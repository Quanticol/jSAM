/*
 * Michele Loreti, Concurrency and Mobility Group
 * Universitą di Firenze, Italy
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
package org.cmg.ml.sam.core;

/**
 * @author loreti
 *
 */
public interface Operator<S,T> {
	
	T apply( S p );

}
