package org.cmg.ml.sam.xtext.lprm.tests

import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.util.ParseHelper
import org.cmg.ml.sam.xtext.lprm.LprSpecificationInjectorProvider
import com.google.inject.Inject
import org.cmg.ml.sam.xtext.lprm.lprSpecification.Model
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.cmg.ml.sam.xtext.lprm.lprSpecification.LprSpecificationPackage
import org.cmg.ml.sam.xtext.lprm.validation.LprSpecificationValidator
import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper

@InjectWith(LprSpecificationInjectorProvider)
@RunWith(XtextRunner)
class TestCompiler {

	@Inject extension CompilationTestHelper	
	
	@Test
	def testCompilationSimpleModule( ) {
		'''
		specification SimpleModule; 

		label success = (s==4);
		
		path formula eventually_success = { true } \U success;

		module Simple:
		variables
			s: [0 .. 4];
		rules		
			[] (s==0) -> 0.5:{s <- 1} + 0.5:{ s <- 2};
			[] (s==1) -> 0.5:{s <- 0} + 0.5:{ s <- 3};
			[] (s==3) -> 1:{s <- 3};
			[] (s==2) -> 0.5:{ s <- 0 } + 0.5:{ s <- 4};
			[] (s==4) -> 0.5:{ s <- 2 } + 0.5:{ s <- 4};		
		endmodule
		'''.compile[compiledClass]
	}	
	
	
}