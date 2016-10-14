/**
 * 
 */
package org.cmg.ml.sam.klaim.core;

/**
 * @author loreti
 *
 */
public interface TemplateField extends Comparable<KValue> {

	public boolean match( KValue v );

	public boolean matchGreaterThan(KValue value);

	public boolean matchLessThan(KValue value);
	
}
