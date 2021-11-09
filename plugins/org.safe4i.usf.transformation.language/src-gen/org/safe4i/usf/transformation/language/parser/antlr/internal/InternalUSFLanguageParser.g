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
	superClass=AbstractInternalAntlrParser;
}

@header {
package org.safe4i.usf.transformation.language.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.safe4i.usf.transformation.language.services.USFLanguageGrammarAccess;

}

@members {

 	private USFLanguageGrammarAccess grammarAccess;

    public InternalUSFLanguageParser(TokenStream input, USFLanguageGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Transformation";
   	}

   	@Override
   	protected USFLanguageGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleTransformation
entryRuleTransformation returns [EObject current=null]@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
}:
	{ newCompositeNode(grammarAccess.getTransformationRule()); }
	iv_ruleTransformation=ruleTransformation
	{ $current=$iv_ruleTransformation.current; }
	EOF;
finally {
	myHiddenTokenState.restore();
}

// Rule Transformation
ruleTransformation returns [EObject current=null]
@init {
	enterRule();
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getTransformationAccess().getTransformationAction_0(),
					$current);
			}
		)
		otherlv_1=Transform
		{
			newLeafNode(otherlv_1, grammarAccess.getTransformationAccess().getTransformKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getTransformationAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTransformationRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_3=LeftParenthesis
		{
			newLeafNode(otherlv_3, grammarAccess.getTransformationAccess().getLeftParenthesisKeyword_3());
		}
		this_BEGIN_4=RULE_BEGIN
		{
			newLeafNode(this_BEGIN_4, grammarAccess.getTransformationAccess().getBEGINTerminalRuleCall_4());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getTransformationAccess().getParametersParameterParserRuleCall_5_0_0());
					}
					lv_parameters_5_0=ruleParameter
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTransformationRule());
						}
						add(
							$current,
							"parameters",
							lv_parameters_5_0,
							"org.safe4i.usf.transformation.language.USFLanguage.Parameter");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_6=Comma
				{
					newLeafNode(otherlv_6, grammarAccess.getTransformationAccess().getCommaKeyword_5_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getTransformationAccess().getParametersParameterParserRuleCall_5_1_1_0());
						}
						lv_parameters_7_0=ruleParameter
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTransformationRule());
							}
							add(
								$current,
								"parameters",
								lv_parameters_7_0,
								"org.safe4i.usf.transformation.language.USFLanguage.Parameter");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_8=RightParenthesis
		{
			newLeafNode(otherlv_8, grammarAccess.getTransformationAccess().getRightParenthesisKeyword_6());
		}
		(
			otherlv_9=Colon
			{
				newLeafNode(otherlv_9, grammarAccess.getTransformationAccess().getColonKeyword_7_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTransformationAccess().getTypeTransformationTypeParserRuleCall_7_1_0());
					}
					lv_type_10_0=ruleTransformationType
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTransformationRule());
						}
						set(
							$current,
							"type",
							lv_type_10_0,
							"org.safe4i.usf.transformation.language.USFLanguage.TransformationType");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_11=LeftCurlyBracket
		{
			newLeafNode(otherlv_11, grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_8());
		}
		this_END_12=RULE_END
		{
			newLeafNode(this_END_12, grammarAccess.getTransformationAccess().getENDTerminalRuleCall_9());
		}
		otherlv_13=PRECONDITION
		{
			newLeafNode(otherlv_13, grammarAccess.getTransformationAccess().getPRECONDITIONKeyword_10());
		}
		this_BEGIN_14=RULE_BEGIN
		{
			newLeafNode(this_BEGIN_14, grammarAccess.getTransformationAccess().getBEGINTerminalRuleCall_11());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTransformationAccess().getPreconditionsExpressionParserRuleCall_12_0());
				}
				lv_preconditions_15_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTransformationRule());
					}
					add(
						$current,
						"preconditions",
						lv_preconditions_15_0,
						"org.safe4i.usf.transformation.language.USFLanguage.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		this_END_16=RULE_END
		{
			newLeafNode(this_END_16, grammarAccess.getTransformationAccess().getENDTerminalRuleCall_13());
		}
		otherlv_17=RULES
		{
			newLeafNode(otherlv_17, grammarAccess.getTransformationAccess().getRULESKeyword_14());
		}
		this_BEGIN_18=RULE_BEGIN
		{
			newLeafNode(this_BEGIN_18, grammarAccess.getTransformationAccess().getBEGINTerminalRuleCall_15());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTransformationAccess().getContentExpressionParserRuleCall_16_0());
				}
				lv_content_19_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTransformationRule());
					}
					add(
						$current,
						"content",
						lv_content_19_0,
						"org.safe4i.usf.transformation.language.USFLanguage.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		this_END_20=RULE_END
		{
			newLeafNode(this_END_20, grammarAccess.getTransformationAccess().getENDTerminalRuleCall_17());
		}
		(
			otherlv_21=RETURN
			{
				newLeafNode(otherlv_21, grammarAccess.getTransformationAccess().getRETURNKeyword_18_0());
			}
			this_BEGIN_22=RULE_BEGIN
			{
				newLeafNode(this_BEGIN_22, grammarAccess.getTransformationAccess().getBEGINTerminalRuleCall_18_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTransformationAccess().getOutputExpressionParserRuleCall_18_2_0());
					}
					lv_output_23_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTransformationRule());
						}
						set(
							$current,
							"output",
							lv_output_23_0,
							"org.safe4i.usf.transformation.language.USFLanguage.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			this_END_24=RULE_END
			{
				newLeafNode(this_END_24, grammarAccess.getTransformationAccess().getENDTerminalRuleCall_18_3());
			}
		)?
		otherlv_25=RightCurlyBracket
		{
			newLeafNode(otherlv_25, grammarAccess.getTransformationAccess().getRightCurlyBracketKeyword_19());
		}
	)
;
finally {
	myHiddenTokenState.restore();
}

// Entry rule entryRuleExpression
entryRuleExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getExpressionRule()); }
	iv_ruleExpression=ruleExpression
	{ $current=$iv_ruleExpression.current; }
	EOF;

// Rule Expression
ruleExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentOrVariableDeclarationParserRuleCall_0());
		}
		this_AssignmentOrVariableDeclaration_0=ruleAssignmentOrVariableDeclaration
		{
			$current = $this_AssignmentOrVariableDeclaration_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getExpressionAccess().getNullLiteralParserRuleCall_1());
		}
		this_NullLiteral_1=ruleNullLiteral
		{
			$current = $this_NullLiteral_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getExpressionAccess().getBooleanLiteralParserRuleCall_2());
		}
		this_BooleanLiteral_2=ruleBooleanLiteral
		{
			$current = $this_BooleanLiteral_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		(
			((
				(
				)
				For
				LeftParenthesis
				(
					(
						ruleParameter
					)
				)
				In
			)
			)=>
			{
				newCompositeNode(grammarAccess.getExpressionAccess().getForLoopExpressionParserRuleCall_3());
			}
			this_ForLoopExpression_3=ruleForLoopExpression
			{
				$current = $this_ForLoopExpression_3.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		{
			newCompositeNode(grammarAccess.getExpressionAccess().getIfExpressionParserRuleCall_4());
		}
		this_IfExpression_4=ruleIfExpression
		{
			$current = $this_IfExpression_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getExpressionAccess().getConcatenationExpressionParserRuleCall_5());
		}
		this_ConcatenationExpression_5=ruleConcatenationExpression
		{
			$current = $this_ConcatenationExpression_5.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleTransformationType
entryRuleTransformationType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTransformationTypeRule()); }
	iv_ruleTransformationType=ruleTransformationType
	{ $current=$iv_ruleTransformationType.current; }
	EOF;

// Rule TransformationType
ruleTransformationType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getTransformationTypeAccess().getTypeBasedTransformationTypeParserRuleCall_0());
		}
		this_TypeBasedTransformationType_0=ruleTypeBasedTransformationType
		{
			$current = $this_TypeBasedTransformationType_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTransformationTypeAccess().getEClassBasedTransformationTypeParserRuleCall_1());
		}
		this_EClassBasedTransformationType_1=ruleEClassBasedTransformationType
		{
			$current = $this_EClassBasedTransformationType_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTransformationTypeAccess().getListBasedTransformationTypeParserRuleCall_2());
		}
		this_ListBasedTransformationType_2=ruleListBasedTransformationType
		{
			$current = $this_ListBasedTransformationType_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleTypeBasedTransformationType
entryRuleTypeBasedTransformationType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeBasedTransformationTypeRule()); }
	iv_ruleTypeBasedTransformationType=ruleTypeBasedTransformationType
	{ $current=$iv_ruleTypeBasedTransformationType.current; }
	EOF;

// Rule TypeBasedTransformationType
ruleTypeBasedTransformationType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getTypeBasedTransformationTypeAccess().getTypeTransformationTypesEnumRuleCall_0());
			}
			lv_type_0_0=ruleTransformationTypes
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getTypeBasedTransformationTypeRule());
				}
				set(
					$current,
					"type",
					lv_type_0_0,
					"org.safe4i.usf.transformation.language.USFLanguage.TransformationTypes");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleEClassBasedTransformationType
entryRuleEClassBasedTransformationType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEClassBasedTransformationTypeRule()); }
	iv_ruleEClassBasedTransformationType=ruleEClassBasedTransformationType
	{ $current=$iv_ruleEClassBasedTransformationType.current; }
	EOF;

// Rule EClassBasedTransformationType
ruleEClassBasedTransformationType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getEClassBasedTransformationTypeAccess().getEClassBasedTransformationTypeAction_0(),
					$current);
			}
		)
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEClassBasedTransformationTypeRule());
					}
				}
				otherlv_1=RULE_ID
				{
					newLeafNode(otherlv_1, grammarAccess.getEClassBasedTransformationTypeAccess().getTypeEClassCrossReference_1_0());
				}
			)
		)
	)
;

// Entry rule entryRuleListBasedTransformationType
entryRuleListBasedTransformationType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getListBasedTransformationTypeRule()); }
	iv_ruleListBasedTransformationType=ruleListBasedTransformationType
	{ $current=$iv_ruleListBasedTransformationType.current; }
	EOF;

// Rule ListBasedTransformationType
ruleListBasedTransformationType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getListBasedTransformationTypeAccess().getListBasedTransformationTypeAction_0(),
					$current);
			}
		)
		otherlv_1=List
		{
			newLeafNode(otherlv_1, grammarAccess.getListBasedTransformationTypeAccess().getListKeyword_1());
		}
		otherlv_2=LessThanSign
		{
			newLeafNode(otherlv_2, grammarAccess.getListBasedTransformationTypeAccess().getLessThanSignKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getListBasedTransformationTypeRule());
					}
				}
				otherlv_3=RULE_ID
				{
					newLeafNode(otherlv_3, grammarAccess.getListBasedTransformationTypeAccess().getTypeEClassCrossReference_3_0());
				}
			)
		)
		otherlv_4=GreaterThanSign
		{
			newLeafNode(otherlv_4, grammarAccess.getListBasedTransformationTypeAccess().getGreaterThanSignKeyword_4());
		}
	)
;

// Entry rule entryRuleParameter
entryRuleParameter returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getParameterRule()); }
	iv_ruleParameter=ruleParameter
	{ $current=$iv_ruleParameter.current; }
	EOF;

// Rule Parameter
ruleParameter returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getParameterAccess().getTypeBasedParameterParserRuleCall_0());
		}
		this_TypeBasedParameter_0=ruleTypeBasedParameter
		{
			$current = $this_TypeBasedParameter_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getParameterAccess().getEClassBasedParameterParserRuleCall_1());
		}
		this_EClassBasedParameter_1=ruleEClassBasedParameter
		{
			$current = $this_EClassBasedParameter_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getParameterAccess().getListBasedParameterParserRuleCall_2());
		}
		this_ListBasedParameter_2=ruleListBasedParameter
		{
			$current = $this_ListBasedParameter_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleTypeBasedParameter
entryRuleTypeBasedParameter returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeBasedParameterRule()); }
	iv_ruleTypeBasedParameter=ruleTypeBasedParameter
	{ $current=$iv_ruleTypeBasedParameter.current; }
	EOF;

// Rule TypeBasedParameter
ruleTypeBasedParameter returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getTypeBasedParameterAccess().getTypeBasedParameterAction_0(),
					$current);
			}
		)
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getTypeBasedParameterAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTypeBasedParameterRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2=Colon
		{
			newLeafNode(otherlv_2, grammarAccess.getTypeBasedParameterAccess().getColonKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTypeBasedParameterAccess().getTypeTransformationTypesEnumRuleCall_3_0());
				}
				lv_type_3_0=ruleTransformationTypes
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTypeBasedParameterRule());
					}
					set(
						$current,
						"type",
						lv_type_3_0,
						"org.safe4i.usf.transformation.language.USFLanguage.TransformationTypes");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleEClassBasedParameter
entryRuleEClassBasedParameter returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEClassBasedParameterRule()); }
	iv_ruleEClassBasedParameter=ruleEClassBasedParameter
	{ $current=$iv_ruleEClassBasedParameter.current; }
	EOF;

// Rule EClassBasedParameter
ruleEClassBasedParameter returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getEClassBasedParameterAccess().getEClassBasedParameterAction_0(),
					$current);
			}
		)
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getEClassBasedParameterAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEClassBasedParameterRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2=Colon
		{
			newLeafNode(otherlv_2, grammarAccess.getEClassBasedParameterAccess().getColonKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEClassBasedParameterRule());
					}
				}
				otherlv_3=RULE_ID
				{
					newLeafNode(otherlv_3, grammarAccess.getEClassBasedParameterAccess().getTypeEClassCrossReference_3_0());
				}
			)
		)
	)
;

// Entry rule entryRuleListBasedParameter
entryRuleListBasedParameter returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getListBasedParameterRule()); }
	iv_ruleListBasedParameter=ruleListBasedParameter
	{ $current=$iv_ruleListBasedParameter.current; }
	EOF;

// Rule ListBasedParameter
ruleListBasedParameter returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getListBasedParameterAccess().getListBasedParameterAction_0(),
					$current);
			}
		)
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getListBasedParameterAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getListBasedParameterRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2=Colon
		{
			newLeafNode(otherlv_2, grammarAccess.getListBasedParameterAccess().getColonKeyword_2());
		}
		otherlv_3=List
		{
			newLeafNode(otherlv_3, grammarAccess.getListBasedParameterAccess().getListKeyword_3());
		}
		otherlv_4=LessThanSign
		{
			newLeafNode(otherlv_4, grammarAccess.getListBasedParameterAccess().getLessThanSignKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getListBasedParameterRule());
					}
				}
				otherlv_5=RULE_ID
				{
					newLeafNode(otherlv_5, grammarAccess.getListBasedParameterAccess().getTypeEClassCrossReference_5_0());
				}
			)
		)
		otherlv_6=GreaterThanSign
		{
			newLeafNode(otherlv_6, grammarAccess.getListBasedParameterAccess().getGreaterThanSignKeyword_6());
		}
	)
;

// Entry rule entryRuleConcatenationExpression
entryRuleConcatenationExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConcatenationExpressionRule()); }
	iv_ruleConcatenationExpression=ruleConcatenationExpression
	{ $current=$iv_ruleConcatenationExpression.current; }
	EOF;

// Rule ConcatenationExpression
ruleConcatenationExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getConcatenationExpressionAccess().getPrimaryParserRuleCall_0());
		}
		this_Primary_0=rulePrimary
		{
			$current = $this_Primary_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getConcatenationExpressionAccess().getConcatenationExpressionLeftAction_1_0(),
						$current);
				}
			)
			otherlv_2=PlusSign
			{
				newLeafNode(otherlv_2, grammarAccess.getConcatenationExpressionAccess().getPlusSignKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getConcatenationExpressionAccess().getRightPrimaryParserRuleCall_1_2_0());
					}
					lv_right_3_0=rulePrimary
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getConcatenationExpressionRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.safe4i.usf.transformation.language.USFLanguage.Primary");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRulePrimary
entryRulePrimary returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimaryRule()); }
	iv_rulePrimary=rulePrimary
	{ $current=$iv_rulePrimary.current; }
	EOF;

// Rule Primary
rulePrimary returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getPrimaryAccess().getStringLiteralParserRuleCall_0());
		}
		this_StringLiteral_0=ruleStringLiteral
		{
			$current = $this_StringLiteral_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPrimaryAccess().getNumberLiteralParserRuleCall_1());
		}
		this_NumberLiteral_1=ruleNumberLiteral
		{
			$current = $this_NumberLiteral_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPrimaryAccess().getTypedMemberCallExpressionParserRuleCall_2());
		}
		this_TypedMemberCallExpression_2=ruleTypedMemberCallExpression
		{
			$current = $this_TypedMemberCallExpression_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPrimaryAccess().getFeatureCallExpressionParserRuleCall_3());
		}
		this_FeatureCallExpression_3=ruleFeatureCallExpression
		{
			$current = $this_FeatureCallExpression_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPrimaryAccess().getOperationCallExpressionParserRuleCall_4());
		}
		this_OperationCallExpression_4=ruleOperationCallExpression
		{
			$current = $this_OperationCallExpression_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPrimaryAccess().getPortDirectionLiteralParserRuleCall_5());
		}
		this_PortDirectionLiteral_5=rulePortDirectionLiteral
		{
			$current = $this_PortDirectionLiteral_5.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleStringLiteral
entryRuleStringLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStringLiteralRule()); }
	iv_ruleStringLiteral=ruleStringLiteral
	{ $current=$iv_ruleStringLiteral.current; }
	EOF;

// Rule StringLiteral
ruleStringLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			lv_value_0_0=RULE_STRING
			{
				newLeafNode(lv_value_0_0, grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getStringLiteralRule());
				}
				setWithLastConsumed(
					$current,
					"value",
					lv_value_0_0,
					"org.eclipse.xtext.common.Terminals.STRING");
			}
		)
	)
;

// Entry rule entryRuleNumberLiteral
entryRuleNumberLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNumberLiteralRule()); }
	iv_ruleNumberLiteral=ruleNumberLiteral
	{ $current=$iv_ruleNumberLiteral.current; }
	EOF;

// Rule NumberLiteral
ruleNumberLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getNumberLiteralAccess().getValueNumberParserRuleCall_0());
			}
			lv_value_0_0=ruleNumber
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getNumberLiteralRule());
				}
				set(
					$current,
					"value",
					lv_value_0_0,
					"org.safe4i.usf.transformation.language.USFLanguage.Number");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleNullLiteral
entryRuleNullLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNullLiteralRule()); }
	iv_ruleNullLiteral=ruleNullLiteral
	{ $current=$iv_ruleNullLiteral.current; }
	EOF;

// Rule NullLiteral
ruleNullLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getNullLiteralAccess().getNullLiteralAction_0(),
					$current);
			}
		)
		otherlv_1=Null
		{
			newLeafNode(otherlv_1, grammarAccess.getNullLiteralAccess().getNullKeyword_1());
		}
	)
;

// Entry rule entryRuleBooleanLiteral
entryRuleBooleanLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBooleanLiteralRule()); }
	iv_ruleBooleanLiteral=ruleBooleanLiteral
	{ $current=$iv_ruleBooleanLiteral.current; }
	EOF;

// Rule BooleanLiteral
ruleBooleanLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
					$current);
			}
		)
		(
			otherlv_1=False
			{
				newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
			}
			    |
			(
				(
					lv_isTrue_2_0=True
					{
						newLeafNode(lv_isTrue_2_0, grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBooleanLiteralRule());
						}
						setWithLastConsumed($current, "isTrue", lv_isTrue_2_0 != null, "true");
					}
				)
			)
		)
	)
;

// Entry rule entryRulePortDirectionLiteral
entryRulePortDirectionLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPortDirectionLiteralRule()); }
	iv_rulePortDirectionLiteral=rulePortDirectionLiteral
	{ $current=$iv_rulePortDirectionLiteral.current; }
	EOF;

// Rule PortDirectionLiteral
rulePortDirectionLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getPortDirectionLiteralAccess().getPortDirectionLiteralAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getPortDirectionLiteralAccess().getDirectionPortDirectionEnumRuleCall_1_0());
				}
				lv_direction_1_0=rulePortDirection
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPortDirectionLiteralRule());
					}
					set(
						$current,
						"direction",
						lv_direction_1_0,
						"org.safe4i.usf.transformation.language.USFLanguage.PortDirection");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleNumber
entryRuleNumber returns [String current=null]@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	{ newCompositeNode(grammarAccess.getNumberRule()); }
	iv_ruleNumber=ruleNumber
	{ $current=$iv_ruleNumber.current.getText(); }
	EOF;
finally {
	myHiddenTokenState.restore();
}

// Rule Number
ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
@after {
	leaveRule();
}:
	(
		this_INT_0=RULE_INT
		{
			$current.merge(this_INT_0);
		}
		{
			newLeafNode(this_INT_0, grammarAccess.getNumberAccess().getINTTerminalRuleCall_0());
		}
		(
			kw=FullStop
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_1_0());
			}
			this_INT_2=RULE_INT
			{
				$current.merge(this_INT_2);
			}
			{
				newLeafNode(this_INT_2, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1());
			}
		)?
	)
;
finally {
	myHiddenTokenState.restore();
}

// Entry rule entryRuleFeatureCallExpression
entryRuleFeatureCallExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFeatureCallExpressionRule()); }
	iv_ruleFeatureCallExpression=ruleFeatureCallExpression
	{ $current=$iv_ruleFeatureCallExpression.current; }
	EOF;

// Rule FeatureCallExpression
ruleFeatureCallExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFeatureCallExpressionRule());
					}
				}
				otherlv_0=RULE_ID
				{
					newLeafNode(otherlv_0, grammarAccess.getFeatureCallExpressionAccess().getContextTypedMemberCrossReference_0_0());
				}
			)
		)
		(
			otherlv_1=FullStop
			{
				newLeafNode(otherlv_1, grammarAccess.getFeatureCallExpressionAccess().getFullStopKeyword_1());
			}
		)+
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFeatureCallExpressionRule());
					}
				}
				otherlv_2=RULE_ID
				{
					newLeafNode(otherlv_2, grammarAccess.getFeatureCallExpressionAccess().getStructuralFeatureETypedElementCrossReference_2_0());
				}
			)
		)
		(
			otherlv_3=LeftParenthesis
			{
				newLeafNode(otherlv_3, grammarAccess.getFeatureCallExpressionAccess().getLeftParenthesisKeyword_3_0());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getFeatureCallExpressionAccess().getParameterValuesExpressionParserRuleCall_3_1_0_0());
						}
						lv_parameterValues_4_0=ruleExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getFeatureCallExpressionRule());
							}
							add(
								$current,
								"parameterValues",
								lv_parameterValues_4_0,
								"org.safe4i.usf.transformation.language.USFLanguage.Expression");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_5=Comma
					{
						newLeafNode(otherlv_5, grammarAccess.getFeatureCallExpressionAccess().getCommaKeyword_3_1_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getFeatureCallExpressionAccess().getParameterValuesExpressionParserRuleCall_3_1_1_1_0());
							}
							lv_parameterValues_6_0=ruleExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getFeatureCallExpressionRule());
								}
								add(
									$current,
									"parameterValues",
									lv_parameterValues_6_0,
									"org.safe4i.usf.transformation.language.USFLanguage.Expression");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)?
			otherlv_7=RightParenthesis
			{
				newLeafNode(otherlv_7, grammarAccess.getFeatureCallExpressionAccess().getRightParenthesisKeyword_3_2());
			}
		)?
	)
;

// Entry rule entryRuleOperationCallExpression
entryRuleOperationCallExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOperationCallExpressionRule()); }
	iv_ruleOperationCallExpression=ruleOperationCallExpression
	{ $current=$iv_ruleOperationCallExpression.current; }
	EOF;

// Rule OperationCallExpression
ruleOperationCallExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getOperationCallExpressionAccess().getOperationCallExpressionAction_0(),
					$current);
			}
		)
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getOperationCallExpressionRule());
					}
				}
				otherlv_1=RULE_ID
				{
					newLeafNode(otherlv_1, grammarAccess.getOperationCallExpressionAccess().getOperationEOperationCrossReference_1_0());
				}
			)
		)
		otherlv_2=LeftParenthesis
		{
			newLeafNode(otherlv_2, grammarAccess.getOperationCallExpressionAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getOperationCallExpressionAccess().getParameterValuesExpressionParserRuleCall_3_0_0());
					}
					lv_parameterValues_3_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getOperationCallExpressionRule());
						}
						add(
							$current,
							"parameterValues",
							lv_parameterValues_3_0,
							"org.safe4i.usf.transformation.language.USFLanguage.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4=Comma
				{
					newLeafNode(otherlv_4, grammarAccess.getOperationCallExpressionAccess().getCommaKeyword_3_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getOperationCallExpressionAccess().getParameterValuesExpressionParserRuleCall_3_1_1_0());
						}
						lv_parameterValues_5_0=ruleExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getOperationCallExpressionRule());
							}
							add(
								$current,
								"parameterValues",
								lv_parameterValues_5_0,
								"org.safe4i.usf.transformation.language.USFLanguage.Expression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_6=RightParenthesis
		{
			newLeafNode(otherlv_6, grammarAccess.getOperationCallExpressionAccess().getRightParenthesisKeyword_4());
		}
	)
;

// Entry rule entryRuleAssignmentOrVariableDeclaration
entryRuleAssignmentOrVariableDeclaration returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAssignmentOrVariableDeclarationRule()); }
	iv_ruleAssignmentOrVariableDeclaration=ruleAssignmentOrVariableDeclaration
	{ $current=$iv_ruleAssignmentOrVariableDeclaration.current; }
	EOF;

// Rule AssignmentOrVariableDeclaration
ruleAssignmentOrVariableDeclaration returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getAssignmentOrVariableDeclarationAccess().getVariableDeclarationParserRuleCall_0());
		}
		this_VariableDeclaration_0=ruleVariableDeclaration
		{
			$current = $this_VariableDeclaration_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getAssignmentOrVariableDeclarationAccess().getAssignmentExpressionParserRuleCall_1());
		}
		this_AssignmentExpression_1=ruleAssignmentExpression
		{
			$current = $this_AssignmentExpression_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleVariableDeclaration
entryRuleVariableDeclaration returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getVariableDeclarationRule()); }
	iv_ruleVariableDeclaration=ruleVariableDeclaration
	{ $current=$iv_ruleVariableDeclaration.current; }
	EOF;

// Rule VariableDeclaration
ruleVariableDeclaration returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getVariableDeclarationAccess().getVariableDeclarationAction_0(),
					$current);
			}
		)
		(
			(
				(
					lv_writeable_1_0=Var
					{
						newLeafNode(lv_writeable_1_0, grammarAccess.getVariableDeclarationAccess().getWriteableVarKeyword_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getVariableDeclarationRule());
						}
						setWithLastConsumed($current, "writeable", lv_writeable_1_0 != null, "var");
					}
				)
			)
			    |
			otherlv_2=Val
			{
				newLeafNode(otherlv_2, grammarAccess.getVariableDeclarationAccess().getValKeyword_1_1());
			}
		)
		(
			(
				((
					(
						(
							ruleTransformationType
						)
					)
					(
						(
							RULE_ID
						)
					)
				)
				)=>
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTransformationTypeParserRuleCall_2_0_0_0_0());
							}
							lv_type_3_0=ruleTransformationType
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
								}
								set(
									$current,
									"type",
									lv_type_3_0,
									"org.safe4i.usf.transformation.language.USFLanguage.TransformationType");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						(
							lv_name_4_0=RULE_ID
							{
								newLeafNode(lv_name_4_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_2_0_0_1_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getVariableDeclarationRule());
								}
								setWithLastConsumed(
									$current,
									"name",
									lv_name_4_0,
									"org.eclipse.xtext.common.Terminals.ID");
							}
						)
					)
				)
			)
			    |
			(
				(
					lv_name_5_0=RULE_ID
					{
						newLeafNode(lv_name_5_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_2_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getVariableDeclarationRule());
						}
						setWithLastConsumed(
							$current,
							"name",
							lv_name_5_0,
							"org.eclipse.xtext.common.Terminals.ID");
					}
				)
			)
		)
		(
			otherlv_6=EqualsSign
			{
				newLeafNode(otherlv_6, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getVariableDeclarationAccess().getRhsExpressionParserRuleCall_3_1_0());
					}
					lv_rhs_7_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
						}
						set(
							$current,
							"rhs",
							lv_rhs_7_0,
							"org.safe4i.usf.transformation.language.USFLanguage.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleAssignmentExpression
entryRuleAssignmentExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAssignmentExpressionRule()); }
	iv_ruleAssignmentExpression=ruleAssignmentExpression
	{ $current=$iv_ruleAssignmentExpression.current; }
	EOF;

// Rule AssignmentExpression
ruleAssignmentExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionAction_0(),
					$current);
			}
		)
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAssignmentExpressionRule());
					}
				}
				otherlv_1=RULE_ID
				{
					newLeafNode(otherlv_1, grammarAccess.getAssignmentExpressionAccess().getTypeMemberVariableDeclarationCrossReference_1_0());
				}
			)
		)
		otherlv_2=EqualsSign
		{
			newLeafNode(otherlv_2, grammarAccess.getAssignmentExpressionAccess().getEqualsSignKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getValueExpressionParserRuleCall_3_0());
				}
				lv_value_3_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
					}
					set(
						$current,
						"value",
						lv_value_3_0,
						"org.safe4i.usf.transformation.language.USFLanguage.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleTypedMemberCallExpression
entryRuleTypedMemberCallExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypedMemberCallExpressionRule()); }
	iv_ruleTypedMemberCallExpression=ruleTypedMemberCallExpression
	{ $current=$iv_ruleTypedMemberCallExpression.current; }
	EOF;

// Rule TypedMemberCallExpression
ruleTypedMemberCallExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getTypedMemberCallExpressionAccess().getTypedMemberCallExpressionAction_0(),
					$current);
			}
		)
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTypedMemberCallExpressionRule());
					}
				}
				otherlv_1=RULE_ID
				{
					newLeafNode(otherlv_1, grammarAccess.getTypedMemberCallExpressionAccess().getTypeMemberTypedMemberCrossReference_1_0());
				}
			)
		)
	)
;

// Entry rule entryRuleForLoopExpression
entryRuleForLoopExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getForLoopExpressionRule()); }
	iv_ruleForLoopExpression=ruleForLoopExpression
	{ $current=$iv_ruleForLoopExpression.current; }
	EOF;

// Rule ForLoopExpression
ruleForLoopExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			((
				(
				)
				For
				LeftParenthesis
				(
					(
						ruleParameter
					)
				)
				In
			)
			)=>
			(
				(
					{
						$current = forceCreateModelElement(
							grammarAccess.getForLoopExpressionAccess().getForLoopExpressionAction_0_0_0(),
							$current);
					}
				)
				otherlv_1=For
				{
					newLeafNode(otherlv_1, grammarAccess.getForLoopExpressionAccess().getForKeyword_0_0_1());
				}
				otherlv_2=LeftParenthesis
				{
					newLeafNode(otherlv_2, grammarAccess.getForLoopExpressionAccess().getLeftParenthesisKeyword_0_0_2());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getForLoopExpressionAccess().getDeclaredParamParameterParserRuleCall_0_0_3_0());
						}
						lv_declaredParam_3_0=ruleParameter
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getForLoopExpressionRule());
							}
							set(
								$current,
								"declaredParam",
								lv_declaredParam_3_0,
								"org.safe4i.usf.transformation.language.USFLanguage.Parameter");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_4=In
				{
					newLeafNode(otherlv_4, grammarAccess.getForLoopExpressionAccess().getInKeyword_0_0_4());
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getForLoopExpressionAccess().getForExpressionExpressionParserRuleCall_1_0());
				}
				lv_forExpression_5_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getForLoopExpressionRule());
					}
					set(
						$current,
						"forExpression",
						lv_forExpression_5_0,
						"org.safe4i.usf.transformation.language.USFLanguage.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6=RightParenthesis
		{
			newLeafNode(otherlv_6, grammarAccess.getForLoopExpressionAccess().getRightParenthesisKeyword_2());
		}
		otherlv_7=LeftCurlyBracket
		{
			newLeafNode(otherlv_7, grammarAccess.getForLoopExpressionAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			this_BEGIN_8=RULE_BEGIN
			{
				newLeafNode(this_BEGIN_8, grammarAccess.getForLoopExpressionAccess().getBEGINTerminalRuleCall_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getForLoopExpressionAccess().getEachExpressionExpressionParserRuleCall_4_1_0());
					}
					lv_eachExpression_9_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getForLoopExpressionRule());
						}
						add(
							$current,
							"eachExpression",
							lv_eachExpression_9_0,
							"org.safe4i.usf.transformation.language.USFLanguage.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			this_END_10=RULE_END
			{
				newLeafNode(this_END_10, grammarAccess.getForLoopExpressionAccess().getENDTerminalRuleCall_4_2());
			}
		)?
		otherlv_11=RightCurlyBracket
		{
			newLeafNode(otherlv_11, grammarAccess.getForLoopExpressionAccess().getRightCurlyBracketKeyword_5());
		}
	)
;

// Entry rule entryRuleIfExpression
entryRuleIfExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIfExpressionRule()); }
	iv_ruleIfExpression=ruleIfExpression
	{ $current=$iv_ruleIfExpression.current; }
	EOF;

// Rule IfExpression
ruleIfExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getIfExpressionAccess().getIFExpressionAction_0(),
					$current);
			}
		)
		otherlv_1=If
		{
			newLeafNode(otherlv_1, grammarAccess.getIfExpressionAccess().getIfKeyword_1());
		}
		otherlv_2=LeftParenthesis
		{
			newLeafNode(otherlv_2, grammarAccess.getIfExpressionAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getIfExpressionAccess().getConditionBooleanExpressionParserRuleCall_3_0());
				}
				lv_condition_3_0=ruleBooleanExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIfExpressionRule());
					}
					set(
						$current,
						"condition",
						lv_condition_3_0,
						"org.safe4i.usf.transformation.language.USFLanguage.BooleanExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=RightParenthesis
		{
			newLeafNode(otherlv_4, grammarAccess.getIfExpressionAccess().getRightParenthesisKeyword_4());
		}
		otherlv_5=LeftCurlyBracket
		{
			newLeafNode(otherlv_5, grammarAccess.getIfExpressionAccess().getLeftCurlyBracketKeyword_5());
		}
		(
			this_BEGIN_6=RULE_BEGIN
			{
				newLeafNode(this_BEGIN_6, grammarAccess.getIfExpressionAccess().getBEGINTerminalRuleCall_6_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getIfExpressionAccess().getThenExpressionParserRuleCall_6_1_0());
					}
					lv_then_7_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getIfExpressionRule());
						}
						add(
							$current,
							"then",
							lv_then_7_0,
							"org.safe4i.usf.transformation.language.USFLanguage.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			this_END_8=RULE_END
			{
				newLeafNode(this_END_8, grammarAccess.getIfExpressionAccess().getENDTerminalRuleCall_6_2());
			}
		)?
		otherlv_9=RightCurlyBracket
		{
			newLeafNode(otherlv_9, grammarAccess.getIfExpressionAccess().getRightCurlyBracketKeyword_7());
		}
		(
			(
				(Else)=>
				otherlv_10=Else
				{
					newLeafNode(otherlv_10, grammarAccess.getIfExpressionAccess().getElseKeyword_8_0());
				}
			)
			otherlv_11=LeftCurlyBracket
			{
				newLeafNode(otherlv_11, grammarAccess.getIfExpressionAccess().getLeftCurlyBracketKeyword_8_1());
			}
			(
				this_BEGIN_12=RULE_BEGIN
				{
					newLeafNode(this_BEGIN_12, grammarAccess.getIfExpressionAccess().getBEGINTerminalRuleCall_8_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getIfExpressionAccess().getElseExpressionParserRuleCall_8_2_1_0());
						}
						lv_else_13_0=ruleExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getIfExpressionRule());
							}
							add(
								$current,
								"else",
								lv_else_13_0,
								"org.safe4i.usf.transformation.language.USFLanguage.Expression");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				this_END_14=RULE_END
				{
					newLeafNode(this_END_14, grammarAccess.getIfExpressionAccess().getENDTerminalRuleCall_8_2_2());
				}
			)?
			otherlv_15=RightCurlyBracket
			{
				newLeafNode(otherlv_15, grammarAccess.getIfExpressionAccess().getRightCurlyBracketKeyword_8_3());
			}
		)?
	)
;

// Entry rule entryRuleBooleanExpression
entryRuleBooleanExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBooleanExpressionRule()); }
	iv_ruleBooleanExpression=ruleBooleanExpression
	{ $current=$iv_ruleBooleanExpression.current; }
	EOF;

// Rule BooleanExpression
ruleBooleanExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getBooleanExpressionAccess().getOrBooleanExpressionParserRuleCall());
	}
	this_OrBooleanExpression_0=ruleOrBooleanExpression
	{
		$current = $this_OrBooleanExpression_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleOrBooleanExpression
entryRuleOrBooleanExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOrBooleanExpressionRule()); }
	iv_ruleOrBooleanExpression=ruleOrBooleanExpression
	{ $current=$iv_ruleOrBooleanExpression.current; }
	EOF;

// Rule OrBooleanExpression
ruleOrBooleanExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getOrBooleanExpressionAccess().getAndBooleanExpressionParserRuleCall_0());
		}
		this_AndBooleanExpression_0=ruleAndBooleanExpression
		{
			$current = $this_AndBooleanExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getOrBooleanExpressionAccess().getOrBooleanExpressionLeftAction_1_0_0(),
							$current);
					}
				)
				otherlv_2=VerticalLineVerticalLine
				{
					newLeafNode(otherlv_2, grammarAccess.getOrBooleanExpressionAccess().getVerticalLineVerticalLineKeyword_1_0_1());
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getOrBooleanExpressionAccess().getRightAndBooleanExpressionParserRuleCall_1_1_0());
					}
					lv_right_3_0=ruleAndBooleanExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getOrBooleanExpressionRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.safe4i.usf.transformation.language.USFLanguage.AndBooleanExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleAndBooleanExpression
entryRuleAndBooleanExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAndBooleanExpressionRule()); }
	iv_ruleAndBooleanExpression=ruleAndBooleanExpression
	{ $current=$iv_ruleAndBooleanExpression.current; }
	EOF;

// Rule AndBooleanExpression
ruleAndBooleanExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getAndBooleanExpressionAccess().getComparisonBooleanExpressionParserRuleCall_0());
		}
		this_ComparisonBooleanExpression_0=ruleComparisonBooleanExpression
		{
			$current = $this_ComparisonBooleanExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getAndBooleanExpressionAccess().getAndBooleanExpressionLeftAction_1_0_0(),
							$current);
					}
				)
				otherlv_2=AmpersandAmpersand
				{
					newLeafNode(otherlv_2, grammarAccess.getAndBooleanExpressionAccess().getAmpersandAmpersandKeyword_1_0_1());
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getAndBooleanExpressionAccess().getRightComparisonBooleanExpressionParserRuleCall_1_1_0());
					}
					lv_right_3_0=ruleComparisonBooleanExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAndBooleanExpressionRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.safe4i.usf.transformation.language.USFLanguage.ComparisonBooleanExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleComparisonBooleanExpression
entryRuleComparisonBooleanExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getComparisonBooleanExpressionRule()); }
	iv_ruleComparisonBooleanExpression=ruleComparisonBooleanExpression
	{ $current=$iv_ruleComparisonBooleanExpression.current; }
	EOF;

// Rule ComparisonBooleanExpression
ruleComparisonBooleanExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getComparisonBooleanExpressionAccess().getBooleanNegationExpressionParserRuleCall_0());
		}
		this_BooleanNegationExpression_0=ruleBooleanNegationExpression
		{
			$current = $this_BooleanNegationExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getComparisonBooleanExpressionAccess().getComparisonBooleanExpressionLeftAction_1_0(),
						$current);
				}
			)
			(
				(
					(
						lv_operator_2_1=LessThanSign
						{
							newLeafNode(lv_operator_2_1, grammarAccess.getComparisonBooleanExpressionAccess().getOperatorLessThanSignKeyword_1_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getComparisonBooleanExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_1, null);
						}
						    |
						lv_operator_2_2=LessThanSignEqualsSign
						{
							newLeafNode(lv_operator_2_2, grammarAccess.getComparisonBooleanExpressionAccess().getOperatorLessThanSignEqualsSignKeyword_1_1_0_1());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getComparisonBooleanExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_2, null);
						}
						    |
						lv_operator_2_3=EqualsSignEqualsSign
						{
							newLeafNode(lv_operator_2_3, grammarAccess.getComparisonBooleanExpressionAccess().getOperatorEqualsSignEqualsSignKeyword_1_1_0_2());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getComparisonBooleanExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_3, null);
						}
						    |
						lv_operator_2_4=GreaterThanSignEqualsSign
						{
							newLeafNode(lv_operator_2_4, grammarAccess.getComparisonBooleanExpressionAccess().getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_3());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getComparisonBooleanExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_4, null);
						}
						    |
						lv_operator_2_5=GreaterThanSign
						{
							newLeafNode(lv_operator_2_5, grammarAccess.getComparisonBooleanExpressionAccess().getOperatorGreaterThanSignKeyword_1_1_0_4());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getComparisonBooleanExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_5, null);
						}
						    |
						lv_operator_2_6=ExclamationMarkEqualsSign
						{
							newLeafNode(lv_operator_2_6, grammarAccess.getComparisonBooleanExpressionAccess().getOperatorExclamationMarkEqualsSignKeyword_1_1_0_5());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getComparisonBooleanExpressionRule());
							}
							setWithLastConsumed($current, "operator", lv_operator_2_6, null);
						}
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getComparisonBooleanExpressionAccess().getRightBooleanNegationExpressionParserRuleCall_1_2_0());
					}
					lv_right_3_0=ruleBooleanNegationExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getComparisonBooleanExpressionRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.safe4i.usf.transformation.language.USFLanguage.BooleanNegationExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleBooleanNegationExpression
entryRuleBooleanNegationExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBooleanNegationExpressionRule()); }
	iv_ruleBooleanNegationExpression=ruleBooleanNegationExpression
	{ $current=$iv_ruleBooleanNegationExpression.current; }
	EOF;

// Rule BooleanNegationExpression
ruleBooleanNegationExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getBooleanNegationExpressionAccess().getBooleanNegationExpressionAction_0(),
					$current);
			}
		)
		(
			((
				(
					ExclamationMark
				)
			)
			)=>
			(
				(
					lv_isNegate_1_0=ExclamationMark
					{
						newLeafNode(lv_isNegate_1_0, grammarAccess.getBooleanNegationExpressionAccess().getIsNegateExclamationMarkKeyword_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBooleanNegationExpressionRule());
						}
						setWithLastConsumed($current, "isNegate", lv_isNegate_1_0 != null, "!");
					}
				)
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getBooleanNegationExpressionAccess().getExpressionAtomicParserRuleCall_2_0());
				}
				lv_expression_2_0=ruleAtomic
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBooleanNegationExpressionRule());
					}
					set(
						$current,
						"expression",
						lv_expression_2_0,
						"org.safe4i.usf.transformation.language.USFLanguage.Atomic");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleAtomic
entryRuleAtomic returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAtomicRule()); }
	iv_ruleAtomic=ruleAtomic
	{ $current=$iv_ruleAtomic.current; }
	EOF;

// Rule Atomic
ruleAtomic returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0=LeftParenthesis
			{
				newLeafNode(otherlv_0, grammarAccess.getAtomicAccess().getLeftParenthesisKeyword_0_0());
			}
			{
				newCompositeNode(grammarAccess.getAtomicAccess().getExpressionParserRuleCall_0_1());
			}
			this_Expression_1=ruleExpression
			{
				$current = $this_Expression_1.current;
				afterParserOrEnumRuleCall();
			}
			otherlv_2=RightParenthesis
			{
				newLeafNode(otherlv_2, grammarAccess.getAtomicAccess().getRightParenthesisKeyword_0_2());
			}
		)
		    |
		{
			newCompositeNode(grammarAccess.getAtomicAccess().getStringLiteralParserRuleCall_1());
		}
		this_StringLiteral_3=ruleStringLiteral
		{
			$current = $this_StringLiteral_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getAtomicAccess().getBooleanLiteralParserRuleCall_2());
		}
		this_BooleanLiteral_4=ruleBooleanLiteral
		{
			$current = $this_BooleanLiteral_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getAtomicAccess().getNullLiteralParserRuleCall_3());
		}
		this_NullLiteral_5=ruleNullLiteral
		{
			$current = $this_NullLiteral_5.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getAtomicAccess().getPortDirectionLiteralParserRuleCall_4());
		}
		this_PortDirectionLiteral_6=rulePortDirectionLiteral
		{
			$current = $this_PortDirectionLiteral_6.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getAtomicAccess().getNumberLiteralParserRuleCall_5());
		}
		this_NumberLiteral_7=ruleNumberLiteral
		{
			$current = $this_NumberLiteral_7.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getAtomicAccess().getFeatureCallExpressionParserRuleCall_6());
		}
		this_FeatureCallExpression_8=ruleFeatureCallExpression
		{
			$current = $this_FeatureCallExpression_8.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getAtomicAccess().getTypedMemberCallExpressionParserRuleCall_7());
		}
		this_TypedMemberCallExpression_9=ruleTypedMemberCallExpression
		{
			$current = $this_TypedMemberCallExpression_9.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Rule TransformationTypes
ruleTransformationTypes returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0=Integer
			{
				$current = grammarAccess.getTransformationTypesAccess().getIntegerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getTransformationTypesAccess().getIntegerEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1=Float
			{
				$current = grammarAccess.getTransformationTypesAccess().getFloatEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getTransformationTypesAccess().getFloatEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2=String
			{
				$current = grammarAccess.getTransformationTypesAccess().getStringEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getTransformationTypesAccess().getStringEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3=Boolean
			{
				$current = grammarAccess.getTransformationTypesAccess().getBooleanEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getTransformationTypesAccess().getBooleanEnumLiteralDeclaration_3());
			}
		)
		    |
		(
			enumLiteral_4=Void
			{
				$current = grammarAccess.getTransformationTypesAccess().getVoidEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_4, grammarAccess.getTransformationTypesAccess().getVoidEnumLiteralDeclaration_4());
			}
		)
	)
;

// Rule PortDirection
rulePortDirection returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0=PortDirectionIN
			{
				$current = grammarAccess.getPortDirectionAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getPortDirectionAccess().getINEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1=PortDirectionOUT
			{
				$current = grammarAccess.getPortDirectionAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getPortDirectionAccess().getOUTEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2=PortDirectionINOUT
			{
				$current = grammarAccess.getPortDirectionAccess().getINOUTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getPortDirectionAccess().getINOUTEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3=PortDirectionUNSET
			{
				$current = grammarAccess.getPortDirectionAccess().getUNSETEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getPortDirectionAccess().getUNSETEnumLiteralDeclaration_3());
			}
		)
	)
;
