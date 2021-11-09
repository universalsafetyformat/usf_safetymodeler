/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.transformation.language.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.safe4i.usf.transformation.language.ui.hoverprovider.USFLanguageDocumentationProvider;
import org.safe4i.usf.transformation.language.ui.hoverprovider.USFLanguageHoverProvider;
import org.safe4i.usf.transformation.language.ui.hoverprovider.USFLanguageObjectHover;
import org.safe4i.usf.transformation.language.ui.syntax.USFLanguageHighlightingConfiguration;
import org.safe4i.usf.transformation.language.ui.syntax.USFLanguageSemanticHightlightingCalculator;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
public class USFLanguageUiModule extends AbstractUSFLanguageUiModule {

	public USFLanguageUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return USFLanguageHighlightingConfiguration.class;
	}

	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return USFLanguageSemanticHightlightingCalculator.class;
	}

	@Override
	public Class<? extends IEObjectHover> bindIEObjectHover() {
		return USFLanguageObjectHover.class;
	}

	public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return USFLanguageHoverProvider.class;
	}

	public Class<? extends IEObjectDocumentationProvider> bindIEObjectDocumentationProviderr() {
		return USFLanguageDocumentationProvider.class;
	}

}
