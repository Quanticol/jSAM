/*
 * Michele Loreti, Concurrency and Mobility Group
 * Universitą di Firenze, Italy
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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (pippa).
 */

public class NewSpecificationWizardPage extends WizardPage {
	
	private static final String JSAMSPECIFICATION_ID = "org.cmg.ml.sam.extensions.specification"; //$NON-NLS-1$

	private Text containerText;

	private Text fileText;
	
	private Combo combo;

	private ISelection selection;

	private IConfigurationElement[] specifications;

	private String currentExtension;
	
	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param pageName
	 */
	public NewSpecificationWizardPage(ISelection selection) {
		super("wizardPage");
		setTitle("New specification");
		setDescription("This wizard creates a new file contains a sysstem specification in one of the SAM specification languages.");
		this.selection = selection;
		IExtensionRegistry platformRegistry = Platform.getExtensionRegistry();
		this.specifications = platformRegistry .getConfigurationElementsFor(JSAMSPECIFICATION_ID);
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;
		Label label = new Label(container, SWT.NULL);
		label.setText("&Container:");

		containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.FILL;
		gd.grabExcessHorizontalSpace = true;
		containerText.setLayoutData(gd);
		containerText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		Button button = new Button(container, SWT.PUSH);
		button.setText("Browse...");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleBrowse();
			}
		});
		
		label = new Label(container,SWT.NULL);
		label.setText("&Specification language:");
		combo = new Combo(container, SWT.NULL);
		combo.setItems(getLanguageNames());
		combo.addModifyListener( new ModifyListener() {			
			@Override
			public void modifyText(ModifyEvent e) {
				changePlugInSelection();
				dialogChanged();
			}
		});
		gd = new GridData();
		gd.horizontalAlignment = GridData.FILL;
		gd.horizontalSpan = 2;
		combo.setLayoutData(gd);

		
		label = new Label(container, SWT.NULL);
		label.setText("&File name:");
		fileText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData();
		gd.horizontalAlignment = GridData.FILL;
//		gd.horizontalSpan = 2;
		fileText.setLayoutData(gd);
		fileText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		initialize();
		dialogChanged();
		setControl(container);
	}

	/**
	 * @return
	 */
	private String[] getLanguageNames() {
		String[] languageNames = new String[specifications.length];
		for( int i=0 ; i<languageNames.length ; i++ ) {
			languageNames[i] = specifications[i].getChildren("shortdescription")[0].getAttribute("value");					
		}
		return languageNames;
	}

	/**
	 * This method is invoked when the selection in the combo box containing
	 * plug-ins changes.
	 */
	protected void changePlugInSelection() {
		int i = combo.getSelectionIndex();
		if (i>-1) {
			currentExtension = specifications[i].getChildren("fileextension")[0].getAttribute("value");
			changeFileExtension();
		} else {
			currentExtension = null;
		}
	}

	/**
	 * This method is activated when a specification language is selected and it changes
	 * the filename extension. 
	 * @param ext 
	 */
	private void changeFileExtension() {
		String fileName = fileText.getText();
		if (fileName.trim().equals("")) {
			return;
		}
		int dotLoc = fileName.lastIndexOf('.');
		if (dotLoc != -1) {
			fileName = fileName.substring(0, dotLoc);			
		} 
		fileText.setText(fileName+"."+currentExtension);
	}

	/**
	 * Tests if the current workbench selection is a suitable container to use.
	 */

	private void initialize() {
		if (selection != null && selection.isEmpty() == false
				&& selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
			if (ssel.size() > 1)
				return;
			Object obj = ssel.getFirstElement();
			if (obj instanceof IResource) {
				IContainer container;
				if (obj instanceof IContainer)
					container = (IContainer) obj;
				else
					container = ((IResource) obj).getParent();
				containerText.setText(container.getFullPath().toString());
			}
		}
		fileText.setText("new_file.net");
	}

	/**
	 * Uses the standard container selection dialog to choose the new value for
	 * the container field.
	 */

	private void handleBrowse() {
		ContainerSelectionDialog dialog = new ContainerSelectionDialog(
				getShell(), ResourcesPlugin.getWorkspace().getRoot(), false,
				"Select new file container");
		if (dialog.open() == ContainerSelectionDialog.OK) {
			Object[] result = dialog.getResult();
			if (result.length == 1) {
				containerText.setText(((Path) result[0]).toString());
			}
		}
	}

	/**
	 * Ensures that both text fields are set.
	 */

	private void dialogChanged() {
		IResource container = ResourcesPlugin.getWorkspace().getRoot()
				.findMember(new Path(getContainerName()));
		String fileName = getFileName();

		if (getContainerName().length() == 0) {
			updateStatus("File container must be specified");
			return;
		}
		if (container == null
				|| (container.getType() & (IResource.PROJECT | IResource.FOLDER)) == 0) {
			updateStatus("File container must exist");
			return;
		}
		if (!container.isAccessible()) {
			updateStatus("Project must be writable");
			return;
		}
		if (fileName.length() == 0) {
			updateStatus("File name must be specified");
			return;
		}
		if (fileName.replace('\\', '/').indexOf('/', 1) > 0) {
			updateStatus("File name must be valid");
			return;
		}
		if (combo.getSelectionIndex() == -1) {
			updateStatus("Selects a specification language.");
			return;
		}

		int dotLoc = fileName.lastIndexOf('.');
		if (dotLoc != -1) {
			String ext = fileName.substring(dotLoc + 1);			
			if (ext.equalsIgnoreCase(currentExtension) == false) {
				updateStatus("File extension must be \""+currentExtension+"\"");
				return;
			}
		} 
		updateStatus(null);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public String getContainerName() {
		return containerText.getText();
	}

	public String getFileName() {
		return fileText.getText();
	}
}