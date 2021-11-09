/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.views;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.safe4i.usf.core.usfmodel.block.Block;
import org.safe4i.usf.core.usfmodel.block.BlockType;
import org.safe4i.usf.core.usfmodel.block.Connection;
import org.safe4i.usf.core.usfmodel.block.Port;
import org.safe4i.usf.core.usfmodel.parameter.BlockParameterValue;
import org.safe4i.usf.core.usfmodel.parameter.BlockTypeParameterValue;
import org.safe4i.usf.core.usfmodel.parameter.ConnectionParameterValue;
import org.safe4i.usf.core.usfmodel.parameter.ParametersPackage;
import org.safe4i.usf.core.usfmodel.parameter.PortParameterValue;
import org.safe4i.usf.core.usfmodel.parameter.PrimitiveParameterValue;

/**
 * @author Hamza
 *
 */
public class StereoTypesAndParameterEditingSupport extends EditingSupport {

	private final TextCellEditor cellEditor;
	private final TreeViewer viewer;

	public StereoTypesAndParameterEditingSupport(TreeViewer treeViewer) {
		super(treeViewer);
		this.viewer = treeViewer;
		cellEditor = new TextCellEditor(this.viewer.getTree());
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return cellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {
		return element instanceof PrimitiveParameterValue;
	}

	@Override
	protected Object getValue(Object element) {
		if (element instanceof PrimitiveParameterValue) {
			if (((PrimitiveParameterValue) element).getValue() == null) {
				return "";
			}
			return ((PrimitiveParameterValue) element).getValue();
		} else if (element instanceof BlockParameterValue) {
			return ((BlockParameterValue) element).getValue();
		} else if (element instanceof BlockTypeParameterValue) {
			return ((BlockTypeParameterValue) element).getValue();
		} else if (element instanceof PortParameterValue) {
			return ((PortParameterValue) element).getValue();
		} else if (element instanceof ConnectionParameterValue) {
			return ((ConnectionParameterValue) element).getValue();
		}
		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {
		if (element instanceof PrimitiveParameterValue && value instanceof String) {
			if (((String) value).isEmpty()) {
				value = null;
			}
			final EditingDomain editDomain = ModelHelper.INSTANCE.getEditingDomain((EObject) element);
			final SetCommand setCmd = new SetCommand(editDomain, (PrimitiveParameterValue) element,
					ParametersPackage.eINSTANCE.getPrimitiveParameterValue_Value(), value);
			editDomain.getCommandStack().execute(setCmd);
			viewer.update(element, null);
		} else if (element instanceof BlockParameterValue && value instanceof Block) {
			final EditingDomain editDomain = ModelHelper.INSTANCE.getEditingDomain((EObject) element);
			final SetCommand setCmd = new SetCommand(editDomain, (BlockParameterValue) element, ParametersPackage.eINSTANCE.getBlockParameterValue_Value(),
					value);
			editDomain.getCommandStack().execute(setCmd);
			viewer.update(element, null);
		} else if (element instanceof BlockTypeParameterValue && value instanceof BlockType) {
			final EditingDomain editDomain = ModelHelper.INSTANCE.getEditingDomain((EObject) element);
			final SetCommand setCmd = new SetCommand(editDomain, (BlockTypeParameterValue) element,
					ParametersPackage.eINSTANCE.getBlockTypeParameterValue_Value(), value);
			editDomain.getCommandStack().execute(setCmd);
			viewer.update(element, null);
		} else if (element instanceof PortParameterValue && value instanceof Port) {
			final EditingDomain editDomain = ModelHelper.INSTANCE.getEditingDomain((EObject) element);
			final SetCommand setCmd = new SetCommand(editDomain, (PortParameterValue) element, ParametersPackage.eINSTANCE.getPortParameterValue_Value(),
					value);
			editDomain.getCommandStack().execute(setCmd);
			viewer.update(element, null);
		} else if (element instanceof ConnectionParameterValue && value instanceof Connection) {
			final EditingDomain editDomain = ModelHelper.INSTANCE.getEditingDomain((EObject) element);
			final SetCommand setCmd = new SetCommand(editDomain, (ConnectionParameterValue) element,
					ParametersPackage.eINSTANCE.getConnectionParameterValue_Value(), value);
			editDomain.getCommandStack().execute(setCmd);
			viewer.update(element, null);
		}

	}

}
