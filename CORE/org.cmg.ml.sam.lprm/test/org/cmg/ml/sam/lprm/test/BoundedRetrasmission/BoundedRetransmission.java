package org.cmg.ml.sam.lprm.test.BoundedRetrasmission;
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
public class BoundedRetransmission extends LprmModule {
	
	
	public static final int _CONST_N = 10;
	
	public static final int _CONST_MAX = 10;
	
	public static final int _VAR_s = 0;
	public static final int _VAR_srep = 1;
	public static final int _VAR_nrtr = 2;
	public static final int _VAR_i = 3;
	public static final int _VAR_bs = 4;
	public static final int _VAR_s_ab = 5;
	public static final int _VAR_fs = 6;
	public static final int _VAR_ls = 7;
	public static final int _VAR_r = 8;
	public static final int _VAR_rrep = 9;
	public static final int _VAR_fr = 10;
	public static final int _VAR_lr = 11;
	public static final int _VAR_br = 12;
	public static final int _VAR_r_ab = 13;
	public static final int _VAR_recv = 14;
	public static final int _VAR_T = 14;
	public static final int _VAR_k = 15;
	public static final int _VAR_l = 16;
	
	
	public static final int[] _LOWER_BOUNDS_ = { 
		0 , // _VAR_s
		0 , // _VAR_step
		0 , // _VAR_nrtr
		0 , // _VAR_i
		0 , // _VAR_bs
		0 , // _VAR_s_ab
		0 , // _VAR_fs
		0 , // _VAR_ls
		0 , // _VAR_r
		0 , // _VAR_rrep
		0 , // _VAR_fr
		0 , // _VAR_lr
		0 , // _VAR_br
		0 , // _VAR_r_ab
		0 , // _VAR_recv
		0 , // _VAR_T
		0 , // _VAR_k
		0 , // _VAR_l		
	};
	public static final int[] _UPPER_BOUNDS_ = { 
		6 , // _VAR_s
		3 , // _VAR_step
		_CONST_MAX , // _VAR_nrtr
		_CONST_N , // _VAR_i
		1 , // _VAR_bs
		1 , // _VAR_s_ab
		1 , // _VAR_fs
		1 , // _VAR_ls
		5 , // _VAR_r
		4 , // _VAR_rrep
		1 , // _VAR_fr
		1 , // _VAR_lr
		1 , // _VAR_br
		1 , // _VAR_r_ab
		1 , // _VAR_recv
		1 , // _VAR_T
		2 , // _VAR_k
		2 , // _VAR_l		
	};

	public final True<LprmState> _FORMULA_TRUE = new True<LprmState>();
	
//	public final int _MACRO_num_tokens( LprmState current_state ) {
//		BigInteger state = current_state.getState();
//		
//		int _var_x1 = enumerator.get(state, _VAR_x1);
//		int _var_x2 = enumerator.get(state, _VAR_x2);
//		int _var_x3 = enumerator.get(state, _VAR_x3);
//		
//		return (_var_x1==_var_x2?1:0)+(_var_x2==_var_x3?1:0)+(_var_x3==_var_x1?1:0);
//	}
//	
//	public Predicate<LprmState> _label_stable = new Predicate<LprmState>() {
//
//		@Override
//		public boolean sat(LprmState current_state) {
//			return _MACRO_num_tokens(current_state)==1;
//		}
//	};
//
//	public final Atomic<LprmState> _FORMULA_stable = new Atomic<LprmState>(_label_stable);
//
//	public final Until<LprmState> _PATH_FORMULA_eventually_stable = new Until<LprmState>(_FORMULA_TRUE, _FORMULA_stable);
	
	@Override
	protected StateEnumerator initializeEnumerator() {
		return StateEnumerator.createEnumerator(_LOWER_BOUNDS_, _UPPER_BOUNDS_);
	}

	@Override
	protected Distribution<LprmState> doComputeNext(LprmState current_state) {
		
		BigInteger state = current_state.getState();

		int _var_s = getValue(state, _VAR_s);
		int _var_srep = getValue(state, _VAR_srep);
		int _var_nrtr = getValue(state, _VAR_nrtr);
		int _var_i = getValue(state, _VAR_i);
		int _var_bs = getValue(state, _VAR_bs);
		int _var_s_ab = getValue(state, _VAR_s_ab);
		int _var_fs = getValue(state, _VAR_fs);
		int _var_ls = getValue(state, _VAR_ls);
		int _var_r = getValue(state, _VAR_r);
		int _var_rrep = getValue(state, _VAR_rrep);
		int _var_fr = getValue(state, _VAR_fr);
		int _var_lr = getValue(state, _VAR_lr);
		int _var_br = getValue(state, _VAR_br);
		int _var_r_ab = getValue(state, _VAR_r_ab);
		int _var_recv = getValue(state, _VAR_recv);
		int _var_T = getValue(state, _VAR_T);
		int _var_k = getValue(state, _VAR_k);
		int _var_l = getValue(state, _VAR_l);

		Probability<LprmState> toReturn = new Probability<LprmState>();

		// START: *silent*
		
		// END: *silent*
				
		{ // START: NewFile
		
			boolean _guard_1 = (_var_s==0);
			boolean _guard_2 = (_var_T==0);
			
			if (_guard_1&&_guard_2) {
				Probability<LprmState> next_NewFile = new Probability<LprmState>();
			
				// Module: sender
				{
				Probability<LprmState> next_NewFile_sender = new Probability<LprmState>();
				if (_guard_1) {
					{
						LprmState foo_state = current_state;
						foo_state = foo_state.set(_VAR_s, 1);
						foo_state = foo_state.set(_VAR_i, 1);
						foo_state = foo_state.set(_VAR_srep, 0);
						next_NewFile_sender.set(foo_state, 1.0);
					}
				}
				next_NewFile = next_NewFile_sender;
				}
				// End module: sender
	
				// Module: tester	
				{
					Probability<LprmState> next_NewFile_tester = new Probability<LprmState>();
					for (WeightedElement<LprmState> we : next_NewFile) {
						double p = we.getWeight();
						if (_guard_2) {
							LprmState foo_state = we.getElement();
							foo_state = foo_state.set(_VAR_T, 1);							
							next_NewFile_tester.set(foo_state, p*1.0);							
						}					
					}
					next_NewFile = next_NewFile_tester;
				}
				// End module: sender
				
				toReturn.add(next_NewFile);

			}			
			
		} // END: NewFile

		
		{ // START: aF
			boolean _guard_1 = (_var_s == 1);
			boolean _guard_2 = (_var_s == 3) && (_var_nrtr<_CONST_MAX);
			boolean _guard_3 = (_var_k == 0);
			
			if (
				((_guard_1)||(_guard_2))
				&&
				(_guard_3)
			){
				Probability<LprmState> next_aF = new Probability<LprmState>();

				{ // Module: sender

					Probability<LprmState> next_aF_sender = new Probability<LprmState>();
					
					if (_guard_1) {
						LprmState foo_state = current_state;
						foo_state = foo_state.set(_VAR_s, 2);
						foo_state = foo_state.set(_VAR_fs, (_var_i==1?1:0));
						foo_state = foo_state.set(_VAR_ls, (_var_i==_CONST_N?1:0));
						foo_state = foo_state.set(_VAR_bs, _var_s_ab );
						foo_state = foo_state.set(_VAR_nrtr, 0 );
						next_aF_sender.set(foo_state, 1.0);						
					}
					
					if (_guard_2) {
						LprmState foo_state = current_state;
						foo_state = foo_state.set(_VAR_s, 2);
						foo_state = foo_state.set(_VAR_fs, (_var_i==1?1:0));
						foo_state = foo_state.set(_VAR_ls, (_var_i==_CONST_N?1:0));
						foo_state = foo_state.set(_VAR_bs, _var_s_ab );
						foo_state = foo_state.set(_VAR_nrtr, 0 );
						next_aF_sender.set(foo_state, 1.0);						
					}
					
					next_aF = next_aF_sender;
					
				} // End module: sender

				{ // Module: channelK

					Probability<LprmState> next_aF_channelK = new Probability<LprmState>();
					
					for (WeightedElement<LprmState> we : next_aF) {
						
						
						
					}
					
					next_aF = next_aF_channelK;
					
				} // End module: channelK
					
				toReturn.add(next_aF);
			}
		
		} // END:aF
		
		// START: aB	
		
		// END:aB
		
		// START: TO_Msg
		
		// END: TO_Ack
		
		// START: SyncWait
		
		// END: SyncWait	
		
		// START: aG	
		
		// END:aG

		// START: aA	
		
		// END:aA


		return toReturn;
	}
	
	public static void main( String[] argv ) {
		
		BoundedRetransmission test = new BoundedRetransmission();
		
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
//		if ("stable".equals(name)) {
//			return _FORMULA_stable;
//		}
		return null;
	}

	@Override
	public PathFormula<LprmState> getPathFormula(String name) {
//		if ("eventually stable".equals(name)) {
//			return _PATH_FORMULA_eventually_stable;
//		}
		return null;
	}

	@Override
	protected LprmState initializeStartState() {
		return new LprmState(this, this.enumerator.enumerate(0,0,0));
	}

}
