package org.cmg.ml.aqua.klaim.core.test;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Random;

import org.cmg.ml.sam.klaim.core.ActualField;
import org.cmg.ml.sam.klaim.core.FormalField;
import org.cmg.ml.sam.klaim.core.KBoolean;
import org.cmg.ml.sam.klaim.core.KDouble;
import org.cmg.ml.sam.klaim.core.KInteger;
import org.cmg.ml.sam.klaim.core.KType;
import org.cmg.ml.sam.klaim.core.KValue;
import org.cmg.ml.sam.klaim.core.Pair;
import org.cmg.ml.sam.klaim.core.Template;
import org.cmg.ml.sam.klaim.core.Tuple;
import org.cmg.ml.sam.klaim.core.TupleNotFoundException;
import org.cmg.ml.sam.klaim.core.TupleSpace;
import org.junit.Test;


public class TestTupleSpace {
	
	private static final int MAX_INT_TEST = 3;
	private static final int NUMBER_OF_ADDS = 10000;
	private static final int NUMBER_OF_GETS = 1000000;
	private static final int MAX_TUPLE_LENGTH = 3;
	private Random r = new Random(100234);

	@Test
	public void testCreateEmptyTupleSpace() {
		TupleSpace ts = new TupleSpace();
		assertEquals(0, ts.getSize());
	}
	
	@Test
	public void testAddGetTuple() {
		TupleSpace ts = new TupleSpace();
		ts = ts.addTuple( new KInteger(0) , new KInteger(1) );
		ts = ts.addTuple( new KInteger(1) , new KInteger(1) );
		ts = ts.addTuple( new KInteger(2) , new KInteger(1) );
		assertEquals(3, ts.getSize());
		assertEquals(1,ts.getTuples(new ActualField(new KInteger(0)),new ActualField(new KInteger(1))).size());
		assertEquals(1,ts.getTuples(new ActualField(new KInteger(1)),new ActualField(new KInteger(1))).size());
		assertEquals(1,ts.getTuples(new ActualField(new KInteger(2)),new ActualField(new KInteger(1))).size());
		assertEquals(1,ts.getTuples(new ActualField(new KInteger(0)),new FormalField(KType.integerType)).size());
		assertEquals(0,ts.getTuples(new ActualField(new KInteger(1))).size());
	}

	@Test(expected=TupleNotFoundException.class)
	public void testRetrieveTuple() {
		TupleSpace ts = new TupleSpace();
		ts = ts.getTuple( new KInteger(0) );
		assertEquals(1, ts.getSize());
	}

	@Test
	public void testReplicatedAddAndRemove() {
		int size = 0;
		int failures = 0;
		TupleSpace ts = new TupleSpace();
		for (int i=0 ; i<NUMBER_OF_ADDS ; i++ ) {
			ts = ts.addTuple(getTuple());
			size++;
			assertEquals(size, ts.getSize());
		}
		for (int i=0 ; i<NUMBER_OF_GETS ; i++ ) {
			try {
				ts = ts.getTuple(getTuple());
				size--;
				assertEquals("Get "+i+":",size, ts.getSize());
			} catch (TupleNotFoundException e) {				
				failures++;
			}
		}
		System.out.println("Unsuccessfull seaches: "+failures);
		System.out.println("Unsuccessfull rates: "+((double) failures)/NUMBER_OF_GETS);
		System.out.println("Final size: "+size);
	}
	
	@Test
	public void testAddAndRetrieve() {
		TupleSpace ts = new TupleSpace();
		for (int i=0 ; i<10 ;i++) {
			for (int j=0 ; j<10 ; j++ ) {
				ts = ts.addTuple(getTuple(i,j));
			}
		}
		assertEquals(100, ts.getSize());
		LinkedList<Pair<Tuple, Integer>> list = ts.getTuples( new Template( new FormalField(KType.integerType) , new FormalField(KType.integerType) ));	
		assertEquals(100,list.size());
		for (Pair<Tuple, Integer> pair : list) {
			System.out.println(pair.getFirst()+" "+pair.getSecond());
		}
		list = ts.getTuples( new Template( new ActualField(new KInteger(5)) , new FormalField(KType.integerType) ));	
		assertEquals(10,list.size());
		for (Pair<Tuple, Integer> pair : list) {
			System.out.println(pair.getFirst()+" "+pair.getSecond());
		}
	}

	protected Tuple getTuple( ) {
		int size = r.nextInt(MAX_TUPLE_LENGTH)+1;
		KValue[] array = new KValue[size];
		for( int i=0 ; i<size ; i++ ) {
			array[i] = getValue();
		}
		return new Tuple(array);
	}
	
	protected Tuple getTuple( int ... values) {
		KValue[] kv = new KValue[values.length];
		for (int i=0 ; i<values.length ; i++ ) {
			kv[i] = new KInteger(values[i]);
		}
		return new Tuple(kv);
	}
	
	protected KValue getValue() {
		int v = r.nextInt(2);
		switch (v) {
		case 0:
			return new KBoolean(r.nextBoolean());
		case 1:
			return new KInteger(r.nextInt(MAX_INT_TEST));
		default:
			return new KDouble(r.nextDouble());
		}
	}
	
}
