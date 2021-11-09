/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.visualisation.services;

import org.eclipse.emf.ecore.EObject;
import org.safe4i.usf.core.usfmodel.block.BlockType;
import org.safe4i.usf.core.usfmodel.controlFlow.ControlFlowConnection;
import org.safe4i.usf.core.usfmodel.controlFlow.ControlFlowPort;

public enum ConnectionCreationChecker {

	INSTANCE;

	public boolean isValidConnectionStart(final ControlFlowPort port, final EObject container) {
		boolean validConnectionStart = true;
		final BlockType rootContainer = (BlockType) container;
		for (final ControlFlowConnection conn : rootContainer.getControlFlowConnections()) {
			if (conn.getSourcePort().equals(port)) {
				validConnectionStart = false;
			}
		}
		return validConnectionStart;
	}

	public boolean isValidConnectionEnd(final ControlFlowPort port, final EObject container) {
		boolean validConnectionStart = true;
		final BlockType rootContainer = (BlockType) container;
		for (final ControlFlowConnection conn : rootContainer.getControlFlowConnections()) {
			if (conn.getDestinationPort().equals(port)) {
				validConnectionStart = false;
			}
		}
		return validConnectionStart;
	}

}
