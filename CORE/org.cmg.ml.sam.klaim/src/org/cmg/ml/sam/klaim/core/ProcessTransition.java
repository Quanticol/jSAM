/**
 * 
 */
package org.cmg.ml.sam.klaim.core;

import java.util.LinkedList;

/**
 * @author loreti
 *
 */
public class ProcessTransition {

	private LinkedList<Input> pendingInput;
	private LinkedList<Read> pendingRead;
	private LinkedList<Out> pendingOut;
	private LinkedList<Eval> pendingEval;
	private LinkedList<Tick> pendingTick;

	public ProcessTransition() {
		this.pendingEval = new LinkedList<Eval>();
		this.pendingInput = new LinkedList<Input>();
		this.pendingOut = new LinkedList<Out>();
		this.pendingRead = new LinkedList<Read>();
		this.pendingTick = new LinkedList<Tick>();
	}

	public void populateNetTransition( NetTransition t , int idx ) {
		for (Eval e : pendingEval) {
			t.registerEval(idx, e.q, e.rate, e.p, idx);
		}		
		for (Input i : pendingInput) {
			LinkedList<Pair<Tuple, Integer>> tList = t.getTuples(i.t,i.trg);
			for (Pair<Tuple, Integer> p : tList) {
				t.registerInput(idx, p.getFirst(), i.trg, i.rate, i.abs.apply(p.getFirst()), idx);
			}
			if (tList.isEmpty()&& i.isPredicative) {
				t.registerTick(idx, i.fRate, i.fNext, idx);
			}
		}
		for (Out o : pendingOut) {
			t.registerOut(idx, o.t, o.trg, o.rate, o.p, idx);
		}
		for (Read r : pendingRead) {
			LinkedList<Pair<Tuple, Integer>> tList = t.getTuples(r.t,r.trg);
			for (Pair<Tuple, Integer> p : tList) {
				t.registerRead(idx, p.getFirst(), r.trg, r.rate, r.abs.apply(p.getFirst()), idx);
			}
			if (tList.isEmpty()&& r.isPredicative) {
				t.registerTick(idx, r.fRate, r.fNext, idx);
			}
		}
		for (Tick tick : pendingTick) {
			t.registerTick(idx, tick.rate, tick.p, idx);
		}

	}

	public void registerInput( Template t , int trg , double rate , Abstraction abs ) {
		pendingInput.add(new Input(t, trg, rate, abs));
	}

	public void registerInput( Template t , int trg , double rate , Abstraction abs , double fRate , KProcess fNext ) {
		pendingInput.add(new Input(t, trg, rate, abs,true,fRate,fNext));
	}

	public void registerRead( Template t , int trg , double rate , Abstraction abs , boolean isPredicative ) {
		pendingRead.add(new Read(t, trg, rate, abs));
	}

	public void registerRead( Template t , int trg , double rate , Abstraction abs , double fRate , KProcess fNext ) {
		pendingRead.add(new Read(t, trg, rate, abs,true,fRate,fNext));
	}

	public void registerOut( Tuple t , int trg , double rate , KProcess p ) {
		pendingOut.add( new Out(t, trg, rate, p));
	}
	
	public void registerEval( KProcess q , double rate , KProcess p ) {
		pendingEval.add( new Eval(q, rate, p) );
	}
	
	public void registerTick( double rate , KProcess p ) {
		pendingTick.add( new Tick(rate, p));
	}

	public class Input {
		protected Template t;
		protected int trg;
		protected double rate;
		protected Abstraction abs;
		protected boolean isPredicative;
		protected double fRate;
		protected KProcess fNext;

		public Input(Template t, int trg, double rate, Abstraction abs) {
			this(t,trg,rate,abs,false,0.0,null);
		}

		public Input(Template t, int trg, double rate, Abstraction abs,
				boolean isPredicative, double fRate, KProcess fNext) {
			super();
			this.t = t;
			this.trg = trg;
			this.rate = rate;
			this.abs = abs;
			this.isPredicative = isPredicative;
			this.fRate = fRate;
			this.fNext = fNext;
		}
		
	}
	
	public class Read {
		protected Template t;
		protected int trg;
		protected double rate;
		protected Abstraction abs;
		protected boolean isPredicative;
		protected double fRate;
		protected KProcess fNext;

		public Read(Template t, int trg, double rate, Abstraction abs) {
			this(t,trg,rate,abs,false,0.0,null);
		}

		public Read(Template t, int trg, double rate, Abstraction abs,
				boolean isPredicative, double fRate, KProcess fNext) {
			super();
			this.t = t;
			this.trg = trg;
			this.rate = rate;
			this.abs = abs;
			this.isPredicative = isPredicative;
			this.fRate = fRate;
			this.fNext = fNext;
		}
	}
	
	public class Out {
		protected Tuple t;
		protected int trg;
		protected double rate;
		protected KProcess p;

		public Out(Tuple t, int trg, double rate, KProcess p) {
			super();
			this.t = t;
			this.trg = trg;
			this.rate = rate;
			this.p = p;
		}
	}
	
	public class Eval {
		protected KProcess q;
		protected double rate;
		protected KProcess p;

		public Eval(KProcess q, double rate, KProcess p) {
			super();
			this.q = q;
			this.rate = rate;
			this.p = p;
		}
	}

	public class Tick {
		protected double rate;
		protected KProcess p;

		public Tick(double rate, KProcess p) {
			super();
			this.rate = rate;
			this.p = p;
		}
	}
	
}
