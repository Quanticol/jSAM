/**
 */
package org.cmg.ml.sam.xtext.prism.prism.impl;

import java.util.Collection;

import org.cmg.ml.sam.xtext.prism.prism.ActionRenaming;
import org.cmg.ml.sam.xtext.prism.prism.PrismPackage;
import org.cmg.ml.sam.xtext.prism.prism.PrismSystem;
import org.cmg.ml.sam.xtext.prism.prism.Renaming;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Renaming</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.impl.RenamingImpl#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.impl.RenamingImpl#getRenaming <em>Renaming</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RenamingImpl extends PrismSystemImpl implements Renaming
{
  /**
   * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgument()
   * @generated
   * @ordered
   */
  protected PrismSystem argument;

  /**
   * The cached value of the '{@link #getRenaming() <em>Renaming</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRenaming()
   * @generated
   * @ordered
   */
  protected EList<ActionRenaming> renaming;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RenamingImpl()
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
    return PrismPackage.Literals.RENAMING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrismSystem getArgument()
  {
    return argument;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArgument(PrismSystem newArgument, NotificationChain msgs)
  {
    PrismSystem oldArgument = argument;
    argument = newArgument;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrismPackage.RENAMING__ARGUMENT, oldArgument, newArgument);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArgument(PrismSystem newArgument)
  {
    if (newArgument != argument)
    {
      NotificationChain msgs = null;
      if (argument != null)
        msgs = ((InternalEObject)argument).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrismPackage.RENAMING__ARGUMENT, null, msgs);
      if (newArgument != null)
        msgs = ((InternalEObject)newArgument).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrismPackage.RENAMING__ARGUMENT, null, msgs);
      msgs = basicSetArgument(newArgument, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PrismPackage.RENAMING__ARGUMENT, newArgument, newArgument));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ActionRenaming> getRenaming()
  {
    if (renaming == null)
    {
      renaming = new EObjectContainmentEList<ActionRenaming>(ActionRenaming.class, this, PrismPackage.RENAMING__RENAMING);
    }
    return renaming;
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
      case PrismPackage.RENAMING__ARGUMENT:
        return basicSetArgument(null, msgs);
      case PrismPackage.RENAMING__RENAMING:
        return ((InternalEList<?>)getRenaming()).basicRemove(otherEnd, msgs);
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
      case PrismPackage.RENAMING__ARGUMENT:
        return getArgument();
      case PrismPackage.RENAMING__RENAMING:
        return getRenaming();
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
      case PrismPackage.RENAMING__ARGUMENT:
        setArgument((PrismSystem)newValue);
        return;
      case PrismPackage.RENAMING__RENAMING:
        getRenaming().clear();
        getRenaming().addAll((Collection<? extends ActionRenaming>)newValue);
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
      case PrismPackage.RENAMING__ARGUMENT:
        setArgument((PrismSystem)null);
        return;
      case PrismPackage.RENAMING__RENAMING:
        getRenaming().clear();
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
      case PrismPackage.RENAMING__ARGUMENT:
        return argument != null;
      case PrismPackage.RENAMING__RENAMING:
        return renaming != null && !renaming.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RenamingImpl
