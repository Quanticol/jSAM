package org.cmg.ml.sam.xtext.lprm

import org.cmg.ml.sam.xtext.lprm.lprSpecification.Element
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Model
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Constant
import static extension org.eclipse.xtext.EcoreUtil2.*
import org.cmg.ml.sam.xtext.lprm.lprSpecification.MacroFunction
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Variable
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Module
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Activity
import java.util.LinkedList
import org.cmg.ml.sam.xtext.lprm.lprSpecification.NameableElement

class Util {

	def static getConstants( Element element ) {
		var model = element.getContainerOfType(Model)
		model.elements.subList( 0 , model.elements.indexOf(element) ).filter(Constant)		
	}
	
	def static getMacroFunctions( Element element ) {
		var model = element.getContainerOfType(Model)
		model.elements.subList( 0 , model.elements.indexOf(element) ).filter(MacroFunction)		
	}	
	
	def static getVariables( Element element ) {
		element.getContainerOfType(Model).variables
	}

	def static getGlobalVariables( Element element ) {
		element.getContainerOfType(Model).elements.filter(Variable)
	}
	
	def static getVariables( Model model ) {
		model.elements.filter(Variable)+model.elements.filter(Module).map[ it.variables ].flatten		
	}
	
	def static getModules( Element element ) {
		var model = element.getContainerOfType(Model)
		model.elements.subList( 0 , model.elements.indexOf(element) ).filter(Module)		
	}
	
	def static getActivities( Model model ) {
		model.elements.filter(Activity)
	}

	def static getActivities( Element element ) {
		element.getContainerOfType(Model).activities
	}
	
	
	def static dispatch addNambeableElements( Module module , LinkedList<NameableElement> elements ) {
		elements.addAll( module.variables )
	}
	
	def static dispatch addNambeableElements( Activity a , LinkedList<NameableElement> elements ) {
		elements.add( a )
	}

	def static dispatch addNambeableElements( Variable v , LinkedList<NameableElement> elements ) {
		elements.add( v )
	}

	def static dispatch addNambeableElements( Constant c , LinkedList<NameableElement> elements ) {
		elements.add( c )
	}

	def static dispatch addNambeableElements( MacroFunction f , LinkedList<NameableElement> elements ) {
		elements.add( f )
	}
	
	def static dispatch addNambeableElements( Element e , LinkedList<NameableElement> elements ) {

	}	
	
	def static getNameableElements( Model model ) {
		val list = newLinkedList()
		model.elements.forEach[ e | e.addNambeableElements( list ) ]
		list		
	}	
	
	def static getNambeableElements( Module module ) {
		module.globalVariables + module.constants + module.macroFunctions + module.activities
	}
	
	def static isLocal( Variable v ) {
		v.getContainerOfType(Module) != null
	}
	
	def static isGlobal( Variable v ) {
		!v.isLocal
	}	
	
}