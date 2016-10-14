/**
 */
package org.cmg.ml.sam.xtext.prism.prism.util;

import org.cmg.ml.sam.xtext.prism.prism.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage
 * @generated
 */
public class PrismSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PrismPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrismSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = PrismPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case PrismPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.ELEMENT:
      {
        Element element = (Element)theEObject;
        T result = caseElement(element);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.PATH_FORMULA_DECLARATION:
      {
        PathFormulaDeclaration pathFormulaDeclaration = (PathFormulaDeclaration)theEObject;
        T result = casePathFormulaDeclaration(pathFormulaDeclaration);
        if (result == null) result = caseElement(pathFormulaDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.STATE_FORMULA_DECLARATION:
      {
        StateFormulaDeclaration stateFormulaDeclaration = (StateFormulaDeclaration)theEObject;
        T result = caseStateFormulaDeclaration(stateFormulaDeclaration);
        if (result == null) result = caseElement(stateFormulaDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.PATH_FORMULA:
      {
        PathFormula pathFormula = (PathFormula)theEObject;
        T result = casePathFormula(pathFormula);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.UNTIL_FORMULA:
      {
        UntilFormula untilFormula = (UntilFormula)theEObject;
        T result = caseUntilFormula(untilFormula);
        if (result == null) result = casePathFormula(untilFormula);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.BOUND:
      {
        Bound bound = (Bound)theEObject;
        T result = caseBound(bound);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.NEXT_FORMULA:
      {
        NextFormula nextFormula = (NextFormula)theEObject;
        T result = caseNextFormula(nextFormula);
        if (result == null) result = casePathFormula(nextFormula);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.STATE_FORMULA:
      {
        StateFormula stateFormula = (StateFormula)theEObject;
        T result = caseStateFormula(stateFormula);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.PROBABILITY_FORMULA:
      {
        ProbabilityFormula probabilityFormula = (ProbabilityFormula)theEObject;
        T result = caseProbabilityFormula(probabilityFormula);
        if (result == null) result = caseStateFormula(probabilityFormula);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.NEGATION_FORMULA:
      {
        NegationFormula negationFormula = (NegationFormula)theEObject;
        T result = caseNegationFormula(negationFormula);
        if (result == null) result = caseStateFormula(negationFormula);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.ATOMIC_STATE_FORMULA:
      {
        AtomicStateFormula atomicStateFormula = (AtomicStateFormula)theEObject;
        T result = caseAtomicStateFormula(atomicStateFormula);
        if (result == null) result = caseStateFormula(atomicStateFormula);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.PRISM_SYSTEM:
      {
        PrismSystem prismSystem = (PrismSystem)theEObject;
        T result = casePrismSystem(prismSystem);
        if (result == null) result = caseElement(prismSystem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.ACTION_RENAMING:
      {
        ActionRenaming actionRenaming = (ActionRenaming)theEObject;
        T result = caseActionRenaming(actionRenaming);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.MODULE_REFERENCE:
      {
        ModuleReference moduleReference = (ModuleReference)theEObject;
        T result = caseModuleReference(moduleReference);
        if (result == null) result = casePrismSystem(moduleReference);
        if (result == null) result = caseElement(moduleReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.VARIABLE:
      {
        Variable variable = (Variable)theEObject;
        T result = caseVariable(variable);
        if (result == null) result = caseElement(variable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.LABEL:
      {
        Label label = (Label)theEObject;
        T result = caseLabel(label);
        if (result == null) result = caseElement(label);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.FORMULA:
      {
        Formula formula = (Formula)theEObject;
        T result = caseFormula(formula);
        if (result == null) result = caseElement(formula);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.INIT_PREDICATE:
      {
        InitPredicate initPredicate = (InitPredicate)theEObject;
        T result = caseInitPredicate(initPredicate);
        if (result == null) result = caseElement(initPredicate);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.REWARD:
      {
        Reward reward = (Reward)theEObject;
        T result = caseReward(reward);
        if (result == null) result = caseElement(reward);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.REWARD_CASE:
      {
        RewardCase rewardCase = (RewardCase)theEObject;
        T result = caseRewardCase(rewardCase);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.CONSTANT:
      {
        Constant constant = (Constant)theEObject;
        T result = caseConstant(constant);
        if (result == null) result = caseElement(constant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.MODULE:
      {
        Module module = (Module)theEObject;
        T result = caseModule(module);
        if (result == null) result = caseElement(module);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.MODULE_BODY:
      {
        ModuleBody moduleBody = (ModuleBody)theEObject;
        T result = caseModuleBody(moduleBody);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.VARIABLE_RENAMING:
      {
        VariableRenaming variableRenaming = (VariableRenaming)theEObject;
        T result = caseVariableRenaming(variableRenaming);
        if (result == null) result = caseModuleBody(variableRenaming);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.SYMBOL_RENAMING:
      {
        SymbolRenaming symbolRenaming = (SymbolRenaming)theEObject;
        T result = caseSymbolRenaming(symbolRenaming);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.MODULE_BODY_DECLARATION:
      {
        ModuleBodyDeclaration moduleBodyDeclaration = (ModuleBodyDeclaration)theEObject;
        T result = caseModuleBodyDeclaration(moduleBodyDeclaration);
        if (result == null) result = caseModuleBody(moduleBodyDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.COMMAND:
      {
        Command command = (Command)theEObject;
        T result = caseCommand(command);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.UPDATE:
      {
        Update update = (Update)theEObject;
        T result = caseUpdate(update);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.UPDATE_ELEMENT:
      {
        UpdateElement updateElement = (UpdateElement)theEObject;
        T result = caseUpdateElement(updateElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.TYPE:
      {
        Type type = (Type)theEObject;
        T result = caseType(type);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.INTERVAL_TYPE:
      {
        IntervalType intervalType = (IntervalType)theEObject;
        T result = caseIntervalType(intervalType);
        if (result == null) result = caseType(intervalType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.BOOLEAN_TYPE:
      {
        BooleanType booleanType = (BooleanType)theEObject;
        T result = caseBooleanType(booleanType);
        if (result == null) result = caseType(booleanType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.LOG_FUNCTION:
      {
        LogFunction logFunction = (LogFunction)theEObject;
        T result = caseLogFunction(logFunction);
        if (result == null) result = caseExpression(logFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.MOD_FUNCTION:
      {
        ModFunction modFunction = (ModFunction)theEObject;
        T result = caseModFunction(modFunction);
        if (result == null) result = caseExpression(modFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.CEIL_FUNCTION:
      {
        CeilFunction ceilFunction = (CeilFunction)theEObject;
        T result = caseCeilFunction(ceilFunction);
        if (result == null) result = caseExpression(ceilFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.FLOOR_FUNCTION:
      {
        FloorFunction floorFunction = (FloorFunction)theEObject;
        T result = caseFloorFunction(floorFunction);
        if (result == null) result = caseExpression(floorFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.POW_FUNCTION:
      {
        PowFunction powFunction = (PowFunction)theEObject;
        T result = casePowFunction(powFunction);
        if (result == null) result = caseExpression(powFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.MAX_FUNCTION:
      {
        MaxFunction maxFunction = (MaxFunction)theEObject;
        T result = caseMaxFunction(maxFunction);
        if (result == null) result = caseExpression(maxFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.MIN_FUNCTION:
      {
        MinFunction minFunction = (MinFunction)theEObject;
        T result = caseMinFunction(minFunction);
        if (result == null) result = caseExpression(minFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.TRUE:
      {
        True true_ = (True)theEObject;
        T result = caseTrue(true_);
        if (result == null) result = caseExpression(true_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.FALSE:
      {
        False false_ = (False)theEObject;
        T result = caseFalse(false_);
        if (result == null) result = caseExpression(false_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.REFERENCE:
      {
        Reference reference = (Reference)theEObject;
        T result = caseReference(reference);
        if (result == null) result = caseExpression(reference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.NUMERICAL_VALUE:
      {
        NumericalValue numericalValue = (NumericalValue)theEObject;
        T result = caseNumericalValue(numericalValue);
        if (result == null) result = caseExpression(numericalValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.INTEGER_LITERAL:
      {
        IntegerLiteral integerLiteral = (IntegerLiteral)theEObject;
        T result = caseIntegerLiteral(integerLiteral);
        if (result == null) result = caseNumericalValue(integerLiteral);
        if (result == null) result = caseExpression(integerLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.STATE_OR:
      {
        StateOr stateOr = (StateOr)theEObject;
        T result = caseStateOr(stateOr);
        if (result == null) result = caseStateFormula(stateOr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.STATE_AND:
      {
        StateAnd stateAnd = (StateAnd)theEObject;
        T result = caseStateAnd(stateAnd);
        if (result == null) result = caseStateFormula(stateAnd);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.ALPHABETISED_PARALLEL_COMPOSITION:
      {
        AlphabetisedParallelComposition alphabetisedParallelComposition = (AlphabetisedParallelComposition)theEObject;
        T result = caseAlphabetisedParallelComposition(alphabetisedParallelComposition);
        if (result == null) result = casePrismSystem(alphabetisedParallelComposition);
        if (result == null) result = caseElement(alphabetisedParallelComposition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.ASYNCHRONOUS_PARALLEL_COMPOSITION:
      {
        AsynchronousParallelComposition asynchronousParallelComposition = (AsynchronousParallelComposition)theEObject;
        T result = caseAsynchronousParallelComposition(asynchronousParallelComposition);
        if (result == null) result = casePrismSystem(asynchronousParallelComposition);
        if (result == null) result = caseElement(asynchronousParallelComposition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.RESTRICTED_PARALLEL_COMPOSITION:
      {
        RestrictedParallelComposition restrictedParallelComposition = (RestrictedParallelComposition)theEObject;
        T result = caseRestrictedParallelComposition(restrictedParallelComposition);
        if (result == null) result = casePrismSystem(restrictedParallelComposition);
        if (result == null) result = caseElement(restrictedParallelComposition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.HIDING:
      {
        Hiding hiding = (Hiding)theEObject;
        T result = caseHiding(hiding);
        if (result == null) result = casePrismSystem(hiding);
        if (result == null) result = caseElement(hiding);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.RENAMING:
      {
        Renaming renaming = (Renaming)theEObject;
        T result = caseRenaming(renaming);
        if (result == null) result = casePrismSystem(renaming);
        if (result == null) result = caseElement(renaming);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.IF_THEN_ELSE:
      {
        IfThenElse ifThenElse = (IfThenElse)theEObject;
        T result = caseIfThenElse(ifThenElse);
        if (result == null) result = caseExpression(ifThenElse);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.IMPLIES:
      {
        Implies implies = (Implies)theEObject;
        T result = caseImplies(implies);
        if (result == null) result = caseExpression(implies);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.IF_AND_ONLY_IF:
      {
        IfAndOnlyIf ifAndOnlyIf = (IfAndOnlyIf)theEObject;
        T result = caseIfAndOnlyIf(ifAndOnlyIf);
        if (result == null) result = caseExpression(ifAndOnlyIf);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.OR_EXPRESSION:
      {
        OrExpression orExpression = (OrExpression)theEObject;
        T result = caseOrExpression(orExpression);
        if (result == null) result = caseExpression(orExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.AND_EXPRESSION:
      {
        AndExpression andExpression = (AndExpression)theEObject;
        T result = caseAndExpression(andExpression);
        if (result == null) result = caseExpression(andExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.NEGATION:
      {
        Negation negation = (Negation)theEObject;
        T result = caseNegation(negation);
        if (result == null) result = caseExpression(negation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.REL_EXPRESSION:
      {
        RelExpression relExpression = (RelExpression)theEObject;
        T result = caseRelExpression(relExpression);
        if (result == null) result = caseExpression(relExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.SUM_EXPRESSION:
      {
        SumExpression sumExpression = (SumExpression)theEObject;
        T result = caseSumExpression(sumExpression);
        if (result == null) result = caseExpression(sumExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.MUL_EXPRESSION:
      {
        MulExpression mulExpression = (MulExpression)theEObject;
        T result = caseMulExpression(mulExpression);
        if (result == null) result = caseExpression(mulExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PrismPackage.DECIMAL_LITERAL:
      {
        DecimalLiteral decimalLiteral = (DecimalLiteral)theEObject;
        T result = caseDecimalLiteral(decimalLiteral);
        if (result == null) result = caseNumericalValue(decimalLiteral);
        if (result == null) result = caseExpression(decimalLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElement(Element object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Path Formula Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Path Formula Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePathFormulaDeclaration(PathFormulaDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State Formula Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Formula Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateFormulaDeclaration(StateFormulaDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Path Formula</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Path Formula</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePathFormula(PathFormula object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Until Formula</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Until Formula</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUntilFormula(UntilFormula object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bound</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bound</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBound(Bound object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Next Formula</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Next Formula</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNextFormula(NextFormula object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State Formula</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Formula</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateFormula(StateFormula object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Probability Formula</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Probability Formula</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProbabilityFormula(ProbabilityFormula object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Negation Formula</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Negation Formula</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNegationFormula(NegationFormula object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Atomic State Formula</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Atomic State Formula</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAtomicStateFormula(AtomicStateFormula object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>System</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>System</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrismSystem(PrismSystem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Action Renaming</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Action Renaming</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActionRenaming(ActionRenaming object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Module Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Module Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModuleReference(ModuleReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariable(Variable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Label</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Label</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLabel(Label object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Formula</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Formula</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFormula(Formula object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Init Predicate</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Init Predicate</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInitPredicate(InitPredicate object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reward</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reward</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReward(Reward object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reward Case</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reward Case</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRewardCase(RewardCase object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstant(Constant object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Module</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModule(Module object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Module Body</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Module Body</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModuleBody(ModuleBody object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable Renaming</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable Renaming</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariableRenaming(VariableRenaming object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Symbol Renaming</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Symbol Renaming</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSymbolRenaming(SymbolRenaming object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Module Body Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Module Body Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModuleBodyDeclaration(ModuleBodyDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommand(Command object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Update</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Update</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUpdate(Update object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Update Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Update Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUpdateElement(UpdateElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType(Type object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Interval Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Interval Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntervalType(IntervalType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanType(BooleanType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Log Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Log Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLogFunction(LogFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mod Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mod Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModFunction(ModFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ceil Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ceil Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCeilFunction(CeilFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Floor Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Floor Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFloorFunction(FloorFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pow Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pow Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePowFunction(PowFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Max Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Max Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMaxFunction(MaxFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Min Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Min Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMinFunction(MinFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>True</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>True</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrue(True object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>False</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>False</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFalse(False object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReference(Reference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Numerical Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Numerical Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumericalValue(NumericalValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerLiteral(IntegerLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State Or</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Or</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateOr(StateOr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State And</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State And</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateAnd(StateAnd object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Alphabetised Parallel Composition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Alphabetised Parallel Composition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAlphabetisedParallelComposition(AlphabetisedParallelComposition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Asynchronous Parallel Composition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Asynchronous Parallel Composition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAsynchronousParallelComposition(AsynchronousParallelComposition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Restricted Parallel Composition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Restricted Parallel Composition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRestrictedParallelComposition(RestrictedParallelComposition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Hiding</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Hiding</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHiding(Hiding object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Renaming</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Renaming</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRenaming(Renaming object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Then Else</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Then Else</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfThenElse(IfThenElse object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Implies</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Implies</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImplies(Implies object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If And Only If</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If And Only If</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfAndOnlyIf(IfAndOnlyIf object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrExpression(OrExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>And Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAndExpression(AndExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Negation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Negation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNegation(Negation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rel Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rel Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelExpression(RelExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sum Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sum Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSumExpression(SumExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mul Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mul Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMulExpression(MulExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Decimal Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Decimal Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDecimalLiteral(DecimalLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //PrismSwitch
