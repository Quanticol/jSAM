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
package org.cmg.ml.sam.lprm;

import org.apache.commons.math3.random.RandomGenerator;
import org.cmg.ml.sam.core.DTStochasticProcess;
import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.Probability;
import org.cmg.ml.sam.core.StochasticProcess;

/**
 * @author loreti
 *
 */
public class Module extends DTStochasticProcess<State> {

	/**
	 * This is an array containing all the rules governing module behaviour.
	 * We assume that rules at index 0 are the one associated to internal/invisible 
	 * actions.
	 */
	private Rule[] rules;
	
	@Override
	public Distribution<State> getNext(State s) {		
		Probability<State> next = new Probability<State>();
		for (Rule r : rules) {
			if (r.isEnabled( s )) {
				next.add( r.apply( s ) );
			}
		}
		return next;
	}

	@Override
	protected State selectNext(State s, RandomGenerator rg) {
		return getNext(s).select(rg.nextDouble());
	}

}
