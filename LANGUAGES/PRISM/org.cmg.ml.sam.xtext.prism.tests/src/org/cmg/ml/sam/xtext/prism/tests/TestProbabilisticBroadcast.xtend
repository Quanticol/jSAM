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
class TestProbabilisticBroadcast {
	
	@Inject
	ParseHelper<Model> parser
	
	@Inject extension ValidationTestHelper
	
	OnTheFlyJavaCompiler compiler = new OnTheFlyJavaCompiler();

	
	@Test
	def void testMyExample() {
		var m = parser.parse(
		'''
		dtmc
		
		const double psend =0.8;
		
		
		module node0
		active0:[0..1] init 1;
		send0:  [0..1] init 0;
		
		[tick] active0=1 & send0=0 -> psend:(active0'=1)&(send0'=1)+(1-psend):(active0'=0)&(send0'=0);
		[tick] active0=1 & send0=1 -> (send0'=0)& (active0'=0);
		[tick] active0=0  -> (send0'=0)& (active0'=0);
		endmodule
		
		
		module node1
		active1:[0..1] init 1;
		send1:  [0..1] init 0;
		
		[tick] active1=1 & send1=0 & send0+send2+send4 >=1 -> psend:(active1'=1)&(send1'=1)+(1-psend):(active1'=0)&(send1'=0);
		[tick] active1=1 & send1=0 & send0+send2+send4 <1 -> (active1'=1)& (send1'=0);
		[tick] active1=1 & send1=1 -> (send1'=0)& (active1'=0);
		[tick] active1=0 -> (send1'=0)& (active1'=0);
		endmodule
		
		module node2
		active2:[0..1] init 1;
		send2:  [0..1] init 0;
		
		[tick] active2=1 & send2=0 & send1+send5 >= 1 -> psend:(active2'=1)&(send2'=1)+(1-psend):(active2'=0)&(send2'=0);
		[tick] active2=1 & send2=0 & send1+send5 < 1 -> (active2'=1)& (send2'=0);
		[tick] active2=1 & send2=1   -> (send2'=0)& (active2'=0);
		[tick] active2=0  -> (send2'=0)& (active2'=0);
		endmodule
		
		
		module node3
		active3:[0..1] init 1;
		send3:  [0..1] init 0;
		
		
		[tick] active3=1 & send3=0 & send0+send4+ send6 >=1 -> psend:(active3'=1)&(send3'=1)+(1-psend):(active3'=0)&(send3'=0);
		[tick] active3=1 & send3=0 & send0+send4+ send6 <1 -> (active3'=1)& (send3'=0);
		[tick] active3=1 & send3=1    -> (send3'=0)& (active3'=0);
		[tick] active3=0  -> (send3'=0)& (active3'=0);
		endmodule
		
		
		module node4
		active4:[0..1] init 1;
		send4:  [0..1] init 0;
		
		[tick] active4=1 & send4=0 & send1+send3+ send5 +send7 >=1 -> psend:(active4'=1)&(send4'=1)+(1-psend):(active4'=0)&(send4'=0);
		[tick] active4=1 & send4=0 & send1+send3+ send5 +send7 <1 -> (active4'=1) & (send4'=0);
		[tick] active4=1 & send4=1 -> (send4'=0)& (active4'=0);
		[tick] active4=0  -> (send4'=0)& (active4'=0);
		endmodule
		
		module node5
		active5:[0..1] init 1;
		send5:  [0..1] init 0;
		
		[tick] active5=1 & send5=0 & send2+send4+ send8 >=1 -> psend:(active5'=1)&(send5'=1)+(1-psend):(active5'=0)&(send5'=0);
		[tick] active5=1 & send5=0 & send2+send4+ send8 < 1 -> (active5'=1) & (send5'=0);
		[tick] active5=1 & send5=1 -> (send5'=0)& (active5'=0);
		[tick] active5=0  -> (send5'=0)& (active5'=0);
		endmodule
		
		module node6
		active6:[0..1] init 1;
		send6:  [0..1] init 0;
		
		[tick] active6=1 & send6=0 & send3+send7 >=1 -> psend:(active6'=1)&(send6'=1)+(1-psend):(active6'=0)&(send6'=0);
		[tick] active6=1 & send6=0 & send3+send7 < 1 -> (active6'=1) & (send6'=0);
		[tick] active6=1 & send6=1    -> (send6'=0)& (active6'=0);
		[tick] active6=0  -> (send6'=0)& (active6'=0);
		endmodule
		
		module node7
		active7:[0..1] init 1;
		send7:  [0..1] init 0;
		
		[tick] active7=1 & send7=0 & send4+send6+ send8 >=1 -> psend:(active7'=1)&(send7'=1)+(1-psend):(active7'=0)&(send7'=0);
		[tick] active7=1 & send7=0 & send4+send6+ send8 < 1 -> (active7'=1) & (send7'=0);
		[tick] active7=1 & send7=1    -> (send7'=0)& (active7'=0);
		[tick] active7=0  -> (send7'=0)& (active7'=0);
		endmodule
		
		module node8
		active8:[0..1] init 1;
		send8:  [0..1] init 0;
		
		[tick] active8=1 & send8=0 & send5+send7 >=1 -> psend:(active8'=1)&(send8'=1)+(1-psend):(active8'=0)&(send8'=0);
		[tick] active8=1 & send8=0 & send5+send7 < 1 -> (active8'=1) & (send8'=0);
		[tick] active8=1 & send8=1    -> (send8'=0)& (active8'=0);
		[tick] active8=0  -> (send8'=0)& (active8'=0);
		endmodule
			
			stateformula success = { active8 = 0 };
			
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