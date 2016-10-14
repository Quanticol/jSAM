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

public class LV extends PopulationSpecification  {

public static int _STATE_RD = 0;
public static int _STATE_RL = 1;
public static int _STATE_FD = 2;
public static int _STATE_FL = 3;

protected void initStateNameVector() {
	this.states = new String[4];
	states[_STATE_RD] = "RD";
	states[_STATE_RL] = "RL";
	states[_STATE_FD] = "FD";
	states[_STATE_FL] = "FL";
}


public static double _CONST_alphaa = 0.04;
public static double _CONST_alphab = 0.5;
public static double _CONST_alphae = 0.2;
public static double _CONST_alphac = 0.05;

public static ProbabilityFunction _ACT_rborn_PROBABILITY_ = new ProbabilityFunction() {

	//@Override 
	public double eval(double[] occupancy) {
		return (_CONST_alphaa)*((occupancy[ _STATE_RL ])/(occupancy[ _STATE_RD ]));
	}
	
};
public static ProbabilityFunction _ACT_rdies_PROBABILITY_ = new ProbabilityFunction() {

	//@Override 
	public double eval(double[] occupancy) {
		return (_CONST_alphab)*(occupancy[ _STATE_FL ]);
	}
	
};
public static ProbabilityFunction _ACT_fborn_PROBABILITY_ = new ProbabilityFunction() {

	//@Override 
	public double eval(double[] occupancy) {
		return (_CONST_alphae)*((occupancy[ _STATE_RL ])*((occupancy[ _STATE_FL ])/(occupancy[ _STATE_FD ])));
	}
	
};
public static ProbabilityFunction _ACT_fdies_PROBABILITY_ = new ProbabilityFunction() {

	//@Override 
	public double eval(double[] occupancy) {
		return _CONST_alphac;
	}
	
};


public static LocalState _RULE_RD =  new LocalState( 
	_STATE_RD ,  
	new LocalState.RuleElement( _ACT_rborn_PROBABILITY_ , _STATE_RL ) 
);
public static LocalState _RULE_RL =  new LocalState( 
	_STATE_RL ,  
	new LocalState.RuleElement( _ACT_rdies_PROBABILITY_ , _STATE_RD ) 
);
public static LocalState _RULE_FD =  new LocalState( 
	_STATE_FD ,  
	new LocalState.RuleElement( _ACT_fborn_PROBABILITY_ , _STATE_FL ) 
);
public static LocalState _RULE_FL =  new LocalState( 
	_STATE_FL ,  
	new LocalState.RuleElement( _ACT_fdies_PROBABILITY_ , _STATE_FD ) 
);
		

protected void initPopulationModule() {		
 	this.module = new PopulationModule( 
		4 , 
		_RULE_RD,
		_RULE_RL,
		_RULE_FD,
		_RULE_FL
	);		
}

public static Atomic<PopulationState> _STATE_RD_OF_INDIVIDUALS = new Atomic<PopulationState>( 

	new Predicate<PopulationState>() {
		
		public boolean sat( PopulationState t) {						
			return _STATE_RD == t.getStateAt(0);					
		}			
			
	}
	
);
public static Atomic<PopulationState> _STATE_RL_OF_INDIVIDUALS = new Atomic<PopulationState>( 

	new Predicate<PopulationState>() {
		
		public boolean sat( PopulationState t) {						
			return _STATE_RL == t.getStateAt(0);					
		}			
			
	}
	
);
public static Atomic<PopulationState> _STATE_FD_OF_INDIVIDUALS = new Atomic<PopulationState>( 

	new Predicate<PopulationState>() {
		
		public boolean sat( PopulationState t) {						
			return _STATE_FD == t.getStateAt(0);					
		}			
			
	}
	
);
public static Atomic<PopulationState> _STATE_FL_OF_INDIVIDUALS = new Atomic<PopulationState>( 

	new Predicate<PopulationState>() {
		
		public boolean sat( PopulationState t) {						
			return _STATE_FL == t.getStateAt(0);					
		}			
			
	}
	
);

public static Atomic<FastSimulationState> _STATE_RD_OF_FASTSIMULATION = new Atomic<FastSimulationState>( 

	new Predicate<FastSimulationState>() {
		
		public boolean sat( FastSimulationState t) {						
			return _STATE_RD == t.getState();					
		}			
			
	}
	
);
public static Atomic<FastSimulationState> _STATE_RL_OF_FASTSIMULATION = new Atomic<FastSimulationState>( 

	new Predicate<FastSimulationState>() {
		
		public boolean sat( FastSimulationState t) {						
			return _STATE_RL == t.getState();					
		}			
			
	}
	
);
public static Atomic<FastSimulationState> _STATE_FD_OF_FASTSIMULATION = new Atomic<FastSimulationState>( 

	new Predicate<FastSimulationState>() {
		
		public boolean sat( FastSimulationState t) {						
			return _STATE_FD == t.getState();					
		}			
			
	}
	
);
public static Atomic<FastSimulationState> _STATE_FL_OF_FASTSIMULATION = new Atomic<FastSimulationState>( 

	new Predicate<FastSimulationState>() {
		
		public boolean sat( FastSimulationState t) {						
			return _STATE_FL == t.getState();					
		}			
			
	}
	
);



protected void initStateFormulaeTables() {
	stateFormulae = new String[] {
	};
}


protected void initPathFormulaeTables() {
	pathFormulae = new String[] {
	};
}

protected void initConfigurations() {			
	configurations = new String[] {
		"main"
	};
	PopulationState state;
	state = module.getState( 
		new int[] { _STATE_RD , (int) 5 },
		new int[] { _STATE_RL , (int) 1 },
		new int[] { _STATE_FD , (int) 3 },
		new int[] { _STATE_FL , (int) 1 }
	);
	configurationsForIndividuals.put("main",state);		
	configurationsForFastSimulation.put("main",state.project(0));	
}


public LV() {
	initStateNameVector();	
	initPopulationModule();
	initConfigurations();
	initStateFormulaeTables();
	initPathFormulaeTables();
}

public static void main( String[] argv ) {
	LV lv = new LV();
	simulate(lv , lv.getFastSimulationConfiguration("main"), 10000000);
//	doModelCheck(bikes.getFastSimulationConfiguration("main"), new True<FastSimulationState>(), _STATE_FORMULA_isFull_OF_FASTSIMULATION() , 4100);
}

public static void simulate( LV bikes , FastSimulationState current , int deadline ) {
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
	double[] probs = opm.getProbabilities(state, left, deadline, 1, right);
	for( int i=0 ; i<probs.length ; i++ ) {
		System.out.println(i+":"+probs[i]);			
	}
}

}