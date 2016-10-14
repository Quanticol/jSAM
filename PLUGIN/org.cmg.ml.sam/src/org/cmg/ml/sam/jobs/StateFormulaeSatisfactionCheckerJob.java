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
import java.util.Iterator;
import java.util.LinkedList;

import org.cmg.ml.sam.core.logic.ModelCheckerI;
import org.cmg.ml.sam.core.logic.StateFormula;
import org.cmg.ml.sam.util.Pair;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

/**
 * @author loreti
 *
 */
public class StateFormulaeSatisfactionCheckerJob<T> implements IRunnableWithProgress {
	
	private ModelCheckerI<T> modelChecker;
	private T state;
	private LinkedList<Pair<String, StateFormula<T>>> formulae;
	private LinkedList<Pair<String,Boolean>> results;

	public StateFormulaeSatisfactionCheckerJob( ModelCheckerI<T> modelChecker , T state , LinkedList<Pair<String,StateFormula<T>>> formulae ) {
		this.modelChecker = modelChecker;
		this.state = state;
		this.formulae = formulae;
		this.results = new LinkedList<Pair<String,Boolean>>();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException,
			InterruptedException {
		monitor.beginTask("Model-checking...", formulae.size());
		for (Iterator<Pair<String,StateFormula<T>>> iterator = formulae.iterator(); iterator.hasNext()&&!monitor.isCanceled();) {
			Pair<String,StateFormula<T>> next = iterator.next();
			monitor.subTask("Model-checking: "+next.getFirst());
			results.add(new Pair<String,Boolean>( next.getFirst() , modelChecker.sat(state, next.getSecond())));
			monitor.worked(1);
		}
	}
	
	public LinkedList<Pair<String,Boolean>> getResults() {
		return results;
	}

}
