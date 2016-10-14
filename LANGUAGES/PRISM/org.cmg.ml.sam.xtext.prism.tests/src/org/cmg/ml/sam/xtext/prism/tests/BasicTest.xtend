package org.cmg.ml.sam.xtext.prism.tests

import org.eclipse.xtext.junit4.InjectWith
import org.cmg.ml.sam.xtext.prism.PrismInjectorProvider
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runner.RunWith
import com.google.inject.Inject
import org.eclipse.xtext.junit4.util.ParseHelper
import org.cmg.ml.sam.xtext.prism.prism.Model
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import static extension org.junit.Assert.*
import org.junit.Assert
import org.cmg.ml.sam.prism.PrismModel
import org.cmg.ml.sam.core.logic.Until
import org.cmg.ml.sam.prism.PrismState
import org.cmg.ml.sam.core.mc.pomc.OnTheFlyProbabilisticModelChecker

@InjectWith(typeof(PrismInjectorProvider))
@RunWith(typeof(XtextRunner))
class BasicTest {

	@Inject extension ValidationTestHelper
	
	@Inject extension ParseHelper<Model>

	@Inject extension CompilationTestHelper
	
	@Inject extension PrismTestHelper

	@Test
	def testSimpleModuleA( ) {
		'''
		dtmc 

		module moduleA
			s: [0..4];
		  [] (s=0) -> 0.5:(s'=0)+0.25:(s'=1)+0.25:(s'=2);
		  [] (s=1) -> 0.5:(s'=1)+0.5:(s'=3);
		  [] (s=2) -> 0.5:(s'=2)+0.5:(s'=4);
		  [] (s=3) -> 0.5:(s'=3)+0.5:(s'=1);
		  [] (s=4) -> 0.5:(s'=2)+0.5:(s'=4);
		
		endmodule 
		
		stateformula tFormula = { true };						
						
		stateformula success = { s = 4 };
		
		
		'''.compile[
			val o = getCompiledClass().newInstance
			Assert::assertTrue(o instanceof PrismModel)
			val m = o as PrismModel
			val left = m.getStateFormula("tFormula")
			Assert::assertNotNull(left)
			val right = m.getStateFormula("success")
			Assert::assertNotNull(right)
			val s = m.startState
			Assert::assertNotNull(s)
			s.assertBoundUntilProbability(left, 2, right, 0.125 , 0.00001)
			s.assertBoundUntilProbability(left, 5, right, 0.40625 , 0.00001)
			s.assertBoundUntilProbability(left, 10, right, 0.49462890625 , 0.00001)
			s.assertUntilProbability(left, right, 0.5 , 0.00001)
		]
	}
	
	@Test
	def testSimpleModuleB( ) {
		'''
		dtmc 
		
		module moduleA
			s: [0 .. 4];
		[] (s=0) -> 0.5:(s'=0)+0.25:(s'=1)+0.25:(s'=2);
		[] (s=1) -> 0.5:(s'=1)+0.5:(s'=3);
		[] (s=2) -> 0.5:(s'=2)+0.5:(s'=4);
		[] (s=3) -> 0.5:(s'=3)+0.5:(s'=1);
		[] (s=4) -> 0.5:(s'=2)+0.5:(s'=4);		
		endmodule
		
		module moduleB
			s2: [0 .. 1];
		
		[a] (s2=0) -> 0.5:(s2'=0)+0.5:(s2'=1);
		[b] (s2=1) -> 0.5:(s2'=0)+0.5:(s2'=1);
		endmodule
		
		stateformula tFormula = { true };						
						
		stateformula success = { s = 4 };
		
				
		'''.compile[
			val o = getCompiledClass().newInstance
			Assert::assertTrue(o instanceof PrismModel)
			val m = o as PrismModel
			val left = m.getStateFormula("tFormula")
			Assert::assertNotNull(left)
			val right = m.getStateFormula("success")
			Assert::assertNotNull(right)
			val s = m.startState
			Assert::assertNotNull(s)
			s.assertBoundUntilProbability(left, 2, right, 0.03125 , 0.00001)
			s.assertBoundUntilProbability(left, 5, right, 0.18359375 , 0.00001)
			s.assertBoundUntilProbability(left, 10, right, 0.3779873847961426 , 0.00001)
			s.assertUntilProbability(left, right, 0.4999995231628418 , 0.00001)
		]
	}
	
	@Test
	def testStiff( ) {
		'''
		dtmc 
		
		const N = 6;
		
		const double eps = 0.000001;
		
		module moduleA
			s: [0 .. N];
		[] (s=0) -> (1-eps):(s'=1)+eps:(s'=N-1);
		[] (s<N-2)&(s>0) -> (1-eps)/2:(s'=s+1)+(1-eps)/2:(s'=s-1)+eps:(s'=N-1);
		[] (s=N-2) -> (1-2*eps):(s'=s-1)+eps:(s'=N)+eps:(s'=N-1);
		[] (s=N) -> 1:(s'=N);
		[] (s=N-1) -> 1:(s'=N-1);
		endmodule
				
		stateformula tFormula = { true };						
						
		stateformula success = { s = N };
		
				
		'''.compile[
			val o = getCompiledClass().newInstance
			Assert::assertTrue(o instanceof PrismModel)
			val m = o as PrismModel
			val left = m.getStateFormula("tFormula")
			Assert::assertNotNull(left)
			val right = m.getStateFormula("success")
			Assert::assertNotNull(right)
			val s = m.startState
			Assert::assertNotNull(s)
//			s.assertBoundUntilProbability(left, 2, right, 0.03125 , 0.00001)
//			s.assertBoundUntilProbability(left, 5, right, 0.18359375 , 0.00001)
//			s.assertBoundUntilProbability(left, 10, right, 0.3779873847961426 , 0.00001)
			s.assertUntilProbability(left, right, 0.1723399766459277 , 0.000001)
		]
	}
	
	
		@Test
	def testStiff2( ) {
		'''
		dtmc
		
		
		const double delta = 0.001;
		
		module Chain
		s:[1..7];
		
		
		
		[] (s=1) -> (1-delta):(s'=1) + (delta):(s'=2);
		[] (s=2) -> (1-delta):(s'=1) + (delta):(s'=3);
		[] (s=3) -> (1-delta):(s'=1) + (delta):(s'=4);
		[] (s=4) -> (1-delta):(s'=1) + (delta):(s'=5);
		[] (s=5) ->(1-delta):(s'=1) +  (delta/2):(s'=6) + (delta/2):(s'=7);
		[] (s=6) -> 1:(s'=6);
		[] (s=7) -> 1:(s'=7);
		endmodule				
		stateformula tFormula = { true };						
						
		stateformula success = { s = 6 };
		
				
		'''.compile[
			val o = getCompiledClass().newInstance
			Assert::assertTrue(o instanceof PrismModel)
			val m = o as PrismModel
			val left = m.getStateFormula("tFormula")
			Assert::assertNotNull(left)
			val right = m.getStateFormula("success")
			Assert::assertNotNull(right)
			val s = m.startState
			Assert::assertNotNull(s)
//			s.assertBoundUntilProbability(left, 2, right, 0.03125 , 0.00001)
//			s.assertBoundUntilProbability(left, 5, right, 0.18359375 , 0.00001)
//			s.assertBoundUntilProbability(left, 10, right, 0.3779873847961426 , 0.00001)
			s.assertUntilProbability(left, right, 0.1723399766459277 , 0.000001)
		]
	}
	
	@Test
	def testBrp_N16_M2( ) {
		'''
		// bounded retransmission protocol [D'AJJL01]
		// gxn/dxp 23/05/2001
		
		dtmc
		
		// number of chunks
		const int N = 16;
		// maximum number of retransmissions
		const int MAX = 2;
		
		module sender
		
			s : [0 .. 6];
			// 0 idle
			// 1 next_frame	
			// 2 wait_ack
			// 3 retransmit
			// 4 success
			// 5 error
			// 6 wait sync
			srep : [0 .. 3];
			// 0 bottom
			// 1 not ok (nok)
			// 2 do not know (dk)
			// 3 ok (ok)
			nrtr : [0 .. MAX];
			i : [0 .. N];
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
		
			r : [0 .. 5];
			// 0 new_file
			// 1 fst_safe
			// 2 frame_received
			// 3 frame_reported
			// 4 idle
			// 5 resync
			rrep : [0 .. 4];
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
		
			k : [0 .. 2];
			
			// idle
			[aF] (k=0) -> 0.98 : (k'=1) + 0.02 : (k'=2);
			// sending
			[aG] (k=1) -> (k'=0);
			// lost
			[TO_Msg] (k=2) -> (k'=0);
			
		endmodule
		
		module	channelL
		
			l : [0 .. 2];
			
			// idle
			[aA] (l=0) -> 0.99 : (l'=1) + 0.01 : (l'=2);
			// sending
			[aB] (l=1) -> (l'=0);
			// lost
			[TO_Ack] (l=2) -> (l'=0);
			
		endmodule
		
		rewards
			[aF] i=1 : 1;
		endrewards
		
		stateformula tFormula = { true };						
						
		stateformula success = { s = 5 };
		
		
		'''.compile[			
			val o = getCompiledClass().newInstance
			Assert::assertTrue(o instanceof PrismModel)
			val m = o as PrismModel
			val left = m.getStateFormula("tFormula")
			Assert::assertNotNull(left)
			val right = m.getStateFormula("success")
			Assert::assertNotNull(right)
			val s = m.startState
			Assert::assertNotNull(s)
			s.assertBoundUntilProbability(left, 10, right, 8.000000000000001E-6 , 0.00001)
			s.assertBoundUntilProbability(left, 50, right, 1.8246343729938765E-4 , 0.00001)
			s.assertBoundUntilProbability(left, 100, right, 4.000328422842116E-4 , 0.00001)
			s.assertUntilProbability(left, right, 4.2333330028103487E-4 , 0.00001)
		]
	}

		@Test
	def testBrp_N16_M5( ) {
		'''
		// bounded retransmission protocol [D'AJJL01]
		// gxn/dxp 23/05/2001
		
		dtmc
		
		// number of chunks
		const int N = 16;
		// maximum number of retransmissions
		const int MAX = 5;
		
		module sender
		
			s : [0 .. 6];
			// 0 idle
			// 1 next_frame	
			// 2 wait_ack
			// 3 retransmit
			// 4 success
			// 5 error
			// 6 wait sync
			srep : [0 .. 3];
			// 0 bottom
			// 1 not ok (nok)
			// 2 do not know (dk)
			// 3 ok (ok)
			nrtr : [0 .. MAX];
			i : [0 .. N];
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
		
			r : [0 .. 5];
			// 0 new_file
			// 1 fst_safe
			// 2 frame_received
			// 3 frame_reported
			// 4 idle
			// 5 resync
			rrep : [0 .. 4];
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
		
			k : [0 .. 2];
			
			// idle
			[aF] (k=0) -> 0.98 : (k'=1) + 0.02 : (k'=2);
			// sending
			[aG] (k=1) -> (k'=0);
			// lost
			[TO_Msg] (k=2) -> (k'=0);
			
		endmodule
		
		module	channelL
		
			l : [0 .. 2];
			
			// idle
			[aA] (l=0) -> 0.99 : (l'=1) + 0.01 : (l'=2);
			// sending
			[aB] (l=1) -> (l'=0);
			// lost
			[TO_Ack] (l=2) -> (l'=0);
			
		endmodule
		
		rewards
			[aF] i=1 : 1;
		endrewards
		
		stateformula tFormula = { true };						
						
		stateformula success = { s = 5 };
		
		
		'''.compile[			
			val o = getCompiledClass().newInstance
			Assert::assertTrue(o instanceof PrismModel)
			val m = o as PrismModel
			val left = m.getStateFormula("tFormula")
			Assert::assertNotNull(left)
			val right = m.getStateFormula("success")
			Assert::assertNotNull(right)
			val s = m.startState
			Assert::assertNotNull(s)
//			s.assertBoundUntilProbability(left, 10, right, 0 , 0.00001)
//			s.assertBoundUntilProbability(left, 50, right, 3.935656338253205E-9 , 0.00001)
//			s.assertBoundUntilProbability(left, 100, right, 9.681678106984152E-9 , 0.00001)
			s.assertUntilProbability(left, right, 1.1205136479757483E-8 , 0.00001)
		]
	}
	
			@Test
	def testBrp_N32_M2( ) {
		'''
		// bounded retransmission protocol [D'AJJL01]
		// gxn/dxp 23/05/2001
		
		dtmc
		
		// number of chunks
		const int N = 32;
		// maximum number of retransmissions
		const int MAX = 2;
		
		module sender
		
			s : [0 .. 6];
			// 0 idle
			// 1 next_frame	
			// 2 wait_ack
			// 3 retransmit
			// 4 success
			// 5 error
			// 6 wait sync
			srep : [0 .. 3];
			// 0 bottom
			// 1 not ok (nok)
			// 2 do not know (dk)
			// 3 ok (ok)
			nrtr : [0 .. MAX];
			i : [0 .. N];
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
		
			r : [0 .. 5];
			// 0 new_file
			// 1 fst_safe
			// 2 frame_received
			// 3 frame_reported
			// 4 idle
			// 5 resync
			rrep : [0 .. 4];
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
		
			k : [0 .. 2];
			
			// idle
			[aF] (k=0) -> 0.98 : (k'=1) + 0.02 : (k'=2);
			// sending
			[aG] (k=1) -> (k'=0);
			// lost
			[TO_Msg] (k=2) -> (k'=0);
			
		endmodule
		
		module	channelL
		
			l : [0 .. 2];
			
			// idle
			[aA] (l=0) -> 0.99 : (l'=1) + 0.01 : (l'=2);
			// sending
			[aB] (l=1) -> (l'=0);
			// lost
			[TO_Ack] (l=2) -> (l'=0);
			
		endmodule
		
		rewards
			[aF] i=1 : 1;
		endrewards
		
		stateformula tFormula = { true };						
						
		stateformula success = { s = 5 };
		
		
		'''.compile[			
			val o = getCompiledClass().newInstance
			Assert::assertTrue(o instanceof PrismModel)
			val m = o as PrismModel
			val left = m.getStateFormula("tFormula")
			Assert::assertNotNull(left)
			val right = m.getStateFormula("success")
			Assert::assertNotNull(right)
			val s = m.startState
			Assert::assertNotNull(s)
//			s.assertBoundUntilProbability(left, 10, right, 0 , 0.00001)
//			s.assertBoundUntilProbability(left, 50, right, 3.935656338253205E-9 , 0.00001)
//			s.assertBoundUntilProbability(left, 100, right, 9.681678106984152E-9 , 0.00001)
			s.assertUntilProbability(left, right, 8.464873452387598E-4 , 0.00001)
		]
	}
	
	@Test
	def testBrp_N32_M5( ) {
		'''
		// bounded retransmission protocol [D'AJJL01]
		// gxn/dxp 23/05/2001
		
		dtmc
		
		// number of chunks
		const int N = 32;
		// maximum number of retransmissions
		const int MAX = 4;
		
		module sender
		
			s : [0 .. 6];
			// 0 idle
			// 1 next_frame	
			// 2 wait_ack
			// 3 retransmit
			// 4 success
			// 5 error
			// 6 wait sync
			srep : [0 .. 3];
			// 0 bottom
			// 1 not ok (nok)
			// 2 do not know (dk)
			// 3 ok (ok)
			nrtr : [0 .. MAX];
			i : [0 .. N];
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
		
			r : [0 .. 5];
			// 0 new_file
			// 1 fst_safe
			// 2 frame_received
			// 3 frame_reported
			// 4 idle
			// 5 resync
			rrep : [0 .. 4];
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
		
			k : [0 .. 2];
			
			// idle
			[aF] (k=0) -> 0.98 : (k'=1) + 0.02 : (k'=2);
			// sending
			[aG] (k=1) -> (k'=0);
			// lost
			[TO_Msg] (k=2) -> (k'=0);
			
		endmodule
		
		module	channelL
		
			l : [0 .. 2];
			
			// idle
			[aA] (l=0) -> 0.99 : (l'=1) + 0.01 : (l'=2);
			// sending
			[aB] (l=1) -> (l'=0);
			// lost
			[TO_Ack] (l=2) -> (l'=0);
			
		endmodule
		
		rewards
			[aF] i=1 : 1;
		endrewards
		
		stateformula tFormula = { true };						
						
		stateformula success = { s = 5 };
		
		
		'''.compile[			
			val o = getCompiledClass().newInstance
			Assert::assertTrue(o instanceof PrismModel)
			val m = o as PrismModel
			val left = m.getStateFormula("tFormula")
			Assert::assertNotNull(left)
			val right = m.getStateFormula("success")
			Assert::assertNotNull(right)
			val s = m.startState
			Assert::assertNotNull(s)
//			s.assertBoundUntilProbability(left, 10, right, 0 , 0.00001)
//			s.assertBoundUntilProbability(left, 50, right, 3.935656338253205E-9 , 0.00001)
//			s.assertBoundUntilProbability(left, 100, right, 9.681678106984152E-9 , 0.00001)
			s.assertUntilProbability(left, right, 2.241027583194653E-8 , 0.00001)
		]
	}
	
		@Test
	def testBrp_N64_M5( ) {
		'''
		// bounded retransmission protocol [D'AJJL01]
		// gxn/dxp 23/05/2001
		
		dtmc
		
		// number of chunks
		const int N = 64;
		// maximum number of retransmissions
		const int MAX = 4;
		
		module sender
		
			s : [0 .. 6];
			// 0 idle
			// 1 next_frame	
			// 2 wait_ack
			// 3 retransmit
			// 4 success
			// 5 error
			// 6 wait sync
			srep : [0 .. 3];
			// 0 bottom
			// 1 not ok (nok)
			// 2 do not know (dk)
			// 3 ok (ok)
			nrtr : [0 .. MAX];
			i : [0 .. N];
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
		
			r : [0 .. 5];
			// 0 new_file
			// 1 fst_safe
			// 2 frame_received
			// 3 frame_reported
			// 4 idle
			// 5 resync
			rrep : [0 .. 4];
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
		
			k : [0 .. 2];
			
			// idle
			[aF] (k=0) -> 0.98 : (k'=1) + 0.02 : (k'=2);
			// sending
			[aG] (k=1) -> (k'=0);
			// lost
			[TO_Msg] (k=2) -> (k'=0);
			
		endmodule
		
		module	channelL
		
			l : [0 .. 2];
			
			// idle
			[aA] (l=0) -> 0.99 : (l'=1) + 0.01 : (l'=2);
			// sending
			[aB] (l=1) -> (l'=0);
			// lost
			[TO_Ack] (l=2) -> (l'=0);
			
		endmodule
		
		rewards
			[aF] i=1 : 1;
		endrewards
		
		stateformula tFormula = { true };						
						
		stateformula success = { s = 5 };
		
		
		'''.compile[			
			val o = getCompiledClass().newInstance
			Assert::assertTrue(o instanceof PrismModel)
			val m = o as PrismModel
			val left = m.getStateFormula("tFormula")
			Assert::assertNotNull(left)
			val right = m.getStateFormula("success")
			Assert::assertNotNull(right)
			val s = m.startState
			Assert::assertNotNull(s)
//			s.assertBoundUntilProbability(left, 10, right, 0 , 0.00001)
//			s.assertBoundUntilProbability(left, 50, right, 3.935656338253205E-9 , 0.00001)
//			s.assertBoundUntilProbability(left, 100, right, 9.681678106984152E-9 , 0.00001)
			s.assertUntilProbability(left, right, 4.4820549554973446E-8 , 0.00001)
		]
	}
	
	@Test
	def testCrowds_TR3_CS5( ) {
		'''
// CROWDS [Reiter,Rubin]
// Vitaly Shmatikov, 2002

// Note:
// Change everything marked CWDSIZ when changing the size of the crowd
// Change everything marked CWDMAX when increasing max size of the crowd

dtmc

// Probability of forwarding
const double PF = 0.8;

// Probability that a crowd member is bad
const double  badC = 0.091;
// const double  badC = 0.167;

const int TotalRuns = 2; // Total number of protocol runs to analyze
const int CrowdSize = 20; // CWDSIZ: actual number of good crowd members
const int MaxGood=20; // CWDMAX: maximum number of good crowd members

// Process definitions
module crowds

	// Auxiliary variables
	launch:   bool init true;       // Start modeling?
	new:      bool init false;      // Initialize a new protocol instance?
	runCount: [0..TotalRuns] init TotalRuns;   // Counts protocol instances
	start:    bool init false;      // Start the protocol?
	run:      bool init false;      // Run the protocol?
	lastSeen: [0..MaxGood] init MaxGood;   // Last crowd member to touch msg
	good:     bool init false;      // Crowd member is good?
	bad:      bool init false;      //              ... bad?
	recordLast: bool init false;    // Record last seen crowd member?
	badObserve: bool init false;    // Bad members observes who sent msg?
	deliver:  bool init false;      // Deliver message to destination?
	done:     bool init false;      // Protocol instance finished?

	// Counters for attackers' observations
	// CWDMAX: 1 counter per each good crowd member
	observe0:  [0..TotalRuns] init 0;
	observe1:  [0..TotalRuns] init 0;
	observe2:  [0..TotalRuns] init 0;
	observe3:  [0..TotalRuns] init 0;
	observe4:  [0..TotalRuns] init 0;
	observe5:  [0..TotalRuns] init 0;
	observe6:  [0..TotalRuns] init 0;
	observe7:  [0..TotalRuns] init 0;
	observe8:  [0..TotalRuns] init 0;
	observe9:  [0..TotalRuns] init 0;
	observe10: [0..TotalRuns] init 0;
	observe11: [0..TotalRuns] init 0;
	observe12: [0..TotalRuns] init 0;
	observe13: [0..TotalRuns] init 0;
	observe14: [0..TotalRuns] init 0;
	observe15: [0..TotalRuns] init 0;
	observe16: [0..TotalRuns] init 0;
	observe17: [0..TotalRuns] init 0;
	observe18: [0..TotalRuns] init 0;
	observe19: [0..TotalRuns] init 0;
	
	[] launch -> (new'=true) & (runCount'=TotalRuns) & (launch'=false);
	// Set up a new protocol instance
	[] new & runCount>0 -> (runCount'=runCount-1) & (new'=false) & (start'=true);
	
	// SENDER
	// Start the protocol
	[] start -> (lastSeen'=0) & (run'=true) & (deliver'=false) & (start'=false);
	
	// CROWD MEMBERS
	// Good or bad crowd member?
	[] !good & !bad & !deliver & run ->
	             1-badC : (good'=true) & (recordLast'=true) & (run'=false) +
	               badC : (bad'=true)  & (badObserve'=true) & (run'=false);

	// GOOD MEMBERS
	// Forward with probability PF, else deliver
	[] good & !deliver & run -> PF : (good'=false) + 1-PF : (deliver'=true);
	// Record the last crowd member who touched the msg;
	// all good members may appear with equal probability
	//    Note: This is backward.  In the real protocol, each honest
	//          forwarder randomly chooses the next forwarder.
	//          Here, the identity of an honest forwarder is randomly
	//          chosen *after* it has forwarded the message.
	[] recordLast & CrowdSize=2 ->
	        1/2 : (lastSeen'=0) & (recordLast'=false) & (run'=true) +
	        1/2 : (lastSeen'=1) & (recordLast'=false) & (run'=true);
	[] recordLast & CrowdSize=4 ->
	        1/4 : (lastSeen'=0) & (recordLast'=false) & (run'=true) +
	        1/4 : (lastSeen'=1) & (recordLast'=false) & (run'=true) +
	        1/4 : (lastSeen'=2) & (recordLast'=false) & (run'=true) +
	        1/4 : (lastSeen'=3) & (recordLast'=false) & (run'=true);
	[] recordLast & CrowdSize=5 ->
	        1/5 : (lastSeen'=0) & (recordLast'=false) & (run'=true) +
	        1/5 : (lastSeen'=1) & (recordLast'=false) & (run'=true) +
	        1/5 : (lastSeen'=2) & (recordLast'=false) & (run'=true) +
	        1/5 : (lastSeen'=3) & (recordLast'=false) & (run'=true) +
	        1/5 : (lastSeen'=4) & (recordLast'=false) & (run'=true);
	[] recordLast & CrowdSize=10 ->
	        1/10 : (lastSeen'=0) & (recordLast'=false) & (run'=true) +
	        1/10 : (lastSeen'=1) & (recordLast'=false) & (run'=true) +
	        1/10 : (lastSeen'=2) & (recordLast'=false) & (run'=true) +
	        1/10 : (lastSeen'=3) & (recordLast'=false) & (run'=true) +
	        1/10 : (lastSeen'=4) & (recordLast'=false) & (run'=true) +
	        1/10 : (lastSeen'=5) & (recordLast'=false) & (run'=true) +
	        1/10 : (lastSeen'=6) & (recordLast'=false) & (run'=true) +
	        1/10 : (lastSeen'=7) & (recordLast'=false) & (run'=true) +
	        1/10 : (lastSeen'=8) & (recordLast'=false) & (run'=true) +
	        1/10 : (lastSeen'=9) & (recordLast'=false) & (run'=true);
	[] recordLast & CrowdSize=15 ->
	        1/15 : (lastSeen'=0)  & (recordLast'=false) & (run'=true) +
	        1/15 : (lastSeen'=1)  & (recordLast'=false) & (run'=true) +
	        1/15 : (lastSeen'=2)  & (recordLast'=false) & (run'=true) +
	        1/15 : (lastSeen'=3)  & (recordLast'=false) & (run'=true) +
	        1/15 : (lastSeen'=4)  & (recordLast'=false) & (run'=true) +
	        1/15 : (lastSeen'=5)  & (recordLast'=false) & (run'=true) +
	        1/15 : (lastSeen'=6)  & (recordLast'=false) & (run'=true) +
	        1/15 : (lastSeen'=7)  & (recordLast'=false) & (run'=true) +
	        1/15 : (lastSeen'=8)  & (recordLast'=false) & (run'=true) +
	        1/15 : (lastSeen'=9)  & (recordLast'=false) & (run'=true) +
	        1/15 : (lastSeen'=10) & (recordLast'=false) & (run'=true) +
	        1/15 : (lastSeen'=11) & (recordLast'=false) & (run'=true) +
	        1/15 : (lastSeen'=12) & (recordLast'=false) & (run'=true) +
	        1/15 : (lastSeen'=13) & (recordLast'=false) & (run'=true) +
	        1/15 : (lastSeen'=14) & (recordLast'=false) & (run'=true);
	[] recordLast & CrowdSize=20 ->
	        1/20 : (lastSeen'=0)  & (recordLast'=false) & (run'=true) +
	        1/20 : (lastSeen'=1)  & (recordLast'=false) & (run'=true) +
	        1/20 : (lastSeen'=2)  & (recordLast'=false) & (run'=true) +
	        1/20 : (lastSeen'=3)  & (recordLast'=false) & (run'=true) +
	        1/20 : (lastSeen'=4)  & (recordLast'=false) & (run'=true) +
	        1/20 : (lastSeen'=5)  & (recordLast'=false) & (run'=true) +
	        1/20 : (lastSeen'=6)  & (recordLast'=false) & (run'=true) +
	        1/20 : (lastSeen'=7)  & (recordLast'=false) & (run'=true) +
	        1/20 : (lastSeen'=8)  & (recordLast'=false) & (run'=true) +
	        1/20 : (lastSeen'=9)  & (recordLast'=false) & (run'=true) +
	        1/20 : (lastSeen'=10) & (recordLast'=false) & (run'=true) +
	        1/20 : (lastSeen'=11) & (recordLast'=false) & (run'=true) +
	        1/20 : (lastSeen'=12) & (recordLast'=false) & (run'=true) +
	        1/20 : (lastSeen'=13) & (recordLast'=false) & (run'=true) +
	        1/20 : (lastSeen'=14) & (recordLast'=false) & (run'=true) +
	        1/20 : (lastSeen'=15) & (recordLast'=false) & (run'=true) +
	        1/20 : (lastSeen'=16) & (recordLast'=false) & (run'=true) +
	        1/20 : (lastSeen'=17) & (recordLast'=false) & (run'=true) +
	        1/20 : (lastSeen'=18) & (recordLast'=false) & (run'=true) +
	        1/20 : (lastSeen'=19) & (recordLast'=false) & (run'=true);
	
	// BAD MEMBERS
	// Remember from whom the message was received and deliver
	// CWDMAX: 1 rule per each good crowd member
	[] lastSeen=0  & badObserve & observe0 <TotalRuns -> (observe0' =observe0 +1) & (deliver'=true) & (run'=true) & (badObserve'=false);
	[] lastSeen=1  & badObserve & observe1 <TotalRuns -> (observe1' =observe1 +1) & (deliver'=true) & (run'=true) & (badObserve'=false);
	[] lastSeen=2  & badObserve & observe2 <TotalRuns -> (observe2' =observe2 +1) & (deliver'=true) & (run'=true) & (badObserve'=false);
	[] lastSeen=3  & badObserve & observe3 <TotalRuns -> (observe3' =observe3 +1) & (deliver'=true) & (run'=true) & (badObserve'=false);
	[] lastSeen=4  & badObserve & observe4 <TotalRuns -> (observe4' =observe4 +1) & (deliver'=true) & (run'=true) & (badObserve'=false);
	[] lastSeen=5  & badObserve & observe5 <TotalRuns -> (observe5' =observe5 +1) & (deliver'=true) & (run'=true) & (badObserve'=false);
	[] lastSeen=6  & badObserve & observe6 <TotalRuns -> (observe6' =observe6 +1) & (deliver'=true) & (run'=true) & (badObserve'=false);
	[] lastSeen=7  & badObserve & observe7 <TotalRuns -> (observe7' =observe7 +1) & (deliver'=true) & (run'=true) & (badObserve'=false);
	[] lastSeen=8  & badObserve & observe8 <TotalRuns -> (observe8' =observe8 +1) & (deliver'=true) & (run'=true) & (badObserve'=false);
	[] lastSeen=9  & badObserve & observe9 <TotalRuns -> (observe9' =observe9 +1) & (deliver'=true) & (run'=true) & (badObserve'=false);
	[] lastSeen=10 & badObserve & observe10<TotalRuns -> (observe10'=observe10+1) & (deliver'=true) & (run'=true) & (badObserve'=false);
	[] lastSeen=11 & badObserve & observe11<TotalRuns -> (observe11'=observe11+1) & (deliver'=true) & (run'=true) & (badObserve'=false);
	[] lastSeen=12 & badObserve & observe12<TotalRuns -> (observe12'=observe12+1) & (deliver'=true) & (run'=true) & (badObserve'=false);
	[] lastSeen=13 & badObserve & observe13<TotalRuns -> (observe13'=observe13+1) & (deliver'=true) & (run'=true) & (badObserve'=false);
	[] lastSeen=14 & badObserve & observe14<TotalRuns -> (observe14'=observe14+1) & (deliver'=true) & (run'=true) & (badObserve'=false);
	[] lastSeen=15 & badObserve & observe15<TotalRuns -> (observe15'=observe15+1) & (deliver'=true) & (run'=true) & (badObserve'=false);
	[] lastSeen=16 & badObserve & observe16<TotalRuns -> (observe16'=observe16+1) & (deliver'=true) & (run'=true) & (badObserve'=false);
	[] lastSeen=17 & badObserve & observe17<TotalRuns -> (observe17'=observe17+1) & (deliver'=true) & (run'=true) & (badObserve'=false);
	[] lastSeen=18 & badObserve & observe18<TotalRuns -> (observe18'=observe18+1) & (deliver'=true) & (run'=true) & (badObserve'=false);
	[] lastSeen=19 & badObserve & observe19<TotalRuns -> (observe19'=observe19+1) & (deliver'=true) & (run'=true) & (badObserve'=false);

	// RECIPIENT
	// Delivery to destination
	[] deliver & run -> (done'=true) & (deliver'=false) & (run'=false) & (good'=false) & (bad'=false);
	// Start a new instance
	[] done -> (new'=true) & (done'=false) & (run'=false) & (lastSeen'=MaxGood);
	
endmodule

		stateformula tFormula = { true };						
						
		stateformula success = { observe0 > 1 };

		stateformula ttFormula = { observe1
			+observe2
			+observe3
			+observe4
			+observe5
			+observe6
			+observe7
			+observe8
			+observe9
			+observe10
			+observe11
			+observe12
			+observe13
			+observe14
			+observe15
			+observe16
			+observe17
			+observe18
			+observe19  = 0 };
		
		'''.compile[
			val o = getCompiledClass().newInstance
			Assert::assertTrue(o instanceof PrismModel)
			val m = o as PrismModel
			val left = m.getStateFormula("tFormula")
			Assert::assertNotNull(left)
			val right = m.getStateFormula("success")
			Assert::assertNotNull(right)
			val s = m.startState
			Assert::assertNotNull(s)
//			s.assertBoundUntilProbability(left, 2, right, 0.125 , 0.00001)
//			s.assertBoundUntilProbability(left, 5, right, 0.40625 , 0.00001)
			s.assertBoundUntilProbability(left, 100, right, 0.49462890625 , 0.00001)
//			s.assertUntilProbability(left, right, 0.052962534914338694 , 0.00001)
		]
	}
	
		@Test
	def testSIER3( ) {
		'''
dtmc

const N = 3;

const double alpha_e = 0.1;

const double alpha_i = 0.1;

const double alpha_a = 0.1;

const double alpha_r = 0.1;

const double alpha_s = 0.1;


formula total_s = 
	(s1=0?1:0)
	+(s2=0?1:0)
	+(s3=0?1:0);

formula total_e = 
	(s1=1?1:0)
	+(s2=1?1:0)
	+(s3=1?1:0);

formula total_i = 
	(s1=2?1:0)
	+(s2=2?1:0)
	+(s3=2?1:0);

formula total_r = 
	(s1=3?1:0)
	+(s2=3?1:0)
	+(s3=3?1:0);

module Agent1 
	s1:[0..3];
// s1=0 -> S
// s1=1 -> E
// s1=2 -> I
// s1=3 -> R
[step] (s1=0) -> (alpha_e+(alpha_i*(total_i/N))):(s1'=1) + (1-(alpha_e+(alpha_i*(total_i/N)))):(s1'=0);
[step] (s1=1) -> alpha_a:(s1'=2) + (1-alpha_a):(s1'=1);
[step] (s1=2) -> alpha_r:(s1'=3) + (1-alpha_r):(s1'=2);
[step] (s1=3) -> alpha_s:(s1'=0) + (1-alpha_s):(s1'=3);
endmodule

module Agent2  = Agent1[s1=s2]
endmodule	

module Agent3  = Agent1[s1=s3]
endmodule	
				
				
		stateformula tFormula = { (total_e/7<0.25) & (total_i=0) };						
						
		stateformula success = { s1 = 2  };
		
		
				
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
	}
	
			@Test
	def testSIER5( ) {
		'''
dtmc

const N = 5;

const double alpha_e = 0.1;

const double alpha_i = 0.1;

const double alpha_a = 0.1;

const double alpha_r = 0.1;

const double alpha_s = 0.1;


formula total_s = 
	(s1=0?1:0)
	+(s2=0?1:0)
	+(s3=0?1:0)
	+(s4=0?1:0)
	+(s5=0?1:0);

formula total_e = 
	(s1=1?1:0)
	+(s2=1?1:0)
	+(s3=1?1:0)
	+(s4=1?1:0)
	+(s5=1?1:0);

formula total_i = 
	(s1=2?1:0)
	+(s2=2?1:0)
	+(s3=2?1:0)
	+(s4=2?1:0)
	+(s5=2?1:0);

formula total_r = 
	(s1=3?1:0)
	+(s2=3?1:0)
	+(s3=3?1:0)
	+(s4=3?1:0)
	+(s5=3?1:0);

module Agent1 
	s1:[0..3];
// s1=0 -> S
// s1=1 -> E
// s1=2 -> I
// s1=3 -> R
[step] (s1=0) -> (alpha_e+(alpha_i*(total_i/N))):(s1'=1) + (1-(alpha_e+(alpha_i*(total_i/N)))):(s1'=0);
[step] (s1=1) -> alpha_a:(s1'=2) + (1-alpha_a):(s1'=1);
[step] (s1=2) -> alpha_r:(s1'=3) + (1-alpha_r):(s1'=2);
[step] (s1=3) -> alpha_s:(s1'=0) + (1-alpha_s):(s1'=3);
endmodule

module Agent2  = Agent1[s1=s2]
endmodule	

module Agent3  = Agent1[s1=s3]
endmodule	

module Agent4  = Agent1[s1=s4]
endmodule	

module Agent5  = Agent1[s1=s5]
endmodule	
				
		stateformula tFormula = { (total_e/7<0.25) & (total_i=0) };						
						
		stateformula success = { s1 = 2  };
		
		
				
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
	}
	
			@Test
	def testSIER7( ) {
		'''
dtmc

const N = 10;

const double alpha_e = 0.1;

const double alpha_i = 0.1;

const double alpha_a = 0.1;

const double alpha_r = 0.1;

const double alpha_s = 0.1;


formula total_s = 
	(s1=0?1:0)
	+(s2=0?1:0)
	+(s3=0?1:0)
	+(s4=0?1:0)
	+(s5=0?1:0)
	+(s6=0?1:0)
	+(s7=0?1:0);

formula total_e = 
	(s1=1?1:0)
	+(s2=1?1:0)
	+(s3=1?1:0)
	+(s4=1?1:0)
	+(s5=1?1:0)
	+(s6=1?1:0)
	+(s7=1?1:0);

formula total_i = 
	(s1=2?1:0)
	+(s2=2?1:0)
	+(s3=2?1:0)
	+(s4=2?1:0)
	+(s5=2?1:0)
	+(s6=2?1:0)
	+(s7=2?1:0);

formula total_r = 
	(s1=3?1:0)
	+(s2=3?1:0)
	+(s3=3?1:0)
	+(s4=3?1:0)
	+(s5=3?1:0)
	+(s6=3?1:0)
	+(s7=3?1:0);

module Agent1 
	s1:[0..3];
// s1=0 -> S
// s1=1 -> E
// s1=2 -> I
// s1=3 -> R
[step] (s1=0) -> (alpha_e+(alpha_i*(total_i/N))):(s1'=1) + (1-(alpha_e+(alpha_i*(total_i/N)))):(s1'=0);
[step] (s1=1) -> alpha_a:(s1'=2) + (1-alpha_a):(s1'=1);
[step] (s1=2) -> alpha_r:(s1'=3) + (1-alpha_r):(s1'=2);
[step] (s1=3) -> alpha_s:(s1'=0) + (1-alpha_s):(s1'=3);
endmodule

module Agent2  = Agent1[s1=s2]
endmodule	

module Agent3  = Agent1[s1=s3]
endmodule	

module Agent4  = Agent1[s1=s4]
endmodule	

module Agent5  = Agent1[s1=s5]
endmodule	

module Agent6  = Agent1[s1=s6]
endmodule	

module Agent7  = Agent1[s1=s7]
endmodule				

		stateformula tFormula = { (total_e/7<0.25) & (total_i=0) };						
						
		stateformula success = { s1 = 2  };
		
				
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
	}
	
			@Test
	def testSIER9( ) {
		'''
dtmc

const N = 10;

const double alpha_e = 0.1;

const double alpha_i = 0.1;

const double alpha_a = 0.1;

const double alpha_r = 0.1;

const double alpha_s = 0.1;


formula total_s = 
	(s1=0?1:0)
	+(s2=0?1:0)
	+(s3=0?1:0)
	+(s4=0?1:0)
	+(s5=0?1:0)
	+(s6=0?1:0)
	+(s7=0?1:0)
	+(s8=0?1:0)
	+(s9=0?1:0);
formula total_e = 
	(s1=1?1:0)
	+(s2=1?1:0)
	+(s3=1?1:0)
	+(s4=1?1:0)
	+(s5=1?1:0)
	+(s6=1?1:0)
	+(s7=1?1:0)
	+(s8=1?1:0)
	+(s9=1?1:0);

formula total_i = 
	(s1=2?1:0)
	+(s2=2?1:0)
	+(s3=2?1:0)
	+(s4=2?1:0)
	+(s5=2?1:0)
	+(s6=2?1:0)
	+(s7=2?1:0)
	+(s8=2?1:0)
	+(s9=2?1:0);

formula total_r = 
	(s1=3?1:0)
	+(s2=3?1:0)
	+(s3=3?1:0)
	+(s4=3?1:0)
	+(s5=3?1:0)
	+(s6=3?1:0)
	+(s7=3?1:0)
	+(s8=3?1:0)
	+(s9=3?1:0);

module Agent1 
	s1:[0..3];
// s1=0 -> S
// s1=1 -> E
// s1=2 -> I
// s1=3 -> R
[step] (s1=0) -> (alpha_e+(alpha_i*(total_i/N))):(s1'=1) + (1-(alpha_e+(alpha_i*(total_i/N)))):(s1'=0);
[step] (s1=1) -> alpha_a:(s1'=2) + (1-alpha_a):(s1'=1);
[step] (s1=2) -> alpha_r:(s1'=3) + (1-alpha_r):(s1'=2);
[step] (s1=3) -> alpha_s:(s1'=0) + (1-alpha_s):(s1'=3);
endmodule


module Agent2  = Agent1[s1=s2]
endmodule	

module Agent3  = Agent1[s1=s3]
endmodule	

module Agent4  = Agent1[s1=s4]
endmodule	

module Agent5  = Agent1[s1=s5]
endmodule	

module Agent6  = Agent1[s1=s6]
endmodule	

module Agent7  = Agent1[s1=s7]
endmodule	

module Agent8  = Agent1[s1=s8]
endmodule	

module Agent9  = Agent1[s1=s9]
endmodule	

		stateformula tFormula = { (total_e/9<0.25) & (total_i=0) };						
						
		stateformula success = { s1 = 2  };
		
				
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
	}
	
			@Test
	def testSIER11( ) {
		'''
dtmc

const N = 3;

const double alpha_e = 0.1;

const double alpha_i = 0.1;

const double alpha_a = 0.1;

const double alpha_r = 0.1;

const double alpha_s = 0.1;


formula total_s = 
	(s1=0?1:0)
	+(s2=0?1:0)
	+(s3=0?1:0);

formula total_e = 
	(s1=1?1:0)
	+(s2=1?1:0)
	+(s3=1?1:0);

formula total_i = 
	(s1=2?1:0)
	+(s2=2?1:0)
	+(s3=2?1:0);

formula total_r = 
	(s1=3?1:0)
	+(s2=3?1:0)
	+(s3=3?1:0);

module Agent1 
	s1:[0..3];
// s1=0 -> S
// s1=1 -> E
// s1=2 -> I
// s1=3 -> R
[step] (s1=0) -> (alpha_e+(alpha_i*(total_i/N))):(s1'=1) + (1-(alpha_e+(alpha_i*(total_i/N)))):(s1'=0);
[step] (s1=1) -> alpha_a:(s1'=2) + (1-alpha_a):(s1'=1);
[step] (s1=2) -> alpha_r:(s1'=3) + (1-alpha_r):(s1'=2);
[step] (s1=3) -> alpha_s:(s1'=0) + (1-alpha_s):(s1'=3);
endmodule

module Agent2  = Agent1[s1=s2]
endmodule	

module Agent3  = Agent1[s1=s3]
endmodule	
				
		stateformula tFormula = { (total_i/2<0.25) };						
						
		stateformula success = { s1 = 1  };
		
				
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
	}
}
