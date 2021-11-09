/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.transformation.language.ui.hoverprovider

import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EClass
import org.safe4i.usf.core.usfmodel.common.DomainType
import java.util.Map

class USFLanguageDocumentationProvider implements IEObjectDocumentationProvider {

	Map<String, String> commentDescriptions = USFClassComentLoader.INSTANCE.loadClassComments

	override getDocumentation(EObject o) {

		if (o instanceof EOperation) {
			if (commentDescriptions.containsKey(o.key)) {
				val unformated_description = commentDescriptions.get(o.key)
				return unformated_description.formattedDocument;
			} else {
				return "No JavaDoc provided for this object"
			}
		}

		if (o instanceof EClass) {
			if (commentDescriptions.containsKey(o.key)) {
				val unformated_description = commentDescriptions.get(o.key)
				return unformated_description.formattedDocument;
			} else {
				return "No JavaDoc provided for this object"
			}
		}

		if (o instanceof DomainType) {
			if (commentDescriptions.containsKey(o.key)) {
				val unformated_description = commentDescriptions.get(o.key)
				return unformated_description.formattedDocument;
			} else {
				return "No JavaDoc provided for this object"
			}
		}

		return null;

	}

	def String formattedDocument(String unformated) {
		// add a line break for the model comment which starts with * in java doc
		var String formatedDescription = unformated.replace("*", "<br><br>") 
		// cut of model annotations
		var index = unformated.indexOf("@model");
		if (unformated.indexOf("@see") > index)
			index = unformated.indexOf("@see");
		formatedDescription = index > 0 ? formatedDescription.subSequence(0, index).toString : formatedDescription;

		val builder = new StringBuilder
		builder.append("<html>")
		builder.append("<p>")
		builder.append(formatedDescription)
		builder.append("</p>")
		builder.append("</html>")
		builder.toString
	}

	def String getKey(EOperation op) {
		(op.eContainer as EClass).instanceTypeName + "." + op.name
	}

	def String getKey(EClass ec) {
		ec.instanceTypeName
	}

	def String getKey(DomainType ty) {
		ty.eClass.instanceTypeName
	}

}
