/**
 * 
 */
package org.cmg.ml.sam.klaim.core;

import java.util.ArrayList;

import org.cmg.ml.sam.core.Operator;
import org.cmg.ml.sam.core.Probability;

/**
 * @author loreti
 *
 */
public class ProcessInputAction {
	
	protected Template template;
	protected int locality;
	protected Abstraction abstraction;
	protected double rate;
	protected Operator<KProcess, ArrayList<KProcess>> proc;
	
	public ProcessInputAction( Template template , int locality , Abstraction abstraction ) {
		this.template = template;
		this.locality = locality;
		this.abstraction = abstraction;
	}
	
	public Probability<Net> execute( Net n ) {
		return null;
	}

}
