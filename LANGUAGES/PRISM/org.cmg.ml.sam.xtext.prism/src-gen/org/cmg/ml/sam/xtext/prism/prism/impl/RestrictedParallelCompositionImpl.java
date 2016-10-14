/**
 */
package org.cmg.ml.sam.xtext.prism.prism.impl;

import java.util.Collection;

import org.cmg.ml.sam.xtext.prism.prism.PrismPackage;
import org.cmg.ml.sam.xtext.prism.prism.PrismSystem;
import org.cmg.ml.sam.xtext.prism.prism.RestrictedParallelComposition;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Restricted Parallel Composition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.impl.RestrictedParallelCompositionImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.impl.RestrictedParallelCompositionImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.impl.RestrictedParallelCompositionImpl#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RestrictedParallelCompositionImpl extends PrismSystemImpl implements RestrictedParallelComposition
{
  /**
   * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeft()
   * @generated
   * @ordered
   */
  protected PrismSystem left;

  /**
   * The cached value of the '{@link #getActions() <em>Actions</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActions()
   * @generated
   * @ordered
   */
  protected EList<String> actions;

  /**
   * The cached value of the '{@link #getRight() <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRight()
   * @generated
   * @ordered
   */
  protected PrismSystem right;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RestrictedParallelCompositionImpl()
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
    return PrismPackage.Literals.RESTRICTED_PARALLEL_COMPOSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrismSystem getLeft()
  {
    return left;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeft(PrismSystem newLeft, NotificationChain msgs)
  {
    PrismSystem oldLeft = left;
    left = newLeft;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__LEFT, oldLeft, newLeft);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeft(PrismSystem newLeft)
  {
    if (newLeft != left)
    {
      NotificationChain msgs = null;
      if (left != null)
        msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__LEFT, null, msgs);
      if (newLeft != null)
        msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__LEFT, null, msgs);
      msgs = basicSetLeft(newLeft, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__LEFT, newLeft, newLeft));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getActions()
  {
    if (actions == null)
    {
      actions = new EDataTypeEList<String>(String.class, this, PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__ACTIONS);
    }
    return actions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrismSystem getRight()
  {
    return right;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRight(PrismSystem newRight, NotificationChain msgs)
  {
    PrismSystem oldRight = right;
    right = newRight;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__RIGHT, oldRight, newRight);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRight(PrismSystem newRight)
  {
    if (newRight != right)
    {
      NotificationChain msgs = null;
      if (right != null)
        msgs = ((InternalEObject)right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__RIGHT, null, msgs);
      if (newRight != null)
        msgs = ((InternalEObject)newRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__RIGHT, null, msgs);
      msgs = basicSetRight(newRight, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__RIGHT, newRight, newRight));
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
      case PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__LEFT:
        return basicSetLeft(null, msgs);
      case PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__RIGHT:
        return basicSetRight(null, msgs);
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
      case PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__LEFT:
        return getLeft();
      case PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__ACTIONS:
        return getActions();
      case PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__RIGHT:
        return getRight();
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
      case PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__LEFT:
        setLeft((PrismSystem)newValue);
        return;
      case PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__ACTIONS:
        getActions().clear();
        getActions().addAll((Collection<? extends String>)newValue);
        return;
      case PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__RIGHT:
        setRight((PrismSystem)newValue);
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
      case PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__LEFT:
        setLeft((PrismSystem)null);
        return;
      case PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__ACTIONS:
        getActions().clear();
        return;
      case PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__RIGHT:
        setRight((PrismSystem)null);
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
      case PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__LEFT:
        return left != null;
      case PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__ACTIONS:
        return actions != null && !actions.isEmpty();
      case PrismPackage.RESTRICTED_PARALLEL_COMPOSITION__RIGHT:
        return right != null;
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
    result.append(" (actions: ");
    result.append(actions);
    result.append(')');
    return result.toString();
  }

} //RestrictedParallelCompositionImpl
