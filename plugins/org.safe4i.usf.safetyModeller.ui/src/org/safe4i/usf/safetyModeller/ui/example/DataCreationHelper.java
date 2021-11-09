/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.safe4i.usf.core.usfmodel.block.AbstractBlockType;
import org.safe4i.usf.core.usfmodel.block.AssemblyDataFlowConnection;
import org.safe4i.usf.core.usfmodel.block.Block;
import org.safe4i.usf.core.usfmodel.block.BlockType;
import org.safe4i.usf.core.usfmodel.block.BlocksPackage;
import org.safe4i.usf.core.usfmodel.block.DataFlowPort;
import org.safe4i.usf.core.usfmodel.block.PortDirection;
import org.safe4i.usf.core.usfmodel.common.CommonsFactory;
import org.safe4i.usf.core.usfmodel.common.CommonsPackage;
import org.safe4i.usf.core.usfmodel.common.DomainType;
import org.safe4i.usf.core.usfmodel.common.Model;
import org.safe4i.usf.core.usfmodel.common.PrimitiveType;
import org.safe4i.usf.safetyModeller.ui.Activator;

public abstract class DataCreationHelper {

	protected Model model;
	protected Map<String, BlockType> blockTypeMap = new HashMap<>();
	protected Map<String, Block> blockMap = new HashMap<>();
	protected Map<String, DataFlowPort> portMap = new HashMap<>();
	protected Map<String, DomainType> typeMap = new HashMap<>();

	protected Model initModel() {
		model = CommonsFactory.eINSTANCE.createModel();
		createBlockData();
		return model;
	}

	protected void saveModel(IFile modelFile) {
		if (modelFile == null || modelFile.getLocationURI() == null) {
			return;
		}
		final String path = modelFile.getLocationURI().getPath();

		final ResourceSet resSet = new ResourceSetImpl();
		final Resource res = resSet.createResource(URI.createFileURI(path));
		res.getContents().add(model);
		try {
			Activator.getDefault().getLog().log(new Status(IStatus.INFO, Activator.PLUGIN_ID, "Create Model File: " + path));
			res.save(null);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	protected abstract void createBlockData();

	protected void createConnector(BlockType parentBlockType, Block sourceBlock, DataFlowPort source, Block targetBlock, DataFlowPort target) {
		final AssemblyDataFlowConnection connector = createInstance(BlocksPackage.eINSTANCE.getAssemblyDataFlowConnection());
		connector.setSourcePort(source);
		connector.setSourceBlock(sourceBlock);
		connector.setDestinationPort(target);
		connector.setDestinationBlock(targetBlock);

		parentBlockType.getDataFlowConnections().add(connector);
	}

	protected BlockType createOrGetBlockType(String typeName) {
		return blockTypeMap.computeIfAbsent(typeName, key -> {
			final BlockType type = createInstance(BlocksPackage.eINSTANCE.getBlockType());
			type.setName(key);
			model.getContent().add(type);
			return type;
		});
	}

	protected Block createOrGetBlock(BlockType parentBlockType, String blockName, String typeName) {
		return blockMap.computeIfAbsent(blockName, key -> {
			final Block block = createInstance(BlocksPackage.eINSTANCE.getBlock());
			block.setName(blockName);
			block.setType(createOrGetBlockType(typeName));
			parentBlockType.getBlocks().add(block);
			return block;
		});
	}

	protected DataFlowPort createOrGetPort(AbstractBlockType ownerBlockType, String portName, String portTypename, PortDirection direction) {
		final String portKey = ownerBlockType.getName() + portName;
		return portMap.computeIfAbsent(portKey, key -> {
			final DataFlowPort port = createInstance(BlocksPackage.eINSTANCE.getDataFlowPort());

			port.setName(portName);
			port.setType(createDomainType(portTypename));
			port.setDirection(direction);

			((BlockType) ownerBlockType).getDataFlowPorts().add(port);
			return port;
		});
	}

	/**
	 * For now we only support primitive types
	 * 
	 * @param portTypename
	 * @return
	 */
	protected DomainType createDomainType(String portTypename) {
		return typeMap.computeIfAbsent(portTypename, key -> {
			final PrimitiveType type = createInstance(CommonsPackage.eINSTANCE.getPrimitiveType());
			type.setName(portTypename);

			model.getContent().add(type);
			return type;
		});
	}

	protected <T> T createInstance(EClass eClass) {
		if (eClass == null) {
			throw new RuntimeException("EClass 'null' is invalid");
		}

		@SuppressWarnings("unchecked")
		final T element = (T) eClass.getEPackage().getEFactoryInstance().create(eClass);
		// if (element instanceof IIdentifiable) {
		// ((IIdentifiable) element).setUuid(UUID.randomUUID());
		// } else {
		// System.err.println("EClass '" + eClass.getName() + "' has no IIdentifiable interface!");
		// }

		return element;
	}

}
