/*******************************************************************************
* Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
* This program and the accompanying materials are made available under the
* terms of the Eclipse Public License 2.0 which is available at
* http://www.eclipse.org/legal/epl-2.0.
* 
* SPDX-License-Identifier: EPL-2.0
*******************************************************************************/
package org.safe4i.usf.transformation.language.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.safe4i.usf.transformation.language.services.USFLanguageGrammarAccess;

@SuppressWarnings("all")
public class USFLanguageSyntacticSequencer extends AbstractSyntacticSequencer {

	protected USFLanguageGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Atomic_LeftParenthesisKeyword_0_0_q;
	protected AbstractElementAlias match_FeatureCallExpression_FullStopKeyword_1_p;
	protected AbstractElementAlias match_FeatureCallExpression___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q;
	protected AbstractElementAlias match_ForLoopExpression___BEGINTerminalRuleCall_4_0_ENDTerminalRuleCall_4_2__q;
	protected AbstractElementAlias match_IfExpression___BEGINTerminalRuleCall_6_0_ENDTerminalRuleCall_6_2__q;
	protected AbstractElementAlias match_IfExpression___ElseKeyword_8_0_LeftCurlyBracketKeyword_8_1___BEGINTerminalRuleCall_8_2_0_ENDTerminalRuleCall_8_2_2__q_RightCurlyBracketKeyword_8_3__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (USFLanguageGrammarAccess) access;
		match_Atomic_LeftParenthesisKeyword_0_0_q = new TokenAlias(false, true, grammarAccess.getAtomicAccess().getLeftParenthesisKeyword_0_0());
		match_FeatureCallExpression_FullStopKeyword_1_p = new TokenAlias(true, false, grammarAccess.getFeatureCallExpressionAccess().getFullStopKeyword_1());
		match_FeatureCallExpression___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getFeatureCallExpressionAccess().getLeftParenthesisKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getFeatureCallExpressionAccess().getRightParenthesisKeyword_3_2()));
		match_ForLoopExpression___BEGINTerminalRuleCall_4_0_ENDTerminalRuleCall_4_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getForLoopExpressionAccess().getBEGINTerminalRuleCall_4_0()), new TokenAlias(false, false, grammarAccess.getForLoopExpressionAccess().getENDTerminalRuleCall_4_2()));
		match_IfExpression___BEGINTerminalRuleCall_6_0_ENDTerminalRuleCall_6_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getIfExpressionAccess().getBEGINTerminalRuleCall_6_0()), new TokenAlias(false, false, grammarAccess.getIfExpressionAccess().getENDTerminalRuleCall_6_2()));
		match_IfExpression___ElseKeyword_8_0_LeftCurlyBracketKeyword_8_1___BEGINTerminalRuleCall_8_2_0_ENDTerminalRuleCall_8_2_2__q_RightCurlyBracketKeyword_8_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getIfExpressionAccess().getElseKeyword_8_0()), new TokenAlias(false, false, grammarAccess.getIfExpressionAccess().getLeftCurlyBracketKeyword_8_1()), new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getIfExpressionAccess().getBEGINTerminalRuleCall_8_2_0()), new TokenAlias(false, false, grammarAccess.getIfExpressionAccess().getENDTerminalRuleCall_8_2_2())), new TokenAlias(false, false, grammarAccess.getIfExpressionAccess().getRightCurlyBracketKeyword_8_3()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getBEGINRule())
			return getBEGINToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getENDRule())
			return getENDToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * Synthetic terminal rule. The concrete syntax is to be specified by clients.
	 * Defaults to the empty string.
	 */
	protected String getBEGINToken(EObject semanticObject, RuleCall ruleCall, INode node) { return ""; }
	
	/**
	 * Synthetic terminal rule. The concrete syntax is to be specified by clients.
	 * Defaults to the empty string.
	 */
	protected String getENDToken(EObject semanticObject, RuleCall ruleCall, INode node) { return ""; }
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_Atomic_LeftParenthesisKeyword_0_0_q.equals(syntax))
				emit_Atomic_LeftParenthesisKeyword_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_FeatureCallExpression_FullStopKeyword_1_p.equals(syntax))
				emit_FeatureCallExpression_FullStopKeyword_1_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_FeatureCallExpression___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q.equals(syntax))
				emit_FeatureCallExpression___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ForLoopExpression___BEGINTerminalRuleCall_4_0_ENDTerminalRuleCall_4_2__q.equals(syntax))
				emit_ForLoopExpression___BEGINTerminalRuleCall_4_0_ENDTerminalRuleCall_4_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_IfExpression___BEGINTerminalRuleCall_6_0_ENDTerminalRuleCall_6_2__q.equals(syntax))
				emit_IfExpression___BEGINTerminalRuleCall_6_0_ENDTerminalRuleCall_6_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_IfExpression___ElseKeyword_8_0_LeftCurlyBracketKeyword_8_1___BEGINTerminalRuleCall_8_2_0_ENDTerminalRuleCall_8_2_2__q_RightCurlyBracketKeyword_8_3__q.equals(syntax))
				emit_IfExpression___ElseKeyword_8_0_LeftCurlyBracketKeyword_8_1___BEGINTerminalRuleCall_8_2_0_ENDTerminalRuleCall_8_2_2__q_RightCurlyBracketKeyword_8_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     '('?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) 'false' (rule start)
	 *     (rule start) (ambiguity) 'null' (rule start)
	 *     (rule start) (ambiguity) context=[TypedMember|ID]
	 *     (rule start) (ambiguity) direction=PortDirection
	 *     (rule start) (ambiguity) isTrue?='true'
	 *     (rule start) (ambiguity) typeMember=[TypedMember|ID]
	 *     (rule start) (ambiguity) value=Number
	 *     (rule start) (ambiguity) value=STRING
	 */
	protected void emit_Atomic_LeftParenthesisKeyword_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '.'+
	 *
	 * This ambiguous syntax occurs at:
	 *     context=[TypedMember|ID] (ambiguity) structuralFeature=[ETypedElement|ID]
	 */
	protected void emit_FeatureCallExpression_FullStopKeyword_1_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     structuralFeature=[ETypedElement|ID] (ambiguity) (rule end)
	 */
	protected void emit_FeatureCallExpression___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (BEGIN END)?
	 *
	 * This ambiguous syntax occurs at:
	 *     forExpression=Expression ')' '{' (ambiguity) '}' ')' (rule end)
	 *     forExpression=Expression ')' '{' (ambiguity) '}' (rule end)
	 */
	protected void emit_ForLoopExpression___BEGINTerminalRuleCall_4_0_ENDTerminalRuleCall_4_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (BEGIN END)?
	 *
	 * This ambiguous syntax occurs at:
	 *     condition=BooleanExpression ')' '{' (ambiguity) '}' 'else' '{' BEGIN else+=Expression
	 *     condition=BooleanExpression ')' '{' (ambiguity) '}' ('else' '{' (BEGIN END)? '}')? ')' (rule end)
	 *     condition=BooleanExpression ')' '{' (ambiguity) '}' ('else' '{' (BEGIN END)? '}')? (rule end)
	 */
	protected void emit_IfExpression___BEGINTerminalRuleCall_6_0_ENDTerminalRuleCall_6_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('else' '{' (BEGIN END)? '}')?
	 *
	 * This ambiguous syntax occurs at:
	 *     condition=BooleanExpression ')' '{' (BEGIN END)? '}' (ambiguity) ')' (rule end)
	 *     condition=BooleanExpression ')' '{' (BEGIN END)? '}' (ambiguity) (rule end)
	 *     then+=Expression END '}' (ambiguity) ')' (rule end)
	 *     then+=Expression END '}' (ambiguity) (rule end)
	 */
	protected void emit_IfExpression___ElseKeyword_8_0_LeftCurlyBracketKeyword_8_1___BEGINTerminalRuleCall_8_2_0_ENDTerminalRuleCall_8_2_2__q_RightCurlyBracketKeyword_8_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
