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

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

import org.cmg.ml.sam.SamProjectHelper;
import org.cmg.ml.sam.core.sim.DefaultRandomGenerator;
import org.cmg.ml.sam.core.sim.Measure;
import org.cmg.ml.sam.core.sim.ProbabilisticSimulator;
import org.cmg.ml.sam.core.sim.SimulationSeries;
import org.cmg.ml.sam.jobs.SimulationJob;
import org.cmg.ml.sam.population.FastSimulationState;
import org.cmg.ml.sam.population.PopulationSpecification;
import org.cmg.ml.sam.population.PopulationState;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Text;

/**
 * @author loreti
 *
 */
public class FastSimulationComposite extends Composite {

	private Shell main;
	private PopulationSpecification spec;
	private Combo combo;
	private Spinner deadline;


	public FastSimulationComposite(Shell main, Composite parent , PopulationSpecification spec) {
		super( parent , SWT.NONE );
		this.main = main;
		this.spec = spec;
		buildComposite();
	}
	
	
	private void buildComposite() {

//		shell = new Shell(getParent(), getStyle());
//		shell.setSize(215, 180);
//		shell.setText(getText());
//		shell.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		this.setLayoutData(new RowData(208, SWT.DEFAULT));
		this.setLayout(new GridLayout(2, false));

		Label lblSystem = new Label(this, SWT.NONE);
		lblSystem.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSystem.setSize(26, 152);
		lblSystem.setText("System:");
		
		combo = new Combo(this, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		combo.setItems(spec.getConfigurationNames());
		
		Label lblStartTime = new Label(this, SWT.NONE);
		lblStartTime.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblStartTime.setSize(26, 152);
		lblStartTime.setText("Deadline:");
		
//		Text deadline = new Text(composite, SWT.BORDER);
//		deadline.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
//		deadline.setText("100.0");
//		deadline.setSize(30, 152);
		deadline = new Spinner(this, SWT.BORDER | SWT.RIGHT_TO_LEFT);
		deadline.setMinimum(0);
		deadline.setMaximum(Integer.MAX_VALUE);
		deadline.setSelection(100);
		deadline.setIncrement(1);
		deadline.setPageIncrement(100);
		deadline.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
						
						Composite composite = new Composite(this, SWT.NONE);
						composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, true, 2, 1));
						composite.setLayout(new FillLayout(SWT.HORIZONTAL));
						
						
//		Composite composite_1 = new Composite(composite, SWT.NONE);
//		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
//		composite_1.setLayoutData(new RowData(208, SWT.DEFAULT));
//		
						Button btnOk = new Button(composite, SWT.NONE);
						btnOk.setText("Ok");
						btnOk.addSelectionListener( new SelectionAdapter() {

							@Override
							public void widgetSelected(SelectionEvent e) {
								if (validate()) {
									scheduleSimulationJob();
								} else {
									MessageDialog.openInformation(
											main,
											"SAM",
											"No configuration has been selected!");
								}
								main.close();
							}
							
						});
						
								Button btnCancel = new Button(composite, SWT.NONE);
								btnCancel.setText("Cancel");
								btnCancel.addSelectionListener( new SelectionAdapter() {

									@Override
									public void widgetSelected(SelectionEvent e) {
										main.close();
									}
									
								});
	}
	
	protected boolean validate() {
		if (combo.getSelectionIndex()<0) {
			return false;
		}
		return true;
	}


	private void scheduleSimulationJob( ) {
		int foo = combo.getSelectionIndex();
		if (foo < 0) {
			return ;
		}
		String configurationName = combo.getItem(foo);
		FastSimulationState state = spec.getFastSimulationConfiguration(configurationName);
		ProbabilisticSimulator<FastSimulationState> simulator = new ProbabilisticSimulator<FastSimulationState>(new DefaultRandomGenerator(), spec.getModule().getMeanFieldStochasticProcess() , state, spec.getMeasuresOfFastState()  , deadline.getSelection(), 1);
		SimulationJob job = new SimulationJob("Name", "Simulating "+configurationName, 1, simulator);
		try {
			new ProgressMonitorDialog(main).run(true, true, job);
			List<SimulationSeries> series = simulator.getSeries();
			MessageBox dialog = new MessageBox(main, SWT.ICON_QUESTION | SWT.YES| SWT.NO);
			dialog.setText("Dave data");
			dialog.setMessage("Do you save data into an external folder?");					
			if (dialog.open() == SWT.YES) {
				DirectoryDialog fileDialog = new DirectoryDialog(main);
				String file = fileDialog.open();
				SamProjectHelper.saveSeriesData(file,series);
			}
			SamProjectHelper.getGraphView().addGraph(configurationName+" Simulation ["+deadline.getSelection()+"]", series);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		job.schedule();
	}
}
