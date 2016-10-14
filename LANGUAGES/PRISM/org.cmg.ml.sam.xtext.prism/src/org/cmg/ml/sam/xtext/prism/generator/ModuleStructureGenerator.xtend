package org.cmg.ml.sam.xtext.prism.generator

import java.util.HashMap
import org.cmg.ml.sam.xtext.prism.prism.ActionRenaming
import org.cmg.ml.sam.xtext.prism.prism.AlphabetisedParallelComposition
import org.cmg.ml.sam.xtext.prism.prism.AsynchronousParallelComposition
import org.cmg.ml.sam.xtext.prism.prism.Command
import org.cmg.ml.sam.xtext.prism.prism.Element
import org.cmg.ml.sam.xtext.prism.prism.Hiding
import org.cmg.ml.sam.xtext.prism.prism.Model
import org.cmg.ml.sam.xtext.prism.prism.Module
import org.cmg.ml.sam.xtext.prism.prism.ModuleBodyDeclaration
import org.cmg.ml.sam.xtext.prism.prism.PrismSystem
import org.cmg.ml.sam.xtext.prism.prism.Renaming
import org.cmg.ml.sam.xtext.prism.prism.RestrictedParallelComposition
import org.cmg.ml.sam.xtext.prism.prism.SymbolRenaming
import org.cmg.ml.sam.xtext.prism.prism.Update
import org.cmg.ml.sam.xtext.prism.prism.VariableRenaming
import org.cmg.ml.sam.xtext.prism.util.ModuleStructure
import org.cmg.ml.sam.xtext.prism.util.RenamedElement
import org.cmg.ml.sam.xtext.prism.util.RuleStructure
import org.cmg.ml.sam.xtext.prism.util.UpdateStructure
import org.eclipse.emf.common.util.EList
import java.util.Map

class ModuleStructureGenerator {
	
	Map<String,ModuleStructure> moduleCache = new HashMap<String,ModuleStructure>()
	
	def dispatch ModuleStructure generateStructure( Module m ) {
		var structure = moduleCache.get(m.name)
		if (structure == null) {
			structure = m.body.generateModuleStructure(m.name)			
			moduleCache.put(m.name,structure)
		}
		structure
	}
	
	def dispatch ModuleStructure generateModuleStructure( ModuleBodyDeclaration b , String name ) {
		new ModuleStructure( 
			name , 
			b.variables.map([ v | v.name ]) ,
			b.commands.map( 
				[ Command c |
					new RuleStructure( 
						c.act , 
						newArrayList(new RenamedElement(c.guard)) , 
						c.updates.map([Update u | new UpdateStructure(u.weight , u.elements ) ])
					)
				]
			) 
		)		
	}
	
	def dispatch ModuleStructure generateModuleStructure( VariableRenaming b , String name ) {
		val map = new HashMap<String,String>()
		b.renaming.forEach([SymbolRenaming s | map.put(s.source , s.target )])
		b.module.generateStructure.rename( name , map )
	}
	
	/*

	def dispatch ModuleStructure generateStructure( Model m ) {
		val system = m.elements.findFirst( 
			[ Element e | 
				switch e {
					PrismSystem: true
					default: false	
				}				
			]
		)
		if (system != null) {
			system.generateStructure			
		} else {
			m.elements.generateStructure
		}
	}

	def dispatch ModuleStructure generateStructure( EList<Element> elist ) {
		elist.fold( null , 
			[ ModuleStructure r , Element e | 
				switch e {
					Module: if (r != null) {
						r.alphabetisedParallel( e.generateStructure )
					} else {
						e.generateStructure
					}
					default: r
				}
			]
		)
	}

	def dispatch ModuleStructure generateStructure( AlphabetisedParallelComposition p ) {
		p.left.generateStructure.alphabetisedParallel(p.right.generateStructure)
	}

	def dispatch ModuleStructure generateStructure( AsynchronousParallelComposition p ) {
		p.left.generateStructure.asynchronousParallel(p.right.generateStructure)
	}

	def dispatch ModuleStructure generateStructure( RestrictedParallelComposition p ) {
		p.left.generateStructure.restrictedParallel(p.right.generateStructure , p.actions )
	}
	
	def dispatch ModuleStructure generateStructure( Hiding p ) {
		p.argument.generateStructure.hide(p.actions)
	}
	
	def dispatch ModuleStructure generateStructure( Renaming p ) {
		val map = new HashMap<String,String>()
		p.renaming.forEach([ActionRenaming s | map.put(s.source , s.target )])
		p.argument.generateStructure.rename( "_UNNAMED_" , map)
	}

*/

}