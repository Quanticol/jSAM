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
package org.cmg.ml.sam.core.sim;

import java.util.Random;

import org.apache.commons.math3.random.AbstractRandomGenerator;


/**
 * @author loreti
 *
 */
public class DefaultRandomGenerator extends AbstractRandomGenerator {

	private Random random = new Random();
	
	@Override
	public void setSeed(long seed) {
		clear();
		random.setSeed(seed);
	}

	@Override
	public double nextDouble() {
		return random.nextDouble();
	}

}
