/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.contentprovider;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.safe4i.usf.core.usfmodel.parameter.Stereotype;
import org.safe4i.usf.core.usfmodel.parameter.StereotypeAssignment;
import org.safe4i.usf.safetyModeller.ui.contentprovider.model.VirtualGroupTreeItem;
import org.safe4i.usf.safetyModeller.ui.contentprovider.model.VirtualStereotypeTreeItem;
import org.safe4i.usf.safetyModeller.ui.contentprovider.model.VirtualTree;

public class StereotypesParameterTreeContentProvider implements ITreeContentProvider {

	private static final Object[] EMPTY = {};

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof VirtualTree) {
			return ArrayContentProvider.getInstance().getElements(new VirtualGroupTreeItem[] { ((VirtualTree) inputElement).getStereotypes(),
					((VirtualTree) inputElement).getParameters(), ((VirtualTree) inputElement).getTemplateAssignments() });
		} else if (inputElement instanceof VirtualGroupTreeItem<?>) {
			return ArrayContentProvider.getInstance().getElements(((VirtualGroupTreeItem<?>) inputElement).getChildren());
		}

		return EMPTY;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof VirtualGroupTreeItem<?>) {
			return ArrayContentProvider.getInstance().getElements(((VirtualGroupTreeItem<?>) parentElement).getChildren());
		} else if (parentElement instanceof VirtualStereotypeTreeItem) {
			return ArrayContentProvider.getInstance().getElements(((VirtualStereotypeTreeItem) parentElement).getParameterValues());
		} else if (parentElement instanceof StereotypeAssignment) {
			final List<VirtualStereotypeTreeItem> treeItems = new LinkedList<>();
			for (final Stereotype stereotype : ((StereotypeAssignment) parentElement).getAssignedStereotypes()) {
				treeItems.add(
						new VirtualStereotypeTreeItem(stereotype, ((StereotypeAssignment) parentElement).getValues(), (StereotypeAssignment) parentElement));
			}
			return ArrayContentProvider.getInstance().getElements(treeItems);
		}
		return EMPTY;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

}
