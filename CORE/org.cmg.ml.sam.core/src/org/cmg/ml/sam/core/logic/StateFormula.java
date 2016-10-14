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
public abstract class StateFormula<T> {// extends MarkovState<T>> {
	
	private Integer hc;
	
	public abstract <R> R accept(FormulaVisitor<T,R> v,T s);
	protected abstract int _hashCode();
	protected abstract boolean _equals( StateFormula<?> f );

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof StateFormula<?>) {
			return _equals((StateFormula<?>) obj);
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


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	} 
	
	
	
	
}
