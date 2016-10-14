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
package org.cmg.ml.sam.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Identifies a probability distribution over instances of a class <code>T</code>
 * 
 * @author loreti
 *
 */
public class Probability<T> implements Iterable<WeightedElement<T>>, Distribution<T> {

	private HashMap<T,WeightedElement<T>> data;
	private double total;
//	private Iterator<Weight<T>> iterator;
	
	public Probability() {
		data = new HashMap<T, WeightedElement<T>>();
		total = 0.0;
	}
	
	public Probability(LinkedList<WeightedElement<T>> data , double total ) {
		this();
		for (WeightedElement<T> weightedElement : data) {
			this.data.put(weightedElement.getElement(), weightedElement);
		}
		this.total = total;
	}
	
	private Probability(HashMap<T, WeightedElement<T>> data , double total ) {
		this.data = data;
		this.total = total;
	}
	
	public void set(T t, double d) {		
		WeightedElement<T> element = data.get(t);
		if (element == null) {
			element = new WeightedElement<T>(t, d);
			data.put(t, element);
		} else {
			element.addWeight(d);
		}
		total = total+d;
	}
	
	public void set(WeightedElement<T> t) {
		WeightedElement<T> element = data.get(t.getElement());
		if (element == null) {
			data.put(t.getElement(), t);
		} else {
			element.addWeight(t.getWeight());
		}
		total = total+t.getWeight();
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.jopmc.core.ProbabilityI#size()
	 */
	@Override
	public int size() {
		return data.size();
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.jopmc.core.ProbabilityI#iterator()
	 */
	@Override
	public Iterator<WeightedElement<T>> iterator() {
		return data.values().iterator();
	}
	
	/* (non-Javadoc)
	 * @see org.cmg.ml.jopmc.core.ProbabilityI#renormalize()
	 */
	public void renormalize() {
		if (total != 1.0) {
			for (WeightedElement<T> w : data.values()) {
				w.renormalize(total);
			}
			total = 1.0;
		}		
	}
	
	
	
	/**
	 * If <em>R<sub>j</sub></em> denotes the cumulative weight
	 * of the first <em>j</em> elements in the distribution support, 
	 * this method returns the element at position <em>i</em> such that:
	 * 
	 * <blockquote>
	 * <em>R<sub>i-1</sub>&lt;</em> <code>p*getTotalWeight()</code>&lt;=<em>R<sub>i-1</sub></em>
	 * </blockquote>
	 * 
	 * @see org.cmg.ml.jopmc.core.ProbabilityI#select(double)
	 * 
	 */
	@Override
	public T select( double p ) {
		double value = total*p;
		double tot = 0.0;
		for (WeightedElement<T> t : this) {
			if ((tot<=value)&&(value<tot+t.getWeight())) {
				return t.getElement();
			}
			tot += t.getWeight();
		}
		return null;
	}

	@Override
	public String toString() {
		String toReturn = "[ ";
		boolean flag = false;
		for (WeightedElement<T> p : data.values()) {
			if (flag) {
				toReturn += " , "+p;
			} else {
				toReturn += p;
				flag = true;
			}
		}
		toReturn += " ]";
		return toReturn;
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.jopmc.core.ProbabilityI#getTotalWeight()
	 */
	@Override
	public double getTotalWeight() {
		return total;
	}
	
	/* (non-Javadoc)
	 * @see org.cmg.ml.jopmc.core.ProbabilityI#apply(org.cmg.ml.jopmc.core.Operator)
	 */
	@Override
	public <S> Probability<S> apply( Operator<T, S> op ) {
		Probability<S> result = new Probability<S>();
		for (WeightedElement<T> w : data.values()) {
			S q = op.apply(w.getElement());
			if (q != null) {
				result.set(q,w.getWeight());
			}
		}
		return result;		
	}
	
	/* (non-Javadoc)
	 * @see org.cmg.ml.jopmc.core.ProbabilityI#filter(org.cmg.ml.jopmc.core.Filter)
	 */
	@Override
	public Distribution<T> filter( Filter<T> f ) {
		Probability<T> result = new Probability<T>();
		for (WeightedElement<T> w : data.values()) {
			if (f.eval(w.getElement())) {
				result.set(w);
			}
		}
		return result;
	}

	@Override
	public WeightedElement<T> get(int i) {
		return data.get(i);
	}

	@Override
	public void renormalize(double v) {
		for (WeightedElement<T> w : data.values()) {
			w.renormalize(v);
		}
		total = total/v;
	}
	
	public void add( Probability<T> p ) {
		if ( p == null) {
			return ;
		}
		for (WeightedElement<T> weightedElement : p) {
			set( weightedElement );
		}
	}
	
	/**
	 * It is assumed that op is injective!
	 */
	public <S> Probability<S> map( Operator<T,S> op ) {
		HashMap<S,WeightedElement<S>> newData = new HashMap<S, WeightedElement<S>>();
		for (WeightedElement<T> w : data.values()) {
			S element = op.apply(w.getElement());
			newData.put( element ,  new WeightedElement<S>(element, w.getWeight()));
		}
		return new Probability<S>(newData,total);
	}
}
