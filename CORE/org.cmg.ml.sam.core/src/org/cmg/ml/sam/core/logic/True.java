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

import org.cmg.ml.sam.core.StochasticState;

/**
 * @author loreti
 *
 */
public class True<T extends StochasticState<T>> extends StateFormula<T> {

	@Override
	public <R> R accept(FormulaVisitor<T, R> v, T s) {
		return v.visitTrue(s);
	}

	@Override
	protected int _hashCode() {
		return 1;
	}
	
	@Override
	protected boolean _equals(StateFormula<?> f) {		
		return f instanceof True<?>;
	}


}
