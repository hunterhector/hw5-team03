

/* First created by JCasGen Wed Nov 06 21:03:16 EST 2013 */
package edu.cmu.lti.util.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** 
 * Updated by JCasGen Wed Nov 06 21:03:16 EST 2013
 * XML source: /Users/tengda/Documents/workspace/hw5-team03/hw5-team03/qa4mre-base/src/main/resources/TypeSystemDescriptor.xml
 * @generated */
public class ComponentTOP extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(ComponentTOP.class);
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
  protected ComponentTOP() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public ComponentTOP(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public ComponentTOP(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: componentId

  /** getter for componentId - gets 
   * @generated */
  public String getComponentId() {
    if (ComponentTOP_Type.featOkTst && ((ComponentTOP_Type)jcasType).casFeat_componentId == null)
      jcasType.jcas.throwFeatMissing("componentId", "edu.cmu.lti.util.type.ComponentTOP");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ComponentTOP_Type)jcasType).casFeatCode_componentId);}
    
  /** setter for componentId - sets  
   * @generated */
  public void setComponentId(String v) {
    if (ComponentTOP_Type.featOkTst && ((ComponentTOP_Type)jcasType).casFeat_componentId == null)
      jcasType.jcas.throwFeatMissing("componentId", "edu.cmu.lti.util.type.ComponentTOP");
    jcasType.ll_cas.ll_setStringValue(addr, ((ComponentTOP_Type)jcasType).casFeatCode_componentId, v);}    
  }

    