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
package org.cmg.ml.sam.core.mc.pomc;

import java.util.HashMap;

import org.cmg.ml.sam.core.Predicate;
import org.cmg.ml.sam.core.StochasticState;
import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.WeightedElement;
import org.cmg.ml.sam.core.logic.And;
import org.cmg.ml.sam.core.logic.Atomic;
import org.cmg.ml.sam.core.logic.FMap;
import org.cmg.ml.sam.core.logic.FormulaVisitor;
import org.cmg.ml.sam.core.logic.ModelCheckerI;
import org.cmg.ml.sam.core.logic.Next;
import org.cmg.ml.sam.core.logic.Not;
import org.cmg.ml.sam.core.logic.Or;
import org.cmg.ml.sam.core.logic.PCheck;
import org.cmg.ml.sam.core.logic.PathFormula;
import org.cmg.ml.sam.core.logic.PathFormulaVisitor;
import org.cmg.ml.sam.core.logic.StateFormula;
import org.cmg.ml.sam.core.logic.Until;

/**
 * @author loreti
 *
 */
public class OnTheFlyProbabilisticModelChecker<T extends StochasticState<T>> implements FormulaVisitor<T, Boolean>, PathFormulaVisitor<T, Double>, ModelCheckerI<T> {
	
	private HashMap<Until<T>, UntilStructure<T>> cache;
	
	public OnTheFlyProbabilisticModelChecker() {
		this.cache = new HashMap<Until<T>, UntilStructure<T>>();
	}
	
	public boolean sat( T t , StateFormula<T> f ) {
		return f.accept(this, t);
	}
	
	public double getProbability( T t , PathFormula<T> f) {
		return f.accept(this, t);
	}

	@Override
	public Boolean visitTrue(T s) {
		return true;
	}

	@Override
	public Boolean visitAnd(And<T> f, T s) {
		for (StateFormula<T> arg : f.elements()) {
			if (!sat(s,arg)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Boolean visitOr(Or<T> f, T s) {
		for (StateFormula<T> arg : f.elements()) {
			if (sat(s,arg)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean visitFalse(T s) {
		return false;
	}

	@Override
	public Boolean visitNot(Not<T> f, T s) {
		return !f.getElement().accept(this, s);
	}

	@Override
	public Boolean visitAtomic(Atomic<T> f, T s) {
		return f.sat(s);
	}

	@Override
	public Boolean visitPCheck(PCheck<T> f, T s) {
		return f.getRelation().sat(getProbability(s, f.getPathFormula()), f.getLimit());
	}

	@Override
	public Boolean visitMap(FMap<T> f, T s) {
		for (T r : f.getFunction().apply(s)) {
			if (f.getFormula().accept(this, r)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Double visitNext(Next<T> f, T t) {
		Distribution<T> next = t.getNext();
		double toReturn = 0.0;
		for (WeightedElement<T> weight : next) {
			if (sat(weight.getElement(),f.getStateFormula())) {
				toReturn += weight.getWeight();
			}
		}
		return toReturn;
	}

	@Override
	public Double visitUntil(Until<T> f, T t) {
		UntilStructure<T> structure = getUntilStructure(f);
		return structure.getProbability(t);
	}

	private UntilStructure<T> getUntilStructure(final Until<T> f) {
		UntilStructure<T> structure = null;//cache.get(f);
		if (structure == null) {
			Number bound = f.getUpperBound();
			if (bound == null) {
				structure = new UnboundUntilStructure<T>( new Predicate<T>() {

					@Override
					public boolean sat(T t) {
						return OnTheFlyProbabilisticModelChecker.this.sat( t , f.getLeft() );
					}
					
				}, 
				new Predicate<T>() {

					@Override
					public boolean sat(T t) {
						return OnTheFlyProbabilisticModelChecker.this.sat( t , f.getRight() );
					}
					
				});
			} else {
				structure = new BoundUntilStructure<T>( new Predicate<T>() {
//				structure = new EfficientCompleteBoundUntilStructure<T>( new Predicate<T>() {

					@Override
					public boolean sat(T t) {
						return OnTheFlyProbabilisticModelChecker.this.sat( t , f.getLeft() );
					}
					
				}, 
				bound.intValue(), 
				new Predicate<T>() {

					@Override
					public boolean sat(T t) {
						return OnTheFlyProbabilisticModelChecker.this.sat( t , f.getRight() );
					}
					
				});
			}
			cache.put(f, structure);
		}
		return structure;
	}

	@Override
	public double[] getProbabilities(T state, StateFormula<T> first,
			double deadline, double dt , StateFormula<T> second) {		
		Until<T> until = new Until<T>(first, deadline, second);
		UntilStructure<T> structure = getUntilStructure(until);
		if (dt == 1.0) {
			return structure.getProbabilities(state);
		} else {
			return recomputeResults( structure.getProbabilities(state) , dt , deadline );
		}
	}

	private double[] recomputeResults(
			double[] probabilities, 
			double dt,
			double deadline) {
		double[] toReturn = new double[(int) ((deadline/dt) + 1)];
		int counter = 0;
		for( int i=0 ; i<toReturn.length ; i++ ) {
			if (i*dt >= counter+1) {
				counter++;
			} 
			toReturn[i] = probabilities[counter];
		}		
		return toReturn;
	}

	@Override
	public double getProbabilities(T[] state, PathFormula<T> f) {
		return 0;
	}
	
}
