package edu.cmu.lti.deiis.hw5.annotators;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.resource.ResourceInitializationException;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.util.FSCollectionFactory;
import org.uimafit.util.JCasUtil;

import ac.biu.nlp.normalization.BiuNormalizer;

import com.google.common.collect.Iterators;

import edu.cmu.lti.qa4mre.type.NumberAnnotation;
import edu.cmu.lti.qa4mre.type.StanfordDependencyNode;
import edu.cmu.lti.qa4mre.type.StanfordDependencyRelation;
import edu.cmu.lti.qa4mre.type.StanfordEntityMention;
import edu.cmu.lti.util.model.Span;

/**
 * Annotation requirement : 1. Stanford Corenlp (use the number entity
 * annotation) 2. Annotators about agent patient (to associate number with)
 * 
 * @author Zhengzhong Liu, Hector
 * 
 */
public class NumberAnnotator extends JCasAnnotator_ImplBase {
	public static final String NUMBER_NORMALIZER_STRING_RULE = "normalize_rule_file";

	private final String ANNOTATOR_COMPONENT_ID = "System-number-annotation";

	private String normalizeRulePath;

	private BiuNormalizer normalizer;

	private final String numberEntityType = "NUMBER";

	private final String stanfordNumModifierDependency = "num";

	private final String stanfordDetModifilerDependency = "det";

	private Map<String, String> commonNumberMappings = new HashMap<String, String>();

	// control duplication, need to be refresh for each Cas
	private Map<Span, NumberAnnotation> numberMap;

	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);

		normalizeRulePath = (String) aContext.getConfigParameterValue(NUMBER_NORMALIZER_STRING_RULE);

		// initialize normalizer
		File normalizeRuleFile = new File(normalizeRulePath);
		try {
			normalizer = new BiuNormalizer(normalizeRuleFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		commonNumberMappings.put("one", "1");
		commonNumberMappings.put("two", "2");
		commonNumberMappings.put("three", "3");
		commonNumberMappings.put("four", "4");
		// commonNumberMappings.put("two", "2");
		// commonNumberMappings.put("two", "2");
		commonNumberMappings.put("dozen", "12");
	}

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {

		numberMap = new HashMap<Span, NumberAnnotation>();

		Collection<StanfordEntityMention> allEntityMentions = JCasUtil.select(aJCas, StanfordEntityMention.class);

		// 1 Create number annotations based on stanford dependencies
		for (StanfordEntityMention em : allEntityMentions) {
			String entityType = em.getEntityType();
			if (entityType != null && entityType.equals(numberEntityType)) {
				String normalized = getNormalizedNumberString(em.getCoveredText());
				createNumberAnnotation(aJCas, em.getBegin(), em.getEnd(), normalized);
			}
		}

		// Map<StanfordDependencyNode, Collection<NumberAnnotation>>
		// node2NumberMap = JCasUtil.indexCovering(aJCas,
		// StanfordDependencyNode.class,
		// NumberAnnotation.class);
	}

	private NumberAnnotation getNaiveQuantityFromModifier(JCas aJCas, Map<StanfordDependencyNode, Collection<NumberAnnotation>> node2NumberMap,
			StanfordDependencyNode headNode) {
		FSList childRelationsFS = headNode.getChildRelations();
		NumberAnnotation number = null;

		if (childRelationsFS != null) {
			Collection<StanfordDependencyRelation> childDependencies = FSCollectionFactory.create(childRelationsFS, StanfordDependencyRelation.class);
			for (StanfordDependencyRelation childDependency : childDependencies) {
				String relationType = childDependency.getRelationType();
				if (relationType.equals(stanfordNumModifierDependency)) {
					StanfordDependencyNode childNode = childDependency.getChild();
					if (node2NumberMap.containsKey(childNode)) {
						number = Iterators.get(node2NumberMap.get(childNode).iterator(), 0);
						break;
					}
				}

				if (relationType.equals(stanfordDetModifilerDependency)) {
					StanfordDependencyNode childNode = childDependency.getChild();
					String determiner = childNode.getCoveredText().toLowerCase();
					if (determiner.equals("a") || determiner.equals("an")) {
						number = createNumberAnnotation(aJCas, childNode.getBegin(), childNode.getEnd(), "1");
						break;
					}
				}
			}
		}
		return number;
	}

	private String normalizationPreprocessing(String beforePreprocessStr) {
		return beforePreprocessStr.toLowerCase().replace("-", " ");
	}

	private String getNormalizedNumberString(String originalStr) {
		// this is very hacky
		String numberStr = normalizationPreprocessing(originalStr);

		String normalized = null;
		try {
			normalized = normalizer.normalize(numberStr);
			if (commonNumberMappings.containsKey(normalized)) {
				normalized = commonNumberMappings.get(normalized);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return normalized;
	}

	private NumberAnnotation createNumberAnnotation(JCas aJCas, int begin, int end, String normalized) {
		Span span = new Span(begin, end);
		if (numberMap.containsKey(span)) {
			return numberMap.get(span);
		} else {
			NumberAnnotation numAnn = new NumberAnnotation(aJCas);
			numAnn.setBegin(begin);
			numAnn.setEnd(end);
			numAnn.addToIndexes(aJCas);
			numAnn.setComponentId(ANNOTATOR_COMPONENT_ID);
			numAnn.setNormalizedString(normalized);

			numberMap.put(span, numAnn);

			return numAnn;
		}
	}

}
