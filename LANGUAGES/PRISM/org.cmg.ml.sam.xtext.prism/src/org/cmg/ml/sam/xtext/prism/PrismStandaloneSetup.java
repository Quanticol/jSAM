
package org.cmg.ml.sam.xtext.prism;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class PrismStandaloneSetup extends PrismStandaloneSetupGenerated{

	public static void doSetup() {
		new PrismStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

