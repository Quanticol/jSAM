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
package org.cmg.ml.sam.util;

/**
 * @author loreti
 *
 */
public class Pair<A, B> {
	
	private A first;
	
	private B second;
	
	public Pair( A first , B second ) {
		this.first = first;
		this.second = second;
	}
	
	public A getFirst() {
		return first;
	}
	
	public B getSecond() {
		return second;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof Pair) {
			Pair<?,?> pair = (Pair<?,?>) arg0;
			return ((this.first==pair.first)||(this.first.equals(pair.first)))&&
					((this.second==pair.second)||(this.second.equals(pair.second)));
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (first==null?0:first.hashCode())^(second==null?0:second.hashCode());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "<"+first+","+second+">";
	}

}
