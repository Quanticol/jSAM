
package org.cmg.ml.sam.xtext.population;

import org.cmg.ml.sam.xtext.population.PopulationStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class PopulationStandaloneSetup extends PopulationStandaloneSetupGenerated{

	public static void doSetup() {
		new PopulationStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

