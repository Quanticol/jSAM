package org.cmg.ml.sam.population.swt;

import org.cmg.ml.sam.population.PopulationSpecification;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class FlyFastStateSelectionComposite extends Composite {

	private PopulationSpecification specification;
	private Text[] occupancies;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public FlyFastStateSelectionComposite(Shell main , Composite parent, PopulationSpecification specification ) {
		super(parent, SWT.NONE);
		this.specification = specification;
		init();
	}

	private void init() {
		setLayout(new GridLayout(2, false));
		
		Group grpEnvironment = new Group(this, SWT.NONE);
		grpEnvironment.setText("Initial Occupancy");
		grpEnvironment.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_grpEnvironment = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);
		gd_grpEnvironment.heightHint = 125;
		grpEnvironment.setLayoutData(gd_grpEnvironment);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(grpEnvironment, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		
		Label lblState = new Label(composite, SWT.NONE);
		lblState.setText("State 1:");
		
//		text = new Text(composite, SWT.BORDER);
//		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
//		
//		Label lblState_1 = new Label(composite, SWT.NONE);
//		lblState_1.setText("State 2:");
//		
//		text_1 = new Text(composite, SWT.BORDER);
//		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblState_2 = new Label(composite, SWT.NONE);
		lblState_2.setText("State 3:");
		new Label(composite, SWT.NONE);
		
		Label lblState_3 = new Label(composite, SWT.NONE);
		lblState_3.setText("State 4:");
		new Label(composite, SWT.NONE);
		
		Label lblState_4 = new Label(composite, SWT.NONE);
		lblState_4.setText("State 5:");
		new Label(composite, SWT.NONE);
		
		Label lblState_5 = new Label(composite, SWT.NONE);
		lblState_5.setText("State 6:");
		new Label(composite, SWT.NONE);
		Label lblState_6 = new Label(composite, SWT.NONE);
		lblState_6.setText("State 6:");
		new Label(composite, SWT.NONE);
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		
		Label lblStateOfIndividual = new Label(this, SWT.NONE);
		lblStateOfIndividual.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblStateOfIndividual.setText("Individual:");
		
		Combo combo = new Combo(this, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnRetrieve = new Button(this, SWT.NONE);
		btnRetrieve.setText("Retrieve");
		
		Combo combo_1 = new Combo(this, SWT.NONE);
		combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
