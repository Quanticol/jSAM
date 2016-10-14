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
public class Hiding extends PrismSystem {

	private PrismSystem argument;
	private boolean[] hidingSet;
	private int[] restrictedIndexes;

	public Hiding(
			PrismSystem argument,
			boolean[] hidingSet ) {
		super( argument.getLabels() );
		this.argument = argument;
		this.hidingSet = hidingSet;
		int count = 0;
		for( int i=0 ; i<hidingSet.length ; i++ ) {
			if (hidingSet[i]) {
				count++;
			}
		}
		this.restrictedIndexes = new int[count];
		count = 0;
		for( int i=0 ; i<hidingSet.length ; i++ ) {
			if (hidingSet[i]) {
				restrictedIndexes[count] = i;
				count++;
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.PrismSystem#getNext(org.cmg.ml.sam.prism.PrismState, int)
	 */
	@Override
	protected Probability<BigInteger> getNext(BigInteger s, int actionId) {
		if (hidingSet[actionId]) {
			return null;
		}
		return argument.getNext( s , actionId );
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.PrismSystem#interleaving(org.cmg.ml.sam.prism.PrismState, org.cmg.ml.sam.core.Probability)
	 */
	@Override
	protected Probability<BigInteger> interleaving(BigInteger s,
			int actionId , 
			Probability<BigInteger> next) {
		if (hidingSet[actionId]) {
			return next;
		}
		if (actionId == 0) {
			Probability<BigInteger> toReturn = argument.interleaving(s, 0, next);
			for( int i=0 ; i<restrictedIndexes.length ; i++) {
				toReturn = argument.interleaving(s, restrictedIndexes[i], toReturn);
			}
			return toReturn;
		} else {
			return argument.interleaving(s, actionId, next);
		}
	}

	@Override
	public Probability<BigInteger> synchronize(BigInteger s, int actionId,
			Probability<BigInteger> next) {
		if (hidingSet[actionId]) {
			return null;
		}
		return argument.synchronize(s, actionId, next);
	}

	@Override
	protected boolean[] appearingActions() {
		boolean[] toReturn = argument.appearingActions();
		for( int i=0 ; i<toReturn.length ; i++ ) {
			toReturn[i] = toReturn[i] && !hidingSet[i];
		}
		return toReturn;
	}

	@Override
	public boolean isEnabled(PrismState s, int actionId) {
		if (hidingSet[actionId]) {
			return false;
		}
		return argument.isEnabled( s , actionId );
	}

	
}
