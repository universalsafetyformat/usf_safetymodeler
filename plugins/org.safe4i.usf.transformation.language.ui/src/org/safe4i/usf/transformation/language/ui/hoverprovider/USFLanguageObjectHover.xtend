/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.transformation.language.ui.hoverprovider

import com.google.inject.Inject
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.util.Pair;
import org.eclipse.jface.text.IRegion
import org.eclipse.xtext.util.Tuples
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.Keyword
import org.eclipse.jface.text.Region
import org.eclipse.jface.text.ITextViewer

class USFLanguageObjectHover extends DispatchingEObjectTextHover {
	
	
	@Inject USFLanguageHoverProvider hoverProvider
	

	override getHoverInfo(EObject first, ITextViewer textViewer, IRegion hoverRegion) {
		var creatorProvider = hoverProvider.getHoverInfo(first, textViewer, hoverRegion);
		if(creatorProvider === null){
			return null;
		}
		this.lastCreatorProvider = creatorProvider
		return lastCreatorProvider.info
	}
	
	
	override protected getXtextElementAt(XtextResource resource, int offset) {
		var Pair<EObject,IRegion> result = super.getXtextElementAt(resource, offset)
		if(result === null){
			result = resolveKeywords(resource,offset)
		}
		return result
	}
	
	
	
	
	def Pair<EObject,IRegion> resolveKeywords(XtextResource resource, int offset){
		var  parseResult = resource.getParseResult();
		if (parseResult !== null) {
      		var  leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
  		 	 if (leaf !== null && leaf.isHidden() && leaf.getOffset() == offset) {
       			 leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset - 1);
      			}
     		 if (leaf !== null && leaf.getGrammarElement() instanceof Keyword) {
       			var keyword = leaf.getGrammarElement();
       			var region =  new Region(leaf.getOffset(), leaf.getLength())
        		return Tuples.create(keyword,(region as IRegion));
			}
		}	
		return null
		
	}
	
	
	
}