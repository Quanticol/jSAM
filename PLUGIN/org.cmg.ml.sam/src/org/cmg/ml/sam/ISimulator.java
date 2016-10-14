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
 * @author loreti
 *
 */
public interface ISimulator {

	/**
	 * @param file TODO
	 * @param model 
	 * @param folder 
	 * @param folder
	 */
	Composite createSimulationComposite( IFile file, EObject model, Shell main, Composite folder );

	/**
	 * @return
	 */
	String getName();

}
