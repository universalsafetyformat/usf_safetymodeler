/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.transformation.language.ui.codemining;

import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.codemining.ICodeMining;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.codemining.AbstractXtextCodeMiningProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.safe4i.usf.model.transformation.Parameter;
import org.safe4i.usf.model.transformation.Transformation;
import org.safe4i.usf.model.transformation.TypedMember;
import org.safe4i.usf.model.transformation.VariableDeclaration;

@SuppressWarnings("restriction")
public class USFLanguageCodeMiningProvider extends AbstractXtextCodeMiningProvider {

	@Override
	protected void createCodeMinings(IDocument document, XtextResource resource, CancelIndicator indicator, IAcceptor<? super ICodeMining> acceptor)
			throws BadLocationException {

		System.out.println("TEST");

		if (resource.getContents().isEmpty()) {
			return;
		}

		final List<TypedMember> allTypedMembers = EcoreUtil2.eAllOfType(resource.getContents().get(0), TypedMember.class);
		int parameterCount = 0;
		int variableCount = 0;
		;
		for (final TypedMember e : allTypedMembers) {
			if (e instanceof Parameter) {
				parameterCount++;
			}
			if (e instanceof VariableDeclaration) {
				variableCount++;
			}
		}

		final String parameterHeaderText = parameterCount + " " + (parameterCount == 1 ? "parameter" : "parameters");
		final String variableHeaderText = variableCount + " " + (variableCount == 1 ? "variable" : "variables");

		final List<Transformation> transformationList = EcoreUtil2.eAllOfType(resource.getContents().get(0), Transformation.class);

		System.out.println("T: " + transformationList);

		final ICompositeNode node = NodeModelUtils.getNode(transformationList.get(0));
		final int beforeLineNumber = document.getLineOfOffset(node.getOffset());
		// create two line header code minings before the transformation: one for the
		// Parameters, one for the Variables
		acceptor.accept(createNewLineHeaderCodeMining(beforeLineNumber, document, parameterHeaderText));
		acceptor.accept(createNewLineHeaderCodeMining(beforeLineNumber, document, variableHeaderText));

	}
}
