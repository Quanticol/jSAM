package org.cmg.ml.sam.xtext.lprm.typing

import org.cmg.ml.sam.xtext.lprm.lprSpecification.Expression
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Or
import org.cmg.ml.sam.xtext.lprm.lprSpecification.And
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Not
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Equal
import org.cmg.ml.sam.xtext.lprm.lprSpecification.NotEqual
import org.cmg.ml.sam.xtext.lprm.lprSpecification.LessOrEqual
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Less
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Greater
import org.cmg.ml.sam.xtext.lprm.lprSpecification.GreaterOrEqual
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Plus
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Minus
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Modulo
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Mul
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Div
import org.cmg.ml.sam.xtext.lprm.lprSpecification.IfThenElse
import org.cmg.ml.sam.xtext.lprm.lprSpecification.IntConstant
import org.cmg.ml.sam.xtext.lprm.lprSpecification.FloatConstant
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Log
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Ceil
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Floor
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Exp
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Pow
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Min
import org.cmg.ml.sam.xtext.lprm.lprSpecification.True
import org.cmg.ml.sam.xtext.lprm.lprSpecification.False
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Max
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Reference
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Constant
import org.cmg.ml.sam.xtext.lprm.lprSpecification.MacroFunction
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Variable
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Type
import org.cmg.ml.sam.xtext.lprm.lprSpecification.BooleanType
import org.cmg.ml.sam.xtext.lprm.lprSpecification.IntervalType
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Activity
import org.cmg.ml.sam.xtext.lprm.lprSpecification.IntegerType
import org.cmg.ml.sam.xtext.lprm.lprSpecification.FloatType
import org.cmg.ml.sam.xtext.lprm.lprSpecification.NameableElement

class TypeProvider {
	
	def dispatch LprmType typeFor( Expression e ) {
		LprmType::VOID
	}
	
	def dispatch LprmType typeFor( Or e ) {
		LprmType::BOOLEAN_TYPE
	}
	
	def dispatch LprmType typeFor( And e ) {
		LprmType::BOOLEAN_TYPE
	}
	
	def dispatch LprmType typeFor( Not t ) {
		LprmType::BOOLEAN_TYPE
	}
	
	def dispatch LprmType typeFor( Equal e) {
		LprmType::BOOLEAN_TYPE
	}

	def dispatch LprmType typeFor( NotEqual e) {
		LprmType::BOOLEAN_TYPE
	}
	
	def dispatch LprmType typeFor( LessOrEqual e) {
		LprmType::BOOLEAN_TYPE
	}

	def dispatch LprmType typeFor( Less e) {
		LprmType::BOOLEAN_TYPE
	}

	def dispatch LprmType typeFor( Greater e) {
		LprmType::BOOLEAN_TYPE
	}

	def dispatch LprmType typeFor( GreaterOrEqual e) {
		LprmType::BOOLEAN_TYPE
	}
	
	def dispatch LprmType typeFor( Plus e ) {
		(e?.left.typeFor ?: LprmType::VOID )?.combine( e.right?.typeFor ?: LprmType::VOID ).toNumberType 
	}

	def dispatch LprmType typeFor( Minus e ) {
		(e?.left.typeFor ?: LprmType::VOID )?.combine( e.right?.typeFor ?: LprmType::VOID ).toNumberType  
	}

	def dispatch LprmType typeFor( Modulo e) {
		LprmType::INT_TYPE
	}
	
	def dispatch LprmType typeFor( Mul e ) {
		(e?.left.typeFor ?: LprmType::VOID )?.combine( e.right?.typeFor ?: LprmType::VOID ).toNumberType 
	}	

	def dispatch LprmType typeFor( Div e ) {
		(e?.left.typeFor ?: LprmType::VOID )?.combine( e.right?.typeFor ?: LprmType::VOID ).toNumberType  
	}	

	def dispatch LprmType typeFor( IfThenElse e ) {
		(e?.thenCase.typeFor ?: LprmType::VOID )?.combine( e.elseCase?.typeFor ?: LprmType::VOID ) 
	}	
	
	def dispatch LprmType typeFor( IntConstant e ) {
		LprmType::INT_TYPE
	}
	
	def dispatch LprmType typeFor( FloatConstant e ) {
		LprmType::REAL_TYPE
	}

	def dispatch LprmType typeFor( Log e ) {
		LprmType::REAL_TYPE
	}

	def dispatch LprmType typeFor( Ceil e ) {
		LprmType::INT_TYPE
	}

	def dispatch LprmType typeFor( Floor e ) {
		LprmType::INT_TYPE
	}

	def dispatch LprmType typeFor( Exp e ) {
		LprmType::REAL_TYPE
	}

	def dispatch LprmType typeFor( Pow e ) {
		(e?.base.typeFor ?: LprmType::VOID )?.combine( e.exponent?.typeFor ?: LprmType::VOID ).toNumberType  
	}

	def dispatch LprmType typeFor( Min e ) {
		(e?.left.typeFor ?: LprmType::VOID )?.combine( e.right?.typeFor ?: LprmType::VOID ).toNumberType  
	}

	def dispatch LprmType typeFor( Max e ) {
		(e?.left.typeFor ?: LprmType::VOID )?.combine( e.right?.typeFor ?: LprmType::VOID ).toNumberType  
	}

	def dispatch LprmType typeFor( True e ) {
		LprmType::BOOLEAN_TYPE
	}
	
	def dispatch LprmType typeFor( False e ) {
		LprmType::BOOLEAN_TYPE
	}
	
	def dispatch LprmType typeFor( Reference r ) {
		r.reference.typeOf
	}
	
	def LprmType typeOf( NameableElement e ) {
		switch e {
			Constant: e.expression.typeFor
			MacroFunction: e.expression.typeFor
			Variable: e.type.toLprmType
			Activity: LprmType::ACTIVITY_TYPE
		}
	}
	
	def LprmType toLprmType(Type type) {
		switch type {
			BooleanType: LprmType::BOOLEAN_TYPE
			IntervalType: LprmType::INT_TYPE
			IntegerType: LprmType::INT_TYPE
			FloatType: LprmType::REAL_TYPE
		}
	}
	
	def combine(LprmType type1, LprmType type2) {
		if (type1 == type2) {
			type1
		} else {
			if (
				(type1==LprmType::INT_TYPE)&&(type2==LprmType::REAL_TYPE)
				|| (type2==LprmType::INT_TYPE)&&(type1==LprmType::REAL_TYPE)
			) {
				LprmType::REAL_TYPE
			} else {
				LprmType::VOID
			}			
		}
	}
	
	def private toNumberType( LprmType type ) {
		switch (type) {
			case LprmType::BOOLEAN_TYPE: LprmType::VOID
			case LprmType::ACTIVITY_TYPE: LprmType::ACTIVITY_TYPE
			default: type 
		}
	}
	
	def isCompatibleWith( LprmType type1 , LprmType type2 ) {
		(type1 == type2)
		||
		(type1==LprmType::INT_TYPE)&&(type2==LprmType::REAL_TYPE)
		||
		(type2==LprmType::INT_TYPE)&&(type1==LprmType::REAL_TYPE)		
	}
	
	def isAssignableTo( LprmType type1 , LprmType type2 ) {
		(type1 == LprmType::VOID)
		||
		(type2==LprmType::VOID)
		||
		(type1 == type2)
		||
		((type1 == LprmType::INT_TYPE)&&(type2==LprmType::REAL_TYPE))
	}
}