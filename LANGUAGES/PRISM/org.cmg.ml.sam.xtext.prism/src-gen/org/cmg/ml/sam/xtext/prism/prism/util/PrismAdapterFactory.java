/**
 */
package org.cmg.ml.sam.xtext.prism.prism.util;

import org.cmg.ml.sam.xtext.prism.prism.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage
 * @generated
 */
public class PrismAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PrismPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrismAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = PrismPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrismSwitch<Adapter> modelSwitch =
    new PrismSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseElement(Element object)
      {
        return createElementAdapter();
      }
      @Override
      public Adapter casePathFormulaDeclaration(PathFormulaDeclaration object)
      {
        return createPathFormulaDeclarationAdapter();
      }
      @Override
      public Adapter caseStateFormulaDeclaration(StateFormulaDeclaration object)
      {
        return createStateFormulaDeclarationAdapter();
      }
      @Override
      public Adapter casePathFormula(PathFormula object)
      {
        return createPathFormulaAdapter();
      }
      @Override
      public Adapter caseUntilFormula(UntilFormula object)
      {
        return createUntilFormulaAdapter();
      }
      @Override
      public Adapter caseBound(Bound object)
      {
        return createBoundAdapter();
      }
      @Override
      public Adapter caseNextFormula(NextFormula object)
      {
        return createNextFormulaAdapter();
      }
      @Override
      public Adapter caseStateFormula(StateFormula object)
      {
        return createStateFormulaAdapter();
      }
      @Override
      public Adapter caseProbabilityFormula(ProbabilityFormula object)
      {
        return createProbabilityFormulaAdapter();
      }
      @Override
      public Adapter caseNegationFormula(NegationFormula object)
      {
        return createNegationFormulaAdapter();
      }
      @Override
      public Adapter caseAtomicStateFormula(AtomicStateFormula object)
      {
        return createAtomicStateFormulaAdapter();
      }
      @Override
      public Adapter casePrismSystem(PrismSystem object)
      {
        return createPrismSystemAdapter();
      }
      @Override
      public Adapter caseActionRenaming(ActionRenaming object)
      {
        return createActionRenamingAdapter();
      }
      @Override
      public Adapter caseModuleReference(ModuleReference object)
      {
        return createModuleReferenceAdapter();
      }
      @Override
      public Adapter caseVariable(Variable object)
      {
        return createVariableAdapter();
      }
      @Override
      public Adapter caseLabel(Label object)
      {
        return createLabelAdapter();
      }
      @Override
      public Adapter caseFormula(Formula object)
      {
        return createFormulaAdapter();
      }
      @Override
      public Adapter caseInitPredicate(InitPredicate object)
      {
        return createInitPredicateAdapter();
      }
      @Override
      public Adapter caseReward(Reward object)
      {
        return createRewardAdapter();
      }
      @Override
      public Adapter caseRewardCase(RewardCase object)
      {
        return createRewardCaseAdapter();
      }
      @Override
      public Adapter caseConstant(Constant object)
      {
        return createConstantAdapter();
      }
      @Override
      public Adapter caseModule(Module object)
      {
        return createModuleAdapter();
      }
      @Override
      public Adapter caseModuleBody(ModuleBody object)
      {
        return createModuleBodyAdapter();
      }
      @Override
      public Adapter caseVariableRenaming(VariableRenaming object)
      {
        return createVariableRenamingAdapter();
      }
      @Override
      public Adapter caseSymbolRenaming(SymbolRenaming object)
      {
        return createSymbolRenamingAdapter();
      }
      @Override
      public Adapter caseModuleBodyDeclaration(ModuleBodyDeclaration object)
      {
        return createModuleBodyDeclarationAdapter();
      }
      @Override
      public Adapter caseCommand(Command object)
      {
        return createCommandAdapter();
      }
      @Override
      public Adapter caseUpdate(Update object)
      {
        return createUpdateAdapter();
      }
      @Override
      public Adapter caseUpdateElement(UpdateElement object)
      {
        return createUpdateElementAdapter();
      }
      @Override
      public Adapter caseType(Type object)
      {
        return createTypeAdapter();
      }
      @Override
      public Adapter caseIntervalType(IntervalType object)
      {
        return createIntervalTypeAdapter();
      }
      @Override
      public Adapter caseBooleanType(BooleanType object)
      {
        return createBooleanTypeAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseLogFunction(LogFunction object)
      {
        return createLogFunctionAdapter();
      }
      @Override
      public Adapter caseModFunction(ModFunction object)
      {
        return createModFunctionAdapter();
      }
      @Override
      public Adapter caseCeilFunction(CeilFunction object)
      {
        return createCeilFunctionAdapter();
      }
      @Override
      public Adapter caseFloorFunction(FloorFunction object)
      {
        return createFloorFunctionAdapter();
      }
      @Override
      public Adapter casePowFunction(PowFunction object)
      {
        return createPowFunctionAdapter();
      }
      @Override
      public Adapter caseMaxFunction(MaxFunction object)
      {
        return createMaxFunctionAdapter();
      }
      @Override
      public Adapter caseMinFunction(MinFunction object)
      {
        return createMinFunctionAdapter();
      }
      @Override
      public Adapter caseTrue(True object)
      {
        return createTrueAdapter();
      }
      @Override
      public Adapter caseFalse(False object)
      {
        return createFalseAdapter();
      }
      @Override
      public Adapter caseReference(Reference object)
      {
        return createReferenceAdapter();
      }
      @Override
      public Adapter caseNumericalValue(NumericalValue object)
      {
        return createNumericalValueAdapter();
      }
      @Override
      public Adapter caseIntegerLiteral(IntegerLiteral object)
      {
        return createIntegerLiteralAdapter();
      }
      @Override
      public Adapter caseStateOr(StateOr object)
      {
        return createStateOrAdapter();
      }
      @Override
      public Adapter caseStateAnd(StateAnd object)
      {
        return createStateAndAdapter();
      }
      @Override
      public Adapter caseAlphabetisedParallelComposition(AlphabetisedParallelComposition object)
      {
        return createAlphabetisedParallelCompositionAdapter();
      }
      @Override
      public Adapter caseAsynchronousParallelComposition(AsynchronousParallelComposition object)
      {
        return createAsynchronousParallelCompositionAdapter();
      }
      @Override
      public Adapter caseRestrictedParallelComposition(RestrictedParallelComposition object)
      {
        return createRestrictedParallelCompositionAdapter();
      }
      @Override
      public Adapter caseHiding(Hiding object)
      {
        return createHidingAdapter();
      }
      @Override
      public Adapter caseRenaming(Renaming object)
      {
        return createRenamingAdapter();
      }
      @Override
      public Adapter caseIfThenElse(IfThenElse object)
      {
        return createIfThenElseAdapter();
      }
      @Override
      public Adapter caseImplies(Implies object)
      {
        return createImpliesAdapter();
      }
      @Override
      public Adapter caseIfAndOnlyIf(IfAndOnlyIf object)
      {
        return createIfAndOnlyIfAdapter();
      }
      @Override
      public Adapter caseOrExpression(OrExpression object)
      {
        return createOrExpressionAdapter();
      }
      @Override
      public Adapter caseAndExpression(AndExpression object)
      {
        return createAndExpressionAdapter();
      }
      @Override
      public Adapter caseNegation(Negation object)
      {
        return createNegationAdapter();
      }
      @Override
      public Adapter caseRelExpression(RelExpression object)
      {
        return createRelExpressionAdapter();
      }
      @Override
      public Adapter caseSumExpression(SumExpression object)
      {
        return createSumExpressionAdapter();
      }
      @Override
      public Adapter caseMulExpression(MulExpression object)
      {
        return createMulExpressionAdapter();
      }
      @Override
      public Adapter caseDecimalLiteral(DecimalLiteral object)
      {
        return createDecimalLiteralAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.Element
   * @generated
   */
  public Adapter createElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.PathFormulaDeclaration <em>Path Formula Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.PathFormulaDeclaration
   * @generated
   */
  public Adapter createPathFormulaDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.StateFormulaDeclaration <em>State Formula Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.StateFormulaDeclaration
   * @generated
   */
  public Adapter createStateFormulaDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.PathFormula <em>Path Formula</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.PathFormula
   * @generated
   */
  public Adapter createPathFormulaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.UntilFormula <em>Until Formula</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.UntilFormula
   * @generated
   */
  public Adapter createUntilFormulaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.Bound <em>Bound</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.Bound
   * @generated
   */
  public Adapter createBoundAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.NextFormula <em>Next Formula</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.NextFormula
   * @generated
   */
  public Adapter createNextFormulaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.StateFormula <em>State Formula</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.StateFormula
   * @generated
   */
  public Adapter createStateFormulaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.ProbabilityFormula <em>Probability Formula</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.ProbabilityFormula
   * @generated
   */
  public Adapter createProbabilityFormulaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.NegationFormula <em>Negation Formula</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.NegationFormula
   * @generated
   */
  public Adapter createNegationFormulaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.AtomicStateFormula <em>Atomic State Formula</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.AtomicStateFormula
   * @generated
   */
  public Adapter createAtomicStateFormulaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.PrismSystem <em>System</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismSystem
   * @generated
   */
  public Adapter createPrismSystemAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.ActionRenaming <em>Action Renaming</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.ActionRenaming
   * @generated
   */
  public Adapter createActionRenamingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.ModuleReference <em>Module Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.ModuleReference
   * @generated
   */
  public Adapter createModuleReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.Variable
   * @generated
   */
  public Adapter createVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.Label <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.Label
   * @generated
   */
  public Adapter createLabelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.Formula <em>Formula</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.Formula
   * @generated
   */
  public Adapter createFormulaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.InitPredicate <em>Init Predicate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.InitPredicate
   * @generated
   */
  public Adapter createInitPredicateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.Reward <em>Reward</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.Reward
   * @generated
   */
  public Adapter createRewardAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.RewardCase <em>Reward Case</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.RewardCase
   * @generated
   */
  public Adapter createRewardCaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.Constant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.Constant
   * @generated
   */
  public Adapter createConstantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.Module <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.Module
   * @generated
   */
  public Adapter createModuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.ModuleBody <em>Module Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.ModuleBody
   * @generated
   */
  public Adapter createModuleBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.VariableRenaming <em>Variable Renaming</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.VariableRenaming
   * @generated
   */
  public Adapter createVariableRenamingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.SymbolRenaming <em>Symbol Renaming</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.SymbolRenaming
   * @generated
   */
  public Adapter createSymbolRenamingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.ModuleBodyDeclaration <em>Module Body Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.ModuleBodyDeclaration
   * @generated
   */
  public Adapter createModuleBodyDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.Command <em>Command</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.Command
   * @generated
   */
  public Adapter createCommandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.Update <em>Update</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.Update
   * @generated
   */
  public Adapter createUpdateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.UpdateElement <em>Update Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.UpdateElement
   * @generated
   */
  public Adapter createUpdateElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.Type
   * @generated
   */
  public Adapter createTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.IntervalType <em>Interval Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.IntervalType
   * @generated
   */
  public Adapter createIntervalTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.BooleanType <em>Boolean Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.BooleanType
   * @generated
   */
  public Adapter createBooleanTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.LogFunction <em>Log Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.LogFunction
   * @generated
   */
  public Adapter createLogFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.ModFunction <em>Mod Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.ModFunction
   * @generated
   */
  public Adapter createModFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.CeilFunction <em>Ceil Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.CeilFunction
   * @generated
   */
  public Adapter createCeilFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.FloorFunction <em>Floor Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.FloorFunction
   * @generated
   */
  public Adapter createFloorFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.PowFunction <em>Pow Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.PowFunction
   * @generated
   */
  public Adapter createPowFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.MaxFunction <em>Max Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.MaxFunction
   * @generated
   */
  public Adapter createMaxFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.MinFunction <em>Min Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.MinFunction
   * @generated
   */
  public Adapter createMinFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.True <em>True</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.True
   * @generated
   */
  public Adapter createTrueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.False <em>False</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.False
   * @generated
   */
  public Adapter createFalseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.Reference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.Reference
   * @generated
   */
  public Adapter createReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.NumericalValue <em>Numerical Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.NumericalValue
   * @generated
   */
  public Adapter createNumericalValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.IntegerLiteral <em>Integer Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.IntegerLiteral
   * @generated
   */
  public Adapter createIntegerLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.StateOr <em>State Or</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.StateOr
   * @generated
   */
  public Adapter createStateOrAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.StateAnd <em>State And</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.StateAnd
   * @generated
   */
  public Adapter createStateAndAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.AlphabetisedParallelComposition <em>Alphabetised Parallel Composition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.AlphabetisedParallelComposition
   * @generated
   */
  public Adapter createAlphabetisedParallelCompositionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.AsynchronousParallelComposition <em>Asynchronous Parallel Composition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.AsynchronousParallelComposition
   * @generated
   */
  public Adapter createAsynchronousParallelCompositionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.RestrictedParallelComposition <em>Restricted Parallel Composition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.RestrictedParallelComposition
   * @generated
   */
  public Adapter createRestrictedParallelCompositionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.Hiding <em>Hiding</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.Hiding
   * @generated
   */
  public Adapter createHidingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.Renaming <em>Renaming</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.Renaming
   * @generated
   */
  public Adapter createRenamingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.IfThenElse <em>If Then Else</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.IfThenElse
   * @generated
   */
  public Adapter createIfThenElseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.Implies <em>Implies</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.Implies
   * @generated
   */
  public Adapter createImpliesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.IfAndOnlyIf <em>If And Only If</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.IfAndOnlyIf
   * @generated
   */
  public Adapter createIfAndOnlyIfAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.OrExpression <em>Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.OrExpression
   * @generated
   */
  public Adapter createOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.AndExpression
   * @generated
   */
  public Adapter createAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.Negation <em>Negation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.Negation
   * @generated
   */
  public Adapter createNegationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.RelExpression <em>Rel Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.RelExpression
   * @generated
   */
  public Adapter createRelExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.SumExpression <em>Sum Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.SumExpression
   * @generated
   */
  public Adapter createSumExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.MulExpression <em>Mul Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.MulExpression
   * @generated
   */
  public Adapter createMulExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.cmg.ml.sam.xtext.prism.prism.DecimalLiteral <em>Decimal Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.cmg.ml.sam.xtext.prism.prism.DecimalLiteral
   * @generated
   */
  public Adapter createDecimalLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //PrismAdapterFactory
