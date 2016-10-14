/**
 * 
 */
package org.cmg.ml.sam.klaim.core;

/**
 * @author loreti
 *
 */
public class KDouble implements KValue {

	private Double value;
	
	public KDouble(double value) {
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(KValue o) {
		int foo = getType().compareTo(o.getType());
		if (foo == 0) {
			return value.compareTo(((KDouble) o).value );
		}
		return foo;
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.aqua.klaim.KValue#getType()
	 */
	@Override
	public KType getType() {
		return KType.doubleType;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof KDouble) {
			return value.equals(((KDouble) obj).value);
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

	public double getValue() {
		return value;
	}
}
