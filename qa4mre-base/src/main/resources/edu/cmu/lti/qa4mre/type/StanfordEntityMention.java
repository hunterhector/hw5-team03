

/* First created by JCasGen Wed Nov 06 21:03:16 EST 2013 */
package edu.cmu.lti.qa4mre.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.lti.util.type.ComponentAnnotation;


/** 
 * Updated by JCasGen Wed Nov 06 21:03:16 EST 2013
 * XML source: /Users/tengda/Documents/workspace/hw5-team03/hw5-team03/qa4mre-base/src/main/resources/TypeSystemDescriptor.xml
 * @generated */
public class StanfordEntityMention extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(StanfordEntityMention.class);
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
  protected StanfordEntityMention() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public StanfordEntityMention(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public StanfordEntityMention(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public StanfordEntityMention(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: entityMentionId

  /** getter for entityMentionId - gets 
   * @generated */
  public String getEntityMentionId() {
    if (StanfordEntityMention_Type.featOkTst && ((StanfordEntityMention_Type)jcasType).casFeat_entityMentionId == null)
      jcasType.jcas.throwFeatMissing("entityMentionId", "edu.cmu.lti.qa4mre.type.StanfordEntityMention");
    return jcasType.ll_cas.ll_getStringValue(addr, ((StanfordEntityMention_Type)jcasType).casFeatCode_entityMentionId);}
    
  /** setter for entityMentionId - sets  
   * @generated */
  public void setEntityMentionId(String v) {
    if (StanfordEntityMention_Type.featOkTst && ((StanfordEntityMention_Type)jcasType).casFeat_entityMentionId == null)
      jcasType.jcas.throwFeatMissing("entityMentionId", "edu.cmu.lti.qa4mre.type.StanfordEntityMention");
    jcasType.ll_cas.ll_setStringValue(addr, ((StanfordEntityMention_Type)jcasType).casFeatCode_entityMentionId, v);}    
   
    
  //*--------------*
  //* Feature: entityCoreferenceCluster

  /** getter for entityCoreferenceCluster - gets 
   * @generated */
  public StanfordEntityCoreferenceCluster getEntityCoreferenceCluster() {
    if (StanfordEntityMention_Type.featOkTst && ((StanfordEntityMention_Type)jcasType).casFeat_entityCoreferenceCluster == null)
      jcasType.jcas.throwFeatMissing("entityCoreferenceCluster", "edu.cmu.lti.qa4mre.type.StanfordEntityMention");
    return (StanfordEntityCoreferenceCluster)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((StanfordEntityMention_Type)jcasType).casFeatCode_entityCoreferenceCluster)));}
    
  /** setter for entityCoreferenceCluster - sets  
   * @generated */
  public void setEntityCoreferenceCluster(StanfordEntityCoreferenceCluster v) {
    if (StanfordEntityMention_Type.featOkTst && ((StanfordEntityMention_Type)jcasType).casFeat_entityCoreferenceCluster == null)
      jcasType.jcas.throwFeatMissing("entityCoreferenceCluster", "edu.cmu.lti.qa4mre.type.StanfordEntityMention");
    jcasType.ll_cas.ll_setRefValue(addr, ((StanfordEntityMention_Type)jcasType).casFeatCode_entityCoreferenceCluster, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: entityType

  /** getter for entityType - gets 
   * @generated */
  public String getEntityType() {
    if (StanfordEntityMention_Type.featOkTst && ((StanfordEntityMention_Type)jcasType).casFeat_entityType == null)
      jcasType.jcas.throwFeatMissing("entityType", "edu.cmu.lti.qa4mre.type.StanfordEntityMention");
    return jcasType.ll_cas.ll_getStringValue(addr, ((StanfordEntityMention_Type)jcasType).casFeatCode_entityType);}
    
  /** setter for entityType - sets  
   * @generated */
  public void setEntityType(String v) {
    if (StanfordEntityMention_Type.featOkTst && ((StanfordEntityMention_Type)jcasType).casFeat_entityType == null)
      jcasType.jcas.throwFeatMissing("entityType", "edu.cmu.lti.qa4mre.type.StanfordEntityMention");
    jcasType.ll_cas.ll_setStringValue(addr, ((StanfordEntityMention_Type)jcasType).casFeatCode_entityType, v);}    
  }

    