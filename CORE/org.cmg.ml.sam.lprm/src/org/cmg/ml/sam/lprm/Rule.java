package org.cmg.ml.sam.lprm;

import org.cmg.ml.sam.core.Probability;
import org.cmg.ml.sam.core.WeightedElement;

public interface Rule {

	public abstract boolean isEnabled(State s);

	public abstract Probability<State> apply(State s);

	public abstract Probability<State> apply(State s , WeightedElement<State> wState );

}