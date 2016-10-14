/**
 */
package org.cmg.ml.sam.xtext.prism.prism;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.IntegerLiteral#getIntegerPart <em>Integer Part</em>}</li>
 * </ul>
 *
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getIntegerLiteral()
 * @model
 * @generated
 */
public interface IntegerLiteral extends NumericalValue
{
  /**
   * Returns the value of the '<em><b>Integer Part</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Integer Part</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Integer Part</em>' attribute.
   * @see #setIntegerPart(int)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getIntegerLiteral_IntegerPart()
   * @model
   * @generated
   */
  int getIntegerPart();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.IntegerLiteral#getIntegerPart <em>Integer Part</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Integer Part</em>' attribute.
   * @see #getIntegerPart()
   * @generated
   */
  void setIntegerPart(int value);

} // IntegerLiteral
