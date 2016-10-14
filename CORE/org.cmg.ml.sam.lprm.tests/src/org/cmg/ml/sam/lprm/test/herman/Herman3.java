package org.cmg.ml.sam.lprm.test.herman;
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
public class Herman3 extends LprmModule {
	
	public static final int _VAR_x1 = 0;
	public static final int _VAR_x2 = 1;
	public static final int _VAR_x3 = 2;
	
	public static final double _CONST_p = 0.5;
	
	public static final int[] _LOWER_BOUNDS_ = { 0 , 0 , 0 };
	public static final int[] _UPPER_BOUNDS_ = { 1 , 1 , 1 };

	public final True<LprmState> _FORMULA_TRUE = new True<LprmState>();
	
	public final int _MACRO_num_tokens( LprmState current_state ) {
		BigInteger state = current_state.getState();
		
		int _var_x1 = enumerator.get(state, _VAR_x1);
		int _var_x2 = enumerator.get(state, _VAR_x2);
		int _var_x3 = enumerator.get(state, _VAR_x3);
		
		return (_var_x1==_var_x2?1:0)+(_var_x2==_var_x3?1:0)+(_var_x3==_var_x1?1:0);
	}
	
	public Predicate<LprmState> _label_stable = new Predicate<LprmState>() {

		@Override
		public boolean sat(LprmState current_state) {
			return _MACRO_num_tokens(current_state)==1;
		}
	};

	public final Atomic<LprmState> _FORMULA_stable = new Atomic<LprmState>(_label_stable);

	public final Until<LprmState> _PATH_FORMULA_eventually_stable = new Until<LprmState>(_FORMULA_TRUE, _FORMULA_stable);
	
	@Override
	protected StateEnumerator initializeEnumerator() {
		return StateEnumerator.createEnumerator(_LOWER_BOUNDS_, _UPPER_BOUNDS_);
	}

	@Override
	protected Distribution<LprmState> doComputeNext(LprmState current_state) {
		
		BigInteger state = current_state.getState();
		
		int _var_x1 = enumerator.get(state, _VAR_x1);
		int _var_x2 = enumerator.get(state, _VAR_x2);
		int _var_x3 = enumerator.get(state, _VAR_x3);
		
		boolean _guard_process1_1 = (_var_x1==_var_x3);
		boolean _guard_process1_2 = !(_var_x1==_var_x3);
		boolean _guard_process2_1 = (_var_x2==_var_x1);
		boolean _guard_process2_2 = !(_var_x2==_var_x1);
		boolean _guard_process3_1 = (_var_x3==_var_x2);
		boolean _guard_process3_2 = !(_var_x3==_var_x2);

		Probability<LprmState> toReturn = new Probability<LprmState>();
		{   //START ACTIVITY: step
			Probability<LprmState> next_step = new Probability<LprmState>();
			if (((_guard_process1_1)||(_guard_process1_2))
				&&((_guard_process2_1)||(_guard_process2_2))
				&&((_guard_process3_1)||(_guard_process3_2))
			) {			
							
				{//START: process1
					
					Probability<LprmState> next_step_process1 = new Probability<LprmState>();
				
					LprmState foo_state = current_state;
					double value = 1.0;
					
					if (_guard_process1_1) {
						next_step_process1.set(foo_state.set( _VAR_x1 , 0 ) , value*(_CONST_p) );;
						next_step_process1.set(foo_state.set( _VAR_x1 , 1 ) , value*(1 - _CONST_p) );;
					}
					
					if (_guard_process1_2) {
						next_step_process1.set(foo_state.set( _VAR_x1 , _var_x3 ) , value*(1.0) );;
					}

					next_step = next_step_process1;
				}//END: process1

				
				{//START: process2
					
					Probability<LprmState> next_step_process2 = new Probability<LprmState>();
				
					for (WeightedElement<LprmState> weightedElement : next_step) {

						LprmState foo_state = weightedElement.getElement();
						double value = weightedElement.getWeight();
						
						if (_guard_process2_1) {
							next_step_process2.set(foo_state.set( _VAR_x2 , 0 ) , value*(_CONST_p) );
							next_step_process2.set(foo_state.set( _VAR_x2 , 1 ) , value*(1 - _CONST_p) );
						}
						
						if (_guard_process2_2) {
							next_step_process2.set(current_state.set( _VAR_x2 , _var_x1 ) , value*(1.0) );
						}
												
					}
					
					next_step = next_step_process2;
										
				}//END: process2

				{//START: process3
					
					Probability<LprmState> next_step_process3 = new Probability<LprmState>();
				
					for (WeightedElement<LprmState> weightedElement : next_step) {

						LprmState foo_state = weightedElement.getElement();
						double value = weightedElement.getWeight();
						
						if (_guard_process3_1) {
							next_step_process3.set(foo_state.set( _VAR_x3 , 0 ) , value*(_CONST_p) );
							next_step_process3.set(foo_state.set( _VAR_x3 , 1 ) , value*(1 - _CONST_p) );
						}
						
						if (_guard_process3_2) {
							next_step_process3.set(current_state.set( _VAR_x3 , _var_x2 ) , value*(1.0) );
						}
												
					}
					
					next_step = next_step_process3;
										
				}//END: process3
				
			}
			
			toReturn.add(next_step);
		}   //END ACTIVITY: step

		return toReturn;
	}
	
	public static void main( String[] argv ) {
		
		Herman3 test = new Herman3();
		
		int size = 100;
		LprmState state = test.getStartState();
		PathFormula<LprmState> target = new Until<LprmState>(test.getStateFormula("TRUE"), 2, test.getStateFormula("stable"));
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
		return new String[] {
				"TRUE" , "stable"
		};
	}

	@Override
	public String[] getPathFormulae() {
		return new String[] { "eventually stable"};
	}

	@Override
	public StateFormula<LprmState> getStateFormula(String name) {
		if ("TRUE".equals(name)) {
			return _FORMULA_TRUE;
		}
		if ("stable".equals(name)) {
			return _FORMULA_stable;
		}
		return null;
	}

	@Override
	public PathFormula<LprmState> getPathFormula(String name) {
		if ("eventually stable".equals(name)) {
			return _PATH_FORMULA_eventually_stable;
		}
		return null;
	}

	@Override
	protected LprmState initializeStartState() {
		return new LprmState(this, this.enumerator.enumerate(0,0,0));
	}

}
