/*******************************************************************************
* Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
* This program and the accompanying materials are made available under the
* terms of the Eclipse Public License 2.0 which is available at
* http://www.eclipse.org/legal/epl-2.0.
* 
* SPDX-License-Identifier: EPL-2.0
*******************************************************************************/
package org.safe4i.usf.transformation.language.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class USFLanguageGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {
	
	public class TransformationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.Transformation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cTransformationAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cTransformKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final RuleCall cBEGINTerminalRuleCall_4 = (RuleCall)cGroup.eContents().get(4);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Assignment cParametersAssignment_5_0 = (Assignment)cGroup_5.eContents().get(0);
		private final RuleCall cParametersParameterParserRuleCall_5_0_0 = (RuleCall)cParametersAssignment_5_0.eContents().get(0);
		private final Group cGroup_5_1 = (Group)cGroup_5.eContents().get(1);
		private final Keyword cCommaKeyword_5_1_0 = (Keyword)cGroup_5_1.eContents().get(0);
		private final Assignment cParametersAssignment_5_1_1 = (Assignment)cGroup_5_1.eContents().get(1);
		private final RuleCall cParametersParameterParserRuleCall_5_1_1_0 = (RuleCall)cParametersAssignment_5_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cColonKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Assignment cTypeAssignment_7_1 = (Assignment)cGroup_7.eContents().get(1);
		private final RuleCall cTypeTransformationTypeParserRuleCall_7_1_0 = (RuleCall)cTypeAssignment_7_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final RuleCall cENDTerminalRuleCall_9 = (RuleCall)cGroup.eContents().get(9);
		private final Keyword cPRECONDITIONKeyword_10 = (Keyword)cGroup.eContents().get(10);
		private final RuleCall cBEGINTerminalRuleCall_11 = (RuleCall)cGroup.eContents().get(11);
		private final Assignment cPreconditionsAssignment_12 = (Assignment)cGroup.eContents().get(12);
		private final RuleCall cPreconditionsExpressionParserRuleCall_12_0 = (RuleCall)cPreconditionsAssignment_12.eContents().get(0);
		private final RuleCall cENDTerminalRuleCall_13 = (RuleCall)cGroup.eContents().get(13);
		private final Keyword cRULESKeyword_14 = (Keyword)cGroup.eContents().get(14);
		private final RuleCall cBEGINTerminalRuleCall_15 = (RuleCall)cGroup.eContents().get(15);
		private final Assignment cContentAssignment_16 = (Assignment)cGroup.eContents().get(16);
		private final RuleCall cContentExpressionParserRuleCall_16_0 = (RuleCall)cContentAssignment_16.eContents().get(0);
		private final RuleCall cENDTerminalRuleCall_17 = (RuleCall)cGroup.eContents().get(17);
		private final Group cGroup_18 = (Group)cGroup.eContents().get(18);
		private final Keyword cRETURNKeyword_18_0 = (Keyword)cGroup_18.eContents().get(0);
		private final RuleCall cBEGINTerminalRuleCall_18_1 = (RuleCall)cGroup_18.eContents().get(1);
		private final Assignment cOutputAssignment_18_2 = (Assignment)cGroup_18.eContents().get(2);
		private final RuleCall cOutputExpressionParserRuleCall_18_2_0 = (RuleCall)cOutputAssignment_18_2.eContents().get(0);
		private final RuleCall cENDTerminalRuleCall_18_3 = (RuleCall)cGroup_18.eContents().get(3);
		private final Keyword cRightCurlyBracketKeyword_19 = (Keyword)cGroup.eContents().get(19);
		
		//Transformation returns Transformation hidden(WS, ML_COMMENT, SL_COMMENT):
		//    {Transformation}
		//    'transform' name=ID '('
		//        BEGIN
		//        (parameters+=Parameter ("," parameters+=Parameter)*)?
		//     ')'
		//    (':' type=TransformationType)? "{"
		//    END
		//    'PRECONDITION'
		//    BEGIN
		//    (preconditions+=Expression)*
		//    END
		//    'RULES'
		//    BEGIN
		//    (content+=Expression)*
		//    END
		//    ('RETURN'
		//    BEGIN
		//    output=Expression
		//    END)?
		//    '}';
		@Override public ParserRule getRule() { return rule; }
		
		//{Transformation}
		//'transform' name=ID '('
		//    BEGIN
		//    (parameters+=Parameter ("," parameters+=Parameter)*)?
		// ')'
		//(':' type=TransformationType)? "{"
		//END
		//'PRECONDITION'
		//BEGIN
		//(preconditions+=Expression)*
		//END
		//'RULES'
		//BEGIN
		//(content+=Expression)*
		//END
		//('RETURN'
		//BEGIN
		//output=Expression
		//END)?
		//'}'
		public Group getGroup() { return cGroup; }
		
		//{Transformation}
		public Action getTransformationAction_0() { return cTransformationAction_0; }
		
		//'transform'
		public Keyword getTransformKeyword_1() { return cTransformKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_3() { return cLeftParenthesisKeyword_3; }
		
		//BEGIN
		public RuleCall getBEGINTerminalRuleCall_4() { return cBEGINTerminalRuleCall_4; }
		
		//(parameters+=Parameter ("," parameters+=Parameter)*)?
		public Group getGroup_5() { return cGroup_5; }
		
		//parameters+=Parameter
		public Assignment getParametersAssignment_5_0() { return cParametersAssignment_5_0; }
		
		//Parameter
		public RuleCall getParametersParameterParserRuleCall_5_0_0() { return cParametersParameterParserRuleCall_5_0_0; }
		
		//("," parameters+=Parameter)*
		public Group getGroup_5_1() { return cGroup_5_1; }
		
		//","
		public Keyword getCommaKeyword_5_1_0() { return cCommaKeyword_5_1_0; }
		
		//parameters+=Parameter
		public Assignment getParametersAssignment_5_1_1() { return cParametersAssignment_5_1_1; }
		
		//Parameter
		public RuleCall getParametersParameterParserRuleCall_5_1_1_0() { return cParametersParameterParserRuleCall_5_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_6() { return cRightParenthesisKeyword_6; }
		
		//(':' type=TransformationType)?
		public Group getGroup_7() { return cGroup_7; }
		
		//':'
		public Keyword getColonKeyword_7_0() { return cColonKeyword_7_0; }
		
		//type=TransformationType
		public Assignment getTypeAssignment_7_1() { return cTypeAssignment_7_1; }
		
		//TransformationType
		public RuleCall getTypeTransformationTypeParserRuleCall_7_1_0() { return cTypeTransformationTypeParserRuleCall_7_1_0; }
		
		//"{"
		public Keyword getLeftCurlyBracketKeyword_8() { return cLeftCurlyBracketKeyword_8; }
		
		//END
		public RuleCall getENDTerminalRuleCall_9() { return cENDTerminalRuleCall_9; }
		
		//'PRECONDITION'
		public Keyword getPRECONDITIONKeyword_10() { return cPRECONDITIONKeyword_10; }
		
		//BEGIN
		public RuleCall getBEGINTerminalRuleCall_11() { return cBEGINTerminalRuleCall_11; }
		
		//(preconditions+=Expression)*
		public Assignment getPreconditionsAssignment_12() { return cPreconditionsAssignment_12; }
		
		//Expression
		public RuleCall getPreconditionsExpressionParserRuleCall_12_0() { return cPreconditionsExpressionParserRuleCall_12_0; }
		
		//END
		public RuleCall getENDTerminalRuleCall_13() { return cENDTerminalRuleCall_13; }
		
		//'RULES'
		public Keyword getRULESKeyword_14() { return cRULESKeyword_14; }
		
		//BEGIN
		public RuleCall getBEGINTerminalRuleCall_15() { return cBEGINTerminalRuleCall_15; }
		
		//(content+=Expression)*
		public Assignment getContentAssignment_16() { return cContentAssignment_16; }
		
		//Expression
		public RuleCall getContentExpressionParserRuleCall_16_0() { return cContentExpressionParserRuleCall_16_0; }
		
		//END
		public RuleCall getENDTerminalRuleCall_17() { return cENDTerminalRuleCall_17; }
		
		//('RETURN'
		//BEGIN
		//output=Expression
		//END)?
		public Group getGroup_18() { return cGroup_18; }
		
		//'RETURN'
		public Keyword getRETURNKeyword_18_0() { return cRETURNKeyword_18_0; }
		
		//BEGIN
		public RuleCall getBEGINTerminalRuleCall_18_1() { return cBEGINTerminalRuleCall_18_1; }
		
		//output=Expression
		public Assignment getOutputAssignment_18_2() { return cOutputAssignment_18_2; }
		
		//Expression
		public RuleCall getOutputExpressionParserRuleCall_18_2_0() { return cOutputExpressionParserRuleCall_18_2_0; }
		
		//END
		public RuleCall getENDTerminalRuleCall_18_3() { return cENDTerminalRuleCall_18_3; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_19() { return cRightCurlyBracketKeyword_19; }
	}
	public class ExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.Expression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAssignmentOrVariableDeclarationParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cNullLiteralParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cBooleanLiteralParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cForLoopExpressionParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cIfExpressionParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cConcatenationExpressionParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		
		//Expression returns Expression:
		//    AssignmentOrVariableDeclaration |
		//    NullLiteral |
		//    BooleanLiteral | ForLoopExpression| IfExpression|
		//    ConcatenationExpression;
		@Override public ParserRule getRule() { return rule; }
		
		//AssignmentOrVariableDeclaration |
		//NullLiteral |
		//BooleanLiteral | ForLoopExpression| IfExpression|
		//ConcatenationExpression
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//AssignmentOrVariableDeclaration
		public RuleCall getAssignmentOrVariableDeclarationParserRuleCall_0() { return cAssignmentOrVariableDeclarationParserRuleCall_0; }
		
		//NullLiteral
		public RuleCall getNullLiteralParserRuleCall_1() { return cNullLiteralParserRuleCall_1; }
		
		//BooleanLiteral
		public RuleCall getBooleanLiteralParserRuleCall_2() { return cBooleanLiteralParserRuleCall_2; }
		
		//ForLoopExpression
		public RuleCall getForLoopExpressionParserRuleCall_3() { return cForLoopExpressionParserRuleCall_3; }
		
		//IfExpression
		public RuleCall getIfExpressionParserRuleCall_4() { return cIfExpressionParserRuleCall_4; }
		
		//ConcatenationExpression
		public RuleCall getConcatenationExpressionParserRuleCall_5() { return cConcatenationExpressionParserRuleCall_5; }
	}
	public class TransformationTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.TransformationType");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cTypeBasedTransformationTypeParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cEClassBasedTransformationTypeParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cListBasedTransformationTypeParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//TransformationType returns TransformationType:
		//    TypeBasedTransformationType | EClassBasedTransformationType | ListBasedTransformationType;
		@Override public ParserRule getRule() { return rule; }
		
		//TypeBasedTransformationType | EClassBasedTransformationType | ListBasedTransformationType
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//TypeBasedTransformationType
		public RuleCall getTypeBasedTransformationTypeParserRuleCall_0() { return cTypeBasedTransformationTypeParserRuleCall_0; }
		
		//EClassBasedTransformationType
		public RuleCall getEClassBasedTransformationTypeParserRuleCall_1() { return cEClassBasedTransformationTypeParserRuleCall_1; }
		
		//ListBasedTransformationType
		public RuleCall getListBasedTransformationTypeParserRuleCall_2() { return cListBasedTransformationTypeParserRuleCall_2; }
	}
	public class TypeBasedTransformationTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.TypeBasedTransformationType");
		private final Assignment cTypeAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cTypeTransformationTypesEnumRuleCall_0 = (RuleCall)cTypeAssignment.eContents().get(0);
		
		//TypeBasedTransformationType returns TypeBasedTransformationType:
		//    type=TransformationTypes;
		@Override public ParserRule getRule() { return rule; }
		
		//type=TransformationTypes
		public Assignment getTypeAssignment() { return cTypeAssignment; }
		
		//TransformationTypes
		public RuleCall getTypeTransformationTypesEnumRuleCall_0() { return cTypeTransformationTypesEnumRuleCall_0; }
	}
	public class EClassBasedTransformationTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.EClassBasedTransformationType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cEClassBasedTransformationTypeAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cTypeAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cTypeEClassCrossReference_1_0 = (CrossReference)cTypeAssignment_1.eContents().get(0);
		private final RuleCall cTypeEClassIDTerminalRuleCall_1_0_1 = (RuleCall)cTypeEClassCrossReference_1_0.eContents().get(1);
		
		//EClassBasedTransformationType returns EClassBasedTransformationType:
		//    {EClassBasedTransformationType}
		//    type=[ecore::EClass|ID];
		@Override public ParserRule getRule() { return rule; }
		
		//{EClassBasedTransformationType}
		//type=[ecore::EClass|ID]
		public Group getGroup() { return cGroup; }
		
		//{EClassBasedTransformationType}
		public Action getEClassBasedTransformationTypeAction_0() { return cEClassBasedTransformationTypeAction_0; }
		
		//type=[ecore::EClass|ID]
		public Assignment getTypeAssignment_1() { return cTypeAssignment_1; }
		
		//[ecore::EClass|ID]
		public CrossReference getTypeEClassCrossReference_1_0() { return cTypeEClassCrossReference_1_0; }
		
		//ID
		public RuleCall getTypeEClassIDTerminalRuleCall_1_0_1() { return cTypeEClassIDTerminalRuleCall_1_0_1; }
	}
	public class ListBasedTransformationTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.ListBasedTransformationType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cListBasedTransformationTypeAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cListKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLessThanSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cTypeEClassCrossReference_3_0 = (CrossReference)cTypeAssignment_3.eContents().get(0);
		private final RuleCall cTypeEClassIDTerminalRuleCall_3_0_1 = (RuleCall)cTypeEClassCrossReference_3_0.eContents().get(1);
		private final Keyword cGreaterThanSignKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//ListBasedTransformationType returns ListBasedTransformationType:
		//    {ListBasedTransformationType}
		//    'List' '<' type=[ecore::EClass|ID] '>';
		@Override public ParserRule getRule() { return rule; }
		
		//{ListBasedTransformationType}
		//'List' '<' type=[ecore::EClass|ID] '>'
		public Group getGroup() { return cGroup; }
		
		//{ListBasedTransformationType}
		public Action getListBasedTransformationTypeAction_0() { return cListBasedTransformationTypeAction_0; }
		
		//'List'
		public Keyword getListKeyword_1() { return cListKeyword_1; }
		
		//'<'
		public Keyword getLessThanSignKeyword_2() { return cLessThanSignKeyword_2; }
		
		//type=[ecore::EClass|ID]
		public Assignment getTypeAssignment_3() { return cTypeAssignment_3; }
		
		//[ecore::EClass|ID]
		public CrossReference getTypeEClassCrossReference_3_0() { return cTypeEClassCrossReference_3_0; }
		
		//ID
		public RuleCall getTypeEClassIDTerminalRuleCall_3_0_1() { return cTypeEClassIDTerminalRuleCall_3_0_1; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_4() { return cGreaterThanSignKeyword_4; }
	}
	public class ParameterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.Parameter");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cTypeBasedParameterParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cEClassBasedParameterParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cListBasedParameterParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//Parameter returns Parameter:
		//    TypeBasedParameter | EClassBasedParameter | ListBasedParameter;
		@Override public ParserRule getRule() { return rule; }
		
		//TypeBasedParameter | EClassBasedParameter | ListBasedParameter
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//TypeBasedParameter
		public RuleCall getTypeBasedParameterParserRuleCall_0() { return cTypeBasedParameterParserRuleCall_0; }
		
		//EClassBasedParameter
		public RuleCall getEClassBasedParameterParserRuleCall_1() { return cEClassBasedParameterParserRuleCall_1; }
		
		//ListBasedParameter
		public RuleCall getListBasedParameterParserRuleCall_2() { return cListBasedParameterParserRuleCall_2; }
	}
	public class TypeBasedParameterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.TypeBasedParameter");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cTypeBasedParameterAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cTypeTransformationTypesEnumRuleCall_3_0 = (RuleCall)cTypeAssignment_3.eContents().get(0);
		
		//TypeBasedParameter returns TypeBasedParameter:
		//    {TypeBasedParameter}
		//    name=ID ':' type=TransformationTypes;
		@Override public ParserRule getRule() { return rule; }
		
		//{TypeBasedParameter}
		//name=ID ':' type=TransformationTypes
		public Group getGroup() { return cGroup; }
		
		//{TypeBasedParameter}
		public Action getTypeBasedParameterAction_0() { return cTypeBasedParameterAction_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }
		
		//type=TransformationTypes
		public Assignment getTypeAssignment_3() { return cTypeAssignment_3; }
		
		//TransformationTypes
		public RuleCall getTypeTransformationTypesEnumRuleCall_3_0() { return cTypeTransformationTypesEnumRuleCall_3_0; }
	}
	public class EClassBasedParameterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.EClassBasedParameter");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cEClassBasedParameterAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cTypeEClassCrossReference_3_0 = (CrossReference)cTypeAssignment_3.eContents().get(0);
		private final RuleCall cTypeEClassIDTerminalRuleCall_3_0_1 = (RuleCall)cTypeEClassCrossReference_3_0.eContents().get(1);
		
		//EClassBasedParameter returns EClassBasedParameter:
		//    {EClassBasedParameter}
		//    name=ID ':' type=[ecore::EClass|ID];
		@Override public ParserRule getRule() { return rule; }
		
		//{EClassBasedParameter}
		//name=ID ':' type=[ecore::EClass|ID]
		public Group getGroup() { return cGroup; }
		
		//{EClassBasedParameter}
		public Action getEClassBasedParameterAction_0() { return cEClassBasedParameterAction_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }
		
		//type=[ecore::EClass|ID]
		public Assignment getTypeAssignment_3() { return cTypeAssignment_3; }
		
		//[ecore::EClass|ID]
		public CrossReference getTypeEClassCrossReference_3_0() { return cTypeEClassCrossReference_3_0; }
		
		//ID
		public RuleCall getTypeEClassIDTerminalRuleCall_3_0_1() { return cTypeEClassIDTerminalRuleCall_3_0_1; }
	}
	public class ListBasedParameterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.ListBasedParameter");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cListBasedParameterAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cListKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cLessThanSignKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cTypeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cTypeEClassCrossReference_5_0 = (CrossReference)cTypeAssignment_5.eContents().get(0);
		private final RuleCall cTypeEClassIDTerminalRuleCall_5_0_1 = (RuleCall)cTypeEClassCrossReference_5_0.eContents().get(1);
		private final Keyword cGreaterThanSignKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//ListBasedParameter returns ListBasedParameter:
		//    {ListBasedParameter}
		//    name=ID ':' 'List' '<' type=[ecore::EClass|ID] '>';
		@Override public ParserRule getRule() { return rule; }
		
		//{ListBasedParameter}
		//name=ID ':' 'List' '<' type=[ecore::EClass|ID] '>'
		public Group getGroup() { return cGroup; }
		
		//{ListBasedParameter}
		public Action getListBasedParameterAction_0() { return cListBasedParameterAction_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }
		
		//'List'
		public Keyword getListKeyword_3() { return cListKeyword_3; }
		
		//'<'
		public Keyword getLessThanSignKeyword_4() { return cLessThanSignKeyword_4; }
		
		//type=[ecore::EClass|ID]
		public Assignment getTypeAssignment_5() { return cTypeAssignment_5; }
		
		//[ecore::EClass|ID]
		public CrossReference getTypeEClassCrossReference_5_0() { return cTypeEClassCrossReference_5_0; }
		
		//ID
		public RuleCall getTypeEClassIDTerminalRuleCall_5_0_1() { return cTypeEClassIDTerminalRuleCall_5_0_1; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_6() { return cGreaterThanSignKeyword_6; }
	}
	public class ConcatenationExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.ConcatenationExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cPrimaryParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cConcatenationExpressionLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cPlusSignKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightPrimaryParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//ConcatenationExpression returns Expression:
		//    Primary ({ConcatenationExpression.left=current} '+' right=Primary)*;
		@Override public ParserRule getRule() { return rule; }
		
		//Primary ({ConcatenationExpression.left=current} '+' right=Primary)*
		public Group getGroup() { return cGroup; }
		
		//Primary
		public RuleCall getPrimaryParserRuleCall_0() { return cPrimaryParserRuleCall_0; }
		
		//({ConcatenationExpression.left=current} '+' right=Primary)*
		public Group getGroup_1() { return cGroup_1; }
		
		//{ConcatenationExpression.left=current}
		public Action getConcatenationExpressionLeftAction_1_0() { return cConcatenationExpressionLeftAction_1_0; }
		
		//'+'
		public Keyword getPlusSignKeyword_1_1() { return cPlusSignKeyword_1_1; }
		
		//right=Primary
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }
		
		//Primary
		public RuleCall getRightPrimaryParserRuleCall_1_2_0() { return cRightPrimaryParserRuleCall_1_2_0; }
	}
	public class PrimaryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.Primary");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cStringLiteralParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cNumberLiteralParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cTypedMemberCallExpressionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cFeatureCallExpressionParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cOperationCallExpressionParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cPortDirectionLiteralParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		
		//Primary returns Expression:
		//    StringLiteral |
		//    NumberLiteral |
		//    TypedMemberCallExpression |
		//    FeatureCallExpression |
		//    OperationCallExpression |
		//    PortDirectionLiteral
		//    ;
		@Override public ParserRule getRule() { return rule; }
		
		//StringLiteral |
		//NumberLiteral |
		//TypedMemberCallExpression |
		//FeatureCallExpression |
		//OperationCallExpression |
		//PortDirectionLiteral
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//StringLiteral
		public RuleCall getStringLiteralParserRuleCall_0() { return cStringLiteralParserRuleCall_0; }
		
		//NumberLiteral
		public RuleCall getNumberLiteralParserRuleCall_1() { return cNumberLiteralParserRuleCall_1; }
		
		//TypedMemberCallExpression
		public RuleCall getTypedMemberCallExpressionParserRuleCall_2() { return cTypedMemberCallExpressionParserRuleCall_2; }
		
		//FeatureCallExpression
		public RuleCall getFeatureCallExpressionParserRuleCall_3() { return cFeatureCallExpressionParserRuleCall_3; }
		
		//OperationCallExpression
		public RuleCall getOperationCallExpressionParserRuleCall_4() { return cOperationCallExpressionParserRuleCall_4; }
		
		//PortDirectionLiteral
		public RuleCall getPortDirectionLiteralParserRuleCall_5() { return cPortDirectionLiteralParserRuleCall_5; }
	}
	public class StringLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.StringLiteral");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//StringLiteral returns StringLiteral:
		//    value=STRING;
		@Override public ParserRule getRule() { return rule; }
		
		//value=STRING
		public Assignment getValueAssignment() { return cValueAssignment; }
		
		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_0() { return cValueSTRINGTerminalRuleCall_0; }
	}
	public class NumberLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.NumberLiteral");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueNumberParserRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//NumberLiteral returns NumberLiteral:
		//    value=Number;
		@Override public ParserRule getRule() { return rule; }
		
		//value=Number
		public Assignment getValueAssignment() { return cValueAssignment; }
		
		//Number
		public RuleCall getValueNumberParserRuleCall_0() { return cValueNumberParserRuleCall_0; }
	}
	public class NullLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.NullLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cNullLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cNullKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//NullLiteral returns NullLiteral:
		//    {NullLiteral} 'null';
		@Override public ParserRule getRule() { return rule; }
		
		//{NullLiteral} 'null'
		public Group getGroup() { return cGroup; }
		
		//{NullLiteral}
		public Action getNullLiteralAction_0() { return cNullLiteralAction_0; }
		
		//'null'
		public Keyword getNullKeyword_1() { return cNullKeyword_1; }
	}
	public class BooleanLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.BooleanLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cBooleanLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Keyword cFalseKeyword_1_0 = (Keyword)cAlternatives_1.eContents().get(0);
		private final Assignment cIsTrueAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final Keyword cIsTrueTrueKeyword_1_1_0 = (Keyword)cIsTrueAssignment_1_1.eContents().get(0);
		
		//BooleanLiteral returns BooleanLiteral:
		//    {BooleanLiteral} ('false' | isTrue?='true');
		@Override public ParserRule getRule() { return rule; }
		
		//{BooleanLiteral} ('false' | isTrue?='true')
		public Group getGroup() { return cGroup; }
		
		//{BooleanLiteral}
		public Action getBooleanLiteralAction_0() { return cBooleanLiteralAction_0; }
		
		//('false' | isTrue?='true')
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//'false'
		public Keyword getFalseKeyword_1_0() { return cFalseKeyword_1_0; }
		
		//isTrue?='true'
		public Assignment getIsTrueAssignment_1_1() { return cIsTrueAssignment_1_1; }
		
		//'true'
		public Keyword getIsTrueTrueKeyword_1_1_0() { return cIsTrueTrueKeyword_1_1_0; }
	}
	public class PortDirectionLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.PortDirectionLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cPortDirectionLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cDirectionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cDirectionPortDirectionEnumRuleCall_1_0 = (RuleCall)cDirectionAssignment_1.eContents().get(0);
		
		//PortDirectionLiteral returns PortDirectionLiteral:
		//    {PortDirectionLiteral} direction=PortDirection
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{PortDirectionLiteral} direction=PortDirection
		public Group getGroup() { return cGroup; }
		
		//{PortDirectionLiteral}
		public Action getPortDirectionLiteralAction_0() { return cPortDirectionLiteralAction_0; }
		
		//direction=PortDirection
		public Assignment getDirectionAssignment_1() { return cDirectionAssignment_1; }
		
		//PortDirection
		public RuleCall getDirectionPortDirectionEnumRuleCall_1_0() { return cDirectionPortDirectionEnumRuleCall_1_0; }
	}
	public class NumberElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.Number");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cINTTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//Number hidden():
		//    INT ('.' INT)?;
		@Override public ParserRule getRule() { return rule; }
		
		//INT ('.' INT)?
		public Group getGroup() { return cGroup; }
		
		//INT
		public RuleCall getINTTerminalRuleCall_0() { return cINTTerminalRuleCall_0; }
		
		//('.' INT)?
		public Group getGroup_1() { return cGroup_1; }
		
		//'.'
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }
		
		//INT
		public RuleCall getINTTerminalRuleCall_1_1() { return cINTTerminalRuleCall_1_1; }
	}
	public class FeatureCallExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.FeatureCallExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cContextAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cContextTypedMemberCrossReference_0_0 = (CrossReference)cContextAssignment_0.eContents().get(0);
		private final RuleCall cContextTypedMemberIDTerminalRuleCall_0_0_1 = (RuleCall)cContextTypedMemberCrossReference_0_0.eContents().get(1);
		private final Keyword cFullStopKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cStructuralFeatureAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cStructuralFeatureETypedElementCrossReference_2_0 = (CrossReference)cStructuralFeatureAssignment_2.eContents().get(0);
		private final RuleCall cStructuralFeatureETypedElementIDTerminalRuleCall_2_0_1 = (RuleCall)cStructuralFeatureETypedElementCrossReference_2_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cLeftParenthesisKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Assignment cParameterValuesAssignment_3_1_0 = (Assignment)cGroup_3_1.eContents().get(0);
		private final RuleCall cParameterValuesExpressionParserRuleCall_3_1_0_0 = (RuleCall)cParameterValuesAssignment_3_1_0.eContents().get(0);
		private final Group cGroup_3_1_1 = (Group)cGroup_3_1.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_1_0 = (Keyword)cGroup_3_1_1.eContents().get(0);
		private final Assignment cParameterValuesAssignment_3_1_1_1 = (Assignment)cGroup_3_1_1.eContents().get(1);
		private final RuleCall cParameterValuesExpressionParserRuleCall_3_1_1_1_0 = (RuleCall)cParameterValuesAssignment_3_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		
		//FeatureCallExpression returns FeatureCallExpression:
		//    context=[TypedMember] '.'+ structuralFeature=[ecore::ETypedElement|ID] ('(' (parameterValues+=Expression (","
		//    parameterValues+=Expression)*)?')')?;
		@Override public ParserRule getRule() { return rule; }
		
		//context=[TypedMember] '.'+ structuralFeature=[ecore::ETypedElement|ID] ('(' (parameterValues+=Expression (","
		//parameterValues+=Expression)*)?')')?
		public Group getGroup() { return cGroup; }
		
		//context=[TypedMember]
		public Assignment getContextAssignment_0() { return cContextAssignment_0; }
		
		//[TypedMember]
		public CrossReference getContextTypedMemberCrossReference_0_0() { return cContextTypedMemberCrossReference_0_0; }
		
		//ID
		public RuleCall getContextTypedMemberIDTerminalRuleCall_0_0_1() { return cContextTypedMemberIDTerminalRuleCall_0_0_1; }
		
		//'.'+
		public Keyword getFullStopKeyword_1() { return cFullStopKeyword_1; }
		
		//structuralFeature=[ecore::ETypedElement|ID]
		public Assignment getStructuralFeatureAssignment_2() { return cStructuralFeatureAssignment_2; }
		
		//[ecore::ETypedElement|ID]
		public CrossReference getStructuralFeatureETypedElementCrossReference_2_0() { return cStructuralFeatureETypedElementCrossReference_2_0; }
		
		//ID
		public RuleCall getStructuralFeatureETypedElementIDTerminalRuleCall_2_0_1() { return cStructuralFeatureETypedElementIDTerminalRuleCall_2_0_1; }
		
		//('(' (parameterValues+=Expression (","
		//   parameterValues+=Expression)*)?')')?
		public Group getGroup_3() { return cGroup_3; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_3_0() { return cLeftParenthesisKeyword_3_0; }
		
		//(parameterValues+=Expression (","
		//   parameterValues+=Expression)*)?
		public Group getGroup_3_1() { return cGroup_3_1; }
		
		//parameterValues+=Expression
		public Assignment getParameterValuesAssignment_3_1_0() { return cParameterValuesAssignment_3_1_0; }
		
		//Expression
		public RuleCall getParameterValuesExpressionParserRuleCall_3_1_0_0() { return cParameterValuesExpressionParserRuleCall_3_1_0_0; }
		
		//(","
		//   parameterValues+=Expression)*
		public Group getGroup_3_1_1() { return cGroup_3_1_1; }
		
		//","
		public Keyword getCommaKeyword_3_1_1_0() { return cCommaKeyword_3_1_1_0; }
		
		//parameterValues+=Expression
		public Assignment getParameterValuesAssignment_3_1_1_1() { return cParameterValuesAssignment_3_1_1_1; }
		
		//Expression
		public RuleCall getParameterValuesExpressionParserRuleCall_3_1_1_1_0() { return cParameterValuesExpressionParserRuleCall_3_1_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_3_2() { return cRightParenthesisKeyword_3_2; }
	}
	public class OperationCallExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.OperationCallExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cOperationCallExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cOperationAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cOperationEOperationCrossReference_1_0 = (CrossReference)cOperationAssignment_1.eContents().get(0);
		private final RuleCall cOperationEOperationIDTerminalRuleCall_1_0_1 = (RuleCall)cOperationEOperationCrossReference_1_0.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cParameterValuesAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cParameterValuesExpressionParserRuleCall_3_0_0 = (RuleCall)cParameterValuesAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cParameterValuesAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cParameterValuesExpressionParserRuleCall_3_1_1_0 = (RuleCall)cParameterValuesAssignment_3_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//OperationCallExpression returns OperationCallExpression:
		//    {OperationCallExpression}
		//    operation=[ecore::EOperation|ID] '(' (parameterValues+=Expression ("," parameterValues+=Expression)*)?
		//    ')';
		@Override public ParserRule getRule() { return rule; }
		
		//{OperationCallExpression}
		//operation=[ecore::EOperation|ID] '(' (parameterValues+=Expression ("," parameterValues+=Expression)*)?
		//')'
		public Group getGroup() { return cGroup; }
		
		//{OperationCallExpression}
		public Action getOperationCallExpressionAction_0() { return cOperationCallExpressionAction_0; }
		
		//operation=[ecore::EOperation|ID]
		public Assignment getOperationAssignment_1() { return cOperationAssignment_1; }
		
		//[ecore::EOperation|ID]
		public CrossReference getOperationEOperationCrossReference_1_0() { return cOperationEOperationCrossReference_1_0; }
		
		//ID
		public RuleCall getOperationEOperationIDTerminalRuleCall_1_0_1() { return cOperationEOperationIDTerminalRuleCall_1_0_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//(parameterValues+=Expression ("," parameterValues+=Expression)*)?
		public Group getGroup_3() { return cGroup_3; }
		
		//parameterValues+=Expression
		public Assignment getParameterValuesAssignment_3_0() { return cParameterValuesAssignment_3_0; }
		
		//Expression
		public RuleCall getParameterValuesExpressionParserRuleCall_3_0_0() { return cParameterValuesExpressionParserRuleCall_3_0_0; }
		
		//("," parameterValues+=Expression)*
		public Group getGroup_3_1() { return cGroup_3_1; }
		
		//","
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }
		
		//parameterValues+=Expression
		public Assignment getParameterValuesAssignment_3_1_1() { return cParameterValuesAssignment_3_1_1; }
		
		//Expression
		public RuleCall getParameterValuesExpressionParserRuleCall_3_1_1_0() { return cParameterValuesExpressionParserRuleCall_3_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
	}
	public class AssignmentOrVariableDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.AssignmentOrVariableDeclaration");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cVariableDeclarationParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cAssignmentExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//AssignmentOrVariableDeclaration returns Expression:
		//    VariableDeclaration | AssignmentExpression
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//VariableDeclaration | AssignmentExpression
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//VariableDeclaration
		public RuleCall getVariableDeclarationParserRuleCall_0() { return cVariableDeclarationParserRuleCall_0; }
		
		//AssignmentExpression
		public RuleCall getAssignmentExpressionParserRuleCall_1() { return cAssignmentExpressionParserRuleCall_1; }
	}
	public class VariableDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.VariableDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cVariableDeclarationAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cWriteableAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final Keyword cWriteableVarKeyword_1_0_0 = (Keyword)cWriteableAssignment_1_0.eContents().get(0);
		private final Keyword cValKeyword_1_1 = (Keyword)cAlternatives_1.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Group cGroup_2_0_0 = (Group)cGroup_2_0.eContents().get(0);
		private final Assignment cTypeAssignment_2_0_0_0 = (Assignment)cGroup_2_0_0.eContents().get(0);
		private final RuleCall cTypeTransformationTypeParserRuleCall_2_0_0_0_0 = (RuleCall)cTypeAssignment_2_0_0_0.eContents().get(0);
		private final Assignment cNameAssignment_2_0_0_1 = (Assignment)cGroup_2_0_0.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_2_0_0_1_0 = (RuleCall)cNameAssignment_2_0_0_1.eContents().get(0);
		private final Assignment cNameAssignment_2_1 = (Assignment)cAlternatives_2.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_2_1_0 = (RuleCall)cNameAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cEqualsSignKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cRhsAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cRhsExpressionParserRuleCall_3_1_0 = (RuleCall)cRhsAssignment_3_1.eContents().get(0);
		
		//VariableDeclaration returns VariableDeclaration:
		//    {VariableDeclaration}
		//    (writeable?='var'|'val') (=>(type=TransformationType name=ID) | name=ID) ('=' rhs=Expression)?;
		@Override public ParserRule getRule() { return rule; }
		
		//{VariableDeclaration}
		//(writeable?='var'|'val') (=>(type=TransformationType name=ID) | name=ID) ('=' rhs=Expression)?
		public Group getGroup() { return cGroup; }
		
		//{VariableDeclaration}
		public Action getVariableDeclarationAction_0() { return cVariableDeclarationAction_0; }
		
		//(writeable?='var'|'val')
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//writeable?='var'
		public Assignment getWriteableAssignment_1_0() { return cWriteableAssignment_1_0; }
		
		//'var'
		public Keyword getWriteableVarKeyword_1_0_0() { return cWriteableVarKeyword_1_0_0; }
		
		//'val'
		public Keyword getValKeyword_1_1() { return cValKeyword_1_1; }
		
		//(=>(type=TransformationType name=ID) | name=ID)
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//=>(type=TransformationType name=ID)
		public Group getGroup_2_0() { return cGroup_2_0; }
		
		//type=TransformationType name=ID
		public Group getGroup_2_0_0() { return cGroup_2_0_0; }
		
		//type=TransformationType
		public Assignment getTypeAssignment_2_0_0_0() { return cTypeAssignment_2_0_0_0; }
		
		//TransformationType
		public RuleCall getTypeTransformationTypeParserRuleCall_2_0_0_0_0() { return cTypeTransformationTypeParserRuleCall_2_0_0_0_0; }
		
		//name=ID
		public Assignment getNameAssignment_2_0_0_1() { return cNameAssignment_2_0_0_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0_0_1_0() { return cNameIDTerminalRuleCall_2_0_0_1_0; }
		
		//name=ID
		public Assignment getNameAssignment_2_1() { return cNameAssignment_2_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_1_0() { return cNameIDTerminalRuleCall_2_1_0; }
		
		//('=' rhs=Expression)?
		public Group getGroup_3() { return cGroup_3; }
		
		//'='
		public Keyword getEqualsSignKeyword_3_0() { return cEqualsSignKeyword_3_0; }
		
		//rhs=Expression
		public Assignment getRhsAssignment_3_1() { return cRhsAssignment_3_1; }
		
		//Expression
		public RuleCall getRhsExpressionParserRuleCall_3_1_0() { return cRhsExpressionParserRuleCall_3_1_0; }
	}
	public class AssignmentExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.AssignmentExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAssignmentExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cTypeMemberAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cTypeMemberVariableDeclarationCrossReference_1_0 = (CrossReference)cTypeMemberAssignment_1.eContents().get(0);
		private final RuleCall cTypeMemberVariableDeclarationIDTerminalRuleCall_1_0_1 = (RuleCall)cTypeMemberVariableDeclarationCrossReference_1_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cValueExpressionParserRuleCall_3_0 = (RuleCall)cValueAssignment_3.eContents().get(0);
		
		//AssignmentExpression returns AssignmentExpression:
		//    {AssignmentExpression} typeMember=[VariableDeclaration]  '=' value=Expression
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{AssignmentExpression} typeMember=[VariableDeclaration]  '=' value=Expression
		public Group getGroup() { return cGroup; }
		
		//{AssignmentExpression}
		public Action getAssignmentExpressionAction_0() { return cAssignmentExpressionAction_0; }
		
		//typeMember=[VariableDeclaration]
		public Assignment getTypeMemberAssignment_1() { return cTypeMemberAssignment_1; }
		
		//[VariableDeclaration]
		public CrossReference getTypeMemberVariableDeclarationCrossReference_1_0() { return cTypeMemberVariableDeclarationCrossReference_1_0; }
		
		//ID
		public RuleCall getTypeMemberVariableDeclarationIDTerminalRuleCall_1_0_1() { return cTypeMemberVariableDeclarationIDTerminalRuleCall_1_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }
		
		//value=Expression
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }
		
		//Expression
		public RuleCall getValueExpressionParserRuleCall_3_0() { return cValueExpressionParserRuleCall_3_0; }
	}
	public class TypedMemberCallExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.TypedMemberCallExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cTypedMemberCallExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cTypeMemberAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cTypeMemberTypedMemberCrossReference_1_0 = (CrossReference)cTypeMemberAssignment_1.eContents().get(0);
		private final RuleCall cTypeMemberTypedMemberIDTerminalRuleCall_1_0_1 = (RuleCall)cTypeMemberTypedMemberCrossReference_1_0.eContents().get(1);
		
		//TypedMemberCallExpression returns TypedMemberCallExpression:
		//    {TypedMemberCallExpression}
		//    typeMember=[TypedMember];
		@Override public ParserRule getRule() { return rule; }
		
		//{TypedMemberCallExpression}
		//typeMember=[TypedMember]
		public Group getGroup() { return cGroup; }
		
		//{TypedMemberCallExpression}
		public Action getTypedMemberCallExpressionAction_0() { return cTypedMemberCallExpressionAction_0; }
		
		//typeMember=[TypedMember]
		public Assignment getTypeMemberAssignment_1() { return cTypeMemberAssignment_1; }
		
		//[TypedMember]
		public CrossReference getTypeMemberTypedMemberCrossReference_1_0() { return cTypeMemberTypedMemberCrossReference_1_0; }
		
		//ID
		public RuleCall getTypeMemberTypedMemberIDTerminalRuleCall_1_0_1() { return cTypeMemberTypedMemberIDTerminalRuleCall_1_0_1; }
	}
	public class ForLoopExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.ForLoopExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cGroup_0.eContents().get(0);
		private final Action cForLoopExpressionAction_0_0_0 = (Action)cGroup_0_0.eContents().get(0);
		private final Keyword cForKeyword_0_0_1 = (Keyword)cGroup_0_0.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0_0_2 = (Keyword)cGroup_0_0.eContents().get(2);
		private final Assignment cDeclaredParamAssignment_0_0_3 = (Assignment)cGroup_0_0.eContents().get(3);
		private final RuleCall cDeclaredParamParameterParserRuleCall_0_0_3_0 = (RuleCall)cDeclaredParamAssignment_0_0_3.eContents().get(0);
		private final Keyword cInKeyword_0_0_4 = (Keyword)cGroup_0_0.eContents().get(4);
		private final Assignment cForExpressionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cForExpressionExpressionParserRuleCall_1_0 = (RuleCall)cForExpressionAssignment_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final RuleCall cBEGINTerminalRuleCall_4_0 = (RuleCall)cGroup_4.eContents().get(0);
		private final Assignment cEachExpressionAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cEachExpressionExpressionParserRuleCall_4_1_0 = (RuleCall)cEachExpressionAssignment_4_1.eContents().get(0);
		private final RuleCall cENDTerminalRuleCall_4_2 = (RuleCall)cGroup_4.eContents().get(2);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//ForLoopExpression returns ForLoopExpression:
		//    =>({ForLoopExpression}
		//    'for' '(' declaredParam=Parameter 'in'  ) forExpression=Expression ')' '{'
		//            (BEGIN
		//            (eachExpression+=Expression)*
		//            END)?  '}'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//=>({ForLoopExpression}
		//'for' '(' declaredParam=Parameter 'in'  ) forExpression=Expression ')' '{'
		//        (BEGIN
		//        (eachExpression+=Expression)*
		//        END)?  '}'
		public Group getGroup() { return cGroup; }
		
		//=>({ForLoopExpression}
		//'for' '(' declaredParam=Parameter 'in'  )
		public Group getGroup_0() { return cGroup_0; }
		
		//{ForLoopExpression}
		//    'for' '(' declaredParam=Parameter 'in'
		public Group getGroup_0_0() { return cGroup_0_0; }
		
		//{ForLoopExpression}
		public Action getForLoopExpressionAction_0_0_0() { return cForLoopExpressionAction_0_0_0; }
		
		//'for'
		public Keyword getForKeyword_0_0_1() { return cForKeyword_0_0_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_0_0_2() { return cLeftParenthesisKeyword_0_0_2; }
		
		//declaredParam=Parameter
		public Assignment getDeclaredParamAssignment_0_0_3() { return cDeclaredParamAssignment_0_0_3; }
		
		//Parameter
		public RuleCall getDeclaredParamParameterParserRuleCall_0_0_3_0() { return cDeclaredParamParameterParserRuleCall_0_0_3_0; }
		
		//'in'
		public Keyword getInKeyword_0_0_4() { return cInKeyword_0_0_4; }
		
		//forExpression=Expression
		public Assignment getForExpressionAssignment_1() { return cForExpressionAssignment_1; }
		
		//Expression
		public RuleCall getForExpressionExpressionParserRuleCall_1_0() { return cForExpressionExpressionParserRuleCall_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2() { return cRightParenthesisKeyword_2; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//(BEGIN
		//(eachExpression+=Expression)*
		//END)?
		public Group getGroup_4() { return cGroup_4; }
		
		//BEGIN
		public RuleCall getBEGINTerminalRuleCall_4_0() { return cBEGINTerminalRuleCall_4_0; }
		
		//(eachExpression+=Expression)*
		public Assignment getEachExpressionAssignment_4_1() { return cEachExpressionAssignment_4_1; }
		
		//Expression
		public RuleCall getEachExpressionExpressionParserRuleCall_4_1_0() { return cEachExpressionExpressionParserRuleCall_4_1_0; }
		
		//END
		public RuleCall getENDTerminalRuleCall_4_2() { return cENDTerminalRuleCall_4_2; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}
	public class IfExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.IfExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cIFExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cIfKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cConditionAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cConditionBooleanExpressionParserRuleCall_3_0 = (RuleCall)cConditionAssignment_3.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cLeftCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final RuleCall cBEGINTerminalRuleCall_6_0 = (RuleCall)cGroup_6.eContents().get(0);
		private final Assignment cThenAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cThenExpressionParserRuleCall_6_1_0 = (RuleCall)cThenAssignment_6_1.eContents().get(0);
		private final RuleCall cENDTerminalRuleCall_6_2 = (RuleCall)cGroup_6.eContents().get(2);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cElseKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_8_1 = (Keyword)cGroup_8.eContents().get(1);
		private final Group cGroup_8_2 = (Group)cGroup_8.eContents().get(2);
		private final RuleCall cBEGINTerminalRuleCall_8_2_0 = (RuleCall)cGroup_8_2.eContents().get(0);
		private final Assignment cElseAssignment_8_2_1 = (Assignment)cGroup_8_2.eContents().get(1);
		private final RuleCall cElseExpressionParserRuleCall_8_2_1_0 = (RuleCall)cElseAssignment_8_2_1.eContents().get(0);
		private final RuleCall cENDTerminalRuleCall_8_2_2 = (RuleCall)cGroup_8_2.eContents().get(2);
		private final Keyword cRightCurlyBracketKeyword_8_3 = (Keyword)cGroup_8.eContents().get(3);
		
		//IfExpression returns IFExpression:
		//    {IFExpression}
		//    'if' '(' condition=BooleanExpression ')'  '{'
		//            (BEGIN
		//            (then+=Expression)*
		//            END )?
		//            '}'
		//    (=>'else' '{'
		//        (BEGIN
		//            (else+=Expression)*
		//        END )?
		//        '}'
		//    )?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{IFExpression}
		//'if' '(' condition=BooleanExpression ')'  '{'
		//        (BEGIN
		//        (then+=Expression)*
		//        END )?
		//        '}'
		//(=>'else' '{'
		//    (BEGIN
		//        (else+=Expression)*
		//    END )?
		//    '}'
		//)?
		public Group getGroup() { return cGroup; }
		
		//{IFExpression}
		public Action getIFExpressionAction_0() { return cIFExpressionAction_0; }
		
		//'if'
		public Keyword getIfKeyword_1() { return cIfKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//condition=BooleanExpression
		public Assignment getConditionAssignment_3() { return cConditionAssignment_3; }
		
		//BooleanExpression
		public RuleCall getConditionBooleanExpressionParserRuleCall_3_0() { return cConditionBooleanExpressionParserRuleCall_3_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_5() { return cLeftCurlyBracketKeyword_5; }
		
		//(BEGIN
		//(then+=Expression)*
		//END )?
		public Group getGroup_6() { return cGroup_6; }
		
		//BEGIN
		public RuleCall getBEGINTerminalRuleCall_6_0() { return cBEGINTerminalRuleCall_6_0; }
		
		//(then+=Expression)*
		public Assignment getThenAssignment_6_1() { return cThenAssignment_6_1; }
		
		//Expression
		public RuleCall getThenExpressionParserRuleCall_6_1_0() { return cThenExpressionParserRuleCall_6_1_0; }
		
		//END
		public RuleCall getENDTerminalRuleCall_6_2() { return cENDTerminalRuleCall_6_2; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
		
		//(=>'else' '{'
		//    (BEGIN
		//        (else+=Expression)*
		//    END )?
		//    '}'
		//)?
		public Group getGroup_8() { return cGroup_8; }
		
		//=>'else'
		public Keyword getElseKeyword_8_0() { return cElseKeyword_8_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_8_1() { return cLeftCurlyBracketKeyword_8_1; }
		
		//(BEGIN
		//    (else+=Expression)*
		//END )?
		public Group getGroup_8_2() { return cGroup_8_2; }
		
		//BEGIN
		public RuleCall getBEGINTerminalRuleCall_8_2_0() { return cBEGINTerminalRuleCall_8_2_0; }
		
		//(else+=Expression)*
		public Assignment getElseAssignment_8_2_1() { return cElseAssignment_8_2_1; }
		
		//Expression
		public RuleCall getElseExpressionParserRuleCall_8_2_1_0() { return cElseExpressionParserRuleCall_8_2_1_0; }
		
		//END
		public RuleCall getENDTerminalRuleCall_8_2_2() { return cENDTerminalRuleCall_8_2_2; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_8_3() { return cRightCurlyBracketKeyword_8_3; }
	}
	public class BooleanExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.BooleanExpression");
		private final RuleCall cOrBooleanExpressionParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//BooleanExpression returns Expression:
		//    OrBooleanExpression
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//OrBooleanExpression
		public RuleCall getOrBooleanExpressionParserRuleCall() { return cOrBooleanExpressionParserRuleCall; }
	}
	public class OrBooleanExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.OrBooleanExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAndBooleanExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Action cOrBooleanExpressionLeftAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final Keyword cVerticalLineVerticalLineKeyword_1_0_1 = (Keyword)cGroup_1_0.eContents().get(1);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightAndBooleanExpressionParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//OrBooleanExpression returns Expression:
		//    AndBooleanExpression (({OrBooleanExpression.left=current} "||") right=AndBooleanExpression)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//AndBooleanExpression (({OrBooleanExpression.left=current} "||") right=AndBooleanExpression)*
		public Group getGroup() { return cGroup; }
		
		//AndBooleanExpression
		public RuleCall getAndBooleanExpressionParserRuleCall_0() { return cAndBooleanExpressionParserRuleCall_0; }
		
		//(({OrBooleanExpression.left=current} "||") right=AndBooleanExpression)*
		public Group getGroup_1() { return cGroup_1; }
		
		//({OrBooleanExpression.left=current} "||")
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{OrBooleanExpression.left=current}
		public Action getOrBooleanExpressionLeftAction_1_0_0() { return cOrBooleanExpressionLeftAction_1_0_0; }
		
		//"||"
		public Keyword getVerticalLineVerticalLineKeyword_1_0_1() { return cVerticalLineVerticalLineKeyword_1_0_1; }
		
		//right=AndBooleanExpression
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }
		
		//AndBooleanExpression
		public RuleCall getRightAndBooleanExpressionParserRuleCall_1_1_0() { return cRightAndBooleanExpressionParserRuleCall_1_1_0; }
	}
	public class AndBooleanExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.AndBooleanExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cComparisonBooleanExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Action cAndBooleanExpressionLeftAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final Keyword cAmpersandAmpersandKeyword_1_0_1 = (Keyword)cGroup_1_0.eContents().get(1);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightComparisonBooleanExpressionParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//AndBooleanExpression returns Expression:
		//    ComparisonBooleanExpression (({AndBooleanExpression.left=current} "&&") right=ComparisonBooleanExpression)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//ComparisonBooleanExpression (({AndBooleanExpression.left=current} "&&") right=ComparisonBooleanExpression)*
		public Group getGroup() { return cGroup; }
		
		//ComparisonBooleanExpression
		public RuleCall getComparisonBooleanExpressionParserRuleCall_0() { return cComparisonBooleanExpressionParserRuleCall_0; }
		
		//(({AndBooleanExpression.left=current} "&&") right=ComparisonBooleanExpression)*
		public Group getGroup_1() { return cGroup_1; }
		
		//({AndBooleanExpression.left=current} "&&")
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{AndBooleanExpression.left=current}
		public Action getAndBooleanExpressionLeftAction_1_0_0() { return cAndBooleanExpressionLeftAction_1_0_0; }
		
		//"&&"
		public Keyword getAmpersandAmpersandKeyword_1_0_1() { return cAmpersandAmpersandKeyword_1_0_1; }
		
		//right=ComparisonBooleanExpression
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }
		
		//ComparisonBooleanExpression
		public RuleCall getRightComparisonBooleanExpressionParserRuleCall_1_1_0() { return cRightComparisonBooleanExpressionParserRuleCall_1_1_0; }
	}
	public class ComparisonBooleanExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.ComparisonBooleanExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cBooleanNegationExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cComparisonBooleanExpressionLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOperatorAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Alternatives cOperatorAlternatives_1_1_0 = (Alternatives)cOperatorAssignment_1_1.eContents().get(0);
		private final Keyword cOperatorLessThanSignKeyword_1_1_0_0 = (Keyword)cOperatorAlternatives_1_1_0.eContents().get(0);
		private final Keyword cOperatorLessThanSignEqualsSignKeyword_1_1_0_1 = (Keyword)cOperatorAlternatives_1_1_0.eContents().get(1);
		private final Keyword cOperatorEqualsSignEqualsSignKeyword_1_1_0_2 = (Keyword)cOperatorAlternatives_1_1_0.eContents().get(2);
		private final Keyword cOperatorGreaterThanSignEqualsSignKeyword_1_1_0_3 = (Keyword)cOperatorAlternatives_1_1_0.eContents().get(3);
		private final Keyword cOperatorGreaterThanSignKeyword_1_1_0_4 = (Keyword)cOperatorAlternatives_1_1_0.eContents().get(4);
		private final Keyword cOperatorExclamationMarkEqualsSignKeyword_1_1_0_5 = (Keyword)cOperatorAlternatives_1_1_0.eContents().get(5);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightBooleanNegationExpressionParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//ComparisonBooleanExpression returns Expression:
		//    BooleanNegationExpression ({ComparisonBooleanExpression.left=current} operator=("<"|"<="|"=="|">="|">"|"!=") right=BooleanNegationExpression)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//BooleanNegationExpression ({ComparisonBooleanExpression.left=current} operator=("<"|"<="|"=="|">="|">"|"!=") right=BooleanNegationExpression)*
		public Group getGroup() { return cGroup; }
		
		//BooleanNegationExpression
		public RuleCall getBooleanNegationExpressionParserRuleCall_0() { return cBooleanNegationExpressionParserRuleCall_0; }
		
		//({ComparisonBooleanExpression.left=current} operator=("<"|"<="|"=="|">="|">"|"!=") right=BooleanNegationExpression)*
		public Group getGroup_1() { return cGroup_1; }
		
		//{ComparisonBooleanExpression.left=current}
		public Action getComparisonBooleanExpressionLeftAction_1_0() { return cComparisonBooleanExpressionLeftAction_1_0; }
		
		//operator=("<"|"<="|"=="|">="|">"|"!=")
		public Assignment getOperatorAssignment_1_1() { return cOperatorAssignment_1_1; }
		
		//("<"|"<="|"=="|">="|">"|"!=")
		public Alternatives getOperatorAlternatives_1_1_0() { return cOperatorAlternatives_1_1_0; }
		
		//"<"
		public Keyword getOperatorLessThanSignKeyword_1_1_0_0() { return cOperatorLessThanSignKeyword_1_1_0_0; }
		
		//"<="
		public Keyword getOperatorLessThanSignEqualsSignKeyword_1_1_0_1() { return cOperatorLessThanSignEqualsSignKeyword_1_1_0_1; }
		
		//"=="
		public Keyword getOperatorEqualsSignEqualsSignKeyword_1_1_0_2() { return cOperatorEqualsSignEqualsSignKeyword_1_1_0_2; }
		
		//">="
		public Keyword getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_3() { return cOperatorGreaterThanSignEqualsSignKeyword_1_1_0_3; }
		
		//">"
		public Keyword getOperatorGreaterThanSignKeyword_1_1_0_4() { return cOperatorGreaterThanSignKeyword_1_1_0_4; }
		
		//"!="
		public Keyword getOperatorExclamationMarkEqualsSignKeyword_1_1_0_5() { return cOperatorExclamationMarkEqualsSignKeyword_1_1_0_5; }
		
		//right=BooleanNegationExpression
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }
		
		//BooleanNegationExpression
		public RuleCall getRightBooleanNegationExpressionParserRuleCall_1_2_0() { return cRightBooleanNegationExpressionParserRuleCall_1_2_0; }
	}
	public class BooleanNegationExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.BooleanNegationExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cBooleanNegationExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cIsNegateAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final Keyword cIsNegateExclamationMarkKeyword_1_0_0 = (Keyword)cIsNegateAssignment_1_0.eContents().get(0);
		private final Assignment cExpressionAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cExpressionAtomicParserRuleCall_2_0 = (RuleCall)cExpressionAssignment_2.eContents().get(0);
		
		//BooleanNegationExpression returns Expression:
		//  {BooleanNegationExpression} => (isNegate?='!')?  expression=Atomic
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{BooleanNegationExpression} => (isNegate?='!')?  expression=Atomic
		public Group getGroup() { return cGroup; }
		
		//{BooleanNegationExpression}
		public Action getBooleanNegationExpressionAction_0() { return cBooleanNegationExpressionAction_0; }
		
		//=> (isNegate?='!')?
		public Group getGroup_1() { return cGroup_1; }
		
		//isNegate?='!'
		public Assignment getIsNegateAssignment_1_0() { return cIsNegateAssignment_1_0; }
		
		//'!'
		public Keyword getIsNegateExclamationMarkKeyword_1_0_0() { return cIsNegateExclamationMarkKeyword_1_0_0; }
		
		//expression=Atomic
		public Assignment getExpressionAssignment_2() { return cExpressionAssignment_2; }
		
		//Atomic
		public RuleCall getExpressionAtomicParserRuleCall_2_0() { return cExpressionAtomicParserRuleCall_2_0; }
	}
	public class AtomicElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.Atomic");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final RuleCall cExpressionParserRuleCall_0_1 = (RuleCall)cGroup_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final RuleCall cStringLiteralParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cBooleanLiteralParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cNullLiteralParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cPortDirectionLiteralParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cNumberLiteralParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cFeatureCallExpressionParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cTypedMemberCallExpressionParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		
		//Atomic returns Expression:
		//    '(' Expression ')' |
		//    StringLiteral | BooleanLiteral| NullLiteral| PortDirectionLiteral |
		//    NumberLiteral |FeatureCallExpression | TypedMemberCallExpression
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'(' Expression ')' |
		//StringLiteral | BooleanLiteral| NullLiteral| PortDirectionLiteral |
		//NumberLiteral |FeatureCallExpression | TypedMemberCallExpression
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'(' Expression ')'
		public Group getGroup_0() { return cGroup_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_0_0() { return cLeftParenthesisKeyword_0_0; }
		
		//Expression
		public RuleCall getExpressionParserRuleCall_0_1() { return cExpressionParserRuleCall_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_0_2() { return cRightParenthesisKeyword_0_2; }
		
		//StringLiteral
		public RuleCall getStringLiteralParserRuleCall_1() { return cStringLiteralParserRuleCall_1; }
		
		//BooleanLiteral
		public RuleCall getBooleanLiteralParserRuleCall_2() { return cBooleanLiteralParserRuleCall_2; }
		
		//NullLiteral
		public RuleCall getNullLiteralParserRuleCall_3() { return cNullLiteralParserRuleCall_3; }
		
		//PortDirectionLiteral
		public RuleCall getPortDirectionLiteralParserRuleCall_4() { return cPortDirectionLiteralParserRuleCall_4; }
		
		//NumberLiteral
		public RuleCall getNumberLiteralParserRuleCall_5() { return cNumberLiteralParserRuleCall_5; }
		
		//FeatureCallExpression
		public RuleCall getFeatureCallExpressionParserRuleCall_6() { return cFeatureCallExpressionParserRuleCall_6; }
		
		//TypedMemberCallExpression
		public RuleCall getTypedMemberCallExpressionParserRuleCall_7() { return cTypedMemberCallExpressionParserRuleCall_7; }
	}
	
	public class TransformationTypesElements extends AbstractElementFinder.AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.TransformationTypes");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cIntegerEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cIntegerIntegerKeyword_0_0 = (Keyword)cIntegerEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cFloatEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cFloatFloatKeyword_1_0 = (Keyword)cFloatEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cStringEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cStringStringKeyword_2_0 = (Keyword)cStringEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cBooleanEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cBooleanBooleanKeyword_3_0 = (Keyword)cBooleanEnumLiteralDeclaration_3.eContents().get(0);
		private final EnumLiteralDeclaration cVoidEnumLiteralDeclaration_4 = (EnumLiteralDeclaration)cAlternatives.eContents().get(4);
		private final Keyword cVoidVoidKeyword_4_0 = (Keyword)cVoidEnumLiteralDeclaration_4.eContents().get(0);
		
		//enum TransformationTypes returns parameter::TransformationPrimitiveType:
		//        Integer = 'integer' | Float = 'float'| String = 'String' | Boolean = 'boolean' | Void= "void";
		public EnumRule getRule() { return rule; }
		
		//Integer = 'integer' | Float = 'float'| String = 'String' | Boolean = 'boolean' | Void= "void"
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Integer = 'integer'
		public EnumLiteralDeclaration getIntegerEnumLiteralDeclaration_0() { return cIntegerEnumLiteralDeclaration_0; }
		
		//'integer'
		public Keyword getIntegerIntegerKeyword_0_0() { return cIntegerIntegerKeyword_0_0; }
		
		//Float = 'float'
		public EnumLiteralDeclaration getFloatEnumLiteralDeclaration_1() { return cFloatEnumLiteralDeclaration_1; }
		
		//'float'
		public Keyword getFloatFloatKeyword_1_0() { return cFloatFloatKeyword_1_0; }
		
		//String = 'String'
		public EnumLiteralDeclaration getStringEnumLiteralDeclaration_2() { return cStringEnumLiteralDeclaration_2; }
		
		//'String'
		public Keyword getStringStringKeyword_2_0() { return cStringStringKeyword_2_0; }
		
		//Boolean = 'boolean'
		public EnumLiteralDeclaration getBooleanEnumLiteralDeclaration_3() { return cBooleanEnumLiteralDeclaration_3; }
		
		//'boolean'
		public Keyword getBooleanBooleanKeyword_3_0() { return cBooleanBooleanKeyword_3_0; }
		
		//Void= "void"
		public EnumLiteralDeclaration getVoidEnumLiteralDeclaration_4() { return cVoidEnumLiteralDeclaration_4; }
		
		//"void"
		public Keyword getVoidVoidKeyword_4_0() { return cVoidVoidKeyword_4_0; }
	}
	public class PortDirectionElements extends AbstractElementFinder.AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.PortDirection");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cINEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cINPortDirectionINKeyword_0_0 = (Keyword)cINEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cOUTEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cOUTPortDirectionOUTKeyword_1_0 = (Keyword)cOUTEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cINOUTEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cINOUTPortDirectionINOUTKeyword_2_0 = (Keyword)cINOUTEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cUNSETEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cUNSETPortDirectionUNSETKeyword_3_0 = (Keyword)cUNSETEnumLiteralDeclaration_3.eContents().get(0);
		
		//enum PortDirection returns block::PortDirection:
		//    IN = 'PortDirection.IN' | OUT = 'PortDirection.OUT' | INOUT = 'PortDirection.INOUT' | UNSET = 'PortDirection.UNSET'
		//;
		public EnumRule getRule() { return rule; }
		
		//IN = 'PortDirection.IN' | OUT = 'PortDirection.OUT' | INOUT = 'PortDirection.INOUT' | UNSET = 'PortDirection.UNSET'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//IN = 'PortDirection.IN'
		public EnumLiteralDeclaration getINEnumLiteralDeclaration_0() { return cINEnumLiteralDeclaration_0; }
		
		//'PortDirection.IN'
		public Keyword getINPortDirectionINKeyword_0_0() { return cINPortDirectionINKeyword_0_0; }
		
		//OUT = 'PortDirection.OUT'
		public EnumLiteralDeclaration getOUTEnumLiteralDeclaration_1() { return cOUTEnumLiteralDeclaration_1; }
		
		//'PortDirection.OUT'
		public Keyword getOUTPortDirectionOUTKeyword_1_0() { return cOUTPortDirectionOUTKeyword_1_0; }
		
		//INOUT = 'PortDirection.INOUT'
		public EnumLiteralDeclaration getINOUTEnumLiteralDeclaration_2() { return cINOUTEnumLiteralDeclaration_2; }
		
		//'PortDirection.INOUT'
		public Keyword getINOUTPortDirectionINOUTKeyword_2_0() { return cINOUTPortDirectionINOUTKeyword_2_0; }
		
		//UNSET = 'PortDirection.UNSET'
		public EnumLiteralDeclaration getUNSETEnumLiteralDeclaration_3() { return cUNSETEnumLiteralDeclaration_3; }
		
		//'PortDirection.UNSET'
		public Keyword getUNSETPortDirectionUNSETKeyword_3_0() { return cUNSETPortDirectionUNSETKeyword_3_0; }
	}
	
	private final TransformationElements pTransformation;
	private final TerminalRule tBEGIN;
	private final TerminalRule tEND;
	private final ExpressionElements pExpression;
	private final TransformationTypeElements pTransformationType;
	private final TypeBasedTransformationTypeElements pTypeBasedTransformationType;
	private final EClassBasedTransformationTypeElements pEClassBasedTransformationType;
	private final ListBasedTransformationTypeElements pListBasedTransformationType;
	private final ParameterElements pParameter;
	private final TypeBasedParameterElements pTypeBasedParameter;
	private final EClassBasedParameterElements pEClassBasedParameter;
	private final ListBasedParameterElements pListBasedParameter;
	private final ConcatenationExpressionElements pConcatenationExpression;
	private final PrimaryElements pPrimary;
	private final StringLiteralElements pStringLiteral;
	private final NumberLiteralElements pNumberLiteral;
	private final NullLiteralElements pNullLiteral;
	private final BooleanLiteralElements pBooleanLiteral;
	private final PortDirectionLiteralElements pPortDirectionLiteral;
	private final NumberElements pNumber;
	private final FeatureCallExpressionElements pFeatureCallExpression;
	private final OperationCallExpressionElements pOperationCallExpression;
	private final AssignmentOrVariableDeclarationElements pAssignmentOrVariableDeclaration;
	private final VariableDeclarationElements pVariableDeclaration;
	private final AssignmentExpressionElements pAssignmentExpression;
	private final TypedMemberCallExpressionElements pTypedMemberCallExpression;
	private final ForLoopExpressionElements pForLoopExpression;
	private final IfExpressionElements pIfExpression;
	private final BooleanExpressionElements pBooleanExpression;
	private final OrBooleanExpressionElements pOrBooleanExpression;
	private final AndBooleanExpressionElements pAndBooleanExpression;
	private final ComparisonBooleanExpressionElements pComparisonBooleanExpression;
	private final BooleanNegationExpressionElements pBooleanNegationExpression;
	private final AtomicElements pAtomic;
	private final TransformationTypesElements eTransformationTypes;
	private final PortDirectionElements ePortDirection;
	
	private final Grammar grammar;
	
	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public USFLanguageGrammarAccess(GrammarProvider grammarProvider,
			TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pTransformation = new TransformationElements();
		this.tBEGIN = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.BEGIN");
		this.tEND = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.safe4i.usf.transformation.language.USFLanguage.END");
		this.pExpression = new ExpressionElements();
		this.pTransformationType = new TransformationTypeElements();
		this.pTypeBasedTransformationType = new TypeBasedTransformationTypeElements();
		this.pEClassBasedTransformationType = new EClassBasedTransformationTypeElements();
		this.pListBasedTransformationType = new ListBasedTransformationTypeElements();
		this.pParameter = new ParameterElements();
		this.pTypeBasedParameter = new TypeBasedParameterElements();
		this.pEClassBasedParameter = new EClassBasedParameterElements();
		this.pListBasedParameter = new ListBasedParameterElements();
		this.pConcatenationExpression = new ConcatenationExpressionElements();
		this.pPrimary = new PrimaryElements();
		this.pStringLiteral = new StringLiteralElements();
		this.pNumberLiteral = new NumberLiteralElements();
		this.pNullLiteral = new NullLiteralElements();
		this.pBooleanLiteral = new BooleanLiteralElements();
		this.pPortDirectionLiteral = new PortDirectionLiteralElements();
		this.pNumber = new NumberElements();
		this.pFeatureCallExpression = new FeatureCallExpressionElements();
		this.pOperationCallExpression = new OperationCallExpressionElements();
		this.pAssignmentOrVariableDeclaration = new AssignmentOrVariableDeclarationElements();
		this.pVariableDeclaration = new VariableDeclarationElements();
		this.pAssignmentExpression = new AssignmentExpressionElements();
		this.pTypedMemberCallExpression = new TypedMemberCallExpressionElements();
		this.pForLoopExpression = new ForLoopExpressionElements();
		this.pIfExpression = new IfExpressionElements();
		this.pBooleanExpression = new BooleanExpressionElements();
		this.pOrBooleanExpression = new OrBooleanExpressionElements();
		this.pAndBooleanExpression = new AndBooleanExpressionElements();
		this.pComparisonBooleanExpression = new ComparisonBooleanExpressionElements();
		this.pBooleanNegationExpression = new BooleanNegationExpressionElements();
		this.pAtomic = new AtomicElements();
		this.eTransformationTypes = new TransformationTypesElements();
		this.ePortDirection = new PortDirectionElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.safe4i.usf.transformation.language.USFLanguage".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Transformation returns Transformation hidden(WS, ML_COMMENT, SL_COMMENT):
	//    {Transformation}
	//    'transform' name=ID '('
	//        BEGIN
	//        (parameters+=Parameter ("," parameters+=Parameter)*)?
	//     ')'
	//    (':' type=TransformationType)? "{"
	//    END
	//    'PRECONDITION'
	//    BEGIN
	//    (preconditions+=Expression)*
	//    END
	//    'RULES'
	//    BEGIN
	//    (content+=Expression)*
	//    END
	//    ('RETURN'
	//    BEGIN
	//    output=Expression
	//    END)?
	//    '}';
	public TransformationElements getTransformationAccess() {
		return pTransformation;
	}
	
	public ParserRule getTransformationRule() {
		return getTransformationAccess().getRule();
	}
	
	//terminal BEGIN:
	//    'synthetic:BEGIN';
	public TerminalRule getBEGINRule() {
		return tBEGIN;
	}
	
	//terminal END:
	//    'synthetic:END';
	public TerminalRule getENDRule() {
		return tEND;
	}
	
	//Expression returns Expression:
	//    AssignmentOrVariableDeclaration |
	//    NullLiteral |
	//    BooleanLiteral | ForLoopExpression| IfExpression|
	//    ConcatenationExpression;
	public ExpressionElements getExpressionAccess() {
		return pExpression;
	}
	
	public ParserRule getExpressionRule() {
		return getExpressionAccess().getRule();
	}
	
	//TransformationType returns TransformationType:
	//    TypeBasedTransformationType | EClassBasedTransformationType | ListBasedTransformationType;
	public TransformationTypeElements getTransformationTypeAccess() {
		return pTransformationType;
	}
	
	public ParserRule getTransformationTypeRule() {
		return getTransformationTypeAccess().getRule();
	}
	
	//TypeBasedTransformationType returns TypeBasedTransformationType:
	//    type=TransformationTypes;
	public TypeBasedTransformationTypeElements getTypeBasedTransformationTypeAccess() {
		return pTypeBasedTransformationType;
	}
	
	public ParserRule getTypeBasedTransformationTypeRule() {
		return getTypeBasedTransformationTypeAccess().getRule();
	}
	
	//EClassBasedTransformationType returns EClassBasedTransformationType:
	//    {EClassBasedTransformationType}
	//    type=[ecore::EClass|ID];
	public EClassBasedTransformationTypeElements getEClassBasedTransformationTypeAccess() {
		return pEClassBasedTransformationType;
	}
	
	public ParserRule getEClassBasedTransformationTypeRule() {
		return getEClassBasedTransformationTypeAccess().getRule();
	}
	
	//ListBasedTransformationType returns ListBasedTransformationType:
	//    {ListBasedTransformationType}
	//    'List' '<' type=[ecore::EClass|ID] '>';
	public ListBasedTransformationTypeElements getListBasedTransformationTypeAccess() {
		return pListBasedTransformationType;
	}
	
	public ParserRule getListBasedTransformationTypeRule() {
		return getListBasedTransformationTypeAccess().getRule();
	}
	
	//Parameter returns Parameter:
	//    TypeBasedParameter | EClassBasedParameter | ListBasedParameter;
	public ParameterElements getParameterAccess() {
		return pParameter;
	}
	
	public ParserRule getParameterRule() {
		return getParameterAccess().getRule();
	}
	
	//TypeBasedParameter returns TypeBasedParameter:
	//    {TypeBasedParameter}
	//    name=ID ':' type=TransformationTypes;
	public TypeBasedParameterElements getTypeBasedParameterAccess() {
		return pTypeBasedParameter;
	}
	
	public ParserRule getTypeBasedParameterRule() {
		return getTypeBasedParameterAccess().getRule();
	}
	
	//EClassBasedParameter returns EClassBasedParameter:
	//    {EClassBasedParameter}
	//    name=ID ':' type=[ecore::EClass|ID];
	public EClassBasedParameterElements getEClassBasedParameterAccess() {
		return pEClassBasedParameter;
	}
	
	public ParserRule getEClassBasedParameterRule() {
		return getEClassBasedParameterAccess().getRule();
	}
	
	//ListBasedParameter returns ListBasedParameter:
	//    {ListBasedParameter}
	//    name=ID ':' 'List' '<' type=[ecore::EClass|ID] '>';
	public ListBasedParameterElements getListBasedParameterAccess() {
		return pListBasedParameter;
	}
	
	public ParserRule getListBasedParameterRule() {
		return getListBasedParameterAccess().getRule();
	}
	
	//ConcatenationExpression returns Expression:
	//    Primary ({ConcatenationExpression.left=current} '+' right=Primary)*;
	public ConcatenationExpressionElements getConcatenationExpressionAccess() {
		return pConcatenationExpression;
	}
	
	public ParserRule getConcatenationExpressionRule() {
		return getConcatenationExpressionAccess().getRule();
	}
	
	//Primary returns Expression:
	//    StringLiteral |
	//    NumberLiteral |
	//    TypedMemberCallExpression |
	//    FeatureCallExpression |
	//    OperationCallExpression |
	//    PortDirectionLiteral
	//    ;
	public PrimaryElements getPrimaryAccess() {
		return pPrimary;
	}
	
	public ParserRule getPrimaryRule() {
		return getPrimaryAccess().getRule();
	}
	
	//StringLiteral returns StringLiteral:
	//    value=STRING;
	public StringLiteralElements getStringLiteralAccess() {
		return pStringLiteral;
	}
	
	public ParserRule getStringLiteralRule() {
		return getStringLiteralAccess().getRule();
	}
	
	//NumberLiteral returns NumberLiteral:
	//    value=Number;
	public NumberLiteralElements getNumberLiteralAccess() {
		return pNumberLiteral;
	}
	
	public ParserRule getNumberLiteralRule() {
		return getNumberLiteralAccess().getRule();
	}
	
	//NullLiteral returns NullLiteral:
	//    {NullLiteral} 'null';
	public NullLiteralElements getNullLiteralAccess() {
		return pNullLiteral;
	}
	
	public ParserRule getNullLiteralRule() {
		return getNullLiteralAccess().getRule();
	}
	
	//BooleanLiteral returns BooleanLiteral:
	//    {BooleanLiteral} ('false' | isTrue?='true');
	public BooleanLiteralElements getBooleanLiteralAccess() {
		return pBooleanLiteral;
	}
	
	public ParserRule getBooleanLiteralRule() {
		return getBooleanLiteralAccess().getRule();
	}
	
	//PortDirectionLiteral returns PortDirectionLiteral:
	//    {PortDirectionLiteral} direction=PortDirection
	//;
	public PortDirectionLiteralElements getPortDirectionLiteralAccess() {
		return pPortDirectionLiteral;
	}
	
	public ParserRule getPortDirectionLiteralRule() {
		return getPortDirectionLiteralAccess().getRule();
	}
	
	//Number hidden():
	//    INT ('.' INT)?;
	public NumberElements getNumberAccess() {
		return pNumber;
	}
	
	public ParserRule getNumberRule() {
		return getNumberAccess().getRule();
	}
	
	//FeatureCallExpression returns FeatureCallExpression:
	//    context=[TypedMember] '.'+ structuralFeature=[ecore::ETypedElement|ID] ('(' (parameterValues+=Expression (","
	//    parameterValues+=Expression)*)?')')?;
	public FeatureCallExpressionElements getFeatureCallExpressionAccess() {
		return pFeatureCallExpression;
	}
	
	public ParserRule getFeatureCallExpressionRule() {
		return getFeatureCallExpressionAccess().getRule();
	}
	
	//OperationCallExpression returns OperationCallExpression:
	//    {OperationCallExpression}
	//    operation=[ecore::EOperation|ID] '(' (parameterValues+=Expression ("," parameterValues+=Expression)*)?
	//    ')';
	public OperationCallExpressionElements getOperationCallExpressionAccess() {
		return pOperationCallExpression;
	}
	
	public ParserRule getOperationCallExpressionRule() {
		return getOperationCallExpressionAccess().getRule();
	}
	
	//AssignmentOrVariableDeclaration returns Expression:
	//    VariableDeclaration | AssignmentExpression
	//;
	public AssignmentOrVariableDeclarationElements getAssignmentOrVariableDeclarationAccess() {
		return pAssignmentOrVariableDeclaration;
	}
	
	public ParserRule getAssignmentOrVariableDeclarationRule() {
		return getAssignmentOrVariableDeclarationAccess().getRule();
	}
	
	//VariableDeclaration returns VariableDeclaration:
	//    {VariableDeclaration}
	//    (writeable?='var'|'val') (=>(type=TransformationType name=ID) | name=ID) ('=' rhs=Expression)?;
	public VariableDeclarationElements getVariableDeclarationAccess() {
		return pVariableDeclaration;
	}
	
	public ParserRule getVariableDeclarationRule() {
		return getVariableDeclarationAccess().getRule();
	}
	
	//AssignmentExpression returns AssignmentExpression:
	//    {AssignmentExpression} typeMember=[VariableDeclaration]  '=' value=Expression
	//;
	public AssignmentExpressionElements getAssignmentExpressionAccess() {
		return pAssignmentExpression;
	}
	
	public ParserRule getAssignmentExpressionRule() {
		return getAssignmentExpressionAccess().getRule();
	}
	
	//TypedMemberCallExpression returns TypedMemberCallExpression:
	//    {TypedMemberCallExpression}
	//    typeMember=[TypedMember];
	public TypedMemberCallExpressionElements getTypedMemberCallExpressionAccess() {
		return pTypedMemberCallExpression;
	}
	
	public ParserRule getTypedMemberCallExpressionRule() {
		return getTypedMemberCallExpressionAccess().getRule();
	}
	
	//ForLoopExpression returns ForLoopExpression:
	//    =>({ForLoopExpression}
	//    'for' '(' declaredParam=Parameter 'in'  ) forExpression=Expression ')' '{'
	//            (BEGIN
	//            (eachExpression+=Expression)*
	//            END)?  '}'
	//;
	public ForLoopExpressionElements getForLoopExpressionAccess() {
		return pForLoopExpression;
	}
	
	public ParserRule getForLoopExpressionRule() {
		return getForLoopExpressionAccess().getRule();
	}
	
	//IfExpression returns IFExpression:
	//    {IFExpression}
	//    'if' '(' condition=BooleanExpression ')'  '{'
	//            (BEGIN
	//            (then+=Expression)*
	//            END )?
	//            '}'
	//    (=>'else' '{'
	//        (BEGIN
	//            (else+=Expression)*
	//        END )?
	//        '}'
	//    )?
	//;
	public IfExpressionElements getIfExpressionAccess() {
		return pIfExpression;
	}
	
	public ParserRule getIfExpressionRule() {
		return getIfExpressionAccess().getRule();
	}
	
	//BooleanExpression returns Expression:
	//    OrBooleanExpression
	//;
	public BooleanExpressionElements getBooleanExpressionAccess() {
		return pBooleanExpression;
	}
	
	public ParserRule getBooleanExpressionRule() {
		return getBooleanExpressionAccess().getRule();
	}
	
	//OrBooleanExpression returns Expression:
	//    AndBooleanExpression (({OrBooleanExpression.left=current} "||") right=AndBooleanExpression)*
	//;
	public OrBooleanExpressionElements getOrBooleanExpressionAccess() {
		return pOrBooleanExpression;
	}
	
	public ParserRule getOrBooleanExpressionRule() {
		return getOrBooleanExpressionAccess().getRule();
	}
	
	//AndBooleanExpression returns Expression:
	//    ComparisonBooleanExpression (({AndBooleanExpression.left=current} "&&") right=ComparisonBooleanExpression)*
	//;
	public AndBooleanExpressionElements getAndBooleanExpressionAccess() {
		return pAndBooleanExpression;
	}
	
	public ParserRule getAndBooleanExpressionRule() {
		return getAndBooleanExpressionAccess().getRule();
	}
	
	//ComparisonBooleanExpression returns Expression:
	//    BooleanNegationExpression ({ComparisonBooleanExpression.left=current} operator=("<"|"<="|"=="|">="|">"|"!=") right=BooleanNegationExpression)*
	//;
	public ComparisonBooleanExpressionElements getComparisonBooleanExpressionAccess() {
		return pComparisonBooleanExpression;
	}
	
	public ParserRule getComparisonBooleanExpressionRule() {
		return getComparisonBooleanExpressionAccess().getRule();
	}
	
	//BooleanNegationExpression returns Expression:
	//  {BooleanNegationExpression} => (isNegate?='!')?  expression=Atomic
	//;
	public BooleanNegationExpressionElements getBooleanNegationExpressionAccess() {
		return pBooleanNegationExpression;
	}
	
	public ParserRule getBooleanNegationExpressionRule() {
		return getBooleanNegationExpressionAccess().getRule();
	}
	
	//Atomic returns Expression:
	//    '(' Expression ')' |
	//    StringLiteral | BooleanLiteral| NullLiteral| PortDirectionLiteral |
	//    NumberLiteral |FeatureCallExpression | TypedMemberCallExpression
	//;
	public AtomicElements getAtomicAccess() {
		return pAtomic;
	}
	
	public ParserRule getAtomicRule() {
		return getAtomicAccess().getRule();
	}
	
	//enum TransformationTypes returns parameter::TransformationPrimitiveType:
	//        Integer = 'integer' | Float = 'float'| String = 'String' | Boolean = 'boolean' | Void= "void";
	public TransformationTypesElements getTransformationTypesAccess() {
		return eTransformationTypes;
	}
	
	public EnumRule getTransformationTypesRule() {
		return getTransformationTypesAccess().getRule();
	}
	
	//enum PortDirection returns block::PortDirection:
	//    IN = 'PortDirection.IN' | OUT = 'PortDirection.OUT' | INOUT = 'PortDirection.INOUT' | UNSET = 'PortDirection.UNSET'
	//;
	public PortDirectionElements getPortDirectionAccess() {
		return ePortDirection;
	}
	
	public EnumRule getPortDirectionRule() {
		return getPortDirectionAccess().getRule();
	}
	
	//terminal ID: '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	}
	
	//terminal INT returns ecore::EInt: ('0'..'9')+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	}
	
	//terminal STRING:
	//            '"' ( '\\' . /* 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' */ | !('\\'|'"') )* '"' |
	//            "'" ( '\\' . /* 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' */ | !('\\'|"'") )* "'"
	//        ;
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	}
	
	//terminal ML_COMMENT : '/*' -> '*/';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT : '//' !('\n'|'\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	}
	
	//terminal WS         : (' '|'\t'|'\r'|'\n')+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	}
	
	//terminal ANY_OTHER: .;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	}
}
