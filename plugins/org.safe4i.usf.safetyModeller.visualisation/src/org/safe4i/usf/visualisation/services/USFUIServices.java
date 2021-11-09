/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.visualisation.services;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DDiagramElementContainer;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.DNodeList;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.safe4i.usf.core.usfmodel.block.AssemblyDataFlowConnection;
import org.safe4i.usf.core.usfmodel.block.Block;
import org.safe4i.usf.core.usfmodel.block.BlockRelationship;
import org.safe4i.usf.core.usfmodel.block.BlockType;
import org.safe4i.usf.core.usfmodel.block.DelegateDataFlowConnection;
import org.safe4i.usf.core.usfmodel.block.DeployRelationship;
import org.safe4i.usf.core.usfmodel.block.Port;
import org.safe4i.usf.core.usfmodel.block.UseRelationship;
import org.safe4i.usf.core.usfmodel.common.NamedElement;
import org.safe4i.usf.core.usfmodel.controlFlow.AssemblyControlFlowConnection;
import org.safe4i.usf.core.usfmodel.controlFlow.DecisionNode;
import org.safe4i.usf.core.usfmodel.controlFlow.DelegateControlFlowConnection;
import org.safe4i.usf.core.usfmodel.controlFlow.ForkNode;
import org.safe4i.usf.core.usfmodel.controlFlow.JoinNode;
import org.safe4i.usf.core.usfmodel.controlFlow.MergeNode;
import org.safe4i.usf.core.usfmodel.controlFlow.ReceiveSignalNode;
import org.safe4i.usf.core.usfmodel.controlFlow.SendSignalNode;
import org.safe4i.usf.core.usfmodel.errorHandling.ErrorControlFlowPort;
import org.safe4i.usf.core.usfmodel.parameter.BlockParameterDefinition;
import org.safe4i.usf.core.usfmodel.parameter.BlockTypeParameterDefinition;
import org.safe4i.usf.core.usfmodel.parameter.ConnectionParameterDefinition;
import org.safe4i.usf.core.usfmodel.parameter.DomainTypeParameterDefinition;
import org.safe4i.usf.core.usfmodel.parameter.PortParameterDefinition;
import org.safe4i.usf.core.usfmodel.parameter.TransformationParameterDefinition;
import org.safe4i.usf.core.usfmodel.parameter.TransformationTypeParameterDefinition;

/**
 * The services class used by VSM for view elements.
 */
public class USFUIServices {

	private static final String UNSET_VALUE_LITERAL = "<unset>";

	// /**
	// * Mark for auto size.
	// *
	// * @param any
	// * Any
	// * @return the given auto sized object
	// */
	// public EObject markForAutosize(EObject any) {
	// if (any != null) {
	// any.eAdapters().add(AutosizeTrigger.AUTO_SIZE_MARKER);
	// }
	// return any;
	// }

	/**
	 * This method checks if the connection source is a valid starting connection source. This method will be check before a connection is created
	 * 
	 * @param object
	 * @param source
	 * @return
	 */
	public boolean isValidAssemblyControlFlowConnectionStart(EObject object, EObject source) {

		if (source instanceof Block && ((Block) source).getType() instanceof SendSignalNode) {
			final SendSignalNode node = (SendSignalNode) ((Block) source).getType();
			if (node.getOutControlFlowPort() != null) {
				return false;
			}
		}

		if (source instanceof Block && ((Block) source).getType() instanceof ReceiveSignalNode) {
			final ReceiveSignalNode node = (ReceiveSignalNode) ((Block) source).getType();
			if (node.getOutControlFlowPort() != null) {
				return false;
			}
		}

		if (source instanceof Block && ((Block) source).getType() instanceof JoinNode) {
			final JoinNode node = (JoinNode) ((Block) source).getType();
			if (node.getOutControlFlowPort() != null) {
				return false;
			}
		}

		if (source instanceof Block && ((Block) source).getType() instanceof MergeNode) {
			final MergeNode node = (MergeNode) ((Block) source).getType();
			if (node.getOutControlFlowPort() != null) {
				return false;
			}
		}

		if (source instanceof Block && ((Block) source).getType() instanceof DecisionNode) {
			final DecisionNode node = (DecisionNode) ((Block) source).getType();
			if (node.getOutControlFlowPortTrue() != null && node.getOutControlFlowPortFalse() != null) {
				return false;
			}

		}

		return true;
	}

	/**
	 * This method checks if the connection target is a valid combination
	 * 
	 * @param object
	 * @param target
	 * @return
	 */
	public boolean isValidAssemblyControlFlowConnectionEnd(EObject object, EObject target) {

		// Only two IN ports are allowed for a merge node, check if both port are already used.
		if (target instanceof Block && ((Block) target).getType() instanceof MergeNode) {
			final MergeNode node = (MergeNode) ((Block) target).getType();
			if (!node.getInControlFlowPorts().isEmpty() && node.getInControlFlowPorts().size() >= 2) {
				return false;
			}
		}

		if (target instanceof Block && ((Block) target).getType() instanceof ForkNode) {
			final ForkNode node = (ForkNode) ((Block) target).getType();
			if (node.getInControlFlowPort() != null) {
				return false;
			}
		}

		if (target instanceof Block && ((Block) target).getType() instanceof DecisionNode) {
			final DecisionNode node = (DecisionNode) ((Block) target).getType();
			if (node.getInControlFlowPort() != null) {
				return false;
			}
		}

		if (target instanceof Block && ((Block) target).getType() instanceof SendSignalNode) {
			final SendSignalNode node = (SendSignalNode) ((Block) target).getType();
			if (node.getInControlFlowPort() != null) {
				return false;
			}
		}

		if (target instanceof Block && ((Block) target).getType() instanceof ReceiveSignalNode) {
			return false;
		}

		return true;
	}

	/**
	 * This method checks if the connection source is a valid starting connection source. This method will be check before a connection is created
	 * 
	 * @param object
	 * @param source
	 * @return
	 */
	public boolean isValidDelegateControlFlowConnectionStart(EObject object, DSemanticDecorator source) {

		if (source.getTarget() instanceof BlockType) {
			return true;
		}

		if (source.getTarget() instanceof Block) {
			return true;
		}

		if (source.getTarget() instanceof ErrorControlFlowPort) {
			return true;
		}

		return false;
	}

	/**
	 * This method checks if the connection target is a valid combination
	 * 
	 * @param object
	 * @param target
	 * @return
	 */
	public boolean isValidDelegateControlFlowConnectionEnd(EObject object, DSemanticDecorator source, DSemanticDecorator target) {

		if (source.getTarget() instanceof BlockType && target.getTarget() instanceof BlockType) {
			return false;
		}

		if (source.getTarget() instanceof Block && target.getTarget() instanceof Block) {
			return false;
		}

		if (source.getTarget() instanceof ErrorControlFlowPort && target.getTarget() instanceof ErrorControlFlowPort) {

			final EObject sourceObject = ((DDiagramElementContainer) source.eContainer()).getTarget();
			final EObject targetObjectObject = ((DDiagramElementContainer) target.eContainer()).getTarget();

			if (sourceObject instanceof Block && targetObjectObject instanceof Block) {
				return false;
			}

			if (sourceObject instanceof BlockType && targetObjectObject instanceof BlockType) {
				return false;
			}

		}

		return true;
	}

	/**
	 * The method will check if a {@link AssemblyDataFlowConnection} really connects the two ports based on the additional block information. If this is not
	 * done severel connections will be created for all the ports which are reused in different Blocks based on the same type. See also:
	 * https://www.eclipse.org/forums/index.php/t/830878/
	 * 
	 * @param connection
	 * @param source
	 * @param target
	 * @return
	 */
	public boolean isValidAssemblyDataFlowConnectionLinkEdge(AssemblyDataFlowConnection connection, DNode source, DNode target) {

		if (connection.getSourceBlock() == null || connection.getDestinationBlock() == null) {
			return false; // invalid edge which should be removed anyway
		}

		if (source.eContainer() == null || target.eContainer() == null) {
			return false;
		}

		if ((connection.getSourceBlock().equals(((DDiagramElement) source.eContainer()).getTarget())
				&& connection.getDestinationBlock().equals(((DDiagramElement) target.eContainer()).getTarget()))) {
			return true;
		}

		return false;
	}

	/**
	 * see {@link #isValidAssemblyDataFlowConnectionLinkEdge(AssemblyDataFlowConnection, DNode, DNode)} -> same usecase
	 * 
	 * @param connection
	 * @param source
	 * @param target
	 * @return
	 */
	public boolean isValidDelegateDataFlowConnectionLinkEdge(DelegateDataFlowConnection connection, DNode source, DNode target) {

		if (connection.getInnerBlock() == null) {
			return false; // invalid edge which should be removed anyway
		}

		if (source.eContainer() == null || target.eContainer() == null) {
			return false;
		}

		if (connection.getInnerBlock().equals(((DDiagramElement) source.eContainer()).getTarget())
				|| connection.getInnerBlock().equals(((DDiagramElement) target.eContainer()).getTarget())) {
			return true;
		}

		return false;
	}

	/**
	 * see {@link #isValidAssemblyDataFlowConnectionLinkEdge(AssemblyDataFlowConnection, DNode, DNode)} -> same usecase
	 * 
	 * @param connection
	 * @param source
	 * @param target
	 * @return
	 */
	public boolean isValidAssemblyControlFlowConnectionLinkEdge(AssemblyControlFlowConnection connection, DSemanticDecorator source,
			DSemanticDecorator target) {

		if (connection.getSourceBlock() == null || connection.getDestinationBlock() == null) {
			return false; // invalid edge which should be removed anyway
		}

		if (source.eContainer() == null || target.eContainer() == null) {
			return false;
		}

		if (connection.getSourcePort() instanceof ErrorControlFlowPort && connection.getDestinationPort() instanceof ErrorControlFlowPort) {
			return connection.getSourcePort().equals(source.getTarget()) && connection.getDestinationPort().equals(target.getTarget())
					&& connection.getSourceBlock().equals(((DNodeList) source.eContainer()).getTarget())
					&& connection.getDestinationBlock().equals(((DNodeList) target.eContainer()).getTarget());
		}

		if (!(connection.getSourcePort() instanceof ErrorControlFlowPort) && !(connection.getDestinationPort() instanceof ErrorControlFlowPort)) {
			return connection.getSourceBlock().equals(source.getTarget()) && connection.getDestinationBlock().equals(target.getTarget());
		}

		if (connection.getSourcePort() instanceof ErrorControlFlowPort && !(connection.getDestinationPort() instanceof ErrorControlFlowPort)) {
			return connection.getSourcePort().equals(source.getTarget()) && connection.getSourceBlock().equals(((DNodeList) source.eContainer()).getTarget())
					&& connection.getDestinationBlock().equals(target.getTarget());
		}

		if (!(connection.getSourcePort() instanceof ErrorControlFlowPort) && connection.getDestinationPort() instanceof ErrorControlFlowPort) {
			return connection.getSourceBlock().equals(source.getTarget()) && connection.getDestinationPort().equals(target.getTarget())
					&& connection.getDestinationBlock().equals(((DNodeList) target.eContainer()).getTarget());
		}

		return false;
	}

	/**
	 * see {@link #isValidAssemblyDataFlowConnectionLinkEdge(AssemblyDataFlowConnection, DNode, DNode)} -> same usecase
	 * 
	 * @param connection
	 * @param source
	 * @param target
	 * @return
	 */
	public boolean isValidDelegateControlFlowConnectionLinkEdge(DelegateControlFlowConnection connection, DSemanticDecorator source,
			DSemanticDecorator target) {

		if (connection.getInnerBlock() == null) {
			return false; // invalid edge which should be removed anyway
		}

		if (source.eContainer() == null || target.eContainer() == null) {
			return false;
		}

		if (connection.getSourcePort() instanceof ErrorControlFlowPort && connection.getDestinationPort() instanceof ErrorControlFlowPort) {

			return connection.getSourcePort().equals(source.getTarget())
					&& (connection.getInnerBlock().equals(((DDiagramElementContainer) source.eContainer()).getTarget())
							|| connection.getInnerBlock().equals(((DDiagramElementContainer) target.eContainer()).getTarget()))
					&& connection.getDestinationPort().equals(target.getTarget());
		}

		if (!(connection.getSourcePort() instanceof ErrorControlFlowPort) && !(connection.getDestinationPort() instanceof ErrorControlFlowPort)) {

			if (source.getTarget() instanceof BlockType && target.getTarget() instanceof Block) {
				final BlockType sourceContainer = (BlockType) source.getTarget();
				return connection.getInnerBlock().equals(target.getTarget()) && sourceContainer.getAllPorts().contains(connection.getSourcePort());
			}

			if (source.getTarget() instanceof Block && target.getTarget() instanceof BlockType) {
				final BlockType targetContainer = (BlockType) target.getTarget();
				return connection.getInnerBlock().equals(source.getTarget()) && targetContainer.getAllPorts().contains(connection.getDestinationPort());
			}

		}

		if (!(connection.getSourcePort() instanceof ErrorControlFlowPort) && connection.getDestinationPort() instanceof ErrorControlFlowPort) {

			return connection.getDestinationPort().equals(target.getTarget()) && (connection.getInnerBlock().equals(source.getTarget())
					|| connection.getInnerBlock().equals(((DDiagramElementContainer) target.eContainer()).getTarget()));

		}

		if (connection.getSourcePort() instanceof ErrorControlFlowPort && !(connection.getDestinationPort() instanceof ErrorControlFlowPort)) {

			return connection.getSourcePort().equals(source.getTarget())
					&& (connection.getInnerBlock().equals(((DDiagramElementContainer) source.eContainer()).getTarget())
							|| (connection.getInnerBlock().equals(target.getTarget())));
		}

		return false;
	}

	/**
	 * Get the container {@link BlockType} for the Connection which will be the container of the Block for which the connection is created.
	 * 
	 * We could also use something like this in the design file: aql:targetView.eContainer().target.eContainer()
	 */
	public BlockType getConnectionContainer(Port element, DNode sourceView) {
		// System.out.println("element: " + element);
		// System.out.println("sourceView.eClass(): " + sourceView.eClass());
		// System.out.println("((DDiagramElement)sourceView).getTarget(): " + ((DDiagramElement) sourceView).getTarget());
		// System.out.println("((DDiagramElement)sourceView).getParentDiagram(): " + ((DDiagramElement) sourceView).getParentDiagram());
		//
		// System.out.println("((DDiagramElement)sourceView).getSemanticElements(): " + ((DDiagramElement) sourceView).getSemanticElements());

		// System.out.println("((DNode) sourceView).eContainer(): " + sourceView.eContainer());
		// System.out.println("((DNode) sourceView).eContainer(): " + sourceView.eContainer().eClass());
		// System.out.println("((DNode) sourceView).eContainer(): " + );
		// return (BlockType) ((DDiagramElement) sourceView.eContainer()).getTarget().eContainer();

		if (sourceView.eContainer() == null) {
			return null;
		}

		final EObject block = ((DDiagramElement) sourceView.eContainer()).getTarget();
		if (block != null && (block.eContainer() instanceof BlockType)) {
			final BlockType container = (BlockType) block.eContainer();
			return container;
		}

		return null;
	}

	public BlockType getBlockRelashionshipContainer(Block element) {

		if (element == null) {
			return null;
		}

		final EObject container = element.eContainer();
		if (container != null && (container instanceof BlockType)) {
			final BlockType root = (BlockType) container;
			return root;
		}

		return null;
	}

	public BlockType getTopBlockTypeContainer(EObject object, DNode sourceView) {

		if (sourceView == null) {
			return null;
		}

		EObject topBlockTypeContainer = ((DDiagramElement) sourceView.eContainer()).getTarget();
		while (topBlockTypeContainer.eContainer() != null && (topBlockTypeContainer.eContainer() instanceof BlockType)) {
			topBlockTypeContainer = topBlockTypeContainer.eContainer();
		}

		if (!(topBlockTypeContainer instanceof BlockType)) {
			return null;
		}

		return (BlockType) topBlockTypeContainer;

	}

	public String getSafetyPatternParameterName(TransformationParameterDefinition param) {
		final StringBuilder result = new StringBuilder();

		if (param instanceof TransformationTypeParameterDefinition) {
			final TransformationTypeParameterDefinition tParam = (TransformationTypeParameterDefinition) param;
			if (tParam.getType() != null) {
				result.append("[" + tParam.getType().getName() + "] ");
			}

			result.append(param.getName() != null ? param.getName() : "<No Name>");

			final String defaultValue = tParam.getDefaultValue();
			if (defaultValue != null) {
				result.append(" = " + defaultValue);
			} else {
				result.append(" = " + UNSET_VALUE_LITERAL);
			}
		} else if (param instanceof DomainTypeParameterDefinition) {
			final DomainTypeParameterDefinition dParam = ((DomainTypeParameterDefinition) param);
			if (dParam.getConstrainingDomainType() != null) {
				result.append("[" + dParam.getConstrainingDomainType().getName() + "] ");
			}

			result.append(param.getName() != null ? param.getName() : "<No Name>");

			if (dParam.getDefaultValue() != null) {
				result.append(" = " + dParam.getDefaultValue().getName());
			} else {
				result.append(" = " + UNSET_VALUE_LITERAL);
			}
		} else if (param instanceof BlockParameterDefinition) {
			final BlockParameterDefinition bParam = ((BlockParameterDefinition) param);
			if (bParam.getConstrainingBlockType() != null) {
				result.append("[" + bParam.getConstrainingBlockType().getName() + "] ");
			}
			result.append(param.getName() != null ? param.getName() : "<No Name>");
			if (bParam.getDefaultValue() != null) {
				result.append(" = " + bParam.getDefaultValue().getName());
			} else {
				result.append(" = " + UNSET_VALUE_LITERAL);
			}
		} else if (param instanceof BlockTypeParameterDefinition) {
			final BlockTypeParameterDefinition bParam = ((BlockTypeParameterDefinition) param);
			if (bParam.getConstrainingBlockType() != null) {
				result.append("[" + bParam.getConstrainingBlockType().getName() + "] ");
			}
			result.append(param.getName() != null ? param.getName() : "<No Name>");
			if (bParam.getDefaultValue() != null) {
				result.append(" = " + bParam.getDefaultValue().getName());
			} else {
				result.append(" = " + UNSET_VALUE_LITERAL);
			}
		} else if (param instanceof PortParameterDefinition) {
			final PortParameterDefinition pParam = ((PortParameterDefinition) param);
			result.append(pParam.isControlflowPort() ? "[CF" : "[DF");
			switch (pParam.getConstrainingDirection()) {
			case IN:
				result.append(" IN");
				break;
			case OUT:
				result.append(" OUT");
				break;
			case INOUT:
				result.append(" INOUT");
				break;
			default:
				break;
			}
			result.append("] ");

			if (pParam.getConstrainingPortType() != null) {
				result.append("[" + pParam.getConstrainingPortType().getName() + "] ");
			}
			result.append(pParam.getName() != null ? pParam.getName() : "<No Name>");
			if (pParam.getDefaultValue() != null) {
				result.append(" = " + pParam.getDefaultValue().getName());
			} else {
				result.append(" = " + UNSET_VALUE_LITERAL);
			}
		} else if (param instanceof ConnectionParameterDefinition) {
			final ConnectionParameterDefinition cParam = ((ConnectionParameterDefinition) param);
			result.append(cParam.isControlflowConnection() ? "[CF] " : "[DF] ");
			result.append(cParam.getName() != null ? param.getName() : "<No Name>");
			if (cParam.getDefaultValue() != null) {
				result.append(" = <SET>");
			} else {
				result.append(" = " + UNSET_VALUE_LITERAL);
			}
		}

		return result.toString();
	}

	public boolean isValidUseRelationship(EObject object, EObject source, EObject target) {

		if (object == null || object.eContainer() == null) {
			return false;
		}

		final BlockType container = (BlockType) object.eContainer();

		for (final BlockRelationship relationship : container.getBlockRelationships()) {
			if (relationship instanceof UseRelationship) {
				final UseRelationship oldRelation = (UseRelationship) relationship;
				if (oldRelation.getSource().equals(source) && oldRelation.getUses().equals(target)) {
					return false;
				}
			}
		}

		return true;
	}

	public boolean isValidDeployRelationship(EObject object, EObject source, EObject target) {

		if (object == null || object.eContainer() == null) {
			return false;
		}

		final BlockType container = (BlockType) object.eContainer();

		for (final BlockRelationship relationship : container.getBlockRelationships()) {
			if (relationship instanceof DeployRelationship) {
				final DeployRelationship oldRelation = (DeployRelationship) relationship;
				if (oldRelation.getSource().equals(source) && oldRelation.getDeployedAt().equals(target)) {
					return false;
				}
			}
		}

		return true;
	}

	public String getBlockTypeOrigin(EObject eObj) {
		if (eObj instanceof BlockType) {
			return getBlockTypeOrigin((BlockType) eObj);
		}
		return "No origin found for input " + eObj;

	}

	public String getBlockTypeOrigin(BlockType blockType) {
		final StringBuilder sb = new StringBuilder(blockType.getName());
		EObject container = blockType.eContainer();
		while (container instanceof org.safe4i.usf.core.usfmodel.common.Package) {
			sb.append(" :: ");
			sb.append(((NamedElement) container).getName());
			container = container.eContainer();
		}
		return sb.toString();
	}

	public Collection<EObject> getSourceCandidates(DelegateControlFlowConnection connection) {
		final ArrayList<EObject> candidates = new ArrayList<>();
		final boolean contained = connection.getInnerBlock().getType().getAllPorts().contains(connection.getSourcePort());
		if (contained) {
			candidates.add(connection.getSourcePort());
			candidates.add(connection.getInnerBlock());
		} else {
			candidates.add(connection.getSourcePort().eContainer());
			candidates.add(connection.getSourcePort());
		}
		return candidates;
	}

	public Collection<EObject> getTargetCandidates(DelegateControlFlowConnection connection) {
		final ArrayList<EObject> candidates = new ArrayList<>();
		final boolean contained = connection.getInnerBlock().getType().getAllPorts().contains(connection.getDestinationPort());
		if (contained) {
			candidates.add(connection.getDestinationPort());
			candidates.add(connection.getInnerBlock());
		} else {
			candidates.add(connection.getDestinationPort().eContainer());
			candidates.add(connection.getDestinationPort());
		}
		return candidates;
	}

}
