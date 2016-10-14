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
public class BasicRule implements Rule {
	
	public Guard guard;
	
	public Command[] commands;

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.lprm.Rule#isEnabled(org.cmg.ml.sam.lprm.State)
	 */
	@Override
	public boolean isEnabled(State s) {
		return guard.eval(s);
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.lprm.Rule#apply(org.cmg.ml.sam.lprm.State)
	 */
	@Override
	public Probability<State> apply(State s) {
		return apply( s , null );
	}

	@Override
	public Probability<State> apply(State s, WeightedElement<State> wState) {
		if (!isEnabled(s)) {
			return null;
		}
		Probability<State> prob = new Probability<State>();
		for (Command c : commands) {
			if ( wState != null )  {
				prob.set(c.apply(s,wState));
			} else {
				prob.set(c.apply(s,wState));
			}
		}
		return prob;
	}

	
}
