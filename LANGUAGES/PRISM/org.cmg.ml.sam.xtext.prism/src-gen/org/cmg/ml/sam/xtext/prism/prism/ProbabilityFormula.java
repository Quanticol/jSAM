/**
 */
package org.cmg.ml.sam.xtext.prism.prism;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Probability Formula</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.ProbabilityFormula#getRelation <em>Relation</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.ProbabilityFormula#getValue <em>Value</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.ProbabilityFormula#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getProbabilityFormula()
 * @model
 * @generated
 */
public interface ProbabilityFormula extends StateFormula
{
  /**
   * Returns the value of the '<em><b>Relation</b></em>' attribute.
   * The literals are from the enumeration {@link org.cmg.ml.sam.xtext.prism.prism.Relations}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Relation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relation</em>' attribute.
   * @see org.cmg.ml.sam.xtext.prism.prism.Relations
   * @see #setRelation(Relations)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getProbabilityFormula_Relation()
   * @model
   * @generated
   */
  Relations getRelation();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.ProbabilityFormula#getRelation <em>Relation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Relation</em>' attribute.
   * @see org.cmg.ml.sam.xtext.prism.prism.Relations
   * @see #getRelation()
   * @generated
   */
  void setRelation(Relations value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Expression)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getProbabilityFormula_Value()
   * @model containment="true"
   * @generated
   */
  Expression getValue();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.ProbabilityFormula#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Expression value);

  /**
   * Returns the value of the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Path</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path</em>' containment reference.
   * @see #setPath(PathFormula)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getProbabilityFormula_Path()
   * @model containment="true"
   * @generated
   */
  PathFormula getPath();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.ProbabilityFormula#getPath <em>Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Path</em>' containment reference.
   * @see #getPath()
   * @generated
   */
  void setPath(PathFormula value);

} // ProbabilityFormula
