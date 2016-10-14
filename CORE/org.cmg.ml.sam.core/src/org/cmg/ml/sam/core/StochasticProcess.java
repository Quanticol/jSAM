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

import org.apache.commons.math3.random.RandomGenerator;

/**
 * The <code>MarkovProcess</code> class identifies a generic Markov process. This
 * class is parametrized with respect to a class <code>S<code> that implements
 * <code>MarkovState</code> and that identifies the states of the Markov process.
 * 
 * 
 * @author loreti
 *
 */
public abstract class StochasticProcess<S extends StochasticState<S>> {
	
	/**
	 * Process parameters.
	 */
	protected Number[] parameters;
	
	/**
	 * Start state.
	 */
	protected S start;

	/**
	 * Creates a process with a given array of parameters.
	 * 
	 * @param parameters process parameters.
	 */
	public StochasticProcess( Number ... parameters ) {
		this.parameters = parameters;
	}
	
	/**
	 * This method will be provided to define the stochastic behaviour
	 * associated to each state. In a classical point of view, this method
	 * returns the row associated to a state via the transition matrix of 
	 * a DTMC/CTMC.
	 * 
	 * @param s current state
	 * @return	next state distribution
	 */
	public abstract Distribution<S> getNext(S s);

	/**
	 * This method is used to perform a simulation step. 
	 * 
	 * @param s current state
	 * @param rg random generator
	 * @return a weighted element identifying the next state and the time of changing state.
	 */
	public abstract WeightedElement<S> getNext(S s, RandomGenerator rg );

	/**
	 * Returns the start state.
	 * 
	 * @return the start state.
	 */
	public final S getStartState() {
		return start;
	}
	
	/**
	 * Set the start state.
	 * 
	 * @param s the new start state.
	 */
	public final void setStartState( S s ) {
		this.start = s;
	}

	/**
	 * Return the integer value associated to parameter <code>idx</code>-th.
	 * 
	 * @param idx parameter's index
	 * @return	integer value associated to parameter <code>idx</code>-th.
	 */
	public int getIntValue( int idx ) {
		return parameters[idx].intValue(); 
	}

	/**
	 * Return the double value associated to parameter <code>idx</code>-th.
	 * 
	 * @param idx parameter's index
	 * @return	double value associated to parameter <code>idx</code>-th.
	 */
	public double getDoubleValue( int idx ) {
		return parameters[idx].doubleValue(); 
	}

	/**
	 * Return the boolean value associated to parameter <code>idx</code>-th.
	 * 
	 * @param idx parameter's index
	 * @return	boolean value associated to parameter <code>idx</code>-th.
	 */
	public boolean getBoolValue( int idx ) {
		return parameters[idx].intValue()!=0;
	}
	
}
