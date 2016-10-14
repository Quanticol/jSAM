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
package org.cmg.ml.sam.core.mc.stat;

import java.util.Random;

import org.cmg.ml.sam.core.Predicate;
import org.cmg.ml.sam.core.StochasticState;
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
import org.cmg.ml.sam.core.logic.Relation;
import org.cmg.ml.sam.core.logic.StateFormula;
import org.cmg.ml.sam.core.logic.Until;

/**
 * @author loreti
 *
 */
public class StatisticProbabilisticModelChecker<T extends StochasticState<T>> implements FormulaVisitor<T, Boolean>, ModelCheckerI<T> {
	
	private double delta;
	private double alpha;
	private double beta;
	private Random r;
	
	public StatisticProbabilisticModelChecker() {

	}
	
	public boolean sat( T t , StateFormula<T> f ) {
		return f.accept(this, t);
	}
	
	public double getProbability( T t , PathFormula<T> f) {
		return 0;
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
	public Boolean visitPCheck(PCheck<T> f, final T s) {
		PathFormula<T> pf = f.getPathFormula();
		final Relation rel = f.getRelation();
		final double p = f.getLimit();
		return pf.accept(new PathFormulaVisitor<T,Boolean>() {

			@Override
			public Boolean visitNext(Next<T> f, T t) {
				throw new IllegalArgumentException("Statistica Model Checking: Unsupported model operator (Next)!");
			}

			@Override
			public Boolean visitUntil(final Until<T> f, T t) {
				Number limit = f.getUpperBound();
				if (limit == null) {
					throw new IllegalArgumentException("Statistica Model Checking: Unsupported model operator (Unbound until)!");
				}
				return sequentialTest(s, rel, p, new Predicate<T>() {

					@Override
					public boolean sat(T t) {
						return StatisticProbabilisticModelChecker.this.sat( t , f.getLeft() );
					}
					
				}, limit.doubleValue(), new Predicate<T>() {

					@Override
					public boolean sat(T t) {
						return StatisticProbabilisticModelChecker.this.sat( t , f.getRight() );
					}
					
				});
			}
			
		}, s);
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

	protected boolean sequentialTest( T s , Relation rel , double p , Predicate<T> left , double bound , Predicate<T> right ) {
//		double p1 = p-delta;
//		double p0 = p+delta;
//		double logA = Math.log((1-beta)/alpha);
//		double logB = Math.log(beta/(1-alpha));
//		double d = 0.0;
//		while ((logB<d)&&(d<logA)) {
//			if (s.simulate(r,left,bound,right)) {
//				d += Math.log(p1/p0);
//			} else {
//				d += Math.log((1-p1)/(1-p0));
//			}
//		}
//		if ((rel==Relation.GEQ)||(rel==Relation.GTR)) {
//			return (d<=logB);
//		} else {
//			return (d>logB);
//		}
		return false;
	}

	@Override
	public double[] getProbabilities(T state, StateFormula<T> first,
			double deadline, double dt , StateFormula<T> second) {
		//FIXME!
		return null;
	}

	@Override
	public double getProbabilities(T[] state, PathFormula<T> f) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
