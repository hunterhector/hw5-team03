

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
public class SemaforLabel extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(SemaforLabel.class);
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
  protected SemaforLabel() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public SemaforLabel(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public SemaforLabel(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public SemaforLabel(JCas jcas, int begin, int end) {
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
    if (SemaforLabel_Type.featOkTst && ((SemaforLabel_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.cmu.lti.qa4mre.type.SemaforLabel");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SemaforLabel_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets  
   * @generated */
  public void setName(String v) {
    if (SemaforLabel_Type.featOkTst && ((SemaforLabel_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.cmu.lti.qa4mre.type.SemaforLabel");
    jcasType.ll_cas.ll_setStringValue(addr, ((SemaforLabel_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: ID

  /** getter for ID - gets 
   * @generated */
  public int getID() {
    if (SemaforLabel_Type.featOkTst && ((SemaforLabel_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "edu.cmu.lti.qa4mre.type.SemaforLabel");
    return jcasType.ll_cas.ll_getIntValue(addr, ((SemaforLabel_Type)jcasType).casFeatCode_ID);}
    
  /** setter for ID - sets  
   * @generated */
  public void setID(int v) {
    if (SemaforLabel_Type.featOkTst && ((SemaforLabel_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "edu.cmu.lti.qa4mre.type.SemaforLabel");
    jcasType.ll_cas.ll_setIntValue(addr, ((SemaforLabel_Type)jcasType).casFeatCode_ID, v);}    
  }

    