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
package org.cmg.ml.views;

import org.eclipse.nebula.visualization.xygraph.dataprovider.ISample;

/**
 * @author loreti
 *
 */
public class SimpleSample implements ISample {

	private double x;
	private double y;

	/**
	 * @param d
	 * @param e
	 */
	public SimpleSample(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/* (non-Javadoc)
	 * @see org.csstudio.swt.xygraph.dataprovider.ISample#getXValue()
	 */
	@Override
	public double getXValue() {
		return x;
	}

	/* (non-Javadoc)
	 * @see org.csstudio.swt.xygraph.dataprovider.ISample#getYValue()
	 */
	@Override
	public double getYValue() {
		return y;
	}

	/* (non-Javadoc)
	 * @see org.csstudio.swt.xygraph.dataprovider.ISample#getXPlusError()
	 */
	@Override
	public double getXPlusError() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.csstudio.swt.xygraph.dataprovider.ISample#getYPlusError()
	 */
	@Override
	public double getYPlusError() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.csstudio.swt.xygraph.dataprovider.ISample#getXMinusError()
	 */
	@Override
	public double getXMinusError() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.csstudio.swt.xygraph.dataprovider.ISample#getYMinusError()
	 */
	@Override
	public double getYMinusError() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.csstudio.swt.xygraph.dataprovider.ISample#getInfo()
	 */
	@Override
	public String getInfo() {
		return "("+x+","+y+")";
	}

}
