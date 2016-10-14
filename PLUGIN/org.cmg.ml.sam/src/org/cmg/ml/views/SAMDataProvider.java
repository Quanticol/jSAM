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

import java.util.ArrayList;

import org.cmg.ml.sam.core.sim.SimulationData;
import org.eclipse.nebula.visualization.xygraph.dataprovider.AbstractDataProvider;
import org.eclipse.nebula.visualization.xygraph.dataprovider.ISample;
import org.eclipse.nebula.visualization.xygraph.linearscale.Range;

/**
 * @author loreti
 *
 */
public class SAMDataProvider extends AbstractDataProvider {
	
	/**
	 * @param chronological
	 */
	public SAMDataProvider(Iterable<SimulationData> data) {
		this();
		initSamples(data);
	}

	public SAMDataProvider(double[] data , double dt) {
		this();
		initSamples(data,dt);
	}
	
	/**
	 * @param data
	 * @param dt
	 */
	private void initSamples(double[] data, double dt) {
		for (int i=0 ; i<data.length ; i++) {
			ISample newSample  = new SimpleSample( i*dt , data[i] );
			samples.add( newSample );
			updateRange(newSample);
		}
	}

	/**
	 * 
	 */
	protected SAMDataProvider() {
		super(true);
		samples = new ArrayList<ISample>();
	}

	/**
	 * @param data
	 */
	private void initSamples(Iterable<SimulationData> data) {
		for (SimulationData d : data) {
			ISample newSample  = new SimulationDataSample(d);
			samples.add( newSample );
			updateRange(newSample);
		}
	}

	/**
	 * @param d
	 */
	private void updateRange(ISample sample) {
		if (this.xDataMinMax == null) {
			this.xDataMinMax = new Range(Math.min(0, sample.getXValue()), Math.max(0, sample.getXValue()));
			this.yDataMinMax = new Range(sample.getYValue(), sample.getYValue());
		} else {
			if (!this.xDataMinMax.inRange(sample.getXValue())) {
				this.xDataMinMax = new Range( Math.min(this.xDataMinMax.getLower(), sample.getXValue()) , Math.max(this.xDataMinMax.getUpper(), sample.getXValue()));
			}
			if (!this.yDataMinMax.inRange(sample.getYValue())) {
				this.yDataMinMax = new Range( Math.min(this.yDataMinMax.getLower(), sample.getYValue()) , Math.max(this.yDataMinMax.getUpper(), sample.getYValue()));				
			}
		}
	}

	protected ArrayList<ISample> samples;

	/* (non-Javadoc)
	 * @see org.csstudio.swt.xygraph.dataprovider.AbstractDataProvider#getSize()
	 */
	@Override
	public int getSize() {
		return samples.size();
	}

	/* (non-Javadoc)
	 * @see org.csstudio.swt.xygraph.dataprovider.AbstractDataProvider#getSample(int)
	 */
	@Override
	public ISample getSample(int index) {
		return samples.get(index);
	}

	/* (non-Javadoc)
	 * @see org.csstudio.swt.xygraph.dataprovider.AbstractDataProvider#innerUpdate()
	 */
	@Override
	protected void innerUpdate() {
	}

	/* (non-Javadoc)
	 * @see org.csstudio.swt.xygraph.dataprovider.AbstractDataProvider#updateDataRange()
	 */
	@Override
	protected void updateDataRange() {
	}
}
