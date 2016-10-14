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

import java.util.ArrayList;

import org.apache.commons.math3.random.RandomGenerator;
import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.Probability;
import org.cmg.ml.sam.core.WeightedElement;

/**
 * @author loreti
 *
 */
public class MeanFieldState {
	
	private ArrayList<double[]> evolution;

	private PopulationModule module;

	public MeanFieldState( double[] startOccupancy , PopulationModule module ) {
		this.evolution = new ArrayList<double[]>();
		this.evolution.add(startOccupancy);
		this.module = module;
	}
	
	public double[] getOccupancy(int time) {
		if (!(time  < evolution.size())) {
			computeTo(time);
		}
		return evolution.get(time);
	}

	private void computeTo(int time) {
		double[] last = evolution.get(evolution.size()-1);
		while( evolution.size() < (time+1) ) {
			last = iterate(last);
			evolution.add(last);
		}
	}

	private double[] iterate(double[] last) {		
		return multiply(last,module.getTransitionMatrix(last));
	}

	public Distribution<FastSimulationState> getNext(int time, int state) {
		double[] occupancy = getOccupancy(time);
		Probability<Integer>[] transitionMatrix = module.getTransitionMatrix(occupancy);		
		Probability<FastSimulationState> next = new Probability<FastSimulationState>();
		for (WeightedElement<Integer> weightedElement : transitionMatrix[state]) {
			next.set(new FastSimulationState(time+1, weightedElement.getElement(), this), weightedElement.getWeight());
		}
		return next;
	}

//	public WeightedElement<FastSimulationState> getNext(RandomGenerator r,
//			int time, int state) {
//		double[] occupancy = getOccupancy(time);
//		Probability<Integer>[] transitionMatrix = module.getTransitionMatrix(occupancy);		
//		return new WeightedElement<FastSimulationState>( new FastSimulationState(time+1,transitionMatrix[state].select(r.nextDouble()), this), 1.0);
//	}

	public FastSimulationState getNext(RandomGenerator r,
			int time, int state) {
		double[] occupancy = getOccupancy(time);
		Probability<Integer>[] transitionMatrix = module.getTransitionMatrix(occupancy);		
		return new FastSimulationState(time+1,transitionMatrix[state].select(r.nextDouble()), this);
	}

	private double[] multiply(double[] occupancy,
			Probability<Integer>[] transitionMatrix) {
		double[] next = new double[occupancy.length];
		for( int i=0 ; i<occupancy.length ; i++ ) {
			for (WeightedElement<Integer> we : transitionMatrix[i]) {
				next[we.getElement()] += occupancy[i]*we.getWeight();
			}
		}
		return next;
	}



//	public Distribution<FastSimulationState> getNext(
//			FastSimulationState fastSimulationState) {
//		double[] occupancy = fastSimulationState.getEnvironmentOccupancy();
//		int currentState = fastSimulationState.getState();
//		Probability<Integer>[] transitionMatrix = getTransitionMatrix(occupancy);		
//		double[] nextOccupancy = multiply(occupancy, transitionMatrix);
//		Probability<FastSimulationState> next = new Probability<FastSimulationState>();		
//		for (WeightedElement<Integer> nextState: transitionMatrix[currentState]) {
//			next.set(
//				new FastSimulationState(nextState.getElement() , nextOccupancy , this) , 
//				nextState.getWeight()
//			);
//		}
//		return next;
//	}
//
//	public WeightedElement<FastSimulationState> getNext(RandomGenerator r,
//			FastSimulationState fastSimulationState) {
//		double[] occupancy = fastSimulationState.getEnvironmentOccupancy();
//		int currentState = fastSimulationState.getState();
//		Probability<Integer>[] transitionMatrix = getTransitionMatrix(occupancy);		
//		double[] nextOccupancy = multiply(occupancy, transitionMatrix);
//		int nextState = transitionMatrix[currentState].select(r.nextDouble());
//		return new WeightedElement<FastSimulationState>( new FastSimulationState(nextState, nextOccupancy, this) , 1.0 );
//	}

}
