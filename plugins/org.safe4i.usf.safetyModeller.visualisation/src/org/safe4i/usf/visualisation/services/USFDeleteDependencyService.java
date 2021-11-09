/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.visualisation.services;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.safe4i.usf.core.usfmodel.block.AbstractBlockType;
import org.safe4i.usf.core.usfmodel.block.Block;
import org.safe4i.usf.core.usfmodel.block.BlockRelationship;
import org.safe4i.usf.core.usfmodel.block.Connection;
import org.safe4i.usf.core.usfmodel.block.Port;
import org.safe4i.usf.core.usfmodel.controlFlow.ControlFlowConnection;
import org.safe4i.usf.core.usfmodel.controlFlow.ControlFlowPort;
import org.safe4i.usf.core.usfmodel.controlFlow.DecisionNode;
import org.safe4i.usf.core.usfmodel.controlFlow.ForkNode;
import org.safe4i.usf.core.usfmodel.controlFlow.JoinNode;
import org.safe4i.usf.core.usfmodel.controlFlow.MergeNode;
import org.safe4i.usf.core.usfmodel.controlFlow.SignalNode;
import org.safe4i.usf.core.usfmodel.errorHandling.ErrorControlFlowPort;
import org.safe4i.usf.core.usfmodel.parameter.ParameterAssignment;
import org.safe4i.usf.core.usfmodel.parameter.ParameterDefinition;
import org.safe4i.usf.core.usfmodel.parameter.PrimitiveParameterValue;
import org.safe4i.usf.core.usfmodel.parameter.Stereotype;
import org.safe4i.usf.core.usfmodel.parameter.StereotypeAssignment;
import org.safe4i.usf.visualisation.Activator;

/**
 * The services class used by VSM.
 */
public class USFDeleteDependencyService {

	/**
	 * Calculates the direct and indirect delete dependencies of the given context element and return them.
	 *
	 * @param context
	 *            context element for the calculation
	 * @return a list of elements which should be also deleted together with the context element. The list will also contain the element it self.
	 */
	public Set<EObject> getDeleteDependencies(EObject context) {
		Set<EObject> result = null;
		if (context instanceof Block) {
			result = getBlockDeleteDependencies((Block) context);
		} else if (context instanceof AbstractBlockType) {
			result = getBlockTypeDeleteDependencies((AbstractBlockType) context);
		} else if (context instanceof Port) {
			result = getPortDeleteDependencies((Port) context);
		} else if (context instanceof Stereotype) {
			result = getStereotypeDeleteDependencies((Stereotype) context);
		} else if (context instanceof ParameterDefinition) {
			result = getParameterDefinitionDeleteDependencies((ParameterDefinition) context);
		} else if (context instanceof Connection) {
			result = getConnectionDeleteDependencies((Connection) context);
		}

		if (result == null) {
			result = Collections.singleton(context);
		} else {
			result.add(context);
		}
		return result;
	}

	private Set<EObject> getBlockDeleteDependencies(Block block) {
		final AbstractBlockType blockType = block.getType();
		if (blockType == null) {
			return Collections.emptySet();
		}
		final Resource eResource = block.eResource();
		if (eResource == null) {
			return Collections.emptySet();
		}

		final Set<EObject> result = new HashSet<>();

		for (final Setting setting : EcoreUtil.UsageCrossReferencer.find(block, eResource)) {
			// BlocksPackage.eINSTANCE.getAssemblyDataFlowConnection_DestinationBlock()
			// BlocksPackage.eINSTANCE.getAssemblyDataFlowConnection_SourceBlock()
			// ControlFlowsPackage.eINSTANCE.getAssemblyControlFlowConnection_DestinationBlock()
			// ControlFlowsPackage.eINSTANCE.getAssemblyControlFlowConnection_SourceBlock()
			// BlocksPackage.eINSTANCE.getDelegateDataFlowConnection_InnerBlock()
			// ControlFlowsPackage.eINSTANCE.getDelegateControlFlowConnection_InnerBlock()

			final EObject referencingElement = setting.getEObject();

			if (referencingElement instanceof Connection) { // Connections to delete
				result.add(referencingElement);
				result.addAll(getConnectionDeleteDependencies((Connection) referencingElement));
			} else if (referencingElement instanceof ParameterAssignment) { // ParameterAssignments to delete
				result.add(referencingElement);
			} else if (referencingElement instanceof StereotypeAssignment) { // StereotypeAssignments to delete
				result.add(referencingElement);
			} else if (referencingElement instanceof BlockRelationship) { // BlockRelationship to delete
				result.add(referencingElement);
			} else {
				Activator.getDefault().getLog()
						.log(new Status(IStatus.INFO, getClass(), "Setting:\n" + " - " + referencingElement + "\n" + " - " + setting.getEStructuralFeature()));
			}

		}

		// Don't delete BlockType for "normal" Blocks see:
		// https://jira.scopeforge.de/browse/SAFE4I-50?focusedCommentId=11072&page=com.atlassian.jira.plugin.system.issuetabpanels:comment-tabpanel#comment-11072
		if (blockType instanceof DecisionNode || blockType instanceof ForkNode || blockType instanceof JoinNode || blockType instanceof MergeNode
				|| blockType instanceof SignalNode) {
			final Collection<Setting> blockTypeDepenedencies = EcoreUtil.UsageCrossReferencer.find(blockType, eResource);
			// if there is only one dependency to the BlockType and it is the block to delete we can also remove the BlockType
			if (blockTypeDepenedencies.size() == 1 && block.equals(blockTypeDepenedencies.iterator().next().getEObject())) {
				result.add(blockType);
			}
		}

		return result;
	}

	private Set<EObject> getBlockTypeDeleteDependencies(AbstractBlockType blockType) {
		final Resource eResource = blockType.eResource();
		if (eResource == null) {
			return Collections.emptySet();
		}

		final Set<EObject> result = new HashSet<>();
		for (final Setting setting : EcoreUtil.UsageCrossReferencer.find(blockType, eResource)) {
			final EObject referencingElement = setting.getEObject();

			if (referencingElement instanceof ParameterAssignment) { // ParameterAssignments to delete
				result.add(referencingElement);
			} else if (referencingElement instanceof StereotypeAssignment) { // StereotypeAssignments to delete
				result.add(referencingElement);
			} else {
				Activator.getDefault().getLog()
						.log(new Status(IStatus.INFO, getClass(), "Setting:\n" + " - " + referencingElement + "\n" + " - " + setting.getEStructuralFeature()));
			}
		}

		for (final EObject children : blockType.eContents()) {
			if (children instanceof Block) {
				result.addAll(getBlockDeleteDependencies((Block) children));
			} else if (children instanceof Port) {
				result.addAll(getPortDeleteDependencies((Port) children));
			} else if (children instanceof Connection) {
				result.addAll(getConnectionDeleteDependencies((Connection) children));
			}
		}

		return result;
	}

	private Set<EObject> getConnectionDeleteDependencies(Connection connection) {
		final Resource eResource = connection.eResource();
		if (eResource == null) {
			return Collections.emptySet();
		}

		final Set<EObject> result = new HashSet<>();
		for (final Setting setting : EcoreUtil.UsageCrossReferencer.find(connection, eResource)) {
			final EObject referencingElement = setting.getEObject();

			if (referencingElement instanceof ParameterAssignment) { // ParameterAssignments to delete
				result.add(referencingElement);
			} else if (referencingElement instanceof StereotypeAssignment) { // StereotypeAssignments to delete
				result.add(referencingElement);
			} else {
				Activator.getDefault().getLog()
						.log(new Status(IStatus.INFO, getClass(), "Setting:\n" + " - " + referencingElement + "\n" + " - " + setting.getEStructuralFeature()));
			}
		}

		if (connection instanceof ControlFlowConnection) {
			final ControlFlowPort sourcePort = ((ControlFlowConnection) connection).getSourcePort();
			final ControlFlowPort targetPort = ((ControlFlowConnection) connection).getDestinationPort();

			if (sourcePort instanceof ErrorControlFlowPort == false) {
				result.add(sourcePort);
			}

			if (targetPort instanceof ErrorControlFlowPort == false) {
				result.add(targetPort);
			}
		}

		return result;
	}

	private Set<EObject> getPortDeleteDependencies(Port port) {
		final Resource eResource = port.eResource();
		if (eResource == null) {
			return Collections.emptySet();
		}

		final Set<EObject> result = new HashSet<>();
		for (final Setting setting : EcoreUtil.UsageCrossReferencer.find(port, eResource)) {
			final EObject referencingElement = setting.getEObject();

			if (referencingElement instanceof ParameterAssignment) { // ParameterAssignments to delete
				result.add(referencingElement);
			} else if (referencingElement instanceof StereotypeAssignment) { // StereotypeAssignments to delete
				result.add(referencingElement);
			} else {
				Activator.getDefault().getLog()
						.log(new Status(IStatus.INFO, getClass(), "Setting:\n" + " - " + referencingElement + "\n" + " - " + setting.getEStructuralFeature()));
			}
		}
		return result;
	}

	private Set<EObject> getParameterDefinitionDeleteDependencies(ParameterDefinition parameterDefinition) {

		final Resource eResource = parameterDefinition.eResource();
		if (eResource == null) {
			return Collections.emptySet();
		}

		final Set<EObject> result = new HashSet<>();
		for (final Setting setting : EcoreUtil.UsageCrossReferencer.find(parameterDefinition, eResource)) {
			final EObject referencingElement = setting.getEObject();

			if (referencingElement instanceof PrimitiveParameterValue) { // ParameterValue to delete
				result.add(referencingElement);
				final ParameterAssignment parameterAssignment = (ParameterAssignment) referencingElement.eContainer();
				// also delete the assignment if it is the last value
				if (parameterAssignment.getValues().size() == 1 && parameterAssignment.getValues().contains(referencingElement)) {
					result.add(parameterAssignment);
				}
			} else {
				Activator.getDefault().getLog()
						.log(new Status(IStatus.INFO, getClass(), "Setting:\n" + " - " + referencingElement + "\n" + " - " + setting.getEStructuralFeature()));
			}
		}
		return result;

	}

	private Set<EObject> getStereotypeDeleteDependencies(Stereotype stereotype) {
		final Resource eResource = stereotype.eResource();
		if (eResource == null) {
			return Collections.emptySet();
		}

		final Set<EObject> result = new HashSet<>();
		for (final Setting setting : EcoreUtil.UsageCrossReferencer.find(stereotype, eResource)) {
			final EObject referencingElement = setting.getEObject();

			if (referencingElement instanceof StereotypeAssignment) { // ParameterAssignments to delete
				// delete the stereotype if it is the last one in the asignment
				if (((StereotypeAssignment) referencingElement).getAssignedStereotypes().size() == 1
						&& ((StereotypeAssignment) referencingElement).getAssignedStereotypes().contains(stereotype)) {
					result.add(referencingElement);
				}
			} else {
				Activator.getDefault().getLog()
						.log(new Status(IStatus.INFO, getClass(), "Setting:\n" + " - " + referencingElement + "\n" + " - " + setting.getEStructuralFeature()));
			}
		}
		return result;
	}

}
