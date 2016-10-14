/**
 */
package org.cmg.ml.sam.xtext.prism.prism.impl;

import org.cmg.ml.sam.xtext.prism.prism.Bound;
import org.cmg.ml.sam.xtext.prism.prism.PrismPackage;
import org.cmg.ml.sam.xtext.prism.prism.Relations;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bound</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.impl.BoundImpl#getRelop <em>Relop</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.impl.BoundImpl#getLimit <em>Limit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BoundImpl extends MinimalEObjectImpl.Container implements Bound
{
  /**
   * The default value of the '{@link #getRelop() <em>Relop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelop()
   * @generated
   * @ordered
   */
  protected static final Relations RELOP_EDEFAULT = Relations.LSS;

  /**
   * The cached value of the '{@link #getRelop() <em>Relop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelop()
   * @generated
   * @ordered
   */
  protected Relations relop = RELOP_EDEFAULT;

  /**
   * The default value of the '{@link #getLimit() <em>Limit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLimit()
   * @generated
   * @ordered
   */
  protected static final int LIMIT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getLimit() <em>Limit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLimit()
   * @generated
   * @ordered
   */
  protected int limit = LIMIT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BoundImpl()
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
    return PrismPackage.Literals.BOUND;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Relations getRelop()
  {
    return relop;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRelop(Relations newRelop)
  {
    Relations oldRelop = relop;
    relop = newRelop == null ? RELOP_EDEFAULT : newRelop;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PrismPackage.BOUND__RELOP, oldRelop, relop));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getLimit()
  {
    return limit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLimit(int newLimit)
  {
    int oldLimit = limit;
    limit = newLimit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PrismPackage.BOUND__LIMIT, oldLimit, limit));
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
      case PrismPackage.BOUND__RELOP:
        return getRelop();
      case PrismPackage.BOUND__LIMIT:
        return getLimit();
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
      case PrismPackage.BOUND__RELOP:
        setRelop((Relations)newValue);
        return;
      case PrismPackage.BOUND__LIMIT:
        setLimit((Integer)newValue);
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
      case PrismPackage.BOUND__RELOP:
        setRelop(RELOP_EDEFAULT);
        return;
      case PrismPackage.BOUND__LIMIT:
        setLimit(LIMIT_EDEFAULT);
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
      case PrismPackage.BOUND__RELOP:
        return relop != RELOP_EDEFAULT;
      case PrismPackage.BOUND__LIMIT:
        return limit != LIMIT_EDEFAULT;
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
    result.append(" (relop: ");
    result.append(relop);
    result.append(", limit: ");
    result.append(limit);
    result.append(')');
    return result.toString();
  }

} //BoundImpl
