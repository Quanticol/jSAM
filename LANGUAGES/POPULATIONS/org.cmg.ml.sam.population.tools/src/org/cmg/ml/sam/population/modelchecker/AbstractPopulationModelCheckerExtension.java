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
package org.cmg.ml.sam.population.modelchecker;

import org.cmg.ml.sam.IModelCheckerExtensionPoint;
import org.cmg.ml.sam.SamProjectHelper;
import org.cmg.ml.sam.population.PopulationSpecification;
import org.cmg.ml.sam.xtext.population.population.Model;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/**
 * @author loreti
 *
 */
public abstract class AbstractPopulationModelCheckerExtension implements IModelCheckerExtensionPoint {

	@Override
	public Composite createModelCheckingComposite(IFile file, EObject model,
			Shell main, Composite parent) {
		if (!(model instanceof Model)) {
			return null;
		}
		PopulationSpecification spec = null;
		try {
			spec = (PopulationSpecification) SamProjectHelper.loadClassFromProject(PopulationSpecification.class.getClassLoader() , model.eResource(), file.getProject()).newInstance();
			return createPopulationModelCheckingComposite( main , parent , spec );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}

	protected abstract Composite createPopulationModelCheckingComposite(Shell main,
			Composite parent, PopulationSpecification spec);


}
