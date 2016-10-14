/**
 * 
 */
package org.cmg.ml.sam.population;

import org.cmg.ml.sam.SAMPlugIn;

/**
 * @author loreti
 *
 */
public class PopulationPlugIn implements SAMPlugIn {

	public static final String LANGUAGE_NAME = "Population Specification Language";
	public static final String LANGUAGE_EXTENSION = "pop";

	/**
	 * 
	 */
	public PopulationPlugIn() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.SAMPlugIn#getLanguageName()
	 */
	@Override
	public String getLanguageName() {
		return LANGUAGE_NAME;
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.SAMPlugIn#getFileExtension()
	 */
	@Override
	public String getFileExtension() {
		return LANGUAGE_EXTENSION;
	}

}
