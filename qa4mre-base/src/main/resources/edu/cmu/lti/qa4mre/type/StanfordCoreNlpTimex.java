

/* First created by JCasGen Wed Nov 06 21:03:16 EST 2013 */
package edu.cmu.lti.qa4mre.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.lti.util.type.ComponentAnnotation;


/** See http://www-nlp.stanford.edu/nlp/javadoc/javanlp/edu/stanford/nlp/time/Timex.html
 * Updated by JCasGen Wed Nov 06 21:03:16 EST 2013
 * XML source: /Users/tengda/Documents/workspace/hw5-team03/hw5-team03/qa4mre-base/src/main/resources/TypeSystemDescriptor.xml
 * @generated */
public class StanfordCoreNlpTimex extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(StanfordCoreNlpTimex.class);
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
  protected StanfordCoreNlpTimex() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public StanfordCoreNlpTimex(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public StanfordCoreNlpTimex(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public StanfordCoreNlpTimex(JCas jcas, int begin, int end) {
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
  //* Feature: tid

  /** getter for tid - gets 
   * @generated */
  public String getTid() {
    if (StanfordCoreNlpTimex_Type.featOkTst && ((StanfordCoreNlpTimex_Type)jcasType).casFeat_tid == null)
      jcasType.jcas.throwFeatMissing("tid", "edu.cmu.lti.qa4mre.type.StanfordCoreNlpTimex");
    return jcasType.ll_cas.ll_getStringValue(addr, ((StanfordCoreNlpTimex_Type)jcasType).casFeatCode_tid);}
    
  /** setter for tid - sets  
   * @generated */
  public void setTid(String v) {
    if (StanfordCoreNlpTimex_Type.featOkTst && ((StanfordCoreNlpTimex_Type)jcasType).casFeat_tid == null)
      jcasType.jcas.throwFeatMissing("tid", "edu.cmu.lti.qa4mre.type.StanfordCoreNlpTimex");
    jcasType.ll_cas.ll_setStringValue(addr, ((StanfordCoreNlpTimex_Type)jcasType).casFeatCode_tid, v);}    
   
    
  //*--------------*
  //* Feature: value

  /** getter for value - gets 
   * @generated */
  public String getValue() {
    if (StanfordCoreNlpTimex_Type.featOkTst && ((StanfordCoreNlpTimex_Type)jcasType).casFeat_value == null)
      jcasType.jcas.throwFeatMissing("value", "edu.cmu.lti.qa4mre.type.StanfordCoreNlpTimex");
    return jcasType.ll_cas.ll_getStringValue(addr, ((StanfordCoreNlpTimex_Type)jcasType).casFeatCode_value);}
    
  /** setter for value - sets  
   * @generated */
  public void setValue(String v) {
    if (StanfordCoreNlpTimex_Type.featOkTst && ((StanfordCoreNlpTimex_Type)jcasType).casFeat_value == null)
      jcasType.jcas.throwFeatMissing("value", "edu.cmu.lti.qa4mre.type.StanfordCoreNlpTimex");
    jcasType.ll_cas.ll_setStringValue(addr, ((StanfordCoreNlpTimex_Type)jcasType).casFeatCode_value, v);}    
   
    
  //*--------------*
  //* Feature: timexType

  /** getter for timexType - gets This corresponds to 'type' defined in Timex3.
   * @generated */
  public String getTimexType() {
    if (StanfordCoreNlpTimex_Type.featOkTst && ((StanfordCoreNlpTimex_Type)jcasType).casFeat_timexType == null)
      jcasType.jcas.throwFeatMissing("timexType", "edu.cmu.lti.qa4mre.type.StanfordCoreNlpTimex");
    return jcasType.ll_cas.ll_getStringValue(addr, ((StanfordCoreNlpTimex_Type)jcasType).casFeatCode_timexType);}
    
  /** setter for timexType - sets This corresponds to 'type' defined in Timex3. 
   * @generated */
  public void setTimexType(String v) {
    if (StanfordCoreNlpTimex_Type.featOkTst && ((StanfordCoreNlpTimex_Type)jcasType).casFeat_timexType == null)
      jcasType.jcas.throwFeatMissing("timexType", "edu.cmu.lti.qa4mre.type.StanfordCoreNlpTimex");
    jcasType.ll_cas.ll_setStringValue(addr, ((StanfordCoreNlpTimex_Type)jcasType).casFeatCode_timexType, v);}    
   
    
  //*--------------*
  //* Feature: range

  /** getter for range - gets 
   * @generated */
  public String getRange() {
    if (StanfordCoreNlpTimex_Type.featOkTst && ((StanfordCoreNlpTimex_Type)jcasType).casFeat_range == null)
      jcasType.jcas.throwFeatMissing("range", "edu.cmu.lti.qa4mre.type.StanfordCoreNlpTimex");
    return jcasType.ll_cas.ll_getStringValue(addr, ((StanfordCoreNlpTimex_Type)jcasType).casFeatCode_range);}
    
  /** setter for range - sets  
   * @generated */
  public void setRange(String v) {
    if (StanfordCoreNlpTimex_Type.featOkTst && ((StanfordCoreNlpTimex_Type)jcasType).casFeat_range == null)
      jcasType.jcas.throwFeatMissing("range", "edu.cmu.lti.qa4mre.type.StanfordCoreNlpTimex");
    jcasType.ll_cas.ll_setStringValue(addr, ((StanfordCoreNlpTimex_Type)jcasType).casFeatCode_range, v);}    
  }

    