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
package org.cmg.ml.sam;

import org.eclipse.emf.ecore.EObject;

/**
 * @author loreti
 *
 */
public class UnexpectedEObjectException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6706091975063492548L;

	private EObject o;

	public UnexpectedEObjectException( EObject o ) {
		super();
		this.o = o;
	}
	
	public EObject getEObject() {
		return o;
	}

}
