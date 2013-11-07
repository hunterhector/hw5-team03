

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
public class FanseToken extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(FanseToken.class);
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
  protected FanseToken() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public FanseToken(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public FanseToken(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public FanseToken(JCas jcas, int begin, int end) {
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
    if (FanseToken_Type.featOkTst && ((FanseToken_Type)jcasType).casFeat_tokenId == null)
      jcasType.jcas.throwFeatMissing("tokenId", "edu.cmu.lti.qa4mre.type.FanseToken");
    return jcasType.ll_cas.ll_getIntValue(addr, ((FanseToken_Type)jcasType).casFeatCode_tokenId);}
    
  /** setter for tokenId - sets  
   * @generated */
  public void setTokenId(int v) {
    if (FanseToken_Type.featOkTst && ((FanseToken_Type)jcasType).casFeat_tokenId == null)
      jcasType.jcas.throwFeatMissing("tokenId", "edu.cmu.lti.qa4mre.type.FanseToken");
    jcasType.ll_cas.ll_setIntValue(addr, ((FanseToken_Type)jcasType).casFeatCode_tokenId, v);}    
   
    
  //*--------------*
  //* Feature: coarsePos

  /** getter for coarsePos - gets 
   * @generated */
  public String getCoarsePos() {
    if (FanseToken_Type.featOkTst && ((FanseToken_Type)jcasType).casFeat_coarsePos == null)
      jcasType.jcas.throwFeatMissing("coarsePos", "edu.cmu.lti.qa4mre.type.FanseToken");
    return jcasType.ll_cas.ll_getStringValue(addr, ((FanseToken_Type)jcasType).casFeatCode_coarsePos);}
    
  /** setter for coarsePos - sets  
   * @generated */
  public void setCoarsePos(String v) {
    if (FanseToken_Type.featOkTst && ((FanseToken_Type)jcasType).casFeat_coarsePos == null)
      jcasType.jcas.throwFeatMissing("coarsePos", "edu.cmu.lti.qa4mre.type.FanseToken");
    jcasType.ll_cas.ll_setStringValue(addr, ((FanseToken_Type)jcasType).casFeatCode_coarsePos, v);}    
   
    
  //*--------------*
  //* Feature: pos

  /** getter for pos - gets 
   * @generated */
  public String getPos() {
    if (FanseToken_Type.featOkTst && ((FanseToken_Type)jcasType).casFeat_pos == null)
      jcasType.jcas.throwFeatMissing("pos", "edu.cmu.lti.qa4mre.type.FanseToken");
    return jcasType.ll_cas.ll_getStringValue(addr, ((FanseToken_Type)jcasType).casFeatCode_pos);}
    
  /** setter for pos - sets  
   * @generated */
  public void setPos(String v) {
    if (FanseToken_Type.featOkTst && ((FanseToken_Type)jcasType).casFeat_pos == null)
      jcasType.jcas.throwFeatMissing("pos", "edu.cmu.lti.qa4mre.type.FanseToken");
    jcasType.ll_cas.ll_setStringValue(addr, ((FanseToken_Type)jcasType).casFeatCode_pos, v);}    
   
    
  //*--------------*
  //* Feature: lexicalSense

  /** getter for lexicalSense - gets 
   * @generated */
  public String getLexicalSense() {
    if (FanseToken_Type.featOkTst && ((FanseToken_Type)jcasType).casFeat_lexicalSense == null)
      jcasType.jcas.throwFeatMissing("lexicalSense", "edu.cmu.lti.qa4mre.type.FanseToken");
    return jcasType.ll_cas.ll_getStringValue(addr, ((FanseToken_Type)jcasType).casFeatCode_lexicalSense);}
    
  /** setter for lexicalSense - sets  
   * @generated */
  public void setLexicalSense(String v) {
    if (FanseToken_Type.featOkTst && ((FanseToken_Type)jcasType).casFeat_lexicalSense == null)
      jcasType.jcas.throwFeatMissing("lexicalSense", "edu.cmu.lti.qa4mre.type.FanseToken");
    jcasType.ll_cas.ll_setStringValue(addr, ((FanseToken_Type)jcasType).casFeatCode_lexicalSense, v);}    
   
    
  //*--------------*
  //* Feature: headDependencyRelations

  /** getter for headDependencyRelations - gets 
   * @generated */
  public FSList getHeadDependencyRelations() {
    if (FanseToken_Type.featOkTst && ((FanseToken_Type)jcasType).casFeat_headDependencyRelations == null)
      jcasType.jcas.throwFeatMissing("headDependencyRelations", "edu.cmu.lti.qa4mre.type.FanseToken");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((FanseToken_Type)jcasType).casFeatCode_headDependencyRelations)));}
    
  /** setter for headDependencyRelations - sets  
   * @generated */
  public void setHeadDependencyRelations(FSList v) {
    if (FanseToken_Type.featOkTst && ((FanseToken_Type)jcasType).casFeat_headDependencyRelations == null)
      jcasType.jcas.throwFeatMissing("headDependencyRelations", "edu.cmu.lti.qa4mre.type.FanseToken");
    jcasType.ll_cas.ll_setRefValue(addr, ((FanseToken_Type)jcasType).casFeatCode_headDependencyRelations, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: childDependencyRelations

  /** getter for childDependencyRelations - gets 
   * @generated */
  public FSList getChildDependencyRelations() {
    if (FanseToken_Type.featOkTst && ((FanseToken_Type)jcasType).casFeat_childDependencyRelations == null)
      jcasType.jcas.throwFeatMissing("childDependencyRelations", "edu.cmu.lti.qa4mre.type.FanseToken");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((FanseToken_Type)jcasType).casFeatCode_childDependencyRelations)));}
    
  /** setter for childDependencyRelations - sets  
   * @generated */
  public void setChildDependencyRelations(FSList v) {
    if (FanseToken_Type.featOkTst && ((FanseToken_Type)jcasType).casFeat_childDependencyRelations == null)
      jcasType.jcas.throwFeatMissing("childDependencyRelations", "edu.cmu.lti.qa4mre.type.FanseToken");
    jcasType.ll_cas.ll_setRefValue(addr, ((FanseToken_Type)jcasType).casFeatCode_childDependencyRelations, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: headSemanticRelations

  /** getter for headSemanticRelations - gets 
   * @generated */
  public FSList getHeadSemanticRelations() {
    if (FanseToken_Type.featOkTst && ((FanseToken_Type)jcasType).casFeat_headSemanticRelations == null)
      jcasType.jcas.throwFeatMissing("headSemanticRelations", "edu.cmu.lti.qa4mre.type.FanseToken");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((FanseToken_Type)jcasType).casFeatCode_headSemanticRelations)));}
    
  /** setter for headSemanticRelations - sets  
   * @generated */
  public void setHeadSemanticRelations(FSList v) {
    if (FanseToken_Type.featOkTst && ((FanseToken_Type)jcasType).casFeat_headSemanticRelations == null)
      jcasType.jcas.throwFeatMissing("headSemanticRelations", "edu.cmu.lti.qa4mre.type.FanseToken");
    jcasType.ll_cas.ll_setRefValue(addr, ((FanseToken_Type)jcasType).casFeatCode_headSemanticRelations, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: childSemanticRelations

  /** getter for childSemanticRelations - gets 
   * @generated */
  public FSList getChildSemanticRelations() {
    if (FanseToken_Type.featOkTst && ((FanseToken_Type)jcasType).casFeat_childSemanticRelations == null)
      jcasType.jcas.throwFeatMissing("childSemanticRelations", "edu.cmu.lti.qa4mre.type.FanseToken");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((FanseToken_Type)jcasType).casFeatCode_childSemanticRelations)));}
    
  /** setter for childSemanticRelations - sets  
   * @generated */
  public void setChildSemanticRelations(FSList v) {
    if (FanseToken_Type.featOkTst && ((FanseToken_Type)jcasType).casFeat_childSemanticRelations == null)
      jcasType.jcas.throwFeatMissing("childSemanticRelations", "edu.cmu.lti.qa4mre.type.FanseToken");
    jcasType.ll_cas.ll_setRefValue(addr, ((FanseToken_Type)jcasType).casFeatCode_childSemanticRelations, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    