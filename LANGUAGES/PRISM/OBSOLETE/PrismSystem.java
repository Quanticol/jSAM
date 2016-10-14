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
package org.cmg.ml.sam.prism.obsolete;

import java.util.ArrayList;
import java.util.LinkedList;

import org.cmg.ml.sam.core.CombinedDistribution;
import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.Probability;


/**
 * @author loreti
 *
 */
public class PrismSystem {
	
	private ArrayList<LinkedList<BasicRule>> rules;
	
	
	public PrismSystem( ArrayList<LinkedList<BasicRule>> rules ) {
		this.rules = rules;
	}
	
	public PrismSystem( int labelSize , BasicRule ... rules ) {
		this.rules = new ArrayList<LinkedList<BasicRule>>(labelSize);
		for( int i=0 ; i<labelSize ; i++ ) {
			this.rules.add(new LinkedList<BasicRule>());
		}
		for( int i=0 ; i<rules.length ; i++ ) {
			int rIndex = rules[i].getActionId();
			this.rules.get(rIndex).add(rules[i]);
		}
	}

	public Probability<PrismState> getNext(PrismState s) {
		Probability<PrismState> toReturn = new Probability<PrismState>();
		for (LinkedList<BasicRule> rList : rules) {
			for (BasicRule r : rList) {
				toReturn = r.apply(s, toReturn);
			}			
		}
		return toReturn;
	}

	public static PrismSystem alphabetisedParallelComposition( PrismSystem ... modules ) {
		return alphabetisedParallelComposition( 0 , modules.length , modules );
//		if (modules.length<1) {
//			return null;
//		}
//		PrismSystem toReturn = modules[0];
//		for( int i=1 ; i<modules.length ; i++ ) {
//			toReturn = alphabetisedParallelComposition(toReturn , modules[i]);
//		}
//		return toReturn;
	}

	public static PrismSystem alphabetisedParallelComposition( int from , int to , PrismSystem ... modules ) {
		if (from+1 == to) {
			return modules[from];
		} else {
			int pivot = (to-from)/2;
			return alphabetisedParallelComposition( 
				alphabetisedParallelComposition( from , from+pivot , modules ) ,
				alphabetisedParallelComposition( from+pivot , to , modules )
			);
		}
	}
	
	
	public static PrismSystem alphabetisedParallelComposition( PrismSystem left , PrismSystem right ) {
		ArrayList<LinkedList<BasicRule>> newRules = new ArrayList<LinkedList<BasicRule>>();
		newRules.add( combineOrRule( left.rules.get(0) , right.rules.get(0) ) );
		for( int i=1 ; i<left.rules.size() ; i++ ) {
			newRules.add( combineAndRule(left.rules.get(i), right.rules.get(i) ) );
		}
		return new PrismSystem(newRules);
	}

	
	public static PrismSystem controlledParallelComposition( PrismSystem left , boolean[] syncSet , PrismSystem right ) {
		ArrayList<LinkedList<BasicRule>> newRules = new ArrayList<LinkedList<BasicRule>>();
		newRules.add( combineOrRule( left.rules.get(0) , right.rules.get(0) ) );
		for( int i=1 ; i<left.rules.size() ; i++ ) {
			if (syncSet[i]) {
				newRules.add( combineAndRule(left.rules.get(i), right.rules.get(i) ) );
			} else {
				newRules.add( combineOrRule( left.rules.get(i) , right.rules.get(i) ) );
			}
		}
		return new PrismSystem(newRules);
	}

	public static PrismSystem interlivingParallelComposition( PrismSystem left , boolean[] syncSet , PrismSystem right ) {
		ArrayList<LinkedList<BasicRule>> newRules = new ArrayList<LinkedList<BasicRule>>();
		newRules.add( combineOrRule( left.rules.get(0) , right.rules.get(0) ) );
		for( int i=1 ; i<left.rules.size() ; i++ ) {
			newRules.add( combineOrRule( left.rules.get(i) , right.rules.get(i) ) );
		}
		return new PrismSystem(newRules);
	}

	public static PrismSystem hide( PrismSystem m , boolean[] hideSet ) {
		ArrayList<LinkedList<BasicRule>> newRules = new ArrayList<LinkedList<BasicRule>>();
		newRules.add( m.rules.get(0) );
		for( int i=1 ; i<m.rules.size() ; i++ ) {
			if (hideSet[i]) {
				newRules.set( 0 , combineOrRule(m.rules.get(i), newRules.get(0) ) );				
				newRules.add( new LinkedList<BasicRule>() );
			} else {
				newRules.add( m.rules.get(i) );
			}
		}
		return new PrismSystem(newRules);
	}
	
	public static PrismSystem rename( PrismSystem m , int[] map ) {
		ArrayList<LinkedList<BasicRule>> newRules = new ArrayList<LinkedList<BasicRule>>();
		for( int i=0 ; i<m.rules.size() ; i++ ) {
			newRules.add(new LinkedList<BasicRule>());
		}
		newRules.set( 0 , m.rules.get(0) );
		for( int i=1 ; i<m.rules.size() ; i++ ) {
			int trg = map[i];
			newRules.set(  trg , combineOrRule( m.rules.get(i) , newRules.get( trg ) ) );				
		}
		return new PrismSystem(newRules);
	}
	
	private static LinkedList<BasicRule> combineAndRule(LinkedList<BasicRule> left, LinkedList<BasicRule> right) {
		LinkedList<BasicRule> toReturn = new LinkedList<BasicRule>();
		if ((left.size() == 0)||(right.size() == 0)) {
			return toReturn;
		}
		for (BasicRule rl : left) {
			for (BasicRule rr : right) {
				toReturn.add(rl.computeAndRule(rr));
			}
		}
		return toReturn;
	}

	public static LinkedList<BasicRule> combineOrRule( LinkedList<BasicRule> left , LinkedList<BasicRule> right ) {
		if (left.size() == 0) {
			return right;
		}
		if (right.size() == 0) {
			return left;
		}		
		LinkedList<BasicRule> newList = new LinkedList<BasicRule>();
		newList.addAll(left);
		newList.addAll(right);
		return newList;		
	}
	
	
//	@Override
//	public Distribution<PrismState> getNext( int labelSize , PrismState s ) {
//		BasicPrismTransitionStructure next = new BasicPrismTransitionStructure( labelSize );
//		for (Rule r : rules) {
//			next = r.apply(next, s);
//		}
//		return next;
//	}
	

}
