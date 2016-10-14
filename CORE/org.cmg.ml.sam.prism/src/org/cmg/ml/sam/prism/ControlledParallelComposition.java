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
public class ControlledParallelComposition extends PrismSystem {

	private PrismSystem left;
	private PrismSystem right;
	private boolean[] syncSet;

	public ControlledParallelComposition( 
			PrismSystem left , 
			boolean[] syncSet, 
			PrismSystem right)  {
		super( left.getLabels() );
		this.syncSet = syncSet;
		this.left = left;
		this.right = right;
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.PrismSystem#getNext(org.cmg.ml.sam.prism.PrismState, int)
	 */
	@Override
	protected Probability<BigInteger> getNext(BigInteger s, int actionId) {
		if (syncSet[actionId]) {
			return right.synchronize(s, actionId , left.getNext(s,actionId));
		} else {
			return right.interleaving(s, actionId , left.getNext(s,actionId));
		}
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.PrismSystem#interleaving(org.cmg.ml.sam.prism.PrismState, org.cmg.ml.sam.core.Probability)
	 */
	@Override
	protected Probability<BigInteger> interleaving(BigInteger s,
			int actionId , 
			Probability<BigInteger> next) {
		if (syncSet[actionId]) {
			if (next == null) {
				next = getNext( s , actionId );
			} else {
				next.add( getNext( s , actionId ) );				
			}
			return next;
		} else {
			return right.interleaving(s, actionId , left.interleaving(s,actionId,next));
		}
	}

	@Override
	protected Probability<BigInteger> synchronize(BigInteger s, int actionId,
			Probability<BigInteger> next) {
		if (syncSet[actionId]) {
			return right.synchronize(s, actionId, left.synchronize(s, actionId, next));
		} else {
			Probability<BigInteger> leftNext = left.synchronize(s, actionId, next);
			Probability<BigInteger> rightNext = right.synchronize(s, actionId, next);
			if (leftNext == null) {
				return rightNext;
			} else {
				leftNext.add(rightNext);
				return leftNext;
			}
		}
	}

	@Override
	protected boolean[] appearingActions() {
		boolean[] enabledOnLeft = left.appearingActions();
		boolean[] enabledOnRight = right.appearingActions();
		for (int i=0 ; i<enabledOnLeft.length ; i++ ) {
			enabledOnLeft[i] = enabledOnLeft[i] || enabledOnRight[i];
		}
		return enabledOnLeft;
	}

	@Override
	public boolean isEnabled(PrismState s, int actionId) {
		if (syncSet[actionId]) {
			return left.isEnabled(s, actionId)&&right.isEnabled(s, actionId);
		} else {
			return left.isEnabled(s, actionId)||right.isEnabled(s, actionId);
		}
	}

}
