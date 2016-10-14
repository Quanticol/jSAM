/**
 */
package org.cmg.ml.sam.xtext.prism.prism;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Negation Formula</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.NegationFormula#getArgument <em>Argument</em>}</li>
 * </ul>
 *
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getNegationFormula()
 * @model
 * @generated
 */
public interface NegationFormula extends StateFormula
{
  /**
   * Returns the value of the '<em><b>Argument</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Argument</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Argument</em>' containment reference.
   * @see #setArgument(StateFormula)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getNegationFormula_Argument()
   * @model containment="true"
   * @generated
   */
  StateFormula getArgument();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.NegationFormula#getArgument <em>Argument</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Argument</em>' containment reference.
   * @see #getArgument()
   * @generated
   */
  void setArgument(StateFormula value);

} // NegationFormula
