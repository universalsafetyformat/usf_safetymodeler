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
import java.util.Optional;

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
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.factory.SessionFactory;
import org.eclipse.sirius.tools.api.command.semantic.AddSemanticResourceCommand;
import org.eclipse.sirius.ui.business.api.session.UserSession;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.safe4i.usf.safetyModeller.ui.Activator;
import org.safe4i.usf.safetyModeller.ui.example.DefaultModelCreationHelper;
import org.safe4i.usf.safetyModeller.ui.project.USFProjectNature;
import org.safe4i.usf.safetyModeller.ui.project.USFProjectSupport;

public class CreateNewModelHandler extends AbstractHandler {

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

		final IProject relatedProject = (IProject) result;
		final IFolder modelFolder = relatedProject.getFolder(USFProjectSupport.MODEL_FOLDER);

		final InputDialog d = new InputDialog(null, "Model", "Please enter a Model name", "New Model", new FolderNameValidator(modelFolder));
		if (d.open() != Window.OK) {
			return null;
		}

		final String modelname = d.getValue();

		final IFolder exampleFolder = modelFolder.getFolder(modelname);
		try {
			exampleFolder.create(false, true, new NullProgressMonitor());
		} catch (final CoreException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
		}

		final IFile modelFile = exampleFolder.getFile(modelname + ".xmi");

		// Empty_Model_CreationHelper helper = new Empty_Model_CreationHelper();
		// Model modelRoot = helper.createModel(modelFile);

		final DefaultModelCreationHelper helper = new DefaultModelCreationHelper();
		helper.createModel(modelFile);

		try {
			exampleFolder.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
		} catch (final CoreException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
		}

		try {
			// create new AIRD file and open the sirius session
			final URI representationFileUri = URI.createFileURI(exampleFolder.getFile(modelname + ".aird").getFullPath().toString());
			final Session session = SessionFactory.INSTANCE.createSession(representationFileUri, new NullProgressMonitor());
			session.open(new NullProgressMonitor());

			// add the newly created model as semantic resource
			// relative paths are not accepted, so construct a platform resource URI
			final URI modelUri = generateModelFileUri(relatedProject, modelFolder, modelname);
			// session.addSemanticResource(modelUri, new NullProgressMonitor());
			// for some reason, the API doesn't work, so use the command instead
			final AddSemanticResourceCommand command = new AddSemanticResourceCommand(session, modelUri, new NullProgressMonitor());
			session.getTransactionalEditingDomain().getCommandStack().execute(command);

			if (!session.getSemanticResources().stream().filter(r -> r.getURI().equals(modelUri)).findAny().isPresent()) {
				Activator.getDefault().getLog()
						.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Failed to add " + modelUri + " as semantic resource to diagram file!"));
			}

			// select viewpoint
			final UserSession us = UserSession.from(session);
			us.selectViewpoint(USFProjectSupport.USF_VIEWPOINT_NAME);
			final Optional<Viewpoint> usfVP = session.getSelectedViewpoints(true).stream()
					.filter(vp -> vp.getName().equals(USFProjectSupport.USF_VIEWPOINT_NAME)).findAny();
			if (usfVP.isPresent()) {
				Activator.getDefault().getLog().log(new Status(IStatus.INFO, Activator.PLUGIN_ID, "Selected ViewPoint " + usfVP.get().getName()));
			} else {
				Activator.getDefault().getLog()
						.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Failed to select ViewPoint " + USFProjectSupport.USF_VIEWPOINT_NAME + "!"));
			}
			us.save(new NullProgressMonitor());
		} catch (final CoreException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
		}

		return null;
	}

	class FolderNameValidator implements IInputValidator {
		private final IFolder context;

		public FolderNameValidator(IFolder modelFolder) {
			this.context = modelFolder;
		}

		@Override
		public String isValid(String newText) {
			if (context.getFolder(newText).exists()) {
				return "Model with the given name already exists.";
			}

			// Input must be OK
			return null;
		}
	}

	private URI generateModelFileUri(IProject project, IFolder modelFolder, String modelName) {
		return URI.createPlatformResourceURI(
				"/" + project.getName() + "/" + modelFolder.getName() + "/" + modelName + "/" + modelName + USFProjectSupport.MODEL_FILE_EXTENSION, true);
	}

}
