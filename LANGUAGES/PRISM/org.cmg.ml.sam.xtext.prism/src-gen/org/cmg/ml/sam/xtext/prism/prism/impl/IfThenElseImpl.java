/**
 */
package org.cmg.ml.sam.xtext.prism.prism.impl;

import org.cmg.ml.sam.xtext.prism.prism.Expression;
import org.cmg.ml.sam.xtext.prism.prism.IfThenElse;
import org.cmg.ml.sam.xtext.prism.prism.PrismPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Then Else</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.impl.IfThenElseImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.impl.IfThenElseImpl#getThenCase <em>Then Case</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.impl.IfThenElseImpl#getElseCase <em>Else Case</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfThenElseImpl extends ExpressionImpl implements IfThenElse
{
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
   * The cached value of the '{@link #getThenCase() <em>Then Case</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThenCase()
   * @generated
   * @ordered
   */
  protected Expression thenCase;

  /**
   * The cached value of the '{@link #getElseCase() <em>Else Case</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseCase()
   * @generated
   * @ordered
   */
  protected Expression elseCase;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfThenElseImpl()
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
    return PrismPackage.Literals.IF_THEN_ELSE;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrismPackage.IF_THEN_ELSE__GUARD, oldGuard, newGuard);
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
        msgs = ((InternalEObject)guard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrismPackage.IF_THEN_ELSE__GUARD, null, msgs);
      if (newGuard != null)
        msgs = ((InternalEObject)newGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrismPackage.IF_THEN_ELSE__GUARD, null, msgs);
      msgs = basicSetGuard(newGuard, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PrismPackage.IF_THEN_ELSE__GUARD, newGuard, newGuard));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getThenCase()
  {
    return thenCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetThenCase(Expression newThenCase, NotificationChain msgs)
  {
    Expression oldThenCase = thenCase;
    thenCase = newThenCase;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrismPackage.IF_THEN_ELSE__THEN_CASE, oldThenCase, newThenCase);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setThenCase(Expression newThenCase)
  {
    if (newThenCase != thenCase)
    {
      NotificationChain msgs = null;
      if (thenCase != null)
        msgs = ((InternalEObject)thenCase).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrismPackage.IF_THEN_ELSE__THEN_CASE, null, msgs);
      if (newThenCase != null)
        msgs = ((InternalEObject)newThenCase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrismPackage.IF_THEN_ELSE__THEN_CASE, null, msgs);
      msgs = basicSetThenCase(newThenCase, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PrismPackage.IF_THEN_ELSE__THEN_CASE, newThenCase, newThenCase));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getElseCase()
  {
    return elseCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElseCase(Expression newElseCase, NotificationChain msgs)
  {
    Expression oldElseCase = elseCase;
    elseCase = newElseCase;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrismPackage.IF_THEN_ELSE__ELSE_CASE, oldElseCase, newElseCase);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElseCase(Expression newElseCase)
  {
    if (newElseCase != elseCase)
    {
      NotificationChain msgs = null;
      if (elseCase != null)
        msgs = ((InternalEObject)elseCase).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrismPackage.IF_THEN_ELSE__ELSE_CASE, null, msgs);
      if (newElseCase != null)
        msgs = ((InternalEObject)newElseCase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrismPackage.IF_THEN_ELSE__ELSE_CASE, null, msgs);
      msgs = basicSetElseCase(newElseCase, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PrismPackage.IF_THEN_ELSE__ELSE_CASE, newElseCase, newElseCase));
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
      case PrismPackage.IF_THEN_ELSE__GUARD:
        return basicSetGuard(null, msgs);
      case PrismPackage.IF_THEN_ELSE__THEN_CASE:
        return basicSetThenCase(null, msgs);
      case PrismPackage.IF_THEN_ELSE__ELSE_CASE:
        return basicSetElseCase(null, msgs);
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
      case PrismPackage.IF_THEN_ELSE__GUARD:
        return getGuard();
      case PrismPackage.IF_THEN_ELSE__THEN_CASE:
        return getThenCase();
      case PrismPackage.IF_THEN_ELSE__ELSE_CASE:
        return getElseCase();
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
      case PrismPackage.IF_THEN_ELSE__GUARD:
        setGuard((Expression)newValue);
        return;
      case PrismPackage.IF_THEN_ELSE__THEN_CASE:
        setThenCase((Expression)newValue);
        return;
      case PrismPackage.IF_THEN_ELSE__ELSE_CASE:
        setElseCase((Expression)newValue);
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
      case PrismPackage.IF_THEN_ELSE__GUARD:
        setGuard((Expression)null);
        return;
      case PrismPackage.IF_THEN_ELSE__THEN_CASE:
        setThenCase((Expression)null);
        return;
      case PrismPackage.IF_THEN_ELSE__ELSE_CASE:
        setElseCase((Expression)null);
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
      case PrismPackage.IF_THEN_ELSE__GUARD:
        return guard != null;
      case PrismPackage.IF_THEN_ELSE__THEN_CASE:
        return thenCase != null;
      case PrismPackage.IF_THEN_ELSE__ELSE_CASE:
        return elseCase != null;
    }
    return super.eIsSet(featureID);
  }

} //IfThenElseImpl
