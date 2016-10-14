/*
 * Michele Loreti, Concurrency and Mobility Group
 * Universit� di Firenze, Italy
 * (C) Copyright 2013.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Michele Loreti
 */
package org.cmg.ml.sam.xtext.population;

import java.util.logging.Filter;

import org.cmg.ml.sam.CompilationEObjectException;
import org.cmg.ml.sam.core.logic.StateFormula;
import org.cmg.ml.sam.population.PopulationModule;
import org.cmg.ml.sam.population.PopulationSpecification;
import org.cmg.ml.sam.util.OnTheFlyJavaCompiler;
import org.cmg.ml.sam.xtext.population.generator.PopulationToJavaCompiler;
import org.cmg.ml.sam.xtext.population.population.Model;

/**
 * @author loreti
 *
 */
public class PopulationCompiler {
	
	private static Class<?>[] dependencyList = {
		PopulationSpecification.class ,
		PopulationModule.class , 
		Filter.class ,
		StateFormula.class 
	};

	protected PopulationToJavaCompiler compiler;
	
	public PopulationCompiler() {
		this.compiler = new PopulationToJavaCompiler();		
	}
	
	public PopulationSpecification compile( String packageName , String className , Model m ) throws CompilationEObjectException {
		CharSequence seq = compiler.compile(packageName, className, m);
		OnTheFlyJavaCompiler javaCompiler = new OnTheFlyJavaCompiler();
//		javaCompiler.setParentClassLoader(Thread.currentThread().getContextClassLoader());
		javaCompiler.setParentClassLoader(getClass().getClassLoader());
		for (Class<?> clazz	: dependencyList) {
			javaCompiler.addClassPathOfClass(clazz);
		}
		Class<?> newClazz = javaCompiler.compileToClass(packageName+"."+className,  seq.toString());
		try {
			return (PopulationSpecification) newClazz.newInstance();
		} catch (InstantiationException e) {
			throw new CompilationEObjectException(e);
		} catch (IllegalAccessException e) {
			throw new CompilationEObjectException(e);
		} catch (ClassCastException e) {
			throw new CompilationEObjectException(e);
		}
	}
	
}
