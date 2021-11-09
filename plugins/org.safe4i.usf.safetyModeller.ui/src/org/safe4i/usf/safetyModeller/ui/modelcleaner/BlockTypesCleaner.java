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
import org.safe4i.usf.core.usfmodel.block.AbstractBlockType;
import org.safe4i.usf.core.usfmodel.block.BlockType;
import org.safe4i.usf.core.usfmodel.common.IModelContent;
import org.safe4i.usf.core.usfmodel.common.Model;
import org.safe4i.usf.core.usfmodel.common.Package;

public enum BlockTypesCleaner implements IContentCleaner {

	INSTANCE;

	@Override
	public List<EObject> getUnUsedContent(Model rootElement) {

		if (rootElement.getContent().isEmpty()) {
			return new ArrayList<>();
		}

		final Set<EObject> stillInUseBlockTypes = new HashSet<>();
		final Set<EObject> unUsedBlockTypes = new HashSet<>();

		for (final IModelContent content : rootElement.getContent()) {
			getBlockTypesStillInUse(content, stillInUseBlockTypes);
		}

		rootElement.getContent().forEach(conn -> {
			if (conn instanceof AbstractBlockType && !stillInUseBlockTypes.contains(conn)) {
				unUsedBlockTypes.add(conn);
			}

			if (conn instanceof Package && !((Package) conn).getContent().isEmpty()) {
				final Package package1 = (Package) conn;
				package1.getContent().forEach(childContent -> {
					getUnUsedBlockTypesFromPackage(childContent, unUsedBlockTypes, Collections.unmodifiableSet(stillInUseBlockTypes));
				});
			}

		});

		return new ArrayList<>(unUsedBlockTypes);

	}

	private void getBlockTypesStillInUse(IModelContent content, Set<EObject> stillInUseBlockTypes) {
		if (content instanceof BlockType) {
			final BlockType blockType = (BlockType) content;
			if (!blockType.getBlocks().isEmpty()) {
				stillInUseBlockTypes.add(blockType);
				blockType.getBlocks().forEach(block -> {
					if (block.getType() != null) {
						stillInUseBlockTypes.add(block.getType());
					}
				});
			}
		}
		if (content instanceof Package && !((Package) content).getContent().isEmpty()) {
			final Package package1 = (Package) content;
			package1.getContent().forEach(childContent -> {
				getBlockTypesStillInUse(childContent, stillInUseBlockTypes);
			});
		}
	}

	private void getUnUsedBlockTypesFromPackage(IModelContent childContent, Set<EObject> unUsedBlockTypes, Set<EObject> stillInUseBlockTypes) {
		if (childContent instanceof BlockType && !stillInUseBlockTypes.contains(childContent)) {
			unUsedBlockTypes.add(childContent);
		}

		if (childContent instanceof AbstractBlockType && !stillInUseBlockTypes.contains(childContent)) {
			unUsedBlockTypes.add(childContent);
		}

		if (childContent instanceof Package && !((Package) childContent).getContent().isEmpty()) {
			final Package package1 = (Package) childContent;
			package1.getContent().forEach(innerContent -> getUnUsedBlockTypesFromPackage(innerContent, unUsedBlockTypes, stillInUseBlockTypes));
		}

	}

}
