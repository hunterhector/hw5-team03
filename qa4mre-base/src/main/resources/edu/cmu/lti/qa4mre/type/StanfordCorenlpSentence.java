

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
public class StanfordCorenlpSentence extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(StanfordCorenlpSentence.class);
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
  protected StanfordCorenlpSentence() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public StanfordCorenlpSentence(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public StanfordCorenlpSentence(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public StanfordCorenlpSentence(JCas jcas, int begin, int end) {
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
  //* Feature: sentenceId

  /** getter for sentenceId - gets 
   * @generated */
  public int getSentenceId() {
    if (StanfordCorenlpSentence_Type.featOkTst && ((StanfordCorenlpSentence_Type)jcasType).casFeat_sentenceId == null)
      jcasType.jcas.throwFeatMissing("sentenceId", "edu.cmu.lti.qa4mre.type.StanfordCorenlpSentence");
    return jcasType.ll_cas.ll_getIntValue(addr, ((StanfordCorenlpSentence_Type)jcasType).casFeatCode_sentenceId);}
    
  /** setter for sentenceId - sets  
   * @generated */
  public void setSentenceId(int v) {
    if (StanfordCorenlpSentence_Type.featOkTst && ((StanfordCorenlpSentence_Type)jcasType).casFeat_sentenceId == null)
      jcasType.jcas.throwFeatMissing("sentenceId", "edu.cmu.lti.qa4mre.type.StanfordCorenlpSentence");
    jcasType.ll_cas.ll_setIntValue(addr, ((StanfordCorenlpSentence_Type)jcasType).casFeatCode_sentenceId, v);}    
  }

    