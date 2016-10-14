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

import org.cmg.ml.sam.core.StochasticState;

public interface UntilStructure<T extends StochasticState<T>> {

	/**
	 * Returns the probability of all the paths starting from t
	 * that eventually reach a state satisfying predicate <code>right</code>
	 * while only traversing states satisfying predicate <code>left</code>.
	 * 
	 * @param t 
	 * @return
	 */
	public abstract double getProbability(T t);

	public abstract double[] getProbabilities(T t);
	
	public abstract double[] getProbabilities(T[] t);

}