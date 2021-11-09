/*******************************************************************************
* Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
* This program and the accompanying materials are made available under the
* terms of the Eclipse Public License 2.0 which is available at
* http://www.eclipse.org/legal/epl-2.0.
* 
* SPDX-License-Identifier: EPL-2.0
*******************************************************************************/
package org.safe4i.usf.transformation.language.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.safe4i.usf.transformation.language.ide.contentassist.antlr.internal.InternalUSFLanguageParser;
import org.safe4i.usf.transformation.language.services.USFLanguageGrammarAccess;

public class USFLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(USFLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, USFLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getExpressionAccess().getAlternatives(), "rule__Expression__Alternatives");
			builder.put(grammarAccess.getTransformationTypeAccess().getAlternatives(), "rule__TransformationType__Alternatives");
			builder.put(grammarAccess.getParameterAccess().getAlternatives(), "rule__Parameter__Alternatives");
			builder.put(grammarAccess.getPrimaryAccess().getAlternatives(), "rule__Primary__Alternatives");
			builder.put(grammarAccess.getBooleanLiteralAccess().getAlternatives_1(), "rule__BooleanLiteral__Alternatives_1");
			builder.put(grammarAccess.getAssignmentOrVariableDeclarationAccess().getAlternatives(), "rule__AssignmentOrVariableDeclaration__Alternatives");
			builder.put(grammarAccess.getVariableDeclarationAccess().getAlternatives_1(), "rule__VariableDeclaration__Alternatives_1");
			builder.put(grammarAccess.getVariableDeclarationAccess().getAlternatives_2(), "rule__VariableDeclaration__Alternatives_2");
			builder.put(grammarAccess.getComparisonBooleanExpressionAccess().getOperatorAlternatives_1_1_0(), "rule__ComparisonBooleanExpression__OperatorAlternatives_1_1_0");
			builder.put(grammarAccess.getAtomicAccess().getAlternatives(), "rule__Atomic__Alternatives");
			builder.put(grammarAccess.getTransformationTypesAccess().getAlternatives(), "rule__TransformationTypes__Alternatives");
			builder.put(grammarAccess.getPortDirectionAccess().getAlternatives(), "rule__PortDirection__Alternatives");
			builder.put(grammarAccess.getTransformationAccess().getGroup(), "rule__Transformation__Group__0");
			builder.put(grammarAccess.getTransformationAccess().getGroup_5(), "rule__Transformation__Group_5__0");
			builder.put(grammarAccess.getTransformationAccess().getGroup_5_1(), "rule__Transformation__Group_5_1__0");
			builder.put(grammarAccess.getTransformationAccess().getGroup_7(), "rule__Transformation__Group_7__0");
			builder.put(grammarAccess.getTransformationAccess().getGroup_18(), "rule__Transformation__Group_18__0");
			builder.put(grammarAccess.getEClassBasedTransformationTypeAccess().getGroup(), "rule__EClassBasedTransformationType__Group__0");
			builder.put(grammarAccess.getListBasedTransformationTypeAccess().getGroup(), "rule__ListBasedTransformationType__Group__0");
			builder.put(grammarAccess.getTypeBasedParameterAccess().getGroup(), "rule__TypeBasedParameter__Group__0");
			builder.put(grammarAccess.getEClassBasedParameterAccess().getGroup(), "rule__EClassBasedParameter__Group__0");
			builder.put(grammarAccess.getListBasedParameterAccess().getGroup(), "rule__ListBasedParameter__Group__0");
			builder.put(grammarAccess.getConcatenationExpressionAccess().getGroup(), "rule__ConcatenationExpression__Group__0");
			builder.put(grammarAccess.getConcatenationExpressionAccess().getGroup_1(), "rule__ConcatenationExpression__Group_1__0");
			builder.put(grammarAccess.getNullLiteralAccess().getGroup(), "rule__NullLiteral__Group__0");
			builder.put(grammarAccess.getBooleanLiteralAccess().getGroup(), "rule__BooleanLiteral__Group__0");
			builder.put(grammarAccess.getPortDirectionLiteralAccess().getGroup(), "rule__PortDirectionLiteral__Group__0");
			builder.put(grammarAccess.getNumberAccess().getGroup(), "rule__Number__Group__0");
			builder.put(grammarAccess.getNumberAccess().getGroup_1(), "rule__Number__Group_1__0");
			builder.put(grammarAccess.getFeatureCallExpressionAccess().getGroup(), "rule__FeatureCallExpression__Group__0");
			builder.put(grammarAccess.getFeatureCallExpressionAccess().getGroup_3(), "rule__FeatureCallExpression__Group_3__0");
			builder.put(grammarAccess.getFeatureCallExpressionAccess().getGroup_3_1(), "rule__FeatureCallExpression__Group_3_1__0");
			builder.put(grammarAccess.getFeatureCallExpressionAccess().getGroup_3_1_1(), "rule__FeatureCallExpression__Group_3_1_1__0");
			builder.put(grammarAccess.getOperationCallExpressionAccess().getGroup(), "rule__OperationCallExpression__Group__0");
			builder.put(grammarAccess.getOperationCallExpressionAccess().getGroup_3(), "rule__OperationCallExpression__Group_3__0");
			builder.put(grammarAccess.getOperationCallExpressionAccess().getGroup_3_1(), "rule__OperationCallExpression__Group_3_1__0");
			builder.put(grammarAccess.getVariableDeclarationAccess().getGroup(), "rule__VariableDeclaration__Group__0");
			builder.put(grammarAccess.getVariableDeclarationAccess().getGroup_2_0(), "rule__VariableDeclaration__Group_2_0__0");
			builder.put(grammarAccess.getVariableDeclarationAccess().getGroup_2_0_0(), "rule__VariableDeclaration__Group_2_0_0__0");
			builder.put(grammarAccess.getVariableDeclarationAccess().getGroup_3(), "rule__VariableDeclaration__Group_3__0");
			builder.put(grammarAccess.getAssignmentExpressionAccess().getGroup(), "rule__AssignmentExpression__Group__0");
			builder.put(grammarAccess.getTypedMemberCallExpressionAccess().getGroup(), "rule__TypedMemberCallExpression__Group__0");
			builder.put(grammarAccess.getForLoopExpressionAccess().getGroup(), "rule__ForLoopExpression__Group__0");
			builder.put(grammarAccess.getForLoopExpressionAccess().getGroup_0(), "rule__ForLoopExpression__Group_0__0");
			builder.put(grammarAccess.getForLoopExpressionAccess().getGroup_0_0(), "rule__ForLoopExpression__Group_0_0__0");
			builder.put(grammarAccess.getForLoopExpressionAccess().getGroup_4(), "rule__ForLoopExpression__Group_4__0");
			builder.put(grammarAccess.getIfExpressionAccess().getGroup(), "rule__IfExpression__Group__0");
			builder.put(grammarAccess.getIfExpressionAccess().getGroup_6(), "rule__IfExpression__Group_6__0");
			builder.put(grammarAccess.getIfExpressionAccess().getGroup_8(), "rule__IfExpression__Group_8__0");
			builder.put(grammarAccess.getIfExpressionAccess().getGroup_8_2(), "rule__IfExpression__Group_8_2__0");
			builder.put(grammarAccess.getOrBooleanExpressionAccess().getGroup(), "rule__OrBooleanExpression__Group__0");
			builder.put(grammarAccess.getOrBooleanExpressionAccess().getGroup_1(), "rule__OrBooleanExpression__Group_1__0");
			builder.put(grammarAccess.getOrBooleanExpressionAccess().getGroup_1_0(), "rule__OrBooleanExpression__Group_1_0__0");
			builder.put(grammarAccess.getAndBooleanExpressionAccess().getGroup(), "rule__AndBooleanExpression__Group__0");
			builder.put(grammarAccess.getAndBooleanExpressionAccess().getGroup_1(), "rule__AndBooleanExpression__Group_1__0");
			builder.put(grammarAccess.getAndBooleanExpressionAccess().getGroup_1_0(), "rule__AndBooleanExpression__Group_1_0__0");
			builder.put(grammarAccess.getComparisonBooleanExpressionAccess().getGroup(), "rule__ComparisonBooleanExpression__Group__0");
			builder.put(grammarAccess.getComparisonBooleanExpressionAccess().getGroup_1(), "rule__ComparisonBooleanExpression__Group_1__0");
			builder.put(grammarAccess.getBooleanNegationExpressionAccess().getGroup(), "rule__BooleanNegationExpression__Group__0");
			builder.put(grammarAccess.getBooleanNegationExpressionAccess().getGroup_1(), "rule__BooleanNegationExpression__Group_1__0");
			builder.put(grammarAccess.getAtomicAccess().getGroup_0(), "rule__Atomic__Group_0__0");
			builder.put(grammarAccess.getTransformationAccess().getNameAssignment_2(), "rule__Transformation__NameAssignment_2");
			builder.put(grammarAccess.getTransformationAccess().getParametersAssignment_5_0(), "rule__Transformation__ParametersAssignment_5_0");
			builder.put(grammarAccess.getTransformationAccess().getParametersAssignment_5_1_1(), "rule__Transformation__ParametersAssignment_5_1_1");
			builder.put(grammarAccess.getTransformationAccess().getTypeAssignment_7_1(), "rule__Transformation__TypeAssignment_7_1");
			builder.put(grammarAccess.getTransformationAccess().getPreconditionsAssignment_12(), "rule__Transformation__PreconditionsAssignment_12");
			builder.put(grammarAccess.getTransformationAccess().getContentAssignment_16(), "rule__Transformation__ContentAssignment_16");
			builder.put(grammarAccess.getTransformationAccess().getOutputAssignment_18_2(), "rule__Transformation__OutputAssignment_18_2");
			builder.put(grammarAccess.getTypeBasedTransformationTypeAccess().getTypeAssignment(), "rule__TypeBasedTransformationType__TypeAssignment");
			builder.put(grammarAccess.getEClassBasedTransformationTypeAccess().getTypeAssignment_1(), "rule__EClassBasedTransformationType__TypeAssignment_1");
			builder.put(grammarAccess.getListBasedTransformationTypeAccess().getTypeAssignment_3(), "rule__ListBasedTransformationType__TypeAssignment_3");
			builder.put(grammarAccess.getTypeBasedParameterAccess().getNameAssignment_1(), "rule__TypeBasedParameter__NameAssignment_1");
			builder.put(grammarAccess.getTypeBasedParameterAccess().getTypeAssignment_3(), "rule__TypeBasedParameter__TypeAssignment_3");
			builder.put(grammarAccess.getEClassBasedParameterAccess().getNameAssignment_1(), "rule__EClassBasedParameter__NameAssignment_1");
			builder.put(grammarAccess.getEClassBasedParameterAccess().getTypeAssignment_3(), "rule__EClassBasedParameter__TypeAssignment_3");
			builder.put(grammarAccess.getListBasedParameterAccess().getNameAssignment_1(), "rule__ListBasedParameter__NameAssignment_1");
			builder.put(grammarAccess.getListBasedParameterAccess().getTypeAssignment_5(), "rule__ListBasedParameter__TypeAssignment_5");
			builder.put(grammarAccess.getConcatenationExpressionAccess().getRightAssignment_1_2(), "rule__ConcatenationExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getStringLiteralAccess().getValueAssignment(), "rule__StringLiteral__ValueAssignment");
			builder.put(grammarAccess.getNumberLiteralAccess().getValueAssignment(), "rule__NumberLiteral__ValueAssignment");
			builder.put(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1(), "rule__BooleanLiteral__IsTrueAssignment_1_1");
			builder.put(grammarAccess.getPortDirectionLiteralAccess().getDirectionAssignment_1(), "rule__PortDirectionLiteral__DirectionAssignment_1");
			builder.put(grammarAccess.getFeatureCallExpressionAccess().getContextAssignment_0(), "rule__FeatureCallExpression__ContextAssignment_0");
			builder.put(grammarAccess.getFeatureCallExpressionAccess().getStructuralFeatureAssignment_2(), "rule__FeatureCallExpression__StructuralFeatureAssignment_2");
			builder.put(grammarAccess.getFeatureCallExpressionAccess().getParameterValuesAssignment_3_1_0(), "rule__FeatureCallExpression__ParameterValuesAssignment_3_1_0");
			builder.put(grammarAccess.getFeatureCallExpressionAccess().getParameterValuesAssignment_3_1_1_1(), "rule__FeatureCallExpression__ParameterValuesAssignment_3_1_1_1");
			builder.put(grammarAccess.getOperationCallExpressionAccess().getOperationAssignment_1(), "rule__OperationCallExpression__OperationAssignment_1");
			builder.put(grammarAccess.getOperationCallExpressionAccess().getParameterValuesAssignment_3_0(), "rule__OperationCallExpression__ParameterValuesAssignment_3_0");
			builder.put(grammarAccess.getOperationCallExpressionAccess().getParameterValuesAssignment_3_1_1(), "rule__OperationCallExpression__ParameterValuesAssignment_3_1_1");
			builder.put(grammarAccess.getVariableDeclarationAccess().getWriteableAssignment_1_0(), "rule__VariableDeclaration__WriteableAssignment_1_0");
			builder.put(grammarAccess.getVariableDeclarationAccess().getTypeAssignment_2_0_0_0(), "rule__VariableDeclaration__TypeAssignment_2_0_0_0");
			builder.put(grammarAccess.getVariableDeclarationAccess().getNameAssignment_2_0_0_1(), "rule__VariableDeclaration__NameAssignment_2_0_0_1");
			builder.put(grammarAccess.getVariableDeclarationAccess().getNameAssignment_2_1(), "rule__VariableDeclaration__NameAssignment_2_1");
			builder.put(grammarAccess.getVariableDeclarationAccess().getRhsAssignment_3_1(), "rule__VariableDeclaration__RhsAssignment_3_1");
			builder.put(grammarAccess.getAssignmentExpressionAccess().getTypeMemberAssignment_1(), "rule__AssignmentExpression__TypeMemberAssignment_1");
			builder.put(grammarAccess.getAssignmentExpressionAccess().getValueAssignment_3(), "rule__AssignmentExpression__ValueAssignment_3");
			builder.put(grammarAccess.getTypedMemberCallExpressionAccess().getTypeMemberAssignment_1(), "rule__TypedMemberCallExpression__TypeMemberAssignment_1");
			builder.put(grammarAccess.getForLoopExpressionAccess().getDeclaredParamAssignment_0_0_3(), "rule__ForLoopExpression__DeclaredParamAssignment_0_0_3");
			builder.put(grammarAccess.getForLoopExpressionAccess().getForExpressionAssignment_1(), "rule__ForLoopExpression__ForExpressionAssignment_1");
			builder.put(grammarAccess.getForLoopExpressionAccess().getEachExpressionAssignment_4_1(), "rule__ForLoopExpression__EachExpressionAssignment_4_1");
			builder.put(grammarAccess.getIfExpressionAccess().getConditionAssignment_3(), "rule__IfExpression__ConditionAssignment_3");
			builder.put(grammarAccess.getIfExpressionAccess().getThenAssignment_6_1(), "rule__IfExpression__ThenAssignment_6_1");
			builder.put(grammarAccess.getIfExpressionAccess().getElseAssignment_8_2_1(), "rule__IfExpression__ElseAssignment_8_2_1");
			builder.put(grammarAccess.getOrBooleanExpressionAccess().getRightAssignment_1_1(), "rule__OrBooleanExpression__RightAssignment_1_1");
			builder.put(grammarAccess.getAndBooleanExpressionAccess().getRightAssignment_1_1(), "rule__AndBooleanExpression__RightAssignment_1_1");
			builder.put(grammarAccess.getComparisonBooleanExpressionAccess().getOperatorAssignment_1_1(), "rule__ComparisonBooleanExpression__OperatorAssignment_1_1");
			builder.put(grammarAccess.getComparisonBooleanExpressionAccess().getRightAssignment_1_2(), "rule__ComparisonBooleanExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getBooleanNegationExpressionAccess().getIsNegateAssignment_1_0(), "rule__BooleanNegationExpression__IsNegateAssignment_1_0");
			builder.put(grammarAccess.getBooleanNegationExpressionAccess().getExpressionAssignment_2(), "rule__BooleanNegationExpression__ExpressionAssignment_2");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private USFLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalUSFLanguageParser createParser() {
		InternalUSFLanguageParser result = new InternalUSFLanguageParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected TokenSource createLexer(CharStream stream) {
		return new USFLanguageTokenSource(super.createLexer(stream));
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public USFLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(USFLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
