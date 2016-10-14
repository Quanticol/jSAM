package org.cmg.ml.sam.prism.obsolete;

import org.cmg.ml.sam.core.Distribution;
import org.cmg.ml.sam.core.Probability;

public interface Rule {

	public boolean isEnabled(PrismState s);

	public Distribution<PrismState> apply(PrismState s);

	public Probability<PrismState> apply( PrismState s , Probability<PrismState> next );

}