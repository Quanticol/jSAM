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

import java.math.BigInteger;
import java.util.Arrays;

import org.apache.commons.math3.random.RandomGenerator;
import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.StochasticState;
import org.cmg.ml.sam.core.WeightedElement;

/**
 * @author loreti
 *
 */
public class PrismState implements StochasticState<PrismState> {
	
	private BigInteger state;
//	private PrismModel model;
//	private Distribution<PrismState> _next;
//	private Integer hCode;
//
//	public PrismState(BigInteger state , PrismModel model) {
//		this.state = state;
//		this.model = model;
//	}
	
	@Override
	public int compareTo(PrismState s) {
		return state.compareTo(s.state);
	}

	@Override
	public Distribution<PrismState> getNext() {
//		if (_next == null) {
//			_next = model.getNext(this);
//		}
//		return _next;
		return null;
	}

	@Override
	public PrismState copy() {
//		return new PrismState( state , model ) ;
		return null;
	}

	public WeightedElement<PrismState> getNext(RandomGenerator r) {
		return null;//model.getNext(r,this);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof PrismState)) {
			return false;
		}
		return state.equals(((PrismState) obj ).state);
	}

	@Override
	public int hashCode() {
		return state.hashCode();
	}

	@Override
	public String toString() {
		return "";//model.stringOfState( state );
	}

	public int getValueOf( int variable ) {
		return 0;//model.get(state, variable);
	}

	public void setValueOf(int variable , int value) {
		state = model.set(state, variable, value);
		//return model.set(state, variable, value);
	}

}
