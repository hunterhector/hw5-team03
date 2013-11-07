

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
public class SemaforAnnotationSet extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(SemaforAnnotationSet.class);
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
  protected SemaforAnnotationSet() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public SemaforAnnotationSet(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public SemaforAnnotationSet(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public SemaforAnnotationSet(JCas jcas, int begin, int end) {
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
  //* Feature: layers

  /** getter for layers - gets 
   * @generated */
  public FSArray getLayers() {
    if (SemaforAnnotationSet_Type.featOkTst && ((SemaforAnnotationSet_Type)jcasType).casFeat_layers == null)
      jcasType.jcas.throwFeatMissing("layers", "edu.cmu.lti.qa4mre.type.SemaforAnnotationSet");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((SemaforAnnotationSet_Type)jcasType).casFeatCode_layers)));}
    
  /** setter for layers - sets  
   * @generated */
  public void setLayers(FSArray v) {
    if (SemaforAnnotationSet_Type.featOkTst && ((SemaforAnnotationSet_Type)jcasType).casFeat_layers == null)
      jcasType.jcas.throwFeatMissing("layers", "edu.cmu.lti.qa4mre.type.SemaforAnnotationSet");
    jcasType.ll_cas.ll_setRefValue(addr, ((SemaforAnnotationSet_Type)jcasType).casFeatCode_layers, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for layers - gets an indexed value - 
   * @generated */
  public SemaforLayer getLayers(int i) {
    if (SemaforAnnotationSet_Type.featOkTst && ((SemaforAnnotationSet_Type)jcasType).casFeat_layers == null)
      jcasType.jcas.throwFeatMissing("layers", "edu.cmu.lti.qa4mre.type.SemaforAnnotationSet");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((SemaforAnnotationSet_Type)jcasType).casFeatCode_layers), i);
    return (SemaforLayer)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((SemaforAnnotationSet_Type)jcasType).casFeatCode_layers), i)));}

  /** indexed setter for layers - sets an indexed value - 
   * @generated */
  public void setLayers(int i, SemaforLayer v) { 
    if (SemaforAnnotationSet_Type.featOkTst && ((SemaforAnnotationSet_Type)jcasType).casFeat_layers == null)
      jcasType.jcas.throwFeatMissing("layers", "edu.cmu.lti.qa4mre.type.SemaforAnnotationSet");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((SemaforAnnotationSet_Type)jcasType).casFeatCode_layers), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((SemaforAnnotationSet_Type)jcasType).casFeatCode_layers), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: frameName

  /** getter for frameName - gets 
   * @generated */
  public String getFrameName() {
    if (SemaforAnnotationSet_Type.featOkTst && ((SemaforAnnotationSet_Type)jcasType).casFeat_frameName == null)
      jcasType.jcas.throwFeatMissing("frameName", "edu.cmu.lti.qa4mre.type.SemaforAnnotationSet");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SemaforAnnotationSet_Type)jcasType).casFeatCode_frameName);}
    
  /** setter for frameName - sets  
   * @generated */
  public void setFrameName(String v) {
    if (SemaforAnnotationSet_Type.featOkTst && ((SemaforAnnotationSet_Type)jcasType).casFeat_frameName == null)
      jcasType.jcas.throwFeatMissing("frameName", "edu.cmu.lti.qa4mre.type.SemaforAnnotationSet");
    jcasType.ll_cas.ll_setStringValue(addr, ((SemaforAnnotationSet_Type)jcasType).casFeatCode_frameName, v);}    
   
    
  //*--------------*
  //* Feature: ID

  /** getter for ID - gets 
   * @generated */
  public int getID() {
    if (SemaforAnnotationSet_Type.featOkTst && ((SemaforAnnotationSet_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "edu.cmu.lti.qa4mre.type.SemaforAnnotationSet");
    return jcasType.ll_cas.ll_getIntValue(addr, ((SemaforAnnotationSet_Type)jcasType).casFeatCode_ID);}
    
  /** setter for ID - sets  
   * @generated */
  public void setID(int v) {
    if (SemaforAnnotationSet_Type.featOkTst && ((SemaforAnnotationSet_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "edu.cmu.lti.qa4mre.type.SemaforAnnotationSet");
    jcasType.ll_cas.ll_setIntValue(addr, ((SemaforAnnotationSet_Type)jcasType).casFeatCode_ID, v);}    
  }

    