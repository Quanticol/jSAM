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
package org.cmg.ml.sam.population.modelchecker;

import java.lang.reflect.InvocationTargetException;

import org.cmg.ml.sam.core.logic.ModelCheckerI;
import org.cmg.ml.sam.core.logic.PathFormula;
import org.cmg.ml.sam.population.FastSimulationState;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

/**
 * @author loreti
 *
 */
public class SatIntervalComputationJob implements IRunnableWithProgress {

	private ModelCheckerI<FastSimulationState> modelChecker;
	private FastSimulationState[] states;
	private PathFormula<FastSimulationState> pathFormula;
	private int from;
	private int to;
	private double[] probabilities;

	public SatIntervalComputationJob(
			ModelCheckerI<FastSimulationState> modelChecker,
			FastSimulationState[] states,
			PathFormula<FastSimulationState> pathFormula,
			int from, int to) {
		this.modelChecker = modelChecker;
		this.states = states;
		this.pathFormula = pathFormula;
		this.from = from;
		this.to = to;
		if (from > to) {
			throw new IllegalArgumentException();
		}
		this.probabilities = new double[(to-from)+1];
	}

	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException,
			InterruptedException {
		monitor.beginTask("Model-checking...", (to-from)+1);
		for ( int i=0 ; i<states.length ; i++ ) {
			monitor.subTask("Model-checking at time "+(from+i));
			probabilities[i] = modelChecker.getProbability(states[i], pathFormula);
			monitor.worked(1);
		}
	}

	public double[] getProbabilities() {
		return probabilities;
	}

}
