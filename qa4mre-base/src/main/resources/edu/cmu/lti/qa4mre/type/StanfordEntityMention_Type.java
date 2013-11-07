
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
public class StanfordEntityMention_Type extends ComponentAnnotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (StanfordEntityMention_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = StanfordEntityMention_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new StanfordEntityMention(addr, StanfordEntityMention_Type.this);
  			   StanfordEntityMention_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new StanfordEntityMention(addr, StanfordEntityMention_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = StanfordEntityMention.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.qa4mre.type.StanfordEntityMention");
 
  /** @generated */
  final Feature casFeat_entityMentionId;
  /** @generated */
  final int     casFeatCode_entityMentionId;
  /** @generated */ 
  public String getEntityMentionId(int addr) {
        if (featOkTst && casFeat_entityMentionId == null)
      jcas.throwFeatMissing("entityMentionId", "edu.cmu.lti.qa4mre.type.StanfordEntityMention");
    return ll_cas.ll_getStringValue(addr, casFeatCode_entityMentionId);
  }
  /** @generated */    
  public void setEntityMentionId(int addr, String v) {
        if (featOkTst && casFeat_entityMentionId == null)
      jcas.throwFeatMissing("entityMentionId", "edu.cmu.lti.qa4mre.type.StanfordEntityMention");
    ll_cas.ll_setStringValue(addr, casFeatCode_entityMentionId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_entityCoreferenceCluster;
  /** @generated */
  final int     casFeatCode_entityCoreferenceCluster;
  /** @generated */ 
  public int getEntityCoreferenceCluster(int addr) {
        if (featOkTst && casFeat_entityCoreferenceCluster == null)
      jcas.throwFeatMissing("entityCoreferenceCluster", "edu.cmu.lti.qa4mre.type.StanfordEntityMention");
    return ll_cas.ll_getRefValue(addr, casFeatCode_entityCoreferenceCluster);
  }
  /** @generated */    
  public void setEntityCoreferenceCluster(int addr, int v) {
        if (featOkTst && casFeat_entityCoreferenceCluster == null)
      jcas.throwFeatMissing("entityCoreferenceCluster", "edu.cmu.lti.qa4mre.type.StanfordEntityMention");
    ll_cas.ll_setRefValue(addr, casFeatCode_entityCoreferenceCluster, v);}
    
  
 
  /** @generated */
  final Feature casFeat_entityType;
  /** @generated */
  final int     casFeatCode_entityType;
  /** @generated */ 
  public String getEntityType(int addr) {
        if (featOkTst && casFeat_entityType == null)
      jcas.throwFeatMissing("entityType", "edu.cmu.lti.qa4mre.type.StanfordEntityMention");
    return ll_cas.ll_getStringValue(addr, casFeatCode_entityType);
  }
  /** @generated */    
  public void setEntityType(int addr, String v) {
        if (featOkTst && casFeat_entityType == null)
      jcas.throwFeatMissing("entityType", "edu.cmu.lti.qa4mre.type.StanfordEntityMention");
    ll_cas.ll_setStringValue(addr, casFeatCode_entityType, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public StanfordEntityMention_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_entityMentionId = jcas.getRequiredFeatureDE(casType, "entityMentionId", "uima.cas.String", featOkTst);
    casFeatCode_entityMentionId  = (null == casFeat_entityMentionId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_entityMentionId).getCode();

 
    casFeat_entityCoreferenceCluster = jcas.getRequiredFeatureDE(casType, "entityCoreferenceCluster", "edu.cmu.lti.qa4mre.type.StanfordEntityCoreferenceCluster", featOkTst);
    casFeatCode_entityCoreferenceCluster  = (null == casFeat_entityCoreferenceCluster) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_entityCoreferenceCluster).getCode();

 
    casFeat_entityType = jcas.getRequiredFeatureDE(casType, "entityType", "uima.cas.String", featOkTst);
    casFeatCode_entityType  = (null == casFeat_entityType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_entityType).getCode();

  }
}



    