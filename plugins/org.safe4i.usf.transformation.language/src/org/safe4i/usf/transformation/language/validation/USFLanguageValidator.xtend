/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.transformation.language.validation

import com.google.inject.Inject
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.xtext.validation.Check
import org.safe4i.usf.model.transformation.AndBooleanExpression
import org.safe4i.usf.model.transformation.AssignmentExpression
import org.safe4i.usf.model.transformation.BooleanNegationExpression
import org.safe4i.usf.model.transformation.ComparisonBooleanExpression
import org.safe4i.usf.model.transformation.EClassBasedParameter
import org.safe4i.usf.model.transformation.EClassBasedTransformationType
import org.safe4i.usf.model.transformation.FeatureCallExpression
import org.safe4i.usf.model.transformation.ForLoopExpression
import org.safe4i.usf.model.transformation.GenericListType
import org.safe4i.usf.model.transformation.IFExpression
import org.safe4i.usf.model.transformation.ListBasedParameter
import org.safe4i.usf.model.transformation.ListType
import org.safe4i.usf.model.transformation.NullLiteral
import org.safe4i.usf.model.transformation.OperationCallExpression
import org.safe4i.usf.model.transformation.OrBooleanExpression
import org.safe4i.usf.model.transformation.Transformation
import org.safe4i.usf.model.transformation.TypeBasedParameter
import org.safe4i.usf.model.transformation.TypeBasedTransformationType
import org.safe4i.usf.model.transformation.TypedMember
import org.safe4i.usf.model.transformation.TypedMemberCallExpression
import org.safe4i.usf.model.transformation.VariableDeclaration
import org.safe4i.usf.transformation.language.utils.USFTypeReferenceHelper

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class USFLanguageValidator extends AbstractUSFLanguageValidator {

	val errorMessage = "The operation %s(%s) in the type %s is not applicable for the arguments (%s)"
	val typeMismatchError = "Type mismatch: cannot convert from element type %s to %s"
	val incompatibleError = "Incompatible operand types %s and %s"
	val operatorError = "The operator %s is undefined for the argument type(s) %s, %s"

	@Inject extension USFTypeReferenceHelper

	@Check(FAST)
	def checkTransformation(Transformation transformation) {

		for (precodition : transformation.preconditions) {
			if (precodition instanceof IFExpression) {
				val message = "IFExpression is not allowed in preconditions"
				error(message, null)
			}
		}

	}

	@Check(FAST)
	def checkAssignmentExpression(AssignmentExpression assignmentexp) {
		val typeMember = assignmentexp.typeMember
		if (typeMember instanceof VariableDeclaration) {
			if (!typeMember.writeable) {
				val message = "Assignment to a final variable is not allowed"
				error(message, null)
				return
			}
			val variableType = typeMember.varType
			val assignmentType = assignmentexp.value.type
			if (!variableType.checkTypeEquality(assignmentType)) {
				val message = String.format(typeMismatchError, variableType.nameOfType, assignmentType.nameOfType)
				error(message, null)
				return
			}
			return
		}
		
		if(!(typeMember instanceof VariableDeclaration)){
				val message = "Assignment to a non variable type is not allowed"
				error(message, null)
			return 
		}
	}
	
	
	def getConcrateTypeMembertype(TypedMember typedMember){
		
		if(typedMember instanceof TypeBasedParameter){
			return typedMember.type
		}
		
		if(typedMember instanceof EClassBasedParameter){
			return typedMember.type
		}
		
		if(typedMember instanceof ListBasedParameter){
			return typedMember.type
		}
		
	}
	

	@Check(FAST)
	def checkIfExpression(IFExpression ifexp) {

		if (ifexp.condition === null) {
			val message = "The condition of the if expression can not be empty"
			error(message, null)
			return
		}

		if (!(ifexp.condition instanceof BooleanNegationExpression) &&
			!(ifexp.condition instanceof AndBooleanExpression) && !(ifexp.condition instanceof OrBooleanExpression) &&
			!(ifexp.condition instanceof ComparisonBooleanExpression)) {
			val message = "The condition of the if expression is not a boolean operation"
			error(message, null)
			return
		}

		if (ifexp.condition instanceof BooleanNegationExpression) {
			val type = ifexp.condition.type
			if (type === null) {
				val message = String.format(typeMismatchError, "null", "boolean")
				error(message, null)
			}

			if (type !== EcorePackage.Literals.EBOOLEAN) {
				val message = String.format(typeMismatchError, type.nameOfType, "boolean")
				error(message, null)
			}

			return
		}

		if (ifexp.condition instanceof AndBooleanExpression) {

			val rightexpressType = (ifexp.condition as AndBooleanExpression).right.type
			val leftexpressType = (ifexp.condition as AndBooleanExpression).left.type

			if (rightexpressType !== EcorePackage.Literals.EBOOLEAN &&
				leftexpressType !== EcorePackage.Literals.EBOOLEAN) {
				val message = "&& cannot be resolve "
				error(message, null)
			}

			if (rightexpressType === EcorePackage.Literals.EBOOLEAN &&
				leftexpressType !== EcorePackage.Literals.EBOOLEAN) {
				val message = String.format(operatorError, "&&", rightexpressType.nameOfType,
					leftexpressType.nameOfType)
				error(message, null)
			}

			if (rightexpressType !== EcorePackage.Literals.EBOOLEAN &&
				leftexpressType === EcorePackage.Literals.EBOOLEAN) {
				val message = String.format(operatorError, "&&", leftexpressType.nameOfType,
					rightexpressType.nameOfType)
				error(message, null)
			}
			return
		}

		if (ifexp.condition instanceof OrBooleanExpression) {

			val rightexpressType = (ifexp.condition as OrBooleanExpression).right.type
			val leftexpressType = (ifexp.condition as OrBooleanExpression).left.type

			if (rightexpressType !== EcorePackage.Literals.EBOOLEAN &&
				leftexpressType !== EcorePackage.Literals.EBOOLEAN) {
				val message = "|| cannot be resolve "
				error(message, null)
			}

			if (rightexpressType === EcorePackage.Literals.EBOOLEAN &&
				leftexpressType !== EcorePackage.Literals.EBOOLEAN) {
				val message = String.format(operatorError, "||", rightexpressType.nameOfType,
					leftexpressType.nameOfType)
				error(message, null)
			}

			if (rightexpressType !== EcorePackage.Literals.EBOOLEAN &&
				leftexpressType === EcorePackage.Literals.EBOOLEAN) {
				val message = String.format(operatorError, "||", leftexpressType.nameOfType,
					rightexpressType.nameOfType)
				error(message, null)
			}
			return
		}

		if (ifexp.condition instanceof ComparisonBooleanExpression) {

			val comparisionExpre = (ifexp.condition as ComparisonBooleanExpression)

			if ((comparisionExpre.right as BooleanNegationExpression).expression instanceof NullLiteral ||
				(comparisionExpre.left as BooleanNegationExpression).expression instanceof NullLiteral) {
				return
			}

			val rightexpressType = comparisionExpre.right.type
			val leftexpressType = comparisionExpre.left.type

			// if both right and left expressions are from Type EClass skip 
			// since we are comparing objects  
			if (rightexpressType instanceof EClass && leftexpressType instanceof EClass) {
				return
			}

			if (rightexpressType != leftexpressType) {
				val message = String.format(incompatibleError, rightexpressType.nameOfType, leftexpressType.nameOfType)
				error(message, null)
				return
			}
			return
		}

	}

	@Check(FAST)
	def checkInputParameter(OperationCallExpression opExpress) {
		val eop = opExpress.operation
		if (eop.EParameters.size != opExpress.parameterValues.size) {
			val message = String.format(errorMessage, eop.name, eop.formatedOperatorParameters,
				eop.EContainingClass.name, opExpress.formatedOperatorArguments);
			error(message, null)
			return
		}
		if (eop.name.equals("log")) {
			return
		}
		eop.checkArguments(opExpress)
	}

	@Check(FAST)
	def checkInputParameter(FeatureCallExpression featureCallExpression) {
		if (featureCallExpression.structuralFeature instanceof EOperation) {
			val eop = (featureCallExpression.structuralFeature as EOperation)
			if (eop.name.equals("add")) {
				return
			}
			if (eop.EParameters.size != featureCallExpression.parameterValues.size) {
				val message = String.format(errorMessage, eop.name, eop.formatedOperatorParameters,
					eop.EContainingClass.name, featureCallExpression.formatedOperatorArguments);
				error(message, null)
				return
			}
			eop.checkArguments(featureCallExpression)
		}
	}

	@Check(FAST)
	def checkVariableDeclaration(VariableDeclaration variableDeclaration) {

		if (variableDeclaration.type === null && variableDeclaration.rhs instanceof NullLiteral) {
			val message = 'Assignment of null without specifying the variable Type is not allowed'
			error(message, null)
			return
		}

		if (variableDeclaration.type !== null && variableDeclaration.type instanceof EClassBasedTransformationType) {
			val declaredType = (variableDeclaration.type as EClassBasedTransformationType).type
			val rhstype = (variableDeclaration.rhs.type as EClass)
			if (!declaredType.isSuperTypeOf(rhstype)) {
				val message = String.format(typeMismatchError, declaredType.name, rhstype.name)
				error(message, null)
				return
			}
		}

		if (variableDeclaration.type !== null && variableDeclaration.type instanceof TypeBasedTransformationType) {
			val declaredType = (variableDeclaration.type as TypeBasedTransformationType).type
			val rhstype = variableDeclaration.rhs.type
			if (declaredType !== rhstype) {
				val message = String.format(typeMismatchError, declaredType.literal, rhstype.nameOfType)
				error(message, null)
				return
			}
		}

		if (variableDeclaration.type !== null && variableDeclaration.type instanceof ListType) {
			val declaredType = (variableDeclaration.type as GenericListType).type
			val rhstype = variableDeclaration.rhs.type
			if (declaredType !== rhstype) {
				val message = String.format(typeMismatchError, declaredType.name, rhstype.nameOfType)
				error(message, null)
				return
			}
		}
	}

	@Check(FAST)
	def checkForLoopExpression(ForLoopExpression forLoopExpression) {
		var declaredParamn = forLoopExpression.declaredParam
		var forExpression = forLoopExpression.forExpression

		if (forExpression instanceof TypedMemberCallExpression) {
			var typemember = forExpression.typeMember

			if (!(typemember instanceof ListBasedParameter) && !(typemember instanceof VariableDeclaration)) {
				val message = "The type " + typemember.eClass.name + " is not application for this operation"
				error(message, null)
				return
			}

			if (typemember instanceof ListBasedParameter) {
				var listType = (typemember as GenericListType).type

				if (declaredParamn instanceof EClassBasedParameter) {
					var type = (declaredParamn as EClassBasedParameter).type
					if (!type.isSuperTypeOf(listType)) {
						val message = String.format(typeMismatchError, type.name, listType.name)
						error(message, null)
						return
					}
				}

				// Not possible for TypeBasedParameter even before the refactoring this was limited to a handfull of types defined in USFLanguage.xtext
				// if (declaredParamn instanceof TypeBasedParameter) {
				// var type = (declaredParamn as TypeBasedParameter).type
				// if (!type.eClass.isSuperTypeOf(listType)) {
				// val message = String.format(typeMismatchError, type.name, listType.name)
				// error(message, null)
				// return
				// }
				// }
				return
			}

			if (typemember instanceof VariableDeclaration) {
				var variableDecType = typemember.variableDeclarationExpressionType

				if (variableDecType instanceof ETypedElement) {
					if (!variableDecType.isMany) {
						val message = String.format(typeMismatchError, variableDecType.EType.nameOfType, Iterable.name)
						error(message, null)
						return
					}

					if (declaredParamn instanceof EClassBasedParameter) {
						if (!(variableDecType.EType as EClass).isSuperTypeOf(declaredParamn.type)) {
							val message = String.format(typeMismatchError, variableDecType.EType.nameOfType,
								declaredParamn.type.name)
							error(message, null)
							return
						}
					}
					return
				}

				if (!(variableDecType instanceof ETypedElement)) {
					val message = String.format(typeMismatchError, variableDecType.nameOfType, Iterable.name)
					error(message, null)
					return
				}

				// Not possible for TypeBasedParameter even before the refactoring this was limited to a handfull of types defined in USFLanguage.xtext
				// if (declaredParamn instanceof TypeBasedParameter) {
				// var listType = (declaredParamn.type as GenericListType).type
				// var type = (declaredParamn as TypeBasedParameter).type
				// if (!type.eClass.isSuperTypeOf(listType)) {
				// val message = String.format(typeMismatchError, type.name, listType.name)
				// error(message, null)
				// return
				// }
				// }
				return

			}

			return

		}

		if (forExpression instanceof FeatureCallExpression) {
			var etype = forExpression.structuralFeature

			// A FeatureCallExpression can be a EAttribute or EReference and only a "many" EReference is valid in this case here ...
			// the other if s looks strange below 
			if (etype.many == false || !(etype instanceof ETypedElement)) {
				val message = String.format(typeMismatchError, etype.EType.name, Iterable.name)
				error(message, null)
				return
			}

			// Is this even possible?? see above
			if (etype.many != false && declaredParamn instanceof EClassBasedParameter) {
				var type = (declaredParamn as EClassBasedParameter).type
				if (!type.isSuperTypeOf((etype.EType as EClass))) {
					val message = String.format(typeMismatchError, type.name, (etype.EType as EClass).name)
					error(message, null)
					return
				}
			}
			// Is this even possible?? see above
			// if (etype.many != false && declaredParamn instanceof TypeBasedParameter) {
			// var type = (declaredParamn as TypeBasedParameter).type
			// if (!type.eClass.isSuperTypeOf((etype.EType as EClass))) {
			// val message = String.format(typeMismatchError, type.name, (etype.EType as EClass).name)
			// error(message, null)
			// return
			// }
			// }
			return
		}

		if (!(forExpression instanceof TypedMemberCallExpression) &&
			!(forExpression instanceof FeatureCallExpression)) {
			val message = "The type " + forExpression.eClass.name + " is not application for this operation"
			error(message, null)
			return
		}
	}

	def checkArguments(EOperation eop, FeatureCallExpression featureCallExpression) {
		for (var i = 0; i < eop.EParameters.size; i++) {
			val param = eop.EParameters.get(i).EType
			val argument = featureCallExpression.parameterValues.get(i).getType

			if (argument === null) {
				return
			}

			if (argument instanceof EClass) {
				val paramEclass = (param as EClass)
				if (!paramEclass.isSuperTypeOf(argument)) {

					val message = String.format(errorMessage, eop.name, eop.formatedOperatorParameters,
						eop.EContainingClass.name, featureCallExpression.formatedOperatorArguments)
					error(message, null)
				}
			} else {
				if (param != argument) {
					val message = String.format(errorMessage, eop.name, eop.formatedOperatorParameters,
						eop.EContainingClass.name, featureCallExpression.formatedOperatorArguments)
					error(message, null)
				}
			}
		}
	}

	def checkArguments(EOperation eop, OperationCallExpression opExpress) {
		for (var i = 0; i < eop.EParameters.size; i++) {
			val param = eop.EParameters.get(i).EType
			val argument = opExpress.parameterValues.get(i).getType

			if (argument === null) {
				return
			}

			if (argument instanceof EClass) {
				val paramEclass = (param as EClass)
				if (!paramEclass.isSuperTypeOf(argument)) {
					val message = String.format(errorMessage, eop.name, eop.formatedOperatorParameters,
						eop.EContainingClass.name, opExpress.formatedOperatorArguments)
					error(message, null)
				}
			} else {
				if (param != argument) {
					val message = String.format(errorMessage, eop.name, eop.formatedOperatorParameters,
						eop.EContainingClass.name, opExpress.formatedOperatorArguments)
					error(message, null)
				}
			}
		}
	}

	def String formatedOperatorArguments(FeatureCallExpression fcExpress) {
		val builder = new StringBuilder
		for (var i = 0; i < fcExpress.parameterValues.size; i++) {
			builder.append(fcExpress.parameterValues.get(i).type.nameOfType)
			if (i !== (fcExpress.parameterValues.size - 1)) {
				builder.append(",")
			}
		}
		return builder.toString
	}

	def String formatedOperatorArguments(OperationCallExpression opExpress) {
		val builder = new StringBuilder
		for (var i = 0; i < opExpress.parameterValues.size; i++) {
			builder.append(opExpress.parameterValues.get(i).type.nameOfType)
			if (i !== (opExpress.parameterValues.size - 1)) {
				builder.append(",")
			}
		}
		return builder.toString
	}

	def String formatedOperatorParameters(EOperation eop) {
		val builder = new StringBuilder
		for (var i = 0; i < eop.EParameters.size; i++) {
			builder.append(eop.EParameters.get(i).EType.name)
			if (i !== (eop.EParameters.size - 1)) {
				builder.append(",")
			}
		}
		return builder.toString
	}

	def boolean checkTypeEquality(Object type1, Object type2) {
		if (type1 instanceof EClass && type2 instanceof EClass) {
			return (type1 as EClass).isSuperTypeOf((type2 as EClass))
		}

		if (type1 instanceof EClass && !(type2 instanceof EClass)) {
			return false;
		}

		return (type1 != type2)
	}

}
