package org.cmg.ml.sam.klaim.core;


public abstract class KProcess {

	protected int locality;	
	protected AllocationEnvironment ae;
	
	public KProcess( int locality , AllocationEnvironment e ) {
		this.locality = locality;
		this.ae = e;
	}
	
	public abstract ProcessTransition getNext();
	
	public abstract KProcess copy();
}
