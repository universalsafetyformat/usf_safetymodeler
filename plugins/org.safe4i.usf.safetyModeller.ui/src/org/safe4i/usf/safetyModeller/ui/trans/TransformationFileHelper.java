/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.trans;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.safe4i.usf.core.usfmodel.safetyPattern.SafetyPattern;
import org.safe4i.usf.safetyModeller.ui.Activator;
import org.safe4i.usf.safetyModeller.ui.project.USFProjectSupport;

public enum TransformationFileHelper {
	INSTANCE;

	private static String GEN_REGION_START = "/*START generated block*/";
	private static String GEN_REGION_END = "/*END generated block*/";
	private static final String TAB = "\t";
	private static final String NEWLINE = "\n";

	public IFile getOrCreateTransformationFile(SafetyPattern safetyPattern, IProject project, IProgressMonitor monitor) throws CoreException {
		final IFolder transformationFolder = project.getFolder(USFProjectSupport.TRANSFORMATION_FOLDER);

		final IFile modelFile = transformationFolder.getFile(safetyPattern.getName() + ".usft");
		if (!modelFile.exists()) {
			createModelFile(modelFile, safetyPattern, monitor);
		} else {
			updateHeader(modelFile, safetyPattern, monitor);
		}
		return modelFile;

	}

	void updateHeader(IFile modelFile, SafetyPattern safetyPattern, IProgressMonitor monitor) {
		// update header
		final StringBuilder builder = new StringBuilder();
		appendGeneratedHeader(safetyPattern, builder);

		try (Scanner scanner = new Scanner(new InputStreamReader(modelFile.getContents(), modelFile.getCharset()))) {
			boolean userRegion = false;
			while (scanner.hasNextLine()) {
				final String line = scanner.nextLine();
				if (line.startsWith(GEN_REGION_END)) {
					userRegion = true;
					continue;
				}
				if (!userRegion) {
					continue;
				}

				builder.append(line + "\n");
			}

			if (!userRegion) {
				Activator.getDefault().logError(
						"Invalid File content cannot update parameter list. Start Tag:" + GEN_REGION_START + "and End Tag:" + GEN_REGION_END + "is mising!",
						null);
			}

		} catch (final Exception e) {
			Activator.getDefault().logError("Cannot update Transformation Header", e);
			return;
		}

		final InputStream source = new ByteArrayInputStream(builder.toString().getBytes());
		try {
			modelFile.setContents(source, false, false, monitor);
		} catch (final CoreException e) {
			Activator.getDefault().logError("Failed to update file.", e);
		}

	}

	private void appendGeneratedHeader(SafetyPattern safetyPattern, final StringBuilder builder) {
		builder.append(GEN_REGION_START + "\n");
		builder.append(getDocumentation(safetyPattern));
		builder.append("transform ").append(normalizeName(safetyPattern.getName()));
		builder.append("(\n").append(getParameterList(safetyPattern)).append(TAB).append(") : void {\n");
		builder.append(GEN_REGION_END + "\n");
	}

	void createModelFile(IFile modelFile, SafetyPattern safetyPattern, IProgressMonitor monitor) throws CoreException {
		final String content = getFileContent(safetyPattern);

		final InputStream source = new ByteArrayInputStream(content.getBytes());
		modelFile.create(source, false, monitor);
	}

	private String getFileContent(SafetyPattern safetyPattern) {
		final StringBuilder builder = new StringBuilder();
		appendGeneratedHeader(safetyPattern, builder);
		builder.append("PRECONDITION\n\n");
		builder.append("	// add checks here\n\n");
		builder.append("RULES\n\n");
		builder.append("	// add implementation here\n\n");
		builder.append("RETURN\n");
		builder.append("	model\n");
		builder.append("}");

		return builder.toString();
	}

	private String getDocumentation(SafetyPattern safetyPattern) {
		if (safetyPattern.getDocumentation() == null) {
			return "";
		}

		final StringBuilder builder = new StringBuilder();
		final String[] tokens = safetyPattern.getDocumentation().split("\n");
		builder.append("/**\n");
		for (final String string : tokens) {
			builder.append("* ").append(string).append("\n");
		}
		builder.append("*/\n");
		return builder.toString();
	}

	private String getParameterList(SafetyPattern safetyPattern) {
		final StringBuilder builder = new StringBuilder();

		// see TransformationExecuteHelper::getSafetyPatternApplicationArguments ... we need the same order here!
		// at the moment the order below which is the containment reference order as defined in the model should provide the same result as
		// "safetyPattern.eContents()"
		// ToBe solved in https://jira.scopeforge.de/browse/SAFE4I-128

		safetyPattern.getBlockParameters().forEach(param -> {
			if (param.isMany()) {
				builder.append(TAB).append(normalizeName(param.getName())).append(":").append("List<Block>");
			} else {
				builder.append(TAB).append(normalizeName(param.getName())).append(":").append("Block");
			}
			if (param.getDefaultValue() != null || param.getConstrainingBlockType() != null) {
				builder.append(" /*");
				if (param.getDefaultValue() != null) {
					builder.append(" default='" + param.getDefaultValue().getName() + "'");
				}
				if (param.getConstrainingBlockType() != null) {
					builder.append(" constraint='" + param.getConstrainingBlockType().getName() + "'");
				}
				builder.append(" */");
			}
			builder.append(",\n");
		});
		safetyPattern.getBlockTypeParameters().forEach(param -> {
			if (param.isMany()) {
				builder.append(TAB).append(normalizeName(param.getName())).append(":").append("List<BlockType>");
			} else {
				builder.append(TAB).append(normalizeName(param.getName())).append(":").append("BlockType");
			}
			if (param.getDefaultValue() != null || param.getConstrainingBlockType() != null) {
				builder.append(" /*");
				if (param.getDefaultValue() != null) {
					builder.append(" default='" + param.getDefaultValue().getName() + "'");
				}
				if (param.getConstrainingBlockType() != null) {
					builder.append(" constraint='" + param.getConstrainingBlockType().getName() + "'");
				}
				builder.append(" */");
			}
			builder.append(",\n");
		});
		safetyPattern.getPortParameters().forEach(param -> {
			final String type = param.isControlflowPort() ? "ControlFlowPort" : "DataFlowPort";
			if (param.isMany()) {
				builder.append(TAB).append(normalizeName(param.getName())).append(":").append("List<" + type + ">");
			} else {
				builder.append(TAB).append(normalizeName(param.getName())).append(":").append(type);
			}
			if (param.getDefaultValue() != null || param.getConstrainingPortType() != null) {
				builder.append(" /*");
				if (param.getDefaultValue() != null) {
					builder.append(" default='" + param.getDefaultValue().getName() + "'");
				}
				if (param.getConstrainingPortType() != null) {
					builder.append(" constraint='" + param.getConstrainingPortType().getName() + "'");
				}
				builder.append(" */");
			}
			builder.append(",\n");
		});
		safetyPattern.getConnectionParameters().forEach(param -> {
			final String type = param.isControlflowConnection() ? "ControlFlowConnection" : "DataFlowConnection";
			if (param.isMany()) {
				builder.append(TAB).append(normalizeName(param.getName())).append(":").append("List<" + type + ">");
			} else {
				builder.append(TAB).append(normalizeName(param.getName())).append(":").append(type);
			}
			if (param.getDefaultValue() != null) {
				builder.append(" /* default='ID:" + param.getDefaultValue().getUniqueIdentifier() + "' */");
			}
			builder.append(",\n");
		});
		safetyPattern.getDomainTypeParameterDefinitions().forEach(param -> {
			builder.append(TAB).append(normalizeName(param.getName())).append(":DomainType");
			if (param.getDefaultValue() != null) {
				builder.append(" /*");
				if (param.getDefaultValue() != null || param.getConstrainingDomainType() != null) {
					builder.append(" default='" + param.getDefaultValue().getName() + "'");
				}
				if (param.getConstrainingDomainType() != null) {
					builder.append(" constraint='" + param.getConstrainingDomainType().getName() + "'");
				}
				builder.append(" */");
			}
			builder.append(",\n");
		});
		safetyPattern.getTrafoTypeParameterDefinitions().forEach(param -> {
			builder.append(TAB).append(normalizeName(param.getName())).append(":").append(param.getType().getName().toLowerCase());

			if (param.getDefaultValue() != null) {
				builder.append(" /* default='" + param.getDefaultValue() + "' */");
			}
			builder.append(",\n");
		});

		// add default
		builder.append(TAB).append("model").append(":").append("Model").append(NEWLINE);

		return builder.toString();
	}

	private String normalizeName(String name) {
		// FIXME maybe more required
		return name.replace(" ", "_");
	}

}
