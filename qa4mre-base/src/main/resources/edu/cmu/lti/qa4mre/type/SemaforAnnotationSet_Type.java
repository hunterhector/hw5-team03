
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
public class SemaforAnnotationSet_Type extends ComponentAnnotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (SemaforAnnotationSet_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = SemaforAnnotationSet_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new SemaforAnnotationSet(addr, SemaforAnnotationSet_Type.this);
  			   SemaforAnnotationSet_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new SemaforAnnotationSet(addr, SemaforAnnotationSet_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = SemaforAnnotationSet.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.qa4mre.type.SemaforAnnotationSet");
 
  /** @generated */
  final Feature casFeat_layers;
  /** @generated */
  final int     casFeatCode_layers;
  /** @generated */ 
  public int getLayers(int addr) {
        if (featOkTst && casFeat_layers == null)
      jcas.throwFeatMissing("layers", "edu.cmu.lti.qa4mre.type.SemaforAnnotationSet");
    return ll_cas.ll_getRefValue(addr, casFeatCode_layers);
  }
  /** @generated */    
  public void setLayers(int addr, int v) {
        if (featOkTst && casFeat_layers == null)
      jcas.throwFeatMissing("layers", "edu.cmu.lti.qa4mre.type.SemaforAnnotationSet");
    ll_cas.ll_setRefValue(addr, casFeatCode_layers, v);}
    
   /** @generated */
  public int getLayers(int addr, int i) {
        if (featOkTst && casFeat_layers == null)
      jcas.throwFeatMissing("layers", "edu.cmu.lti.qa4mre.type.SemaforAnnotationSet");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_layers), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_layers), i);
	return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_layers), i);
  }
   
  /** @generated */ 
  public void setLayers(int addr, int i, int v) {
        if (featOkTst && casFeat_layers == null)
      jcas.throwFeatMissing("layers", "edu.cmu.lti.qa4mre.type.SemaforAnnotationSet");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_layers), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_layers), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_layers), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_frameName;
  /** @generated */
  final int     casFeatCode_frameName;
  /** @generated */ 
  public String getFrameName(int addr) {
        if (featOkTst && casFeat_frameName == null)
      jcas.throwFeatMissing("frameName", "edu.cmu.lti.qa4mre.type.SemaforAnnotationSet");
    return ll_cas.ll_getStringValue(addr, casFeatCode_frameName);
  }
  /** @generated */    
  public void setFrameName(int addr, String v) {
        if (featOkTst && casFeat_frameName == null)
      jcas.throwFeatMissing("frameName", "edu.cmu.lti.qa4mre.type.SemaforAnnotationSet");
    ll_cas.ll_setStringValue(addr, casFeatCode_frameName, v);}
    
  
 
  /** @generated */
  final Feature casFeat_ID;
  /** @generated */
  final int     casFeatCode_ID;
  /** @generated */ 
  public int getID(int addr) {
        if (featOkTst && casFeat_ID == null)
      jcas.throwFeatMissing("ID", "edu.cmu.lti.qa4mre.type.SemaforAnnotationSet");
    return ll_cas.ll_getIntValue(addr, casFeatCode_ID);
  }
  /** @generated */    
  public void setID(int addr, int v) {
        if (featOkTst && casFeat_ID == null)
      jcas.throwFeatMissing("ID", "edu.cmu.lti.qa4mre.type.SemaforAnnotationSet");
    ll_cas.ll_setIntValue(addr, casFeatCode_ID, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public SemaforAnnotationSet_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_layers = jcas.getRequiredFeatureDE(casType, "layers", "uima.cas.FSArray", featOkTst);
    casFeatCode_layers  = (null == casFeat_layers) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_layers).getCode();

 
    casFeat_frameName = jcas.getRequiredFeatureDE(casType, "frameName", "uima.cas.String", featOkTst);
    casFeatCode_frameName  = (null == casFeat_frameName) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_frameName).getCode();

 
    casFeat_ID = jcas.getRequiredFeatureDE(casType, "ID", "uima.cas.Integer", featOkTst);
    casFeatCode_ID  = (null == casFeat_ID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ID).getCode();

  }
}



    