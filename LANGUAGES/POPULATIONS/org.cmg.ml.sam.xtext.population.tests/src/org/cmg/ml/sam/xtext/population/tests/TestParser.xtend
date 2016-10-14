package org.cmg.ml.sam.xtext.population.tests

import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import org.cmg.ml.sam.xtext.population.PopulationInjectorProvider
import com.google.inject.Inject
import org.cmg.ml.sam.xtext.population.population.Model
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.cmg.ml.sam.util.OnTheFlyJavaCompiler
import org.cmg.ml.sam.population.PopulationModule
import org.cmg.ml.sam.core.Filter
import org.cmg.ml.sam.core.logic.StateFormula
import org.cmg.ml.sam.population.PopulationSpecification
import org.cmg.ml.sam.xtext.population.generator.PopulationToJavaCompiler

@InjectWith(typeof(PopulationInjectorProvider))
@RunWith(typeof(XtextRunner))
class TestParser {
	
	@Inject
	ParseHelper<Model> parser;
	
		
	@Inject extension ValidationTestHelper
	
	@Inject
	OnTheFlyJavaCompiler compiler;
	
	@Inject
	PopulationToJavaCompiler populationToJavaCompiler
	
	
	@Test
	def testParserEpidemic() {
		var m = parser.parse(
			'''
			constant N = 100;
			
			constant alpha_e = 0.1;
			constant alpha_i = 0.2;
			constant alpha_r = 0.2;
			constant alpha_a = 1-alpha_r*alpha_i;
			constant alpha_s = 1-alpha_a;
			
			action inf_ext: alpha_e;
			action inf_sus: 1/alpha_i;
			action activate: alpha_a;
			action patch: alpha_r;
			action loss: alpha_s;
			
			state S {
				inf_ext.E
				+ inf_sus.E
			}
			
			state E {
				activate.I
			}
			
			state I {
				patch.R
			}
			
			state R {
				loss.S
			}
			
			system mySystem = < S[100] >;
			
			formula test1: P{ <= 0.2 }[ true U<=100 I];
			
			//This is a comment!
			formula test2: P{ <= 0.2 }[ frc(I)<0.25 U<=100 E];

			//This is a comment!
			formula test3: P{ <= 0.2 }[ test1 U<=100 test2 ];
			'''						
		)	
		m.assertNoErrors
		var o = m.doCompile

		print(o)
		print("\n\nState formulae: ")
		o.stateFormulae.forEach( [ x | print(x+" ") ] );
		print("\n")
		print("Path formulae: ")
		o.pathFormulae.forEach( [ x | print(x+" ") ] );
		print("\n")
		print("Configurations: ")
		o.configurationNames.forEach( [ x | print(x+" ") ] );
		print("\n")
		print("******** END *********\n\n")
		return 
	}
	
	def doCompile( Model m ) {
		var code = populationToJavaCompiler.compile("testpackage","TestClass",m)				
		println(code)
		compiler.setParentClassLoader(ClassLoader::systemClassLoader)
		compiler.addClassPathOfClass( typeof(PopulationModule) )
		compiler.addClassPathOfClass( typeof(Filter) )
		compiler.addClassPathOfClass( typeof(StateFormula) )
		var c = compiler.compileToClass("testpackage.TestClass",code.toString) 
		c.newInstance as PopulationSpecification
	}
	
}