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

/**
 * This interface identifies a generic reachability distribution
 * function over elements of type <code>T</code>. A distribution maps
 * elements of type <code>T</code> to a real number. 
 * 
 * @author Michele Loreti
 *
 * @param <T>
 */
public interface Distribution<T> extends Iterable<WeightedElement<T>> {

	/**
	 * Returns the size of distribution support, i.e. the
	 * number of elements having probability measure greater than 0.
	 * 
	 * @return the size of distribution support.
	 */
	public abstract int size();

	/**
	 * Returns the i-th element in the distribution support.
	 * 
	 * @param i elemnt index.
	 * @return the i-th element in the distribution support.
	 */
	public WeightedElement<T> get(int i);
	
	/**
	 * Selects an element in the distribution support by using parameter
	 * <code>p</code>. The latter is a double value between 0 and 1. 
	 * 
	 * @param p a value between 0 and 1
	 * @return an element in the distribution support
	 */
	public abstract T select(double p);

	/**
	 * Returns the total weight of all the elements in the distribution support. 
	 * 
	 * @return the total weight of all the elements in the distribution support. 
	 */
	public abstract double getTotalWeight();

	/**
	 * Returns the reachability distribution obtained by applying operator <code>op</code>
	 * to each element in the distribution support.
	 * 
	 * @param op an operator mapping <code>T</code> to <code>S</code>
	 * @return the reachability distribution obtained by applying operator <code>op</code>
	 * to each element in the distribution support.
	 */
	public abstract <S> Distribution<S> apply(Operator<T, S> op);

	/**
	 * Returns the reachability distribution obtained by removing all the
	 * elements in the current support that does not pass the filter <code>f</code>.
	 * 
	 * @param f a filter on elements of type <code>T</code>
	 * @return the reachability distribution obtained by removing all the
	 * elements in the current support that does not pass the filter <code>f</code>.
	 */
	public abstract Distribution<T> filter(Filter<T> f);

	public abstract void renormalize();
	
	public abstract void renormalize(double v);
	

}