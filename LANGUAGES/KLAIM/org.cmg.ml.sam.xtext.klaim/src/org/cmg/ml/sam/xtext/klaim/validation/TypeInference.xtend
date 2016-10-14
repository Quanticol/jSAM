package org.cmg.ml.sam.xtext.klaim.validation

import org.cmg.ml.sam.xtext.klaim.klaim.ACosExpression
import org.cmg.ml.sam.xtext.klaim.klaim.ASinExpression
import org.cmg.ml.sam.xtext.klaim.klaim.ATanExpression
import org.cmg.ml.sam.xtext.klaim.klaim.CeilExpression
import org.cmg.ml.sam.xtext.klaim.klaim.Conjunction
import org.cmg.ml.sam.xtext.klaim.klaim.ConstantDeclaration
import org.cmg.ml.sam.xtext.klaim.klaim.CosExpression
import org.cmg.ml.sam.xtext.klaim.klaim.Disjunction
import org.cmg.ml.sam.xtext.klaim.klaim.Expression
import org.cmg.ml.sam.xtext.klaim.klaim.FalseExpression
import org.cmg.ml.sam.xtext.klaim.klaim.FloorExpression
import org.cmg.ml.sam.xtext.klaim.klaim.LogExpression
import org.cmg.ml.sam.xtext.klaim.klaim.LogicalLocality
import org.cmg.ml.sam.xtext.klaim.klaim.MaxExpression
import org.cmg.ml.sam.xtext.klaim.klaim.MinExpression
import org.cmg.ml.sam.xtext.klaim.klaim.ModExpression
import org.cmg.ml.sam.xtext.klaim.klaim.MultiplicationDivision
import org.cmg.ml.sam.xtext.klaim.klaim.Negation
import org.cmg.ml.sam.xtext.klaim.klaim.NodeDeclaration
import org.cmg.ml.sam.xtext.klaim.klaim.NumberLiteral
import org.cmg.ml.sam.xtext.klaim.klaim.PowExpression
import org.cmg.ml.sam.xtext.klaim.klaim.Reference
import org.cmg.ml.sam.xtext.klaim.klaim.Relation
import org.cmg.ml.sam.xtext.klaim.klaim.SelfExpression
import org.cmg.ml.sam.xtext.klaim.klaim.SinExpression
import org.cmg.ml.sam.xtext.klaim.klaim.StringLiteral
import org.cmg.ml.sam.xtext.klaim.klaim.SummationSubtraction
import org.cmg.ml.sam.xtext.klaim.klaim.TanExpression
import org.cmg.ml.sam.xtext.klaim.klaim.TrueExpression
import org.cmg.ml.sam.xtext.klaim.klaim.Type
import org.cmg.ml.sam.xtext.klaim.klaim.Variable
import org.cmg.ml.sam.xtext.klaim.klaim.Call
import org.cmg.ml.sam.xtext.klaim.klaim.ProcessDeclaration
import org.cmg.ml.sam.xtext.klaim.klaim.FunctionDeclaration
import org.cmg.ml.sam.xtext.klaim.klaim.TupleSelection

class TypeInference {
	
	def dispatch KlaimType getType( Expression e ) {
		KlaimType::VOID
	}
	
	def dispatch KlaimType getType( Disjunction d ) {
		KlaimType::BOOLEAN
	}
	
	def dispatch KlaimType getType( Conjunction c ) {
		KlaimType::BOOLEAN
	}
	
	def dispatch KlaimType getType( Negation n ) {
		KlaimType::BOOLEAN
	}

	def dispatch KlaimType getType( Relation r ) {
		KlaimType::BOOLEAN
	}

	def dispatch KlaimType getType( TrueExpression e ) {
		KlaimType::BOOLEAN
	}
	
	def dispatch KlaimType getType( SummationSubtraction e ) {
		getMax(e.left.type , e.right.type)
	}
	
	def dispatch getType( MultiplicationDivision m ) {
//		getMax(m.left.type,m.right.type)
		KlaimType::ERROR
	}
	
	def dispatch  KlaimType getType( FalseExpression e ) {
		KlaimType::BOOLEAN
	}
	
	def dispatch  KlaimType getType( NumberLiteral n ) {
		if (n.isDouble) {
			KlaimType::DOUBLE
		} else {	
			KlaimType::INTEGER
		}
	}
	
	def dispatch  KlaimType getType( StringLiteral s ) {
		KlaimType::STRING
	}
	
	def dispatch  KlaimType getType( SelfExpression s ) {
		KlaimType::LOCALITY
	}
	
	def dispatch  KlaimType getType( MinExpression m ) {
		//getMax(m.left.type,m.right.type);
		KlaimType::ERROR
	}
	
	def dispatch  KlaimType getType( MaxExpression m ) {
		//getMax(m.left.type,m.right.type);
		KlaimType::ERROR
	}

	def dispatch  KlaimType getType( ModExpression m ) {
		KlaimType::INTEGER
	}

	def dispatch KlaimType getType( LogExpression m ) {
		KlaimType::DOUBLE
	}

	def dispatch KlaimType getType( SinExpression m ) {
		KlaimType::DOUBLE
	}

	def dispatch KlaimType getType( CosExpression m ) {
		KlaimType::DOUBLE
	}

	def dispatch KlaimType getType( TanExpression m ) {
		KlaimType::DOUBLE
	}

	def dispatch KlaimType getType( ASinExpression m ) {
		KlaimType::DOUBLE
	}

	def dispatch KlaimType getType( ACosExpression m ) {
		KlaimType::DOUBLE
	}

	def dispatch KlaimType getType( ATanExpression m ) {
		KlaimType::DOUBLE
	}
	
	
	def dispatch KlaimType getType( FloorExpression f ) {
		KlaimType::INTEGER
	}	
	
	def dispatch KlaimType getType( CeilExpression c ) {
		KlaimType::INTEGER
	}

	def dispatch KlaimType getType( PowExpression p ) {
		KlaimType::DOUBLE
	}
	
	def dispatch KlaimType getType( Reference r ) {
		r.ref.type
		KlaimType::ERROR
	}	
	
	def dispatch KlaimType getType( TupleSelection ts ) {
		KlaimType::DOUBLE		
	}
	
	def dispatch KlaimType getType( Call r ) {
		var f = r.function.ref
		switch (f) {
			ProcessDeclaration: KlaimType::PROCESS
			FunctionDeclaration: 		KlaimType::ERROR
			//f.returnType.type
			default: KlaimType::ERROR
		} 
	}		
	
	def dispatch KlaimType getType( LogicalLocality l ) {
		KlaimType::LOCALITY
	}
	
	def dispatch KlaimType getType( NodeDeclaration n ) {
		KlaimType::LOCALITY
	}
	
	def dispatch KlaimType getType( Variable v ) {
		v.type.type
		KlaimType::ERROR
		
	}		

	def dispatch KlaimType getType( ConstantDeclaration c ) {
		c.type.type
		KlaimType::ERROR
	}		
	
/* 	def dispatch KlaimType getType( TypeExpression e ) {
		var result = e.type.type
		for (m:e.modifiers) {
			switch m {
				case TypeModifier::ARRAYM: result = KlaimType::getArray(result)
				case TypeModifier::LISTM: result = KlaimType::getArray(result)
			}
		}
		result
	}*/
	
	def  dispatch KlaimType getType( Type t ) {
		switch t {
			case Type::KBOOL: KlaimType::BOOLEAN
			case Type::KINT: KlaimType::INTEGER
			case Type::KDOUBLE: KlaimType::DOUBLE
			case Type::KSTRING: KlaimType::STRING
			case Type::KLOCALITY: KlaimType::LOCALITY
			case Type::KPROCESS: KlaimType::PROCESS
			case Type::KVOID: KlaimType::VOID
			default:
				KlaimType::ERROR
		}
		
	}

	def KlaimType getMax( KlaimType t1 , KlaimType t2 ) {
		if (t1.contains(t2)) {
			return t1;
		}
		if (t2.contains(t1)) {
			return t2
		}
		return KlaimType::ERROR
	}
	
//	/*
//	 * Checks if values of type t2 can be assigned to
//	 * variables of type t1.
//	 */
//	def areCompatible( Type t1 , Type t2 ) {
//		(t1==t2)||((t1==Type::KDOUBLE)&&(t2==Type::KINT))		
//	}
	
}