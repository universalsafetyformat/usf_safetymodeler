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
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DDiagramEditPart;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeContainerEditPart;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.safe4i.usf.qvto.ui.InferTypesLauncher;
import org.safe4i.usf.qvto.ui.QVToLauncherHelper;
import org.safe4i.usf.safetyModeller.ui.Activator;

@SuppressWarnings("restriction")
public class InferTypesHandler extends AbstractHandler {

	private URI getModelURI(IFile airdFile) {
		final URI airdURI = URI.createPlatformResourceURI(airdFile.getFullPath().toString(), true);
		final Session siriusSession = SessionManager.INSTANCE.getSession(airdURI, new NullProgressMonitor());
		final DAnalysis root = (DAnalysis) siriusSession.getSessionResource().getContents().get(0);
		return EcoreUtil.getURI(root.getModels().get(0));

	}

	private URI getURI(ExecutionEvent event) {
		final ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if (selection == null || selection.isEmpty() || !(selection instanceof IStructuredSelection)) {
			return null;
		}

		final Object selectedElement = ((IStructuredSelection) selection).getFirstElement();

		if (selectedElement instanceof File) {
			final IFile iFile = ((File) selectedElement);
			if (iFile.getFileExtension().equals("xmi")) {
				return URI.createPlatformResourceURI(iFile.getFullPath().toString(), true);
			} else if (iFile.getFileExtension().equals("aird")) {
				return getModelURI(iFile);
			}
		}

		if (selectedElement instanceof XMIResourceImpl) {
			final XMIResourceImpl xmi = ((XMIResourceImpl) selectedElement);
			return xmi.getURI();
		}

		if (selectedElement instanceof EObject) {
			final EObject eObj = ((EObject) selectedElement);
			return EcoreUtil.getURI(eObj);
		}

		if (selectedElement instanceof DNodeContainerEditPart) {
			final DNodeContainerEditPart dPart = ((DNodeContainerEditPart) selectedElement);
			final EObject eObj = dPart.resolveTargetSemanticElement();
			return EcoreUtil.getURI(eObj);
		}

		if (selectedElement instanceof DDiagramEditPart) {
			final IWorkbenchWindow win = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			final IFile airdFile = win.getActivePage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
			return getModelURI(airdFile);
		}

		QVToLauncherHelper.displayNoteMsg("Error: Wrong selection!", "Please select a USF element or file");
		return null;
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final URI modelURI = getURI(event);

		final IRunnableWithProgress operation = monitor -> {
			try {
				InferTypesLauncher.modelTransform(monitor, modelURI, false);
			} catch (final CoreException e) {
				e.printStackTrace();
				final IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
				Activator.getDefault().getLog().log(status);
			}
		};

		try {
			PlatformUI.getWorkbench().getProgressService().run(true, true, operation);
		} catch (final InvocationTargetException e) {
			final IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
			Activator.getDefault().getLog().log(status);
		} catch (final InterruptedException e) {
			final IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
			Activator.getDefault().getLog().log(status);
		}
		return null;
	}
}
