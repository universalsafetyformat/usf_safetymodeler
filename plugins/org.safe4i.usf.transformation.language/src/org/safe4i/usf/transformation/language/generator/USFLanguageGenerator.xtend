/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.transformation.language.generator

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.codegen.util.ImportManager
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.safe4i.usf.core.usfmodel.block.PortDirection
import org.safe4i.usf.model.transformation.AndBooleanExpression
import org.safe4i.usf.model.transformation.AssignmentExpression
import org.safe4i.usf.model.transformation.BooleanLiteral
import org.safe4i.usf.model.transformation.BooleanNegationExpression
import org.safe4i.usf.model.transformation.ComparisonBooleanExpression
import org.safe4i.usf.model.transformation.ConcatenationExpression
import org.safe4i.usf.model.transformation.EClassBasedParameter
import org.safe4i.usf.model.transformation.EClassBasedTransformationType
import org.safe4i.usf.model.transformation.Expression
import org.safe4i.usf.model.transformation.FeatureCallExpression
import org.safe4i.usf.model.transformation.ForLoopExpression
import org.safe4i.usf.model.transformation.IFExpression
import org.safe4i.usf.model.transformation.ListBasedParameter
import org.safe4i.usf.model.transformation.ListBasedTransformationType
import org.safe4i.usf.model.transformation.NullLiteral
import org.safe4i.usf.model.transformation.NumberLiteral
import org.safe4i.usf.model.transformation.OperationCallExpression
import org.safe4i.usf.model.transformation.OrBooleanExpression
import org.safe4i.usf.model.transformation.Parameter
import org.safe4i.usf.model.transformation.PortDirectionLiteral
import org.safe4i.usf.model.transformation.StringLiteral
import org.safe4i.usf.model.transformation.Transformation
import org.safe4i.usf.model.transformation.TransformationFactory
import org.safe4i.usf.model.transformation.TransformationType
import org.safe4i.usf.model.transformation.TypeBasedParameter
import org.safe4i.usf.model.transformation.TypeBasedTransformationType
import org.safe4i.usf.model.transformation.TypedMember
import org.safe4i.usf.model.transformation.TypedMemberCallExpression
import org.safe4i.usf.model.transformation.VariableDeclaration
import org.safe4i.usf.transformation.language.utils.USFQualifiedNameProvider
import org.safe4i.usf.transformation.language.utils.USFTypeReferenceHelper

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class USFLanguageGenerator extends AbstractGenerator {

	@Inject extension USFQualifiedNameProvider
	@Inject extension USFTypeReferenceHelper

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val tramsform = resource.allContents.toIterable.filter(Transformation)
		for (t : tramsform) {
			fsa.generateFile(
				"org/safe4i/transformations/generated/" + t.name.toLowerCase + "/" + t.name.toFirstUpper + ".java",
				t.compile
			)
		}
	}

	private def compile(Transformation t) {

		val className = t.name.toFirstUpper
		val importManager = new ImportManager("package org.safe4i.transformations.generated", className)

		val body = t.body(importManager)
		importManager.addImport(TransformationFactory.canonicalName)

		val content = '''
package org.safe4i.transformations.generated.«t.name.toLowerCase»;

«importManager.computeSortedImports»

public class «className»{
	

«body»

}
'''
		return content
	}

	def body(Transformation t, ImportManager importManager) '''



public String preConditionChecks(«FOR arg : t.parameters SEPARATOR ","»«arg.compile(importManager)» «ENDFOR»){
	«FOR exp : t.preconditions»  
	
	if(!«exp.compile(importManager)») {
		String message = "The precondiction check of '«exp.getOPName»' with arguments '«exp.getArguments(importManager)»' failed";
		return message;
	}
	«ENDFOR»
	
	return null;
}

public void performTransformation(«FOR arg : t.parameters SEPARATOR ","»«arg.compile(importManager)» «ENDFOR»){
	«FOR exp : t.content»  
	
	«exp.compile(importManager)»«IF !(exp instanceof ForLoopExpression) && !(exp instanceof IFExpression)»;«ENDIF»
	«ENDFOR»
}


'''

	private def String getArguments(Expression expression, ImportManager importManager) {
		var builder = new StringBuilder

		if (expression instanceof OperationCallExpression) {
			val lastIndex = expression.parameterValues.size - 1
			for (var i = 0; i < expression.parameterValues.size; i++) {
				val arg = expression.parameterValues.get(i)

				if (arg instanceof StringLiteral) {
					builder.append(arg.value)
				} else {
					builder.append(arg.compile(importManager))
				}
				if (i !== lastIndex) {
					builder.append(", ")
				}
			}
			return builder.toString
		}

		if (expression instanceof FeatureCallExpression) {
			val lastIndex = expression.parameterValues.size - 1
			for (var i = 0; i < expression.parameterValues.size; i++) {
				val arg = expression.parameterValues.get(i)
				if (arg instanceof StringLiteral) {
					builder.append(arg.value)
				} else {
					builder.append(arg.compile(importManager))
				}
				if (i !== lastIndex) {
					builder.append(", ")
				}
			}
			return builder.toString
		}

	}

	private def String getGetOPName(Expression expression) {
		if (expression instanceof OperationCallExpression) {
			return expression.operation.name
		}

		if (expression instanceof FeatureCallExpression) {
			if (expression.structuralFeature instanceof EOperation) {
				return expression.structuralFeature.name
			}
		}
	}

	private def compile(Parameter p, ImportManager importManager) {
		return p.getParameterType(importManager) + " " + p.name
	}

// Check for different instances of Expression and call the appropriate compile method
	private def String compile(Expression exp, ImportManager importManager) {
		if (exp instanceof OperationCallExpression) {
			return exp.compile(importManager)
		}

		if (exp instanceof VariableDeclaration) {
			return exp.compile(importManager)
		}

		if (exp instanceof FeatureCallExpression) {
			return exp.compile(importManager)
		}

		if (exp instanceof ConcatenationExpression) {
			return exp.compile(importManager)
		}

		if (exp instanceof TypedMemberCallExpression) {
			return exp.compile(importManager)
		}

		if (exp instanceof StringLiteral) {
			return exp.compile(importManager)
		}

		if (exp instanceof NumberLiteral) {
			return exp.compile(importManager)
		}

		if (exp instanceof NullLiteral) {
			return exp.compile(importManager)
		}

		if (exp instanceof ForLoopExpression) {
			return exp.compile(importManager)
		}

		if (exp instanceof IFExpression) {
			return exp.compile(importManager)
		}

		if (exp instanceof BooleanLiteral) {
			return exp.compile(importManager)
		}

		if (exp instanceof OrBooleanExpression) {
			return exp.compile(importManager)
		}

		if (exp instanceof AndBooleanExpression) {
			return exp.compile(importManager)
		}

		if (exp instanceof ComparisonBooleanExpression) {
			return exp.compile(importManager)
		}

		if (exp instanceof BooleanNegationExpression) {
			return exp.compile(importManager)
		}
	
		if (exp instanceof PortDirectionLiteral) {
			return exp.compile(importManager)
		}
		
		if (exp instanceof AssignmentExpression) {
			return exp.compile(importManager)
		}
	}
	
	
	private def compile(AssignmentExpression assignment, ImportManager importManager){
		val builder = new StringBuilder
		builder.append(assignment.typeMember.typedMemberName)
		builder.append(" ")
		builder.append("=")
		builder.append(" ")
		builder.append(assignment.value.compile(importManager))
		return builder.toString
	}
	
	
	private def compile(PortDirectionLiteral portDirectionLiteral, ImportManager importManager){
		val builder = new StringBuilder
		builder.append(importManager.getImportedName(PortDirection.canonicalName, true))
		builder.append(".")
		builder.append(portDirectionLiteral.direction)
		return builder.toString
	}

	private def compile(OrBooleanExpression orExp, ImportManager importManager) {
		val builder = new StringBuilder
		builder.append(orExp.right.compile(importManager))
		if (orExp.left !== null) {
			builder.append(" ")
			builder.append("||")
			builder.append(" ")
			builder.append(orExp.left.compile(importManager))
		}
		return builder.toString
	}

	private def compile(AndBooleanExpression andExp, ImportManager importManager) {
		val builder = new StringBuilder
		builder.append(andExp.right.compile(importManager))
		if (andExp.left !== null) {
			builder.append(" ")
			builder.append("&&")
			builder.append(" ")
			builder.append(andExp.left.compile(importManager))
		}
		return builder.toString
	}

	private def compile(ComparisonBooleanExpression campExp, ImportManager importManager) {
		val builder = new StringBuilder

		switch campExp.operator {
			case "==":
				if ((campExp.right.type === EcorePackage.Literals.ESTRING &&
					campExp.left.type === EcorePackage.Literals.ESTRING) || (campExp.right.type instanceof EClass &&
					campExp.left.type instanceof EClass)) {
					builder.append(
						campExp.right.transformComparisonBooleanExpressionToEquals(campExp.left, importManager))
				} else {
					builder.append(campExp.right.compile(importManager))
					builder.append(" ")
					builder.append(campExp.operator)
					builder.append(" ")
					builder.append(campExp.left.compile(importManager))
				}
			case "!=":
				if ((campExp.right.type === EcorePackage.Literals.ESTRING &&
					campExp.left.type === EcorePackage.Literals.ESTRING) || (campExp.right.type instanceof EClass &&
					campExp.left.type instanceof EClass)) {
					builder.append("!")
					builder.append("(")
					builder.append(
						campExp.right.transformComparisonBooleanExpressionToEquals(campExp.left, importManager))
					builder.append(")")
				} else {
					builder.append(campExp.right.compile(importManager))
					builder.append(" ")
					builder.append(campExp.operator)
					builder.append(" ")
					builder.append(campExp.left.compile(importManager))
				}
			default: {
				builder.append(campExp.right.compile(importManager))
				builder.append(" ")
				builder.append(campExp.operator)
				builder.append(" ")
				builder.append(campExp.left.compile(importManager))
			}
		}

		return builder.toString
	}

	private def String transformComparisonBooleanExpressionToEquals(Expression right, Expression left,
		ImportManager importManager) {
		val builder = new StringBuilder
		builder.append(right.compile(importManager))
		builder.append(".equals(")
		builder.append(left.compile(importManager))
		builder.append(")")
		return builder.toString
	}

	private def compile(BooleanNegationExpression bolNegateExp, ImportManager importManager) {
		val builder = new StringBuilder

		if (bolNegateExp.isIsNegate) {
			builder.append("!")
		}
		builder.append(bolNegateExp.expression.compile(importManager))
		return builder.toString
	}

	private def String compile(IFExpression ifexp, ImportManager importManager) {
		val builder = new StringBuilder
		builder.append("if(")
		builder.append(ifexp.condition.compile(importManager))
		builder.append(")")
		builder.append("{")
		builder.append("\n")
		for (thenexpr : ifexp.then) {
			if (thenexpr instanceof IFExpression) {
				builder.append(thenexpr.compile(importManager))
			} else {
				builder.append(thenexpr.compile(importManager))
				builder.append(";")
				builder.append("\n")
			}
		}
		builder.append("\n")
		builder.append("}")

		if (ifexp.^else !== null) {

			builder.append("else {")
			builder.append("\n")
			for (elseExpr : ifexp.^else) {
				builder.append(elseExpr.compile(importManager))
				builder.append(";")
				builder.append("\n")
			}
			builder.append("}")
			builder.append("\n")

		}
		return builder.toString
	}

	private def compile(ForLoopExpression forLoopexpr, ImportManager importManager) {
		val builder = new StringBuilder
		builder.append("for")
		builder.append("( ")
		builder.append(forLoopexpr.declaredParam.compile(importManager))
		builder.append(" ")
		builder.append(":")
		builder.append(" ")
		builder.append(forLoopexpr.forExpression.compile(importManager))
		
//		if (forLoopexpr.forExpression instanceof TypedMemberCallExpression) {
//			var typemember = (forLoopexpr.forExpression as TypedMemberCallExpression).typeMember
//
//			if (typemember instanceof VariableDeclaration) {
//				builder.append(typemember.name)
//			}
//			if (typemember instanceof ListBasedParameter) {
//				builder.append(typemember.name)
//			}
//		}
//
//		if (forLoopexpr.forExpression instanceof FeatureCallExpression) {
//			var structuralType = (forLoopexpr.forExpression as FeatureCallExpression).structuralFeature
//			var typemember = (forLoopexpr.forExpression as FeatureCallExpression).context
//
//			if (typemember instanceof VariableDeclaration) {
//				builder.append(typemember.name)
//			}
//
//			if (typemember instanceof EClassBasedParameter) {
//				builder.append(typemember.name)
//			}
//
//			if (typemember instanceof TypeBasedParameter) {
//				builder.append(typemember.name)
//			}
//
//			builder.append(".")
//			builder.append("get")
//			builder.append(structuralType.name.toFirstUpper)
//			builder.append("()")
//		}

		builder.append(")")
		builder.append("{")
		builder.append("\n")
		for (exp : forLoopexpr.eachExpression) {
			builder.append(exp.compile(importManager))
			if (!(exp instanceof IFExpression)) {
				builder.append(";")
			}
		}
		builder.append("\n")
		builder.append("}")
		return builder.toString
	}

	private def compile(OperationCallExpression opexp, ImportManager importManager) {
		val builder = new StringBuilder
		builder.append("TransformationFactory.eINSTANCE.create")
		builder.append((opexp.operation.eContainer as EClass).name)
		builder.append("()")
		builder.append(".")
		builder.append(opexp.operation.name)
		builder.append("(")
		builder.append(opexp.listOperationCallExpressionArguments(importManager))
		builder.append(")")
		return builder.toString
	}

	private def listOperationCallExpressionArguments(OperationCallExpression opexp, ImportManager importManager) {
		var builder = new StringConcatenation
		val index_of_lastObject = opexp.parameterValues.size - 1
		for (var i = 0; i < opexp.parameterValues.size; i++) {
			val value = opexp.parameterValues.get(i).compile(importManager)
			builder.append(value)
			if (i !== index_of_lastObject) {
				builder.append(",")
			}
		}
		builder.toString
	}

	private def compile(VariableDeclaration varexp, ImportManager importManager) {
		if (!varexp.writeable) {
			return "final " + varexp.vardeclType(importManager) + " " + varexp.name + " = " +
				varexp.rhs.compile(importManager)
		} else {
			return varexp.vardeclType(importManager) + " " + varexp.name + " = " + varexp.rhs.compile(importManager)
		}
	}

	private def compile(FeatureCallExpression feaexp, ImportManager importManager) {
		if (feaexp.context instanceof Parameter) {
			return (feaexp.context as Parameter).name + feaexp.getStructuralType(importManager)
		} else if (feaexp.context instanceof VariableDeclaration) {
			return (feaexp.context as VariableDeclaration).name + feaexp.getStructuralType(importManager)
		}
	}

	private def String getStructuralType(FeatureCallExpression feaexp, ImportManager importManager) {
		if (feaexp.structuralFeature instanceof EAttribute || feaexp.structuralFeature instanceof EReference) {
			return ".get" + feaexp.structuralFeature.name.toFirstUpper + "()"
		} 
		
		if (feaexp.structuralFeature instanceof EOperation) {
			val eop = (feaexp.structuralFeature as EOperation)
			return "." + eop.name + "(" + feaexp.listFeatureCallExpressionArguments(importManager) + ")"
		}
	}

	private def listFeatureCallExpressionArguments(FeatureCallExpression feaexp, ImportManager importManager) {
		if (feaexp.parameterValues.isEmpty) {
			return ""
		}
		var builder = new StringConcatenation
		val index_of_lastObject = feaexp.parameterValues.size - 1
		for (var i = 0; i < feaexp.parameterValues.size; i++) {
			val value = feaexp.parameterValues.get(i).compile(importManager)
			builder.append(value)
			if (i !== index_of_lastObject) {
				builder.append(",")
			}
		}
		builder.toString
	}

	private def compile(ConcatenationExpression concatexp, ImportManager importManager) {
		val builder = new StringConcatenation
		builder.append(concatexp.left.compile(importManager) + "+" + concatexp.right.compile(importManager))
		return builder.toString
	}

	private def compile(TypedMemberCallExpression typeexp, ImportManager importManager) {
		if (typeexp.typeMember instanceof Parameter) {
			return (typeexp.typeMember as Parameter).name
		} else if (typeexp.typeMember instanceof VariableDeclaration) {
			return (typeexp.typeMember as VariableDeclaration).name
		}
	}

	private def compile(StringLiteral strexp, ImportManager importManager) {
		return '"' + strexp.value + '"'
	}

	private def compile(NumberLiteral numberLiteral, ImportManager importManager) {
		return "" + numberLiteral.value + ""
	}

	private def compile(NullLiteral nullLiteral, ImportManager importManager) {
		return "null"
	}

	private def compile(BooleanLiteral boolLiteral, ImportManager importManager) {
		if (boolLiteral.isIsTrue) {
			return "true";
		}
		return "false"
	}

// Check for different instances of Expression and call the appropriate type method
	private def String getType(Expression exp, ImportManager importManager) {
		if (exp instanceof OperationCallExpression) {
			return exp.getOperationCallExpressionType(importManager)
		}
		if (exp instanceof VariableDeclaration) {
			return exp.rhs.getType(importManager)
		}
		if (exp instanceof FeatureCallExpression) {
			return exp.getFeatureCallExpressionType(importManager)
		}
		if (exp instanceof ConcatenationExpression) {
			return exp.getConcatenationExpressionType(importManager)
		}
		if (exp instanceof TypedMemberCallExpression) {
			return exp.getTypedMemberCallExpressionType(importManager)
		}
		if (exp instanceof StringLiteral) {
			return exp.getStringLiteralType(importManager)
		}
		if (exp instanceof BooleanLiteral) {
			return exp.getBooleanLiteralType(importManager)
		}

		if (exp instanceof NumberLiteral) {
			return exp.getNumberLiteralType(importManager)
		}
		
		if (exp instanceof PortDirectionLiteral) {
			return exp.getPortDirectionLiteralType(importManager)
		}
	}
	
	private def getPortDirectionLiteralType(PortDirectionLiteral portDirectionlit, ImportManager importManager){
		return importManager.getImportedName(PortDirection.canonicalName, true)
	}

	private def getBooleanLiteralType(BooleanLiteral booleanType, ImportManager importManager) {
		return importManager.getImportedName(boolean.canonicalName, true)
	}
	

	private def getNumberLiteralType(NumberLiteral numberType, ImportManager importManager) {
		return importManager.getImportedName(int.canonicalName, true)
	}

	private def getOperationCallExpressionType(OperationCallExpression opType, ImportManager importManager) {
		return importManager.getImportedName((opType.operation.EType as EClass).fullyQualifiedName, true)
	}

	private def getFeatureCallExpressionType(FeatureCallExpression feaType, ImportManager importManager) {
		if (feaType.structuralFeature instanceof EAttribute || feaType.structuralFeature instanceof EReference) {
			if (feaType.structuralFeature.isMany) {
				importManager.addImport(List.canonicalName)
				return "List<" +
					importManager.getImportedName(feaType.structuralFeature.EType.instanceClassName, true) + ">";
			}
			return importManager.getImportedName(feaType.structuralFeature.EType.instanceClassName, true)
		}

		if (feaType.structuralFeature instanceof EOperation) {
			val eop = (feaType.structuralFeature as EOperation)
			if (eop.isMany) {
				importManager.addImport(List.canonicalName)
				if (eop.EType instanceof EDataType) {
					return "List<"+importManager.getImportedName(eop.EType.instanceClassName, true) + ">";
				}
				return "List<"+importManager.getImportedName((eop.EType as EClass).fullyQualifiedName, true) + ">";
			}

			if (eop.EType instanceof EDataType) {
				return importManager.getImportedName(eop.EType.instanceClassName, true)
			} 
				
			return importManager.getImportedName((eop.EType as EClass).fullyQualifiedName, true)
			
		}
	}

	private def getConcatenationExpressionType(ConcatenationExpression concatType, ImportManager importManager) {
		return importManager.getImportedName(String.canonicalName, true)
	}

	private def getTypedMemberCallExpressionType(TypedMemberCallExpression typememnerType,
		ImportManager importManager) {
		return typememnerType.typeMember.getTypedMemberType(importManager)
	}

	private def getStringLiteralType(StringLiteral strtype, ImportManager importManager) {
		return importManager.getImportedName(String.canonicalName, true)
	}

	private def String vardeclType(VariableDeclaration vardeclType, ImportManager importManager) {
		if (vardeclType.type !== null) {
			return (vardeclType.type as TransformationType).getTransformationTypeType(importManager)
		} else {
			return vardeclType.rhs.getType(importManager)
		}
	}

// Check for different instances of Parameter and call the appropriate type method
	private def String getParameterType(Parameter p, ImportManager importManager) {
		if (p instanceof TypeBasedParameter) {
			return importManager.getImportedName((p as TypeBasedParameter).type.literal, true)
		} else if (p instanceof EClassBasedParameter) {
			return importManager.getImportedName((p as EClassBasedParameter).type.fullyQualifiedName, true)
		} else if (p instanceof ListBasedParameter) {
			val param = (p as ListBasedParameter)
			val type = (param.type as EClass)
			importManager.addImport(List.canonicalName)
			return "List<" + importManager.getImportedName(type.fullyQualifiedName, true) + ">"
		}
	}

// Check for different instances of TransformationType and call the appropriate type method
	private def getTransformationTypeType(TransformationType transType, ImportManager importManager) {
		if (transType instanceof EClassBasedTransformationType) {
			return importManager.getImportedName((transType as EClassBasedTransformationType).type.fullyQualifiedName,
				true)
		} else if (transType instanceof TypeBasedTransformationType) {
			return importManager.getImportedName((transType as TypeBasedTransformationType).type.literal, true)
		} else if (transType instanceof ListBasedTransformationType) {
			val listType = (transType as ListBasedTransformationType)
			val type = (listType.type as EClass)
			importManager.addImport(List.canonicalName)
			return "List<" + importManager.getImportedName(type.fullyQualifiedName, true) + ">"
		}
	}

// Check for different instances of TypedMember and call the appropriate type method
	private def getTypedMemberType(TypedMember typemember, ImportManager importManager) {
		if (typemember instanceof Parameter) {
			(typemember as Parameter).getParameterType(importManager)
		} else if (typemember instanceof VariableDeclaration) {
			val vardecl = (typemember as VariableDeclaration)
			if (vardecl.type !== null) {
				vardecl.type.getTransformationTypeType(importManager)
			} else {
				vardecl.rhs.getType(importManager)
			}
		}
	}
	
	
	private def getTypedMemberName(TypedMember typemember) {
		if (typemember instanceof Parameter) {
			return (typemember as Parameter).name
		}
		
		if (typemember instanceof VariableDeclaration) {
			return (typemember as VariableDeclaration).name
		}
	}

}
