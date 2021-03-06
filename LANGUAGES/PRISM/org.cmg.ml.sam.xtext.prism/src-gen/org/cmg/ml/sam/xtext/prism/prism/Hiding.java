/**
 */
package org.cmg.ml.sam.xtext.prism.prism;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hiding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.Hiding#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.Hiding#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getHiding()
 * @model
 * @generated
 */
public interface Hiding extends PrismSystem
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
   * @see #setArgument(PrismSystem)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getHiding_Argument()
   * @model containment="true"
   * @generated
   */
  PrismSystem getArgument();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.Hiding#getArgument <em>Argument</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Argument</em>' containment reference.
   * @see #getArgument()
   * @generated
   */
  void setArgument(PrismSystem value);

  /**
   * Returns the value of the '<em><b>Actions</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actions</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actions</em>' attribute list.
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getHiding_Actions()
   * @model unique="false"
   * @generated
   */
  EList<String> getActions();

} // Hiding
