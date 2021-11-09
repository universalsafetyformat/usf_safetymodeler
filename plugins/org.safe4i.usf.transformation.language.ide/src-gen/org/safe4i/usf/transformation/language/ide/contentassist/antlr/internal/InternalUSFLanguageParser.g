/*******************************************************************************
* Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
* This program and the accompanying materials are made available under the
* terms of the Eclipse Public License 2.0 which is available at
* http://www.eclipse.org/legal/epl-2.0.
* 
* SPDX-License-Identifier: EPL-2.0
*******************************************************************************/
parser grammar InternalUSFLanguageParser;

options {
	tokenVocab=InternalUSFLanguageLexer;
	superClass=AbstractInternalContentAssistParser;
	backtrack=true;
}

@header {
package org.safe4i.usf.transformation.language.ide.contentassist.antlr.internal;
import java.util.Map;
import java.util.HashMap;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.safe4i.usf.transformation.language.services.USFLanguageGrammarAccess;

}
@members {
	private USFLanguageGrammarAccess grammarAccess;
	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
	
	{
		tokenNameToValue.put("ExclamationMark", "'!'");
		tokenNameToValue.put("LeftParenthesis", "'('");
		tokenNameToValue.put("RightParenthesis", "')'");
		tokenNameToValue.put("PlusSign", "'+'");
		tokenNameToValue.put("Comma", "','");
		tokenNameToValue.put("FullStop", "'.'");
		tokenNameToValue.put("Colon", "':'");
		tokenNameToValue.put("LessThanSign", "'<'");
		tokenNameToValue.put("EqualsSign", "'='");
		tokenNameToValue.put("GreaterThanSign", "'>'");
		tokenNameToValue.put("LeftCurlyBracket", "'{'");
		tokenNameToValue.put("RightCurlyBracket", "'}'");
		tokenNameToValue.put("ExclamationMarkEqualsSign", "'!='");
		tokenNameToValue.put("AmpersandAmpersand", "'&&'");
		tokenNameToValue.put("LessThanSignEqualsSign", "'<='");
		tokenNameToValue.put("EqualsSignEqualsSign", "'=='");
		tokenNameToValue.put("GreaterThanSignEqualsSign", "'>='");
		tokenNameToValue.put("If", "'if'");
		tokenNameToValue.put("In", "'in'");
		tokenNameToValue.put("VerticalLineVerticalLine", "'||'");
		tokenNameToValue.put("For", "'for'");
		tokenNameToValue.put("Val", "'val'");
		tokenNameToValue.put("Var", "'var'");
		tokenNameToValue.put("List", "'List'");
		tokenNameToValue.put("Else", "'else'");
		tokenNameToValue.put("Null", "'null'");
		tokenNameToValue.put("True", "'true'");
		tokenNameToValue.put("Void", "'void'");
		tokenNameToValue.put("RULES", "'RULES'");
		tokenNameToValue.put("False", "'false'");
		tokenNameToValue.put("Float", "'float'");
		tokenNameToValue.put("RETURN", "'RETURN'");
		tokenNameToValue.put("String", "'String'");
		tokenNameToValue.put("Boolean", "'boolean'");
		tokenNameToValue.put("Integer", "'integer'");
		tokenNameToValue.put("Transform", "'transform'");
		tokenNameToValue.put("PRECONDITION", "'PRECONDITION'");
		tokenNameToValue.put("PortDirectionIN", "'PortDirection.IN'");
		tokenNameToValue.put("PortDirectionOUT", "'PortDirection.OUT'");
		tokenNameToValue.put("PortDirectionINOUT", "'PortDirection.INOUT'");
		tokenNameToValue.put("PortDirectionUNSET", "'PortDirection.UNSET'");
	}

	public void setGrammarAccess(USFLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		String result = tokenNameToValue.get(tokenName);
		if (result == null)
			result = tokenName;
		return result;
	}
}

// Entry rule entryRuleTransformation
entryRuleTransformation
@init { 
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
}
:
{ before(grammarAccess.getTransformationRule()); }
	 ruleTransformation
{ after(grammarAccess.getTransformationRule()); } 
	 EOF 
;
finally {
	myHiddenTokenState.restore();
}

// Rule Transformation
ruleTransformation 
	@init {
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTransformationAccess().getGroup()); }
		(rule__Transformation__Group__0)
		{ after(grammarAccess.getTransformationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
	myHiddenTokenState.restore();
}

// Entry rule entryRuleExpression
entryRuleExpression
:
{ before(grammarAccess.getExpressionRule()); }
	 ruleExpression
{ after(grammarAccess.getExpressionRule()); } 
	 EOF 
;

// Rule Expression
ruleExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getExpressionAccess().getAlternatives()); }
		(rule__Expression__Alternatives)
		{ after(grammarAccess.getExpressionAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTransformationType
entryRuleTransformationType
:
{ before(grammarAccess.getTransformationTypeRule()); }
	 ruleTransformationType
{ after(grammarAccess.getTransformationTypeRule()); } 
	 EOF 
;

// Rule TransformationType
ruleTransformationType 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTransformationTypeAccess().getAlternatives()); }
		(rule__TransformationType__Alternatives)
		{ after(grammarAccess.getTransformationTypeAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTypeBasedTransformationType
entryRuleTypeBasedTransformationType
:
{ before(grammarAccess.getTypeBasedTransformationTypeRule()); }
	 ruleTypeBasedTransformationType
{ after(grammarAccess.getTypeBasedTransformationTypeRule()); } 
	 EOF 
;

// Rule TypeBasedTransformationType
ruleTypeBasedTransformationType 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTypeBasedTransformationTypeAccess().getTypeAssignment()); }
		(rule__TypeBasedTransformationType__TypeAssignment)
		{ after(grammarAccess.getTypeBasedTransformationTypeAccess().getTypeAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEClassBasedTransformationType
entryRuleEClassBasedTransformationType
:
{ before(grammarAccess.getEClassBasedTransformationTypeRule()); }
	 ruleEClassBasedTransformationType
{ after(grammarAccess.getEClassBasedTransformationTypeRule()); } 
	 EOF 
;

// Rule EClassBasedTransformationType
ruleEClassBasedTransformationType 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEClassBasedTransformationTypeAccess().getGroup()); }
		(rule__EClassBasedTransformationType__Group__0)
		{ after(grammarAccess.getEClassBasedTransformationTypeAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleListBasedTransformationType
entryRuleListBasedTransformationType
:
{ before(grammarAccess.getListBasedTransformationTypeRule()); }
	 ruleListBasedTransformationType
{ after(grammarAccess.getListBasedTransformationTypeRule()); } 
	 EOF 
;

// Rule ListBasedTransformationType
ruleListBasedTransformationType 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getListBasedTransformationTypeAccess().getGroup()); }
		(rule__ListBasedTransformationType__Group__0)
		{ after(grammarAccess.getListBasedTransformationTypeAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleParameter
entryRuleParameter
:
{ before(grammarAccess.getParameterRule()); }
	 ruleParameter
{ after(grammarAccess.getParameterRule()); } 
	 EOF 
;

// Rule Parameter
ruleParameter 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getParameterAccess().getAlternatives()); }
		(rule__Parameter__Alternatives)
		{ after(grammarAccess.getParameterAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTypeBasedParameter
entryRuleTypeBasedParameter
:
{ before(grammarAccess.getTypeBasedParameterRule()); }
	 ruleTypeBasedParameter
{ after(grammarAccess.getTypeBasedParameterRule()); } 
	 EOF 
;

// Rule TypeBasedParameter
ruleTypeBasedParameter 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTypeBasedParameterAccess().getGroup()); }
		(rule__TypeBasedParameter__Group__0)
		{ after(grammarAccess.getTypeBasedParameterAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEClassBasedParameter
entryRuleEClassBasedParameter
:
{ before(grammarAccess.getEClassBasedParameterRule()); }
	 ruleEClassBasedParameter
{ after(grammarAccess.getEClassBasedParameterRule()); } 
	 EOF 
;

// Rule EClassBasedParameter
ruleEClassBasedParameter 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEClassBasedParameterAccess().getGroup()); }
		(rule__EClassBasedParameter__Group__0)
		{ after(grammarAccess.getEClassBasedParameterAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleListBasedParameter
entryRuleListBasedParameter
:
{ before(grammarAccess.getListBasedParameterRule()); }
	 ruleListBasedParameter
{ after(grammarAccess.getListBasedParameterRule()); } 
	 EOF 
;

// Rule ListBasedParameter
ruleListBasedParameter 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getListBasedParameterAccess().getGroup()); }
		(rule__ListBasedParameter__Group__0)
		{ after(grammarAccess.getListBasedParameterAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleConcatenationExpression
entryRuleConcatenationExpression
:
{ before(grammarAccess.getConcatenationExpressionRule()); }
	 ruleConcatenationExpression
{ after(grammarAccess.getConcatenationExpressionRule()); } 
	 EOF 
;

// Rule ConcatenationExpression
ruleConcatenationExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getConcatenationExpressionAccess().getGroup()); }
		(rule__ConcatenationExpression__Group__0)
		{ after(grammarAccess.getConcatenationExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePrimary
entryRulePrimary
:
{ before(grammarAccess.getPrimaryRule()); }
	 rulePrimary
{ after(grammarAccess.getPrimaryRule()); } 
	 EOF 
;

// Rule Primary
rulePrimary 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPrimaryAccess().getAlternatives()); }
		(rule__Primary__Alternatives)
		{ after(grammarAccess.getPrimaryAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStringLiteral
entryRuleStringLiteral
:
{ before(grammarAccess.getStringLiteralRule()); }
	 ruleStringLiteral
{ after(grammarAccess.getStringLiteralRule()); } 
	 EOF 
;

// Rule StringLiteral
ruleStringLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStringLiteralAccess().getValueAssignment()); }
		(rule__StringLiteral__ValueAssignment)
		{ after(grammarAccess.getStringLiteralAccess().getValueAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleNumberLiteral
entryRuleNumberLiteral
:
{ before(grammarAccess.getNumberLiteralRule()); }
	 ruleNumberLiteral
{ after(grammarAccess.getNumberLiteralRule()); } 
	 EOF 
;

// Rule NumberLiteral
ruleNumberLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getNumberLiteralAccess().getValueAssignment()); }
		(rule__NumberLiteral__ValueAssignment)
		{ after(grammarAccess.getNumberLiteralAccess().getValueAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleNullLiteral
entryRuleNullLiteral
:
{ before(grammarAccess.getNullLiteralRule()); }
	 ruleNullLiteral
{ after(grammarAccess.getNullLiteralRule()); } 
	 EOF 
;

// Rule NullLiteral
ruleNullLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getNullLiteralAccess().getGroup()); }
		(rule__NullLiteral__Group__0)
		{ after(grammarAccess.getNullLiteralAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleBooleanLiteral
entryRuleBooleanLiteral
:
{ before(grammarAccess.getBooleanLiteralRule()); }
	 ruleBooleanLiteral
{ after(grammarAccess.getBooleanLiteralRule()); } 
	 EOF 
;

// Rule BooleanLiteral
ruleBooleanLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getBooleanLiteralAccess().getGroup()); }
		(rule__BooleanLiteral__Group__0)
		{ after(grammarAccess.getBooleanLiteralAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePortDirectionLiteral
entryRulePortDirectionLiteral
:
{ before(grammarAccess.getPortDirectionLiteralRule()); }
	 rulePortDirectionLiteral
{ after(grammarAccess.getPortDirectionLiteralRule()); } 
	 EOF 
;

// Rule PortDirectionLiteral
rulePortDirectionLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPortDirectionLiteralAccess().getGroup()); }
		(rule__PortDirectionLiteral__Group__0)
		{ after(grammarAccess.getPortDirectionLiteralAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleNumber
entryRuleNumber
@init { 
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
:
{ before(grammarAccess.getNumberRule()); }
	 ruleNumber
{ after(grammarAccess.getNumberRule()); } 
	 EOF 
;
finally {
	myHiddenTokenState.restore();
}

// Rule Number
ruleNumber 
	@init {
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getNumberAccess().getGroup()); }
		(rule__Number__Group__0)
		{ after(grammarAccess.getNumberAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
	myHiddenTokenState.restore();
}

// Entry rule entryRuleFeatureCallExpression
entryRuleFeatureCallExpression
:
{ before(grammarAccess.getFeatureCallExpressionRule()); }
	 ruleFeatureCallExpression
{ after(grammarAccess.getFeatureCallExpressionRule()); } 
	 EOF 
;

// Rule FeatureCallExpression
ruleFeatureCallExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFeatureCallExpressionAccess().getGroup()); }
		(rule__FeatureCallExpression__Group__0)
		{ after(grammarAccess.getFeatureCallExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOperationCallExpression
entryRuleOperationCallExpression
:
{ before(grammarAccess.getOperationCallExpressionRule()); }
	 ruleOperationCallExpression
{ after(grammarAccess.getOperationCallExpressionRule()); } 
	 EOF 
;

// Rule OperationCallExpression
ruleOperationCallExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOperationCallExpressionAccess().getGroup()); }
		(rule__OperationCallExpression__Group__0)
		{ after(grammarAccess.getOperationCallExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAssignmentOrVariableDeclaration
entryRuleAssignmentOrVariableDeclaration
:
{ before(grammarAccess.getAssignmentOrVariableDeclarationRule()); }
	 ruleAssignmentOrVariableDeclaration
{ after(grammarAccess.getAssignmentOrVariableDeclarationRule()); } 
	 EOF 
;

// Rule AssignmentOrVariableDeclaration
ruleAssignmentOrVariableDeclaration 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAssignmentOrVariableDeclarationAccess().getAlternatives()); }
		(rule__AssignmentOrVariableDeclaration__Alternatives)
		{ after(grammarAccess.getAssignmentOrVariableDeclarationAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleVariableDeclaration
entryRuleVariableDeclaration
:
{ before(grammarAccess.getVariableDeclarationRule()); }
	 ruleVariableDeclaration
{ after(grammarAccess.getVariableDeclarationRule()); } 
	 EOF 
;

// Rule VariableDeclaration
ruleVariableDeclaration 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getVariableDeclarationAccess().getGroup()); }
		(rule__VariableDeclaration__Group__0)
		{ after(grammarAccess.getVariableDeclarationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAssignmentExpression
entryRuleAssignmentExpression
:
{ before(grammarAccess.getAssignmentExpressionRule()); }
	 ruleAssignmentExpression
{ after(grammarAccess.getAssignmentExpressionRule()); } 
	 EOF 
;

// Rule AssignmentExpression
ruleAssignmentExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAssignmentExpressionAccess().getGroup()); }
		(rule__AssignmentExpression__Group__0)
		{ after(grammarAccess.getAssignmentExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTypedMemberCallExpression
entryRuleTypedMemberCallExpression
:
{ before(grammarAccess.getTypedMemberCallExpressionRule()); }
	 ruleTypedMemberCallExpression
{ after(grammarAccess.getTypedMemberCallExpressionRule()); } 
	 EOF 
;

// Rule TypedMemberCallExpression
ruleTypedMemberCallExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTypedMemberCallExpressionAccess().getGroup()); }
		(rule__TypedMemberCallExpression__Group__0)
		{ after(grammarAccess.getTypedMemberCallExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleForLoopExpression
entryRuleForLoopExpression
:
{ before(grammarAccess.getForLoopExpressionRule()); }
	 ruleForLoopExpression
{ after(grammarAccess.getForLoopExpressionRule()); } 
	 EOF 
;

// Rule ForLoopExpression
ruleForLoopExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getForLoopExpressionAccess().getGroup()); }
		(rule__ForLoopExpression__Group__0)
		{ after(grammarAccess.getForLoopExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleIfExpression
entryRuleIfExpression
:
{ before(grammarAccess.getIfExpressionRule()); }
	 ruleIfExpression
{ after(grammarAccess.getIfExpressionRule()); } 
	 EOF 
;

// Rule IfExpression
ruleIfExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIfExpressionAccess().getGroup()); }
		(rule__IfExpression__Group__0)
		{ after(grammarAccess.getIfExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleBooleanExpression
entryRuleBooleanExpression
:
{ before(grammarAccess.getBooleanExpressionRule()); }
	 ruleBooleanExpression
{ after(grammarAccess.getBooleanExpressionRule()); } 
	 EOF 
;

// Rule BooleanExpression
ruleBooleanExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getBooleanExpressionAccess().getOrBooleanExpressionParserRuleCall()); }
		ruleOrBooleanExpression
		{ after(grammarAccess.getBooleanExpressionAccess().getOrBooleanExpressionParserRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOrBooleanExpression
entryRuleOrBooleanExpression
:
{ before(grammarAccess.getOrBooleanExpressionRule()); }
	 ruleOrBooleanExpression
{ after(grammarAccess.getOrBooleanExpressionRule()); } 
	 EOF 
;

// Rule OrBooleanExpression
ruleOrBooleanExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOrBooleanExpressionAccess().getGroup()); }
		(rule__OrBooleanExpression__Group__0)
		{ after(grammarAccess.getOrBooleanExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAndBooleanExpression
entryRuleAndBooleanExpression
:
{ before(grammarAccess.getAndBooleanExpressionRule()); }
	 ruleAndBooleanExpression
{ after(grammarAccess.getAndBooleanExpressionRule()); } 
	 EOF 
;

// Rule AndBooleanExpression
ruleAndBooleanExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAndBooleanExpressionAccess().getGroup()); }
		(rule__AndBooleanExpression__Group__0)
		{ after(grammarAccess.getAndBooleanExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleComparisonBooleanExpression
entryRuleComparisonBooleanExpression
:
{ before(grammarAccess.getComparisonBooleanExpressionRule()); }
	 ruleComparisonBooleanExpression
{ after(grammarAccess.getComparisonBooleanExpressionRule()); } 
	 EOF 
;

// Rule ComparisonBooleanExpression
ruleComparisonBooleanExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getComparisonBooleanExpressionAccess().getGroup()); }
		(rule__ComparisonBooleanExpression__Group__0)
		{ after(grammarAccess.getComparisonBooleanExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleBooleanNegationExpression
entryRuleBooleanNegationExpression
:
{ before(grammarAccess.getBooleanNegationExpressionRule()); }
	 ruleBooleanNegationExpression
{ after(grammarAccess.getBooleanNegationExpressionRule()); } 
	 EOF 
;

// Rule BooleanNegationExpression
ruleBooleanNegationExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getBooleanNegationExpressionAccess().getGroup()); }
		(rule__BooleanNegationExpression__Group__0)
		{ after(grammarAccess.getBooleanNegationExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAtomic
entryRuleAtomic
:
{ before(grammarAccess.getAtomicRule()); }
	 ruleAtomic
{ after(grammarAccess.getAtomicRule()); } 
	 EOF 
;

// Rule Atomic
ruleAtomic 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAtomicAccess().getAlternatives()); }
		(rule__Atomic__Alternatives)
		{ after(grammarAccess.getAtomicAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Rule TransformationTypes
ruleTransformationTypes
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTransformationTypesAccess().getAlternatives()); }
		(rule__TransformationTypes__Alternatives)
		{ after(grammarAccess.getTransformationTypesAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Rule PortDirection
rulePortDirection
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPortDirectionAccess().getAlternatives()); }
		(rule__PortDirection__Alternatives)
		{ after(grammarAccess.getPortDirectionAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Expression__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExpressionAccess().getAssignmentOrVariableDeclarationParserRuleCall_0()); }
		ruleAssignmentOrVariableDeclaration
		{ after(grammarAccess.getExpressionAccess().getAssignmentOrVariableDeclarationParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getExpressionAccess().getNullLiteralParserRuleCall_1()); }
		ruleNullLiteral
		{ after(grammarAccess.getExpressionAccess().getNullLiteralParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getExpressionAccess().getBooleanLiteralParserRuleCall_2()); }
		ruleBooleanLiteral
		{ after(grammarAccess.getExpressionAccess().getBooleanLiteralParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getExpressionAccess().getForLoopExpressionParserRuleCall_3()); }
		(ruleForLoopExpression)
		{ after(grammarAccess.getExpressionAccess().getForLoopExpressionParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getExpressionAccess().getIfExpressionParserRuleCall_4()); }
		ruleIfExpression
		{ after(grammarAccess.getExpressionAccess().getIfExpressionParserRuleCall_4()); }
	)
	|
	(
		{ before(grammarAccess.getExpressionAccess().getConcatenationExpressionParserRuleCall_5()); }
		ruleConcatenationExpression
		{ after(grammarAccess.getExpressionAccess().getConcatenationExpressionParserRuleCall_5()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TransformationType__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTransformationTypeAccess().getTypeBasedTransformationTypeParserRuleCall_0()); }
		ruleTypeBasedTransformationType
		{ after(grammarAccess.getTransformationTypeAccess().getTypeBasedTransformationTypeParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getTransformationTypeAccess().getEClassBasedTransformationTypeParserRuleCall_1()); }
		ruleEClassBasedTransformationType
		{ after(grammarAccess.getTransformationTypeAccess().getEClassBasedTransformationTypeParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getTransformationTypeAccess().getListBasedTransformationTypeParserRuleCall_2()); }
		ruleListBasedTransformationType
		{ after(grammarAccess.getTransformationTypeAccess().getListBasedTransformationTypeParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterAccess().getTypeBasedParameterParserRuleCall_0()); }
		ruleTypeBasedParameter
		{ after(grammarAccess.getParameterAccess().getTypeBasedParameterParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getParameterAccess().getEClassBasedParameterParserRuleCall_1()); }
		ruleEClassBasedParameter
		{ after(grammarAccess.getParameterAccess().getEClassBasedParameterParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getParameterAccess().getListBasedParameterParserRuleCall_2()); }
		ruleListBasedParameter
		{ after(grammarAccess.getParameterAccess().getListBasedParameterParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Primary__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPrimaryAccess().getStringLiteralParserRuleCall_0()); }
		ruleStringLiteral
		{ after(grammarAccess.getPrimaryAccess().getStringLiteralParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getPrimaryAccess().getNumberLiteralParserRuleCall_1()); }
		ruleNumberLiteral
		{ after(grammarAccess.getPrimaryAccess().getNumberLiteralParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getPrimaryAccess().getTypedMemberCallExpressionParserRuleCall_2()); }
		ruleTypedMemberCallExpression
		{ after(grammarAccess.getPrimaryAccess().getTypedMemberCallExpressionParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getPrimaryAccess().getFeatureCallExpressionParserRuleCall_3()); }
		ruleFeatureCallExpression
		{ after(grammarAccess.getPrimaryAccess().getFeatureCallExpressionParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getPrimaryAccess().getOperationCallExpressionParserRuleCall_4()); }
		ruleOperationCallExpression
		{ after(grammarAccess.getPrimaryAccess().getOperationCallExpressionParserRuleCall_4()); }
	)
	|
	(
		{ before(grammarAccess.getPrimaryAccess().getPortDirectionLiteralParserRuleCall_5()); }
		rulePortDirectionLiteral
		{ after(grammarAccess.getPrimaryAccess().getPortDirectionLiteralParserRuleCall_5()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); }
		False
		{ after(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); }
		(rule__BooleanLiteral__IsTrueAssignment_1_1)
		{ after(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentOrVariableDeclaration__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentOrVariableDeclarationAccess().getVariableDeclarationParserRuleCall_0()); }
		ruleVariableDeclaration
		{ after(grammarAccess.getAssignmentOrVariableDeclarationAccess().getVariableDeclarationParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getAssignmentOrVariableDeclarationAccess().getAssignmentExpressionParserRuleCall_1()); }
		ruleAssignmentExpression
		{ after(grammarAccess.getAssignmentOrVariableDeclarationAccess().getAssignmentExpressionParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVariableDeclarationAccess().getWriteableAssignment_1_0()); }
		(rule__VariableDeclaration__WriteableAssignment_1_0)
		{ after(grammarAccess.getVariableDeclarationAccess().getWriteableAssignment_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getVariableDeclarationAccess().getValKeyword_1_1()); }
		Val
		{ after(grammarAccess.getVariableDeclarationAccess().getValKeyword_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__Alternatives_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVariableDeclarationAccess().getGroup_2_0()); }
		(rule__VariableDeclaration__Group_2_0__0)
		{ after(grammarAccess.getVariableDeclarationAccess().getGroup_2_0()); }
	)
	|
	(
		{ before(grammarAccess.getVariableDeclarationAccess().getNameAssignment_2_1()); }
		(rule__VariableDeclaration__NameAssignment_2_1)
		{ after(grammarAccess.getVariableDeclarationAccess().getNameAssignment_2_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ComparisonBooleanExpression__OperatorAlternatives_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getComparisonBooleanExpressionAccess().getOperatorLessThanSignKeyword_1_1_0_0()); }
		LessThanSign
		{ after(grammarAccess.getComparisonBooleanExpressionAccess().getOperatorLessThanSignKeyword_1_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getComparisonBooleanExpressionAccess().getOperatorLessThanSignEqualsSignKeyword_1_1_0_1()); }
		LessThanSignEqualsSign
		{ after(grammarAccess.getComparisonBooleanExpressionAccess().getOperatorLessThanSignEqualsSignKeyword_1_1_0_1()); }
	)
	|
	(
		{ before(grammarAccess.getComparisonBooleanExpressionAccess().getOperatorEqualsSignEqualsSignKeyword_1_1_0_2()); }
		EqualsSignEqualsSign
		{ after(grammarAccess.getComparisonBooleanExpressionAccess().getOperatorEqualsSignEqualsSignKeyword_1_1_0_2()); }
	)
	|
	(
		{ before(grammarAccess.getComparisonBooleanExpressionAccess().getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_3()); }
		GreaterThanSignEqualsSign
		{ after(grammarAccess.getComparisonBooleanExpressionAccess().getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_3()); }
	)
	|
	(
		{ before(grammarAccess.getComparisonBooleanExpressionAccess().getOperatorGreaterThanSignKeyword_1_1_0_4()); }
		GreaterThanSign
		{ after(grammarAccess.getComparisonBooleanExpressionAccess().getOperatorGreaterThanSignKeyword_1_1_0_4()); }
	)
	|
	(
		{ before(grammarAccess.getComparisonBooleanExpressionAccess().getOperatorExclamationMarkEqualsSignKeyword_1_1_0_5()); }
		ExclamationMarkEqualsSign
		{ after(grammarAccess.getComparisonBooleanExpressionAccess().getOperatorExclamationMarkEqualsSignKeyword_1_1_0_5()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Atomic__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAtomicAccess().getGroup_0()); }
		(rule__Atomic__Group_0__0)
		{ after(grammarAccess.getAtomicAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getAtomicAccess().getStringLiteralParserRuleCall_1()); }
		ruleStringLiteral
		{ after(grammarAccess.getAtomicAccess().getStringLiteralParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getAtomicAccess().getBooleanLiteralParserRuleCall_2()); }
		ruleBooleanLiteral
		{ after(grammarAccess.getAtomicAccess().getBooleanLiteralParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getAtomicAccess().getNullLiteralParserRuleCall_3()); }
		ruleNullLiteral
		{ after(grammarAccess.getAtomicAccess().getNullLiteralParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getAtomicAccess().getPortDirectionLiteralParserRuleCall_4()); }
		rulePortDirectionLiteral
		{ after(grammarAccess.getAtomicAccess().getPortDirectionLiteralParserRuleCall_4()); }
	)
	|
	(
		{ before(grammarAccess.getAtomicAccess().getNumberLiteralParserRuleCall_5()); }
		ruleNumberLiteral
		{ after(grammarAccess.getAtomicAccess().getNumberLiteralParserRuleCall_5()); }
	)
	|
	(
		{ before(grammarAccess.getAtomicAccess().getFeatureCallExpressionParserRuleCall_6()); }
		ruleFeatureCallExpression
		{ after(grammarAccess.getAtomicAccess().getFeatureCallExpressionParserRuleCall_6()); }
	)
	|
	(
		{ before(grammarAccess.getAtomicAccess().getTypedMemberCallExpressionParserRuleCall_7()); }
		ruleTypedMemberCallExpression
		{ after(grammarAccess.getAtomicAccess().getTypedMemberCallExpressionParserRuleCall_7()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TransformationTypes__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTransformationTypesAccess().getIntegerEnumLiteralDeclaration_0()); }
		(Integer)
		{ after(grammarAccess.getTransformationTypesAccess().getIntegerEnumLiteralDeclaration_0()); }
	)
	|
	(
		{ before(grammarAccess.getTransformationTypesAccess().getFloatEnumLiteralDeclaration_1()); }
		(Float)
		{ after(grammarAccess.getTransformationTypesAccess().getFloatEnumLiteralDeclaration_1()); }
	)
	|
	(
		{ before(grammarAccess.getTransformationTypesAccess().getStringEnumLiteralDeclaration_2()); }
		(String)
		{ after(grammarAccess.getTransformationTypesAccess().getStringEnumLiteralDeclaration_2()); }
	)
	|
	(
		{ before(grammarAccess.getTransformationTypesAccess().getBooleanEnumLiteralDeclaration_3()); }
		(Boolean)
		{ after(grammarAccess.getTransformationTypesAccess().getBooleanEnumLiteralDeclaration_3()); }
	)
	|
	(
		{ before(grammarAccess.getTransformationTypesAccess().getVoidEnumLiteralDeclaration_4()); }
		(Void)
		{ after(grammarAccess.getTransformationTypesAccess().getVoidEnumLiteralDeclaration_4()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PortDirection__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPortDirectionAccess().getINEnumLiteralDeclaration_0()); }
		(PortDirectionIN)
		{ after(grammarAccess.getPortDirectionAccess().getINEnumLiteralDeclaration_0()); }
	)
	|
	(
		{ before(grammarAccess.getPortDirectionAccess().getOUTEnumLiteralDeclaration_1()); }
		(PortDirectionOUT)
		{ after(grammarAccess.getPortDirectionAccess().getOUTEnumLiteralDeclaration_1()); }
	)
	|
	(
		{ before(grammarAccess.getPortDirectionAccess().getINOUTEnumLiteralDeclaration_2()); }
		(PortDirectionINOUT)
		{ after(grammarAccess.getPortDirectionAccess().getINOUTEnumLiteralDeclaration_2()); }
	)
	|
	(
		{ before(grammarAccess.getPortDirectionAccess().getUNSETEnumLiteralDeclaration_3()); }
		(PortDirectionUNSET)
		{ after(grammarAccess.getPortDirectionAccess().getUNSETEnumLiteralDeclaration_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__0__Impl
	rule__Transformation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getTransformationAction_0()); }
	()
	{ after(grammarAccess.getTransformationAccess().getTransformationAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__1__Impl
	rule__Transformation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getTransformKeyword_1()); }
	Transform
	{ after(grammarAccess.getTransformationAccess().getTransformKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__2__Impl
	rule__Transformation__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getNameAssignment_2()); }
	(rule__Transformation__NameAssignment_2)
	{ after(grammarAccess.getTransformationAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__3__Impl
	rule__Transformation__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getLeftParenthesisKeyword_3()); }
	LeftParenthesis
	{ after(grammarAccess.getTransformationAccess().getLeftParenthesisKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__4__Impl
	rule__Transformation__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getBEGINTerminalRuleCall_4()); }
	RULE_BEGIN
	{ after(grammarAccess.getTransformationAccess().getBEGINTerminalRuleCall_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__5__Impl
	rule__Transformation__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getGroup_5()); }
	(rule__Transformation__Group_5__0)?
	{ after(grammarAccess.getTransformationAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__6__Impl
	rule__Transformation__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getRightParenthesisKeyword_6()); }
	RightParenthesis
	{ after(grammarAccess.getTransformationAccess().getRightParenthesisKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__7__Impl
	rule__Transformation__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getGroup_7()); }
	(rule__Transformation__Group_7__0)?
	{ after(grammarAccess.getTransformationAccess().getGroup_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__8__Impl
	rule__Transformation__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_8()); }
	LeftCurlyBracket
	{ after(grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__9__Impl
	rule__Transformation__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getENDTerminalRuleCall_9()); }
	RULE_END
	{ after(grammarAccess.getTransformationAccess().getENDTerminalRuleCall_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__10
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__10__Impl
	rule__Transformation__Group__11
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__10__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getPRECONDITIONKeyword_10()); }
	PRECONDITION
	{ after(grammarAccess.getTransformationAccess().getPRECONDITIONKeyword_10()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__11
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__11__Impl
	rule__Transformation__Group__12
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__11__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getBEGINTerminalRuleCall_11()); }
	RULE_BEGIN
	{ after(grammarAccess.getTransformationAccess().getBEGINTerminalRuleCall_11()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__12
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__12__Impl
	rule__Transformation__Group__13
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__12__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getPreconditionsAssignment_12()); }
	(rule__Transformation__PreconditionsAssignment_12)*
	{ after(grammarAccess.getTransformationAccess().getPreconditionsAssignment_12()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__13
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__13__Impl
	rule__Transformation__Group__14
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__13__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getENDTerminalRuleCall_13()); }
	RULE_END
	{ after(grammarAccess.getTransformationAccess().getENDTerminalRuleCall_13()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__14
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__14__Impl
	rule__Transformation__Group__15
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__14__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getRULESKeyword_14()); }
	RULES
	{ after(grammarAccess.getTransformationAccess().getRULESKeyword_14()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__15
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__15__Impl
	rule__Transformation__Group__16
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__15__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getBEGINTerminalRuleCall_15()); }
	RULE_BEGIN
	{ after(grammarAccess.getTransformationAccess().getBEGINTerminalRuleCall_15()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__16
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__16__Impl
	rule__Transformation__Group__17
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__16__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getContentAssignment_16()); }
	(rule__Transformation__ContentAssignment_16)*
	{ after(grammarAccess.getTransformationAccess().getContentAssignment_16()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__17
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__17__Impl
	rule__Transformation__Group__18
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__17__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getENDTerminalRuleCall_17()); }
	RULE_END
	{ after(grammarAccess.getTransformationAccess().getENDTerminalRuleCall_17()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__18
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__18__Impl
	rule__Transformation__Group__19
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__18__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getGroup_18()); }
	(rule__Transformation__Group_18__0)?
	{ after(grammarAccess.getTransformationAccess().getGroup_18()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__19
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group__19__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group__19__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getRightCurlyBracketKeyword_19()); }
	RightCurlyBracket
	{ after(grammarAccess.getTransformationAccess().getRightCurlyBracketKeyword_19()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Transformation__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group_5__0__Impl
	rule__Transformation__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getParametersAssignment_5_0()); }
	(rule__Transformation__ParametersAssignment_5_0)
	{ after(grammarAccess.getTransformationAccess().getParametersAssignment_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getGroup_5_1()); }
	(rule__Transformation__Group_5_1__0)*
	{ after(grammarAccess.getTransformationAccess().getGroup_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Transformation__Group_5_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group_5_1__0__Impl
	rule__Transformation__Group_5_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group_5_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getCommaKeyword_5_1_0()); }
	Comma
	{ after(grammarAccess.getTransformationAccess().getCommaKeyword_5_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group_5_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group_5_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group_5_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getParametersAssignment_5_1_1()); }
	(rule__Transformation__ParametersAssignment_5_1_1)
	{ after(grammarAccess.getTransformationAccess().getParametersAssignment_5_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Transformation__Group_7__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group_7__0__Impl
	rule__Transformation__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group_7__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getColonKeyword_7_0()); }
	Colon
	{ after(grammarAccess.getTransformationAccess().getColonKeyword_7_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group_7__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group_7__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group_7__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getTypeAssignment_7_1()); }
	(rule__Transformation__TypeAssignment_7_1)
	{ after(grammarAccess.getTransformationAccess().getTypeAssignment_7_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Transformation__Group_18__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group_18__0__Impl
	rule__Transformation__Group_18__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group_18__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getRETURNKeyword_18_0()); }
	RETURN
	{ after(grammarAccess.getTransformationAccess().getRETURNKeyword_18_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group_18__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group_18__1__Impl
	rule__Transformation__Group_18__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group_18__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getBEGINTerminalRuleCall_18_1()); }
	RULE_BEGIN
	{ after(grammarAccess.getTransformationAccess().getBEGINTerminalRuleCall_18_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group_18__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group_18__2__Impl
	rule__Transformation__Group_18__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group_18__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getOutputAssignment_18_2()); }
	(rule__Transformation__OutputAssignment_18_2)
	{ after(grammarAccess.getTransformationAccess().getOutputAssignment_18_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group_18__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Transformation__Group_18__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__Group_18__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTransformationAccess().getENDTerminalRuleCall_18_3()); }
	RULE_END
	{ after(grammarAccess.getTransformationAccess().getENDTerminalRuleCall_18_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EClassBasedTransformationType__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EClassBasedTransformationType__Group__0__Impl
	rule__EClassBasedTransformationType__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EClassBasedTransformationType__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEClassBasedTransformationTypeAccess().getEClassBasedTransformationTypeAction_0()); }
	()
	{ after(grammarAccess.getEClassBasedTransformationTypeAccess().getEClassBasedTransformationTypeAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EClassBasedTransformationType__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EClassBasedTransformationType__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EClassBasedTransformationType__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEClassBasedTransformationTypeAccess().getTypeAssignment_1()); }
	(rule__EClassBasedTransformationType__TypeAssignment_1)
	{ after(grammarAccess.getEClassBasedTransformationTypeAccess().getTypeAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ListBasedTransformationType__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListBasedTransformationType__Group__0__Impl
	rule__ListBasedTransformationType__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedTransformationType__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListBasedTransformationTypeAccess().getListBasedTransformationTypeAction_0()); }
	()
	{ after(grammarAccess.getListBasedTransformationTypeAccess().getListBasedTransformationTypeAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedTransformationType__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListBasedTransformationType__Group__1__Impl
	rule__ListBasedTransformationType__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedTransformationType__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListBasedTransformationTypeAccess().getListKeyword_1()); }
	List
	{ after(grammarAccess.getListBasedTransformationTypeAccess().getListKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedTransformationType__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListBasedTransformationType__Group__2__Impl
	rule__ListBasedTransformationType__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedTransformationType__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListBasedTransformationTypeAccess().getLessThanSignKeyword_2()); }
	LessThanSign
	{ after(grammarAccess.getListBasedTransformationTypeAccess().getLessThanSignKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedTransformationType__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListBasedTransformationType__Group__3__Impl
	rule__ListBasedTransformationType__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedTransformationType__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListBasedTransformationTypeAccess().getTypeAssignment_3()); }
	(rule__ListBasedTransformationType__TypeAssignment_3)
	{ after(grammarAccess.getListBasedTransformationTypeAccess().getTypeAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedTransformationType__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListBasedTransformationType__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedTransformationType__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListBasedTransformationTypeAccess().getGreaterThanSignKeyword_4()); }
	GreaterThanSign
	{ after(grammarAccess.getListBasedTransformationTypeAccess().getGreaterThanSignKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TypeBasedParameter__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeBasedParameter__Group__0__Impl
	rule__TypeBasedParameter__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeBasedParameter__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeBasedParameterAccess().getTypeBasedParameterAction_0()); }
	()
	{ after(grammarAccess.getTypeBasedParameterAccess().getTypeBasedParameterAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeBasedParameter__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeBasedParameter__Group__1__Impl
	rule__TypeBasedParameter__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeBasedParameter__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeBasedParameterAccess().getNameAssignment_1()); }
	(rule__TypeBasedParameter__NameAssignment_1)
	{ after(grammarAccess.getTypeBasedParameterAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeBasedParameter__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeBasedParameter__Group__2__Impl
	rule__TypeBasedParameter__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeBasedParameter__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeBasedParameterAccess().getColonKeyword_2()); }
	Colon
	{ after(grammarAccess.getTypeBasedParameterAccess().getColonKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeBasedParameter__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeBasedParameter__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeBasedParameter__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeBasedParameterAccess().getTypeAssignment_3()); }
	(rule__TypeBasedParameter__TypeAssignment_3)
	{ after(grammarAccess.getTypeBasedParameterAccess().getTypeAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EClassBasedParameter__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EClassBasedParameter__Group__0__Impl
	rule__EClassBasedParameter__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EClassBasedParameter__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEClassBasedParameterAccess().getEClassBasedParameterAction_0()); }
	()
	{ after(grammarAccess.getEClassBasedParameterAccess().getEClassBasedParameterAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EClassBasedParameter__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EClassBasedParameter__Group__1__Impl
	rule__EClassBasedParameter__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EClassBasedParameter__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEClassBasedParameterAccess().getNameAssignment_1()); }
	(rule__EClassBasedParameter__NameAssignment_1)
	{ after(grammarAccess.getEClassBasedParameterAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EClassBasedParameter__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EClassBasedParameter__Group__2__Impl
	rule__EClassBasedParameter__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EClassBasedParameter__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEClassBasedParameterAccess().getColonKeyword_2()); }
	Colon
	{ after(grammarAccess.getEClassBasedParameterAccess().getColonKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EClassBasedParameter__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EClassBasedParameter__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EClassBasedParameter__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEClassBasedParameterAccess().getTypeAssignment_3()); }
	(rule__EClassBasedParameter__TypeAssignment_3)
	{ after(grammarAccess.getEClassBasedParameterAccess().getTypeAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ListBasedParameter__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListBasedParameter__Group__0__Impl
	rule__ListBasedParameter__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedParameter__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListBasedParameterAccess().getListBasedParameterAction_0()); }
	()
	{ after(grammarAccess.getListBasedParameterAccess().getListBasedParameterAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedParameter__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListBasedParameter__Group__1__Impl
	rule__ListBasedParameter__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedParameter__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListBasedParameterAccess().getNameAssignment_1()); }
	(rule__ListBasedParameter__NameAssignment_1)
	{ after(grammarAccess.getListBasedParameterAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedParameter__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListBasedParameter__Group__2__Impl
	rule__ListBasedParameter__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedParameter__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListBasedParameterAccess().getColonKeyword_2()); }
	Colon
	{ after(grammarAccess.getListBasedParameterAccess().getColonKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedParameter__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListBasedParameter__Group__3__Impl
	rule__ListBasedParameter__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedParameter__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListBasedParameterAccess().getListKeyword_3()); }
	List
	{ after(grammarAccess.getListBasedParameterAccess().getListKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedParameter__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListBasedParameter__Group__4__Impl
	rule__ListBasedParameter__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedParameter__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListBasedParameterAccess().getLessThanSignKeyword_4()); }
	LessThanSign
	{ after(grammarAccess.getListBasedParameterAccess().getLessThanSignKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedParameter__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListBasedParameter__Group__5__Impl
	rule__ListBasedParameter__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedParameter__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListBasedParameterAccess().getTypeAssignment_5()); }
	(rule__ListBasedParameter__TypeAssignment_5)
	{ after(grammarAccess.getListBasedParameterAccess().getTypeAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedParameter__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListBasedParameter__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedParameter__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListBasedParameterAccess().getGreaterThanSignKeyword_6()); }
	GreaterThanSign
	{ after(grammarAccess.getListBasedParameterAccess().getGreaterThanSignKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConcatenationExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConcatenationExpression__Group__0__Impl
	rule__ConcatenationExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConcatenationExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConcatenationExpressionAccess().getPrimaryParserRuleCall_0()); }
	rulePrimary
	{ after(grammarAccess.getConcatenationExpressionAccess().getPrimaryParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConcatenationExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConcatenationExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConcatenationExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConcatenationExpressionAccess().getGroup_1()); }
	(rule__ConcatenationExpression__Group_1__0)*
	{ after(grammarAccess.getConcatenationExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConcatenationExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConcatenationExpression__Group_1__0__Impl
	rule__ConcatenationExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConcatenationExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConcatenationExpressionAccess().getConcatenationExpressionLeftAction_1_0()); }
	()
	{ after(grammarAccess.getConcatenationExpressionAccess().getConcatenationExpressionLeftAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConcatenationExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConcatenationExpression__Group_1__1__Impl
	rule__ConcatenationExpression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConcatenationExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConcatenationExpressionAccess().getPlusSignKeyword_1_1()); }
	PlusSign
	{ after(grammarAccess.getConcatenationExpressionAccess().getPlusSignKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConcatenationExpression__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConcatenationExpression__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConcatenationExpression__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConcatenationExpressionAccess().getRightAssignment_1_2()); }
	(rule__ConcatenationExpression__RightAssignment_1_2)
	{ after(grammarAccess.getConcatenationExpressionAccess().getRightAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NullLiteral__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NullLiteral__Group__0__Impl
	rule__NullLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NullLiteral__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNullLiteralAccess().getNullLiteralAction_0()); }
	()
	{ after(grammarAccess.getNullLiteralAccess().getNullLiteralAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NullLiteral__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NullLiteral__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NullLiteral__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNullLiteralAccess().getNullKeyword_1()); }
	Null
	{ after(grammarAccess.getNullLiteralAccess().getNullKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__BooleanLiteral__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BooleanLiteral__Group__0__Impl
	rule__BooleanLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); }
	()
	{ after(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BooleanLiteral__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); }
	(rule__BooleanLiteral__Alternatives_1)
	{ after(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PortDirectionLiteral__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PortDirectionLiteral__Group__0__Impl
	rule__PortDirectionLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PortDirectionLiteral__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPortDirectionLiteralAccess().getPortDirectionLiteralAction_0()); }
	()
	{ after(grammarAccess.getPortDirectionLiteralAccess().getPortDirectionLiteralAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PortDirectionLiteral__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PortDirectionLiteral__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PortDirectionLiteral__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPortDirectionLiteralAccess().getDirectionAssignment_1()); }
	(rule__PortDirectionLiteral__DirectionAssignment_1)
	{ after(grammarAccess.getPortDirectionLiteralAccess().getDirectionAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Number__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Number__Group__0__Impl
	rule__Number__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Number__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumberAccess().getINTTerminalRuleCall_0()); }
	RULE_INT
	{ after(grammarAccess.getNumberAccess().getINTTerminalRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Number__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Number__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Number__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumberAccess().getGroup_1()); }
	(rule__Number__Group_1__0)?
	{ after(grammarAccess.getNumberAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Number__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Number__Group_1__0__Impl
	rule__Number__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Number__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumberAccess().getFullStopKeyword_1_0()); }
	FullStop
	{ after(grammarAccess.getNumberAccess().getFullStopKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Number__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Number__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Number__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1()); }
	RULE_INT
	{ after(grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FeatureCallExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FeatureCallExpression__Group__0__Impl
	rule__FeatureCallExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFeatureCallExpressionAccess().getContextAssignment_0()); }
	(rule__FeatureCallExpression__ContextAssignment_0)
	{ after(grammarAccess.getFeatureCallExpressionAccess().getContextAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FeatureCallExpression__Group__1__Impl
	rule__FeatureCallExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getFeatureCallExpressionAccess().getFullStopKeyword_1()); }
		(FullStop)
		{ after(grammarAccess.getFeatureCallExpressionAccess().getFullStopKeyword_1()); }
	)
	(
		{ before(grammarAccess.getFeatureCallExpressionAccess().getFullStopKeyword_1()); }
		(FullStop)*
		{ after(grammarAccess.getFeatureCallExpressionAccess().getFullStopKeyword_1()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FeatureCallExpression__Group__2__Impl
	rule__FeatureCallExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFeatureCallExpressionAccess().getStructuralFeatureAssignment_2()); }
	(rule__FeatureCallExpression__StructuralFeatureAssignment_2)
	{ after(grammarAccess.getFeatureCallExpressionAccess().getStructuralFeatureAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FeatureCallExpression__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFeatureCallExpressionAccess().getGroup_3()); }
	(rule__FeatureCallExpression__Group_3__0)?
	{ after(grammarAccess.getFeatureCallExpressionAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FeatureCallExpression__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FeatureCallExpression__Group_3__0__Impl
	rule__FeatureCallExpression__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFeatureCallExpressionAccess().getLeftParenthesisKeyword_3_0()); }
	LeftParenthesis
	{ after(grammarAccess.getFeatureCallExpressionAccess().getLeftParenthesisKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FeatureCallExpression__Group_3__1__Impl
	rule__FeatureCallExpression__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFeatureCallExpressionAccess().getGroup_3_1()); }
	(rule__FeatureCallExpression__Group_3_1__0)?
	{ after(grammarAccess.getFeatureCallExpressionAccess().getGroup_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__Group_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FeatureCallExpression__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__Group_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFeatureCallExpressionAccess().getRightParenthesisKeyword_3_2()); }
	RightParenthesis
	{ after(grammarAccess.getFeatureCallExpressionAccess().getRightParenthesisKeyword_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FeatureCallExpression__Group_3_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FeatureCallExpression__Group_3_1__0__Impl
	rule__FeatureCallExpression__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__Group_3_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFeatureCallExpressionAccess().getParameterValuesAssignment_3_1_0()); }
	(rule__FeatureCallExpression__ParameterValuesAssignment_3_1_0)
	{ after(grammarAccess.getFeatureCallExpressionAccess().getParameterValuesAssignment_3_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__Group_3_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FeatureCallExpression__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__Group_3_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFeatureCallExpressionAccess().getGroup_3_1_1()); }
	(rule__FeatureCallExpression__Group_3_1_1__0)*
	{ after(grammarAccess.getFeatureCallExpressionAccess().getGroup_3_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FeatureCallExpression__Group_3_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FeatureCallExpression__Group_3_1_1__0__Impl
	rule__FeatureCallExpression__Group_3_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__Group_3_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFeatureCallExpressionAccess().getCommaKeyword_3_1_1_0()); }
	Comma
	{ after(grammarAccess.getFeatureCallExpressionAccess().getCommaKeyword_3_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__Group_3_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FeatureCallExpression__Group_3_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__Group_3_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFeatureCallExpressionAccess().getParameterValuesAssignment_3_1_1_1()); }
	(rule__FeatureCallExpression__ParameterValuesAssignment_3_1_1_1)
	{ after(grammarAccess.getFeatureCallExpressionAccess().getParameterValuesAssignment_3_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCallExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OperationCallExpression__Group__0__Impl
	rule__OperationCallExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCallExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationCallExpressionAccess().getOperationCallExpressionAction_0()); }
	()
	{ after(grammarAccess.getOperationCallExpressionAccess().getOperationCallExpressionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCallExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OperationCallExpression__Group__1__Impl
	rule__OperationCallExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCallExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationCallExpressionAccess().getOperationAssignment_1()); }
	(rule__OperationCallExpression__OperationAssignment_1)
	{ after(grammarAccess.getOperationCallExpressionAccess().getOperationAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCallExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OperationCallExpression__Group__2__Impl
	rule__OperationCallExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCallExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationCallExpressionAccess().getLeftParenthesisKeyword_2()); }
	LeftParenthesis
	{ after(grammarAccess.getOperationCallExpressionAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCallExpression__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OperationCallExpression__Group__3__Impl
	rule__OperationCallExpression__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCallExpression__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationCallExpressionAccess().getGroup_3()); }
	(rule__OperationCallExpression__Group_3__0)?
	{ after(grammarAccess.getOperationCallExpressionAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCallExpression__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OperationCallExpression__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCallExpression__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationCallExpressionAccess().getRightParenthesisKeyword_4()); }
	RightParenthesis
	{ after(grammarAccess.getOperationCallExpressionAccess().getRightParenthesisKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCallExpression__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OperationCallExpression__Group_3__0__Impl
	rule__OperationCallExpression__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCallExpression__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationCallExpressionAccess().getParameterValuesAssignment_3_0()); }
	(rule__OperationCallExpression__ParameterValuesAssignment_3_0)
	{ after(grammarAccess.getOperationCallExpressionAccess().getParameterValuesAssignment_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCallExpression__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OperationCallExpression__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCallExpression__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationCallExpressionAccess().getGroup_3_1()); }
	(rule__OperationCallExpression__Group_3_1__0)*
	{ after(grammarAccess.getOperationCallExpressionAccess().getGroup_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCallExpression__Group_3_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OperationCallExpression__Group_3_1__0__Impl
	rule__OperationCallExpression__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCallExpression__Group_3_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationCallExpressionAccess().getCommaKeyword_3_1_0()); }
	Comma
	{ after(grammarAccess.getOperationCallExpressionAccess().getCommaKeyword_3_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCallExpression__Group_3_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OperationCallExpression__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCallExpression__Group_3_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationCallExpressionAccess().getParameterValuesAssignment_3_1_1()); }
	(rule__OperationCallExpression__ParameterValuesAssignment_3_1_1)
	{ after(grammarAccess.getOperationCallExpressionAccess().getParameterValuesAssignment_3_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__VariableDeclaration__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VariableDeclaration__Group__0__Impl
	rule__VariableDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVariableDeclarationAccess().getVariableDeclarationAction_0()); }
	()
	{ after(grammarAccess.getVariableDeclarationAccess().getVariableDeclarationAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VariableDeclaration__Group__1__Impl
	rule__VariableDeclaration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVariableDeclarationAccess().getAlternatives_1()); }
	(rule__VariableDeclaration__Alternatives_1)
	{ after(grammarAccess.getVariableDeclarationAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VariableDeclaration__Group__2__Impl
	rule__VariableDeclaration__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVariableDeclarationAccess().getAlternatives_2()); }
	(rule__VariableDeclaration__Alternatives_2)
	{ after(grammarAccess.getVariableDeclarationAccess().getAlternatives_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VariableDeclaration__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVariableDeclarationAccess().getGroup_3()); }
	(rule__VariableDeclaration__Group_3__0)?
	{ after(grammarAccess.getVariableDeclarationAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__VariableDeclaration__Group_2_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VariableDeclaration__Group_2_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__Group_2_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVariableDeclarationAccess().getGroup_2_0_0()); }
	(rule__VariableDeclaration__Group_2_0_0__0)
	{ after(grammarAccess.getVariableDeclarationAccess().getGroup_2_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__VariableDeclaration__Group_2_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VariableDeclaration__Group_2_0_0__0__Impl
	rule__VariableDeclaration__Group_2_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__Group_2_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVariableDeclarationAccess().getTypeAssignment_2_0_0_0()); }
	(rule__VariableDeclaration__TypeAssignment_2_0_0_0)
	{ after(grammarAccess.getVariableDeclarationAccess().getTypeAssignment_2_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__Group_2_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VariableDeclaration__Group_2_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__Group_2_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVariableDeclarationAccess().getNameAssignment_2_0_0_1()); }
	(rule__VariableDeclaration__NameAssignment_2_0_0_1)
	{ after(grammarAccess.getVariableDeclarationAccess().getNameAssignment_2_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__VariableDeclaration__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VariableDeclaration__Group_3__0__Impl
	rule__VariableDeclaration__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0()); }
	EqualsSign
	{ after(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VariableDeclaration__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVariableDeclarationAccess().getRhsAssignment_3_1()); }
	(rule__VariableDeclaration__RhsAssignment_3_1)
	{ after(grammarAccess.getVariableDeclarationAccess().getRhsAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AssignmentExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssignmentExpression__Group__0__Impl
	rule__AssignmentExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionAction_0()); }
	()
	{ after(grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssignmentExpression__Group__1__Impl
	rule__AssignmentExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getTypeMemberAssignment_1()); }
	(rule__AssignmentExpression__TypeMemberAssignment_1)
	{ after(grammarAccess.getAssignmentExpressionAccess().getTypeMemberAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssignmentExpression__Group__2__Impl
	rule__AssignmentExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getEqualsSignKeyword_2()); }
	EqualsSign
	{ after(grammarAccess.getAssignmentExpressionAccess().getEqualsSignKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssignmentExpression__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getValueAssignment_3()); }
	(rule__AssignmentExpression__ValueAssignment_3)
	{ after(grammarAccess.getAssignmentExpressionAccess().getValueAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TypedMemberCallExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypedMemberCallExpression__Group__0__Impl
	rule__TypedMemberCallExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedMemberCallExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypedMemberCallExpressionAccess().getTypedMemberCallExpressionAction_0()); }
	()
	{ after(grammarAccess.getTypedMemberCallExpressionAccess().getTypedMemberCallExpressionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedMemberCallExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypedMemberCallExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedMemberCallExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypedMemberCallExpressionAccess().getTypeMemberAssignment_1()); }
	(rule__TypedMemberCallExpression__TypeMemberAssignment_1)
	{ after(grammarAccess.getTypedMemberCallExpressionAccess().getTypeMemberAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ForLoopExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ForLoopExpression__Group__0__Impl
	rule__ForLoopExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getForLoopExpressionAccess().getGroup_0()); }
	(rule__ForLoopExpression__Group_0__0)
	{ after(grammarAccess.getForLoopExpressionAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ForLoopExpression__Group__1__Impl
	rule__ForLoopExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getForLoopExpressionAccess().getForExpressionAssignment_1()); }
	(rule__ForLoopExpression__ForExpressionAssignment_1)
	{ after(grammarAccess.getForLoopExpressionAccess().getForExpressionAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ForLoopExpression__Group__2__Impl
	rule__ForLoopExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getForLoopExpressionAccess().getRightParenthesisKeyword_2()); }
	RightParenthesis
	{ after(grammarAccess.getForLoopExpressionAccess().getRightParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ForLoopExpression__Group__3__Impl
	rule__ForLoopExpression__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getForLoopExpressionAccess().getLeftCurlyBracketKeyword_3()); }
	LeftCurlyBracket
	{ after(grammarAccess.getForLoopExpressionAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ForLoopExpression__Group__4__Impl
	rule__ForLoopExpression__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getForLoopExpressionAccess().getGroup_4()); }
	(rule__ForLoopExpression__Group_4__0)?
	{ after(grammarAccess.getForLoopExpressionAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ForLoopExpression__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getForLoopExpressionAccess().getRightCurlyBracketKeyword_5()); }
	RightCurlyBracket
	{ after(grammarAccess.getForLoopExpressionAccess().getRightCurlyBracketKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ForLoopExpression__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ForLoopExpression__Group_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getForLoopExpressionAccess().getGroup_0_0()); }
	(rule__ForLoopExpression__Group_0_0__0)
	{ after(grammarAccess.getForLoopExpressionAccess().getGroup_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ForLoopExpression__Group_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ForLoopExpression__Group_0_0__0__Impl
	rule__ForLoopExpression__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getForLoopExpressionAccess().getForLoopExpressionAction_0_0_0()); }
	()
	{ after(grammarAccess.getForLoopExpressionAccess().getForLoopExpressionAction_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ForLoopExpression__Group_0_0__1__Impl
	rule__ForLoopExpression__Group_0_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getForLoopExpressionAccess().getForKeyword_0_0_1()); }
	For
	{ after(grammarAccess.getForLoopExpressionAccess().getForKeyword_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group_0_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ForLoopExpression__Group_0_0__2__Impl
	rule__ForLoopExpression__Group_0_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group_0_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getForLoopExpressionAccess().getLeftParenthesisKeyword_0_0_2()); }
	LeftParenthesis
	{ after(grammarAccess.getForLoopExpressionAccess().getLeftParenthesisKeyword_0_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group_0_0__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ForLoopExpression__Group_0_0__3__Impl
	rule__ForLoopExpression__Group_0_0__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group_0_0__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getForLoopExpressionAccess().getDeclaredParamAssignment_0_0_3()); }
	(rule__ForLoopExpression__DeclaredParamAssignment_0_0_3)
	{ after(grammarAccess.getForLoopExpressionAccess().getDeclaredParamAssignment_0_0_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group_0_0__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ForLoopExpression__Group_0_0__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group_0_0__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getForLoopExpressionAccess().getInKeyword_0_0_4()); }
	In
	{ after(grammarAccess.getForLoopExpressionAccess().getInKeyword_0_0_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ForLoopExpression__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ForLoopExpression__Group_4__0__Impl
	rule__ForLoopExpression__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getForLoopExpressionAccess().getBEGINTerminalRuleCall_4_0()); }
	RULE_BEGIN
	{ after(grammarAccess.getForLoopExpressionAccess().getBEGINTerminalRuleCall_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ForLoopExpression__Group_4__1__Impl
	rule__ForLoopExpression__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getForLoopExpressionAccess().getEachExpressionAssignment_4_1()); }
	(rule__ForLoopExpression__EachExpressionAssignment_4_1)*
	{ after(grammarAccess.getForLoopExpressionAccess().getEachExpressionAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ForLoopExpression__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getForLoopExpressionAccess().getENDTerminalRuleCall_4_2()); }
	RULE_END
	{ after(grammarAccess.getForLoopExpressionAccess().getENDTerminalRuleCall_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IfExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IfExpression__Group__0__Impl
	rule__IfExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIfExpressionAccess().getIFExpressionAction_0()); }
	()
	{ after(grammarAccess.getIfExpressionAccess().getIFExpressionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IfExpression__Group__1__Impl
	rule__IfExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIfExpressionAccess().getIfKeyword_1()); }
	If
	{ after(grammarAccess.getIfExpressionAccess().getIfKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IfExpression__Group__2__Impl
	rule__IfExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIfExpressionAccess().getLeftParenthesisKeyword_2()); }
	LeftParenthesis
	{ after(grammarAccess.getIfExpressionAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IfExpression__Group__3__Impl
	rule__IfExpression__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIfExpressionAccess().getConditionAssignment_3()); }
	(rule__IfExpression__ConditionAssignment_3)
	{ after(grammarAccess.getIfExpressionAccess().getConditionAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IfExpression__Group__4__Impl
	rule__IfExpression__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIfExpressionAccess().getRightParenthesisKeyword_4()); }
	RightParenthesis
	{ after(grammarAccess.getIfExpressionAccess().getRightParenthesisKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IfExpression__Group__5__Impl
	rule__IfExpression__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIfExpressionAccess().getLeftCurlyBracketKeyword_5()); }
	LeftCurlyBracket
	{ after(grammarAccess.getIfExpressionAccess().getLeftCurlyBracketKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IfExpression__Group__6__Impl
	rule__IfExpression__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIfExpressionAccess().getGroup_6()); }
	(rule__IfExpression__Group_6__0)?
	{ after(grammarAccess.getIfExpressionAccess().getGroup_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IfExpression__Group__7__Impl
	rule__IfExpression__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIfExpressionAccess().getRightCurlyBracketKeyword_7()); }
	RightCurlyBracket
	{ after(grammarAccess.getIfExpressionAccess().getRightCurlyBracketKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IfExpression__Group__8__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIfExpressionAccess().getGroup_8()); }
	(rule__IfExpression__Group_8__0)?
	{ after(grammarAccess.getIfExpressionAccess().getGroup_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IfExpression__Group_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IfExpression__Group_6__0__Impl
	rule__IfExpression__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIfExpressionAccess().getBEGINTerminalRuleCall_6_0()); }
	RULE_BEGIN
	{ after(grammarAccess.getIfExpressionAccess().getBEGINTerminalRuleCall_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IfExpression__Group_6__1__Impl
	rule__IfExpression__Group_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIfExpressionAccess().getThenAssignment_6_1()); }
	(rule__IfExpression__ThenAssignment_6_1)*
	{ after(grammarAccess.getIfExpressionAccess().getThenAssignment_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group_6__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IfExpression__Group_6__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group_6__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIfExpressionAccess().getENDTerminalRuleCall_6_2()); }
	RULE_END
	{ after(grammarAccess.getIfExpressionAccess().getENDTerminalRuleCall_6_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IfExpression__Group_8__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IfExpression__Group_8__0__Impl
	rule__IfExpression__Group_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group_8__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIfExpressionAccess().getElseKeyword_8_0()); }
	(Else)
	{ after(grammarAccess.getIfExpressionAccess().getElseKeyword_8_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group_8__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IfExpression__Group_8__1__Impl
	rule__IfExpression__Group_8__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group_8__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIfExpressionAccess().getLeftCurlyBracketKeyword_8_1()); }
	LeftCurlyBracket
	{ after(grammarAccess.getIfExpressionAccess().getLeftCurlyBracketKeyword_8_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group_8__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IfExpression__Group_8__2__Impl
	rule__IfExpression__Group_8__3
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group_8__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIfExpressionAccess().getGroup_8_2()); }
	(rule__IfExpression__Group_8_2__0)?
	{ after(grammarAccess.getIfExpressionAccess().getGroup_8_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group_8__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IfExpression__Group_8__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group_8__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIfExpressionAccess().getRightCurlyBracketKeyword_8_3()); }
	RightCurlyBracket
	{ after(grammarAccess.getIfExpressionAccess().getRightCurlyBracketKeyword_8_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IfExpression__Group_8_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IfExpression__Group_8_2__0__Impl
	rule__IfExpression__Group_8_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group_8_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIfExpressionAccess().getBEGINTerminalRuleCall_8_2_0()); }
	RULE_BEGIN
	{ after(grammarAccess.getIfExpressionAccess().getBEGINTerminalRuleCall_8_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group_8_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IfExpression__Group_8_2__1__Impl
	rule__IfExpression__Group_8_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group_8_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIfExpressionAccess().getElseAssignment_8_2_1()); }
	(rule__IfExpression__ElseAssignment_8_2_1)*
	{ after(grammarAccess.getIfExpressionAccess().getElseAssignment_8_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group_8_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IfExpression__Group_8_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__Group_8_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIfExpressionAccess().getENDTerminalRuleCall_8_2_2()); }
	RULE_END
	{ after(grammarAccess.getIfExpressionAccess().getENDTerminalRuleCall_8_2_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OrBooleanExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OrBooleanExpression__Group__0__Impl
	rule__OrBooleanExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OrBooleanExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOrBooleanExpressionAccess().getAndBooleanExpressionParserRuleCall_0()); }
	ruleAndBooleanExpression
	{ after(grammarAccess.getOrBooleanExpressionAccess().getAndBooleanExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OrBooleanExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OrBooleanExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OrBooleanExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOrBooleanExpressionAccess().getGroup_1()); }
	(rule__OrBooleanExpression__Group_1__0)*
	{ after(grammarAccess.getOrBooleanExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OrBooleanExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OrBooleanExpression__Group_1__0__Impl
	rule__OrBooleanExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OrBooleanExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOrBooleanExpressionAccess().getGroup_1_0()); }
	(rule__OrBooleanExpression__Group_1_0__0)
	{ after(grammarAccess.getOrBooleanExpressionAccess().getGroup_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OrBooleanExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OrBooleanExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OrBooleanExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOrBooleanExpressionAccess().getRightAssignment_1_1()); }
	(rule__OrBooleanExpression__RightAssignment_1_1)
	{ after(grammarAccess.getOrBooleanExpressionAccess().getRightAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OrBooleanExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OrBooleanExpression__Group_1_0__0__Impl
	rule__OrBooleanExpression__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OrBooleanExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOrBooleanExpressionAccess().getOrBooleanExpressionLeftAction_1_0_0()); }
	()
	{ after(grammarAccess.getOrBooleanExpressionAccess().getOrBooleanExpressionLeftAction_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OrBooleanExpression__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OrBooleanExpression__Group_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OrBooleanExpression__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOrBooleanExpressionAccess().getVerticalLineVerticalLineKeyword_1_0_1()); }
	VerticalLineVerticalLine
	{ after(grammarAccess.getOrBooleanExpressionAccess().getVerticalLineVerticalLineKeyword_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AndBooleanExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AndBooleanExpression__Group__0__Impl
	rule__AndBooleanExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AndBooleanExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAndBooleanExpressionAccess().getComparisonBooleanExpressionParserRuleCall_0()); }
	ruleComparisonBooleanExpression
	{ after(grammarAccess.getAndBooleanExpressionAccess().getComparisonBooleanExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AndBooleanExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AndBooleanExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AndBooleanExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAndBooleanExpressionAccess().getGroup_1()); }
	(rule__AndBooleanExpression__Group_1__0)*
	{ after(grammarAccess.getAndBooleanExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AndBooleanExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AndBooleanExpression__Group_1__0__Impl
	rule__AndBooleanExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AndBooleanExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAndBooleanExpressionAccess().getGroup_1_0()); }
	(rule__AndBooleanExpression__Group_1_0__0)
	{ after(grammarAccess.getAndBooleanExpressionAccess().getGroup_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AndBooleanExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AndBooleanExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AndBooleanExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAndBooleanExpressionAccess().getRightAssignment_1_1()); }
	(rule__AndBooleanExpression__RightAssignment_1_1)
	{ after(grammarAccess.getAndBooleanExpressionAccess().getRightAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AndBooleanExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AndBooleanExpression__Group_1_0__0__Impl
	rule__AndBooleanExpression__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AndBooleanExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAndBooleanExpressionAccess().getAndBooleanExpressionLeftAction_1_0_0()); }
	()
	{ after(grammarAccess.getAndBooleanExpressionAccess().getAndBooleanExpressionLeftAction_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AndBooleanExpression__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AndBooleanExpression__Group_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AndBooleanExpression__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAndBooleanExpressionAccess().getAmpersandAmpersandKeyword_1_0_1()); }
	AmpersandAmpersand
	{ after(grammarAccess.getAndBooleanExpressionAccess().getAmpersandAmpersandKeyword_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ComparisonBooleanExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ComparisonBooleanExpression__Group__0__Impl
	rule__ComparisonBooleanExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComparisonBooleanExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getComparisonBooleanExpressionAccess().getBooleanNegationExpressionParserRuleCall_0()); }
	ruleBooleanNegationExpression
	{ after(grammarAccess.getComparisonBooleanExpressionAccess().getBooleanNegationExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ComparisonBooleanExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ComparisonBooleanExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComparisonBooleanExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getComparisonBooleanExpressionAccess().getGroup_1()); }
	(rule__ComparisonBooleanExpression__Group_1__0)*
	{ after(grammarAccess.getComparisonBooleanExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ComparisonBooleanExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ComparisonBooleanExpression__Group_1__0__Impl
	rule__ComparisonBooleanExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComparisonBooleanExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getComparisonBooleanExpressionAccess().getComparisonBooleanExpressionLeftAction_1_0()); }
	()
	{ after(grammarAccess.getComparisonBooleanExpressionAccess().getComparisonBooleanExpressionLeftAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ComparisonBooleanExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ComparisonBooleanExpression__Group_1__1__Impl
	rule__ComparisonBooleanExpression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ComparisonBooleanExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getComparisonBooleanExpressionAccess().getOperatorAssignment_1_1()); }
	(rule__ComparisonBooleanExpression__OperatorAssignment_1_1)
	{ after(grammarAccess.getComparisonBooleanExpressionAccess().getOperatorAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ComparisonBooleanExpression__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ComparisonBooleanExpression__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComparisonBooleanExpression__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getComparisonBooleanExpressionAccess().getRightAssignment_1_2()); }
	(rule__ComparisonBooleanExpression__RightAssignment_1_2)
	{ after(grammarAccess.getComparisonBooleanExpressionAccess().getRightAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__BooleanNegationExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BooleanNegationExpression__Group__0__Impl
	rule__BooleanNegationExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanNegationExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBooleanNegationExpressionAccess().getBooleanNegationExpressionAction_0()); }
	()
	{ after(grammarAccess.getBooleanNegationExpressionAccess().getBooleanNegationExpressionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanNegationExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BooleanNegationExpression__Group__1__Impl
	rule__BooleanNegationExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanNegationExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBooleanNegationExpressionAccess().getGroup_1()); }
	(rule__BooleanNegationExpression__Group_1__0)?
	{ after(grammarAccess.getBooleanNegationExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanNegationExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BooleanNegationExpression__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanNegationExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBooleanNegationExpressionAccess().getExpressionAssignment_2()); }
	(rule__BooleanNegationExpression__ExpressionAssignment_2)
	{ after(grammarAccess.getBooleanNegationExpressionAccess().getExpressionAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__BooleanNegationExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BooleanNegationExpression__Group_1__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanNegationExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBooleanNegationExpressionAccess().getIsNegateAssignment_1_0()); }
	(rule__BooleanNegationExpression__IsNegateAssignment_1_0)
	{ after(grammarAccess.getBooleanNegationExpressionAccess().getIsNegateAssignment_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Atomic__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Atomic__Group_0__0__Impl
	rule__Atomic__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Atomic__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAtomicAccess().getLeftParenthesisKeyword_0_0()); }
	LeftParenthesis
	{ after(grammarAccess.getAtomicAccess().getLeftParenthesisKeyword_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Atomic__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Atomic__Group_0__1__Impl
	rule__Atomic__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Atomic__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAtomicAccess().getExpressionParserRuleCall_0_1()); }
	ruleExpression
	{ after(grammarAccess.getAtomicAccess().getExpressionParserRuleCall_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Atomic__Group_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Atomic__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Atomic__Group_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAtomicAccess().getRightParenthesisKeyword_0_2()); }
	RightParenthesis
	{ after(grammarAccess.getAtomicAccess().getRightParenthesisKeyword_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Transformation__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTransformationAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getTransformationAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__ParametersAssignment_5_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTransformationAccess().getParametersParameterParserRuleCall_5_0_0()); }
		ruleParameter
		{ after(grammarAccess.getTransformationAccess().getParametersParameterParserRuleCall_5_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__ParametersAssignment_5_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTransformationAccess().getParametersParameterParserRuleCall_5_1_1_0()); }
		ruleParameter
		{ after(grammarAccess.getTransformationAccess().getParametersParameterParserRuleCall_5_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__TypeAssignment_7_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTransformationAccess().getTypeTransformationTypeParserRuleCall_7_1_0()); }
		ruleTransformationType
		{ after(grammarAccess.getTransformationAccess().getTypeTransformationTypeParserRuleCall_7_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__PreconditionsAssignment_12
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTransformationAccess().getPreconditionsExpressionParserRuleCall_12_0()); }
		ruleExpression
		{ after(grammarAccess.getTransformationAccess().getPreconditionsExpressionParserRuleCall_12_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__ContentAssignment_16
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTransformationAccess().getContentExpressionParserRuleCall_16_0()); }
		ruleExpression
		{ after(grammarAccess.getTransformationAccess().getContentExpressionParserRuleCall_16_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Transformation__OutputAssignment_18_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTransformationAccess().getOutputExpressionParserRuleCall_18_2_0()); }
		ruleExpression
		{ after(grammarAccess.getTransformationAccess().getOutputExpressionParserRuleCall_18_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeBasedTransformationType__TypeAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeBasedTransformationTypeAccess().getTypeTransformationTypesEnumRuleCall_0()); }
		ruleTransformationTypes
		{ after(grammarAccess.getTypeBasedTransformationTypeAccess().getTypeTransformationTypesEnumRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EClassBasedTransformationType__TypeAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEClassBasedTransformationTypeAccess().getTypeEClassCrossReference_1_0()); }
		(
			{ before(grammarAccess.getEClassBasedTransformationTypeAccess().getTypeEClassIDTerminalRuleCall_1_0_1()); }
			RULE_ID
			{ after(grammarAccess.getEClassBasedTransformationTypeAccess().getTypeEClassIDTerminalRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getEClassBasedTransformationTypeAccess().getTypeEClassCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedTransformationType__TypeAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getListBasedTransformationTypeAccess().getTypeEClassCrossReference_3_0()); }
		(
			{ before(grammarAccess.getListBasedTransformationTypeAccess().getTypeEClassIDTerminalRuleCall_3_0_1()); }
			RULE_ID
			{ after(grammarAccess.getListBasedTransformationTypeAccess().getTypeEClassIDTerminalRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getListBasedTransformationTypeAccess().getTypeEClassCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeBasedParameter__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeBasedParameterAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getTypeBasedParameterAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeBasedParameter__TypeAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeBasedParameterAccess().getTypeTransformationTypesEnumRuleCall_3_0()); }
		ruleTransformationTypes
		{ after(grammarAccess.getTypeBasedParameterAccess().getTypeTransformationTypesEnumRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EClassBasedParameter__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEClassBasedParameterAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getEClassBasedParameterAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EClassBasedParameter__TypeAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEClassBasedParameterAccess().getTypeEClassCrossReference_3_0()); }
		(
			{ before(grammarAccess.getEClassBasedParameterAccess().getTypeEClassIDTerminalRuleCall_3_0_1()); }
			RULE_ID
			{ after(grammarAccess.getEClassBasedParameterAccess().getTypeEClassIDTerminalRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getEClassBasedParameterAccess().getTypeEClassCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedParameter__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getListBasedParameterAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getListBasedParameterAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListBasedParameter__TypeAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getListBasedParameterAccess().getTypeEClassCrossReference_5_0()); }
		(
			{ before(grammarAccess.getListBasedParameterAccess().getTypeEClassIDTerminalRuleCall_5_0_1()); }
			RULE_ID
			{ after(grammarAccess.getListBasedParameterAccess().getTypeEClassIDTerminalRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getListBasedParameterAccess().getTypeEClassCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConcatenationExpression__RightAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConcatenationExpressionAccess().getRightPrimaryParserRuleCall_1_2_0()); }
		rulePrimary
		{ after(grammarAccess.getConcatenationExpressionAccess().getRightPrimaryParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringLiteral__ValueAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0()); }
		RULE_STRING
		{ after(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumberLiteral__ValueAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumberLiteralAccess().getValueNumberParserRuleCall_0()); }
		ruleNumber
		{ after(grammarAccess.getNumberLiteralAccess().getValueNumberParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__IsTrueAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); }
		(
			{ before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); }
			True
			{ after(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); }
		)
		{ after(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PortDirectionLiteral__DirectionAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPortDirectionLiteralAccess().getDirectionPortDirectionEnumRuleCall_1_0()); }
		rulePortDirection
		{ after(grammarAccess.getPortDirectionLiteralAccess().getDirectionPortDirectionEnumRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__ContextAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFeatureCallExpressionAccess().getContextTypedMemberCrossReference_0_0()); }
		(
			{ before(grammarAccess.getFeatureCallExpressionAccess().getContextTypedMemberIDTerminalRuleCall_0_0_1()); }
			RULE_ID
			{ after(grammarAccess.getFeatureCallExpressionAccess().getContextTypedMemberIDTerminalRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getFeatureCallExpressionAccess().getContextTypedMemberCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__StructuralFeatureAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFeatureCallExpressionAccess().getStructuralFeatureETypedElementCrossReference_2_0()); }
		(
			{ before(grammarAccess.getFeatureCallExpressionAccess().getStructuralFeatureETypedElementIDTerminalRuleCall_2_0_1()); }
			RULE_ID
			{ after(grammarAccess.getFeatureCallExpressionAccess().getStructuralFeatureETypedElementIDTerminalRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getFeatureCallExpressionAccess().getStructuralFeatureETypedElementCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__ParameterValuesAssignment_3_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFeatureCallExpressionAccess().getParameterValuesExpressionParserRuleCall_3_1_0_0()); }
		ruleExpression
		{ after(grammarAccess.getFeatureCallExpressionAccess().getParameterValuesExpressionParserRuleCall_3_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallExpression__ParameterValuesAssignment_3_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFeatureCallExpressionAccess().getParameterValuesExpressionParserRuleCall_3_1_1_1_0()); }
		ruleExpression
		{ after(grammarAccess.getFeatureCallExpressionAccess().getParameterValuesExpressionParserRuleCall_3_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCallExpression__OperationAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOperationCallExpressionAccess().getOperationEOperationCrossReference_1_0()); }
		(
			{ before(grammarAccess.getOperationCallExpressionAccess().getOperationEOperationIDTerminalRuleCall_1_0_1()); }
			RULE_ID
			{ after(grammarAccess.getOperationCallExpressionAccess().getOperationEOperationIDTerminalRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getOperationCallExpressionAccess().getOperationEOperationCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCallExpression__ParameterValuesAssignment_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOperationCallExpressionAccess().getParameterValuesExpressionParserRuleCall_3_0_0()); }
		ruleExpression
		{ after(grammarAccess.getOperationCallExpressionAccess().getParameterValuesExpressionParserRuleCall_3_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCallExpression__ParameterValuesAssignment_3_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOperationCallExpressionAccess().getParameterValuesExpressionParserRuleCall_3_1_1_0()); }
		ruleExpression
		{ after(grammarAccess.getOperationCallExpressionAccess().getParameterValuesExpressionParserRuleCall_3_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__WriteableAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVariableDeclarationAccess().getWriteableVarKeyword_1_0_0()); }
		(
			{ before(grammarAccess.getVariableDeclarationAccess().getWriteableVarKeyword_1_0_0()); }
			Var
			{ after(grammarAccess.getVariableDeclarationAccess().getWriteableVarKeyword_1_0_0()); }
		)
		{ after(grammarAccess.getVariableDeclarationAccess().getWriteableVarKeyword_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__TypeAssignment_2_0_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVariableDeclarationAccess().getTypeTransformationTypeParserRuleCall_2_0_0_0_0()); }
		ruleTransformationType
		{ after(grammarAccess.getVariableDeclarationAccess().getTypeTransformationTypeParserRuleCall_2_0_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__NameAssignment_2_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_2_0_0_1_0()); }
		RULE_ID
		{ after(grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_2_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__NameAssignment_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_2_1_0()); }
		RULE_ID
		{ after(grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableDeclaration__RhsAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVariableDeclarationAccess().getRhsExpressionParserRuleCall_3_1_0()); }
		ruleExpression
		{ after(grammarAccess.getVariableDeclarationAccess().getRhsExpressionParserRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__TypeMemberAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentExpressionAccess().getTypeMemberVariableDeclarationCrossReference_1_0()); }
		(
			{ before(grammarAccess.getAssignmentExpressionAccess().getTypeMemberVariableDeclarationIDTerminalRuleCall_1_0_1()); }
			RULE_ID
			{ after(grammarAccess.getAssignmentExpressionAccess().getTypeMemberVariableDeclarationIDTerminalRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getAssignmentExpressionAccess().getTypeMemberVariableDeclarationCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__ValueAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentExpressionAccess().getValueExpressionParserRuleCall_3_0()); }
		ruleExpression
		{ after(grammarAccess.getAssignmentExpressionAccess().getValueExpressionParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedMemberCallExpression__TypeMemberAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypedMemberCallExpressionAccess().getTypeMemberTypedMemberCrossReference_1_0()); }
		(
			{ before(grammarAccess.getTypedMemberCallExpressionAccess().getTypeMemberTypedMemberIDTerminalRuleCall_1_0_1()); }
			RULE_ID
			{ after(grammarAccess.getTypedMemberCallExpressionAccess().getTypeMemberTypedMemberIDTerminalRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getTypedMemberCallExpressionAccess().getTypeMemberTypedMemberCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__DeclaredParamAssignment_0_0_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getForLoopExpressionAccess().getDeclaredParamParameterParserRuleCall_0_0_3_0()); }
		ruleParameter
		{ after(grammarAccess.getForLoopExpressionAccess().getDeclaredParamParameterParserRuleCall_0_0_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__ForExpressionAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getForLoopExpressionAccess().getForExpressionExpressionParserRuleCall_1_0()); }
		ruleExpression
		{ after(grammarAccess.getForLoopExpressionAccess().getForExpressionExpressionParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ForLoopExpression__EachExpressionAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getForLoopExpressionAccess().getEachExpressionExpressionParserRuleCall_4_1_0()); }
		ruleExpression
		{ after(grammarAccess.getForLoopExpressionAccess().getEachExpressionExpressionParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__ConditionAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIfExpressionAccess().getConditionBooleanExpressionParserRuleCall_3_0()); }
		ruleBooleanExpression
		{ after(grammarAccess.getIfExpressionAccess().getConditionBooleanExpressionParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__ThenAssignment_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIfExpressionAccess().getThenExpressionParserRuleCall_6_1_0()); }
		ruleExpression
		{ after(grammarAccess.getIfExpressionAccess().getThenExpressionParserRuleCall_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpression__ElseAssignment_8_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIfExpressionAccess().getElseExpressionParserRuleCall_8_2_1_0()); }
		ruleExpression
		{ after(grammarAccess.getIfExpressionAccess().getElseExpressionParserRuleCall_8_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OrBooleanExpression__RightAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOrBooleanExpressionAccess().getRightAndBooleanExpressionParserRuleCall_1_1_0()); }
		ruleAndBooleanExpression
		{ after(grammarAccess.getOrBooleanExpressionAccess().getRightAndBooleanExpressionParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AndBooleanExpression__RightAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAndBooleanExpressionAccess().getRightComparisonBooleanExpressionParserRuleCall_1_1_0()); }
		ruleComparisonBooleanExpression
		{ after(grammarAccess.getAndBooleanExpressionAccess().getRightComparisonBooleanExpressionParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ComparisonBooleanExpression__OperatorAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getComparisonBooleanExpressionAccess().getOperatorAlternatives_1_1_0()); }
		(rule__ComparisonBooleanExpression__OperatorAlternatives_1_1_0)
		{ after(grammarAccess.getComparisonBooleanExpressionAccess().getOperatorAlternatives_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ComparisonBooleanExpression__RightAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getComparisonBooleanExpressionAccess().getRightBooleanNegationExpressionParserRuleCall_1_2_0()); }
		ruleBooleanNegationExpression
		{ after(grammarAccess.getComparisonBooleanExpressionAccess().getRightBooleanNegationExpressionParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanNegationExpression__IsNegateAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBooleanNegationExpressionAccess().getIsNegateExclamationMarkKeyword_1_0_0()); }
		(
			{ before(grammarAccess.getBooleanNegationExpressionAccess().getIsNegateExclamationMarkKeyword_1_0_0()); }
			ExclamationMark
			{ after(grammarAccess.getBooleanNegationExpressionAccess().getIsNegateExclamationMarkKeyword_1_0_0()); }
		)
		{ after(grammarAccess.getBooleanNegationExpressionAccess().getIsNegateExclamationMarkKeyword_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanNegationExpression__ExpressionAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBooleanNegationExpressionAccess().getExpressionAtomicParserRuleCall_2_0()); }
		ruleAtomic
		{ after(grammarAccess.getBooleanNegationExpressionAccess().getExpressionAtomicParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}
