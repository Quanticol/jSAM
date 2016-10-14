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

import org.cmg.ml.sam.core.Predicate;

/**
 * @author loreti
 *
 */
public class Atomic<T> extends StateFormula<T> {

	private Predicate<T> predicate; 
	
	public Atomic( Predicate<T> predicate ) {
		this.predicate = predicate;
	}

	@Override
	public <R> R accept(FormulaVisitor<T, R> v, T s) {
		return v.visitAtomic(this, s);
	}

	@Override
	protected int _hashCode() {
		return predicate.hashCode();
	}

	@Override
	protected boolean _equals(StateFormula<?> f) {
		if (f instanceof Atomic<?>) {
			return predicate.equals(((Atomic<?>) f).predicate);
		}
		return false;
	}
	
	public boolean sat(T t) {
		return predicate.sat(t);
	}
	
}
