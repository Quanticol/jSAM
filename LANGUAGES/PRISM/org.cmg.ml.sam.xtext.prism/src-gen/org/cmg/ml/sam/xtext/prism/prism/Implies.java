/**
 */
package org.cmg.ml.sam.xtext.prism.prism;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Implies</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.Implies#getLeft <em>Left</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.Implies#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getImplies()
 * @model
 * @generated
 */
public interface Implies extends Expression
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
   * @see #setLeft(Expression)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getImplies_Left()
   * @model containment="true"
   * @generated
   */
  Expression getLeft();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.Implies#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Expression value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Expression)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getImplies_Right()
   * @model containment="true"
   * @generated
   */
  Expression getRight();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.Implies#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Expression value);

} // Implies
