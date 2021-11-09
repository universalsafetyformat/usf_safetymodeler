/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.transformation.language.ui.hoverprovider;

import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;
import org.safe4i.usf.transformation.language.ui.internal.LanguageActivator;

/**
 * @author Hamza
 *
 */
public enum USFClassComentLoader {

	INSTANCE;

	@SuppressWarnings("unchecked")
	public Map<String, String> loadClassComments() {
		final Bundle bundle = Platform.getBundle(LanguageActivator.PLUGIN_ID);
		final URL fileURL = bundle.getEntry("comment-docu/usfShortDoc.docu");
		try (ObjectInputStream ois = new ObjectInputStream(fileURL.openStream())) {
			final Map<String, String> mapInFile = (HashMap<String, String>) ois.readObject();
			return mapInFile;
		} catch (final Exception e) {
			LanguageActivator.getInstance().getLog().log(new Status(IStatus.ERROR, LanguageActivator.PLUGIN_ID, e.getMessage(), e));
		}
		return Collections.emptyMap();
	}

}
