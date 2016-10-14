/**
 */
package org.cmg.ml.sam.xtext.prism.prism;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rel Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.RelExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.RelExpression#getRelop <em>Relop</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.RelExpression#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getRelExpression()
 * @model
 * @generated
 */
public interface RelExpression extends Expression
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
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getRelExpression_Left()
   * @model containment="true"
   * @generated
   */
  Expression getLeft();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.RelExpression#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Expression value);

  /**
   * Returns the value of the '<em><b>Relop</b></em>' attribute.
   * The literals are from the enumeration {@link org.cmg.ml.sam.xtext.prism.prism.Relations}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Relop</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relop</em>' attribute.
   * @see org.cmg.ml.sam.xtext.prism.prism.Relations
   * @see #setRelop(Relations)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getRelExpression_Relop()
   * @model
   * @generated
   */
  Relations getRelop();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.RelExpression#getRelop <em>Relop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Relop</em>' attribute.
   * @see org.cmg.ml.sam.xtext.prism.prism.Relations
   * @see #getRelop()
   * @generated
   */
  void setRelop(Relations value);

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
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getRelExpression_Right()
   * @model containment="true"
   * @generated
   */
  Expression getRight();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.RelExpression#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Expression value);

} // RelExpression
