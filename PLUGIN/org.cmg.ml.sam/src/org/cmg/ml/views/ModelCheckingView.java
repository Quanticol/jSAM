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
package org.cmg.ml.views;

import java.util.LinkedList;

import org.cmg.ml.sam.util.Pair;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.part.ViewPart;

/**
 * @author loreti
 *
 */
public class ModelCheckingView extends ViewPart {

	public static final String ID = "org.cmg.ml.sam.views.ModelCheckingView"; //$NON-NLS-1$

	private CTabFolder tabFolder;

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		{
			tabFolder = new CTabFolder(container, SWT.BORDER);
			tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		}

//		createActions();
//		initializeToolBar();
//		initializeMenu();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}
	
	public void addSatisfactionResults( String stateName , LinkedList<Pair<String,Boolean>> results ) {
		CTabItem item = new CTabItem(tabFolder, SWT.CLOSE );
		item.setText(stateName);
		ScrolledComposite scrolledComposite = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Table table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnFormulae = new TableColumn(table, SWT.CENTER);
		tblclmnFormulae.setWidth(310);
		tblclmnFormulae.setText("Formulae");
		
		TableColumn tblclmnModelcheckingResult = new TableColumn(table, SWT.CENTER);
		tblclmnModelcheckingResult.setWidth(138);
		tblclmnModelcheckingResult.setText("Results");
		
		for (Pair<String, Boolean> pair : results) {
			TableItem tableItem = new TableItem(table, SWT.NONE );
			tableItem.setText( new String[] { pair.getFirst() , pair.getSecond()+"" } );
		}
		
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		item.setControl(scrolledComposite);
	}
	
	public void addPathProbabilityResults( String stateName , LinkedList<Pair<String,Double>> results ) {
		CTabItem item = new CTabItem(tabFolder, SWT.CLOSE );
		item.setText(stateName);
		ScrolledComposite scrolledComposite = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Table table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnFormulae = new TableColumn(table, SWT.CENTER);
		tblclmnFormulae.setWidth(310);
		tblclmnFormulae.setText("Formulae");
		
		TableColumn tblclmnModelcheckingResult = new TableColumn(table, SWT.CENTER);
		tblclmnModelcheckingResult.setWidth(138);
		tblclmnModelcheckingResult.setText("Results");
		
		for (Pair<String, Double> pair : results) {
			TableItem tableItem = new TableItem(table, SWT.NONE );
			tableItem.setText( new String[] { pair.getFirst() , pair.getSecond()+"" } );
		}
		
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		item.setControl(scrolledComposite);
	}

}
