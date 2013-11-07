

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
public class StanfordCorenlpToken extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(StanfordCorenlpToken.class);
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
  protected StanfordCorenlpToken() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public StanfordCorenlpToken(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public StanfordCorenlpToken(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public StanfordCorenlpToken(JCas jcas, int begin, int end) {
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
  //* Feature: tokenId

  /** getter for tokenId - gets 
   * @generated */
  public int getTokenId() {
    if (StanfordCorenlpToken_Type.featOkTst && ((StanfordCorenlpToken_Type)jcasType).casFeat_tokenId == null)
      jcasType.jcas.throwFeatMissing("tokenId", "edu.cmu.lti.qa4mre.type.StanfordCorenlpToken");
    return jcasType.ll_cas.ll_getIntValue(addr, ((StanfordCorenlpToken_Type)jcasType).casFeatCode_tokenId);}
    
  /** setter for tokenId - sets  
   * @generated */
  public void setTokenId(int v) {
    if (StanfordCorenlpToken_Type.featOkTst && ((StanfordCorenlpToken_Type)jcasType).casFeat_tokenId == null)
      jcasType.jcas.throwFeatMissing("tokenId", "edu.cmu.lti.qa4mre.type.StanfordCorenlpToken");
    jcasType.ll_cas.ll_setIntValue(addr, ((StanfordCorenlpToken_Type)jcasType).casFeatCode_tokenId, v);}    
   
    
  //*--------------*
  //* Feature: pos

  /** getter for pos - gets 
   * @generated */
  public String getPos() {
    if (StanfordCorenlpToken_Type.featOkTst && ((StanfordCorenlpToken_Type)jcasType).casFeat_pos == null)
      jcasType.jcas.throwFeatMissing("pos", "edu.cmu.lti.qa4mre.type.StanfordCorenlpToken");
    return jcasType.ll_cas.ll_getStringValue(addr, ((StanfordCorenlpToken_Type)jcasType).casFeatCode_pos);}
    
  /** setter for pos - sets  
   * @generated */
  public void setPos(String v) {
    if (StanfordCorenlpToken_Type.featOkTst && ((StanfordCorenlpToken_Type)jcasType).casFeat_pos == null)
      jcasType.jcas.throwFeatMissing("pos", "edu.cmu.lti.qa4mre.type.StanfordCorenlpToken");
    jcasType.ll_cas.ll_setStringValue(addr, ((StanfordCorenlpToken_Type)jcasType).casFeatCode_pos, v);}    
   
    
  //*--------------*
  //* Feature: lemma

  /** getter for lemma - gets 
   * @generated */
  public String getLemma() {
    if (StanfordCorenlpToken_Type.featOkTst && ((StanfordCorenlpToken_Type)jcasType).casFeat_lemma == null)
      jcasType.jcas.throwFeatMissing("lemma", "edu.cmu.lti.qa4mre.type.StanfordCorenlpToken");
    return jcasType.ll_cas.ll_getStringValue(addr, ((StanfordCorenlpToken_Type)jcasType).casFeatCode_lemma);}
    
  /** setter for lemma - sets  
   * @generated */
  public void setLemma(String v) {
    if (StanfordCorenlpToken_Type.featOkTst && ((StanfordCorenlpToken_Type)jcasType).casFeat_lemma == null)
      jcasType.jcas.throwFeatMissing("lemma", "edu.cmu.lti.qa4mre.type.StanfordCorenlpToken");
    jcasType.ll_cas.ll_setStringValue(addr, ((StanfordCorenlpToken_Type)jcasType).casFeatCode_lemma, v);}    
  }

    