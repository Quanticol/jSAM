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

import org.cmg.ml.sam.core.StateEnumerator;
import org.cmg.ml.sam.core.WeightedElement;

/**
 * @author loreti
 *
 */
public abstract class Command {

	private StateEnumerator enumerator;
	
	public Command( StateEnumerator enumerator ) {
		this.enumerator = enumerator;
	}

	public WeightedElement<BigInteger> apply( BigInteger state ) {
		return new WeightedElement<BigInteger>( doApply(state, state), computeWeight(state) );
	}

	public WeightedElement<BigInteger> apply( BigInteger state , double w ) {
		return new WeightedElement<BigInteger>( doApply( state , state ) , computeWeight(state)*w );
	}

	public WeightedElement<BigInteger> apply( BigInteger state , BigInteger next , double w ) {
		return new WeightedElement<BigInteger>( doApply( state , next ) , computeWeight(state)*w );
	}

	protected abstract BigInteger doApply( BigInteger originalState , BigInteger currentState );
	
	protected abstract double computeWeight( BigInteger currentState );

	protected BigInteger set( BigInteger state , int idx , int v ) {
		return enumerator.set(state, idx, v);
	}

}
