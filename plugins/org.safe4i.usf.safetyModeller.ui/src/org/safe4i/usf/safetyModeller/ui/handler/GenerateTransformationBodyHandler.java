/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.handler;

import java.lang.reflect.InvocationTargetException;

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
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeContainerEditPart;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.safe4i.usf.core.usfmodel.safetyPattern.SafetyPattern;
import org.safe4i.usf.safetyModeller.ui.Activator;
import org.safe4i.usf.safetyModeller.ui.trans.TransformationFileHelper;

public class GenerateTransformationBodyHandler extends AbstractHandler {

	private SafetyPattern getSafetyPattern(ExecutionEvent event) {
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

		if (selectedElement instanceof SafetyPattern) {
			return (SafetyPattern) selectedElement;
		}
		if (selectedElement instanceof DNodeContainerEditPart) {
			final DNodeContainerEditPart dPart = ((DNodeContainerEditPart) selectedElement);
			final EObject eObj = dPart.resolveTargetSemanticElement();
			if (eObj instanceof SafetyPattern) {
				return (SafetyPattern) eObj;
			}
		}

		return null;
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final SafetyPattern safetyPattern = getSafetyPattern(event);
		if (safetyPattern == null) {
			return null;
		}
		final String pluginBasedPath = safetyPattern.eResource().getURI().toPlatformString(true);
		final IPath path = new Path(pluginBasedPath);
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		final IProject project = file.getProject();
		if (!project.exists()) {
			return null;
		}

		final IRunnableWithProgress operation = monitor -> {
			try {
				final IFile transformationFile = TransformationFileHelper.INSTANCE.getOrCreateTransformationFile(safetyPattern, project, monitor);

				final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				if (window == null) {
					return;
				}
				final IWorkbenchPage page = window.getActivePage();
				if (page == null) {
					return;
				}
				final IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(transformationFile.getName());
				page.openEditor(new FileEditorInput(transformationFile), desc.getId());
			} catch (final Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		};

		try {
			PlatformUI.getWorkbench().getProgressService().run(false, true, operation);
		} catch (final InvocationTargetException e) {
			final IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
			Activator.getDefault().getLog().log(status);
		} catch (final InterruptedException e) {
			final IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
			Activator.getDefault().getLog().log(status);
		}
		return null;
	}

	@Override
	public boolean isEnabled() {
		final SafetyPattern safetyPattern = getSafetyPattern(null);
		if (safetyPattern == null) {
			return false;
		} else {
			return true;
		}
	}
}
