package edu.cmu.lti.deiis.hw5.annotators;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.uimafit.descriptor.ConfigurationParameter;
import org.uimafit.util.FSCollectionFactory;
import org.uimafit.util.JCasUtil;

import com.google.common.collect.ArrayListMultimap;

import tratz.parse.FullSystemWrapper;
import tratz.parse.FullSystemWrapper.FullSystemResult;
import tratz.parse.types.Arc;
import tratz.parse.types.Parse;
import tratz.parse.types.Sentence;
import tratz.parse.types.Token;
import edu.cmu.lti.qa4mre.type.FanseDependencyRelation;
import edu.cmu.lti.qa4mre.type.FanseSemanticRelation;
import edu.cmu.lti.qa4mre.type.FanseToken;
import edu.cmu.lti.qa4mre.type.StanfordCorenlpSentence;
import edu.cmu.lti.util.uima.UimaConvenience;

public class FanseAnnotator extends JCasAnnotator_ImplBase {

	public static final String PARAM_MODEL_BASE_DIR = "./model/";

	@ConfigurationParameter(name = PARAM_MODEL_BASE_DIR)
	private String modeBaseDir = "./model/";
	
	private static final String POS_MODEL = "posTaggingModel.gz", PARSE_MODEL = "parseModel.gz",
	          POSSESSIVES_MODEL = "possessivesModel.gz", NOUN_COMPOUND_MODEL = "nnModel.gz",
	          SRL_ARGS_MODELS = "srlArgsWrapper.gz", SRL_PREDICATE_MODELS = "srlPredWrapper.gz",
	          PREPOSITION_MODELS = "psdModels.gz", WORDNET = "wordnet3";
	
	public final static Boolean DEFAULT_VCH_CONVERT = Boolean.FALSE;
	
	public final static String DEFAULT_SENTENCE_READER_CLASS = tratz.parse.io.ConllxSentenceReader.class
	          .getName();
	
	FullSystemWrapper fullSystemWrapper = null;
	
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		try {
			  System.out.println("test!");
			  System.out.println(modeBaseDir+PREPOSITION_MODELS);
		      fullSystemWrapper = new FullSystemWrapper(modeBaseDir + PREPOSITION_MODELS, modeBaseDir
		              + NOUN_COMPOUND_MODEL, modeBaseDir + POSSESSIVES_MODEL,
		              modeBaseDir + SRL_ARGS_MODELS, modeBaseDir + SRL_PREDICATE_MODELS, modeBaseDir
		                      + POS_MODEL, modeBaseDir + PARSE_MODEL, modeBaseDir + WORDNET);
		    } catch (Exception e) {
		      e.printStackTrace();
		      throw new ResourceInitializationException();
		    }
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		UimaConvenience.printProcessLog(aJCas);
		
		List<StanfordCorenlpSentence> sentList = UimaConvenience.getAnnotationList(aJCas, StanfordCorenlpSentence.class);
		
		for (StanfordCorenlpSentence sent: sentList) {
			System.out.println(sent.getCoveredText());
			
			List<edu.cmu.lti.qalab.types.Token> tokenList = 
					JCasUtil.selectCovered(edu.cmu.lti.qalab.types.Token.class,sent);
			
			for (int i = 0; i < tokenList.size(); i++) {
				System.out.println(tokenList.get(i));
			}
			
			Parse par = tokenListToParse(tokenList);
			Sentence fSent = par.getSentence();
			List<Token> tokens = fSent.getTokens();
			
			FullSystemResult result = fullSystemWrapper.process(fSent, tokens.size() > 0
		              && tokens.get(0).getPos() == null, true, true, true, true, true);
			
			Parse dependencyParse = result.getParse();
			Parse semanticParse = result.getSrlParse();
			
			tratz.parse.types.Sentence resultSent = dependencyParse.getSentence();
			List<tratz.parse.types.Token> resultTokens = resultSent.getTokens();
			
			Map<Token, FanseToken> Fanse2UimaMap = new HashMap<Token, FanseToken>();
			
			int tokenId = 1;
			for (Token token : resultTokens) {
				edu.cmu.lti.qalab.types.Token goldToken = tokenList.get(token.getIndex()-1);
				int begin = goldToken.getBegin();
				int end = goldToken.getEnd();
				
				FanseToken fToken = new FanseToken(aJCas,begin,end);
				fToken.setTokenId(tokenId);
				fToken.setCoarsePos(token.getCoarsePos());
				fToken.setPos(token.getPos());
				fToken.setLexicalSense(token.getLexSense());
				fToken.addToIndexes();
				tokenId++;
				
				Fanse2UimaMap.put(token, fToken);
			}
			
			ArrayListMultimap<FanseToken, FanseDependencyRelation> dependencyHeadRelationMap = 
					ArrayListMultimap.create();
			ArrayListMultimap<FanseToken, FanseDependencyRelation> dependencyChildRelationMap = 
					ArrayListMultimap.create();
			
			for (Arc arc: dependencyParse.getArcs()) {
				FanseToken childToken = Fanse2UimaMap.get(arc.getChild());
				FanseToken headToken = Fanse2UimaMap.get(arc.getHead());
				
				if (childToken != null || headToken != null) {
					FanseDependencyRelation fArc = new FanseDependencyRelation(aJCas);
					fArc.setHead(headToken);
					fArc.setChild(childToken);
					fArc.setDependency(arc.getDependency());
					
					dependencyHeadRelationMap.put(childToken, fArc);
					dependencyChildRelationMap.put(headToken, fArc);
					
					fArc.addToIndexes(aJCas);
				}
			}
			
			ArrayListMultimap<FanseToken, FanseSemanticRelation> semanticHeadRelationMap = 
					ArrayListMultimap.create();
		    ArrayListMultimap<FanseToken, FanseSemanticRelation> semanticChildRelationMap = 
		    		  ArrayListMultimap.create();

		      for (Arc arc : semanticParse.getArcs()) {
		        if (arc == null || arc.getSemanticAnnotation() == null) {
		          continue;
		        }

		        FanseToken childToken = Fanse2UimaMap.get(arc.getChild());
		        FanseToken headToken = Fanse2UimaMap.get(arc.getHead());

		        if (childToken != null || headToken != null) {
		          FanseSemanticRelation fArc = new FanseSemanticRelation(aJCas);
		          fArc.setHead(headToken);
		          fArc.setChild(childToken);
		          fArc.setSemanticAnnotation(arc.getSemanticAnnotation());

		          semanticHeadRelationMap.put(childToken, fArc);
		          semanticChildRelationMap.put(headToken, fArc);

		          fArc.addToIndexes(aJCas);
		        }
		      }
		      
		      for (FanseToken fToken : Fanse2UimaMap.values()) {
		          if (dependencyHeadRelationMap.containsKey(fToken)) {
		            fToken.setHeadDependencyRelations(FSCollectionFactory.createFSList(aJCas,
		                    dependencyHeadRelationMap.get(fToken)));
		          }
		          if (dependencyChildRelationMap.containsKey(fToken)) {
		            fToken.setChildDependencyRelations(FSCollectionFactory.createFSList(aJCas,
		                    dependencyChildRelationMap.get(fToken)));
		          }
		          if (semanticHeadRelationMap.containsKey(fToken)) {
		            fToken.setHeadSemanticRelations(FSCollectionFactory.createFSList(aJCas,
		                    semanticHeadRelationMap.get(fToken)));
		          }
		          if (semanticChildRelationMap.containsKey(fToken)) {
		            fToken.setChildSemanticRelations(FSCollectionFactory.createFSList(aJCas,
		                    semanticChildRelationMap.get(fToken)));
		          }

		          fToken.addToIndexes(aJCas);
		        }
		      
		}
	}
	
	private Parse tokenListToParse(List<edu.cmu.lti.qalab.types.Token> tokenList) {
		Token root = new Token("[ROOT]",0);
		List<Token> tokens = new ArrayList<Token>();
		List<Arc> arcs = new ArrayList<Arc>();
		
		int tokenNum = 0;
		for(edu.cmu.lti.qalab.types.Token token: tokenList) {
			tokenNum++;
			String tokenString = token.getCoveredText();
			Token fToken = new Token(tokenString,tokenNum);
			tokens.add(fToken);
		}
		
		Parse result = new Parse(new Sentence(tokens), root, arcs);
		return result;
	}

}

