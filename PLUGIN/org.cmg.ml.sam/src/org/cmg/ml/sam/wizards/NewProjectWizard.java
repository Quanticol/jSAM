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
package org.cmg.ml.sam.wizards;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;


/**
 * @author loreti
 *
 */
public class NewProjectWizard extends Wizard implements INewWizard {

	private NewProjectWizardPage page;
	
	public NewProjectWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean performFinish() {
		final String projectName = page.getProjectName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(projectName, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public void addPages() {
		page = new NewProjectWizardPage();
		addPage(page);
	}
	
	private void doFinish(
			String projectName,
			IProgressMonitor monitor)
			throws CoreException {
			monitor.beginTask("Creating project " + projectName, 1);
	        IProject newProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);

	        if (!newProject.exists()) {
//	        	URI projectLocation = location;
	        	IProjectDescription desc = newProject.getWorkspace().newProjectDescription(newProject.getName());
//	        	if (location != null &amp;&amp; ResourcesPlugin.getWorkspace().getRoot().getLocationURI().equals(location)) {
//	        		projectLocation = null;
//	        	}
	        
//	        	desc.setLocationURI(projectLocation);
	        	try {
	        		newProject.create(desc, null);
	        		if (!newProject.isOpen()) {
	        			newProject.open(null);
	        		}
	        	} catch (CoreException e) {
	        		e.printStackTrace();
	        	}
//	        	if (!newProject.hasNature("org.eclipse.xtext.builder.nature.XtextNature")) {
//	        	if (!newProject.hasNature("org.eclipse.xtext.ui.shared.xtextNature")) {
	        	if (!newProject.hasNature("org.cmg.ml.sam.SamNature")) {
	        		IProjectDescription description = newProject.getDescription();
	        		String[] natures = description.getNatureIds();
	        		String[] newNatures = new String[natures.length+2];
	        		System.arraycopy(natures, 0, newNatures, 0, natures.length);
	        		newNatures[natures.length] = "org.eclipse.xtext.ui.shared.xtextNature";
	        		newNatures[natures.length+1] = "org.cmg.ml.sam.SamNature";
	        		description.setNatureIds(newNatures);
	        		newProject.setDescription(description, null);
	        		newProject.build(IncrementalProjectBuilder.FULL_BUILD, monitor);
	        	}
	        }
	        //			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
//			IResource resource = root.findMember(new Path(containerName));
//			if (!resource.exists() || !(resource instanceof IContainer)) {
//				throwCoreException("Container \"" + containerName + "\" does not exist.");
//			}
//			IContainer container = (IContainer) resource;
//			final IFile file = container.getFile(new Path(fileName));
//			try {
//				InputStream stream = openContentStream();
//				if (file.exists()) {
//					file.setContents(stream, true, true, monitor);
//				} else {
//					file.create(stream, true, monitor);
//				}
//				stream.close();
//			} catch (IOException e) {
//			}
//			monitor.worked(1);
//			monitor.setTaskName("Opening file for editing...");
//			getShell().getDisplay().asyncExec(new Runnable() {
//				public void run() {
//					IWorkbenchPage page =
//						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
//					try {
//						IDE.openEditor(page, file, true);
//					} catch (PartInitException e) {
//					}
//				}
//			});
			monitor.worked(1);
		}
	
//	private void throwCoreException(String message) throws CoreException {
//		IStatus status =
//			new Status(IStatus.ERROR, "menuExample", IStatus.OK, message, null);
//		throw new CoreException(status);
//	}

}
