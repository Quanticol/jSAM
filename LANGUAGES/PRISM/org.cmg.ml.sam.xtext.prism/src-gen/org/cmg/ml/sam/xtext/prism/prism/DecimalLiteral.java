/**
 */
package org.cmg.ml.sam.xtext.prism.prism;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decimal Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.DecimalLiteral#getIntegerPart <em>Integer Part</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.DecimalLiteral#getDecimalPart <em>Decimal Part</em>}</li>
 * </ul>
 *
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getDecimalLiteral()
 * @model
 * @generated
 */
public interface DecimalLiteral extends NumericalValue
{
  /**
   * Returns the value of the '<em><b>Integer Part</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Integer Part</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Integer Part</em>' containment reference.
   * @see #setIntegerPart(IntegerLiteral)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getDecimalLiteral_IntegerPart()
   * @model containment="true"
   * @generated
   */
  IntegerLiteral getIntegerPart();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.DecimalLiteral#getIntegerPart <em>Integer Part</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Integer Part</em>' containment reference.
   * @see #getIntegerPart()
   * @generated
   */
  void setIntegerPart(IntegerLiteral value);

  /**
   * Returns the value of the '<em><b>Decimal Part</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Decimal Part</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decimal Part</em>' attribute.
   * @see #setDecimalPart(String)
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#getDecimalLiteral_DecimalPart()
   * @model
   * @generated
   */
  String getDecimalPart();

  /**
   * Sets the value of the '{@link org.cmg.ml.sam.xtext.prism.prism.DecimalLiteral#getDecimalPart <em>Decimal Part</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Decimal Part</em>' attribute.
   * @see #getDecimalPart()
   * @generated
   */
  void setDecimalPart(String value);

} // DecimalLiteral
