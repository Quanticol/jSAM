/**
 */
package org.cmg.ml.sam.xtext.prism.prism;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Min Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.MinFunction#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getMinFunction()
 * @model
 * @generated
 */
public interface MinFunction extends Expression
{
  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link org.cmg.ml.sam.xtext.prism.prism.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getMinFunction_Args()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getArgs();

} // MinFunction
