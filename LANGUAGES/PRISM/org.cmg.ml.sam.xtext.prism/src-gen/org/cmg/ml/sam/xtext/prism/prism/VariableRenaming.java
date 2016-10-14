/**
 */
package org.cmg.ml.sam.xtext.prism.prism;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Renaming</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.VariableRenaming#getModule <em>Module</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.VariableRenaming#getRenaming <em>Renaming</em>}</li>
 * </ul>
 *
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getVariableRenaming()
 * @model
 * @generated
 */
public interface VariableRenaming extends ModuleBody
{
  /**
   * Returns the value of the '<em><b>Module</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Module</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Module</em>' reference.
   * @see #setModule(Module)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getVariableRenaming_Module()
   * @model
   * @generated
   */
  Module getModule();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.VariableRenaming#getModule <em>Module</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Module</em>' reference.
   * @see #getModule()
   * @generated
   */
  void setModule(Module value);

  /**
   * Returns the value of the '<em><b>Renaming</b></em>' containment reference list.
   * The list contents are of type {@link org.cmg.ml.sam.xtext.prism.prism.SymbolRenaming}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Renaming</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Renaming</em>' containment reference list.
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getVariableRenaming_Renaming()
   * @model containment="true"
   * @generated
   */
  EList<SymbolRenaming> getRenaming();

} // VariableRenaming
