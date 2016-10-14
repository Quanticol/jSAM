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

import org.cmg.ml.sam.xtext.prism.prism.Model
import org.cmg.ml.sam.xtext.prism.prism.Module
import org.cmg.ml.sam.xtext.prism.prism.ModuleBodyDeclaration
import org.cmg.ml.sam.xtext.prism.prism.VariableRenaming
import org.cmg.ml.sam.xtext.prism.prism.Element
import org.cmg.ml.sam.xtext.prism.prism.Command
import java.util.HashMap
import org.cmg.ml.sam.xtext.prism.prism.SymbolRenaming
import org.cmg.ml.sam.xtext.prism.prism.Constant
import org.cmg.ml.sam.xtext.prism.prism.Formula
import org.cmg.ml.sam.xtext.prism.prism.Variable

class SymbolTableCollector {

	var moduleGenerationTable = new HashMap<String,Boolean>();

	def collecSymbols( Model model ) {
		var st = new SymbolTable();
		for( Element e: model.elements ) {
			e.populateSymbolTable(st)
		}
		st
	} 
	
	def dispatch populateSymbolTable( Element e , SymbolTable st ) {
		st
	}

	def dispatch populateSymbolTable( Variable v , SymbolTable st ) {
		st.registerGlobalVariable(v)
		st
	}


	def dispatch populateSymbolTable( Constant c , SymbolTable st ) {
		st.registerConstant(c)
		st
	}

	def dispatch populateSymbolTable( Formula f , SymbolTable st ) {
		st.registerFormula(f)
		st
	}	
	
	def dispatch populateSymbolTable( Module m , SymbolTable st ) {
		m.body.populateSymbolTable(m.name , st)
	}

	def dispatch populateSymbolTable( ModuleBodyDeclaration m , String name , SymbolTable st ) {
		st.registerModule(name, 
			m.variables , 
			m.commands.map([Command c | c.act ]).filterNull
		)
		moduleGenerationTable.put(name , true )
		st
	}

	def dispatch populateSymbolTable( VariableRenaming m , String name , SymbolTable st ) {
		var renamed = m.module
		if (moduleGenerationTable.get(renamed.name)==null) {
			moduleGenerationTable.put(name,false);
			renamed.populateSymbolTable(st)
		}
		st.registerModule( name , renamed.name , m.renaming )
		st
	}
	
	def getRenamingFunction( Iterable<SymbolRenaming> renaming ) {
		var map = new HashMap<String,String>()
		for( r: renaming ) {
			map.put(r.source,r.target)
		}
		map
	}
	
}