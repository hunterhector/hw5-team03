
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
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Wed Nov 06 21:03:16 EST 2013
 * @generated */
public class SemaforParse_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (SemaforParse_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = SemaforParse_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new SemaforParse(addr, SemaforParse_Type.this);
  			   SemaforParse_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new SemaforParse(addr, SemaforParse_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = SemaforParse.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.qa4mre.type.SemaforParse");
 
  /** @generated */
  final Feature casFeat_annotationSets;
  /** @generated */
  final int     casFeatCode_annotationSets;
  /** @generated */ 
  public int getAnnotationSets(int addr) {
        if (featOkTst && casFeat_annotationSets == null)
      jcas.throwFeatMissing("annotationSets", "edu.cmu.lti.qa4mre.type.SemaforParse");
    return ll_cas.ll_getRefValue(addr, casFeatCode_annotationSets);
  }
  /** @generated */    
  public void setAnnotationSets(int addr, int v) {
        if (featOkTst && casFeat_annotationSets == null)
      jcas.throwFeatMissing("annotationSets", "edu.cmu.lti.qa4mre.type.SemaforParse");
    ll_cas.ll_setRefValue(addr, casFeatCode_annotationSets, v);}
    
   /** @generated */
  public int getAnnotationSets(int addr, int i) {
        if (featOkTst && casFeat_annotationSets == null)
      jcas.throwFeatMissing("annotationSets", "edu.cmu.lti.qa4mre.type.SemaforParse");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_annotationSets), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_annotationSets), i);
	return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_annotationSets), i);
  }
   
  /** @generated */ 
  public void setAnnotationSets(int addr, int i, int v) {
        if (featOkTst && casFeat_annotationSets == null)
      jcas.throwFeatMissing("annotationSets", "edu.cmu.lti.qa4mre.type.SemaforParse");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_annotationSets), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_annotationSets), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_annotationSets), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public SemaforParse_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_annotationSets = jcas.getRequiredFeatureDE(casType, "annotationSets", "uima.cas.FSArray", featOkTst);
    casFeatCode_annotationSets  = (null == casFeat_annotationSets) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_annotationSets).getCode();

  }
}



    