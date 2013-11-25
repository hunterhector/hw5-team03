package edu.cmu.lti.deiis.hw5.question_type;

import java.util.ArrayList;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.qalab.types.Answer;
import edu.cmu.lti.qalab.types.Question;
import edu.cmu.lti.qalab.types.QuestionAnswerSet;
import edu.cmu.lti.qalab.utils.Utils;

public class QuestionTypeFilter extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		ArrayList<QuestionAnswerSet> qaSet = Utils.getQuestionAnswerSetFromTestDocCAS(aJCas);
		
		for (int i = 0; i < qaSet.size(); i++) {
			Question question = qaSet.get(i).getQuestion();
			ArrayList<Answer> choiceList = Utils.fromFSListToCollection(qaSet.get(i).getAnswerList(), Answer.class);
			
			System.out.println("Question: " + question.getText());
			System.out.println("Question type: " + question.getQtype());
			
			
		}

	}

}
