/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.transformation.language.ui.quickfix;

import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;

/**
 * Custom quickfixes.
 *
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
public class USFLanguageQuickfixProvider extends DefaultQuickfixProvider {

	// @Fix(USFLanguageValidator.INVALID_NAME)
	// public void capitalizeName(final Issue issue, IssueResolutionAcceptor acceptor) {
	// acceptor.accept(issue, "Capitalize name", "Capitalize the name.", "upcase.png", new IModification() {
	// public void apply(IModificationContext context) throws BadLocationException {
	// IXtextDocument xtextDocument = context.getXtextDocument();
	// String firstLetter = xtextDocument.get(issue.getOffset(), 1);
	// xtextDocument.replace(issue.getOffset(), 1, firstLetter.toUpperCase());
	// }
	// });
	// }

}
