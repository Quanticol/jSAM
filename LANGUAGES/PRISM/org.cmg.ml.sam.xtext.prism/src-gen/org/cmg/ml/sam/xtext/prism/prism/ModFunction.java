/**
 */
package org.cmg.ml.sam.xtext.prism.prism;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mod Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.ModFunction#getDividend <em>Dividend</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.ModFunction#getDivisor <em>Divisor</em>}</li>
 * </ul>
 *
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getModFunction()
 * @model
 * @generated
 */
public interface ModFunction extends Expression
{
  /**
   * Returns the value of the '<em><b>Dividend</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dividend</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dividend</em>' containment reference.
   * @see #setDividend(Expression)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getModFunction_Dividend()
   * @model containment="true"
   * @generated
   */
  Expression getDividend();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.ModFunction#getDividend <em>Dividend</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dividend</em>' containment reference.
   * @see #getDividend()
   * @generated
   */
  void setDividend(Expression value);

  /**
   * Returns the value of the '<em><b>Divisor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Divisor</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Divisor</em>' containment reference.
   * @see #setDivisor(Expression)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getModFunction_Divisor()
   * @model containment="true"
   * @generated
   */
  Expression getDivisor();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.ModFunction#getDivisor <em>Divisor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Divisor</em>' containment reference.
   * @see #getDivisor()
   * @generated
   */
  void setDivisor(Expression value);

} // ModFunction
