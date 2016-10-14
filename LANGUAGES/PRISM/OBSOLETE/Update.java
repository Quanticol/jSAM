package org.cmg.ml.sam.prism.obsolete;

public abstract class Update {

	public abstract void set(int id, int value);

	public final PrismState apply(PrismState s) {
		PrismState nextState = s.copy();
		return doUpdate( nextState );
	}

	protected abstract PrismState doUpdate(PrismState nextState);
	
	

}