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

import org.cmg.ml.sam.core.WeightedElement;

/**
 * @author loreti
 *
 */
public abstract class Command {

	public WeightedElement<Update> apply( PrismState currentState ) {
		BasicUpdate update = new BasicUpdate();
		doApply(currentState, update);
		return new WeightedElement<Update>(update , computeWeight(currentState) );
	}

	public WeightedElement<PrismState> getNextState( PrismState s ) {
		BasicUpdate update = new BasicUpdate();
		doApply(s, update);
		return new WeightedElement<PrismState>(update.apply(s) , computeWeight(s) );
	}
	
	protected abstract void doApply(PrismState currentState, Update update);
	
	protected abstract double computeWeight( PrismState currentState );

	public Command join( Command c ) {
		if (c instanceof JoinCommand) {
			return ((JoinCommand) c).join(c);
		}
		return new JoinCommand( this , c );
	}


}
