/**
 * 
 */
package org.cmg.ml.sam.lprm;

import java.math.BigInteger;

import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.StateEnumerator;
import org.cmg.ml.sam.core.StochasticState;

/**
 * @author loreti
 *
 */
public class State implements StochasticState<State>{
	
	private StateEnumerator enumerator;
	
	private Module module;
	
	private BigInteger state;
	
	private State(StateEnumerator enumerator, Module module , BigInteger state) {
		this.enumerator = enumerator;
		this.module = module;
		this.state = state;
	}

	public int getValueOf( int vIdx ) {
		return enumerator.get( state , vIdx );
	}
	
	public void update( int vIdx , int value ) {
		this.state = enumerator.set( this.state , vIdx, value );
	}
	
	public State set( int vIdx , int value ) {
		return new State( enumerator , module , enumerator.set( state , vIdx, value ) );
	}

	@Override
	public int compareTo(State arg0) {
		return state.compareTo( arg0.state );
	}

	@Override
	public Distribution<State> getNext() {
		return module.getNext(this);
	}

	@Override
	public State copy() {
		return new State( enumerator , module , state );
	}
	
//FIXME: Remove code!
//	@Override
//	public WeightedElement<State> getNext(RandomGenerator r) {
//		return null;
//	}
	

}
