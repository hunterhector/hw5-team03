

/* First created by JCasGen Wed Nov 06 21:03:16 EST 2013 */
package edu.cmu.lti.qa4mre.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.lti.util.type.ComponentTOP;
import org.apache.uima.jcas.cas.FSList;


/** 
 * Updated by JCasGen Wed Nov 06 21:03:16 EST 2013
 * XML source: /Users/tengda/Documents/workspace/hw5-team03/hw5-team03/qa4mre-base/src/main/resources/TypeSystemDescriptor.xml
 * @generated */
public class StanfordEntityCoreferenceCluster extends ComponentTOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(StanfordEntityCoreferenceCluster.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected StanfordEntityCoreferenceCluster() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public StanfordEntityCoreferenceCluster(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public StanfordEntityCoreferenceCluster(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: entityCoreferenceClusterId

  /** getter for entityCoreferenceClusterId - gets 
   * @generated */
  public String getEntityCoreferenceClusterId() {
    if (StanfordEntityCoreferenceCluster_Type.featOkTst && ((StanfordEntityCoreferenceCluster_Type)jcasType).casFeat_entityCoreferenceClusterId == null)
      jcasType.jcas.throwFeatMissing("entityCoreferenceClusterId", "edu.cmu.lti.qa4mre.type.StanfordEntityCoreferenceCluster");
    return jcasType.ll_cas.ll_getStringValue(addr, ((StanfordEntityCoreferenceCluster_Type)jcasType).casFeatCode_entityCoreferenceClusterId);}
    
  /** setter for entityCoreferenceClusterId - sets  
   * @generated */
  public void setEntityCoreferenceClusterId(String v) {
    if (StanfordEntityCoreferenceCluster_Type.featOkTst && ((StanfordEntityCoreferenceCluster_Type)jcasType).casFeat_entityCoreferenceClusterId == null)
      jcasType.jcas.throwFeatMissing("entityCoreferenceClusterId", "edu.cmu.lti.qa4mre.type.StanfordEntityCoreferenceCluster");
    jcasType.ll_cas.ll_setStringValue(addr, ((StanfordEntityCoreferenceCluster_Type)jcasType).casFeatCode_entityCoreferenceClusterId, v);}    
   
    
  //*--------------*
  //* Feature: entityMentions

  /** getter for entityMentions - gets 
   * @generated */
  public FSList getEntityMentions() {
    if (StanfordEntityCoreferenceCluster_Type.featOkTst && ((StanfordEntityCoreferenceCluster_Type)jcasType).casFeat_entityMentions == null)
      jcasType.jcas.throwFeatMissing("entityMentions", "edu.cmu.lti.qa4mre.type.StanfordEntityCoreferenceCluster");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((StanfordEntityCoreferenceCluster_Type)jcasType).casFeatCode_entityMentions)));}
    
  /** setter for entityMentions - sets  
   * @generated */
  public void setEntityMentions(FSList v) {
    if (StanfordEntityCoreferenceCluster_Type.featOkTst && ((StanfordEntityCoreferenceCluster_Type)jcasType).casFeat_entityMentions == null)
      jcasType.jcas.throwFeatMissing("entityMentions", "edu.cmu.lti.qa4mre.type.StanfordEntityCoreferenceCluster");
    jcasType.ll_cas.ll_setRefValue(addr, ((StanfordEntityCoreferenceCluster_Type)jcasType).casFeatCode_entityMentions, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    