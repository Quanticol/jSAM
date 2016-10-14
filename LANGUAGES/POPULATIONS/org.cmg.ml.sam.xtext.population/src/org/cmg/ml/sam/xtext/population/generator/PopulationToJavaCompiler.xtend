package org.cmg.ml.sam.xtext.population.generator

import org.cmg.ml.sam.xtext.population.population.Model
import org.cmg.ml.sam.xtext.population.population.StateConstant
import org.eclipse.xtext.util.Wrapper
import org.eclipse.xtext.xbase.lib.Pair
import org.cmg.ml.sam.xtext.population.population.Constant
import org.cmg.ml.sam.xtext.population.population.RelationExpression
import org.cmg.ml.sam.xtext.population.population.Expression
import org.cmg.ml.sam.xtext.population.population.SumDiffExpression
import org.cmg.ml.sam.xtext.population.population.MulDivExpression
import org.cmg.ml.sam.xtext.population.population.NotFormula
import org.cmg.ml.sam.xtext.population.population.TrueFormula
import org.cmg.ml.sam.xtext.population.population.FalseFormula
import org.cmg.ml.sam.xtext.population.population.LiteralExpression
import org.cmg.ml.sam.xtext.population.population.Label
import org.cmg.ml.sam.xtext.population.population.Formula
import org.cmg.ml.sam.xtext.population.population.ModExpression
import org.cmg.ml.sam.xtext.population.population.LogExpression
import org.cmg.ml.sam.xtext.population.population.PowExpression
import org.cmg.ml.sam.xtext.population.population.FloorExpression
import org.cmg.ml.sam.xtext.population.population.CeilExpression
import org.cmg.ml.sam.xtext.population.population.MinExpression
import org.cmg.ml.sam.xtext.population.population.MaxExpression
import org.cmg.ml.sam.xtext.population.population.SinExpression
import org.cmg.ml.sam.xtext.population.population.CosExpression
import org.cmg.ml.sam.xtext.population.population.TanExpression
import org.cmg.ml.sam.xtext.population.population.ATanExpression
import org.cmg.ml.sam.xtext.population.population.ASinExpression
import org.cmg.ml.sam.xtext.population.population.ACosExpression
import org.cmg.ml.sam.xtext.population.population.PopulationExpression
import org.cmg.ml.sam.xtext.population.population.DecimalLiteral
import org.cmg.ml.sam.xtext.population.population.NumberLiteral
import org.cmg.ml.sam.xtext.population.population.ReferenceableName
import org.cmg.ml.sam.xtext.population.population.OrPctlFormula
import org.cmg.ml.sam.xtext.population.population.AndPctlFormula
import org.cmg.ml.sam.xtext.population.population.ProbabilityFormula
import org.cmg.ml.sam.xtext.population.population.RelationSymbol
import org.cmg.ml.sam.xtext.population.population.NamedPctlPathFormula
import org.cmg.ml.sam.xtext.population.population.NextFormula
import org.cmg.ml.sam.xtext.population.population.UntilFormula
import org.cmg.ml.sam.xtext.population.population.Action
import org.cmg.ml.sam.xtext.population.population.PathFormula
import org.cmg.ml.sam.xtext.population.population.Configuration

class PopulationToJavaCompiler {
		
	public static String typeOfStateOfIndividuals = "PopulationState"	

	public static String typeOfFastSimulationState = "FastSimulationState"	

	def compile( String packageName , String className , Model m ) {
		'''
		package «packageName»;
		
		import org.cmg.ml.sam.core.*;
		import org.cmg.ml.sam.core.logic.*;
		import org.cmg.ml.sam.population.*;
		import java.util.Map;
		import java.util.HashMap;
		
		public class «className» extends PopulationSpecification {
			
			«generateStateNameDeclarations(m.elements.filter(typeof(StateConstant)).map[ s | s.name ].generateIndexes(0))»

			«generateConstantDeclarations(m.elements.filter(typeof(Constant)))»	
			
			«generateProbabilityFunctionDeclarations(m.elements.filter(typeof(Action)))»
			
			«generateLabelDeclaration(m.elements.filter(typeof(Label)))»

			«generateStateDeclarations(m.elements.filter(typeof(StateConstant)))»
					
			«generateModelDeclaration(m.elements.filter(typeof(StateConstant)))»

			«generateLabelStateOfIndividuals(m.elements.filter(typeof(StateConstant)))»

			«generateLabelFastSimulationState(m.elements.filter(typeof(StateConstant)))»

			«generateStateFormulaeDeclaration(m.elements.filter(typeof(Formula)))»

			«generatePathFormulaeDeclaration(m.elements.filter(typeof(PathFormula)))»
			
			«generateConfigurationsDeclarations(m.elements.filter(typeof(Configuration)))»
			
			public «className»() {
				initStateNameVector();	
				initPopulationModule();
				initConfigurations();
				initStateFormulaeTables();
				initPathFormulaeTables();
			}


			
		}
		'''
	}
	def generateConfigurationsDeclarations(Iterable<Configuration> configurations) { 
		'''
		protected void initConfigurations() {			
			configurations = new String[] {
				«FOR c:configurations SEPARATOR ','»
				"«c.name»"
				«ENDFOR»			
			};
			«IF configurations.size>0»
			PopulationState state;
			«FOR c:configurations»
			state = module.getState( 
				«FOR e:c.elements SEPARATOR ','»
				new int[] { «e.state.name.stateVariable» , «IF e.hasSize»(int) «e.size.generateExpressionCode(StateLanguage::NONE)»«ELSE»1«ENDIF» }
				«ENDFOR»
			);
			configurationsForIndividuals.put("«c.name»",state);		
			configurationsForFastSimulation.put("«c.name»",state.project(0));	
			«ENDFOR»	
			«ENDIF»
		}
		
		'''		
	}

	
	def generateStateFormulaeDeclaration(Iterable<Formula> formulas) { 
		'''

		«FOR f:formulas»
		public static StateFormula<«typeOfStateOfIndividuals»> «f.name.getStateFormulaVariable(StateLanguage::INDIVIDUALS)» {
			 return «f.formula.generateExpressionCode(StateLanguage::INDIVIDUALS)»;
		}

		public static StateFormula<«typeOfFastSimulationState»> «f.name.getStateFormulaVariable(StateLanguage::FASTSIMULATION)» {
			return «f.formula.generateExpressionCode(StateLanguage::FASTSIMULATION)»;
		}
		«ENDFOR»

		protected void initStateFormulaeTables() {
			stateFormulae = new String[] {
				«FOR f:formulas SEPARATOR ','»
				"«f.name»"
				«ENDFOR»
			};
			«FOR f:formulas»
			stateFormulaeForIndividuals.put("«f.name»",«f.name.getStateFormulaVariable(StateLanguage::INDIVIDUALS)»);
			stateFormulaeForFastSimulation.put("«f.name»",«f.name.getStateFormulaVariable(StateLanguage::FASTSIMULATION)»);
			«ENDFOR»
		}
		'''
	}

	def generatePathFormulaeDeclaration(Iterable<PathFormula> formulas) { 
		'''
		«FOR f:formulas»
		public static PathFormula<«typeOfStateOfIndividuals»> «f.name.getPathFormulaVariable(StateLanguage::INDIVIDUALS)» {
			return «f.formula.generateExpressionCode(StateLanguage::INDIVIDUALS)»;
		}

		public static PathFormula<«typeOfFastSimulationState»> «f.name.getPathFormulaVariable(StateLanguage::FASTSIMULATION)» {
			return «f.formula.generateExpressionCode(StateLanguage::FASTSIMULATION)»;
		}
		«ENDFOR»

		protected void initPathFormulaeTables() {
			pathFormulae = new String[] {
				«FOR f:formulas SEPARATOR ','»
				"«f.name»"
				«ENDFOR»
			};
			«FOR f:formulas»
			pathFormulaeForIndividuals.put("«f.name»",«f.name.getPathFormulaVariable(StateLanguage::INDIVIDUALS)»);
			pathFormulaeForFastSimulation.put("«f.name»",«f.name.getPathFormulaVariable(StateLanguage::FASTSIMULATION)»);
			«ENDFOR»
		}
		'''
	}


	def generateLabelDeclaration(Iterable<Label> labels) { 
		'''
		«FOR l:labels»
		public static Atomic<«typeOfStateOfIndividuals»> «l.name.getLabelVariable(StateLanguage::INDIVIDUALS)» = new Atomic<«typeOfStateOfIndividuals»>( 
		
			new Predicate<«typeOfStateOfIndividuals»>() {
				
				public boolean sat( «typeOfStateOfIndividuals» t) {						
					int state = t.getStateAt(0);
					return false
						«FOR s:l.states»
						||(state == «s.name.stateVariable»);
						«ENDFOR»;					
				}			
					
			}
			
		);
		«ENDFOR»
		'''		
	}

	def generateLabelStateOfIndividuals( Iterable<StateConstant> constants ) {
		'''
		«FOR s:constants»
		public static Atomic<«typeOfStateOfIndividuals»> «s.name.stateVariable»_OF_INDIVIDUALS = new Atomic<«typeOfStateOfIndividuals»>( 
		
			new Predicate<«typeOfStateOfIndividuals»>() {
				
				public boolean sat( «typeOfStateOfIndividuals» t) {						
					return «s.name.stateVariable» == t.getStateAt(0);					
				}			
					
			}
			
		);
		«ENDFOR»
		'''				
	}

	def generateLabelFastSimulationState( Iterable<StateConstant> constants ) {
		'''
		«FOR s:constants»
		public static Atomic<FastSimulationState> «s.name.stateVariable»_OF_FASTSIMULATION = new Atomic<FastSimulationState>( 
		
			new Predicate<FastSimulationState>() {
				
				public boolean sat( FastSimulationState t) {						
					return «s.name.stateVariable» == t.getState();					
				}			
					
			}
			
		);
		«ENDFOR»
		'''				
	}
	
	def generateModelDeclaration(Iterable<StateConstant> constants) { 
		'''
		
		protected void initPopulationModule() {		
		 	this.module = new PopulationModule( 
				«constants.size» «IF constants.size>0»,«ENDIF» 
				«FOR s:constants SEPARATOR ','»
				«s.name.stateRuleName»
				«ENDFOR»
			);		
		}
		'''		
	}

	def generateStateDeclarations(Iterable<StateConstant> states) { 
		'''
		«FOR s:states»
		public static LocalState «s.name.stateRuleName» =  new LocalState( 
			«s.name.stateVariable» «IF s.transitions.size>0»,«ENDIF»  
			«FOR t:s.transitions SEPARATOR ','»
				new LocalState.RuleElement( «t.action.name.actionProbabilityFunctionVariable» , «t.nextState.name.stateVariable» ) 
			«ENDFOR»
		);
		«ENDFOR»
		'''		
		
	}

	def generateProbabilityFunctionDeclarations(Iterable<Action> actions) { 
		'''
		«FOR a:actions»
		public static ProbabilityFunction «a.name.actionProbabilityFunctionVariable» = new ProbabilityFunction() {
		
			//@Override 
			public double eval(double[] occupancy) {
				return «a.probability.generateExpressionCode(StateLanguage::NONE)»;
			}
			
		};
		«ENDFOR»
		'''
	}

	
	def generateConstantDeclarations( Iterable<Constant> constants ) {
		'''
		«FOR c:constants»
		public static double «c.name.constantVariable» = «c.exp.generateExpressionCode(StateLanguage::NONE)»;
		«ENDFOR»
		'''	
	}
	def generateStateNameDeclarations( Iterable<Pair<Integer, String>> states ) { 
		'''
		«FOR s:states»
		public static int «s.value.stateVariable» = «s.key»;
		«ENDFOR»
		
		protected void initStateNameVector() {
			this.states = new String[«states.size»];
			«FOR s:states»
			states[«s.value.stateVariable»] = "«s.value»";
			«ENDFOR»
		}
		
		'''	
	}

	def getActionProbabilityFunctionVariable( String action ) {
		'''_ACT_«action»_PROBABILITY_'''
	}

	def getStateRuleName( String state ) {
		'''_RULE_«state»'''
	}

	def getStateVariable( String state ) {
		'''_STATE_«state»'''
	}
	
	def getStatePredicate( String state , StateLanguage language ) {
		'''«state.stateVariable»_OF_«language»'''
	}

	def getLabelVariable( String label , StateLanguage language ) {
		'''_LABEL_«label»_OF_«language»'''
	}

	def getStateFormulaVariable( String formula , StateLanguage language ) {
		'''_STATE_FORMULA_«formula»_OF_«language»()'''
	}

	def getPathFormulaVariable( String formula , StateLanguage language ) {
		'''_PATH_FORMULA_«formula»_OF_«language»()'''
	}

	def getConstantVariable( String formula ) {
		'''_CONST_«formula»'''
	}
	
	def <T> generateIndexes( Iterable<T> list , int start ) {
		val i = Wrapper::wrap(start)
		list.map[ r | 
			var c = i.get
			i.set(c+1)
			c -> r
		]
	}
	
	/*
	 * This function is used to generate the code associated to numerical
	 * expressions.
	 */
	def dispatch CharSequence generateExpressionCode( Expression e , StateLanguage language ) {
		'''ERROR'''
	}

	def dispatch CharSequence generateExpressionCode( RelationExpression e , StateLanguage language ) {
		'''
		new Atomic<«language.codeToType»>( 
		
			new Predicate<«language.codeToType»>() {
				
				public boolean sat( «language.codeToType» state ) {
					return («e.left.generateExpressionCode(language)»)«e.op»(«e.right.generateExpressionCode(language)»);			
				}			
					
			}
			
		)
		'''
	}

	def dispatch CharSequence generateExpressionCode( SumDiffExpression e , StateLanguage language ) {
		'''(«e.left.generateExpressionCode(language)»)«e.op»(«e.right.generateExpressionCode(language)»)'''
	}
	
	def dispatch CharSequence generateExpressionCode( MulDivExpression e , StateLanguage language ) {
		'''(«e.left.generateExpressionCode(language)»)«e.op»(«e.right.generateExpressionCode(language)»)'''
	}

	def dispatch CharSequence generateExpressionCode( NotFormula e , StateLanguage language ) {
		'''new Not<«language.codeToType»>(«e.arg.generateExpressionCode(language)»)'''
	}	

	def dispatch CharSequence generateExpressionCode( TrueFormula e , StateLanguage language ) {
		'''new True<«language.codeToType»>()'''
	}	
	
	def dispatch CharSequence generateExpressionCode( FalseFormula e , StateLanguage language ) {
		'''new False<«language.codeToType»>()'''
	}	

	def dispatch CharSequence generateExpressionCode( LiteralExpression e , StateLanguage language ) {
		var reference = e.ref
		switch reference {
			Label: reference.name.getLabelVariable(language)
			Formula: reference.name.getStateFormulaVariable(language)
			Constant: reference.name.constantVariable
			PathFormula: reference.name.getPathFormulaVariable(language)
			StateConstant: reference.name.getStatePredicate(language)
		}		 		
	}	
	
	def dispatch CharSequence generateExpressionCode( ModExpression e , StateLanguage language ) {
		'''(«e.arg.generateExpressionCode(language)»)%(«e.mod.generateExpressionCode(language)»)'''
	}

	def dispatch CharSequence generateExpressionCode( LogExpression e , StateLanguage language ) {
		'''Math.log( «e.arg.generateExpressionCode(language)» )'''
	}
	
	def dispatch CharSequence generateExpressionCode( PowExpression e , StateLanguage language ) {
		'''Math.pow( «e.base.generateExpressionCode(language)» , «e.exp.generateExpressionCode(language)» )'''
	}
	
	def dispatch CharSequence generateExpressionCode( FloorExpression e , StateLanguage language ) {
		'''Math.floor( «e.arg.generateExpressionCode(language)» )'''
	}
	
	def dispatch CharSequence generateExpressionCode( CeilExpression e , StateLanguage language ) {
		'''Math.ceil( «e.arg.generateExpressionCode(language)» )'''
	}
	
	def dispatch CharSequence generateExpressionCode( MinExpression e , StateLanguage language ) {
		'''Math.min( «e.left.generateExpressionCode(language)» , «e.right.generateExpressionCode(language)» )'''
	}

	def dispatch CharSequence generateExpressionCode( MaxExpression e , StateLanguage language ) {
		'''Math.max( «e.left.generateExpressionCode(language)» , «e.right.generateExpressionCode(language)» )'''
	}

	def dispatch CharSequence generateExpressionCode( SinExpression e , StateLanguage language ) {
		'''Math.sin( «e.arg.generateExpressionCode(language)» )'''
	}
	
	def dispatch CharSequence generateExpressionCode( CosExpression e , StateLanguage language ) {
		'''Math.cos( «e.arg.generateExpressionCode(language)» )'''
	}
	
	def dispatch CharSequence generateExpressionCode( TanExpression e , StateLanguage language ) {
		'''Math.tan( «e.arg.generateExpressionCode(language)» )'''
	}
	
	def dispatch CharSequence generateExpressionCode( ATanExpression e , StateLanguage language ) {
		'''Math.atan( «e.arg.generateExpressionCode(language)» )'''
	}
	
	def dispatch CharSequence generateExpressionCode( ASinExpression e , StateLanguage language ) {
		'''Math.asin( «e.arg.generateExpressionCode(language)» )'''
	}
	
	def dispatch CharSequence generateExpressionCode( ACosExpression e , StateLanguage language ) {
		'''Math.acos( «e.arg.generateExpressionCode(language)» )'''
	}
	
	def dispatch CharSequence generateExpressionCode( PopulationExpression e , StateLanguage language ) {
		if (language == StateLanguage::NONE) {
			'''occupancy[ «e.state.name.stateVariable» ]'''
		} else {
			'''state.getOccupancy( «e.state.name.stateVariable» )'''			
		}
	}
	
	def dispatch CharSequence generateExpressionCode( DecimalLiteral e , StateLanguage language ) {
		'''«e.integerPart.intPart»«e.decimalPart»'''
	}

	def dispatch CharSequence generateExpressionCode( NumberLiteral e , StateLanguage language ) {
		'''«e.intPart»'''
	}

	def dispatch CharSequence generateExpressionCode( ReferenceableName e , StateLanguage language ) {
		switch e {
			StateConstant: e.name.stateVariable
			Constant: e.name.constantVariable			
			Formula: e.name.getStateFormulaVariable(language)
			PathFormula: e.name.getPathFormulaVariable(language)
			Label: e.name.getLabelVariable(language)
		}
	}
	
	def dispatch CharSequence generateExpressionCode( OrPctlFormula e , StateLanguage language ) {
		'''new Or<«language.codeToType»>( «e.left.generateExpressionCode(language)» , «e.right.generateExpressionCode(language)» )'''
	}
	
	def dispatch CharSequence generateExpressionCode( AndPctlFormula e , StateLanguage language ) {
		'''new And<«language.codeToType»>( «e.left.generateExpressionCode(language)» , «e.right.generateExpressionCode(language)» )'''
	}
	
	def dispatch CharSequence generateExpressionCode( ProbabilityFormula e , StateLanguage language ) {
		'''new PCheck<«language.codeToType»>( «e.rel.relationCode» , «e.PBound.generateExpressionCode(language)» , «e.path.generateExpressionCode(language)» )'''
	}
	
	def getRelationCode( RelationSymbol s ) {
		switch s {
			case RelationSymbol::LES: '''Relation.LESS''' 
			case RelationSymbol::LEQ: '''Relation.LEQ'''
			case RelationSymbol::GEQ: '''Relation.GEQ'''
			case RelationSymbol::GTR: '''Relation.GTR'''
		}
	}
	
	def dispatch CharSequence generateExpressionCode( NamedPctlPathFormula formula , StateLanguage language ) {
		'''«formula.name.name.getPathFormulaVariable(language)»'''
	}
	
	def dispatch CharSequence generateExpressionCode( NextFormula next , StateLanguage language ) {
		'''new Next<«language.codeToType»>( «next.arg.generateExpressionCode(language)» )'''
	}

	def dispatch CharSequence generateExpressionCode( UntilFormula until , StateLanguage language ) {
		'''new Until<«language.codeToType»>( «until.left.generateExpressionCode(language)» «IF until.isBound», «until.bound» «ENDIF», «until.right.generateExpressionCode(language)» )'''		
	}	

	def codeToType( StateLanguage language ) {
		switch (language) {
			case StateLanguage::INDIVIDUALS :
				'''PopulationState'''
			case StateLanguage::FASTSIMULATION:
				'''FastSimulationState'''
			default:
				''''''
		}
	}
	
}