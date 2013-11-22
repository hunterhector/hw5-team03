package edu.cmu.lti.deiis.hw5.annotators;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.uimafit.util.JCasUtil;

import edu.cmu.lti.deiis.hw5.runner.CPERunner;
import edu.cmu.lti.qa4mre.type.ComponentAnnotation;
import edu.cmu.lti.qa4mre.type.trainingdata.Author;
import edu.cmu.lti.qa4mre.type.trainingdata.Citation;
import edu.cmu.lti.qa4mre.type.trainingdata.RelevantInfo;
import edu.cmu.lti.qa4mre.type.trainingdata.Year;
import edu.cmu.lti.qalab.types.SourceDocument;

public class TrainingDataAnnotator extends JCasAnnotator_ImplBase {
  
  private enum PatternType {
    YEAR, CITATION, AUTHOR
  };
  
  private static final String yearPatternStr = "\\b(18|19|20)[0-9][0-9]\\b"; // could be smarter
  private static final String citationPatternStr = "\\[[0-9]+\\]";
  private static final String authorPatternStr = "\\b[A-Z][a-z]+( [A-Z]?[a-z]+| [A-Z]\\.)* [A-Z][a-z]+[0-9]\\b";
  
  private static final String[] irrelevantPatternStrings = new String[]{yearPatternStr, citationPatternStr, authorPatternStr};
  
  private Pattern getPattern(String patternStr) {
    return Pattern.compile(patternStr);
  }
  
  private Pattern getIrrelevantPattern() {
    StringBuilder builder = new StringBuilder();
    
    for (int i=0; i<irrelevantPatternStrings.length; i++){
      if (i > 0) {
        builder.append("|");
      }
      builder.append(irrelevantPatternStrings[i]);
    }
    return Pattern.compile(builder.toString());
  }
  
  public void addToIndexesUsingMatcher(Matcher matcher, PatternType patternType, JCas aJCas) {
    boolean debug = false;
    while (matcher.find()) {
      ComponentAnnotation annotation;
      switch (patternType) {
        case AUTHOR:
          annotation = new Author(aJCas);
//          debug = true;
          break;
        case CITATION:
          annotation = new Citation(aJCas);
          break;
        case YEAR:
          annotation = new Year(aJCas);
          break;
        default:
          return;
      }
      
      annotation.setBegin(matcher.start());
      annotation.setEnd(matcher.end());
      annotation.addToIndexes();
      
      if (debug) { System.out.println(annotation.getCoveredText()); }
    }
  }

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
//    System.out.println("processing with " + getClass().getSimpleName());
    Collection<SourceDocument> docs = JCasUtil.select(aJCas, SourceDocument.class);
    for (SourceDocument doc : docs) {
//      System.out.println("file: " + doc.getId());
//      System.out.println(doc.getText().substring(0, 200));
//      System.out.println("(begin, end): (" + doc.getBegin() + ", " + doc.getEnd() + ")");
      
      String docText = doc.getText();
      addToIndexesUsingMatcher(getPattern(yearPatternStr).matcher(docText), PatternType.YEAR, aJCas);
      addToIndexesUsingMatcher(getPattern(citationPatternStr).matcher(docText), PatternType.CITATION, aJCas);
      addToIndexesUsingMatcher(getPattern(authorPatternStr).matcher(docText), PatternType.AUTHOR, aJCas);
      
      Matcher irrelevantMatcher = getIrrelevantPattern().matcher(docText);
      int currentPosition = doc.getBegin();
      while (irrelevantMatcher.find()) {
        RelevantInfo info = new RelevantInfo(aJCas);
        info.setBegin(currentPosition);
        info.setEnd(irrelevantMatcher.start()-1);
        currentPosition = irrelevantMatcher.end()+1;
        info.addToIndexes();
      }
      
      if (currentPosition < doc.getEnd()) {
        RelevantInfo info = new RelevantInfo(aJCas);
        info.setBegin(currentPosition);
        info.setEnd(doc.getEnd());
        info.addToIndexes();
      }
      
    }
  }
  
  public static void main(String[] args) throws Exception {
    System.out.println(TrainingDataAnnotator.class.getSimpleName() + ".main()");
    
    CPERunner runner = new CPERunner("src/main/resources/RelevantInfoDescriptor.xml");

  }
}
