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
package org.cmg.ml.sam.prism;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;

import org.cmg.ml.sam.core.CombinedDistribution;
import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.Probability;


/**
 * @author loreti
 *
 */
public class BasicPrismSystem extends PrismSystem {
	
	private ArrayList<LinkedList<Rule>> rules;
	
	
	public BasicPrismSystem( ArrayList<LinkedList<Rule>> rules ) {
		super( rules.size() );
		this.rules = rules;
	}
	
	public BasicPrismSystem( int labelSize , Rule ... rules ) {
		super( labelSize );
		this.rules = new ArrayList<LinkedList<Rule>>(labelSize);
		for( int i=0 ; i<labelSize ; i++ ) {
			this.rules.add(new LinkedList<Rule>());
		}
		for( int i=0 ; i<rules.length ; i++ ) {
			int rIndex = rules[i].getActionId();
			this.rules.get(rIndex).add(rules[i]);
		}
	}


	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.PrismSystem#getNext(org.cmg.ml.sam.prism.PrismState, int)
	 */
	@Override
	protected Probability<BigInteger> getNext(BigInteger s , int actionId ) {
		Probability<BigInteger> next = null;
		LinkedList<Rule> ruleList = rules.get(actionId);
		for (Rule rule : ruleList) {
			next = rule.interleaving(s, next);
		}
		return next;
	}


	@Override
	protected Probability<BigInteger> interleaving(BigInteger s, int actionId,
			Probability<BigInteger> next) {
		LinkedList<Rule> rList = rules.get(actionId);
		for (Rule rule : rList) {
			next = rule.interleaving(s, next);
		}
		return next;
	}

	@Override
	protected Probability<BigInteger> synchronize(BigInteger s, int actionId,
			Probability<BigInteger> next) {
		Probability<BigInteger> toReturn = new Probability<BigInteger>();
		LinkedList<Rule> rList = rules.get(actionId);
		for (Rule rule : rList) {
			Probability<BigInteger> foo = rule.synchronize(s, next);
			if (foo != null) {
				toReturn.add(foo);
			}
		}
		return toReturn;
	}

	@Override
	protected boolean[] appearingActions() {
		boolean[] toReturn = new boolean[getLabels()];
		toReturn[0] = false;
		for(int i=1 ; i<toReturn.length;i++) {
			LinkedList<Rule> actionRules = rules.get(i);
			toReturn[i] = (actionRules!=null)&&(actionRules.size()>0);
		}
		return toReturn;
	}

	@Override
	public boolean isEnabled(PrismState s, int actionId) {
		LinkedList<Rule> ruleList = rules.get(actionId);
		if ((ruleList == null)||(ruleList.isEmpty())) {
			return false;
		}
		for (Rule r : ruleList) {
			if (r.isEnabled(s.getState())) {
				return true;
			}
		}
		return false;
	}

}
