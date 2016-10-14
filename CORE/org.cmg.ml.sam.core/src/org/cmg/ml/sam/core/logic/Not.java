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
public class Not<T> extends StateFormula<T> {

	private StateFormula<T> arg;
	
	public Not( StateFormula<T> arg ) {
		this.arg = arg;
	}

	@Override
	public <R> R accept(FormulaVisitor<T, R> v, T s) {
		return v.visitNot(this,s);
	}

	@Override
	protected int _hashCode() {
		return 3*arg.hashCode();
	}

	@Override
	protected boolean _equals(StateFormula<?> f) {		
		return (f instanceof Not<?>)&&(arg._equals(((Not<?>) f).arg));
	}

	public StateFormula<T> getElement() {
		return arg;
	}

}
