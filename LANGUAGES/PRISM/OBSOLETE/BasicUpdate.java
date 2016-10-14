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

/**
 * @author loreti
 *
 */
public class BasicUpdate extends Update {
	
	LinkedList<UpdateElement> updates;
	
	public BasicUpdate() {
		updates = new LinkedList<UpdateElement>();
	}

	public BasicUpdate( UpdateElement ... elements ) {
		this();
		for (int i = 0; i < elements.length; i++) {
			updates.add(elements[i]);
		}
	}
	
	public BasicUpdate( BasicUpdate u1 , BasicUpdate u2 ) {
		updates = new LinkedList<UpdateElement>(u1.updates);
		updates.addAll(u2.updates);
	}
	
	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.Update#set(int, int)
	 */
	@Override
	public void set( int id , int value ) {
		updates.add( new UpdateElement( id , value ) );
	}
	
	public void join( BasicUpdate u ) {
		updates.addAll(u.updates);
	}
	
	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.Update#apply(org.cmg.ml.sam.prism.PrismState)
	 */
	@Override
	public PrismState doUpdate( PrismState nextState ) {
		for (UpdateElement e : updates) {
			nextState.setValueOf(e.id, e.update);
		}
		return nextState;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BasicUpdate) {
			return updates.equals((Update) obj);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return updates.hashCode();
	}

	@Override
	public String toString() {
		return updates.toString();
	}
	

}
