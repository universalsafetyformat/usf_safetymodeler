/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.transformation.language.ui.hoverprovider

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EOperation
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider
import org.eclipse.emf.ecore.EClass
import org.safe4i.usf.core.usfmodel.common.DomainType

class USFLanguageHoverProvider extends DefaultEObjectHoverProvider {
	
	override protected getFirstLine(EObject o) {
		if(o instanceof EOperation){
			return "<b> Operation " + o.formatedMessage  + " </b>";
		}
		if(o instanceof EClass){
			return  "<b> Class "+ o.name +" </b>";
		}
		
		if(o instanceof DomainType){
			return  "<b> Type "+ o.name +" </b>";
		}
		
		super.getFirstLine(o)
		
	}
	
	
	
	def String formatedMessage(EOperation op){
		val builder = new StringBuilder
		builder.append(op.name)
		builder.append("(")
		for (var i = 0; i < op.EParameters.size; i++) {
			val param = op.EParameters.get(i)
			val paramType = param.EType.name
			val paramName = param.name
			builder.append(paramType)
			builder.append(" ")
			builder.append(paramName)
			if (i !== (op.EParameters.size -1)) {
				builder.append(", ")
			}
		}
		builder.append(")")
		builder.toString
	}
	
}
