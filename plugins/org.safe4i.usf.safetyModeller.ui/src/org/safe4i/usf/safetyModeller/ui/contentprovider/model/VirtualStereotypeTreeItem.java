/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.contentprovider.model;

import java.util.LinkedList;
import java.util.List;

import org.safe4i.usf.core.usfmodel.parameter.PrimitiveParameterValue;
import org.safe4i.usf.core.usfmodel.parameter.Stereotype;
import org.safe4i.usf.core.usfmodel.parameter.StereotypeAssignment;

public class VirtualStereotypeTreeItem extends VirtualTreeItem {

	private final Stereotype stereotype;
	private final StereotypeAssignment context;
	private final List<PrimitiveParameterValue> parameterValues = new LinkedList<>();

	public VirtualStereotypeTreeItem(Stereotype stereotype, List<PrimitiveParameterValue> parameterValues, StereotypeAssignment context) {
		super(stereotype.getName(), "");
		this.stereotype = stereotype;
		this.context = context;
		this.parameterValues.addAll(parameterValues);
	}

	public Stereotype getStereotype() {
		return stereotype;
	}

	public StereotypeAssignment getContext() {
		return context;
	}

	public List<PrimitiveParameterValue> getParameterValues() {
		return parameterValues;
	}

}
