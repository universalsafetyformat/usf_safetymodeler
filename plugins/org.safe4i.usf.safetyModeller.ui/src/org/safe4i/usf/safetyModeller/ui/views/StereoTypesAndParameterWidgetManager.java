/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.views;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.eef.common.ui.api.EEFWidgetFactory;
import org.eclipse.eef.common.ui.api.IEEFFormContainer;
import org.eclipse.eef.ide.ui.api.widgets.IEEFLifecycleManager;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.sirius.diagram.ui.edit.api.part.IDiagramElementEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.ui.forms.widgets.Section;
import org.safe4i.usf.core.usfmodel.block.Block;
import org.safe4i.usf.core.usfmodel.block.BlockType;
import org.safe4i.usf.core.usfmodel.block.Connection;
import org.safe4i.usf.core.usfmodel.block.Port;
import org.safe4i.usf.core.usfmodel.common.CommonsPackage;
import org.safe4i.usf.core.usfmodel.common.NamedElement;
import org.safe4i.usf.core.usfmodel.parameter.BasePrimitiveParameterDefinition;
import org.safe4i.usf.core.usfmodel.parameter.ParameterAssignment;
import org.safe4i.usf.core.usfmodel.parameter.ParameterDefinition;
import org.safe4i.usf.core.usfmodel.parameter.ParametersFactory;
import org.safe4i.usf.core.usfmodel.parameter.ParametersPackage;
import org.safe4i.usf.core.usfmodel.parameter.PrimitiveParameterValue;
import org.safe4i.usf.core.usfmodel.parameter.Stereotype;
import org.safe4i.usf.core.usfmodel.parameter.StereotypeAssignment;
import org.safe4i.usf.core.usfmodel.portTemplate.TemplateAssignment;
import org.safe4i.usf.safetyModeller.ui.Activator;
import org.safe4i.usf.safetyModeller.ui.contentprovider.StereotypesParameterTreeContentProvider;
import org.safe4i.usf.safetyModeller.ui.contentprovider.model.VirtualStereotypeTreeItem;
import org.safe4i.usf.safetyModeller.ui.contentprovider.model.VirtualTree;
import org.safe4i.usf.safetyModeller.ui.labelprovider.StereotypesParametersTreeLabelProvider;

/**
 * @author Hamza
 *
 */
public class StereoTypesAndParameterWidgetManager implements IEEFLifecycleManager, ISelectionListener {

	private static final String EMPTY_SELECTION_MESSAGE = "Please select a Block, BlockType, Port or Connection!";

	private final static ImageDescriptor IMG_STEREOTYPE_ADD = org.eclipse.jface.resource.ResourceLocator
			.imageDescriptorFromBundle(Activator.PLUGIN_ID, "icons/16x16/icons/tag_add.png").orElse(null);
	private final static ImageDescriptor IMG_PARAMETER_ADD = org.eclipse.jface.resource.ResourceLocator
			.imageDescriptorFromBundle(Activator.PLUGIN_ID, "icons/16x16/icons/page_white_add.png").orElse(null);
	private final static ImageDescriptor IMG_DELETE = org.eclipse.jface.resource.ResourceLocator
			.imageDescriptorFromBundle(Activator.PLUGIN_ID, "icons/16x16/icons/cross.png").orElse(null);

	private final IWorkbench workbench;
	private final ISelectionService selectionService;

	private final VirtualTree virtualTree = new VirtualTree();
	private final StereotypesParametersTreeLabelProvider labelProvider = new StereotypesParametersTreeLabelProvider();
	private TreeViewer treeViewer;
	private EObject semanticObject;
	// private Section section;
	private Composite main;
	private Action addStereotypeAction;
	private Action addParameterAction;
	private Action deleteAction;

	public StereoTypesAndParameterWidgetManager() {
		this.workbench = PlatformUI.getWorkbench();
		this.selectionService = workbench.getActiveWorkbenchWindow().getSelectionService();
		this.selectionService.addSelectionListener(this);
	}

	@Override
	public void createControl(Composite parent, IEEFFormContainer formContainer) {
		createPartControl(parent, formContainer);
	}

	@Override
	public void aboutToBeHidden() {

	}

	@Override
	public void aboutToBeShown() {

	}

	@Override
	public void dispose() {
		// this.selectionService.removeSelectionListener(this);
	}

	@Override
	public void refresh() {
		updateSemanticObject();
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (selection instanceof StructuredSelection && !selection.isEmpty()) {
			final Object sel = ((StructuredSelection) selection).getFirstElement();
			if (sel instanceof IDiagramElementEditPart) {
				final IDiagramElementEditPart editPart = (IDiagramElementEditPart) sel;
				semanticObject = editPart.resolveTargetSemanticElement();
			} else if (sel instanceof EObject) {
				semanticObject = (EObject) sel;
			} else {
				semanticObject = null;
			}
		}
	}

	private void createPartControl(Composite parent, IEEFFormContainer formContainer) {
		final EEFWidgetFactory widgetFactory = formContainer.getWidgetFactory();

		this.main = parent;

		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		main.setLayout(gridLayout);

		final Section toolBarSection = widgetFactory.createSection(main, SWT.NONE);
		toolBarSection.setLayout(new RowLayout());
		contributeToActionBars(toolBarSection);

		treeViewer = new TreeViewer(main, SWT.SINGLE | SWT.FULL_SELECTION | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		GridDataFactory.fillDefaults().grab(true, true).indent(-5, -5).applyTo(treeViewer.getTree());
		treeViewer.setContentProvider(new StereotypesParameterTreeContentProvider());
		final GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		gridData.horizontalSpan = 2;
		treeViewer.getTree().setLayoutData(gridData);
		treeViewer.getTree().setHeaderVisible(true);
		treeViewer.getTree().setLinesVisible(true);

		final TreeViewerColumn nameColumn = new TreeViewerColumn(treeViewer, SWT.LEFT);
		nameColumn.setLabelProvider(labelProvider);
		nameColumn.getColumn().setText("Name");
		nameColumn.getColumn().setWidth(300);

		final TreeViewerColumn valueColumn = new TreeViewerColumn(treeViewer, SWT.LEFT);
		valueColumn.setLabelProvider(labelProvider);
		valueColumn.getColumn().setText("Value");
		valueColumn.getColumn().setWidth(500);
		valueColumn.setEditingSupport(new StereoTypesAndParameterEditingSupport(treeViewer));

		treeViewer.setInput(virtualTree);

	}

	private void contributeToActionBars(Section parent) {
		makeActions();

		final ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		final ToolBar toolbar = toolBarManager.createControl(parent);
		toolbar.setCursor(Display.getCurrent().getSystemCursor(SWT.CURSOR_HAND));
		parent.setTextClient(toolbar);
		fillToolBar(toolBarManager);
		toolBarManager.update(true);

	}

	private void fillToolBar(ToolBarManager toolBarManager) {
		toolBarManager.add(addStereotypeAction);
		toolBarManager.add(addParameterAction);
		toolBarManager.add(new Separator());
		toolBarManager.add(deleteAction);
	}

	private void resetVitualTree() {
		virtualTree.reset();
	}

	private List<ParameterDefinition> getModelParameters() {
		if (semanticObject == null) {
			return Collections.emptyList();
		}

		return ModelHelper.INSTANCE.getAllElements(semanticObject) //
				.filter(e -> e instanceof ParameterDefinition) //
				.map(s -> (ParameterDefinition) s) //
				.collect(Collectors.toList());
	}

	private List<Stereotype> getModelStereotypes() {
		if (semanticObject == null) {
			return Collections.emptyList();
		}

		return ModelHelper.INSTANCE.getAllElements(semanticObject) //
				.filter(e -> e instanceof Stereotype) //
				.map(s -> (Stereotype) s) //
				.collect(Collectors.toList());
	}

	private void makeActions() {

		addStereotypeAction = new Action("Add Stereotype", IMG_STEREOTYPE_ADD) {
			@Override
			public void run() {
				if (!isObjectOfInterest(semanticObject) || semanticObject == null) {
					MessageDialog.openInformation(main.getShell(), "Info", EMPTY_SELECTION_MESSAGE);
					return;
				}

				final SelectionDialog selectionDialog = new ListSelectionDialog(main.getShell(), getModelStereotypes(), ArrayContentProvider.getInstance(),
						new LabelProvider() {
							@Override
							public String getText(Object element) {
								if (element instanceof NamedElement) {
									return ((NamedElement) element).getName();
								}
								return super.getText(element);
							}
						}, "Please select one or more Stereotype!");
				final List<Stereotype> preselection = ModelHelper.INSTANCE.collectStereotypeAssignments(semanticObject).stream()
						.flatMap(sa -> sa.getAssignedStereotypes().stream()).collect(Collectors.toList());
				selectionDialog.setInitialElementSelections(preselection);

				if (selectionDialog.open() == IDialogConstants.OK_ID) {
					final List<Stereotype> result = Arrays.asList(selectionDialog.getResult()).stream() //
							.filter(o -> o instanceof Stereotype) //
							.map(o -> (Stereotype) o).collect(Collectors.toList());
					result.removeAll(preselection);
					addStereotypes(semanticObject, result);
				}
				updateSemanticObject();
			}
		};

		addParameterAction = new Action("Add Parameter", IMG_PARAMETER_ADD) {
			@Override
			public void run() {
				if (!isObjectOfInterest(semanticObject) || semanticObject == null) {
					MessageDialog.openInformation(main.getShell(), "Info", EMPTY_SELECTION_MESSAGE);
					return;
				}

				final SelectionDialog selectionDialog = new ListSelectionDialog(main.getShell(), getModelParameters(), ArrayContentProvider.getInstance(),
						new LabelProvider() {
							@Override
							public String getText(Object element) {
								if (element instanceof NamedElement) {
									return ((NamedElement) element).getName();
								}
								return super.getText(element);
							}
						}, "Please select one or more Parameter!");
				final List<ParameterDefinition> preselection = ModelHelper.INSTANCE.collectParameterAssignments(semanticObject).stream()
						.flatMap(pa -> pa.getValues().stream()).map(pv -> getParameter(pv)).collect(Collectors.toList());
				selectionDialog.setInitialElementSelections(preselection);

				if (selectionDialog.open() == IDialogConstants.OK_ID) {
					final List<ParameterDefinition> result = Arrays.asList(selectionDialog.getResult()).stream() //
							.filter(o -> o instanceof ParameterDefinition) //
							.map(o -> (ParameterDefinition) o).collect(Collectors.toList());
					result.removeAll(preselection);
					addParameters(semanticObject, result);
				}
				updateSemanticObject();
			}

			private ParameterDefinition getParameter(PrimitiveParameterValue pv) {
				return pv.getParameter();
			};
		};

		deleteAction = new Action("Remove", IMG_DELETE) {
			@Override
			public void run() {
				final ITreeSelection selection = treeViewer.getStructuredSelection();
				if (!selection.isEmpty()) {
					final Object semanticSelection = selection.getFirstElement();
					if (semanticSelection instanceof VirtualStereotypeTreeItem) {
						final StereotypeAssignment assignment = ((VirtualStereotypeTreeItem) semanticSelection).getContext();
						final EditingDomain editDomain = ModelHelper.INSTANCE.getEditingDomain(assignment);
						final RemoveCommand removeCmd = new RemoveCommand(editDomain, ModelHelper.INSTANCE.getModel(assignment),
								CommonsPackage.eINSTANCE.getModel_Content(), assignment);
						editDomain.getCommandStack().execute(removeCmd);
					} else if (semanticSelection instanceof PrimitiveParameterValue) {
						final PrimitiveParameterValue val = (PrimitiveParameterValue) semanticSelection;
						final EObject container = val.eContainer();
						if (container instanceof ParameterAssignment) {
							final EditingDomain editDomain = ModelHelper.INSTANCE.getEditingDomain(container);
							final RemoveCommand remCmd = new RemoveCommand(editDomain, ModelHelper.INSTANCE.getModel(container),
									CommonsPackage.eINSTANCE.getModel_Content(), container);
							editDomain.getCommandStack().execute(remCmd);
						} else if (container instanceof StereotypeAssignment) {
							final EditingDomain editDomain = ModelHelper.INSTANCE.getEditingDomain(container);
							final SetCommand setCmd = new SetCommand(editDomain, (EObject) semanticSelection,
									ParametersPackage.eINSTANCE.getPrimitiveParameterValue_Value(), null);
							editDomain.getCommandStack().execute(setCmd);
						}
					}
					updateSemanticObject();
				}
			}
		};
	}

	/**
	 * we are only interested in Block, BlockType, Port and Connection as semantic context
	 * 
	 * @param obj
	 *            object to test
	 * @return true, if the object is interesting
	 */
	private boolean isObjectOfInterest(Object obj) {
		return obj instanceof Block || obj instanceof BlockType || obj instanceof Port || obj instanceof Connection;
	}

	private void updateSemanticObject() {

		resetVitualTree();

		if (!isObjectOfInterest(semanticObject) || semanticObject == null) {
			return;
		}
		if (semanticObject instanceof Block) {
			collectParameterValues((Block) semanticObject);
		} else if (semanticObject instanceof BlockType) {
			collectParameterValues((BlockType) semanticObject);
		} else if (semanticObject instanceof Port) {
			collectParameterValues((Port) semanticObject);
		} else if (semanticObject instanceof Connection) {
			collectParameterValues((Connection) semanticObject);
		}

		treeViewer.refresh();
		treeViewer.expandAll();
	}

	private void collectParameterValues(Block block) {
		final List<StereotypeAssignment> stereotypeAssignments = ModelHelper.INSTANCE.collectStereotypeAssignments(block);
		final List<? extends ParameterAssignment> parameterAssignments = ModelHelper.INSTANCE.collectParameterAssignments(block);
		final List<TemplateAssignment> templateAssignments = ModelHelper.INSTANCE.collectTemplateAssignments(block);

		virtualTree.update(stereotypeAssignments, parameterAssignments, templateAssignments);
	}

	private void collectParameterValues(BlockType blockType) {
		final List<StereotypeAssignment> stereotypeAssignments = ModelHelper.INSTANCE.collectStereotypeAssignments(blockType);
		final List<? extends ParameterAssignment> parameterAssignments = ModelHelper.INSTANCE.collectParameterAssignments(blockType);
		final List<TemplateAssignment> templateAssignments = ModelHelper.INSTANCE.collectTemplateAssignments(blockType);

		virtualTree.update(stereotypeAssignments, parameterAssignments, templateAssignments);
	}

	private void collectParameterValues(Port port) {
		final List<StereotypeAssignment> stereotypeAssignments = ModelHelper.INSTANCE.collectStereotypeAssignments(port);
		final List<? extends ParameterAssignment> parameterAssignments = ModelHelper.INSTANCE.collectParameterAssignments(port);
		final List<TemplateAssignment> templateAssignments = new LinkedList<>();

		virtualTree.update(stereotypeAssignments, parameterAssignments, templateAssignments);
	}

	private void collectParameterValues(Connection connection) {
		final List<StereotypeAssignment> stereotypeAssignments = ModelHelper.INSTANCE.collectStereotypeAssignments(connection);
		final List<? extends ParameterAssignment> parameterAssignments = ModelHelper.INSTANCE.collectParameterAssignments(connection);
		final List<TemplateAssignment> templateAssignments = new LinkedList<>();

		virtualTree.update(stereotypeAssignments, parameterAssignments, templateAssignments);
	}

	private void addStereotypes(EObject semanticObject, List<Stereotype> stereotypes) {
		final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(semanticObject);
		final CompoundCommand compoundCommand = new CompoundCommand();
		// for each selected Stereotype create one StereotypeAssignment and add it to the model
		for (final Stereotype stereotype : stereotypes) {
			StereotypeAssignment assignment = null;
			if (semanticObject instanceof Block) {
				assignment = ParametersFactory.eINSTANCE.createBlockStereotypeAssignment();
				compoundCommand
						.append(new SetCommand(editingDomain, assignment, ParametersPackage.eINSTANCE.getBlockStereotypeAssignment_Context(), semanticObject));
			} else if (semanticObject instanceof BlockType) {
				assignment = ParametersFactory.eINSTANCE.createBlockTypeStereotypeAssignment();
				compoundCommand.append(
						new SetCommand(editingDomain, assignment, ParametersPackage.eINSTANCE.getBlockTypeStereotypeAssignment_Context(), semanticObject));
			} else if (semanticObject instanceof Port) {
				assignment = ParametersFactory.eINSTANCE.createPortStereotypeAssignment();
				compoundCommand
						.append(new SetCommand(editingDomain, assignment, ParametersPackage.eINSTANCE.getPortStereotypeAssignment_Context(), semanticObject));
			} else if (semanticObject instanceof Connection) {
				assignment = ParametersFactory.eINSTANCE.createConnectionStereotypeAssignment();
				compoundCommand.append(
						new SetCommand(editingDomain, assignment, ParametersPackage.eINSTANCE.getConnectionStereotypeAssignment_Context(), semanticObject));
			}

			// set the context of the StereotypeAssignment
			compoundCommand.append(
					new AddCommand(editingDomain, ModelHelper.INSTANCE.getModel(semanticObject), CommonsPackage.eINSTANCE.getModel_Content(), assignment));
			// add all defined parameters to the specific stereotype
			for (final ParameterDefinition parameter : stereotype.getParameters()) {
				if (parameter instanceof BasePrimitiveParameterDefinition) {
					final PrimitiveParameterValue newValue = ParametersFactory.eINSTANCE.createPrimitiveParameterValue();
					newValue.setParameter((BasePrimitiveParameterDefinition) parameter);
					compoundCommand.append(new AddCommand(editingDomain, assignment, ParametersPackage.eINSTANCE.getStereotypeAssignment_Values(), newValue));
				}
			}
			// add the stereotype to the assignment
			compoundCommand
					.append(new AddCommand(editingDomain, assignment, ParametersPackage.eINSTANCE.getStereotypeAssignment_AssignedStereotypes(), stereotype));
		}
		editingDomain.getCommandStack().execute(compoundCommand);
	}

	private void addParameters(EObject semanticObject, List<ParameterDefinition> parameters) {
		final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(semanticObject);
		final CompoundCommand compoundCommand = new CompoundCommand();
		// for each selected Parameter create one ParameterAssignment and add it to the model
		for (final ParameterDefinition parameter : parameters) {
			ParameterAssignment assignment = null;
			if (semanticObject instanceof Block) {
				assignment = ParametersFactory.eINSTANCE.createBlockParameterAssignment();
				compoundCommand
						.append(new SetCommand(editingDomain, assignment, ParametersPackage.eINSTANCE.getBlockParameterAssignment_Context(), semanticObject));
			}

			// set the context of the ParameterAssignment
			compoundCommand.append(
					new AddCommand(editingDomain, ModelHelper.INSTANCE.getModel(semanticObject), CommonsPackage.eINSTANCE.getModel_Content(), assignment));
			// add a ParameterValue to the parameterDefinition
			PrimitiveParameterValue newValue = null;
			if (parameter instanceof BasePrimitiveParameterDefinition) {
				newValue = ParametersFactory.eINSTANCE.createPrimitiveParameterValue();
				newValue.setParameter((BasePrimitiveParameterDefinition) parameter);
			}

			compoundCommand.append(new AddCommand(editingDomain, assignment, ParametersPackage.eINSTANCE.getParameterAssignment_Values(), newValue));
		}
		editingDomain.getCommandStack().execute(compoundCommand);
	}

}
