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

import java.lang.reflect.InvocationTargetException;

import org.cmg.ml.sam.core.logic.ModelCheckerI;
import org.cmg.ml.sam.core.logic.StateFormula;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

/**
 * @author loreti
 *
 */
public class PathProbabilityComputationJob<T> implements IRunnableWithProgress {
	
	private ModelCheckerI<T> modelChecker;
	private T state;
	private StateFormula<T> firstFormula;
	private StateFormula<T> secondFormula;
	private double deadline;
	private double dt;
	private double[] probabilities;

	/**
	 * @param modelChecker
	 * @param state
	 * @param firstFormula
	 * @param secondFormula
	 * @param deadline
	 * @param d
	 */
	public PathProbabilityComputationJob(
			ModelCheckerI<T> modelChecker,
			T state,
			StateFormula<T> firstFormula,
			StateFormula<T> secondFormula, 
			double deadline,
			double dt) {
		this.modelChecker = modelChecker;
		this.state = state;
		this.firstFormula = firstFormula;
		this.secondFormula = secondFormula;
		this.deadline = deadline;
		this.dt = dt;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException,
			InterruptedException {
		this.probabilities = modelChecker.getProbabilities(state, firstFormula, deadline, dt, secondFormula);
	}
	
	public double[] getProbabilities() {
		return probabilities;
	}

}
