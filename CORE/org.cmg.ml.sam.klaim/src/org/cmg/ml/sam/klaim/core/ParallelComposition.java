/**
 * 
 */
package org.cmg.ml.sam.klaim.core;

import java.util.LinkedList;

import org.cmg.ml.sam.core.Operator;

/**
 * @author loreti
 *
 */
public class ParallelComposition implements Operator<KProcess, LinkedList<KProcess>> {

	protected int idx;
	protected LinkedList<KProcess> par;

	public ParallelComposition(int idx , LinkedList<KProcess> par) {
		this.idx = idx;
		this.par = par;
	}
	
	@Override
	public LinkedList<KProcess> apply(KProcess p) {
		@SuppressWarnings("unchecked")
		LinkedList<KProcess> res = (LinkedList<KProcess>) par.clone();
		res.set(idx, p);
		return res;
	}

}
