/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.transformation.language.ui.syntax

import com.google.inject.Inject
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EOperation
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.resource.XtextResource
import org.safe4i.usf.transformation.language.services.USFLanguageGrammarAccess

class USFLanguageSemanticHightlightingCalculator extends DefaultSemanticHighlightingCalculator {
	
	
	@Inject package USFLanguageGrammarAccess usfLanguageGrammarAccess
	
	
	override protected highlightTasks(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		val root = resource.parseResult.rootNode
		val  rootTree = root.asTreeIterable
		for(node:rootTree){
			val grammerElement = node.grammarElement
			if(grammerElement instanceof CrossReference){
				val instanceClass = (grammerElement as CrossReference).type.classifier.instanceClass
				if(instanceClass ==  EOperation){
					acceptor.addPosition(node.offset,node.length,USFLanguageHighlightStyles.EXPRESIONS_ID)
				}else if(instanceClass ==  EClass){
					acceptor.addPosition(node.offset,node.length,USFLanguageHighlightStyles.ECLASS_ID)
				}
			}
			
			if(grammerElement ==  usfLanguageGrammarAccess.featureCallExpressionAccess.structuralFeatureETypedElementCrossReference_2_0){
				acceptor.addPosition(node.offset,node.length,USFLanguageHighlightStyles.EXPRESIONS_ID)
			}
			
			
			if(grammerElement instanceof Keyword){
				val keyword = (grammerElement as Keyword)
				if(keyword.value.equals("PRECONDITION") || keyword.value.equals("RULES") || keyword.value.equals("RETURN")){
					acceptor.addPosition(node.offset,node.length,USFLanguageHighlightStyles.USF_TRANSFORMATION_KEYWORDS_ID)
				}
			}
		}
		
		super.highlightTasks(resource, acceptor)
	}
	
	
}