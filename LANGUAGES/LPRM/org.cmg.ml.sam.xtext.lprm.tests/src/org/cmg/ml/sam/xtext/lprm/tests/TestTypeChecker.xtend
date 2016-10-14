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

@InjectWith(LprSpecificationInjectorProvider)
@RunWith(XtextRunner)
class TestTypeChecker {

	@Inject extension ParseHelper<Model>
	
	@Inject extension ValidationTestHelper
	
	
	@Test
	def void checkNotTypeError() {
		'''
		specification Test;
		
		constant int c = not 2;
		'''.parse => [
			assertError( 
				LprSpecificationPackage::eINSTANCE.not,
				LprSpecificationValidator::WRONG_TYPE,
				"Type error: expected BOOLEAN_TYPE is INT_TYPE"
			)
		]
	}
	
	@Test
	def void checkAndLeftTypeError() {
		'''
		specification Test;
		
		constant int c2 = 2 and true;
		'''.parse => [
			assertError( 
				LprSpecificationPackage::eINSTANCE.and,
				LprSpecificationValidator::WRONG_TYPE,
				"Type error: expected BOOLEAN_TYPE is INT_TYPE"
			)
		]
	}

	@Test
	def void checkAndRightTypeError() {
		'''
		specification Test;
		
		constant int c2 = true and 2;

		'''.parse => [
			assertError( 
				LprSpecificationPackage::eINSTANCE.and,
				LprSpecificationValidator::WRONG_TYPE,
				"Type error: expected BOOLEAN_TYPE is INT_TYPE"
			)
		]
	}
	
	@Test
	def void checkOrLeftTypeError() {
		'''
		specification Test;
		
		constant int c2 = 2 or true;
		'''.parse => [
			assertError( 
				LprSpecificationPackage::eINSTANCE.or,
				LprSpecificationValidator::WRONG_TYPE,
				"Type error: expected BOOLEAN_TYPE is INT_TYPE"
			)
		]
	}
	
	@Test
	def void checkOrRightTypeError() {
		'''
		specification Test;
		
		constant int c2 = true or 2;
		
		'''.parse => [
			assertError( 
				LprSpecificationPackage::eINSTANCE.or,
				LprSpecificationValidator::WRONG_TYPE,
				"Type error: expected BOOLEAN_TYPE is INT_TYPE"
			)
		]
	}

	@Test
	def void checkSumLeftTypeError() {
		'''
		specification Test;
		
		constant int c2 = true + 2;
		
		'''.parse => [
			assertError( 
				LprSpecificationPackage::eINSTANCE.plus,
				LprSpecificationValidator::WRONG_TYPE,
				"Type error: BOOLEAN_TYPE is not a valid type for arithmetic operations"
			)
		]
	}

	@Test
	def void checkSumRightTypeError() {
		'''
		specification Test;
		
		constant int c2 = 2 + true;
		
		'''.parse => [
			assertError( 
				LprSpecificationPackage::eINSTANCE.plus,
				LprSpecificationValidator::WRONG_TYPE,
				"Type error: BOOLEAN_TYPE is not a valid type for arithmetic operations"
			)
		]
	}

	@Test
	def void checkMinusLeftTypeError() {
		'''
		specification Test;
		
		constant int c2 = true - 2;
		
		'''.parse => [
			assertError( 
				LprSpecificationPackage::eINSTANCE.minus,
				LprSpecificationValidator::WRONG_TYPE,
				"Type error: BOOLEAN_TYPE is not a valid type for arithmetic operations"
			)
		]
	}

	@Test
	def void checkMinusRightTypeError() {
		'''
		specification Test;
		
		constant int c2 = 2 - true;
		
		'''.parse => [
			assertError( 
				LprSpecificationPackage::eINSTANCE.minus,
				LprSpecificationValidator::WRONG_TYPE,
				"Type error: BOOLEAN_TYPE is not a valid type for arithmetic operations"
			)
		]
	}

	@Test
	def void checkMulLeftTypeError() {
		'''
		specification Test;
		
		constant int c2 = true * 2;
		
		'''.parse => [
			assertError( 
				LprSpecificationPackage::eINSTANCE.mul,
				LprSpecificationValidator::WRONG_TYPE,
				"Type error: BOOLEAN_TYPE is not a valid type for arithmetic operations"
			)
		]
	}

	@Test
	def void checkMulRightTypeError() {
		'''
		specification Test;
		
		constant int c2 = 2 * true;
		
		'''.parse => [
			assertError( 
				LprSpecificationPackage::eINSTANCE.mul,
				LprSpecificationValidator::WRONG_TYPE,
				"Type error: BOOLEAN_TYPE is not a valid type for arithmetic operations"
			)
		]
	}

	@Test
	def void checkDivLeftTypeError() {
		'''
		specification Test;
		
		constant int c2 = true / 2;
		
		'''.parse => [
			assertError( 
				LprSpecificationPackage::eINSTANCE.div,
				LprSpecificationValidator::WRONG_TYPE,
				"Type error: BOOLEAN_TYPE is not a valid type for arithmetic operations"
			)
		]
	}

	@Test
	def void checkDivRightTypeError() {
		'''
		specification Test;
		
		constant int c2 = 2 / true;
		
		'''.parse => [
			assertError( 
				LprSpecificationPackage::eINSTANCE.div,
				LprSpecificationValidator::WRONG_TYPE,
				"Type error: BOOLEAN_TYPE is not a valid type for arithmetic operations"
			)
		]
	}

	
}