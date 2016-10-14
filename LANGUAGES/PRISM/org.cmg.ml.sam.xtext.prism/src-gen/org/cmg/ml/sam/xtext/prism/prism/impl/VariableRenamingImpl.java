/**
 */
package org.cmg.ml.sam.xtext.prism.prism.impl;

import java.util.Collection;

import org.cmg.ml.sam.xtext.prism.prism.Module;
import org.cmg.ml.sam.xtext.prism.prism.PrismPackage;
import org.cmg.ml.sam.xtext.prism.prism.SymbolRenaming;
import org.cmg.ml.sam.xtext.prism.prism.VariableRenaming;

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
 * An implementation of the model object '<em><b>Variable Renaming</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.impl.VariableRenamingImpl#getModule <em>Module</em>}</li>
 *   <li>{@link org.cmg.ml.sam.xtext.prism.prism.impl.VariableRenamingImpl#getRenaming <em>Renaming</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableRenamingImpl extends ModuleBodyImpl implements VariableRenaming
{
  /**
   * The cached value of the '{@link #getModule() <em>Module</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModule()
   * @generated
   * @ordered
   */
  protected Module module;

  /**
   * The cached value of the '{@link #getRenaming() <em>Renaming</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRenaming()
   * @generated
   * @ordered
   */
  protected EList<SymbolRenaming> renaming;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableRenamingImpl()
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
    return PrismPackage.Literals.VARIABLE_RENAMING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Module getModule()
  {
    if (module != null && module.eIsProxy())
    {
      InternalEObject oldModule = (InternalEObject)module;
      module = (Module)eResolveProxy(oldModule);
      if (module != oldModule)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PrismPackage.VARIABLE_RENAMING__MODULE, oldModule, module));
      }
    }
    return module;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Module basicGetModule()
  {
    return module;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModule(Module newModule)
  {
    Module oldModule = module;
    module = newModule;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PrismPackage.VARIABLE_RENAMING__MODULE, oldModule, module));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SymbolRenaming> getRenaming()
  {
    if (renaming == null)
    {
      renaming = new EObjectContainmentEList<SymbolRenaming>(SymbolRenaming.class, this, PrismPackage.VARIABLE_RENAMING__RENAMING);
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
      case PrismPackage.VARIABLE_RENAMING__RENAMING:
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
      case PrismPackage.VARIABLE_RENAMING__MODULE:
        if (resolve) return getModule();
        return basicGetModule();
      case PrismPackage.VARIABLE_RENAMING__RENAMING:
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
      case PrismPackage.VARIABLE_RENAMING__MODULE:
        setModule((Module)newValue);
        return;
      case PrismPackage.VARIABLE_RENAMING__RENAMING:
        getRenaming().clear();
        getRenaming().addAll((Collection<? extends SymbolRenaming>)newValue);
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
      case PrismPackage.VARIABLE_RENAMING__MODULE:
        setModule((Module)null);
        return;
      case PrismPackage.VARIABLE_RENAMING__RENAMING:
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
      case PrismPackage.VARIABLE_RENAMING__MODULE:
        return module != null;
      case PrismPackage.VARIABLE_RENAMING__RENAMING:
        return renaming != null && !renaming.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //VariableRenamingImpl
