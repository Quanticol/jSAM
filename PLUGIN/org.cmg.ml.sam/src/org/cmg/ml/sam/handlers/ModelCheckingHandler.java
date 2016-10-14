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

import org.cmg.ml.sam.IModelCheckerExtensionPoint;
import org.cmg.ml.sam.dialogs.ModelCheckingDialog;
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
public class ModelCheckingHandler extends AbstractToolHandler {

	private static final String JSAMMODELCHECKER_ID = "org.cmg.ml.sam.extensions.modelchecker"; //$NON-NLS-1$

	int count = 0;

	private IConfigurationElement[] simulators;
	private HashSet<String> languages;
	
	public ModelCheckingHandler( ) {
		this.languages = new HashSet<String>();
		IExtensionRegistry platformRegistry = Platform.getExtensionRegistry();
		this.simulators = platformRegistry .getConfigurationElementsFor(JSAMMODELCHECKER_ID);
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
		LinkedList<IModelCheckerExtensionPoint> languageSimulators = loadModelCheckers(extension);
		if (languageSimulators.size() == 0) {
			return null;
		}
		ModelCheckingDialog dialog = new ModelCheckingDialog(file,model,languageSimulators , HandlerUtil.getActiveShell(event),  SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		dialog.open();		
		return null;
	}

	private LinkedList<IModelCheckerExtensionPoint> loadModelCheckers( String fileExtension ) {
		LinkedList<IModelCheckerExtensionPoint> toReturn = new LinkedList<IModelCheckerExtensionPoint>();
		for (IConfigurationElement e : simulators) {
			if (e.getAttribute("language").equals(fileExtension)) {
				try {
					IModelCheckerExtensionPoint s = (IModelCheckerExtensionPoint) e.createExecutableExtension("class");
					toReturn.add(  s );
				} catch (CoreException e1) {
				}
			}
			System.out.println("Ext: "+e.getAttribute("language")+" Model-checker: "+e.getAttribute("class"));
		}		
		return toReturn;
	}
}
