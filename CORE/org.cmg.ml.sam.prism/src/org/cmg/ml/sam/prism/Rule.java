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
package org.cmg.ml.sam.prism;

import java.math.BigInteger;
import java.util.LinkedList;

import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.Filter;
import org.cmg.ml.sam.core.Probability;
import org.cmg.ml.sam.core.WeightedElement;

/**
 * @author loreti
 *
 */
public class Rule {
	
	private int labelId;
	
	private Filter<BigInteger> guard;
	
	private Command[] commands;
	
	public Rule( Command ... commands ) {
		this(null,commands);
	}
	
	public Rule( Filter<BigInteger> guard , Command ... commands  ) {
		this( 0 , guard , commands );
	}

	public Rule( int labelId , Filter<BigInteger> guard , Command ... commands  ) {
		this.guard =  guard;
		this.commands = commands;
		this.labelId = labelId;
	}

	public boolean isEnabled( BigInteger s ) {
		return guard.eval(s);
	}
	

	public Probability<BigInteger> interleaving( BigInteger s , Probability<BigInteger> next ) {
		if (!isEnabled(s)) {
			return next;
		}
		if (next == null) {
			next = new Probability<BigInteger>();
		}
		for (Command c : commands) {
			next.set(c.apply(s));
		}
		return next;
	}

	public Probability<BigInteger> synchronize( BigInteger s , Probability<BigInteger> next ) {
		if ((next == null)||(!isEnabled(s))) {
			return null;
		}
		Probability<BigInteger> sync_prob = new Probability<BigInteger>();
		for (WeightedElement<BigInteger> w: next) {
			BigInteger next_s = w.getElement();
			double p = w.getWeight();
			for (Command c : commands) {
				sync_prob.set( c.apply(s, next_s, p));;
			}
		}
		return sync_prob;
	}

	public int getActionId() {
		return labelId;
	}
	

}
