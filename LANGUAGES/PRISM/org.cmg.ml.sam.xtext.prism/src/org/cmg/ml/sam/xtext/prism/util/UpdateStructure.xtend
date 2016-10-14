package org.cmg.ml.sam.xtext.prism.util

import org.cmg.ml.sam.xtext.prism.prism.Expression
import org.cmg.ml.sam.xtext.prism.prism.UpdateElement
import java.util.Map

class UpdateStructure {
	
	Iterable<RenamedElement<Expression>> weight
	Iterable<RenamedElement<UpdateElement>> updates
	int index
	
	new( Iterable<RenamedElement<Expression>> weight , Iterable<RenamedElement<UpdateElement>> updates ) {
		this.weight = weight
		this.updates = updates
	}
	
	new( Expression weight , Iterable<UpdateElement> updates ) {
		this( newArrayList(new RenamedElement(weight)) , 
			  updates.map([ UpdateElement u | new RenamedElement(u) ]) ) 
	}
	
	def getWeight() {
		weight
	}
	
	def getUpdates() {
		updates
	}
	
	def getIndex() {
		index
	}
	
	def setIndex( int i ) {
		index = i
	}
	
	def combine( UpdateStructure str ) {
		new UpdateStructure( weight+str.weight , updates+str.updates )
	}
	
	def rename( Map<String,String> map ) {
		new UpdateStructure( 
			weight.map([ RenamedElement<Expression> e | e.apply( map )]) , 
			updates.map([ RenamedElement<UpdateElement> u | u.apply( map )])
		)
	}
	
}