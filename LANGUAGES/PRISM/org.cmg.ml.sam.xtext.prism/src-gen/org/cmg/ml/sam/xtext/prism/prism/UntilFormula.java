/**
 */
package org.cmg.ml.sam.xtext.prism.prism;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Until Formula</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.UntilFormula#getLeft <em>Left</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.UntilFormula#getBound <em>Bound</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.UntilFormula#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getUntilFormula()
 * @model
 * @generated
 */
public interface UntilFormula extends PathFormula
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(StateFormula)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getUntilFormula_Left()
   * @model containment="true"
   * @generated
   */
  StateFormula getLeft();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.UntilFormula#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(StateFormula value);

  /**
   * Returns the value of the '<em><b>Bound</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bound</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bound</em>' containment reference.
   * @see #setBound(Bound)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getUntilFormula_Bound()
   * @model containment="true"
   * @generated
   */
  Bound getBound();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.UntilFormula#getBound <em>Bound</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bound</em>' containment reference.
   * @see #getBound()
   * @generated
   */
  void setBound(Bound value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(StateFormula)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getUntilFormula_Right()
   * @model containment="true"
   * @generated
   */
  StateFormula getRight();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.UntilFormula#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(StateFormula value);

} // UntilFormula
