package org.cmg.ml.sam.xtext.prism.tests

import com.google.inject.Inject
import org.cmg.ml.sam.core.sim.DefaultRandomGenerator
import org.cmg.ml.sam.util.OnTheFlyJavaCompiler
import org.cmg.ml.sam.xtext.prism.PrismCompiler
import org.cmg.ml.sam.xtext.prism.PrismInjectorProvider
import org.cmg.ml.sam.xtext.prism.prism.Model
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.cmg.ml.sam.core.logic.Until
import org.cmg.ml.sam.core.mc.pomc.OnTheFlyProbabilisticModelChecker
import org.cmg.ml.sam.prism.PrismState

@InjectWith(typeof(PrismInjectorProvider))
@RunWith(typeof(XtextRunner))
class TestExampleOne {
	
	@Inject
	ParseHelper<Model> parser
	
	@Inject extension ValidationTestHelper
	
	OnTheFlyJavaCompiler compiler = new OnTheFlyJavaCompiler();

	
	@Test
	def void testMyExample() {
		var m = parser.parse(
		'''
			dtmc
	
			module Pippo 
				x: [0..3];
			
				[] (x<3) -> (x'=x+1);
				[] (x=3) -> (x'=0);
			endmodule
			
			module Pluto = Pippo[x=y] endmodule
			
			pathformula nextTest = \X { x = 3 };
			
			stateformula success = { x = 3 };
			
			stateformula tFormula = { true };
			
			
		'''
		)
		m.assertNoErrors
		var prismCompiler = new PrismCompiler(compiler)
		var model = prismCompiler.compile( m )
		var state = model.startState
		var left = model.getStateFormula("tFormula");
		var right = model.getStateFormula("success");
		var target = new Until( left , right );
		var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
		print("Probability: "+opmc.getProbability(state,target));
	}
	
}