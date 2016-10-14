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
package org.cmg.ml.sam.core;

/**
 * This class permits associating an instance of class <code>T</code> with
 * a real value. This value can be used with different meaning depending on the context
 * where it is used.  
 * 
 * @author loreti
 *
 */
public class WeightedElement<T> {

	/**
	 * An element of type <code>T</code>
	 */
	private T element;
	
	/**
	 * A real value
	 */
	private double value;
	
	/**
	 * Create a new weighted element.
	 * 
	 * @param element an element
	 * @param value its weight
	 */
	public WeightedElement( T element , double value ) {
		this.element = element;
		this.value = value;
	}
	
	/**
	 * Returns the weighted element 
	 * 
	 * @return the weighted element
	 */
	public T getElement() {
		return element;
	}
	
	/**
	 * Returns the weight
	 * 
	 * @return the weight
	 */
	public double getWeight() {
		return value;
	}

	public void renormalize(double v) {
		value = value/v;
	}

	@Override
	public String toString() {
		return element+":"+value;
	}

	public void addWeight(double weight) {
		value += weight;
	}

}
