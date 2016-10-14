/*
 * Michele Loreti, Concurrency and Mobility Group
 * Universitˆ di Firenze, Italy
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

/**
 * A <code>Run</code> is a data-structure containing the measures 
 * collected from a rimulation run.
 * 
 * @author loreti
 *
 */
public class Run {
	
	private double[][] values;
	
	/**
	 * Creates a new simulation run with <code>size</code> measures.
	 * 
	 * @param size the number of measures in the run.
	 */
	public Run( int size ) {
		this.values = new double[size][];
	}
	
	/**
	 * Set measures for the i-th element in the run.
	 * 
	 * @param i element in the run
	 * @param measures collected values
	 */
	public void set( int i , double[] measures ) {
		this.values[i] = measures;
	}
	
	/**
	 * Returns the measures collected in the i-th element in the run.
	 * 
	 * @param i an element in the run
	 * @return collected values
	 */
	public double[] get( int i ) {
		return this.values[i];
	}

}
