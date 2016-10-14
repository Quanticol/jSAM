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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;

import org.eclipse.e4.core.di.annotations.Execute;

/**
 * @author loreti
 *
 */
public class SAMPlugInLoader {
	
	private static final String JSAMCOMPONENT_ID = "org.cmg.ml.sam.extensionpoint.definition.component"; //$NON-NLS-1$

	@Execute
	public void execute(IExtensionRegistry registry) {
		loadComponents(registry);
	}
	
	/**
	 * 
	 */
	private void loadComponents(IExtensionRegistry registry) {
		SAMRegistry samRegistry = SAMRegistry.getInstance();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(JSAMCOMPONENT_ID);
	    try {
	        for (IConfigurationElement e : config) {
	          final Object o = e.createExecutableExtension("class");
	          if (o instanceof SAMPlugIn) {
	        	  samRegistry.registerPlugIn((SAMPlugIn) o);
	          }
	        }
	      } catch (CoreException ex) {
	        System.out.println(ex.getMessage());
	      }
	}


}
