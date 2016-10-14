/**
 */
package org.cmg.ml.sam.xtext.prism.prism.impl;

import org.cmg.ml.sam.xtext.prism.prism.ActionRenaming;
import org.cmg.ml.sam.xtext.prism.prism.AlphabetisedParallelComposition;
import org.cmg.ml.sam.xtext.prism.prism.AndExpression;
import org.cmg.ml.sam.xtext.prism.prism.AsynchronousParallelComposition;
import org.cmg.ml.sam.xtext.prism.prism.AtomicStateFormula;
import org.cmg.ml.sam.xtext.prism.prism.BooleanType;
import org.cmg.ml.sam.xtext.prism.prism.Bound;
import org.cmg.ml.sam.xtext.prism.prism.CeilFunction;
import org.cmg.ml.sam.xtext.prism.prism.Command;
import org.cmg.ml.sam.xtext.prism.prism.Constant;
import org.cmg.ml.sam.xtext.prism.prism.ConstantType;
import org.cmg.ml.sam.xtext.prism.prism.DecimalLiteral;
import org.cmg.ml.sam.xtext.prism.prism.Element;
import org.cmg.ml.sam.xtext.prism.prism.Expression;
import org.cmg.ml.sam.xtext.prism.prism.False;
import org.cmg.ml.sam.xtext.prism.prism.FloorFunction;
import org.cmg.ml.sam.xtext.prism.prism.Formula;
import org.cmg.ml.sam.xtext.prism.prism.Hiding;
import org.cmg.ml.sam.xtext.prism.prism.IfAndOnlyIf;
import org.cmg.ml.sam.xtext.prism.prism.IfThenElse;
import org.cmg.ml.sam.xtext.prism.prism.Implies;
import org.cmg.ml.sam.xtext.prism.prism.InitPredicate;
import org.cmg.ml.sam.xtext.prism.prism.IntegerLiteral;
import org.cmg.ml.sam.xtext.prism.prism.IntervalType;
import org.cmg.ml.sam.xtext.prism.prism.Label;
import org.cmg.ml.sam.xtext.prism.prism.LogFunction;
import org.cmg.ml.sam.xtext.prism.prism.MaxFunction;
import org.cmg.ml.sam.xtext.prism.prism.MinFunction;
import org.cmg.ml.sam.xtext.prism.prism.ModFunction;
import org.cmg.ml.sam.xtext.prism.prism.Model;
import org.cmg.ml.sam.xtext.prism.prism.Module;
import org.cmg.ml.sam.xtext.prism.prism.ModuleBody;
import org.cmg.ml.sam.xtext.prism.prism.ModuleBodyDeclaration;
import org.cmg.ml.sam.xtext.prism.prism.ModuleReference;
import org.cmg.ml.sam.xtext.prism.prism.MulExpression;
import org.cmg.ml.sam.xtext.prism.prism.Negation;
import org.cmg.ml.sam.xtext.prism.prism.NegationFormula;
import org.cmg.ml.sam.xtext.prism.prism.NextFormula;
import org.cmg.ml.sam.xtext.prism.prism.NumericalValue;
import org.cmg.ml.sam.xtext.prism.prism.OrExpression;
import org.cmg.ml.sam.xtext.prism.prism.PathFormula;
import org.cmg.ml.sam.xtext.prism.prism.PathFormulaDeclaration;
import org.cmg.ml.sam.xtext.prism.prism.PowFunction;
import org.cmg.ml.sam.xtext.prism.prism.PrismFactory;
import org.cmg.ml.sam.xtext.prism.prism.PrismPackage;
import org.cmg.ml.sam.xtext.prism.prism.PrismSystem;
import org.cmg.ml.sam.xtext.prism.prism.ProbabilityFormula;
import org.cmg.ml.sam.xtext.prism.prism.Reference;
import org.cmg.ml.sam.xtext.prism.prism.RelExpression;
import org.cmg.ml.sam.xtext.prism.prism.Relations;
import org.cmg.ml.sam.xtext.prism.prism.Renaming;
import org.cmg.ml.sam.xtext.prism.prism.RestrictedParallelComposition;
import org.cmg.ml.sam.xtext.prism.prism.Reward;
import org.cmg.ml.sam.xtext.prism.prism.RewardCase;
import org.cmg.ml.sam.xtext.prism.prism.StateAnd;
import org.cmg.ml.sam.xtext.prism.prism.StateFormula;
import org.cmg.ml.sam.xtext.prism.prism.StateFormulaDeclaration;
import org.cmg.ml.sam.xtext.prism.prism.StateOr;
import org.cmg.ml.sam.xtext.prism.prism.SumExpression;
import org.cmg.ml.sam.xtext.prism.prism.SymbolRenaming;
import org.cmg.ml.sam.xtext.prism.prism.True;
import org.cmg.ml.sam.xtext.prism.prism.Type;
import org.cmg.ml.sam.xtext.prism.prism.UntilFormula;
import org.cmg.ml.sam.xtext.prism.prism.Update;
import org.cmg.ml.sam.xtext.prism.prism.UpdateElement;
import org.cmg.ml.sam.xtext.prism.prism.Variable;
import org.cmg.ml.sam.xtext.prism.prism.VariableRenaming;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PrismPackageImpl extends EPackageImpl implements PrismPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass elementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pathFormulaDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateFormulaDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pathFormulaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass untilFormulaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass boundEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nextFormulaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateFormulaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass probabilityFormulaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass negationFormulaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass atomicStateFormulaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass prismSystemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actionRenamingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moduleReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass labelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass formulaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass initPredicateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rewardEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rewardCaseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constantEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moduleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moduleBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableRenamingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass symbolRenamingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moduleBodyDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass commandEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass updateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass updateElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass intervalTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass logFunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modFunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ceilFunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass floorFunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass powFunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass maxFunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass minFunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass trueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass falseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass referenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numericalValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass integerLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateOrEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateAndEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass alphabetisedParallelCompositionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asynchronousParallelCompositionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass restrictedParallelCompositionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass hidingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass renamingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifThenElseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass impliesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifAndOnlyIfEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass orExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass andExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass negationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass relExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sumExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mulExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass decimalLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum constantTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum relationsEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.cmg.ml.sam.xtext.prism.prism.PrismPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private PrismPackageImpl()
  {
    super(eNS_URI, PrismFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link PrismPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static PrismPackage init()
  {
    if (isInited) return (PrismPackage)EPackage.Registry.INSTANCE.getEPackage(PrismPackage.eNS_URI);

    // Obtain or create and register package
    PrismPackageImpl thePrismPackage = (PrismPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PrismPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PrismPackageImpl());

    isInited = true;

    // Create package meta-data objects
    thePrismPackage.createPackageContents();

    // Initialize created meta-data
    thePrismPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    thePrismPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(PrismPackage.eNS_URI, thePrismPackage);
    return thePrismPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModel_Type()
  {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Elements()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getElement()
  {
    return elementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPathFormulaDeclaration()
  {
    return pathFormulaDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPathFormulaDeclaration_Name()
  {
    return (EAttribute)pathFormulaDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPathFormulaDeclaration_Formula()
  {
    return (EReference)pathFormulaDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateFormulaDeclaration()
  {
    return stateFormulaDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStateFormulaDeclaration_Name()
  {
    return (EAttribute)stateFormulaDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateFormulaDeclaration_Formula()
  {
    return (EReference)stateFormulaDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPathFormula()
  {
    return pathFormulaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUntilFormula()
  {
    return untilFormulaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUntilFormula_Left()
  {
    return (EReference)untilFormulaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUntilFormula_Bound()
  {
    return (EReference)untilFormulaEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUntilFormula_Right()
  {
    return (EReference)untilFormulaEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBound()
  {
    return boundEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBound_Relop()
  {
    return (EAttribute)boundEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBound_Limit()
  {
    return (EAttribute)boundEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNextFormula()
  {
    return nextFormulaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNextFormula_Arg()
  {
    return (EReference)nextFormulaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateFormula()
  {
    return stateFormulaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProbabilityFormula()
  {
    return probabilityFormulaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getProbabilityFormula_Relation()
  {
    return (EAttribute)probabilityFormulaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProbabilityFormula_Value()
  {
    return (EReference)probabilityFormulaEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProbabilityFormula_Path()
  {
    return (EReference)probabilityFormulaEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNegationFormula()
  {
    return negationFormulaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNegationFormula_Argument()
  {
    return (EReference)negationFormulaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAtomicStateFormula()
  {
    return atomicStateFormulaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAtomicStateFormula_Exp()
  {
    return (EReference)atomicStateFormulaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrismSystem()
  {
    return prismSystemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActionRenaming()
  {
    return actionRenamingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getActionRenaming_Source()
  {
    return (EAttribute)actionRenamingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getActionRenaming_Target()
  {
    return (EAttribute)actionRenamingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModuleReference()
  {
    return moduleReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModuleReference_Module()
  {
    return (EReference)moduleReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariable()
  {
    return variableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariable_Name()
  {
    return (EAttribute)variableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariable_Type()
  {
    return (EReference)variableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariable_Init()
  {
    return (EReference)variableEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLabel()
  {
    return labelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLabel_Name()
  {
    return (EAttribute)labelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLabel_Expression()
  {
    return (EReference)labelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFormula()
  {
    return formulaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFormula_Name()
  {
    return (EAttribute)formulaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFormula_Expression()
  {
    return (EReference)formulaEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInitPredicate()
  {
    return initPredicateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInitPredicate_Predicate()
  {
    return (EReference)initPredicateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReward()
  {
    return rewardEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReward_Label()
  {
    return (EAttribute)rewardEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReward_Cases()
  {
    return (EReference)rewardEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRewardCase()
  {
    return rewardCaseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRewardCase_Action()
  {
    return (EAttribute)rewardCaseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRewardCase_Guard()
  {
    return (EReference)rewardCaseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRewardCase_Value()
  {
    return (EReference)rewardCaseEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstant()
  {
    return constantEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstant_Type()
  {
    return (EAttribute)constantEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstant_Name()
  {
    return (EAttribute)constantEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstant_Exp()
  {
    return (EReference)constantEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModule()
  {
    return moduleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModule_Name()
  {
    return (EAttribute)moduleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModule_Body()
  {
    return (EReference)moduleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModuleBody()
  {
    return moduleBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableRenaming()
  {
    return variableRenamingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableRenaming_Module()
  {
    return (EReference)variableRenamingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableRenaming_Renaming()
  {
    return (EReference)variableRenamingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSymbolRenaming()
  {
    return symbolRenamingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSymbolRenaming_Source()
  {
    return (EAttribute)symbolRenamingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSymbolRenaming_Target()
  {
    return (EAttribute)symbolRenamingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModuleBodyDeclaration()
  {
    return moduleBodyDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModuleBodyDeclaration_Variables()
  {
    return (EReference)moduleBodyDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModuleBodyDeclaration_Commands()
  {
    return (EReference)moduleBodyDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCommand()
  {
    return commandEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCommand_Act()
  {
    return (EAttribute)commandEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCommand_Guard()
  {
    return (EReference)commandEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCommand_Updates()
  {
    return (EReference)commandEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUpdate()
  {
    return updateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUpdate_Weight()
  {
    return (EReference)updateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUpdate_Elements()
  {
    return (EReference)updateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUpdateElement()
  {
    return updateElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUpdateElement_Variable()
  {
    return (EAttribute)updateElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUpdateElement_Expression()
  {
    return (EReference)updateElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getType()
  {
    return typeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntervalType()
  {
    return intervalTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIntervalType_Min()
  {
    return (EReference)intervalTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIntervalType_Max()
  {
    return (EReference)intervalTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanType()
  {
    return booleanTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLogFunction()
  {
    return logFunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLogFunction_Argument()
  {
    return (EReference)logFunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLogFunction_Base()
  {
    return (EReference)logFunctionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModFunction()
  {
    return modFunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModFunction_Dividend()
  {
    return (EReference)modFunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModFunction_Divisor()
  {
    return (EReference)modFunctionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCeilFunction()
  {
    return ceilFunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCeilFunction_Arg()
  {
    return (EReference)ceilFunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFloorFunction()
  {
    return floorFunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFloorFunction_Arg()
  {
    return (EReference)floorFunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPowFunction()
  {
    return powFunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPowFunction_Base()
  {
    return (EReference)powFunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPowFunction_Exponent()
  {
    return (EReference)powFunctionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMaxFunction()
  {
    return maxFunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMaxFunction_Args()
  {
    return (EReference)maxFunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMinFunction()
  {
    return minFunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMinFunction_Args()
  {
    return (EReference)minFunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrue()
  {
    return trueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFalse()
  {
    return falseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReference()
  {
    return referenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReference_Reference()
  {
    return (EAttribute)referenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumericalValue()
  {
    return numericalValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntegerLiteral()
  {
    return integerLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIntegerLiteral_IntegerPart()
  {
    return (EAttribute)integerLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateOr()
  {
    return stateOrEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateOr_Left()
  {
    return (EReference)stateOrEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateOr_Right()
  {
    return (EReference)stateOrEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateAnd()
  {
    return stateAndEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateAnd_Left()
  {
    return (EReference)stateAndEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateAnd_Right()
  {
    return (EReference)stateAndEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAlphabetisedParallelComposition()
  {
    return alphabetisedParallelCompositionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAlphabetisedParallelComposition_Left()
  {
    return (EReference)alphabetisedParallelCompositionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAlphabetisedParallelComposition_Right()
  {
    return (EReference)alphabetisedParallelCompositionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAsynchronousParallelComposition()
  {
    return asynchronousParallelCompositionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAsynchronousParallelComposition_Left()
  {
    return (EReference)asynchronousParallelCompositionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAsynchronousParallelComposition_Right()
  {
    return (EReference)asynchronousParallelCompositionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRestrictedParallelComposition()
  {
    return restrictedParallelCompositionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRestrictedParallelComposition_Left()
  {
    return (EReference)restrictedParallelCompositionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRestrictedParallelComposition_Actions()
  {
    return (EAttribute)restrictedParallelCompositionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRestrictedParallelComposition_Right()
  {
    return (EReference)restrictedParallelCompositionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHiding()
  {
    return hidingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHiding_Argument()
  {
    return (EReference)hidingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHiding_Actions()
  {
    return (EAttribute)hidingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRenaming()
  {
    return renamingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRenaming_Argument()
  {
    return (EReference)renamingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRenaming_Renaming()
  {
    return (EReference)renamingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfThenElse()
  {
    return ifThenElseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfThenElse_Guard()
  {
    return (EReference)ifThenElseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfThenElse_ThenCase()
  {
    return (EReference)ifThenElseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfThenElse_ElseCase()
  {
    return (EReference)ifThenElseEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImplies()
  {
    return impliesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImplies_Left()
  {
    return (EReference)impliesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImplies_Right()
  {
    return (EReference)impliesEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfAndOnlyIf()
  {
    return ifAndOnlyIfEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfAndOnlyIf_Left()
  {
    return (EReference)ifAndOnlyIfEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfAndOnlyIf_Right()
  {
    return (EReference)ifAndOnlyIfEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrExpression()
  {
    return orExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrExpression_Left()
  {
    return (EReference)orExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrExpression_Right()
  {
    return (EReference)orExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAndExpression()
  {
    return andExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpression_Left()
  {
    return (EReference)andExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpression_Right()
  {
    return (EReference)andExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNegation()
  {
    return negationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNegation_Arg()
  {
    return (EReference)negationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRelExpression()
  {
    return relExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelExpression_Left()
  {
    return (EReference)relExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelExpression_Relop()
  {
    return (EAttribute)relExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelExpression_Right()
  {
    return (EReference)relExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSumExpression()
  {
    return sumExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSumExpression_Left()
  {
    return (EReference)sumExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSumExpression_Op()
  {
    return (EAttribute)sumExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSumExpression_Right()
  {
    return (EReference)sumExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMulExpression()
  {
    return mulExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMulExpression_Left()
  {
    return (EReference)mulExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMulExpression_Op()
  {
    return (EAttribute)mulExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMulExpression_Right()
  {
    return (EReference)mulExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDecimalLiteral()
  {
    return decimalLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDecimalLiteral_IntegerPart()
  {
    return (EReference)decimalLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDecimalLiteral_DecimalPart()
  {
    return (EAttribute)decimalLiteralEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getConstantType()
  {
    return constantTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getRelations()
  {
    return relationsEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrismFactory getPrismFactory()
  {
    return (PrismFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);
    createEAttribute(modelEClass, MODEL__TYPE);
    createEReference(modelEClass, MODEL__ELEMENTS);

    elementEClass = createEClass(ELEMENT);

    pathFormulaDeclarationEClass = createEClass(PATH_FORMULA_DECLARATION);
    createEAttribute(pathFormulaDeclarationEClass, PATH_FORMULA_DECLARATION__NAME);
    createEReference(pathFormulaDeclarationEClass, PATH_FORMULA_DECLARATION__FORMULA);

    stateFormulaDeclarationEClass = createEClass(STATE_FORMULA_DECLARATION);
    createEAttribute(stateFormulaDeclarationEClass, STATE_FORMULA_DECLARATION__NAME);
    createEReference(stateFormulaDeclarationEClass, STATE_FORMULA_DECLARATION__FORMULA);

    pathFormulaEClass = createEClass(PATH_FORMULA);

    untilFormulaEClass = createEClass(UNTIL_FORMULA);
    createEReference(untilFormulaEClass, UNTIL_FORMULA__LEFT);
    createEReference(untilFormulaEClass, UNTIL_FORMULA__BOUND);
    createEReference(untilFormulaEClass, UNTIL_FORMULA__RIGHT);

    boundEClass = createEClass(BOUND);
    createEAttribute(boundEClass, BOUND__RELOP);
    createEAttribute(boundEClass, BOUND__LIMIT);

    nextFormulaEClass = createEClass(NEXT_FORMULA);
    createEReference(nextFormulaEClass, NEXT_FORMULA__ARG);

    stateFormulaEClass = createEClass(STATE_FORMULA);

    probabilityFormulaEClass = createEClass(PROBABILITY_FORMULA);
    createEAttribute(probabilityFormulaEClass, PROBABILITY_FORMULA__RELATION);
    createEReference(probabilityFormulaEClass, PROBABILITY_FORMULA__VALUE);
    createEReference(probabilityFormulaEClass, PROBABILITY_FORMULA__PATH);

    negationFormulaEClass = createEClass(NEGATION_FORMULA);
    createEReference(negationFormulaEClass, NEGATION_FORMULA__ARGUMENT);

    atomicStateFormulaEClass = createEClass(ATOMIC_STATE_FORMULA);
    createEReference(atomicStateFormulaEClass, ATOMIC_STATE_FORMULA__EXP);

    prismSystemEClass = createEClass(PRISM_SYSTEM);

    actionRenamingEClass = createEClass(ACTION_RENAMING);
    createEAttribute(actionRenamingEClass, ACTION_RENAMING__SOURCE);
    createEAttribute(actionRenamingEClass, ACTION_RENAMING__TARGET);

    moduleReferenceEClass = createEClass(MODULE_REFERENCE);
    createEReference(moduleReferenceEClass, MODULE_REFERENCE__MODULE);

    variableEClass = createEClass(VARIABLE);
    createEAttribute(variableEClass, VARIABLE__NAME);
    createEReference(variableEClass, VARIABLE__TYPE);
    createEReference(variableEClass, VARIABLE__INIT);

    labelEClass = createEClass(LABEL);
    createEAttribute(labelEClass, LABEL__NAME);
    createEReference(labelEClass, LABEL__EXPRESSION);

    formulaEClass = createEClass(FORMULA);
    createEAttribute(formulaEClass, FORMULA__NAME);
    createEReference(formulaEClass, FORMULA__EXPRESSION);

    initPredicateEClass = createEClass(INIT_PREDICATE);
    createEReference(initPredicateEClass, INIT_PREDICATE__PREDICATE);

    rewardEClass = createEClass(REWARD);
    createEAttribute(rewardEClass, REWARD__LABEL);
    createEReference(rewardEClass, REWARD__CASES);

    rewardCaseEClass = createEClass(REWARD_CASE);
    createEAttribute(rewardCaseEClass, REWARD_CASE__ACTION);
    createEReference(rewardCaseEClass, REWARD_CASE__GUARD);
    createEReference(rewardCaseEClass, REWARD_CASE__VALUE);

    constantEClass = createEClass(CONSTANT);
    createEAttribute(constantEClass, CONSTANT__TYPE);
    createEAttribute(constantEClass, CONSTANT__NAME);
    createEReference(constantEClass, CONSTANT__EXP);

    moduleEClass = createEClass(MODULE);
    createEAttribute(moduleEClass, MODULE__NAME);
    createEReference(moduleEClass, MODULE__BODY);

    moduleBodyEClass = createEClass(MODULE_BODY);

    variableRenamingEClass = createEClass(VARIABLE_RENAMING);
    createEReference(variableRenamingEClass, VARIABLE_RENAMING__MODULE);
    createEReference(variableRenamingEClass, VARIABLE_RENAMING__RENAMING);

    symbolRenamingEClass = createEClass(SYMBOL_RENAMING);
    createEAttribute(symbolRenamingEClass, SYMBOL_RENAMING__SOURCE);
    createEAttribute(symbolRenamingEClass, SYMBOL_RENAMING__TARGET);

    moduleBodyDeclarationEClass = createEClass(MODULE_BODY_DECLARATION);
    createEReference(moduleBodyDeclarationEClass, MODULE_BODY_DECLARATION__VARIABLES);
    createEReference(moduleBodyDeclarationEClass, MODULE_BODY_DECLARATION__COMMANDS);

    commandEClass = createEClass(COMMAND);
    createEAttribute(commandEClass, COMMAND__ACT);
    createEReference(commandEClass, COMMAND__GUARD);
    createEReference(commandEClass, COMMAND__UPDATES);

    updateEClass = createEClass(UPDATE);
    createEReference(updateEClass, UPDATE__WEIGHT);
    createEReference(updateEClass, UPDATE__ELEMENTS);

    updateElementEClass = createEClass(UPDATE_ELEMENT);
    createEAttribute(updateElementEClass, UPDATE_ELEMENT__VARIABLE);
    createEReference(updateElementEClass, UPDATE_ELEMENT__EXPRESSION);

    typeEClass = createEClass(TYPE);

    intervalTypeEClass = createEClass(INTERVAL_TYPE);
    createEReference(intervalTypeEClass, INTERVAL_TYPE__MIN);
    createEReference(intervalTypeEClass, INTERVAL_TYPE__MAX);

    booleanTypeEClass = createEClass(BOOLEAN_TYPE);

    expressionEClass = createEClass(EXPRESSION);

    logFunctionEClass = createEClass(LOG_FUNCTION);
    createEReference(logFunctionEClass, LOG_FUNCTION__ARGUMENT);
    createEReference(logFunctionEClass, LOG_FUNCTION__BASE);

    modFunctionEClass = createEClass(MOD_FUNCTION);
    createEReference(modFunctionEClass, MOD_FUNCTION__DIVIDEND);
    createEReference(modFunctionEClass, MOD_FUNCTION__DIVISOR);

    ceilFunctionEClass = createEClass(CEIL_FUNCTION);
    createEReference(ceilFunctionEClass, CEIL_FUNCTION__ARG);

    floorFunctionEClass = createEClass(FLOOR_FUNCTION);
    createEReference(floorFunctionEClass, FLOOR_FUNCTION__ARG);

    powFunctionEClass = createEClass(POW_FUNCTION);
    createEReference(powFunctionEClass, POW_FUNCTION__BASE);
    createEReference(powFunctionEClass, POW_FUNCTION__EXPONENT);

    maxFunctionEClass = createEClass(MAX_FUNCTION);
    createEReference(maxFunctionEClass, MAX_FUNCTION__ARGS);

    minFunctionEClass = createEClass(MIN_FUNCTION);
    createEReference(minFunctionEClass, MIN_FUNCTION__ARGS);

    trueEClass = createEClass(TRUE);

    falseEClass = createEClass(FALSE);

    referenceEClass = createEClass(REFERENCE);
    createEAttribute(referenceEClass, REFERENCE__REFERENCE);

    numericalValueEClass = createEClass(NUMERICAL_VALUE);

    integerLiteralEClass = createEClass(INTEGER_LITERAL);
    createEAttribute(integerLiteralEClass, INTEGER_LITERAL__INTEGER_PART);

    stateOrEClass = createEClass(STATE_OR);
    createEReference(stateOrEClass, STATE_OR__LEFT);
    createEReference(stateOrEClass, STATE_OR__RIGHT);

    stateAndEClass = createEClass(STATE_AND);
    createEReference(stateAndEClass, STATE_AND__LEFT);
    createEReference(stateAndEClass, STATE_AND__RIGHT);

    alphabetisedParallelCompositionEClass = createEClass(ALPHABETISED_PARALLEL_COMPOSITION);
    createEReference(alphabetisedParallelCompositionEClass, ALPHABETISED_PARALLEL_COMPOSITION__LEFT);
    createEReference(alphabetisedParallelCompositionEClass, ALPHABETISED_PARALLEL_COMPOSITION__RIGHT);

    asynchronousParallelCompositionEClass = createEClass(ASYNCHRONOUS_PARALLEL_COMPOSITION);
    createEReference(asynchronousParallelCompositionEClass, ASYNCHRONOUS_PARALLEL_COMPOSITION__LEFT);
    createEReference(asynchronousParallelCompositionEClass, ASYNCHRONOUS_PARALLEL_COMPOSITION__RIGHT);

    restrictedParallelCompositionEClass = createEClass(RESTRICTED_PARALLEL_COMPOSITION);
    createEReference(restrictedParallelCompositionEClass, RESTRICTED_PARALLEL_COMPOSITION__LEFT);
    createEAttribute(restrictedParallelCompositionEClass, RESTRICTED_PARALLEL_COMPOSITION__ACTIONS);
    createEReference(restrictedParallelCompositionEClass, RESTRICTED_PARALLEL_COMPOSITION__RIGHT);

    hidingEClass = createEClass(HIDING);
    createEReference(hidingEClass, HIDING__ARGUMENT);
    createEAttribute(hidingEClass, HIDING__ACTIONS);

    renamingEClass = createEClass(RENAMING);
    createEReference(renamingEClass, RENAMING__ARGUMENT);
    createEReference(renamingEClass, RENAMING__RENAMING);

    ifThenElseEClass = createEClass(IF_THEN_ELSE);
    createEReference(ifThenElseEClass, IF_THEN_ELSE__GUARD);
    createEReference(ifThenElseEClass, IF_THEN_ELSE__THEN_CASE);
    createEReference(ifThenElseEClass, IF_THEN_ELSE__ELSE_CASE);

    impliesEClass = createEClass(IMPLIES);
    createEReference(impliesEClass, IMPLIES__LEFT);
    createEReference(impliesEClass, IMPLIES__RIGHT);

    ifAndOnlyIfEClass = createEClass(IF_AND_ONLY_IF);
    createEReference(ifAndOnlyIfEClass, IF_AND_ONLY_IF__LEFT);
    createEReference(ifAndOnlyIfEClass, IF_AND_ONLY_IF__RIGHT);

    orExpressionEClass = createEClass(OR_EXPRESSION);
    createEReference(orExpressionEClass, OR_EXPRESSION__LEFT);
    createEReference(orExpressionEClass, OR_EXPRESSION__RIGHT);

    andExpressionEClass = createEClass(AND_EXPRESSION);
    createEReference(andExpressionEClass, AND_EXPRESSION__LEFT);
    createEReference(andExpressionEClass, AND_EXPRESSION__RIGHT);

    negationEClass = createEClass(NEGATION);
    createEReference(negationEClass, NEGATION__ARG);

    relExpressionEClass = createEClass(REL_EXPRESSION);
    createEReference(relExpressionEClass, REL_EXPRESSION__LEFT);
    createEAttribute(relExpressionEClass, REL_EXPRESSION__RELOP);
    createEReference(relExpressionEClass, REL_EXPRESSION__RIGHT);

    sumExpressionEClass = createEClass(SUM_EXPRESSION);
    createEReference(sumExpressionEClass, SUM_EXPRESSION__LEFT);
    createEAttribute(sumExpressionEClass, SUM_EXPRESSION__OP);
    createEReference(sumExpressionEClass, SUM_EXPRESSION__RIGHT);

    mulExpressionEClass = createEClass(MUL_EXPRESSION);
    createEReference(mulExpressionEClass, MUL_EXPRESSION__LEFT);
    createEAttribute(mulExpressionEClass, MUL_EXPRESSION__OP);
    createEReference(mulExpressionEClass, MUL_EXPRESSION__RIGHT);

    decimalLiteralEClass = createEClass(DECIMAL_LITERAL);
    createEReference(decimalLiteralEClass, DECIMAL_LITERAL__INTEGER_PART);
    createEAttribute(decimalLiteralEClass, DECIMAL_LITERAL__DECIMAL_PART);

    // Create enums
    constantTypeEEnum = createEEnum(CONSTANT_TYPE);
    relationsEEnum = createEEnum(RELATIONS);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    pathFormulaDeclarationEClass.getESuperTypes().add(this.getElement());
    stateFormulaDeclarationEClass.getESuperTypes().add(this.getElement());
    untilFormulaEClass.getESuperTypes().add(this.getPathFormula());
    nextFormulaEClass.getESuperTypes().add(this.getPathFormula());
    probabilityFormulaEClass.getESuperTypes().add(this.getStateFormula());
    negationFormulaEClass.getESuperTypes().add(this.getStateFormula());
    atomicStateFormulaEClass.getESuperTypes().add(this.getStateFormula());
    prismSystemEClass.getESuperTypes().add(this.getElement());
    moduleReferenceEClass.getESuperTypes().add(this.getPrismSystem());
    variableEClass.getESuperTypes().add(this.getElement());
    labelEClass.getESuperTypes().add(this.getElement());
    formulaEClass.getESuperTypes().add(this.getElement());
    initPredicateEClass.getESuperTypes().add(this.getElement());
    rewardEClass.getESuperTypes().add(this.getElement());
    constantEClass.getESuperTypes().add(this.getElement());
    moduleEClass.getESuperTypes().add(this.getElement());
    variableRenamingEClass.getESuperTypes().add(this.getModuleBody());
    moduleBodyDeclarationEClass.getESuperTypes().add(this.getModuleBody());
    intervalTypeEClass.getESuperTypes().add(this.getType());
    booleanTypeEClass.getESuperTypes().add(this.getType());
    logFunctionEClass.getESuperTypes().add(this.getExpression());
    modFunctionEClass.getESuperTypes().add(this.getExpression());
    ceilFunctionEClass.getESuperTypes().add(this.getExpression());
    floorFunctionEClass.getESuperTypes().add(this.getExpression());
    powFunctionEClass.getESuperTypes().add(this.getExpression());
    maxFunctionEClass.getESuperTypes().add(this.getExpression());
    minFunctionEClass.getESuperTypes().add(this.getExpression());
    trueEClass.getESuperTypes().add(this.getExpression());
    falseEClass.getESuperTypes().add(this.getExpression());
    referenceEClass.getESuperTypes().add(this.getExpression());
    numericalValueEClass.getESuperTypes().add(this.getExpression());
    integerLiteralEClass.getESuperTypes().add(this.getNumericalValue());
    stateOrEClass.getESuperTypes().add(this.getStateFormula());
    stateAndEClass.getESuperTypes().add(this.getStateFormula());
    alphabetisedParallelCompositionEClass.getESuperTypes().add(this.getPrismSystem());
    asynchronousParallelCompositionEClass.getESuperTypes().add(this.getPrismSystem());
    restrictedParallelCompositionEClass.getESuperTypes().add(this.getPrismSystem());
    hidingEClass.getESuperTypes().add(this.getPrismSystem());
    renamingEClass.getESuperTypes().add(this.getPrismSystem());
    ifThenElseEClass.getESuperTypes().add(this.getExpression());
    impliesEClass.getESuperTypes().add(this.getExpression());
    ifAndOnlyIfEClass.getESuperTypes().add(this.getExpression());
    orExpressionEClass.getESuperTypes().add(this.getExpression());
    andExpressionEClass.getESuperTypes().add(this.getExpression());
    negationEClass.getESuperTypes().add(this.getExpression());
    relExpressionEClass.getESuperTypes().add(this.getExpression());
    sumExpressionEClass.getESuperTypes().add(this.getExpression());
    mulExpressionEClass.getESuperTypes().add(this.getExpression());
    decimalLiteralEClass.getESuperTypes().add(this.getNumericalValue());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModel_Type(), ecorePackage.getEString(), "type", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_Elements(), this.getElement(), null, "elements", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(elementEClass, Element.class, "Element", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(pathFormulaDeclarationEClass, PathFormulaDeclaration.class, "PathFormulaDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPathFormulaDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, PathFormulaDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPathFormulaDeclaration_Formula(), this.getPathFormula(), null, "formula", null, 0, 1, PathFormulaDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stateFormulaDeclarationEClass, StateFormulaDeclaration.class, "StateFormulaDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStateFormulaDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, StateFormulaDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateFormulaDeclaration_Formula(), this.getStateFormula(), null, "formula", null, 0, 1, StateFormulaDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pathFormulaEClass, PathFormula.class, "PathFormula", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(untilFormulaEClass, UntilFormula.class, "UntilFormula", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUntilFormula_Left(), this.getStateFormula(), null, "left", null, 0, 1, UntilFormula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUntilFormula_Bound(), this.getBound(), null, "bound", null, 0, 1, UntilFormula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUntilFormula_Right(), this.getStateFormula(), null, "right", null, 0, 1, UntilFormula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(boundEClass, Bound.class, "Bound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBound_Relop(), this.getRelations(), "relop", null, 0, 1, Bound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBound_Limit(), ecorePackage.getEInt(), "limit", null, 0, 1, Bound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nextFormulaEClass, NextFormula.class, "NextFormula", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNextFormula_Arg(), this.getStateFormula(), null, "arg", null, 0, 1, NextFormula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stateFormulaEClass, StateFormula.class, "StateFormula", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(probabilityFormulaEClass, ProbabilityFormula.class, "ProbabilityFormula", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getProbabilityFormula_Relation(), this.getRelations(), "relation", null, 0, 1, ProbabilityFormula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProbabilityFormula_Value(), this.getExpression(), null, "value", null, 0, 1, ProbabilityFormula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProbabilityFormula_Path(), this.getPathFormula(), null, "path", null, 0, 1, ProbabilityFormula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(negationFormulaEClass, NegationFormula.class, "NegationFormula", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNegationFormula_Argument(), this.getStateFormula(), null, "argument", null, 0, 1, NegationFormula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(atomicStateFormulaEClass, AtomicStateFormula.class, "AtomicStateFormula", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAtomicStateFormula_Exp(), this.getExpression(), null, "exp", null, 0, 1, AtomicStateFormula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(prismSystemEClass, PrismSystem.class, "PrismSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(actionRenamingEClass, ActionRenaming.class, "ActionRenaming", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getActionRenaming_Source(), ecorePackage.getEString(), "source", null, 0, 1, ActionRenaming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getActionRenaming_Target(), ecorePackage.getEString(), "target", null, 0, 1, ActionRenaming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(moduleReferenceEClass, ModuleReference.class, "ModuleReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModuleReference_Module(), this.getModule(), null, "module", null, 0, 1, ModuleReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariable_Name(), ecorePackage.getEString(), "name", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariable_Type(), this.getType(), null, "type", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariable_Init(), this.getExpression(), null, "init", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(labelEClass, Label.class, "Label", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLabel_Name(), ecorePackage.getEString(), "name", null, 0, 1, Label.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLabel_Expression(), this.getExpression(), null, "expression", null, 0, 1, Label.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(formulaEClass, Formula.class, "Formula", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFormula_Name(), ecorePackage.getEString(), "name", null, 0, 1, Formula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFormula_Expression(), this.getExpression(), null, "expression", null, 0, 1, Formula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(initPredicateEClass, InitPredicate.class, "InitPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInitPredicate_Predicate(), this.getExpression(), null, "predicate", null, 0, 1, InitPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rewardEClass, Reward.class, "Reward", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getReward_Label(), ecorePackage.getEString(), "label", null, 0, 1, Reward.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReward_Cases(), this.getRewardCase(), null, "cases", null, 0, -1, Reward.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rewardCaseEClass, RewardCase.class, "RewardCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRewardCase_Action(), ecorePackage.getEString(), "action", null, 0, 1, RewardCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRewardCase_Guard(), this.getExpression(), null, "guard", null, 0, 1, RewardCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRewardCase_Value(), this.getExpression(), null, "value", null, 0, 1, RewardCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(constantEClass, Constant.class, "Constant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getConstant_Type(), this.getConstantType(), "type", null, 0, 1, Constant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getConstant_Name(), ecorePackage.getEString(), "name", null, 0, 1, Constant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConstant_Exp(), this.getExpression(), null, "exp", null, 0, 1, Constant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModule_Name(), ecorePackage.getEString(), "name", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModule_Body(), this.getModuleBody(), null, "body", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(moduleBodyEClass, ModuleBody.class, "ModuleBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(variableRenamingEClass, VariableRenaming.class, "VariableRenaming", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVariableRenaming_Module(), this.getModule(), null, "module", null, 0, 1, VariableRenaming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariableRenaming_Renaming(), this.getSymbolRenaming(), null, "renaming", null, 0, -1, VariableRenaming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(symbolRenamingEClass, SymbolRenaming.class, "SymbolRenaming", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSymbolRenaming_Source(), ecorePackage.getEString(), "source", null, 0, 1, SymbolRenaming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSymbolRenaming_Target(), ecorePackage.getEString(), "target", null, 0, 1, SymbolRenaming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(moduleBodyDeclarationEClass, ModuleBodyDeclaration.class, "ModuleBodyDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModuleBodyDeclaration_Variables(), this.getVariable(), null, "variables", null, 0, -1, ModuleBodyDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModuleBodyDeclaration_Commands(), this.getCommand(), null, "commands", null, 0, -1, ModuleBodyDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(commandEClass, Command.class, "Command", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCommand_Act(), ecorePackage.getEString(), "act", null, 0, 1, Command.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCommand_Guard(), this.getExpression(), null, "guard", null, 0, 1, Command.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCommand_Updates(), this.getUpdate(), null, "updates", null, 0, -1, Command.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(updateEClass, Update.class, "Update", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUpdate_Weight(), this.getExpression(), null, "weight", null, 0, 1, Update.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUpdate_Elements(), this.getUpdateElement(), null, "elements", null, 0, -1, Update.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(updateElementEClass, UpdateElement.class, "UpdateElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUpdateElement_Variable(), ecorePackage.getEString(), "variable", null, 0, 1, UpdateElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUpdateElement_Expression(), this.getExpression(), null, "expression", null, 0, 1, UpdateElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(intervalTypeEClass, IntervalType.class, "IntervalType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIntervalType_Min(), this.getExpression(), null, "min", null, 0, 1, IntervalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIntervalType_Max(), this.getExpression(), null, "max", null, 0, 1, IntervalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanTypeEClass, BooleanType.class, "BooleanType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(logFunctionEClass, LogFunction.class, "LogFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLogFunction_Argument(), this.getExpression(), null, "argument", null, 0, 1, LogFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLogFunction_Base(), this.getExpression(), null, "base", null, 0, 1, LogFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(modFunctionEClass, ModFunction.class, "ModFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModFunction_Dividend(), this.getExpression(), null, "dividend", null, 0, 1, ModFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModFunction_Divisor(), this.getExpression(), null, "divisor", null, 0, 1, ModFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ceilFunctionEClass, CeilFunction.class, "CeilFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCeilFunction_Arg(), this.getExpression(), null, "arg", null, 0, 1, CeilFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(floorFunctionEClass, FloorFunction.class, "FloorFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFloorFunction_Arg(), this.getExpression(), null, "arg", null, 0, 1, FloorFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(powFunctionEClass, PowFunction.class, "PowFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPowFunction_Base(), this.getExpression(), null, "base", null, 0, 1, PowFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPowFunction_Exponent(), this.getExpression(), null, "exponent", null, 0, 1, PowFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(maxFunctionEClass, MaxFunction.class, "MaxFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMaxFunction_Args(), this.getExpression(), null, "args", null, 0, -1, MaxFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(minFunctionEClass, MinFunction.class, "MinFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMinFunction_Args(), this.getExpression(), null, "args", null, 0, -1, MinFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(trueEClass, True.class, "True", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(falseEClass, False.class, "False", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(referenceEClass, Reference.class, "Reference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getReference_Reference(), ecorePackage.getEString(), "reference", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(numericalValueEClass, NumericalValue.class, "NumericalValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(integerLiteralEClass, IntegerLiteral.class, "IntegerLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIntegerLiteral_IntegerPart(), ecorePackage.getEInt(), "integerPart", null, 0, 1, IntegerLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stateOrEClass, StateOr.class, "StateOr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStateOr_Left(), this.getStateFormula(), null, "left", null, 0, 1, StateOr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateOr_Right(), this.getStateFormula(), null, "right", null, 0, 1, StateOr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stateAndEClass, StateAnd.class, "StateAnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStateAnd_Left(), this.getStateFormula(), null, "left", null, 0, 1, StateAnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateAnd_Right(), this.getStateFormula(), null, "right", null, 0, 1, StateAnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(alphabetisedParallelCompositionEClass, AlphabetisedParallelComposition.class, "AlphabetisedParallelComposition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAlphabetisedParallelComposition_Left(), this.getPrismSystem(), null, "left", null, 0, 1, AlphabetisedParallelComposition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAlphabetisedParallelComposition_Right(), this.getPrismSystem(), null, "right", null, 0, 1, AlphabetisedParallelComposition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(asynchronousParallelCompositionEClass, AsynchronousParallelComposition.class, "AsynchronousParallelComposition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAsynchronousParallelComposition_Left(), this.getPrismSystem(), null, "left", null, 0, 1, AsynchronousParallelComposition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAsynchronousParallelComposition_Right(), this.getPrismSystem(), null, "right", null, 0, 1, AsynchronousParallelComposition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(restrictedParallelCompositionEClass, RestrictedParallelComposition.class, "RestrictedParallelComposition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRestrictedParallelComposition_Left(), this.getPrismSystem(), null, "left", null, 0, 1, RestrictedParallelComposition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRestrictedParallelComposition_Actions(), ecorePackage.getEString(), "actions", null, 0, -1, RestrictedParallelComposition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRestrictedParallelComposition_Right(), this.getPrismSystem(), null, "right", null, 0, 1, RestrictedParallelComposition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(hidingEClass, Hiding.class, "Hiding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getHiding_Argument(), this.getPrismSystem(), null, "argument", null, 0, 1, Hiding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHiding_Actions(), ecorePackage.getEString(), "actions", null, 0, -1, Hiding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(renamingEClass, Renaming.class, "Renaming", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRenaming_Argument(), this.getPrismSystem(), null, "argument", null, 0, 1, Renaming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRenaming_Renaming(), this.getActionRenaming(), null, "renaming", null, 0, -1, Renaming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifThenElseEClass, IfThenElse.class, "IfThenElse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIfThenElse_Guard(), this.getExpression(), null, "guard", null, 0, 1, IfThenElse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfThenElse_ThenCase(), this.getExpression(), null, "thenCase", null, 0, 1, IfThenElse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfThenElse_ElseCase(), this.getExpression(), null, "elseCase", null, 0, 1, IfThenElse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(impliesEClass, Implies.class, "Implies", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getImplies_Left(), this.getExpression(), null, "left", null, 0, 1, Implies.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getImplies_Right(), this.getExpression(), null, "right", null, 0, 1, Implies.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifAndOnlyIfEClass, IfAndOnlyIf.class, "IfAndOnlyIf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIfAndOnlyIf_Left(), this.getExpression(), null, "left", null, 0, 1, IfAndOnlyIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfAndOnlyIf_Right(), this.getExpression(), null, "right", null, 0, 1, IfAndOnlyIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(orExpressionEClass, OrExpression.class, "OrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOrExpression_Left(), this.getExpression(), null, "left", null, 0, 1, OrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOrExpression_Right(), this.getExpression(), null, "right", null, 0, 1, OrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(andExpressionEClass, AndExpression.class, "AndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAndExpression_Left(), this.getExpression(), null, "left", null, 0, 1, AndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAndExpression_Right(), this.getExpression(), null, "right", null, 0, 1, AndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(negationEClass, Negation.class, "Negation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNegation_Arg(), this.getExpression(), null, "arg", null, 0, 1, Negation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(relExpressionEClass, RelExpression.class, "RelExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRelExpression_Left(), this.getExpression(), null, "left", null, 0, 1, RelExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRelExpression_Relop(), this.getRelations(), "relop", null, 0, 1, RelExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRelExpression_Right(), this.getExpression(), null, "right", null, 0, 1, RelExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sumExpressionEClass, SumExpression.class, "SumExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSumExpression_Left(), this.getExpression(), null, "left", null, 0, 1, SumExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSumExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, SumExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSumExpression_Right(), this.getExpression(), null, "right", null, 0, 1, SumExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mulExpressionEClass, MulExpression.class, "MulExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMulExpression_Left(), this.getExpression(), null, "left", null, 0, 1, MulExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMulExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, MulExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMulExpression_Right(), this.getExpression(), null, "right", null, 0, 1, MulExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(decimalLiteralEClass, DecimalLiteral.class, "DecimalLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDecimalLiteral_IntegerPart(), this.getIntegerLiteral(), null, "integerPart", null, 0, 1, DecimalLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDecimalLiteral_DecimalPart(), ecorePackage.getEString(), "decimalPart", null, 0, 1, DecimalLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(constantTypeEEnum, ConstantType.class, "ConstantType");
    addEEnumLiteral(constantTypeEEnum, ConstantType.CINT);
    addEEnumLiteral(constantTypeEEnum, ConstantType.CBOOL);
    addEEnumLiteral(constantTypeEEnum, ConstantType.CDOUBLE);

    initEEnum(relationsEEnum, Relations.class, "Relations");
    addEEnumLiteral(relationsEEnum, Relations.LSS);
    addEEnumLiteral(relationsEEnum, Relations.LEQ);
    addEEnumLiteral(relationsEEnum, Relations.EQ);
    addEEnumLiteral(relationsEEnum, Relations.NEQ);
    addEEnumLiteral(relationsEEnum, Relations.GTR);
    addEEnumLiteral(relationsEEnum, Relations.GEQ);

    // Create resource
    createResource(eNS_URI);
  }

} //PrismPackageImpl
