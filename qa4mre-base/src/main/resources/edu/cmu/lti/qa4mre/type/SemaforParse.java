

/* First created by JCasGen Wed Nov 06 21:03:16 EST 2013 */
package edu.cmu.lti.qa4mre.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Nov 06 21:03:16 EST 2013
 * XML source: /Users/tengda/Documents/workspace/hw5-team03/hw5-team03/qa4mre-base/src/main/resources/TypeSystemDescriptor.xml
 * @generated */
public class SemaforParse extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(SemaforParse.class);
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
  protected SemaforParse() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public SemaforParse(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public SemaforParse(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public SemaforParse(JCas jcas, int begin, int end) {
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
  //* Feature: annotationSets

  /** getter for annotationSets - gets 
   * @generated */
  public FSArray getAnnotationSets() {
    if (SemaforParse_Type.featOkTst && ((SemaforParse_Type)jcasType).casFeat_annotationSets == null)
      jcasType.jcas.throwFeatMissing("annotationSets", "edu.cmu.lti.qa4mre.type.SemaforParse");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((SemaforParse_Type)jcasType).casFeatCode_annotationSets)));}
    
  /** setter for annotationSets - sets  
   * @generated */
  public void setAnnotationSets(FSArray v) {
    if (SemaforParse_Type.featOkTst && ((SemaforParse_Type)jcasType).casFeat_annotationSets == null)
      jcasType.jcas.throwFeatMissing("annotationSets", "edu.cmu.lti.qa4mre.type.SemaforParse");
    jcasType.ll_cas.ll_setRefValue(addr, ((SemaforParse_Type)jcasType).casFeatCode_annotationSets, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for annotationSets - gets an indexed value - 
   * @generated */
  public SemaforAnnotationSet getAnnotationSets(int i) {
    if (SemaforParse_Type.featOkTst && ((SemaforParse_Type)jcasType).casFeat_annotationSets == null)
      jcasType.jcas.throwFeatMissing("annotationSets", "edu.cmu.lti.qa4mre.type.SemaforParse");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((SemaforParse_Type)jcasType).casFeatCode_annotationSets), i);
    return (SemaforAnnotationSet)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((SemaforParse_Type)jcasType).casFeatCode_annotationSets), i)));}

  /** indexed setter for annotationSets - sets an indexed value - 
   * @generated */
  public void setAnnotationSets(int i, SemaforAnnotationSet v) { 
    if (SemaforParse_Type.featOkTst && ((SemaforParse_Type)jcasType).casFeat_annotationSets == null)
      jcasType.jcas.throwFeatMissing("annotationSets", "edu.cmu.lti.qa4mre.type.SemaforParse");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((SemaforParse_Type)jcasType).casFeatCode_annotationSets), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((SemaforParse_Type)jcasType).casFeatCode_annotationSets), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    