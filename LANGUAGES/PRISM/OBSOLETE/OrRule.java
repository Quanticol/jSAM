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

import org.cmg.ml.sam.core.CombinedDistribution;
import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.Probability;

/**
 * @author loreti
 *
 */
public class OrRule implements Rule {

	private Rule left;
	private Rule right;
	
	public OrRule(Rule left, Rule right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean isEnabled(PrismState s) {
		return left.isEnabled(s)||right.isEnabled(s);
	}

	@Override
	public Distribution<PrismState> apply(PrismState s) {
		Distribution<PrismState> toReturn = null;
		if (left.isEnabled(s)) {
			toReturn = left.apply(s);
		}
		if (right.isEnabled(s)) {
			if (toReturn == null) {
				toReturn = right.apply(s);
			} else {
				toReturn = new CombinedDistribution<PrismState>(toReturn, right.apply(s));
			}
		}
		return toReturn;
	}

	@Override
	public Probability<PrismState> apply(PrismState s,
			Probability<PrismState> next) {
		return right.apply(s, left.apply(s, next));
	}

}
