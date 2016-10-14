/*
 * Michele Loreti, Concurrency and Mobility Group
 * Universitˆ di Firenze, Italy
 * (C) Copyright 2013.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Michele Loreti
 */
package org.cmg.ml.sam;

/**
 * @author Michele Loreti
 *
 */
public interface SAMPlugIn {

	/**
	 * Returns plug-in name. 
	 * 
	 * @return plug-in name.
	 */
	String getLanguageName();

	/**
	 * Returns the extension associated to specification file.
	 * 
	 * @return the extension associated to specification file.
	 */
	String getFileExtension();

}
