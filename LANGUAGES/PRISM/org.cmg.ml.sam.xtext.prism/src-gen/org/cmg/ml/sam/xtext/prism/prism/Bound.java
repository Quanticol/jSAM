/**
 */
package org.cmg.ml.sam.xtext.prism.prism;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bound</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.Bound#getRelop <em>Relop</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.Bound#getLimit <em>Limit</em>}</li>
 * </ul>
 *
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getBound()
 * @model
 * @generated
 */
public interface Bound extends EObject
{
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
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getBound_Relop()
   * @model
   * @generated
   */
  Relations getRelop();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.Bound#getRelop <em>Relop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Relop</em>' attribute.
   * @see org.cmg.ml.sam.xtext.prism.prism.Relations
   * @see #getRelop()
   * @generated
   */
  void setRelop(Relations value);

  /**
   * Returns the value of the '<em><b>Limit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Limit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Limit</em>' attribute.
   * @see #setLimit(int)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getBound_Limit()
   * @model
   * @generated
   */
  int getLimit();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.Bound#getLimit <em>Limit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Limit</em>' attribute.
   * @see #getLimit()
   * @generated
   */
  void setLimit(int value);

} // Bound
