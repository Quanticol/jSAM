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

import java.util.LinkedList;

import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.Filter;
import org.cmg.ml.sam.core.Probability;
import org.cmg.ml.sam.core.WeightedElement;

/**
 * @author loreti
 *
 */
public class BasicRule implements Rule {
	
	private int labelId;
	
	private LinkedList<Filter<PrismState>> guard;
	
	private LinkedList<Command> commands;
	
	public BasicRule( Command ... commands ) {
		this(null,commands);
	}
	
	public BasicRule( Filter<PrismState> guard , Command ... commands  ) {
		this( 0 , guard , commands );
	}

	public BasicRule( int labelId , Filter<PrismState> guard , Command ... commands  ) {
		this.guard = new LinkedList<Filter<PrismState>>();
		this.guard.add(guard);
		this.commands = new LinkedList<Command>();
		for (Command command : commands) {
			this.commands.add(command);
		}
		this.labelId = labelId;
	}

	public BasicRule( int labelId , LinkedList<Filter<PrismState>> guard , LinkedList<Command> commands  ) {
		this.guard = guard;
		this.commands = commands;
		this.labelId = labelId;
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.Rule#isEnable(org.cmg.ml.sam.prism.PrismState)
	 */
	@Override
	public boolean isEnabled( PrismState s ) {
		for (Filter<PrismState> f : guard) {
			if (!f.eval(s)) {
				return false;
			}
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.Rule#apply(org.cmg.ml.sam.prism.PrismState)
	 */
	@Override
	public Distribution<PrismState> apply( PrismState s ) {
		Probability<PrismState> next = new Probability<PrismState>();
		return apply(s,next);
	}

	/*
	 * (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.Rule#apply(org.cmg.ml.sam.prism.PrismState, org.cmg.ml.sam.core.Probability)
	 */
	@Override
	public Probability<PrismState> apply( PrismState s , Probability<PrismState> next ) {
		if (isEnabled(s)) {
			for (Command c : commands) {
				next.set(c.getNextState(s));
			}
		}
		return next;
	}
	
	
	public int getActionId() {
		return labelId;
	}
	
	public BasicRule computeAndRule( BasicRule r ) {
		if (r.labelId != labelId) {
			throw new IllegalArgumentException();
		}
		LinkedList<Command> newCommands = new LinkedList<Command>();
		for (Command c1 : this.commands) {
			for (Command c2 : r.commands) {
				newCommands.add(c1.join(c2));
			}
		}
		LinkedList<Filter<PrismState>> newGuards = new LinkedList<Filter<PrismState>>();
		newGuards.addAll(guard);
		newGuards.addAll(r.guard);
		return new BasicRule( labelId , newGuards , newCommands );
	}
	
//	/* (non-Javadoc)
//	 * @see org.cmg.ml.sam.prism.Rule#apply(org.cmg.ml.sam.prism.BasicPrismTransitionStructure, org.cmg.ml.sam.prism.PrismState)
//	 */
//	@Override
//	public BasicPrismTransitionStructure apply( BasicPrismTransitionStructure next , PrismState s ) {
//		if ((guard==null)||(guard.eval(s))) {
//			Probability<Update> localNext = new Probability<Update>();
//			for (Command c : commands) {
//				WeightedElement<Update> we = c.apply(s);
//				localNext.set(we.getElement(),we.getWeight());
//			}
//			next.add(labelId, localNext);
//		}
//		return next;
//	}

}
