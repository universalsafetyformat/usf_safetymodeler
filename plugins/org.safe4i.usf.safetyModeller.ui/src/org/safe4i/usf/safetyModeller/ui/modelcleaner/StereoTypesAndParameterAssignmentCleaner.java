/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.modelcleaner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.safe4i.usf.core.usfmodel.common.IModelContent;
import org.safe4i.usf.core.usfmodel.common.Model;
import org.safe4i.usf.core.usfmodel.parameter.BlockTypeParameterAssignment;
import org.safe4i.usf.core.usfmodel.parameter.BlockTypeStereotypeAssignment;

public enum StereoTypesAndParameterAssignmentCleaner implements IContentCleaner {

	INSTANCE;

	@Override
	public List<EObject> getUnUsedContent(Model rootElement) {
		if (rootElement.getContent().isEmpty()) {
			return new ArrayList<>();
		}
		final Set<EObject> unUsedAssignedStereotypesAndParameter = new HashSet<>();
		for (final IModelContent content : rootElement.getContent()) {

			if (content instanceof BlockTypeParameterAssignment) {
				final BlockTypeParameterAssignment blockTypeParameterAssignment = (BlockTypeParameterAssignment) content;
				if (blockTypeParameterAssignment.getContext() == null || blockTypeParameterAssignment.getValues().isEmpty()) {
					unUsedAssignedStereotypesAndParameter.add(blockTypeParameterAssignment);
				}
			}

			if (content instanceof BlockTypeStereotypeAssignment) {
				final BlockTypeStereotypeAssignment blockTypeStereotypeAssignment = (BlockTypeStereotypeAssignment) content;
				if (blockTypeStereotypeAssignment.getContext() == null || blockTypeStereotypeAssignment.getAssignedStereotypes().isEmpty()) {
					unUsedAssignedStereotypesAndParameter.add(blockTypeStereotypeAssignment);
				}
			}
		}

		return new ArrayList<>(unUsedAssignedStereotypesAndParameter);
	}

}
