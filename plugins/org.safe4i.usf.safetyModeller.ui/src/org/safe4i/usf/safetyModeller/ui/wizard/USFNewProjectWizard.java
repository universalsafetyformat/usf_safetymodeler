/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.wizard;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.safe4i.usf.safetyModeller.ui.Activator;
import org.safe4i.usf.safetyModeller.ui.project.USFProjectSupport;

public class USFNewProjectWizard extends Wizard implements INewWizard {

	private WizardNewProjectCreationPage newProjectPage;

	public USFNewProjectWizard() {
		setWindowTitle("New USF Project");
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// nothing to do
	}

	@Override
	public void addPages() {
		super.addPages();

		newProjectPage = new WizardNewProjectCreationPage("New USF Project Wizard");
		newProjectPage.setTitle("New USF Project");
		newProjectPage.setDescription("Create a new USF Project");

		addPage(newProjectPage);
	}

	@Override
	public boolean performFinish() {
		final IProject projectHandle = newProjectPage.getProjectHandle();

		final IRunnableWithProgress operation = progressMonitor -> {
			try {
				// Create a project
				projectHandle.create(progressMonitor);

				// Open the project
				projectHandle.open(progressMonitor);

				// add the project nature
				USFProjectSupport.INSTANCE.addNature(projectHandle, progressMonitor);

				ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, progressMonitor);

				// Create folders
				USFProjectSupport.INSTANCE.createProjectStructure(projectHandle, progressMonitor);

				ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, progressMonitor);

			} catch (final Throwable e) {
				e.printStackTrace();
				Activator.getDefault().logError("Error during Project creation", e);
			} finally {
				progressMonitor.done();
			}
		};

		try {
			getContainer().run(false, false, operation);
		} catch (final Throwable e) {
			Activator.getDefault().logError("Error during Project creation", e);
		}

		return true;
	}

}
