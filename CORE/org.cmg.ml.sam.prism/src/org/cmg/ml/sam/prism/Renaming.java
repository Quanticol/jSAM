/**
 * 
 */
package org.cmg.ml.sam.prism;

import java.math.BigInteger;

import org.cmg.ml.sam.core.Probability;

/**
 * @author loreti
 *
 */
public class Renaming extends PrismSystem {

	private PrismSystem argument;
	private int[] invMap;

	public Renaming(
			PrismSystem argument,
			int[] map ) {
		super( argument.getLabels() );
		this.argument = argument;
		this.invMap = new int[map.length];
		for( int i=0 ; i<map.length ; i++ ) {
			this.invMap[map[i]] = i;
		}
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.PrismSystem#getNext(org.cmg.ml.sam.prism.PrismState, int)
	 */
	@Override
	protected Probability<BigInteger> getNext(BigInteger s, int actionId) {
		return argument.getNext( s , invMap[actionId] );
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.PrismSystem#interleaving(org.cmg.ml.sam.prism.PrismState, org.cmg.ml.sam.core.Probability)
	 */
	@Override
	protected Probability<BigInteger> interleaving(BigInteger s,
			int actionId , 
			Probability<BigInteger> next) {
		return argument.interleaving(s, invMap[actionId], next);
	}

	@Override
	protected Probability<BigInteger> synchronize(BigInteger s, int actionId,
			Probability<BigInteger> next) {
		return argument.synchronize(s, invMap[actionId], next);
	}

	@Override
	protected boolean[] appearingActions() {
		boolean[] argActions = argument.appearingActions();
		boolean[] toReturn = new boolean[argActions.length];
		for( int i=0 ; i<toReturn.length ; i++ ) {
			toReturn[invMap[i]] = argActions[i];
		}
		return toReturn;
	}

	@Override
	public boolean isEnabled(PrismState s, int actionId) {
		return argument.isEnabled( s , invMap[actionId] );
	}

}
