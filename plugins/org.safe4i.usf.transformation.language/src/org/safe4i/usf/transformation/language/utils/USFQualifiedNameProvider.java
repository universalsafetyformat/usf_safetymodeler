/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.transformation.language.utils;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Hamza
 *
 */
public class USFQualifiedNameProvider {

	public String getFullyQualifiedName(EObject object) {
		EClass c = object.eClass();
		String className = c.getInstanceTypeName();
		return className;
	}

	public String getFullyQualifiedName(EClass object) {
		return object.getInstanceTypeName();
	}

}
