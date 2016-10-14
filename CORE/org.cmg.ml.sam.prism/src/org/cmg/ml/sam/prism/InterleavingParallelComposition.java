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
public class InterleavingParallelComposition extends PrismSystem {

	private PrismSystem left;
	private PrismSystem right;

	public InterleavingParallelComposition( 
			PrismSystem left , 
			PrismSystem right)  {
		super( left.getLabels() );
		this.left = left;
		this.right = right;
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.PrismSystem#getNext(org.cmg.ml.sam.prism.PrismState, int)
	 */
	@Override
	protected Probability<BigInteger> getNext(BigInteger s, int actionId) {
		return right.interleaving(s, actionId , left.getNext(s,actionId));
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.PrismSystem#interleaving(org.cmg.ml.sam.prism.PrismState, org.cmg.ml.sam.core.Probability)
	 */
	@Override
	protected Probability<BigInteger> interleaving(BigInteger s,
			int actionId , 
			Probability<BigInteger> next) {
		return right.interleaving(s, actionId , left.interleaving(s,actionId,next));
	}

	@Override
	protected Probability<BigInteger> synchronize(BigInteger s, int actionId,
			Probability<BigInteger> next) {
		Probability<BigInteger> leftNext = left.synchronize(s, actionId, next);
		Probability<BigInteger> rightNext = right.synchronize(s, actionId, next);
		if (leftNext == null) {
			return rightNext;
		} else {
			leftNext.add(rightNext);
			return leftNext;
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
		return left.isEnabled(s, actionId)||right.isEnabled(s, actionId);
	}

}
