
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

/** See http://www-nlp.stanford.edu/nlp/javadoc/javanlp/edu/stanford/nlp/time/Timex.html
 * Updated by JCasGen Wed Nov 06 21:03:16 EST 2013
 * @generated */
public class StanfordCoreNlpTimex_Type extends ComponentAnnotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (StanfordCoreNlpTimex_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = StanfordCoreNlpTimex_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new StanfordCoreNlpTimex(addr, StanfordCoreNlpTimex_Type.this);
  			   StanfordCoreNlpTimex_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new StanfordCoreNlpTimex(addr, StanfordCoreNlpTimex_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = StanfordCoreNlpTimex.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.qa4mre.type.StanfordCoreNlpTimex");
 
  /** @generated */
  final Feature casFeat_tid;
  /** @generated */
  final int     casFeatCode_tid;
  /** @generated */ 
  public String getTid(int addr) {
        if (featOkTst && casFeat_tid == null)
      jcas.throwFeatMissing("tid", "edu.cmu.lti.qa4mre.type.StanfordCoreNlpTimex");
    return ll_cas.ll_getStringValue(addr, casFeatCode_tid);
  }
  /** @generated */    
  public void setTid(int addr, String v) {
        if (featOkTst && casFeat_tid == null)
      jcas.throwFeatMissing("tid", "edu.cmu.lti.qa4mre.type.StanfordCoreNlpTimex");
    ll_cas.ll_setStringValue(addr, casFeatCode_tid, v);}
    
  
 
  /** @generated */
  final Feature casFeat_value;
  /** @generated */
  final int     casFeatCode_value;
  /** @generated */ 
  public String getValue(int addr) {
        if (featOkTst && casFeat_value == null)
      jcas.throwFeatMissing("value", "edu.cmu.lti.qa4mre.type.StanfordCoreNlpTimex");
    return ll_cas.ll_getStringValue(addr, casFeatCode_value);
  }
  /** @generated */    
  public void setValue(int addr, String v) {
        if (featOkTst && casFeat_value == null)
      jcas.throwFeatMissing("value", "edu.cmu.lti.qa4mre.type.StanfordCoreNlpTimex");
    ll_cas.ll_setStringValue(addr, casFeatCode_value, v);}
    
  
 
  /** @generated */
  final Feature casFeat_timexType;
  /** @generated */
  final int     casFeatCode_timexType;
  /** @generated */ 
  public String getTimexType(int addr) {
        if (featOkTst && casFeat_timexType == null)
      jcas.throwFeatMissing("timexType", "edu.cmu.lti.qa4mre.type.StanfordCoreNlpTimex");
    return ll_cas.ll_getStringValue(addr, casFeatCode_timexType);
  }
  /** @generated */    
  public void setTimexType(int addr, String v) {
        if (featOkTst && casFeat_timexType == null)
      jcas.throwFeatMissing("timexType", "edu.cmu.lti.qa4mre.type.StanfordCoreNlpTimex");
    ll_cas.ll_setStringValue(addr, casFeatCode_timexType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_range;
  /** @generated */
  final int     casFeatCode_range;
  /** @generated */ 
  public String getRange(int addr) {
        if (featOkTst && casFeat_range == null)
      jcas.throwFeatMissing("range", "edu.cmu.lti.qa4mre.type.StanfordCoreNlpTimex");
    return ll_cas.ll_getStringValue(addr, casFeatCode_range);
  }
  /** @generated */    
  public void setRange(int addr, String v) {
        if (featOkTst && casFeat_range == null)
      jcas.throwFeatMissing("range", "edu.cmu.lti.qa4mre.type.StanfordCoreNlpTimex");
    ll_cas.ll_setStringValue(addr, casFeatCode_range, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public StanfordCoreNlpTimex_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_tid = jcas.getRequiredFeatureDE(casType, "tid", "uima.cas.String", featOkTst);
    casFeatCode_tid  = (null == casFeat_tid) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_tid).getCode();

 
    casFeat_value = jcas.getRequiredFeatureDE(casType, "value", "uima.cas.String", featOkTst);
    casFeatCode_value  = (null == casFeat_value) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_value).getCode();

 
    casFeat_timexType = jcas.getRequiredFeatureDE(casType, "timexType", "uima.cas.String", featOkTst);
    casFeatCode_timexType  = (null == casFeat_timexType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_timexType).getCode();

 
    casFeat_range = jcas.getRequiredFeatureDE(casType, "range", "uima.cas.String", featOkTst);
    casFeatCode_range  = (null == casFeat_range) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_range).getCode();

  }
}



    