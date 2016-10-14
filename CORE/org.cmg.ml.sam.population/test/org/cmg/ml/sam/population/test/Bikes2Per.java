/**
 * 
 */
package org.cmg.ml.sam.population.test;

import org.apache.commons.math3.random.RandomGenerator;
import org.cmg.ml.sam.core.*;
import org.cmg.ml.sam.core.logic.*;
import org.cmg.ml.sam.core.mc.pomc.OnTheFlyProbabilisticModelChecker;
import org.cmg.ml.sam.core.sim.DefaultRandomGenerator;
import org.cmg.ml.sam.core.sim.ProbabilisticSimulator;
import org.cmg.ml.sam.core.sim.SimulationController;
import org.cmg.ml.sam.population.*;

import java.util.Map;
import java.util.HashMap;

public class Bikes2Per extends PopulationSpecification {
		
		public static int _STATE_Y0 = 0;
		public static int _STATE_Y1 = 1;
		public static int _STATE_Y2 = 2;
		public static int _STATE_Y3 = 3;
		public static int _STATE_Y4 = 4;
		public static int _STATE_Y5 = 5;
		public static int _STATE_Y6 = 6;
		public static int _STATE_Y7 = 7;
		public static int _STATE_Y8 = 8;
		public static int _STATE_Y9 = 9;
		public static int _STATE_Y10 = 10;
		
		protected void initStateNameVector() {
			this.states = new String[11];
			states[_STATE_Y0] = "Y0";
			states[_STATE_Y1] = "Y1";
			states[_STATE_Y2] = "Y2";
			states[_STATE_Y3] = "Y3";
			states[_STATE_Y4] = "Y4";
			states[_STATE_Y5] = "Y5";
			states[_STATE_Y6] = "Y6";
			states[_STATE_Y7] = "Y7";
			states[_STATE_Y8] = "Y8";
			states[_STATE_Y9] = "Y9";
			states[_STATE_Y10] = "Y10";
		}
		

		public static double _CONST_N = 10;
		public static double _CONST_s = 20;
		public static double _CONST_v = 10;
		public static double _CONST_lambda = (_CONST_v)/((_CONST_s)+(_CONST_v));
		public static double _CONST_mu = (_CONST_s)/((_CONST_s)+(_CONST_v));
		
		public static ProbabilityFunction _ACT_return_PROBABILITY_ = new ProbabilityFunction() {
		
			//@Override 
			public double eval(double[] occupancy) {
				return (_CONST_mu)*(((_CONST_s)-((occupancy[ _STATE_Y1 ])+(((2)*(occupancy[ _STATE_Y2 ]))+(((3)*(occupancy[ _STATE_Y3 ]))+(((4)*(occupancy[ _STATE_Y4 ]))+(((5)*(occupancy[ _STATE_Y5 ]))+(((6)*(occupancy[ _STATE_Y6 ]))+(((7)*(occupancy[ _STATE_Y7 ]))+(((8)*(occupancy[ _STATE_Y8 ]))+(((9)*(occupancy[ _STATE_Y9 ]))+((10)*(occupancy[ _STATE_Y10 ]))))))))))))/(_CONST_s));
			}
			
		};
		public static ProbabilityFunction _ACT_returnAt0_PROBABILITY_ = new ProbabilityFunction() {
		
			//@Override 
			public double eval(double[] occupancy) {
				return (_CONST_mu)*((((_CONST_s)-((occupancy[ _STATE_Y1 ])+(((2)*(occupancy[ _STATE_Y2 ]))+(((3)*(occupancy[ _STATE_Y3 ]))+(((4)*(occupancy[ _STATE_Y4 ]))+(((5)*(occupancy[ _STATE_Y5 ]))+(((6)*(occupancy[ _STATE_Y6 ]))+(((7)*(occupancy[ _STATE_Y7 ]))+(((8)*(occupancy[ _STATE_Y8 ]))+(((9)*(occupancy[ _STATE_Y9 ]))+((10)*(occupancy[ _STATE_Y10 ]))))))))))))/(_CONST_s))*(((2)*((occupancy[ _STATE_Y1 ])+((occupancy[ _STATE_Y2 ])+((occupancy[ _STATE_Y3 ])+((occupancy[ _STATE_Y4 ])+((occupancy[ _STATE_Y5 ])+((occupancy[ _STATE_Y6 ])+((occupancy[ _STATE_Y7 ])+((occupancy[ _STATE_Y8 ])+((occupancy[ _STATE_Y9 ])+(occupancy[ _STATE_Y10 ])))))))))))+(occupancy[ _STATE_Y0 ])));
			}
			
		};
		public static ProbabilityFunction _ACT_returnAt1_PROBABILITY_ = new ProbabilityFunction() {
		
			//@Override 
			public double eval(double[] occupancy) {
				return (_CONST_mu)*((((_CONST_s)-((occupancy[ _STATE_Y1 ])+(((2)*(occupancy[ _STATE_Y2 ]))+(((3)*(occupancy[ _STATE_Y3 ]))+(((4)*(occupancy[ _STATE_Y4 ]))+(((5)*(occupancy[ _STATE_Y5 ]))+(((6)*(occupancy[ _STATE_Y6 ]))+(((7)*(occupancy[ _STATE_Y7 ]))+(((8)*(occupancy[ _STATE_Y8 ]))+(((9)*(occupancy[ _STATE_Y9 ]))+((10)*(occupancy[ _STATE_Y10 ]))))))))))))/(_CONST_s))*(((2)*((occupancy[ _STATE_Y2 ])+((occupancy[ _STATE_Y3 ])+((occupancy[ _STATE_Y4 ])+((occupancy[ _STATE_Y5 ])+((occupancy[ _STATE_Y6 ])+((occupancy[ _STATE_Y7 ])+((occupancy[ _STATE_Y8 ])+((occupancy[ _STATE_Y9 ])+(occupancy[ _STATE_Y10 ]))))))))))+(occupancy[ _STATE_Y1 ])));
			}
			
		};
		public static ProbabilityFunction _ACT_returnAt2_PROBABILITY_ = new ProbabilityFunction() {
		
			//@Override 
			public double eval(double[] occupancy) {
				return (_CONST_mu)*((((_CONST_s)-((occupancy[ _STATE_Y1 ])+(((2)*(occupancy[ _STATE_Y2 ]))+(((3)*(occupancy[ _STATE_Y3 ]))+(((4)*(occupancy[ _STATE_Y4 ]))+(((5)*(occupancy[ _STATE_Y5 ]))+(((6)*(occupancy[ _STATE_Y6 ]))+(((7)*(occupancy[ _STATE_Y7 ]))+(((8)*(occupancy[ _STATE_Y8 ]))+(((9)*(occupancy[ _STATE_Y9 ]))+((10)*(occupancy[ _STATE_Y10 ]))))))))))))/(_CONST_s))*(((2)*((occupancy[ _STATE_Y3 ])+((occupancy[ _STATE_Y4 ])+((occupancy[ _STATE_Y5 ])+((occupancy[ _STATE_Y6 ])+((occupancy[ _STATE_Y7 ])+((occupancy[ _STATE_Y8 ])+((occupancy[ _STATE_Y9 ])+(occupancy[ _STATE_Y10 ])))))))))+(occupancy[ _STATE_Y2 ])));
			}
			
		};
		public static ProbabilityFunction _ACT_returnAt3_PROBABILITY_ = new ProbabilityFunction() {
		
			//@Override 
			public double eval(double[] occupancy) {
				return (_CONST_mu)*((((_CONST_s)-((occupancy[ _STATE_Y1 ])+(((2)*(occupancy[ _STATE_Y2 ]))+(((3)*(occupancy[ _STATE_Y3 ]))+(((4)*(occupancy[ _STATE_Y4 ]))+(((5)*(occupancy[ _STATE_Y5 ]))+(((6)*(occupancy[ _STATE_Y6 ]))+(((7)*(occupancy[ _STATE_Y7 ]))+(((8)*(occupancy[ _STATE_Y8 ]))+(((9)*(occupancy[ _STATE_Y9 ]))+((10)*(occupancy[ _STATE_Y10 ]))))))))))))/(_CONST_s))*(((2)*((occupancy[ _STATE_Y4 ])+((occupancy[ _STATE_Y5 ])+((occupancy[ _STATE_Y6 ])+((occupancy[ _STATE_Y7 ])+((occupancy[ _STATE_Y8 ])+((occupancy[ _STATE_Y9 ])+(occupancy[ _STATE_Y10 ]))))))))+(occupancy[ _STATE_Y3 ])));
			}
			
		};
		public static ProbabilityFunction _ACT_returnAt4_PROBABILITY_ = new ProbabilityFunction() {
		
			//@Override 
			public double eval(double[] occupancy) {
				return (_CONST_mu)*((((_CONST_s)-((occupancy[ _STATE_Y1 ])+(((2)*(occupancy[ _STATE_Y2 ]))+(((3)*(occupancy[ _STATE_Y3 ]))+(((4)*(occupancy[ _STATE_Y4 ]))+(((5)*(occupancy[ _STATE_Y5 ]))+(((6)*(occupancy[ _STATE_Y6 ]))+(((7)*(occupancy[ _STATE_Y7 ]))+(((8)*(occupancy[ _STATE_Y8 ]))+(((9)*(occupancy[ _STATE_Y9 ]))+((10)*(occupancy[ _STATE_Y10 ]))))))))))))/(_CONST_s))*(((2)*((occupancy[ _STATE_Y5 ])+((occupancy[ _STATE_Y6 ])+((occupancy[ _STATE_Y7 ])+((occupancy[ _STATE_Y8 ])+((occupancy[ _STATE_Y9 ])+(occupancy[ _STATE_Y10 ])))))))+(occupancy[ _STATE_Y4 ])));
			}
			
		};
		public static ProbabilityFunction _ACT_returnAt5_PROBABILITY_ = new ProbabilityFunction() {
		
			//@Override 
			public double eval(double[] occupancy) {
				return (_CONST_mu)*((((_CONST_s)-((occupancy[ _STATE_Y1 ])+(((2)*(occupancy[ _STATE_Y2 ]))+(((3)*(occupancy[ _STATE_Y3 ]))+(((4)*(occupancy[ _STATE_Y4 ]))+(((5)*(occupancy[ _STATE_Y5 ]))+(((6)*(occupancy[ _STATE_Y6 ]))+(((7)*(occupancy[ _STATE_Y7 ]))+(((8)*(occupancy[ _STATE_Y8 ]))+(((9)*(occupancy[ _STATE_Y9 ]))+((10)*(occupancy[ _STATE_Y10 ]))))))))))))/(_CONST_s))*(((2)*((occupancy[ _STATE_Y6 ])+((occupancy[ _STATE_Y7 ])+((occupancy[ _STATE_Y8 ])+((occupancy[ _STATE_Y9 ])+(occupancy[ _STATE_Y10 ]))))))+(occupancy[ _STATE_Y5 ])));
			}
			
		};
		public static ProbabilityFunction _ACT_returnAt6_PROBABILITY_ = new ProbabilityFunction() {
		
			//@Override 
			public double eval(double[] occupancy) {
				return (_CONST_mu)*((((_CONST_s)-((occupancy[ _STATE_Y1 ])+(((2)*(occupancy[ _STATE_Y2 ]))+(((3)*(occupancy[ _STATE_Y3 ]))+(((4)*(occupancy[ _STATE_Y4 ]))+(((5)*(occupancy[ _STATE_Y5 ]))+(((6)*(occupancy[ _STATE_Y6 ]))+(((7)*(occupancy[ _STATE_Y7 ]))+(((8)*(occupancy[ _STATE_Y8 ]))+(((9)*(occupancy[ _STATE_Y9 ]))+((10)*(occupancy[ _STATE_Y10 ]))))))))))))/(_CONST_s))*(((2)*((occupancy[ _STATE_Y7 ])+((occupancy[ _STATE_Y8 ])+((occupancy[ _STATE_Y9 ])+(occupancy[ _STATE_Y10 ])))))+(occupancy[ _STATE_Y6 ])));
			}
			
		};
		public static ProbabilityFunction _ACT_returnAt7_PROBABILITY_ = new ProbabilityFunction() {
		
			//@Override 
			public double eval(double[] occupancy) {
				return (_CONST_mu)*((((_CONST_s)-((occupancy[ _STATE_Y1 ])+(((2)*(occupancy[ _STATE_Y2 ]))+(((3)*(occupancy[ _STATE_Y3 ]))+(((4)*(occupancy[ _STATE_Y4 ]))+(((5)*(occupancy[ _STATE_Y5 ]))+(((6)*(occupancy[ _STATE_Y6 ]))+(((7)*(occupancy[ _STATE_Y7 ]))+(((8)*(occupancy[ _STATE_Y8 ]))+(((9)*(occupancy[ _STATE_Y9 ]))+((10)*(occupancy[ _STATE_Y10 ]))))))))))))/(_CONST_s))*(((2)*((occupancy[ _STATE_Y8 ])+((occupancy[ _STATE_Y9 ])+(occupancy[ _STATE_Y10 ]))))+(occupancy[ _STATE_Y7 ])));
			}
			
		};
		public static ProbabilityFunction _ACT_returnAt8_PROBABILITY_ = new ProbabilityFunction() {
		
			//@Override 
			public double eval(double[] occupancy) {
				return (_CONST_mu)*((((_CONST_s)-((occupancy[ _STATE_Y1 ])+(((2)*(occupancy[ _STATE_Y2 ]))+(((3)*(occupancy[ _STATE_Y3 ]))+(((4)*(occupancy[ _STATE_Y4 ]))+(((5)*(occupancy[ _STATE_Y5 ]))+(((6)*(occupancy[ _STATE_Y6 ]))+(((7)*(occupancy[ _STATE_Y7 ]))+(((8)*(occupancy[ _STATE_Y8 ]))+(((9)*(occupancy[ _STATE_Y9 ]))+((10)*(occupancy[ _STATE_Y10 ]))))))))))))/(_CONST_s))*(((2)*((occupancy[ _STATE_Y9 ])+(occupancy[ _STATE_Y10 ])))+(occupancy[ _STATE_Y8 ])));
			}
			
		};
		public static ProbabilityFunction _ACT_returnAt9_PROBABILITY_ = new ProbabilityFunction() {
		
			//@Override 
			public double eval(double[] occupancy) {
				return (_CONST_mu)*((((_CONST_s)-((occupancy[ _STATE_Y1 ])+(((2)*(occupancy[ _STATE_Y2 ]))+(((3)*(occupancy[ _STATE_Y3 ]))+(((4)*(occupancy[ _STATE_Y4 ]))+(((5)*(occupancy[ _STATE_Y5 ]))+(((6)*(occupancy[ _STATE_Y6 ]))+(((7)*(occupancy[ _STATE_Y7 ]))+(((8)*(occupancy[ _STATE_Y8 ]))+(((9)*(occupancy[ _STATE_Y9 ]))+((10)*(occupancy[ _STATE_Y10 ]))))))))))))/(_CONST_s))*(((2)*(occupancy[ _STATE_Y10 ]))+(occupancy[ _STATE_Y9 ])));
			}
			
		};
		public static ProbabilityFunction _ACT_get_PROBABILITY_ = new ProbabilityFunction() {
		
			//@Override 
			public double eval(double[] occupancy) {
				return _CONST_lambda;
			}
			
		};
		

		public static LocalState _RULE_Y0 =  new LocalState( 
			_STATE_Y0 ,  
			new LocalState.RuleElement( _ACT_returnAt0_PROBABILITY_ , _STATE_Y1 ) 
		);
		public static LocalState _RULE_Y1 =  new LocalState( 
			_STATE_Y1 ,  
			new LocalState.RuleElement( _ACT_get_PROBABILITY_ , _STATE_Y0 ) ,
			new LocalState.RuleElement( _ACT_returnAt1_PROBABILITY_ , _STATE_Y2 ) 
		);
		public static LocalState _RULE_Y2 =  new LocalState( 
			_STATE_Y2 ,  
			new LocalState.RuleElement( _ACT_get_PROBABILITY_ , _STATE_Y1 ) ,
			new LocalState.RuleElement( _ACT_returnAt2_PROBABILITY_ , _STATE_Y3 ) 
		);
		public static LocalState _RULE_Y3 =  new LocalState( 
			_STATE_Y3 ,  
			new LocalState.RuleElement( _ACT_get_PROBABILITY_ , _STATE_Y2 ) ,
			new LocalState.RuleElement( _ACT_returnAt3_PROBABILITY_ , _STATE_Y4 ) 
		);
		public static LocalState _RULE_Y4 =  new LocalState( 
			_STATE_Y4 ,  
			new LocalState.RuleElement( _ACT_get_PROBABILITY_ , _STATE_Y3 ) ,
			new LocalState.RuleElement( _ACT_returnAt4_PROBABILITY_ , _STATE_Y5 ) 
		);
		public static LocalState _RULE_Y5 =  new LocalState( 
			_STATE_Y5 ,  
			new LocalState.RuleElement( _ACT_get_PROBABILITY_ , _STATE_Y4 ) ,
			new LocalState.RuleElement( _ACT_returnAt5_PROBABILITY_ , _STATE_Y6 ) 
		);
		public static LocalState _RULE_Y6 =  new LocalState( 
			_STATE_Y6 ,  
			new LocalState.RuleElement( _ACT_get_PROBABILITY_ , _STATE_Y5 ) ,
			new LocalState.RuleElement( _ACT_returnAt6_PROBABILITY_ , _STATE_Y7 ) 
		);
		public static LocalState _RULE_Y7 =  new LocalState( 
			_STATE_Y7 ,  
			new LocalState.RuleElement( _ACT_get_PROBABILITY_ , _STATE_Y6 ) ,
			new LocalState.RuleElement( _ACT_returnAt7_PROBABILITY_ , _STATE_Y8 ) 
		);
		public static LocalState _RULE_Y8 =  new LocalState( 
			_STATE_Y8 ,  
			new LocalState.RuleElement( _ACT_get_PROBABILITY_ , _STATE_Y7 ) ,
			new LocalState.RuleElement( _ACT_returnAt8_PROBABILITY_ , _STATE_Y9 ) 
		);
		public static LocalState _RULE_Y9 =  new LocalState( 
			_STATE_Y9 ,  
			new LocalState.RuleElement( _ACT_get_PROBABILITY_ , _STATE_Y8 ) ,
			new LocalState.RuleElement( _ACT_returnAt9_PROBABILITY_ , _STATE_Y10 ) 
		);
		public static LocalState _RULE_Y10 =  new LocalState( 
			_STATE_Y10 ,  
			new LocalState.RuleElement( _ACT_get_PROBABILITY_ , _STATE_Y9 ) 
		);
				
		
		protected void initPopulationModule() {		
		 	this.module = new PopulationModule( 
				11 , 
				_RULE_Y0,
				_RULE_Y1,
				_RULE_Y2,
				_RULE_Y3,
				_RULE_Y4,
				_RULE_Y5,
				_RULE_Y6,
				_RULE_Y7,
				_RULE_Y8,
				_RULE_Y9,
				_RULE_Y10
			);		
		}

		public static Atomic<PopulationState> _STATE_Y0_OF_INDIVIDUALS = new Atomic<PopulationState>( 
		
			new Predicate<PopulationState>() {
				
				public boolean sat( PopulationState t) {						
					return _STATE_Y0 == t.getStateAt(0);					
				}			
					
			}
			
		);
		public static Atomic<PopulationState> _STATE_Y1_OF_INDIVIDUALS = new Atomic<PopulationState>( 
		
			new Predicate<PopulationState>() {
				
				public boolean sat( PopulationState t) {						
					return _STATE_Y1 == t.getStateAt(0);					
				}			
					
			}
			
		);
		public static Atomic<PopulationState> _STATE_Y2_OF_INDIVIDUALS = new Atomic<PopulationState>( 
		
			new Predicate<PopulationState>() {
				
				public boolean sat( PopulationState t) {						
					return _STATE_Y2 == t.getStateAt(0);					
				}			
					
			}
			
		);
		public static Atomic<PopulationState> _STATE_Y3_OF_INDIVIDUALS = new Atomic<PopulationState>( 
		
			new Predicate<PopulationState>() {
				
				public boolean sat( PopulationState t) {						
					return _STATE_Y3 == t.getStateAt(0);					
				}			
					
			}
			
		);
		public static Atomic<PopulationState> _STATE_Y4_OF_INDIVIDUALS = new Atomic<PopulationState>( 
		
			new Predicate<PopulationState>() {
				
				public boolean sat( PopulationState t) {						
					return _STATE_Y4 == t.getStateAt(0);					
				}			
					
			}
			
		);
		public static Atomic<PopulationState> _STATE_Y5_OF_INDIVIDUALS = new Atomic<PopulationState>( 
		
			new Predicate<PopulationState>() {
				
				public boolean sat( PopulationState t) {						
					return _STATE_Y5 == t.getStateAt(0);					
				}			
					
			}
			
		);
		public static Atomic<PopulationState> _STATE_Y6_OF_INDIVIDUALS = new Atomic<PopulationState>( 
		
			new Predicate<PopulationState>() {
				
				public boolean sat( PopulationState t) {						
					return _STATE_Y6 == t.getStateAt(0);					
				}			
					
			}
			
		);
		public static Atomic<PopulationState> _STATE_Y7_OF_INDIVIDUALS = new Atomic<PopulationState>( 
		
			new Predicate<PopulationState>() {
				
				public boolean sat( PopulationState t) {						
					return _STATE_Y7 == t.getStateAt(0);					
				}			
					
			}
			
		);
		public static Atomic<PopulationState> _STATE_Y8_OF_INDIVIDUALS = new Atomic<PopulationState>( 
		
			new Predicate<PopulationState>() {
				
				public boolean sat( PopulationState t) {						
					return _STATE_Y8 == t.getStateAt(0);					
				}			
					
			}
			
		);
		public static Atomic<PopulationState> _STATE_Y9_OF_INDIVIDUALS = new Atomic<PopulationState>( 
		
			new Predicate<PopulationState>() {
				
				public boolean sat( PopulationState t) {						
					return _STATE_Y9 == t.getStateAt(0);					
				}			
					
			}
			
		);
		public static Atomic<PopulationState> _STATE_Y10_OF_INDIVIDUALS = new Atomic<PopulationState>( 
		
			new Predicate<PopulationState>() {
				
				public boolean sat( PopulationState t) {						
					return _STATE_Y10 == t.getStateAt(0);					
				}			
					
			}
			
		);

		public static Atomic<FastSimulationState> _STATE_Y0_OF_FASTSIMULATION = new Atomic<FastSimulationState>( 
		
			new Predicate<FastSimulationState>() {
				
				public boolean sat( FastSimulationState t) {						
					return _STATE_Y0 == t.getState();					
				}			
					
			}
			
		);
		public static Atomic<FastSimulationState> _STATE_Y1_OF_FASTSIMULATION = new Atomic<FastSimulationState>( 
		
			new Predicate<FastSimulationState>() {
				
				public boolean sat( FastSimulationState t) {						
					return _STATE_Y1 == t.getState();					
				}			
					
			}
			
		);
		public static Atomic<FastSimulationState> _STATE_Y2_OF_FASTSIMULATION = new Atomic<FastSimulationState>( 
		
			new Predicate<FastSimulationState>() {
				
				public boolean sat( FastSimulationState t) {						
					return _STATE_Y2 == t.getState();					
				}			
					
			}
			
		);
		public static Atomic<FastSimulationState> _STATE_Y3_OF_FASTSIMULATION = new Atomic<FastSimulationState>( 
		
			new Predicate<FastSimulationState>() {
				
				public boolean sat( FastSimulationState t) {						
					return _STATE_Y3 == t.getState();					
				}			
					
			}
			
		);
		public static Atomic<FastSimulationState> _STATE_Y4_OF_FASTSIMULATION = new Atomic<FastSimulationState>( 
		
			new Predicate<FastSimulationState>() {
				
				public boolean sat( FastSimulationState t) {						
					return _STATE_Y4 == t.getState();					
				}			
					
			}
			
		);
		public static Atomic<FastSimulationState> _STATE_Y5_OF_FASTSIMULATION = new Atomic<FastSimulationState>( 
		
			new Predicate<FastSimulationState>() {
				
				public boolean sat( FastSimulationState t) {						
					return _STATE_Y5 == t.getState();					
				}			
					
			}
			
		);
		public static Atomic<FastSimulationState> _STATE_Y6_OF_FASTSIMULATION = new Atomic<FastSimulationState>( 
		
			new Predicate<FastSimulationState>() {
				
				public boolean sat( FastSimulationState t) {						
					return _STATE_Y6 == t.getState();					
				}			
					
			}
			
		);
		public static Atomic<FastSimulationState> _STATE_Y7_OF_FASTSIMULATION = new Atomic<FastSimulationState>( 
		
			new Predicate<FastSimulationState>() {
				
				public boolean sat( FastSimulationState t) {						
					return _STATE_Y7 == t.getState();					
				}			
					
			}
			
		);
		public static Atomic<FastSimulationState> _STATE_Y8_OF_FASTSIMULATION = new Atomic<FastSimulationState>( 
		
			new Predicate<FastSimulationState>() {
				
				public boolean sat( FastSimulationState t) {						
					return _STATE_Y8 == t.getState();					
				}			
					
			}
			
		);
		public static Atomic<FastSimulationState> _STATE_Y9_OF_FASTSIMULATION = new Atomic<FastSimulationState>( 
		
			new Predicate<FastSimulationState>() {
				
				public boolean sat( FastSimulationState t) {						
					return _STATE_Y9 == t.getState();					
				}			
					
			}
			
		);
		public static Atomic<FastSimulationState> _STATE_Y10_OF_FASTSIMULATION = new Atomic<FastSimulationState>( 
		
			new Predicate<FastSimulationState>() {
				
				public boolean sat( FastSimulationState t) {						
					return _STATE_Y10 == t.getState();					
				}			
					
			}
			
		);

		
		public static StateFormula<PopulationState> _STATE_FORMULA_isFull_OF_INDIVIDUALS() {
			 return _STATE_Y10_OF_INDIVIDUALS;
		}
		
		public static StateFormula<FastSimulationState> _STATE_FORMULA_isFull_OF_FASTSIMULATION() {
			return _STATE_Y10_OF_FASTSIMULATION;
		}
		public static StateFormula<PopulationState> _STATE_FORMULA_isEmpty_OF_INDIVIDUALS() {
			 return _STATE_Y0_OF_INDIVIDUALS;
		}
		
		public static StateFormula<FastSimulationState> _STATE_FORMULA_isEmpty_OF_FASTSIMULATION() {
			return _STATE_Y0_OF_FASTSIMULATION;
		}
		public static StateFormula<PopulationState> _STATE_FORMULA_isY1_OF_INDIVIDUALS() {
			 return _STATE_Y1_OF_INDIVIDUALS;
		}
		
		public static StateFormula<FastSimulationState> _STATE_FORMULA_isY1_OF_FASTSIMULATION() {
			return _STATE_Y1_OF_FASTSIMULATION;
		}
		public static StateFormula<PopulationState> _STATE_FORMULA_isY2_OF_INDIVIDUALS() {
			 return _STATE_Y2_OF_INDIVIDUALS;
		}
		
		public static StateFormula<FastSimulationState> _STATE_FORMULA_isY2_OF_FASTSIMULATION() {
			return _STATE_Y2_OF_FASTSIMULATION;
		}
		public static StateFormula<PopulationState> _STATE_FORMULA_isY5_OF_INDIVIDUALS() {
			 return _STATE_Y5_OF_INDIVIDUALS;
		}
		
		public static StateFormula<FastSimulationState> _STATE_FORMULA_isY5_OF_FASTSIMULATION() {
			return _STATE_Y5_OF_FASTSIMULATION;
		}
		public static StateFormula<PopulationState> _STATE_FORMULA_isY4_OF_INDIVIDUALS() {
			 return _STATE_Y4_OF_INDIVIDUALS;
		}
		
		public static StateFormula<FastSimulationState> _STATE_FORMULA_isY4_OF_FASTSIMULATION() {
			return _STATE_Y4_OF_FASTSIMULATION;
		}
		public static StateFormula<PopulationState> _STATE_FORMULA_othersAlmostFree_OF_INDIVIDUALS() {
			 return new Atomic<PopulationState>( 
			 
			 	new Predicate<PopulationState>() {
			 		
			 		public boolean sat( PopulationState state ) {
			 			return ((state.getOccupancy( _STATE_Y10 ))+((state.getOccupancy( _STATE_Y9 ))+((state.getOccupancy( _STATE_Y8 ))+((state.getOccupancy( _STATE_Y7 ))+(state.getOccupancy( _STATE_Y5 ))))))<(0.5);			
			 		}			
			 			
			 	}
			 	
			 )
			 ;
		}
		
		public static StateFormula<FastSimulationState> _STATE_FORMULA_othersAlmostFree_OF_FASTSIMULATION() {
			return new Atomic<FastSimulationState>( 
			
				new Predicate<FastSimulationState>() {
					
					public boolean sat( FastSimulationState state ) {
						return ((state.getOccupancy( _STATE_Y10 ))+((state.getOccupancy( _STATE_Y9 ))+((state.getOccupancy( _STATE_Y8 ))+((state.getOccupancy( _STATE_Y7 ))+(state.getOccupancy( _STATE_Y5 ))))))<(0.5);			
					}			
						
				}
				
			)
			;
		}
		public static StateFormula<PopulationState> _STATE_FORMULA_othersFree_OF_INDIVIDUALS() {
			 return new Atomic<PopulationState>( 
			 
			 	new Predicate<PopulationState>() {
			 		
			 		public boolean sat( PopulationState state ) {
			 			return ((state.getOccupancy( _STATE_Y0 ))+((state.getOccupancy( _STATE_Y1 ))+(state.getOccupancy( _STATE_Y2 ))))>(0.25);			
			 		}			
			 			
			 	}
			 	
			 )
			 ;
		}
		
		public static StateFormula<FastSimulationState> _STATE_FORMULA_othersFree_OF_FASTSIMULATION() {
			return new Atomic<FastSimulationState>( 
			
				new Predicate<FastSimulationState>() {
					
					public boolean sat( FastSimulationState state ) {
						return ((state.getOccupancy( _STATE_Y0 ))+((state.getOccupancy( _STATE_Y1 ))+(state.getOccupancy( _STATE_Y2 ))))>(0.25);			
					}			
						
				}
				
			)
			;
		}
		public static StateFormula<PopulationState> _STATE_FORMULA_fullForAWhile_OF_INDIVIDUALS() {
			 return new PCheck<PopulationState>( Relation.LESS , 0.1 , new Until<PopulationState>( new True<PopulationState>() , 1 , new Not<PopulationState>(_STATE_Y10_OF_INDIVIDUALS) ) );
		}
		
		public static StateFormula<FastSimulationState> _STATE_FORMULA_fullForAWhile_OF_FASTSIMULATION() {
			return new PCheck<FastSimulationState>( Relation.LESS , 0.1 , new Until<FastSimulationState>( new True<FastSimulationState>() , 1 , new Not<FastSimulationState>(_STATE_Y10_OF_FASTSIMULATION) ) );
		}
		public static StateFormula<PopulationState> _STATE_FORMULA_isFullAndSoRemains_OF_INDIVIDUALS() {
			 return new And<PopulationState>( _STATE_FORMULA_isFull_OF_INDIVIDUALS() , _STATE_FORMULA_fullForAWhile_OF_INDIVIDUALS() );
		}
		
		public static StateFormula<FastSimulationState> _STATE_FORMULA_isFullAndSoRemains_OF_FASTSIMULATION() {
			return new And<FastSimulationState>( _STATE_FORMULA_isFull_OF_FASTSIMULATION() , _STATE_FORMULA_fullForAWhile_OF_FASTSIMULATION() );
		}
		public static StateFormula<PopulationState> _STATE_FORMULA_isTrue_OF_INDIVIDUALS() {
			 return new True<PopulationState>();
		}
		
		public static StateFormula<FastSimulationState> _STATE_FORMULA_isTrue_OF_FASTSIMULATION() {
			return new True<FastSimulationState>();
		}
		
		protected void initStateFormulaeTables() {
			stateFormulae = new String[] {
				"isFull",
				"isEmpty",
				"isY1",
				"isY2",
				"isY5",
				"isY4",
				"othersAlmostFree",
				"othersFree",
				"fullForAWhile",
				"isFullAndSoRemains",
				"isTrue"
			};
			stateFormulaeForIndividuals.put("isFull",_STATE_FORMULA_isFull_OF_INDIVIDUALS());
			stateFormulaeForFastSimulation.put("isFull",_STATE_FORMULA_isFull_OF_FASTSIMULATION());
			stateFormulaeForIndividuals.put("isEmpty",_STATE_FORMULA_isEmpty_OF_INDIVIDUALS());
			stateFormulaeForFastSimulation.put("isEmpty",_STATE_FORMULA_isEmpty_OF_FASTSIMULATION());
			stateFormulaeForIndividuals.put("isY1",_STATE_FORMULA_isY1_OF_INDIVIDUALS());
			stateFormulaeForFastSimulation.put("isY1",_STATE_FORMULA_isY1_OF_FASTSIMULATION());
			stateFormulaeForIndividuals.put("isY2",_STATE_FORMULA_isY2_OF_INDIVIDUALS());
			stateFormulaeForFastSimulation.put("isY2",_STATE_FORMULA_isY2_OF_FASTSIMULATION());
			stateFormulaeForIndividuals.put("isY5",_STATE_FORMULA_isY5_OF_INDIVIDUALS());
			stateFormulaeForFastSimulation.put("isY5",_STATE_FORMULA_isY5_OF_FASTSIMULATION());
			stateFormulaeForIndividuals.put("isY4",_STATE_FORMULA_isY4_OF_INDIVIDUALS());
			stateFormulaeForFastSimulation.put("isY4",_STATE_FORMULA_isY4_OF_FASTSIMULATION());
			stateFormulaeForIndividuals.put("othersAlmostFree",_STATE_FORMULA_othersAlmostFree_OF_INDIVIDUALS());
			stateFormulaeForFastSimulation.put("othersAlmostFree",_STATE_FORMULA_othersAlmostFree_OF_FASTSIMULATION());
			stateFormulaeForIndividuals.put("othersFree",_STATE_FORMULA_othersFree_OF_INDIVIDUALS());
			stateFormulaeForFastSimulation.put("othersFree",_STATE_FORMULA_othersFree_OF_FASTSIMULATION());
			stateFormulaeForIndividuals.put("fullForAWhile",_STATE_FORMULA_fullForAWhile_OF_INDIVIDUALS());
			stateFormulaeForFastSimulation.put("fullForAWhile",_STATE_FORMULA_fullForAWhile_OF_FASTSIMULATION());
			stateFormulaeForIndividuals.put("isFullAndSoRemains",_STATE_FORMULA_isFullAndSoRemains_OF_INDIVIDUALS());
			stateFormulaeForFastSimulation.put("isFullAndSoRemains",_STATE_FORMULA_isFullAndSoRemains_OF_FASTSIMULATION());
			stateFormulaeForIndividuals.put("isTrue",_STATE_FORMULA_isTrue_OF_INDIVIDUALS());
			stateFormulaeForFastSimulation.put("isTrue",_STATE_FORMULA_isTrue_OF_FASTSIMULATION());
		}

		public static PathFormula<PopulationState> _PATH_FORMULA_eventuallyFull_OF_INDIVIDUALS() {
			return new Until<PopulationState>( new True<PopulationState>() , 10 , _STATE_Y10_OF_INDIVIDUALS );
		}
		
		public static PathFormula<FastSimulationState> _PATH_FORMULA_eventuallyFull_OF_FASTSIMULATION() {
			return new Until<FastSimulationState>( new True<FastSimulationState>() , 10 , _STATE_Y10_OF_FASTSIMULATION );
		}
		public static PathFormula<PopulationState> _PATH_FORMULA_eventuallyAlmostFull_OF_INDIVIDUALS() {
			return new Until<PopulationState>( new True<PopulationState>() , 1000 , new Or<PopulationState>( _STATE_Y9_OF_INDIVIDUALS , _STATE_Y10_OF_INDIVIDUALS ) );
		}
		
		public static PathFormula<FastSimulationState> _PATH_FORMULA_eventuallyAlmostFull_OF_FASTSIMULATION() {
			return new Until<FastSimulationState>( new True<FastSimulationState>() , 1000 , new Or<FastSimulationState>( _STATE_Y9_OF_FASTSIMULATION , _STATE_Y10_OF_FASTSIMULATION ) );
		}
		public static PathFormula<PopulationState> _PATH_FORMULA_eventuallyQuiteFull_OF_INDIVIDUALS() {
			return new Until<PopulationState>( new True<PopulationState>() , 1000 , new Or<PopulationState>( _STATE_Y8_OF_INDIVIDUALS , new Or<PopulationState>( _STATE_Y9_OF_INDIVIDUALS , _STATE_Y10_OF_INDIVIDUALS ) ) );
		}
		
		public static PathFormula<FastSimulationState> _PATH_FORMULA_eventuallyQuiteFull_OF_FASTSIMULATION() {
			return new Until<FastSimulationState>( new True<FastSimulationState>() , 1000 , new Or<FastSimulationState>( _STATE_Y8_OF_FASTSIMULATION , new Or<FastSimulationState>( _STATE_Y9_OF_FASTSIMULATION , _STATE_Y10_OF_FASTSIMULATION ) ) );
		}
		
		protected void initPathFormulaeTables() {
			pathFormulae = new String[] {
				"eventuallyFull",
				"eventuallyAlmostFull",
				"eventuallyQuiteFull"
			};
			pathFormulaeForIndividuals.put("eventuallyFull",_PATH_FORMULA_eventuallyFull_OF_INDIVIDUALS());
			pathFormulaeForFastSimulation.put("eventuallyFull",_PATH_FORMULA_eventuallyFull_OF_FASTSIMULATION());
			pathFormulaeForIndividuals.put("eventuallyAlmostFull",_PATH_FORMULA_eventuallyAlmostFull_OF_INDIVIDUALS());
			pathFormulaeForFastSimulation.put("eventuallyAlmostFull",_PATH_FORMULA_eventuallyAlmostFull_OF_FASTSIMULATION());
			pathFormulaeForIndividuals.put("eventuallyQuiteFull",_PATH_FORMULA_eventuallyQuiteFull_OF_INDIVIDUALS());
			pathFormulaeForFastSimulation.put("eventuallyQuiteFull",_PATH_FORMULA_eventuallyQuiteFull_OF_FASTSIMULATION());
		}
		
		protected void initConfigurations() {			
			configurations = new String[] {
				"main",
				"main7"
			};
			PopulationState state;
			state = module.getState( 
				new int[] { _STATE_Y0 , (int) 10 }
			);
			configurationsForIndividuals.put("main",state);		
			configurationsForFastSimulation.put("main",state.project(0));	
			state = module.getState( 
				new int[] { _STATE_Y7 , 1 },
				new int[] { _STATE_Y0 , (int) 10 }
			);
			configurationsForIndividuals.put("main7",state);		
			configurationsForFastSimulation.put("main7",state.project(0));	
		}
		
		
	public Bikes2Per() {
		initStateNameVector();	
		initPopulationModule();
		initConfigurations();
		initStateFormulaeTables();
		initPathFormulaeTables();
	}

	public static void main( String[] argv ) {
		Bikes2Per bikes = new Bikes2Per();
		simulate(bikes , bikes.getFastSimulationConfiguration("main"), 10000000);
//		doModelCheck(bikes.getFastSimulationConfiguration("main"), new True<FastSimulationState>(), _STATE_FORMULA_isFull_OF_FASTSIMULATION() , 4100);
	}
	
	public static void simulate( Bikes2Per bikes , FastSimulationState current , int deadline ) {
		RandomGenerator r = new DefaultRandomGenerator();
		long startTime = System.currentTimeMillis();
		ProbabilisticSimulator<FastSimulationState> simulator = 
				new ProbabilisticSimulator<FastSimulationState>(
						r, 
						bikes.module.getMeanFieldStochasticProcess() ,
						current ,
						bikes.getMeasuresOfFastState() ,
						deadline , 1);
		simulator.doARun(new SimulationController() {
			
			@Override
			public void startSimulationRun(int iteration) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void simulationStepDone() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isCanceled() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void endSimulationRun(int iteration) {
				// TODO Auto-generated method stub
				
			}
		});
		long time = (System.currentTimeMillis()-startTime);
		System.out.println("Simulation time: "+time);
		System.out.println("Average time-step simulation: "+(((double) time)/deadline));
	}
	
	public static void doModelCheck( FastSimulationState state , StateFormula<FastSimulationState> left , StateFormula<FastSimulationState> right , int deadline ) {
		OnTheFlyProbabilisticModelChecker<FastSimulationState> opm = new OnTheFlyProbabilisticModelChecker<FastSimulationState>();
		double prob = opm.getProbability( state , new Until<FastSimulationState>( new True<FastSimulationState>() , 10000 , _STATE_Y10_OF_FASTSIMULATION ));
		System.out.println("Prob: "+prob);
//		double[] probs = opm.getProbabilities(state, left, deadline, 1, right);
//		for( int i=0 ; i<probs.length ; i++ ) {
//			System.out.println(i+":"+probs[i]);			
//		}
	}

	
}