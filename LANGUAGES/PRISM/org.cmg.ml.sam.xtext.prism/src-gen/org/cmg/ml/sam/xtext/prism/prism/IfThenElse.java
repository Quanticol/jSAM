/**
 */
package org.cmg.ml.sam.xtext.prism.prism;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Then Else</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.IfThenElse#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.IfThenElse#getThenCase <em>Then Case</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.IfThenElse#getElseCase <em>Else Case</em>}</li>
 * </ul>
 *
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getIfThenElse()
 * @model
 * @generated
 */
public interface IfThenElse extends Expression
{
  /**
   * Returns the value of the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Guard</em>' containment reference.
   * @see #setGuard(Expression)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getIfThenElse_Guard()
   * @model containment="true"
   * @generated
   */
  Expression getGuard();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.IfThenElse#getGuard <em>Guard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guard</em>' containment reference.
   * @see #getGuard()
   * @generated
   */
  void setGuard(Expression value);

  /**
   * Returns the value of the '<em><b>Then Case</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Then Case</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then Case</em>' containment reference.
   * @see #setThenCase(Expression)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getIfThenElse_ThenCase()
   * @model containment="true"
   * @generated
   */
  Expression getThenCase();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.IfThenElse#getThenCase <em>Then Case</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then Case</em>' containment reference.
   * @see #getThenCase()
   * @generated
   */
  void setThenCase(Expression value);

  /**
   * Returns the value of the '<em><b>Else Case</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else Case</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Case</em>' containment reference.
   * @see #setElseCase(Expression)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getIfThenElse_ElseCase()
   * @model containment="true"
   * @generated
   */
  Expression getElseCase();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.IfThenElse#getElseCase <em>Else Case</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else Case</em>' containment reference.
   * @see #getElseCase()
   * @generated
   */
  void setElseCase(Expression value);

} // IfThenElse
