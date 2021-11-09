/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.modelcleaner;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.safe4i.usf.core.usfmodel.common.Model;

public interface IContentCleaner {

	/**
	 * 
	 * @param rootElement
	 * @return all dirty content of a root element
	 */
	List<EObject> getUnUsedContent(Model rootElement);

}
