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
public class OrRule implements Rule {
	
	private Rule rule1;
	private Rule rule2;
	
	public OrRule( Rule rule1 , Rule rule2 ) {
		this.rule1 = rule1;
		this.rule2 = rule2;
	}

	@Override
	public boolean isEnabled(State s) {
		return rule1.isEnabled(s)||rule2.isEnabled(s);
	}

	@Override
	public Probability<State> apply(State s) {
		Probability<State> next = rule1.apply(s);
		if (next != null) {
			next.add(rule2.apply(s));
		}
		return next;
	}

	@Override
	public Probability<State> apply(State s, WeightedElement<State> wState) {
		Probability<State> next = new Probability<State>();
		if (rule1.isEnabled(s)) {
			next = rule1.apply(s,wState);
		} 
		if (rule2.isEnabled(s)) {
			next.add(rule2.apply(s,wState));
		}
		return next;
	}
	
	

}
