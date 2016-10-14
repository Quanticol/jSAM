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
public class FastSimulationState implements StochasticState<FastSimulationState> {
	
	/**
	 * Component state.
	 */
	private int state;
	
	/**
	 * Environment
	 */
	private MeanFieldState environment;
	
	/**
	 * The distribution of possible next states. This field is used
	 * for efficiency (memoization).
	 */
	private Distribution<FastSimulationState> next;
	
	/**
	 * Current time
	 */
	private int time;
	
	/**
	 * Create a new isntance from the vector of states and from module.
	 */
	public FastSimulationState( int state , MeanFieldState environment ) {
		this( 0 , state , environment );
	}
	
	public FastSimulationState(int time , int state, MeanFieldState environment) {
		this.time = time;
		this.state = state;
		this.environment = environment;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(FastSimulationState s) {
		//TODO: Verificare che il valore ritornato sia quello giusto.
		if (state != s.state) {
			return state - s.state;
		} 
		return time - s.time;
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.core.StochasticState#getNext()
	 */
	@Override
	public Distribution<FastSimulationState> getNext() {
		return environment.getNext( time , state );
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.core.StochasticState#getNext(org.apache.commons.math3.random.RandomDataGenerator)
	 */
//	@Override
//	public WeightedElement<FastSimulationState> getNext(RandomGenerator r) {
//		return environment.getNext(r,time,state);
//	}

	/*
	 * (non-Javadoc)
	 * @see org.cmg.ml.sam.core.StochasticState#copy()
	 */
	@Override
	public FastSimulationState copy() {
		return this;
	}

	public double[] getOccupancy() {
		return environment.getOccupancy(time);
	}

	public int getState() {
		return state;
	}

	public double getOccupancy(int i) {
		return getOccupancy()[i];
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FastSimulationState) {
			FastSimulationState fss = (FastSimulationState) obj;
			return (state == fss.state)&&(time == fss.time);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return time;//(state << 16)^time;
	}

	@Override
	public String toString() {
		return state+"["+Arrays.toString(getOccupancy())+"]@"+time;
	}

	public FastSimulationState getNext(RandomGenerator rg) {
		return environment.getNext(rg,time,state);
	}
	
}
