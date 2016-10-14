package org.cmg.ml.sam.prism;

public class UpdateElement {
	
	int id ;
	
	int update;
	
	public UpdateElement( int id , int update ) {
		this.id = id ; 
		this.update = update;
	}

	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof UpdateElement) {
			UpdateElement foo = (UpdateElement) arg0;
			return (id==foo.id)&&(update==foo.update);
		}
		return super.equals(arg0);
	}

	@Override
	public int hashCode() {
		return id^update;
	}

	@Override
	public String toString() {
		return id+"<-"+update;
	}
	
	
}