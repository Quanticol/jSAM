package org.cmg.ml.sam.klaim.sim;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.cmg.ml.sam.core.sim.Measure;
import org.cmg.ml.sam.klaim.core.Net;
/**
 * 
 */
import org.cmg.ml.sam.klaim.core.NetTransition;

/**
 * @author loreti
 *
 */
public class KlaimSimulator {

	protected Random r = new Random();
	protected Net startNet;
	protected Map<String, Measure<Net>> measures;
	
	public KlaimSimulator(Net startNet, Map<String, Measure<Net>> measures) {
		this.startNet = startNet;
		this.measures = measures;
	}
	
	public Map<Double,HashMap<String,Double>> simulate( int iterations , double dt , double deadline ) {
		HashMap<Double, HashMap<String,Double>> data = new HashMap<Double, HashMap<String,Double>>();
		for( int i=0 ; i<iterations ; i++ ) {
			_simulate(data,dt,deadline);
		}
		computeAverage(iterations,data);
		return data;
	}

	private void computeAverage(int iterations,
			HashMap<Double, HashMap<String, Double>> data) {
		for (HashMap<String,Double> sample : data.values()) {
			for (String name : sample.keySet()) {
				Double v = sample.get(name);
				sample.put(name, v/iterations);
			}
		}
	}

	private void _simulate(HashMap<Double, HashMap<String, Double>> data,
			double dt, double deadline) {
		Net current = startNet.copy();
		double time = 0.0;
		double samplingTime = 0.0;

		collectData(0.0,current,data);
		while (time < deadline) {			
			NetTransition nt = current.getNext();
			double p1 = r.nextDouble();
			double p2 = r.nextDouble();
			Net next = nt.select(p1);
			double tw = nt.getTotalWeight();
			if (tw != 0) {
				double step = (1/nt.getTotalWeight())*Math.log(1/p2); 
				time = time + step;
				samplingTime = doSampling(dt,samplingTime,time,current,next,data);
			} else {
				fill(samplingTime,dt,deadline,current,data);
				time = deadline;
			}
			current = next;
		}
	}

	private void fill(double samplingTime, double dt, double deadline, Net current,
			HashMap<Double, HashMap<String, Double>> data) {
		double time = samplingTime + dt;
		while (time < deadline) {
			collectData(time,current,data);
			time = time+dt;
		}
	}

	private double doSampling(double dt , double samplingTime, double time, Net current,
			Net next, HashMap<Double, HashMap<String, Double>> data) {
		double lastSampling = samplingTime;
		while( lastSampling+dt < time) {
			lastSampling += dt;
			collectData(lastSampling,current,data);
		}
		return lastSampling;
	}

	private void collectData(double time, Net n,
			HashMap<Double, HashMap<String, Double>> data) {
		HashMap<String, Double> sampling = data.get(time);
		if (sampling == null) {
			sampling = new HashMap<String, Double>();
			data.put(time, sampling);
		}
		for (Measure<Net> m : measures.values()) {
			addData(sampling,m.getName(),m.measure(n));
		}
	}

	private void addData(HashMap<String, Double> data,
			String name, double measure) {
		Double v = data.get(name);
		if (v == null) {
			v = 0.0;
		}
		data.put(name, v+measure);
	}
	
}
