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
public class EfficientCompleteBoundUntilStructure<T extends StochasticState<T>> implements UntilStructure<T>{

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
	private long lastExpansionTime;
	private long lastComputeTime;
	private long totalComputeNext = 0;

	/**
	 * Initializes an empty structure
	 */
	public EfficientCompleteBoundUntilStructure(Predicate<T> left, int limit , Predicate<T> right) {
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
		double[] toReturn = new double[limit+1];
		for( int i=0 ; i<limit+1 ; i++ ) {
			toReturn[i] = tNode.getProbability(i);
		}
		return toReturn;
	}

	private Node populateNode( T t ) {
		long time = System.currentTimeMillis();
		Node tNode = getAndCreateNode(t);
		if ((tNode.nodeLevel != 0)&&(tNode.nodeLevel<limit)) {
			pending.add(tNode);
		}
		expand();
		long foo = System.currentTimeMillis();
		lastExpansionTime = foo-time;
		System.out.println("EXPAND TIME: "+lastExpansionTime);
		System.out.println("TOTAL NEXT TIME: "+totalComputeNext);
		System.out.println("AVERAGE NEXT TIME: "+(totalComputeNext+0.0)/active.size());
		time = foo;
		System.out.println("STATES: "+all.size());
		System.out.flush();
		compute();
		foo = System.currentTimeMillis();
		lastComputeTime = foo-time;
		System.out.println("COMPUTE TIME: "+lastComputeTime);
		System.out.println("TOTAL TIME: "+(lastComputeTime+lastExpansionTime));
		active = new LinkedList<Node>();
		return tNode;		
	}

	private void compute() {
		for( int i=2 ; i<=limit ; i++ ) {
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
//			System.out.println("FOO: "+foo.size());
			pending = new LinkedList<Node>();
//			int i = 0;
			for (Node n : foo) {
//				long start = System.currentTimeMillis();
				n.expand(k);
//				System.out.println("Expantion time ("+i+"/"+foo.size()+"/"+all.size()+"): "+(System.currentTimeMillis()-start));
//				i++;
			}
			k--;
//			if (k%500==0) {
//				System.out.println("--> "+k+" [ "+pending.size()+" - "+all.size()+" ]");
//				System.out.flush();
//			}
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
		 * 
		 */
		private double yesInOneStep;

		private int computed;
		
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
				p = new double[limit-1];
			}
			this.nodeLevel = 0;
		}
		
		private void compute(int i) {
			if (i > computed) {
//				double foo = selfLoop*getProbability(i-1)+yesInOneStep;
				double foo = selfLoop*getProbability(i-1)+yesInOneStep;
				for (WeightedElement<Node> w : next) {
					foo += w.getWeight()*w.getElement().getProbability(i-1);
				}
				p[i-2] = foo;//+getProbability(i-1);
			} 
		}

		public double getProbability(int i) {
			switch (status) {
			case YES:
				return 1.0;
			case NO:
				return 0.0;
			default:
				if (i==0) {
					return 0.0;
				}
				if (i==1) {
					return yesInOneStep;
				}
				return p[i-2];
			}
		}


		public Label getStatus() {
			return status;
		}

		@Override
		public String toString() {
			return "("+status+")"+element.toString()+"[loop:"+selfLoop+" yesOneStep:"+yesInOneStep+"]:"+Arrays.toString(p)+"\n";
		}

		@Override
		public boolean equals(Object arg0) {
			if (arg0 instanceof EfficientCompleteBoundUntilStructure<?>.Node) {
				return element.equals(((EfficientCompleteBoundUntilStructure<?>.Node) arg0 ).element);
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
				long time = System.currentTimeMillis();
				Distribution<T> step = element.getNext();
				totalComputeNext += (System.currentTimeMillis()-time);
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
						if (n.status == Label.COMPUTED) {
							next.add(new WeightedElement<Node>(n,t.getWeight()));
							if ((n.nodeLevel!=0)&&(n.nodeLevel<level)) {
								pending.add(n);
							}
						}
						if (n.status == Label.YES) {
							yesInOneStep += t.getWeight();
						}
					}
				}
			} else {
				if (nodeLevel>0) {
					for (WeightedElement<Node> wn : next) {
						wn.getElement().expand(nodeLevel-1);
					}
				}
			}
			active.add(this);
		}

	}


	@Override
	public String toString() {
		return "Node: "+all+"\nActive: "+active;
	}

	public long getLastExpansionTime() {
		return lastExpansionTime;
	}

	public long getLastComputeTime() {
		return lastComputeTime;
	}

	@Override
	public double[] getProbabilities(T[] t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
