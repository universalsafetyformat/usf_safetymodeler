/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.example;

import java.util.Arrays;

import org.eclipse.core.resources.IFile;

public class DefaultModelCreationHelper extends DataCreationHelper {

	public void createModel(IFile modelFile) {
		initModel();
		createPrimitiveType("Integer", "Double", "Boolean", "String", "Byte");
		saveModel(modelFile);
	}

	private void createPrimitiveType(String... names) {
		if (names.length == 0) {
			return;
		}

		Arrays.asList(names).forEach(name -> {
			if (name != null && !name.isEmpty()) {
				createDomainType(name);
			}
		});
	}

	@Override
	protected void createBlockData() {

	}

}
