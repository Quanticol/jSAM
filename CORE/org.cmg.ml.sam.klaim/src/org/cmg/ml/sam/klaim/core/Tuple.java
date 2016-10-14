/**
 * 
 */
package org.cmg.ml.sam.klaim.core;

import java.util.Arrays;

/**
 * @author loreti
 *
 */
public class Tuple implements Comparable<Tuple> {
	
	private KValue[] data;
	private Integer hash;
	
	
	public Tuple( KValue ... data ) {
		this.data = data;
	}
	
	public int length() {
		return data.length;
	}
	
	public KValue getValueAt( int i ) {
		return data[i];
	}
	
	public KType getTypeAt( int i ) {
		return data[i].getType();
	}
	
	public KBoolean getBooleanAt( int i ) {
		return (KBoolean) data[i];
	}

	public KInteger getIntegerAt( int i ) {
		return (KInteger) data[i];
	}

	public KDouble getDoubleAt( int i ) {
		return (KDouble) data[i];
	}
	
	public KLocality getLocalityAt( int i ) {
		return (KLocality) data[i];
	}

	public KString getStringAt( int i ) {
		return (KString) data[i];
	}

	public KProcess getProcessAt( int i ) {
		return (KProcess) data[i];
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Tuple) {
			return Arrays.equals(data, ((Tuple) obj).data);
		}
		return false;
	}

	@Override
	public int hashCode() {
		if (hash == null) {
			hash = Arrays.hashCode(data);
		}
		return hash;
	}

	@Override
	public String toString() {
		return Arrays.toString(data);
	}

	@Override
	public int compareTo(Tuple o) {
		int foo = this.length() - o.length();
		for (int i=0 ; (i<length())&&(foo==0) ; i++ ) {
			foo = data[i].compareTo(o.data[i]);
		}
		return foo;
	}

}
