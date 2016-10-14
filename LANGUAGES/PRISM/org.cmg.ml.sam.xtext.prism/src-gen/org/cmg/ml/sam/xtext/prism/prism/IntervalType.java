/**
 */
package org.cmg.ml.sam.xtext.prism.prism;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interval Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.IntervalType#getMin <em>Min</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.IntervalType#getMax <em>Max</em>}</li>
 * </ul>
 *
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getIntervalType()
 * @model
 * @generated
 */
public interface IntervalType extends Type
{
  /**
   * Returns the value of the '<em><b>Min</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Min</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Min</em>' containment reference.
   * @see #setMin(Expression)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getIntervalType_Min()
   * @model containment="true"
   * @generated
   */
  Expression getMin();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.IntervalType#getMin <em>Min</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Min</em>' containment reference.
   * @see #getMin()
   * @generated
   */
  void setMin(Expression value);

  /**
   * Returns the value of the '<em><b>Max</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max</em>' containment reference.
   * @see #setMax(Expression)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getIntervalType_Max()
   * @model containment="true"
   * @generated
   */
  Expression getMax();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.IntervalType#getMax <em>Max</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Max</em>' containment reference.
   * @see #getMax()
   * @generated
   */
  void setMax(Expression value);

} // IntervalType
