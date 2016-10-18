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

import org.cmg.ml.sam.core.sim.SimulationData;
import org.eclipse.nebula.visualization.xygraph.dataprovider.ISample;

/**
 * @author loreti
 *
 */
public class SimulationDataSample implements ISample {

	private SimulationData sample;

	/**
	 * @param d
	 */
	public SimulationDataSample(SimulationData d) {
		this.sample = d;
	}

	/* (non-Javadoc)
	 * @see org.csstudio.swt.xygraph.dataprovider.ISample#getXValue()
	 */
	@Override
	public double getXValue() {
		return sample.getX();
	}

	/* (non-Javadoc)
	 * @see org.csstudio.swt.xygraph.dataprovider.ISample#getYValue()
	 */
	@Override
	public double getYValue() {
		return sample.getY();
	}

	/* (non-Javadoc)
	 * @see org.csstudio.swt.xygraph.dataprovider.ISample#getXPlusError()
	 */
	@Override
	public double getXPlusError() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.csstudio.swt.xygraph.dataprovider.ISample#getYPlusError()
	 */
	@Override
	public double getYPlusError() {
		return sample.getDelta();
	}

	/* (non-Javadoc)
	 * @see org.csstudio.swt.xygraph.dataprovider.ISample#getXMinusError()
	 */
	@Override
	public double getXMinusError() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.csstudio.swt.xygraph.dataprovider.ISample#getYMinusError()
	 */
	@Override
	public double getYMinusError() {
		return sample.getDelta();
	}

	/* (non-Javadoc)
	 * @see org.csstudio.swt.xygraph.dataprovider.ISample#getInfo()
	 */
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return sample.toString();
	}

}
