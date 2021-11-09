/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.transformation.language.ide;

import org.eclipse.xtext.util.Modules2;
import org.safe4i.usf.transformation.language.USFLanguageRuntimeModule;
import org.safe4i.usf.transformation.language.USFLanguageStandaloneSetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class USFLanguageIdeSetup extends USFLanguageStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new USFLanguageRuntimeModule(), new USFLanguageIdeModule()));
	}

}
