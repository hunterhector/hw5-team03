package edu.cmu.lti.deiis.hw5.annotators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.EmptyFSList;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.NonEmptyFSList;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.qalab.types.Dependency;
import edu.cmu.lti.qalab.types.Sentence;
import edu.cmu.lti.qalab.types.TestDocument;
import edu.cmu.lti.qalab.types.Token;
import edu.cmu.lti.qalab.utils.Utils;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.semgraph.SemanticGraph;
import edu.stanford.nlp.trees.semgraph.SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation;
import edu.stanford.nlp.trees.semgraph.SemanticGraphEdge;
import edu.stanford.nlp.util.CoreMap;

public class StanfordNLPAnnotator extends JCasAnnotator_ImplBase {

	private StanfordCoreNLP stanfordAnnotator;

	@Override
	public void initialize(UimaContext context) throws ResourceInitializationException {
		super.initialize(context);
		Properties props = new Properties();
		props.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse");
		stanfordAnnotator = new StanfordCoreNLP(props);
	}

	@Override
	public void process(JCas jCas) throws AnalysisEngineProcessException {
		System.out.println(String.format("Processing with %s", this.getClass().getSimpleName()));

		TestDocument testDoc = (TestDocument) Utils.getTestDocumentFromCAS(jCas);

		String docText = testDoc.getText();
		String segments[] = docText.split("[\\n]");

		int sentOffset = 0;
		int sentNo = 0;

		ArrayList<Sentence> sentList = new ArrayList<Sentence>();
		for (int i = 0; i < segments.length; i++) {
			String segmentText = segments[i];
			Annotation document = new Annotation(segmentText);
			try {
				// System.out.println("Entering stanford annotation");
				stanfordAnnotator.annotate(document);
				// System.out.println("Out of stanford annotation");
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
			List<CoreMap> sentences = document.get(SentencesAnnotation.class);

			for (CoreMap sentence : sentences) {
				String sentText = sentence.toString();
				Sentence annSentence = new Sentence(jCas);
				ArrayList<Token> tokenList = new ArrayList<Token>();

				// Dependency should have Token rather than String
				for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
					int begin = token.beginPosition();

					int end = token.endPosition();
					String orgText = token.originalText();

					String pos = token.get(PartOfSpeechAnnotation.class);

					String ne = token.get(NamedEntityTagAnnotation.class);
					Token annToken = new Token(jCas);
					annToken.setBegin(begin + sentOffset);
					annToken.setEnd(end + sentOffset);
					annToken.setText(orgText);
					annToken.setPos(pos);
					annToken.addToIndexes();

					tokenList.add(annToken);
				}

				FSList fsTokenList = this.createTokenList(jCas, tokenList);
				fsTokenList.addToIndexes();

				// this is the Stanford dependency graph of the current sentence
				SemanticGraph dependencies = sentence.get(CollapsedCCProcessedDependenciesAnnotation.class);
				List<SemanticGraphEdge> depList = dependencies.edgeListSorted();
				FSList fsDependencyList = this.createDependencyList(jCas, depList);
				fsDependencyList.addToIndexes();

				annSentence.setId(String.valueOf(sentNo));
				annSentence.setBegin(tokenList.get(0).getBegin());
				annSentence.setEnd(tokenList.get(tokenList.size() - 1).getEnd());
				annSentence.setText(sentText);
				annSentence.setTokenList(fsTokenList);
				annSentence.setDependencyList(fsDependencyList);
				annSentence.addToIndexes();
				sentList.add(annSentence);
				sentNo++;
				System.out.println("Sentence no. " + sentNo + " processed");
			}
			sentOffset += segmentText.length() + 1;
		}
		FSList fsSentList = this.createSentenceList(jCas, sentList);
		testDoc.setSentenceList(fsSentList);
	}

	/**
	 * Creates FeatureStructure List from sentenceList
	 * 
	 * @param <T>
	 * 
	 * @param aJCas
	 * @param aCollection
	 * @return FSList
	 */

	public FSList createSentenceList(JCas aJCas, Collection<Sentence> aCollection) {
		if (aCollection.size() == 0) {
			return new EmptyFSList(aJCas);
		}

		NonEmptyFSList head = new NonEmptyFSList(aJCas);
		NonEmptyFSList list = head;
		Iterator<Sentence> i = aCollection.iterator();
		while (i.hasNext()) {
			head.setHead(i.next());
			if (i.hasNext()) {
				head.setTail(new NonEmptyFSList(aJCas));
				head = (NonEmptyFSList) head.getTail();
			} else {
				head.setTail(new EmptyFSList(aJCas));
			}
		}

		return list;
	}

	/**
	 * @param aJCas
	 * @param aCollection
	 * @return
	 */
	public FSList createTokenList(JCas aJCas, Collection<Token> aCollection) {
		if (aCollection.size() == 0) {
			return new EmptyFSList(aJCas);
		}

		NonEmptyFSList head = new NonEmptyFSList(aJCas);
		NonEmptyFSList list = head;
		Iterator<Token> i = aCollection.iterator();
		while (i.hasNext()) {
			head.setHead(i.next());
			if (i.hasNext()) {
				head.setTail(new NonEmptyFSList(aJCas));
				head = (NonEmptyFSList) head.getTail();
			} else {
				head.setTail(new EmptyFSList(aJCas));
			}
		}

		return list;
	}

	public FSList createDependencyList(JCas aJCas, Collection<SemanticGraphEdge> aCollection) {
		if (aCollection.size() == 0) {
			return new EmptyFSList(aJCas);
		}

		NonEmptyFSList head = new NonEmptyFSList(aJCas);
		NonEmptyFSList list = head;
		Iterator<SemanticGraphEdge> i = aCollection.iterator();
		while (i.hasNext()) {
			SemanticGraphEdge edge = i.next();
			Dependency dep = new Dependency(aJCas);

			Token governorToken = new Token(aJCas);
			governorToken.setText(edge.getGovernor().originalText());
			governorToken.setPos(edge.getGovernor().tag());
			governorToken.addToIndexes();
			dep.setGovernor(governorToken);

			Token dependentToken = new Token(aJCas);
			dependentToken.setText(edge.getDependent().originalText());
			dependentToken.setPos(edge.getDependent().tag());
			dependentToken.addToIndexes();
			dep.setDependent(dependentToken);

			dep.setRelation(edge.getRelation().toString());
			dep.addToIndexes();

			head.setHead(dep);
			if (i.hasNext()) {
				head.setTail(new NonEmptyFSList(aJCas));
				head = (NonEmptyFSList) head.getTail();
			} else {
				head.setTail(new EmptyFSList(aJCas));
			}
		}

		return list;
	}

}
