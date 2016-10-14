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

/**
 * @author loreti
 *
 */
public class CombinedUpdate extends Update {

	private Update left;
	private Update right;
	
	public CombinedUpdate(Update left, Update right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public void set(int id, int value) {
		left.set(id, value);
	}

	@Override
	protected PrismState doUpdate(PrismState nextState) {
		return right.doUpdate(left.doUpdate(nextState));
	}

}
