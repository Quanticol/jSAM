/**
 */
package org.cmg.ml.sam.xtext.prism.prism;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage
 * @generated
 */
public interface PrismFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PrismFactory eINSTANCE = org.cmg.ml.sam.xtext.prism.prism.impl.PrismFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Element</em>'.
   * @generated
   */
  Element createElement();

  /**
   * Returns a new object of class '<em>Path Formula Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Path Formula Declaration</em>'.
   * @generated
   */
  PathFormulaDeclaration createPathFormulaDeclaration();

  /**
   * Returns a new object of class '<em>State Formula Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Formula Declaration</em>'.
   * @generated
   */
  StateFormulaDeclaration createStateFormulaDeclaration();

  /**
   * Returns a new object of class '<em>Path Formula</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Path Formula</em>'.
   * @generated
   */
  PathFormula createPathFormula();

  /**
   * Returns a new object of class '<em>Until Formula</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Until Formula</em>'.
   * @generated
   */
  UntilFormula createUntilFormula();

  /**
   * Returns a new object of class '<em>Bound</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bound</em>'.
   * @generated
   */
  Bound createBound();

  /**
   * Returns a new object of class '<em>Next Formula</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Next Formula</em>'.
   * @generated
   */
  NextFormula createNextFormula();

  /**
   * Returns a new object of class '<em>State Formula</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Formula</em>'.
   * @generated
   */
  StateFormula createStateFormula();

  /**
   * Returns a new object of class '<em>Probability Formula</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Probability Formula</em>'.
   * @generated
   */
  ProbabilityFormula createProbabilityFormula();

  /**
   * Returns a new object of class '<em>Negation Formula</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Negation Formula</em>'.
   * @generated
   */
  NegationFormula createNegationFormula();

  /**
   * Returns a new object of class '<em>Atomic State Formula</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Atomic State Formula</em>'.
   * @generated
   */
  AtomicStateFormula createAtomicStateFormula();

  /**
   * Returns a new object of class '<em>System</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>System</em>'.
   * @generated
   */
  PrismSystem createPrismSystem();

  /**
   * Returns a new object of class '<em>Action Renaming</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Action Renaming</em>'.
   * @generated
   */
  ActionRenaming createActionRenaming();

  /**
   * Returns a new object of class '<em>Module Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module Reference</em>'.
   * @generated
   */
  ModuleReference createModuleReference();

  /**
   * Returns a new object of class '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable</em>'.
   * @generated
   */
  Variable createVariable();

  /**
   * Returns a new object of class '<em>Label</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Label</em>'.
   * @generated
   */
  Label createLabel();

  /**
   * Returns a new object of class '<em>Formula</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Formula</em>'.
   * @generated
   */
  Formula createFormula();

  /**
   * Returns a new object of class '<em>Init Predicate</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Init Predicate</em>'.
   * @generated
   */
  InitPredicate createInitPredicate();

  /**
   * Returns a new object of class '<em>Reward</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reward</em>'.
   * @generated
   */
  Reward createReward();

  /**
   * Returns a new object of class '<em>Reward Case</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reward Case</em>'.
   * @generated
   */
  RewardCase createRewardCase();

  /**
   * Returns a new object of class '<em>Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant</em>'.
   * @generated
   */
  Constant createConstant();

  /**
   * Returns a new object of class '<em>Module</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module</em>'.
   * @generated
   */
  Module createModule();

  /**
   * Returns a new object of class '<em>Module Body</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module Body</em>'.
   * @generated
   */
  ModuleBody createModuleBody();

  /**
   * Returns a new object of class '<em>Variable Renaming</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Renaming</em>'.
   * @generated
   */
  VariableRenaming createVariableRenaming();

  /**
   * Returns a new object of class '<em>Symbol Renaming</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Symbol Renaming</em>'.
   * @generated
   */
  SymbolRenaming createSymbolRenaming();

  /**
   * Returns a new object of class '<em>Module Body Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module Body Declaration</em>'.
   * @generated
   */
  ModuleBodyDeclaration createModuleBodyDeclaration();

  /**
   * Returns a new object of class '<em>Command</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Command</em>'.
   * @generated
   */
  Command createCommand();

  /**
   * Returns a new object of class '<em>Update</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Update</em>'.
   * @generated
   */
  Update createUpdate();

  /**
   * Returns a new object of class '<em>Update Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Update Element</em>'.
   * @generated
   */
  UpdateElement createUpdateElement();

  /**
   * Returns a new object of class '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type</em>'.
   * @generated
   */
  Type createType();

  /**
   * Returns a new object of class '<em>Interval Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Interval Type</em>'.
   * @generated
   */
  IntervalType createIntervalType();

  /**
   * Returns a new object of class '<em>Boolean Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Type</em>'.
   * @generated
   */
  BooleanType createBooleanType();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Log Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Log Function</em>'.
   * @generated
   */
  LogFunction createLogFunction();

  /**
   * Returns a new object of class '<em>Mod Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mod Function</em>'.
   * @generated
   */
  ModFunction createModFunction();

  /**
   * Returns a new object of class '<em>Ceil Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ceil Function</em>'.
   * @generated
   */
  CeilFunction createCeilFunction();

  /**
   * Returns a new object of class '<em>Floor Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Floor Function</em>'.
   * @generated
   */
  FloorFunction createFloorFunction();

  /**
   * Returns a new object of class '<em>Pow Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pow Function</em>'.
   * @generated
   */
  PowFunction createPowFunction();

  /**
   * Returns a new object of class '<em>Max Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Max Function</em>'.
   * @generated
   */
  MaxFunction createMaxFunction();

  /**
   * Returns a new object of class '<em>Min Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Min Function</em>'.
   * @generated
   */
  MinFunction createMinFunction();

  /**
   * Returns a new object of class '<em>True</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>True</em>'.
   * @generated
   */
  True createTrue();

  /**
   * Returns a new object of class '<em>False</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>False</em>'.
   * @generated
   */
  False createFalse();

  /**
   * Returns a new object of class '<em>Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reference</em>'.
   * @generated
   */
  Reference createReference();

  /**
   * Returns a new object of class '<em>Numerical Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Numerical Value</em>'.
   * @generated
   */
  NumericalValue createNumericalValue();

  /**
   * Returns a new object of class '<em>Integer Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Integer Literal</em>'.
   * @generated
   */
  IntegerLiteral createIntegerLiteral();

  /**
   * Returns a new object of class '<em>State Or</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Or</em>'.
   * @generated
   */
  StateOr createStateOr();

  /**
   * Returns a new object of class '<em>State And</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State And</em>'.
   * @generated
   */
  StateAnd createStateAnd();

  /**
   * Returns a new object of class '<em>Alphabetised Parallel Composition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Alphabetised Parallel Composition</em>'.
   * @generated
   */
  AlphabetisedParallelComposition createAlphabetisedParallelComposition();

  /**
   * Returns a new object of class '<em>Asynchronous Parallel Composition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Asynchronous Parallel Composition</em>'.
   * @generated
   */
  AsynchronousParallelComposition createAsynchronousParallelComposition();

  /**
   * Returns a new object of class '<em>Restricted Parallel Composition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Restricted Parallel Composition</em>'.
   * @generated
   */
  RestrictedParallelComposition createRestrictedParallelComposition();

  /**
   * Returns a new object of class '<em>Hiding</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Hiding</em>'.
   * @generated
   */
  Hiding createHiding();

  /**
   * Returns a new object of class '<em>Renaming</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Renaming</em>'.
   * @generated
   */
  Renaming createRenaming();

  /**
   * Returns a new object of class '<em>If Then Else</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Then Else</em>'.
   * @generated
   */
  IfThenElse createIfThenElse();

  /**
   * Returns a new object of class '<em>Implies</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Implies</em>'.
   * @generated
   */
  Implies createImplies();

  /**
   * Returns a new object of class '<em>If And Only If</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If And Only If</em>'.
   * @generated
   */
  IfAndOnlyIf createIfAndOnlyIf();

  /**
   * Returns a new object of class '<em>Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Or Expression</em>'.
   * @generated
   */
  OrExpression createOrExpression();

  /**
   * Returns a new object of class '<em>And Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And Expression</em>'.
   * @generated
   */
  AndExpression createAndExpression();

  /**
   * Returns a new object of class '<em>Negation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Negation</em>'.
   * @generated
   */
  Negation createNegation();

  /**
   * Returns a new object of class '<em>Rel Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rel Expression</em>'.
   * @generated
   */
  RelExpression createRelExpression();

  /**
   * Returns a new object of class '<em>Sum Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sum Expression</em>'.
   * @generated
   */
  SumExpression createSumExpression();

  /**
   * Returns a new object of class '<em>Mul Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mul Expression</em>'.
   * @generated
   */
  MulExpression createMulExpression();

  /**
   * Returns a new object of class '<em>Decimal Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Decimal Literal</em>'.
   * @generated
   */
  DecimalLiteral createDecimalLiteral();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  PrismPackage getPrismPackage();

} //PrismFactory
