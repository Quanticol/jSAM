/*
 * Michele Loreti, Concurrency and Mobility Group
 * Universitˆ di Firenze, Italy
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

import java.util.ArrayList;

/**
 * This class is used to store the list of available SAM plug-in. Each plug-in
 * register itself as soon as it is loaded. 
 * 
 * @author Michele Loreti
 *
 */
public class SAMRegistry {
	
	/**
	 * To access to SAMRegistry instance, the singleton pattern is
	 * used.
	 */
	private static SAMRegistry instance;
	//FIXME: Check if dependency injection could simplify code organizzation.

	/**
	 * Hashmap used to bind each specification language name to the corresponding 
	 * SAMPlugIn.
	 */
	private ArrayList<SAMPlugIn> plugins;
	
	/**
	 * Creates a new instance of SAMRegistry. Since SAMRegisrty follows a 
	 * singleton pattern, this constructor is private. The single
	 * available instance can be obtained via method <code>getInstance()</code>.
	 */
	private SAMRegistry() {
		plugins = new ArrayList<SAMPlugIn>();
//		registerPlugIn(new SAMPlugIn() {
//
//			@Override
//			public String getLanguageName() {
//				return "Klaim Specification Language";
//			}
//
//			@Override
//			public String getFileExtension() {
//				return "net";
//			}
//			
//		});
//		registerPlugIn(new SAMPlugIn() {
//
//			@Override
//			public String getLanguageName() {
//				return "Population Based Language";
//			}
//
//			@Override
//			public String getFileExtension() {
//				return "pop";
//			}
//			
//		});
//		registerPlugIn(new SAMPlugIn() {
//
//			@Override
//			public String getLanguageName() {
//				return "PEPA";
//			}
//
//			@Override
//			public String getFileExtension() {
//				return "pepa";
//			}
//			
//		});
//		registerPlugIn(new SAMPlugIn() {
//
//			@Override
//			public String getLanguageName() {
//				return "SCEL-TS";
//			}
//
//			@Override
//			public String getFileExtension() {
//				return "sts";
//			}
//			
//		});
	}
	
	/**
	 * Returns the active registry instance. 
	 * 
	 * @return the active registry instance.
	 */
	public static SAMRegistry getInstance() {
		init();
		return instance;
	}
	
	/**
	 * Returns the plugin associated to the specification language with name
	 * <code>languageName</code>
	 * @param languageName specification language name
	 * @return the plugin associated to the specification language with name
	 * <code>languageName</code>.
	 */
	public SAMPlugIn getPlugIn( String languageName ) {
		for (SAMPlugIn plugin : plugins) {
			if (plugin.getLanguageName().equals(languageName)) {
				return plugin;
			}
		}
		return null;
	}
	
	/**
	 * Associates to specification language <code>languageName</code> the 
	 * plugin <code>plugin</code>.
	 * 
	 * @param plugin a SAM plug-in
	 */
	public void registerPlugIn( SAMPlugIn plugin ) {
		plugins.add(plugin);
	}
	
	
	/**
	 * Initializes registry data structures.
	 */
	public static void init() {
		if (instance == null) {
			instance = new SAMRegistry();
		}
	}

	/**
	 * Returns an array containing the installed the descriptions of installed
	 * plug-ins.
	 * 
	 * @return an array containing the installed the descriptions of installed
	 * plug-ins.
	 */
	public String[] getLanguageNames() {
		String[] toReturn = new String[plugins.size()];
		for (int i=0 ; i<plugins.size() ; i++ ) {
			toReturn[i] = plugins.get(i).getLanguageName();
		}
		return toReturn;
	}

	/**
	 * Returns the plug-in with index <code>i</code>.
	 * 
	 * @param i plug-in index
	 * @return the plug-in with index <code>i</code>.
	 */
	public SAMPlugIn getPlugIn(int i) {
		return plugins.get(i);
	}
	
}
