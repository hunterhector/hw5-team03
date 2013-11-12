package edu.cmu.lti.deiis.hw5.annotators;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.resource.ResourceInitializationException;
import org.uimafit.util.JCasUtil;

import edu.cmu.lti.qalab.types.Answer;
import edu.cmu.lti.qalab.types.NounPhrase;
import edu.cmu.lti.qalab.types.Question;
import edu.cmu.lti.qalab.types.QuestionAnswerSet;
import edu.cmu.lti.qalab.types.TestDocument;
import edu.cmu.lti.qalab.types.Token;
import edu.cmu.lti.qalab.utils.Utils;

public class QuestionPhraseAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void initialize(UimaContext context) throws ResourceInitializationException {
		super.initialize(context);

	}

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		System.out.println(String.format("Processing with %s", this.getClass().getSimpleName()));

		// ArrayList<Question> questionList =
		// Utils.getQuestionListFromTestDocCAS(aJCas);
		// ArrayList<ArrayList<Answer>> answerList =
		// Utils.getAnswerListFromTestDocCAS(aJCas);

		// for (int i = 0; i < questionList.size(); i++) {
		for (Question question : JCasUtil.select(aJCas, Question.class)) {
			System.out.println(String.format("Processing phrase on question"));
			// Question question = questionList.get(i);
			ArrayList<Token> tokenList = Utils.getTokenListFromQuestion(question);
			ArrayList<NounPhrase> phraseList = extractNounPhrases(tokenList, aJCas);
			FSList fsPhraseList = Utils.createNounPhraseList(aJCas, phraseList);
			question.setNounList(fsPhraseList);
		}

		// for (int i = 0; i < answerList.size(); i++) {
		for (Answer answer : JCasUtil.select(aJCas, Answer.class)) {
			System.out.println("Processing phrase on answer number");
			// ArrayList<Answer> choiceList = answerList.get(i);
			// for (int j = 0; j < choiceList.size(); j++) {
			// Answer ans = choiceList.get(j);
			Collection<Token> tokenList = Utils.getTokenListFromAnswer(answer);
			ArrayList<NounPhrase> phraseList = extractNounPhrases(tokenList, aJCas);
			FSList fsPhraseList = Utils.createNounPhraseList(aJCas, phraseList);
			answer.setNounPhraseList(fsPhraseList);
			// }
		}
	}

	public ArrayList<NounPhrase> extractNounPhrases(Collection<Token> tokenList, JCas jCas) {

		ArrayList<NounPhrase> nounPhraseList = new ArrayList<NounPhrase>();
		String nounPhrase = "";
		for (Token token : tokenList) {
			String word = token.getText();
			String pos = token.getPos();
			// System.out.println("Token: "+word+"/"+pos);
			if (pos.startsWith("NN") || pos.startsWith("JJ") || pos.startsWith("CD")) {
				nounPhrase += word + " ";
			} else {
				nounPhrase = nounPhrase.trim();
				if (!nounPhrase.equals("")) {
					NounPhrase nn = new NounPhrase(jCas);
					nounPhrase = nounPhrase.trim();
					nn.setText(nounPhrase);
					nounPhraseList.add(nn);
					// System.out.println("Noun Phrase: "+nounPhrase);
					nounPhrase = "";
					nn.addToIndexes();
				}
			}

		}
		nounPhrase = nounPhrase.trim();
		if (!nounPhrase.equals("")) {
			NounPhrase nn = new NounPhrase(jCas);
			nn.setText(nounPhrase);
			nounPhraseList.add(nn);
			nn.addToIndexes();
		}

		return nounPhraseList;
	}

}
