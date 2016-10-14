/**
 * 
 */
package org.cmg.ml.sam.core;

import org.apache.commons.math3.random.RandomGenerator;

/**
 * @author loreti
 *
 */
public abstract class CTStochasticProcess<S extends StochasticState<S>> extends StochasticProcess<S>{

	@Override
	public WeightedElement<S> getNext(S s, RandomGenerator rg) {
		Distribution<S> next = getNext(s);
		if ((next == null)||(next.getTotalWeight()<=0)) {
			return null;
		}
		return new WeightedElement<S>( this.getNext(s).select(rg.nextDouble()) , (1/next.getTotalWeight())*Math.log( rg.nextDouble() ) );
	}
	

}
