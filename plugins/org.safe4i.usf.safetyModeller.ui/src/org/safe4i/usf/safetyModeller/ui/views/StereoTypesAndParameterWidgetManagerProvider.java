/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.views;

import org.eclipse.eef.EEFControlDescription;
import org.eclipse.eef.EEFCustomWidgetDescription;
import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.eef.ide.ui.api.widgets.IEEFLifecycleManager;
import org.eclipse.eef.ide.ui.api.widgets.IEEFLifecycleManagerProvider;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;

/**
 * @author Hamza
 *
 */
public class StereoTypesAndParameterWidgetManagerProvider implements IEEFLifecycleManagerProvider {

	private static final String SUPPORTED_ID = "org.safe4i.usf.core.model.ui.ext.widget.streotypesAndParameter";
	private final StereoTypesAndParameterWidgetManager widgetManager;

	public StereoTypesAndParameterWidgetManagerProvider() {
		widgetManager = new StereoTypesAndParameterWidgetManager();
	}

	@Override
	public boolean canHandle(EEFControlDescription controlDescription) {
		return SUPPORTED_ID.equals(controlDescription.getIdentifier()) && controlDescription instanceof EEFCustomWidgetDescription;
	}

	@Override
	public IEEFLifecycleManager getLifecycleManager(EEFControlDescription controlDescription, IVariableManager variableManager, IInterpreter interpreter,
			EditingContextAdapter contextAdapter) {
		if (controlDescription instanceof EEFCustomWidgetDescription) {
			return widgetManager;
		}
		throw new IllegalArgumentException();
	}

}
