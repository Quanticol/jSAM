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
package org.cmg.ml.sam;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.List;

import org.cmg.ml.sam.core.sim.SimulationData;
import org.cmg.ml.sam.core.sim.SimulationSeries;
import org.cmg.ml.views.GraphView;
import org.cmg.ml.views.ModelCheckingView;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * @author loreti
 *
 */
public class SamProjectHelper {

	public static final String SAM_MAIN = "org.cmg.ml.sam";
	public static final String SAM_CORE = "org.cmg.ml.sam.core";
	public static final String APACHE_MATH_COMMONS = "org.apache.commons.math";
	

	/**
	 * @param bundles 
	 * @return
	 */
	public static Collection<? extends String> addSamBudles(List<String> bundles ) {
		bundles.add(SAM_MAIN);
		bundles.add(SAM_CORE);
		bundles.add(APACHE_MATH_COMMONS);
		return bundles;
	}
	
		
	public static String getPackageFolder( Resource resource ) {
		URI uri = resource.getURI();
		if (uri.isPlatform()) {
			String toReturn = uri.toPlatformString(true);
			if (toReturn.startsWith("/")) {
				toReturn = toReturn.substring(1);
			}
			int lastSlash = toReturn.lastIndexOf('/');
			String packageFolder;
			if (lastSlash < 0) {
				packageFolder = "";
			} else {
				packageFolder = toReturn.substring(0, lastSlash);

			}
			packageFolder = packageFolder.replace('.', '_');
			int lastDot = toReturn.lastIndexOf('.');
			if (lastDot >= 0) {
				packageFolder = packageFolder+"/"+(toReturn.substring(lastDot+1));
			}
			return packageFolder;
		}
		return "test";
	}
	
	public static String getClassName( Resource resource ) {
		URI uri = resource.getURI();
		if (uri.isPlatform()) {
			String toReturn = uri.toPlatformString(true);
			int start = toReturn.lastIndexOf('/');
			if (start < 0) {
				start = 0;
			} else {
				start = start + 1;
			}
			int end = toReturn.lastIndexOf('.');
			if (end < 0) {
				end = toReturn.length();
			}
			return toReturn.substring(start, end);
		}
		return "Test";
	}
	
	public static Class<?> loadClassFromProject( ClassLoader parentClassLoader , Resource resource , IProject project ) throws CoreException, MalformedURLException, ClassNotFoundException {
		String[] classPathEntries = JavaRuntime.computeDefaultRuntimeClassPath(JavaCore.create(project));
//		URL url = JavaCore.create(project).getOutputLocation().toFile().
//		List<URL> urlList = new ArrayList<URL>();
//		for (int i = 0; i < classPathEntries.length; i++) {
		 String entry = classPathEntries[0];
		 IPath path = new Path(entry);
		 URL url = path.toFile().toURI().toURL();
//		 urlList.add(url);
//		}
//		ClassLoader parentClassLoader = project.getClass().getClassLoader();
//		URL[] urls = (URL[]) urlList.toArray(new URL[urlList.size()]);
//		URLClassLoader classLoader = new URLClassLoader(urls, cLoader);
		URLClassLoader classLoader = new URLClassLoader(new URL[] { url } , parentClassLoader);

		
		Class<?> clazz = classLoader.loadClass(SamProjectHelper.getPackageFolder(resource).replace('/','.')+"."+
				SamProjectHelper.getClassName(resource));
		return clazz;
	}
	
	public static GraphView getGraphView() {
		try {
			IWorkbench workbench = PlatformUI.getWorkbench();
			IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();
			return (GraphView) page.showView(GraphView.ID);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}				
	}


	/**
	 * @return
	 */
	public static ModelCheckingView getModelCheckingView() {
		try {
			IWorkbench workbench = PlatformUI.getWorkbench();
			IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();
			return (ModelCheckingView) page.showView(ModelCheckingView.ID);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}				
	}


	/**
	 * @param file
	 * @param series
	 */
	public static void saveSeriesData(String file, List<SimulationSeries> series) {
		for (SimulationSeries s : series) {
			saveSerieData(file,s);
		}
	}


	/**
	 * @param file
	 * @param s
	 */
	public static void saveSerieData(String file, SimulationSeries s) {
		try {
			File dataFile = new File(file+File.separator+s.getName()+".dat");
			PrintWriter writer = new PrintWriter(dataFile);
			for (SimulationData	d : s.getSeries()) {
				writer.println(d.getX()+"\t"+d.getY());
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	/**
	 * @param file
	 * @param probabilities
	 * @param d 
	 */
	public static void saveProbabilityData(String file, double[] probabilities , double start , double dt ) {
		try {
			File dataFile = new File(file+File.separator+"output.dat");
			PrintWriter writer = new PrintWriter(dataFile);
			for( int i=0 ; i<probabilities.length ; i++) {
				writer.println((start+(i*dt))+"\t"+probabilities[i]);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
