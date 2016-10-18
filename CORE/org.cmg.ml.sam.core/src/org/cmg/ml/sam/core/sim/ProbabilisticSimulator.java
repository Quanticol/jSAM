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
package org.cmg.ml.sam.core.sim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.cmg.ml.sam.core.StochasticProcess;
import org.cmg.ml.sam.core.StochasticState;
import org.cmg.ml.sam.core.WeightedElement;

/**
 * @author loreti
 *
 */
public class ProbabilisticSimulator<T extends StochasticState<T>> {
	
	private double deadline;
	
	private double dt;
		
	private ArrayList<Measure<T>> measures;
	
	private SummaryStatistics[][] collected;
	
	private int iterations;
	
	private T start;

	private int steps;

	private RandomGenerator rdg;

	private StochasticProcess<T> process;

	
	//private double[] timeDataArray;
	
	//TODO: Aggiungere gli AbstractDataProvider!!!
	
			
	public ProbabilisticSimulator( RandomGenerator rdg , StochasticProcess<T> process , T start , List<Measure<T>> measures , double deadline , double dt ) {
		this.rdg = rdg;
		this.deadline = deadline;
		this.dt = dt;
		this.start = start;
		this.measures = new ArrayList<Measure<T>>();
		this.measures.addAll(measures);
		this.steps = (int) (deadline/dt);
		this.collected = new SummaryStatistics[measures.size()][steps+1];
		this.iterations++;
		this.process = process;
	}
	
	public void doARun() {
		doARun(null);
	}
	
	public void doARun(SimulationController h) {
		T current = start.copy();
		double time = 0;
		double nextSample = 0;
		int sampleIndex = 0;
//		HashSet<T> set = new HashSet<T>();
//		set.add(current);
		do {		
			WeightedElement<T> step = process.getNext(current,rdg);
			time += step.getWeight();
			while ((time > nextSample)&&(nextSample<=deadline)) {
				storeMeasures( current , sampleIndex );
				nextSample += dt;
				sampleIndex++;
			}
			current = step.getElement();
//			set.add(current);
//			if (sampleIndex%10000==0) {
//				System.out.println("--> "+sampleIndex+" [ "+set.size()+" ]");
//			}
		} while ((time <= deadline)&&((h==null)||!h.isCanceled()));
		iterations++;
	}
	
	private void storeMeasures(T current, int sampleIndex) {
		for( int i=0 ; i<measures.size(); i++ ) {
			if (collected[i][sampleIndex] == null) {
				collected[i][sampleIndex] = new SummaryStatistics();
			}
			collected[i][sampleIndex].addValue(measures.get(i).measure(current));
		}
	}

	public int getMeasuresSize() {
		return measures.size();
	}
	
	public String getMeasureName(int i) {
		return measures.get(i).getName();
	}
	
	public double getMeanValue(int measureId, int step) {
		if ((collected[measureId]==null)||(collected[measureId][step]==null)) {
			return 0.0;
		}
		return collected[measureId][step].getMean();
	}

	public int getIterations() {
		return iterations;
	}
	
	public List<SimulationSeries> getSeries() {
		LinkedList<SimulationSeries> toReturn = new LinkedList<SimulationSeries>();
		for( int i=0 ; i<measures.size() ; i++ ) {
			toReturn.add(new SimulationSeries(measures.get(i).getName(), iterations , collected[i], dt));
		}
		return toReturn;				
	}
	
}
