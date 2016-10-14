/**
 * 
 */
package org.cmg.ml.sam.core;

import org.apache.commons.math3.random.RandomGenerator;

/**
 * @author loreti
 *
 */
public abstract class DTStochasticProcess<S extends StochasticState<S>> extends StochasticProcess<S>{

	@Override
	public WeightedElement<S> getNext(S s, RandomGenerator rg) {
		return new WeightedElement<S>( this.selectNext(s,rg) , 1 );
	}

	protected abstract S selectNext( S s , RandomGenerator rg );
}
