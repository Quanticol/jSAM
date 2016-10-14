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
package org.cmg.ml.sam.core.logic;

/**
 * @author loreti
 *
 */
public interface ModelCheckerI<T> {
	
	public boolean sat( T state , StateFormula<T> f );
	
	public double getProbability( T state , PathFormula<T> f );
	
	public double[] getProbabilities( T state , StateFormula<T> first , double deadline , double dt , StateFormula<T> second );
	
	public double getProbabilities( T[] state , PathFormula<T> f );

}
