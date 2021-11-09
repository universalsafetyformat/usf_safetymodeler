/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.modelcleaner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.safe4i.usf.core.usfmodel.block.AssemblyDataFlowConnection;
import org.safe4i.usf.core.usfmodel.block.BlockType;
import org.safe4i.usf.core.usfmodel.block.Connection;
import org.safe4i.usf.core.usfmodel.block.DelegateDataFlowConnection;
import org.safe4i.usf.core.usfmodel.common.IModelContent;
import org.safe4i.usf.core.usfmodel.common.Model;
import org.safe4i.usf.core.usfmodel.common.Package;
import org.safe4i.usf.core.usfmodel.controlFlow.AssemblyControlFlowConnection;
import org.safe4i.usf.core.usfmodel.controlFlow.DelegateControlFlowConnection;

public enum ConnectionCleaner implements IContentCleaner {

	INSTANCE;

	@Override
	public List<EObject> getUnUsedContent(Model rootElement) {
		if (rootElement.getContent().isEmpty()) {
			return Collections.emptyList();
		}

		final Set<EObject> unUsedConnections = new HashSet<>();
		for (final IModelContent content : rootElement.getContent()) {
			getUnsetConnections(content, unUsedConnections);
		}

		return new ArrayList<>(unUsedConnections);
	}

	/**
	 * 
	 * @param content
	 * @param unUsedConnections
	 */
	private void getUnsetConnections(IModelContent content, Set<EObject> unUsedConnections) {
		if (content instanceof BlockType) {
			final BlockType blockType = (BlockType) content;

			blockType.getDataFlowConnections().forEach(conn -> {
				if (!validateConnections(conn)) {
					unUsedConnections.add(conn);
				}
			});

			blockType.getControlFlowConnections().forEach(conn -> {
				if (!validateConnections(conn)) {
					unUsedConnections.add(conn);
				}
			});

		}

		if (content instanceof Package && !((Package) content).getContent().isEmpty()) {
			final Package package1 = (Package) content;
			package1.getContent().forEach(childContent -> {
				getUnsetConnections(childContent, unUsedConnections);
			});
		}
	}

	/**
	 * 
	 * @param connection
	 * @return true if a connection is valid ( a valid connection most have both sources and ports != null )
	 */
	private boolean validateConnections(Connection connection) {

		if (connection instanceof AssemblyDataFlowConnection) {
			final AssemblyDataFlowConnection conn = (AssemblyDataFlowConnection) connection;
			if (conn.getDestinationBlock() != null && conn.getSourceBlock() != null && conn.getDestinationPort() != null && conn.getSourcePort() != null) {
				return true;
			}
		}

		if (connection instanceof DelegateDataFlowConnection) {
			final DelegateDataFlowConnection conn = (DelegateDataFlowConnection) connection;
			if (conn.getInnerBlock() != null && conn.getDestinationPort() != null && conn.getSourcePort() != null) {
				return true;
			}
		}

		if (connection instanceof AssemblyControlFlowConnection) {
			final AssemblyControlFlowConnection conn = (AssemblyControlFlowConnection) connection;
			if (conn.getDestinationBlock() != null && conn.getSourceBlock() != null && conn.getDestinationPort() != null && conn.getSourcePort() != null) {
				return true;
			}
		}

		if (connection instanceof DelegateControlFlowConnection) {
			final DelegateControlFlowConnection conn = (DelegateControlFlowConnection) connection;
			if (conn.getInnerBlock() != null && conn.getDestinationPort() != null && conn.getSourcePort() != null) {
				return true;
			}
		}

		return false;
	}

}
