/**
 * 
 */
package org.cmg.ml.sam.lprm;

import java.math.BigInteger;
import java.util.Arrays;

import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.StochasticState;

/**
 * @author loreti
 *
 */
public class LprmState implements StochasticState<LprmState> {
	
	@Override
	public int hashCode() {
		return state.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if ((obj != null)&&(obj instanceof LprmState)) {
			return state.equals(((LprmState) obj).state);
		}
		return false;
		
	}

	@Override
	public String toString() {
		return Arrays.toString( module.enumerator.hashToArray(state) );
	}

	private BigInteger state;
	private LprmModule module;

	public LprmState(LprmModule module, BigInteger state) {
		this.module = module;
		this.state = state;
	}

	@Override
	public int compareTo(LprmState o) {
		return state.compareTo(o.state);
	}

	@Override
	public Distribution<LprmState> getNext() {
		return module.getNext(this);
	}

	@Override
	public LprmState copy() {
		return new LprmState(module,state);
	}

	public BigInteger getState() {
		return state;
	}

	public LprmState set( int variable , int value ) {
		return new LprmState( module , module.set( state , variable , value ) );
	}

}
