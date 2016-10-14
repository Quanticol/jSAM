package org.cmg.ml.sam.xtext.population.validation

import org.cmg.ml.sam.xtext.population.population.ACosExpression
import org.cmg.ml.sam.xtext.population.population.ASinExpression
import org.cmg.ml.sam.xtext.population.population.ATanExpression
import org.cmg.ml.sam.xtext.population.population.AndPctlFormula
import org.cmg.ml.sam.xtext.population.population.CeilExpression
import org.cmg.ml.sam.xtext.population.population.Constant
import org.cmg.ml.sam.xtext.population.population.CosExpression
import org.cmg.ml.sam.xtext.population.population.DecimalLiteral
import org.cmg.ml.sam.xtext.population.population.FalseFormula
import org.cmg.ml.sam.xtext.population.population.FloorExpression
import org.cmg.ml.sam.xtext.population.population.Formula
import org.cmg.ml.sam.xtext.population.population.LiteralExpression
import org.cmg.ml.sam.xtext.population.population.LogExpression
import org.cmg.ml.sam.xtext.population.population.MaxExpression
import org.cmg.ml.sam.xtext.population.population.MinExpression
import org.cmg.ml.sam.xtext.population.population.ModExpression
import org.cmg.ml.sam.xtext.population.population.MulDivExpression
import org.cmg.ml.sam.xtext.population.population.NotFormula
import org.cmg.ml.sam.xtext.population.population.OrPctlFormula
import org.cmg.ml.sam.xtext.population.population.PathFormula
import org.cmg.ml.sam.xtext.population.population.PopulationExpression
import org.cmg.ml.sam.xtext.population.population.PowExpression
import org.cmg.ml.sam.xtext.population.population.ProbabilityFormula
import org.cmg.ml.sam.xtext.population.population.RelationExpression
import org.cmg.ml.sam.xtext.population.population.SinExpression
import org.cmg.ml.sam.xtext.population.population.SumDiffExpression
import org.cmg.ml.sam.xtext.population.population.TanExpression
import org.cmg.ml.sam.xtext.population.population.TrueFormula
import org.cmg.ml.sam.xtext.population.population.NumberExpression
import org.cmg.ml.sam.xtext.population.population.StateConstant
import org.cmg.ml.sam.xtext.population.population.NumberLiteral

class TypeInference {
	
	def dispatch getExpressionType( OrPctlFormula e ) {
		PopulationDataType::STATE_FORMULA;
	}
	
	def dispatch getExpressionType( AndPctlFormula e ) {
		PopulationDataType::STATE_FORMULA;
	}
	
	def dispatch getExpressionType( RelationExpression e ) {
		PopulationDataType::STATE_FORMULA;
	}

	def dispatch getExpressionType( SumDiffExpression e ) {
		PopulationDataType::NUMBER;
	}

	def dispatch getExpressionType( MulDivExpression e ) {
		PopulationDataType::NUMBER;
	}
	
	def dispatch getExpressionType( DecimalLiteral e ) {
		PopulationDataType::NUMBER;
	}
	
	def dispatch getExpressionType( NumberLiteral e ) {
		PopulationDataType::NUMBER;
	}
	
	def dispatch getExpressionType( NotFormula e ) {
		PopulationDataType::STATE_FORMULA;
	}

	def dispatch getExpressionType( NumberExpression e ) {
		PopulationDataType::NUMBER;
	}

	def dispatch getExpressionType( TrueFormula e ) {
		PopulationDataType::STATE_FORMULA;
	}
	
	def dispatch getExpressionType( FalseFormula e ) {
		PopulationDataType::STATE_FORMULA;
	}
	
	def dispatch getExpressionType( ProbabilityFormula e ) {
		PopulationDataType::STATE_FORMULA;		
	}

	def dispatch getExpressionType( LiteralExpression e ) {
		switch e.ref {
			Constant: PopulationDataType::NUMBER 
			Formula: PopulationDataType::STATE_FORMULA
			PathFormula: PopulationDataType::PATH_FORMULA
			StateConstant: PopulationDataType::STATE_FORMULA
		}
	}
	
	def dispatch getExpressionType( PopulationExpression e ) {
		PopulationDataType::NUMBER		
	}

//	def dispatch getExpressionType( Expression e ) {
//		PopulationDataType::ERROR		
//	}

	def dispatch getExpressionType( LogExpression e ) {
		PopulationDataType::NUMBER		
	}

	def dispatch getExpressionType( ModExpression e ) {
		PopulationDataType::NUMBER		
	}

	def dispatch getExpressionType( PowExpression e ) {
		PopulationDataType::NUMBER		
	}

	def dispatch getExpressionType( FloorExpression e ) {
		PopulationDataType::NUMBER		
	}

	def dispatch getExpressionType( CeilExpression e ) {
		PopulationDataType::NUMBER		
	}

	def dispatch getExpressionType( MinExpression e ) {
		PopulationDataType::NUMBER		
	}

	def dispatch getExpressionType( MaxExpression e ) {
		PopulationDataType::NUMBER		
	}

	def dispatch getExpressionType( SinExpression e ) {
		PopulationDataType::NUMBER		
	}

	def dispatch getExpressionType( CosExpression e ) {
		PopulationDataType::NUMBER		
	}

	def dispatch getExpressionType( TanExpression e ) {
		PopulationDataType::NUMBER		
	}

	def dispatch getExpressionType( ATanExpression e ) {
		PopulationDataType::NUMBER		
	}
	
	def dispatch getExpressionType( ASinExpression e ) {
		PopulationDataType::NUMBER		
	}
	
	def dispatch getExpressionType( ACosExpression e ) {
		PopulationDataType::NUMBER		
	}


}