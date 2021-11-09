/*******************************************************************************
* Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
* This program and the accompanying materials are made available under the
* terms of the Eclipse Public License 2.0 which is available at
* http://www.eclipse.org/legal/epl-2.0.
* 
* SPDX-License-Identifier: EPL-2.0
*******************************************************************************/
package org.safe4i.usf.transformation.language.parser.antlr;

import com.google.inject.Inject;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.safe4i.usf.transformation.language.parser.antlr.internal.InternalUSFLanguageParser;
import org.safe4i.usf.transformation.language.services.USFLanguageGrammarAccess;

public class USFLanguageParser extends AbstractAntlrParser {

	@Inject
	private USFLanguageGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected TokenSource createLexer(CharStream stream) {
		return new USFLanguageTokenSource(super.createLexer(stream));
	}
	
	/**
	 * Indentation aware languages do not support partial parsing since the lexer is inherently stateful.
	 * Override and return {@code true} if your terminal splitting is stateless.
	 */
	@Override
	protected boolean isReparseSupported() {
		return false;
	}

	@Override
	protected InternalUSFLanguageParser createParser(XtextTokenStream stream) {
		return new InternalUSFLanguageParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Transformation";
	}

	public USFLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(USFLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
