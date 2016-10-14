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

import org.apache.commons.math3.random.RandomGenerator;
import org.cmg.ml.sam.core.DTStochasticProcess;
import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.Probability;
import org.cmg.ml.sam.core.StochasticProcess;
import org.cmg.ml.sam.core.WeightedElement;

/**
 * @author loreti
 *
 */
public class PopulationModule  {

	/**
	 * Identifies the number of local states.
	 */
	protected int stateSpaceSize;
	
	protected LocalState[] rules;
	
	
	public PopulationModule( int stateSpaceSize , LocalState ... rules ) {
		this.stateSpaceSize = stateSpaceSize;
		this.rules = new LocalState[stateSpaceSize];
		for( int i=0 ; i<rules.length ; i++ ) {
			this.rules[rules[i].getStateId()] = rules[i];			
		}
	}
	
	public double[] getOccupancyMeasure( int[] state ) {
		double[] toReturn = new double[stateSpaceSize];
		int populationSize = state.length;
		for( int i=0 ; i<populationSize ; i++ ) {
			toReturn[state[i]]++;
		}
		for( int i=0 ; i<stateSpaceSize ; i++ ) {
			toReturn[i] = toReturn[i]/populationSize;
		}
		return toReturn;
	}
	
	@SuppressWarnings("unchecked")
	public Probability<Integer>[] getTransitionMatrix( double[] occupancy ) {
		Probability<Integer>[] toReturn = (Probability<Integer>[]) new Probability[stateSpaceSize];
		for( int i=0 ; i<stateSpaceSize ; i++ ) {
			toReturn[i] = rules[i].eval(occupancy);
		}
		return toReturn;
	}
	
	
	public Distribution<PopulationState> getNext( PopulationState globalState ) {
		double[] occupancy  = globalState.getOccupancy();
		Probability<Integer>[] transitionMatrix = getTransitionMatrix(occupancy);		
		Probability<PopulationState> _next = new Probability<PopulationState>();		
		_next.set(globalState, 1.0);
		for (int i=0 ; i<globalState.size() ; i++ ) {
			Probability<PopulationState> tmp = new Probability<PopulationState>();
			for (WeightedElement<PopulationState> s : _next) {
				double p = s.getWeight();
				PopulationState current = s.getElement();
				for (WeightedElement<Integer> nextState: transitionMatrix[current.getStateAt(i)]) {
					tmp.set(new WeightedElement<PopulationState>( current.setStateAt(i, nextState.getElement() ), p*nextState.getWeight()));
				}
			}
			_next = tmp;
		}
		//TODO: Check the real meaning and correct use of "assert".
		assert(_next.getTotalWeight()==1.0);
		return _next;
	}

	public PopulationState getNext(RandomGenerator r,
			PopulationState populationState) {
		double[] occupancy =  populationState.getOccupancy();
		double[] newOccupancy = new double[occupancy.length];
		int populationSize = populationState.size();
		Probability<Integer>[] transitionMatrix = getTransitionMatrix(occupancy);
		int[] nextState = new int[populationSize];
		for( int i=0 ; i<populationSize ; i++ ) {
			int foo = transitionMatrix[populationState.getStateAt(i)].select(r.nextDouble());
			nextState[i] = foo;
			newOccupancy[foo]++;
		}
		return new PopulationState(this, nextState, newOccupancy);
	}

	public PopulationState getState( int[] ... species ) {
		int size = 0;
		double[] occupancy = new double[stateSpaceSize];
		for( int i=0 ; i<species.length ; i++ ) {
			size += species[i][1];
		}
		int[] state = new int[size];
		int idx = 0;
		for( int i=0 ; i<species.length ; i++ ) {
			for( int j=0 ; j<species[i][1] ; j++ ) {
				state[idx+j] = species[i][0];
				occupancy[species[i][0]]++;
			}
			idx += species[i][1];
		}
		return new PopulationState(this,state,occupancy);
	}
	
	public DTStochasticProcess<PopulationState> getPopulationStochasticProcess( ) {
		return new DTStochasticProcess<PopulationState>() {

			@Override
			public Distribution<PopulationState> getNext(PopulationState s) {
				return s.getNext();
			}

			@Override
			protected PopulationState selectNext(PopulationState s,
					RandomGenerator rg) {
				return s.getNext( rg );
			}
		};
		
	}

	public DTStochasticProcess<FastSimulationState> getMeanFieldStochasticProcess( ) {
		return new DTStochasticProcess<FastSimulationState>() {

			@Override
			public Distribution<FastSimulationState> getNext(FastSimulationState s) {
				return s.getNext();
			}

			@Override
			protected FastSimulationState selectNext(FastSimulationState s,
					RandomGenerator rg) {
				return s.getNext( rg );
			}
		};
		
	}

}
