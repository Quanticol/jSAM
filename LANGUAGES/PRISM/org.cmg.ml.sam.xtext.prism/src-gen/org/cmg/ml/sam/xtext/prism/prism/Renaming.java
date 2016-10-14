/**
 */
package org.cmg.ml.sam.xtext.prism.prism;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Renaming</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.Renaming#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.Renaming#getRenaming <em>Renaming</em>}</li>
 * </ul>
 *
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getRenaming()
 * @model
 * @generated
 */
public interface Renaming extends PrismSystem
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
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getRenaming_Argument()
   * @model containment="true"
   * @generated
   */
  PrismSystem getArgument();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.Renaming#getArgument <em>Argument</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Argument</em>' containment reference.
   * @see #getArgument()
   * @generated
   */
  void setArgument(PrismSystem value);

  /**
   * Returns the value of the '<em><b>Renaming</b></em>' containment reference list.
   * The list contents are of type {@link org.cmg.ml.sam.xtext.prism.prism.ActionRenaming}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Renaming</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Renaming</em>' containment reference list.
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getRenaming_Renaming()
   * @model containment="true"
   * @generated
   */
  EList<ActionRenaming> getRenaming();

} // Renaming
