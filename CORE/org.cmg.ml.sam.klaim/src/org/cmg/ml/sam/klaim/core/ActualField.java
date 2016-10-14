package org.cmg.ml.sam.klaim.core;

/**
 * 
 */

/**
 * @author loreti
 *
 */
public class ActualField implements TemplateField {

	private KValue actual;

	public ActualField(KValue actual) {
		this.actual = actual;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(KValue value) {
		return actual.compareTo(value);
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.aqua.klaim.TemplateField#match(org.cmg.ml.aqua.klaim.KValue)
	 */
	@Override
	public boolean match(KValue value) {
		return actual.equals(value);
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.aqua.klaim.TemplateField#matchGreaterThan(org.cmg.ml.aqua.klaim.KValue)
	 */
	@Override
	public boolean matchGreaterThan(KValue value) {
		return actual.compareTo(value)>0;
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.aqua.klaim.TemplateField#matchLessThan(org.cmg.ml.aqua.klaim.KValue)
	 */
	@Override
	public boolean matchLessThan(KValue value) {
		return actual.compareTo(value)<0;
	}

}
