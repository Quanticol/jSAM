package org.cmg.ml.sam.xtext.prism.util

import org.cmg.ml.sam.xtext.prism.prism.Type
import java.util.HashMap
import java.util.LinkedList
import java.util.HashSet
import org.eclipse.xtext.xbase.lib.Pair
import org.cmg.ml.sam.xtext.prism.prism.Variable
import org.cmg.ml.sam.xtext.prism.prism.ConstantType
import org.cmg.ml.sam.xtext.prism.prism.Constant
import org.cmg.ml.sam.xtext.prism.prism.Formula
import java.util.Map
import org.cmg.ml.sam.xtext.prism.prism.SymbolRenaming
import org.cmg.ml.sam.xtext.prism.prism.BooleanType
import org.cmg.ml.sam.xtext.prism.prism.IntervalType
import org.cmg.ml.sam.xtext.prism.prism.Expression

class SymbolTable {
	
	var globalVariables = new HashMap<String,Type>()
	var localVariables = new HashMap<String,Type>()
	var constants = new HashMap<String,ConstantType>()
	var actions = new HashSet<String>()
	var functions = new HashSet<String>()
	var modules = new HashMap<String,Pair<HashMap<String,Type>,HashSet<String>>>()
	var duplicated = new HashSet<String>()
	var init = new HashMap<String,RenamedElement<Expression>>()

	def isAGlobalVariable( String id ) {
		(globalVariables.get(id) != null)
	}
	
	def isAnAction( String id ) {
		actions.contains(id)
	}
	
	def isAFunction( String id ) {
		functions.contains(id)
	}
	
	def isALocalVariable( String id ) {
		(localVariables.get(id)!=null)
	}
	
	def isConstant( String id ) {
		(constants.get(id) != null)
	}
	
	def isDefined( String id ) {
		(id.AFunction||id.AGlobalVariable||id.ALocalVariable||id.anAction||id.constant)
	}
	
	def registerGlobalVariable( Variable v ) {
		if (v.name.defined) {
			duplicated.add(v.name)
		}
		globalVariables.put(v.name,v.type)
		var foo = v.initExpression
		if (foo != null) {
			init.put(v.name,new RenamedElement(foo))
		}
		
	}

	def registerLocalVariable( Variable v ) {
		registerLocalVariable( v.name , v.type )
		var foo = v.initExpression
		if (foo != null) {
			init.put(v.name,new RenamedElement(foo))
		}
	}

	def registerLocalVariable( String name , Type type ) {
		if (name.defined) {
			duplicated.add(name)
		}
		localVariables.put(name,type)
	}
	
	
	def registerAction( String a ) {
		if (!actions.contains(a)) { 
			if (a.defined) {
				duplicated.add(a)
			}
			actions.add(a)
		}
	}
	
	def registerConstant( Constant c ) {
		if (c.name.defined) {
			duplicated.add(c.name)
		}
		constants.put(c.name,c.type)
	}
	
	def registerFormula( Formula f ) {
		if (f.name.defined) {
			duplicated.add(f.name)
		}
		functions.add(f.name)
	}
	
	def isModuleRegistered( String name ) {
		modules.containsKey(name)
	}
	
	def registerModule( String name , Iterable<Variable> variables , Iterable<String> actions ) {
//		println("REGISTERING MODULE: "+name)
		val data = new HashMap<String,Type>() -> new HashSet<String>()
		variables.forEach[ v |  
			v.registerLocalVariable
			data.key.put( v.name , v.type )
		]
		actions.forEach[ a |
			a.registerAction
			data.value.add(a)
		]
		modules.put(name,data)
	}
	
	def registerModule( String name , String src , Iterable<SymbolRenaming> renaming ) {
//		println("REGISTERING MODULE: "+name)
		val map = new HashMap<String,String>()
		renaming.forEach[ f | 
			map.put(f.source,f.target)
		]
		val data = modules.get(src)
		val newData = new HashMap<String,Type>() -> new HashSet<String>()
		if (data != null) {
			data.key.forEach[ v , t |
				var renamed = map.get(v)
				if (renamed == null) {
					renamed = v;
				}
				renamed.registerLocalVariable(t)
				var start = init.get(v)
				if (start != null) {
					init.put(renamed,start.apply(map))
				}
				newData.key.put(renamed,t)
			]
			data.value.forEach[ a | 
				var renamed = map.get(a)
				if (renamed == null) {
					renamed = a
				}
				if (!actions.contains(renamed)) {
					renamed.registerAction
				}
				newData.value.add(renamed)
			]
		}
	}
	
	def getExpressionCode( String id , boolean isBoolean ) {
		if (id.AGlobalVariable) {
			id.globalVariableCode.getVariableExpression( globalVariables.get(id) , isBoolean )
		} else if (id.ALocalVariable) {
			id.localVariableCode.getVariableExpression( localVariables.get(id) , isBoolean )
		} else if (id.constant) {
			id.constantCode
		} else if (id.AFunction) {
			'''«id.formulaCode»(currentState)'''
		} else {
			'''ERROR'''
		}
	}
	
	def getGlobalVariableCode( String id ) {
		'''_GLOBAL_«id»'''
	}

	def getLocalVariableCode( String id ) {
		'''_LOCAL_«id»'''
	}

	def getActionCode( String id ) {
		'''_ACTION_«id»'''
	}

	def getConstantCode( String id ) {
		'''_CONST_«id»'''
	}

	def getFormulaCode( String id ) {
		'''_FORMULA_«id»'''
	}
	
	def getVariableCode( String id ) {
		if (globalVariables.containsKey(id)) {
			id.getGlobalVariableCode
		} else {
			id.localVariableCode
		}
	}
	
	def getVariableExpression( CharSequence evaluatingCode , Type type , boolean isBoolean ) {
		switch type {
			BooleanType: '''(enumerator.get(currentState,«evaluatingCode»)«IF isBoolean»==1«ENDIF»)'''
			IntervalType: '''enumerator.get(currentState,«evaluatingCode»)'''
		}
	}
	
	def getActions(  ) {
		actions
	}
	
	def getInitExpression( Variable v ) {
		if (v.init != null) {
			v.init
		} else {
			var t = v.type
			switch (t) {
				IntervalType: t.min
				BooleanType: null
			}
		}
	}
	
	def getNumberOfVariables( ) {
		globalVariables.size+localVariables.size
	}
	
	def getGlobalVariables( ) {
		this.globalVariables.keySet
	}
	
	def getLocalVariables( ) {
		this.localVariables.keySet
	}
	
	def getInitExpression( String id ) {
		var v = init.get(id)		
		v
	}
	
	def getTypeOf( String id ) {
		var result = globalVariables.get(id)
		if (result != null) {
			result
		} else {
			localVariables.get(id)
		}
	}
}