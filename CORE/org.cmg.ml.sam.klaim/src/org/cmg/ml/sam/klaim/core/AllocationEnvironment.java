/**
 * 
 */
package org.cmg.ml.sam.klaim.core;

/**
 * @author loreti
 *
 */
public class AllocationEnvironment {
	
	public static final int SELF = 0;
	protected int[] map;
	
	public AllocationEnvironment( int[] map ) {
		this.map = map;
	}
	
	public AllocationEnvironment() {
		this.map = new int[1];
	}

	public KLocality eval( KLocality src ) {
		if (src.isPhysical()) {
			return src;
		}
		return new KLocality(map[src.getCode()]);
	}

	public void set(int src, int trg) {
		map[src] = trg;
	}

	public int eval(int l) {
		return map[l];
	}

}
