/*
 * Michele Loreti, Concurrency and Mobility Group
 * Universit� di Firenze, Italy
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
public class Until<T> extends PathFormula<T> {

	public StateFormula<T> left;	
	public StateFormula<T> right;
	public Number lowerBound;
	public Number upperBound;
	
	public Until( StateFormula<T> left, StateFormula<T> right) {
		this(left,null,right);
	}

	public Until(StateFormula<T> left, Number limit, StateFormula<T> right) {
		this(left,null,limit,right);
	}

	public Until(StateFormula<T> left, Number lowerIntervalBound , Number upperIntervalBound , StateFormula<T> right) {
		this.left = left;
		this.lowerBound=lowerIntervalBound;
		this.upperBound=upperIntervalBound;
		this.right = right;
	}

	@Override
	public <R> R accept(PathFormulaVisitor<T, R> v, T s) {
		return v.visitUntil(this,s);
	}

	@Override
	protected int _hashCode() {
		return 3*(left.hashCode()^right.hashCode());
	}
	
	@Override
	protected boolean _equals(PathFormula<?> path) {
		if (path instanceof Until<?>) {
			boolean toReturn = true;
			Until<?> until = (Until<?>) path;
			if (upperBound == null) {
				toReturn = (until.upperBound == null);
			} else {
				toReturn = upperBound.equals(until.upperBound);
			}
			return toReturn&&left._equals(((Until<?>) path).left)&&
					right._equals(((Until<?>) path).right);
		}
 		return false;
	}

	public Number getLowerBound() {
		return lowerBound;
	}

	public Number getUpperBound() {
		return upperBound;
	}

	public StateFormula<T> getLeft() {
		return left;
	}

	public StateFormula<T> getRight() {
		return right;
	}
		
}
