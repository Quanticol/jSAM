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
package org.cmg.ml.sam.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SimulationDialogOld extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text deadline;
	private Text dt;
	private Label lblIterations;
	private Text iterations;
	private Composite composite;
	private int iterationsValue;
	private double deadlineValue;
	private double dtValue;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public SimulationDialogOld(Shell parent, int style) {
		super(parent, style);
		setText("Simulation...");
	}

	/**
	 * Open the dialog.
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
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(215, 180);
		shell.setText(getText());
		shell.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		composite = new Composite(shell, SWT.NONE);
		composite.setLayoutData(new RowData(208, SWT.DEFAULT));
		composite.setLayout(new GridLayout(3, false));
		
		Label lblStartTime = new Label(composite, SWT.NONE);
		lblStartTime.setSize(26, 152);
		lblStartTime.setText("Deadline:");
		new Label(composite, SWT.NONE);
		
		deadline = new Text(composite, SWT.BORDER);
		deadline.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		deadline.setText("100.0");
		deadline.setSize(30, 152);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Label lblDt = new Label(composite, SWT.NONE);
		lblDt.setSize(35, 152);
		lblDt.setText("Dt:");
		new Label(composite, SWT.NONE);
		
		dt = new Text(composite, SWT.BORDER);
		dt.setText("0.1");
		dt.setSize(35, 152);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		lblIterations = new Label(composite, SWT.NONE);
		lblIterations.setSize(35, 152);
		lblIterations.setText("Iterations:");
		new Label(composite, SWT.NONE);
				iterations = new Text(composite, SWT.BORDER);
				iterations.setText("100");
		iterations.setSize(35, 152);
		
		Composite composite_1 = new Composite(shell, SWT.NONE);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
		composite_1.setLayoutData(new RowData(208, SWT.DEFAULT));
		
		Button btnOk = new Button(composite_1, SWT.NONE);
		btnOk.setText("Ok");
		btnOk.addSelectionListener( new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				setResult( true );
				shell.close();
			}
			
		});

		Button btnCancel = new Button(composite_1, SWT.NONE);
		btnCancel.setText("Cancel");
		btnCancel.addSelectionListener( new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
			
		});
		
	}

	protected void setResult(boolean result) {
		this.result = true;
		this.iterationsValue = _getIterations();
		this.deadlineValue = _getDeadline();
		this.dtValue = _getDt();
	}
	
	private int _getIterations() {
		try {
			return Integer.parseInt(iterations.getText());			
		} catch (NumberFormatException e) {
			return 1;
		}
	}

	private double _getDeadline() {
		try {
			return Double.parseDouble(deadline.getText());			
		} catch (NumberFormatException e) {
			return 10.0;
		}
	}

	private double _getDt() {
		try {
			return Double.parseDouble(dt.getText());			
		} catch (NumberFormatException e) {
			return 0.1;
		}
	}

	public int getIterations() {
		return iterationsValue;
	}
	
	public double getDt() {
		return dtValue;
	}

	public double getDeadline() {
		return deadlineValue;
	}
}
