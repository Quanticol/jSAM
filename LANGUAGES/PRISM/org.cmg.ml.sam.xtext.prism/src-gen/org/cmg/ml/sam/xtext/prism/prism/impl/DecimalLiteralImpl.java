/**
 */
package org.cmg.ml.sam.xtext.prism.prism.impl;

import org.cmg.ml.sam.xtext.prism.prism.DecimalLiteral;
import org.cmg.ml.sam.xtext.prism.prism.IntegerLiteral;
import org.cmg.ml.sam.xtext.prism.prism.PrismPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decimal Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.impl.DecimalLiteralImpl#getIntegerPart <em>Integer Part</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.impl.DecimalLiteralImpl#getDecimalPart <em>Decimal Part</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DecimalLiteralImpl extends NumericalValueImpl implements DecimalLiteral
{
  /**
   * The cached value of the '{@link #getIntegerPart() <em>Integer Part</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntegerPart()
   * @generated
   * @ordered
   */
  protected IntegerLiteral integerPart;

  /**
   * The default value of the '{@link #getDecimalPart() <em>Decimal Part</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDecimalPart()
   * @generated
   * @ordered
   */
  protected static final String DECIMAL_PART_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDecimalPart() <em>Decimal Part</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDecimalPart()
   * @generated
   * @ordered
   */
  protected String decimalPart = DECIMAL_PART_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DecimalLiteralImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return PrismPackage.Literals.DECIMAL_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntegerLiteral getIntegerPart()
  {
    return integerPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIntegerPart(IntegerLiteral newIntegerPart, NotificationChain msgs)
  {
    IntegerLiteral oldIntegerPart = integerPart;
    integerPart = newIntegerPart;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrismPackage.DECIMAL_LITERAL__INTEGER_PART, oldIntegerPart, newIntegerPart);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIntegerPart(IntegerLiteral newIntegerPart)
  {
    if (newIntegerPart != integerPart)
    {
      NotificationChain msgs = null;
      if (integerPart != null)
        msgs = ((InternalEObject)integerPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrismPackage.DECIMAL_LITERAL__INTEGER_PART, null, msgs);
      if (newIntegerPart != null)
        msgs = ((InternalEObject)newIntegerPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrismPackage.DECIMAL_LITERAL__INTEGER_PART, null, msgs);
      msgs = basicSetIntegerPart(newIntegerPart, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PrismPackage.DECIMAL_LITERAL__INTEGER_PART, newIntegerPart, newIntegerPart));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDecimalPart()
  {
    return decimalPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDecimalPart(String newDecimalPart)
  {
    String oldDecimalPart = decimalPart;
    decimalPart = newDecimalPart;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PrismPackage.DECIMAL_LITERAL__DECIMAL_PART, oldDecimalPart, decimalPart));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case PrismPackage.DECIMAL_LITERAL__INTEGER_PART:
        return basicSetIntegerPart(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case PrismPackage.DECIMAL_LITERAL__INTEGER_PART:
        return getIntegerPart();
      case PrismPackage.DECIMAL_LITERAL__DECIMAL_PART:
        return getDecimalPart();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PrismPackage.DECIMAL_LITERAL__INTEGER_PART:
        setIntegerPart((IntegerLiteral)newValue);
        return;
      case PrismPackage.DECIMAL_LITERAL__DECIMAL_PART:
        setDecimalPart((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case PrismPackage.DECIMAL_LITERAL__INTEGER_PART:
        setIntegerPart((IntegerLiteral)null);
        return;
      case PrismPackage.DECIMAL_LITERAL__DECIMAL_PART:
        setDecimalPart(DECIMAL_PART_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case PrismPackage.DECIMAL_LITERAL__INTEGER_PART:
        return integerPart != null;
      case PrismPackage.DECIMAL_LITERAL__DECIMAL_PART:
        return DECIMAL_PART_EDEFAULT == null ? decimalPart != null : !DECIMAL_PART_EDEFAULT.equals(decimalPart);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (decimalPart: ");
    result.append(decimalPart);
    result.append(')');
    return result.toString();
  }

} //DecimalLiteralImpl
