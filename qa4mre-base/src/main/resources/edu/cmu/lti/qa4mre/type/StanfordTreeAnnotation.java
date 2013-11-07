

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
public class StanfordTreeAnnotation extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(StanfordTreeAnnotation.class);
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
  protected StanfordTreeAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public StanfordTreeAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public StanfordTreeAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public StanfordTreeAnnotation(JCas jcas, int begin, int end) {
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
  //* Feature: pennTreeLabel

  /** getter for pennTreeLabel - gets 
   * @generated */
  public String getPennTreeLabel() {
    if (StanfordTreeAnnotation_Type.featOkTst && ((StanfordTreeAnnotation_Type)jcasType).casFeat_pennTreeLabel == null)
      jcasType.jcas.throwFeatMissing("pennTreeLabel", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((StanfordTreeAnnotation_Type)jcasType).casFeatCode_pennTreeLabel);}
    
  /** setter for pennTreeLabel - sets  
   * @generated */
  public void setPennTreeLabel(String v) {
    if (StanfordTreeAnnotation_Type.featOkTst && ((StanfordTreeAnnotation_Type)jcasType).casFeat_pennTreeLabel == null)
      jcasType.jcas.throwFeatMissing("pennTreeLabel", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((StanfordTreeAnnotation_Type)jcasType).casFeatCode_pennTreeLabel, v);}    
   
    
  //*--------------*
  //* Feature: children

  /** getter for children - gets 
   * @generated */
  public FSList getChildren() {
    if (StanfordTreeAnnotation_Type.featOkTst && ((StanfordTreeAnnotation_Type)jcasType).casFeat_children == null)
      jcasType.jcas.throwFeatMissing("children", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((StanfordTreeAnnotation_Type)jcasType).casFeatCode_children)));}
    
  /** setter for children - sets  
   * @generated */
  public void setChildren(FSList v) {
    if (StanfordTreeAnnotation_Type.featOkTst && ((StanfordTreeAnnotation_Type)jcasType).casFeat_children == null)
      jcasType.jcas.throwFeatMissing("children", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    jcasType.ll_cas.ll_setRefValue(addr, ((StanfordTreeAnnotation_Type)jcasType).casFeatCode_children, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: isLeaf

  /** getter for isLeaf - gets 
   * @generated */
  public boolean getIsLeaf() {
    if (StanfordTreeAnnotation_Type.featOkTst && ((StanfordTreeAnnotation_Type)jcasType).casFeat_isLeaf == null)
      jcasType.jcas.throwFeatMissing("isLeaf", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((StanfordTreeAnnotation_Type)jcasType).casFeatCode_isLeaf);}
    
  /** setter for isLeaf - sets  
   * @generated */
  public void setIsLeaf(boolean v) {
    if (StanfordTreeAnnotation_Type.featOkTst && ((StanfordTreeAnnotation_Type)jcasType).casFeat_isLeaf == null)
      jcasType.jcas.throwFeatMissing("isLeaf", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((StanfordTreeAnnotation_Type)jcasType).casFeatCode_isLeaf, v);}    
   
    
  //*--------------*
  //* Feature: isRoot

  /** getter for isRoot - gets 
   * @generated */
  public boolean getIsRoot() {
    if (StanfordTreeAnnotation_Type.featOkTst && ((StanfordTreeAnnotation_Type)jcasType).casFeat_isRoot == null)
      jcasType.jcas.throwFeatMissing("isRoot", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((StanfordTreeAnnotation_Type)jcasType).casFeatCode_isRoot);}
    
  /** setter for isRoot - sets  
   * @generated */
  public void setIsRoot(boolean v) {
    if (StanfordTreeAnnotation_Type.featOkTst && ((StanfordTreeAnnotation_Type)jcasType).casFeat_isRoot == null)
      jcasType.jcas.throwFeatMissing("isRoot", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((StanfordTreeAnnotation_Type)jcasType).casFeatCode_isRoot, v);}    
   
    
  //*--------------*
  //* Feature: parent

  /** getter for parent - gets 
   * @generated */
  public StanfordTreeAnnotation getParent() {
    if (StanfordTreeAnnotation_Type.featOkTst && ((StanfordTreeAnnotation_Type)jcasType).casFeat_parent == null)
      jcasType.jcas.throwFeatMissing("parent", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    return (StanfordTreeAnnotation)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((StanfordTreeAnnotation_Type)jcasType).casFeatCode_parent)));}
    
  /** setter for parent - sets  
   * @generated */
  public void setParent(StanfordTreeAnnotation v) {
    if (StanfordTreeAnnotation_Type.featOkTst && ((StanfordTreeAnnotation_Type)jcasType).casFeat_parent == null)
      jcasType.jcas.throwFeatMissing("parent", "edu.cmu.lti.qa4mre.type.StanfordTreeAnnotation");
    jcasType.ll_cas.ll_setRefValue(addr, ((StanfordTreeAnnotation_Type)jcasType).casFeatCode_parent, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    