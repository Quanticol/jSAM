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
package org.cmg.ml.views;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cmg.ml.sam.core.sim.Measure;
import org.cmg.ml.sam.core.sim.SimulationSeries;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.nebula.visualization.xygraph.figures.IXYGraph;
import org.eclipse.nebula.visualization.xygraph.figures.ToolbarArmedXYGraph;
import org.eclipse.nebula.visualization.xygraph.figures.Trace;
import org.eclipse.nebula.visualization.xygraph.figures.Trace.ErrorBarType;
import org.eclipse.nebula.visualization.xygraph.figures.Trace.PointStyle;
import org.eclipse.nebula.visualization.xygraph.figures.XYGraph;

public class GraphView extends ViewPart {

	public static final String ID = "org.cmg.ml.sam.views.GraphView"; //$NON-NLS-1$
	private CTabFolder tabFolder;

	public GraphView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		{
			tabFolder = new CTabFolder(container, SWT.BORDER);
			tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		}

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
//		IToolBarManager toolbarManager = getViewSite().getActionBars()
//				.getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
//		IMenuManager menuManager = getViewSite().getActionBars()
//				.getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
	
	public void addGraph( String graphName , List<SimulationSeries> list ) {
		CTabItem item = new CTabItem(tabFolder, SWT.CLOSE );
		item.setText(graphName);
		Canvas canvas = new Canvas(tabFolder, SWT.NONE);
		final LightweightSystem lws = new LightweightSystem(canvas);
		tabFolder.setSelection(tabFolder.getItemCount()-1);
		XYGraph xyGraph = new XYGraph();
		
		ToolbarArmedXYGraph toolbarArmedXYGraph = new ToolbarArmedXYGraph(xyGraph);

		xyGraph.setTitle("Simple Example");
		//set it as the content of LightwightSystem
		lws.setContents(toolbarArmedXYGraph);

		for (SimulationSeries series : list) {
			Trace trace = new Trace(series.getName() , 
					xyGraph.primaryXAxis, xyGraph.primaryYAxis, new SAMDataProvider(series.getSeries()));	
			
			//set trace property
			trace.setPointStyle(PointStyle.XCROSS);
			
			//add the trace to xyGraph
			xyGraph.addTrace(trace);	
		}
		xyGraph.primaryXAxis.setAutoScale(true);
		xyGraph.primaryYAxis.setAutoScale(true);
		item.setControl(canvas);
	}

	public void addGraph( String graphName , String traceName , double[] data , double dt ) {
		addGraph( graphName , traceName , data , 0.0 , dt );
	}

	
	public void addGraph( String graphName , String traceName , double[] data , double start , double dt ) {
		CTabItem item = new CTabItem(tabFolder, SWT.CLOSE );
		item.setText(graphName);
		Canvas canvas = new Canvas(tabFolder, SWT.NONE);
		final LightweightSystem lws = new LightweightSystem(canvas);
		tabFolder.setSelection(tabFolder.getItemCount()-1);
		XYGraph xyGraph = new XYGraph();
		
		ToolbarArmedXYGraph toolbarArmedXYGraph = new ToolbarArmedXYGraph(xyGraph);

		xyGraph.setTitle("Simple Example");
		//set it as the content of LightwightSystem
		lws.setContents(toolbarArmedXYGraph);

		Trace trace = new Trace(traceName ,  xyGraph.primaryXAxis, xyGraph.primaryYAxis, new SAMDataProvider(data,dt));	
			
		//set trace property
		trace.setPointStyle(PointStyle.XCROSS);
		
		//add the trace to xyGraph
		xyGraph.addTrace(trace);	

		xyGraph.primaryXAxis.setAutoScale(true);
		xyGraph.primaryYAxis.setAutoScale(true);
		item.setControl(canvas);
	}


}
