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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

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
public class UnboundUntilStructure<T extends StochasticState<T>> implements UntilStructure<T> {

	/**
	 * Default error bound.
	 */
	private static final double DEFAULT_ERROR = 0.000001;
	
	/**
	 * Predicate associated to left until formula.
	 */
	private Predicate<T> left;

	/**
	 * Predicate associated to left until formula.
	 */
	private Predicate<T> right;

	/**
	 * This variable is used to identify odd and even iterations in method <code>compute()</code>. 
	 */
	private boolean turn = false;
	
	/**
	 * Error bound.
	 */
	private double error;

	private boolean stability_flag = false;
	
	/**
	 * Labels are used to identify the role of each node in the 
	 * computation.
	 * 
	 * @author loreti
	 *
	 */
	public enum Label {
		/** Identifies a node satisfying the formula with probability <code>1</code>     */
		YES ,       
		/** Identifies a node satisfying the formula with probability <code>0</code>     */
		NO ,        
		/** Identifies a node satisfying the formula with probability greater than 0 
		    and lower that 1 */
		COMPUTED ,  
		/** Identifies a node that is not used in the computation                        */
		UNKNOWN 
	}
	
	/**
	 * A collection containing all the nodes
	 */
	private HashMap<T,Node> all;
	
	/**
	 * The set of nodes that have to be expanded.
	 */
	private LinkedList<Node> pending;

	/**
	 * This list contains that nodes that are not marked neither as YES nor
	 * as NO. 
	 */
	private LinkedList<Node> unmarked;
	
	/**
	 * This list contains that nodes that are currently involved in the 
	 * probabilities computation.
	 */
	private LinkedList<Node> active;
	
	/**
	 * This field is used to store how computed probabilities changes in the 
	 * computation.
	 */
	public double stability;

	/**
	 * Initializes an empty structure
	 */
	public UnboundUntilStructure(double error, Predicate<T> left, Predicate<T> right) {
		all = new HashMap<T,Node>();
		pending = new LinkedList<Node>();
		unmarked = new LinkedList<Node>();
		active = new LinkedList<Node>();
		this.error = 1-error;
		this.left = left;
		this.right = right;
		
	}
	

	/**
	 * Initializes an empty structure
	 */
	public UnboundUntilStructure(Predicate<T> left, Predicate<T> right) {
		this(DEFAULT_ERROR,left,right);
	}


	/* (non-Javadoc)
	 * @see org.cmg.ml.jopmc.core.UntilStructure#getProbability(T)
	 */
	@Override
	public double getProbability( T t ) {
		long time = System.currentTimeMillis();
		long start = time;
		Node tNode = getAndCreateNode(t);
		expand();
		long foo = System.currentTimeMillis();
		System.out.println("Expand Time ("+all.size()+"): "+(foo-time));
		System.out.println("Unmarked size: "+unmarked.size());
		time = foo;
		discard();
		foo = System.currentTimeMillis();
		System.out.println("Discard Time: "+(foo-time));
		System.out.println("Ready size: "+unmarked.size());
		time = foo;
		int iterations = compute();
		foo = System.currentTimeMillis();
		System.out.println("Compute Time (Iterations="+iterations+"): "+(foo-time));
		System.out.println("Total Time: "+(foo-start));		
		System.out.println("pNO="+tNode.pNo[0]+" , "+tNode.pNo[1]);
		System.out.println("pYES="+tNode.pYes[0]+" , "+tNode.pYes[1]);
		return tNode.getProbability();
	}


	private int compute() {	
		stability_flag = false; 
		int count = 0;
		int currentIdx;
		int previousIdx;
		while (!active.isEmpty()&&!stability_flag) {
			stability_flag = true;
//			System.out.println(active.size());
			LinkedList<Node> foo = active;
			active = new LinkedList<Node>();
			count++;
			currentIdx = (turn?1:0);
			previousIdx = (turn?0:1);
			for (Node node : foo) {
				node.compute(currentIdx,previousIdx);
			}			
			turn = !turn;
		}		
		return count;
	}

	/**
	 * This method is used to scan nodes in <code>unmarked</code> list
	 * in order to mark as YES that nodes that only reach YES nodes
	 * and NO that nodes that are not able to reach a YES node.
	 */
	private void discard() { 		
		LinkedList<Node> foo = unmarked;
		System.out.println("Unmarked: "+unmarked.size());
		unmarked = new LinkedList<Node>();
//		while (!foo.isEmpty()) {
//			Node n = foo.pollLast();
//			if (n.reachYes) {
//				if (!n.reachNo) { // n is marked YES since it reaches only YES nodes
//					n.setYes(); 
//				} else {
//					active.add(n); 
//					//FIXME: Check it the if below can be moved here!
//				}
//			} else { // n is marked NO since it cannot reach a YES node.
//				n.setNo();
//			}
//		}
		int countNo = 0;
		for (Node node : foo) {
			if (node.reachYes) {
				unmarked.add(node);
			} else {
				node.setNo();
				countNo++;
			}
		}
		System.out.println("Moved to NO: "+countNo);
		int countYes = 1;
		foo = unmarked;
		unmarked = new LinkedList<Node>();
		for (Node node : foo) {
			if (node.reachNo) {
				unmarked.add(node);
			} else {
				countYes++;
				node.setYes();
			}
		}
		System.out.println("Moved to YES: "+countYes);
		foo = unmarked;
		unmarked = new LinkedList<Node>();
		active = new LinkedList<Node>(); 
		for (Node node : foo) {
			if ((node.yesInOneStep>0.0)||(node.noInOneStep>0.0)) {
				node.isActive();
			}
		}
		System.out.println("Active size: "+active.size());
	}

	/**
	 * Expand the reachability graph.
	 */
	private void expand() {		
		while ( !pending.isEmpty() ) {
			LinkedList<Node> foo = pending;
			pending = new LinkedList<Node>();
			for (Node n : foo) {
				n.expand();
			}
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
		if (n.getStatus()==Label.UNKNOWN) {
			unmarked.add(n);
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
			return Label.UNKNOWN;
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
		 * This flag is true when current node is involved in probability computation.
		 */
		private boolean isActive = false;
		
		/**
		 * This flag indicates if current iteration is the first one involving this node.
		 */
		private boolean firstTime = false;
		
		private boolean stable = false;
		
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
		 * Nodes that can reach with probability greater than 0 the current node.
		 */
		private LinkedList<WeightedElement<Node>> previous;

		/**
		 * This flag is set to <code>true</code> when a <code>NO</code>
		 * can be reached. 
		 */
		private boolean reachNo = false;

		/**
		 * This flag is set to <code>true</code> when a <code>YES</code>
		 * can be reached. 
		 */
		private boolean reachYes = false;

		/**
		 * Vector used to compute the probability associated to the set of 
		 * paths starting from <code>element</code> that satisfy until formula. After <code>k</code>
		 * iterations, <code>pYes[k%2]</code> contains the probability
		 * of reaching a YES node while passing only through ACTIVE nodes with paths of lenght
		 * at most <code>k</code>.
		 */
		private double[] pYes = { 0.0 , 0.0 };
		
		/**
		 * Vector used to compute the probability associated to the set of 
		 * paths starting from <code>element</code> that do not satisfy until formula. After <code>k</code>
		 * iterations, <code>pNo[k%2]</code> contains the probability
		 * that a YES node is not reached through ACTIVE nodes with paths of lenght
		 * at most <code>k</code>.
		 */
		private double[] pNo = { 0.0 , 0.0 };

		private double probability;
		
		/**
		 * This is a value associated to ACTIVE nodes that identifies the probability 
		 * that a node moves into another ACTIVE node with exactly <code>normStep</code> 
		 * transitions. This corresponds to the sum of submatrix associated to ACTIVE nodes.
		 */
		private double[] localNorm = { 1.0 , 1.0 };

		/**
		 * Self-loop probability.
		 */
		private double selfLoop;

		/**
		 * This field stores the probability to reach a yes node in one step.
		 */
		private double yesInOneStep;
		
		/**
		 * This field stores the probability to reach a node node in one step.
		 */
		private double noInOneStep;
		
		
		/**
		 * Creates a node with label <code>label<code> and element <code>element</code>.
		 * 
		 * @param element node element
		 * @param label	  node label
		 */
		private Node( T element , Label label ) {
			this.status = label;
			this.element = element;
			this.previous = new LinkedList<WeightedElement<UnboundUntilStructure<T>.Node>>();
			if (label==Label.YES) {
				pYes[0] = 1.0;
				pYes[1] = 1.0;
			}
			if (label==Label.NO) {
				pNo[0] = 1.0;
				pNo[1] = 1.0;
			}
		}
		
		private void isActive() {
			if (!isActive) {
				active.add(this);
				isActive = true;
				firstTime = true;
			}
		}

		/**
		 * Add to list <code>list</code> all the nodes that are
		 * @param list
		 */
		public void selectPrevious(LinkedList<Node> list) {
			for (WeightedElement<Node> w : previous) {
				Node n = w.getElement();
				n.next.add(new WeightedElement<Node>(this, w.getWeight()));
				if (!n.isActive) {
					list.add(n);
					n.isActive = true;
				}
			}
		}


		public void compute(int currentIdx, int previousIdx) {
			if ((pYes[previousIdx]+pNo[previousIdx]<error)) {
				active.add(this);
			} else {
				pYes[currentIdx]=pYes[previousIdx];
				pNo[currentIdx]=pNo[previousIdx];
				return ;
			}
			pYes[currentIdx] = yesInOneStep;
			pNo[currentIdx] = noInOneStep;
			pYes[currentIdx] += selfLoop*pYes[previousIdx];
			pNo[currentIdx] += selfLoop*pNo[previousIdx];
			for (WeightedElement<Node> w : next) {
				pYes[currentIdx] += w.getWeight()*w.getElement().pYes[previousIdx];
				pNo[currentIdx] += w.getWeight()*w.getElement().pNo[previousIdx];
			}
			probability = pYes[currentIdx];
			if (firstTime) {
				firstTime = false;
				for (WeightedElement<Node> w : previous) {
					w.getElement().addNext(this,w.getWeight());
				}
			}
			if ((pYes[currentIdx]!=pYes[previousIdx])||(pNo[currentIdx]!=pNo[previousIdx])) {
				stability_flag = false;
			}
		}


		private void addNext(Node node, double weight) {
			next.add(new WeightedElement<Node>(node, weight));
			if (!isActive) {
				isActive();
			}
		}

		public void setYes() {
			this.status = Label.YES;
			for (WeightedElement<Node> p : previous ) {
				Node n = p.getElement();
				n.reachYes(p.getWeight());
			}
		}


		public double getProbability() {
			switch (status) {
			case YES:
				return 1.0;
			case NO:
				return 0.0;
			default:
				return probability;//FIXME!
			}
		}


		public Label getStatus() {
			return status;
		}
		
		/**
		 * This method is invoked when a NO node can be reached in one step. 
		 *  
		 * @param p probability to reach a NO node in one step 
		 */
		private void reachNo(double p) {
			noInOneStep += p;
			reachNo();
		}

		/**
		 * This method is invoked when a NO node can be reached. 
		 * 
		 */
		private void reachNo() {
			if (!reachNo) {
				reachNo = true;
//				for (WeightedElement<Node> n : previous) {
//					n.getElement().reachNo(0.0);
//				}
				reachNo = true;
				Stack<Node> stack = new Stack<Node>();
				stack.push(this);
				while (!stack.isEmpty()) {
					Node current = stack.pop();
					for (WeightedElement<Node> n : current.previous) {
						Node p = n.getElement();
						if (!p.reachNo) {
							p.reachNo = true;
							stack.push(p);
						}
					}
				} 
			}
		}

		
		/**
		 * This method is invoked when a YES node can be reached. If
		 * the node is 
		 * @param d 
		 */
		private void reachYes(double d) {
			yesInOneStep += d;
			reachYes();
		}

		/**
		 * This method is invoked when a YES node can be reached. If
		 * the node is 
		 * @param d 
		 */
		private void reachYes() {
			if (!reachYes) {
				reachYes = true;
//				for (WeightedElement<Node> n : previous) {
//					n.getElement().reachYes();
//				}
				Stack<Node> stack = new Stack<Node>();
				stack.push(this);
				while (!stack.isEmpty()) {
					Node current = stack.pop();
					for (WeightedElement<Node> n : current.previous) {
						Node p = n.getElement();
						if (!p.reachYes) {
							p.reachYes = true;
							stack.push(p);
						}
					}
				} 
			}
		}

		@Override
		public String toString() {
			return element.toString()+"->["+(1-pNo[0]-pYes[0])+","+(1-pNo[1]-pYes[1])+"]";
//			return element.toString()+"Yes=["+pYes[0]+","+pYes[1]+"] No=["+pNo[0]+","+pNo[1]+"] Error=["+(1-pNo[0]-pYes[0])+","+(1-pNo[1]-pYes[1])+"]";
		}

		@Override
		public boolean equals(Object arg0) {
			if (arg0 instanceof UnboundUntilStructure<?>.Node) {
				return element.equals(((UnboundUntilStructure<?>.Node) arg0 ).element);
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
		 * PRECONDITION: <code>this.status==Label.UNKNOWN</code>
		 * 
		 */
		private void expand() {
			if (next == null) {
				next = new LinkedList<WeightedElement<Node>>();
				Distribution<T> step = element.getNext();
				if (step.size()==0) {
					this.setNo();
				}
				for (WeightedElement<T> t : step ) {
					//The node associated to term t is retrieved.
					Node n = getAndCreateNode(t.getElement());
					if (n == this) {
						selfLoop += t.getWeight();
					} else {
						//New discovered incoming edge is registered at n
						n.previous.add(new WeightedElement<Node>(this,t.getWeight()));
					}
					switch (n.getStatus()) {
					case YES:
						reachYes(t.getWeight());
						break;
					case NO:
						reachNo(t.getWeight());
						break;
					default:
						if (n.reachYes) {
							reachYes();
						}
						if (n.reachNo) {
							reachNo();
						}
						break;
					}
				}
			}			
		}

		/**
		 * This method is invoked when a node is marked as a NO.  
		 */
		private void setNo() {
			status = Label.NO;
			for (WeightedElement<Node> w : this.previous) {
				w.getElement().reachNo(w.getWeight());
			}
		}
		
	}


	@Override
	public String toString() {
		return "Active: "+all+"\nUnmarked: "+unmarked+"\n Active: "+active;
	}


	@Override
	public double[] getProbabilities(T t) {
		//FIXME!
		return new double[] { getProbability(t)} ;
	}


	@Override
	public double[] getProbabilities(T[] t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
