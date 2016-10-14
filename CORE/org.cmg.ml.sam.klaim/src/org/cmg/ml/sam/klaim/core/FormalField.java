/**
 * 
 */
package org.cmg.ml.sam.klaim.core;

/**
 * @author loreti
 *
 */
public class FormalField implements TemplateField {

	private KType fieldType;
	
	
	public FormalField(KType fieldType) {
		this.fieldType = fieldType;
	}

	@Override
	public int compareTo(KValue o) {
		return fieldType.compareTo(o.getType());
	}

	@Override
	public boolean match(KValue v) {
		return (fieldType==null)||fieldType.equals(v.getType());
	}

	@Override
	public boolean matchGreaterThan(KValue value) {
		return (fieldType==null)||fieldType.compareTo(value.getType())>=0;
	}

	@Override
	public boolean matchLessThan(KValue value) {
		return (fieldType==null)||fieldType.compareTo(value.getType())<=0;
	}

}
