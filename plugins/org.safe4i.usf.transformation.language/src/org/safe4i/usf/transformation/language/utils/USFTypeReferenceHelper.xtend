/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
 package org.safe4i.usf.transformation.language.utils

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EcorePackage
import org.safe4i.usf.core.usfmodel.block.BlocksPackage
import org.safe4i.usf.model.transformation.BooleanLiteral
import org.safe4i.usf.model.transformation.BooleanNegationExpression
import org.safe4i.usf.model.transformation.ConcatenationExpression
import org.safe4i.usf.model.transformation.EClassBasedParameter
import org.safe4i.usf.model.transformation.EClassBasedTransformationType
import org.safe4i.usf.model.transformation.Expression
import org.safe4i.usf.model.transformation.FeatureCallExpression
import org.safe4i.usf.model.transformation.GenericListType
import org.safe4i.usf.model.transformation.ListType
import org.safe4i.usf.model.transformation.NullLiteral
import org.safe4i.usf.model.transformation.NumberLiteral
import org.safe4i.usf.model.transformation.OperationCallExpression
import org.safe4i.usf.model.transformation.PortDirectionLiteral
import org.safe4i.usf.model.transformation.StringLiteral
import org.safe4i.usf.model.transformation.TypeBasedParameter
import org.safe4i.usf.model.transformation.TypeBasedTransformationType
import org.safe4i.usf.model.transformation.TypedMemberCallExpression
import org.safe4i.usf.model.transformation.VariableDeclaration

class USFTypeReferenceHelper {

	def Object getType(Expression expression) {

		if (expression instanceof TypedMemberCallExpression) {
			return expression.getTypeMemberCallExpressionType
		}

		if (expression instanceof OperationCallExpression) {
			return expression.getOperationCallType
		}

		if (expression instanceof StringLiteral) {
			return expression.getStringType
		}

		if (expression instanceof NumberLiteral) {
			return expression.getNumberType
		}

		if (expression instanceof BooleanLiteral) {
			return expression.getBooleanType
		}

		if (expression instanceof NullLiteral) {
			return expression.getNullType
		}

		if (expression instanceof ConcatenationExpression) {
			return expression.getConcatenationType
		}

		if (expression instanceof FeatureCallExpression) {
			return expression.getFeatureCallType
		}

		if (expression instanceof VariableDeclaration) {
			return expression.getVarType
		}

		if (expression instanceof ListType) {
			return expression.getListType
		}

		if (expression instanceof BooleanNegationExpression) {
			return expression.getBooleanNegationType
		}

		if (expression instanceof PortDirectionLiteral) {
			return expression.getPortDirectionLiteralType
		}

	}

	def getBooleanNegationType(BooleanNegationExpression boolExp) {
		return boolExp.expression.type
	}

	def getTypeMemberCallExpressionType(TypedMemberCallExpression typeMemberexp) {
		val typemenber = typeMemberexp.typeMember
		if (typemenber instanceof TypeBasedParameter) {
			return (typemenber as TypeBasedParameter).type
		} else if (typemenber instanceof EClassBasedParameter) {
			return (typemenber as EClassBasedParameter).type
		} else if (typemenber instanceof VariableDeclaration) {
			return (typemenber as VariableDeclaration).getVarType
		} else if (typemenber instanceof ListType) {
			return typemenber.getListType
		}
	}

	def getVarType(VariableDeclaration vardecl) {
		if (vardecl.type === null) {
			return vardecl.rhs.getType
		} else if (vardecl.type instanceof EClassBasedTransformationType) {
			return (vardecl.type as EClassBasedTransformationType).type
		} else if (vardecl.type instanceof TypeBasedTransformationType) {
			return (vardecl.type as TypeBasedTransformationType).type
		}
	}
	

	def getConcatenationType(ConcatenationExpression concat) {
		return EcorePackage.Literals.ESTRING
	}

	def getOperationCallType(OperationCallExpression opexpress) {
		return opexpress.operation.EType
	}

	def getStringType(StringLiteral stringLiteral) {
		return EcorePackage.Literals.ESTRING
	}

	def getFeatureCallType(FeatureCallExpression featureCallExpression) {
		return featureCallExpression.structuralFeature.EType
	}

	def getNumberType(NumberLiteral numberLiteral) {
		return EcorePackage.Literals.EINT
	}

	def getBooleanType(BooleanLiteral booleanLiteral) {
		return EcorePackage.Literals.EBOOLEAN
	}

	def getPortDirectionLiteralType(PortDirectionLiteral portDirection) {
		return BlocksPackage.Literals.PORT_DIRECTION
	}

	def getNullType(NullLiteral nullLiteral) {
		return null
	}
	

	def getListType(ListType listType) {
		return (listType as GenericListType).type
	}
	
	def String nameOfType(Object object) {
		if (object instanceof EDataType) {
			return (object as EDataType).name
		}
		if (object instanceof EClass) {
			return (object as EClass).name
		}

		if (object instanceof EObject) {
			return (object as EObject).eClass.name
		}
		
		if(object instanceof EEnum){
			return (object as EEnum).name
		}
	}


	// Testing to see if returning the structureFeature of a FeatureExpression will be enough to support all validation.
	def getExpressionDataTypes(Expression expression) {

		if (expression instanceof TypedMemberCallExpression) {
			return expression.getTypeMemberCallExpressionType
		}

		if (expression instanceof OperationCallExpression) {
			return expression.getOperationCallType
		}

		if (expression instanceof StringLiteral) {
			return expression.getStringType
		}

		if (expression instanceof NumberLiteral) {
			return expression.getNumberType
		}

		if (expression instanceof BooleanLiteral) {
			return expression.getBooleanType
		}

		if (expression instanceof NullLiteral) {
			return expression.getNullType
		}

		if (expression instanceof ConcatenationExpression) {
			return expression.getConcatenationType
		}

		if (expression instanceof FeatureCallExpression) {
			return expression.getFeatureCallExpressionType
		}

		if (expression instanceof VariableDeclaration) {
			return expression.getVarType
		}

		if (expression instanceof ListType) {
			return expression.getListType
		}

		if (expression instanceof BooleanNegationExpression) {
			return expression.getBooleanNegationType
		}
		
		if (expression instanceof PortDirectionLiteral) {
			return expression.getPortDirectionLiteralType
		}
	}

	def getFeatureCallExpressionType(FeatureCallExpression featureCallExpression) {
		return featureCallExpression.structuralFeature
	}

	def getVariableDeclarationExpressionType(VariableDeclaration vardecl) {
		if (vardecl.type === null) {
			return vardecl.rhs.expressionDataTypes
		} else if (vardecl.type instanceof EClassBasedTransformationType) {
			return (vardecl.type as EClassBasedTransformationType).type
		} else if (vardecl.type instanceof TypeBasedTransformationType) {
			return (vardecl.type as TypeBasedTransformationType).type
		}
	}

}
