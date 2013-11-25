/**
 * 
 */
package edu.cmu.lti.deiis.hw5.annotators;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.util.JCasUtil;

import edu.cmu.lti.qa4mre.type.StanfordCorenlpToken;
import edu.knowitall.tool.stem.PorterStemmer;
import edu.knowitall.tool.stem.SnowballStemmer;
import edu.washington.cs.knowitall.morpha.MorphaStemmer;

/**
 * There is a problem while matching words, the morphological changes of words
 * make it hard to compare wordnet similarities, for example, similarity between
 * an adj and a noun could be difficult. Unifying the morphological change could
 * be beneficial.
 * 
 * @author Zhengzhong Liu, Hector
 * 
 */
public class TokenMorphologyAnnotator extends JCasAnnotator_ImplBase {

	PorterStemmer porterStemmer = new PorterStemmer();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.uima.analysis_component.JCasAnnotator_ImplBase#process(org
	 * .apache.uima.jcas.JCas)
	 */
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// for (Sentence sent : JCasUtil.select(aJCas, Sentence.class)) {
		// String sent = sent.ge
		//
		// }

		for (StanfordCorenlpToken word : JCasUtil.select(aJCas, StanfordCorenlpToken.class)) {
			String wordText = word.getCoveredText();
			String posTag = word.getPos();
			// use the morpha stemmer to get the form I want!!
			String morpha;
			String shorterned;

			shorterned = word.getLemma();
			if (wordText.contains(" ")) {// morpha cannot handle space
				morpha = word.getLemma();
			} else {
				// without the posTag the stemmer is more aggressive, and that's
				// what I want

				// morpha = MorphaStemmer.stemToken(wordText, posTag);
				morpha = MorphaStemmer.stemToken(wordText);

				if (shorterned.length() > 12) {
					shorterned = shorterned.substring(0, 12);
				}

				// porter = porterStemmer.stem(wordText);
				// snowball = SnowballStemmer.stem(wordText);
				// System.out.println(porter + " " + snowball);
			}
			if (!wordText.equals(morpha))
				System.out.println(String.format("From lemma %s to morpha %s, pos %s", wordText, morpha, posTag));
			word.setMorpha(morpha);
			word.setShorten(shorterned);
		}
	}
}
