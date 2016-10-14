/*
 * Michele Loreti, Concurrency and Mobility Group
 * Universitˆ di Firenze, Italy
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
import java.util.HashMap;
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
public class CompleteBoundUntilStructure<T extends StochasticState<T>> implements UntilStructure<T>{

	private Predicate<T> left;
	private Predicate<T> right;
	
	private LinkedList<Node> pending;
	private LinkedList<Node> active;
	
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
	
	private int limit;

	/**
	 * Initializes an empty structure
	 */
	public CompleteBoundUntilStructure(Predicate<T> left, int limit , Predicate<T> right) {
		all = new HashMap<T,Node>();
		pending = new LinkedList<Node>();
		active = new LinkedList<Node>();
		this.left = left;
		this.right = right;
		this.limit = limit;
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
		return populateNode(t).getProbability(limit);
	}
	
	public double[] getProbabilities( T t ) {
		Node tNode = populateNode(t);
		if (tNode.p != null) {
			return tNode.p;
		}
		double[] toReturn = new double[limit+1];
		if (tNode.status == Label.YES) {
			for( int i=0 ; i<limit+1 ; i++ ) {
				toReturn[i] = 1.0;
			}
		}
		return toReturn;
	}

	private Node populateNode( T t ) {
		long time = System.currentTimeMillis();
		long start = time;
		Node tNode = getAndCreateNode(t);
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
		return tNode;		
	}

	private void compute() {
		for( int i=1 ; i<=limit ; i++ ) {
			for (Node n : active) {
				n.compute(i);
			}
		}
	}

	/**
	 * Expand the reachability graph.
	 */
	private void expand() {
		int k = limit;
		while ( ( k != 0 ) && ( !pending.isEmpty() ) ) {
			LinkedList<Node> foo = pending;
			pending = new LinkedList<Node>();
			for (Node n : foo) {
				n.expand(k);
			}
			k--;
		}
	}

	/**
	 * Retrieves the node associated to element <code>t</code>. In the case
	 * this node does not exist, a new element is created.
	 * 
	 * @param t an element
	 * @return  the node associated to <code>t</code>
	 */
	private Node getAndCreateNode(T t) {
		Node foo = getNode(t);
		if (foo==null) {
			foo = create(t);
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
	private Node create(T t) {
		Node n = new Node(t,getLabel(t));
		all.put(t, n);
		if (n.getStatus()==Label.COMPUTED) {
			pending.add(n);
		} 
		return n;
	}
	
	/**
	 * Identifies the label that has to be associated to an elemnent <code>t</code.
	 * @param t an element
	 * @return	the label asociated to <code>t</code>
	 */
	private Label getLabel(T t) {
		if (right.sat(t)) {
			return Label.YES;
		}
		if (left.sat(t)) {
			return Label.COMPUTED;
		} 
		return Label.NO;
	}

	
	/**
	 * This class is associated to each DTCM node. 
	 * 
	 * @author loreti
	 *
	 */
	public class Node {
				
		/**
		 * Identifies node status.
		 */
		private Label status;
		
		/**
		 * The element associated to the current node
		 */
		private T element;
		
		/**
		 * Exit probability distribution 
		 */
		private LinkedList<WeightedElement<Node>> next;
		
		/**
		 * Temporary array
		 */
		private double[] p;

		private int nodeLevel;
		
		/**
		 * Self-loop probability.
		 */
		private double selfLoop;
		/**
		 * Creates a node with label <code>label<code> and element <code>element</code>.
		 * 
		 * @param element node element
		 * @param label	  node label
		 */
		private Node( T element , Label label ) {
			this.status = label;
			this.element = element;
			if (label==Label.COMPUTED) {
				p = new double[limit+1];
			}
			this.nodeLevel = 0;
		}
		
		private void compute(int i) {
			double foo = selfLoop*p[i-1];
			for (WeightedElement<Node> w : next) {
				foo += w.getWeight()*w.getElement().getProbability(i-1);
			}
			p[i] = foo;
		}

		public double getProbability(int i) {
			switch (status) {
			case YES:
				return 1.0;
			case NO:
				return 0.0;
			default:
				return p[i];
			}
		}


		public Label getStatus() {
			return status;
		}

		@Override
		public String toString() {
			return element.toString()+":"+Arrays.toString(p)+"\n";
		}

		@Override
		public boolean equals(Object arg0) {
			if (arg0 instanceof CompleteBoundUntilStructure<?>.Node) {
				return element.equals(((CompleteBoundUntilStructure<?>.Node) arg0 ).element);
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
					status = Label.NO;
					p = null;
					return ;
				}
				for (WeightedElement<T> t : step ) {
					edges++;
					//The node associated to term t is retrieved.
					Node n = getAndCreateNode(t.getElement());
					if (n == this) {
						selfLoop += t.getWeight();
					} else {
						next.add(new WeightedElement<Node>(n,t.getWeight()));
					}
				}
				active.add(this);
			} else {
				if (nodeLevel>0) {
					for (WeightedElement<Node> wn : next) {
						wn.getElement().expand(nodeLevel-1);
					}
				}
			}
		}

	}


	@Override
	public String toString() {
		return "Node: "+all+"\nActive: "+active;
	}

	@Override
	public double[] getProbabilities(T[] t) {
		// TODO Auto-generated method stub
		return null;
	}

}
