/**
 * 
 */
package org.cmg.ml.sam.klaim.core;

/**
 * @author loreti
 *
 */
public class Template {
	
	private TemplateField[] fields;

	public Template(TemplateField ...fields ) {
		this.fields = fields;
	}

	public int length() {
		return fields.length;
	}

	public TemplateField getFieldAt(int idx) {
		return fields[idx];
	}

}
