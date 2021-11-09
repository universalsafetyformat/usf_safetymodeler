/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.transformation.language.scoping

import com.google.inject.Inject
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.safe4i.usf.core.usfmodel.block.BlocksPackage
import org.safe4i.usf.core.usfmodel.common.CommonsPackage
import org.safe4i.usf.core.usfmodel.controlFlow.ControlFlowsPackage
import org.safe4i.usf.model.transformation.EClassBasedParameter
import org.safe4i.usf.model.transformation.EClassBasedTransformationType
import org.safe4i.usf.model.transformation.FeatureCallExpression
import org.safe4i.usf.model.transformation.ListBasedParameter
import org.safe4i.usf.model.transformation.TransformationPackage
import org.safe4i.usf.model.transformation.TypeBasedParameter
import org.safe4i.usf.model.transformation.TypeBasedTransformationType
import org.safe4i.usf.model.transformation.VariableDeclaration
import org.safe4i.usf.transformation.language.utils.USFTypeReferenceHelper

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class USFLanguageScopeProvider extends AbstractUSFLanguageScopeProvider {
	
	@Inject extension USFTypeReferenceHelper
	

	override getScope(EObject context, EReference reference) {
		if (reference == TransformationPackage.eINSTANCE.EClassBasedParameter_Type ||
			reference == TransformationPackage.eINSTANCE.EClassBasedTransformationType_Type ||
			reference == TransformationPackage.eINSTANCE.genericListType_Type) {

			val candidates = newArrayList
			candidates.addAll(BlocksPackage.eINSTANCE.EClassifiers.filter(e| e instanceof EClass))
			candidates.addAll(ControlFlowsPackage.eINSTANCE.EClassifiers.filter(e| e instanceof EClass))
			candidates.addAll(CommonsPackage.eINSTANCE.EClassifiers.filter(e| e instanceof EClass))
			candidates.addAll(EcorePackage.eINSTANCE.EClassifiers.filter(e| e instanceof EClass))
			return Scopes.scopeFor(candidates)

		}

		if (reference == TransformationPackage.eINSTANCE.operationCallExpression_Operation) {

			val candidates = newArrayList
			candidates.addAll(TransformationPackage.eINSTANCE.transformationUtils.EOperations)
			return Scopes.scopeFor(candidates)
		}

		if (reference == TransformationPackage.eINSTANCE.featureCallExpression_StructuralFeature) {

			if (context instanceof FeatureCallExpression) {
				val typedMember = context.context

				if (typedMember instanceof TypeBasedParameter) {
					// A "Type" has no attributes/references
				} else if (typedMember instanceof EClassBasedParameter) {
					val candidates = newArrayList
					candidates.addAll(typedMember.type.EAllAttributes)
					candidates.addAll(typedMember.type.EAllReferences)
					candidates.addAll(typedMember.type.EAllOperations)
					return Scopes.scopeFor(candidates)
				} else if (typedMember instanceof ListBasedParameter) {
					val candidates = newArrayList
					candidates.addAll(TransformationPackage.eINSTANCE.genericListType.EAllOperations)
					return Scopes.scopeFor(candidates)
				} else if (typedMember instanceof VariableDeclaration) {
					val transformationType = typedMember.type
					// we need to return scope from rhs expression if transformationType is not giving
					if(transformationType === null){
						val type = typedMember.varType
						return type.scope
					}
					
					if (transformationType instanceof EClassBasedTransformationType) {
						val candidates = newArrayList
						candidates.addAll(transformationType.type.EAllAttributes)
						candidates.addAll(transformationType.type.EAllReferences)
						candidates.addAll(transformationType.type.EAllOperations)
						return Scopes.scopeFor(candidates)
					} else if (transformationType instanceof TypeBasedTransformationType) {
						// A "Type" has no attributes/references
					}
				}

			}
		}

		super.getScope(context, reference)
	}
	
	
	def IScope getScope(Object object) {
		if (object instanceof EDataType) {
			val candidates = newArrayList
			candidates.addAll(object.eClass.EAllAttributes)
			candidates.addAll(object.eClass.EAllReferences)
			candidates.addAll(object.eClass.EAllOperations)
			return Scopes.scopeFor(candidates)
		}
		if (object instanceof EClass) {
			val candidates = newArrayList
			candidates.addAll(object.EAllAttributes)
			candidates.addAll(object.EAllReferences)
			candidates.addAll(object.EAllOperations)
			return Scopes.scopeFor(candidates)
		}

		if (object instanceof EObject) {
			val candidates = newArrayList
			candidates.addAll(object.eClass.EAllAttributes)
			candidates.addAll(object.eClass.EAllReferences)
			candidates.addAll(object.eClass.EAllOperations)
			return Scopes.scopeFor(candidates)
		}
	}
	
	
	

}
