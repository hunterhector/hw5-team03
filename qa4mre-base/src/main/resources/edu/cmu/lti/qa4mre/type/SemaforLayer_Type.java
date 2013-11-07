
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
public class SemaforLayer_Type extends ComponentAnnotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (SemaforLayer_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = SemaforLayer_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new SemaforLayer(addr, SemaforLayer_Type.this);
  			   SemaforLayer_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new SemaforLayer(addr, SemaforLayer_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = SemaforLayer.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.qa4mre.type.SemaforLayer");
 
  /** @generated */
  final Feature casFeat_name;
  /** @generated */
  final int     casFeatCode_name;
  /** @generated */ 
  public String getName(int addr) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    return ll_cas.ll_getStringValue(addr, casFeatCode_name);
  }
  /** @generated */    
  public void setName(int addr, String v) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    ll_cas.ll_setStringValue(addr, casFeatCode_name, v);}
    
  
 
  /** @generated */
  final Feature casFeat_labels;
  /** @generated */
  final int     casFeatCode_labels;
  /** @generated */ 
  public int getLabels(int addr) {
        if (featOkTst && casFeat_labels == null)
      jcas.throwFeatMissing("labels", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    return ll_cas.ll_getRefValue(addr, casFeatCode_labels);
  }
  /** @generated */    
  public void setLabels(int addr, int v) {
        if (featOkTst && casFeat_labels == null)
      jcas.throwFeatMissing("labels", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    ll_cas.ll_setRefValue(addr, casFeatCode_labels, v);}
    
   /** @generated */
  public int getLabels(int addr, int i) {
        if (featOkTst && casFeat_labels == null)
      jcas.throwFeatMissing("labels", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_labels), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_labels), i);
	return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_labels), i);
  }
   
  /** @generated */ 
  public void setLabels(int addr, int i, int v) {
        if (featOkTst && casFeat_labels == null)
      jcas.throwFeatMissing("labels", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_labels), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_labels), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_labels), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_ID;
  /** @generated */
  final int     casFeatCode_ID;
  /** @generated */ 
  public int getID(int addr) {
        if (featOkTst && casFeat_ID == null)
      jcas.throwFeatMissing("ID", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    return ll_cas.ll_getIntValue(addr, casFeatCode_ID);
  }
  /** @generated */    
  public void setID(int addr, int v) {
        if (featOkTst && casFeat_ID == null)
      jcas.throwFeatMissing("ID", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    ll_cas.ll_setIntValue(addr, casFeatCode_ID, v);}
    
  
 
  /** @generated */
  final Feature casFeat_rank;
  /** @generated */
  final int     casFeatCode_rank;
  /** @generated */ 
  public int getRank(int addr) {
        if (featOkTst && casFeat_rank == null)
      jcas.throwFeatMissing("rank", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    return ll_cas.ll_getIntValue(addr, casFeatCode_rank);
  }
  /** @generated */    
  public void setRank(int addr, int v) {
        if (featOkTst && casFeat_rank == null)
      jcas.throwFeatMissing("rank", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    ll_cas.ll_setIntValue(addr, casFeatCode_rank, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public SemaforLayer_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_name = jcas.getRequiredFeatureDE(casType, "name", "uima.cas.String", featOkTst);
    casFeatCode_name  = (null == casFeat_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_name).getCode();

 
    casFeat_labels = jcas.getRequiredFeatureDE(casType, "labels", "uima.cas.FSArray", featOkTst);
    casFeatCode_labels  = (null == casFeat_labels) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_labels).getCode();

 
    casFeat_ID = jcas.getRequiredFeatureDE(casType, "ID", "uima.cas.Integer", featOkTst);
    casFeatCode_ID  = (null == casFeat_ID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ID).getCode();

 
    casFeat_rank = jcas.getRequiredFeatureDE(casType, "rank", "uima.cas.Integer", featOkTst);
    casFeatCode_rank  = (null == casFeat_rank) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_rank).getCode();

  }
}



    