/**
 * Copyright (c) 2021 FZI Forschungszentrum Informatik (www.fzi.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.qvto.ui;

import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchConfigurationDelegate;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchConfigurationDelegateBase;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.qvt.oml.ExecutionContext;
import org.eclipse.m2m.qvt.oml.util.WriterLog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;

@SuppressWarnings("restriction")
public class QVToLauncherHelper {
	
	public static void displayNoteMsg(String msgHeading, String msgText) {
		IWorkbench iWorkbench = PlatformUI.getWorkbench();
		IWorkbenchWindow iWorkbenchWindow = iWorkbench.getActiveWorkbenchWindow();

		if (iWorkbenchWindow != null) {
			Shell activeShell = iWorkbenchWindow.getShell();
			MessageBox mbox = new MessageBox(activeShell, SWT.ICON_WARNING | SWT.OK);
			mbox.setText(msgHeading);
			mbox.setMessage(msgText);
			mbox.open();
		}
	}

	private static MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++)
			if (name.equals(existing[i].getName())) {
				MessageConsole myConsole = (MessageConsole) existing[i];
				myConsole.activate();
				myConsole.clearConsole();
				return (MessageConsole) existing[i];
			}
		// no console found, so create a new one
		MessageConsole myConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		myConsole.activate();
		myConsole.clearConsole();
		return myConsole;
	}
	
	private static String getFileName(String path) {
		path = path.split("#")[0];
		path = path.split("/")[path.split("/").length - 1];
		path = path.split("\\.")[0];
		return path;
	}

	public static void modelTransform(IProgressMonitor monitor, final String trafo, List<URI> modelURIs,
			String traceFile, boolean refresh) throws CoreException {
		
		try {
			String trafoName = getFileName(trafo);

			ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
			ILaunchConfigurationType c = manager
					.getLaunchConfigurationType(QvtLaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE_ID);
			ILaunchConfigurationWorkingCopy instance = c.newInstance(null, trafoName);

			instance.setAttribute(IQvtLaunchConstants.CONFIGURATION_PROPERTIES, new HashMap<String, String>());
			instance.setAttribute(IQvtLaunchConstants.MODULE, trafo);
			
			if (traceFile == null || traceFile == "") {
				instance.setAttribute(IQvtLaunchConstants.TRACE_FILE, "");
				instance.setAttribute(IQvtLaunchConstants.USE_TRACE_FILE, false);				
			} else {
				instance.setAttribute(IQvtLaunchConstants.TRACE_FILE, traceFile);
				instance.setAttribute(IQvtLaunchConstants.USE_TRACE_FILE, true);
			}
			
			instance.setAttribute(IQvtLaunchConstants.ELEM_COUNT, modelURIs.size());
			int counter = 1;
			for (URI modelURI : modelURIs) {
				String counterStr = Integer.toString(counter++);
				String tokens[] = modelURI.toString().split("#");
				String target = tokens[0];
				String feature = "";
				if (tokens.length > 1) {
					feature = tokens[1];
				}
				
				instance.setAttribute(IQvtLaunchConstants.CLEAR_CONTENTS + counterStr, true);
				instance.setAttribute(IQvtLaunchConstants.TARGET_MODEL + counterStr, target);
				instance.setAttribute(IQvtLaunchConstants.FEATURE_NAME + counterStr, feature);
				instance.setAttribute(IQvtLaunchConstants.TARGET_TYPE + counterStr, "");
			}

			QvtTransformation qvtTransformation = new QvtInterpretedTransformation(
					QvtLaunchConfigurationDelegateBase.getQvtModule(instance));
			
			IStatus status = QvtLaunchConfigurationDelegateBase.validate(qvtTransformation, instance);
			if (status.getSeverity() > IStatus.WARNING)
				throw new CoreException(status);

			OutputStreamWriter s = new OutputStreamWriter(findConsole(trafo).newOutputStream());
			ExecutionContext context = QvtLaunchUtil.createContext(instance, new WriterLog(s), monitor);

			try {
				QvtLaunchUtil.doLaunch(qvtTransformation, instance, context);
			} catch (Exception e) {
				IStatus status2 = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
				Activator.getDefault().getLog().log(status2);
			}
			qvtTransformation.cleanup();

		} finally {
			if (refresh) {
				for (URI modelURI : modelURIs) {
					IFile model = ResourcesPlugin.getWorkspace().getRoot().getFile(new
							Path(modelURI.toString()));
					model.getProject().refreshLocal(IResource.DEPTH_INFINITE, monitor);
				}
			}
		}
	}
}
