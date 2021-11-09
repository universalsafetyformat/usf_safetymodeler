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
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.safe4i.usf.core.usfmodel.common.CommonsPackage;
import org.safe4i.usf.model.transformation.AndBooleanExpression;
import org.safe4i.usf.model.transformation.AssignmentExpression;
import org.safe4i.usf.model.transformation.BooleanLiteral;
import org.safe4i.usf.model.transformation.BooleanNegationExpression;
import org.safe4i.usf.model.transformation.ComparisonBooleanExpression;
import org.safe4i.usf.model.transformation.ConcatenationExpression;
import org.safe4i.usf.model.transformation.EClassBasedParameter;
import org.safe4i.usf.model.transformation.EClassBasedTransformationType;
import org.safe4i.usf.model.transformation.FeatureCallExpression;
import org.safe4i.usf.model.transformation.ForLoopExpression;
import org.safe4i.usf.model.transformation.IFExpression;
import org.safe4i.usf.model.transformation.ListBasedParameter;
import org.safe4i.usf.model.transformation.ListBasedTransformationType;
import org.safe4i.usf.model.transformation.NullLiteral;
import org.safe4i.usf.model.transformation.NumberLiteral;
import org.safe4i.usf.model.transformation.OperationCallExpression;
import org.safe4i.usf.model.transformation.OrBooleanExpression;
import org.safe4i.usf.model.transformation.PortDirectionLiteral;
import org.safe4i.usf.model.transformation.StringLiteral;
import org.safe4i.usf.model.transformation.Transformation;
import org.safe4i.usf.model.transformation.TransformationPackage;
import org.safe4i.usf.model.transformation.TypeBasedParameter;
import org.safe4i.usf.model.transformation.TypeBasedTransformationType;
import org.safe4i.usf.model.transformation.TypedMemberCallExpression;
import org.safe4i.usf.model.transformation.VariableDeclaration;
import org.safe4i.usf.transformation.language.services.USFLanguageGrammarAccess;

@SuppressWarnings("all")
public class USFLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private USFLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == TransformationPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case TransformationPackage.AND_BOOLEAN_EXPRESSION:
				sequence_AndBooleanExpression(context, (AndBooleanExpression) semanticObject); 
				return; 
			case TransformationPackage.ASSIGNMENT_EXPRESSION:
				sequence_AssignmentExpression(context, (AssignmentExpression) semanticObject); 
				return; 
			case TransformationPackage.BOOLEAN_LITERAL:
				sequence_BooleanLiteral(context, (BooleanLiteral) semanticObject); 
				return; 
			case TransformationPackage.BOOLEAN_NEGATION_EXPRESSION:
				sequence_BooleanNegationExpression(context, (BooleanNegationExpression) semanticObject); 
				return; 
			case TransformationPackage.COMPARISON_BOOLEAN_EXPRESSION:
				sequence_ComparisonBooleanExpression(context, (ComparisonBooleanExpression) semanticObject); 
				return; 
			case TransformationPackage.CONCATENATION_EXPRESSION:
				sequence_ConcatenationExpression(context, (ConcatenationExpression) semanticObject); 
				return; 
			case TransformationPackage.ECLASS_BASED_PARAMETER:
				sequence_EClassBasedParameter(context, (EClassBasedParameter) semanticObject); 
				return; 
			case TransformationPackage.ECLASS_BASED_TRANSFORMATION_TYPE:
				sequence_EClassBasedTransformationType(context, (EClassBasedTransformationType) semanticObject); 
				return; 
			case TransformationPackage.FEATURE_CALL_EXPRESSION:
				sequence_FeatureCallExpression(context, (FeatureCallExpression) semanticObject); 
				return; 
			case TransformationPackage.FOR_LOOP_EXPRESSION:
				sequence_ForLoopExpression(context, (ForLoopExpression) semanticObject); 
				return; 
			case TransformationPackage.IF_EXPRESSION:
				sequence_IfExpression(context, (IFExpression) semanticObject); 
				return; 
			case TransformationPackage.LIST_BASED_PARAMETER:
				sequence_ListBasedParameter(context, (ListBasedParameter) semanticObject); 
				return; 
			case TransformationPackage.LIST_BASED_TRANSFORMATION_TYPE:
				sequence_ListBasedTransformationType(context, (ListBasedTransformationType) semanticObject); 
				return; 
			case TransformationPackage.NULL_LITERAL:
				sequence_NullLiteral(context, (NullLiteral) semanticObject); 
				return; 
			case TransformationPackage.NUMBER_LITERAL:
				sequence_NumberLiteral(context, (NumberLiteral) semanticObject); 
				return; 
			case TransformationPackage.OPERATION_CALL_EXPRESSION:
				sequence_OperationCallExpression(context, (OperationCallExpression) semanticObject); 
				return; 
			case TransformationPackage.OR_BOOLEAN_EXPRESSION:
				sequence_OrBooleanExpression(context, (OrBooleanExpression) semanticObject); 
				return; 
			case TransformationPackage.PORT_DIRECTION_LITERAL:
				sequence_PortDirectionLiteral(context, (PortDirectionLiteral) semanticObject); 
				return; 
			case TransformationPackage.STRING_LITERAL:
				sequence_StringLiteral(context, (StringLiteral) semanticObject); 
				return; 
			case TransformationPackage.TRANSFORMATION:
				sequence_Transformation(context, (Transformation) semanticObject); 
				return; 
			case TransformationPackage.TYPE_BASED_PARAMETER:
				sequence_TypeBasedParameter(context, (TypeBasedParameter) semanticObject); 
				return; 
			case TransformationPackage.TYPE_BASED_TRANSFORMATION_TYPE:
				sequence_TypeBasedTransformationType(context, (TypeBasedTransformationType) semanticObject); 
				return; 
			case TransformationPackage.TYPED_MEMBER_CALL_EXPRESSION:
				sequence_TypedMemberCallExpression(context, (TypedMemberCallExpression) semanticObject); 
				return; 
			case TransformationPackage.VARIABLE_DECLARATION:
				sequence_VariableDeclaration(context, (VariableDeclaration) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     BooleanExpression returns AndBooleanExpression
	 *     OrBooleanExpression returns AndBooleanExpression
	 *     OrBooleanExpression.OrBooleanExpression_1_0_0 returns AndBooleanExpression
	 *     AndBooleanExpression returns AndBooleanExpression
	 *     AndBooleanExpression.AndBooleanExpression_1_0_0 returns AndBooleanExpression
	 *
	 * Constraint:
	 *     (left=AndBooleanExpression_AndBooleanExpression_1_0_0 right=ComparisonBooleanExpression)
	 */
	protected void sequence_AndBooleanExpression(ISerializationContext context, AndBooleanExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TransformationPackage.Literals.AND_BOOLEAN_EXPRESSION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransformationPackage.Literals.AND_BOOLEAN_EXPRESSION__LEFT));
			if (transientValues.isValueTransient(semanticObject, TransformationPackage.Literals.AND_BOOLEAN_EXPRESSION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransformationPackage.Literals.AND_BOOLEAN_EXPRESSION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAndBooleanExpressionAccess().getAndBooleanExpressionLeftAction_1_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAndBooleanExpressionAccess().getRightComparisonBooleanExpressionParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns AssignmentExpression
	 *     AssignmentOrVariableDeclaration returns AssignmentExpression
	 *     AssignmentExpression returns AssignmentExpression
	 *     Atomic returns AssignmentExpression
	 *
	 * Constraint:
	 *     (typeMember=[VariableDeclaration|ID] value=Expression)
	 */
	protected void sequence_AssignmentExpression(ISerializationContext context, AssignmentExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TransformationPackage.Literals.ASSIGNMENT_EXPRESSION__TYPE_MEMBER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransformationPackage.Literals.ASSIGNMENT_EXPRESSION__TYPE_MEMBER));
			if (transientValues.isValueTransient(semanticObject, TransformationPackage.Literals.ASSIGNMENT_EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransformationPackage.Literals.ASSIGNMENT_EXPRESSION__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAssignmentExpressionAccess().getTypeMemberVariableDeclarationIDTerminalRuleCall_1_0_1(), semanticObject.eGet(TransformationPackage.Literals.ASSIGNMENT_EXPRESSION__TYPE_MEMBER, false));
		feeder.accept(grammarAccess.getAssignmentExpressionAccess().getValueExpressionParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns BooleanLiteral
	 *     BooleanLiteral returns BooleanLiteral
	 *     Atomic returns BooleanLiteral
	 *
	 * Constraint:
	 *     isTrue?='true'?
	 */
	protected void sequence_BooleanLiteral(ISerializationContext context, BooleanLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     BooleanExpression returns BooleanNegationExpression
	 *     OrBooleanExpression returns BooleanNegationExpression
	 *     OrBooleanExpression.OrBooleanExpression_1_0_0 returns BooleanNegationExpression
	 *     AndBooleanExpression returns BooleanNegationExpression
	 *     AndBooleanExpression.AndBooleanExpression_1_0_0 returns BooleanNegationExpression
	 *     ComparisonBooleanExpression returns BooleanNegationExpression
	 *     ComparisonBooleanExpression.ComparisonBooleanExpression_1_0 returns BooleanNegationExpression
	 *     BooleanNegationExpression returns BooleanNegationExpression
	 *
	 * Constraint:
	 *     (isNegate?='!'? expression=Atomic)
	 */
	protected void sequence_BooleanNegationExpression(ISerializationContext context, BooleanNegationExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     BooleanExpression returns ComparisonBooleanExpression
	 *     OrBooleanExpression returns ComparisonBooleanExpression
	 *     OrBooleanExpression.OrBooleanExpression_1_0_0 returns ComparisonBooleanExpression
	 *     AndBooleanExpression returns ComparisonBooleanExpression
	 *     AndBooleanExpression.AndBooleanExpression_1_0_0 returns ComparisonBooleanExpression
	 *     ComparisonBooleanExpression returns ComparisonBooleanExpression
	 *     ComparisonBooleanExpression.ComparisonBooleanExpression_1_0 returns ComparisonBooleanExpression
	 *
	 * Constraint:
	 *     (
	 *         left=ComparisonBooleanExpression_ComparisonBooleanExpression_1_0 
	 *         (
	 *             operator='<' | 
	 *             operator='<=' | 
	 *             operator='==' | 
	 *             operator='>=' | 
	 *             operator='>' | 
	 *             operator='!='
	 *         ) 
	 *         right=BooleanNegationExpression
	 *     )
	 */
	protected void sequence_ComparisonBooleanExpression(ISerializationContext context, ComparisonBooleanExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns ConcatenationExpression
	 *     ConcatenationExpression returns ConcatenationExpression
	 *     ConcatenationExpression.ConcatenationExpression_1_0 returns ConcatenationExpression
	 *     Atomic returns ConcatenationExpression
	 *
	 * Constraint:
	 *     (left=ConcatenationExpression_ConcatenationExpression_1_0 right=Primary)
	 */
	protected void sequence_ConcatenationExpression(ISerializationContext context, ConcatenationExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TransformationPackage.Literals.CONCATENATION_EXPRESSION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransformationPackage.Literals.CONCATENATION_EXPRESSION__LEFT));
			if (transientValues.isValueTransient(semanticObject, TransformationPackage.Literals.CONCATENATION_EXPRESSION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransformationPackage.Literals.CONCATENATION_EXPRESSION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getConcatenationExpressionAccess().getConcatenationExpressionLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getConcatenationExpressionAccess().getRightPrimaryParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Parameter returns EClassBasedParameter
	 *     EClassBasedParameter returns EClassBasedParameter
	 *
	 * Constraint:
	 *     (name=ID type=[EClass|ID])
	 */
	protected void sequence_EClassBasedParameter(ISerializationContext context, EClassBasedParameter semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CommonsPackage.Literals.NAMED_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonsPackage.Literals.NAMED_ELEMENT__NAME));
			if (transientValues.isValueTransient(semanticObject, TransformationPackage.Literals.ECLASS_BASED_PARAMETER__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransformationPackage.Literals.ECLASS_BASED_PARAMETER__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEClassBasedParameterAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getEClassBasedParameterAccess().getTypeEClassIDTerminalRuleCall_3_0_1(), semanticObject.eGet(TransformationPackage.Literals.ECLASS_BASED_PARAMETER__TYPE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TransformationType returns EClassBasedTransformationType
	 *     EClassBasedTransformationType returns EClassBasedTransformationType
	 *
	 * Constraint:
	 *     type=[EClass|ID]
	 */
	protected void sequence_EClassBasedTransformationType(ISerializationContext context, EClassBasedTransformationType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TransformationPackage.Literals.ECLASS_BASED_TRANSFORMATION_TYPE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransformationPackage.Literals.ECLASS_BASED_TRANSFORMATION_TYPE__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEClassBasedTransformationTypeAccess().getTypeEClassIDTerminalRuleCall_1_0_1(), semanticObject.eGet(TransformationPackage.Literals.ECLASS_BASED_TRANSFORMATION_TYPE__TYPE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns FeatureCallExpression
	 *     ConcatenationExpression returns FeatureCallExpression
	 *     ConcatenationExpression.ConcatenationExpression_1_0 returns FeatureCallExpression
	 *     Primary returns FeatureCallExpression
	 *     FeatureCallExpression returns FeatureCallExpression
	 *     Atomic returns FeatureCallExpression
	 *
	 * Constraint:
	 *     (context=[TypedMember|ID] structuralFeature=[ETypedElement|ID] (parameterValues+=Expression parameterValues+=Expression*)?)
	 */
	protected void sequence_FeatureCallExpression(ISerializationContext context, FeatureCallExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns ForLoopExpression
	 *     ForLoopExpression returns ForLoopExpression
	 *     Atomic returns ForLoopExpression
	 *
	 * Constraint:
	 *     (declaredParam=Parameter forExpression=Expression eachExpression+=Expression*)
	 */
	protected void sequence_ForLoopExpression(ISerializationContext context, ForLoopExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns IFExpression
	 *     IfExpression returns IFExpression
	 *     Atomic returns IFExpression
	 *
	 * Constraint:
	 *     (condition=BooleanExpression then+=Expression* else+=Expression*)
	 */
	protected void sequence_IfExpression(ISerializationContext context, IFExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Parameter returns ListBasedParameter
	 *     ListBasedParameter returns ListBasedParameter
	 *
	 * Constraint:
	 *     (name=ID type=[EClass|ID])
	 */
	protected void sequence_ListBasedParameter(ISerializationContext context, ListBasedParameter semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CommonsPackage.Literals.NAMED_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonsPackage.Literals.NAMED_ELEMENT__NAME));
			if (transientValues.isValueTransient(semanticObject, TransformationPackage.Literals.GENERIC_LIST_TYPE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransformationPackage.Literals.GENERIC_LIST_TYPE__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getListBasedParameterAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getListBasedParameterAccess().getTypeEClassIDTerminalRuleCall_5_0_1(), semanticObject.eGet(TransformationPackage.Literals.GENERIC_LIST_TYPE__TYPE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TransformationType returns ListBasedTransformationType
	 *     ListBasedTransformationType returns ListBasedTransformationType
	 *
	 * Constraint:
	 *     type=[EClass|ID]
	 */
	protected void sequence_ListBasedTransformationType(ISerializationContext context, ListBasedTransformationType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TransformationPackage.Literals.GENERIC_LIST_TYPE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransformationPackage.Literals.GENERIC_LIST_TYPE__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getListBasedTransformationTypeAccess().getTypeEClassIDTerminalRuleCall_3_0_1(), semanticObject.eGet(TransformationPackage.Literals.GENERIC_LIST_TYPE__TYPE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns NullLiteral
	 *     NullLiteral returns NullLiteral
	 *     Atomic returns NullLiteral
	 *
	 * Constraint:
	 *     {NullLiteral}
	 */
	protected void sequence_NullLiteral(ISerializationContext context, NullLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns NumberLiteral
	 *     ConcatenationExpression returns NumberLiteral
	 *     ConcatenationExpression.ConcatenationExpression_1_0 returns NumberLiteral
	 *     Primary returns NumberLiteral
	 *     NumberLiteral returns NumberLiteral
	 *     Atomic returns NumberLiteral
	 *
	 * Constraint:
	 *     value=Number
	 */
	protected void sequence_NumberLiteral(ISerializationContext context, NumberLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TransformationPackage.Literals.NUMBER_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransformationPackage.Literals.NUMBER_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNumberLiteralAccess().getValueNumberParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns OperationCallExpression
	 *     ConcatenationExpression returns OperationCallExpression
	 *     ConcatenationExpression.ConcatenationExpression_1_0 returns OperationCallExpression
	 *     Primary returns OperationCallExpression
	 *     OperationCallExpression returns OperationCallExpression
	 *     Atomic returns OperationCallExpression
	 *
	 * Constraint:
	 *     (operation=[EOperation|ID] (parameterValues+=Expression parameterValues+=Expression*)?)
	 */
	protected void sequence_OperationCallExpression(ISerializationContext context, OperationCallExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     BooleanExpression returns OrBooleanExpression
	 *     OrBooleanExpression returns OrBooleanExpression
	 *     OrBooleanExpression.OrBooleanExpression_1_0_0 returns OrBooleanExpression
	 *
	 * Constraint:
	 *     (left=OrBooleanExpression_OrBooleanExpression_1_0_0 right=AndBooleanExpression)
	 */
	protected void sequence_OrBooleanExpression(ISerializationContext context, OrBooleanExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TransformationPackage.Literals.OR_BOOLEAN_EXPRESSION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransformationPackage.Literals.OR_BOOLEAN_EXPRESSION__LEFT));
			if (transientValues.isValueTransient(semanticObject, TransformationPackage.Literals.OR_BOOLEAN_EXPRESSION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransformationPackage.Literals.OR_BOOLEAN_EXPRESSION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOrBooleanExpressionAccess().getOrBooleanExpressionLeftAction_1_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getOrBooleanExpressionAccess().getRightAndBooleanExpressionParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns PortDirectionLiteral
	 *     ConcatenationExpression returns PortDirectionLiteral
	 *     ConcatenationExpression.ConcatenationExpression_1_0 returns PortDirectionLiteral
	 *     Primary returns PortDirectionLiteral
	 *     PortDirectionLiteral returns PortDirectionLiteral
	 *     Atomic returns PortDirectionLiteral
	 *
	 * Constraint:
	 *     direction=PortDirection
	 */
	protected void sequence_PortDirectionLiteral(ISerializationContext context, PortDirectionLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TransformationPackage.Literals.PORT_DIRECTION_LITERAL__DIRECTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransformationPackage.Literals.PORT_DIRECTION_LITERAL__DIRECTION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPortDirectionLiteralAccess().getDirectionPortDirectionEnumRuleCall_1_0(), semanticObject.getDirection());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns StringLiteral
	 *     ConcatenationExpression returns StringLiteral
	 *     ConcatenationExpression.ConcatenationExpression_1_0 returns StringLiteral
	 *     Primary returns StringLiteral
	 *     StringLiteral returns StringLiteral
	 *     Atomic returns StringLiteral
	 *
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_StringLiteral(ISerializationContext context, StringLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TransformationPackage.Literals.STRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransformationPackage.Literals.STRING_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Transformation returns Transformation
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (parameters+=Parameter parameters+=Parameter*)? 
	 *         type=TransformationType? 
	 *         preconditions+=Expression* 
	 *         content+=Expression* 
	 *         output=Expression?
	 *     )
	 */
	protected void sequence_Transformation(ISerializationContext context, Transformation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Parameter returns TypeBasedParameter
	 *     TypeBasedParameter returns TypeBasedParameter
	 *
	 * Constraint:
	 *     (name=ID type=TransformationTypes)
	 */
	protected void sequence_TypeBasedParameter(ISerializationContext context, TypeBasedParameter semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CommonsPackage.Literals.NAMED_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonsPackage.Literals.NAMED_ELEMENT__NAME));
			if (transientValues.isValueTransient(semanticObject, TransformationPackage.Literals.TYPE_BASED_PARAMETER__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransformationPackage.Literals.TYPE_BASED_PARAMETER__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTypeBasedParameterAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getTypeBasedParameterAccess().getTypeTransformationTypesEnumRuleCall_3_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TransformationType returns TypeBasedTransformationType
	 *     TypeBasedTransformationType returns TypeBasedTransformationType
	 *
	 * Constraint:
	 *     type=TransformationTypes
	 */
	protected void sequence_TypeBasedTransformationType(ISerializationContext context, TypeBasedTransformationType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TransformationPackage.Literals.TYPE_BASED_TRANSFORMATION_TYPE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransformationPackage.Literals.TYPE_BASED_TRANSFORMATION_TYPE__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTypeBasedTransformationTypeAccess().getTypeTransformationTypesEnumRuleCall_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns TypedMemberCallExpression
	 *     ConcatenationExpression returns TypedMemberCallExpression
	 *     ConcatenationExpression.ConcatenationExpression_1_0 returns TypedMemberCallExpression
	 *     Primary returns TypedMemberCallExpression
	 *     TypedMemberCallExpression returns TypedMemberCallExpression
	 *     Atomic returns TypedMemberCallExpression
	 *
	 * Constraint:
	 *     typeMember=[TypedMember|ID]
	 */
	protected void sequence_TypedMemberCallExpression(ISerializationContext context, TypedMemberCallExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TransformationPackage.Literals.TYPED_MEMBER_CALL_EXPRESSION__TYPE_MEMBER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransformationPackage.Literals.TYPED_MEMBER_CALL_EXPRESSION__TYPE_MEMBER));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTypedMemberCallExpressionAccess().getTypeMemberTypedMemberIDTerminalRuleCall_1_0_1(), semanticObject.eGet(TransformationPackage.Literals.TYPED_MEMBER_CALL_EXPRESSION__TYPE_MEMBER, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns VariableDeclaration
	 *     AssignmentOrVariableDeclaration returns VariableDeclaration
	 *     VariableDeclaration returns VariableDeclaration
	 *     Atomic returns VariableDeclaration
	 *
	 * Constraint:
	 *     (writeable?='var'? ((type=TransformationType name=ID) | name=ID) rhs=Expression?)
	 */
	protected void sequence_VariableDeclaration(ISerializationContext context, VariableDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
