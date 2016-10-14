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
package org.cmg.ml.sam.core.logic;


public interface FormulaVisitor<T, R> {

	R visitTrue( T s );
	R visitAnd( And<T> f, T s );
	R visitOr( Or<T> f, T s );
	R visitFalse( T s );
	R visitNot( Not<T> f, T s );
	R visitAtomic( Atomic<T> f, T s );
	R visitPCheck( PCheck<T> f, T s );
	R visitMap( FMap<T> f, T s );
	
}
