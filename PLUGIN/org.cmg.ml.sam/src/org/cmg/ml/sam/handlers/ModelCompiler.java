/*
 * Michele Loreti, Concurrency and Mobility Group
 * Universitˆ di Firenze, Italy
 * (C) Copyright ${year}.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Michele Loreti
 */
package org.cmg.ml.sam.handlers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.emf.common.util.WrappedException;
//import org.cmg.ml.sam.klaim.core.KlaimSpecification;
//import org.cmg.ml.sam.util.JavaObjectFromString;

/**
 * @author loreti
 *
 */
public class ModelCompiler {

	
//	public static KlaimSpecification getKlaimModel(CharSequence code ) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//
//	    Class<?> thisClass = compileAndLoad(code);
//	
//	    Object o = thisClass.newInstance();
//	    if ( o instanceof KlaimSpecification ) {
//	    	return (KlaimSpecification) o;
//	    }
//		return null;
//	}
//	
//	public static Class<?> compileAndLoad( CharSequence code ) throws ClassNotFoundException, MalformedURLException {
//		OnTheFlyJavaCompiler javaCompiler = new OnTheFlyJavaCompiler();
//		LinkedList<JavaObjectFromString> sourceFiles = new LinkedList<JavaObjectFromString>();
//		sourceFiles.add( new JavaObjectFromString("KlaimSystem", code.toString()) );
//		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//		List<String> options = Arrays.asList("-d" , "/tmp/","-cp",ModelCompiler.addClassPathOfClass(KlaimSpecification.class)+":/tmp" );
//		boolean res = compiler.getTask(null,null,null,options,null,sourceFiles).call();
//		if (!res) {
//			return null;
//		}
//		// Convert File to a URL
//		URL[] urls = { new URL( "file:///tmp/") };//, new URL( "file:///Users/loreti/Documents/Workspaces/ECLIPSE/PROJECTS/SAM/PLUGIN/org.cmg.sam.core.ref/") };
//		//urls.add(url)
//	    // Create a new class loader with the directory
//		   Thread current = Thread.currentThread();
//		   ClassLoader oldLoader = current.getContextClassLoader();
//		   URLClassLoader loader = new URLClassLoader( urls , oldLoader );
//	
//	    // Load in the class; Class.childclass should be located in
//	    // the directory file:/class/demo/
//	    Class<?> thisClass = loader.loadClass("KlaimSystem");
//	    //Class<?> thisClass = Class.forName("KlaimSystem");
//	    return thisClass;
//	}
	
	public static String addClassPathOfClass(Class<?> clazz) {
		final String classNameAsPath = "/"
				+ clazz.getCanonicalName().replace('.', '/');
		String resourceName = classNameAsPath + ".class";
		URL url = clazz.getResource(resourceName);
		if (url == null)
			throw new IllegalArgumentException(resourceName + " not found");
		String pathToFolderOrJar = null;
		if (url.getProtocol().startsWith("bundleresource")) {
			try {
				url = FileLocator.resolve(url);
			} catch (IOException e) {
				throw new WrappedException(e);
			}
		}
		if (url.getProtocol().startsWith("jar")) {
			try {
				pathToFolderOrJar = new URL(url.getPath().substring(0,
						url.getPath().indexOf('!'))).toURI().getRawPath();
			} catch (Exception e) {
				throw new WrappedException(e);
			}
		} else {
			String resolvedRawPath;
			try {
				resolvedRawPath = URIUtil.toURI(url).getRawPath();
			} catch (URISyntaxException e) {
				throw new WrappedException(e);
			}
			pathToFolderOrJar = resolvedRawPath.substring(0,
					resolvedRawPath.indexOf(classNameAsPath));
		}
		return pathToFolderOrJar;
	}
}
