package org.cmg.ml.sam.prism;

import java.math.BigInteger;

import org.cmg.ml.sam.core.Operator;
import org.cmg.ml.sam.core.Probability;

public abstract class PrismSystem {
	
	
	private int labels;

	public PrismSystem( int labels ) {
		this.labels = labels;
	}
	
	public int getLabels() {
		return labels;
	}

	public final Probability<PrismState> getNext(PrismState s) {
		final PrismModel m = s.getModel();
		Operator<BigInteger, PrismState> op = new Operator<BigInteger, PrismState>() {

			@Override
			public PrismState apply(BigInteger p) {
				return new PrismState(p, m );
			}
			
		};
		BigInteger state = s.getState();
		Probability<BigInteger> toReturn = new Probability<BigInteger>();
		long start = System.currentTimeMillis();
		for( int i=0 ; i<labels ; i++ ) {
//			if (isEnabled(s, i)) {
				Probability<BigInteger> rNext = getNext(state,i);
				if (rNext != null) {
					toReturn.add(rNext);
				}
//			}
		}
		start = System.currentTimeMillis();
		Probability<PrismState> foo = toReturn.apply(op);
		return foo;
	}
	
	public abstract boolean isEnabled( PrismState s , int actionId );

	protected abstract Probability<BigInteger> getNext(BigInteger s, int actionId);
	
	protected abstract Probability<BigInteger> interleaving( BigInteger s , int actionId , Probability<BigInteger> next );

	protected abstract Probability<BigInteger> synchronize(BigInteger s, int actionId ,
			Probability<BigInteger> next);

	public static PrismSystem alphabetisedParallelComposition( PrismSystem ... systems ) {
		return alphabetisedParallelComposition( 0 , systems.length , systems);
	}
	
	private static PrismSystem alphabetisedParallelComposition( int from , int to , PrismSystem ... systems ) {
		if (from + 1 == to) {
			return systems[from];
		} else {
			int pivot = (to-from)/2; 
			PrismSystem left = alphabetisedParallelComposition( from , from+pivot , systems);
			PrismSystem right = alphabetisedParallelComposition( from+pivot , to , systems);
			boolean[] leftActions = left.appearingActions();
			boolean[] rightActions = right.appearingActions();
			for( int i=0 ; i<leftActions.length ; i++ ) {
				leftActions[i] = leftActions[i] && rightActions[i];
			}
			return new ControlledParallelComposition( 
					left,
					leftActions,
					right
			);
		}
	}
	
	public static PrismSystem controlledParallelComposition( PrismSystem ... systems ) {
		return alphabetisedParallelComposition( 0 , systems.length , systems);
	}
	
	protected abstract boolean[] appearingActions();

}