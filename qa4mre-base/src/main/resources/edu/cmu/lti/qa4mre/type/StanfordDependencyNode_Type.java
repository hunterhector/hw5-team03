
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
public class StanfordDependencyNode_Type extends ComponentAnnotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (StanfordDependencyNode_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = StanfordDependencyNode_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new StanfordDependencyNode(addr, StanfordDependencyNode_Type.this);
  			   StanfordDependencyNode_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new StanfordDependencyNode(addr, StanfordDependencyNode_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = StanfordDependencyNode.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.qa4mre.type.StanfordDependencyNode");
 
  /** @generated */
  final Feature casFeat_headRelations;
  /** @generated */
  final int     casFeatCode_headRelations;
  /** @generated */ 
  public int getHeadRelations(int addr) {
        if (featOkTst && casFeat_headRelations == null)
      jcas.throwFeatMissing("headRelations", "edu.cmu.lti.qa4mre.type.StanfordDependencyNode");
    return ll_cas.ll_getRefValue(addr, casFeatCode_headRelations);
  }
  /** @generated */    
  public void setHeadRelations(int addr, int v) {
        if (featOkTst && casFeat_headRelations == null)
      jcas.throwFeatMissing("headRelations", "edu.cmu.lti.qa4mre.type.StanfordDependencyNode");
    ll_cas.ll_setRefValue(addr, casFeatCode_headRelations, v);}
    
  
 
  /** @generated */
  final Feature casFeat_childRelations;
  /** @generated */
  final int     casFeatCode_childRelations;
  /** @generated */ 
  public int getChildRelations(int addr) {
        if (featOkTst && casFeat_childRelations == null)
      jcas.throwFeatMissing("childRelations", "edu.cmu.lti.qa4mre.type.StanfordDependencyNode");
    return ll_cas.ll_getRefValue(addr, casFeatCode_childRelations);
  }
  /** @generated */    
  public void setChildRelations(int addr, int v) {
        if (featOkTst && casFeat_childRelations == null)
      jcas.throwFeatMissing("childRelations", "edu.cmu.lti.qa4mre.type.StanfordDependencyNode");
    ll_cas.ll_setRefValue(addr, casFeatCode_childRelations, v);}
    
  
 
  /** @generated */
  final Feature casFeat_token;
  /** @generated */
  final int     casFeatCode_token;
  /** @generated */ 
  public int getToken(int addr) {
        if (featOkTst && casFeat_token == null)
      jcas.throwFeatMissing("token", "edu.cmu.lti.qa4mre.type.StanfordDependencyNode");
    return ll_cas.ll_getRefValue(addr, casFeatCode_token);
  }
  /** @generated */    
  public void setToken(int addr, int v) {
        if (featOkTst && casFeat_token == null)
      jcas.throwFeatMissing("token", "edu.cmu.lti.qa4mre.type.StanfordDependencyNode");
    ll_cas.ll_setRefValue(addr, casFeatCode_token, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public StanfordDependencyNode_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_headRelations = jcas.getRequiredFeatureDE(casType, "headRelations", "uima.cas.FSList", featOkTst);
    casFeatCode_headRelations  = (null == casFeat_headRelations) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_headRelations).getCode();

 
    casFeat_childRelations = jcas.getRequiredFeatureDE(casType, "childRelations", "uima.cas.FSList", featOkTst);
    casFeatCode_childRelations  = (null == casFeat_childRelations) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_childRelations).getCode();

 
    casFeat_token = jcas.getRequiredFeatureDE(casType, "token", "edu.cmu.lti.qa4mre.type.StanfordCorenlpToken", featOkTst);
    casFeatCode_token  = (null == casFeat_token) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_token).getCode();

  }
}



    