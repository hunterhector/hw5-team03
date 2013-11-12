package edu.cmu.lti.deiis.hw5.annotators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.resource.ResourceInitializationException;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;
import org.uimafit.util.FSCollectionFactory;
import org.uimafit.util.JCasUtil;

import com.google.common.collect.ArrayListMultimap;

import edu.cmu.lti.qa4mre.type.StanfordCorenlpSentence;
import edu.cmu.lti.qa4mre.type.StanfordCorenlpToken;
import edu.cmu.lti.qa4mre.type.StanfordDependencyNode;
import edu.cmu.lti.qa4mre.type.StanfordDependencyRelation;
import edu.cmu.lti.qa4mre.type.StanfordDependencyRootNode;
import edu.cmu.lti.qa4mre.type.StanfordEntityCoreferenceCluster;
import edu.cmu.lti.qa4mre.type.StanfordEntityMention;
import edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation;
import edu.cmu.lti.qa4mre.type.StanfordCoreNlpTimex;
import edu.cmu.lti.qalab.types.Answer;
import edu.cmu.lti.qalab.types.Question;
import edu.cmu.lti.qalab.types.TestDocument;
import edu.cmu.lti.util.model.Span;
//import edu.cmu.lti.util.uima.FSCollectionFactory;
import edu.cmu.lti.util.uima.UimaConvenience;
import edu.stanford.nlp.dcoref.CorefChain;
import edu.stanford.nlp.dcoref.CorefChain.CorefMention;
import edu.stanford.nlp.dcoref.CorefCoreAnnotations.CorefChainAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.BeginIndexAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.CharacterOffsetBeginAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.CharacterOffsetEndAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.EndIndexAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.semgraph.SemanticGraph;
import edu.stanford.nlp.trees.semgraph.SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation;
import edu.stanford.nlp.trees.semgraph.SemanticGraphEdge;
import edu.stanford.nlp.time.Timex;
import edu.stanford.nlp.time.TimeAnnotations.TimexAnnotation;
import edu.stanford.nlp.time.TimeAnnotations.TimexAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.util.CoreMap;

/**
 * This class uses the Stanford Corenlp Pipeline to annotate POS, NER, Parsing and entity coreference
 * 
 * The current issue is that it does not split on DATETIME and TITLE correctly.
 * 
 * @author Zhengzhong Liu, Hector
 * @author Jun Araki
 * @author Da Teng
 */
public class StanfordCoreNlpAnnotator extends JCasAnnotator_ImplBase {
  public final static String PARAM_USE_SUTIME = "UseSUTime";

  private Boolean useSUTime;

  private final static String ANNOTATOR_COMPONENT_ID = "System-stanford-corenlp";

  private StanfordCoreNLP pipeline;

  private final static String PARSE_TREE_ROOT_NODE_LABEL = "ROOT";

  @Override
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    super.initialize(aContext);

    useSUTime = (Boolean) aContext.getConfigParameterValue(PARAM_USE_SUTIME);
    
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
    props.setProperty("dcoref.postprocessing", "true");
    if (useSUTime) {
      props.setProperty("ner.useSUTime", "true");
    } else {
      props.setProperty("ner.useSUTime", "false");
    }

    // Here I assume that we have sentence split already, and use EOL each.
    // props.setProperty("ssplit.eolonly", "true");
    // props.setProperty("tokenize.whitespace", "true");

    pipeline = new StanfordCoreNLP(props);
  }

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
	  for (TestDocument doc : JCasUtil.select(aJCas, TestDocument.class)) {
			annotateText(doc.getCoveredText(), aJCas, doc.getBegin());
		}

		for (Question question : JCasUtil.select(aJCas, Question.class)) {
			annotateText(question.getCoveredText(), aJCas, question.getBegin());
		}

		for (Answer answer : JCasUtil.select(aJCas, Answer.class)) {
			annotateText(answer.getCoveredText(), aJCas, answer.getBegin());
		}
  }

  private StanfordTreeAnnotation addPennTreeAnnotation(Tree currentNode, JCas aJCas,
          StanfordTreeAnnotation parent, int textOffset) {
    StanfordTreeAnnotation treeAnno = new StanfordTreeAnnotation(aJCas);

    if (!currentNode.isLeaf()) {
      int thisBegin = 0;
      int thisEnd = 0;
      int count = 0;
      int numChild = currentNode.children().length;
      String currentNodeLabel = currentNode.value();

      List<StanfordTreeAnnotation> childrenList = new ArrayList<StanfordTreeAnnotation>();
      for (Tree child : currentNode.children()) {
        StanfordTreeAnnotation childTree = addPennTreeAnnotation(child, aJCas, treeAnno, textOffset);
        childrenList.add(childTree);
        if (count == 0) {
          thisBegin = childTree.getBegin();
        }
        if (count == numChild - 1) {
          thisEnd = childTree.getEnd();
        }
        count++;
      }

      if (PARSE_TREE_ROOT_NODE_LABEL.equals(currentNodeLabel)) {
        treeAnno.setIsRoot(true);
      } else {
        treeAnno.setIsRoot(false);
      }

      treeAnno.setBegin(thisBegin+textOffset);
      treeAnno.setEnd(thisEnd+textOffset);
      treeAnno.setPennTreeLabel(currentNodeLabel);
      treeAnno.setParent(parent);
      treeAnno.setChildren(FSCollectionFactory.createFSList(aJCas, childrenList));
      treeAnno.setIsLeaf(false);
      treeAnno.setComponentId(ANNOTATOR_COMPONENT_ID);
      treeAnno.addToIndexes(aJCas);
      return treeAnno;
    } else {
      List<Word> words = currentNode.yieldWords();
      StanfordTreeAnnotation leafTree = new StanfordTreeAnnotation(aJCas);
      leafTree.setBegin(words.get(0).beginPosition()+textOffset);
      leafTree.setEnd(words.get(words.size() - 1).endPosition()+textOffset);
      leafTree.setPennTreeLabel(currentNode.value());
      leafTree.setIsLeaf(true);
      leafTree.setComponentId(ANNOTATOR_COMPONENT_ID);
      leafTree.addToIndexes(aJCas);

      return leafTree;
    }
  }

  private void annotateText(String text, JCas aJCas, int textOffset) {
	  UimaConvenience.printProcessLog(aJCas);

	    String documentText = text;
	    Annotation document = new Annotation(documentText);
	    pipeline.annotate(document);

	    List<CoreMap> sentAnnos = document.get(SentencesAnnotation.class);

	    // The following put token annotation to CAS
	    int tokenId = 1;
	    String preNe = "";
	    int neBegin = 0;
	    int neEnd = 0;
	    for (CoreLabel token : document.get(TokensAnnotation.class)) {
	      int beginIndex = token.get(CharacterOffsetBeginAnnotation.class);
	      int endIndex = token.get(CharacterOffsetEndAnnotation.class);
	      
	      //add token annotation
	      StanfordCorenlpToken sToken = new StanfordCorenlpToken(aJCas, beginIndex+textOffset, endIndex+textOffset);
	      sToken.setTokenId(tokenId);
	      sToken.setPos(token.get(PartOfSpeechAnnotation.class));
	      sToken.setLemma(token.get(LemmaAnnotation.class));
	      sToken.addToIndexes(aJCas);
	      tokenId++;

	      // Add NER annotation
	      String ne = token.get(NamedEntityTagAnnotation.class);
	      if (ne != null) {
	        // System.out.println("[" + token.originalText() + "] :" + ne);
	        if (ne.equals(preNe) && !preNe.equals("")) {

	        } else if (preNe.equals("")) {
	          // if the previous is start of sentence(no label).
	          neBegin = beginIndex;
	          preNe = ne;
	        } else {
	          if (!preNe.equals("O")) {// "O" represent no label (other)
	            StanfordEntityMention sne = new StanfordEntityMention(aJCas);
	            sne.setBegin(neBegin+textOffset);
	            sne.setEnd(neEnd+textOffset);
	            sne.setEntityType(preNe);
	            // sne.setEntitySpan(documentText.substring(neBegin,neEnd));
	            sne.addToIndexes(aJCas);
	          }
	          // set the next span of NE
	          neBegin = beginIndex;
	          preNe = ne;
	        }
	        neEnd = endIndex;
	      }
	    }

	    int sentenceId = 1;
	    for (CoreMap sentAnno : sentAnnos) {
	      // The following add Stanford sentence to CAS
	      int begin = sentAnno.get(CharacterOffsetBeginAnnotation.class);
	      int end = sentAnno.get(CharacterOffsetEndAnnotation.class);
	      StanfordCorenlpSentence sSent = new StanfordCorenlpSentence(aJCas, begin+textOffset, end+textOffset);
	      sSent.setSentenceId(sentenceId);
	      sSent.addToIndexes(aJCas);
	      sentenceId++;

	      // The following deals with tree annotation
	      Tree tree = sentAnno.get(TreeAnnotation.class);
	      addPennTreeAnnotation(tree, aJCas, null, textOffset);

	      // the following add the collapsed cc processed dependencies of each sentence into CAS
	      // annotation
	      SemanticGraph depends = sentAnno.get(CollapsedCCProcessedDependenciesAnnotation.class);
	      // SemanticGraph basicDepends = sentAnno.get(BasicDependenciesAnnotation.class);

	      List<StanfordCorenlpToken> tokens = JCasUtil.selectCovered(aJCas, StanfordCorenlpToken.class,
	              sSent);
	      Map<IndexedWord, StanfordDependencyNode> stanford2UimaMap = new HashMap<IndexedWord, StanfordDependencyNode>();
	      for (IndexedWord stanfordNode : depends.vertexSet()) {
	        int indexBegin = stanfordNode.get(BeginIndexAnnotation.class);
	        int indexEnd = stanfordNode.get(EndIndexAnnotation.class);
	        StanfordCorenlpToken sToken = tokens.get(indexBegin);
	        int tokenBegin = sToken.getBegin();
	        int tokenEnd = tokens.get(indexEnd - 1).getEnd();

	        if (indexBegin + 1 != indexEnd) {
	          System.err.print("Dependency node is not exactly one token here!");
	        }
	        StanfordDependencyNode node;

	        // here we make new annotation called DependencyNode, it is also possible to reuse
	        // StanfordToken.
	        if (depends.getRoots().contains(stanfordNode)) {
	          node = new StanfordDependencyRootNode(aJCas, tokenBegin, tokenEnd);
	        } else {
	          node = new StanfordDependencyNode(aJCas, tokenBegin, tokenEnd);
	        }

	        node.setToken(sToken);

	        stanford2UimaMap.put(stanfordNode, node);
	      }

	      // now create edges of these nodes
	      // Map<StanfordDependencyNode, List<StanfordDependencyRelation>> headRelationMap = new
	      // HashMap<StanfordDependencyNode, List<StanfordDependencyRelation>>();
	      // Map<StanfordDependencyNode, List<StanfordDependencyRelation>> childRelationMap = new
	      // HashMap<StanfordDependencyNode, List<StanfordDependencyRelation>>();

	      ArrayListMultimap<StanfordDependencyNode, StanfordDependencyRelation> headRelationMap = ArrayListMultimap
	              .create();
	      ArrayListMultimap<StanfordDependencyNode, StanfordDependencyRelation> childRelationMap = ArrayListMultimap
	              .create();

	      for (SemanticGraphEdge stanfordEdge : depends.edgeIterable()) {
	        String edgeType = stanfordEdge.getRelation().toString();
	        double edgeWeight = stanfordEdge.getWeight(); // weight is usually infinity
	        StanfordDependencyNode head = stanford2UimaMap.get(stanfordEdge.getGovernor());
	        StanfordDependencyNode child = stanford2UimaMap.get(stanfordEdge.getDependent());

	        StanfordDependencyRelation sr = new StanfordDependencyRelation(aJCas);
	        sr.setHead(head);
	        sr.setChild(child);
	        sr.setWeight(edgeWeight);
	        sr.setRelationType(edgeType);
	        sr.addToIndexes(aJCas);

	        headRelationMap.put(child, sr);
	        childRelationMap.put(head, sr);
	      }

	      // associate the edges to the nodes
	      for (StanfordDependencyNode sNode : stanford2UimaMap.values()) {
	        if (headRelationMap.containsKey(sNode)) {
	          sNode.setHeadRelations(FSCollectionFactory.createFSList(aJCas, headRelationMap.get(sNode)));
	        }
	        if (childRelationMap.containsKey(sNode)) {
	          sNode.setChildRelations(FSCollectionFactory.createFSList(aJCas,
	                  childRelationMap.get(sNode)));
	        }
	        sNode.addToIndexes(aJCas);
	      }
	    }

	    // the following set the coreference chain to CAS annotation
	    Map<Integer, CorefChain> graph = document.get(CorefChainAnnotation.class);

	    List<List<StanfordCorenlpToken>> sentTokens = new ArrayList<List<StanfordCorenlpToken>>();

	    for (StanfordCorenlpSentence sSent : JCasUtil.select(aJCas, StanfordCorenlpSentence.class)) {
	      sentTokens.add(JCasUtil.selectCovered(aJCas, StanfordCorenlpToken.class, sSent));
	    }

	    Map<Span, StanfordEntityMention> spanMentionMap = new HashMap<Span, StanfordEntityMention>();
	    for (StanfordEntityMention sem : JCasUtil.select(aJCas, StanfordEntityMention.class)) {
	      spanMentionMap.put(new Span(sem.getBegin(), sem.getEnd()), sem);
	    }

	    for (Entry<Integer, CorefChain> entry : graph.entrySet()) {
	      CorefChain refChain = entry.getValue();
	      StanfordEntityCoreferenceCluster cc = new StanfordEntityCoreferenceCluster(aJCas);
	      List<StanfordEntityMention> stanfordEntityMentions = new ArrayList<StanfordEntityMention>();

	      for (CorefMention mention : refChain.getMentionsInTextualOrder()) {
	        List<StanfordCorenlpToken> sTokens = sentTokens.get(mention.sentNum - 1);
	        int begin = sTokens.get(mention.startIndex - 1).getBegin();
	        int end = sTokens.get(mention.endIndex - 2).getEnd();

	        StanfordEntityMention em;
	        if (spanMentionMap.containsKey(new Span(begin, end))) {
	          em = spanMentionMap.get(new Span(begin, end));
	        } else {
	          em = new StanfordEntityMention(aJCas, begin, end);
	          em.addToIndexes(aJCas);
	        }
	        em.setEntityCoreferenceCluster(cc);
	        stanfordEntityMentions.add(em);
	      }

	      // convert the list to CAS entity mention FSList type
	      FSList mentionFSList = FSCollectionFactory.createFSList(aJCas, stanfordEntityMentions);

	      // Put that in the cluster type
	      cc.setEntityMentions(mentionFSList);
	      cc.addToIndexes(aJCas);
	    }

	    if (!useSUTime) {
	      // Stop here if you don't use SUTime.
	      return;
	    }

	    // The following add Time annotation
	    // TimeAnnotator should come after the tokenizer, sentence splitter, and pos tagger
	    Properties propsTime = new Properties();

	    // TODO: Create a customized rule to capture "last May 16" correctly in
	    // LTW_ENG_20040319.0128.src.xml.txt
	    StringBuilder ruleFiles = new StringBuilder();
	    // A light hack: includes '../edu.cmu.lti.event_coref.ann.StanfordCoreNlpAnnotator'
	    // to allow other projects to successfully run this code.
	    String relativePath = "../edu.cmu.lti.event_coref.ann.StanfordCoreNlpAnnotator/conf/sutime";
	    ruleFiles.append(relativePath + "/defs.sutime.txt");
	    ruleFiles.append(",");
	    ruleFiles.append(relativePath + "/english.sutime.txt");
	    ruleFiles.append(",");
	    ruleFiles.append(relativePath + "/english.holidays.sutime.txt");

	    propsTime.put("sutime.rules", ruleFiles.toString());
	    propsTime.put("sutime.markTimeRanges", true);
	    propsTime.put("sutime.includeNested", true);
	    propsTime.put("sutime.teRelHeurLevel", "MORE");


	    List<CoreMap> timexes = document.get(TimexAnnotations.class);
	    for (CoreMap timex : timexes) {
	      int begin = timex.get(CharacterOffsetBeginAnnotation.class);
	      int end = timex.get(CharacterOffsetEndAnnotation.class);
	      Timex timexObj = timex.get(TimexAnnotation.class);

	      StanfordCoreNlpTimex annTimex = new StanfordCoreNlpTimex(aJCas);
	      annTimex.setBegin(begin+textOffset);
	      annTimex.setEnd(end+textOffset);
	      annTimex.setTid(timexObj.tid());
	      annTimex.setTimexType(timexObj.timexType());
	      annTimex.setValue(timexObj.value());
	      annTimex.setComponentId(ANNOTATOR_COMPONENT_ID);
	      annTimex.addToIndexes();
	    }
	    
  }

}