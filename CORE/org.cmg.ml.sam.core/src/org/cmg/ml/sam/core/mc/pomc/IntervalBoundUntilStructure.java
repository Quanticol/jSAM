/*
 * Michele Loreti, Concurrency and Mobility Group
 * Universit� di Firenze, Italy
 * (C) Copyright 2013.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Michele Loreti
 */
package org.cmg.ml.sam.core.mc.pomc;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import org.cmg.ml.sam.core.StochasticState;
import org.cmg.ml.sam.core.Predicate;
import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.WeightedElement;


/**
 * This data structure is devoted to store the (partial) DTMC 
 * discovered in the expansion phases of the model-checking algorithm.
 * Moreover, the class provides efficient mechanism for computing
 * transient probabilities.
 * 
 * 
 * @author loreti
 *
 */
public class IntervalBoundUntilStructure<T extends StochasticState<T>> implements UntilStructure<T>{

	private Predicate<T> left;
	private Predicate<T> right;
	
	private LinkedList<Node> pending;
	private LinkedList<Node> active;
	
	private LinkedList<Node> yesNode;
	
	public int maxDegree = 0;
	
	public int edges = 0;
	
	/**
	 * Labels are used to identify the role of each node in the 
	 * computation.
	 * 
	 * @author loreti
	 *
	 */
	public enum Label {
		YES ,       /** Identifies a node satisfying the formula with probability <code>1</code>     */
		NO ,        /** Identifies a node satisfying the formula with probability <code>0</code>     */
		UNKNOWN , 	/** Identifies a node whose probabilities are under computation                  */
		COMPUTED ,  /** Identifies a node for which we have already computed paths probability       */
	}
	
	/**
	 * A collection containing all the nodes
	 */
	private HashMap<T,Node> all;
	
	private int intervalLowerBound;

	private int intervalUpperBound;

	/**
	 * Initializes an empty structure
	 */
	public IntervalBoundUntilStructure(Predicate<T> left, int limit , Predicate<T> right) {
		all = new HashMap<T,Node>();
		pending = new LinkedList<Node>();
		active = new LinkedList<Node>();
		yesNode = new LinkedList<Node>();
		this.left = left;
		this.right = right;
		this.intervalUpperBound = limit;
	}

	/**
	 * Returns the probability of all the paths starting from t
	 * that eventually reach a state satisfying predicate <code>right</code>
	 * while only traversing states satisfying predicate <code>left</code>.
	 * 
	 * @param t 
	 * @return
	 */
	public double getProbability( T t ) {
		long time = System.currentTimeMillis();
		long start = time;
		Node tNode = getAndCreateNode( t );
		if ((tNode.satRight&&(intervalLowerBound<tNode.nodeLevel))||
				(tNode.satLeft)) {
			pending.add(tNode);
		}
		expand();
		long foo = System.currentTimeMillis();
		System.out.println("Expand Time ("+all.size()+"): "+(foo-time));
		System.out.println("All size: "+all.size());
		System.out.println("Active size: "+active.size());
		time = foo;
		compute();
		foo = System.currentTimeMillis();
		System.out.println("Edges: "+edges);
		System.out.println("Compute Time: "+(foo-time));
		System.out.println("Total Time: "+(foo-start));		
		System.out.println("Max degree: "+maxDegree);
		return tNode.getProbability(intervalUpperBound);
	}


	private void compute() {
		for (Node n : yesNode) {
			active.addAll(n.getPrevious());
		}
		for( int i=1 ; i<=intervalUpperBound ; i++ ) {
//			if (i%50==0) {
//				System.out.println(i+" --> Actve: "+active.size());
//			}
			LinkedList<Node> foo = active;
			active = new LinkedList<IntervalBoundUntilStructure<T>.Node>();
			for (Node n : foo) {
				n.compute(i);
				for (Node p: n.getPrevious()) {
					if (p.enable(i+1)) {
						active.add(p);
					}
				}
			}			
		}
	}

	/**
	 * Expand the reachability graph.
	 */
	private void expand() {
		int k = intervalUpperBound;
		while ( ( k < intervalUpperBound ) && ( !pending.isEmpty() ) ) {
			LinkedList<Node> foo = pending;
			pending = new LinkedList<Node>();
			for (Node n : foo) {
				n.expand(k);
			}
			k--;
		}
		pending = new LinkedList<Node>();
	}

	/**
	 * Retrieves the node associated to element <code>t</code>. In the case
	 * this node does not exist, a new element is created.
	 * 
	 * @param t an element
	 * @return  the node associated to <code>t</code>
	 */
	private Node getAndCreateNode( T t ) {
		Node foo = getNode(t);
		if (foo==null) {
			foo = create( t );
		} else {
			pending.add(foo);
		}
		return foo;
	}
	
	/**
	 * Retrieves the node associated to <code>t</code>
	 * 
	 * @param t an element
	 * @return  the node associated to <code>t</code>
	 */
	private Node getNode(T t) {
		return all.get(t);
	}

	/**
	 * This is a private method used to create the node associated
	 * to element <code>t</code>. Notice that we assume that 
	 * when the method is invoked <code>all.get(t)</code> returns
	 * <code>null</code>.
	 * 
	 * PRECONDITION: all.get(t)==null
	 * 
	 * @param t element
	 * @return  a new node associated to t
	 */
	private Node create( T t ) {
		Node n = new Node(t,left.sat(t),right.sat(t));
		all.put(t, n);
			pending.add(n);
		if (n.satRight) {
			yesNode.add(n);
		}
		return n;
	}
	
	/**
	 * This class is associated to each DTCM node. 
	 * 
	 * @author loreti
	 *
	 */
	public class Node {
				
		
		/**
		 * The element associated to the current node
		 */
		private T element;
		
		private boolean satLeft;
		
		private boolean satRight;
		
		/**
		 * Exit probability distribution 
		 */
		private LinkedList<WeightedElement<Node>> next;

		/**
		 * 
		 */
		private HashSet<Node> previous;
		
		/**
		 * Temporary array
		 */
		private double[] p;

		private int nodeLevel = -1;
		
		/**
		 * Self-loop probability.
		 */
		private double selfLoop;

		private int enabledFor = -1;

		/**
		 * Creates a node with label <code>label<code> and element <code>element</code>.
		 * 
		 * @param element node element
		 * @param label	  node label
		 */
		private Node( T element , boolean satLeft , boolean satRight ) {
			this.satLeft = satLeft;
			this.satLeft = satLeft;
			this.satRight = satRight;
			this.element = element;
			this.previous = new HashSet<Node>();
//			if (label==Label.COMPUTED) {
			p = new double[2];
//			}
			this.nodeLevel = 0;
		}
		
		public boolean enable(int i) {
			if (enabledFor  == i) {
				return false;
			}
			enabledFor = i;
			return true;
		}

		public HashSet<Node> getPrevious() {
			return previous;
		}

		private void compute(int i) {
			double foo = selfLoop*p[(i-1)%2];
			for (WeightedElement<Node> w : next) {
				foo += w.getWeight()*w.getElement().getProbability(i-1);
			}
			p[i%2] = foo;
		}

		public double getProbability(int i) {
			if (satRight&&(intervalLowerBound<=i)&&(i<=intervalUpperBound)) {
				return 1;
			}
			if (satLeft&&i>0) {
				return p[i%2];
			}
			return 0;
		}


		@Override
		public String toString() {
			return element.toString()+":"+Arrays.toString(p)+"\n";
		}

		@Override
		public boolean equals(Object arg0) {
			if (arg0 instanceof IntervalBoundUntilStructure<?>.Node) {
				return element.equals(((IntervalBoundUntilStructure<?>.Node) arg0 ).element);
			}
			return false;
		}

		@Override
		public int hashCode() {
			return element.hashCode();
		}
		
		/**
		 * This method is invoked when a node has to be expanded. 
		 * 
		 * PRECONDITION: <code>this.status==Label.SUSPENDED</code>
		 * 
		 */
		private void expand( int level ) {
//			if (p != null) {
//				this.p[0] = 0.0;
//				this.p[1] = 0.0;
//			}
			if (level <= nodeLevel) {
				return ;
			}
			nodeLevel = level;
			if (next == null) {
				next = new LinkedList<WeightedElement<Node>>();
				Distribution<T> step = element.getNext();
				if (maxDegree < step.size()) {
					maxDegree = step.size();
				}
				if (step.size() == 0) {
					//status = Label.NO;
					p = null;
					return ;
				}
				for (WeightedElement<T> t : step ) {
					edges++;
					//The node associated to term t is retrieved.
					Node n = getAndCreateNode(t.getElement() );
					if (n == this) {
						selfLoop += t.getWeight();
						previous.add(this);
					} else {
						next.add(new WeightedElement<Node>(n,t.getWeight()));
						n.addPrevius(this);
					}
				}
//				active.add(this);
			} else {
				if (nodeLevel>0) {
					for (WeightedElement<Node> wn : next) {
						wn.getElement().expand(nodeLevel-1);
					}
				}
			}
		}

		private void addPrevius(Node node) {
			this.previous.add(node);
		}

	}


	@Override
	public String toString() {
		return "Node: "+all+"\nActive: "+active;
	}

	@Override
	public double[] getProbabilities(T t) {
		double[] toReturn = new double[intervalUpperBound+1];
		long time = System.currentTimeMillis();
		long start = time;
		Node tNode = getAndCreateNode(t);
		expand();
		for (Node n : yesNode) {
			active.addAll(n.getPrevious());
		}
		toReturn[0] = tNode.getProbability(0);
		for( int i=1 ; i<=intervalUpperBound ; i++ ) {
//			if (i%50==0) {
//				System.out.println(i+" --> Actve: "+active.size());
//			}
			LinkedList<Node> foo = active;
			active = new LinkedList<IntervalBoundUntilStructure<T>.Node>();
			for (Node n : foo) {
				n.compute(i);
				for (Node p: n.getPrevious()) {
					if (p.enable(i+1)) {
						active.add(p);
					}
				}
			}		
			toReturn[i] = tNode.getProbability(i);
		}
		return toReturn;
	}

	@Override
	public double[] getProbabilities(T[] t) {
		long time = System.currentTimeMillis();
		long start = time;
		LinkedList<Node> nodes = new LinkedList<Node>();
		for( int i=0 ; i<t.length ; i++ ) {
			nodes.push(getAndCreateNode(t[i]));			
		}
		expand();
		long foo = System.currentTimeMillis();
		System.out.println("Expand Time ("+all.size()+"): "+(foo-time));
		System.out.println("All size: "+all.size());
		System.out.println("Active size: "+active.size());
		time = foo;
		compute();
		foo = System.currentTimeMillis();
		System.out.println("Edges: "+edges);
		System.out.println("Compute Time: "+(foo-time));
		System.out.println("Total Time: "+(foo-start));		
		System.out.println("Max degree: "+maxDegree);
		double[] result = new double[t.length];
		int i = 0;
		for (Node n : nodes) {
			result[i] = n.getProbability(intervalUpperBound);
		}
		return result;
	}
	
}
