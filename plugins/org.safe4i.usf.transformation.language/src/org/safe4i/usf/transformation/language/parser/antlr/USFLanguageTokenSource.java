/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.transformation.language.parser.antlr;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.parser.antlr.AbstractIndentationTokenSource;
import org.safe4i.usf.transformation.language.parser.antlr.internal.InternalUSFLanguageParser;

public class USFLanguageTokenSource extends AbstractIndentationTokenSource {

	public USFLanguageTokenSource(TokenSource delegate) {
		super(delegate);
	}

	@Override
	protected boolean shouldSplitTokenImpl(Token token) {
		// TODO Review assumption
		return token.getType() == InternalUSFLanguageParser.RULE_WS;
	}

	@Override
	protected int getBeginTokenType() {
		// TODO Review assumption
		return InternalUSFLanguageParser.RULE_BEGIN;
	}

	@Override
	protected int getEndTokenType() {
		// TODO Review assumption
		return InternalUSFLanguageParser.RULE_END;
	}

}
