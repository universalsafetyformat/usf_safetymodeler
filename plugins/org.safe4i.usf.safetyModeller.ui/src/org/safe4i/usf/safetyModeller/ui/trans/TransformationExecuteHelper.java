/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.trans;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.codehaus.janino.SimpleCompiler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.safe4i.usf.core.usfmodel.block.Block;
import org.safe4i.usf.core.usfmodel.block.BlockType;
import org.safe4i.usf.core.usfmodel.block.Connection;
import org.safe4i.usf.core.usfmodel.block.Port;
import org.safe4i.usf.core.usfmodel.common.DomainType;
import org.safe4i.usf.core.usfmodel.common.Model;
import org.safe4i.usf.core.usfmodel.parameter.BlockParameterDefinition;
import org.safe4i.usf.core.usfmodel.parameter.BlockTypeParameterDefinition;
import org.safe4i.usf.core.usfmodel.parameter.ConnectionParameterDefinition;
import org.safe4i.usf.core.usfmodel.parameter.DomainTypeParameterDefinition;
import org.safe4i.usf.core.usfmodel.parameter.PortParameterDefinition;
import org.safe4i.usf.core.usfmodel.parameter.TransformationParameterDefinition;
import org.safe4i.usf.core.usfmodel.parameter.TransformationPrimitiveType;
import org.safe4i.usf.core.usfmodel.parameter.TransformationTypeParameterDefinition;
import org.safe4i.usf.core.usfmodel.parameter.TransformationTypeValue;
import org.safe4i.usf.core.usfmodel.safetyPattern.SafetyPattern;
import org.safe4i.usf.core.usfmodel.safetyPattern.SafetyPatternApplication;
import org.safe4i.usf.safetyModeller.ui.Activator;
import org.safe4i.usf.safetyModeller.ui.project.USFProjectSupport;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaParameter;

/**
 * @author Hamza
 *
 */

public enum TransformationExecuteHelper {
	INSTANCE;

	private final String fs = File.separator;
	private final String PACKAGE_PREFIX = "org" + fs + "safe4i" + fs + "transformations" + fs + "generated" + fs;
	private final String PRECONDITION_METHOD_NAME = "preConditionChecks";
	private final String TRANSFORMATION_METHOD_NAME = "performTransformation";

	public boolean transform(SafetyPatternApplication safetyPatternApplication, IProject project, ExecutionEvent event) throws Exception {
		final boolean done = true;

		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);

		final ProgressMonitorDialog progress = new ProgressMonitorDialog(window.getShell());

		progress.run(false, false, monitor -> {

			try {
				monitor.beginTask("Executing Transformation", IProgressMonitor.UNKNOWN);

				final Model modelCopy = makeModelCopy(safetyPatternApplication);
				final SafetyPatternApplication safetyPatternApplicationCopy = getSafetyPatternApplicationFromModel(modelCopy, safetyPatternApplication);

				final IFile javaFile = getTransformationJavaFile(safetyPatternApplication, project);
				final String fullJavaPath;

				if (javaFile == null) {
					MessageDialog.openInformation(window.getShell(), "Transformation Executor",
							"A corresponding Transformation file for the selected SafetyPatternApplication can not be found");
				} else {

					fullJavaPath = javaFile.getLocation().toPortableString();
					final String fullClassname = normalizeWithPackage(safetyPatternApplication);

					final SimpleCompiler compiler = new SimpleCompiler();
					compiler.setDebuggingInformation(true, true, true);
					compiler.cookFile(fullJavaPath);
					final ClassLoader loader = compiler.getClassLoader();
					final Class<?> transformationJavaClass = loader.loadClass(fullClassname);
					final Method precondiction = getMethodByName(transformationJavaClass, PRECONDITION_METHOD_NAME);
					final JavaMethod precondictionSource = getParsedMethodSource(javaFile.getRawLocation().makeAbsolute().toFile(), fullClassname);

					final Object[] safetyPatternApplicationArguments = getSafetyPatternApplicationArguments(safetyPatternApplicationCopy, precondictionSource,
							modelCopy);

					if (precondiction != null) {
						final String message = (String) precondiction.invoke(transformationJavaClass.getDeclaredConstructor().newInstance(),
								safetyPatternApplicationArguments);

						if (message == null) {
							final Method performTransformation = getMethodByName(transformationJavaClass, TRANSFORMATION_METHOD_NAME);
							performTransformation.invoke(transformationJavaClass.getDeclaredConstructor().newInstance(), safetyPatternApplicationArguments);
							saveTransformedModel(modelCopy, project, normalize(safetyPatternApplication.getType().getName()), monitor);

							final String doneMessage = "The SafetyPattern " + safetyPatternApplication.getType().getName()
									+ " has sucessfully been transformed";
							MessageDialog.openInformation(window.getShell(), "Transformation Executor", doneMessage);

						} else {
							MessageDialog.openError(window.getShell(), "Transformation Executor", message);
						}
					}
				}

			} catch (final Exception e) {
				Activator.getDefault().logError(e.getMessage(), e);
				MessageDialog.openError(window.getShell(), "Transformation Executor", "Transformation was not sucessfull");

			} finally {
				monitor.done();
			}

		});

		return done;
	}

	private JavaMethod getParsedMethodSource(File file, String fullClassname) throws IOException {
		final JavaProjectBuilder builder = new JavaProjectBuilder();
		builder.addSource(file);
		final JavaClass cls = builder.getClassByName(fullClassname);
		final JavaMethod method = getMethodOfParseJavaSourceByName(cls, PRECONDITION_METHOD_NAME);
		return method;
	}

	private SafetyPatternApplication getSafetyPatternApplicationFromModel(Model modelCopy, SafetyPatternApplication safetyPatternApplication) {
		SafetyPatternApplication copy = null;
		for (final Iterator<EObject> i = modelCopy.eAllContents(); i.hasNext();) {
			final EObject content = i.next();
			if (EcoreUtil.equals(content, safetyPatternApplication)) {
				copy = (SafetyPatternApplication) content;
			}
		}
		return copy;
	}

	private JavaMethod getMethodOfParseJavaSourceByName(JavaClass cls, String methodname) {
		for (final JavaMethod jm : cls.getMethods()) {
			if (jm.getName().equals(methodname)) {
				return jm;
			}
		}
		return null;
	}

	private Method getMethodByName(Class<?> clazz, String methodname) {
		for (final Method m : clazz.getDeclaredMethods()) {
			if (m.getName().equals(methodname)) {
				return m;
			}
		}
		return null;
	}

	private Model makeModelCopy(SafetyPatternApplication safetyPatternApplication) {
		Model t = (Model) safetyPatternApplication.eContainer();
		while (t.eContainer() != null) {
			t = (Model) t.eContainer();
		}
		final Model original = t;
		final Model copy = EcoreUtil.copy(original);
		return copy;
	}

	private void saveTransformedModel(Model model, IProject project, String fileName, IProgressMonitor monitor) throws CoreException {
		final IFolder save_modelFolder = project.getFolder(USFProjectSupport.SAVE_MODEL_FOLDER);
		final IFolder transformationFolder = save_modelFolder.getFolder(fileName);
		final String trasformedXmi = fileName + USFProjectSupport.MODEL_FILE_EXTENSION;

		if (transformationFolder.exists()) {
			final IFile modelFile = transformationFolder.getFile(trasformedXmi);
			saveFile(modelFile, model, monitor);
		} else {
			transformationFolder.create(false, true, monitor);
			final IFile modelFile = transformationFolder.getFile(trasformedXmi);
			saveFile(modelFile, model, monitor);
		}
	}

	private void saveFile(IFile modelFile, Model model, IProgressMonitor monitor) throws CoreException {
		if (modelFile.exists()) {
			saveModel(modelFile, model);
		} else {
			modelFile.create(null, true, monitor);
			saveModel(modelFile, model);
		}
	}

	protected void saveModel(IFile modelFile, Model model) {
		if (modelFile == null || modelFile.getLocationURI() == null) {
			return;
		}
		final String path = modelFile.getLocationURI().getPath();

		final ResourceSet resSet = new ResourceSetImpl();
		final Resource res = resSet.createResource(URI.createFileURI(path));
		res.getContents().clear();
		res.getContents().add(model);
		try {
			Activator.getDefault().getLog().log(new Status(IStatus.INFO, Activator.PLUGIN_ID, "Create Model File: " + path));
			res.save(null);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	private Object[] getSafetyPatternApplicationArguments(SafetyPatternApplication safetyPatternApplication, JavaMethod method, Model modelCopy)
			throws TransformationExecutionException {
		final List<Object> arguments = new ArrayList<>();
		final SafetyPattern pattern = safetyPatternApplication.getType();

		// going through the list of method parameter names
		for (final JavaParameter jp : method.getParameters()) {
			if (jp.getType().getValue().equals("Model")) {
				arguments.add(modelCopy);
				continue;
			}

			final TransformationParameterDefinition pd = getParameterDefinitionByName(pattern, jp.getName());

			if (pd != null) {
				final Object argument = getArguments(safetyPatternApplication, pd);
				arguments.add(argument);
			}
		}

		return arguments.toArray();
	}

	private TransformationParameterDefinition getParameterDefinitionByName(SafetyPattern pattern, String name) {
		for (final EObject e : pattern.eContents()) {
			if (e instanceof TransformationParameterDefinition && ((TransformationParameterDefinition) e).getName().equals(name)) {
				return (TransformationParameterDefinition) e;
			}
		}
		return null;
	}

	// first approach
	// private Object[] getSafetyPatternApplicationArguments(SafetyPatternApplication safetyPatternApplication, Model modelCopy)
	// throws TransformationExecutionException {
	// final List<Object> arguments = new ArrayList<>();
	// final SafetyPattern pattern = safetyPatternApplication.getType();
	//
	// // see TransformationFileHelper::getParameterList ... we need the same order here!
	// // ToBe solved in https://jira.scopeforge.de/browse/SAFE4I-128
	// for (final EObject e : pattern.eContents()) {
	// if (e instanceof ParameterDefinition) {
	// final Object argument = getArguments(safetyPatternApplication, (ParameterDefinition) e);
	// arguments.add(argument);
	// }
	// }
	//
	// // add model copy as the last argument
	// arguments.add(modelCopy);
	// return arguments.toArray();
	//
	// }

	private Object getArguments(SafetyPatternApplication safetyPatternApplication, TransformationParameterDefinition param)
			throws TransformationExecutionException {
		if (param instanceof BlockParameterDefinition) {
			return blockArguments(safetyPatternApplication, (BlockParameterDefinition) param);
		} else if (param instanceof BlockTypeParameterDefinition) {
			return blockTypeArguments(safetyPatternApplication, (BlockTypeParameterDefinition) param);
		} else if (param instanceof ConnectionParameterDefinition) {
			return connectionArguments(safetyPatternApplication, (ConnectionParameterDefinition) param);
		} else if (param instanceof PortParameterDefinition) {
			return portArguments(safetyPatternApplication, (PortParameterDefinition) param);
		} else if (param instanceof TransformationTypeParameterDefinition) {
			return primitiveArguments(safetyPatternApplication, (TransformationTypeParameterDefinition) param);
		} else if (param instanceof DomainTypeParameterDefinition) {
			return domainTypeArguments(safetyPatternApplication, (DomainTypeParameterDefinition) param);
		} else {
			throw new TransformationExecutionException("Unsupported ParameterDefinition Type");
		}
	}

	private Object domainTypeArguments(SafetyPatternApplication safetyPatternApplication, DomainTypeParameterDefinition param)
			throws TransformationExecutionException {

		final List<DomainType> type = safetyPatternApplication.getDomainTypeArguments().stream().filter(bp -> bp.getParameter().equals(param))
				.map(bp -> bp.getValue()).filter(Objects::nonNull).collect(Collectors.toList());

		if (type.size() == 0) {
			type.add(param.getDefaultValue());
		}

		if (type.size() == 1) {
			final Object value = type.get(0);
			return value;
		} else {
			throw new TransformationExecutionException("Multiple DomainTypeParameterValues for one TransformationTypeParameterDefinition are not allowed!");
		}

	}

	private Object primitiveArguments(SafetyPatternApplication safetyPatternApplication, TransformationTypeParameterDefinition param)
			throws TransformationExecutionException {

		final List<TransformationTypeValue> primitives = safetyPatternApplication.getTrafoTypeArguments().stream().filter(bp -> bp.getParameter().equals(param))
				.collect(Collectors.toList());

		if (primitives.size() == 1) {
			final Object value = getArgumentsPrimitiveParameterType(primitives.get(0), param);
			return value;
		} else {
			throw new TransformationExecutionException("Multiple TransformationTypeValues for one TransformationTypeParameterDefinition are not allowed!");
		}

	}

	private Object portArguments(SafetyPatternApplication safetyPatternApplication, PortParameterDefinition param) throws TransformationExecutionException {
		final ArrayList<Port> ports = (ArrayList<Port>) safetyPatternApplication.getPortParameterArguments().stream()
				.filter(bp -> bp.getParameter().equals(param)).map(bp -> bp.getValue()).collect(Collectors.toList());

		if (param.isMany()) {
			return ports;
		} else {
			if (ports.size() == 1) {
				return ports.get(0);
			} else {
				throw new TransformationExecutionException("Multiple Ports for a single value ParameterDefinition which is not allowed!");
			}
		}

	}

	private Object connectionArguments(SafetyPatternApplication safetyPatternApplication, ConnectionParameterDefinition param)
			throws TransformationExecutionException {
		final ArrayList<Connection> connections = (ArrayList<Connection>) safetyPatternApplication.getConnectionParameterArguments().stream()
				.filter(bp -> bp.getParameter().equals(param)).map(bp -> bp.getValue()).collect(Collectors.toList());

		if (param.isMany()) {
			return connections;
		} else {
			if (connections.size() == 1) {
				return connections.get(0);
			} else {
				throw new TransformationExecutionException("Multiple Connections for a single value ParameterDefinition which is not allowed!");
			}
		}
	}

	private Object blockTypeArguments(SafetyPatternApplication safetyPatternApplication, BlockTypeParameterDefinition param)
			throws TransformationExecutionException {
		final ArrayList<BlockType> blocktypes = (ArrayList<BlockType>) safetyPatternApplication.getBlockTypeParameterArguments().stream()
				.filter(bp -> bp.getParameter().equals(param)).map(bp -> bp.getValue()).collect(Collectors.toList());

		if (blocktypes.size() == 0) {
			blocktypes.add(param.getDefaultValue());
		}

		if (param.isMany()) {
			return blocktypes;
		} else {
			if (blocktypes.size() == 1) {
				return blocktypes.get(0);
			} else {
				throw new TransformationExecutionException("Multiple BlockTypes for a single value ParameterDefinition which is not allowed!");
			}
		}
	}

	private Object blockArguments(SafetyPatternApplication safetyPatternApplication, BlockParameterDefinition param) throws TransformationExecutionException {
		final ArrayList<Block> blocks = (ArrayList<Block>) safetyPatternApplication.getBlockParameterArguments().stream()
				.filter(bp -> bp.getParameter().equals(param)).map(bp -> bp.getValue()).collect(Collectors.toList());

		if (blocks.size() == 0) {
			blocks.add(param.getDefaultValue());
		}

		if (param.isMany()) {
			return blocks;
		} else {
			if (blocks.size() == 1) {
				return blocks.get(0);
			} else {
				throw new TransformationExecutionException("Multiple Blocks for a single value ParameterDefinition which is not allowed!");
			}
		}
	}

	private Object getArgumentsPrimitiveParameterType(TransformationTypeValue transformationTypeValue,
			TransformationTypeParameterDefinition transformationTypeParameterDefinition) {

		final TransformationPrimitiveType parameterType = transformationTypeParameterDefinition.getType();
		final String val = transformationTypeValue.getValue() != null ? transformationTypeValue.getValue()
				: transformationTypeParameterDefinition.getDefaultValue();

		switch (parameterType) {
		case BOOLEAN:
			return Boolean.valueOf(val);
		case FLOAT:
			return Float.valueOf(val);
		case INTEGER:
			return Integer.valueOf(val);
		case STRING:
			return val;
		case VOID:
			return null;
		}
		return null;
	}

	private String normalizeWithPackage(SafetyPatternApplication safetyPatternApplication) {
		final String safetyPatternName = normalize(safetyPatternApplication.getType().getName());
		final String full = PACKAGE_PREFIX + safetyPatternName.toLowerCase() + "." + safetyPatternName;
		return full.replace(fs, ".");
	}

	private IFile getTransformationJavaFile(SafetyPatternApplication safetyPatternApplication, IProject project) {

		final String packageFolderPath = USFProjectSupport.SRC_GEN_FOLDER + fs + PACKAGE_PREFIX
				+ normalize(safetyPatternApplication.getType().getName()).toLowerCase();
		final String javeFileName = normalize(safetyPatternApplication.getType().getName()) + ".java";
		final String fullPath = packageFolderPath + fs + javeFileName;
		final IFile javaFile = project.getFile(fullPath);
		if (javaFile.exists()) {
			return javaFile;
		}
		return null;
	}

	private String normalize(String tobeNormalize) {
		return tobeNormalize.replace(" ", "_");
	}

}
