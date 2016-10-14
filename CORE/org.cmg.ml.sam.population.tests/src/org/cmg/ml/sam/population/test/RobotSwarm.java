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
package org.cmg.ml.sam.population.test;

import org.apache.commons.math3.random.RandomGenerator;
import org.cmg.ml.sam.core.DTStochasticProcess;
import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.Predicate;
import org.cmg.ml.sam.core.WeightedElement;
import org.cmg.ml.sam.core.mc.pomc.BoundUntilStructure;
import org.cmg.ml.sam.core.mc.pomc.CompleteBoundUntilStructure;
import org.cmg.ml.sam.core.sim.DefaultRandomGenerator;
import org.cmg.ml.sam.population.LocalState;
import org.cmg.ml.sam.population.MeanFieldState;
import org.cmg.ml.sam.population.PopulationModule;
import org.cmg.ml.sam.population.PopulationState;
import org.cmg.ml.sam.population.ProbabilityFunction;

/**
 * @author loreti
 *
 */
public class RobotSwarm {

	public static double G0 = 1.0;
	public static double PG1 = 0.1;
	public static double TG = 0.1;
	public static double PG2 = 0.1;
	
	public static int STATE_S = 0;
	public static int STATE_G = 1;
	
	public static ProbabilityFunction GRIP_PROBABILITY = new ProbabilityFunction() {
		
		@Override
		public double eval(double[] occupancy) {
			return (G0 - occupancy[STATE_G])*PG1;
		}
		
	};
	
	public static ProbabilityFunction TIMEOUT_PROBABILITY = new ProbabilityFunction() {
		
		@Override
		public double eval(double[] occupancy) {
			return TG;
		}
		
	};

	public static ProbabilityFunction HELPED_PROBABILITY = new ProbabilityFunction() {
		
		@Override
		public double eval(double[] occupancy) {
			return occupancy[STATE_S]*PG2;
		}
		
	};	
	
	public static LocalState RULE_STATE_S =  new LocalState( 
				0 ,  
				new LocalState.RuleElement( 
					GRIP_PROBABILITY ,
					STATE_G
				) 
			);
	
	public static LocalState RULE_STATE_G =  new LocalState( 
			1 ,  
			new LocalState.RuleElement( 
				TIMEOUT_PROBABILITY ,
				STATE_S
			) ,
			new LocalState.RuleElement( 
				HELPED_PROBABILITY ,
				STATE_S
			) 			
		);

	public static PopulationModule module = new PopulationModule( 2 , RULE_STATE_S , RULE_STATE_G );
	
	public static void main(String[] argv) {
		PopulationState current = module.getState( new int[] { STATE_S , 10 } );
		System.out.println("PROB: "+getBuondUntilProbability(
				current, 
				new Predicate<PopulationState>() {
					@Override
					public boolean sat(PopulationState t) {
						return true;
//						return t.getOccupancyAt(STATE_S)==1.0;
					}
				}, 
				100 ,
				new Predicate<PopulationState>() {
					@Override
					public boolean sat(PopulationState t) {
						return t.getStateAt(0)==STATE_G;
					}
				}));
//		simulate(current, 100);
		System.out.println("PROB: "+getCompleteBuondUntilProbability(
				current, 
				new Predicate<PopulationState>() {
					@Override
					public boolean sat(PopulationState t) {
						return true;
//						return t.getOccupancyAt(STATE_S)==1.0;
					}
				}, 
				100 ,
				new Predicate<PopulationState>() {
					@Override
					public boolean sat(PopulationState t) {
						return t.getStateAt(0)==STATE_G;
					}
				}));
	}
	
	public static void simulateOnFile(PopulationState current, double deadline, String string) {
		DTStochasticProcess<PopulationState> process = module.getPopulationStochasticProcess();
		MeanFieldState currentMF = current.getMeanFieldState();
		double time = 0;
		RandomGenerator r = new DefaultRandomGenerator();
		while (time<=deadline) {
//			printState( time , module.getOccupancyMeasure(current) );
			printState( time , currentMF.getOccupancy((int) time) );
			WeightedElement<PopulationState> next = process.getNext( current , r);
			if (next == null) {
				time = time+1;
			} else {
				current = next.getElement();
				time += next.getWeight();
			}
		}
	}
	
	public static double simulate( PopulationState current , int iterations ) {
		double totalTime = 0.0;
		RandomGenerator r = new DefaultRandomGenerator();
		for( int i=0 ; i<iterations ; i++ ) {
			long start = System.currentTimeMillis();
			Distribution<PopulationState> next = current.getNext();
			totalTime += (System.currentTimeMillis()-start);
			current = next.select(r.nextDouble());
		}
		double average = (totalTime/iterations);
		System.out.println("\nAverage: "+average);
		return average;
	}

	private static void printState(double time, double[] current) {
		System.out.print( time +" ");
		for( int i=0 ; i<current.length ; i++ ) {
			System.out.print( current[i] +" ");
		}
		System.out.println();

		
//		for( int i=0 ; i.)
//		System.out.println(time+") "
//				+Arrays.toString(  )+" "
//				+Arrays.toString( currentMF ));
	}
	
	
	public static double getBuondUntilProbability( 
			PopulationState t , 
			Predicate<PopulationState> left , 
			int limit , 
			Predicate<PopulationState> right
	) {
		BoundUntilStructure<PopulationState> bus = new BoundUntilStructure<PopulationState>(
			left , 
			limit , 
			right
		);
		return bus.getProbability(t);
////System.out.println("PROB: "+bus.getProbability(current.poject(0)));
//System.out.println("PROB: "+bus.getProbability(current));
	}

	public static double getCompleteBuondUntilProbability( 
			PopulationState t , 
			Predicate<PopulationState> left , 
			int limit , 
			Predicate<PopulationState> right
	) {
		CompleteBoundUntilStructure<PopulationState> bus = new CompleteBoundUntilStructure<PopulationState>(
			left , 
			limit , 
			right
		);
		return bus.getProbability(t);
////System.out.println("PROB: "+bus.getProbability(current.poject(0)));
//System.out.println("PROB: "+bus.getProbability(current));
	}
}
