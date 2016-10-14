/**
 * 
 */
package org.cmg.ml.sam.klaim.core;

import java.lang.ref.PhantomReference;

/**
 * @author loreti
 *
 */
public class KLocality implements KValue {

	public static KLocality SELF = new KLocality(false,AllocationEnvironment.SELF);
	
	private Integer value;
	private Boolean isPhysical;
	
	public KLocality(boolean isPhysical , int value) {
		this.value = value;
		this.isPhysical = isPhysical;
	}
	
	
	public KLocality( int value ) {
		this( true , value );
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(KValue o) {
		int foo = getType().compareTo(o.getType());
		if (foo == 0) {
			KLocality loc = ((KLocality) o);
			foo = isPhysical.compareTo(loc.isPhysical);
			if (foo != 0) {
				return foo;
			}
			return value.compareTo(loc.value);
		}
		return foo;
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.aqua.klaim.KValue#getType()
	 */
	@Override
	public KType getType() {
		return KType.localityType;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof KLocality) {
			return isPhysical.equals(((KLocality) obj).isPhysical)&&value.equals(((KLocality) obj).value);
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

	public boolean isPhysical() {
		return isPhysical;
	}
	
	public boolean isLogical() {
		return isLogical();
	}


	public int getCode() {
		return value;
	}
	
	public KLocality getValue() {
		return this;
	}
	
}
