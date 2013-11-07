
/* First created by JCasGen Wed Nov 06 21:03:16 EST 2013 */
package edu.cmu.lti.qa4mre.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import edu.cmu.lti.util.type.ComponentAnnotation_Type;

/** 
 * Updated by JCasGen Wed Nov 06 21:03:16 EST 2013
 * @generated */
public class SemaforLabel_Type extends ComponentAnnotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (SemaforLabel_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = SemaforLabel_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new SemaforLabel(addr, SemaforLabel_Type.this);
  			   SemaforLabel_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new SemaforLabel(addr, SemaforLabel_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = SemaforLabel.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.qa4mre.type.SemaforLabel");
 
  /** @generated */
  final Feature casFeat_name;
  /** @generated */
  final int     casFeatCode_name;
  /** @generated */ 
  public String getName(int addr) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "edu.cmu.lti.qa4mre.type.SemaforLabel");
    return ll_cas.ll_getStringValue(addr, casFeatCode_name);
  }
  /** @generated */    
  public void setName(int addr, String v) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "edu.cmu.lti.qa4mre.type.SemaforLabel");
    ll_cas.ll_setStringValue(addr, casFeatCode_name, v);}
    
  
 
  /** @generated */
  final Feature casFeat_ID;
  /** @generated */
  final int     casFeatCode_ID;
  /** @generated */ 
  public int getID(int addr) {
        if (featOkTst && casFeat_ID == null)
      jcas.throwFeatMissing("ID", "edu.cmu.lti.qa4mre.type.SemaforLabel");
    return ll_cas.ll_getIntValue(addr, casFeatCode_ID);
  }
  /** @generated */    
  public void setID(int addr, int v) {
        if (featOkTst && casFeat_ID == null)
      jcas.throwFeatMissing("ID", "edu.cmu.lti.qa4mre.type.SemaforLabel");
    ll_cas.ll_setIntValue(addr, casFeatCode_ID, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public SemaforLabel_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_name = jcas.getRequiredFeatureDE(casType, "name", "uima.cas.String", featOkTst);
    casFeatCode_name  = (null == casFeat_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_name).getCode();

 
    casFeat_ID = jcas.getRequiredFeatureDE(casType, "ID", "uima.cas.Integer", featOkTst);
    casFeatCode_ID  = (null == casFeat_ID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ID).getCode();

  }
}



    