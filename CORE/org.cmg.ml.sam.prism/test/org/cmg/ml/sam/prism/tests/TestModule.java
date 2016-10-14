package org.cmg.ml.sam.prism.tests;

import java.math.BigInteger;

import org.cmg.ml.sam.core.Filter;
import org.cmg.ml.sam.core.StateEnumerator;
import org.cmg.ml.sam.prism.BasicPrismSystem;
import org.cmg.ml.sam.prism.Command;
import org.cmg.ml.sam.prism.PrismModel;
import org.cmg.ml.sam.prism.PrismState;
import org.cmg.ml.sam.prism.PrismSystem;
import org.cmg.ml.sam.prism.Rule;
import org.junit.Test;

public class TestModule {
	
	public static int VAR_X = 0;

	public static class DiceModule extends PrismModel {
		
		public static StateEnumerator enumerator = StateEnumerator.createEnumerator(new int[] { 1 } );

		public static Filter<BigInteger> GUARD_RULE_1 = new Filter<BigInteger>() {

			@Override
			public boolean eval(BigInteger t) {
				return enumerator.get(t,VAR_X)==1;
			}
			
		};
		
		public static Command COMMAND_1_RULE_1 = new Command( enumerator ) {
			
			@Override
			protected double computeWeight(BigInteger originalState) {
				return 1.0/2.0;
			}

			@Override
			protected BigInteger doApply(BigInteger originalState,
					BigInteger currentState) {
				return enumerator.set(currentState, VAR_X, 1);
			}
			
		};
		
		public static Command COMMAND_2_RULE_1 = new Command(enumerator) {
			
			@Override
			protected double computeWeight(BigInteger originalState) {
				return 1.0/2.0;
			}
			
			@Override
			protected BigInteger doApply(BigInteger originalState,
					BigInteger currentState) {
				return enumerator.set(currentState, VAR_X, enumerator.get(currentState, VAR_X));
			}

		};

		public static Rule RULE_1 = new Rule( GUARD_RULE_1 , new Command[] { COMMAND_1_RULE_1 , COMMAND_2_RULE_1 } );
		
		public DiceModule() {
			super(ModelType.DTMC,1);
			setStateEnumerator(enumerator);
		}

		@Override
		protected PrismSystem createSystem() {
			return new BasicPrismSystem( 1 , RULE_1 );
		}
		
		
		
	}
	
	
	@Test
	public void test() {
		DiceModule module = new DiceModule();
		PrismSystem system = module.createSystem();
	}

}
