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
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.dialect.command.RefreshRepresentationsCommand;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.factory.SessionFactory;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.ui.IWorkbenchWindow;
import org.safe4i.usf.core.usfmodel.common.Model;
import org.safe4i.usf.safetyModeller.ui.Activator;

public enum ModelCleaner_Helper {

	INSTANCE;

	private final ReflectiveItemProvider LABEL_PROVIDER = new ReflectiveItemProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	/**
	 * 
	 * @param selectedModel
	 * @throws Exception
	 */
	public void cleanModel(IWorkbenchWindow window, IFile selectedModel) throws Exception {
		if (selectedModel == null || selectedModel.getLocationURI() == null) {
			return;
		}
		final ProgressMonitorDialog progress = new ProgressMonitorDialog(window.getShell());

		progress.run(false, false, monitor -> {

			try {

				monitor.beginTask("Start model cleaning", IProgressMonitor.UNKNOWN);

				final String path = selectedModel.getLocationURI().getPath();
				final URI representationFileUri = URI.createFileURI(path);

				final Session session = SessionFactory.INSTANCE.createSession(representationFileUri, monitor);
				session.open(new NullProgressMonitor());
				final Resource resource = session.getSemanticResources().iterator().next();
				final Model rootElement = (Model) resource.getContents().get(0);
				final List<EObject> unUsedContents = getUnUsedContents(rootElement);
				int continueCleaning = 0;

				if (!unUsedContents.isEmpty()) {
					final String content = unUsedContents.size() == 1 ? " content" : " contents";
					final String message = unUsedContents.size() + content + " will be deleted after the clean operation";
					continueCleaning = MessageDialog.open(MessageDialog.CONFIRM, window.getShell(), "Model Cleaner", message, 0, "Cancel", "Continue");
				} else {
					MessageDialog.openInformation(window.getShell(), "Model Cleaner", "There is no incomplete or dirty contents in the model");
				}

				if (continueCleaning == 1) {

					final StringBuilder builder = new StringBuilder("The following elements have been deleted:");
					builder.append(System.getProperty("line.separator"));
					builder.append(System.getProperty("line.separator"));
					builder.append(getElementNameWithType(unUsedContents));
					final DeleteCommand command = new DeleteCommand(session.getTransactionalEditingDomain(), unUsedContents);
					session.getTransactionalEditingDomain().getCommandStack().execute(command);
					save(session, rootElement, monitor);
					MessageDialog.openInformation(window.getShell(), "Model Cleaner", builder.toString());
				}

			} catch (final Exception e) {
				Activator.getDefault().logError(e.getMessage(), e);
			} finally {
				monitor.done();
			}

		});
	}

	/**
	 * 
	 * @param session
	 * @param rootElement
	 * @throws Exception
	 */
	private void save(Session session, Model rootElement, IProgressMonitor monitor) throws Exception {
		session.save(new NullProgressMonitor());
		final List<DRepresentation> representation = new ArrayList<>(DialectManager.INSTANCE.getRepresentations(rootElement, session));
		final RefreshRepresentationsCommand command = new RefreshRepresentationsCommand(session.getTransactionalEditingDomain(), monitor, representation);
		session.getTransactionalEditingDomain().getCommandStack().execute(command);
		ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, monitor);
	}

	/**
	 * 
	 * @param rootElement
	 * @return
	 */
	private List<EObject> getUnUsedContents(Model rootElement) {
		final List<EObject> unusedContents = new ArrayList<>();
		// unusedContents.addAll(BlockTypesCleaner.INSTANCE.getUnUsedContent(rootElement));
		unusedContents.addAll(ConnectionCleaner.INSTANCE.getUnUsedContent(rootElement));
		unusedContents.addAll(StereoTypesAndParameterAssignmentCleaner.INSTANCE.getUnUsedContent(rootElement));
		return unusedContents;
	}

	private String getElementNameWithType(List<EObject> elements) {
		final StringBuilder builder = new StringBuilder();
		for (final EObject element : elements) {
			final String elementName = LABEL_PROVIDER.getText(element);
			builder.append(elementName);
			builder.append(System.getProperty("line.separator"));
		}
		return builder.toString();
	}

}
