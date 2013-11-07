
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
public class FanseToken_Type extends ComponentAnnotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (FanseToken_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = FanseToken_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new FanseToken(addr, FanseToken_Type.this);
  			   FanseToken_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new FanseToken(addr, FanseToken_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = FanseToken.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.qa4mre.type.FanseToken");
 
  /** @generated */
  final Feature casFeat_tokenId;
  /** @generated */
  final int     casFeatCode_tokenId;
  /** @generated */ 
  public int getTokenId(int addr) {
        if (featOkTst && casFeat_tokenId == null)
      jcas.throwFeatMissing("tokenId", "edu.cmu.lti.qa4mre.type.FanseToken");
    return ll_cas.ll_getIntValue(addr, casFeatCode_tokenId);
  }
  /** @generated */    
  public void setTokenId(int addr, int v) {
        if (featOkTst && casFeat_tokenId == null)
      jcas.throwFeatMissing("tokenId", "edu.cmu.lti.qa4mre.type.FanseToken");
    ll_cas.ll_setIntValue(addr, casFeatCode_tokenId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_coarsePos;
  /** @generated */
  final int     casFeatCode_coarsePos;
  /** @generated */ 
  public String getCoarsePos(int addr) {
        if (featOkTst && casFeat_coarsePos == null)
      jcas.throwFeatMissing("coarsePos", "edu.cmu.lti.qa4mre.type.FanseToken");
    return ll_cas.ll_getStringValue(addr, casFeatCode_coarsePos);
  }
  /** @generated */    
  public void setCoarsePos(int addr, String v) {
        if (featOkTst && casFeat_coarsePos == null)
      jcas.throwFeatMissing("coarsePos", "edu.cmu.lti.qa4mre.type.FanseToken");
    ll_cas.ll_setStringValue(addr, casFeatCode_coarsePos, v);}
    
  
 
  /** @generated */
  final Feature casFeat_pos;
  /** @generated */
  final int     casFeatCode_pos;
  /** @generated */ 
  public String getPos(int addr) {
        if (featOkTst && casFeat_pos == null)
      jcas.throwFeatMissing("pos", "edu.cmu.lti.qa4mre.type.FanseToken");
    return ll_cas.ll_getStringValue(addr, casFeatCode_pos);
  }
  /** @generated */    
  public void setPos(int addr, String v) {
        if (featOkTst && casFeat_pos == null)
      jcas.throwFeatMissing("pos", "edu.cmu.lti.qa4mre.type.FanseToken");
    ll_cas.ll_setStringValue(addr, casFeatCode_pos, v);}
    
  
 
  /** @generated */
  final Feature casFeat_lexicalSense;
  /** @generated */
  final int     casFeatCode_lexicalSense;
  /** @generated */ 
  public String getLexicalSense(int addr) {
        if (featOkTst && casFeat_lexicalSense == null)
      jcas.throwFeatMissing("lexicalSense", "edu.cmu.lti.qa4mre.type.FanseToken");
    return ll_cas.ll_getStringValue(addr, casFeatCode_lexicalSense);
  }
  /** @generated */    
  public void setLexicalSense(int addr, String v) {
        if (featOkTst && casFeat_lexicalSense == null)
      jcas.throwFeatMissing("lexicalSense", "edu.cmu.lti.qa4mre.type.FanseToken");
    ll_cas.ll_setStringValue(addr, casFeatCode_lexicalSense, v);}
    
  
 
  /** @generated */
  final Feature casFeat_headDependencyRelations;
  /** @generated */
  final int     casFeatCode_headDependencyRelations;
  /** @generated */ 
  public int getHeadDependencyRelations(int addr) {
        if (featOkTst && casFeat_headDependencyRelations == null)
      jcas.throwFeatMissing("headDependencyRelations", "edu.cmu.lti.qa4mre.type.FanseToken");
    return ll_cas.ll_getRefValue(addr, casFeatCode_headDependencyRelations);
  }
  /** @generated */    
  public void setHeadDependencyRelations(int addr, int v) {
        if (featOkTst && casFeat_headDependencyRelations == null)
      jcas.throwFeatMissing("headDependencyRelations", "edu.cmu.lti.qa4mre.type.FanseToken");
    ll_cas.ll_setRefValue(addr, casFeatCode_headDependencyRelations, v);}
    
  
 
  /** @generated */
  final Feature casFeat_childDependencyRelations;
  /** @generated */
  final int     casFeatCode_childDependencyRelations;
  /** @generated */ 
  public int getChildDependencyRelations(int addr) {
        if (featOkTst && casFeat_childDependencyRelations == null)
      jcas.throwFeatMissing("childDependencyRelations", "edu.cmu.lti.qa4mre.type.FanseToken");
    return ll_cas.ll_getRefValue(addr, casFeatCode_childDependencyRelations);
  }
  /** @generated */    
  public void setChildDependencyRelations(int addr, int v) {
        if (featOkTst && casFeat_childDependencyRelations == null)
      jcas.throwFeatMissing("childDependencyRelations", "edu.cmu.lti.qa4mre.type.FanseToken");
    ll_cas.ll_setRefValue(addr, casFeatCode_childDependencyRelations, v);}
    
  
 
  /** @generated */
  final Feature casFeat_headSemanticRelations;
  /** @generated */
  final int     casFeatCode_headSemanticRelations;
  /** @generated */ 
  public int getHeadSemanticRelations(int addr) {
        if (featOkTst && casFeat_headSemanticRelations == null)
      jcas.throwFeatMissing("headSemanticRelations", "edu.cmu.lti.qa4mre.type.FanseToken");
    return ll_cas.ll_getRefValue(addr, casFeatCode_headSemanticRelations);
  }
  /** @generated */    
  public void setHeadSemanticRelations(int addr, int v) {
        if (featOkTst && casFeat_headSemanticRelations == null)
      jcas.throwFeatMissing("headSemanticRelations", "edu.cmu.lti.qa4mre.type.FanseToken");
    ll_cas.ll_setRefValue(addr, casFeatCode_headSemanticRelations, v);}
    
  
 
  /** @generated */
  final Feature casFeat_childSemanticRelations;
  /** @generated */
  final int     casFeatCode_childSemanticRelations;
  /** @generated */ 
  public int getChildSemanticRelations(int addr) {
        if (featOkTst && casFeat_childSemanticRelations == null)
      jcas.throwFeatMissing("childSemanticRelations", "edu.cmu.lti.qa4mre.type.FanseToken");
    return ll_cas.ll_getRefValue(addr, casFeatCode_childSemanticRelations);
  }
  /** @generated */    
  public void setChildSemanticRelations(int addr, int v) {
        if (featOkTst && casFeat_childSemanticRelations == null)
      jcas.throwFeatMissing("childSemanticRelations", "edu.cmu.lti.qa4mre.type.FanseToken");
    ll_cas.ll_setRefValue(addr, casFeatCode_childSemanticRelations, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public FanseToken_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_tokenId = jcas.getRequiredFeatureDE(casType, "tokenId", "uima.cas.Integer", featOkTst);
    casFeatCode_tokenId  = (null == casFeat_tokenId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_tokenId).getCode();

 
    casFeat_coarsePos = jcas.getRequiredFeatureDE(casType, "coarsePos", "uima.cas.String", featOkTst);
    casFeatCode_coarsePos  = (null == casFeat_coarsePos) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_coarsePos).getCode();

 
    casFeat_pos = jcas.getRequiredFeatureDE(casType, "pos", "uima.cas.String", featOkTst);
    casFeatCode_pos  = (null == casFeat_pos) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_pos).getCode();

 
    casFeat_lexicalSense = jcas.getRequiredFeatureDE(casType, "lexicalSense", "uima.cas.String", featOkTst);
    casFeatCode_lexicalSense  = (null == casFeat_lexicalSense) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_lexicalSense).getCode();

 
    casFeat_headDependencyRelations = jcas.getRequiredFeatureDE(casType, "headDependencyRelations", "uima.cas.FSList", featOkTst);
    casFeatCode_headDependencyRelations  = (null == casFeat_headDependencyRelations) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_headDependencyRelations).getCode();

 
    casFeat_childDependencyRelations = jcas.getRequiredFeatureDE(casType, "childDependencyRelations", "uima.cas.FSList", featOkTst);
    casFeatCode_childDependencyRelations  = (null == casFeat_childDependencyRelations) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_childDependencyRelations).getCode();

 
    casFeat_headSemanticRelations = jcas.getRequiredFeatureDE(casType, "headSemanticRelations", "uima.cas.FSList", featOkTst);
    casFeatCode_headSemanticRelations  = (null == casFeat_headSemanticRelations) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_headSemanticRelations).getCode();

 
    casFeat_childSemanticRelations = jcas.getRequiredFeatureDE(casType, "childSemanticRelations", "uima.cas.FSList", featOkTst);
    casFeatCode_childSemanticRelations  = (null == casFeat_childSemanticRelations) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_childSemanticRelations).getCode();

  }
}



    