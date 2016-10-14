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

@InjectWith(typeof(PrismInjectorProvider))
@RunWith(typeof(XtextRunner))
class TestParser {
	
	@Inject
	ParseHelper<Model> parser
	
	@Inject extension ValidationTestHelper
	
	OnTheFlyJavaCompiler compiler = new OnTheFlyJavaCompiler();

	
	@Test
	def void testFirstExample() {
		var m = parser.parse(
		'''
			mdp

			module M1
			
			    x : [0 .. 2] init 2;
			
			    [] x=0 -> 0.8:(x'=0) + 0.2:(x'=1);
			    [] x=1 & y!=2 -> (x'=2);
			    [] x=2 -> 0.5:(x'=2) + 0.5:(x'=0);
			
			endmodule
			
			module M2
			
			    y : [0 .. 2] init 2;
			
			    [] y=0 -> 0.8:(y'=0) + 0.2:(y'=1);
			    [] y=1 & x!=2 -> (y'=2);
			    [] y=2 -> 0.5:(y'=2) + 0.5:(y'=0);
			
			endmodule
		'''
		)		
		m.assertNoErrors
		var prismCompiler = new PrismCompiler(compiler)
		var model = prismCompiler.compile( m )
		var state = model.startState
		var time = 0.0;
		var rg = new DefaultRandomGenerator();
		while (time < 100) {
			println(time+": "+state)
			state = state.getNext().select(rg.nextDouble)
			time = time+1;
		}
	}
		
	@Test
	def void testSecondExample() {
		var m = parser.parse(
		'''
			ctmc
			
			const int N = 10;
			const double mu = 1/10;
			const double lambda = 1/2;
			const double gamma = 1/3;
			
			module queue
			     q : [0..N];
			
			     [] q<N -> mu:(q'=q+1);
			     [] q=N -> mu:(q'=q);
			     [serve] q>0 -> lambda:(q'=q-1);
			endmodule
			
			module server
			     s : [0..1];
			
			     [serve] s=0 -> 1:(s'=1);
			     [] s=1 -> gamma:(s'=0);
			endmodule
		'''
		)
		m.assertNoErrors
		var prismCompiler = new PrismCompiler(compiler)
		prismCompiler.compile( m )
	}
	
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
		'''
		)
		m.assertNoErrors
		var prismCompiler = new PrismCompiler(compiler)
		var model = prismCompiler.compile( m )
		var state = model.startState
		var time = 0.0;
		var rg = new DefaultRandomGenerator();
		while (time < 100) {
			println(time+": "+state)
			state = state.getNext().select(rg.nextDouble)
			time = time+1;
		}
	}
	
	@Test
	def void testHerman() {
		var m = parser.parse(
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
		'''
		)
		m.assertNoErrors
		var prismCompiler = new PrismCompiler(compiler)
		prismCompiler.compile( m )
	}

	@Test
	def void testTwoProcessesTestAndSet() {
		var m = parser.parse(
		'''
		// randomized two process wait-free test-and-set [TV02]
		// gxn/dxp 12/07/02
		
		mdp
		
		// tester process
		module tester
		
			t : [0..1];
		
			[] t=0 -> (t'=1); // start test
		
		endmodule
		
		
		// process 0
		module proc0
			
			// local states
			l0 : [0..10];
			// 0  - rst	
			// 1  - me
			// 2  - not me
			// 3  - choose
			// 4  - to me
			// 5  - to he
			// 6  - he
			// 7  - not he
			// 8  - tst0
			// 9  - tst1
			// 10 - free
		
			// shared variable owned by process 0
			R0 : [0..3];
			// 0 - rst
			// 1 - choose
			// 2 - he
			// 3 - me
			
			// rst
			[p0] l0=0 -> (R0'=3) & (l0'=1);
			// me
			[p0] l0=1 & R1=3  -> (l0'=2);
			[p0] l0=1 & !R1=3 -> (l0'=8); // finished and test not started
			// not me
			[p0] l0=2 -> (R0'=1) & (l0'=3);
			// choose
			[p0] l0=3 & R1=2 -> (l0'=4); // R1=he
			[p0] l0=3 & R1=1 -> 0.5 : (l0'=4) + 0.5 : (l0'=5);  // R1=choose 
			[p0] l0=3 & !(R1=2 | R1=1) -> (l0'=5); // otherwise
			// to me
			[p0] l0=4 -> (R0'=3) & (l0'=1);
			// to he
			[p0] l0=5 -> (R0'=2) & (l0'=6);
			// he
			[p0] l0=6 & R1=2  -> (l0'=7);
			[p0] l0=6 & !R1=2 -> (l0'=9); // finished and test not started
			// not he
			[p0] l0=7 -> (R0'=1) & (l0'=3);
			// tst0 (removed transitions once test starts as only looking at one test and set operation)
			[p0] t=0 & l0=8 -> (R0'=0) & (l0'=0);
			// tst1 (removed transitions once test starts as only looking at one test and set operation)
			[p0] t=0 & l0=9 & !R1=0 -> (l0'=9); // R1 not rst
			[p0] t=0 & l0=9 & R1=0 -> (l0'=10); // R1 equals rst
			// free
			[p0] l0=10 -> (R0'=3) & (l0'=1);
		
		endmodule  
		
		// construct process 1 through renaming
		module proc1=proc0[l0=l1,R0=R1,R1=R0,p0=p1] endmodule
		
		// rewards
		rewards "process0" // reads/writes by process 0 (all transitions of process 0 require one access)
			[p0] t=1 : 1;
		endrewards
		rewards "process1" // reads/writes by process 1 (all transitions of process 1 require one access)
			[p1] t=1 : 1;
		endrewards
		'''
		)
		m.assertNoErrors
		var prismCompiler = new PrismCompiler(compiler)
		prismCompiler.compile( m )

	}
	
	@Test
	def void testSynchronousLeaderElection() {
		var m = parser.parse(
		'''
		// synchronous leader election protocol (itai & Rodeh)
		// dxp/gxn 25/01/01
		// N=4 and K=8
		
		dtmc
		
		// CONSTANTS
		const int N=4; // number of processes
		const int K=8; // range of probabilistic choice
		
		// counter module used to count the number of processes that have been read
		// and to know when a process has decided
		module counter
			
			// counter 
			c : [1..N-1];
			
			// reading
			[read] c<N-1 -> (c'=c+1);
			// finished reading
			[read] c=N-1 -> (c'=c);
			//done
			[done] u1 | u2 | u3 | u4 -> (c'=c);
			// pick again reset counter 
			[retry] !(u1 | u2 | u3 | u4) -> (c'=1);
			// loop (when finished to avoid deadlocks)
			[loop] s1=3 -> (c'=c);
			
		endmodule
		
		//  processes form a ring and suppose:
		// process 1 reads process 2
		// process 2 reads process 3
		// process 3 reads process 1
		module process1
			
			// local state
			s1 : [0..3];
			// s1=0 make random choice
			// s1=1 reading
			// s1=2 deciding
			// s1=3 finished
			
			// has a unique id so far (initially true)
			u1 : bool;
			
			// value to be sent to next process in the ring (initially sets this to its own value)
			v1 : [0..K-1];
			
			// random choice
			p1 : [0..K-1];
			
			// pick value
			[pick] s1=0 -> 1/K : (s1'=1) & (p1'=0) & (v1'=0) & (u1'=true)
			             + 1/K : (s1'=1) & (p1'=1) & (v1'=1) & (u1'=true)
			             + 1/K : (s1'=1) & (p1'=2) & (v1'=2) & (u1'=true)
			             + 1/K : (s1'=1) & (p1'=3) & (v1'=3) & (u1'=true)
			             + 1/K : (s1'=1) & (p1'=4) & (v1'=4) & (u1'=true)
			             + 1/K : (s1'=1) & (p1'=5) & (v1'=5) & (u1'=true)
			             + 1/K : (s1'=1) & (p1'=6) & (v1'=6) & (u1'=true)
			             + 1/K : (s1'=1) & (p1'=7) & (v1'=7) & (u1'=true);
			// read
			[read] s1=1 &  u1 & !p1=v2 & c<N-1 -> (u1'=true) & (v1'=v2);
			[read] s1=1 &  u1 &  p1=v2 & c<N-1 -> (u1'=false) & (v1'=v2) & (p1'=0);
			[read] s1=1 & !u1 &  c<N-1 -> (u1'=false) & (v1'=v2);
			// read and move to decide
			[read] s1=1 &  u1 & !p1=v2 & c=N-1 -> (s1'=2) & (u1'=true) & (v1'=0) & (p1'=0);
			[read] s1=1 &  u1 &  p1=v2 & c=N-1 -> (s1'=2) & (u1'=false) & (v1'=0) & (p1'=0);
			[read] s1=1 & !u1 &  c=N-1 -> (s1'=2) & (u1'=false) & (v1'=0);
			// done
			[done] s1=2 -> (s1'=3) & (u1'=false) & (v1'=0) & (p1'=0);
			//retry
			[retry] s1=2 -> (s1'=0) & (u1'=false) & (v1'=0) & (p1'=0);
			// loop (when finished to avoid deadlocks)
			[loop] s1=3 -> (s1'=3);
			
		endmodule
		
		// construct remaining processes through renaming
		module process2=process1[s1=s2,p1=p2,v1=v2,u1=u2,v2=v3] endmodule
		module process3=process1[s1=s3,p1=p3,v1=v3,u1=u3,v2=v4] endmodule
		module process4=process1[s1=s4,p1=p4,v1=v4,u1=u4,v2=v1] endmodule
		'''
		)
		m.assertNoErrors
		var prismCompiler = new PrismCompiler(compiler)
		prismCompiler.compile( m )
	}

	@Test
	def void testAsynchronousLeaderElection() {
		var m = parser.parse(
		'''
	// asynchronous leader election
	// 4 processes
	// gxn/dxp 29/01/01
	
	mdp
	
	const int N=4; // number of processes
	
	module process1
		
		// COUNTER
		c1 : [0..N-1];
		
		// STATES
		s1 : [0..4];
		// 0  make choice
		// 1 have not received neighbours choice
		// 2 active
		// 3 inactive
		// 4 leader
		
		// PREFERENCE
		p1 : [0..1];
		
		// VARIABLES FOR SENDING AND RECEIVING
		receive1 : [0..2];
		// not received anything
		// received choice
		// received counter
		sent1 : [0..2];
		// not send anything
		// sent choice
		// sent counter
		
		// pick value
		[] (s1=0) -> 0.5 : (s1'=1) & (p1'=0) + 0.5 : (s1'=1) & (p1'=1);
		
		// send preference
		[p12] (s1=1) & (sent1=0) -> (sent1'=1);
		// receive preference
		// stay active
		[p41] (s1=1) & (receive1=0) & !( (p1=0) & (p4=1) ) -> (s1'=2) & (receive1'=1);
		// become inactive
		[p41] (s1=1) & (receive1=0) & (p1=0) & (p4=1) -> (s1'=3) & (receive1'=1);
		
		// send preference (can now reset preference)
		[p12] (s1=2) & (sent1=0) -> (sent1'=1) & (p1'=0);
		// send counter (already sent preference)
		// not received counter yet
		[c12] (s1=2) & (sent1=1) & (receive1=1) -> (sent1'=2);
		// received counter (pick again)
		[c12] (s1=2) & (sent1=1) & (receive1=2) -> (s1'=0) & (p1'=0) & (c1'=0) & (sent1'=0) & (receive1'=0);
		
		// receive counter and not sent yet (note in this case do not pass it on as will send own counter)
		[c41] (s1=2) & (receive1=1) & (sent1<2) -> (receive1'=2);
		// receive counter and sent counter
		// only active process (decide)
		[c41] (s1=2) & (receive1=1) & (sent1=2) & (c4=N-1) -> (s1'=4) & (p1'=0) & (c1'=0) & (sent1'=0) & (receive1'=0);
		// other active process (pick again)
		[c41] (s1=2) & (receive1=1) & (sent1=2) & (c4<N-1) -> (s1'=0) & (p1'=0) & (c1'=0) & (sent1'=0) & (receive1'=0);
		
		// send preference (must have received preference) and can now reset
		[p12] (s1=3) & (receive1>0) & (sent1=0) -> (sent1'=1) & (p1'=0);
		// send counter (must have received counter first) and can now reset
		[c12] (s1=3) & (receive1=2) & (sent1=1) ->  (s1'=3) & (p1'=0) & (c1'=0) & (sent1'=0) & (receive1'=0);
		
		// receive preference
		[p41] (s1=3) & (receive1=0) -> (p1'=p4) & (receive1'=1);
		// receive counter
		[c41] (s1=3) & (receive1=1) & (c4<N-1) -> (c1'=c4+1) & (receive1'=2);
			
		// done
		[done] (s1=4) -> (s1'=s1);
		// add loop for processes who are inactive
		[done] (s1=3) -> (s1'=s1);
	
	endmodule
	
	module process2=process1[s1=s2,p1=p2,c1=c2,sent1=sent2,receive1=receive2,p12=p23,p41=p12,c12=c23,c41=c12,p4=p1,c4=c1] endmodule
	module process3=process1[s1=s3,p1=p3,c1=c3,sent1=sent3,receive1=receive3,p12=p34,p41=p23,c12=c34,c41=c23,p4=p2,c4=c2] endmodule
	module process4=process1[s1=s4,p1=p4,c1=c4,sent1=sent4,receive1=receive4,p12=p41,p41=p34,c12=c41,c41=c34,p4=p3,c4=c3] endmodule
	
	// reward - expected number of rounds (equals the number of times a process receives a counter)
	rewards "rounds"
		[c12] true : 1;
	endrewards
		'''
		)
		m.assertNoErrors
		var prismCompiler = new PrismCompiler(compiler)
		prismCompiler.compile( m )	
	}
	
	@Test
	def void testRandomizedSigningContracts() {
		var m = parser.parse(
		'''
		// Randomized Protocol for Signing Contracts [Even, Goldreich and Lempel 1985]
		// Gethin Norman and Vitaly Shmatikov 2004
		
		dtmc
		
		// CONSTANTS
		const int N=5; // number of pairs of secrets
		const int L=2; // number of bits in each secret
		
		// FORMULE
		// B knows a pair of secrets
		formula kB = ( (a0=L & a5=L)
					 | (a1=L & a6=L)
					 | (a2=L & a7=L)
					 | (a3=L & a8=L)
					 | (a4=L & a9=L));
		// A knows a pair of secrets
		formula kA = ( (b0=L & b5=L)
					 | (b1=L & b6=L)
					 | (b2=L & b7=L)
					 | (b3=L & b8=L)
					 | (b4=L & b9=L));
		
		module protocol
			
			b : [1..L]; // counter for current bit to be send
			n : [0..N-1]; // counter for which secret to send
			phase : [1..4]; // phase of the protocol
			// 1 - sending secrets using OT (step 1 of the protocol)
			// 2 - send bits of the secrets 0,...,N-1 (step 2 of the protocol)
			// 3 - send bits of the secrets N,...,2N-1 (step 2 of the protocol)
			party : [1..2]; // which party sends next (1 - A and 2 - B)
			
			// STEP 1 
			// A sends
			[receiveB] phase=1 & party=1 -> (party'=2);
			 // B sends and we move onto the next secret
			[receiveA] phase=1 & party=2 & n<N-1 -> (party'=1) & (n'=n+1);
			// B sends and finished this step
			[receiveA] phase=1 & party=2 & n=N-1 -> (party'=1) & (phase'=2) & (n'=0);
			// STEP 2 (A sends)
			// next secret
			[receiveB] phase=2|phase=3 & party=1 & n<N-1-> (n'=n+1);
			// move onto secrets N,...,2N-1	
			[receiveB] phase=2 & party=1 & n=N-1 -> (phase'=3) & (n'=0);
			// move onto party B
			[receiveB] phase=3 & party=1 & n=N-1 -> (phase'=2) & (party'=2) & (n'=0);
			// STEP 2 (B sends)
			// next secret
			[receiveA] phase=2|phase=3 & party=2 & n<N-1 -> (n'=n+1);
			// move onto secrets N,...,2N-1	
			[receiveA] phase=2 & party=2 & n=N-1 -> (phase'=3) & (n'=0);
			 // move onto next bit
			[receiveA] phase=3 & party=2 & n=N-1 & b<L 
			-> (phase'=2) & (party'=1) & (n'=0) & (b'=b+1);
			// finished protocol
			[receiveA] phase=3 & party=2 & n=N-1 & b=L -> (phase'=4);
			// FINISHED
			[] phase=4 -> (phase'=4); // loop
			
		endmodule
		
		module partyA
			
			// bi the number of bits of B's ith secret A knows 
			// (keep pairs of secrets together to give a more structured model)
			b0 : [0..L]; b5 : [0..L];
			b1 : [0..L]; b6 : [0..L];
			b2 : [0..L]; b7 : [0..L];
			b3 : [0..L]; b8 : [0..L];
			b4 : [0..L]; b9 : [0..L];
			
			// first step (get either secret i or (N-1)+i with equal probability)
			[receiveA] phase=1 & n=0 -> 0.5 : (b0'=L) + 0.5 : (b5'=L);
			[receiveA] phase=1 & n=1 -> 0.5 : (b1'=L) + 0.5 : (b6'=L);
			[receiveA] phase=1 & n=2 -> 0.5 : (b2'=L) + 0.5 : (b7'=L);
			[receiveA] phase=1 & n=3 -> 0.5 : (b3'=L) + 0.5 : (b8'=L);
			[receiveA] phase=1 & n=4 -> 0.5 : (b4'=L) + 0.5 : (b9'=L);
			// second step (secrets 0,...,N-1)
			[receiveA] phase=2 & n=0 -> (b0'=min(b0+1,L));
			[receiveA] phase=2 & n=1 -> (b1'=min(b1+1,L));
			[receiveA] phase=2 & n=2 -> (b2'=min(b2+1,L));
			[receiveA] phase=2 & n=3 -> (b3'=min(b3+1,L));
			[receiveA] phase=2 & n=4 -> (b4'=min(b4+1,L));
			// second step (secrets N,...,2N-1)
			[receiveA] phase=3 & n=0 -> (b5'=min(b5+1,L));
			[receiveA] phase=3 & n=1 -> (b6'=min(b6+1,L));
			[receiveA] phase=3 & n=2 -> (b7'=min(b7+1,L));
			[receiveA] phase=3 & n=3 -> (b8'=min(b8+1,L));
			[receiveA] phase=3 & n=4 -> (b9'=min(b9+1,L));
			
		endmodule
		
		// construct module for party B through renaming
		module partyB=partyA[b0=a0,b1=a1,
		                     b2=a2,b3=a3,
		                     b4=a4,b5=a5,
		                     b6=a6,b7=a7,
		                     b8=a8,b9=a9,
		                     receiveA=receiveB]
		endmodule
		'''
		)
		m.assertNoErrors
		var prismCompiler = new PrismCompiler(compiler)
		prismCompiler.compile( m )
		
	}

	@Test
	def void testProbabilisticBroadcast() {
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

		'''
		)
		m.assertNoErrors
		var prismCompiler = new PrismCompiler(compiler)
		prismCompiler.compile( m )

	}

	@Test
	def void testParametricStep() {
		var m = parser.parse(
		'''
		dtmc
		
		module M1
					
			x : [1 .. 6] init 1;
				
			[] x=1 -> (1/2):(x'=1) + (1/2):(x'=x+1);	
			[] (x>1)&(x<6) -> (1/x):(x'=x) + (1-(1/x)):(x'=x+1);
			[] x=6 -> (1/x):(x'=x) + (1-(1/x)):(x'=1);
		endmodule

		'''
		)
		m.assertNoErrors
		var prismCompiler = new PrismCompiler(compiler)
		prismCompiler.compile( m )
	
	}	
	
}