/**
 * 
 */
package org.cmg.ml.sam.klaim.core;

import java.util.HashMap;
import java.util.Map;

import org.cmg.ml.sam.core.logic.PathFormula;
import org.cmg.ml.sam.core.logic.StateFormula;
import org.cmg.ml.sam.core.sim.Measure;

/**
 * @author loreti
 *
 */
public abstract class AbstractKlaimSpecification implements KlaimSpecification {

	protected HashMap<String, PathFormula<Net>> pathFormulae;
	
	protected HashMap<String, StateFormula<Net>> stateFormulae;

	protected HashMap<String, Measure<Net>> measures;
	
	
	
	public AbstractKlaimSpecification() {
		this.pathFormulae = new HashMap<String, PathFormula<Net>>();
		this.stateFormulae = new HashMap<String, StateFormula<Net>>();
		this.measures = new HashMap<String, Measure<Net>>();
		doInitMeasures();
		doInitStateFormulae();
		doInitPathFormulae();
	}


	@Override
	public Map<String, StateFormula<Net>> getStateFormulae() {
		return stateFormulae;
	}


	@Override
	public Map<String, PathFormula<Net>> getPathFormulae() {
		return pathFormulae;
	}


	@Override
	public Map<String, Measure<Net>> getMeasures() {
		return measures;
	}
	
	protected abstract void doInitMeasures();
	
	protected abstract void doInitStateFormulae();
	
	protected abstract void doInitPathFormulae();


	public void addStateFormula( String name , StateFormula<Net> formula ) {
		stateFormulae.put(name,formula);
	}

	public void addPathFormula( String name , PathFormula<Net> formula ) {
		pathFormulae.put(name,formula);
	}

	@Override
	public String[] getFormulaeArray() {
		String[] toReturn = new String[stateFormulae.size()+pathFormulae.size()];
		int i=0;
		for (String name : stateFormulae.keySet()) {
			toReturn[i] = name;
			i++;
		}
		for (String name : pathFormulae.keySet()) {
			toReturn[i] = name;
			i++;
		}
		return toReturn;
	}
	
	public StateFormula<Net> getStateFormula(String name) {
		return stateFormulae.get(name);
	}
	
	public PathFormula<Net> getPathFormula(String name) {
		return pathFormulae.get(name);
	}
	
	
}
