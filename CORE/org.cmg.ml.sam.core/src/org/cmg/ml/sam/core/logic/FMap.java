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
public class FMap<T> extends StateFormula<T> {

	private ProcessFunction<T> map;
	private StateFormula<T> f;
	
	public FMap(ProcessFunction<T> map , StateFormula<T> f) {
		this.map = map;
		this.f = f;
	}
	
	@Override
	public <R> R accept(FormulaVisitor<T, R> v, T s) {
		return v.visitMap(this,s);
	}

	@Override
	protected int _hashCode() {
		return 1;
	}
	
	@Override
	protected boolean _equals(StateFormula<?> f) {
		if (f instanceof FMap<?>) {
			FMap<?> g = (FMap<?>) f;
			return map.equals(g.map)&&this.f._equals(g.f);
		}
		return false;
	}

	public ProcessFunction<T> getFunction() {
		return map;
	}
	
	public StateFormula<T> getFormula() {
		return f;
	}


}
