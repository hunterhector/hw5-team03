
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
public class StanfordTreeAnnotation_Type extends ComponentAnnotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (StanfordTreeAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = StanfordTreeAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new StanfordTreeAnnotation(addr, StanfordTreeAnnotation_Type.this);
  			   StanfordTreeAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new StanfordTreeAnnotation(addr, StanfordTreeAnnotation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = StanfordTreeAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
 
  /** @generated */
  final Feature casFeat_pennTreeLabel;
  /** @generated */
  final int     casFeatCode_pennTreeLabel;
  /** @generated */ 
  public String getPennTreeLabel(int addr) {
        if (featOkTst && casFeat_pennTreeLabel == null)
      jcas.throwFeatMissing("pennTreeLabel", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_pennTreeLabel);
  }
  /** @generated */    
  public void setPennTreeLabel(int addr, String v) {
        if (featOkTst && casFeat_pennTreeLabel == null)
      jcas.throwFeatMissing("pennTreeLabel", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_pennTreeLabel, v);}
    
  
 
  /** @generated */
  final Feature casFeat_children;
  /** @generated */
  final int     casFeatCode_children;
  /** @generated */ 
  public int getChildren(int addr) {
        if (featOkTst && casFeat_children == null)
      jcas.throwFeatMissing("children", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_children);
  }
  /** @generated */    
  public void setChildren(int addr, int v) {
        if (featOkTst && casFeat_children == null)
      jcas.throwFeatMissing("children", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    ll_cas.ll_setRefValue(addr, casFeatCode_children, v);}
    
  
 
  /** @generated */
  final Feature casFeat_isLeaf;
  /** @generated */
  final int     casFeatCode_isLeaf;
  /** @generated */ 
  public boolean getIsLeaf(int addr) {
        if (featOkTst && casFeat_isLeaf == null)
      jcas.throwFeatMissing("isLeaf", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_isLeaf);
  }
  /** @generated */    
  public void setIsLeaf(int addr, boolean v) {
        if (featOkTst && casFeat_isLeaf == null)
      jcas.throwFeatMissing("isLeaf", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_isLeaf, v);}
    
  
 
  /** @generated */
  final Feature casFeat_isRoot;
  /** @generated */
  final int     casFeatCode_isRoot;
  /** @generated */ 
  public boolean getIsRoot(int addr) {
        if (featOkTst && casFeat_isRoot == null)
      jcas.throwFeatMissing("isRoot", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_isRoot);
  }
  /** @generated */    
  public void setIsRoot(int addr, boolean v) {
        if (featOkTst && casFeat_isRoot == null)
      jcas.throwFeatMissing("isRoot", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_isRoot, v);}
    
  
 
  /** @generated */
  final Feature casFeat_parent;
  /** @generated */
  final int     casFeatCode_parent;
  /** @generated */ 
  public int getParent(int addr) {
        if (featOkTst && casFeat_parent == null)
      jcas.throwFeatMissing("parent", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_parent);
  }
  /** @generated */    
  public void setParent(int addr, int v) {
        if (featOkTst && casFeat_parent == null)
      jcas.throwFeatMissing("parent", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    ll_cas.ll_setRefValue(addr, casFeatCode_parent, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public StanfordTreeAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_pennTreeLabel = jcas.getRequiredFeatureDE(casType, "pennTreeLabel", "uima.cas.String", featOkTst);
    casFeatCode_pennTreeLabel  = (null == casFeat_pennTreeLabel) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_pennTreeLabel).getCode();

 
    casFeat_children = jcas.getRequiredFeatureDE(casType, "children", "uima.cas.FSList", featOkTst);
    casFeatCode_children  = (null == casFeat_children) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_children).getCode();

 
    casFeat_isLeaf = jcas.getRequiredFeatureDE(casType, "isLeaf", "uima.cas.Boolean", featOkTst);
    casFeatCode_isLeaf  = (null == casFeat_isLeaf) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_isLeaf).getCode();

 
    casFeat_isRoot = jcas.getRequiredFeatureDE(casType, "isRoot", "uima.cas.Boolean", featOkTst);
    casFeatCode_isRoot  = (null == casFeat_isRoot) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_isRoot).getCode();

 
    casFeat_parent = jcas.getRequiredFeatureDE(casType, "parent", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation", featOkTst);
    casFeatCode_parent  = (null == casFeat_parent) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_parent).getCode();

  }
}



    