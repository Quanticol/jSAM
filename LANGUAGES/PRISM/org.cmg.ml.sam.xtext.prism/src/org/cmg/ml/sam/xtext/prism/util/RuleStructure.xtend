package org.cmg.ml.sam.xtext.prism.util

import org.cmg.ml.sam.xtext.prism.prism.Expression
import java.util.Map
import org.eclipse.xtext.util.Wrapper

class RuleStructure {
	
	String action
	
	int index
	
	Iterable<RenamedElement<Expression>> guard
	
	Iterable<UpdateStructure> commands
	
	new( Iterable<RenamedElement<Expression>> guard , Iterable<UpdateStructure> commands) {
		this(null,guard,commands)	
	}
	
	new( String action , Iterable<RenamedElement<Expression>> guard , Iterable<UpdateStructure> commands) {
		this.action = action
		this.guard = guard
		this.commands = commands
	}
	
	def getAction() {
		action
	}
	
	def getGuard() {
		guard
	}
	
	def getCommands() {
		commands
	}
	
	def getIndex() {
		index
	}
	
	def setIndex( int i ) {
		index = i
	}
	
	def rename( Map<String,String> map ) {
		var newAct = action
		if (action != null) {
			newAct = map.get( action )
			if (newAct == null) {
				newAct = action
			}			
		}
		new RuleStructure( action , guard.map( [RenamedElement<Expression> e | e.apply(map) ]  ) , commands.map( [ UpdateStructure u | u.rename(map) ] ))
	}
	
	def combine( RuleStructure r ) {
		if ((action != r.action)||( !action.equals(r.action))) {
			null
		} else {
			new RuleStructure( action , guard+r.guard , commands+r.commands )
		}
	}
	
	def hide( Iterable<String> actions ) {
		if ((action != null)&&(actions.exists([ String x | action.equals(x) ]))) {
			new RuleStructure( guard , commands )
		} else {
			this
		}
	} 
	
	def generateIndexes() {
		commands.forEach( [UpdateStructure us, int i | us.setIndex(i) ] )
	}
	
	override String toString() {
		"["+action+"]"+(guard.map[ g | g.toString ].reduce[ x , y | x+" , "+y ])+" -> "+
		commands.map[ c | c.toString ].reduce[ x , y | x+" , "+y] 
	}
	
	def getIndexedCommands() {
		val i = Wrapper::wrap(0)
		commands.map[ r | 
			var c = i.get
			i.set(c+1)
			c -> r
		]
	}
}