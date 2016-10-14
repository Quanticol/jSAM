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

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

/**
 * @author loreti
 *
 */
public class SamProjectBuilder extends IncrementalProjectBuilder {
	
	public static String BUILDER_ID = "org.cmg.ml.sam.projectbuilder";

	@Inject
	private IResourceSetProvider resourceSetProvider;
	
	/**
	 * 
	 */
	public SamProjectBuilder() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.resources.IncrementalProjectBuilder#build(int, java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IProject[] build(int kind, Map<String, String> args,
			IProgressMonitor monitor) throws CoreException {
		
		IProject project = getProject();
		
		ResourceSet rs = getResourceSetProvider().get(getProject());
		
		for( Resource r: rs.getResources() ) {
			System.out.println(r.getURI());
		}

		switch (kind) {
		case FULL_BUILD:
			System.out.println(project.getName()+" FULL_BUILD!");
			break;
		case INCREMENTAL_BUILD:
			System.out.println(project.getName()+" INCREMENTAL_BUILD!");			
			break;
		case CLEAN_BUILD:
			System.out.println(project.getName()+" CLEAN_BUILD!");						
			break;
		case AUTO_BUILD:
			System.out.println(project.getName()+" AUTO_BUILD!");						
			break;
		default:
			break;
		}
		// TODO Auto-generated method stub
		return null;
	}

	public IResourceSetProvider getResourceSetProvider() {
		return resourceSetProvider;
	}

}
