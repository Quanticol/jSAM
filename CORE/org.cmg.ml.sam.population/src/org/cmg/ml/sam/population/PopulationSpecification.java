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
package org.cmg.ml.sam.population;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.cmg.ml.sam.core.logic.PathFormula;
import org.cmg.ml.sam.core.logic.StateFormula;
import org.cmg.ml.sam.core.sim.Measure;

/**
 * This interface identifies a generic population specification and
 * permits accessing to:
 * <ul>
 * <li> population model (via method <code>getModule()</code>);
 * <li> array population states (via method <code>getStates()</code>);
 * <li> declared state formulae (via method <code>getStateFormulae()</code>);
 * <li> declared path formulae (via method <code>getPathFormulae()</code>);
 * <li> declared system configurations (via method <code>getSystems()</code>).
 * </ul>
 * 
 * @author loreti
 *
 */
public abstract class PopulationSpecification {

	
	protected String[] states;
	
	protected PopulationModule module;

	protected String[] stateFormulae;

	protected String[] configurations;
	
	protected String[] pathFormulae;

	protected HashMap<String,StateFormula<PopulationState>> stateFormulaeForIndividuals = new HashMap<String,StateFormula<PopulationState>>();

	protected HashMap<String,StateFormula<FastSimulationState>> stateFormulaeForFastSimulation = new HashMap<String,StateFormula<FastSimulationState>>();

	protected HashMap<String,PathFormula<PopulationState>> pathFormulaeForIndividuals = new HashMap<String,PathFormula<PopulationState>>();

	protected HashMap<String,PathFormula<FastSimulationState>> pathFormulaeForFastSimulation = new HashMap<String,PathFormula<FastSimulationState>>();
		
	protected HashMap<String,PopulationState> configurationsForIndividuals = new HashMap<String,PopulationState>();
		
	protected HashMap<String,FastSimulationState> configurationsForFastSimulation = new HashMap<String,FastSimulationState>();


	public PopulationSpecification() {
		initStateNameVector();
		initPopulationModule();
		initStateFormulaeTables();
		initPathFormulaeTables();
	}

	
	protected abstract void initStateNameVector();

	protected abstract void initPopulationModule();
	
	protected abstract void initStateFormulaeTables();

	protected abstract void initPathFormulaeTables();

	public PopulationModule getModule() {
		return module;	
	}

	public String[] getStates() {
		return states;	
	}

	public String[] getStateFormulae() {
		return stateFormulae;
	}

	public String[] getPathFormulae() {
		return pathFormulae;
	}

	public StateFormula<PopulationState> getPopulationStateFormula( String name ) {
		return stateFormulaeForIndividuals.get(name);
	}

	public StateFormula<FastSimulationState> getFastSimulationStateFormula( String name ) {
		return stateFormulaeForFastSimulation.get(name);
	}

	public PathFormula<PopulationState> getPopulationPathFormula( String name ) {
		return pathFormulaeForIndividuals.get(name);
	}

	public PathFormula<FastSimulationState> getFastSimulationPathFormula( String name ) {
		return pathFormulaeForFastSimulation.get(name);
	}

	public String[] getConfigurationNames() {
		return configurations;
	}

	public PopulationState getIndividualsConfiguration( String name ) {
		return configurationsForIndividuals.get(name);
	}

	public FastSimulationState getFastSimulationConfiguration( String name ) {
		return configurationsForFastSimulation.get(name);
	}
	
	public FastSimulationState getFastSimulationConfiguration( String name , int time ) {
		PopulationState state = getIndividualsConfiguration(name);		
		return state.project(0,time);
	}
	
	public LinkedList<Measure<PopulationState>> getMeasuresOfIndividuals() {
		LinkedList<Measure<PopulationState>> measures = new LinkedList<Measure<PopulationState>>();
		for (int i=0 ; i<states.length ; i++ ) {
			final int stateIndex = i;
			Measure<PopulationState> m = new Measure<PopulationState>() {

				@Override
				public double measure(PopulationState t) {
					return t.getOccupancy(stateIndex);
				}

				@Override
				public String getName() {
					return states[stateIndex];
				}
			};
			measures.add(m);
		}
		return measures;
	}

	public LinkedList<Measure<FastSimulationState>> getMeasuresOfFastState() {
		LinkedList<Measure<FastSimulationState>> measures = new LinkedList<Measure<FastSimulationState>>();
		for (int i=0 ; i<states.length ; i++ ) {
			final int stateIndex = i;
			Measure<FastSimulationState> m = new Measure<FastSimulationState>() {

				@Override
				public double measure(FastSimulationState t) {
					return t.getOccupancy(stateIndex);
				}

				@Override
				public String getName() {
					return states[stateIndex];
				}
			};
			measures.add(m);
		}
		return measures;
	}


	public FastSimulationState getFastSimulationConfiguation(int state,
			double[] occupancyVector) {
		return new FastSimulationState(state, new MeanFieldState(occupancyVector, module));
	}

	public FastSimulationState[] getFastSimulationConfiguations(int state,
			double[] occupancyVector, int from , int to) {
		FastSimulationState[] states = new FastSimulationState[(to-from)+1];
		MeanFieldState mfs = new MeanFieldState(occupancyVector, module);
		for( int i=0 ; i<states.length; i++ ) {
			states[i] = new FastSimulationState(from+i, state, mfs);
		}
		return states;
	}

	public FastSimulationState[] getFastSimulationConfigurations(
			String name, int from, int to) {
		PopulationState fullState = getIndividualsConfiguration(name);
		double[] occupancyVector = fullState.getOccupancy();		
		int state = fullState.getStateAt(0);
		return getFastSimulationConfiguations(state,occupancyVector,from,to);
	}

}
