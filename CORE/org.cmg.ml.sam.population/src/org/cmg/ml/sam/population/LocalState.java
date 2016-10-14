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
package org.cmg.ml.sam.population;

import org.cmg.ml.sam.core.Probability;

/**
 * @author loreti
 *
 */
public class LocalState {

	public static class RuleElement {
		
		private int nextState;
		
		private ProbabilityFunction weight;
		
		public RuleElement( ProbabilityFunction weight , int nextState ) {
			this.nextState = nextState;
			this.weight = weight;
		}
		
	}

	private RuleElement[] elements;
	
	private int self;
	
	public LocalState( int self , RuleElement ... elements ) {
		this.self = self;
		this.elements = elements;
	}
	
	public Probability<Integer> eval( double[] occupancy ) {
		Probability<Integer> toReturn = new Probability<Integer>();
		double total = 0.0;
		for( int i=0 ; i<elements.length ; i++ ) {
			double p = elements[i].weight.eval(occupancy);
			if (p>0.0) {
				toReturn.set(elements[i].nextState, p);
				total += p;
			}
		}
		if (total != 1.0) {
			toReturn.set(self, 1.0-total);
		}
		return toReturn;
	}

	public int getStateId() {
		return self;
	}
	
}
