/**
 * 
 */
package org.cmg.ml.sam.klaim.smc;

import java.util.LinkedList;
import java.util.Random;

import org.cmg.ml.sam.core.logic.And;
import org.cmg.ml.sam.core.logic.Atomic;
import org.cmg.ml.sam.core.logic.FMap;
import org.cmg.ml.sam.core.logic.FormulaVisitor;
import org.cmg.ml.sam.core.logic.Next;
import org.cmg.ml.sam.core.logic.Not;
import org.cmg.ml.sam.core.logic.Or;
import org.cmg.ml.sam.core.logic.PCheck;
import org.cmg.ml.sam.core.logic.PathFormulaVisitor;
import org.cmg.ml.sam.core.logic.StateFormula;
import org.cmg.ml.sam.core.logic.Until;
import org.cmg.ml.sam.klaim.core.Net;
import org.cmg.ml.sam.klaim.core.NetTransition;

/**
 * @author loreti
 *
 */
public class StatisticalModelChecekr implements 
	FormulaVisitor<Net, Boolean>,
	PathFormulaVisitor<Net, Double>{
	
	public StatisticalModelChecekr(double perror, double delta) {
		super();
		this.perror = perror;
		this.delta = delta;
	}

	public StatisticalModelChecekr() {
		this(0.1,0.1);
	}

	private double perror = 0.1;
	private double delta = 0.1;
	
	

	@Override
	public Boolean visitTrue(Net s) {
		return true;
	}

	@Override
	public Boolean visitAnd(And<Net> f, Net s) {
		for (StateFormula<Net> e : f.elements()) {
			if (!e.accept(this, s)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Boolean visitOr(Or<Net> f, Net s) {
		for (StateFormula<Net> e : f.elements()) {
			if (e.accept(this, s)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean visitFalse(Net s) {
		return false;
	}

	@Override
	public Boolean visitNot(Not<Net> f, Net s) {
		return !f.getElement().accept(this, s);
	}

	@Override
	public Boolean visitAtomic(Atomic<Net> f, Net s) {
		return f.sat(s);
	}

	@Override
	public Boolean visitPCheck(PCheck<Net> f, Net s) {
		return f.getRelation().sat(f.getPathFormula().accept(this, s), f.getLimit());
	}

	@Override
	public Boolean visitMap(FMap<Net> f, Net s) {
		LinkedList<Net> result = f.getFunction().apply(s);
		for (Net net : result) {
			if (f.getFormula().accept(this, net)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Double visitNext(Next<Net> f, Net t) {
		Random r = new Random();
		double sat = 0;
		double unsat = 0;
		NetTransition next = t.getNext();
		if (next.getTotalWeight() == 0) {
			return 0.0;
		}
		for( int i=0 ; i<getIterations() ; i++ ) {
			Net test = next.select(r.nextDouble());
			if (f.getStateFormula().accept(this, test.copy())) {
				sat += 1.0;
			} else {
				unsat += 1.0;
			}
		}
		return (sat/(sat+unsat));
	}

	@Override
	public Double visitUntil(Until<Net> f, Net t) {
		if (f.getUpperBound() == null) {
			throw new IllegalArgumentException();
		}
		double sat = 0;
		double unsat = 0;
		double deadline = f.getUpperBound().doubleValue();
		for( int i=0 ; i<getIterations() ; i++ ) {
			if (simulate(t.copy() , f.left , f.right , deadline )) {
				sat += 1.0;
			} else {
				unsat += 1.0;
			}
		}
		return (sat/(sat+unsat));
	}

	public double getIterations() {
		return 4.0 * (Math.log (2.0 / perror)) / (delta*delta);
	}

	protected boolean simulate( Net start , StateFormula<Net> left , StateFormula<Net> right , double limit ) {
		Random r = new Random();
		double time = 0.0;
		Net current = start;
		while (time<limit) {
			if (right.accept(this, current)) {
				return true;
			}
			if (!right.accept(this, current)) {
				return false;
			}
			NetTransition next = current.getNext();
			if (next.getTotalWeight()==0.0) {
				return false;
			}
			double p1 = r.nextDouble();
			double p2 = r.nextDouble();
			current = next.select(p1);
			time += (1/next.getTotalWeight())*Math.log(1/p2);
		}
		return false;
	}


}
