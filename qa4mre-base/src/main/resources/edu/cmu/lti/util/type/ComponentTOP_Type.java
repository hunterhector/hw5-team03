
/* First created by JCasGen Wed Nov 06 21:03:16 EST 2013 */
package edu.cmu.lti.util.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.cas.TOP_Type;

/** 
 * Updated by JCasGen Wed Nov 06 21:03:16 EST 2013
 * @generated */
public class ComponentTOP_Type extends TOP_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (ComponentTOP_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = ComponentTOP_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new ComponentTOP(addr, ComponentTOP_Type.this);
  			   ComponentTOP_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new ComponentTOP(addr, ComponentTOP_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = ComponentTOP.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.util.type.ComponentTOP");
 
  /** @generated */
  final Feature casFeat_componentId;
  /** @generated */
  final int     casFeatCode_componentId;
  /** @generated */ 
  public String getComponentId(int addr) {
        if (featOkTst && casFeat_componentId == null)
      jcas.throwFeatMissing("componentId", "edu.cmu.lti.util.type.ComponentTOP");
    return ll_cas.ll_getStringValue(addr, casFeatCode_componentId);
  }
  /** @generated */    
  public void setComponentId(int addr, String v) {
        if (featOkTst && casFeat_componentId == null)
      jcas.throwFeatMissing("componentId", "edu.cmu.lti.util.type.ComponentTOP");
    ll_cas.ll_setStringValue(addr, casFeatCode_componentId, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public ComponentTOP_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_componentId = jcas.getRequiredFeatureDE(casType, "componentId", "uima.cas.String", featOkTst);
    casFeatCode_componentId  = (null == casFeat_componentId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_componentId).getCode();

  }
}



    