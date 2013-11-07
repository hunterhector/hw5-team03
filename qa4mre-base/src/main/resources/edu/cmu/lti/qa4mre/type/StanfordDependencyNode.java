

/* First created by JCasGen Wed Nov 06 21:03:16 EST 2013 */
package edu.cmu.lti.qa4mre.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.lti.util.type.ComponentAnnotation;
import org.apache.uima.jcas.cas.FSList;


/** 
 * Updated by JCasGen Wed Nov 06 21:03:16 EST 2013
 * XML source: /Users/tengda/Documents/workspace/hw5-team03/hw5-team03/qa4mre-base/src/main/resources/TypeSystemDescriptor.xml
 * @generated */
public class StanfordDependencyNode extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(StanfordDependencyNode.class);
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
  protected StanfordDependencyNode() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public StanfordDependencyNode(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public StanfordDependencyNode(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public StanfordDependencyNode(JCas jcas, int begin, int end) {
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
  //* Feature: headRelations

  /** getter for headRelations - gets 
   * @generated */
  public FSList getHeadRelations() {
    if (StanfordDependencyNode_Type.featOkTst && ((StanfordDependencyNode_Type)jcasType).casFeat_headRelations == null)
      jcasType.jcas.throwFeatMissing("headRelations", "edu.cmu.lti.qa4mre.type.StanfordDependencyNode");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((StanfordDependencyNode_Type)jcasType).casFeatCode_headRelations)));}
    
  /** setter for headRelations - sets  
   * @generated */
  public void setHeadRelations(FSList v) {
    if (StanfordDependencyNode_Type.featOkTst && ((StanfordDependencyNode_Type)jcasType).casFeat_headRelations == null)
      jcasType.jcas.throwFeatMissing("headRelations", "edu.cmu.lti.qa4mre.type.StanfordDependencyNode");
    jcasType.ll_cas.ll_setRefValue(addr, ((StanfordDependencyNode_Type)jcasType).casFeatCode_headRelations, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: childRelations

  /** getter for childRelations - gets 
   * @generated */
  public FSList getChildRelations() {
    if (StanfordDependencyNode_Type.featOkTst && ((StanfordDependencyNode_Type)jcasType).casFeat_childRelations == null)
      jcasType.jcas.throwFeatMissing("childRelations", "edu.cmu.lti.qa4mre.type.StanfordDependencyNode");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((StanfordDependencyNode_Type)jcasType).casFeatCode_childRelations)));}
    
  /** setter for childRelations - sets  
   * @generated */
  public void setChildRelations(FSList v) {
    if (StanfordDependencyNode_Type.featOkTst && ((StanfordDependencyNode_Type)jcasType).casFeat_childRelations == null)
      jcasType.jcas.throwFeatMissing("childRelations", "edu.cmu.lti.qa4mre.type.StanfordDependencyNode");
    jcasType.ll_cas.ll_setRefValue(addr, ((StanfordDependencyNode_Type)jcasType).casFeatCode_childRelations, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: token

  /** getter for token - gets Link to the token annotation that this Dependency node associate with.
   * @generated */
  public StanfordCorenlpToken getToken() {
    if (StanfordDependencyNode_Type.featOkTst && ((StanfordDependencyNode_Type)jcasType).casFeat_token == null)
      jcasType.jcas.throwFeatMissing("token", "edu.cmu.lti.qa4mre.type.StanfordDependencyNode");
    return (StanfordCorenlpToken)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((StanfordDependencyNode_Type)jcasType).casFeatCode_token)));}
    
  /** setter for token - sets Link to the token annotation that this Dependency node associate with. 
   * @generated */
  public void setToken(StanfordCorenlpToken v) {
    if (StanfordDependencyNode_Type.featOkTst && ((StanfordDependencyNode_Type)jcasType).casFeat_token == null)
      jcasType.jcas.throwFeatMissing("token", "edu.cmu.lti.qa4mre.type.StanfordDependencyNode");
    jcasType.ll_cas.ll_setRefValue(addr, ((StanfordDependencyNode_Type)jcasType).casFeatCode_token, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    