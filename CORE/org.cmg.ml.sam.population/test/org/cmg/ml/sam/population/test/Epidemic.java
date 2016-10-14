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

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.apache.commons.math3.random.RandomGenerator;
import org.cmg.ml.sam.core.DTStochasticProcess;
import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.Predicate;
import org.cmg.ml.sam.core.StochasticState;
import org.cmg.ml.sam.core.WeightedElement;
import org.cmg.ml.sam.core.logic.Atomic;
import org.cmg.ml.sam.core.logic.PCheck;
import org.cmg.ml.sam.core.logic.Relation;
import org.cmg.ml.sam.core.logic.StateFormula;
import org.cmg.ml.sam.core.logic.Until;
import org.cmg.ml.sam.core.mc.pomc.BoundUntilStructure;
import org.cmg.ml.sam.core.mc.pomc.CompleteBoundUntilStructure;
import org.cmg.ml.sam.core.mc.pomc.EfficientCompleteBoundUntilStructure;
import org.cmg.ml.sam.core.mc.pomc.OnTheFlyProbabilisticModelChecker;
import org.cmg.ml.sam.core.sim.DefaultRandomGenerator;
import org.cmg.ml.sam.population.FastSimulationState;
import org.cmg.ml.sam.population.LocalState;
import org.cmg.ml.sam.population.MeanFieldState;
import org.cmg.ml.sam.population.PopulationModule;
import org.cmg.ml.sam.population.PopulationState;
import org.cmg.ml.sam.population.ProbabilityFunction;

/**
 * @author loreti
 *
 */
public class Epidemic {
	
	
	public static int STATE_S = 0;
	public static int STATE_E = 1;
	public static int STATE_I = 2;
	public static int STATE_R = 3;
	
	public static double ALPHA_E = 0.1;
	public static double ALPHA_I = 0.2;
	public static double ALPHA_A = 0.4;	
	public static double ALPHA_R = 0.2;
	public static double ALPHA_P = 0.0;
	public static double ALPHA_S = 0.1;
	public static double ALPHA_Q = 0.0;
		
	public static ProbabilityFunction INF_EXT_PROBABILITY = new ProbabilityFunction() {
		
		@Override
		public double eval(double[] occupancy) {
			return ALPHA_E;
		}
		
	};

	public static ProbabilityFunction INF_SUS_PROBABILITY = new ProbabilityFunction() {
		
		@Override
		public double eval(double[] occupancy) {
			return ALPHA_I*occupancy[STATE_I];
		}
		
	};

	public static ProbabilityFunction INF_ACT_PROBABILITY = new ProbabilityFunction() {
		
		@Override
		public double eval(double[] occupancy) {
			return ALPHA_A;
		}
		
	};

	public static ProbabilityFunction PATCH_NON_INF_PROBABILITY = new ProbabilityFunction() {
		
		@Override
		public double eval(double[] occupancy) {
			return ALPHA_Q;
		}
		
	};

	public static ProbabilityFunction PATCH_INF_PROBABILITY = new ProbabilityFunction() {
		
		@Override
		public double eval(double[] occupancy) {
			return ALPHA_R;
		}
		
	};

	public static ProbabilityFunction PATCH_NON_INF_SUS_PROBABILITY = new ProbabilityFunction() {
		
		@Override
		public double eval(double[] occupancy) {
			return ALPHA_P;
		}
		
	};

	public static ProbabilityFunction LOSS_PROBABILITY = new ProbabilityFunction() {
		
		@Override
		public double eval(double[] occupancy) {
			return ALPHA_S;
		}
		
	};

	public static LocalState RULE_STATE_S =  new LocalState( 
		STATE_S ,  
		new LocalState.RuleElement( INF_EXT_PROBABILITY , STATE_E ) ,
		new LocalState.RuleElement( INF_SUS_PROBABILITY, STATE_E ) ,
		new LocalState.RuleElement( PATCH_NON_INF_SUS_PROBABILITY , STATE_R )			
	);
	
	public static LocalState RULE_STATE_E = new LocalState(
		STATE_E  ,
		new LocalState.RuleElement( INF_ACT_PROBABILITY , STATE_I ) ,
		new LocalState.RuleElement( PATCH_NON_INF_PROBABILITY , STATE_R )
	);

	public static LocalState RULE_STATE_I = new LocalState(
		STATE_I  ,
		new LocalState.RuleElement( PATCH_INF_PROBABILITY , STATE_R )
	);

	public static LocalState RULE_STATE_R = new LocalState(
		STATE_R  ,
		new LocalState.RuleElement( LOSS_PROBABILITY , STATE_S )
	);
	
	public static PopulationModule module = new PopulationModule( 4 , RULE_STATE_S , RULE_STATE_E , RULE_STATE_I , RULE_STATE_R );

	public static void main(String[] argv) throws FileNotFoundException {		
		computeProperty12Probabilities();
		computeProperty3Probabilities();
		System.out.println("\n\n\n\n");
		computeProperty12Probabilities();
		computeProperty3Probabilities();
//		computeMeanFieldProperty12Probabilities();
//		computeMeanFieldProperty3();
//		computeSatIntervalMeanFieldProperty3();
	}

	private static void computeSatIntervalMeanFieldProperty3() throws FileNotFoundException {
		final StateFormula<FastSimulationState> f = new PCheck<FastSimulationState>( 
				Relation.GTR , 
				0.3 , 
				new Until<FastSimulationState>( 
					new Atomic<FastSimulationState>( 
						new Predicate<FastSimulationState>() {

							@Override
							public boolean sat(FastSimulationState t) {
								return true;
							}
							
						}
					) , 
					5 ,
					new Atomic<FastSimulationState>( 
							new Predicate<FastSimulationState>() {

								@Override
								public boolean sat(FastSimulationState t) {
									return t.getState()==STATE_I;
								}
								
							}
						) 
				)
			);
			int extreme = 11;
			double[] timeProb = new double[extreme];
			MeanFieldState mfs = new MeanFieldState(new double[] { 1.0 , 0 , 0 , 0 }, module);
			for( int time = 0 ; time < extreme ; time++ ) {				
				final OnTheFlyProbabilisticModelChecker<FastSimulationState> opmc = new OnTheFlyProbabilisticModelChecker<FastSimulationState>();
				System.out.println("===============================");
				System.out.println("PROP 3");
				System.out.println("TIME: "+time);
				FastSimulationState current = new FastSimulationState(time , STATE_S, mfs);
				
		//		results = getCompleteBuondUntilProbabilities(
				timeProb[time] = getEfficientCompleteBuondUntilProbability(
						current, 
						new Predicate<FastSimulationState>() {
							@Override
							public boolean sat(FastSimulationState t) {
								return true;
//								return t.getOccupancyAt(STATE_I)<0.2;
							}
						}, 
						3 ,
						new Predicate<FastSimulationState>() {
							@Override
							public boolean sat(FastSimulationState t) {
								return (t.getState()!=STATE_I)&&(t.getState()!=STATE_E)&&(opmc.sat(t, f));
							}
						});
			}
			PrintWriter pw = new PrintWriter("/Users/loreti/Desktop/Experiments_CONCUR/sat_interval_3.txt");
			for( int i=0 ; i<extreme ; i++ ) {
				pw.println(i+" "+timeProb[i]);
			}
			pw.flush();
			pw.close();
			System.out.println("DONE");
			System.out.println("===============================");

	}

	
	private static void computeMeanFieldProperty3() throws FileNotFoundException {
		final StateFormula<FastSimulationState> f = new PCheck<FastSimulationState>( 
				Relation.GTR , 
				0.3 , 
				new Until<FastSimulationState>( 
					new Atomic<FastSimulationState>( 
						new Predicate<FastSimulationState>() {

							@Override
							public boolean sat(FastSimulationState t) {
								return true;
							}
							
						}
					) , 
					5 ,
					new Atomic<FastSimulationState>( 
							new Predicate<FastSimulationState>() {

								@Override
								public boolean sat(FastSimulationState t) {
									return t.getState()==STATE_I;
								}
								
							}
						) 
				)
			);
			int size = 10000;
				final OnTheFlyProbabilisticModelChecker<FastSimulationState> opmc = new OnTheFlyProbabilisticModelChecker<FastSimulationState>();
				System.out.println("===============================");
				System.out.println("PROP 3");
				System.out.println("SIZE: "+size);
				PopulationState current = module.getState( 
					new int[] { STATE_S , size } ,
					new int[] { STATE_E , 0 } ,
					new int[] { STATE_I , 0 } ,
					new int[] { STATE_R , 0 } 
				);
				double[] results;
		//		results = getCompleteBuondUntilProbabilities(
				results = getEfficientCompleteBuondUntilProbabilities(
						current.project(0), 
						new Predicate<FastSimulationState>() {
							@Override
							public boolean sat(FastSimulationState t) {
								return true;
//								return t.getOccupancyAt(STATE_I)<0.2;
							}
						}, 
						75 ,
						new Predicate<FastSimulationState>() {
							@Override
							public boolean sat(FastSimulationState t) {
								return (t.getState()!=STATE_I)&&(t.getState()!=STATE_E)&&(opmc.sat(t, f));
							}
						});
				PrintWriter pw = new PrintWriter("/Users/loreti/Desktop/Experiments_CONCUR/epidemic_"+size+"_fast_prop_3_0_5_e.txt");
				for( int i=0 ; i<results.length ; i++ ) {
					pw.println(i+" "+results[i]);
				}
				pw.flush();
				pw.close();
				System.out.println("DONE");
				System.out.println("===============================");
	}

	private static void computeProperty3Probabilities() throws FileNotFoundException {
		final StateFormula<PopulationState> f = new PCheck<PopulationState>( 
			Relation.GTR , 
			0.3 , 
			new Until<PopulationState>( 
				new Atomic<PopulationState>( 
					new Predicate<PopulationState>() {

						@Override
						public boolean sat(PopulationState t) {
							return true;
						}
						
					}
				) , 
				5 ,
				new Atomic<PopulationState>( 
						new Predicate<PopulationState>() {

							@Override
							public boolean sat(PopulationState t) {
								return t.getStateAt(0)==STATE_I;
							}
							
						}
					) 
			)
		);
		for( int size = 2 ; size <= 8 ; size = size+2 ) {
			final OnTheFlyProbabilisticModelChecker<PopulationState> opmc = new OnTheFlyProbabilisticModelChecker<PopulationState>();
			System.out.println("===============================");
			System.out.println("PROP 3");
			System.out.println("SIZE: "+size);
			PopulationState current = module.getState( 
				new int[] { STATE_S , size } ,
				new int[] { STATE_E , 0 } ,
				new int[] { STATE_I , 0 } ,
				new int[] { STATE_R , 0 } 
			);
			double[] results;
	//		results = getCompleteBuondUntilProbabilities(
			long time = System.currentTimeMillis();
			results = getEfficientCompleteBuondUntilProbabilities(
					current, 
					new Predicate<PopulationState>() {
						@Override
						public boolean sat(PopulationState t) {
							return true;
//							return t.getOccupancyAt(STATE_I)<0.2;
						}
					}, 
					75 ,
					new Predicate<PopulationState>() {
						@Override
						public boolean sat(PopulationState t) {
							return (t.getStateAt(0)!=STATE_I)&&(t.getStateAt(0)!=STATE_E)&&(opmc.sat(t, f));
						}
					});
			System.out.println("TIME: "+ (System.currentTimeMillis()-time));
			PrintWriter pw = new PrintWriter("/Users/loreti/Desktop/Experiments_CONCUR/epidemic_"+size+"_prop_3_0_5_e.txt");
			for( int i=0 ; i<results.length ; i++ ) {
				pw.println(i+" "+results[i]);
			}
			pw.flush();
			pw.close();
			System.out.println("DONE");
			System.out.println("===============================");
		}			
	}

	private static void computeProperty12Probabilities() throws FileNotFoundException {
		for( int size = 2 ; size <= 8 ; size = size+2 ) {
			System.out.println("===============================");
			System.out.println("PROP 1");
			System.out.println("SIZE: "+size);
			PopulationState current = module.getState( 
				new int[] { STATE_S , size } ,
				new int[] { STATE_E , 0 } ,
				new int[] { STATE_I , 0 } ,
				new int[] { STATE_R , 0 } 
			);
			double[] results;
	//		results = getCompleteBuondUntilProbabilities(
			long time = System.currentTimeMillis();
			results = getEfficientCompleteBuondUntilProbabilities(
					current, 
					new Predicate<PopulationState>() {
						@Override
						public boolean sat(PopulationState t) {
							return true;
//							return t.getOccupancyAt(STATE_I)<0.2;
						}
					}, 
					75 ,
					new Predicate<PopulationState>() {
						@Override
						public boolean sat(PopulationState t) {
							return t.getStateAt(0)==STATE_I;
						}
					});
			System.out.println("TIME: "+ (System.currentTimeMillis()-time));
			PrintWriter pw = new PrintWriter("/Users/loreti/Desktop/Experiments_CONCUR/epidemic_"+size+"_prop_1_e.txt");
			for( int i=0 ; i<results.length ; i++ ) {
				pw.println(i+" "+results[i]);
			}
			pw.flush();
			pw.close();
			System.out.println("DONE");
			System.out.println("===============================");
			System.out.println("\n\n===============================");
			System.out.println("PROP 2");
			System.out.println("SIZE: "+size);
//			results = getCompleteBuondUntilProbabilities(
			time = System.currentTimeMillis();
			results = getEfficientCompleteBuondUntilProbabilities(
					current, 
					new Predicate<PopulationState>() {
						@Override
						public boolean sat(PopulationState t) {
//							return true;
							return t.getOccupancy(STATE_I)<0.25;
						}
					}, 
					75 ,
					new Predicate<PopulationState>() {
						@Override
						public boolean sat(PopulationState t) {
							return t.getStateAt(0)==STATE_E;
						}
					});
			System.out.println("TIME: "+ (System.currentTimeMillis()-time));
			pw = new PrintWriter("/Users/loreti/Desktop/Experiments_CONCUR/epidemic_"+size+"_prop_2_e.txt");
			for( int i=0 ; i<results.length ; i++ ) {
				pw.println(i+" "+results[i]);
			}
			pw.flush();
			pw.close();
			System.out.println("DONE");
			System.out.println("===============================");
		}	
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
	}

	public static double[] getCompleteBuondUntilProbabilities( 
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
		return bus.getProbabilities(t);
	}

	public static <T extends StochasticState<T>> double[] getEfficientCompleteBuondUntilProbabilities( 
			T t , 
			Predicate<T> left , 
			int limit , 
			Predicate<T> right
	) {
		EfficientCompleteBoundUntilStructure<T> bus = new EfficientCompleteBoundUntilStructure<T>(
			left , 
			limit , 
			right
		);
		return bus.getProbabilities(t);
	}

	public static <T extends StochasticState<T>> double getEfficientCompleteBuondUntilProbability( 
			T t , 
			Predicate<T> left , 
			int limit , 
			Predicate<T> right
	) {
		EfficientCompleteBoundUntilStructure<T> bus = new EfficientCompleteBoundUntilStructure<T>(
			left , 
			limit , 
			right
		);
		return bus.getProbability(t);
	}

	private static void computeMeanFieldProperty12Probabilities() throws FileNotFoundException {
		int size = 1000;
		System.out.println("===============================");
		System.out.println("PROP 1");
		System.out.println("SIZE: "+size);
		PopulationState current = module.getState( 
			new int[] { STATE_S , size } ,
			new int[] { STATE_E , 0 } ,
			new int[] { STATE_I , 0 } ,
			new int[] { STATE_R , 0 } 
		);
		double[] results;
//		results = getCompleteBuondUntilProbabilities(
		results = getEfficientCompleteBuondUntilProbabilities(
				current.project(0), 
				new Predicate<FastSimulationState>() {
					@Override
					public boolean sat(FastSimulationState t) {
						return true;
//							return t.getOccupancyAt(STATE_I)<0.2;
					}
				}, 
				75 ,
				new Predicate<FastSimulationState>() {
					@Override
					public boolean sat(FastSimulationState t) {
						return t.getState()==STATE_I;
					}
				});
		PrintWriter pw = new PrintWriter("/Users/loreti/Desktop/Experiments_CONCUR/epidemic_"+size+"_prop_1_e.txt");
		for( int i=0 ; i<results.length ; i++ ) {
			pw.println(i+" "+results[i]);
		}
		pw.flush();
		pw.close();
		System.out.println("DONE");
		System.out.println("===============================");
		System.out.println("\n\n===============================");
		System.out.println("PROP 2");
		System.out.println("SIZE: "+size);
//			results = getCompleteBuondUntilProbabilities(
		results = getEfficientCompleteBuondUntilProbabilities(
				current.project(0), 
				new Predicate<FastSimulationState>() {
					@Override
					public boolean sat(FastSimulationState t) {
//							return true;
						return t.getOccupancy(STATE_I)<0.25;
					}
				}, 
				75 ,
				new Predicate<FastSimulationState>() {
					@Override
					public boolean sat(FastSimulationState t) {
						return t.getState()==STATE_E;
					}
				});
		pw = new PrintWriter("/Users/loreti/Desktop/Experiments_CONCUR/epidemic_"+size+"_prop_2_e.txt");
		for( int i=0 ; i<results.length ; i++ ) {
			pw.println(i+" "+results[i]);
		}
		pw.flush();
		pw.close();
		System.out.println("DONE");
		System.out.println("===============================");
		}


}
