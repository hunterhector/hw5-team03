
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
import edu.cmu.lti.util.type.ComponentTOP_Type;

/** 
 * Updated by JCasGen Wed Nov 06 21:03:16 EST 2013
 * @generated */
public class StanfordDependencyRelation_Type extends ComponentTOP_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (StanfordDependencyRelation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = StanfordDependencyRelation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new StanfordDependencyRelation(addr, StanfordDependencyRelation_Type.this);
  			   StanfordDependencyRelation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new StanfordDependencyRelation(addr, StanfordDependencyRelation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = StanfordDependencyRelation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.qa4mre.type.StanfordDependencyRelation");
 
  /** @generated */
  final Feature casFeat_head;
  /** @generated */
  final int     casFeatCode_head;
  /** @generated */ 
  public int getHead(int addr) {
        if (featOkTst && casFeat_head == null)
      jcas.throwFeatMissing("head", "edu.cmu.lti.qa4mre.type.StanfordDependencyRelation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_head);
  }
  /** @generated */    
  public void setHead(int addr, int v) {
        if (featOkTst && casFeat_head == null)
      jcas.throwFeatMissing("head", "edu.cmu.lti.qa4mre.type.StanfordDependencyRelation");
    ll_cas.ll_setRefValue(addr, casFeatCode_head, v);}
    
  
 
  /** @generated */
  final Feature casFeat_child;
  /** @generated */
  final int     casFeatCode_child;
  /** @generated */ 
  public int getChild(int addr) {
        if (featOkTst && casFeat_child == null)
      jcas.throwFeatMissing("child", "edu.cmu.lti.qa4mre.type.StanfordDependencyRelation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_child);
  }
  /** @generated */    
  public void setChild(int addr, int v) {
        if (featOkTst && casFeat_child == null)
      jcas.throwFeatMissing("child", "edu.cmu.lti.qa4mre.type.StanfordDependencyRelation");
    ll_cas.ll_setRefValue(addr, casFeatCode_child, v);}
    
  
 
  /** @generated */
  final Feature casFeat_relationType;
  /** @generated */
  final int     casFeatCode_relationType;
  /** @generated */ 
  public String getRelationType(int addr) {
        if (featOkTst && casFeat_relationType == null)
      jcas.throwFeatMissing("relationType", "edu.cmu.lti.qa4mre.type.StanfordDependencyRelation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_relationType);
  }
  /** @generated */    
  public void setRelationType(int addr, String v) {
        if (featOkTst && casFeat_relationType == null)
      jcas.throwFeatMissing("relationType", "edu.cmu.lti.qa4mre.type.StanfordDependencyRelation");
    ll_cas.ll_setStringValue(addr, casFeatCode_relationType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_weight;
  /** @generated */
  final int     casFeatCode_weight;
  /** @generated */ 
  public double getWeight(int addr) {
        if (featOkTst && casFeat_weight == null)
      jcas.throwFeatMissing("weight", "edu.cmu.lti.qa4mre.type.StanfordDependencyRelation");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_weight);
  }
  /** @generated */    
  public void setWeight(int addr, double v) {
        if (featOkTst && casFeat_weight == null)
      jcas.throwFeatMissing("weight", "edu.cmu.lti.qa4mre.type.StanfordDependencyRelation");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_weight, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public StanfordDependencyRelation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_head = jcas.getRequiredFeatureDE(casType, "head", "edu.cmu.lti.qa4mre.type.StanfordDependencyNode", featOkTst);
    casFeatCode_head  = (null == casFeat_head) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_head).getCode();

 
    casFeat_child = jcas.getRequiredFeatureDE(casType, "child", "edu.cmu.lti.qa4mre.type.StanfordDependencyNode", featOkTst);
    casFeatCode_child  = (null == casFeat_child) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_child).getCode();

 
    casFeat_relationType = jcas.getRequiredFeatureDE(casType, "relationType", "uima.cas.String", featOkTst);
    casFeatCode_relationType  = (null == casFeat_relationType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_relationType).getCode();

 
    casFeat_weight = jcas.getRequiredFeatureDE(casType, "weight", "uima.cas.Double", featOkTst);
    casFeatCode_weight  = (null == casFeat_weight) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_weight).getCode();

  }
}



    