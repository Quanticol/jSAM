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

import java.util.HashMap;

import org.cmg.ml.sam.core.CombinedDistribution;
import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.Probability;
import org.cmg.ml.sam.core.WeightedElement;

/**
 * @author loreti
 *
 */
public class BasicPrismTransitionStructure {

	private HashMap<Integer, Distribution<Update>> next;
	private boolean[] enabled;
	private int labelSize;
	
	public BasicPrismTransitionStructure(int labelSize) {
		this.next = new HashMap<Integer, Distribution<Update>>();
		this.labelSize = labelSize;
		this.enabled = new boolean[labelSize];
	}

	public void alphabetizedParallel(BasicPrismTransitionStructure transition) {
		if (enabled[0]) {
			if (transition.enabled[0]) {
				set( 0 , new CombinedDistribution<Update>(next.get(0), transition.get(0)));
			}
		} else {
			if (transition.enabled[0]) {
				set( 0 , transition.get(0));
			}
		}
		for (int i = 1; i < labelSize; i++) {
			if (enabled[i]&&transition.enabled[i]) {
				Probability<Update> newSync = new Probability<Update>(); 
				for (WeightedElement<Update> u1 : next.get(i)) {
					for (WeightedElement<Update> u2 : transition.get(i)) {						
						newSync.set(new CombinedUpdate(u1.getElement(),u2.getElement()), u1.getWeight()*u2.getWeight());
					}
				}
				set( i , newSync );
			} else {
				remove(i);
			}
		}
	}

	private void remove(int i) {
		enabled[i] = false;
		next.remove(i);
	}

	private void set(int i, Distribution<Update> distribution) {
		enabled[i] = true;
		next.put(i, distribution);
	}

	public void controlledParallel(boolean[] interactionSet, BasicPrismTransitionStructure transition) {
		for( int i=0 ; i<labelSize ; i++ ) {
			if ((i!=0)&&interactionSet[i]) {
				//Synchronization on i!
				if (enabled[i]&&transition.enabled[i]) {
					Probability<Update> newSync = new Probability<Update>(); 
					for (WeightedElement<Update> u1 : next.get(i)) {
						for (WeightedElement<Update> u2 : transition.get(i)) {						
							newSync.set(new CombinedUpdate(u1.getElement(),u2.getElement()), u1.getWeight()*u2.getWeight());
						}
					}
					set( i , newSync );
				} else {
					remove(i);
				}
			} else {
				//No synchronization on i!
				if (enabled[i]) {
					if (transition.enabled[i]) {
						set( i , new CombinedDistribution<Update>(next.get(i), transition.get(i)));
					}
				} else {
					if (transition.enabled[0]) {
						set( i , transition.get(i));
					}
				}
			}
		}
	}

	public void interlivingParallel(BasicPrismTransitionStructure transition) {
		for( int i=0 ; i<labelSize ; i++ ) {
			if (enabled[i]) {
				if (transition.enabled[i]) {
					set( i , new CombinedDistribution<Update>(next.get(i), transition.get(i)));
				}
			} else {
				if (transition.enabled[0]) {
					set( i , transition.get(i));
				}
			}
		}
	}

	public void hide(boolean[] hideSet) {
		for( int i=1 ; i<labelSize ; i++ ) {
			if (hideSet[i]&&enabled[i]) {
				add( 0 , next.get(i));
				remove(i);
			}
		}
	}

	public void rename(int[] mapping) {
		for( int i=1 ; i<labelSize ; i++ ) {
			if ((mapping[i]!=i)&&enabled[i]) {
				add( mapping[i] , next.get(i));
				remove(i);
			}
		}
	}

	public Distribution<Update> get(int i) {
		return next.get(i);
	}

	public boolean isEnabled(int i) {
		return next.containsKey(i);
	}

	public void add(int labelId, Distribution<Update> localNext) {
		Distribution<Update> active = next.get(labelId);
		if (active == null) {
			active = localNext;
		} else {
			active = new CombinedDistribution<Update>(active, localNext);
		}
		set(labelId, active);
	}

}
