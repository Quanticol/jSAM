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
package org.cmg.ml.sam.jobs;

import org.cmg.ml.sam.core.sim.ProbabilisticSimulator;
import org.cmg.ml.sam.core.sim.SimulationController;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

/**
 * @author loreti
 *
 */
public class SimulationJob implements IRunnableWithProgress {

	private ProbabilisticSimulator<?> simulator;
	private String description;
	private int iterations;

	/**
	 * @param name
	 */
	public SimulationJob(String name , String description , int iterations ,  ProbabilisticSimulator<?> simulator ) {
//		super(name);
		this.simulator = simulator;
		this.description = description;
		this.iterations = iterations;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void run(final IProgressMonitor monitor) {
		monitor.beginTask(description, iterations);
		SimulationController h = new SimulationController() {
			
			@Override
			public boolean isCanceled() {
				return monitor.isCanceled();
			}

			@Override
			public void startSimulationRun(int iteration) {
				monitor.subTask("Iteration "+iteration);
			}

			@Override
			public void simulationStepDone() {
			}

			@Override
			public void endSimulationRun(int iteration) {
			}

			
		};
		for( int i=0 ; (i<iterations)&&(!monitor.isCanceled()) ; i++ ) {
			monitor.subTask("Iteration "+i+" of "+iterations);
			simulator.doARun(h);
			monitor.worked(1);
		}
		monitor.done();
//		if (monitor.isCanceled()) {
//			return Status.CANCEL_STATUS;
//		}
//		return Status.OK_STATUS;
	}

}
