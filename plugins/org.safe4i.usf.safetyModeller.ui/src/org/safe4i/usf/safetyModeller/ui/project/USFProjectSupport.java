/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.project;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public enum USFProjectSupport {
	INSTANCE;

	public static final String TRANSFORMATION_FOLDER = "transformation";
	public static final String MODEL_FOLDER = "model";
	public static final String SAVE_MODEL_FOLDER = "save_model";
	public static final String MODEL_FILE_EXTENSION = ".xmi";
	public static final String USF_VIEWPOINT_NAME = "USF";
	public static final String MODEL_FILE_EXTENSION_NAME = "xmi";
	public static final String SRC_GEN_FOLDER = "src-gen";

	public void createProjectStructure(IProject newProject, IProgressMonitor monitor) throws CoreException {
		IFolder folder = newProject.getFolder(TRANSFORMATION_FOLDER);
		createFolder(folder, monitor);

		folder = newProject.getFolder(MODEL_FOLDER);
		createFolder(folder, monitor);

		folder = newProject.getFolder(SAVE_MODEL_FOLDER);
		createFolder(folder, monitor);

	}

	public void addNature(IProject project, IProgressMonitor monitor) throws CoreException {
		if (!project.hasNature(USFProjectNature.NATURE_ID)) {
			final IProjectDescription description = project.getDescription();
			description.setNatureIds(new String[] { USFProjectNature.NATURE_ID });
			project.setDescription(description, monitor);
		}
	}

	private void createFolder(IFolder folder, IProgressMonitor monitor) throws CoreException {
		if (!folder.exists()) {
			folder.create(false, true, monitor);
		}
	}
}