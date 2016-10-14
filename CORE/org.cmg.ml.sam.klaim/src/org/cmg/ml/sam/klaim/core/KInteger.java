/**
 * 
 */
package org.cmg.ml.sam.klaim.core;

/**
 * @author loreti
 *
 */
public class KInteger implements KValue {

	private Integer value;
	
	public KInteger(int value) {
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(KValue o) {
		int foo = getType().compareTo(o.getType());
		if (foo == 0) {
			return value.compareTo(((KInteger) o).value);
		}
		return foo;
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.aqua.klaim.KValue#getType()
	 */
	@Override
	public KType getType() {
		return KType.integerType;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof KInteger) {
			return value.equals(((KInteger) obj).value);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public String toString() {
		return value+"";
	}

	public int getValue() {
		return value;
	}
}
