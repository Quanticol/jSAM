/**
 * 
 */
package org.cmg.ml.sam.prism.obsolete;

/**
 * @author loreti
 *
 */
public class Range {
	
	private int minValue;
	private int maxValue;
	private int initValue;

	public Range( int minValue , int maxValue , int initValue ) {
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.initValue = initValue;
	}
	
	public Range( int minValue , int maxValue ) {
		this(minValue,maxValue,minValue);
	}

	public int getMinValue() {
		return minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public int getInitValue() {
		return initValue;
	}	
	
}
