/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.decorator;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.safe4i.usf.safetyModeller.ui.Activator;
import org.safe4i.usf.safetyModeller.ui.project.USFProjectNature;
import org.safe4i.usf.safetyModeller.ui.project.USFProjectSupport;

public class USFProjectDecorator extends LabelProvider implements ILightweightLabelDecorator {
	private final ImageDescriptor trafoImageDescriptor = Activator.getDefault().getImageDescriptor("icons/8x8/cog.png");
	private final ImageDescriptor unsecureImageDescriptor = Activator.getDefault().getImageDescriptor("icons/8x8/error.png");
	private final ImageDescriptor secureImageDescriptor = Activator.getDefault().getImageDescriptor("icons/8x8/shield.png");

	public static final String ID = "org.safe4i.usf.core.model.ui.decorator.USFProjectDecorator";

	@Override
	public boolean isLabelProperty(final Object element, final String property) {
		return false;
	}

	@Override
	public void decorate(Object element, final IDecoration decoration) {
		try {
			if (element instanceof IProject) {
				final IProject project = (IProject) element;
				if (!project.isOpen()) {
					return;
				}

				if (project.hasNature(USFProjectNature.NATURE_ID)) {
					decoration.addSuffix(" [USF]");
				}
			} else if (element instanceof IFolder && ((IFolder) element).getProject().hasNature(USFProjectNature.NATURE_ID)) {
				final IFolder folder = (IFolder) element;

				if (folder.getName().equalsIgnoreCase(USFProjectSupport.TRANSFORMATION_FOLDER)
						|| folder.getName().equalsIgnoreCase(USFProjectSupport.MODEL_FOLDER)
						|| folder.getName().equalsIgnoreCase(USFProjectSupport.SAVE_MODEL_FOLDER)) {
					if (folder.members() != null) {
						decoration.addSuffix(" [" + folder.members().length + "]");
					} else {
						decoration.addSuffix(" [0]");
					}
				}

				if (folder.getName().equalsIgnoreCase(USFProjectSupport.TRANSFORMATION_FOLDER)) {
					decoration.addOverlay(trafoImageDescriptor, IDecoration.BOTTOM_RIGHT);
					return;
				} else if (folder.getName().equalsIgnoreCase(USFProjectSupport.MODEL_FOLDER)) {
					decoration.addOverlay(unsecureImageDescriptor, IDecoration.BOTTOM_RIGHT);
					return;
				} else if (folder.getName().equalsIgnoreCase(USFProjectSupport.SAVE_MODEL_FOLDER)) {
					decoration.addOverlay(secureImageDescriptor, IDecoration.BOTTOM_RIGHT);
					return;
				}

			}
		} catch (final CoreException e) {
			Activator.getDefault().logError("Error during Project decoration", e);
		}
	}

	public void fireUpdateEvent() {
		fireLabelProviderChanged(new LabelProviderChangedEvent(this));
	}

}
