package org.cmg.ml.sam.xtext.prism.tests

import org.cmg.ml.sam.core.logic.StateFormula
import org.cmg.ml.sam.core.logic.Until
import org.cmg.ml.sam.core.mc.pomc.OnTheFlyProbabilisticModelChecker
import org.cmg.ml.sam.prism.PrismState
import org.cmg.ml.sam.xtext.prism.PrismInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Assert

@InjectWith(typeof(PrismInjectorProvider))
class PrismTestHelper {
	
	def  assertBoundUntilProbability( PrismState s , StateFormula<PrismState> left , int bound , StateFormula<PrismState> right , double expected , double delta ) {
		var u = new Until<PrismState>(left,bound,right);
		println("Checking "+s+" sat "+u)
		var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
		var ct = System::currentTimeMillis
		var res = opmc.getProbability(s,u);
		ct = System::currentTimeMillis - ct
		Assert::assertEquals( expected , res , delta );
		println("Time: "+ct)						
	}

	def  assertUntilProbability( PrismState s , StateFormula<PrismState> left , StateFormula<PrismState> right , double expected , double delta ) {
		var u = new Until<PrismState>(left,right);
		println("Checking "+s+" sat "+u)
		var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
		var ct = System::currentTimeMillis
		var res = opmc.getProbability(s,u);
		ct = System::currentTimeMillis - ct
		println("Time: "+ct)						
		Assert::assertEquals( expected , res , delta );
	}
	
}