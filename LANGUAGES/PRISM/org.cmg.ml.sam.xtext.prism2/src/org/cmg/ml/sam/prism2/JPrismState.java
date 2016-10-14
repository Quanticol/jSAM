/**
 * 
 */
package org.cmg.ml.sam.prism2;

import java.math.BigInteger;
import java.util.Arrays;

import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.StochasticState;

/**
 * @author loreti
 *
 */
public class JPrismState implements StochasticState<JPrismState> {
	
	@Override
	public int hashCode() {
		return state.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if ((obj != null)&&(obj instanceof JPrismState)) {
			return state.equals(((JPrismState) obj).state);
		}
		return false;
		
	}

	@Override
	public String toString() {
		return Arrays.toString( module.enumerator.hashToArray(state) );
	}

	private BigInteger state;
	private JPrismModule module;

	public JPrismState(JPrismModule module, BigInteger state) {
		this.module = module;
		this.state = state;
	}

	@Override
	public int compareTo(JPrismState o) {
		return state.compareTo(o.state);
	}

	@Override
	public Distribution<JPrismState> getNext() {
		return module.getNext(this);
	}

	@Override
	public JPrismState copy() {
		return new JPrismState(module,state);
	}

	public BigInteger getState() {
		return state;
	}

	public JPrismState set( int variable , int value ) {
		return new JPrismState( module , module.set( state , variable , value ) );
	}

}
