package org.cmg.ml.sam.klaim.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import org.apache.commons.math3.random.RandomGenerator;
import org.cmg.ml.sam.core.StochasticState;
import org.cmg.ml.sam.core.WeightedElement;

/**
 * This class identifies a Klaim net.
 * 
 * @author loreti
 *
 */
public class Net implements StochasticState<Net> {
	
	/**
	 * This field stores the allocation environments associated to
	 * each locality: <code>env.get(i)</code> is
	 * the allocation environment of locality <code>i</code>.
	 */
	protected Vector<AllocationEnvironment> env;
	
	/**
	 * This data structure contains nodes' tuple spaces: <code>ts.get(i)</code>
	 * is the tuple space located at <code>i</code>.
	 */
	protected Vector<TupleSpace> ts;
	
	/**
	 * Identifies the set of processes running on the net. Each running
	 * process is univocally identified by its index. 
	 */
	protected ArrayList<KProcess> procs;

	/**
	 * Creates an empty net.
	 */
	public Net() {
		this( new Vector<AllocationEnvironment>() , new Vector<TupleSpace>() , new ArrayList<KProcess>());
	}
	
	/**
	 * Creates a new net.
	 * 
	 * @param env nodes allocation environments
	 * @param ts  nodes tuple spaces
	 * @param procs	running processes
	 */
	public Net(Vector<AllocationEnvironment> env,
			Vector<TupleSpace> ts, ArrayList<KProcess> procs) {
		this.env = env;
		this.ts = ts;
		this.procs = procs;
	}
	
	public Net(int size) {
		this( new Vector<AllocationEnvironment>(size) , new Vector<TupleSpace>(size) , new ArrayList<KProcess>());
		ts.setSize(size);
		env.setSize(size);
		for( int i=0 ; i<ts.size() ; i++ ) {
			ts.set(i, new TupleSpace());
		}
	}

	/**
	 * Returns a new net where tuple <code>t</code> is removed from the tuple space located at <code>i</code>,
	 * and where process with index <code>j</code> is replaced by <code>p</code>. If <code>p</code> is
	 * <code>null</code>, process with index <code>j</code> is removed. This method throws a <code>TupleNotFoundException</code> 
	 * if the tuple space located at <code>i</code> does not contain tuple <code>t</code>.
	 * 
	 * @param t the tuple to remove
	 * @param i index of locality of tuple space that contains the tuple to remove.
	 * @param p new process to run
	 * @param j process index of new process
	 * @return a new net where tuple <code>t</code> i removed from tuple space located at <code>i</code>,
	 *         and where process with index <code>j</code> is replaced by <code>p</code>. 
	 */
	public Net in( Tuple t , int i , KProcess p , int j) {
		@SuppressWarnings("unchecked")
		Vector<TupleSpace> newTs = (Vector<TupleSpace>) ts.clone();
		TupleSpace lTs = newTs.get(i);
		newTs.set(i, lTs.getTuple(t));
		@SuppressWarnings("unchecked")
		ArrayList<KProcess> newProcs = (ArrayList<KProcess>) procs.clone();
		if (p==null) {
			newProcs.remove(j);
		} else {
			newProcs.set(j, p);
		}
		return new Net( env , newTs , newProcs );
	}
	
	/**
	 * Returns a new net where tuple <code>t</code> is inserted in the tuple space located at <code>i</code>,
	 * and where process with index <code>j</code> is replaced by <code>p</code>. If <code>p</code> is
	 * <code>null</code>, process with index <code>j</code> is removed. 
	 * 
	 * @param t the tuple to add
	 * @param i index of locality of tuple space that contains the tuple to remove.
	 * @param p new process to run
	 * @param j process index of new process
	 * @return a new net where tuple <code>t</code> i removed from tuple space located at <code>i</code>,
	 *         and where process with index <code>j</code> is replaced by <code>p</code>. 
	 */
	public Net out( Tuple t , int i , KProcess p , int j ) {
		@SuppressWarnings("unchecked")
		Vector<TupleSpace> newTs = (Vector<TupleSpace>) ts.clone();
		TupleSpace lTs = newTs.get(i);
		newTs.set(i, lTs.addTuple(t));
		@SuppressWarnings("unchecked")
		ArrayList<KProcess> newProcs = (ArrayList<KProcess>) procs.clone();
		if (p==null) {
			newProcs.remove(j);
		} else {
			newProcs.set(j, p);
		}
		return new Net( env , newTs , newProcs );
	}
	
	/**
	 * Returns a new net where process with index <code>j</code> is replaced by <code>p</code>. If <code>p</code> is
	 * <code>null</code>, process with index <code>j</code> is removed. 
	 * 
	 * @param p new process to run
	 * @param j process index of new process
	 * @return a new net where process with index <code>j</code> is replaced by <code>p</code>. 
	 */
	public Net execute( KProcess p , int j ) {
		@SuppressWarnings("unchecked")
		ArrayList<KProcess> newProcs = (ArrayList<KProcess>) procs.clone();
		if (p == null) {
			newProcs.remove(j);
		} else {
			newProcs.set(j, p);
		}
		return new Net( env , ts , newProcs );	
	}
	
	/**
	 * Returns a new net where process <code>p</code> is executed (a new index is generate).
	 * 
	 * @param p new process to run
	 * @return returns a new net where process <code>p</code> is executed (a new index is generate). 
	 */
	public Net add( KProcess p ) {
		if (p==null) {
			return this;
		}
		@SuppressWarnings("unchecked")
		ArrayList<KProcess> newProcs = (ArrayList<KProcess>) procs.clone();
		newProcs.add(p);
		return new Net( env , ts , newProcs );			
	}

	
	/**
	 * Returns a new net where process <code>q</code> is evaluated (a new index is generate) and
	 * process with index <code>idx</code> is replaced by <code>p</code>.
	 * 
	 * @param p new process to run
	 * @param p new process to run
	 * @return a new net where process <code>q</code> is evaluated (a new index is generate) and
	 * process with index <code>idx</code> is replaced by <code>p</code>.
	 */
	public Net eval(KProcess q, KProcess p, int idx) {
		@SuppressWarnings("unchecked")
		ArrayList<KProcess> newProcs = (ArrayList<KProcess>) procs.clone();
		if (p == null) {
			newProcs.remove(idx);
		} else {
			newProcs.set(idx, p);
		}
		if (q != null) {
			newProcs.add(q);
		}
		return new Net( env , ts , newProcs );	
	}

	public LinkedList<Pair<Tuple, Integer>> getTuples(Template t, int trg) {
		return ts.get(trg).getTuples(t);
	}

	public int addLocality() {
		return addLocality( new AllocationEnvironment() );
	}

	private int addLocality(AllocationEnvironment ae) {
		int lIndex = env.size();
		ae.set(AllocationEnvironment.SELF, lIndex);
		env.add(ae);
		ts.add(new TupleSpace());
		return lIndex;
	}

	public AllocationEnvironment getAllocationEnvironment(int l) {
		return env.get(l);
	}

	public NetTransition getNext() {
		NetTransition nt = new NetTransition(this);
		for (int i=0 ; i<procs.size() ; i++ ) {
			procs.get(i).getNext().populateNetTransition(nt, i);
		}
		return nt;
	}

	@Override
	public String toString() {
		String toReturn = "";
		for (int i = 0; i < ts.size(); i++) {
			LinkedList<Pair<Tuple, Integer>> tuples = ts.get(i).getTuples();
			if (!tuples.isEmpty()) {
				toReturn += "Tuple space at: "+i+"\n";
				for (Pair<Tuple, Integer> pair : tuples) {
					toReturn += pair.getFirst().toString()+" ";
					if (pair.getSecond()>1) {
						toReturn += " ( "+pair.getSecond()+" ) ";
					}
					toReturn += "\n";
				}
			}
		}
		toReturn += procs.toString();
 		return toReturn;
	}

	public void addLocality(int i, AllocationEnvironment allocationEnvironment) {
		env.ensureCapacity(i+10);
		ts.ensureCapacity(i+10);
		env.add(i, allocationEnvironment);
		ts.add(i,new TupleSpace());
	}

	public void addTuple(Tuple tuple, int l) {
		ts.set(l, ts.get(l).addTuple(tuple));
	}

	public void setAllocationEnvironment(int i,
			AllocationEnvironment ae) {
		env.set(i, ae);
	}

	@Override
	public int compareTo(Net arg0) {
		//FIXME!
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Net copy() {
		Vector<TupleSpace> copyTs = (Vector<TupleSpace>) ts.clone();
		ArrayList<KProcess> copyProcs = (ArrayList<KProcess>) procs.clone();
		return new Net(env, copyTs, copyProcs);
	}	
	
	public int getNumberOfMatchingTuple( Template t , int locality ) {
		return ts.get(locality).getNumberOfMatchingTuple(t);
	}
	
	public int getNumberOfMatchingTuple( Template t ) {
		int count = 0;
		for( int i=0 ; i<ts.size() ; i++ ) {
			count += ts.get(i).getNumberOfMatchingTuple(t);
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	public Net removeTuple(Tuple t, int locality) {
		Vector<TupleSpace> copyTs = (Vector<TupleSpace>) ts.clone();
		ArrayList<KProcess> copyProcs = (ArrayList<KProcess>) procs.clone();
		copyTs.set(locality, copyTs.get(locality).getTuple(t));
		return new Net(env, copyTs, copyProcs);
	}

	public WeightedElement<Net> getNext(RandomGenerator r) {
		NetTransition next = this.getNext();
		if ((next==null)||(next.getTotalWeight()==0)) {
			return null;
		}
		Net n = next.select(r.nextDouble());
		return new WeightedElement<Net>(n, (1/next.getTotalWeight())*Math.log( r.nextDouble()) );
	}
	
}
