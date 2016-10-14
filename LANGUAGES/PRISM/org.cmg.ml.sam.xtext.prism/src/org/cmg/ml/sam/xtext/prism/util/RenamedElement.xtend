/*
 * Michele Loreti, Concurrency and Mobility Group
 * Universitˆ di Firenze, Italy
 * (C) Copyright 2013.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Michele Loreti
 */
package org.cmg.ml.sam.xtext.prism.util

import java.util.Map
import java.util.HashMap

class RenamedElement<T> {

	private T element;
	
	private Map<String,String> renaming;
	
	
	new( T element ) {
		this( element , null )
	}
	
	new( T element , Map<String,String> renaming ) {
		this.element = element;
		this.renaming = renaming;
	}
	
	def getElement( ) {
		element
	}
	
	def getRenaming() {
		renaming
	}
	
	def apply( Map<String,String> f ) {
		if (renaming != null) {
			val newF = new HashMap<String,String>()
			renaming.forEach([ String src , String trg | 
				var foo = f.get(trg)
				if (foo != null) {
					newF.put(src,foo)
				}
			])
			f.forEach([ String src , String trg | 
				var foo = renaming.get(src)
				if (foo == null) {
					newF.put(src,trg)
				}
			])
			new RenamedElement( element , newF )
		} else {
			new RenamedElement( element , f )	
		}
	}
 	
 	override String toString() {
 		var mapping = ""
 		if (renaming != null) {
 			mapping = "{"
	 		for (k:renaming.keySet) {
	 			mapping = mapping+(k+"->"+renaming.get(k))
	 		}
	 		mapping = mapping + "}"
 		}
 		element.toString+"{"+(mapping)+"}"
 	}
 	
}