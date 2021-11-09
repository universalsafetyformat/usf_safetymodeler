/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.contentprovider.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.safe4i.usf.core.usfmodel.parameter.ParameterAssignment;
import org.safe4i.usf.core.usfmodel.parameter.PrimitiveParameterValue;
import org.safe4i.usf.core.usfmodel.parameter.Stereotype;
import org.safe4i.usf.core.usfmodel.parameter.StereotypeAssignment;
import org.safe4i.usf.core.usfmodel.portTemplate.TemplateAssignment;

public class VirtualTree {

	private VirtualGroupTreeItem<VirtualStereotypeTreeItem> stereotypes;
	private VirtualGroupTreeItem<PrimitiveParameterValue> parameters;
	private VirtualGroupTreeItem<TemplateAssignment> templatesAssignment;

	public VirtualTree() {
		stereotypes = new VirtualGroupTreeItem<>("Stereotypes", Collections.emptyList());
		parameters = new VirtualGroupTreeItem<>("Parameters", Collections.emptyList());
		templatesAssignment = new VirtualGroupTreeItem<>("Template Assignments", Collections.emptyList());
	}

	public void update(List<? extends StereotypeAssignment> stereotypeAssignments, List<? extends ParameterAssignment> parameterAssignments,
			List<TemplateAssignment> templateAssignments) {
		stereotypes = new VirtualGroupTreeItem<>("Stereotypes", resolveStereotypeAssignments(stereotypeAssignments));
		parameters = new VirtualGroupTreeItem<>("Parameters", resolveParameterAssignments(parameterAssignments));
		templatesAssignment = new VirtualGroupTreeItem<>("Template Assignments", templateAssignments);
	}

	private List<PrimitiveParameterValue> resolveParameterAssignments(List<? extends ParameterAssignment> assignments) {
		if (assignments.isEmpty()) {
			return Collections.emptyList();
		}

		final List<PrimitiveParameterValue> parameterValues = new LinkedList<>();
		for (final ParameterAssignment assignment : assignments) {
			for (final PrimitiveParameterValue paramValue : assignment.getValues()) {
				parameterValues.add(paramValue);
			}
		}
		return parameterValues;
	}

	private List<VirtualStereotypeTreeItem> resolveStereotypeAssignments(List<? extends StereotypeAssignment> assignments) {
		if (assignments.isEmpty()) {
			return Collections.emptyList();
		}

		final List<VirtualStereotypeTreeItem> treeItems = new LinkedList<>();
		for (final StereotypeAssignment assignment : assignments) {
			for (final Stereotype stereotype : assignment.getAssignedStereotypes()) {
				treeItems.add(new VirtualStereotypeTreeItem(stereotype, assignment.getValues(), assignment));
			}
		}
		return treeItems;
	}

	public VirtualGroupTreeItem<VirtualStereotypeTreeItem> getStereotypes() {
		return stereotypes;
	}

	public VirtualGroupTreeItem<PrimitiveParameterValue> getParameters() {
		return parameters;
	}

	public VirtualGroupTreeItem<TemplateAssignment> getTemplateAssignments() {
		return templatesAssignment;
	}

	public void reset() {
		stereotypes = new VirtualGroupTreeItem<>("Stereotypes", Collections.emptyList());
		parameters = new VirtualGroupTreeItem<>("Parameters", Collections.emptyList());
		templatesAssignment = new VirtualGroupTreeItem<>("Template Assignments", Collections.emptyList());
	}

}
