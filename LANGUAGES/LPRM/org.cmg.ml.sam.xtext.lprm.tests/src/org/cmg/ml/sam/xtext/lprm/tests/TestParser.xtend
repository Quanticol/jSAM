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

@InjectWith(LprSpecificationInjectorProvider)
@RunWith(XtextRunner)
class TestParser {
	
	@Inject extension ParseHelper<Model>
	
	@Inject extension ValidationTestHelper
		
	@Test
	def emptyModel() {
		'''
		specification Test;
		'''.parse.assertNoErrors
	}
	
	@Test
	def void duplicateVariableDeclaration() {
		'''
		specification Test;
		
		variable x: boolean;
		variable x: boolean;
		
		'''.parse => [
			assertError(LprSpecificationPackage::eINSTANCE.variable,LprSpecificationValidator::DUPLICATED_NAME,"Duplicated definition for name 'x'")
        ]

	}
	
	@Test
	def void constantDeclaration() {
		'''
		specification Test;
		
		
		constant c2 = 2*c;

		constant c = 2;

		
		'''.parse => [
			assertError( LprSpecificationPackage::eINSTANCE.reference,Diagnostic::LINKING_DIAGNOSTIC,"Couldn't resolve reference to ReferenceableElement 'c'")
		]



	}
	
	@Test
	def void parametricTypeDeclaration() {
		'''
		specification Test;
		
		
		constant int c = 2;

		constant int c2 = 6;
		
		variable x: [ c .. c2 ];
		
		'''.parse.assertNoErrors

	}
	
	@Test
	def void macroFunctionDeclaration() {
		'''
		specification Test;
		
		
		constant int c = 2;

		
		constant int c2 = 6;
		
		function int test = c*x+c2;

		variable x: [ c .. c2 ];
		
		'''.parse.assertNoErrors
	}
	
	@Test
	def void checkTypeError() {
		'''
		specification Test;
		
		constant c = not 2;
		
		constant c2 = 2 and true;
		
		constant c3 = true or 3;

		constant c4 = true and 2;

		constant c5 = 2 or true;

		
		'''.parse => [
			assertError( 
				LprSpecificationPackage::eINSTANCE.not,
				LprSpecificationValidator::WRONG_TYPE,
				"Type error: expected BOOLEAN_TYPE is INT_TYPE"
			)
			assertError( 
				LprSpecificationPackage::eINSTANCE.and,
				LprSpecificationValidator::WRONG_TYPE,
				"Type error: expected BOOLEAN_TYPE is INT_TYPE"
			)
			assertError( 
				LprSpecificationPackage::eINSTANCE.or,
				LprSpecificationValidator::WRONG_TYPE,
				"Type error: expected BOOLEAN_TYPE is INT_TYPE"
			)
			assertError( 
				LprSpecificationPackage::eINSTANCE.and,
				LprSpecificationValidator::WRONG_TYPE,
				"Type error: expected BOOLEAN_TYPE is INT_TYPE"
			)
			assertError( 
				LprSpecificationPackage::eINSTANCE.or,
				LprSpecificationValidator::WRONG_TYPE,
				"Type error: expected BOOLEAN_TYPE is INT_TYPE"
			)
		]
	}
		
	@Test
	def void simpleModule() {
		'''
		specification Test;
		
		
		constant int c = 2;

		
		constant int c2 = 6;
		
		function int test = c*x+c2;

		variable x: [ c .. c2 ];
		
		module Test: 
		variables
			y: [0 .. 10];
		rules
			[] (y<10) -> 1:{ y <- y+1 };
			[] (y==10) -> 1:{ y <- 0 }; 		
		endmodule
		
		'''.parse.assertNoErrors
		
	}

	@Test
	def void twoModule() {
		'''
		specification Test;
		
		
		constant int c = 2;

		
		constant int c2 = 6;
		
		function int test = c*x+c2;

		variable x: [ c .. c2 ];
		
		module Test: 
		variables
			y: [0 .. 10];
		rules
			[] (z<10) -> 1:{ y <- z+1 };
			[] (z==10) -> 1:{ y <- 0 }; 		
		endmodule

		module Test2: 
		variables
			z: [0 .. 10];
		rules
			[] (y<10) -> 1:{ z <- y+1 };
			[] (y==10) -> 1:{ z <- 0 }; 		
		endmodule
		
		'''.parse.assertNoErrors
		
	}
	
	@Test
	def void twoRenamedModule() {
		'''
		specification Test;
		
		
		constant int c = 2;

		
		constant int c2 = 6;
		
		function int test = c*x+c2;

		variable x: [ c .. c2 ];
		
		module Test: 
		variables
			y: [0 .. 10];
		rules
			[] (z<10) -> 1:{ y <- z+1 };
			[] (z==10) -> 1:{ y <- 0 }; 		
		endmodule

		module Test2: 
		variables
			z: [0 .. 10];
		rules
			Test[ y -> z ]
		endmodule
		
		'''.parse.assertNoErrors
		
	}
	
	
	@Test
	def void missingRenamingOfVariable() {
		'''
		specification Test;
				
		module Test: 
		variables
			x: [0 .. 10];
			y: [0 .. 10];
		rules
			[] (z<10) -> 1:{ y <- z+1 };
			[] (z==10) -> 1:{ y <- 0 }; 		
		endmodule

		module Test2: 
		variables
			z: [0 .. 10];
		rules
			Test[ y -> z ]
		endmodule
		
		'''.parse => [
			assertError(LprSpecificationPackage::eINSTANCE.bodyRenaming,
				LprSpecificationValidator::MISSING_RENAMING_OF_LOCAL_VARIABLE,
				"Renaming of variable x is missing!"
			)
		]
		
	}


	@Test
	def void missingRenamingOfTargetVariable() {
		'''
		specification Test;
				
		module Test2: 
		variables
			z: [0 .. 10];
		rules
			[] true -> 1:{ z <- (x+1)%11 };
		endmodule
		
		module Test: 
		variables
			x: [0 .. 10];
			y: [0 .. 10];
		rules
			Test2[ z -> x ]
		endmodule
		
		
		'''.parse => [
			assertError(LprSpecificationPackage::eINSTANCE.bodyRenaming,
				LprSpecificationValidator::UNRENAMED_LOCAL_VARIABLE,
				"No variable is renamed in y!"
			)
		]
		
	}
	
		
	@Test
	def void twoWrongModuleRenaming() {
		'''
		specification Test;
		
		activity a;
		
		variable x: [ 0 .. 10 ];
		
		module Test: 
		variables
			y: [0 .. 10];
		rules
			[] (z<10) -> 1:{ y <- z+1 };
			[] (z==10) -> 1:{ y <- 0 }; 		
		endmodule

		module Test2: 
		variables
			z: [0 .. 10];
		rules
			Test[ y -> z , z -> y ]
		endmodule
		
		module Test3:
		variables
			w: [0 .. 10];
		rules
			Test2[ z -> x ]
		endmodule

		module Test3:
		variables
			q: [0 .. 10];
		rules
			Test2[ x -> z ]
		endmodule
		
		'''.parse => [
			assertError(LprSpecificationPackage::eINSTANCE.nameMapping,
				LprSpecificationValidator::ILLEGAL_LOCAL_VARIABLE_RENAMING,
				"Variable z has to be renamed in a local variable of module Test3!"
			)
			assertError(LprSpecificationPackage::eINSTANCE.nameMapping,
				LprSpecificationValidator::GLOBAL_LOCAL_RENAMING,
				"Global variable x cannot be renamed in local variable z!"
			)
		]
		
	}
	
	@Test
	def testParserSimpleModule( ) {
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
		'''.parse.assertNoErrors
	}
	
}