package org.cmg.ml.sam.xtext.population.validation;

import org.cmg.ml.sam.xtext.population.population.ACosExpression;
import org.cmg.ml.sam.xtext.population.population.ASinExpression;
import org.cmg.ml.sam.xtext.population.population.ATanExpression;
import org.cmg.ml.sam.xtext.population.population.AndPctlFormula;
import org.cmg.ml.sam.xtext.population.population.CeilExpression;
import org.cmg.ml.sam.xtext.population.population.Constant;
import org.cmg.ml.sam.xtext.population.population.CosExpression;
import org.cmg.ml.sam.xtext.population.population.Expression;
import org.cmg.ml.sam.xtext.population.population.FloorExpression;
import org.cmg.ml.sam.xtext.population.population.Formula;
import org.cmg.ml.sam.xtext.population.population.LogExpression;
import org.cmg.ml.sam.xtext.population.population.MaxExpression;
import org.cmg.ml.sam.xtext.population.population.MinExpression;
import org.cmg.ml.sam.xtext.population.population.ModExpression;
import org.cmg.ml.sam.xtext.population.population.MulDivExpression;
import org.cmg.ml.sam.xtext.population.population.NextFormula;
import org.cmg.ml.sam.xtext.population.population.NotFormula;
import org.cmg.ml.sam.xtext.population.population.OrPctlFormula;
import org.cmg.ml.sam.xtext.population.population.PopulationPackage;
import org.cmg.ml.sam.xtext.population.population.PowExpression;
import org.cmg.ml.sam.xtext.population.population.RelationExpression;
import org.cmg.ml.sam.xtext.population.population.SinExpression;
import org.cmg.ml.sam.xtext.population.population.SumDiffExpression;
import org.cmg.ml.sam.xtext.population.population.TanExpression;
import org.cmg.ml.sam.xtext.population.population.UntilFormula;
import org.cmg.ml.sam.xtext.population.validation.AbstractPopulationJavaValidator;
import org.cmg.ml.sam.xtext.population.validation.StateDependenceChecker;
import org.cmg.ml.sam.xtext.population.validation.TypeInference;
import org.eclipse.xtext.validation.Check;
 

public class PopulationJavaValidator extends AbstractPopulationJavaValidator {

	TypeInference ti = new TypeInference();
	
	StateDependenceChecker sdc = new StateDependenceChecker();
	
	@Check
	public void checkFormulaDefinitionType(Formula greeting) {
		Expression e = greeting.getFormula();
		if (e != null) {
			PopulationDataType pdt = ti.getExpressionType(e);
			if (pdt != PopulationDataType.STATE_FORMULA) {
				error("Wrong expression type: expected "+PopulationDataType.STATE_FORMULA+" is "+pdt+"!" , PopulationPackage.Literals.FORMULA__FORMULA);
				return ;
			}
		}
	}
	
	@Check
	public void checkConstantDefinition(Constant c) {
		Expression e = c.getExp();
		if (e != null) {
			PopulationDataType pdt = ti.getExpressionType(e);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.CONSTANT__EXP);
				return ;
			}
			if (sdc.isStateDependent(e)) {
				error("Constants cannot be assigned to state-dependent expressions!" , PopulationPackage.Literals.CONSTANT__EXP);
			}
		}
	}

	@Check
	public void checkRelationExpressionTypeArguments(RelationExpression e) {
		Expression e1 = e.getLeft();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.RELATION_EXPRESSION__LEFT);

			}
		}
		Expression e2 = e.getRight();
		if (e2 != null) {
			PopulationDataType pdt = ti.getExpressionType(e2);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.RELATION_EXPRESSION__RIGHT);

			}
		}
	}


	@Check
	public void checkSumDiffExpressionTypeArguments(SumDiffExpression e) {
		Expression e1 = e.getLeft();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.SUM_DIFF_EXPRESSION__LEFT);

			}
		}
		Expression e2 = e.getRight();
		if (e2 != null) {
			PopulationDataType pdt = ti.getExpressionType(e2);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.SUM_DIFF_EXPRESSION__RIGHT);

			}
		}
	}


	@Check
	public void checkMulDivExpressionTypeArguments(MulDivExpression e) {
		Expression e1 = e.getLeft();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.MUL_DIV_EXPRESSION__LEFT);

			}
		}
		Expression e2 = e.getRight();
		if (e2 != null) {
			PopulationDataType pdt = ti.getExpressionType(e2);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.MUL_DIV_EXPRESSION__RIGHT);

			}
		}
	}

	@Check
	public void checkNotFormulaTypeArgument( NotFormula e ) {
		Expression e1 = e.getArg();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.STATE_FORMULA) {
				error("Wrong expression type: expected "+PopulationDataType.STATE_FORMULA+" is "+pdt+"!" , PopulationPackage.Literals.NOT_FORMULA__ARG);

			}
		}
	}
	
	@Check
	public void checkAndFormulaTypeArgument( AndPctlFormula e ) {
		Expression e1 = e.getLeft();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.STATE_FORMULA) {
				error("Wrong expression type: expected "+PopulationDataType.STATE_FORMULA+" is "+pdt+"!" , PopulationPackage.Literals.AND_PCTL_FORMULA__LEFT);

			}
		}
		Expression e2 = e.getLeft();
		if (e2 != null) {
			PopulationDataType pdt = ti.getExpressionType(e2);
			if (pdt != PopulationDataType.STATE_FORMULA) {
				error("Wrong expression type: expected "+PopulationDataType.STATE_FORMULA+" is "+pdt+"!" , PopulationPackage.Literals.AND_PCTL_FORMULA__RIGHT);

			}
		}
	}

	@Check
	public void checkAndFormulaTypeArgument( OrPctlFormula e ) {
		Expression e1 = e.getLeft();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.STATE_FORMULA) {
				error("Wrong expression type: expected "+PopulationDataType.STATE_FORMULA+" is "+pdt+"!" , PopulationPackage.Literals.OR_PCTL_FORMULA__LEFT);

			}
		}
		Expression e2 = e.getLeft();
		if (e2 != null) {
			PopulationDataType pdt = ti.getExpressionType(e2);
			if (pdt != PopulationDataType.STATE_FORMULA) {
				error("Wrong expression type: expected "+PopulationDataType.STATE_FORMULA+" is "+pdt+"!" , PopulationPackage.Literals.OR_PCTL_FORMULA__LEFT);

			}
		}
	}
	
	@Check
	public void checkLogFormulaTypeArgument( LogExpression e ) {
		Expression e1 = e.getArg();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.LOG_EXPRESSION__ARG);

			}
		}
	}
	

	@Check
	public void checkModExpressionTypeArguments(ModExpression e) {
		Expression e1 = e.getArg();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.MOD_EXPRESSION__ARG);

			}
		}
		Expression e2 = e.getMod();
		if (e2 != null) {
			PopulationDataType pdt = ti.getExpressionType(e2);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.MOD_EXPRESSION__MOD);

			}
		}
	}

	@Check
	public void checkPowExpressionTypeArguments(PowExpression e) {
		Expression e1 = e.getBase();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.POW_EXPRESSION__BASE);

			}
		}
		Expression e2 = e.getExp();
		if (e2 != null) {
			PopulationDataType pdt = ti.getExpressionType(e2);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.POW_EXPRESSION__EXP);

			}
		}
	}

	@Check
	public void checkFloorFormulaTypeArgument( FloorExpression e ) {
		Expression e1 = e.getArg();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.FLOOR_EXPRESSION__ARG);

			}
		}
	}	
	

	@Check
	public void checkCeilExpressionTypeArgument( CeilExpression e ) {
		Expression e1 = e.getArg();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.CEIL_EXPRESSION__ARG);

			}
		}
	}	

	@Check
	public void checkMinExpressionTypeArgument( MinExpression e ) {
		Expression e1 = e.getLeft();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.MIN_EXPRESSION__LEFT);

			}
		}
		Expression e2 = e.getRight();
		if (e2 != null) {
			PopulationDataType pdt = ti.getExpressionType(e2);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.MIN_EXPRESSION__RIGHT);

			}
		}
	}	

	@Check
	public void checkManExpressionTypeArgument( MaxExpression e ) {
		Expression e1 = e.getLeft();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.MAX_EXPRESSION__LEFT);

			}
		}
		Expression e2 = e.getRight();
		if (e2 != null) {
			PopulationDataType pdt = ti.getExpressionType(e2);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.MAX_EXPRESSION__RIGHT);

			}
		}
	}	
	
	@Check
	public void checkSinExpressionTypeArgument( SinExpression e ) {
		Expression e1 = e.getArg();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.SIN_EXPRESSION__ARG);
			}
		}
	}	

	@Check
	public void checkCosExpressionTypeArgument( CosExpression e ) {
		Expression e1 = e.getArg();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.COS_EXPRESSION__ARG);
			}
		}
	}
	
	@Check
	public void checkTanExpressionTypeArgument( TanExpression e ) {
		Expression e1 = e.getArg();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.TAN_EXPRESSION__ARG);
			}
		}
	}	

	@Check
	public void checkASinExpressionTypeArgument( ASinExpression e ) {
		Expression e1 = e.getArg();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.ASIN_EXPRESSION__ARG);
			}
		}
	}	

	@Check
	public void checkACosExpressionTypeArgument( ACosExpression e ) {
		Expression e1 = e.getArg();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.ACOS_EXPRESSION__ARG);
			}
		}
	}
	
	@Check
	public void checkATanExpressionTypeArgument( ATanExpression e ) {
		Expression e1 = e.getArg();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.NUMBER) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.ATAN_EXPRESSION__ARG);
			}
		}
	}	

	@Check
	public void checkNextFormulaTypeArgument( NextFormula f ) {
		Expression e1 = f.getArg();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.STATE_FORMULA) {
				error("Wrong expression type: expected "+PopulationDataType.NUMBER+" is "+pdt+"!" , PopulationPackage.Literals.NEXT_FORMULA__ARG);
			}
		}		
	}
	
	@Check
	public void checkNextFormulaTypeArgument( UntilFormula f ) {
		Expression e1 = f.getLeft();
		if (e1 != null) {
			PopulationDataType pdt = ti.getExpressionType(e1);
			if (pdt != PopulationDataType.STATE_FORMULA) {
				error("Wrong expression type: expected "+PopulationDataType.STATE_FORMULA+" is "+pdt+"!" , PopulationPackage.Literals.UNTIL_FORMULA__LEFT);
			}
		}		
		Expression e2 = f.getLeft();
		if (e2 != null) {
			PopulationDataType pdt = ti.getExpressionType(e2);
			if (pdt != PopulationDataType.STATE_FORMULA) {
				error("Wrong expression type: expected "+PopulationDataType.STATE_FORMULA+" is "+pdt+"!" , PopulationPackage.Literals.UNTIL_FORMULA__RIGHT);
			}
		}		
}

}
