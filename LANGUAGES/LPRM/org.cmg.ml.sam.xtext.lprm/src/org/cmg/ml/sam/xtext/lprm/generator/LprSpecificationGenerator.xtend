/*
 * generated by Xtext
 */
package org.cmg.ml.sam.xtext.lprm.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Model
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Variable
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Module
import org.eclipse.xtext.util.Wrapper

/**
 * Generates code from your model files on save.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#TutorialCodeGeneration
 */
class LprSpecificationGenerator implements IGenerator {
	
	public final static String VAR_INDEX_PREFIX = "_VAR_"
	
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
//		fsa.generateFile('greetings.txt', 'People to greet: ' + 
//			resource.allContents
//				.filter(typeof(Greeting))
//				.map[name]
//				.join(', '))
		resource.allContents.filter(typeof(Model)).forEach[
			generateClass			
		]
	}
	
	def generateClass( Model model ) {
		'''
		import java.math.BigInteger;

		import org.cmg.ml.sam.core.*;
		import org.cmg.ml.sam.core.logic.*;
		import org.cmg.ml.sam.lprm.LprmModule;
		import org.cmg.ml.sam.lprm.LprmState;
		
		public class «model.name» extends LprmModule {
		
			«model.generateVariablesIndexes»
		
			«FOR e:model.elements»
			«e.generateElementCode»
			«ENDFOR»
		}
		'''
		
		
	}
	
	def getStateVariables( Model model ) {
		model.elements.filter(typeof(Variable))+
			model.elements.filter(typeof(Module)).map[it.variables].flatten
	}
	
	def generateVariablesIndexes( Model model ) {
		'''
		«FOR v: model.stateVariables.generateIndexes(0)» 
		public static final int «VAR_INDEX_PREFIX»«v.value» = «v.key»;
		«ENDFOR»
		'''		
	}


	def <T> generateIndexes( Iterable<T> list , int start ) {
		val i = Wrapper::wrap(start)
		list.map[ r | 
			var c = i.get
			i.set(c+1)
			c -> r
		]
	}
	
	def dispatch generateElementCode( Module m ) {
		
	}

	def dispatch generateElementCode( System m ) {
		
	}
	
	
	
	/*
	Module
	| NameableElement
	| System
	| Label
	| StateFormulaDeclaration
	| PathFormulaDeclaration
	 */
	
}
