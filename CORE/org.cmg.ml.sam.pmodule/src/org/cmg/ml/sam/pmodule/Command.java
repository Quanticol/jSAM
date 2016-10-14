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

/**
 * @author loreti
 *
 */
public abstract class Command {
	
	PModuleState apply( PModuleState state ) {
		PModuleState nextState = state.copy();		
		return doApply( state , nextState );
	}

	protected abstract PModuleState doApply(PModuleState src, PModuleState trg);

}
