/*
 * Michele Loreti, Concurrency and Mobility Group
 * Universitą di Firenze, Italy
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
package org.cmg.ml.sam.dialogs;

import java.util.LinkedList;

import org.cmg.ml.sam.ISimulator;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author loreti
 *
 */
public class SimulationDialog extends Dialog {

	private Shell shell;
	private LinkedList<ISimulator> languageSimulators;
	private EObject model;
	private IFile file;


	/**
	 * @param languageSimulators 
	 * @param parent
	 */
	public SimulationDialog(IFile file , EObject model , LinkedList<ISimulator> languageSimulators, Shell parent, int style) {
		super(parent, style);
		setText("Simulation...");
		this.languageSimulators = languageSimulators;
		this.model = model;
		this.file = file;
	}
	
	/**
	 * Open the dialog.
	 * 
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return null;
	}


	/**
	 * 
	 */
	private boolean createContents() {
		shell = new Shell(getParent(), getStyle());
		//shell.setSize(215, 180);
		shell.setText(getText());
		shell.setLayout(new GridLayout());

        // SWT.BOTTOM to show at the bottom

        CTabFolder folder = new CTabFolder(shell, SWT.TOP);

        GridData data = new GridData(SWT.FILL, 
                SWT.FILL, true, true,
                2, 1);

        folder.setLayoutData(data);
        int enabled = 0;
        for (ISimulator simulator : languageSimulators) {
        	CTabItem item = new CTabItem(folder, SWT.NONE);
        	item.setText(simulator.getName());
			Composite c = simulator.createSimulationComposite(file,model, shell,folder);
			if (c != null) {
				item.setControl(c);
				enabled++;
			}
		}
//      shell.pack();
        return (enabled != 0);
	}
	
}
	
