/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.transformation.language;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class USFLanguageStandaloneSetup extends USFLanguageStandaloneSetupGenerated {

	public static void doSetup() {
		new USFLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
