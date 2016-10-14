/**
 * 
 */
package org.cmg.ml.sam.klaim.core;

import java.util.Iterator;
import java.util.LinkedList;

import org.cmg.ml.sam.core.Filter;
import org.cmg.ml.sam.core.Operator;
import org.cmg.ml.sam.core.Probability;
import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.WeightedElement;

/**
 * @author loreti
 *
 */
public class NetTransition implements Distribution<Net> {

	private Net start;
	private Probability<Input> pendingInput;
	private Probability<Read> pendingRead;
	private Probability<Out> pendingOut;
	private Probability<Eval> pendingEval;
	private Probability<Tick> pendingTick;

	public NetTransition(Net start) {
		this.pendingEval = new Probability<Eval>();
		this.pendingInput = new Probability<Input>();
		this.pendingOut = new Probability<Out>();
		this.pendingRead = new Probability<Read>();
		this.pendingTick = new Probability<Tick>();
		this.start = start;
	}

	public void registerInput( int src , Tuple t , int trg , double rate , KProcess p , int idx) {
		pendingInput.set(new Input(src , t, trg, p ,idx ),rate);
	}

	public void registerRead( int src , Tuple t , int trg , double rate , KProcess p , int idx ) {
		pendingRead.set(new Read(src, t, trg, p , idx),rate);
	}
	
	public void registerOut( int src , Tuple t , int trg , double rate , KProcess p , int idx ) {
		pendingOut.set( new Out(src,t, trg, p, idx),rate);
	}
	
	public void registerEval( int src, KProcess q , double rate , KProcess p , int idx ) {
		pendingEval.set( new Eval(src, q, p, idx ),rate );
	}
	
	public void registerTick( int src , double rate , KProcess p , int idx ) {
		pendingTick.set( new Tick(src, p, idx ),rate);
	}

	public class Input {
		protected int src;
		protected Tuple t;
		protected int trg;
		protected KProcess p;
		private int idx;

		public Input(int src, Tuple t, int trg , KProcess p, int idx) {
			super();
			this.src = src;
			this.t = t;
			this.trg = trg;
			this.p = p;
			this.idx = idx;
		}
	
		public Net execute() {
			return start.in(t, trg, p, idx);
		}

		@Override
		public String toString() {
			return src+") in("+t+")@"+trg;
		}
				
	}
	
	public class Read {
		protected Tuple t;
		protected int trg;
		protected KProcess p;
		protected int idx;
		protected int src;
		
		public Read(int src, Tuple t, int trg, KProcess p, int idx) {
			super();
			this.src = src;
			this.t = t;
			this.trg = trg;
			this.p = p;
			this.idx = idx;
		}

		public Net execute() {
			return start.execute(p, idx);
		}
	}
	
	public class Out {
		protected Tuple t;
		protected int trg;
		protected KProcess p;
		protected int idx;
		protected int src;

		public Out(int src, Tuple t, int trg , KProcess p, int idx) {
			super();
			this.src = src;
			this.t = t;
			this.trg = trg;
			this.p = p;
			this.idx = idx;
		}
		
		public Net execute() {
			return start.out(t, trg, p, idx);
		}
		
		@Override
		public String toString() {
			return src+") out("+t+")@"+trg;
		}
		
	}
	
	public class Eval {
		protected KProcess q;
		protected KProcess p;
		protected int idx;
		protected int src;

		public Eval(int src, KProcess q , KProcess p, int idx) {
			super();
			this.src = src;
			this.q = q;
			this.p = p;
			this.idx = idx;
		}
		
		public Net execute() {
			return start.eval(q,p,idx);
		}

		@Override
		public String toString() {
			return src+") eval("+q+")";
		}
	}

	public class Tick {
		protected int src;
		protected KProcess p;
		protected int idx;

		public Tick(int src, KProcess p, int idx) {
			super();
			this.src = src;
			this.p = p;
			this.idx = idx;
		}
		
		public Net execute() {
			return start.execute(p, idx);
		}

		@Override
		public String toString() {
			return src+") tick";
		}
	}

	@Override
	public Iterator<WeightedElement<Net>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return pendingInput.size()+pendingEval.size()+pendingOut.size()+pendingRead.size()+pendingTick.size();
	}

	@Override
	public WeightedElement<Net> get(int i) {
		int foo = i;
		if (foo< pendingEval.size()) {
			WeightedElement<Eval> w = pendingEval.get(foo);
			return new WeightedElement<Net>(w.getElement().execute(), w.getWeight());
		}
		foo -= pendingEval.size();
		if (foo< pendingInput.size()) {
			WeightedElement<Input> w = pendingInput.get(foo);
			return new WeightedElement<Net>(w.getElement().execute(), w.getWeight());
		}
		foo -= pendingInput.size();
		if (foo< pendingOut.size()) {
			WeightedElement<Out> w = pendingOut.get(foo);
			return new WeightedElement<Net>(w.getElement().execute(), w.getWeight());
		}
		foo -= pendingOut.size();
		if (foo< pendingRead.size()) {
			WeightedElement<Read> w = pendingRead.get(foo);
			return new WeightedElement<Net>(w.getElement().execute(), w.getWeight());
		}
		foo -= pendingRead.size();
		if (foo< pendingTick.size()) {
			WeightedElement<Tick> w = pendingTick.get(foo);
			return new WeightedElement<Net>(w.getElement().execute(), w.getWeight());
		}
		throw new IndexOutOfBoundsException();
	}

	@Override
	public Net select(double p) {
		double foo = getTotalWeight()*p;
		if (foo < pendingEval.getTotalWeight()) {
			return pendingEval.select(foo/pendingEval.getTotalWeight()).execute();
		}
		foo -= pendingEval.getTotalWeight();
		if (foo < pendingInput.getTotalWeight()) {
			return pendingInput.select(foo/pendingInput.getTotalWeight()).execute();
		}
		foo -= pendingInput.getTotalWeight();
		if (foo < pendingOut.getTotalWeight()) {
			return pendingOut.select(foo/pendingOut.getTotalWeight()).execute();
		}
		foo -= pendingOut.getTotalWeight();
		if (foo < pendingRead.getTotalWeight()) {
			return pendingRead.select(foo/pendingRead.getTotalWeight()).execute();
		}
		foo -= pendingRead.getTotalWeight();
		if (foo < pendingTick.getTotalWeight()) {
			return pendingTick.select(foo/pendingTick.getTotalWeight()).execute();
		}
		return start;
	}

	@Override
	public double getTotalWeight() {
		return pendingInput.getTotalWeight()+pendingEval.getTotalWeight()+pendingOut.getTotalWeight()+pendingRead.getTotalWeight()+pendingTick.getTotalWeight();
	}

	@Override
	public <S> Distribution<S> apply(Operator<Net, S> op) {
		//FIXME: Remove this method!
		return null;
	}

	@Override
	public Distribution<Net> filter(Filter<Net> f) {
		//FIXME: Remove this method!
		return null;
	}

	public LinkedList<Pair<Tuple, Integer>> getTuples(Template t, int trg) {
		return start.getTuples(t,trg);
	}

	@Override
	public void renormalize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renormalize(double v) {
		// TODO Auto-generated method stub
		
	}
	
}
