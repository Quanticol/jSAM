package org.cmg.ml.sam.xtext.prism.tests

import com.google.inject.Inject
import org.cmg.ml.sam.core.logic.Until
import org.cmg.ml.sam.core.mc.pomc.OnTheFlyProbabilisticModelChecker
import org.cmg.ml.sam.prism.PrismState
import org.cmg.ml.sam.util.OnTheFlyJavaCompiler
import org.cmg.ml.sam.xtext.prism.PrismCompiler
import org.cmg.ml.sam.xtext.prism.PrismInjectorProvider
import org.cmg.ml.sam.xtext.prism.prism.Model
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.junit.Test
import org.junit.runner.RunWith
import static extension org.junit.Assert.*
import org.cmg.ml.sam.prism.PrismModel

@InjectWith(typeof(PrismInjectorProvider))
@RunWith(typeof(XtextRunner))
class TestHerman {
	
	@Inject
	ParseHelper<Model> parser
	
//	@Inject extension ValidationTestHelper
	
	@Inject extension CompilationTestHelper
	
//	@Inject extension ReflectExtensions
	
	
	@Test
	def void testHerman3() {
//		var m = parser.parse(
		'''
			dtmc
			
			const double p = 0.5;
			
			// module for process 1
			module process1
			
				// Boolean variable for process 1
				x1 : [0..1];
				
				[step]  (x1=x3) -> p : (x1'=0) + 1-p : (x1'=1);
				[step] !(x1=x3) -> (x1'=x3);
				
			endmodule
			
			// add further processes through renaming L:16
			module process2 = process1 [ x1=x2, x3=x1 ] endmodule
			module process3 = process1 [ x1=x3, x3=x2 ] endmodule
			
			// cost - 1 in each state (expected number of steps) L:20
			rewards "steps"
				true : 1;
			endrewards
			
			// set of initial states: all (i.e. any possible initial configuration of tokens) L:25
			init
				true
			endinit
			

			// formula, for use in properties: number of tokens
			// (i.e. number of processes that have the same value as the process to their left)
			formula num_tokens = (x1=x2?1:0)+(x2=x3?1:0)+(x3=x1?1:0);
			
			// label - stable configurations (1 token)
			label "stable" = num_tokens=1;
						
			stateformula tFormula = { true };						
						
			stateformula success = { num_tokens = 1 };
			
			stateformula c = { true };

			stateformula ttFormula = { x1=x2 };
			
			
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
//		println("START COMPILER...")
//		var prismCompiler = new PrismCompiler(compiler)
//		var model = prismCompiler.compile( m )
//		println("DONE!")
//		var state = model.startState
//		var left = model.getStateFormula("tFormula");
//		var right = model.getStateFormula("success");
//		var target = new Until( left ,10 ,  right );
////		var target = new Until( left ,  right );
//		var count = 0
//		var time = 0.0
//		while (count<10) {
//			var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
//			var ct = System::currentTimeMillis
//			println("Probability: "+opmc.getProbability(state,target));
//			ct = System::currentTimeMillis - ct
//			println("Time: "+ct)
//			time = time + ct
//			count = count + 1
//		}
//		println("\n\nAVERAGE TIME: "+(time/10));
	}
	
			@Test
	def void testHermanBis5() {
		'''
dtmc

const double p = 0.5;

// module for process 1
module process1

	// Boolean variable for process 1
	x1 : [0..1];
	
	[step]  (x1=x5) -> p : (x1'=0) + 1-p : (x1'=1);
	[step] !(x1=x5) -> (x1'=x5);
	
endmodule

// add further processes through renaming
module process2 = process1 [ x1=x2, x5=x1 ] endmodule
module process3 = process1 [ x1=x3, x5=x2 ] endmodule
module process4 = process1 [ x1=x4, x5=x3 ] endmodule
module process5 = process1 [ x1=x5, x5=x4 ] endmodule

// cost - 1 in each state (expected number of steps)
rewards "steps"
	true : 1;
endrewards

// set of initial states: all (i.e. any possible initial configuration of tokens)
init
	true
endinit

// formula, for use in properties: number of tokens
// (i.e. number of processes that have the same value as the process to their left)
formula num_tokens = (x1=x2?1:0)+(x2=x3?1:0)+(x3=x4?1:0)+(x4=x5?1:0)+(x5=x1?1:0);

// label - stable configurations (1 token)
label "stable" = num_tokens=1;
						
			stateformula success = { num_tokens = 1 };
			
			stateformula tFormula = { true };
			
			stateformula ttFormula = { x1=x2 };

			
		'''.compile[
			getCompiledClass.newInstance => [
				assertTrue( it instanceof PrismModel )
				var model = it as PrismModel
				var state = model.startState
				assertNotNull(state)				
				var left = model.getStateFormula("tFormula");
				var right = model.getStateFormula("success");
				var target = new Until( left , 2 , right );
				var count = 0
				var time = 0.0
				var size = 1000
				while (count<size) {
					var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
					var ct = System::currentTimeMillis
					println("Probability: "+opmc.getProbability(state,target));
					ct = System::currentTimeMillis - ct
					println("Time: "+ct)
					time = time + ct
					count = count + 1
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
//		var target = new Until( left , 2 , right );
//		var count = 0
//		var time = 0.0
//		while (count<10) {
//			var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
//			var ct = System::currentTimeMillis
//			println("Probability: "+opmc.getProbability(state,target));
//			ct = System::currentTimeMillis - ct
//			println("Time: "+ct)
//			time = time + ct
//			count = count + 1
//		}
//		println("\n\nAVERAGE TIME: "+(time/10));
	}
	

		@Test
	def void testHerman5() {
		'''
dtmc

const double p = 0.5;

// module for process 1
module process1

	// Boolean variable for process 1
	x1 : [0..1];
	
	[step]  (x1=x5) -> p : (x1'=0) + 1-p : (x1'=1);
	[step] !(x1=x5) -> (x1'=x5);
	
endmodule

// add further processes through renaming
module process2 = process1 [ x1=x2, x5=x1 ] endmodule
module process3 = process1 [ x1=x3, x5=x2 ] endmodule
module process4 = process1 [ x1=x4, x5=x3 ] endmodule
module process5 = process1 [ x1=x5, x5=x4 ] endmodule

// cost - 1 in each state (expected number of steps)
rewards "steps"
	true : 1;
endrewards

// set of initial states: all (i.e. any possible initial configuration of tokens)
init
	true
endinit

// formula, for use in properties: number of tokens
// (i.e. number of processes that have the same value as the process to their left)
formula num_tokens = (x1=x2?1:0)+(x2=x3?1:0)+(x3=x4?1:0)+(x4=x5?1:0)+(x5=x1?1:0);

// label - stable configurations (1 token)
label "stable" = num_tokens=1;
						
			stateformula success = { num_tokens = 1 };
			
			stateformula tFormula = { true };
			
			stateformula ttFormula = { x1=x2 };

			
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
				var size = 1000
				while (count<size) {
					var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
					var ct = System::currentTimeMillis
					println("Probability: "+opmc.getProbability(state,target));
					ct = System::currentTimeMillis - ct
					println("Time: "+ct)
					time = time + ct
					count = count + 1
				}
				println("\n\nAVERAGE TIME: "+(time/size));
			]
		]
	}
	
		@Test
	def void testHerman7() {
		'''
dtmc

const double p = 0.5;

// module for process 1
module process1

	// Boolean variable for process 1
	x1 : [0..1];
	
	[step]  (x1=x7) -> p : (x1'=0) + 1-p : (x1'=1);
	[step] !(x1=x7) -> (x1'=x7);
	
endmodule

// add further processes through renaming
module process2 = process1 [ x1=x2, x7=x1 ] endmodule
module process3 = process1 [ x1=x3, x7=x2 ] endmodule
module process4 = process1 [ x1=x4, x7=x3 ] endmodule
module process5 = process1 [ x1=x5, x7=x4 ] endmodule
module process6 = process1 [ x1=x6, x7=x5 ] endmodule
module process7 = process1 [ x1=x7, x7=x6 ] endmodule

// cost - 1 in each state (expected number of steps)
rewards "steps"
	true : 1;
endrewards

// set of initial states: all (i.e. any possible initial configuration of tokens)
init
	true
endinit

// formula, for use in properties: number of tokens
// (i.e. number of processes that have the same value as the process to their left)
formula num_tokens = (x1=x2?1:0)+(x2=x3?1:0)+(x3=x4?1:0)+(x4=x5?1:0)+(x5=x6?1:0)+(x6=x7?1:0)+(x7=x1?1:0);

// label - stable configurations (1 token)
label "stable" = num_tokens=1;
						
			stateformula success = { num_tokens = 1 };
			
			stateformula tFormula = { true };
			
			stateformula ttFormula = { x1=x2 };
			
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
				var size = 1000
				while (count<size) {
					var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
					var ct = System::currentTimeMillis
					println("Probability: "+opmc.getProbability(state,target));
					ct = System::currentTimeMillis - ct
					println("Time: "+ct)
					time = time + ct
					count = count + 1
				}
				println("\n\nAVERAGE TIME: "+(time/size));
			]
		]
	}
		
		@Test
	def void testHerman9() {
		'''
dtmc

const double p = 0.5;

// module for process 1
module process1

	// Boolean variable for process 1
	x1 : [0..1];
	
	[step]  (x1=x9) -> p : (x1'=0) + 1-p : (x1'=1);
	[step] !(x1=x9) -> (x1'=x9);
	
endmodule

// add further processes through renaming
module process2 = process1 [ x1=x2, x9=x1 ] endmodule
module process3 = process1 [ x1=x3, x9=x2 ] endmodule
module process4 = process1 [ x1=x4, x9=x3 ] endmodule
module process5 = process1 [ x1=x5, x9=x4 ] endmodule
module process6 = process1 [ x1=x6, x9=x5 ] endmodule
module process7 = process1 [ x1=x7, x9=x6 ] endmodule
module process8 = process1 [ x1=x8, x9=x7 ] endmodule
module process9 = process1 [ x1=x9, x9=x8 ] endmodule

// cost - 1 in each state (expected number of steps)
rewards "steps"
	true : 1;
endrewards

// set of initial states: all (i.e. any possible initial configuration of tokens)
init
	true
endinit

// formula, for use in properties: number of tokens
// (i.e. number of processes that have the same value as the process to their left)
formula num_tokens = (x1=x2?1:0)+(x2=x3?1:0)+(x3=x4?1:0)+(x4=x5?1:0)+(x5=x6?1:0)+(x6=x7?1:0)+(x7=x8?1:0)+(x8=x9?1:0)+(x9=x1?1:0);

// label - stable configurations (1 token)
label "stable" = num_tokens=1;
						
			stateformula success = { num_tokens = 1 };
			
			stateformula tFormula = { true };
			
			stateformula ttFormula = { x1=x2 };
			
		'''.compile[
			getCompiledClass.newInstance => [
				assertTrue( it instanceof PrismModel )
				var model = it as PrismModel
				var state = model.startState
				assertNotNull(state)				
				var left = model.getStateFormula("tFormula");
				var right = model.getStateFormula("success");
				var target = new Until( left ,  50 , right );
				var count = 0
				var time = 0.0
				var size = 100
				while (count<size) {
					var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
					var ct = System::currentTimeMillis
					println("Probability: "+opmc.getProbability(state,target));
					ct = System::currentTimeMillis - ct
					println("Time: "+ct)
					time = time + ct
					count = count + 1
				}
				println("\n\nAVERAGE TIME: "+(time/size));
			]
		]
	}
	
			@Test
	def void testHerman11() {
		'''
			dtmc
			
			const double p = 0.5;
			
			// module for process 1
			module process1

				// Boolean variable for process 1
				x1 : [0..1];

				[step]  (x1=x11) -> p : (x1'=0) + 1-p : (x1'=1);
				[step] !(x1=x11) -> (x1'=x11);

			endmodule
			
			// add further processes through renaming L:16
			module process2 = process1 [ x1=x2, x11=x1 ] endmodule
			module process3 = process1 [ x1=x3, x11=x2 ] endmodule
			module process4 = process1 [ x1=x4, x11=x3 ] endmodule
			module process5 = process1 [ x1=x5, x11=x4 ] endmodule
			module process6 = process1 [ x1=x6, x11=x5 ] endmodule
			module process7 = process1 [ x1=x7, x11=x6 ] endmodule
			module process8 = process1 [ x1=x8, x11=x7 ] endmodule
			module process9 = process1 [ x1=x9, x11=x8 ] endmodule
			module process10 = process1 [ x1=x10, x11=x9 ] endmodule
			module process11 = process1 [ x1=x11, x11=x10 ] endmodule
			// cost - 1 in each state (expected number of steps) L:20
			rewards "steps"
				true : 1;
			endrewards
			
			// set of initial states: all (i.e. any possible initial configuration of tokens) L:25
			init
				true
			endinit
			

			// formula, for use in properties: number of tokens
			// (i.e. number of processes that have the same value as the process to their left)
			formula num_tokens = (x1=x2?1:0)+(x2=x3?1:0)+(x3=x4?1:0)+(x4=x5?1:0)+(x5=x6?1:0)+(x6=x7?1:0)+(x7=x8?1:0)+(x8=x9?1:0)+(x9=x10?1:0)+(x10=x11?1:0)+(x11=x1?1:0);
			
			// label - stable configurations (1 token)
			label "stable" = num_tokens=1;
						
			stateformula success = { num_tokens = 1 };
			
			stateformula tFormula = { true };

			stateformula ttFormula = { x1=x2 };
			
			
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
				while (count<size) {
					var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
					var ct = System::currentTimeMillis
					println("Probability: "+opmc.getProbability(state,target));
					ct = System::currentTimeMillis - ct
					println("Time: "+ct)
					time = time + ct
					count = count + 1
				}
				println("\n\nAVERAGE TIME: "+(time/size));
			]
		]
	}
	
		@Test
	def void testHerman13() {
		'''
			dtmc
			
			const double p = 0.5;
			
			// module for process 1
			module process1

				// Boolean variable for process 1
				x1 : [0..1];

				[step]  (x1=x1) -> p : (x1'=0) + 1-p : (x1'=1);
				[step] !(x1=x13) -> (x1'=x13);

			endmodule
			
			// add further processes through renaming L:16
			module process2 = process1 [ x1=x2, x13=x1 ] endmodule
			module process3 = process1 [ x1=x3, x13=x2 ] endmodule
			module process4 = process1 [ x1=x4, x13=x3 ] endmodule
			module process5 = process1 [ x1=x5, x13=x4 ] endmodule
			module process6 = process1 [ x1=x6, x13=x5 ] endmodule
			module process7 = process1 [ x1=x7, x13=x6 ] endmodule
			module process8 = process1 [ x1=x8, x13=x7 ] endmodule
			module process9 = process1 [ x1=x9, x13=x8 ] endmodule
			module process10 = process1 [ x1=x10, x13=x9 ] endmodule
			module process11 = process1 [ x1=x11, x13=x10 ] endmodule
			module process12 = process1 [ x1=x12, x13=x11 ] endmodule
			module process13 = process1 [ x1=x13, x13=x12 ] endmodule
			// cost - 1 in each state (expected number of steps) L:20
			rewards "steps"
				true : 1;
			endrewards
			
			// set of initial states: all (i.e. any possible initial configuration of tokens) L:25
			init
				true
			endinit
			

			// formula, for use in properties: number of tokens
			// (i.e. number of processes that have the same value as the process to their left)
			formula num_tokens = (x1=x2?1:0)+(x2=x3?1:0)+(x3=x4?1:0)+(x4=x5?1:0)+(x5=x6?1:0)+(x6=x7?1:0)+(x7=x8?1:0)+(x8=x9?1:0)+(x9=x10?1:0)+(x10=x11?1:0)+(x11=x12?1:0)+(x12=x13?1:0)+(x13=x1?1:0);
			
			// label - stable configurations (1 token)
			label "stable" = num_tokens=1;
						
			stateformula success = { num_tokens = 1 };
			
			stateformula tFormula = { true };
			
			stateformula ttFormula = { x1=x2 };
			
		'''.compile[
			getCompiledClass.newInstance => [
				assertTrue( it instanceof PrismModel )
				var model = it as PrismModel
				var state = model.startState
				assertNotNull(state)				
				var left = model.getStateFormula("ttFormula");
				var right = model.getStateFormula("success");
				var target = new Until( left , right );
				var count = 0
				var time = 0.0
				var size = 10
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
	}
	
	@Test
	def void testHerman15() {
		'''
			dtmc
			
			const double p = 0.5;
			
			// module for process 1
			module process1

				// Boolean variable for process 1
				x1 : [0..1];

				[step]  (x1=x15) -> p : (x1'=0) + 1-p : (x1'=1);
				[step] !(x1=x15) -> (x1'=x15);

			endmodule
			
			// add further processes through renaming L:16
			module process2 = process1 [ x1=x2, x15=x1 ] endmodule
			module process3 = process1 [ x1=x3, x15=x2 ] endmodule
			module process4 = process1 [ x1=x4, x15=x3 ] endmodule
			module process5 = process1 [ x1=x5, x15=x4 ] endmodule
			module process6 = process1 [ x1=x6, x15=x5 ] endmodule
			module process7 = process1 [ x1=x7, x15=x6 ] endmodule
			module process8 = process1 [ x1=x8, x15=x7 ] endmodule
			module process9 = process1 [ x1=x9, x15=x8 ] endmodule
			module process10 = process1 [ x1=x10, x15=x9 ] endmodule
			module process11 = process1 [ x1=x11, x15=x10 ] endmodule
			module process12 = process1 [ x1=x12, x15=x11 ] endmodule
			module process13 = process1 [ x1=x13, x15=x12 ] endmodule
			module process14 = process1 [ x1=x14, x15=x13 ] endmodule
			module process15 = process1 [ x1=x15, x15=x14 ] endmodule
			// cost - 1 in each state (expected number of steps) L:20
			rewards "steps"
				true : 1;
			endrewards
			
			// set of initial states: all (i.e. any possible initial configuration of tokens) L:25
			init
				true
			endinit
			

			// formula, for use in properties: number of tokens
			// (i.e. number of processes that have the same value as the process to their left)
			formula num_tokens = (x1=x2?1:0)+(x2=x3?1:0)+(x3=x4?1:0)+(x4=x5?1:0)+(x5=x6?1:0)+(x6=x7?1:0)+(x7=x8?1:0)+(x8=x9?1:0)+(x9=x10?1:0)+(x10=x11?1:0)+(x11=x12?1:0)+(x12=x13?1:0)+(x13=x14?1:0)+(x14=x15?1:0)+(x15=x1?1:0);
			
			// label - stable configurations (1 token)
			label "stable" = num_tokens=1;
						
			stateformula success = { num_tokens = 1 };
			
			stateformula tFormula = { true };
			
			stateformula ttFormula = { x1=x2 };
			
		'''.compile[
			getCompiledClass.newInstance => [
				assertTrue( it instanceof PrismModel )
				var model = it as PrismModel
				var state = model.startState
				assertNotNull(state)				
				var left = model.getStateFormula("ttFormula");
				var right = model.getStateFormula("success");
				var target = new Until( left , 50 , right );
				var count = 0
				var time = 0.0
				var size = 10
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
	}
	
		@Test
	def void testHerman21() {
		'''
			dtmc
			
			const double p = 0.5;
			
			// module for process 1
			module process1

				// Boolean variable for process 1
				x1 : [0..1];

				[step]  (x1=x21) -> p : (x1'=0) + 1-p : (x1'=1);
				[step] !(x1=x21) -> (x1'=x21);

			endmodule
			
			// add further processes through renaming L:16
			module process2 = process1 [ x1=x2, x21=x1 ] endmodule
			module process3 = process1 [ x1=x3, x21=x2 ] endmodule
			module process4 = process1 [ x1=x4, x21=x3 ] endmodule
			module process5 = process1 [ x1=x5, x21=x4 ] endmodule
			module process6 = process1 [ x1=x6, x21=x5 ] endmodule
			module process7 = process1 [ x1=x7, x21=x6 ] endmodule
			module process8 = process1 [ x1=x8, x21=x7 ] endmodule
			module process9 = process1 [ x1=x9, x21=x8 ] endmodule
			module process10 = process1 [ x1=x10, x21=x9 ] endmodule
			module process11 = process1 [ x1=x11, x21=x10 ] endmodule
			module process12 = process1 [ x1=x12, x21=x11 ] endmodule
			module process13 = process1 [ x1=x13, x21=x12 ] endmodule
			module process14 = process1 [ x1=x14, x21=x13 ] endmodule
			module process15 = process1 [ x1=x15, x21=x14 ] endmodule
			module process16 = process1 [ x1=x16, x21=x15 ] endmodule
			module process17 = process1 [ x1=x17, x21=x16 ] endmodule
			module process18 = process1 [ x1=x18, x21=x17 ] endmodule
			module process19 = process1 [ x1=x19, x21=x18 ] endmodule
			module process20 = process1 [ x1=x20, x21=x19 ] endmodule
			module process21 = process1 [ x1=x21, x21=x20 ] endmodule			
			// cost - 1 in each state (expected number of steps) L:20
			rewards "steps"
				true : 1;
			endrewards
			
			// set of initial states: all (i.e. any possible initial configuration of tokens) L:25
			init
				true
			endinit
			

			// formula, for use in properties: number of tokens
			// (i.e. number of processes that have the same value as the process to their left)
			formula num_tokens = (x1=x2?1:0)+(x2=x3?1:0)+(x3=x4?1:0)+(x4=x5?1:0)+(x5=x6?1:0)+(x6=x7?1:0)+(x7=x8?1:0)+(x8=x9?1:0)+(x9=x10?1:0)+(x10=x11?1:0)+(x11=x12?1:0)+(x12=x13?1:0)+(x13=x14?1:0)+(x14=x15?1:0)+(x15=x16?1:0)+(x16=x17?1:0)+(x17=x18?1:0)+(x18=x19?1:0)+(x19=x20?1:0)+(x20=x21?1:0)+(x21=x1?1:0);
			
			// label - stable configurations (1 token)
			label "stable" = num_tokens=1;
						
			stateformula success = { num_tokens = 1 };
			
			stateformula tFormula = { true };
			
			stateformula ttFormula = { x1=x5 };
			
		'''.compile[
			getCompiledClass.newInstance => [
				assertTrue( it instanceof PrismModel )
				var model = it as PrismModel
				var state = model.startState
				assertNotNull(state)				
				var left = model.getStateFormula("tFormula");
				var right = model.getStateFormula("success");
				var target = new Until( left , 2 , right );
				var count = 0
				var time = 0.0
				var size = 1
				while (count<size) {
					var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
					var ct = System::currentTimeMillis
					println("Probability: "+opmc.getProbability(state,target));
					ct = System::currentTimeMillis - ct
					println("Time: "+ct)
					time = time + ct
					count = count + 1
				}
				println("\n\nAVERAGE TIME: "+(time/size));
			]
		]
	}
}
