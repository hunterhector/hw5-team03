

/* First created by JCasGen Wed Nov 06 21:03:16 EST 2013 */
package edu.cmu.lti.qa4mre.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import edu.cmu.lti.util.type.ComponentAnnotation;


/** 
 * Updated by JCasGen Wed Nov 06 21:03:16 EST 2013
 * XML source: /Users/tengda/Documents/workspace/hw5-team03/hw5-team03/qa4mre-base/src/main/resources/TypeSystemDescriptor.xml
 * @generated */
public class SemaforLayer extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(SemaforLayer.class);
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
  protected SemaforLayer() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public SemaforLayer(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public SemaforLayer(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public SemaforLayer(JCas jcas, int begin, int end) {
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
  //* Feature: name

  /** getter for name - gets 
   * @generated */
  public String getName() {
    if (SemaforLayer_Type.featOkTst && ((SemaforLayer_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SemaforLayer_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets  
   * @generated */
  public void setName(String v) {
    if (SemaforLayer_Type.featOkTst && ((SemaforLayer_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    jcasType.ll_cas.ll_setStringValue(addr, ((SemaforLayer_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: labels

  /** getter for labels - gets 
   * @generated */
  public FSArray getLabels() {
    if (SemaforLayer_Type.featOkTst && ((SemaforLayer_Type)jcasType).casFeat_labels == null)
      jcasType.jcas.throwFeatMissing("labels", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((SemaforLayer_Type)jcasType).casFeatCode_labels)));}
    
  /** setter for labels - sets  
   * @generated */
  public void setLabels(FSArray v) {
    if (SemaforLayer_Type.featOkTst && ((SemaforLayer_Type)jcasType).casFeat_labels == null)
      jcasType.jcas.throwFeatMissing("labels", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    jcasType.ll_cas.ll_setRefValue(addr, ((SemaforLayer_Type)jcasType).casFeatCode_labels, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for labels - gets an indexed value - 
   * @generated */
  public SemaforLabel getLabels(int i) {
    if (SemaforLayer_Type.featOkTst && ((SemaforLayer_Type)jcasType).casFeat_labels == null)
      jcasType.jcas.throwFeatMissing("labels", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((SemaforLayer_Type)jcasType).casFeatCode_labels), i);
    return (SemaforLabel)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((SemaforLayer_Type)jcasType).casFeatCode_labels), i)));}

  /** indexed setter for labels - sets an indexed value - 
   * @generated */
  public void setLabels(int i, SemaforLabel v) { 
    if (SemaforLayer_Type.featOkTst && ((SemaforLayer_Type)jcasType).casFeat_labels == null)
      jcasType.jcas.throwFeatMissing("labels", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((SemaforLayer_Type)jcasType).casFeatCode_labels), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((SemaforLayer_Type)jcasType).casFeatCode_labels), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: ID

  /** getter for ID - gets 
   * @generated */
  public int getID() {
    if (SemaforLayer_Type.featOkTst && ((SemaforLayer_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    return jcasType.ll_cas.ll_getIntValue(addr, ((SemaforLayer_Type)jcasType).casFeatCode_ID);}
    
  /** setter for ID - sets  
   * @generated */
  public void setID(int v) {
    if (SemaforLayer_Type.featOkTst && ((SemaforLayer_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    jcasType.ll_cas.ll_setIntValue(addr, ((SemaforLayer_Type)jcasType).casFeatCode_ID, v);}    
   
    
  //*--------------*
  //* Feature: rank

  /** getter for rank - gets 
   * @generated */
  public int getRank() {
    if (SemaforLayer_Type.featOkTst && ((SemaforLayer_Type)jcasType).casFeat_rank == null)
      jcasType.jcas.throwFeatMissing("rank", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    return jcasType.ll_cas.ll_getIntValue(addr, ((SemaforLayer_Type)jcasType).casFeatCode_rank);}
    
  /** setter for rank - sets  
   * @generated */
  public void setRank(int v) {
    if (SemaforLayer_Type.featOkTst && ((SemaforLayer_Type)jcasType).casFeat_rank == null)
      jcasType.jcas.throwFeatMissing("rank", "edu.cmu.lti.qa4mre.type.SemaforLayer");
    jcasType.ll_cas.ll_setIntValue(addr, ((SemaforLayer_Type)jcasType).casFeatCode_rank, v);}    
  }

    