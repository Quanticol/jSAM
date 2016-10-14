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
public class StrongSynchronization extends PrismSystem {

	private PrismSystem left;
	private PrismSystem right;

	public StrongSynchronization(
			PrismSystem left,
			PrismSystem right) {
		super( left.getLabels() );
		this.left = left;
		this.right = right;
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.PrismSystem#getNext(org.cmg.ml.sam.prism.PrismState, int)
	 */
	@Override
	protected Probability<BigInteger> getNext(BigInteger s, int actionId) {
		if (actionId == 0) {
			return right.interleaving(s, actionId , left.getNext(s,actionId));
		} else {
			return right.synchronize(s, actionId , left.getNext(s,actionId));
		}
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.PrismSystem#interleaving(org.cmg.ml.sam.prism.PrismState, org.cmg.ml.sam.core.Probability)
	 */
	@Override
	public Probability<BigInteger> interleaving(BigInteger s,
			int actionId , 
			Probability<BigInteger> next) {
		if (actionId == 0) {
			return right.interleaving(s, actionId , left.interleaving(s,actionId,next));
		} else {
			next.add( getNext( s , actionId ));
			return next;
		}
	}

	@Override
	public Probability<BigInteger> synchronize(BigInteger s, int actionId,
			Probability<BigInteger> next) {
		return right.synchronize(s, actionId, left.synchronize(s, actionId, next));
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
		return left.isEnabled(s, actionId)&&right.isEnabled(s, actionId);
	}

}
