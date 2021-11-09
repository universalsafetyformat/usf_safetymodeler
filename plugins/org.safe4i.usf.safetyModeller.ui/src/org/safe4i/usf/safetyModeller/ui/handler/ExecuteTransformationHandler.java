/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
/**
* 
*/
package org.safe4i.usf.safetyModeller.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeEditPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.safe4i.usf.core.usfmodel.safetyPattern.SafetyPatternApplication;
import org.safe4i.usf.safetyModeller.ui.Activator;
import org.safe4i.usf.safetyModeller.ui.trans.TransformationExecuteHelper;

/**
 * @author Hamza
 *
 */
public class ExecuteTransformationHandler extends AbstractHandler {

	private SafetyPatternApplication getSafetyPatternApplication(ExecutionEvent event) {
		ISelection selection;
		if (event != null) {
			selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		} else {
			selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		}
		if (selection == null || selection.isEmpty() || !(selection instanceof IStructuredSelection)) {
			return null;
		}

		final Object selectedElement = ((IStructuredSelection) selection).getFirstElement();
		if (selectedElement instanceof SafetyPatternApplication) {
			return (SafetyPatternApplication) selectedElement;
		}

		if (selectedElement instanceof DNodeEditPart) {
			final DNodeEditPart dPart = ((DNodeEditPart) selectedElement);
			final EObject eObj = dPart.resolveTargetSemanticElement();
			if (eObj instanceof SafetyPatternApplication) {
				return (SafetyPatternApplication) eObj;
			}
		}
		return null;
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final SafetyPatternApplication safetyPatternApplication = getSafetyPatternApplication(event);
		if (safetyPatternApplication == null) {
			Activator.getDefault().getLog().error("SafetyPatternApplication can not be found");
			return null;
		}

		final String pluginBasedPath = safetyPatternApplication.eResource().getURI().toPlatformString(true);
		final IPath path = new Path(pluginBasedPath);
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		final IProject project = file.getProject();
		if (!project.exists()) {
			Activator.getDefault().getLog().error("Folder can not be found");
			return null;
		}

		try {
			TransformationExecuteHelper.INSTANCE.transform(safetyPatternApplication, project, event);
		} catch (final Exception e) {
			final IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
			Activator.getDefault().getLog().log(status);
		}

		return null;
	}

	@Override
	public boolean isEnabled() {
		final SafetyPatternApplication safetyPatternApplication = getSafetyPatternApplication(null);
		if (safetyPatternApplication == null) {
			return false;
		} else {
			return true;
		}
	}

}
