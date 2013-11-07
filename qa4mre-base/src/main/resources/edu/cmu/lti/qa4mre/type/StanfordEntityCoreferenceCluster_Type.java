
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
public class StanfordEntityCoreferenceCluster_Type extends ComponentTOP_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (StanfordEntityCoreferenceCluster_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = StanfordEntityCoreferenceCluster_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new StanfordEntityCoreferenceCluster(addr, StanfordEntityCoreferenceCluster_Type.this);
  			   StanfordEntityCoreferenceCluster_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new StanfordEntityCoreferenceCluster(addr, StanfordEntityCoreferenceCluster_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = StanfordEntityCoreferenceCluster.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.qa4mre.type.StanfordEntityCoreferenceCluster");
 
  /** @generated */
  final Feature casFeat_entityCoreferenceClusterId;
  /** @generated */
  final int     casFeatCode_entityCoreferenceClusterId;
  /** @generated */ 
  public String getEntityCoreferenceClusterId(int addr) {
        if (featOkTst && casFeat_entityCoreferenceClusterId == null)
      jcas.throwFeatMissing("entityCoreferenceClusterId", "edu.cmu.lti.qa4mre.type.StanfordEntityCoreferenceCluster");
    return ll_cas.ll_getStringValue(addr, casFeatCode_entityCoreferenceClusterId);
  }
  /** @generated */    
  public void setEntityCoreferenceClusterId(int addr, String v) {
        if (featOkTst && casFeat_entityCoreferenceClusterId == null)
      jcas.throwFeatMissing("entityCoreferenceClusterId", "edu.cmu.lti.qa4mre.type.StanfordEntityCoreferenceCluster");
    ll_cas.ll_setStringValue(addr, casFeatCode_entityCoreferenceClusterId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_entityMentions;
  /** @generated */
  final int     casFeatCode_entityMentions;
  /** @generated */ 
  public int getEntityMentions(int addr) {
        if (featOkTst && casFeat_entityMentions == null)
      jcas.throwFeatMissing("entityMentions", "edu.cmu.lti.qa4mre.type.StanfordEntityCoreferenceCluster");
    return ll_cas.ll_getRefValue(addr, casFeatCode_entityMentions);
  }
  /** @generated */    
  public void setEntityMentions(int addr, int v) {
        if (featOkTst && casFeat_entityMentions == null)
      jcas.throwFeatMissing("entityMentions", "edu.cmu.lti.qa4mre.type.StanfordEntityCoreferenceCluster");
    ll_cas.ll_setRefValue(addr, casFeatCode_entityMentions, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public StanfordEntityCoreferenceCluster_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_entityCoreferenceClusterId = jcas.getRequiredFeatureDE(casType, "entityCoreferenceClusterId", "uima.cas.String", featOkTst);
    casFeatCode_entityCoreferenceClusterId  = (null == casFeat_entityCoreferenceClusterId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_entityCoreferenceClusterId).getCode();

 
    casFeat_entityMentions = jcas.getRequiredFeatureDE(casType, "entityMentions", "uima.cas.FSList", featOkTst);
    casFeatCode_entityMentions  = (null == casFeat_entityMentions) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_entityMentions).getCode();

  }
}



    