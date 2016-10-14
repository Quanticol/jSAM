/*
 * Michele Loreti, Concurrency and Mobility Group
 * Universit� di Firenze, Italy
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

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/**
 * This interface is implemented by the classes providing an extension point
 * related to a model checker.
 * 
 * @author loreti
 *
 */
public interface IModelCheckerExtensionPoint {
	
	/**
	 * Creates a SWT Composite that will be rendered in the model-checking dialog. 
	 * 
	 * @param file the file containing the specification
	 * @param model model of specification
	 * @param main a reference to the main shell
	 * @param folder a reference to the TabFolder that will contain the composite
	 */
	Composite createModelCheckingComposite( IFile file, EObject model, Shell main, Composite folder );

	/**
	 * Returns the name of the extension point. 
	 * 
	 * @return the name of the extension point.
	 */
	String getName();

}
