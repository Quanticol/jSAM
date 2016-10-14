/**
 * 
 */
package org.cmg.ml.sam.prism;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import org.apache.commons.math3.random.RandomGenerator;
import org.cmg.ml.sam.core.DTStochasticProcess;
import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.StateEnumerator;
import org.cmg.ml.sam.core.WeightedElement;
import org.cmg.ml.sam.core.logic.PathFormula;
import org.cmg.ml.sam.core.logic.StateFormula;

/**
 * @author loreti
 *
 */
public abstract class PrismModel extends DTStochasticProcess<PrismState> {
		
	public static enum ModelType {
		DTMC ,
		CTMC ,
		MDP
	}
	
	private ModelType modelType;
	
	private int labelSize;

	private HashMap<String,PathFormula<PrismState>> pathFormulae;

	private HashMap<String,StateFormula<PrismState>> stateFormulae;
	
	private StateEnumerator enumerator;

	public PrismModel( ModelType modelType , int labelSize ) {
		this.modelType = modelType;
		this.labelSize = labelSize;
		this.pathFormulae = new HashMap<String, PathFormula<PrismState>>();
		this.stateFormulae = new HashMap<String, StateFormula<PrismState>>();
	}
	
	public void setStateEnumerator( StateEnumerator enumerator ) {
		this.enumerator = enumerator;
	}
	
//	public PrismModel(ModelType modelType) {
//		this( modelType , 1 );
//	}
//
	/**
	 * Sub-classes should provide an implementation of this method so to create
	 * the rules associated with a model.
	 */
	protected abstract PrismSystem createSystem();

	public ModelType getModelType() {
		return modelType;
	}

	protected Rule[] rules;

	private PrismSystem system;

	@Override
	public Distribution<PrismState> getNext(PrismState s) {
		Distribution<PrismState> toReturn = getSystem().getNext(s);				
		toReturn.renormalize();
		return toReturn;
	}

	private PrismSystem getSystem() {
		if (system == null) {
			long time = System.currentTimeMillis();
			system = createSystem();
			System.out.println("System creation time: "+(System.currentTimeMillis()-time));
		}
		return system;
	}

	public WeightedElement<PrismState> getNext(RandomGenerator r,
			PrismState s) {
		Distribution<PrismState> next = s.getNext();
		if ((next == null)||(next.getTotalWeight()==0)) {
			return null;
		}
		switch (modelType) {
		case DTMC:
			return new WeightedElement<PrismState>(next.select(r.nextDouble()), 1);
		case CTMC:
			double total = next.getTotalWeight();
			return new WeightedElement<PrismState>(next.select(r.nextDouble()), (1/total)*Math.log(r.nextDouble()));
		case MDP:
		default:
			throw new IllegalArgumentException();
		}
	}
	
	public Set<String> pathFormulae() {
		return pathFormulae.keySet();
	}

	public Set<String> stateFormulae() {
		return stateFormulae.keySet();
	}
	
	public PathFormula<PrismState> getPathFormula( String name ) {
		return pathFormulae.get(name);
	}
	
	public StateFormula<PrismState> getStateFormula( String name ) {
		return stateFormulae.get(name);
	}
	
	public void setPathFormula( String name , PathFormula<PrismState> formula ) {
		pathFormulae.put(name, formula);
	}

	public void setStateFormula( String name , StateFormula<PrismState> formula ) {
		stateFormulae.put(name, formula);
	}

	protected PrismState selectNext(PrismState s, RandomGenerator rg) {
		return getNext(s).select(rg.nextDouble());
	}

	protected int get( BigInteger state , int idx ) {
		return enumerator.get(state, idx);
	}
	
	protected BigInteger set( BigInteger state , int idx , int v ) {
		return enumerator.set(state, idx , v);
	}

	public String stringOfState(BigInteger state) {
		return Arrays.toString( enumerator.hashToArray(state) );
	}
	
	public BigInteger getState( int[] state ) {
		return enumerator.enumerate( state );
	}

}
