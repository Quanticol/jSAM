/**
 * 
 */
package org.cmg.ml.sam.lprm;

import java.math.BigInteger;

import org.apache.commons.math3.random.RandomGenerator;
import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.StateEnumerator;
import org.cmg.ml.sam.core.StochasticProcess;
import org.cmg.ml.sam.core.WeightedElement;
import org.cmg.ml.sam.core.logic.PathFormula;
import org.cmg.ml.sam.core.logic.StateFormula;

/**
 * @author loreti
 *
 */
public abstract class LprmModule extends StochasticProcess<LprmState>{
	
	protected StateEnumerator enumerator;
	
	public LprmModule() {
		this.enumerator = initializeEnumerator();
		setStartState( initializeStartState() );
	}

	protected abstract LprmState initializeStartState();

	protected abstract StateEnumerator initializeEnumerator();

	@Override
	public Distribution<LprmState> getNext(LprmState s) {
		return doComputeNext(s);
	}

	protected abstract Distribution<LprmState> doComputeNext(LprmState s);

	@Override
	public WeightedElement<LprmState> getNext(LprmState s,
			RandomGenerator rg) {
		Distribution<LprmState> next = getNext(s);
		return new WeightedElement<LprmState>( next.select(rg.nextDouble()) , 1.0 );
	}

	public BigInteger set(BigInteger state, int variable, int value) {
		return enumerator.set(state, variable, value);
	}
	
	public abstract String[] getStateFormulae();
	
	public abstract String[] getPathFormulae();
	
	public abstract StateFormula<LprmState> getStateFormula( String name );
	
	public abstract PathFormula<LprmState> getPathFormula( String name );
	
	protected int getValue( BigInteger state , int idx ) {
		return enumerator.get(state, idx);
	}

}
