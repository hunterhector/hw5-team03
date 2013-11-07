
/* First created by JCasGen Wed Nov 06 21:03:16 EST 2013 */
package edu.cmu.lti.qa4mre.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import edu.cmu.lti.util.type.ComponentAnnotation_Type;

/** 
 * Updated by JCasGen Wed Nov 06 21:03:16 EST 2013
 * @generated */
public class StanfordCorenlpSentence_Type extends ComponentAnnotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (StanfordCorenlpSentence_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = StanfordCorenlpSentence_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new StanfordCorenlpSentence(addr, StanfordCorenlpSentence_Type.this);
  			   StanfordCorenlpSentence_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new StanfordCorenlpSentence(addr, StanfordCorenlpSentence_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = StanfordCorenlpSentence.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.qa4mre.type.StanfordCorenlpSentence");
 
  /** @generated */
  final Feature casFeat_sentenceId;
  /** @generated */
  final int     casFeatCode_sentenceId;
  /** @generated */ 
  public int getSentenceId(int addr) {
        if (featOkTst && casFeat_sentenceId == null)
      jcas.throwFeatMissing("sentenceId", "edu.cmu.lti.qa4mre.type.StanfordCorenlpSentence");
    return ll_cas.ll_getIntValue(addr, casFeatCode_sentenceId);
  }
  /** @generated */    
  public void setSentenceId(int addr, int v) {
        if (featOkTst && casFeat_sentenceId == null)
      jcas.throwFeatMissing("sentenceId", "edu.cmu.lti.qa4mre.type.StanfordCorenlpSentence");
    ll_cas.ll_setIntValue(addr, casFeatCode_sentenceId, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public StanfordCorenlpSentence_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_sentenceId = jcas.getRequiredFeatureDE(casType, "sentenceId", "uima.cas.Integer", featOkTst);
    casFeatCode_sentenceId  = (null == casFeat_sentenceId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sentenceId).getCode();

  }
}



    