

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
public class OpennlpChunk extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(OpennlpChunk.class);
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
  protected OpennlpChunk() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public OpennlpChunk(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public OpennlpChunk(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public OpennlpChunk(JCas jcas, int begin, int end) {
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
  //* Feature: tag

  /** getter for tag - gets 
   * @generated */
  public String getTag() {
    if (OpennlpChunk_Type.featOkTst && ((OpennlpChunk_Type)jcasType).casFeat_tag == null)
      jcasType.jcas.throwFeatMissing("tag", "edu.cmu.lti.qa4mre.type.OpennlpChunk");
    return jcasType.ll_cas.ll_getStringValue(addr, ((OpennlpChunk_Type)jcasType).casFeatCode_tag);}
    
  /** setter for tag - sets  
   * @generated */
  public void setTag(String v) {
    if (OpennlpChunk_Type.featOkTst && ((OpennlpChunk_Type)jcasType).casFeat_tag == null)
      jcasType.jcas.throwFeatMissing("tag", "edu.cmu.lti.qa4mre.type.OpennlpChunk");
    jcasType.ll_cas.ll_setStringValue(addr, ((OpennlpChunk_Type)jcasType).casFeatCode_tag, v);}    
  }

    