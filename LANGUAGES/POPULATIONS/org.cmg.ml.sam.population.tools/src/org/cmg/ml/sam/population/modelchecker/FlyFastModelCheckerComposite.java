package org.cmg.ml.sam.population.modelchecker;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;

import org.cmg.ml.sam.SamProjectHelper;
import org.cmg.ml.sam.core.logic.ModelCheckerI;
import org.cmg.ml.sam.core.logic.PathFormula;
import org.cmg.ml.sam.core.logic.StateFormula;
import org.cmg.ml.sam.core.mc.pomc.OnTheFlyProbabilisticModelChecker;
import org.cmg.ml.sam.core.mc.stat.StatisticProbabilisticModelChecker;
import org.cmg.ml.sam.core.sim.SimulationSeries;
import org.cmg.ml.sam.jobs.PathFormulaeSatisfactionCheckerJob;
import org.cmg.ml.sam.jobs.PathProbabilityComputationJob;
import org.cmg.ml.sam.jobs.StateFormulaeSatisfactionCheckerJob;
import org.cmg.ml.sam.population.FastSimulationState;
import org.cmg.ml.sam.population.PopulationSpecification;
import org.cmg.ml.sam.population.PopulationState;
import org.cmg.ml.sam.util.Pair;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

public class FlyFastModelCheckerComposite extends Composite {
	
	private static int ONTHEFLY_MODELCHECKER = 0;
	private static int STATISTICAL_MODELCHECKER = 1;

	private static int STATE_FORMULAE = 0;
	private static int PATH_FORMULAE = 1;
	private static int SATISFACTION_INTERVALS = 2;
	private static int PATH_PROBABILITIES = 3;
	
	private Combo systems;
	private PopulationSpecification spec;
	private Shell main;
	private List stateFormulae;
	private List pathFormulae;
	private Text[] occupancies;
	private Button btnOccupancyFromSystem;
	private Button btnFastState;
	private TabFolder toolSelection;
	private Combo stateOfIndividual;
	private Combo leftUntil;
	private Combo rightUntil;
	private Spinner stepLimit;
	private Combo intervalFormula;
	private Spinner fromInterval;
	private Spinner toInterval;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public FlyFastModelCheckerComposite(Shell main , Composite parent, PopulationSpecification spec ) {
		super(parent, SWT.NONE);
		this.spec = spec;
		this.main = main;
		init();
	}
	
	private void init() {
		setLayout(new GridLayout(2, false));
		
		Composite composite = new Composite(this, SWT.BORDER);
		composite.setLayout(new GridLayout(5, false));
		GridData gd_composite = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
//		gd_composite.widthHint = 494;
//		gd_composite.heightHint = 263;
		composite.setLayoutData(gd_composite);
		new Label(composite, SWT.NONE);
		
		btnOccupancyFromSystem = new Button(composite, SWT.RADIO);
		btnOccupancyFromSystem.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 4, 1));
		btnOccupancyFromSystem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnOccupancyFromSystem.setText("Fast state from a declared system");
		btnOccupancyFromSystem.setSelection(true);
		
		Composite composite_4 = new Composite(composite, SWT.BORDER);
		composite_4.setLayout(new GridLayout(1, false));
		composite_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
		
		systems = new Combo(composite_4, SWT.NONE);
		systems.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		systems.setToolTipText("The system to verify.");
		systems.setItems(spec.getConfigurationNames());
		new Label(composite, SWT.NONE);
		
		btnFastState = new Button(composite, SWT.RADIO);
		btnFastState.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 4, 1));
		btnFastState.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnFastState.setText("State and occupancy measure");
		
		Composite composite_5 = new Composite(composite, SWT.BORDER);
		composite_5.setLayout(new GridLayout(2, false));
		GridData gd_composite_5 = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
		gd_composite_5.heightHint = 161;
		composite_5.setLayoutData(gd_composite_5);
		
		Group grpOccupancy = new Group(composite_5, SWT.NONE);
		grpOccupancy.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		grpOccupancy.setText("Occupancy");
		grpOccupancy.setLayout(new GridLayout(1, false));
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(grpOccupancy, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		GridData gd_scrolledComposite = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_scrolledComposite.heightHint = 54;
		scrolledComposite.setLayoutData(gd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		
		
		Composite composite_3 = new Composite(scrolledComposite, SWT.NONE);
		composite_3.setLayout(new GridLayout(2, false));

		String[] localStates = spec.getStates();
		occupancies = new Text[localStates.length];
		
		String initialOccupancy = "1.0";
		for( int i=0 ; i<localStates.length ; i++ ) {
			final int textIndex = i;
			Label lblState = new Label(composite_3,SWT.NONE);
			lblState.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblState.setText(localStates[i]+":");
			occupancies[i] = new Text(composite_3, SWT.BORDER);
			occupancies[i].setText(initialOccupancy);
			initialOccupancy = "0.0";
			occupancies[i].setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			occupancies[i].addModifyListener( new ModifyListener() {
				
				@Override
				public void modifyText(ModifyEvent e) {
					try {
						Double.parseDouble(occupancies[textIndex].getText());
						occupancies[textIndex].setBackground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
					} catch (NumberFormatException ex) {
						occupancies[textIndex].setBackground(getDisplay().getSystemColor(SWT.COLOR_RED));
					}
				}

			});
		}
		
//		Label lblS = new Label(composite_3, SWT.NONE);
//		lblS.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
//		lblS.setText("S");
//		
//		text = new Text(composite_3, SWT.BORDER);
//		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
//		
//		Label lblE = new Label(composite_3, SWT.NONE);
//		lblE.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
//		lblE.setText("E");
//		
//		text_1 = new Text(composite_3, SWT.BORDER);
//		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
//		
//		Label lblI = new Label(composite_3, SWT.NONE);
//		lblI.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
//		lblI.setText("I");
//		
//		text_2 = new Text(composite_3, SWT.BORDER);
//		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
//		
//		Label lblR = new Label(composite_3, SWT.NONE);
//		lblR.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
//		lblR.setText("R");
//		
//		text_3 = new Text(composite_3, SWT.BORDER);
//		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		scrolledComposite.setContent(composite_3);
		scrolledComposite.setMinSize(composite_3.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		


		Label lblState_1 = new Label(composite_5, SWT.NONE);
		lblState_1.setText("State:");
		
		stateOfIndividual = new Combo(composite_5, SWT.NONE);
		stateOfIndividual.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		stateOfIndividual.setItems(spec.getStates());





		toolSelection = new TabFolder(this, SWT.NONE);
		GridData gd_toolSelection = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
		//gd_toolSelection.heightHint = 186;
		toolSelection.setLayoutData(gd_toolSelection);
		
		TabItem tbtmStateFomulae = new TabItem(toolSelection, SWT.NONE);
		tbtmStateFomulae.setText("State Fomulae");
		
		Composite stateFormulaeComposite = new Composite(toolSelection, SWT.NONE);
		tbtmStateFomulae.setControl(stateFormulaeComposite);
		stateFormulaeComposite.setLayout(new GridLayout(1, false));
		
		stateFormulae = new List(stateFormulaeComposite, SWT.BORDER);
		GridData gd_stateFormulae = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		//gd_stateFormulae.heightHint = 148;
		stateFormulae.setLayoutData(gd_stateFormulae);
		stateFormulae.setItems(spec.getStateFormulae());
		
		TabItem tbtmPathFormulae = new TabItem(toolSelection, SWT.NONE);
		tbtmPathFormulae.setText("Path Formulae");
		
		Composite pathFormulaeComposite = new Composite(toolSelection, SWT.NONE);
		tbtmPathFormulae.setControl(pathFormulaeComposite);
		pathFormulaeComposite.setLayout(new GridLayout(1, false));
		
		pathFormulae = new List(pathFormulaeComposite, SWT.BORDER);
		GridData gd_pathFormulae = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		//gd_pathFormulae.heightHint = 149;
		pathFormulae.setLayoutData(gd_pathFormulae);
		pathFormulae.setItems(spec.getPathFormulae());
		
		TabItem tbtmSatisfactionIntervals = new TabItem(toolSelection, SWT.NONE);
		tbtmSatisfactionIntervals.setText("Time dependent satisfaction");

		TabItem tbtmPathProbabilities = new TabItem(toolSelection, SWT.NONE);
		tbtmPathProbabilities.setText("Path Probabilities");
		
		Composite pathProbabilityComposite = new Composite(toolSelection, SWT.NONE);
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
		stepLimit.setMinimum(0);
		
		
		Composite satIntervalComposite = new Composite(toolSelection, SWT.NONE);
		tbtmSatisfactionIntervals.setControl(satIntervalComposite);
		satIntervalComposite.setLayout(new GridLayout(2, false));
		
		Label lblPathFormula = new Label(satIntervalComposite, SWT.NONE);
		lblPathFormula.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPathFormula.setText("Path Formula:");
		
		intervalFormula = new Combo(satIntervalComposite, SWT.NONE);
		intervalFormula.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		intervalFormula.setItems(spec.getPathFormulae());
		
		Label lblFrom = new Label(satIntervalComposite, SWT.NONE);
		lblFrom.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFrom.setText("From:");
		
		fromInterval = new Spinner(satIntervalComposite, SWT.BORDER);
		fromInterval.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		fromInterval.setMinimum(0);
		fromInterval.setMaximum(Integer.MAX_VALUE);
		
		Label lblTo = new Label(satIntervalComposite, SWT.NONE);
		lblTo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTo.setText("To:");
		
		toInterval = new Spinner(satIntervalComposite, SWT.BORDER);
		toInterval.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		toInterval.setMaximum(Integer.MAX_VALUE);
		toInterval.setMinimum(0);
		
		Label lblPrecision = new Label(this, SWT.NONE);
		lblPrecision.setText("Precision:");
		
		Spinner onTheFlyPrecision = new Spinner(this, SWT.BORDER);
		onTheFlyPrecision.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		onTheFlyPrecision.setMaximum(100000000);
		onTheFlyPrecision.setMinimum(1);
		onTheFlyPrecision.setDigits(9);
		
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
		if (toolSelection.getSelectionIndex() ==  STATE_FORMULAE) {
			doModelCheckingOfStateFormulae( );
		} 
		if (toolSelection.getSelectionIndex() == PATH_FORMULAE) {
			doModelCheckingOfPathFormulae( );
		}
		if (toolSelection.getSelectionIndex() == SATISFACTION_INTERVALS) {
			doComputeSatisfactionIntervals();
		}
		if (toolSelection.getSelectionIndex() == PATH_PROBABILITIES) {
			doComputePathProbabilities();
		}
	}

	private void doModelCheckingOfPathFormulae( ) {
		ModelCheckerI<FastSimulationState> modelChecker = getModelChecker();
		String[] selectedFormulae = pathFormulae.getSelection();
		String selectedConfiguration = systems.getItem(systems.getSelectionIndex());
		FastSimulationState state = getFastSimulationState();
		LinkedList<Pair<String, PathFormula<FastSimulationState>>> modelCheckingArguments = new LinkedList<Pair<String,PathFormula<FastSimulationState>>>();
		for (int i = 0; i < selectedFormulae.length; i++) {
			modelCheckingArguments.add(new Pair<String,PathFormula<FastSimulationState>>( selectedFormulae[i] , spec.getFastSimulationPathFormula(selectedFormulae[i])));
		}
		PathFormulaeSatisfactionCheckerJob<FastSimulationState> job = new PathFormulaeSatisfactionCheckerJob<FastSimulationState>(modelChecker, state, modelCheckingArguments);
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

	private FastSimulationState getFastSimulationState() {
		if (btnOccupancyFromSystem.getSelection()) {
			String selectedConfiguration = systems.getItem(systems.getSelectionIndex());
			return spec.getFastSimulationConfiguration(selectedConfiguration);
		} else {
			double[] occupancyVector = getOccupancy();
			int state = stateOfIndividual.getSelectionIndex();
			return spec.getFastSimulationConfiguation( state , occupancyVector );
		}
	}

	private FastSimulationState[] getFastSimulationStates() {
		if (btnOccupancyFromSystem.getSelection()) {
			String selectedConfiguration = systems.getItem(systems.getSelectionIndex());
			return spec.getFastSimulationConfigurations(selectedConfiguration,fromInterval.getSelection(),toInterval.getSelection());
		} else {
			double[] occupancyVector = getOccupancy();
			int state = stateOfIndividual.getSelectionIndex();
			return spec.getFastSimulationConfiguations( state , occupancyVector , fromInterval.getSelection() , toInterval.getSelection() );
		}
	}

	private double[] getOccupancy() {
		double[] occupancyVector = new double[occupancies.length];
		for( int i=0 ; i<occupancies.length ; i++ ) {
			occupancyVector[i] = getOccupancyOf( i );
		}
		return occupancyVector;
	}

	private double getOccupancyOf(int i) {
		try {
			return Double.parseDouble(occupancies[i].getText());
		} catch (NumberFormatException e) {
			return 0.0;
		}
	}

	private ModelCheckerI<FastSimulationState> getModelChecker() {
		return new OnTheFlyProbabilisticModelChecker<FastSimulationState>();
	}

	private void doModelCheckingOfStateFormulae() {
		ModelCheckerI<FastSimulationState> modelChecker = getModelChecker();
		String[] selectedFormulae = stateFormulae.getSelection();
		String selectedConfiguration = systems.getItem(systems.getSelectionIndex());
		FastSimulationState state = getFastSimulationState();
		LinkedList<Pair<String, StateFormula<FastSimulationState>>> modelCheckingArguments = new LinkedList<Pair<String,StateFormula<FastSimulationState>>>();
		for (int i = 0; i < selectedFormulae.length; i++) {
			modelCheckingArguments.add(new Pair<String,StateFormula<FastSimulationState>>( selectedFormulae[i] , spec.getFastSimulationStateFormula(selectedFormulae[i])));
		}
		StateFormulaeSatisfactionCheckerJob<FastSimulationState> job = new StateFormulaeSatisfactionCheckerJob<FastSimulationState>(modelChecker, state, modelCheckingArguments);
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

	private void doComputePathProbabilities() {
		ModelCheckerI<FastSimulationState> modelChecker = getModelChecker();
		FastSimulationState state = getFastSimulationState();
		String left = leftUntil.getItem(leftUntil.getSelectionIndex());
		String right = rightUntil.getItem(rightUntil.getSelectionIndex());
		StateFormula<FastSimulationState> firstFormula = spec.getFastSimulationStateFormula(left);
		StateFormula<FastSimulationState> secondFormula = spec.getFastSimulationStateFormula(right);
		int deadline = stepLimit.getSelection();
		PathProbabilityComputationJob<FastSimulationState> job = new PathProbabilityComputationJob<FastSimulationState>(  modelChecker , state , firstFormula , secondFormula , deadline , 1.0 );
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
			SamProjectHelper.getGraphView().addGraph("[FlyFast]" , (left+" U<=t "+right) , job.getProbabilities() , 1.0 );
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doComputeSatisfactionIntervals() {
		ModelCheckerI<FastSimulationState> modelChecker = getModelChecker();
		FastSimulationState[] states = getFastSimulationStates();
		String formula = intervalFormula.getItem(intervalFormula.getSelectionIndex());
		SatIntervalComputationJob job = new SatIntervalComputationJob(  modelChecker , states , spec.getFastSimulationPathFormula(formula) , fromInterval.getSelection() , toInterval.getSelection() );
		try {
			new ProgressMonitorDialog(main).run(true, true, job);
			double[] probabilities = job.getProbabilities();
			MessageBox dialog = new MessageBox(main, SWT.ICON_QUESTION | SWT.YES| SWT.NO);
			dialog.setText("Dave data");
			dialog.setMessage("Do you save data into an external folder?");					
			if (dialog.open() == SWT.YES) {
				DirectoryDialog fileDialog = new DirectoryDialog(main);
				String file = fileDialog.open();
				SamProjectHelper.saveProbabilityData(file,probabilities,fromInterval.getSelection() , 1.0);
			}
			SamProjectHelper.getGraphView().addGraph("["+fromInterval.getSelection()+","+toInterval.getSelection()+"]" , formula , probabilities , fromInterval.getSelection() , 1.0 );
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected boolean validate() {
		if ((btnOccupancyFromSystem.getSelection())&&(systems.getSelectionIndex()<0)) {
			MessageDialog.openInformation(
					main,
					"SAM",
					"No configuration has been selected!");
			return false;
		}
		try {
			if ((btnFastState.getSelection())&&(!validateOccupanciesText())) {
				MessageDialog.openInformation(
						main,
						"SAM",
						"The sum of all occupancy must be 1.0!");
				return false;
			}
			if ((btnFastState.getSelection())&&(stateOfIndividual.getSelectionIndex()<0)) {
				MessageDialog.openInformation(
						main,
						"SAM",
						"Select a state for the individual!");
				return false;
			}
		} catch (NumberFormatException e) {
			MessageDialog.openInformation(
					main,
					"SAM",
					"Only real values are valid for occupancies!");
			return false;
		}
		if (((toolSelection.getSelectionIndex()==STATE_FORMULAE)&&(stateFormulae.getSelectionIndices().length==0))
				||((toolSelection.getSelectionIndex()==PATH_FORMULAE)&&(pathFormulae.getSelectionIndices().length==0))){
			MessageDialog.openInformation(
					main,
					"SAM",
					"No formula has been selected!");
			return false;
		}
		if ((toolSelection.getSelectionIndex() == PATH_PROBABILITIES)) {
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
		if ((toolSelection.getSelectionIndex() == SATISFACTION_INTERVALS)) {
			if (intervalFormula.getSelectionIndex()<0) {
				MessageDialog.openInformation(
						main,
						"SAM",
						"No formula has been selected!");
				return false;
			}
			if (fromInterval.getSelection()>toInterval.getSelection()) {
				MessageDialog.openInformation(
						main,
						"SAM",
						"Invalid interval!");
				return false;
			}
			return true;
		}
		return true;
	}

	private boolean validateOccupanciesText() {
		double value = 0.0;
		for( int i=0 ; i<occupancies.length ; i++ ) {
			value += Double.parseDouble(occupancies[i].getText());
		}
		return (value == 1.0);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
