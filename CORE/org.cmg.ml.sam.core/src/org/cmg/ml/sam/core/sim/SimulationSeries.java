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

import java.util.Iterator;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;


/**
 * @author loreti
 *
 */
public class SimulationSeries {
	
	private String name;
	private SummaryStatistics[] data;
	private double dt;
	private int iterations;

	public SimulationSeries( String name , int iterations , SummaryStatistics[] data , double dt ) {
		this.name = name;
		this.data = data;
		this.dt = dt;
		this.iterations = iterations;
	}

	public Iterable<SimulationData> getSeries() {
		return new Iterable<SimulationData>() {
			
			@Override
			public Iterator<SimulationData> iterator() {
				return new Iterator<SimulationData>() {
				
							private int counter;
							
							@Override
							public boolean hasNext() {
								return counter < data.length;
							}
				
							@Override
							public SimulationData next() {
								SimulationData toReturn = null;
								if (counter<data.length) {
									toReturn = new SimulationData( dt*counter , data[counter].getMean() , data[counter].getStandardDeviation()/Math.sqrt( iterations ));
									counter++;
								}				
								return toReturn;
							}
				
							@Override
							public void remove() {
							}
							
						};
			}
			
		};
	}
	
	public String getName() {
		return name;
	}
	
	public int getIterations() {
		return iterations;
	}
	
}
