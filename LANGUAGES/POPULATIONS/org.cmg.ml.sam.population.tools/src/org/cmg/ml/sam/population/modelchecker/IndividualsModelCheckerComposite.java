package org.cmg.ml.sam.population.modelchecker;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;

import org.cmg.ml.sam.SamProjectHelper;
import org.cmg.ml.sam.core.logic.ModelCheckerI;
import org.cmg.ml.sam.core.logic.PathFormula;
import org.cmg.ml.sam.core.logic.StateFormula;
import org.cmg.ml.sam.core.mc.pomc.OnTheFlyProbabilisticModelChecker;
import org.cmg.ml.sam.core.mc.stat.StatisticProbabilisticModelChecker;
import org.cmg.ml.sam.jobs.PathFormulaeSatisfactionCheckerJob;
import org.cmg.ml.sam.jobs.PathProbabilityComputationJob;
import org.cmg.ml.sam.jobs.StateFormulaeSatisfactionCheckerJob;
import org.cmg.ml.sam.population.PopulationSpecification;
import org.cmg.ml.sam.population.PopulationState;
import org.cmg.ml.sam.util.Pair;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class IndividualsModelCheckerComposite extends Composite {

	
	private static int ONTHEFLY_MODELCHECKER = 0;
	private static int STATISTICAL_MODELCHECKER = 1;

	private static int STATE_FORMULAE = 0;
	private static int PATH_FORMULAE = 1;
	private static int PATH_PROBABILITIES = 2;
	
	private Combo systems;
	private PopulationSpecification spec;
	private Shell main;
	private Spinner errorThreashold;
	private Spinner errorProbability;
	private TabFolder modelCheckerTab;
	private List stateFormulae;
	private List pathFormulae;
	private TabFolder formulaeTab;
	private Combo leftUntil;
	private Combo rightUntil;
	private Spinner stepLimit;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public IndividualsModelCheckerComposite(Shell main , Composite parent, PopulationSpecification spec ) {
		super(parent, SWT.NONE);
		this.spec = spec;
		this.main = main;
		init();
	}
	
	private void init() {
		setLayout(new GridLayout(2, false));
		
		Label lblSystem = new Label(this, SWT.NONE);
		lblSystem.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSystem.setText("System:");
		
		systems = new Combo(this, SWT.NONE);
		systems.setToolTipText("The system to verify.");
		systems.setItems(spec.getConfigurationNames());
		systems.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		formulaeTab = new TabFolder(this, SWT.NONE);
		GridData gd_formulaeTab = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
		gd_formulaeTab.heightHint = 183;
		formulaeTab.setLayoutData(gd_formulaeTab);
		
		TabItem tbtmStateFomulae = new TabItem(formulaeTab, SWT.NONE);
		tbtmStateFomulae.setText("State Fomulae");
		
		Composite stateFormulaeComposite = new Composite(formulaeTab, SWT.NONE);
		tbtmStateFomulae.setControl(stateFormulaeComposite);
		stateFormulaeComposite.setLayout(new GridLayout(1, false));
		
		stateFormulae = new List(stateFormulaeComposite, SWT.BORDER | SWT.MULTI);
		stateFormulae.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		stateFormulae.setItems(spec.getStateFormulae());
		
		TabItem tbtmPathFormulae = new TabItem(formulaeTab, SWT.NONE);
		tbtmPathFormulae.setText("Path Formulae");
		
		Composite pathFormulaeComposite = new Composite(formulaeTab, SWT.NONE);
		tbtmPathFormulae.setControl(pathFormulaeComposite);
		pathFormulaeComposite.setLayout(new GridLayout(1, false));
		
		pathFormulae = new List(pathFormulaeComposite, SWT.BORDER | SWT.MULTI);
		pathFormulae.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		pathFormulae.setItems(spec.getPathFormulae());
		
		TabItem tbtmPathProbabilities = new TabItem(formulaeTab, SWT.NONE);
		tbtmPathProbabilities.setText("Path Probabilities");
		
		Composite pathProbabilityComposite = new Composite(formulaeTab, SWT.NONE);
		tbtmPathProbabilities.setControl(pathProbabilityComposite);
		pathProbabilityComposite.setLayout(new GridLayout(2, false));
		
		Label lblNewLabel = new Label(pathProbabilityComposite, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("First:");
		
		leftUntil = new Combo(pathProbabilityComposite, SWT.NONE);
		leftUntil.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		leftUntil.setItems(spec.getStateFormulae());
		
		Label lblSecond = new Label(pathProbabilityComposite, SWT.NONE);
		lblSecond.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSecond.setText("Second:");
		
		rightUntil = new Combo(pathProbabilityComposite, SWT.NONE);
		rightUntil.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		rightUntil.setItems(spec.getStateFormulae());
		
		Label lblSteps = new Label(pathProbabilityComposite, SWT.NONE);
		lblSteps.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSteps.setText("Steps:");
		
		stepLimit = new Spinner(pathProbabilityComposite, SWT.BORDER);
		stepLimit.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		stepLimit.setMaximum(Integer.MAX_VALUE);
		
		modelCheckerTab = new TabFolder(this, SWT.NONE);
		modelCheckerTab.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
		
		TabItem tbtmOnthefly = new TabItem(modelCheckerTab, SWT.NONE);
		tbtmOnthefly.setText("On-the-fly");
		
		Composite onTheFlyComposite = new Composite(modelCheckerTab, SWT.NONE);
		tbtmOnthefly.setControl(onTheFlyComposite);
		onTheFlyComposite.setLayout(new GridLayout(2, false));
		
		Label lblPrecision = new Label(onTheFlyComposite, SWT.NONE);
		lblPrecision.setText("Precision:");
		
		Spinner onTheFlyPrecision = new Spinner(onTheFlyComposite, SWT.BORDER);
		onTheFlyPrecision.setMaximum(100000000);
		onTheFlyPrecision.setMinimum(1);
		onTheFlyPrecision.setDigits(9);
		onTheFlyPrecision.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		TabItem tbtmStatistical = new TabItem(modelCheckerTab, SWT.NONE);
		tbtmStatistical.setText("Statistical");
		
		Composite statisticalComposite = new Composite(modelCheckerTab, SWT.NONE);
		tbtmStatistical.setControl(statisticalComposite);
		statisticalComposite.setLayout(new GridLayout(2, false));
		
		Label lblErrorProbability = new Label(statisticalComposite, SWT.NONE);
		lblErrorProbability.setText("Error probability:");
		
		errorProbability = new Spinner(statisticalComposite, SWT.BORDER);
		GridData gd_errorProbability = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_errorProbability.widthHint = 302;
		errorProbability.setLayoutData(gd_errorProbability);
		errorProbability.setMaximum(1000000000);
		errorProbability.setMinimum(1);
		errorProbability.setSelection(1000000);
		errorProbability.setDigits(9);
		
		Label lblErrorThreashold = new Label(statisticalComposite, SWT.NONE);
		lblErrorThreashold.setText("Error threashold:");
		
		errorThreashold = new Spinner(statisticalComposite, SWT.BORDER);
		GridData gd_errorThreashold = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_errorThreashold.widthHint = 148;
		errorThreashold.setLayoutData(gd_errorThreashold);
		errorThreashold.setMaximum(1000000000);
		errorThreashold.setMinimum(1);
		errorThreashold.setSelection(1000000);
		errorThreashold.setDigits(9);
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setLayout(new GridLayout(3, false));
		composite_1.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, false, false, 2, 1));
		new Label(composite_1, SWT.NONE);
		
		Button btnOk = new Button(composite_1, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (validate()) {
					scheduleModelCheckingJob();
					main.close();					
				}
			}
		});
		btnOk.setText("Ok");
		
		Button btnCancel = new Button(composite_1, SWT.NONE);
		btnCancel.setText("Cancel");
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				main.close();					
			}
		});
	}

	protected void scheduleModelCheckingJob() {
		int foo = systems.getSelectionIndex();
		if (foo < 0) {
			return ;
		}
		if (formulaeTab.getSelectionIndex() ==  STATE_FORMULAE) {
			doModelCheckingOfStateFormulae( );
		} 
		if (formulaeTab.getSelectionIndex() == PATH_FORMULAE) {
			doModelCheckingOfPathFormulae( );
		}
		if (formulaeTab.getSelectionIndex() == PATH_PROBABILITIES) {
			doComputePathProbabilities();
		}
	}

	private void doComputePathProbabilities() {
		ModelCheckerI<PopulationState> modelChecker = getModelChecker();
		String selectedConfiguration = systems.getItem(systems.getSelectionIndex());
		PopulationState state = spec.getIndividualsConfiguration(selectedConfiguration);
		String left = leftUntil.getItem(leftUntil.getSelectionIndex());
		String right = rightUntil.getItem(rightUntil.getSelectionIndex());
		StateFormula<PopulationState> firstFormula = spec.getPopulationStateFormula(left);
		StateFormula<PopulationState> secondFormula = spec.getPopulationStateFormula(right);
		int deadline = stepLimit.getSelection();
		PathProbabilityComputationJob<PopulationState> job = new PathProbabilityComputationJob<PopulationState>(  modelChecker , state , firstFormula , secondFormula , deadline , 1.0 );
		try {
			new ProgressMonitorDialog(main).run(true, true, job);
			double[] probabilities = job.getProbabilities();
			MessageBox dialog = new MessageBox(main, SWT.ICON_QUESTION | SWT.YES| SWT.NO);
			dialog.setText("Dave data");
			dialog.setMessage("Do you save data into an external folder?");					
			if (dialog.open() == SWT.YES) {
				DirectoryDialog fileDialog = new DirectoryDialog(main);
				String file = fileDialog.open();
				SamProjectHelper.saveProbabilityData(file,probabilities,0.0,1.0);
			}
			SamProjectHelper.getGraphView().addGraph(selectedConfiguration , (left+" U<=t "+right) , probabilities , 1.0 );
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doModelCheckingOfPathFormulae( ) {
		ModelCheckerI<PopulationState> modelChecker = getModelChecker();
		String[] selectedFormulae = pathFormulae.getSelection();
		String selectedConfiguration = systems.getItem(systems.getSelectionIndex());
		PopulationState state = spec.getIndividualsConfiguration(selectedConfiguration);
		LinkedList<Pair<String, PathFormula<PopulationState>>> modelCheckingArguments = new LinkedList<Pair<String,PathFormula<PopulationState>>>();
		for (int i = 0; i < selectedFormulae.length; i++) {
			modelCheckingArguments.add(new Pair<String,PathFormula<PopulationState>>( selectedFormulae[i] , spec.getPopulationPathFormula(selectedFormulae[i])));
		}
		PathFormulaeSatisfactionCheckerJob<PopulationState> job = new PathFormulaeSatisfactionCheckerJob<PopulationState>(modelChecker, state, modelCheckingArguments);
		try {
			new ProgressMonitorDialog(main).run(true, true, job);
			SamProjectHelper.getModelCheckingView().addPathProbabilityResults(selectedConfiguration , job.getResults());
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}

	private ModelCheckerI<PopulationState> getModelChecker() {
		if (modelCheckerTab.getSelectionIndex() == ONTHEFLY_MODELCHECKER) {
			return new OnTheFlyProbabilisticModelChecker<PopulationState>();
		} 
		if (modelCheckerTab.getSelectionIndex() == STATISTICAL_MODELCHECKER) {
			return new StatisticProbabilisticModelChecker<PopulationState>();
		}
		return null;
	}

	private void doModelCheckingOfStateFormulae() {
		ModelCheckerI<PopulationState> modelChecker = getModelChecker();
		String[] selectedFormulae = stateFormulae.getSelection();
		String selectedConfiguration = systems.getItem(systems.getSelectionIndex());
		PopulationState state = spec.getIndividualsConfiguration(selectedConfiguration);
		LinkedList<Pair<String, StateFormula<PopulationState>>> modelCheckingArguments = new LinkedList<Pair<String,StateFormula<PopulationState>>>();
		for (int i = 0; i < selectedFormulae.length; i++) {
			modelCheckingArguments.add(new Pair<String,StateFormula<PopulationState>>( selectedFormulae[i] , spec.getPopulationStateFormula(selectedFormulae[i])));
		}
		StateFormulaeSatisfactionCheckerJob<PopulationState> job = new StateFormulaeSatisfactionCheckerJob<PopulationState>(modelChecker, state, modelCheckingArguments);
		try {
			new ProgressMonitorDialog(main).run(true, true, job);
			SamProjectHelper.getModelCheckingView().addSatisfactionResults(selectedConfiguration , job.getResults());
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected boolean validate() {
		if (systems.getSelectionIndex()<0) {
			MessageDialog.openInformation(
					main,
					"SAM",
					"No configuration has been selected!");
			return false;
		}
		if (((formulaeTab.getSelectionIndex()==STATE_FORMULAE)&&(stateFormulae.getSelectionIndices().length==0))
				||((formulaeTab.getSelectionIndex()==PATH_FORMULAE)&&(pathFormulae.getSelectionIndices().length==0))){
			MessageDialog.openInformation(
					main,
					"SAM",
					"No formula has been selected!");
			return false;
		}
		if ((formulaeTab.getSelectionIndex() == PATH_PROBABILITIES)) {
			if (leftUntil.getSelectionIndex()<0) {
				MessageDialog.openInformation(
						main,
						"SAM",
						"No first formula has been selected!");
				return false;
			}
			if (rightUntil.getSelectionIndex()<0) {
				MessageDialog.openInformation(
						main,
						"SAM",
						"No second formula has been selected!");
				return false;
			}
			return true;
		}
		return true;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
