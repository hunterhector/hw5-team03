package edu.cmu.lti.deiis.hw5.annotators;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;
import org.uimafit.util.JCasUtil;

import edu.cmu.lti.qa4mre.type.OpennlpChunk;
import edu.cmu.lti.qa4mre.type.StanfordCorenlpSentence;
import edu.cmu.lti.qa4mre.type.StanfordCorenlpToken;
import edu.cmu.lti.util.uima.UimaConvenience;

/**
 * Annotates chunks provided by OpenNLP.
 * 
 * Required annotation: sentence
 */
public class OpenNlpChunker extends JCasAnnotator_ImplBase {
  ChunkerME chunker;

  public static final String PARAM_MODEL_PATH = "modelFilePath";

  @ConfigurationParameter(name = PARAM_MODEL_PATH)
  private String modelFilePath;

  @Override
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    super.initialize(aContext);

    modelFilePath = (String) aContext.getConfigParameterValue(PARAM_MODEL_PATH);
    InputStream modelIn = null;
    ChunkerModel model = null;

    try {
      modelIn = new FileInputStream(modelFilePath);
      model = new ChunkerModel(modelIn);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (modelIn != null) {
        try {
          modelIn.close();
        } catch (IOException e) {
        }
      }
    }

    chunker = new ChunkerME(model);
  }

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    
	UimaConvenience.printProcessLog(aJCas);

    // List<Sentence> sentences = UimaConvenience.getAnnotationList(aJCas, Sentence.class);
    List<StanfordCorenlpSentence> sentences = UimaConvenience.getAnnotationList(aJCas, StanfordCorenlpSentence.class);
    // for (Sentence sent : sentences) {
    for (StanfordCorenlpSentence sent : sentences) {
      List<StanfordCorenlpToken> tokenList = JCasUtil.selectCovered(StanfordCorenlpToken.class, sent);

      String tokens[] = new String[tokenList.size()];
      String pos[] = new String[tokenList.size()];

      for (int i = 0; i < tokenList.size(); i++) {
        tokens[i] = tokenList.get(i).getCoveredText();
        pos[i] = tokenList.get(i).getPos();
      }

      String tags[] = chunker.chunk(tokens, pos);

      tag2Uima(aJCas, tokenList, tags);
    }
  }

  
  
  private void tag2Uima(JCas aJCas, List<StanfordCorenlpToken> tokenList, String[] tags) {
    int begin = -1;
    int end = -1;

    String previousType = "";

    for (int i = 0; i < tokenList.size(); i++) {
      String tag = tags[i];
      StanfordCorenlpToken word = tokenList.get(i);

      String loc = "";
      String type = "";
      String[] tagParts = tag.split("-");

      if (tagParts.length == 2) {
        loc = tagParts[0];
        type = tagParts[1];
      } else {// otherwise is "O"
        loc = tag;
        type = tag;
      }
      if (loc.equals("O")) {
        if (begin != -1) {
          createChunk(aJCas, begin, end, previousType);
        }
        begin = word.getBegin();
        end = word.getEnd();
      }
      if (loc.equals("B")) {
        if (begin != -1) {
          createChunk(aJCas, begin, end, previousType);
        }
        begin = word.getBegin();
        end = word.getEnd();
      }

      if (loc.equals("I")) {
        end = word.getEnd();
      }

      if (i == tokenList.size() - 1) {
        createChunk(aJCas, begin, end, type);
      }

      previousType = type;
    }

  }

  private void createChunk(JCas aJCas, int begin, int end, String tag) {
    OpennlpChunk chunk = new OpennlpChunk(aJCas);
    chunk.setBegin(begin);
    chunk.setEnd(end);
    chunk.setTag(tag);
    chunk.addToIndexes(aJCas);
  }

}
