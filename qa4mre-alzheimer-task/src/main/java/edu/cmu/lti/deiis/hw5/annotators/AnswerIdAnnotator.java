/**
 * 
 */
package edu.cmu.lti.deiis.hw5.annotators;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.uimafit.util.JCasUtil;

import edu.cmu.lti.qalab.types.Question;

/**
 * Question id seems to be missing, use this one to put it back
 * 
 * @author Zhengzhong Liu, Hector
 * 
 */
public class AnswerIdAnnotator extends JCasAnnotator_ImplBase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.uima.analysis_component.JCasAnnotator_ImplBase#process(org
	 * .apache.uima.jcas.JCas)
	 */
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		int i = 1;
		for (Question question : JCasUtil.select(aJCas, Question.class)) {
			question.setId(Integer.toString(i));
			i++;
		}
	}

}
