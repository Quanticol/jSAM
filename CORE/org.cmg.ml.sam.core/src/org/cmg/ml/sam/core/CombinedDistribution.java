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

/**
 * This is a distribution that is obtained as the linear combination of two
 * distributions. 
 * 
 * @author Michele Loreti
 *
 */
public class CombinedDistribution<T> implements Distribution<T> {
	
	private Distribution<T> left;
	private double leftTotalWeight;
	
	private Distribution<T> right;
	private double rightTotalWeight;
	
	public CombinedDistribution( Distribution<T> left , Distribution<T> right) {
		this.left = left;
		this.right = right;
		this.leftTotalWeight =  left.getTotalWeight();
		this.rightTotalWeight = right.getTotalWeight();
	}

	@Override
	public Iterator<WeightedElement<T>> iterator() {
		return new Iterator<WeightedElement<T>>() {
			
			private Iterator<WeightedElement<T>> itLeft = left.iterator();
			private Iterator<WeightedElement<T>> itRight = right.iterator();
			
			@Override
			public boolean hasNext() {
				return itLeft.hasNext()||itRight.hasNext();
			}

			@Override
			public WeightedElement<T> next() {
				if (itLeft.hasNext()) {
					return itLeft.next();
				}
				return itRight.next();
			}

			@Override
			public void remove() {
				throw new IllegalStateException();
			}
		};
	}

	@Override
	public int size() {
		return left.size()+right.size();
	}

	@Override
	public T select(double d) {
		if (d<leftTotalWeight) {
			return left.select(d);
		} else {
			return right.select(d-leftTotalWeight);
		}
	}

	@Override
	public double getTotalWeight() {
		return leftTotalWeight+rightTotalWeight;
	}

	@Override
	public <S> Distribution<S> apply(Operator<T, S> op) {
		return new CombinedDistribution<S>(left.apply(op),right.apply(op));
	}

	@Override
	public Distribution<T> filter(Filter<T> f) {
		return new CombinedDistribution<T>(left.filter(f),right.filter(f));
	}

	@Override
	public WeightedElement<T> get(int i) {
		int foo = left.size(); 
		if (i<foo) {
			return left.get(i);
		}
		return right.get(i-foo);
	}

	@Override
	public void renormalize() {
		double total = leftTotalWeight+rightTotalWeight;
		left.renormalize(total);
		right.renormalize(total);
		leftTotalWeight = leftTotalWeight/total;
		rightTotalWeight = rightTotalWeight/total;
	}

	@Override
	public void renormalize(double v) {
		left.renormalize(v);
		right.renormalize(v);
		leftTotalWeight = leftTotalWeight/v;
		rightTotalWeight = rightTotalWeight/v;
	}

}
