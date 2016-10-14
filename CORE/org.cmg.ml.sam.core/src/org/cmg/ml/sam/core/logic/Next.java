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
public class Next<T> extends PathFormula<T> {

	public StateFormula<T> arg;	
	
	public Next(StateFormula<T> arg) {
		this.arg = arg;
	}

	@Override
	public <R> R accept(PathFormulaVisitor<T, R> v, T s) {
		return v.visitNext(this,s);
	}

	@Override
	protected int _hashCode() {
		return 2*arg.hashCode();
	}

	@Override
	protected boolean _equals(PathFormula<?> path) {
		if (path instanceof Next<?>) {
			return arg._equals(((Next<?>) path).arg);
		}
 		return false;
	}

	public StateFormula<T> getStateFormula() {
		return arg;
	}


}
