/**
 * 
 */
package org.cmg.ml.sam.klaim.core;

/**
 * @author loreti
 *
 */
public class KVector<T extends KValue> implements KValue {

	protected KType thisType;
	protected KType innerType;
	protected T[] values;
	
	@Override
	public int compareTo(KValue arg0) {
		
		return 0;
	}

	@Override
	public KType getType() {
		return new KType.KVector(innerType);
	}

	public KVector<T> getValue() {
		return this;
	}
	
}
