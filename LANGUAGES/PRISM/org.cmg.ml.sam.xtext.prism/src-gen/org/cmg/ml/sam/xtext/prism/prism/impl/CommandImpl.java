/**
 */
package org.cmg.ml.sam.xtext.prism.prism.impl;

import java.util.Collection;

import org.cmg.ml.sam.xtext.prism.prism.Command;
import org.cmg.ml.sam.xtext.prism.prism.Expression;
import org.cmg.ml.sam.xtext.prism.prism.PrismPackage;
import org.cmg.ml.sam.xtext.prism.prism.Update;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.impl.CommandImpl#getAct <em>Act</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.impl.CommandImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.impl.CommandImpl#getUpdates <em>Updates</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CommandImpl extends MinimalEObjectImpl.Container implements Command
{
  /**
   * The default value of the '{@link #getAct() <em>Act</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAct()
   * @generated
   * @ordered
   */
  protected static final String ACT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAct() <em>Act</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAct()
   * @generated
   * @ordered
   */
  protected String act = ACT_EDEFAULT;

  /**
   * The cached value of the '{@link #getGuard() <em>Guard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGuard()
   * @generated
   * @ordered
   */
  protected Expression guard;

  /**
   * The cached value of the '{@link #getUpdates() <em>Updates</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpdates()
   * @generated
   * @ordered
   */
  protected EList<Update> updates;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CommandImpl()
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
    return PrismPackage.Literals.COMMAND;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAct()
  {
    return act;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAct(String newAct)
  {
    String oldAct = act;
    act = newAct;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PrismPackage.COMMAND__ACT, oldAct, act));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getGuard()
  {
    return guard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGuard(Expression newGuard, NotificationChain msgs)
  {
    Expression oldGuard = guard;
    guard = newGuard;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrismPackage.COMMAND__GUARD, oldGuard, newGuard);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGuard(Expression newGuard)
  {
    if (newGuard != guard)
    {
      NotificationChain msgs = null;
      if (guard != null)
        msgs = ((InternalEObject)guard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrismPackage.COMMAND__GUARD, null, msgs);
      if (newGuard != null)
        msgs = ((InternalEObject)newGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrismPackage.COMMAND__GUARD, null, msgs);
      msgs = basicSetGuard(newGuard, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PrismPackage.COMMAND__GUARD, newGuard, newGuard));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Update> getUpdates()
  {
    if (updates == null)
    {
      updates = new EObjectContainmentEList<Update>(Update.class, this, PrismPackage.COMMAND__UPDATES);
    }
    return updates;
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
      case PrismPackage.COMMAND__GUARD:
        return basicSetGuard(null, msgs);
      case PrismPackage.COMMAND__UPDATES:
        return ((InternalEList<?>)getUpdates()).basicRemove(otherEnd, msgs);
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
      case PrismPackage.COMMAND__ACT:
        return getAct();
      case PrismPackage.COMMAND__GUARD:
        return getGuard();
      case PrismPackage.COMMAND__UPDATES:
        return getUpdates();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PrismPackage.COMMAND__ACT:
        setAct((String)newValue);
        return;
      case PrismPackage.COMMAND__GUARD:
        setGuard((Expression)newValue);
        return;
      case PrismPackage.COMMAND__UPDATES:
        getUpdates().clear();
        getUpdates().addAll((Collection<? extends Update>)newValue);
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
      case PrismPackage.COMMAND__ACT:
        setAct(ACT_EDEFAULT);
        return;
      case PrismPackage.COMMAND__GUARD:
        setGuard((Expression)null);
        return;
      case PrismPackage.COMMAND__UPDATES:
        getUpdates().clear();
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
      case PrismPackage.COMMAND__ACT:
        return ACT_EDEFAULT == null ? act != null : !ACT_EDEFAULT.equals(act);
      case PrismPackage.COMMAND__GUARD:
        return guard != null;
      case PrismPackage.COMMAND__UPDATES:
        return updates != null && !updates.isEmpty();
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
    result.append(" (act: ");
    result.append(act);
    result.append(')');
    return result.toString();
  }

} //CommandImpl
