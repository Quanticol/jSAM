/**
 * 
 */
package org.cmg.ml.sam.klaim.core;

/**
 * @author loreti
 *
 */
public class KBoolean implements KValue {

	private Boolean value;
	
	public KBoolean(boolean value) {
		this.value = value;
	}
	
	public KBoolean(KBoolean b) {
		this(b.value);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(KValue o) {
		int foo = getType().compareTo(o.getType());
		if (foo == 0) {
			KBoolean b = (KBoolean) o;
			if (value) {
				return (b.value?0:1);
			} else {
				return (b.value?-1:0);				
			}
		}
		return foo;
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.aqua.klaim.KValue#getType()
	 */
	@Override
	public KType getType() {
		return KType.booleanType;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof KBoolean) {
			KBoolean b = (KBoolean) obj;
			return value.equals(b.value);
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
	
	public boolean getValue() {
		return value;
	}


}
