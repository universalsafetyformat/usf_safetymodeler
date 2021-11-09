/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.contentprovider.model;

import java.util.LinkedList;
import java.util.List;

public class VirtualGroupTreeItem<T> extends VirtualTreeItem {

	private final List<T> childElements = new LinkedList<>();

	public VirtualGroupTreeItem(String name, List<T> children) {
		super(name, "");
		childElements.addAll(children);
	}

	public List<T> getChildren() {
		return childElements;
	}

}
