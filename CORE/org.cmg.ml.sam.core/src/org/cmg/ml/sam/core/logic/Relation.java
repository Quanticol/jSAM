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


public enum Relation {
	LESS,
	LEQ,
	EQ,
	GTR,
	GEQ;
	
	@Override
	public String toString() {
		switch (this) {
		case LESS:
			return "<";
		case LEQ:
			return "<=";
		case EQ:
			return "==";
		case GTR:
			return ">";
		case GEQ:
			return ">=";
		default:
			return "";
		}
	}

	public boolean sat(double value , double limit) {
		switch (this) {
		case LESS:
			return value<limit;
		case LEQ:
			return value<=limit;
		case EQ:
			return value==limit;
		case GTR:
			return value>limit;
		case GEQ:
			return value >= limit;
		default:
			return false;
		}
	}
}
