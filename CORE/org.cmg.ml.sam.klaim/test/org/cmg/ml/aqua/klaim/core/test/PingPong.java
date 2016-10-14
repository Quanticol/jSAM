/**
 * 
 */
package org.cmg.ml.aqua.klaim.core.test;

import java.util.Random;

import org.cmg.ml.sam.klaim.core.Abstraction;
import org.cmg.ml.sam.klaim.core.ActualField;
import org.cmg.ml.sam.klaim.core.AllocationEnvironment;
import org.cmg.ml.sam.klaim.core.FormalField;
import org.cmg.ml.sam.klaim.core.KInteger;
import org.cmg.ml.sam.klaim.core.KProcess;
import org.cmg.ml.sam.klaim.core.KValue;
import org.cmg.ml.sam.klaim.core.Net;
import org.cmg.ml.sam.klaim.core.NetTransition;
import org.cmg.ml.sam.klaim.core.ProcessTransition;
import org.cmg.ml.sam.klaim.core.Template;
import org.cmg.ml.sam.klaim.core.Tuple;

/**
 * @author loreti
 *
 */
public class PingPong {

	public static class Ping extends KProcess {
		
		@Override
		public String toString() {
			return "Ping";
		}

		ProcessTransition pt;

		public Ping(int locality, AllocationEnvironment e) {
			super(locality, e);
		}

		@Override
		public ProcessTransition getNext() {
			if (pt == null) {
				pt = new ProcessTransition();
				pt.registerOut(new Tuple(new KInteger(0)), 0, 1.0, this);
			}
			return pt;
		}

		@Override
		public KProcess copy() {
			return this;
		}
		
	}
	
	public static class Pong extends KProcess {

		ProcessTransition pt;

		@Override
		public String toString() {
			return "Pong";
		}


		public Pong(int locality, AllocationEnvironment e) {
			super(locality, e);
		}

		@Override
		public ProcessTransition getNext() {
			if (pt == null) {
				pt = new ProcessTransition();
				pt.registerInput( new Template( new ActualField( new KInteger(0))), 0, 5.0, new Abstraction() {
					
					@Override
					public KProcess apply(Tuple t) {
						return Pong.this;
					}
					
				});
			}
			return pt;
		}


		@Override
		public KProcess copy() {
			return this;
		}
		
		
		
	}
	
	public static void main(String[] argv) {
		Net n = new Net();
		int l = n.addLocality();
		Pong pong = new Pong(l, n.getAllocationEnvironment(l));
		Ping ping = new Ping(l, n.getAllocationEnvironment(l));
		n = n.add(pong);
		n = n.add(ping);
		Random r = new Random();
		double time = 0.0;
		boolean exit = true;
		while (exit&&(time < 20000)) {
			System.out.println(n.toString()+"\n\n");
			NetTransition nt = n.getNext();
			double p1 = r.nextDouble();
			double p2 = r.nextDouble();
			n = nt.select(p1);
			double dt = (1/nt.getTotalWeight())*Math.log(1/p2); 
			time += dt;
			System.out.println("["+nt.getTotalWeight()+"] "+dt+" -> "+time+"\n\n");
			
		}
	}
	
	
	
}
