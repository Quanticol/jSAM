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
public class PCheck<T> extends StateFormula<T> {

	private PathFormula<T> path;
	private double limit;
	private Relation rel;
	
	public PCheck( Relation rel , double limit , PathFormula<T> path ) {
		this.rel = rel;
		this.limit = limit;
		this.path = path;
	}

	@Override
	public <R> R accept(FormulaVisitor<T, R> v, T s) {
		return v.visitPCheck(this,s);
	}

	@Override
	protected int _hashCode() {
		return 7*path.hashCode();
	}
	
	@Override
	protected boolean _equals(StateFormula<?> f) {
		if (f instanceof PCheck<?>) {
			PCheck<?> g = (PCheck<?>) f;
			return (limit==g.limit)&&(rel==g.rel)&&(path._equals(g.path));
		}
		return false;
	}

	public PathFormula<T> getPathFormula() {
		return path;
	}

	public Relation getRelation() {
		return rel;
	}

	public double getLimit() {
		return limit;
	}

	
}
