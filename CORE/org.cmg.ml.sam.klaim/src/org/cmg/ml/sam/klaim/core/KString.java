/**
 * 
 */
package org.cmg.ml.sam.klaim.core;

/**
 * @author loreti
 *
 */
public class KString implements KValue {

	private String value;
	
	public KString(String value) {
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(KValue o) {
		int foo = getType().compareTo(o.getType());
		if (foo == 0) {
			return value.compareTo(((KString) o).value);
		}
		return foo;
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.aqua.klaim.KValue#getType()
	 */
	@Override
	public KType getType() {
		return KType.stringType;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof KString) {
			return value.equals(((KString) obj).value);
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
	
	public String getValue() {
		return value;
	}

}
