/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.safe4i.usf.safetyModeller.ui.Activator;
import org.safe4i.usf.safetyModeller.ui.example.UR5_Example_CreationHelper;
import org.safe4i.usf.safetyModeller.ui.project.USFProjectNature;
import org.safe4i.usf.safetyModeller.ui.project.USFProjectSupport;

public class CreateExampleModelHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);

		final List<IProject> projects = new ArrayList<>();
		for (final IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			if (!project.isOpen()) {
				continue;
			}

			try {
				if (project.hasNature(USFProjectNature.NATURE_ID)) {
					projects.add(project);
				}
			} catch (final CoreException e) {
				Activator.getDefault().logError(e.getMessage(), e);
			}
		}

		final ElementListSelectionDialog dialog = new ElementListSelectionDialog(window.getShell(),
				WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider());
		dialog.setTitle("Select a USF Project");
		dialog.setElements(projects.toArray());

		if (dialog.open() != Window.OK) {
			return null;
		}

		final Object result = dialog.getFirstResult();

		if (result == null || !(result instanceof IProject)) {
			return null;
		}

		final IFolder modelFolder = ((IProject) result).getFolder(USFProjectSupport.MODEL_FOLDER);

		final IFolder exampleFolder = modelFolder.getFolder("UR5_USF_Example");
		if (exampleFolder.exists()) {
			MessageDialog.openInformation(null, "Info", "Project already exisits and will not be created");
		} else {
			try {
				exampleFolder.create(false, true, new NullProgressMonitor());
			} catch (final CoreException e) {
				Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
			}
		}

		final IFile modelFile = exampleFolder.getFile("UR5_USF_Example.xmi");

		final UR5_Example_CreationHelper helper = new UR5_Example_CreationHelper();
		helper.createModel(modelFile);

		try {
			exampleFolder.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
		} catch (final CoreException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
		}

		return null;
	}

}
