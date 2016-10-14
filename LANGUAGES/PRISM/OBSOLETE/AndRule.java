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
package org.cmg.ml.sam.prism.obsolete;

import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.Probability;
import org.cmg.ml.sam.core.WeightedElement;

/**
 * @author loreti
 *
 */
public class AndRule implements Rule {
	
	private Rule left;
	private Rule right;
	
	public AndRule( Rule left , Rule right ) {
		this.left = left;
		this.right = right;
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.Rule#isEnable(org.cmg.ml.sam.prism.PrismState)
	 */
	@Override
	public boolean isEnabled(PrismState s) {
		return left.isEnabled(s)&&right.isEnabled(s);
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.Rule#apply(org.cmg.ml.sam.prism.PrismState)
	 */
	@Override
	public Distribution<PrismState> apply(PrismState s) {
		Distribution<PrismState> leftNext = left.apply(s);
		Probability<PrismState> toReturn = new Probability<PrismState>();
		for (WeightedElement<PrismState> we : leftNext) {
			double p = we.getWeight();
			Distribution<PrismState> rightNext = right.apply(we.getElement());
			for (WeightedElement<PrismState> we2 : rightNext) {
				toReturn.set(we2.getElement(), p*we2.getWeight());
			}
		}
		return toReturn;
	}

	@Override
	public Probability<PrismState> apply(PrismState s,
			Probability<PrismState> next) {
		if (left.isEnabled(s)&&right.isEnabled(s)) {
			
		}
		// TODO Auto-generated method stub
		return null;
	}

}
