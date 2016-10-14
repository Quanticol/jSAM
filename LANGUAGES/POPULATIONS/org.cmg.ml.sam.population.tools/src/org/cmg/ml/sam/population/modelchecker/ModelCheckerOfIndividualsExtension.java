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
package org.cmg.ml.sam.population.modelchecker;

import org.cmg.ml.sam.population.PopulationSpecification;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/**
 * @author loreti
 *
 */
public class ModelCheckerOfIndividualsExtension extends AbstractPopulationModelCheckerExtension {

	private static final String MODELCHECKERID = "State Formulae";

	@Override
	public String getName() {
		return MODELCHECKERID;
	}

	@Override
	protected Composite createPopulationModelCheckingComposite(Shell main,
			Composite parent, PopulationSpecification spec) {
		return new IndividualsModelCheckerComposite(main, parent, spec);
	}

}
