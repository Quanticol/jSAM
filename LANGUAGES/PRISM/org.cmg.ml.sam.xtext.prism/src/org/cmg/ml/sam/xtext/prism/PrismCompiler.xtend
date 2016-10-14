package org.cmg.ml.sam.xtext.prism

import org.cmg.ml.sam.util.OnTheFlyJavaCompiler
import org.cmg.ml.sam.xtext.prism.util.SymbolTableCollector
import com.google.inject.Inject
import org.cmg.ml.sam.xtext.prism.prism.Model
import org.cmg.ml.sam.xtext.prism.generator.ModuleStructureGenerator
import org.cmg.ml.sam.xtext.prism.generator.ClassGenerator
import org.cmg.ml.sam.xtext.prism.prism.Constant
import org.cmg.ml.sam.xtext.prism.prism.Formula
import org.cmg.ml.sam.xtext.prism.prism.Variable
import org.cmg.ml.sam.prism.PrismModel
import org.cmg.ml.sam.core.Filter
import org.cmg.ml.sam.xtext.prism.prism.Module
import org.cmg.ml.sam.xtext.prism.prism.PrismSystem
import org.cmg.ml.sam.xtext.prism.prism.PathFormulaDeclaration
import org.cmg.ml.sam.xtext.prism.prism.StateFormulaDeclaration

class PrismCompiler {
	
	OnTheFlyJavaCompiler compiler;
	
	SymbolTableCollector stc = new SymbolTableCollector()

	ModuleStructureGenerator generator = new ModuleStructureGenerator()
	
	new( OnTheFlyJavaCompiler compiler ) {
		this.compiler = compiler
	}
	
	def compile( Model m ) {
		var st = stc.collecSymbols(m)
//		var structure = generator.generateStructure(m)
		var structures = m.elements.map[ e |
			switch e {
				Module: generator.generateStructure(e)
				default: null
			}
		].filterNull
//		structure.generateIndexes
		var classGenerator = new ClassGenerator()
		classGenerator.setSymbolTable(st)
		var code = classGenerator.generateClass("test.pkg","test",
			m.elements.filter[ e | e instanceof Constant ] ,
			m.elements.filter[ e | e instanceof Formula ] ,
			m.elements.filter[ e | e instanceof Variable ] ,
			m.elements.filter[ e | e instanceof PathFormulaDeclaration] ,
			m.elements.filter[ e | e instanceof StateFormulaDeclaration] ,
			m.elements.findFirst[ e | e instanceof PrismSystem ] , 
			structures
		)
		println(code)
		compiler.setParentClassLoader(ClassLoader::systemClassLoader)
		compiler.addClassPathOfClass(typeof(PrismModel))
		compiler.addClassPathOfClass(typeof(Filter))
		var c = compiler.compileToClass("test.pkg.test",code.toString) 
		c.newInstance as PrismModel
	}
	
}