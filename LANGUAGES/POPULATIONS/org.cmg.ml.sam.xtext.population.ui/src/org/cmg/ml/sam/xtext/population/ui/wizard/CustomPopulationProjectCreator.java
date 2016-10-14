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
package org.cmg.ml.sam.xtext.population.ui.wizard;

import java.util.List;

import org.cmg.ml.sam.SamProjectHelper;
import org.cmg.ml.sam.xtext.population.ui.wizard.PopulationProjectCreator;

/**
 * @author loreti
 *
 */
public class CustomPopulationProjectCreator extends PopulationProjectCreator {

	private static final String POPULATION_CORE = "org.cmg.ml.sam.population";

	@Override
	protected List<String> getRequiredBundles() {
		List<String> result = super.getRequiredBundles();
		result.addAll(SamProjectHelper.addSamBudles(result));
		result.add(POPULATION_CORE);
		return result;
	}

}
