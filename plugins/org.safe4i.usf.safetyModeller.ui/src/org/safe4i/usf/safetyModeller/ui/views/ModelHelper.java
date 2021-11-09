/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.views;

import java.util.Collections;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.safe4i.usf.core.usfmodel.block.Block;
import org.safe4i.usf.core.usfmodel.block.BlockType;
import org.safe4i.usf.core.usfmodel.block.Connection;
import org.safe4i.usf.core.usfmodel.block.Port;
import org.safe4i.usf.core.usfmodel.common.Model;
import org.safe4i.usf.core.usfmodel.parameter.BlockParameterAssignment;
import org.safe4i.usf.core.usfmodel.parameter.BlockStereotypeAssignment;
import org.safe4i.usf.core.usfmodel.parameter.BlockTypeParameterAssignment;
import org.safe4i.usf.core.usfmodel.parameter.BlockTypeStereotypeAssignment;
import org.safe4i.usf.core.usfmodel.parameter.ConnectionParameterAssignment;
import org.safe4i.usf.core.usfmodel.parameter.ConnectionStereotypeAssignment;
import org.safe4i.usf.core.usfmodel.parameter.ParameterAssignment;
import org.safe4i.usf.core.usfmodel.parameter.PortParameterAssignment;
import org.safe4i.usf.core.usfmodel.parameter.PortStereotypeAssignment;
import org.safe4i.usf.core.usfmodel.parameter.StereotypeAssignment;
import org.safe4i.usf.core.usfmodel.portTemplate.TemplateAssignment;

public enum ModelHelper {

	INSTANCE;

	public Model getModel(EObject context) {
		final String errorMessage = "Context is not contained in a USF Model!";
		final EObject rootObject = EcoreUtil.getRootContainer(context);
		if (rootObject instanceof Model) {
			return (Model) rootObject;
		}

		throw new IllegalArgumentException(errorMessage);
	}

	public Stream<EObject> getAllElements(EObject context) {
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(getModel(context).eAllContents(), Spliterator.ORDERED), false);
	}

	public EditingDomain getEditingDomain(EObject context) {
		return AdapterFactoryEditingDomain.getEditingDomainFor(context);
	}

	public List<? extends ParameterAssignment> collectParameterAssignments(EObject eObject) {
		if (eObject instanceof Block) {
			return collectParameterAssignments((Block) eObject);
		} else if (eObject instanceof BlockType) {
			return collectParameterAssignments((BlockType) eObject);
		} else if (eObject instanceof Port) {
			return collectParameterAssignments((Port) eObject);
		} else if (eObject instanceof Connection) {
			return collectParameterAssignments((Connection) eObject);
		}
		return Collections.emptyList();
	}

	public List<TemplateAssignment> collectTemplateAssignments(EObject eObject) {
		if (eObject instanceof Block) {
			return collectTemplateAssignments((Block) eObject);
		}
		return Collections.emptyList();
	}

	public List<BlockParameterAssignment> collectParameterAssignments(Block block) {
		return ModelHelper.INSTANCE.getAllElements(block) //
				.filter(e -> e instanceof BlockParameterAssignment) //
				.filter(pa -> ((BlockParameterAssignment) pa).getContext().equals(block)) //
				.map(pa -> (BlockParameterAssignment) pa) //
				.collect(Collectors.toList());
	}

	public List<TemplateAssignment> collectTemplateAssignments(Block block) {
		return ModelHelper.INSTANCE.getAllElements(block) //
				.filter(e -> e instanceof TemplateAssignment) //
				.filter(pa -> ((TemplateAssignment) pa).getContext().equals(block)) //
				.map(pa -> (TemplateAssignment) pa) //
				.collect(Collectors.toList());
	}

	public List<BlockTypeParameterAssignment> collectParameterAssignments(BlockType blockType) {
		return ModelHelper.INSTANCE.getAllElements(blockType) //
				.filter(e -> e instanceof BlockTypeParameterAssignment) //
				.filter(pa -> ((BlockTypeParameterAssignment) pa).getContext().equals(blockType)) //
				.map(pa -> (BlockTypeParameterAssignment) pa) //
				.collect(Collectors.toList());
	}

	public List<PortParameterAssignment> collectParameterAssignments(Port port) {
		return ModelHelper.INSTANCE.getAllElements(port) //
				.filter(e -> e instanceof PortParameterAssignment) //
				.filter(pa -> ((PortParameterAssignment) pa).getContext().equals(port)) //
				.map(pa -> (PortParameterAssignment) pa) //
				.collect(Collectors.toList());
	}

	public List<ConnectionParameterAssignment> collectParameterAssignments(Connection connection) {
		return ModelHelper.INSTANCE.getAllElements(connection) //
				.filter(e -> e instanceof ConnectionParameterAssignment) //
				.filter(pa -> ((ConnectionParameterAssignment) pa).getContext().equals(connection)) //
				.map(pa -> (ConnectionParameterAssignment) pa) //
				.collect(Collectors.toList());
	}

	public List<StereotypeAssignment> collectStereotypeAssignments(EObject eObject) {
		if (eObject instanceof Block) {
			return collectStereotypeAssignments((Block) eObject);
		} else if (eObject instanceof BlockType) {
			return collectStereotypeAssignments((BlockType) eObject);
		} else if (eObject instanceof Port) {
			return collectStereotypeAssignments((Port) eObject);
		} else if (eObject instanceof Connection) {
			return collectStereotypeAssignments((Connection) eObject);
		} else {
			return Collections.emptyList();
		}
	}

	public List<StereotypeAssignment> collectStereotypeAssignments(Block block) {
		final List<StereotypeAssignment> stereotypeAssignments = ModelHelper.INSTANCE.getAllElements(block) //
				.filter(e -> e instanceof BlockStereotypeAssignment) //
				.filter(sa -> ((BlockStereotypeAssignment) sa).getContext() != null && ((BlockStereotypeAssignment) sa).getContext().equals(block)) //
				.map(sa -> (BlockStereotypeAssignment) sa) //
				.collect(Collectors.toList());
		return stereotypeAssignments;
	}

	public List<StereotypeAssignment> collectStereotypeAssignments(BlockType blockType) {
		final List<StereotypeAssignment> stereotypeAssignments = ModelHelper.INSTANCE.getAllElements(blockType) //
				.filter(e -> e instanceof BlockTypeStereotypeAssignment) //
				.filter(sa -> ((BlockTypeStereotypeAssignment) sa).getContext() != null && ((BlockTypeStereotypeAssignment) sa).getContext().equals(blockType)) //
				.map(sa -> (BlockTypeStereotypeAssignment) sa) //
				.collect(Collectors.toList());
		return stereotypeAssignments;
	}

	public List<StereotypeAssignment> collectStereotypeAssignments(Port port) {
		final List<StereotypeAssignment> stereotypeAssignments = ModelHelper.INSTANCE.getAllElements(port) //
				.filter(e -> e instanceof PortStereotypeAssignment) //
				.filter(sa -> ((PortStereotypeAssignment) sa).getContext() != null && ((PortStereotypeAssignment) sa).getContext().equals(port)) //
				.map(sa -> (PortStereotypeAssignment) sa) //
				.collect(Collectors.toList());
		return stereotypeAssignments;
	}

	public List<StereotypeAssignment> collectStereotypeAssignments(Connection connection) {
		final List<StereotypeAssignment> stereotypeAssignments = ModelHelper.INSTANCE.getAllElements(connection) //
				.filter(e -> e instanceof ConnectionStereotypeAssignment) //
				.filter(sa -> ((ConnectionStereotypeAssignment) sa).getContext() != null
						&& ((ConnectionStereotypeAssignment) sa).getContext().equals(connection)) //
				.map(sa -> (ConnectionStereotypeAssignment) sa) //
				.collect(Collectors.toList());
		return stereotypeAssignments;
	}
}
