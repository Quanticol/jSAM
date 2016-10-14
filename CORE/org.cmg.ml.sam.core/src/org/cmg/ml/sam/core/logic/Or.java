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

import java.util.Collection;
import java.util.HashSet;

/**
 * @author loreti
 *
 */
public class Or<T> extends StateFormula<T> {

	private HashSet<StateFormula<T>> args = new HashSet<StateFormula<T>>();;
	
	public Or( StateFormula<T> ... args ) {
		for (StateFormula<T> formula : args) {
			this.args.add(formula);
		}
	}
	
	public Or( Collection<StateFormula<T>> args ) {
		for (StateFormula<T> formula : args) {
			this.args.add(formula);
		}
	}

	@Override
	public <R> R accept(FormulaVisitor<T, R> v, T s) {
		return v.visitOr(this,s);
	}

	@Override
	protected int _hashCode() {
		int toReturn = 0;
		for (StateFormula<T> f : args) {
			toReturn = toReturn + f.hashCode();
		}
		return 5*toReturn;
	}	
	
	@Override
	protected boolean _equals(StateFormula<?> f) {
		if (f instanceof And<?>) {
			Or<?> fOr = (Or<?>) f;
			args.equals(fOr.args);
		}
		return false;
	}	

	public Iterable<StateFormula<T>> elements() {
		return args;
	}	


}
