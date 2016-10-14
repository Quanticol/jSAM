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
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.cmg.ml.sam.prism.PrismModel
import static extension org.junit.Assert.*


@InjectWith(typeof(PrismInjectorProvider))
@RunWith(typeof(XtextRunner))
class BoundedRetransmission {
	
	@Inject
	ParseHelper<Model> parser
	
//	@Inject extension ValidationTestHelper
	
	@Inject extension CompilationTestHelper
	
//	@Inject extension ReflectExtensions
	
	
	@Test
	def void testN16_MAX5() {	
		'''
// bounded retransmission protocol [D'AJJL01]
// gxn/dxp 23/05/2001

dtmc

// number of chunks
const int N = 1000;
// maximum number of retransmissions
const int MAX = 30;

module sender

	s : [0..6];
	// 0 idle
	// 1 next_frame	
	// 2 wait_ack
	// 3 retransmit
	// 4 success
	// 5 error
	// 6 wait sync
	srep : [0..3];
	// 0 bottom
	// 1 not ok (nok)
	// 2 do not know (dk)
	// 3 ok (ok)
	nrtr : [0..MAX];
	i : [0..N];
	bs : bool;
	s_ab : bool;
	fs : bool;
	ls : bool;
	
	// idle
	[NewFile] (s=0) -> (s'=1) & (i'=1) & (srep'=0);
	// next_frame
	[aF] (s=1) -> (s'=2) & (fs'=(i=1)) & (ls'=(i=N)) & (bs'=s_ab) & (nrtr'=0);
	// wait_ack
	[aB] (s=2) -> (s'=4) & (s_ab'=!s_ab);
	[TO_Msg] (s=2) -> (s'=3);
	[TO_Ack] (s=2) -> (s'=3);
	// retransmit
	[aF] (s=3) & (nrtr<MAX) -> (s'=2) & (fs'=(i=1)) & (ls'=(i=N)) & (bs'=s_ab) & (nrtr'=nrtr+1);
	[] (s=3) & (nrtr=MAX) & (i<N) -> (s'=5) & (srep'=1);
	[] (s=3) & (nrtr=MAX) & (i=N) -> (s'=5) & (srep'=2);
	// success
	[] (s=4) & (i<N) -> (s'=1) & (i'=i+1);
	[] (s=4) & (i=N) -> (s'=0) & (srep'=3);
	// error
	[SyncWait] (s=5) -> (s'=6); 
	// wait sync
	[SyncWait] (s=6) -> (s'=0) & (s_ab'=false); 
	
endmodule

module receiver

	r : [0..5];
	// 0 new_file
	// 1 fst_safe
	// 2 frame_received
	// 3 frame_reported
	// 4 idle
	// 5 resync
	rrep : [0..4];
	// 0 bottom
	// 1 fst
	// 2 inc
	// 3 ok
	// 4 nok
	fr : bool;
	lr : bool;
	br : bool;
	r_ab : bool;
	recv : bool;
	
	
	// new_file
	[SyncWait] (r=0) -> (r'=0);
	[aG] (r=0) -> (r'=1) & (fr'=fs) & (lr'=ls) & (br'=bs) & (recv'=T);
	// fst_safe_frame
	[] (r=1) -> (r'=2) & (r_ab'=br);
	// frame_received
	[] (r=2) & (r_ab=br) & (fr=true) & (lr=false)  -> (r'=3) & (rrep'=1);
	[] (r=2) & (r_ab=br) & (fr=false) & (lr=false) -> (r'=3) & (rrep'=2);
	[] (r=2) & (r_ab=br) & (fr=false) & (lr=true)  -> (r'=3) & (rrep'=3);
	[aA] (r=2) & !(r_ab=br) -> (r'=4);  
	// frame_reported
	[aA] (r=3) -> (r'=4) & (r_ab'=!r_ab);
	// idle
	[aG] (r=4) -> (r'=2) & (fr'=fs) & (lr'=ls) & (br'=bs) & (recv'=T);
	[SyncWait] (r=4) & (ls=true) -> (r'=5);
	[SyncWait] (r=4) & (ls=false) -> (r'=5) & (rrep'=4);
	// resync
	[SyncWait] (r=5) -> (r'=0) & (rrep'=0);
	
endmodule
	
module checker // prevents more than one frame being set

	T : bool;
	
	[NewFile] (T=false) -> (T'=true);
	
endmodule

module	channelK

	k : [0..2];
	
	// idle
	[aF] (k=0) -> 0.98 : (k'=1) + 0.02 : (k'=2);
	// sending
	[aG] (k=1) -> (k'=0);
	// lost
	[TO_Msg] (k=2) -> (k'=0);
	
endmodule

module	channelL

	l : [0..2];
	
	// idle
	[aA] (l=0) -> 0.99 : (l'=1) + 0.01 : (l'=2);
	// sending
	[aB] (l=1) -> (l'=0);
	// lost
	[TO_Ack] (l=2) -> (l'=0);
	
endmodule


			stateformula tFormula = { true };

			stateformula ttFormula = { nrtr<2 };
			
			stateformula target = { s=4 }&{ i=N };


'''.compile[
			getCompiledClass.newInstance => [
				assertTrue( it instanceof PrismModel )
				var model = it as PrismModel
				var state = model.startState
				assertNotNull(state)				
				var left = model.getStateFormula("ttFormula");
				var right = model.getStateFormula("target");
				var target = new Until( left , right );
				var count = 0
				var time = 0.0
				var size = 20
				var total_memory = 0.0
				var runtime = Runtime::getRuntime()
				while (count<size) {
					runtime.gc()
					var opmc = new OnTheFlyProbabilisticModelChecker<PrismState>();
					var ct = System::currentTimeMillis
					println("Probability: "+opmc.getProbability(state,target));
					ct = System::currentTimeMillis - ct
					println("Time: "+ct)
					time = time + ct
					var totalMemory = runtime.totalMemory() 
					var freeMemory = runtime.freeMemory()
					var memory = totalMemory - freeMemory
					total_memory = memory + total_memory
					println("Total Memory: "+totalMemory/(1024L*1024L))
					println("Free Memory: "+freeMemory/(1024L*1024L))
					println("Used Memory: "+memory/(1024L*1024L))
					count = count + 1
				}
				println("\n\nAVERAGE TIME: "+(time/size));
				println("\n\nAVERAGE USED MEMORY: "+(total_memory/size));
			]
		]
//			m.assertNoErrors
//		var prismCompiler = new PrismCompiler(compiler)
//		var model = prismCompiler.compile( m )
//		var state = model.startState
//		var left = model.getStateFormula("tFormula");
//		var right = model.getStateFormula("target");
//		var target = new Until( left , right );
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
	
	
}