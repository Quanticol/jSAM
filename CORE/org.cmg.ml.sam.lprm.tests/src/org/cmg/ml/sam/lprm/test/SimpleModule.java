package org.cmg.ml.sam.lprm.test;
/**
 * 
 */


import java.math.BigInteger;

import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.Predicate;
import org.cmg.ml.sam.core.Probability;
import org.cmg.ml.sam.core.StateEnumerator;
import org.cmg.ml.sam.core.WeightedElement;
import org.cmg.ml.sam.core.logic.Atomic;
import org.cmg.ml.sam.core.logic.PathFormula;
import org.cmg.ml.sam.core.logic.StateFormula;
import org.cmg.ml.sam.core.logic.True;
import org.cmg.ml.sam.core.logic.Until;
import org.cmg.ml.sam.core.mc.pomc.OnTheFlyProbabilisticModelChecker;
import org.cmg.ml.sam.lprm.LprmModule;
import org.cmg.ml.sam.lprm.LprmState;

/**
 * @author loreti
 *
 */
public class SimpleModule extends LprmModule {
	
	public static final int _VAR_s = 0;
	
	public static final int[] _LOWER_BOUNDS_ = { 0 };
	public static final int[] _UPPER_BOUNDS_ = { 4 };

	public Predicate<LprmState> _label_stable = new Predicate<LprmState>() {

		@Override
		public boolean sat(LprmState current_state) {
			BigInteger state = current_state.getState();
			int _var_s = enumerator.get( state , _VAR_s );
			return _var_s == 4;
		}
	};
	
	public final True<LprmState> _FORMULA_TRUE = new True<LprmState>();

	public final Atomic<LprmState> _FORMULA_success = new Atomic<LprmState>(_label_stable);

	public final Until<LprmState> _PATH_FORMULA_eventually_success = new Until<LprmState>(_FORMULA_TRUE, _FORMULA_success);

	@Override
	protected StateEnumerator initializeEnumerator() {
		return StateEnumerator.createEnumerator(_LOWER_BOUNDS_, _UPPER_BOUNDS_);
	}

	@Override
	protected Distribution<LprmState> doComputeNext(LprmState current_state) {
		
		BigInteger state = current_state.getState();
		
		int _var_s = enumerator.get(state, _VAR_s);
		
		boolean _guard_Simple_0 = (_var_s==0);
		boolean _guard_Simple_1 = (_var_s==1);
		boolean _guard_Simple_3 = (_var_s==3);
		boolean _guard_Simple_2 = (_var_s==2);
		boolean _guard_Simple_4 = (_var_s==4);

		Probability<LprmState> toReturn = new Probability<LprmState>();

		{   //START ACTIVITY: *internal*
			Probability<LprmState> next_step = new Probability<LprmState>();
			LprmState foo_state = current_state;

			if (_guard_Simple_0) {
				next_step.set( foo_state.set(_VAR_s, 1) , 0.5 );
				next_step.set( foo_state.set(_VAR_s, 2) , 0.5 );				
			}
			
			if (_guard_Simple_1) {				
				next_step.set( foo_state.set(_VAR_s, 0) , 0.5 );
				next_step.set( foo_state.set(_VAR_s, 3) , 0.5 );				
			}

			if (_guard_Simple_3) {				
				next_step.set( foo_state.set(_VAR_s, 3) , 1.0 );				
			}
			
			if (_guard_Simple_2) {				
				next_step.set( foo_state.set(_VAR_s, 0) , 0.5 );
				next_step.set( foo_state.set(_VAR_s, 4) , 0.5 );				
			}

			if (_guard_Simple_4) {				
				next_step.set( foo_state.set(_VAR_s, 2) , 0.5 );
				next_step.set( foo_state.set(_VAR_s, 4) , 0.5 );				
			}
			
			toReturn = next_step;

		}

		return toReturn;
	}
	
	public static void main( String[] argv ) {
		
		SimpleModule test = new SimpleModule();
		
		int size = 100;
		LprmState state = test.getStartState();
		PathFormula<LprmState> target = new Until<LprmState>(test.getStateFormula("TRUE"), test.getStateFormula("success"));
		double time = 0;
		for( int i=0 ; i<size ; i++ ) {
			OnTheFlyProbabilisticModelChecker<LprmState> opmc = new OnTheFlyProbabilisticModelChecker<LprmState>();
			long ct = System.currentTimeMillis();
			System.out.println("Probability: "+opmc.getProbability(state,target));
			ct = System.currentTimeMillis() - ct;
			System.out.println("Time: "+ct);
			time = time + ct;
		}
		System.out.println("\n\nAVERAGE TIME: "+(time/size));

	}

	@Override
	public String[] getStateFormulae() {
		return new String[] { "TRUE" , "success" };
	}

	@Override
	public String[] getPathFormulae() {
		return new String[] { "eventually_success" };
	}

	@Override
	public StateFormula<LprmState> getStateFormula(String name) {
		if ("TRUE".equals(name)) {
			return _FORMULA_TRUE;
		}
		if ("success".equals(name)) {
			return _FORMULA_success;
		}
		return null;
	}

	@Override
	public PathFormula<LprmState> getPathFormula(String name) {
		if ("eventually_success".equals(name)) {
			return _PATH_FORMULA_eventually_success;
		}
		return null;
	}

	@Override
	protected LprmState initializeStartState() {
		return new LprmState(this, this.enumerator.enumerate(0));
	}

}
