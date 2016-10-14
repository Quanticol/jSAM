/**
 * 
 */
package org.cmg.ml.sam.core;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author loreti
 *
 */
public class StateEnumerator {
		
	public class State {
		
		private BigInteger state;
		
		private State( BigInteger state ) {
			this.state = state;
		}
		
		@Override
		public boolean equals(Object arg0) {
			if (arg0 instanceof State) {
				return state == ((State) arg0).state;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return state.hashCode();
		}

		@Override
		public String toString() {
			return stateToString( state );
		}
		
		public int get( int i ) {
			return StateEnumerator.this.get( state , i );
		}
		
		public State set( int i , int v ) {
			return new State( StateEnumerator.this.set( state , i , v ) );
		}
		
	}
	
	private BigInteger[] vectorB;
	private BigInteger[] vectorK;
	private int[] minValues;
	
	private StateEnumerator( BigInteger[] vectorB , BigInteger[] vectorK , int[] minValues) {
		this.vectorB = vectorB;
		this.vectorK = vectorK;
		this.minValues = minValues;
	}
	
	public int get( BigInteger v , int i ) {
		return minValues[i]+_get( v , i ).intValue();
	}
	
	private BigInteger _get( BigInteger v , int i ) {
		return (v.divide( vectorB[i] )).mod( vectorK[i] );
	}
	
	public BigInteger set( BigInteger v , int i , int x ) {
		BigInteger old = _get(v , i).multiply( vectorB[i] );
		BigInteger newValue = v.subtract(old).add( _element( i , x ) ); 
		return  newValue;
	}
	
	private BigInteger _element( int i , int x ) {
		return BigInteger.valueOf( x-minValues[i] ).multiply(vectorB[i]);
	}
	
	public BigInteger enumerate( int ... values  ) {
		BigInteger v = BigInteger.ZERO;
		for( int i=0 ; i<values.length ; i++ ) {
			v = v.add( _element( i , values[i] ) );
		}
		return v;
	}
	
	public static StateEnumerator createEnumerator( int[] ranges ) {
		BigInteger[] vectorB = new BigInteger[ranges.length];
		BigInteger[] vectorK = new BigInteger[ranges.length];
		int[] minValues = new int[ranges.length];
		BigInteger foo = BigInteger.ONE;
		for( int i=0 ; i<ranges.length ; i++ ) {
			vectorK[i] = BigInteger.valueOf(ranges[i]);
			vectorB[i] = foo;
			foo = foo.multiply( vectorK[i] );
		}
		return new StateEnumerator(vectorB, vectorK, minValues);
	}
	
	public static StateEnumerator createEnumerator( int[] lowerBounds , int[] upperBounds ) {
		if (lowerBounds.length != upperBounds.length) {
			throw new IllegalArgumentException();
		}
		BigInteger[] vectorB = new BigInteger[lowerBounds.length];
		BigInteger[] vectorK = new BigInteger[lowerBounds.length];
		BigInteger foo = BigInteger.ONE;
		for( int i=0 ; i<lowerBounds.length ; i++ ) {
			vectorB[i] = foo;
			vectorK[i] = BigInteger.valueOf( upperBounds[i] - lowerBounds[i] + 1 );
			foo = foo.multiply( vectorK[i] );
		}
		
		return new StateEnumerator(vectorB, vectorK, lowerBounds);
		
	}
	
	public BigInteger[] getArrayB() {
		return vectorB;
	}

	public int[] hashToArray( BigInteger state) {
		int[] values = new int[vectorK.length];
		for( int i=0 ; i<vectorK.length ; i++ ) {
			values[i] = get( state , i );
		}
		return values;
	}

	public BigInteger size() {
		BigInteger size = BigInteger.ONE;
		for( int i=0 ; i< vectorK.length ; i++ ) {
			size = size.multiply( vectorK[i] );
		}
		return size;
	}
	

	protected String stateToString( BigInteger state) {
		return Arrays.toString( hashToArray( state ) );
	}
	

}
