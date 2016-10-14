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
package org.cmg.ml.sam.population.simulator;

import org.cmg.ml.sam.ISimulator;
import org.cmg.ml.sam.SamProjectHelper;
import org.cmg.ml.sam.population.PopulationSpecification;
import org.cmg.ml.sam.xtext.population.PopulationCompiler;
import org.cmg.ml.sam.xtext.population.population.Model;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

/**
 * @author loreti
 *
 */
public class PopulationFastSimulator implements ISimulator {

	
	/**
	 * 
	 */
	public PopulationFastSimulator() {
	}


	@Override
	public String getName() {
		return "Fast simulation";
	}


	@Override
	public Composite createSimulationComposite( IFile file, EObject model, Shell main, Composite parent ) {
		if (!(model instanceof Model)) {
			return null;
		}
		PopulationSpecification spec = null;
		try {
			spec = (PopulationSpecification) SamProjectHelper.loadClassFromProject(PopulationSpecification.class.getClassLoader() , model.eResource(), file.getProject()).newInstance();
			return new FastSimulationComposite(main,parent,spec);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}	

}
