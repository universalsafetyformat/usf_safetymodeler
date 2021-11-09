/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.transformation.language.ui.syntax;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import org.eclipse.xtext.ui.editor.utils.TextStyle
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.RGB
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor

class USFLanguageHighlightingConfiguration extends DefaultHighlightingConfiguration{
	
	
	override configure(IHighlightingConfigurationAcceptor acceptor) {
		
			// USF Language Styles
		acceptor.acceptDefaultHighlighting(USFLanguageHighlightStyles.USF_TRANSFORMATION_KEYWORDS_ID, "tranformation_keywords", otherKeywordTextStyle());
		acceptor.acceptDefaultHighlighting(USFLanguageHighlightStyles.EXPRESIONS_ID, "expressions", exprestionsTestStyle());
		acceptor.acceptDefaultHighlighting(USFLanguageHighlightStyles.RULE_ID, "id", taskTextStyle());
		acceptor.acceptDefaultHighlighting(USFLanguageHighlightStyles.ECLASS_ID, "eclasses", eClassesTextStyle());
		
		
		// Default Styles
		super.configure(acceptor);
	}
	
		
	def TextStyle eClassesTextStyle() {
		val textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 0, 200));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}
		
	
	override TextStyle taskTextStyle() {
		val textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 2, 3));
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}

	def TextStyle otherKeywordTextStyle() {
		val textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 153, 0));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}
	
	def TextStyle exprestionsTestStyle() {
		val textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(240,165,0));
		textStyle.setStyle(SWT.BOLD.bitwiseOr(SWT.ITALIC));
		return textStyle;
	}
	
}