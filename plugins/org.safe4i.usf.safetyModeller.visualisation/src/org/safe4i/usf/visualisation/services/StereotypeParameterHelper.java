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
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;
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
import org.safe4i.usf.core.usfmodel.parameter.ParameterDefinition;
import org.safe4i.usf.core.usfmodel.parameter.PortParameterAssignment;
import org.safe4i.usf.core.usfmodel.parameter.PortStereotypeAssignment;
import org.safe4i.usf.core.usfmodel.parameter.PrimitiveParameterValue;
import org.safe4i.usf.core.usfmodel.parameter.StereotypeAssignment;

public enum StereotypeParameterHelper {
	INSTANCE;

	private static final String UNSET_STRING = "<Unset>";

	/**
	 * calculates all {@link StereotypeAssignment}s of a passed {@link Block}, {@link Port} or {@link Connection}
	 * 
	 * @param context
	 *            should be a {@link Block}, {@link Port} or {@link Connection}
	 * @param modelRoot
	 *            the model root, where the context element is contained
	 * @return a list of {@link StereotypeAssignment}s of the given context. If the context is no {@link Block}, {@link Port} or {@link Connection}, or there
	 *         are no assignments, an empty list is returned
	 */
	public List<StereotypeAssignment> getAssignedStereotypes(EObject context, Model modelRoot) {
		final List<StereotypeAssignment> stereotypes = StreamSupport
				.stream(Spliterators.spliteratorUnknownSize(modelRoot.eAllContents(), Spliterator.ORDERED), false)
				.filter(o -> getStereotypeAssignmentPredicate(context).test(o)) //
				.map(o -> ((StereotypeAssignment) o)) //
				.collect(Collectors.toList());
		return stereotypes;
	}

	/**
	 * In context of {@link StereotypeAssignment} or {@link ParameterAssignment}, this function checks, if expected and actual refer to the same block. If so,
	 * true is returned, false otherwise.
	 * 
	 * @param expected
	 *            the expected block
	 * @param actual
	 *            the actual block
	 * @return true, if expected and actual are equal, false otherwise
	 */
	private boolean checkStereotypeParameterContextEquality(EObject expected, EObject actual) {
		return expected != null && actual != null && expected.equals(actual);
	}

	private Predicate<EObject> getStereotypeAssignmentPredicate(EObject context) {
		if (context instanceof Block) {
			return t -> t instanceof BlockStereotypeAssignment
					&& checkStereotypeParameterContextEquality(context, ((BlockStereotypeAssignment) t).getContext());
		} else if (context instanceof BlockType) {
			return t -> t instanceof BlockTypeStereotypeAssignment
					&& checkStereotypeParameterContextEquality(context, ((BlockTypeStereotypeAssignment) t).getContext());
		} else if (context instanceof Port) {
			return t -> t instanceof PortStereotypeAssignment && checkStereotypeParameterContextEquality(context, ((PortStereotypeAssignment) t).getContext());
		} else if (context instanceof Connection) {
			return t -> t instanceof ConnectionStereotypeAssignment
					&& checkStereotypeParameterContextEquality(context, ((ConnectionStereotypeAssignment) t).getContext());
		} else {
			return t -> false;
		}
	}

	private Predicate<EObject> getParameterAssignmentPredicate(EObject context) {
		if (context instanceof Block) {
			return t -> t instanceof BlockParameterAssignment && checkStereotypeParameterContextEquality(context, ((BlockParameterAssignment) t).getContext());
		} else if (context instanceof BlockType) {
			return t -> t instanceof BlockTypeParameterAssignment
					&& checkStereotypeParameterContextEquality(context, ((BlockTypeParameterAssignment) t).getContext());
		} else if (context instanceof Port) {
			return t -> t instanceof PortParameterAssignment && checkStereotypeParameterContextEquality(context, ((PortParameterAssignment) t).getContext());
		} else if (context instanceof Connection) {
			return t -> t instanceof ConnectionParameterAssignment
					&& checkStereotypeParameterContextEquality(context, ((ConnectionParameterAssignment) t).getContext());
		} else {
			return t -> false;
		}
	}

	/**
	 * calculates all {@link ParameterAssignment}s of a passed {@link Block}, {@link Port} or {@link Connection}
	 * 
	 * @param context
	 * @param modelRoot
	 *            the model root, where the context element is contained
	 * @return a list of {@link ParameterAssignment} of the given context. If the context is no block, port or connection, or there are no assignment, an empty
	 *         list is returned
	 */
	public List<ParameterAssignment> getAssignedParameters(EObject context, Model modelRoot) {
		final List<ParameterAssignment> assignments = new ArrayList<>();

		assignments.addAll(StreamSupport.stream(Spliterators.spliteratorUnknownSize(modelRoot.eAllContents(), Spliterator.ORDERED), false)
				.filter(e -> getParameterAssignmentPredicate(context).test(e)).map(e -> (ParameterAssignment) e).collect(Collectors.toList()));

		return assignments;
	}

	protected String getParameterValues(List<ParameterAssignment> assignments) {
		return assignments.stream() //
				.flatMap(pa -> pa.getValues().stream()) //
				.map(param -> "* " + getParameter(param).getName() + ": " + getValue(param)) //
				.collect(Collectors.joining(System.lineSeparator()));
	}

	protected String getValue(PrimitiveParameterValue element) {
		if (element.getValue() == null) {
			return element.getParameter().getDefaultValue();
		} else if (element.getValue() == null) {
			return UNSET_STRING;
		} else {
			return element.getValue();
		}
	}

	private ParameterDefinition getParameter(PrimitiveParameterValue pv) {
		return pv.getParameter();
	}

	/**
	 * calculates a string representing parameters of a assigned Stereotype of a {@link Block}, {@link Port}, or {@link Connection}
	 * 
	 * @param context
	 *            context element for the calculation
	 * @param modelRoot
	 *            the model root, where the context element is contained
	 * @return a string listing all parameters found in the {@link StereotypeAssignment} of the passed context element. If the context is no {@link Block},
	 *         {@link Port}, {@link Connection}, or there are no assignments, an empty string is returned
	 * 
	 */
	protected String getStereotypeParameterValues(EObject context, Model modelRoot) {
		final StringBuilder sb = new StringBuilder();
		final List<StereotypeAssignment> assignments = getAssignedStereotypes(context, modelRoot);
		sb.append(assignments.stream().flatMap(sa -> sa.getValues().stream()).map(v -> "* " + getParameter(v).getName() + ": " + getValue(v))
				.collect(Collectors.joining(System.lineSeparator())));
		return sb.toString();
	}

}
