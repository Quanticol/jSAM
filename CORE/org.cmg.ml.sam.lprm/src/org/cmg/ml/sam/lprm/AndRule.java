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
package org.cmg.ml.sam.lprm;

import org.cmg.ml.sam.core.Probability;
import org.cmg.ml.sam.core.WeightedElement;

/**
 * @author loreti
 *
 */
public class AndRule implements Rule {
	
	private Rule rule1;
	private Rule rule2;
	
	public AndRule( Rule rule1 , Rule rule2 ) {
		this.rule1 = rule1;
		this.rule2 = rule2;
	}

	@Override
	public boolean isEnabled(State s) {
		return rule1.isEnabled(s) && rule2.isEnabled(s);
	}

	@Override
	public Probability<State> apply(State s) {
		Probability<State> left = rule1.apply(s);
		if (left == null) {
			return null;
		}
		Probability<State> next = new Probability<State>();
		for (WeightedElement<State> weightedElement : left) {
			next.add( rule2.apply( s , weightedElement ) );
		}
		return next;
	}

	@Override
	public Probability<State> apply(State s, WeightedElement<State> wState) {
		Probability<State> left = rule1.apply(s, wState);
		if (left == null) {
			return null;
		}
		Probability<State> next = new Probability<State>();
		for (WeightedElement<State> weightedElement : left) {
			next.add( rule2.apply( s , weightedElement ) );
		}
		return next;
	}
	

}
