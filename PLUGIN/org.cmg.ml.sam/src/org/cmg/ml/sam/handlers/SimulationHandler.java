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
package org.cmg.ml.sam.handlers;

import java.util.HashSet;
import java.util.LinkedList;

import org.cmg.ml.sam.ISimulator;
import org.cmg.ml.sam.dialogs.SimulationDialog;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.editor.XtextEditor;


/**
 * @author loreti
 *
 */
public class SimulationHandler extends AbstractToolHandler {

	private static final String JSAMSIMULATOR_ID = "org.cmg.ml.sam.extensions.simulator"; //$NON-NLS-1$

	int count = 0;

	private IConfigurationElement[] simulators;
	private HashSet<String> languages;
	
	public SimulationHandler( ) {
		this.languages = new HashSet<String>();
		IExtensionRegistry platformRegistry = Platform.getExtensionRegistry();
		this.simulators = platformRegistry .getConfigurationElementsFor(JSAMSIMULATOR_ID);
		for (IConfigurationElement e : this.simulators) {
			this.languages.add(e.getAttribute("language"));
		}
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor editor = getXtextEditor(event);
		if (editor == null) {
			return null;
		}
		EObject model = getModel(editor);
		if (model == null) {
			return null;
		}
		IFile file = (IFile) editor.getResource();
		String extension = file.getFileExtension();
		LinkedList<ISimulator> languageSimulators = loadSimulators(extension);
		if (languageSimulators.size() == 0) {
			return null;
		}
		SimulationDialog dialog = new SimulationDialog(file,model,languageSimulators , HandlerUtil.getActiveShell(event),  SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		dialog.open();		
		return null;
	}

	private LinkedList<ISimulator> loadSimulators( String fileExtension ) {
		LinkedList<ISimulator> toReturn = new LinkedList<ISimulator>();
		for (IConfigurationElement e : simulators) {
			if (e.getAttribute("language").equals(fileExtension)) {
				try {
					ISimulator s = (ISimulator) e.createExecutableExtension("class");
					toReturn.add(  s );
				} catch (CoreException e1) {
				}
			}
			System.out.println("Ext: "+e.getAttribute("language")+" Simulator: "+e.getAttribute("class"));
		}		
		return toReturn;
	}
}
