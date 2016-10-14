/**
 * 
 */
package org.cmg.ml.sam.prism2;

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
public abstract class JPrismModule extends StochasticProcess<JPrismState>{
	
	protected StateEnumerator enumerator;
	
	public JPrismModule() {
		this.enumerator = initializeEnumerator();
		setStartState( initializeStartState() );
	}

	protected abstract JPrismState initializeStartState();

	protected abstract StateEnumerator initializeEnumerator();

	@Override
	public Distribution<JPrismState> getNext(JPrismState s) {
		return doComputeNext(s);
	}

	protected abstract Distribution<JPrismState> doComputeNext(JPrismState s);

	@Override
	public WeightedElement<JPrismState> getNext(JPrismState s,
			RandomGenerator rg) {
		Distribution<JPrismState> next = getNext(s);
		return new WeightedElement<JPrismState>( next.select(rg.nextDouble()) , 1.0 );
	}

	public BigInteger set(BigInteger state, int variable, int value) {
		return enumerator.set(state, variable, value);
	}
	
	public abstract String[] getStateFormulae();
	
	public abstract String[] getPathFormulae();
	
	public abstract StateFormula<JPrismState> getStateFormula( String name );
	
	public abstract PathFormula<JPrismState> getPathFormula( String name );

}
