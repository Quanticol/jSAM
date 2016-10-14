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

import java.util.Arrays;

import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.StochasticState;
import org.cmg.ml.sam.core.WeightedElement;

/**
 * @author loreti
 *
 */
public class PModuleState implements StochasticState<PModuleState> {

	private int[] state;
	
	private PModule module;
	
	public PModuleState(PModule module , int ... state ) {
		this.state = state;
		this.module = module;
	}

	@Override
	public int compareTo(PModuleState arg0) {
		if (state.length != arg0.state.length) {
			return state.length - arg0.state.length;
		}
		for( int i=0 ; i<state.length ; i++ ) {
			if (state[i] != arg0.state[i]) {
				return state[i] - arg0.state[i];
			}
		}
		return 0;
	}

	@Override
	public Distribution<PModuleState> getNext() {
		return module.getNext(this);
	}

	@Override
	public PModuleState copy() {
		return new PModuleState(module , Arrays.copyOf(state, state.length) );
	}

//FIXME: Remove code!
//	@Override
//	public WeightedElement<PModuleState> getNext(RandomGenerator r) {
//		return new WeightedElement<PModuleState>(module.getNext(this).select(r.nextDouble()) , 1.0 ) ;
//	}

	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof PModuleState) {
			return Arrays.equals(state, ((PModuleState) arg0).state );
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(state);
	}

	@Override
	public String toString() {
		return Arrays.toString(state);
	}

	public int getValueAt(int i) {
		return state[i];
	}


}
