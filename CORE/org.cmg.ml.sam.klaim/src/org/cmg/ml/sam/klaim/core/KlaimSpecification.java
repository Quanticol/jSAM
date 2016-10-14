/**
 * 
 */
package org.cmg.ml.sam.klaim.core;

import java.util.Map;

import org.cmg.ml.sam.core.logic.PathFormula;
import org.cmg.ml.sam.core.logic.StateFormula;
import org.cmg.ml.sam.core.sim.Measure;


/**
 * @author loreti
 *
 */
public interface KlaimSpecification {

	Net getStartNet();
	Map<String,StateFormula<Net>> getStateFormulae();
	Map<String,PathFormula<Net>> getPathFormulae();
	Map<String,Measure<Net>> getMeasures();
	String[] getFormulaeArray();
	
}
