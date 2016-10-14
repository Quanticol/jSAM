/**
 * 
 */
package org.cmg.ml.sam.klaim.mosl;

import java.util.LinkedList;

import org.cmg.ml.sam.core.logic.FMap;
import org.cmg.ml.sam.core.logic.ProcessFunction;
import org.cmg.ml.sam.core.logic.StateFormula;
import org.cmg.ml.sam.klaim.core.Net;
import org.cmg.ml.sam.klaim.core.Tuple;

/**
 * @author loreti
 *
 */
public class Production implements ProcessFunction<Net> {

	protected Tuple t;
	protected int locality;
	
	public Production(Tuple t , int locality ) {
		this.t = t;
		this.locality = locality;
	}
	
	@Override
	public LinkedList<Net> apply(Net n) {
		LinkedList<Net> toReturn = new LinkedList<Net>();
		Net copy = n.copy();
		copy.addTuple(t, locality);
		toReturn.add(copy);
		return toReturn;
	}

}
