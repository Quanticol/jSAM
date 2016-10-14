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
import static extension org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.cmg.ml.sam.core.logic.Until
import org.cmg.ml.sam.core.mc.pomc.OnTheFlyProbabilisticModelChecker
import org.cmg.ml.sam.prism.PrismState
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.cmg.ml.sam.prism.PrismModel

@InjectWith(typeof(PrismInjectorProvider))
@RunWith(typeof(XtextRunner))
class TestDF {
	
	
	@Inject
	ParseHelper<Model> parser
	
//	@Inject extension ValidationTestHelper
	
	@Inject extension CompilationTestHelper
	
//	@Inject extension ReflectExtensions
	
	@Test
	def void testDF3() {
//		var m = parser.parse(
		'''
dtmc


global f1: bool init true;
global f2: bool init true;
global f3: bool init true;

const double pa = 0.5;
const double pr = 0.5;
const double ph = 0.5;

module Philosopher1
	//0: Thinking
	//1: Angry
	//2: Left taken
	//3: Right taken (and Eating)
	//4: Release 
	s1: [0..4];
[] (s1=0) -> pa:(s1'=0)+(1-pa):(s1'=1);
[] (s1=1 & f1) -> (s1'=2) & (f1'=false);
[] (s1=1 & !f1) -> pr:(s1'=1) + (1-pr):(s1'=0);
[] (s1=2 & f2) -> (s1'=3) & (f2'=false);
[] (s1=2 & !f2) -> pr:(s1'=2)+(1-pr):(s1'=0) & (f1'=true);
[] (s1=3) -> ph:(s1'=3)+(1-ph):(s1'=4);
[] (s1=4) -> (s1'=0)&(f1'=false)&(f2'=false);
endmodule

module Philosopher2 = Philosopher1[ s1=s2 , f1=f2 , f2=f3 ] 
endmodule

module Philosopher3 = Philosopher1[ s1=s3 , f1=f3 , f2=f1 ] 
endmodule

						
			stateformula success = { s1 = 3 };
			
			stateformula tFormula = { s2 = 0 & s3 = 0 };

			stateformula ttFormula = { true };			
			
			
		'''.compile[
			getCompiledClass.newInstance => [
				assertTrue( it instanceof PrismModel )
				var model = it as PrismModel
				var state = model.startState
				assertNotNull(state)				
				var left = model.getStateFormula("tFormula");
				var right = model.getStateFormula("success");
				var target = new Until( left , right );
				var count = 0
				var time = 0.0
				var size = 20
				var runtime = Runtime::getRuntime()
				while (count<size) {
					runtime.gc()					
					var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
					var ct = System::currentTimeMillis
					println("Probability: "+opmc.getProbability(state,target));
					ct = System::currentTimeMillis - ct
					println("Time: "+ct)
					time = time + ct
					count = count + 1
					var totalMemory = runtime.totalMemory() 
					var freeMemory = runtime.freeMemory()
					var memory = totalMemory - freeMemory
					println("Total Memory: "+totalMemory/(1024L*1024L))
					println("Free Memory: "+freeMemory/(1024L*1024L))
					println("Used Memory: "+memory/(1024L*1024L))
				}
				println("\n\nAVERAGE TIME: "+(time/size));
			]
		]
//		)
//		m.assertNoErrors
//		var prismCompiler = new PrismCompiler(compiler)
//		var model = prismCompiler.compile( m )
//		var state = model.startState
//		var left = model.getStateFormula("tFormula");
//		var right = model.getStateFormula("success");
//		var target = new Until( left , right );
//		var count = 0
//		var time = 0.0
//		while (count<100) {
//			var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
//			var ct = System::currentTimeMillis
//			println("Probability: "+opmc.getProbability(state,target));
//			ct = System::currentTimeMillis - ct
//			println("Time: "+ct)
//			time = time + ct
//			count = count + 1
//		}
//		println("\n\nAVERAGE TIME: "+(time/100));	
	}

		@Test
	def void testDF5() {
//		var m = parser.parse(
		'''
dtmc


global f1: bool init true;
global f2: bool init true;
global f3: bool init true;
global f4: bool init true;
global f5: bool init true;

const double pa = 0.5;
const double pr = 0.5;
const double ph = 0.5;

module Philosopher1
	//0: Thinking
	//1: Angry
	//2: Left taken
	//3: Right taken (and Eating)
	//4: Release 
	s1: [0..4];
[] (s1=0) -> pa:(s1'=0)+(1-pa):(s1'=1);
[] (s1=1 & f1) -> (s1'=2) & (f1'=false);
[] (s1=1 & !f1) -> pr:(s1'=1) + (1-pr):(s1'=0);
[] (s1=2 & f2) -> (s1'=3) & (f2'=false);
[] (s1=2 & !f2) -> pr:(s1'=2)+(1-pr):(s1'=0) & (f1'=true);
[] (s1=3) -> ph:(s1'=3)+(1-ph):(s1'=4);
[] (s1=4) -> (s1'=0)&(f1'=false)&(f2'=false);
endmodule

module Philosopher2 = Philosopher1[ s1=s2 , f1=f2 , f2=f3 ] 
endmodule

module Philosopher3 = Philosopher1[ s1=s3 , f1=f3 , f2=f4 ] 
endmodule

module Philosopher4 = Philosopher1[ s1=s4 , f1=f4 , f2=f5 ] 
endmodule

module Philosopher5 = Philosopher1[ s1=s5 , f1=f5 , f2=f1 ] 
endmodule
						
			stateformula success = { s1 = 3 };
			
			stateformula tFormula = { s2=0 & s3=0 & s4=0 & s5=0 };

			stateformula ttFormula = { true };			
			
		'''.compile[
			getCompiledClass.newInstance => [
				assertTrue( it instanceof PrismModel )
				var model = it as PrismModel
				var state = model.startState
				assertNotNull(state)				
				var left = model.getStateFormula("tFormula");
				var right = model.getStateFormula("success");
				var target = new Until( left , 50 , right );
				var count = 0
				var time = 0.0
				var size = 20
				var runtime = Runtime::getRuntime()
				while (count<size) {
					runtime.gc()					
					var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
					var ct = System::currentTimeMillis
					println("Probability: "+opmc.getProbability(state,target));
					ct = System::currentTimeMillis - ct
					println("Time: "+ct)
					time = time + ct
					count = count + 1
					var totalMemory = runtime.totalMemory() 
					var freeMemory = runtime.freeMemory()
					var memory = totalMemory - freeMemory
					println("Total Memory: "+totalMemory/(1024L*1024L))
					println("Free Memory: "+freeMemory/(1024L*1024L))
					println("Used Memory: "+memory/(1024L*1024L))
				}
				println("\n\nAVERAGE TIME: "+(time/size));
			]
		]
//		)
//		m.assertNoErrors
//		var prismCompiler = new PrismCompiler(compiler)
//		var model = prismCompiler.compile( m )
//		var state = model.startState
//		var left = model.getStateFormula("tFormula");
//		var right = model.getStateFormula("success");
//		var target = new Until( left , right );
//		var count = 0
//		var time = 0.0
//		while (count<100) {
//			var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
//			var ct = System::currentTimeMillis
//			println("Probability: "+opmc.getProbability(state,target));
//			ct = System::currentTimeMillis - ct
//			println("Time: "+ct)
//			time = time + ct
//			count = count + 1
//		}
//		println("\n\nAVERAGE TIME: "+(time/100));
	}
	
	
			@Test
	def void testDF5Bis() {
//		var m = parser.parse(
		'''
dtmc

const double pa = 0.5;
const double pr = 0.5;
const double ph = 0.5;

module Philosopher1
	//0: Thinking
	//1: Angry
	//2: Left taken
	//3: Right taken (and Eating)
	//4: Release 
	s1: [0..4];
[] (s1=0) -> pa:(s1'=0)+(1-pa):(s1'=1);
[] (s1=1 & s5<2) -> (s1'=2);
[] (s1=1 & s5>=2) -> pr:(s1'=1) + (1-pr):(s1'=0);
[] (s1=2 & s2<3) -> (s1'=3);
[] (s1=2 & s2>=3) -> pr:(s1'=2)+(1-pr):(s1'=0);
[] (s1=3) -> ph:(s1'=3)+(1-ph):(s1'=4);
[] (s1=4) -> (s1'=0);
endmodule

module Philosopher2 = Philosopher1[ s1=s2 , s5=s1 , s2=s3 ] 
endmodule

module Philosopher3 = Philosopher1[ s1=s3 , s5=s2 , s2=s4  ] 
endmodule

module Philosopher4 = Philosopher1[ s1=s4 , s5=s3 , s2=s5  ] 
endmodule

module Philosopher5 = Philosopher1[ s1=s5 , s5=s4 , s2=s1  ] 
endmodule
						
			stateformula success = { s1 = 3 };
			
			stateformula tFormula = { s2=0 & s3=0 & s4=0 & s5=0 };

			stateformula ttFormula = { true };
			
			
		'''.compile[
			getCompiledClass.newInstance => [
				assertTrue( it instanceof PrismModel )
				var model = it as PrismModel
				var state = model.startState
				assertNotNull(state)				
				var left = model.getStateFormula("tFormula");
				var right = model.getStateFormula("success");
				var target = new Until( left , 20 , right );
				var count = 0
				var time = 0.0
				var size = 20
				var runtime = Runtime::getRuntime()
				while (count<size) {
					runtime.gc()					
					var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
					var ct = System::currentTimeMillis
					println("Probability: "+opmc.getProbability(state,target));
					ct = System::currentTimeMillis - ct
					println("Time: "+ct)
					time = time + ct
					count = count + 1
					var totalMemory = runtime.totalMemory() 
					var freeMemory = runtime.freeMemory()
					var memory = totalMemory - freeMemory
					println("Total Memory: "+totalMemory/(1024L*1024L))
					println("Free Memory: "+freeMemory/(1024L*1024L))
					println("Used Memory: "+memory/(1024L*1024L))
				}
				println("\n\nAVERAGE TIME: "+(time/size));
			]
		]
//		)
//		m.assertNoErrors
//		var prismCompiler = new PrismCompiler(compiler)
//		var model = prismCompiler.compile( m )
//		var state = model.startState
//		var left = model.getStateFormula("tFormula");
//		var right = model.getStateFormula("success");
//		var target = new Until( left , 20 , right );
//		var count = 0
//		var time = 0.0
//		while (count<100) {
//			var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
//			var ct = System::currentTimeMillis
//			println("Probability: "+opmc.getProbability(state,target));
//			ct = System::currentTimeMillis - ct
//			println("Time: "+ct)
//			time = time + ct
//			count = count + 1
//		}
//		println("\n\nAVERAGE TIME: "+(time/100));
	}
	
	@Test
	def void testDF9() {
//		var m = parser.parse(
		'''
dtmc


global f1: bool init true;
global f2: bool init true;
global f3: bool init true;
global f4: bool init true;
global f5: bool init true;
global f6: bool init true;
global f7: bool init true;
global f8: bool init true;
global f9: bool init true;

const double pa = 0.5;
const double pr = 0.5;
const double ph = 0.5;

module Philosopher1
	//0: Thinking
	//1: Angry
	//2: Left taken
	//3: Right taken (and Eating)
	//4: Release 
	s1: [0..4];
[] (s1=0) -> pa:(s1'=0)+(1-pa):(s1'=1);
[] (s1=1 & f1) -> (s1'=2) & (f1'=false);
[] (s1=1 & !f1) -> pr:(s1'=1) + (1-pr):(s1'=0);
[] (s1=2 & f2) -> (s1'=3) & (f2'=false);
[] (s1=2 & !f2) -> pr:(s1'=2)+(1-pr):(s1'=0) & (f1'=true);
[] (s1=3) -> ph:(s1'=3)+(1-ph):(s1'=4);
[] (s1=4) -> (s1'=0)&(f1'=false)&(f2'=false);
endmodule

module Philosopher2 = Philosopher1[ s1=s2 , f1=f2 , f2=f3 ] 
endmodule

module Philosopher3 = Philosopher1[ s1=s3 , f1=f3 , f2=f4 ] 
endmodule

module Philosopher4 = Philosopher1[ s1=s4 , f1=f4 , f2=f5 ] 
endmodule

module Philosopher5 = Philosopher1[ s1=s5 , f1=f5 , f2=f6 ] 
endmodule
						
module Philosopher6 = Philosopher1[ s1=s6 , f1=f6 , f2=f7 ] 
endmodule
						
module Philosopher7 = Philosopher1[ s1=s7 , f1=f7 , f2=f8 ] 
endmodule
						
module Philosopher8 = Philosopher1[ s1=s8 , f1=f8 , f2=f9 ] 
endmodule
						
module Philosopher9 = Philosopher1[ s1=s9 , f1=f9 , f2=f1 ] 
endmodule
						
			stateformula success = { s1 = 3 };
			
			stateformula tFormula = { s2=0 & s3=0 & s4=0 & s5=0 & s6=0 & s7=0 & s8=0 & s9=0 };

			stateformula ttFormula = { true };
			
			
		'''.compile[
			getCompiledClass.newInstance => [
				assertTrue( it instanceof PrismModel )
				var model = it as PrismModel
				var state = model.startState
				assertNotNull(state)				
				var left = model.getStateFormula("tFormula");
				var right = model.getStateFormula("success");
				var target = new Until( left , right );
				var count = 0
				var time = 0.0
				var size = 20
				var runtime = Runtime::getRuntime()
				while (count<size) {
					runtime.gc()					
					var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
					var ct = System::currentTimeMillis
					println("Probability: "+opmc.getProbability(state,target));
					ct = System::currentTimeMillis - ct
					println("Time: "+ct)
					time = time + ct
					count = count + 1
					var totalMemory = runtime.totalMemory() 
					var freeMemory = runtime.freeMemory()
					var memory = totalMemory - freeMemory
					println("Total Memory: "+totalMemory/(1024L*1024L))
					println("Free Memory: "+freeMemory/(1024L*1024L))
					println("Used Memory: "+memory/(1024L*1024L))
				}
				println("\n\nAVERAGE TIME: "+(time/size));
			]
		]
//		)
//		m.assertNoErrors
//		var prismCompiler = new PrismCompiler(compiler)
//		var model = prismCompiler.compile( m )
//		var state = model.startState
//		var left = model.getStateFormula("tFormula");
//		var right = model.getStateFormula("success");
//		var target = new Until( left , right );
//		var count = 0
//		var time = 0.0
//		while (count<100) {
//			var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
//			var ct = System::currentTimeMillis
//			println("Probability: "+opmc.getProbability(state,target));
//			ct = System::currentTimeMillis - ct
//			println("Time: "+ct)
//			time = time + ct
//			count = count + 1
//		}
//		println("\n\nAVERAGE TIME: "+(time/100));		
	}

@Test
	def void testDF11() {
//		var m = parser.parse(
		'''
dtmc


global f1: bool init true;
global f2: bool init true;
global f3: bool init true;
global f4: bool init true;
global f5: bool init true;
global f6: bool init true;
global f7: bool init true;
global f8: bool init true;
global f9: bool init true;
global f10: bool init true;
global f11: bool init true;

const double pa = 0.5;
const double pr = 0.5;
const double ph = 0.5;

module Philosopher1
	//0: Thinking
	//1: Angry
	//2: Left taken
	//3: Right taken (and Eating)
	//4: Release 
	s1: [0..4];
[] (s1=0) -> pa:(s1'=0)+(1-pa):(s1'=1);
[] (s1=1 & f1) -> (s1'=2) & (f1'=false);
[] (s1=1 & !f1) -> pr:(s1'=1) + (1-pr):(s1'=0);
[] (s1=2 & f2) -> (s1'=3) & (f2'=false);
[] (s1=2 & !f2) -> pr:(s1'=2)+(1-pr):(s1'=0) & (f1'=true);
[] (s1=3) -> ph:(s1'=3)+(1-ph):(s1'=4);
[] (s1=4) -> (s1'=0)&(f1'=false)&(f2'=false);
endmodule

module Philosopher2 = Philosopher1[ s1=s2 , f1=f2 , f2=f3 ] 
endmodule

module Philosopher3 = Philosopher1[ s1=s3 , f1=f3 , f2=f4 ] 
endmodule

module Philosopher4 = Philosopher1[ s1=s4 , f1=f4 , f2=f5 ] 
endmodule

module Philosopher5 = Philosopher1[ s1=s5 , f1=f5 , f2=f6 ] 
endmodule
						
module Philosopher6 = Philosopher1[ s1=s6 , f1=f6 , f2=f7 ] 
endmodule
						
module Philosopher7 = Philosopher1[ s1=s7 , f1=f7 , f2=f8 ] 
endmodule
						
module Philosopher8 = Philosopher1[ s1=s8 , f1=f8 , f2=f9 ] 
endmodule
						
module Philosopher9 = Philosopher1[ s1=s9 , f1=f9 , f2=f10 ] 
endmodule

module Philosopher10 = Philosopher1[ s1=s10 , f1=f10 , f2=f11 ] 
endmodule

module Philosopher11 = Philosopher1[ s1=s11 , f1=f11 , f2=f1 ] 
endmodule
						
			stateformula success = { s1 = 3 };
			
			stateformula tFormula = { s2=0 & s3=0 & s4=0 & s5=0 & s6=0 & s7=0 & s8=0 & s9=0 & s10=0 & s11=0 };

			stateformula ttFormula = { true };
			
			
		'''.compile[
			getCompiledClass.newInstance => [
				assertTrue( it instanceof PrismModel )
				var model = it as PrismModel
				var state = model.startState
				assertNotNull(state)				
				var left = model.getStateFormula("tFormula");
				var right = model.getStateFormula("success");
				var target = new Until( left , right );
				var count = 0
				var time = 0.0
				var size = 20
				var runtime = Runtime::getRuntime()
				while (count<size) {
					runtime.gc()					
					var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
					var ct = System::currentTimeMillis
					println("Probability: "+opmc.getProbability(state,target));
					ct = System::currentTimeMillis - ct
					println("Time: "+ct)
					time = time + ct
					count = count + 1
					var totalMemory = runtime.totalMemory() 
					var freeMemory = runtime.freeMemory()
					var memory = totalMemory - freeMemory
					println("Total Memory: "+totalMemory/(1024L*1024L))
					println("Free Memory: "+freeMemory/(1024L*1024L))
					println("Used Memory: "+memory/(1024L*1024L))
				}
				println("\n\nAVERAGE TIME: "+(time/size));
			]
		]
//		)
//		m.assertNoErrors
//		var prismCompiler = new PrismCompiler(compiler)
//		var model = prismCompiler.compile( m )
//		var state = model.startState
//		var left = model.getStateFormula("tFormula");
//		var right = model.getStateFormula("success");
//		var target = new Until( left , 20 ,  right );
//		var count = 0
//		var time = 0.0
//		while (count<100) {
//			var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
//			var ct = System::currentTimeMillis
//			println("Probability: "+opmc.getProbability(state,target));
//			ct = System::currentTimeMillis - ct
//			println("Time: "+ct)
//			time = time + ct
//			count = count + 1
//		}
//		println("\n\nAVERAGE TIME: "+(time/100));
	}

	@Test
	def void testDF15() {
//		var m = parser.parse(
		'''
dtmc


global f1: bool init true;
global f2: bool init true;
global f3: bool init true;
global f4: bool init true;
global f5: bool init true;
global f6: bool init true;
global f7: bool init true;
global f8: bool init true;
global f9: bool init true;
global f10: bool init true;
global f11: bool init true;
global f12: bool init true;
global f13: bool init true;
global f14: bool init true;
global f15: bool init true;

const double pa = 0.5;
const double pr = 0.5;
const double ph = 0.5;

module Philosopher1
	//0: Thinking
	//1: Angry
	//2: Left taken
	//3: Right taken (and Eating)
	//4: Release 
	s1: [0..4];
[] (s1=0) -> pa:(s1'=0)+(1-pa):(s1'=1);
[] (s1=1 & f1) -> (s1'=2) & (f1'=false);
[] (s1=1 & !f1) -> pr:(s1'=1) + (1-pr):(s1'=0);
[] (s1=2 & f2) -> (s1'=3) & (f2'=false);
[] (s1=2 & !f2) -> pr:(s1'=2)+(1-pr):(s1'=0) & (f1'=true);
[] (s1=3) -> ph:(s1'=3)+(1-ph):(s1'=4);
[] (s1=4) -> (s1'=0)&(f1'=false)&(f2'=false);
endmodule

module Philosopher2 = Philosopher1[ s1=s2 , f1=f2 , f2=f3 ] 
endmodule

module Philosopher3 = Philosopher1[ s1=s3 , f1=f3 , f2=f4 ] 
endmodule

module Philosopher4 = Philosopher1[ s1=s4 , f1=f4 , f2=f5 ] 
endmodule

module Philosopher5 = Philosopher1[ s1=s5 , f1=f5 , f2=f6 ] 
endmodule
						
module Philosopher6 = Philosopher1[ s1=s6 , f1=f6 , f2=f7 ] 
endmodule
						
module Philosopher7 = Philosopher1[ s1=s7 , f1=f7 , f2=f8 ] 
endmodule
						
module Philosopher8 = Philosopher1[ s1=s8 , f1=f8 , f2=f9 ] 
endmodule
						
module Philosopher9 = Philosopher1[ s1=s9 , f1=f9 , f2=f10 ] 
endmodule

module Philosopher10 = Philosopher1[ s1=s10 , f1=f10 , f2=f11 ] 
endmodule

module Philosopher11 = Philosopher1[ s1=s11 , f1=f11 , f2=f12 ] 
endmodule

module Philosopher12 = Philosopher1[ s1=s12 , f1=f12 , f2=f13 ] 
endmodule

module Philosopher13 = Philosopher1[ s1=s13 , f1=f13 , f2=f14 ] 
endmodule

module Philosopher14 = Philosopher1[ s1=s14 , f1=f14 , f2=f15 ] 
endmodule

module Philosopher15 = Philosopher1[ s1=s15 , f1=f15 , f2=f1 ] 
endmodule
						
			stateformula success = { s1 = 3 };
			
			stateformula tFormula = { s2 = 0 & s3 = 0  & s4=0 & s5=0 & s6=0 & s7=0 & s8=0 & s9=0 & s10=0 & s11=0 & s12=0 & s13=0 & s14=0 & s15=0 };

			stateformula ttFormula = { true };
			
			
		'''.compile[
			getCompiledClass.newInstance => [
				assertTrue( it instanceof PrismModel )
				var model = it as PrismModel
				var state = model.startState
				assertNotNull(state)				
				var left = model.getStateFormula("tFormula");
				var right = model.getStateFormula("success");
				var target = new Until( left , 20 , right );
				var count = 0
				var time = 0.0
				var size = 20
				var runtime = Runtime::getRuntime()
				while (count<size) {
					runtime.gc()					
					var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
					var ct = System::currentTimeMillis
					println("Probability: "+opmc.getProbability(state,target));
					ct = System::currentTimeMillis - ct
					println("Time: "+ct)
					time = time + ct
					count = count + 1
					var totalMemory = runtime.totalMemory() 
					var freeMemory = runtime.freeMemory()
					var memory = totalMemory - freeMemory
					println("Total Memory: "+totalMemory/(1024L*1024L))
					println("Free Memory: "+freeMemory/(1024L*1024L))
					println("Used Memory: "+memory/(1024L*1024L))
				}
				println("\n\nAVERAGE TIME: "+(time/size));
			]
		]
//		)
//		m.assertNoErrors
//		var prismCompiler = new PrismCompiler(compiler)
//		var model = prismCompiler.compile( m )
//		var state = model.startState
//		var left = model.getStateFormula("tFormula");
//		var right = model.getStateFormula("success");
//		var target = new Until( left , 20 , right );
//		var count = 0
//		var time = 0.0
//		while (count<100) {
//			var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
//			var ct = System::currentTimeMillis
//			println("Probability: "+opmc.getProbability(state,target));
//			ct = System::currentTimeMillis - ct
//			println("Time: "+ct)
//			time = time + ct
//			count = count + 1
//		}
//		println("\n\nAVERAGE TIME: "+(time/100));
	}

	@Test
	def void testDF21() {
//		var m = parser.parse(
		'''
dtmc


global f1: bool init true;
global f2: bool init true;
global f3: bool init true;
global f4: bool init true;
global f5: bool init true;
global f6: bool init true;
global f7: bool init true;
global f8: bool init true;
global f9: bool init true;
global f10: bool init true;
global f11: bool init true;
global f12: bool init true;
global f13: bool init true;
global f14: bool init true;
global f15: bool init true;
global f16: bool init true;
global f17: bool init true;
global f18: bool init true;
global f19: bool init true;
global f20: bool init true;
global f21: bool init true;

const double pa = 0.5;
const double pr = 0.5;
const double ph = 0.5;

module Philosopher1
	//0: Thinking
	//1: Angry
	//2: Left taken
	//3: Right taken (and Eating)
	//4: Release 
	s1: [0..4];
[] (s1=0) -> pa:(s1'=0)+(1-pa):(s1'=1);
[] (s1=1 & f1) -> (s1'=2) & (f1'=false);
[] (s1=1 & !f1) -> pr:(s1'=1) + (1-pr):(s1'=0);
[] (s1=2 & f2) -> (s1'=3) & (f2'=false);
[] (s1=2 & !f2) -> pr:(s1'=2)+(1-pr):(s1'=0) & (f1'=true);
[] (s1=3) -> ph:(s1'=3)+(1-ph):(s1'=4);
[] (s1=4) -> (s1'=0)&(f1'=false)&(f2'=false);
endmodule

module Philosopher2 = Philosopher1[ s1=s2 , f1=f2 , f2=f3 ] 
endmodule

module Philosopher3 = Philosopher1[ s1=s3 , f1=f3 , f2=f4 ] 
endmodule

module Philosopher4 = Philosopher1[ s1=s4 , f1=f4 , f2=f5 ] 
endmodule

module Philosopher5 = Philosopher1[ s1=s5 , f1=f5 , f2=f6 ] 
endmodule
						
module Philosopher6 = Philosopher1[ s1=s6 , f1=f6 , f2=f7 ] 
endmodule
						
module Philosopher7 = Philosopher1[ s1=s7 , f1=f7 , f2=f8 ] 
endmodule
						
module Philosopher8 = Philosopher1[ s1=s8 , f1=f8 , f2=f9 ] 
endmodule
						
module Philosopher9 = Philosopher1[ s1=s9 , f1=f9 , f2=f10 ] 
endmodule

module Philosopher10 = Philosopher1[ s1=s10 , f1=f10 , f2=f11 ] 
endmodule

module Philosopher11 = Philosopher1[ s1=s11 , f1=f11 , f2=f12 ] 
endmodule

module Philosopher12 = Philosopher1[ s1=s12 , f1=f12 , f2=f13 ] 
endmodule

module Philosopher13 = Philosopher1[ s1=s13 , f1=f13 , f2=f14 ] 
endmodule

module Philosopher14 = Philosopher1[ s1=s14 , f1=f14 , f2=f15 ] 
endmodule

module Philosopher15 = Philosopher1[ s1=s15 , f1=f15 , f2=f16 ] 
endmodule

module Philosopher16 = Philosopher1[ s1=s16 , f1=f16 , f2=f17 ] 
endmodule

module Philosopher17 = Philosopher1[ s1=s17 , f1=f17 , f2=f18 ] 
endmodule

module Philosopher18 = Philosopher1[ s1=s18 , f1=f18 , f2=f19 ] 
endmodule

module Philosopher19 = Philosopher1[ s1=s19 , f1=f19 , f2=f20 ] 
endmodule

module Philosopher20 = Philosopher1[ s1=s20 , f1=f20 , f2=f21 ] 
endmodule

module Philosopher21 = Philosopher1[ s1=s21 , f1=f21 , f2=f1 ] 
endmodule
						
			stateformula success = { s1 = 3 };
			
			stateformula tFormula = { s2=0 & s3=0 & s4=0 & s5=0 & s6=0 & s7=0 & s8=0 & s9=0 & s10=0 & s11=0 & s12=0 & s13=0 & s14=0 & s15=0 & s16=0& s17=0& s18=0& s19=0& s20=0& s21=0};

			stateformula ttFormula = { true };
			
			
		'''.compile[
			getCompiledClass.newInstance => [
				assertTrue( it instanceof PrismModel )
				var model = it as PrismModel
				var state = model.startState
				assertNotNull(state)				
				var left = model.getStateFormula("tFormula");
				var right = model.getStateFormula("success");
				var target = new Until( left , right );
				var count = 0
				var time = 0.0
				var size = 20
				var runtime = Runtime::getRuntime()
				while (count<size) {
					runtime.gc()					
					var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
					var ct = System::currentTimeMillis
					println("Probability: "+opmc.getProbability(state,target));
					ct = System::currentTimeMillis - ct
					println("Time: "+ct)
					time = time + ct
					count = count + 1
					var totalMemory = runtime.totalMemory() 
					var freeMemory = runtime.freeMemory()
					var memory = totalMemory - freeMemory
					println("Total Memory: "+totalMemory/(1024L*1024L))
					println("Free Memory: "+freeMemory/(1024L*1024L))
					println("Used Memory: "+memory/(1024L*1024L))
				}
				println("\n\nAVERAGE TIME: "+(time/size));
			]
		]
//		)
//		m.assertNoErrors
//		var prismCompiler = new PrismCompiler(compiler)
//		var model = prismCompiler.compile( m )
//		var state = model.startState
//		var left = model.getStateFormula("tFormula");
//		var right = model.getStateFormula("success");
//		var target = new Until( left , right );
//		var count = 0
//		var time = 0.0
//		while (count<100) {
//			var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
//			var ct = System::currentTimeMillis
//			println("Probability: "+opmc.getProbability(state,target));
//			ct = System::currentTimeMillis - ct
//			println("Time: "+ct)
//			time = time + ct
//			count = count + 1
//		}
//		println("\n\nAVERAGE TIME: "+(time/100));
	}

}