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
package org.cmg.ml.sam.population;

import java.util.Arrays;

import org.apache.commons.math3.random.RandomGenerator;
import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.StochasticState;

/**
 * Instances of this class identifies the state vectors identifying the 
 * current system state.
 * 
 * @author loreti
 *
 */
public class PopulationState implements StochasticState<PopulationState> {
	
	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof PopulationState) {
			return Arrays.equals(this.state, ((PopulationState) arg0).state);
		}
		return false;
	}

	@Override
	public int hashCode() {
		int toReturn = 0;
		int base = module.stateSpaceSize;
		int factor = 1;
		for ( int i=0 ; i<state.length ; i++ ) {
			toReturn += state[i]*factor;
			factor *= base;
		}
		return toReturn;
	}

	@Override
	public String toString() {
		return Arrays.toString(state);
	}

	/**
	 * State vector.
	 */
	private int[] state;
	
	/**
	 * Occupancy measure.
	 */
	private double[] occupancy;
	
	/**
	 * The module with system rules.
	 */
	private PopulationModule module;
	
	/**
	 * The distribution of possible next states. This field is used
	 * for efficiency (memoization).
	 */
	private Distribution<PopulationState> next;
	
	/**
	 * Create a new isntance from the vector of states and from module.
	 * 
	 * @param state state vector
	 * @param module population model
	 */
	public PopulationState( PopulationModule module  , int[] state , double[] occupancy ) {
		this.state = state;
		this.module = module;
		this.occupancy = occupancy;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(PopulationState s) {
		//TODO: Verificare che il valore ritornato sia quello giusto.
		if (state.length != s.state.length) {
			return state.length-s.state.length;
		} 
		for (int i=0; i<state.length; i++) {
			if (state[i]!=s.state[i]) {
				return state[i]-s.state[i];
			}
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.core.StochasticState#getNext()
	 */
	@Override
	public Distribution<PopulationState> getNext() {
//		if (next == null) {
//			next = module.getNext( this );
//		}
		return module.getNext( this );
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.core.StochasticState#getNext(org.apache.commons.math3.random.RandomDataGenerator)
	 */
//	@Override
//	public WeightedElement<PopulationState> getNext(RandomGenerator r) {
//		return module.getNext(r,this);
//	}

	/*
	 * (non-Javadoc)
	 * @see org.cmg.ml.sam.core.StochasticState#copy()
	 */
	@Override
	public PopulationState copy() {
		//TODO: Check the meaning of the second parameter!
		return new PopulationState(
			module ,
			Arrays.copyOf(state, state.length), 
			Arrays.copyOf(occupancy, occupancy.length)
		);
	}

	public int size() {
		return state.length;
	}

	public int getStateAt(int i) {
		return state[i];
	}

	public PopulationState setStateAt( int i , int s ) {
		if (state[i]==s) {
			return this;
		} 
		PopulationState copy = copy();
		copy.state[i] = s;
		copy.occupancy[state[i]]--;
		copy.occupancy[s]++;
		return copy;
	}
	
	public FastSimulationState project( int i ) {
		return project(i, 0);
	}
	
	public FastSimulationState project( int i , int time ) {
		int projectedState = state[i];
		return new FastSimulationState(time, projectedState, getMeanFieldState());
	}
	
	public MeanFieldState getMeanFieldState() {
		return new MeanFieldState(getOccupancy(), module) ;
	}

	public double[] getOccupancy( ) {
		double[] toReturn = new double[occupancy.length];
		for( int i=0 ; i<toReturn.length ; i++ ) {
			toReturn[i] = occupancy[i]/state.length;
		}
		return toReturn;
	}

	public double getOccupancy(int i) {
		return occupancy[i]/state.length;
	}

	public PopulationState getNext(RandomGenerator rg) {
		return module.getNext(rg, this);
	}

}
