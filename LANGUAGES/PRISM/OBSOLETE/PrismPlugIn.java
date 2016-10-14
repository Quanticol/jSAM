/**
 * 
 */
package org.cmg.ml.sam.prism.obsolete;

import org.cmg.ml.sam.SAMPlugIn;

/**
 * @author loreti
 *
 */
public class PrismPlugIn implements SAMPlugIn {

	public static final String LANGUAGE_NAME = "Prism Language";
	private static final String LANGUAGE_EXTENSION = "pm";

	@Override
	public String getLanguageName() {
		return LANGUAGE_NAME;
	}

	@Override
	public String getFileExtension() {
		return LANGUAGE_EXTENSION;
	}

}
