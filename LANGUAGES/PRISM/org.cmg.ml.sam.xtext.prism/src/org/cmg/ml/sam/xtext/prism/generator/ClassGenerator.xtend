package org.cmg.ml.sam.xtext.prism.generator

import java.util.HashMap
import java.util.Map
import org.cmg.ml.sam.xtext.prism.prism.ActionRenaming
import org.cmg.ml.sam.xtext.prism.prism.AlphabetisedParallelComposition
import org.cmg.ml.sam.xtext.prism.prism.AndExpression
import org.cmg.ml.sam.xtext.prism.prism.AsynchronousParallelComposition
import org.cmg.ml.sam.xtext.prism.prism.Constant
import org.cmg.ml.sam.xtext.prism.prism.ConstantType
import org.cmg.ml.sam.xtext.prism.prism.Element
import org.cmg.ml.sam.xtext.prism.prism.Expression
import org.cmg.ml.sam.xtext.prism.prism.False
import org.cmg.ml.sam.xtext.prism.prism.Formula
import org.cmg.ml.sam.xtext.prism.prism.Hiding
import org.cmg.ml.sam.xtext.prism.prism.IfAndOnlyIf
import org.cmg.ml.sam.xtext.prism.prism.IfThenElse
import org.cmg.ml.sam.xtext.prism.prism.Implies
import org.cmg.ml.sam.xtext.prism.prism.ModuleReference
import org.cmg.ml.sam.xtext.prism.prism.MulExpression
import org.cmg.ml.sam.xtext.prism.prism.Negation
import org.cmg.ml.sam.xtext.prism.prism.OrExpression
import org.cmg.ml.sam.xtext.prism.prism.PrismSystem
import org.cmg.ml.sam.xtext.prism.prism.Reference
import org.cmg.ml.sam.xtext.prism.prism.RelExpression
import org.cmg.ml.sam.xtext.prism.prism.Relations
import org.cmg.ml.sam.xtext.prism.prism.Renaming
import org.cmg.ml.sam.xtext.prism.prism.RestrictedParallelComposition
import org.cmg.ml.sam.xtext.prism.prism.SumExpression
import org.cmg.ml.sam.xtext.prism.prism.True
import org.cmg.ml.sam.xtext.prism.prism.UpdateElement
import org.cmg.ml.sam.xtext.prism.prism.Variable
import org.cmg.ml.sam.xtext.prism.util.ModuleStructure
import org.cmg.ml.sam.xtext.prism.util.RenamedElement
import org.cmg.ml.sam.xtext.prism.util.SymbolTable
import org.cmg.ml.sam.xtext.prism.util.UpdateStructure
import org.eclipse.xtext.util.Wrapper
import org.cmg.ml.sam.xtext.prism.prism.PathFormulaDeclaration
import org.cmg.ml.sam.xtext.prism.prism.NextFormula
import org.cmg.ml.sam.xtext.prism.prism.UntilFormula
import org.cmg.ml.sam.xtext.prism.prism.StateOr
import org.cmg.ml.sam.xtext.prism.prism.StateAnd
import org.cmg.ml.sam.xtext.prism.prism.NegationFormula
import org.cmg.ml.sam.xtext.prism.prism.AtomicStateFormula
import org.cmg.ml.sam.xtext.prism.prism.ProbabilityFormula
import org.cmg.ml.sam.xtext.prism.prism.StateFormulaDeclaration
import org.eclipse.xtext.xbase.lib.Pair
import org.cmg.ml.sam.xtext.prism.prism.Type
import org.cmg.ml.sam.xtext.prism.prism.BooleanType
import org.cmg.ml.sam.xtext.prism.prism.IntervalType
import org.cmg.ml.sam.xtext.prism.prism.DecimalLiteral
import org.cmg.ml.sam.xtext.prism.prism.IntegerLiteral

class ClassGenerator {
	
	SymbolTable symbolTable;
	
	int variableIndex = -1;
	
	def setSymbolTable( SymbolTable symbolTable ) {
		this.symbolTable = symbolTable
	}
	
	def generateClass( 
		String packageName , 
		String moduleName , 
		Iterable<Element> constants ,
		Iterable<Element> formula ,
		Iterable<Element> globalVariables ,
		Iterable<Element> pathFormulae ,
		Iterable<Element> stateFormulae ,
		Element system ,
		Iterable<ModuleStructure> mlist
	) {
		variableIndex = globalVariables.size
		'''
		/*
		 * Java class automatically generetated by jSAM.
		 * 
		 * Source module: «moduleName»
		 */
		package «packageName»;
		
		import java.math.BigInteger;
		import org.apache.commons.math.random.RandomGenerator;
		import org.cmg.ml.sam.prism.*;
		import org.cmg.ml.sam.core.*;
		import org.cmg.ml.sam.core.logic.*;
		
		public class «moduleName» extends PrismModel {
			
			// START CONSTANTS
			«FOR c:constants»
			«c.generateDeclarationCode»
			«ENDFOR»
			// END CONSTANTS

			// START ACTIONS
			«FOR a:symbolTable.actions.generateIndexes»
			public static int _LABEL_«a.value» = «a.key+1»;
			«ENDFOR»
			// END ACTIONS


			//
			// START GLOBAL VARIABLES
			//
			«FOR v:globalVariables.generateIndexes»
			«v.generateDeclarationCode»
			«ENDFOR»
			//
			// END GLOBAL VARIABLES
			//

			«FOR m:mlist»
			
			

			//
			// START LOCAL VARIABLES MODULE «m.name»
			//
			«FOR v:m.localVariables.generateLocalVariableIndexes»
			public static int _LOCAL_«v.value» = «v.key»;
			«ENDFOR»
			//
			// END LOCAL VARIABLES MODULE «m.name»
			//

			
			«ENDFOR»	
			
								
			// STATE ENUMERATOR
			public static StateEnumerator generateStateEnumerator() {
				int[] lowerBounds = new int[«symbolTable.numberOfVariables»];
				«FOR v:symbolTable.globalVariables»
				lowerBounds[«symbolTable.getGlobalVariableCode(v)»] = «symbolTable.getTypeOf(v).lowerBound »;
				«ENDFOR»
				«FOR v:symbolTable.localVariables»
				lowerBounds[«symbolTable.getLocalVariableCode(v)»] = «symbolTable.getTypeOf(v).lowerBound »;
				«ENDFOR»

				int[] upperBounds = new int[«symbolTable.numberOfVariables»];
				«FOR v:symbolTable.globalVariables»
				upperBounds[«symbolTable.getGlobalVariableCode(v)»] = «symbolTable.getTypeOf(v).upperBound »;
				«ENDFOR»
				«FOR v:symbolTable.localVariables»
				upperBounds[«symbolTable.getLocalVariableCode(v)»] = «symbolTable.getTypeOf(v).upperBound »;
				«ENDFOR»
				
				return StateEnumerator.createEnumerator( lowerBounds , upperBounds );
			}
			
			public static StateEnumerator enumerator = generateStateEnumerator();
			
			// END STATE ENUMERATOR
			


			//
			// START FORMULAE
			//
			«FOR f:formula»
			«f.generateDeclarationCode»
			«ENDFOR»
			// 
			// END FORMULAE
			//
		
			«FOR m:mlist»

			//
			// START MODULE «m.name»
			//
			«FOR r:m.indexedRules»

			//
			// START RULE «r.key» 
			//
			public static Filter<BigInteger> GUARD_RULE_«r.key»_«m.name» = «r.value.guard.generateGuardFilter»;

			«FOR c:r.value.indexedCommands»
			public static Command COMMAND_«c.key»_RULE_«r.key»_«m.name» = «c.value.generateCommand»
			«ENDFOR»

			public static Rule RULE_«r.key»_«m.name» = new Rule( 
				«IF (r.value.action!=null)»_LABEL_«r.value.action» ,«ENDIF»
				GUARD_RULE_«r.key»_«m.name» , 
				new Command[] { «FOR c:r.value.indexedCommands SEPARATOR ','» COMMAND_«c.key»_RULE_«r.key»_«m.name» «ENDFOR»} 
			);
			//
			// END RULE «r.key»
			//
			«ENDFOR»	
				
			public static PrismSystem MODULE_«m.name» = new  BasicPrismSystem(
				«symbolTable.actions.size+1» 
				«FOR r:m.indexedRules»
				, RULE_«r.key»_«m.name»
				«ENDFOR»
			);	

			//
			// END MODULE «m.name»
			//

			«ENDFOR»
			
			@Override
			protected PrismSystem createSystem() {
				return «IF (system!=null)»«system.generateDeclarationCode»«ELSE»«mlist.defaultInstantiation»«ENDIF»;
			}
						
			public «moduleName»() {
				super( ModelType.DTMC , «symbolTable.actions.size+1» );	
				int[] lowerBounds = new int[«symbolTable.numberOfVariables»];
				«FOR v:symbolTable.globalVariables»
				lowerBounds[«symbolTable.getGlobalVariableCode(v)»] = «symbolTable.getTypeOf(v).lowerBound »;
				«ENDFOR»
				«FOR v:symbolTable.localVariables»
				lowerBounds[«symbolTable.getLocalVariableCode(v)»] = «symbolTable.getTypeOf(v).lowerBound »;
				«ENDFOR»

				int[] upperBounds = new int[«symbolTable.numberOfVariables»];
				«FOR v:symbolTable.globalVariables»
				upperBounds[«symbolTable.getGlobalVariableCode(v)»] = «symbolTable.getTypeOf(v).upperBound »;
				«ENDFOR»
				«FOR v:symbolTable.localVariables»
				upperBounds[«symbolTable.getLocalVariableCode(v)»] = «symbolTable.getTypeOf(v).upperBound »;
				«ENDFOR»
				
				setStateEnumerator( StateEnumerator.createEnumerator( lowerBounds , upperBounds ) );
				
				int[] startData = new int[«symbolTable.numberOfVariables»];
				«FOR v:symbolTable.globalVariables»
				startData[«symbolTable.getGlobalVariableCode(v)»] = «symbolTable.getInitExpression(v).initExpressionCode»;
				«ENDFOR»
				«FOR v:symbolTable.localVariables»
				startData[«symbolTable.getLocalVariableCode(v)»] = «symbolTable.getInitExpression(v).initExpressionCode»;
				«ENDFOR»
				start = new PrismState(getState(startData) ,this);				
				«FOR f:pathFormulae»
				«f.generateFormulaInizialization»
				«ENDFOR»
				«FOR f:stateFormulae»
				«f.generateFormulaInizialization»
				«ENDFOR»
			}


				
		}		
		'''
	}
	
	def lowerBound( Type t ) {
		switch t {
			BooleanType: '''0'''
			IntervalType: t.min.generateExpressionCode(null,false)
		}
	}
	
	def upperBound( Type t ) {
		switch t {
			BooleanType: '''1'''
			IntervalType: t.max.generateExpressionCode(null,false)
		}
	}
	
	def dispatch generateFormulaInizialization( Element e ) {
		''''''
	}

	def dispatch generateFormulaInizialization( PathFormulaDeclaration e ) {
		'''setPathFormula("«e.name»" , «e.formula.generatePathFormulaCode»);'''
	}

	def dispatch generateFormulaInizialization( StateFormulaDeclaration e ) {
		'''setStateFormula("«e.name»" , «e.formula.generateStateFormulaCode»);'''
	}
	
	def dispatch generatePathFormulaCode( NextFormula f ) {
		'''new Next<PrismState>( «f.arg.generateStateFormulaCode» )'''
	}
	
	def dispatch generatePathFormulaCode( UntilFormula f ) {
		'''new Until<PrismState>( «f.left.generateStateFormulaCode» «IF (f.bound != null)» , «f.bound.limit» «ENDIF» , «f.right.generateStateFormulaCode») '''
	}

	def dispatch generateStateFormulaCode( StateOr f ) {
		'''new Or<PrismState>( «f.left.generateStateFormulaCode» , «f.right.generateStateFormulaCode »)'''
	}

	def dispatch generateStateFormulaCode( StateAnd f ) {
		'''new And<PrismState>( «f.left.generateStateFormulaCode» , «f.right.generateStateFormulaCode »)'''
	}

	def dispatch generateStateFormulaCode( NegationFormula f ) {
		'''new Not<PrismState>( «f.argument.generateStateFormulaCode»)'''
	}
	
	def dispatch generateStateFormulaCode( AtomicStateFormula f ) {
		'''
		new Atomic<PrismState>( 
			new Predicate<PrismState>() {
				//@Override
				public boolean sat(PrismState state) {
					BigInteger currentState = state.getState();
					return «f.exp.generateExpressionCode(new HashMap<String,String>(),true)»;
				}							
			}
		)
		'''
	}
	
	def dispatch generateStateFormulaCode( ProbabilityFormula f ) {
		'''new PCheck<PrismState>( «f.relation.PCheckRelation» , «f.value.generateExpressionCode(null,false)» , «f.path.generatePathFormulaCode»)'''
	}
	
	def getPCheckRelation( Relations r ) {
		switch r {
			case Relations::EQ: '''Relation.EQ'''
			case Relations::LEQ: '''Relation.GEQ'''
			case Relations::LSS: '''Relation.LESS'''
			case Relations::GEQ: '''Relation.GEQ'''
			case Relations::GTR: '''Relation.GTR'''
		}
	}
	
	def getInitExpressionCode( RenamedElement<Expression> e ) {
		if (e == null) {
			'''0'''
		} else {
			e.element.generateExpressionCode(e.renaming,false)
		}
	}
	
	def defaultInstantiation( Iterable<ModuleStructure> mlist) {
		'''PrismSystem.alphabetisedParallelComposition( «FOR m:mlist SEPARATOR ','»MODULE_«m.name»«ENDFOR»)'''
	}
	
	def dispatch generateSystemInstantiationCode( PrismSystem p ) {
		''''''
	}

	def dispatch generateSystemInstantiationCode( AlphabetisedParallelComposition p ) {
		'''new AlphabetizedParalleSystem( «p.left.generateSystemInstantiationCode» , «p.right.generateSystemInstantiationCode» )'''
	}

	def dispatch generateSystemInstantiationCode( AsynchronousParallelComposition p ) {
		'''new InterleavedParalleSystem( «p.left.generateSystemInstantiationCode» , «p.right.generateSystemInstantiationCode» )'''
	}

	def dispatch generateSystemInstantiationCode( RestrictedParallelComposition p ) {
		'''new ControlledParallelSystem( «p.left.generateSystemInstantiationCode» , «p.actions.synchronizationArray» , «p.right.generateSystemInstantiationCode» )'''
	}
	
	def getSynchronizationArray( Iterable<String> sync ) {		
		var syncSet = symbolTable.actions.map[ a | sync.exists[ b | a==b ] ].map[ b | if (b) { "true" } else { "false" }]
		'''new boolean[] { false , «syncSet.join(',')» }'''
	}
	
	def dispatch generateSystemInstantiationCode( Hiding p ) {
		'''new SystemHiding( «p.actions.hideArray» , «p.argument.generateSystemInstantiationCode» )'''
	}
	
	def getHideArray( Iterable<String> hide ) {		
		var syncSet = symbolTable.actions.map[ a | hide.exists[ b | a==b ] ].map[ b | if (b) { "true" } else { "false" }]
		'''new boolean[] { false , «syncSet.join(',')» }'''
	}

	def dispatch generateSystemInstantiationCode( Renaming p ) {
		'''new SysteSystemRenaming( «p.renaming.getMapArray» , «p.argument.generateSystemInstantiationCode» )'''
	}	
	
	def dispatch generateSystemInstantiationCode( ModuleReference r ) {
		'''MODULE_«r.module.name»'''
	}

	def getMapArray( Iterable<ActionRenaming> f ) {		
		var syncSet = symbolTable.actions.map[ a | f.apply(a) ].map[ a | '''_LABEL_«a»''']
		'''new int[] { 0 , «syncSet.join(',')» }'''
	}

	def apply( Iterable<ActionRenaming> f , String a ) {
		var m = f.findFirst[ m | m.source == 0]
		if (m == null) {
			a
		} else {
			m.target
		}
	}

	
	def generateCommand(UpdateStructure structure) { 
		'''
		
		new Command( enumerator ) {
			@Override
			protected BigInteger doApply(BigInteger currentState , BigInteger nextState) {
				//PrismState nextState = currentState;
				«FOR rc:structure.updates»
				«rc.element.generateUpdateCode(rc.renaming)»
				«ENDFOR»
				return nextState;
			}

			@Override
			protected double computeWeight(BigInteger currentState) {
				double toReturn = 1.0;
				«FOR re:structure.weight.filter[ re | re.element != null]»
				toReturn = toReturn * («re.element.generateExpressionCode(re.renaming,false)»);
				«ENDFOR»
				return toReturn;
			}		
		};
		
		'''
	}
	
	def generateGuardFilter( Iterable<RenamedElement<Expression>> guard ) {
		'''
		new Filter<BigInteger>() {

			//@Override
			public boolean eval(BigInteger currentState) {
				return true «FOR er: guard»&& ( «er.element.generateExpressionCode(er.renaming,true)»)«ENDFOR»;
			}
			
		}
		'''	
	}
	
	def dispatch generateExpressionCode( Expression e , Map<String,String> renaming , boolean isBoolean ) {
		'''UNSUPPORTED'''	
	}
	
	def dispatch generateExpressionCode( IfThenElse e , Map<String,String> renaming , boolean isBoolean ) {
		'''(«e.guard.generateExpressionCode(renaming,true)»?«e.thenCase.generateExpressionCode(renaming,isBoolean)»:«e.elseCase.generateExpressionCode(renaming,isBoolean)»)'''		
	}
	
	def dispatch generateExpressionCode( Implies e , Map<String,String> renaming , boolean isBoolean ) {
		var str1 = e.left.generateExpressionCode(renaming,true)
		var str2 = e.right.generateExpressionCode(renaming,true)
		'''!(«str1»)||(«str2»)'''
	}

	def dispatch generateExpressionCode( IfAndOnlyIf e , Map<String,String> renaming , boolean isBoolean ) {
		var str1 = e.left.generateExpressionCode(renaming,true)
		var str2 = e.right.generateExpressionCode(renaming,true)
		'''(!(«str1»)||(«str2»))&&(!(«str2»)||(«str1»))'''
	}
	
	def dispatch generateExpressionCode( OrExpression e , Map<String,String> renaming , boolean isBoolean ) {
		'''(«e.left.generateExpressionCode(renaming,true)»)||(«e.right.generateExpressionCode(renaming,true)»)'''
	}
	
	def dispatch generateExpressionCode( AndExpression e , Map<String,String> renaming , boolean isBoolean ) {
		'''(«e.left.generateExpressionCode(renaming,true)»)&&(«e.right.generateExpressionCode(renaming,true)»)'''
	}
	
	def dispatch generateExpressionCode( RelExpression e , Map<String,String> renaming , boolean isBoolean ) {
		if (isBoolean) {
			'''(«e.left.generateExpressionCode(renaming,false)»)«e.relop.relationSymbol»(«e.right.generateExpressionCode(renaming,false)»)'''		
		} else {
			'''((«e.left.generateExpressionCode(renaming,true)»)«e.relop.relationSymbol»(«e.right.generateExpressionCode(renaming,true)»)?1:0)'''
		}
	}
	
	def getRelationSymbol( Relations r ) {
		if (r==Relations::EQ) {
			"=="
		} else {
			r.toString
		}
	}
	
	def dispatch generateExpressionCode( SumExpression e , Map<String,String> renaming , boolean isBoolean ) {
		'''(«e.left.generateExpressionCode(renaming,false)»)«e.op»(«e.right.generateExpressionCode(renaming,false)»)'''
	}

	def dispatch generateExpressionCode( MulExpression e , Map<String,String> renaming , boolean isBoolean ) {
		if (e.op.equals('/')) {
			'''((double) «e.left.generateExpressionCode(renaming,false)»)«e.op»((double) «e.right.generateExpressionCode(renaming,false)»)'''
		} else {
			'''(«e.left.generateExpressionCode(renaming,false)»)«e.op»(«e.right.generateExpressionCode(renaming,false)»)'''
		}
	}

	def dispatch generateExpressionCode( DecimalLiteral e , Map<String,String> renaming , boolean isBoolean ) {
		'''«e.integerPart.integerPart»«e.decimalPart»'''
	}
	
	def dispatch generateExpressionCode( IntegerLiteral e , Map<String,String> renaming , boolean isBoolean ) {
		'''«e.integerPart»'''
	}
	
	def dispatch generateExpressionCode( Reference e , Map<String,String> renaming , boolean isBoolean ) {
		var name = e.reference
		if ((renaming != null)&&(renaming.get(name)!=null)) {
			name = renaming.get(name)
		}
		symbolTable.getExpressionCode(name,isBoolean)
	}
	
	def dispatch generateExpressionCode( True e , Map<String,String> renaming , boolean isBoolean ) {
		if (isBoolean) {
			'''true'''
		} else {
			'''1'''		
		}
	}

	def dispatch generateExpressionCode( False e , Map<String,String> renaming , boolean isBoolean ) {
		if (isBoolean) {
			'''false'''
		} else {
			'''0'''		
		}
	}

	def dispatch generateExpressionCode( Negation e , Map<String,String> renaming , boolean isBoolean ) {
		if (isBoolean) {
			'''!(«e.arg.generateExpressionCode(renaming,true)»)'''
		} else {
			'''(«e.arg.generateExpressionCode(renaming,true)»?0:1)'''
		}
	}
		
	/*
	 * TO HANDLE!
	| MinFunction
	| MaxFunction
	| PowFunction
	| FloorFunction
	| CeilFunction
	| ModFunction
	| LogFunction
	 */
	
	def generateUpdateCode( UpdateElement u , Map<String,String> map) {
		var target = u.variable.replaceAll("'","");
		if ((map != null) && (map.get(target) != null)) {
			target = map.get(target)
		}
//		'''newState.setValueOf(«symbolTable.getSymbolCode(target)»,«u.expression.generateExpressionCode(map)»);'''
//		'''nextState = nextState.setValueOf(«symbolTable.getVariableCode(target)», «u.expression.generateExpressionCode(map,false)»);'''
		'''nextState = enumerator.set( nextState , «symbolTable.getVariableCode(target)», «u.expression.generateExpressionCode(map,false)»);'''
	}
	
	def generateLocalVariableIndexes( Iterable<String> vList ) {
		var res = generateIndexes(vList,variableIndex)
		variableIndex = variableIndex+vList.size	
		res
	}
	
	def <T> generateIndexes( Iterable<T> list ) {
		generateIndexes( list , 0 )
	}
	
	def <T> generateIndexes( Iterable<T> list , int start ) {
		val i = Wrapper::wrap(start)
		list.map[ r | 
			var c = i.get
			i.set(c+1)
			c -> r
		]
	}
	
	def dispatch generateDeclarationCode( Pair<Integer,Variable> p ) {
		'''public static int _GLOBAL_«p.value.name» = «p.key»;'''
	}
	
	def dispatch generateDeclarationCode( Constant c ) {
		'''public static «c.type.declarationType» _CONST_«c.name» = «c.exp.generateExpressionCode(null,c.type==ConstantType::CBOOL)»;'''
	}
	
	def getDeclarationType( ConstantType t ) {
		switch t {
			case ConstantType::CINT: '''int'''
			case ConstantType::CBOOL: '''boolean'''
			case ConstantType::CDOUBLE: '''double'''
		}
	}
	
	def dispatch generateDeclarationCode( Formula f ) {
		'''
		public static int «symbolTable.getFormulaCode(f.name)»( BigInteger currentState ) {
			return «f.expression.generateExpressionCode(new HashMap<String,String>(),false)»;	
		}
		'''
	}
	
}