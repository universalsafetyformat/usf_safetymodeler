/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.safe4i.usf.safetyModeller.ui.modelcleaner.ModelCleaner_Helper;

public class CleanModelHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);

		final ISelectionService selectionService = window.getSelectionService();
		final IStructuredSelection structuredSelection = (IStructuredSelection) selectionService.getSelection();

		if (structuredSelection.getFirstElement() instanceof IFile) {
			final IFile file = (IFile) structuredSelection.getFirstElement();
			try {
				ModelCleaner_Helper.INSTANCE.cleanModel(window, file);
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
