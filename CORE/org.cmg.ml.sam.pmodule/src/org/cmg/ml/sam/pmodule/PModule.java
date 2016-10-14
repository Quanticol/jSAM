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
package org.cmg.ml.sam.pmodule;

import org.apache.commons.math3.random.RandomGenerator;
import org.cmg.ml.sam.core.DTStochasticProcess;
import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.Probability;
import org.cmg.ml.sam.core.StochasticProcess;
import org.cmg.ml.sam.core.WeightedElement;

/**
 * @author loreti
 *
 */
public class PModule extends DTStochasticProcess<PModuleState>{

	private Rule[] rules;
	
	public PModule( Rule ... rules ) {
		this.rules = rules;
	}
	
	
	@Override
	public Distribution<PModuleState> getNext(PModuleState s) {
		Probability<PModuleState> next = new Probability<PModuleState>();
		for( int i=0 ; i<rules.length ; i++ ) {
			if (rules[i].isEnabled(s)) {
				WeightedElement<PModuleState>[] ruleNext = rules[i].apply(s);				
				for (WeightedElement<PModuleState> weightedElement : ruleNext) {
					next.set(weightedElement);
				}
			}
		}
		next.renormalize();
		return next;
	}


	@Override
	protected PModuleState selectNext(PModuleState s, RandomGenerator rg) {
		return getNext(s).select(rg.nextDouble());
	}

}
