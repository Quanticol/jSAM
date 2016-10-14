/**
 */
package org.cmg.ml.sam.xtext.prism.prism;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Update</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.Update#getWeight <em>Weight</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.Update#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getUpdate()
 * @model
 * @generated
 */
public interface Update extends EObject
{
  /**
   * Returns the value of the '<em><b>Weight</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Weight</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Weight</em>' containment reference.
   * @see #setWeight(Expression)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getUpdate_Weight()
   * @model containment="true"
   * @generated
   */
  Expression getWeight();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.Update#getWeight <em>Weight</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Weight</em>' containment reference.
   * @see #getWeight()
   * @generated
   */
  void setWeight(Expression value);

  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.cmg.ml.sam.xtext.prism.prism.UpdateElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getUpdate_Elements()
   * @model containment="true"
   * @generated
   */
  EList<UpdateElement> getElements();

} // Update
