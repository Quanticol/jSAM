	package org.cmg.ml.sam.views;


import java.util.HashSet;
import java.util.LinkedList;

import org.cmg.ml.sam.ISimulator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;



public class SAMSimulationView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.cmg.ml.sam.views.SAMSimulationView";
	private static final String JSAMSIMULATOR_ID = "org.cmg.ml.sam.extensions.simulator"; //$NON-NLS-1$

	private CTabFolder viewer;
//	private Action action1;
//	private Action action2;
//	private Action doubleClickAction;

	private LinkedList<CTabItem> tabs;

	private XtextEditor editor;

	private HashSet<String> languages;
	private IConfigurationElement[] simulators;

	/*
	 * The content provider class is responsible for
	 * providing objects to the view. It can wrap
	 * existing objects in adapters or simply return
	 * objects as-is. These objects may be sensitive
	 * to the current input of the view, or ignore
	 * it and always show the same content 
	 * (like Task List, for example).
	 */
	 
	class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			return new String[] { "One", "Two", "Three" };
		}
	}
	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}
		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}
		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().
					getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}
	
	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public SAMSimulationView() {
		installHandler();
		this.languages = new HashSet<String>();
		IExtensionRegistry platformRegistry = Platform.getExtensionRegistry();
		this.simulators = platformRegistry.getConfigurationElementsFor(JSAMSIMULATOR_ID);
		for (IConfigurationElement e : this.simulators) {
			this.languages.add(e.getAttribute("language"));
		}
	}

	/**
	 * 
	 */
	private void installHandler() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		IPartListener2 listener = new IPartListener2() {
			
			@Override
			public void partVisible(IWorkbenchPartReference partRef) {
				System.out.println("Visible: "+partRef.getTitle());
			}
			
			@Override
			public void partOpened(IWorkbenchPartReference partRef) {
				System.out.println("Opened: "+partRef.getTitle());
			}
			
			@Override
			public void partInputChanged(IWorkbenchPartReference partRef) {
				System.out.println("Input: "+partRef.getTitle());
			}
			
			@Override
			public void partHidden(IWorkbenchPartReference partRef) {
				System.out.println("Hidden: "+partRef.getTitle());
			}
			
			@Override
			public void partDeactivated(IWorkbenchPartReference partRef) {
				IEditorPart editor = partRef.getPage().getActiveEditor(); 
				if (editor instanceof XtextEditor) {
					setUpXtextEditor( (XtextEditor) editor );
				}
				
				System.out.println("Deactivated: "+partRef.getTitle());
			}
			
			@Override
			public void partClosed(IWorkbenchPartReference partRef) {
				System.out.println("Closed: "+partRef.getTitle());
			}
			
			@Override
			public void partBroughtToTop(IWorkbenchPartReference partRef) {
				System.out.println("Brought To Top: "+partRef.getTitle());
			}
			
			@Override
			public void partActivated(IWorkbenchPartReference partRef) {
				IEditorPart editor = partRef.getPage().getActiveEditor(); 
				if (editor instanceof XtextEditor) {
					setUpXtextEditor( (XtextEditor) editor );
				}
				
				System.out.println("Activated: "+partRef.getTitle());
			}
		};
		page.addPartListener(listener);
	}

	/**
	 * @param editor
	 */
	protected void setUpXtextEditor(XtextEditor editor) {
//		if (this.editor != editor) {
			this.editor = editor;
			refreshCTabPanels( );
			System.out.println("NEW EDITOR!!!!");
//		}
	}	

	/**
	 * 
	 */
	private void refreshCTabPanels() {
		for (CTabItem tabItem : tabs	) {
			tabItem.dispose();
		}
		IFile file = (IFile) editor.getResource();
		String extension = file.getFileExtension();
		CTabItem first = null;
		for (ISimulator simulator : loadSimulators( extension )) {
			CTabItem tabItem = new CTabItem(viewer, SWT.NONE);
			if (first == null) {
				first = tabItem;
			}
			tabItem.setText(simulator.getName());
			Composite c = simulator.createSimulationComposite(file,getModel(editor),viewer.getShell() ,viewer);
			tabItem.setControl(c);
			tabs.add(tabItem);			
		}
		if (first != null) {
			viewer.setSelection(first);
		}
	}

	private LinkedList<ISimulator> loadSimulators( String fileExtension ) {
		LinkedList<ISimulator> toReturn = new LinkedList<ISimulator>();
		for (IConfigurationElement e : simulators) {
			if (e.getAttribute("language").equals(fileExtension)) {
				try {
					ISimulator s = (ISimulator) e.createExecutableExtension("class");
					toReturn.add(  s );
				} catch (CoreException e1) {
				}
			}
			System.out.println("Ext: "+e.getAttribute("language")+" Simulator: "+e.getAttribute("class"));
		}		
		return toReturn;
	}
	
	
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new CTabFolder(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL ); 
		
		tabs = new LinkedList<CTabItem>();
				
		CTabItem itemStateFormulas = new CTabItem(viewer, SWT.CLOSE);
		itemStateFormulas.setText("State Formulas");
		Text text = new Text(viewer, SWT.MULTI);
		text.setText("Content for Item State Formulas");
		itemStateFormulas.setControl(text);
		tabs.add(itemStateFormulas);


		
//				new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
//		viewer.setContentProvider(new ViewContentProvider());
//		viewer.setLabelProvider(new ViewLabelProvider());
//		viewer.setSorter(new NameSorter());
//		viewer.setInput(getViewSite());

		// Create the help context id for the viewer's control
//		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "org.cmg.ml.sam.viewer");
//		makeActions();
//		hookContextMenu();
//		hookDoubleClickAction();
//		contributeToActionBars();
	}

//	private void hookContextMenu() {
//		MenuManager menuMgr = new MenuManager("#PopupMenu");
//		menuMgr.setRemoveAllWhenShown(true);
//		menuMgr.addMenuListener(new IMenuListener() {
//			public void menuAboutToShow(IMenuManager manager) {
//				SAMModelCheckingView.this.fillContextMenu(manager);
//			}
//		});
////		Menu menu = menuMgr.createContextMenu(viewer.getControl());
////		viewer.getControl().setMenu(menu);
////		getSite().registerContextMenu(menuMgr, viewer);
//	}

//	private void contributeToActionBars() {
//		IActionBars bars = getViewSite().getActionBars();
//		fillLocalPullDown(bars.getMenuManager());
//		fillLocalToolBar(bars.getToolBarManager());
//	}

//	private void fillLocalPullDown(IMenuManager manager) {
//		manager.add(action1);
//		manager.add(new Separator());
//		manager.add(action2);
//	}
//
//	private void fillContextMenu(IMenuManager manager) {
//		manager.add(action1);
//		manager.add(action2);
//		// Other plug-ins can contribute there actions here
//		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
//	}
//	
//	private void fillLocalToolBar(IToolBarManager manager) {
//		manager.add(action1);
//		manager.add(action2);
//	}
//
//	private void makeActions() {
//		action1 = new Action() {
//			public void run() {
//				
//				for (CTabItem cTabItem : tabs) {
//					cTabItem.dispose();
//				}
//				tabs = new LinkedList<CTabItem>();
//				
//			}
//		};
//		action1.setText("Action 1");
//		action1.setToolTipText("Action 1 tooltip");
//		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
//			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
//		
//		action2 = new Action() {
//			public void run() {
//				CTabItem itemStateFormulas = new CTabItem(viewer, SWT.CLOSE);
//				itemStateFormulas.setText("State Formulas "+tabs.size());
//				Text text = new Text(viewer, SWT.MULTI);
//				text.setText("Content for Item State Formulas");
//				itemStateFormulas.setControl(text);
//				tabs.add(itemStateFormulas);
//			}
//		};
//		action2.setText("Action 2");
//		action2.setToolTipText("Action 2 tooltip");
//		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
//				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
//		doubleClickAction = new Action() {
//			public void run() {
////				ISelection selection = viewer.getSelection();
////				Object obj = ((IStructuredSelection)selection).getFirstElement();
////				showMessage("Double-click detected on "+obj.toString());
//			}
//		};
//	}

//	private void hookDoubleClickAction() {
////		viewer.addDoubleClickListener(new IDoubleClickListener() {
////			public void doubleClick(DoubleClickEvent event) {
////				doubleClickAction.run();
////			}
////		});
//	}

//	private void showMessage(String message) {
//		MessageDialog.openInformation(
//			viewer.getShell(),
////			viewer.getControl().getShell(),
//			"Model checking View",
//			message);
//	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.setFocus();
	}
	
	protected EObject getModel(XtextEditor editor) {
		EList<EObject> values = editor.getDocument().readOnly(new IUnitOfWork<EList<EObject>, XtextResource>(){

			@Override
			public EList<EObject> exec(XtextResource state) throws Exception {
				if (state.getErrors().size()>0) {
					return null;
				}
				return state.getContents();
			}
			
		});		
		if ((values != null)&&(values.size() > 0)) {
			return values.get(0);
		}
		return null;
	}
	
}