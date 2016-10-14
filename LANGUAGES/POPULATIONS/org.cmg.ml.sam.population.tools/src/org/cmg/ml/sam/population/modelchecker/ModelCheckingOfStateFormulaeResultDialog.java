package org.cmg.ml.sam.population.modelchecker;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.TableItem;

public class ModelCheckingOfStateFormulaeResultDialog extends Dialog {

	protected Object result;
	protected Shell shlModelcheckingResults;
	private Table table;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ModelCheckingOfStateFormulaeResultDialog(Shell parent, int style) {
		super(parent, style);
		setText("Modelchecking results...");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlModelcheckingResults.open();
		shlModelcheckingResults.layout();
		Display display = getParent().getDisplay();
		while (!shlModelcheckingResults.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlModelcheckingResults = new Shell(getParent(), getStyle());
		shlModelcheckingResults.setSize(450, 300);
		shlModelcheckingResults.setText("Model-checking results...");
		shlModelcheckingResults.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(shlModelcheckingResults, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnFormulae = new TableColumn(table, SWT.CENTER);
		tblclmnFormulae.setWidth(310);
		tblclmnFormulae.setText("Formulae");
		
		TableColumn tblclmnModelcheckingResult = new TableColumn(table, SWT.CENTER);
		tblclmnModelcheckingResult.setWidth(138);
		tblclmnModelcheckingResult.setText("Results");
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));

	}
}
