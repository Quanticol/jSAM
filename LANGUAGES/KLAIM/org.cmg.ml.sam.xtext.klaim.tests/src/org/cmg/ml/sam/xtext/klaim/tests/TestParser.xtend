package org.cmg.ml.sam.xtext.klaim.tests

import com.google.inject.Inject
import java.util.HashMap
import java.util.Map
import org.cmg.ml.sam.core.sim.Measure
import org.cmg.ml.sam.klaim.core.Net
import org.cmg.ml.sam.klaim.sim.KlaimSimulator
import org.cmg.ml.sam.xtext.klaim.KlaimInjectorProvider
import org.cmg.ml.sam.xtext.klaim.klaim.Model
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(KlaimInjectorProvider))
@RunWith(typeof(XtextRunner))
class TestParser {
	
	private static String classOutputFolder = "/tmp";
	
	
	@Inject
	ParseHelper<Model> parser
	
	@Inject extension ValidationTestHelper
	
	
	@Test
	def void testIsDeadlock() {
//		var generator = new JavaClassGenerator();
		var m = parser.parse(
		'''
		node test;
		
		process Process() {
			in( "TEST" )@self:1.0;	
		}

		net:
			test::Process()
		
		'''
		)
		m.assertNoErrors
//		var code = generator.getCode(m); 
//		print(code)
//		var net = compileAndLoad(code);
//        simulate( net , 100 )
    }
	
	@Test
	def void testWhileTrueOut() {
//		var generator = new JavaClassGenerator();
		var m = parser.parse(
		'''
		node test;
		
		process Process() {
			while (true) {
				out( "TEST" )@self:1.0;	
			}
		}

		formula testFormula = true;

		net:
			test::Process()
		
		'''
		)
		m.assertNoErrors
//		var code = generator.getCode(m); 
//		print(code)
//		var net = compileAndLoad(code);
//        simulate( net , 100 )
 //		var c = ClassLoader::systemClassLoader.loadClass("ThisIsATest.KlaimSystem")
//		var o = c.newInstance as KlaimSpecification
//		simulate(o.startNet, 100);
	}

	@Test
	def void testWhileTrueIn() {
//		var generator = new JavaClassGenerator();
		var m = parser.parse(
		'''
		node test;
		
		process Process() {
			int x = 0;
			while (true) {
				in( ?x )@self:1.0;	
				out( x+1 )@self:1.0;
			}
		}

		net:
			test::Process()||test::[ 0 ]
		
		'''
		)
		m.assertNoErrors
//		var code = generator.getCode(m); 
//		print(code)
//		var sourceFiles = new LinkedList<JavaObjectFromString>();
//		sourceFiles.add( new JavaObjectFromString("KlaimSystem",code.toString) );
//		var compiler = ToolProvider::systemJavaCompiler;
//		var options = Arrays::asList("-d", classOutputFolder);
//		var res = compiler.getTask(null,null,null,options,null,sourceFiles).call();
//		assertTrue( "Compilation simple test:",res );		
//        // Convert File to a URL
//		var url = new URL( "file://"+classOutputFolder+"/");
//		var urls = new LinkedList<URL>();
//		urls.add(url)
//            // Create a new class loader with the directory
//            var loader = new URLClassLoader( urls );
// 
//            // Load in the class; Class.childclass should be located in
//            // the directory file:/class/demo/
//            var thisClass = loader.loadClass("KlaimSystem");
// 
//            var o = thisClass.newInstance();
//            assertTrue( o instanceof KlaimSpecification )
//            var spec = o as KlaimSpecification
//            var net = spec.startNet
//            assertNotNull( net )
//            simulate( net , 100 )
 //		var c = ClassLoader::systemClassLoader.loadClass("ThisIsATest.KlaimSystem")
//		var o = c.newInstance as KlaimSpecification
//		simulate(o.startNet, 100);
	}
	
		@Test
	def void testWhileConInOut() {
//		var generator = new JavaClassGenerator();
		var m = parser.parse(
		'''
		node test;
		
		process Process() {
			int x = 0;
			while (x<2) {
				in( ?x )@self:1.0;	
				out( x+1 )@self:1.0;
			}
		}

		net:
			test::Process()||test::[ 0 ]
		
		'''
		)
		m.assertNoErrors
//		var code = generator.getCode(m); 
//		print(code)
//		var sourceFiles = new LinkedList<JavaObjectFromString>();
//		sourceFiles.add( new JavaObjectFromString("KlaimSystem",code.toString) );
//		var compiler = ToolProvider::systemJavaCompiler;
//		var options = Arrays::asList("-d", classOutputFolder);
//		var res = compiler.getTask(null,null,null,options,null,sourceFiles).call();
//		assertTrue( "Compilation simple test:",res );		
//        // Convert File to a URL
//		var url = new URL( "file://"+classOutputFolder+"/");
//		var urls = new LinkedList<URL>();
//		urls.add(url)
//            // Create a new class loader with the directory
//            var loader = new URLClassLoader( urls );
// 
//            // Load in the class; Class.childclass should be located in
//            // the directory file:/class/demo/
//            var thisClass = loader.loadClass("KlaimSystem");
// 
//            var o = thisClass.newInstance();
//            assertTrue( o instanceof KlaimSpecification )
//            var spec = o as KlaimSpecification
//            var net = spec.startNet
//            assertNotNull( net )
//            simulate( net , 10 )
 //		var c = ClassLoader::systemClassLoader.loadClass("ThisIsATest.KlaimSystem")
//		var o = c.newInstance as KlaimSpecification
//		simulate(o.startNet, 100);
	}
	
	@Test
	def void testPingPong() {
//		var generator = new JavaClassGenerator();
		var m = parser.parse(
		'''
		node ping;
		node pong;
		
		process Ping() {
			out( 0 )@pong:1.0;
			in( 1 )@self:1.0;
			Ping();
		}

		process Pong() {
			in( 0 )@self:1.0;
			out( 1 )@ping:1.0;
			Pong();
		}

		net:
			ping::Ping() || pong::Pong()
		
		'''
		)
		m.assertNoErrors
//		var code = generator.getCode(m); 
//		print(code)
//		var sourceFiles = new LinkedList<JavaObjectFromString>();
//		sourceFiles.add( new JavaObjectFromString("KlaimSystem",code.toString) );
//		var compiler = ToolProvider::systemJavaCompiler;
//		var options = Arrays::asList("-d", classOutputFolder);
//		var res = compiler.getTask(null,null,null,options,null,sourceFiles).call();
//		assertTrue( "Compilation simple test:",res );		
//        // Convert File to a URL
//		var url = new URL( "file://"+classOutputFolder+"/");
//		var urls = new LinkedList<URL>();
//		urls.add(url)
//            // Create a new class loader with the directory
//            var loader = new URLClassLoader( urls );
// 
//            // Load in the class; Class.childclass should be located in
//            // the directory file:/class/demo/
//            var thisClass = loader.loadClass("KlaimSystem");
// 
//            var o = thisClass.newInstance();
//            assertTrue( o instanceof KlaimSpecification )
//            var spec = o as KlaimSpecification
//            var net = spec.startNet
//            assertNotNull( net )
//            simulate( net , 100 )
 //		var c = ClassLoader::systemClassLoader.loadClass("ThisIsATest.KlaimSystem")
//		var o = c.newInstance as KlaimSpecification
//		simulate(o.startNet, 100);
	}
	
	@Test
	def void testAsFarAsItCan() {
//		var generator = new JavaClassGenerator();
		var m = parser.parse(
			'''
			logical next;

			node rg;
			node n1 environment { next -> n2 };
			node n2 environment { next -> n3 };
			node n3 environment { next -> n1 };

			process Participant() {
				int id;
				in( ?id )@rg:1.0;
				out( id )@next:1.0;
				int received = id+1;
				while ( received > id ) {
					in( ?received )@self:1.0;
				}
				if (received<id) {
					out( received )@next:1.0;
					out( "FOLLOWER" )@self:1.0;
					Follower();
				} else {
					out( "LEADER" )@rg:1.0;
					Remover();
				}
			}
			
			process Follower() {
				int x;
				while (true) {
					in( ?x )@self:1.0;
					out( x )@next:1.0;
				}
			}
			
			process Remover() {
				int x;
				while (true) {
					in( ?x )@self:1.0;
				}	
			}
			
			measure leader = select t=[ "LEADER" ]@* in t;
			measure follower = select t=[ "FOLLOWER" ]@* in t;
			measure total = select t_follower=[ "FOLLOWER" ]@* 
							and t_leader=[ "LEADER" ]@* in t_follower+t_leader;
			
			formula test1 = true;
			formula test2 = false;
			formula test3 = [ 1 ]@rg -> true;
			
			net:
				rg::[ 1 ] || rg::[ 2 ] || rg::[ 3 ]
				|| n1::Participant() || n2::Participant() || n3::Participant()
						
			'''
		)
				m.assertNoErrors
//		var code = generator.getCode(m); 
//		print(code)
//		var sourceFiles = new LinkedList<JavaObjectFromString>();
//		sourceFiles.add( new JavaObjectFromString("KlaimSystem",code.toString) );
//		var compiler = ToolProvider::systemJavaCompiler;
//		var options = Arrays::asList("-d", classOutputFolder);
//		var res = compiler.getTask(null,null,null,options,null,sourceFiles).call();
//		assertTrue( "Compilation simple test:",res );		
//        // Convert File to a URL
//		var url = new URL( "file://"+classOutputFolder+"/");
//		var urls = new LinkedList<URL>();
//		urls.add(url)
//            // Create a new class loader with the directory
//            var loader = new URLClassLoader( urls );
// 
//            // Load in the class; Class.childclass should be located in
//            // the directory file:/class/demo/
//            var thisClass = loader.loadClass("KlaimSystem");
// 
//            var o = thisClass.newInstance();
//            assertTrue( o instanceof KlaimSpecification )
//            var spec = o as KlaimSpecification
//            var net = spec.startNet
//            assertNotNull( net )
//            var smc = new StatisticalModelChecekr();
//            assertFalse(spec.stateFormulae.get("test2").accept(smc,net));
//            assertTrue(spec.stateFormulae.get("test3").accept(smc,net));
//            simulate( spec.measures , net , 100 )
	}
	
	@Test
	def void testCodeGeneration() {
//		var generator = new JavaClassGenerator();
		var m = parser.parse(
		'''
		node test;
		node testbis;
		
		logical atesr;
		
		rate pippo = 0.35;
		
		function bool testFunction( bool x , int s , locality l ) {
			if (x) {
				s = s+3;
			} 				
			return x;
		}

		process testProcess( ) {
			out( 2+3 )@self:pippo;
			eval( testProcess( ) )@self:pippo;
		}

		net: test::[ 1 ]
		'''
		)
		m.assertNoErrors
//		var code = generator.getCode(m); 
//		print(code)
//		var sourceFiles = new LinkedList<JavaObjectFromString>();
//		sourceFiles.add( new JavaObjectFromString("KlaimSystem",code.toString) );
//		var compiler = ToolProvider::systemJavaCompiler;
//		var res = compiler.getTask(null,null,null,null,null,sourceFiles).call();
//		assertTrue( "Compilation PingPong:",res );
	}

	def simulate( Net start , double limit ) {
		simulate( new HashMap<String,Measure<Net>>() , start , limit )
	}
	
	def simulate( Map<String,Measure<Net>> measures , Net start , double limit ) {
//		var r = new Random()
//		var time = 0.0;
//		var exit = true;
//		print("\n\n\nSTART\n\n\n")
//		while (exit&&(time < limit)) {
//			print("\n\nTime: "+time+"\n")
//			print(n.toString()+"\n\n")
//			print("MEASURES\n")
//			for (m:measures.values) {
//				print(m.name+": "+m.measure(n)+"\n");	
//			}
//			print("END MEASURES\n\n")
//			var nt = n.getNext();
//			var p1 = r.nextDouble();
//			var p2 = r.nextDouble();
//			n = nt.select(p1);
//			var tw = nt.getTotalWeight()
//			if (tw != 0) {
//				var dt = (1/nt.getTotalWeight())*Math::log(1/p2); 
//				time = time + dt;
//				print("["+nt.getTotalWeight()+"] "+dt+" -> "+time+"\n\n******\n\n\n");			
//			} else {
//				print("DEADLOCK!")
//				exit = false;
//			}
//		}
		var simulator = new KlaimSimulator(start,measures);
		var data = simulator.simulate(100,0.1,limit);
		var t = 0.0;
		do {
			print("TIME "+t+"\n");
			print(data.get(t)+"\n");
			t = t+0.1
		} while (t<limit);
	}
	
//	def compileAndLoad( CharSequence code ) {
//				var sourceFiles = new LinkedList<JavaObjectFromString>();
//		sourceFiles.add( new JavaObjectFromString("KlaimSystem",code.toString) );
//		var compiler = ToolProvider::systemJavaCompiler;
//		var options = Arrays::asList("-d", classOutputFolder);
//		var res = compiler.getTask(null,null,null,options,null,sourceFiles).call();
//		assertTrue( "Compilation simple test:",res );		
//        // Convert File to a URL
//		var url = new URL( "file://"+classOutputFolder+"/");
//		var urls = new LinkedList<URL>();
//		urls.add(url)
//            // Create a new class loader with the directory
//            var loader = new URLClassLoader( urls );
// 
//            // Load in the class; Class.childclass should be located in
//            // the directory file:/class/demo/
//            var thisClass = loader.loadClass("KlaimSystem");
// 
//            var o = thisClass.newInstance();
//            assertTrue( o instanceof KlaimSpecification )
//            var spec = o as KlaimSpecification
//            var net = spec.startNet
//            assertNotNull( net )
//		net
//	}
}