/**
 */
package org.cmg.ml.sam.xtext.prism.prism.impl;

import org.cmg.ml.sam.xtext.prism.prism.Expression;
import org.cmg.ml.sam.xtext.prism.prism.ModFunction;
import org.cmg.ml.sam.xtext.prism.prism.PrismPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mod Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.impl.ModFunctionImpl#getDividend <em>Dividend</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.impl.ModFunctionImpl#getDivisor <em>Divisor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModFunctionImpl extends ExpressionImpl implements ModFunction
{
  /**
   * The cached value of the '{@link #getDividend() <em>Dividend</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDividend()
   * @generated
   * @ordered
   */
  protected Expression dividend;

  /**
   * The cached value of the '{@link #getDivisor() <em>Divisor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDivisor()
   * @generated
   * @ordered
   */
  protected Expression divisor;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModFunctionImpl()
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
    return PrismPackage.Literals.MOD_FUNCTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getDividend()
  {
    return dividend;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDividend(Expression newDividend, NotificationChain msgs)
  {
    Expression oldDividend = dividend;
    dividend = newDividend;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrismPackage.MOD_FUNCTION__DIVIDEND, oldDividend, newDividend);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDividend(Expression newDividend)
  {
    if (newDividend != dividend)
    {
      NotificationChain msgs = null;
      if (dividend != null)
        msgs = ((InternalEObject)dividend).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrismPackage.MOD_FUNCTION__DIVIDEND, null, msgs);
      if (newDividend != null)
        msgs = ((InternalEObject)newDividend).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrismPackage.MOD_FUNCTION__DIVIDEND, null, msgs);
      msgs = basicSetDividend(newDividend, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PrismPackage.MOD_FUNCTION__DIVIDEND, newDividend, newDividend));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getDivisor()
  {
    return divisor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDivisor(Expression newDivisor, NotificationChain msgs)
  {
    Expression oldDivisor = divisor;
    divisor = newDivisor;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrismPackage.MOD_FUNCTION__DIVISOR, oldDivisor, newDivisor);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDivisor(Expression newDivisor)
  {
    if (newDivisor != divisor)
    {
      NotificationChain msgs = null;
      if (divisor != null)
        msgs = ((InternalEObject)divisor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrismPackage.MOD_FUNCTION__DIVISOR, null, msgs);
      if (newDivisor != null)
        msgs = ((InternalEObject)newDivisor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrismPackage.MOD_FUNCTION__DIVISOR, null, msgs);
      msgs = basicSetDivisor(newDivisor, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PrismPackage.MOD_FUNCTION__DIVISOR, newDivisor, newDivisor));
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
      case PrismPackage.MOD_FUNCTION__DIVIDEND:
        return basicSetDividend(null, msgs);
      case PrismPackage.MOD_FUNCTION__DIVISOR:
        return basicSetDivisor(null, msgs);
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
      case PrismPackage.MOD_FUNCTION__DIVIDEND:
        return getDividend();
      case PrismPackage.MOD_FUNCTION__DIVISOR:
        return getDivisor();
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
      case PrismPackage.MOD_FUNCTION__DIVIDEND:
        setDividend((Expression)newValue);
        return;
      case PrismPackage.MOD_FUNCTION__DIVISOR:
        setDivisor((Expression)newValue);
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
      case PrismPackage.MOD_FUNCTION__DIVIDEND:
        setDividend((Expression)null);
        return;
      case PrismPackage.MOD_FUNCTION__DIVISOR:
        setDivisor((Expression)null);
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
      case PrismPackage.MOD_FUNCTION__DIVIDEND:
        return dividend != null;
      case PrismPackage.MOD_FUNCTION__DIVISOR:
        return divisor != null;
    }
    return super.eIsSet(featureID);
  }

} //ModFunctionImpl
