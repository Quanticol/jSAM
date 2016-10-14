/*
 * Michele Loreti, Concurrency and Mobility Group
 * Università di Firenze, Italy
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
 * This interface identifies a generic Markov process. 
 * 
 * @author loreti
 *
 */
public interface StochasticState<S extends StochasticState<S>> extends Comparable<S> {

	/**
	 * Returns the probability distribution over possible next states.
	 * 
	 * @return a probability distribution over instances of <code>S</code>
	 */
	public Distribution<S> getNext(); 
	
	/**
	 * Creates a copy of the state.
	 * 
	 * @return a copy of the state.
	 */
	public S copy();
		
	
}
