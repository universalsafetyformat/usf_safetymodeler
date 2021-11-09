/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.transformation.language.formatting2

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.safe4i.usf.model.transformation.Expression
import org.safe4i.usf.model.transformation.ForLoopExpression
import org.safe4i.usf.model.transformation.IFExpression
import org.safe4i.usf.model.transformation.Parameter
import org.safe4i.usf.model.transformation.Transformation
import org.safe4i.usf.transformation.language.services.USFLanguageGrammarAccess

class USFLanguageFormatter extends AbstractFormatter2 {

	@Inject extension USFLanguageGrammarAccess

	def dispatch void format(Transformation transformation, extension IFormattableDocument document) {
		
		interior(
			transformation.regionFor.keyword(transformationAccess.leftParenthesisKeyword_3).append[newLine],
			transformation.regionFor.keyword(transformationAccess.PRECONDITIONKeyword_10).prepend[newLine],
			[indent]
		)
	
		transformation.parameters.forEach[format]

		transformation.regionFor.keyword(transformationAccess.rightParenthesisKeyword_6).prepend[newLine].append[indent]
		val typeLength = transformation.type.regionForEObject.length
		transformation.regionFor.keyword(transformationAccess.colonKeyword_7_0).prepend[oneSpace].append[oneSpace autowrap(typeLength)]
		transformation.regionFor.keyword(transformationAccess.leftCurlyBracketKeyword_8).prepend[oneSpace]
		
		
		
//		transformation.preconditions.forEach[format]

//		val beginPrecondition = transformation.regionFor.ruleCall(transformationAccess.BEGINTerminalRuleCall_9).append[newLine]
//		val endPrecondition = transformation.regionFor.ruleCall(transformationAccess.ENDTerminalRuleCall_11).prepend[newLine]
//		interior(beginPrecondition, endPrecondition)[indent]
		
		for (expression : transformation.preconditions) {
			expression.append[newLine]
		}
		
//		transformation.regionFor.keyword(transformationAccess.RULESKeyword_14).prepend[noSpace].prepend[newLine]
//		transformation.regionFor.keyword(transformationAccess.RETURNKeyword_18_0).prepend[noSpace].prepend[newLine]
//
//		for (rule : transformation.content) {
//			rule.format
//		}

//		transformation.output.prepend[newLine].surround[indent]

//		end.prepend[newLine]
	}

	def dispatch void format(Parameter parameter, extension IFormattableDocument document) {
		parameter.immediatelyPreceding.keyword(',').prepend[noSpace].append[oneSpace].append[newLine]
	}

	def dispatch void format(Expression expression, extension IFormattableDocument document) {
		expression.prepend[newLine]
	}

	def dispatch void format(ForLoopExpression expression, extension IFormattableDocument document) {
//		val begin = expression.regionFor.ruleCall(forLoopExpressionAccess.BEGINTerminalRuleCall_4_0).append[newLine]
//		val end = expression.regionFor.ruleCall(forLoopExpressionAccess.ENDTerminalRuleCall_4_2).prepend[newLine]
//		interior(begin, end)[indent]

		for (expr : expression.eachExpression) {
			expr.format
		}
//		end.prepend[newLine;autowrap]
	}

	def dispatch void format(IFExpression expression, extension IFormattableDocument document) {
//		val beginThen = expression.regionFor.keyword(ifExpressionAccess.leftCurlyBracketKeyword_5).append[newLine]
//		val endThen = expression.regionFor.keyword(ifExpressionAccess.rightCurlyBracketKeyword_7).prepend[newLine]
//		interior(beginThen, endThen)[indent]
		for(then: expression.then){
			then.format
		}
		
//		val beginElse = expression.regionFor.keyword(ifExpressionAccess.leftCurlyBracketKeyword_8_1).append[newLine]
//		val endElse = expression.regionFor.keyword(ifExpressionAccess.rightCurlyBracketKeyword_8_3).prepend[newLine]
//		interior(beginElse, endElse)[indent]
		for(elsepart: expression.^else){
			elsepart.format
		}

	}

// TODO: implement for CreateBlockType, CreateStructDecl, CreateBlock, CreateInPort, CreateOutPort, GetPortByNameFromBlockType, AddSibling, BlockContainsPort, DuplicateBlock, GetBlockName, GetPort, GetPortByNameFromBlock, SetBlockName, CreateConnection, GetBlock, GetPeer, GetPortType, PortIsConnected, SetConnectionTarget, SetPortType, GetDestination, GetSource, AddMember, Concat, TypesAreEqual, CreateErrorType, CreateNumberType, CreateStructType, TransformationCallRule, LetRule, ExpressionRule
}
