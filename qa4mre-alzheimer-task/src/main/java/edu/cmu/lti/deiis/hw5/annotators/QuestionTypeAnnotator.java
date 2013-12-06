package edu.cmu.lti.deiis.hw5.annotators;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.uimafit.util.JCasUtil;

import edu.cmu.lti.deiis.hw5.runner.CPERunner;
import edu.cmu.lti.qalab.types.Question;

public class QuestionTypeAnnotator extends JCasAnnotator_ImplBase {

  private int numQuestions = 0;

  private int numCorrect = 0;

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    Collection<Question> questions = JCasUtil.select(aJCas, Question.class);
    for (Question question : questions) {
      String text = question.getText().toLowerCase();
      String[] tokens = text.split(" ");
      List<String> tokenList = Arrays.asList(tokens);
      // System.out.println(question.getQtype());

      if (tokens[0].equals("is") || tokens[0].equals("can") || tokens[0].equals("does")
              || tokens[0].equals("did") || tokens[0].equals("are") || tokens[0].equals("were")
              || tokens[0].equals("has")) {
        question.setAutoQType("binary");

      } else if (text.contains("how many") || text.contains("how old") || text.contains("number")) {
        question.setAutoQType("quantity");

      } else if (tokens[0].equals("when") || tokenList.contains("date")
              || tokenList.contains("age") || text.contains("how long")) {
        question.setAutoQType("time");

      } else if (text.contains("similar") || text.contains("differ") || text.contains("compar")
              || text.contains("correlat")) {
        question.setAutoQType("relation");

      } else if (tokens[0].equals("why") || text.contains("reason") || text.contains("cause")
              || text.contains("purpose") || text.contains("consequence")) {
        question.setAutoQType("cause");

      } else { // default to 'factoid'
        question.setAutoQType("factoid");
      }
    }

    // now check how many are correct
    for (Question question : questions) {
      if (question.getAutoQType() != null) {
        numCorrect += question.getAutoQType().equals(question.getQtype()) ? 1 : 0;

        String qtype = question.getQtype();
        String auto = question.getAutoQType();
        if (!qtype.equals(auto)) {
          System.out.println("(" + qtype + " -> " + auto + "), text: " + question.getText());
        }
        /*
         * if (qtype.equals("factoid") && !qtype.equals(auto)) { System.out.println("(" + qtype +
         * " -> " + auto + "), text: " + question.getText()); } else if (auto.equals("factoid") &&
         * !auto.equals(qtype)) { System.out.println("(" + qtype + " -> " + auto + "), text: " +
         * question.getText()); }
         */
      }
      numQuestions++;
    }
  }

  @Override
  public void collectionProcessComplete() throws AnalysisEngineProcessException {
    super.collectionProcessComplete();
    System.out.println("collectionProcessComplete");
    float accuracy = 1.f * numCorrect / numQuestions;
    System.out.println("Accuracy: " + accuracy);
  }

  public static void main(String[] args) throws Exception {
    System.out.println(QuestionTypeAnnotator.class.getSimpleName() + ".main()");

    CPERunner runner = new CPERunner("src/main/resources/QuestionTypeDescriptor.xml");

  }
}
