/**
 */
package org.cmg.ml.sam.xtext.prism.prism;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pow Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.PowFunction#getBase <em>Base</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.PowFunction#getExponent <em>Exponent</em>}</li>
 * </ul>
 *
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getPowFunction()
 * @model
 * @generated
 */
public interface PowFunction extends Expression
{
  /**
   * Returns the value of the '<em><b>Base</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base</em>' containment reference.
   * @see #setBase(Expression)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getPowFunction_Base()
   * @model containment="true"
   * @generated
   */
  Expression getBase();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.PowFunction#getBase <em>Base</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base</em>' containment reference.
   * @see #getBase()
   * @generated
   */
  void setBase(Expression value);

  /**
   * Returns the value of the '<em><b>Exponent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exponent</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exponent</em>' containment reference.
   * @see #setExponent(Expression)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getPowFunction_Exponent()
   * @model containment="true"
   * @generated
   */
  Expression getExponent();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.PowFunction#getExponent <em>Exponent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exponent</em>' containment reference.
   * @see #getExponent()
   * @generated
   */
  void setExponent(Expression value);

} // PowFunction
