package org.cmg.ml.sam.xtext.klaim.tests;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.cmg.ml.sam.xtext.klaim.klaim.KlaimFactory;
import org.cmg.ml.sam.xtext.klaim.klaim.NumberLiteral;
import org.cmg.ml.sam.xtext.klaim.klaim.Reference;
import org.cmg.ml.sam.xtext.klaim.klaim.SelfExpression;
import org.cmg.ml.sam.xtext.klaim.klaim.SummationSubtraction;
import org.cmg.ml.sam.xtext.klaim.klaim.Type;
import org.cmg.ml.sam.xtext.klaim.klaim.Variable;
import org.cmg.ml.sam.xtext.klaim.klaim.impl.KlaimFactoryImpl;
import org.cmg.ml.sam.xtext.klaim.validation.KlaimType;
import org.cmg.ml.sam.xtext.klaim.validation.TypeInference;
import org.junit.Test;

public class TypeInferenceTest {

	KlaimFactory factory = KlaimFactoryImpl.init();
	
	@Test
	public void testSelfExpressionTypeInference() {
		TypeInference ti = new TypeInference();
		SelfExpression self = factory.createSelfExpression();
		assertEquals(KlaimType.LOCALITY, ti.getType(self));
	}
	
//	@Test
//	public void booleanAssignment() {
//		TypeInference ti = new TypeInference();
//		KlaimType t1 = KlaimType.BOOLEAN;
//		for (Type t : Type.VALUES) {
//			KlaimType t = ti.getType(t);
//			assertEquals(t1+"<-"+t,t1==t, ti.areCompatible(t1, t));
//		}
//	}
//
//	@Test
//	public void integertAssignment() {
//		TypeInference ti = new TypeInference();
//		Type t1 = Type.KINT;
//		for (Type t : Type.VALUES) {
//			assertEquals(t1+"<-"+t,t1==t, ti.areCompatible(t1, t));
//		}
//	}
//
//	@Test
//	public void stringAssignment() {
//		TypeInference ti = new TypeInference();
//		Type t1 = Type.KSTRING;
//		for (Type t : Type.VALUES) {
//			assertEquals(t1+"<-"+t,t1==t, ti.areCompatible(t1, t));
//		}
//	}
//
//	@Test
//	public void localityAssignment() {
//		TypeInference ti = new TypeInference();
//		Type t1 = Type.KLOCALITY;
//		for (Type t : Type.VALUES) {
//			assertEquals(t1+"<-"+t,t1==t, ti.areCompatible(t1, t));
//		}
//	}
//
//	@Test
//	public void doubleAssignment() {
//		TypeInference ti = new TypeInference();
//		Type t1 = Type.KDOUBLE;
//		for (Type t : Type.VALUES) {
//			assertEquals(t1+"<-"+t,(t1==t)||(t==Type.KINT), ti.areCompatible(t1, t));
//		}
//	}
//	
//		
//	@Test
//	public void testSimpleSum() {
//		TypeInference ti = new TypeInference();
//		NumberLiteral nl = factory.createNumberLiteral();
//		nl.setDecimal(3);
//		nl.setIsDouble(false);
//		Variable v = factory.createVariable();
//		v.setName("s");
//		v.setType(Type.KINT);
//		SummationSubtraction sum = factory.createSummationSubtraction();
//		Reference ref = factory.createReference();
//		ref.setRef(v);
//		sum.setLeft(ref);
//		sum.setRight(nl);		
//		assertEquals(Type.KINT, ti.getType(sum));
//	}

	
}
