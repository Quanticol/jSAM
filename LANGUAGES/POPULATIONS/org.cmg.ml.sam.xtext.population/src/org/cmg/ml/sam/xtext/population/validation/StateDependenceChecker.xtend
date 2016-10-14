package org.cmg.ml.sam.xtext.population.validation

import org.cmg.ml.sam.xtext.population.population.ACosExpression
import org.cmg.ml.sam.xtext.population.population.ASinExpression
import org.cmg.ml.sam.xtext.population.population.ATanExpression
import org.cmg.ml.sam.xtext.population.population.AndPctlFormula
import org.cmg.ml.sam.xtext.population.population.CeilExpression
import org.cmg.ml.sam.xtext.population.population.CosExpression
import org.cmg.ml.sam.xtext.population.population.Expression
import org.cmg.ml.sam.xtext.population.population.FalseFormula
import org.cmg.ml.sam.xtext.population.population.FloorExpression
import org.cmg.ml.sam.xtext.population.population.LiteralExpression
import org.cmg.ml.sam.xtext.population.population.LogExpression
import org.cmg.ml.sam.xtext.population.population.MaxExpression
import org.cmg.ml.sam.xtext.population.population.MinExpression
import org.cmg.ml.sam.xtext.population.population.ModExpression
import org.cmg.ml.sam.xtext.population.population.MulDivExpression
import org.cmg.ml.sam.xtext.population.population.NotFormula
import org.cmg.ml.sam.xtext.population.population.OrPctlFormula
import org.cmg.ml.sam.xtext.population.population.PopulationExpression
import org.cmg.ml.sam.xtext.population.population.PowExpression
import org.cmg.ml.sam.xtext.population.population.ProbabilityFormula
import org.cmg.ml.sam.xtext.population.population.RelationExpression
import org.cmg.ml.sam.xtext.population.population.SinExpression
import org.cmg.ml.sam.xtext.population.population.SumDiffExpression
import org.cmg.ml.sam.xtext.population.population.TanExpression
import org.cmg.ml.sam.xtext.population.population.TrueFormula

class StateDependenceChecker {
	
	def dispatch boolean isStateDependent( OrPctlFormula e ) {
		if (e.left.stateDependent && e.right.stateDependent) {
			true
		} else {
			false
		}
	}
	
	def dispatch boolean isStateDependent( AndPctlFormula e ) {
		if (e.left.stateDependent && e.right.stateDependent) {
			true
		} else {
			false
		}
	}
	
	def dispatch boolean isStateDependent( RelationExpression e ) {
		if (e.left.stateDependent && e.right.stateDependent) {
			true
		} else {
			false
		}
	}

	def dispatch boolean isStateDependent( SumDiffExpression e ) {
		if (e.left.stateDependent && e.right.stateDependent) {
			true
		} else {
			false
		}
	}

	def dispatch boolean isStateDependent( MulDivExpression e ) {
		if (e.left.stateDependent && e.right.stateDependent) {
			true
		} else {
			false
		}
	}
	
	def dispatch boolean isStateDependent( Number e ) {
		false
	}
	
	def dispatch boolean isStateDependent( NotFormula e ) {
		e.arg.stateDependent
	}

	def dispatch boolean isStateDependent( TrueFormula e ) {
		false	
	}
	
	def dispatch boolean isStateDependent( FalseFormula e ) {
		false	
	}
	
	def dispatch boolean isStateDependent( ProbabilityFormula e ) {
		false	
	}

	def dispatch boolean isStateDependent( LiteralExpression e ) {
		false	
	}
	
	def dispatch boolean isStateDependent( PopulationExpression e ) {
		true
	}

	def dispatch boolean isStateDependent( Expression e ) {
		false	
	}

	def dispatch boolean isStateDependent( LogExpression e ) {
		e.arg.stateDependent
	}

	def dispatch boolean isStateDependent( ModExpression e ) {
		if (e.arg.stateDependent && e.mod.stateDependent) {
			true
		} else {
			false
		}
	}

	def dispatch boolean isStateDependent( PowExpression e ) {
		if (e.base.stateDependent && e.exp.stateDependent) {
			true
		} else {
			false
		}
	}

	def dispatch boolean isStateDependent( FloorExpression e ) {
		e.arg.stateDependent
	}

	def dispatch boolean isStateDependent( CeilExpression e ) {
		e.arg.stateDependent
	}

	def dispatch boolean isStateDependent( MinExpression e ) {
		if (e.left.stateDependent && e.right.stateDependent) {
			true
		} else {
			false
		}
	}

	def dispatch boolean isStateDependent( MaxExpression e ) {
		if (e.left.stateDependent && e.right.stateDependent) {
			true
		} else {
			false
		}
	}

	def dispatch boolean isStateDependent( SinExpression e ) {
		e.arg.stateDependent
	}

	def dispatch boolean isStateDependent( CosExpression e ) {
		e.arg.stateDependent
	}

	def dispatch boolean isStateDependent( TanExpression e ) {
		e.arg.stateDependent
	}

	def dispatch boolean isStateDependent( ATanExpression e ) {
		e.arg.stateDependent
	}
	
	def dispatch boolean isStateDependent( ASinExpression e ) {
		e.arg.stateDependent
	}
	
	def dispatch boolean isStateDependent( ACosExpression e ) {
		e.arg.stateDependent
	}
	
	
}