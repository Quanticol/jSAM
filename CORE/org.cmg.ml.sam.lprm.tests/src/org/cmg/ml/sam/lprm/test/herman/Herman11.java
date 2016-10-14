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
public class Herman11 extends LprmModule {
	
	public static final int _VAR_x1 = 0;
	public static final int _VAR_x2 = 1;
	public static final int _VAR_x3 = 2;
	public static final int _VAR_x4 = 3;
	public static final int _VAR_x5 = 4;
	public static final int _VAR_x6 = 5;
	public static final int _VAR_x7 = 6;
	public static final int _VAR_x8 = 7;
	public static final int _VAR_x9 = 8;
	public static final int _VAR_x10 = 9;
	public static final int _VAR_x11 = 10;
	
	public static final double _CONST_p = 0.5;
	
	public static final int[] _LOWER_BOUNDS_ = { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 };
	public static final int[] _UPPER_BOUNDS_ = { 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 };

	public final True<LprmState> _FORMULA_TRUE = new True<LprmState>();
	
	public final int _MACRO_num_tokens( LprmState current_state ) {
		BigInteger state = current_state.getState();
		
		int _var_x1 = enumerator.get(state, _VAR_x1);
		int _var_x2 = enumerator.get(state, _VAR_x2);
		int _var_x3 = enumerator.get(state, _VAR_x3);
		int _var_x4 = enumerator.get(state, _VAR_x4);
		int _var_x5 = enumerator.get(state, _VAR_x5);
		int _var_x6 = enumerator.get(state, _VAR_x6);
		int _var_x7 = enumerator.get(state, _VAR_x7);
		int _var_x8 = enumerator.get(state, _VAR_x8);
		int _var_x9 = enumerator.get(state, _VAR_x9);
		int _var_x10 = enumerator.get(state, _VAR_x10);
		int _var_x11 = enumerator.get(state, _VAR_x11);
		
		return (_var_x1==_var_x2?1:0)+
				(_var_x2==_var_x3?1:0)+
				(_var_x3==_var_x4?1:0)+
				(_var_x4==_var_x5?1:0)+
				(_var_x5==_var_x6?1:0)+
				(_var_x6==_var_x7?1:0)+
				(_var_x7==_var_x8?1:0)+
				(_var_x8==_var_x9?1:0)+
				(_var_x9==_var_x10?1:0)+
				(_var_x10==_var_x11?1:0)+
				(_var_x11==_var_x1?1:0);
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
		int _var_x4 = enumerator.get(state, _VAR_x4);
		int _var_x5 = enumerator.get(state, _VAR_x5);
		int _var_x6 = enumerator.get(state, _VAR_x6);
		int _var_x7 = enumerator.get(state, _VAR_x7);
		int _var_x8 = enumerator.get(state, _VAR_x8);
		int _var_x9 = enumerator.get(state, _VAR_x9);
		int _var_x10 = enumerator.get(state, _VAR_x10);
		int _var_x11 = enumerator.get(state, _VAR_x11);
		
		boolean _guard_process1_1 = (_var_x1==_var_x11);
		boolean _guard_process1_2 = !(_var_x1==_var_x11);
		boolean _guard_process2_1 = (_var_x2==_var_x1);
		boolean _guard_process2_2 = !(_var_x2==_var_x1);
		boolean _guard_process3_1 = (_var_x3==_var_x2);
		boolean _guard_process3_2 = !(_var_x3==_var_x2);
		boolean _guard_process4_1 = (_var_x4==_var_x3);
		boolean _guard_process4_2 = !(_var_x4==_var_x3);
		boolean _guard_process5_1 = (_var_x5==_var_x4);
		boolean _guard_process5_2 = !(_var_x5==_var_x4);
		boolean _guard_process6_1 = (_var_x6==_var_x5);
		boolean _guard_process6_2 = !(_var_x6==_var_x5);
		boolean _guard_process7_1 = (_var_x7==_var_x6);
		boolean _guard_process7_2 = !(_var_x7==_var_x6);
		boolean _guard_process8_1 = (_var_x8==_var_x7);
		boolean _guard_process8_2 = !(_var_x8==_var_x7);
		boolean _guard_process9_1 = (_var_x9==_var_x8);
		boolean _guard_process9_2 = !(_var_x9==_var_x8);
		boolean _guard_process10_1 = (_var_x10==_var_x9);
		boolean _guard_process10_2 = !(_var_x10==_var_x9);
		boolean _guard_process11_1 = (_var_x11==_var_x10);
		boolean _guard_process11_2 = !(_var_x11==_var_x10);

		Probability<LprmState> toReturn = new Probability<LprmState>();
		{   //START ACTIVITY: step
			Probability<LprmState> next_step = new Probability<LprmState>();
			if (((_guard_process1_1)||(_guard_process1_2))
				&&((_guard_process2_1)||(_guard_process2_2))
				&&((_guard_process3_1)||(_guard_process3_2))
				&&((_guard_process4_1)||(_guard_process4_2))
				&&((_guard_process5_1)||(_guard_process5_2))
				&&((_guard_process6_1)||(_guard_process6_2))
				&&((_guard_process7_1)||(_guard_process7_2))
				&&((_guard_process8_1)||(_guard_process8_2))
				&&((_guard_process9_1)||(_guard_process9_2))
				&&((_guard_process10_1)||(_guard_process10_2))
				&&((_guard_process11_1)||(_guard_process11_2))
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
						next_step_process1.set(foo_state.set( _VAR_x1 , _var_x9 ) , value*(1.0) );;
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
							next_step_process2.set(foo_state.set( _VAR_x2 , _var_x1 ) , value*(1.0) );
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
							next_step_process3.set(foo_state.set( _VAR_x3 , _var_x2 ) , value*(1.0) );
						}
												
					}
					
					next_step = next_step_process3;
										
				}//END: process3

				{//START: process4
					
					Probability<LprmState> next_step_process4 = new Probability<LprmState>();
				
					for (WeightedElement<LprmState> weightedElement : next_step) {

						LprmState foo_state = weightedElement.getElement();
						double value = weightedElement.getWeight();
						
						if (_guard_process4_1) {
							next_step_process4.set(foo_state.set( _VAR_x4 , 0 ) , value*(_CONST_p) );
							next_step_process4.set(foo_state.set( _VAR_x4 , 1 ) , value*(1 - _CONST_p) );
						}
						
						if (_guard_process4_2) {
							next_step_process4.set(foo_state.set( _VAR_x4 , _var_x3 ) , value*(1.0) );
						}
												
					}
					
					next_step = next_step_process4;
										
				}//END: process4

				{//START: process5
					
					Probability<LprmState> next_step_process5 = new Probability<LprmState>();
				
					for (WeightedElement<LprmState> weightedElement : next_step) {

						LprmState foo_state = weightedElement.getElement();
						double value = weightedElement.getWeight();
						
						if (_guard_process5_1) {
							next_step_process5.set(foo_state.set( _VAR_x5 , 0 ) , value*(_CONST_p) );
							next_step_process5.set(foo_state.set( _VAR_x5 , 1 ) , value*(1 - _CONST_p) );
						}
						
						if (_guard_process5_2) {
							next_step_process5.set(foo_state.set( _VAR_x5 , _var_x4 ) , value*(1.0) );
						}
												
					}
					
					next_step = next_step_process5;
										
				}//END: process5

				{//START: process6
					
					Probability<LprmState> next_step_process6 = new Probability<LprmState>();
				
					for (WeightedElement<LprmState> weightedElement : next_step) {

						LprmState foo_state = weightedElement.getElement();
						double value = weightedElement.getWeight();
						
						if (_guard_process6_1) {
							next_step_process6.set(foo_state.set( _VAR_x6 , 0 ) , value*(_CONST_p) );
							next_step_process6.set(foo_state.set( _VAR_x6 , 1 ) , value*(1 - _CONST_p) );
						}
						
						if (_guard_process6_2) {
							next_step_process6.set(foo_state.set( _VAR_x6 , _var_x5 ) , value*(1.0) );
						}
												
					}
					
					next_step = next_step_process6;
										
				}//END: process6

				{//START: process7
					
					Probability<LprmState> next_step_process7 = new Probability<LprmState>();
				
					for (WeightedElement<LprmState> weightedElement : next_step) {

						LprmState foo_state = weightedElement.getElement();
						double value = weightedElement.getWeight();
						
						if (_guard_process7_1) {
							next_step_process7.set(foo_state.set( _VAR_x7 , 0 ) , value*(_CONST_p) );
							next_step_process7.set(foo_state.set( _VAR_x7 , 1 ) , value*(1 - _CONST_p) );
						}
						
						if (_guard_process7_2) {
							next_step_process7.set(foo_state.set( _VAR_x7 , _var_x6 ) , value*(1.0) );
						}
												
					}
					
					next_step = next_step_process7;
										
				}//END: process7

				{//START: process8
					
					Probability<LprmState> next_step_process8 = new Probability<LprmState>();
				
					for (WeightedElement<LprmState> weightedElement : next_step) {

						LprmState foo_state = weightedElement.getElement();
						double value = weightedElement.getWeight();
						
						if (_guard_process8_1) {
							next_step_process8.set(foo_state.set( _VAR_x8 , 0 ) , value*(_CONST_p) );
							next_step_process8.set(foo_state.set( _VAR_x8 , 1 ) , value*(1 - _CONST_p) );
						}
						
						if (_guard_process8_2) {
							next_step_process8.set(foo_state.set( _VAR_x8 , _var_x7 ) , value*(1.0) );
						}
												
					}
					
					next_step = next_step_process8;
										
				}//END: process8

				{//START: process9
					
					Probability<LprmState> next_step_process9 = new Probability<LprmState>();
				
					for (WeightedElement<LprmState> weightedElement : next_step) {

						LprmState foo_state = weightedElement.getElement();
						double value = weightedElement.getWeight();
						
						if (_guard_process9_1) {
							next_step_process9.set(foo_state.set( _VAR_x9 , 0 ) , value*(_CONST_p) );
							next_step_process9.set(foo_state.set( _VAR_x9 , 1 ) , value*(1 - _CONST_p) );
						}
						
						if (_guard_process9_2) {
							next_step_process9.set(foo_state.set( _VAR_x9 , _var_x8 ) , value*(1.0) );
						}
												
					}
					
					next_step = next_step_process9;
										
				}//END: process9

				{//START: process10
					
					Probability<LprmState> next_step_process10 = new Probability<LprmState>();
				
					for (WeightedElement<LprmState> weightedElement : next_step) {

						LprmState foo_state = weightedElement.getElement();
						double value = weightedElement.getWeight();
						
						if (_guard_process10_1) {
							next_step_process10.set(foo_state.set( _VAR_x10 , 0 ) , value*(_CONST_p) );
							next_step_process10.set(foo_state.set( _VAR_x10 , 1 ) , value*(1 - _CONST_p) );
						}
						
						if (_guard_process10_2) {
							next_step_process10.set(foo_state.set( _VAR_x10 , _var_x9 ) , value*(1.0) );
						}
												
					}
					
					next_step = next_step_process10;
										
				}//END: process10

				{//START: process11
					
					Probability<LprmState> next_step_process11 = new Probability<LprmState>();
				
					for (WeightedElement<LprmState> weightedElement : next_step) {

						LprmState foo_state = weightedElement.getElement();
						double value = weightedElement.getWeight();
						
						if (_guard_process11_1) {
							next_step_process11.set(foo_state.set( _VAR_x11 , 0 ) , value*(_CONST_p) );
							next_step_process11.set(foo_state.set( _VAR_x11 , 1 ) , value*(1 - _CONST_p) );
						}
						
						if (_guard_process11_2) {
							next_step_process11.set(foo_state.set( _VAR_x11 , _var_x10 ) , value*(1.0) );
						}
												
					}
					
					next_step = next_step_process11;
										
				}//END: process11

			}
			
			//toReturn.add(next_step);
			toReturn = next_step;
		}   //END ACTIVITY: step

		return toReturn;
	}
	
	public static void main( String[] argv ) {
		
		Herman11 test = new Herman11();
		
		int size = 200;
		LprmState state = test.getStartState();
		PathFormula<LprmState> target = new Until<LprmState>(test.getStateFormula("TRUE"), 50, test.getStateFormula("stable"));
//		PathFormula<LprmState> target = new Until<>(test.getStateFormula("TRUE"), test.getStateFormula("stable"));
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
		return new LprmState(this, this.enumerator.enumerate(0,0,0,0,0,0,0,0,0,0,0));
	}

}
