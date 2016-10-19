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
import org.cmg.ml.sam.jobs.StateFormulaeSatisfactionCheckerJob;
import org.cmg.ml.sam.population.FastSimulationState;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.layout.FillLayout;

public class TimeDependentSatisfationComposite extends Composite {
	
	public static enum ModelCheckingType {
		STATE_FORMULAE , 
		PATH_FORMULAE
	}
	
	private Combo systems;
	private PopulationSpecification spec;
	private Shell main;
	private ModelCheckingType type;
	private Combo stateFormulae;
	private Spinner from;
	private Spinner to;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TimeDependentSatisfationComposite(ModelCheckingType type , Shell main , Composite parent, PopulationSpecification spec ) {
		super(parent, SWT.NONE);
		this.spec = spec;
		this.main = main;
		this.type = type;
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
		
		Label lblFormulae = new Label(this, SWT.NONE);
		lblFormulae.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFormulae.setText("Formulae:");
		
		stateFormulae = new Combo(this, SWT.NONE);
		stateFormulae.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblFrom = new Label(this, SWT.NONE);
		lblFrom.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFrom.setText("From:");
		
		from = new Spinner(this, SWT.BORDER);
		from.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblTo = new Label(this, SWT.NONE);
		lblTo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTo.setText("To:");
		
		to = new Spinner(this, SWT.BORDER);
		to.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblPrecision = new Label(this, SWT.NONE);
		lblPrecision.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
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
				if (validate()) {
					main.close();					
				}
			}
		});
	}

	protected void scheduleModelCheckingJob() {
		int foo = systems.getSelectionIndex();
		if (foo < 0) {
			return ;
		}
//		PopulationState selectedConfiguration = spec.getFastSimulationConfiguration(name, time);
//		String selectedFormulae = stateFormulae.getSelection();
//		int selectedTab = tabFolder.getSelectionIndex();
//		if (type == ModelCheckingType.STATE_FORMULAE) {
//			doModelCheckingOfStateFormulae( selectedConfiguration , selectedFormulae , selectedTab );
//		} else {
//			doModelCheckingOfPathFormulae( selectedConfiguration , selectedFormulae , selectedTab );
////		}
	}

	private void doModelCheckingOfPathFormulae(String selectedConfiguration,
			String[] selectedFormulae, int selectedTab) {
		PathFormulaeSatisfactionCheckerJob<?> job = null;
		if (selectedTab == 0) {
			job = createPopulationStatePathModelCheckingJob( new OnTheFlyProbabilisticModelChecker<PopulationState>(true) , selectedConfiguration , selectedFormulae );
		} else if (selectedTab == 1) {
			job = createFastSimulationStatePathModelCheckingJob( new OnTheFlyProbabilisticModelChecker<FastSimulationState>(true), selectedConfiguration , selectedFormulae);
		} else if (selectedTab == 2) {
			job = createPopulationStatePathModelCheckingJob( new StatisticProbabilisticModelChecker<PopulationState>() , selectedConfiguration , selectedFormulae );
		}
		if (job != null) {
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
	}

	private PathFormulaeSatisfactionCheckerJob<?> createFastSimulationStatePathModelCheckingJob(
			ModelCheckerI<FastSimulationState> modelChecker,
			String selectedConfiguration, String[] selectedFormulae) {
		FastSimulationState state = spec.getFastSimulationConfiguration(selectedConfiguration);
		LinkedList<Pair<String, PathFormula<FastSimulationState>>> modelCheckingArguments = new LinkedList<Pair<String,PathFormula<FastSimulationState>>>();
		for (int i = 0; i < selectedFormulae.length; i++) {
			modelCheckingArguments.add(new Pair<String,PathFormula<FastSimulationState>>( selectedFormulae[i] , spec.getFastSimulationPathFormula(selectedFormulae[i])));
		}
		return new PathFormulaeSatisfactionCheckerJob<FastSimulationState>(modelChecker, state, modelCheckingArguments);
	}

	private PathFormulaeSatisfactionCheckerJob<?> createPopulationStatePathModelCheckingJob(
			ModelCheckerI<PopulationState> modelChecker,
			String selectedConfiguration, String[] selectedFormulae) {
		PopulationState state = spec.getIndividualsConfiguration(selectedConfiguration);
		LinkedList<Pair<String, PathFormula<PopulationState>>> modelCheckingArguments = new LinkedList<Pair<String,PathFormula<PopulationState>>>();
		for (int i = 0; i < selectedFormulae.length; i++) {
			modelCheckingArguments.add(new Pair<String,PathFormula<PopulationState>>( selectedFormulae[i] , spec.getPopulationPathFormula(selectedFormulae[i])));
		}
		return new PathFormulaeSatisfactionCheckerJob<PopulationState>(modelChecker, state, modelCheckingArguments);
	}

	private void doModelCheckingOfStateFormulae(String selectedConfiguration,
			String[] selectedFormulae, int selectedTab) {
		StateFormulaeSatisfactionCheckerJob<?> job = null;
		if (selectedTab == 0) {
			job = createPopulationStateModelCheckingJob( new OnTheFlyProbabilisticModelChecker<PopulationState>(true) , selectedConfiguration , selectedFormulae );
		} else if (selectedTab == 1) {
			job = createFastSimulationStateModelCheckingJob( new OnTheFlyProbabilisticModelChecker<FastSimulationState>(true), selectedConfiguration , selectedFormulae);
		} else if (selectedTab == 2) {
			job = createPopulationStateModelCheckingJob( new StatisticProbabilisticModelChecker<PopulationState>() , selectedConfiguration , selectedFormulae );
		}
		if (job != null) {
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
	}

	private StateFormulaeSatisfactionCheckerJob<FastSimulationState> createFastSimulationStateModelCheckingJob(ModelCheckerI<FastSimulationState> modelChecker , String selectedConfiguration,
			String[] selectedFormulae) {
		FastSimulationState state = spec.getFastSimulationConfiguration(selectedConfiguration);
		LinkedList<Pair<String, StateFormula<FastSimulationState>>> modelCheckingArguments = new LinkedList<Pair<String,StateFormula<FastSimulationState>>>();
		for (int i = 0; i < selectedFormulae.length; i++) {
			modelCheckingArguments.add(new Pair<String,StateFormula<FastSimulationState>>( selectedFormulae[i] , spec.getFastSimulationStateFormula(selectedFormulae[i])));
		}
		return new StateFormulaeSatisfactionCheckerJob<FastSimulationState>(modelChecker, state, modelCheckingArguments);
	}

	private StateFormulaeSatisfactionCheckerJob<PopulationState> createPopulationStateModelCheckingJob(ModelCheckerI<PopulationState> modelChecker , String selectedConfiguration,
			String[] selectedFormulae) {
		PopulationState state = spec.getIndividualsConfiguration(selectedConfiguration);
		LinkedList<Pair<String, StateFormula<PopulationState>>> modelCheckingArguments = new LinkedList<Pair<String,StateFormula<PopulationState>>>();
		for (int i = 0; i < selectedFormulae.length; i++) {
			modelCheckingArguments.add(new Pair<String,StateFormula<PopulationState>>( selectedFormulae[i] , spec.getPopulationStateFormula(selectedFormulae[i])));
		}
		return new StateFormulaeSatisfactionCheckerJob<PopulationState>(modelChecker, state, modelCheckingArguments);
	}	

	protected boolean validate() {
		if (systems.getSelectionIndex()<0) {
			MessageDialog.openInformation(
					main,
					"SAM",
					"No configuration has been selected!");
			return false;
		}
		if (stateFormulae.getSelectionIndex()<0) {
			MessageDialog.openInformation(
					main,
					"SAM",
					"No formula has been selected!");
			return false;
		}
		if (from.getSelection()>=to.getSelection()) {
			MessageDialog.openInformation(
					main,
					"SAM",
					"The selected interval is not valid!");
			return false;
		}
		return true;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
