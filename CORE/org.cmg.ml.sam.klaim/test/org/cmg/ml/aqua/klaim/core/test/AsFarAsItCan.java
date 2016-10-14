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
import org.cmg.ml.sam.klaim.core.KString;
import org.cmg.ml.sam.klaim.core.KType;
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
public class AsFarAsItCan {

	public static int SELF = 0;
	public static int NEXT = 1;
	public static int RG = 2;
	
	public static int SIZE = 200;
	
	public static class Start extends KProcess {

		ProcessTransition pt;
		
		@Override
		public String toString() {
			return "("+locality+") Start[]";
		}

		public Start(int locality, AllocationEnvironment ae) {
			super(locality, ae);
		}

		@Override
		public ProcessTransition getNext() {
			if (pt == null) {
				pt = new ProcessTransition();
				pt.registerInput(new Template(new FormalField(KType.integerType)), ae.eval(RG), 1.0, new Abstraction() {
					
					@Override
					public KProcess apply(Tuple t) {
						return new Ready(locality,ae,t.getIntegerAt(0));
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
	
	public static class Ready extends KProcess {
		
		ProcessTransition pt;
		private KInteger id;

		@Override
		public String toString() {
			return "("+locality+") Ready[id="+id+"]";
		}
		
		public Ready(int locality, AllocationEnvironment e, KInteger kInteger) {
			super(locality, e);
			this.id = kInteger;
		}

		@Override
		public ProcessTransition getNext() {
			if (pt == null) {
				pt = new ProcessTransition();
				pt.registerOut(new Tuple(id), ae.eval(NEXT), 1.0, new Waiting(locality,ae,id));
			}
			return pt;
		}

		@Override
		public KProcess copy() {
			return this;
		}
	}
	
	public static class Waiting extends KProcess {

		private KInteger id;
		private ProcessTransition pt;

		@Override
		public String toString() {
			return "("+locality+") Waiting[id="+id+"]";
		}

		public Waiting(int locality, AllocationEnvironment e, KInteger id) {
			super(locality, e);
			this.id = id;
		}

		@Override
		public ProcessTransition getNext() {
			if (pt == null) {
				pt = new ProcessTransition();
				pt.registerInput(new Template(new FormalField(KType.integerType)), ae.eval(SELF), 1.0, new Abstraction() {
					
					@Override
					public KProcess apply(Tuple t) {
						return check(t.getIntegerAt(0));
					}
					
					private KProcess check(KInteger received) {
						int foo = id.compareTo(received);
						if (foo<0) {
							return new Forward(locality, ae, received);
						}
						if (foo==0) {
							return new Leader(locality, ae);
						}
						return Waiting.this;
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
	
	public static class Follower extends KProcess {

		private ProcessTransition pt;

		@Override
		public String toString() {
			return "("+locality+") Follower[]";
		}

		public Follower(int locality, AllocationEnvironment e) {
			super(locality, e);
		}

		@Override
		public ProcessTransition getNext() {
			if (pt == null) {
				pt = new ProcessTransition();
				pt.registerInput(new Template(new FormalField(KType.integerType)), ae.eval(SELF), 1.0, new Abstraction() {
					
					@Override
					public KProcess apply(Tuple t) {
						return check(t.getIntegerAt(0));
					}
					
					private KProcess check(KInteger received) {
						return new Forward(locality, ae, received);
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

	public static class Forward extends KProcess {

		private KInteger next;
		private ProcessTransition pt;
		
		@Override
		public String toString() {
			return "("+locality+") Forward[msd="+next+"]";
		}


		public Forward(int locality, AllocationEnvironment e, KInteger next) {
			super(locality, e);
			this.next = next;
		}

		@Override
		public ProcessTransition getNext() {
			if (pt == null) {
				pt = new ProcessTransition();
				pt.registerOut(new Tuple(next), ae.eval(NEXT), 1.0, new Follower(locality,ae));
			}
			return pt;
		}


		@Override
		public KProcess copy() {
			return this;
		}
		
	}
	
	public static class Leader extends KProcess {

		private ProcessTransition pt;

		@Override
		public String toString() {
			return "("+locality+") Leader[]";
		}


		public Leader(int locality, AllocationEnvironment e) {
			super(locality, e);
		}

		@Override
		public ProcessTransition getNext() {
			if (pt == null) {
				pt = new ProcessTransition();
				pt.registerOut(new Tuple(new KString("LEADER")), ae.eval(SELF), 1.0, new Remover(locality,ae));
			}
			return pt;
		}


		@Override
		public KProcess copy() {
			return this;
		}
		
	}
	
	public static class Remover extends KProcess {

		private ProcessTransition pt;

		@Override
		public String toString() {
			return "("+locality+") Remover[]";
		}

		public Remover(int locality, AllocationEnvironment e) {
			super(locality, e);
		}

		@Override
		public ProcessTransition getNext() {
			if (pt == null) {
				pt = new ProcessTransition();
				pt.registerInput(new Template(new FormalField(KType.integerType)), ae.eval(SELF), 1.0, new Abstraction() {
					
					@Override
					public KProcess apply(Tuple t) {
						return Remover.this;
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
		Net n = new Net(SIZE+1);
		for (int i=0 ; i<SIZE ; i++ ) {
			int[] map = { i , (i+1)%SIZE , SIZE };
			n.setAllocationEnvironment(i,new AllocationEnvironment(map));
		}
		n.addLocality(SIZE,new AllocationEnvironment());
		for (int i=0 ; i<SIZE ; i++ ) {
			n.addTuple( new Tuple(new KInteger(i)),SIZE);
		}
		for (int i=0 ; i<SIZE ; i++ ) {
			n = n.add( new Start(i, n.getAllocationEnvironment(i)));
		}
		Random r = new Random();
		double time = 0.0;
		boolean exit = true;
		long startTime = System.currentTimeMillis();
		while (exit&&(time < 20000)) {
//			System.out.println(n.toString()+"\n\n");
			NetTransition nt = n.getNext();
			if (nt.getTotalWeight()>0) {
				double p1 = r.nextDouble();
				double p2 = r.nextDouble();
				n = nt.select(p1);
				double dt = (1/nt.getTotalWeight())*Math.log(1/p2); 
				time += dt;
			} else {
				exit = false;
			}
//			System.out.println("["+nt.getTotalWeight()+"] "+dt+" -> "+time+"\n\n");		
		}
		long endTime = System.currentTimeMillis();
		System.out.println(n.toString());
		System.out.println("Time: "+time);
		System.out.println("Execution time: "+(endTime-startTime));
	}
	
	
	
}
