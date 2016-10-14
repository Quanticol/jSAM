/**
 */
package org.cmg.ml.sam.xtext.prism.prism;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Path Formula Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.PathFormulaDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.PathFormulaDeclaration#getFormula <em>Formula</em>}</li>
 * </ul>
 *
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getPathFormulaDeclaration()
 * @model
 * @generated
 */
public interface PathFormulaDeclaration extends Element
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getPathFormulaDeclaration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.PathFormulaDeclaration#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Formula</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formula</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formula</em>' containment reference.
   * @see #setFormula(PathFormula)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getPathFormulaDeclaration_Formula()
   * @model containment="true"
   * @generated
   */
  PathFormula getFormula();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.PathFormulaDeclaration#getFormula <em>Formula</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formula</em>' containment reference.
   * @see #getFormula()
   * @generated
   */
  void setFormula(PathFormula value);

} // PathFormulaDeclaration
