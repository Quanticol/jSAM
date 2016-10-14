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
package org.cmg.ml.sam.pmodule;

import org.cmg.ml.sam.core.Predicate;
import org.cmg.ml.sam.core.WeightedElement;

/**
 * @author loreti
 *
 */
public class Rule {
	
	private Predicate<PModuleState> guard;
	private WeightedElement<Command>[] commands;

	public Rule( Predicate<PModuleState> guard , WeightedElement<Command> ... commands ) {
		this.guard = guard;
		this.commands = commands;
	}
	
	public boolean isEnabled( PModuleState state ) {
		return guard.sat(state);
	}
	
	@SuppressWarnings("unchecked")
	public WeightedElement<PModuleState>[] apply(PModuleState state) {
		WeightedElement<PModuleState>[] toReturn = new WeightedElement[commands.length];
		for (int i = 0; i < commands.length; i++) {
			toReturn[i] = new WeightedElement<PModuleState>( commands[i].getElement().apply(state) , commands[i].getWeight() );
		}		
		return toReturn;
	}
}
