/**
 * 
 */
package org.cmg.ml.aqua.klaim.core.test;

import java.util.Vector;

/**
 * @author loreti
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vector<Integer> test = new Vector<Integer>(10,10);
		System.out.println("Before: "+test.capacity());
		test.setSize(20);
		test.ensureCapacity(12);
		test.set(10,10);
		test.setSize(140);
		test.ensureCapacity(120);
		test.set(110,10);
		System.out.println("After: "+test.capacity());
		Math.sin(1.0);
		Math.cos(1.0);
		Math.tan(1.0);
		Math.acos(1.0);
		Math.asin(1.0);
		Math.atan(1.0);
	}

}
