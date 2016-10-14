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
package org.cmg.ml.sam.core;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author loreti
 *
 */
public class MapDistribution<S,T> implements Distribution<T>{
	
	private Operator<S, T> op;
	private Distribution<S> dis;

	public MapDistribution(Distribution<S> dis,
			Operator<S, T> op) {
		this.dis = dis;
		this.op = op;
	}

	@Override
	public Iterator<WeightedElement<T>> iterator() {
		return new Iterator<WeightedElement<T>>() {

			private Iterator<WeightedElement<S>> iterator = dis.iterator();
			
			@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}

			@Override
			public WeightedElement<T> next() {
				return apply(iterator.next());
			}

			@Override
			public void remove() {
				iterator.remove();
			}
		};
	}

	@Override
	public int size() {
		return dis.size();
	}

	@Override
	public WeightedElement<T> get(int i) {
		return apply(dis.get(i)); 
	}
	
	protected WeightedElement<T> apply( WeightedElement<S> w) {
		return new WeightedElement<T>(op.apply(w.getElement()), w.getWeight());
	}

	@Override
	public T select(double p) {
		S s = dis.select(p);
		return op.apply(s);
	}

	@Override
	public double getTotalWeight() {
		return dis.getTotalWeight();
	}

	@Override
	public <R> Distribution<R> apply(Operator<T, R> op) {
		return new MapDistribution<T, R>(this,op);
	}

	@Override
	public Distribution<T> filter(Filter<T> f) {
		LinkedList<WeightedElement<T>> next = new LinkedList<WeightedElement<T>>();
		for (WeightedElement<T> w : this) {
			if (f.eval(w.getElement())) {
				next.add(w);
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void renormalize() {
		dis.renormalize();
	}

	@Override
	public void renormalize(double v) {
		dis.renormalize(v);
	}

}
