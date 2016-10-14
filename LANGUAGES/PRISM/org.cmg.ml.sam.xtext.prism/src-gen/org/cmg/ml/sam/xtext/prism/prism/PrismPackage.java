/**
 */
package org.cmg.ml.sam.xtext.prism.prism;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.cmg.ml.sam.xtext.prism.prism.PrismFactory
 * @model kind="package"
 * @generated
 */
public interface PrismPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "prism";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.cmg.org/ml/sam/xtext/prism/Prism";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "prism";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PrismPackage eINSTANCE = org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl.init();

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.ModelImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__TYPE = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ELEMENTS = 1;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.ElementImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getElement()
   * @generated
   */
  int ELEMENT = 1;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.PathFormulaDeclarationImpl <em>Path Formula Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PathFormulaDeclarationImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getPathFormulaDeclaration()
   * @generated
   */
  int PATH_FORMULA_DECLARATION = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_FORMULA_DECLARATION__NAME = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Formula</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_FORMULA_DECLARATION__FORMULA = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Path Formula Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_FORMULA_DECLARATION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.StateFormulaDeclarationImpl <em>State Formula Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.StateFormulaDeclarationImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getStateFormulaDeclaration()
   * @generated
   */
  int STATE_FORMULA_DECLARATION = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_FORMULA_DECLARATION__NAME = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Formula</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_FORMULA_DECLARATION__FORMULA = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>State Formula Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_FORMULA_DECLARATION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.PathFormulaImpl <em>Path Formula</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PathFormulaImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getPathFormula()
   * @generated
   */
  int PATH_FORMULA = 4;

  /**
   * The number of structural features of the '<em>Path Formula</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_FORMULA_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.UntilFormulaImpl <em>Until Formula</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.UntilFormulaImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getUntilFormula()
   * @generated
   */
  int UNTIL_FORMULA = 5;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNTIL_FORMULA__LEFT = PATH_FORMULA_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Bound</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNTIL_FORMULA__BOUND = PATH_FORMULA_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNTIL_FORMULA__RIGHT = PATH_FORMULA_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Until Formula</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNTIL_FORMULA_FEATURE_COUNT = PATH_FORMULA_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.BoundImpl <em>Bound</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.BoundImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getBound()
   * @generated
   */
  int BOUND = 6;

  /**
   * The feature id for the '<em><b>Relop</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOUND__RELOP = 0;

  /**
   * The feature id for the '<em><b>Limit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOUND__LIMIT = 1;

  /**
   * The number of structural features of the '<em>Bound</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOUND_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.NextFormulaImpl <em>Next Formula</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.NextFormulaImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getNextFormula()
   * @generated
   */
  int NEXT_FORMULA = 7;

  /**
   * The feature id for the '<em><b>Arg</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEXT_FORMULA__ARG = PATH_FORMULA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Next Formula</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEXT_FORMULA_FEATURE_COUNT = PATH_FORMULA_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.StateFormulaImpl <em>State Formula</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.StateFormulaImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getStateFormula()
   * @generated
   */
  int STATE_FORMULA = 8;

  /**
   * The number of structural features of the '<em>State Formula</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_FORMULA_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ProbabilityFormulaImpl <em>Probability Formula</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.ProbabilityFormulaImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getProbabilityFormula()
   * @generated
   */
  int PROBABILITY_FORMULA = 9;

  /**
   * The feature id for the '<em><b>Relation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBABILITY_FORMULA__RELATION = STATE_FORMULA_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBABILITY_FORMULA__VALUE = STATE_FORMULA_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBABILITY_FORMULA__PATH = STATE_FORMULA_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Probability Formula</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBABILITY_FORMULA_FEATURE_COUNT = STATE_FORMULA_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.NegationFormulaImpl <em>Negation Formula</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.NegationFormulaImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getNegationFormula()
   * @generated
   */
  int NEGATION_FORMULA = 10;

  /**
   * The feature id for the '<em><b>Argument</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATION_FORMULA__ARGUMENT = STATE_FORMULA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Negation Formula</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATION_FORMULA_FEATURE_COUNT = STATE_FORMULA_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.AtomicStateFormulaImpl <em>Atomic State Formula</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.AtomicStateFormulaImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getAtomicStateFormula()
   * @generated
   */
  int ATOMIC_STATE_FORMULA = 11;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_STATE_FORMULA__EXP = STATE_FORMULA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Atomic State Formula</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_STATE_FORMULA_FEATURE_COUNT = STATE_FORMULA_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.PrismSystemImpl <em>System</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismSystemImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getPrismSystem()
   * @generated
   */
  int PRISM_SYSTEM = 12;

  /**
   * The number of structural features of the '<em>System</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRISM_SYSTEM_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ActionRenamingImpl <em>Action Renaming</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.ActionRenamingImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getActionRenaming()
   * @generated
   */
  int ACTION_RENAMING = 13;

  /**
   * The feature id for the '<em><b>Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_RENAMING__SOURCE = 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_RENAMING__TARGET = 1;

  /**
   * The number of structural features of the '<em>Action Renaming</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_RENAMING_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ModuleReferenceImpl <em>Module Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.ModuleReferenceImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getModuleReference()
   * @generated
   */
  int MODULE_REFERENCE = 14;

  /**
   * The feature id for the '<em><b>Module</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_REFERENCE__MODULE = PRISM_SYSTEM_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Module Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_REFERENCE_FEATURE_COUNT = PRISM_SYSTEM_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.VariableImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__TYPE = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__INIT = ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.LabelImpl <em>Label</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.LabelImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getLabel()
   * @generated
   */
  int LABEL = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABEL__NAME = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABEL__EXPRESSION = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Label</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABEL_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.FormulaImpl <em>Formula</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.FormulaImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getFormula()
   * @generated
   */
  int FORMULA = 17;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMULA__NAME = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMULA__EXPRESSION = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Formula</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMULA_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.InitPredicateImpl <em>Init Predicate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.InitPredicateImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getInitPredicate()
   * @generated
   */
  int INIT_PREDICATE = 18;

  /**
   * The feature id for the '<em><b>Predicate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_PREDICATE__PREDICATE = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Init Predicate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_PREDICATE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.RewardImpl <em>Reward</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.RewardImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getReward()
   * @generated
   */
  int REWARD = 19;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REWARD__LABEL = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Cases</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REWARD__CASES = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Reward</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REWARD_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.RewardCaseImpl <em>Reward Case</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.RewardCaseImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getRewardCase()
   * @generated
   */
  int REWARD_CASE = 20;

  /**
   * The feature id for the '<em><b>Action</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REWARD_CASE__ACTION = 0;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REWARD_CASE__GUARD = 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REWARD_CASE__VALUE = 2;

  /**
   * The number of structural features of the '<em>Reward Case</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REWARD_CASE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ConstantImpl <em>Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.ConstantImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getConstant()
   * @generated
   */
  int CONSTANT = 21;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__TYPE = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__NAME = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__EXP = ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ModuleImpl <em>Module</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.ModuleImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getModule()
   * @generated
   */
  int MODULE = 22;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__NAME = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__BODY = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ModuleBodyImpl <em>Module Body</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.ModuleBodyImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getModuleBody()
   * @generated
   */
  int MODULE_BODY = 23;

  /**
   * The number of structural features of the '<em>Module Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_BODY_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.VariableRenamingImpl <em>Variable Renaming</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.VariableRenamingImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getVariableRenaming()
   * @generated
   */
  int VARIABLE_RENAMING = 24;

  /**
   * The feature id for the '<em><b>Module</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_RENAMING__MODULE = MODULE_BODY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Renaming</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_RENAMING__RENAMING = MODULE_BODY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Variable Renaming</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_RENAMING_FEATURE_COUNT = MODULE_BODY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.SymbolRenamingImpl <em>Symbol Renaming</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.SymbolRenamingImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getSymbolRenaming()
   * @generated
   */
  int SYMBOL_RENAMING = 25;

  /**
   * The feature id for the '<em><b>Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYMBOL_RENAMING__SOURCE = 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYMBOL_RENAMING__TARGET = 1;

  /**
   * The number of structural features of the '<em>Symbol Renaming</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYMBOL_RENAMING_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ModuleBodyDeclarationImpl <em>Module Body Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.ModuleBodyDeclarationImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getModuleBodyDeclaration()
   * @generated
   */
  int MODULE_BODY_DECLARATION = 26;

  /**
   * The feature id for the '<em><b>Variables</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_BODY_DECLARATION__VARIABLES = MODULE_BODY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Commands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_BODY_DECLARATION__COMMANDS = MODULE_BODY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Module Body Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_BODY_DECLARATION_FEATURE_COUNT = MODULE_BODY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.CommandImpl <em>Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.CommandImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getCommand()
   * @generated
   */
  int COMMAND = 27;

  /**
   * The feature id for the '<em><b>Act</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND__ACT = 0;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND__GUARD = 1;

  /**
   * The feature id for the '<em><b>Updates</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND__UPDATES = 2;

  /**
   * The number of structural features of the '<em>Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.UpdateImpl <em>Update</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.UpdateImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getUpdate()
   * @generated
   */
  int UPDATE = 28;

  /**
   * The feature id for the '<em><b>Weight</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPDATE__WEIGHT = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPDATE__ELEMENTS = 1;

  /**
   * The number of structural features of the '<em>Update</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPDATE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.UpdateElementImpl <em>Update Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.UpdateElementImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getUpdateElement()
   * @generated
   */
  int UPDATE_ELEMENT = 29;

  /**
   * The feature id for the '<em><b>Variable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPDATE_ELEMENT__VARIABLE = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPDATE_ELEMENT__EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Update Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPDATE_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.TypeImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getType()
   * @generated
   */
  int TYPE = 30;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.IntervalTypeImpl <em>Interval Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.IntervalTypeImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getIntervalType()
   * @generated
   */
  int INTERVAL_TYPE = 31;

  /**
   * The feature id for the '<em><b>Min</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL_TYPE__MIN = TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Max</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL_TYPE__MAX = TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Interval Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.BooleanTypeImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getBooleanType()
   * @generated
   */
  int BOOLEAN_TYPE = 32;

  /**
   * The number of structural features of the '<em>Boolean Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.ExpressionImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 33;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.LogFunctionImpl <em>Log Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.LogFunctionImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getLogFunction()
   * @generated
   */
  int LOG_FUNCTION = 34;

  /**
   * The feature id for the '<em><b>Argument</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOG_FUNCTION__ARGUMENT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Base</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOG_FUNCTION__BASE = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Log Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOG_FUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ModFunctionImpl <em>Mod Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.ModFunctionImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getModFunction()
   * @generated
   */
  int MOD_FUNCTION = 35;

  /**
   * The feature id for the '<em><b>Dividend</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOD_FUNCTION__DIVIDEND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Divisor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOD_FUNCTION__DIVISOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Mod Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOD_FUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.CeilFunctionImpl <em>Ceil Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.CeilFunctionImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getCeilFunction()
   * @generated
   */
  int CEIL_FUNCTION = 36;

  /**
   * The feature id for the '<em><b>Arg</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CEIL_FUNCTION__ARG = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Ceil Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CEIL_FUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.FloorFunctionImpl <em>Floor Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.FloorFunctionImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getFloorFunction()
   * @generated
   */
  int FLOOR_FUNCTION = 37;

  /**
   * The feature id for the '<em><b>Arg</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOOR_FUNCTION__ARG = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Floor Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOOR_FUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.PowFunctionImpl <em>Pow Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PowFunctionImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getPowFunction()
   * @generated
   */
  int POW_FUNCTION = 38;

  /**
   * The feature id for the '<em><b>Base</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POW_FUNCTION__BASE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Exponent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POW_FUNCTION__EXPONENT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Pow Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POW_FUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.MaxFunctionImpl <em>Max Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.MaxFunctionImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getMaxFunction()
   * @generated
   */
  int MAX_FUNCTION = 39;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAX_FUNCTION__ARGS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Max Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAX_FUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.MinFunctionImpl <em>Min Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.MinFunctionImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getMinFunction()
   * @generated
   */
  int MIN_FUNCTION = 40;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIN_FUNCTION__ARGS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Min Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIN_FUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.TrueImpl <em>True</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.TrueImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getTrue()
   * @generated
   */
  int TRUE = 41;

  /**
   * The number of structural features of the '<em>True</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.FalseImpl <em>False</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.FalseImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getFalse()
   * @generated
   */
  int FALSE = 42;

  /**
   * The number of structural features of the '<em>False</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FALSE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ReferenceImpl <em>Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.ReferenceImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getReference()
   * @generated
   */
  int REFERENCE = 43;

  /**
   * The feature id for the '<em><b>Reference</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__REFERENCE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.NumericalValueImpl <em>Numerical Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.NumericalValueImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getNumericalValue()
   * @generated
   */
  int NUMERICAL_VALUE = 44;

  /**
   * The number of structural features of the '<em>Numerical Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_VALUE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.IntegerLiteralImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getIntegerLiteral()
   * @generated
   */
  int INTEGER_LITERAL = 45;

  /**
   * The feature id for the '<em><b>Integer Part</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_LITERAL__INTEGER_PART = NUMERICAL_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Integer Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_LITERAL_FEATURE_COUNT = NUMERICAL_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.StateOrImpl <em>State Or</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.StateOrImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getStateOr()
   * @generated
   */
  int STATE_OR = 46;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_OR__LEFT = STATE_FORMULA_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_OR__RIGHT = STATE_FORMULA_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>State Or</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_OR_FEATURE_COUNT = STATE_FORMULA_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.StateAndImpl <em>State And</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.StateAndImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getStateAnd()
   * @generated
   */
  int STATE_AND = 47;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_AND__LEFT = STATE_FORMULA_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_AND__RIGHT = STATE_FORMULA_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>State And</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_AND_FEATURE_COUNT = STATE_FORMULA_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.AlphabetisedParallelCompositionImpl <em>Alphabetised Parallel Composition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.AlphabetisedParallelCompositionImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getAlphabetisedParallelComposition()
   * @generated
   */
  int ALPHABETISED_PARALLEL_COMPOSITION = 48;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALPHABETISED_PARALLEL_COMPOSITION__LEFT = PRISM_SYSTEM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALPHABETISED_PARALLEL_COMPOSITION__RIGHT = PRISM_SYSTEM_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Alphabetised Parallel Composition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALPHABETISED_PARALLEL_COMPOSITION_FEATURE_COUNT = PRISM_SYSTEM_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.AsynchronousParallelCompositionImpl <em>Asynchronous Parallel Composition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.AsynchronousParallelCompositionImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getAsynchronousParallelComposition()
   * @generated
   */
  int ASYNCHRONOUS_PARALLEL_COMPOSITION = 49;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASYNCHRONOUS_PARALLEL_COMPOSITION__LEFT = PRISM_SYSTEM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASYNCHRONOUS_PARALLEL_COMPOSITION__RIGHT = PRISM_SYSTEM_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Asynchronous Parallel Composition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASYNCHRONOUS_PARALLEL_COMPOSITION_FEATURE_COUNT = PRISM_SYSTEM_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.RestrictedParallelCompositionImpl <em>Restricted Parallel Composition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.RestrictedParallelCompositionImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getRestrictedParallelComposition()
   * @generated
   */
  int RESTRICTED_PARALLEL_COMPOSITION = 50;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESTRICTED_PARALLEL_COMPOSITION__LEFT = PRISM_SYSTEM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Actions</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESTRICTED_PARALLEL_COMPOSITION__ACTIONS = PRISM_SYSTEM_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESTRICTED_PARALLEL_COMPOSITION__RIGHT = PRISM_SYSTEM_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Restricted Parallel Composition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESTRICTED_PARALLEL_COMPOSITION_FEATURE_COUNT = PRISM_SYSTEM_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.HidingImpl <em>Hiding</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.HidingImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getHiding()
   * @generated
   */
  int HIDING = 51;

  /**
   * The feature id for the '<em><b>Argument</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HIDING__ARGUMENT = PRISM_SYSTEM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Actions</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HIDING__ACTIONS = PRISM_SYSTEM_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Hiding</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HIDING_FEATURE_COUNT = PRISM_SYSTEM_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.RenamingImpl <em>Renaming</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.RenamingImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getRenaming()
   * @generated
   */
  int RENAMING = 52;

  /**
   * The feature id for the '<em><b>Argument</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RENAMING__ARGUMENT = PRISM_SYSTEM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Renaming</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RENAMING__RENAMING = PRISM_SYSTEM_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Renaming</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RENAMING_FEATURE_COUNT = PRISM_SYSTEM_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.IfThenElseImpl <em>If Then Else</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.IfThenElseImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getIfThenElse()
   * @generated
   */
  int IF_THEN_ELSE = 53;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE__GUARD = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then Case</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE__THEN_CASE = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else Case</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE__ELSE_CASE = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>If Then Else</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ImpliesImpl <em>Implies</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.ImpliesImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getImplies()
   * @generated
   */
  int IMPLIES = 54;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLIES__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLIES__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Implies</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLIES_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.IfAndOnlyIfImpl <em>If And Only If</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.IfAndOnlyIfImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getIfAndOnlyIf()
   * @generated
   */
  int IF_AND_ONLY_IF = 55;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_AND_ONLY_IF__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_AND_ONLY_IF__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>If And Only If</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_AND_ONLY_IF_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.OrExpressionImpl <em>Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.OrExpressionImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getOrExpression()
   * @generated
   */
  int OR_EXPRESSION = 56;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.AndExpressionImpl <em>And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.AndExpressionImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getAndExpression()
   * @generated
   */
  int AND_EXPRESSION = 57;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.NegationImpl <em>Negation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.NegationImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getNegation()
   * @generated
   */
  int NEGATION = 58;

  /**
   * The feature id for the '<em><b>Arg</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATION__ARG = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Negation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.RelExpressionImpl <em>Rel Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.RelExpressionImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getRelExpression()
   * @generated
   */
  int REL_EXPRESSION = 59;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REL_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Relop</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REL_EXPRESSION__RELOP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REL_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Rel Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.SumExpressionImpl <em>Sum Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.SumExpressionImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getSumExpression()
   * @generated
   */
  int SUM_EXPRESSION = 60;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Sum Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.MulExpressionImpl <em>Mul Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.MulExpressionImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getMulExpression()
   * @generated
   */
  int MUL_EXPRESSION = 61;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUL_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUL_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUL_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Mul Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.DecimalLiteralImpl <em>Decimal Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.DecimalLiteralImpl
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getDecimalLiteral()
   * @generated
   */
  int DECIMAL_LITERAL = 62;

  /**
   * The feature id for the '<em><b>Integer Part</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECIMAL_LITERAL__INTEGER_PART = NUMERICAL_VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Decimal Part</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECIMAL_LITERAL__DECIMAL_PART = NUMERICAL_VALUE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Decimal Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECIMAL_LITERAL_FEATURE_COUNT = NUMERICAL_VALUE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.ConstantType <em>Constant Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.ConstantType
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getConstantType()
   * @generated
   */
  int CONSTANT_TYPE = 63;

  /**
   * The meta object id for the '{@link org.cmg.ml.sam.xtext.prism.prism.Relations <em>Relations</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.cmg.ml.sam.xtext.prism.prism.Relations
   * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getRelations()
   * @generated
   */
  int RELATIONS = 64;


  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.Model#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Model#getType()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Type();

  /**
   * Returns the meta object for the containment reference list '{@link org.cmg.ml.sam.xtext.prism.prism.Model#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Model#getElements()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Elements();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Element
   * @generated
   */
  EClass getElement();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.PathFormulaDeclaration <em>Path Formula Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Path Formula Declaration</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.PathFormulaDeclaration
   * @generated
   */
  EClass getPathFormulaDeclaration();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.PathFormulaDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.PathFormulaDeclaration#getName()
   * @see #getPathFormulaDeclaration()
   * @generated
   */
  EAttribute getPathFormulaDeclaration_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.PathFormulaDeclaration#getFormula <em>Formula</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Formula</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.PathFormulaDeclaration#getFormula()
   * @see #getPathFormulaDeclaration()
   * @generated
   */
  EReference getPathFormulaDeclaration_Formula();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.StateFormulaDeclaration <em>State Formula Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Formula Declaration</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.StateFormulaDeclaration
   * @generated
   */
  EClass getStateFormulaDeclaration();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.StateFormulaDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.StateFormulaDeclaration#getName()
   * @see #getStateFormulaDeclaration()
   * @generated
   */
  EAttribute getStateFormulaDeclaration_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.StateFormulaDeclaration#getFormula <em>Formula</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Formula</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.StateFormulaDeclaration#getFormula()
   * @see #getStateFormulaDeclaration()
   * @generated
   */
  EReference getStateFormulaDeclaration_Formula();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.PathFormula <em>Path Formula</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Path Formula</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.PathFormula
   * @generated
   */
  EClass getPathFormula();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.UntilFormula <em>Until Formula</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Until Formula</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.UntilFormula
   * @generated
   */
  EClass getUntilFormula();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.UntilFormula#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.UntilFormula#getLeft()
   * @see #getUntilFormula()
   * @generated
   */
  EReference getUntilFormula_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.UntilFormula#getBound <em>Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Bound</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.UntilFormula#getBound()
   * @see #getUntilFormula()
   * @generated
   */
  EReference getUntilFormula_Bound();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.UntilFormula#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.UntilFormula#getRight()
   * @see #getUntilFormula()
   * @generated
   */
  EReference getUntilFormula_Right();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.Bound <em>Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bound</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Bound
   * @generated
   */
  EClass getBound();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.Bound#getRelop <em>Relop</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Relop</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Bound#getRelop()
   * @see #getBound()
   * @generated
   */
  EAttribute getBound_Relop();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.Bound#getLimit <em>Limit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Limit</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Bound#getLimit()
   * @see #getBound()
   * @generated
   */
  EAttribute getBound_Limit();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.NextFormula <em>Next Formula</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Next Formula</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.NextFormula
   * @generated
   */
  EClass getNextFormula();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.NextFormula#getArg <em>Arg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Arg</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.NextFormula#getArg()
   * @see #getNextFormula()
   * @generated
   */
  EReference getNextFormula_Arg();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.StateFormula <em>State Formula</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Formula</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.StateFormula
   * @generated
   */
  EClass getStateFormula();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.ProbabilityFormula <em>Probability Formula</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Probability Formula</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.ProbabilityFormula
   * @generated
   */
  EClass getProbabilityFormula();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.ProbabilityFormula#getRelation <em>Relation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Relation</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.ProbabilityFormula#getRelation()
   * @see #getProbabilityFormula()
   * @generated
   */
  EAttribute getProbabilityFormula_Relation();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.ProbabilityFormula#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.ProbabilityFormula#getValue()
   * @see #getProbabilityFormula()
   * @generated
   */
  EReference getProbabilityFormula_Value();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.ProbabilityFormula#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Path</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.ProbabilityFormula#getPath()
   * @see #getProbabilityFormula()
   * @generated
   */
  EReference getProbabilityFormula_Path();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.NegationFormula <em>Negation Formula</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Negation Formula</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.NegationFormula
   * @generated
   */
  EClass getNegationFormula();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.NegationFormula#getArgument <em>Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Argument</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.NegationFormula#getArgument()
   * @see #getNegationFormula()
   * @generated
   */
  EReference getNegationFormula_Argument();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.AtomicStateFormula <em>Atomic State Formula</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atomic State Formula</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.AtomicStateFormula
   * @generated
   */
  EClass getAtomicStateFormula();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.AtomicStateFormula#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.AtomicStateFormula#getExp()
   * @see #getAtomicStateFormula()
   * @generated
   */
  EReference getAtomicStateFormula_Exp();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.PrismSystem <em>System</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>System</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismSystem
   * @generated
   */
  EClass getPrismSystem();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.ActionRenaming <em>Action Renaming</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action Renaming</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.ActionRenaming
   * @generated
   */
  EClass getActionRenaming();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.ActionRenaming#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Source</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.ActionRenaming#getSource()
   * @see #getActionRenaming()
   * @generated
   */
  EAttribute getActionRenaming_Source();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.ActionRenaming#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.ActionRenaming#getTarget()
   * @see #getActionRenaming()
   * @generated
   */
  EAttribute getActionRenaming_Target();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.ModuleReference <em>Module Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module Reference</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.ModuleReference
   * @generated
   */
  EClass getModuleReference();

  /**
   * Returns the meta object for the reference '{@link org.cmg.ml.sam.xtext.prism.prism.ModuleReference#getModule <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Module</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.ModuleReference#getModule()
   * @see #getModuleReference()
   * @generated
   */
  EReference getModuleReference_Module();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.Variable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Variable#getName()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.Variable#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Variable#getType()
   * @see #getVariable()
   * @generated
   */
  EReference getVariable_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.Variable#getInit <em>Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Variable#getInit()
   * @see #getVariable()
   * @generated
   */
  EReference getVariable_Init();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.Label <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Label</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Label
   * @generated
   */
  EClass getLabel();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.Label#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Label#getName()
   * @see #getLabel()
   * @generated
   */
  EAttribute getLabel_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.Label#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Label#getExpression()
   * @see #getLabel()
   * @generated
   */
  EReference getLabel_Expression();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.Formula <em>Formula</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Formula</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Formula
   * @generated
   */
  EClass getFormula();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.Formula#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Formula#getName()
   * @see #getFormula()
   * @generated
   */
  EAttribute getFormula_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.Formula#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Formula#getExpression()
   * @see #getFormula()
   * @generated
   */
  EReference getFormula_Expression();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.InitPredicate <em>Init Predicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Init Predicate</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.InitPredicate
   * @generated
   */
  EClass getInitPredicate();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.InitPredicate#getPredicate <em>Predicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Predicate</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.InitPredicate#getPredicate()
   * @see #getInitPredicate()
   * @generated
   */
  EReference getInitPredicate_Predicate();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.Reward <em>Reward</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reward</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Reward
   * @generated
   */
  EClass getReward();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.Reward#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Reward#getLabel()
   * @see #getReward()
   * @generated
   */
  EAttribute getReward_Label();

  /**
   * Returns the meta object for the containment reference list '{@link org.cmg.ml.sam.xtext.prism.prism.Reward#getCases <em>Cases</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Cases</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Reward#getCases()
   * @see #getReward()
   * @generated
   */
  EReference getReward_Cases();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.RewardCase <em>Reward Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reward Case</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.RewardCase
   * @generated
   */
  EClass getRewardCase();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.RewardCase#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Action</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.RewardCase#getAction()
   * @see #getRewardCase()
   * @generated
   */
  EAttribute getRewardCase_Action();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.RewardCase#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.RewardCase#getGuard()
   * @see #getRewardCase()
   * @generated
   */
  EReference getRewardCase_Guard();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.RewardCase#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.RewardCase#getValue()
   * @see #getRewardCase()
   * @generated
   */
  EReference getRewardCase_Value();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.Constant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Constant
   * @generated
   */
  EClass getConstant();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.Constant#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Constant#getType()
   * @see #getConstant()
   * @generated
   */
  EAttribute getConstant_Type();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.Constant#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Constant#getName()
   * @see #getConstant()
   * @generated
   */
  EAttribute getConstant_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.Constant#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Constant#getExp()
   * @see #getConstant()
   * @generated
   */
  EReference getConstant_Exp();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.Module <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Module
   * @generated
   */
  EClass getModule();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.Module#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Module#getName()
   * @see #getModule()
   * @generated
   */
  EAttribute getModule_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.Module#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Module#getBody()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Body();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.ModuleBody <em>Module Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module Body</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.ModuleBody
   * @generated
   */
  EClass getModuleBody();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.VariableRenaming <em>Variable Renaming</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Renaming</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.VariableRenaming
   * @generated
   */
  EClass getVariableRenaming();

  /**
   * Returns the meta object for the reference '{@link org.cmg.ml.sam.xtext.prism.prism.VariableRenaming#getModule <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Module</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.VariableRenaming#getModule()
   * @see #getVariableRenaming()
   * @generated
   */
  EReference getVariableRenaming_Module();

  /**
   * Returns the meta object for the containment reference list '{@link org.cmg.ml.sam.xtext.prism.prism.VariableRenaming#getRenaming <em>Renaming</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Renaming</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.VariableRenaming#getRenaming()
   * @see #getVariableRenaming()
   * @generated
   */
  EReference getVariableRenaming_Renaming();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.SymbolRenaming <em>Symbol Renaming</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Symbol Renaming</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.SymbolRenaming
   * @generated
   */
  EClass getSymbolRenaming();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.SymbolRenaming#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Source</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.SymbolRenaming#getSource()
   * @see #getSymbolRenaming()
   * @generated
   */
  EAttribute getSymbolRenaming_Source();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.SymbolRenaming#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.SymbolRenaming#getTarget()
   * @see #getSymbolRenaming()
   * @generated
   */
  EAttribute getSymbolRenaming_Target();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.ModuleBodyDeclaration <em>Module Body Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module Body Declaration</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.ModuleBodyDeclaration
   * @generated
   */
  EClass getModuleBodyDeclaration();

  /**
   * Returns the meta object for the containment reference list '{@link org.cmg.ml.sam.xtext.prism.prism.ModuleBodyDeclaration#getVariables <em>Variables</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Variables</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.ModuleBodyDeclaration#getVariables()
   * @see #getModuleBodyDeclaration()
   * @generated
   */
  EReference getModuleBodyDeclaration_Variables();

  /**
   * Returns the meta object for the containment reference list '{@link org.cmg.ml.sam.xtext.prism.prism.ModuleBodyDeclaration#getCommands <em>Commands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Commands</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.ModuleBodyDeclaration#getCommands()
   * @see #getModuleBodyDeclaration()
   * @generated
   */
  EReference getModuleBodyDeclaration_Commands();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.Command <em>Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Command</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Command
   * @generated
   */
  EClass getCommand();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.Command#getAct <em>Act</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Act</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Command#getAct()
   * @see #getCommand()
   * @generated
   */
  EAttribute getCommand_Act();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.Command#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Command#getGuard()
   * @see #getCommand()
   * @generated
   */
  EReference getCommand_Guard();

  /**
   * Returns the meta object for the containment reference list '{@link org.cmg.ml.sam.xtext.prism.prism.Command#getUpdates <em>Updates</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Updates</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Command#getUpdates()
   * @see #getCommand()
   * @generated
   */
  EReference getCommand_Updates();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.Update <em>Update</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Update</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Update
   * @generated
   */
  EClass getUpdate();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.Update#getWeight <em>Weight</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Weight</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Update#getWeight()
   * @see #getUpdate()
   * @generated
   */
  EReference getUpdate_Weight();

  /**
   * Returns the meta object for the containment reference list '{@link org.cmg.ml.sam.xtext.prism.prism.Update#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Update#getElements()
   * @see #getUpdate()
   * @generated
   */
  EReference getUpdate_Elements();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.UpdateElement <em>Update Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Update Element</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.UpdateElement
   * @generated
   */
  EClass getUpdateElement();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.UpdateElement#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Variable</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.UpdateElement#getVariable()
   * @see #getUpdateElement()
   * @generated
   */
  EAttribute getUpdateElement_Variable();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.UpdateElement#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.UpdateElement#getExpression()
   * @see #getUpdateElement()
   * @generated
   */
  EReference getUpdateElement_Expression();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.IntervalType <em>Interval Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interval Type</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.IntervalType
   * @generated
   */
  EClass getIntervalType();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.IntervalType#getMin <em>Min</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Min</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.IntervalType#getMin()
   * @see #getIntervalType()
   * @generated
   */
  EReference getIntervalType_Min();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.IntervalType#getMax <em>Max</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Max</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.IntervalType#getMax()
   * @see #getIntervalType()
   * @generated
   */
  EReference getIntervalType_Max();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.BooleanType <em>Boolean Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Type</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.BooleanType
   * @generated
   */
  EClass getBooleanType();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.LogFunction <em>Log Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Log Function</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.LogFunction
   * @generated
   */
  EClass getLogFunction();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.LogFunction#getArgument <em>Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Argument</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.LogFunction#getArgument()
   * @see #getLogFunction()
   * @generated
   */
  EReference getLogFunction_Argument();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.LogFunction#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Base</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.LogFunction#getBase()
   * @see #getLogFunction()
   * @generated
   */
  EReference getLogFunction_Base();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.ModFunction <em>Mod Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mod Function</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.ModFunction
   * @generated
   */
  EClass getModFunction();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.ModFunction#getDividend <em>Dividend</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Dividend</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.ModFunction#getDividend()
   * @see #getModFunction()
   * @generated
   */
  EReference getModFunction_Dividend();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.ModFunction#getDivisor <em>Divisor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Divisor</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.ModFunction#getDivisor()
   * @see #getModFunction()
   * @generated
   */
  EReference getModFunction_Divisor();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.CeilFunction <em>Ceil Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ceil Function</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.CeilFunction
   * @generated
   */
  EClass getCeilFunction();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.CeilFunction#getArg <em>Arg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Arg</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.CeilFunction#getArg()
   * @see #getCeilFunction()
   * @generated
   */
  EReference getCeilFunction_Arg();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.FloorFunction <em>Floor Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Floor Function</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.FloorFunction
   * @generated
   */
  EClass getFloorFunction();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.FloorFunction#getArg <em>Arg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Arg</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.FloorFunction#getArg()
   * @see #getFloorFunction()
   * @generated
   */
  EReference getFloorFunction_Arg();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.PowFunction <em>Pow Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pow Function</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.PowFunction
   * @generated
   */
  EClass getPowFunction();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.PowFunction#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Base</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.PowFunction#getBase()
   * @see #getPowFunction()
   * @generated
   */
  EReference getPowFunction_Base();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.PowFunction#getExponent <em>Exponent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exponent</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.PowFunction#getExponent()
   * @see #getPowFunction()
   * @generated
   */
  EReference getPowFunction_Exponent();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.MaxFunction <em>Max Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Max Function</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.MaxFunction
   * @generated
   */
  EClass getMaxFunction();

  /**
   * Returns the meta object for the containment reference list '{@link org.cmg.ml.sam.xtext.prism.prism.MaxFunction#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.MaxFunction#getArgs()
   * @see #getMaxFunction()
   * @generated
   */
  EReference getMaxFunction_Args();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.MinFunction <em>Min Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Min Function</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.MinFunction
   * @generated
   */
  EClass getMinFunction();

  /**
   * Returns the meta object for the containment reference list '{@link org.cmg.ml.sam.xtext.prism.prism.MinFunction#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.MinFunction#getArgs()
   * @see #getMinFunction()
   * @generated
   */
  EReference getMinFunction_Args();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.True <em>True</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>True</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.True
   * @generated
   */
  EClass getTrue();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.False <em>False</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>False</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.False
   * @generated
   */
  EClass getFalse();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.Reference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Reference
   * @generated
   */
  EClass getReference();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.Reference#getReference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Reference</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Reference#getReference()
   * @see #getReference()
   * @generated
   */
  EAttribute getReference_Reference();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.NumericalValue <em>Numerical Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numerical Value</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.NumericalValue
   * @generated
   */
  EClass getNumericalValue();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.IntegerLiteral <em>Integer Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Literal</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.IntegerLiteral
   * @generated
   */
  EClass getIntegerLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.IntegerLiteral#getIntegerPart <em>Integer Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Integer Part</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.IntegerLiteral#getIntegerPart()
   * @see #getIntegerLiteral()
   * @generated
   */
  EAttribute getIntegerLiteral_IntegerPart();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.StateOr <em>State Or</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Or</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.StateOr
   * @generated
   */
  EClass getStateOr();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.StateOr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.StateOr#getLeft()
   * @see #getStateOr()
   * @generated
   */
  EReference getStateOr_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.StateOr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.StateOr#getRight()
   * @see #getStateOr()
   * @generated
   */
  EReference getStateOr_Right();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.StateAnd <em>State And</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State And</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.StateAnd
   * @generated
   */
  EClass getStateAnd();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.StateAnd#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.StateAnd#getLeft()
   * @see #getStateAnd()
   * @generated
   */
  EReference getStateAnd_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.StateAnd#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.StateAnd#getRight()
   * @see #getStateAnd()
   * @generated
   */
  EReference getStateAnd_Right();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.AlphabetisedParallelComposition <em>Alphabetised Parallel Composition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alphabetised Parallel Composition</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.AlphabetisedParallelComposition
   * @generated
   */
  EClass getAlphabetisedParallelComposition();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.AlphabetisedParallelComposition#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.AlphabetisedParallelComposition#getLeft()
   * @see #getAlphabetisedParallelComposition()
   * @generated
   */
  EReference getAlphabetisedParallelComposition_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.AlphabetisedParallelComposition#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.AlphabetisedParallelComposition#getRight()
   * @see #getAlphabetisedParallelComposition()
   * @generated
   */
  EReference getAlphabetisedParallelComposition_Right();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.AsynchronousParallelComposition <em>Asynchronous Parallel Composition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Asynchronous Parallel Composition</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.AsynchronousParallelComposition
   * @generated
   */
  EClass getAsynchronousParallelComposition();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.AsynchronousParallelComposition#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.AsynchronousParallelComposition#getLeft()
   * @see #getAsynchronousParallelComposition()
   * @generated
   */
  EReference getAsynchronousParallelComposition_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.AsynchronousParallelComposition#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.AsynchronousParallelComposition#getRight()
   * @see #getAsynchronousParallelComposition()
   * @generated
   */
  EReference getAsynchronousParallelComposition_Right();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.RestrictedParallelComposition <em>Restricted Parallel Composition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Restricted Parallel Composition</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.RestrictedParallelComposition
   * @generated
   */
  EClass getRestrictedParallelComposition();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.RestrictedParallelComposition#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.RestrictedParallelComposition#getLeft()
   * @see #getRestrictedParallelComposition()
   * @generated
   */
  EReference getRestrictedParallelComposition_Left();

  /**
   * Returns the meta object for the attribute list '{@link org.cmg.ml.sam.xtext.prism.prism.RestrictedParallelComposition#getActions <em>Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Actions</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.RestrictedParallelComposition#getActions()
   * @see #getRestrictedParallelComposition()
   * @generated
   */
  EAttribute getRestrictedParallelComposition_Actions();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.RestrictedParallelComposition#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.RestrictedParallelComposition#getRight()
   * @see #getRestrictedParallelComposition()
   * @generated
   */
  EReference getRestrictedParallelComposition_Right();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.Hiding <em>Hiding</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Hiding</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Hiding
   * @generated
   */
  EClass getHiding();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.Hiding#getArgument <em>Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Argument</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Hiding#getArgument()
   * @see #getHiding()
   * @generated
   */
  EReference getHiding_Argument();

  /**
   * Returns the meta object for the attribute list '{@link org.cmg.ml.sam.xtext.prism.prism.Hiding#getActions <em>Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Actions</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Hiding#getActions()
   * @see #getHiding()
   * @generated
   */
  EAttribute getHiding_Actions();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.Renaming <em>Renaming</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Renaming</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Renaming
   * @generated
   */
  EClass getRenaming();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.Renaming#getArgument <em>Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Argument</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Renaming#getArgument()
   * @see #getRenaming()
   * @generated
   */
  EReference getRenaming_Argument();

  /**
   * Returns the meta object for the containment reference list '{@link org.cmg.ml.sam.xtext.prism.prism.Renaming#getRenaming <em>Renaming</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Renaming</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Renaming#getRenaming()
   * @see #getRenaming()
   * @generated
   */
  EReference getRenaming_Renaming();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.IfThenElse <em>If Then Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Then Else</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.IfThenElse
   * @generated
   */
  EClass getIfThenElse();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.IfThenElse#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.IfThenElse#getGuard()
   * @see #getIfThenElse()
   * @generated
   */
  EReference getIfThenElse_Guard();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.IfThenElse#getThenCase <em>Then Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then Case</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.IfThenElse#getThenCase()
   * @see #getIfThenElse()
   * @generated
   */
  EReference getIfThenElse_ThenCase();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.IfThenElse#getElseCase <em>Else Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else Case</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.IfThenElse#getElseCase()
   * @see #getIfThenElse()
   * @generated
   */
  EReference getIfThenElse_ElseCase();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.Implies <em>Implies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Implies</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Implies
   * @generated
   */
  EClass getImplies();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.Implies#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Implies#getLeft()
   * @see #getImplies()
   * @generated
   */
  EReference getImplies_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.Implies#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Implies#getRight()
   * @see #getImplies()
   * @generated
   */
  EReference getImplies_Right();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.IfAndOnlyIf <em>If And Only If</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If And Only If</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.IfAndOnlyIf
   * @generated
   */
  EClass getIfAndOnlyIf();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.IfAndOnlyIf#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.IfAndOnlyIf#getLeft()
   * @see #getIfAndOnlyIf()
   * @generated
   */
  EReference getIfAndOnlyIf_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.IfAndOnlyIf#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.IfAndOnlyIf#getRight()
   * @see #getIfAndOnlyIf()
   * @generated
   */
  EReference getIfAndOnlyIf_Right();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.OrExpression <em>Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Expression</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.OrExpression
   * @generated
   */
  EClass getOrExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.OrExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.OrExpression#getLeft()
   * @see #getOrExpression()
   * @generated
   */
  EReference getOrExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.OrExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.OrExpression#getRight()
   * @see #getOrExpression()
   * @generated
   */
  EReference getOrExpression_Right();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Expression</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.AndExpression
   * @generated
   */
  EClass getAndExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.AndExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.AndExpression#getLeft()
   * @see #getAndExpression()
   * @generated
   */
  EReference getAndExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.AndExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.AndExpression#getRight()
   * @see #getAndExpression()
   * @generated
   */
  EReference getAndExpression_Right();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.Negation <em>Negation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Negation</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Negation
   * @generated
   */
  EClass getNegation();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.Negation#getArg <em>Arg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Arg</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Negation#getArg()
   * @see #getNegation()
   * @generated
   */
  EReference getNegation_Arg();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.RelExpression <em>Rel Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rel Expression</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.RelExpression
   * @generated
   */
  EClass getRelExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.RelExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.RelExpression#getLeft()
   * @see #getRelExpression()
   * @generated
   */
  EReference getRelExpression_Left();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.RelExpression#getRelop <em>Relop</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Relop</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.RelExpression#getRelop()
   * @see #getRelExpression()
   * @generated
   */
  EAttribute getRelExpression_Relop();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.RelExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.RelExpression#getRight()
   * @see #getRelExpression()
   * @generated
   */
  EReference getRelExpression_Right();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.SumExpression <em>Sum Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sum Expression</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.SumExpression
   * @generated
   */
  EClass getSumExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.SumExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.SumExpression#getLeft()
   * @see #getSumExpression()
   * @generated
   */
  EReference getSumExpression_Left();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.SumExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.SumExpression#getOp()
   * @see #getSumExpression()
   * @generated
   */
  EAttribute getSumExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.SumExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.SumExpression#getRight()
   * @see #getSumExpression()
   * @generated
   */
  EReference getSumExpression_Right();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.MulExpression <em>Mul Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mul Expression</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.MulExpression
   * @generated
   */
  EClass getMulExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.MulExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.MulExpression#getLeft()
   * @see #getMulExpression()
   * @generated
   */
  EReference getMulExpression_Left();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.MulExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.MulExpression#getOp()
   * @see #getMulExpression()
   * @generated
   */
  EAttribute getMulExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.MulExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.MulExpression#getRight()
   * @see #getMulExpression()
   * @generated
   */
  EReference getMulExpression_Right();

  /**
   * Returns the meta object for class '{@link org.cmg.ml.sam.xtext.prism.prism.DecimalLiteral <em>Decimal Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decimal Literal</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.DecimalLiteral
   * @generated
   */
  EClass getDecimalLiteral();

  /**
   * Returns the meta object for the containment reference '{@link org.cmg.ml.sam.xtext.prism.prism.DecimalLiteral#getIntegerPart <em>Integer Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Integer Part</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.DecimalLiteral#getIntegerPart()
   * @see #getDecimalLiteral()
   * @generated
   */
  EReference getDecimalLiteral_IntegerPart();

  /**
   * Returns the meta object for the attribute '{@link org.cmg.ml.sam.xtext.prism.prism.DecimalLiteral#getDecimalPart <em>Decimal Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Decimal Part</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.DecimalLiteral#getDecimalPart()
   * @see #getDecimalLiteral()
   * @generated
   */
  EAttribute getDecimalLiteral_DecimalPart();

  /**
   * Returns the meta object for enum '{@link org.cmg.ml.sam.xtext.prism.prism.ConstantType <em>Constant Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Constant Type</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.ConstantType
   * @generated
   */
  EEnum getConstantType();

  /**
   * Returns the meta object for enum '{@link org.cmg.ml.sam.xtext.prism.prism.Relations <em>Relations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Relations</em>'.
   * @see org.cmg.ml.sam.xtext.prism.prism.Relations
   * @generated
   */
  EEnum getRelations();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PrismFactory getPrismFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.ModelImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__TYPE = eINSTANCE.getModel_Type();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ELEMENTS = eINSTANCE.getModel_Elements();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.ElementImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getElement()
     * @generated
     */
    EClass ELEMENT = eINSTANCE.getElement();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.PathFormulaDeclarationImpl <em>Path Formula Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PathFormulaDeclarationImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getPathFormulaDeclaration()
     * @generated
     */
    EClass PATH_FORMULA_DECLARATION = eINSTANCE.getPathFormulaDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATH_FORMULA_DECLARATION__NAME = eINSTANCE.getPathFormulaDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Formula</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATH_FORMULA_DECLARATION__FORMULA = eINSTANCE.getPathFormulaDeclaration_Formula();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.StateFormulaDeclarationImpl <em>State Formula Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.StateFormulaDeclarationImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getStateFormulaDeclaration()
     * @generated
     */
    EClass STATE_FORMULA_DECLARATION = eINSTANCE.getStateFormulaDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE_FORMULA_DECLARATION__NAME = eINSTANCE.getStateFormulaDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Formula</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_FORMULA_DECLARATION__FORMULA = eINSTANCE.getStateFormulaDeclaration_Formula();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.PathFormulaImpl <em>Path Formula</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PathFormulaImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getPathFormula()
     * @generated
     */
    EClass PATH_FORMULA = eINSTANCE.getPathFormula();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.UntilFormulaImpl <em>Until Formula</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.UntilFormulaImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getUntilFormula()
     * @generated
     */
    EClass UNTIL_FORMULA = eINSTANCE.getUntilFormula();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNTIL_FORMULA__LEFT = eINSTANCE.getUntilFormula_Left();

    /**
     * The meta object literal for the '<em><b>Bound</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNTIL_FORMULA__BOUND = eINSTANCE.getUntilFormula_Bound();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNTIL_FORMULA__RIGHT = eINSTANCE.getUntilFormula_Right();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.BoundImpl <em>Bound</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.BoundImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getBound()
     * @generated
     */
    EClass BOUND = eINSTANCE.getBound();

    /**
     * The meta object literal for the '<em><b>Relop</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOUND__RELOP = eINSTANCE.getBound_Relop();

    /**
     * The meta object literal for the '<em><b>Limit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOUND__LIMIT = eINSTANCE.getBound_Limit();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.NextFormulaImpl <em>Next Formula</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.NextFormulaImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getNextFormula()
     * @generated
     */
    EClass NEXT_FORMULA = eINSTANCE.getNextFormula();

    /**
     * The meta object literal for the '<em><b>Arg</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NEXT_FORMULA__ARG = eINSTANCE.getNextFormula_Arg();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.StateFormulaImpl <em>State Formula</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.StateFormulaImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getStateFormula()
     * @generated
     */
    EClass STATE_FORMULA = eINSTANCE.getStateFormula();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ProbabilityFormulaImpl <em>Probability Formula</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.ProbabilityFormulaImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getProbabilityFormula()
     * @generated
     */
    EClass PROBABILITY_FORMULA = eINSTANCE.getProbabilityFormula();

    /**
     * The meta object literal for the '<em><b>Relation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROBABILITY_FORMULA__RELATION = eINSTANCE.getProbabilityFormula_Relation();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROBABILITY_FORMULA__VALUE = eINSTANCE.getProbabilityFormula_Value();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROBABILITY_FORMULA__PATH = eINSTANCE.getProbabilityFormula_Path();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.NegationFormulaImpl <em>Negation Formula</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.NegationFormulaImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getNegationFormula()
     * @generated
     */
    EClass NEGATION_FORMULA = eINSTANCE.getNegationFormula();

    /**
     * The meta object literal for the '<em><b>Argument</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NEGATION_FORMULA__ARGUMENT = eINSTANCE.getNegationFormula_Argument();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.AtomicStateFormulaImpl <em>Atomic State Formula</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.AtomicStateFormulaImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getAtomicStateFormula()
     * @generated
     */
    EClass ATOMIC_STATE_FORMULA = eINSTANCE.getAtomicStateFormula();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATOMIC_STATE_FORMULA__EXP = eINSTANCE.getAtomicStateFormula_Exp();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.PrismSystemImpl <em>System</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismSystemImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getPrismSystem()
     * @generated
     */
    EClass PRISM_SYSTEM = eINSTANCE.getPrismSystem();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ActionRenamingImpl <em>Action Renaming</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.ActionRenamingImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getActionRenaming()
     * @generated
     */
    EClass ACTION_RENAMING = eINSTANCE.getActionRenaming();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTION_RENAMING__SOURCE = eINSTANCE.getActionRenaming_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTION_RENAMING__TARGET = eINSTANCE.getActionRenaming_Target();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ModuleReferenceImpl <em>Module Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.ModuleReferenceImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getModuleReference()
     * @generated
     */
    EClass MODULE_REFERENCE = eINSTANCE.getModuleReference();

    /**
     * The meta object literal for the '<em><b>Module</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE_REFERENCE__MODULE = eINSTANCE.getModuleReference_Module();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.VariableImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE__TYPE = eINSTANCE.getVariable_Type();

    /**
     * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE__INIT = eINSTANCE.getVariable_Init();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.LabelImpl <em>Label</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.LabelImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getLabel()
     * @generated
     */
    EClass LABEL = eINSTANCE.getLabel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LABEL__NAME = eINSTANCE.getLabel_Name();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LABEL__EXPRESSION = eINSTANCE.getLabel_Expression();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.FormulaImpl <em>Formula</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.FormulaImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getFormula()
     * @generated
     */
    EClass FORMULA = eINSTANCE.getFormula();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FORMULA__NAME = eINSTANCE.getFormula_Name();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FORMULA__EXPRESSION = eINSTANCE.getFormula_Expression();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.InitPredicateImpl <em>Init Predicate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.InitPredicateImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getInitPredicate()
     * @generated
     */
    EClass INIT_PREDICATE = eINSTANCE.getInitPredicate();

    /**
     * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INIT_PREDICATE__PREDICATE = eINSTANCE.getInitPredicate_Predicate();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.RewardImpl <em>Reward</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.RewardImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getReward()
     * @generated
     */
    EClass REWARD = eINSTANCE.getReward();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REWARD__LABEL = eINSTANCE.getReward_Label();

    /**
     * The meta object literal for the '<em><b>Cases</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REWARD__CASES = eINSTANCE.getReward_Cases();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.RewardCaseImpl <em>Reward Case</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.RewardCaseImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getRewardCase()
     * @generated
     */
    EClass REWARD_CASE = eINSTANCE.getRewardCase();

    /**
     * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REWARD_CASE__ACTION = eINSTANCE.getRewardCase_Action();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REWARD_CASE__GUARD = eINSTANCE.getRewardCase_Guard();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REWARD_CASE__VALUE = eINSTANCE.getRewardCase_Value();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ConstantImpl <em>Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.ConstantImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getConstant()
     * @generated
     */
    EClass CONSTANT = eINSTANCE.getConstant();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT__TYPE = eINSTANCE.getConstant_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT__NAME = eINSTANCE.getConstant_Name();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT__EXP = eINSTANCE.getConstant_Exp();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ModuleImpl <em>Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.ModuleImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getModule()
     * @generated
     */
    EClass MODULE = eINSTANCE.getModule();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULE__NAME = eINSTANCE.getModule_Name();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__BODY = eINSTANCE.getModule_Body();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ModuleBodyImpl <em>Module Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.ModuleBodyImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getModuleBody()
     * @generated
     */
    EClass MODULE_BODY = eINSTANCE.getModuleBody();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.VariableRenamingImpl <em>Variable Renaming</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.VariableRenamingImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getVariableRenaming()
     * @generated
     */
    EClass VARIABLE_RENAMING = eINSTANCE.getVariableRenaming();

    /**
     * The meta object literal for the '<em><b>Module</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_RENAMING__MODULE = eINSTANCE.getVariableRenaming_Module();

    /**
     * The meta object literal for the '<em><b>Renaming</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_RENAMING__RENAMING = eINSTANCE.getVariableRenaming_Renaming();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.SymbolRenamingImpl <em>Symbol Renaming</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.SymbolRenamingImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getSymbolRenaming()
     * @generated
     */
    EClass SYMBOL_RENAMING = eINSTANCE.getSymbolRenaming();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SYMBOL_RENAMING__SOURCE = eINSTANCE.getSymbolRenaming_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SYMBOL_RENAMING__TARGET = eINSTANCE.getSymbolRenaming_Target();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ModuleBodyDeclarationImpl <em>Module Body Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.ModuleBodyDeclarationImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getModuleBodyDeclaration()
     * @generated
     */
    EClass MODULE_BODY_DECLARATION = eINSTANCE.getModuleBodyDeclaration();

    /**
     * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE_BODY_DECLARATION__VARIABLES = eINSTANCE.getModuleBodyDeclaration_Variables();

    /**
     * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE_BODY_DECLARATION__COMMANDS = eINSTANCE.getModuleBodyDeclaration_Commands();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.CommandImpl <em>Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.CommandImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getCommand()
     * @generated
     */
    EClass COMMAND = eINSTANCE.getCommand();

    /**
     * The meta object literal for the '<em><b>Act</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMAND__ACT = eINSTANCE.getCommand_Act();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMAND__GUARD = eINSTANCE.getCommand_Guard();

    /**
     * The meta object literal for the '<em><b>Updates</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMAND__UPDATES = eINSTANCE.getCommand_Updates();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.UpdateImpl <em>Update</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.UpdateImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getUpdate()
     * @generated
     */
    EClass UPDATE = eINSTANCE.getUpdate();

    /**
     * The meta object literal for the '<em><b>Weight</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UPDATE__WEIGHT = eINSTANCE.getUpdate_Weight();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UPDATE__ELEMENTS = eINSTANCE.getUpdate_Elements();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.UpdateElementImpl <em>Update Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.UpdateElementImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getUpdateElement()
     * @generated
     */
    EClass UPDATE_ELEMENT = eINSTANCE.getUpdateElement();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UPDATE_ELEMENT__VARIABLE = eINSTANCE.getUpdateElement_Variable();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UPDATE_ELEMENT__EXPRESSION = eINSTANCE.getUpdateElement_Expression();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.TypeImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.IntervalTypeImpl <em>Interval Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.IntervalTypeImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getIntervalType()
     * @generated
     */
    EClass INTERVAL_TYPE = eINSTANCE.getIntervalType();

    /**
     * The meta object literal for the '<em><b>Min</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERVAL_TYPE__MIN = eINSTANCE.getIntervalType_Min();

    /**
     * The meta object literal for the '<em><b>Max</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERVAL_TYPE__MAX = eINSTANCE.getIntervalType_Max();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.BooleanTypeImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getBooleanType()
     * @generated
     */
    EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.ExpressionImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.LogFunctionImpl <em>Log Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.LogFunctionImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getLogFunction()
     * @generated
     */
    EClass LOG_FUNCTION = eINSTANCE.getLogFunction();

    /**
     * The meta object literal for the '<em><b>Argument</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOG_FUNCTION__ARGUMENT = eINSTANCE.getLogFunction_Argument();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOG_FUNCTION__BASE = eINSTANCE.getLogFunction_Base();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ModFunctionImpl <em>Mod Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.ModFunctionImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getModFunction()
     * @generated
     */
    EClass MOD_FUNCTION = eINSTANCE.getModFunction();

    /**
     * The meta object literal for the '<em><b>Dividend</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MOD_FUNCTION__DIVIDEND = eINSTANCE.getModFunction_Dividend();

    /**
     * The meta object literal for the '<em><b>Divisor</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MOD_FUNCTION__DIVISOR = eINSTANCE.getModFunction_Divisor();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.CeilFunctionImpl <em>Ceil Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.CeilFunctionImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getCeilFunction()
     * @generated
     */
    EClass CEIL_FUNCTION = eINSTANCE.getCeilFunction();

    /**
     * The meta object literal for the '<em><b>Arg</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CEIL_FUNCTION__ARG = eINSTANCE.getCeilFunction_Arg();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.FloorFunctionImpl <em>Floor Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.FloorFunctionImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getFloorFunction()
     * @generated
     */
    EClass FLOOR_FUNCTION = eINSTANCE.getFloorFunction();

    /**
     * The meta object literal for the '<em><b>Arg</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FLOOR_FUNCTION__ARG = eINSTANCE.getFloorFunction_Arg();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.PowFunctionImpl <em>Pow Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PowFunctionImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getPowFunction()
     * @generated
     */
    EClass POW_FUNCTION = eINSTANCE.getPowFunction();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POW_FUNCTION__BASE = eINSTANCE.getPowFunction_Base();

    /**
     * The meta object literal for the '<em><b>Exponent</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POW_FUNCTION__EXPONENT = eINSTANCE.getPowFunction_Exponent();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.MaxFunctionImpl <em>Max Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.MaxFunctionImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getMaxFunction()
     * @generated
     */
    EClass MAX_FUNCTION = eINSTANCE.getMaxFunction();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAX_FUNCTION__ARGS = eINSTANCE.getMaxFunction_Args();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.MinFunctionImpl <em>Min Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.MinFunctionImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getMinFunction()
     * @generated
     */
    EClass MIN_FUNCTION = eINSTANCE.getMinFunction();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MIN_FUNCTION__ARGS = eINSTANCE.getMinFunction_Args();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.TrueImpl <em>True</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.TrueImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getTrue()
     * @generated
     */
    EClass TRUE = eINSTANCE.getTrue();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.FalseImpl <em>False</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.FalseImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getFalse()
     * @generated
     */
    EClass FALSE = eINSTANCE.getFalse();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ReferenceImpl <em>Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.ReferenceImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getReference()
     * @generated
     */
    EClass REFERENCE = eINSTANCE.getReference();

    /**
     * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REFERENCE__REFERENCE = eINSTANCE.getReference_Reference();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.NumericalValueImpl <em>Numerical Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.NumericalValueImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getNumericalValue()
     * @generated
     */
    EClass NUMERICAL_VALUE = eINSTANCE.getNumericalValue();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.IntegerLiteralImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getIntegerLiteral()
     * @generated
     */
    EClass INTEGER_LITERAL = eINSTANCE.getIntegerLiteral();

    /**
     * The meta object literal for the '<em><b>Integer Part</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTEGER_LITERAL__INTEGER_PART = eINSTANCE.getIntegerLiteral_IntegerPart();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.StateOrImpl <em>State Or</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.StateOrImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getStateOr()
     * @generated
     */
    EClass STATE_OR = eINSTANCE.getStateOr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_OR__LEFT = eINSTANCE.getStateOr_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_OR__RIGHT = eINSTANCE.getStateOr_Right();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.StateAndImpl <em>State And</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.StateAndImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getStateAnd()
     * @generated
     */
    EClass STATE_AND = eINSTANCE.getStateAnd();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_AND__LEFT = eINSTANCE.getStateAnd_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_AND__RIGHT = eINSTANCE.getStateAnd_Right();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.AlphabetisedParallelCompositionImpl <em>Alphabetised Parallel Composition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.AlphabetisedParallelCompositionImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getAlphabetisedParallelComposition()
     * @generated
     */
    EClass ALPHABETISED_PARALLEL_COMPOSITION = eINSTANCE.getAlphabetisedParallelComposition();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALPHABETISED_PARALLEL_COMPOSITION__LEFT = eINSTANCE.getAlphabetisedParallelComposition_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALPHABETISED_PARALLEL_COMPOSITION__RIGHT = eINSTANCE.getAlphabetisedParallelComposition_Right();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.AsynchronousParallelCompositionImpl <em>Asynchronous Parallel Composition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.AsynchronousParallelCompositionImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getAsynchronousParallelComposition()
     * @generated
     */
    EClass ASYNCHRONOUS_PARALLEL_COMPOSITION = eINSTANCE.getAsynchronousParallelComposition();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASYNCHRONOUS_PARALLEL_COMPOSITION__LEFT = eINSTANCE.getAsynchronousParallelComposition_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASYNCHRONOUS_PARALLEL_COMPOSITION__RIGHT = eINSTANCE.getAsynchronousParallelComposition_Right();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.RestrictedParallelCompositionImpl <em>Restricted Parallel Composition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.RestrictedParallelCompositionImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getRestrictedParallelComposition()
     * @generated
     */
    EClass RESTRICTED_PARALLEL_COMPOSITION = eINSTANCE.getRestrictedParallelComposition();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESTRICTED_PARALLEL_COMPOSITION__LEFT = eINSTANCE.getRestrictedParallelComposition_Left();

    /**
     * The meta object literal for the '<em><b>Actions</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESTRICTED_PARALLEL_COMPOSITION__ACTIONS = eINSTANCE.getRestrictedParallelComposition_Actions();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESTRICTED_PARALLEL_COMPOSITION__RIGHT = eINSTANCE.getRestrictedParallelComposition_Right();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.HidingImpl <em>Hiding</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.HidingImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getHiding()
     * @generated
     */
    EClass HIDING = eINSTANCE.getHiding();

    /**
     * The meta object literal for the '<em><b>Argument</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HIDING__ARGUMENT = eINSTANCE.getHiding_Argument();

    /**
     * The meta object literal for the '<em><b>Actions</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HIDING__ACTIONS = eINSTANCE.getHiding_Actions();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.RenamingImpl <em>Renaming</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.RenamingImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getRenaming()
     * @generated
     */
    EClass RENAMING = eINSTANCE.getRenaming();

    /**
     * The meta object literal for the '<em><b>Argument</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RENAMING__ARGUMENT = eINSTANCE.getRenaming_Argument();

    /**
     * The meta object literal for the '<em><b>Renaming</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RENAMING__RENAMING = eINSTANCE.getRenaming_Renaming();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.IfThenElseImpl <em>If Then Else</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.IfThenElseImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getIfThenElse()
     * @generated
     */
    EClass IF_THEN_ELSE = eINSTANCE.getIfThenElse();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE__GUARD = eINSTANCE.getIfThenElse_Guard();

    /**
     * The meta object literal for the '<em><b>Then Case</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE__THEN_CASE = eINSTANCE.getIfThenElse_ThenCase();

    /**
     * The meta object literal for the '<em><b>Else Case</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE__ELSE_CASE = eINSTANCE.getIfThenElse_ElseCase();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.ImpliesImpl <em>Implies</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.ImpliesImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getImplies()
     * @generated
     */
    EClass IMPLIES = eINSTANCE.getImplies();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPLIES__LEFT = eINSTANCE.getImplies_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPLIES__RIGHT = eINSTANCE.getImplies_Right();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.IfAndOnlyIfImpl <em>If And Only If</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.IfAndOnlyIfImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getIfAndOnlyIf()
     * @generated
     */
    EClass IF_AND_ONLY_IF = eINSTANCE.getIfAndOnlyIf();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_AND_ONLY_IF__LEFT = eINSTANCE.getIfAndOnlyIf_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_AND_ONLY_IF__RIGHT = eINSTANCE.getIfAndOnlyIf_Right();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.OrExpressionImpl <em>Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.OrExpressionImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getOrExpression()
     * @generated
     */
    EClass OR_EXPRESSION = eINSTANCE.getOrExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPRESSION__LEFT = eINSTANCE.getOrExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPRESSION__RIGHT = eINSTANCE.getOrExpression_Right();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.AndExpressionImpl <em>And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.AndExpressionImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getAndExpression()
     * @generated
     */
    EClass AND_EXPRESSION = eINSTANCE.getAndExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPRESSION__LEFT = eINSTANCE.getAndExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPRESSION__RIGHT = eINSTANCE.getAndExpression_Right();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.NegationImpl <em>Negation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.NegationImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getNegation()
     * @generated
     */
    EClass NEGATION = eINSTANCE.getNegation();

    /**
     * The meta object literal for the '<em><b>Arg</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NEGATION__ARG = eINSTANCE.getNegation_Arg();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.RelExpressionImpl <em>Rel Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.RelExpressionImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getRelExpression()
     * @generated
     */
    EClass REL_EXPRESSION = eINSTANCE.getRelExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REL_EXPRESSION__LEFT = eINSTANCE.getRelExpression_Left();

    /**
     * The meta object literal for the '<em><b>Relop</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REL_EXPRESSION__RELOP = eINSTANCE.getRelExpression_Relop();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REL_EXPRESSION__RIGHT = eINSTANCE.getRelExpression_Right();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.SumExpressionImpl <em>Sum Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.SumExpressionImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getSumExpression()
     * @generated
     */
    EClass SUM_EXPRESSION = eINSTANCE.getSumExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUM_EXPRESSION__LEFT = eINSTANCE.getSumExpression_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUM_EXPRESSION__OP = eINSTANCE.getSumExpression_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUM_EXPRESSION__RIGHT = eINSTANCE.getSumExpression_Right();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.MulExpressionImpl <em>Mul Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.MulExpressionImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getMulExpression()
     * @generated
     */
    EClass MUL_EXPRESSION = eINSTANCE.getMulExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MUL_EXPRESSION__LEFT = eINSTANCE.getMulExpression_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MUL_EXPRESSION__OP = eINSTANCE.getMulExpression_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MUL_EXPRESSION__RIGHT = eINSTANCE.getMulExpression_Right();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.impl.DecimalLiteralImpl <em>Decimal Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.DecimalLiteralImpl
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getDecimalLiteral()
     * @generated
     */
    EClass DECIMAL_LITERAL = eINSTANCE.getDecimalLiteral();

    /**
     * The meta object literal for the '<em><b>Integer Part</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECIMAL_LITERAL__INTEGER_PART = eINSTANCE.getDecimalLiteral_IntegerPart();

    /**
     * The meta object literal for the '<em><b>Decimal Part</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECIMAL_LITERAL__DECIMAL_PART = eINSTANCE.getDecimalLiteral_DecimalPart();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.ConstantType <em>Constant Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.ConstantType
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getConstantType()
     * @generated
     */
    EEnum CONSTANT_TYPE = eINSTANCE.getConstantType();

    /**
     * The meta object literal for the '{@link org.cmg.ml.sam.xtext.prism.prism.Relations <em>Relations</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.cmg.ml.sam.xtext.prism.prism.Relations
     * @see org.cmg.ml.sam.xtext.prism.prism.impl.PrismPackageImpl#getRelations()
     * @generated
     */
    EEnum RELATIONS = eINSTANCE.getRelations();

  }

} //PrismPackage
