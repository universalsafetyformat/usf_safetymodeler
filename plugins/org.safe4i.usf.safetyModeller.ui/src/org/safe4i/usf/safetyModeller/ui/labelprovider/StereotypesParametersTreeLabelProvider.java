/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.labelprovider;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProvider;
import org.eclipse.jface.resource.ResourceLocator;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.safe4i.usf.core.usfmodel.common.NamedElement;
import org.safe4i.usf.core.usfmodel.parameter.BlockParameterValue;
import org.safe4i.usf.core.usfmodel.parameter.BlockTypeParameterValue;
import org.safe4i.usf.core.usfmodel.parameter.ConnectionParameterValue;
import org.safe4i.usf.core.usfmodel.parameter.ParametersPackage;
import org.safe4i.usf.core.usfmodel.parameter.PortParameterValue;
import org.safe4i.usf.core.usfmodel.parameter.PrimitiveParameterValue;
import org.safe4i.usf.core.usfmodel.portTemplate.TemplateAssignment;
import org.safe4i.usf.safetyModeller.ui.Activator;
import org.safe4i.usf.safetyModeller.ui.contentprovider.model.VirtualGroupTreeItem;
import org.safe4i.usf.safetyModeller.ui.contentprovider.model.VirtualStereotypeTreeItem;
import org.safe4i.usf.safetyModeller.ui.contentprovider.model.VirtualTreeItem;

public class StereotypesParametersTreeLabelProvider extends CellLabelProvider {

	private static final String NO_TYPE_SET = "No Type";

	private static final ReflectiveItemProvider LABEL_PROVIDER = new ReflectiveItemProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	private static final Image STEREOTYPE_IMAGE = ResourceLocator.imageDescriptorFromBundle(Activator.PLUGIN_ID, "icons/16x16/icons/tag.png").get()
			.createImage();
	private static final Image TEMPLATE_IMAGE = ResourceLocator.imageDescriptorFromBundle(Activator.PLUGIN_ID, "icons/16x16/icons/tag.png").get().createImage();
	private static final Image PARAMETER_IMAGE = ResourceLocator.imageDescriptorFromBundle(Activator.PLUGIN_ID, "icons/16x16/icons/page_white.png").get()
			.createImage();
	private static final Color DEFAULT_VALUE_BACKGROUND_COLOR = new Color(Display.getDefault(), new RGB(200, 200, 255));
	private static final String UNSET_LITERAL = "<Unset>";

	private String getName(Object obj) {
		if (obj instanceof NamedElement) {
			return ((NamedElement) obj).getName();
		} else if (obj instanceof VirtualTreeItem) {
			return ((VirtualTreeItem) obj).getName();
		} else if (obj instanceof PrimitiveParameterValue) {
			return ((PrimitiveParameterValue) obj).getParameter() != null ? ((PrimitiveParameterValue) obj).getParameter().getName() : NO_TYPE_SET;
		} else if (obj instanceof BlockParameterValue) {
			return ((BlockParameterValue) obj).getParameter() != null ? ((BlockParameterValue) obj).getParameter().getName() : NO_TYPE_SET;
		} else if (obj instanceof BlockTypeParameterValue) {
			return ((BlockTypeParameterValue) obj).getParameter() != null ? ((BlockTypeParameterValue) obj).getParameter().getName() : NO_TYPE_SET;
		} else if (obj instanceof PortParameterValue) {
			return ((PortParameterValue) obj).getParameter() != null ? ((PortParameterValue) obj).getParameter().getName() : NO_TYPE_SET;
		} else if (obj instanceof ConnectionParameterValue) {
			return ((ConnectionParameterValue) obj).getParameter() != null ? ((ConnectionParameterValue) obj).getParameter().getName() : NO_TYPE_SET;
		} else if (obj instanceof TemplateAssignment) {
			return "< " + ((TemplateAssignment) obj).getTemplateType().getName() + " >";
		}
		return obj == null ? "N/A" : obj.toString();
	}

	private String getValue(Object obj) {
		if (obj instanceof VirtualTreeItem) {
			return ((VirtualTreeItem) obj).getValue();
		} else if (obj instanceof PrimitiveParameterValue) {
			final PrimitiveParameterValue paramValue = (PrimitiveParameterValue) obj;
			if (!paramValue.eIsSet(ParametersPackage.eINSTANCE.getPrimitiveParameterValue_Value())) {
				final String value = paramValue.getParameter().getDefaultValue();
				if (value == null) {
					return UNSET_LITERAL;
				}
				return paramValue.getParameter().getDefaultValue();
			}
			final String value = paramValue.getValue();
			if (value == null) {
				return UNSET_LITERAL;
			}
			return paramValue.getValue();
		} else if (obj instanceof BlockParameterValue) {
			final BlockParameterValue paramValue = (BlockParameterValue) obj;
			return paramValue.getValue() != null ? paramValue.getValue().getName() : "";
		} else if (obj instanceof BlockTypeParameterValue) {
			final BlockTypeParameterValue paramValue = (BlockTypeParameterValue) obj;
			return paramValue.getValue() != null ? paramValue.getValue().getName() : "";
		} else if (obj instanceof PortParameterValue) {
			final PortParameterValue paramValue = (PortParameterValue) obj;
			return paramValue.getValue() != null ? paramValue.getValue().getName() : "";
		} else if (obj instanceof ConnectionParameterValue) {
			final ConnectionParameterValue paramValue = (ConnectionParameterValue) obj;
			return paramValue.getValue() != null ? LABEL_PROVIDER.getText(paramValue.getValue()) : "";
		} else if (obj instanceof TemplateAssignment) {
			return ((TemplateAssignment) obj).getResolvedType().getName();
		}
		return "";
	}

	public String getColumnText(Object obj, int index) {
		switch (index) {
		case 0:
			return getName(obj);
		case 1:
			return getValue(obj);
		default:
			return "No valid column index!";
		}
	}

	public Image getColumnImage(Object obj, int index) {
		if (index == 0) {
			return getImage(obj);
		} else {
			return null;
		}
	}

	public Image getImage(Object obj) {
		if (obj instanceof PrimitiveParameterValue) {
			return PARAMETER_IMAGE;
		} else if (obj instanceof VirtualStereotypeTreeItem) {
			return TEMPLATE_IMAGE;
		} else if (obj instanceof TemplateAssignment) {
			return STEREOTYPE_IMAGE;
		} else if (obj instanceof VirtualGroupTreeItem<?>) {
			final String name = ((VirtualGroupTreeItem<?>) obj).getName();
			if (name.equals("Stereotypes")) {
				return STEREOTYPE_IMAGE;
			} else if (name.equals("Template Assignments")) {
				return TEMPLATE_IMAGE;
			} else {
				return PARAMETER_IMAGE;
			}
		}
		return null;
	}

	@Override
	public void update(ViewerCell cell) {
		final Object elem = cell.getElement();
		final int index = cell.getColumnIndex();
		cell.setText(getColumnText(elem, index));
		// cell.setText("[" + elem.getClass().getSimpleName() + "] " + getColumnText(elem, index));
		cell.setImage(getColumnImage(elem, index));
		if (elem instanceof PrimitiveParameterValue) {
			if (!((PrimitiveParameterValue) elem).eIsSet(ParametersPackage.eINSTANCE.getPrimitiveParameterValue_Value())) {
				cell.setBackground(DEFAULT_VALUE_BACKGROUND_COLOR);
			} else {
				cell.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
			}
		}
	}
}
