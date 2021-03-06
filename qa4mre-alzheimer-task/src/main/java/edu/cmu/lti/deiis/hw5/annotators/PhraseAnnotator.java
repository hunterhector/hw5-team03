package edu.cmu.lti.deiis.hw5.annotators;

import java.util.ArrayList;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.resource.ResourceInitializationException;
import org.uimafit.util.JCasUtil;

import edu.cmu.lti.qalab.types.NounPhrase;
import edu.cmu.lti.qalab.types.Sentence;
import edu.cmu.lti.qalab.types.TestDocument;
import edu.cmu.lti.qalab.types.Token;
import edu.cmu.lti.qalab.utils.Utils;

public class PhraseAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void initialize(UimaContext context) throws ResourceInitializationException {
		super.initialize(context);
	}

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		System.out.println(String.format("Processing with %s", this.getClass().getSimpleName()));

		for (Sentence sent : JCasUtil.select(aJCas, Sentence.class)) {
			// Sentence sent = sentenceList.get(i);
			ArrayList<Token> tokenList = Utils.getTokenListFromSentenceList(sent);
			ArrayList<NounPhrase> phraseList = extractNounPhrases(tokenList, aJCas);
			FSList fsPhraseList = Utils.createNounPhraseList(aJCas, phraseList);
			sent.setPhraseList(fsPhraseList);
		}
	}

	public ArrayList<NounPhrase> extractNounPhrases(ArrayList<Token> tokenList, JCas jCas) {

		ArrayList<NounPhrase> nounPhraseList = new ArrayList<NounPhrase>();
		String nounPhrase = "";
		for (int i = 0; i < tokenList.size(); i++) {
			Token token = tokenList.get(i);
			String word = token.getText();
			String pos = token.getPos();

			if (pos.startsWith("NN") || pos.startsWith("JJ") || pos.startsWith("CD")) {
				nounPhrase += word + " ";
			} else {
				nounPhrase = nounPhrase.trim();
				if (!nounPhrase.equals("")) {
					NounPhrase nn = new NounPhrase(jCas);
					nn.setText(nounPhrase);
					nounPhraseList.add(nn);
					nn.addToIndexes();
					// System.out.println("Noun Phrase: "+nounPhrase);
					nounPhrase = "";
				}
			}

		}
		nounPhrase = nounPhrase.trim();
		if (!nounPhrase.equals("")) {
			NounPhrase nn = new NounPhrase(jCas);
			nn.setText(nounPhrase);
			nn.addToIndexes();
			nounPhraseList.add(nn);
		}

		return nounPhraseList;
	}

}
