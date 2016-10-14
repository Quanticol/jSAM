package org.cmg.ml.sam.xtext.prism.util

import java.util.Map
import java.util.LinkedList
import org.eclipse.xtext.util.Wrapper

class ModuleStructure {
	
	String name
	Iterable<String> variables
	Iterable<RuleStructure> rules
	
	new( String name , Iterable<String> variables , Iterable<RuleStructure> rules ) {
		this.name = name
		this.rules = rules
		this.variables = variables
	}
	
	new( Iterable<String> variables , Iterable<RuleStructure> rules ) {
		this.name = "_UNNAMED_"
		this.rules = rules
		this.variables = variables
	}
	

 	
	def rename( String name , Map<String,String> map ) {
		new ModuleStructure( 
			name,
			variables.map( [ String s | if (map.get(s)!=null) {map.get(s)} else { s } ] ),
			rules.map( [RuleStructure r | r.rename(map)] )
		)
	}
	
	def alphabetisedParallel( ModuleStructure m ) {
		val list = new LinkedList<RuleStructure>()
		rules.forEach( 
			[ RuleStructure r1 |
				if (r1.action != null) {
					m.rules.forEach(
						[ RuleStructure r2 |
							var r = r1.combine(r2)
							if (r != null) {
								list.add(r)
							}
						]
					)
				} else {
					list.add(r1)
				}
			]
		)
		m.rules.forEach( [RuleStructure r | if (r.action == null) { list.add(r) }])
		new ModuleStructure( variables+m.variables , list )
	}
	
	def asynchronousParallel( ModuleStructure m ) {
		new ModuleStructure( variables+m.variables , rules + m.rules )
	}
	
	def restrictedParallel( ModuleStructure m , Iterable<String> actions ) {
		val list = new LinkedList<RuleStructure>()
		rules.forEach( 
			[ RuleStructure r1 |
				if ((r1.action != null)&&(actions.exists([String x | r1.action.equals(x)]) )) {
					m.rules.forEach(
						[ RuleStructure r2 |
							var r = r1.combine(r2)
							if (r != null) {
								list.add(r)
							}
						]
					)
				} else {
					list.add(r1)
				}
			]
		)
		m.rules.forEach( [RuleStructure r | if ((r.action != null)&&(actions.exists([String x | r.action.equals(x)]) )) { list.add(r) }])
		new ModuleStructure( variables+m.variables , list )
	}	 			
	
	def hide( Iterable<String> actions ) {
		new ModuleStructure( variables , rules.map( [ RuleStructure r | r.hide(actions) ] ) )
	}
	
	def getRules() {
		rules
	}
	
	def generateIndexes() {
		rules.forEach( [ RuleStructure r , int i | 
			r.setIndex(i)
			r.generateIndexes
		] );
	}
	
	override String toString() {
		rules.map[ r | r.toString ].reduce[ x , y | x+"\n"+y]
	}
	
	def getLocalVariables() {
		variables
	}
	
	def getIndexedRules() {
		val i = Wrapper::wrap(0)
		rules.map[ r | 
			var c = i.get
			i.set(c+1)
			c -> r
		]
	}
	
	def getName() {
		name
	}
}