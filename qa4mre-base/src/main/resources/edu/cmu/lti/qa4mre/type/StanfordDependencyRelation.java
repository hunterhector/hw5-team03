

/* First created by JCasGen Wed Nov 06 21:03:16 EST 2013 */
package edu.cmu.lti.qa4mre.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.lti.util.type.ComponentTOP;


/** 
 * Updated by JCasGen Wed Nov 06 21:03:16 EST 2013
 * XML source: /Users/tengda/Documents/workspace/hw5-team03/hw5-team03/qa4mre-base/src/main/resources/TypeSystemDescriptor.xml
 * @generated */
public class StanfordDependencyRelation extends ComponentTOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(StanfordDependencyRelation.class);
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
  protected StanfordDependencyRelation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public StanfordDependencyRelation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public StanfordDependencyRelation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: head

  /** getter for head - gets 
   * @generated */
  public StanfordDependencyNode getHead() {
    if (StanfordDependencyRelation_Type.featOkTst && ((StanfordDependencyRelation_Type)jcasType).casFeat_head == null)
      jcasType.jcas.throwFeatMissing("head", "edu.cmu.lti.qa4mre.type.StanfordDependencyRelation");
    return (StanfordDependencyNode)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((StanfordDependencyRelation_Type)jcasType).casFeatCode_head)));}
    
  /** setter for head - sets  
   * @generated */
  public void setHead(StanfordDependencyNode v) {
    if (StanfordDependencyRelation_Type.featOkTst && ((StanfordDependencyRelation_Type)jcasType).casFeat_head == null)
      jcasType.jcas.throwFeatMissing("head", "edu.cmu.lti.qa4mre.type.StanfordDependencyRelation");
    jcasType.ll_cas.ll_setRefValue(addr, ((StanfordDependencyRelation_Type)jcasType).casFeatCode_head, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: child

  /** getter for child - gets 
   * @generated */
  public StanfordDependencyNode getChild() {
    if (StanfordDependencyRelation_Type.featOkTst && ((StanfordDependencyRelation_Type)jcasType).casFeat_child == null)
      jcasType.jcas.throwFeatMissing("child", "edu.cmu.lti.qa4mre.type.StanfordDependencyRelation");
    return (StanfordDependencyNode)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((StanfordDependencyRelation_Type)jcasType).casFeatCode_child)));}
    
  /** setter for child - sets  
   * @generated */
  public void setChild(StanfordDependencyNode v) {
    if (StanfordDependencyRelation_Type.featOkTst && ((StanfordDependencyRelation_Type)jcasType).casFeat_child == null)
      jcasType.jcas.throwFeatMissing("child", "edu.cmu.lti.qa4mre.type.StanfordDependencyRelation");
    jcasType.ll_cas.ll_setRefValue(addr, ((StanfordDependencyRelation_Type)jcasType).casFeatCode_child, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: relationType

  /** getter for relationType - gets 
   * @generated */
  public String getRelationType() {
    if (StanfordDependencyRelation_Type.featOkTst && ((StanfordDependencyRelation_Type)jcasType).casFeat_relationType == null)
      jcasType.jcas.throwFeatMissing("relationType", "edu.cmu.lti.qa4mre.type.StanfordDependencyRelation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((StanfordDependencyRelation_Type)jcasType).casFeatCode_relationType);}
    
  /** setter for relationType - sets  
   * @generated */
  public void setRelationType(String v) {
    if (StanfordDependencyRelation_Type.featOkTst && ((StanfordDependencyRelation_Type)jcasType).casFeat_relationType == null)
      jcasType.jcas.throwFeatMissing("relationType", "edu.cmu.lti.qa4mre.type.StanfordDependencyRelation");
    jcasType.ll_cas.ll_setStringValue(addr, ((StanfordDependencyRelation_Type)jcasType).casFeatCode_relationType, v);}    
   
    
  //*--------------*
  //* Feature: weight

  /** getter for weight - gets 
   * @generated */
  public double getWeight() {
    if (StanfordDependencyRelation_Type.featOkTst && ((StanfordDependencyRelation_Type)jcasType).casFeat_weight == null)
      jcasType.jcas.throwFeatMissing("weight", "edu.cmu.lti.qa4mre.type.StanfordDependencyRelation");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((StanfordDependencyRelation_Type)jcasType).casFeatCode_weight);}
    
  /** setter for weight - sets  
   * @generated */
  public void setWeight(double v) {
    if (StanfordDependencyRelation_Type.featOkTst && ((StanfordDependencyRelation_Type)jcasType).casFeat_weight == null)
      jcasType.jcas.throwFeatMissing("weight", "edu.cmu.lti.qa4mre.type.StanfordDependencyRelation");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((StanfordDependencyRelation_Type)jcasType).casFeatCode_weight, v);}    
  }

    