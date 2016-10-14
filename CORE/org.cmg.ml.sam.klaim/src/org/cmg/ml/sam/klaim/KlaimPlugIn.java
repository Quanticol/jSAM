/**
 * 
 */
package org.cmg.ml.sam.klaim;

import org.cmg.ml.sam.SAMPlugIn;

/**
 * @author loreti
 *
 */
public class KlaimPlugIn implements SAMPlugIn {

	public static final String LANGUAGE_NAME = "Klaim Specification Language";
	public static final String LANGUAGE_EXTENSION = "net";

	/**
	 * 
	 */
	public KlaimPlugIn() {
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
