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
import java.util.Collections;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;
import org.safe4i.usf.core.usfmodel.block.Block;
import org.safe4i.usf.core.usfmodel.block.BlockType;
import org.safe4i.usf.core.usfmodel.block.Connection;
import org.safe4i.usf.core.usfmodel.block.DataFlowPort;
import org.safe4i.usf.core.usfmodel.block.Port;
import org.safe4i.usf.core.usfmodel.common.DomainType;
import org.safe4i.usf.core.usfmodel.common.Model;
import org.safe4i.usf.core.usfmodel.errorHandling.ErrorDataPort;
import org.safe4i.usf.core.usfmodel.parameter.ParameterAssignment;
import org.safe4i.usf.core.usfmodel.parameter.PrimitiveParameterValue;
import org.safe4i.usf.core.usfmodel.parameter.Stereotype;
import org.safe4i.usf.core.usfmodel.parameter.StereotypeAssignment;
import org.safe4i.usf.core.usfmodel.safetyPattern.SafetyPattern;

/**
 * The services class used by VSM.
 */
public class USFModelServices {

	/**
	 * Get all DomainTypes ({@link DomainType}) from the Model
	 * 
	 * @param context
	 * @return
	 */
	public List<DomainType> getAllDomainTypes(EObject context) {
		final EObject root = getModelRoot(context);
		if (root == null) {
			return Collections.emptyList();
		}

		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(root.eAllContents(), Spliterator.ORDERED), false).filter(e -> (e instanceof DomainType))
				.map(e -> (DomainType) e).collect(Collectors.toList());
	}

	/**
	 * Get all BlockTypes ({@link BlockType}) from the Model
	 * 
	 * @param context
	 * @return
	 */
	public List<BlockType> getAllBlockTypes(EObject context) {
		final EObject root = getModelRoot(context);
		if (root == null) {
			return Collections.emptyList();
		}

		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(root.eAllContents(), Spliterator.ORDERED), false).filter(e -> (e instanceof BlockType))
				.map(e -> (BlockType) e).collect(Collectors.toList());
	}

	/**
	 * Get all the contained {@link DataFlowPort}s without {@link ErrorDataPort}s
	 * 
	 * @param context
	 * @return
	 */
	public List<DataFlowPort> getDataFlowPorts(EObject context) {
		if (context == null) {
			return Collections.emptyList();
		}

		return context.eContents().parallelStream().filter(e -> (e instanceof DataFlowPort) && !(e instanceof ErrorDataPort)).map(e -> (DataFlowPort) e)
				.collect(Collectors.toList());
	}

	/**
	 * Get all SafetyPattern ({@link SafetyPattern}) from the Model
	 * 
	 * @param context
	 * @return
	 */
	public List<SafetyPattern> getAllSafetyPattern(EObject context) {
		if (context.eResource() == null) {
			return Collections.emptyList();
		}

		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(context.eResource().getResourceSet().getAllContents(), Spliterator.ORDERED), false)
				.filter(e -> (e instanceof SafetyPattern)).map(e -> (SafetyPattern) e).collect(Collectors.toList());
	}

	/**
	 * Get the Root of the Resource -> {@link Model}
	 * 
	 * @param context
	 * @return
	 */
	public Model getModelRoot(EObject context) {
		if (context == null) {
			return null;
		}

		EObject root = context;
		while (root.eContainer() != null) {
			root = root.eContainer();
		}

		if (!(root instanceof Model)) {
			return null;
		}

		return (Model) root;
	}

	/**
	 * calculates a string containing all assigned stereotypes and parameters of a {@link Block}, {@link BlockType}, {@link Port} or {@link Connection}
	 * 
	 * @param context
	 *            context element for the calculation
	 * @return string representation of stereotypes and parameters, which are assigned to the passed context. If the context is no {@link Block},
	 *         {@link BlockType}, {@link Port}, {@link Connection} or there are no assignments, an empty string is returned
	 */
	public String getStereotypesAndParameters(EObject context) {
		final StringBuilder sb = new StringBuilder();
		if (context instanceof Block || context instanceof BlockType || context instanceof Port || context instanceof Connection) {
			final String stereotypeNames = getStereotypeNames(context);
			if (!stereotypeNames.isEmpty()) {
				sb.append("Stereotypes:");
				sb.append(System.lineSeparator());
				sb.append(stereotypeNames);
				sb.append(StereotypeParameterHelper.INSTANCE.getStereotypeParameterValues(context, getModelRoot(context)));
			}

			final List<ParameterAssignment> parameters = StereotypeParameterHelper.INSTANCE.getAssignedParameters(context, getModelRoot(context));
			if (!parameters.isEmpty()) {
				if (sb.length() > 0) { // add some line breaks if stereotypes are also present
					sb.append(System.lineSeparator());
					sb.append(System.lineSeparator());
				}
				sb.append("Parameters:");
				sb.append(System.lineSeparator());
				sb.append(StereotypeParameterHelper.INSTANCE.getParameterValues(parameters));
			}
		}
		return sb.toString();
	}

	/**
	 * calculates a string containing all assigned {@link Stereotype}s of a given {@link Block}, {@link BlockType}, {@link Port} or {@link Connection}
	 * 
	 * @param context
	 *            context element for the calculation
	 * @return string representation of all assigned stereotypes of the passed context. If the context is no {@link Block}, {@link BlockType}, {@link Port},
	 *         {@link Connection} or there are no assignments, an empty string is returned
	 */
	public String getStereotypeNames(EObject context) {
		final StringBuilder result = new StringBuilder();
		final List<StereotypeAssignment> stereotypes = StereotypeParameterHelper.INSTANCE.getAssignedStereotypes(context, getModelRoot(context));
		if (stereotypes.isEmpty()) {
			return result.toString();
		}

		result.append(stereotypes.stream().flatMap(sa -> sa.getAssignedStereotypes().stream()).map(s -> "\u00AB" + s.getName() + "\u00BB")
				.collect(Collectors.joining(" ")));
		result.append(System.lineSeparator());
		return result.toString();
	}

	/**
	 * returns all {@link ParameterValue}s which are assigned to a context element
	 * 
	 * @param context
	 * @return
	 */
	public List<PrimitiveParameterValue> getAssignedParameterValues(EObject context) {
		final List<PrimitiveParameterValue> result = new ArrayList<>();
		result.addAll(StereotypeParameterHelper.INSTANCE.getAssignedParameters(context, getModelRoot(context)).stream().flatMap(pa -> pa.getValues().stream())
				.collect(Collectors.toList()));
		result.addAll(StereotypeParameterHelper.INSTANCE.getAssignedStereotypes(context, getModelRoot(context)).stream().flatMap(sa -> sa.getValues().stream())
				.collect(Collectors.toList()));
		return result;
	}

	public String getParameterValue(PrimitiveParameterValue param) {
		return StereotypeParameterHelper.INSTANCE.getValue(param);
	}

	public boolean isObjectOfInterest(EObject context) {
		return context instanceof Block || context instanceof BlockType || context instanceof Port || context instanceof Connection;
	}
}
