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


public abstract class PathFormula<T> {

	private Integer hc;

	public abstract <R> R accept( PathFormulaVisitor<T,R> v , T t );

	protected abstract int _hashCode();

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof PathFormula<?>) {
			return _equals((PathFormula<?>) obj);
		}
		return false;
	}

	@Override
	public int hashCode() {
		if (hc == null) {
			hc = _hashCode();
		}
		return hc;
	}
	
	
	protected abstract boolean _equals(PathFormula<?> path);
	
}
