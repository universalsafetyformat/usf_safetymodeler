/**
 * Copyright (c) 2021 FZI Forschungszentrum Informatik (www.fzi.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.qvto.ui;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;

public class InferTypesLauncher {
	final static String TYPE_INTERFERENCE = "platform:/plugin/org.safe4i.usf.qvto/transforms/TypeInference.qvto";
	
	public static void modelTransform(IProgressMonitor monitor, URI modelURI, boolean refresh) throws CoreException {
		if (modelURI != null) {
			List<URI> modelURIs = new LinkedList<URI>();
			modelURIs.add(modelURI);
			QVToLauncherHelper.modelTransform(monitor, TYPE_INTERFERENCE, modelURIs, "", refresh);
		}
	}
}
