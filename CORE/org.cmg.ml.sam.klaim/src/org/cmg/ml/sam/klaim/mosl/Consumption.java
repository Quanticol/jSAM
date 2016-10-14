/**
 * 
 */
package org.cmg.ml.sam.klaim.mosl;

import java.util.LinkedList;

import org.cmg.ml.sam.core.logic.ProcessFunction;
import org.cmg.ml.sam.klaim.core.Net;
import org.cmg.ml.sam.klaim.core.Pair;
import org.cmg.ml.sam.klaim.core.Template;
import org.cmg.ml.sam.klaim.core.Tuple;

/**
 * @author loreti
 *
 */
public class Consumption implements ProcessFunction<Net> {

	private Template template;
	private int locality;
	
	public Consumption(Template template, int locality) {
		this.template = template;
		this.locality = locality;
	}
	
	
	@Override
	public LinkedList<Net> apply(Net n) {
		LinkedList<Net> toReturn = new LinkedList<Net>();
		LinkedList<Pair<Tuple, Integer>> tuples = n.getTuples(template, locality);
		for (Pair<Tuple, Integer> p : tuples) {
			toReturn.add(n.removeTuple(p.getFirst(), locality));
		}
		return toReturn;
	}

}
