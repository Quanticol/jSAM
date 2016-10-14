/**
 * 
 */
package org.cmg.ml.sam.klaim.core;

import java.util.Arrays;
import java.util.LinkedList;


/**
 * This class provides a tree-based implementation of a tuple space. 
 * 
 * @author loreti
 *
 */
public class TupleSpace {
	
	/**
	 * 
	 * @author loreti
	 *
	 */
	public class Node {
		protected KValue value;
		protected int 	 occurrences;
		protected Node   nested;
		protected Node	 left;
		protected Node	 right;
		protected int    height;
		protected int    balance;
		
		public Node( KValue value ) {
			this.value = value;
			this.occurrences = 0;
			this.height = 1;
			this.balance = 0;
		}
		
		
		public Node( KValue value , int size , Node nested , Node left , Node right ) {
			this.value = value;
			this.occurrences = size;
			this.nested = nested;
			this.left = left;
			this.right = right;
			this.height = Math.max(getHeight(left), getHeight(right));
			this.balance = getHeight(left) - getHeight(right);
		}
		
		public Node addInside( Tuple t , int idx ) {
			if (idx == t.length()) {
				return new Node(value,occurrences+1,nested,left,right);
			} else {
				return new Node(value,occurrences,addToNode(nested, t, idx).balance(),left,right);
			}
		}
		
		public Node add( Tuple t , int idx ) {
			if (idx == t.length()) {
				//This code cannot be executed!
				return this;
			}
			KValue tValue = t.getValueAt(idx);
			int foo = value.compareTo(tValue);
			if (foo < 0) {
				return new Node(value,occurrences,nested,left,addToNode(right,t,idx)).balance();
			} 
			if (foo > 0) {
				return new Node(value,occurrences,nested,addToNode(left,t,idx),right).balance();
			}
			return addInside(t, idx+1);
		}

		public Node remove(Tuple t, int idx) {
			if (idx == t.length()) {
				//This code cannot be executed!
				throw new TupleNotFoundException();
			}
			KValue tValue = t.getValueAt(idx);
			int foo = value.compareTo(tValue);
			if (foo < 0) {
				return new Node(value,occurrences,nested,left,removeFromNode(right,t,idx));
			} 
			if (foo > 0) {
				return new Node(value,occurrences,nested,removeFromNode(left,t,idx),right);
			}
			return removeInside(t, idx+1);
		}
		
		private Node removeInside(Tuple t, int idx) {
			if (idx == t.length()) {
				if (occurrences > 0) {
					return new Node(value,occurrences-1,nested,left,right);
				} else {
					throw new TupleNotFoundException();
				}
			} else {
				return new Node(value,occurrences,removeFromNode(nested, t, idx).balance(),left,right);
			}
		}

		public Node rotateLeft( ) {
			return new Node(right.value,right.occurrences,right.nested,
							new Node(value,occurrences,nested,left,right.left),
							right.right);					
		}
		
		public Node rotateRight( ) {
			return new Node(left.value,left.occurrences,left.nested,
					left.left,
					new Node(value,occurrences,nested,left.right,right));					
		}
		
		public Node balance() {
			switch (balance) {
			case -2:
				if (left.balance==1) {
					this.left = this.left.rotateLeft();
				} 
				return this.rotateRight();
			case 2:
				if (left.balance==-1) {
					this.left = this.left.rotateRight();
				} 
				return this.rotateLeft();
			default:
				return this;
			}
		}

		public int getSize() {
			return occurrences+TupleSpace.this.getSize(left)+TupleSpace.this.getSize(right)+TupleSpace.this.getSize(nested);
		}

		public LinkedList<Pair<Tuple, Integer>> getTuples(LinkedList<Pair<Tuple, Integer>> list , KValue[] data , Template t, int idx) {
			if (t.length()==idx) {
				if (occurrences>0) {
					list.add(new Pair<Tuple,Integer>(new Tuple(Arrays.copyOf(data, data.length)),occurrences));
				}
			} else {
				TemplateField f = t.getFieldAt(idx);
				if (f.match(value)) {
					data[idx] = value;
					getTuplesInside( list , data , t , idx+1);
				}
				if (f.matchLessThan(value)) {
					getTuplesFromNode(list, data, left, t , idx);
				}
				if (f.matchGreaterThan(value)) {
					getTuplesFromNode(list, data, right, t, idx);
				}
			}
			return list;
		}
		
		public int getNumberOfMatchingTuple( Template t , int idx ) {
			if (t.length()==idx) {
				return 0;//This code is never executed!
			} else {
				TemplateField f = t.getFieldAt(idx);
				int count = 0;
				if (f.match(value)) {
					if (t.length()==(idx+1)) {
						count = occurrences;
					} else {
						count = getNumberOfMatchingTuplesFromNode(nested, t, idx+1);
					}
				}
				if (f.matchLessThan(value)) {
					count += getNumberOfMatchingTuplesFromNode(left, t, idx);
				}
				if (f.matchGreaterThan(value)) {
					count += getNumberOfMatchingTuplesFromNode(right, t, idx);
				}
				return count;
			}
		}

		public LinkedList<Pair<Tuple, Integer>> getTuples(LinkedList<Pair<Tuple, Integer>> list , LinkedList<KValue> data , int idx) {
			data.add(idx,value);
			if (occurrences>0) {
				list.add( new Pair<Tuple,Integer>(new Tuple(data.toArray(new KValue[data.size()])) ,occurrences));
			}
			getTuplesFromNode( list , data , nested , idx+1);
			data.removeLast();
			getTuplesFromNode(list, data, left, idx);
			getTuplesFromNode(list, data, right, idx);
			return list;
		}

		private void getTuplesInside(LinkedList<Pair<Tuple, Integer>> list,
				KValue[] data, Template t, int i) {
			if (t.length() == i) {
				if (occurrences>0) {
					list.add(new Pair<Tuple,Integer>(new Tuple(Arrays.copyOf(data, data.length)),occurrences));
				}
			} else {
				getTuplesFromNode(list, data, nested, t, i);
			}
			
		}
	}
	
	protected Node root;
	
	private TupleSpace(Node root) {
		this.root = root;
	}

	public TupleSpace() {
		this(null);
	}

	protected Node addToNode( Node n , Tuple t , int idx ) {
		if (n == null) {
			return new Node( t.getValueAt(idx) ).addInside(t, idx+1);
		} 
		return n.add(t, idx);
	}
	
	protected Node removeFromNode( Node n , Tuple t , int idx ) {
		if (n == null) {
			throw new TupleNotFoundException();
		}
		return n.remove( t , idx );
	}
	
	public TupleSpace addTuple( Tuple t ) {
		return new TupleSpace( addToNode( root , t , 0 ));
	}
	
	protected int getHeight( Node n ) {
		if (n==null) {
			return 0;
		}
		return n.height;
	}

	public int getSize() {
		return getSize(root);
	}

	private int getSize(Node n) {
		if (n == null) {
			return 0;
		}
		return n.getSize();
	}

	public TupleSpace addTuple(KValue ... kValues ) {
		return addTuple( new Tuple(kValues) );
	}

	public TupleSpace getTuple(Tuple t) {
		return new TupleSpace( removeFromNode(root, t, 0) );
	}

	public TupleSpace getTuple(KValue ... kValues ) {
		return getTuple( new Tuple(kValues) );
	}
	
	public LinkedList<Pair<Tuple,Integer>> getTuples( Template t ) {
		return getTuplesFromNode( new LinkedList<Pair<Tuple,Integer>>() , new KValue[t.length()] , root , t , 0 );
	}

	public LinkedList<Pair<Tuple,Integer>> getTuples( ) {
		return getTuplesFromNode( new LinkedList<Pair<Tuple,Integer>>() , new LinkedList<KValue>() , root , 0 );
	}

	private LinkedList<Pair<Tuple,Integer>> getTuplesFromNode( LinkedList<Pair<Tuple,Integer>> list , KValue[] data , Node n , Template t , int idx ) {
		if (n == null) {
			return list;
		}
		return n.getTuples( list , data , t , idx );
	}

	private LinkedList<Pair<Tuple,Integer>> getTuplesFromNode( LinkedList<Pair<Tuple,Integer>> list , LinkedList<KValue> data , Node n , int idx ) {
		if (n == null) {
			return list;
		}
		return n.getTuples( list , data , idx );
	}

	public LinkedList<Pair<Tuple,Integer>> getTuples(TemplateField ... fields ) {
		return getTuples(new Template(fields));
	}

	public int getNumberOfMatchingTuple(Template t) {
		return getNumberOfMatchingTuplesFromNode( root , t , 0 );
	}

	private int getNumberOfMatchingTuplesFromNode(Node n, Template t, int idx ) {
		if ( n == null ) {
			return 0;
		}
		return n.getNumberOfMatchingTuple(t, idx);
	}

}
