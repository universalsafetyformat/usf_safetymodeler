/**
 * Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.safe4i.usf.safetyModeller.ui.example;

import org.eclipse.core.resources.IFile;
import org.safe4i.usf.core.usfmodel.block.Block;
import org.safe4i.usf.core.usfmodel.block.BlockType;
import org.safe4i.usf.core.usfmodel.block.DataFlowPort;
import org.safe4i.usf.core.usfmodel.block.PortDirection;

public class UR5_Example_CreationHelper extends DataCreationHelper {

	public void createModel(IFile modelFile) {
		initModel();
		saveModel(modelFile);
	}

	@Override
	protected void createBlockData() {

		final BlockType ur5_draw_BlockType = createOrGetBlockType("UR5_Draw");

		// Blocks
		final Block pathPlaner_Block = createOrGetBlock(ur5_draw_BlockType, "pathPlaner", "PathPlaner");
		final Block posectrl_Block = createOrGetBlock(ur5_draw_BlockType, "posectrl", "PoseCtrl");
		final Block cmdprocessor_Block = createOrGetBlock(ur5_draw_BlockType, "cmdprocessor", "CmdProcessor");
		final Block rtde_Block = createOrGetBlock(ur5_draw_BlockType, "rtde", "RTDE");
		final Block shadowGenerator_Block = createOrGetBlock(ur5_draw_BlockType, "shadowGenerator", "DMXProcessor");
		final Block dashboard_Block = createOrGetBlock(ur5_draw_BlockType, "dashboard", "Dashboard");
		final Block dmxctrl_Block = createOrGetBlock(ur5_draw_BlockType, "dmxctrl", "DMXCtrl");
		final Block cmdInterface_Block = createOrGetBlock(ur5_draw_BlockType, "cmdInterface", "EthernetConnection");
		final Block ur5CtrlConn_Block = createOrGetBlock(ur5_draw_BlockType, "ur5CtrlConn", "EthernetConnection");
		final Block ur5RtConn_Block = createOrGetBlock(ur5_draw_BlockType, "ur5RtConn", "EthernetConnection");

		// Ports
		final DataFlowPort cmdprocessor_cmdConn_Port = createOrGetPort(cmdprocessor_Block.getType(), "cmdConn", "Ethernet", PortDirection.INOUT);
		final DataFlowPort cmdprocessor_movementPart_Port = createOrGetPort(cmdprocessor_Block.getType(), "movementPart", "PoseCmd", PortDirection.OUT);

		final DataFlowPort cmdInterface_connection_Port = createOrGetPort(cmdInterface_Block.getType(), "connection", "Ethernet", PortDirection.INOUT);

		// final DataFlowPort pathPlaner_dashboardRtrn_Port =
		// createOrGetPort(pathPlaner_Block,
		// "dashboardRtrn", "DashboardRtrn", PortDirection.INOUT);
		final DataFlowPort pathPlaner_movementPart_Port = createOrGetPort(pathPlaner_Block.getType(), "movementPart", "PoseCmd", PortDirection.IN);
		// final DataFlowPort pathPlaner_curPose_Port = createOrGetPort(pathPlaner_Block,
		// "curPose", "Pose", PortDirection.INOUT);
		//// final DataFlowPort pathPlaner_dashboardCmd_Port =
		// createOrGetPort(pathPlaner_Block,
		// "dashboardCmd", "DashboardCmd", PortDirection.INOUT);
		// final DataFlowPort pathPlaner_sendPose_Port = createOrGetPort(pathPlaner_Block,
		// "sendPose", "PoseCmd", PortDirection.INOUT);
		final DataFlowPort pathPlaner_nextPoses_Port = createOrGetPort(pathPlaner_Block.getType(), "nextPoses", "PoseCmd", PortDirection.OUT);

		final DataFlowPort posectrl_cmdPose_Port = createOrGetPort(posectrl_Block.getType(), "cmdPose", "PoseCmd", PortDirection.IN);
		final DataFlowPort posectrl_curPose_Port = createOrGetPort(posectrl_Block.getType(), "curPose", "Pose", PortDirection.IN);
		final DataFlowPort posectrl_outPose_Port = createOrGetPort(posectrl_Block.getType(), "outPose", "PoseCmd", PortDirection.OUT);
		final DataFlowPort posectrl_poseArray_Port = createOrGetPort(posectrl_Block.getType(), "poseArray", "PoseArray", PortDirection.OUT);

		final DataFlowPort dashboard_dashboardCmd_Port = createOrGetPort(dashboard_Block.getType(), "dashboardCmd", "DashboardCmd", PortDirection.IN);
		final DataFlowPort dashboard_dashboardRtrn_Port = createOrGetPort(dashboard_Block.getType(), "dashboardRtrn", "DashboardRtrn", PortDirection.OUT);
		final DataFlowPort dashboard_ur5Ctrl_Port = createOrGetPort(dashboard_Block.getType(), "ur5Ctrl", "Ethernet", PortDirection.INOUT);

		final DataFlowPort rtde_sendPose_Port = createOrGetPort(rtde_Block.getType(), "sendPose", "PoseCmd", PortDirection.IN);
		final DataFlowPort rtde_ur5rtde_Port = createOrGetPort(rtde_Block.getType(), "ur5rtde", "Ethernet", PortDirection.INOUT);
		final DataFlowPort rtde_curPose_Port = createOrGetPort(rtde_Block.getType(), "curPose", "Pose", PortDirection.OUT);
		final DataFlowPort rtde_dashboardCmd_Port = createOrGetPort(rtde_Block.getType(), "dashboardCmd", "DashboardCmd", PortDirection.OUT);
		final DataFlowPort rtde_dashboardRtrn_Port = createOrGetPort(rtde_Block.getType(), "dashboardRtrn", "DashboardRtrn", PortDirection.IN);

		final DataFlowPort shadowGenerator_inPoses_Port = createOrGetPort(shadowGenerator_Block.getType(), "inPoses", "PoseArray", PortDirection.IN);
		final DataFlowPort shadowGenerator_dmxIntf_Port = createOrGetPort(shadowGenerator_Block.getType(), "dmxIntf", "DMXIntf", PortDirection.OUT);

		final DataFlowPort ur5CtrlConn_connection_Port = createOrGetPort(ur5CtrlConn_Block.getType(), "connection", "Ethernet", PortDirection.INOUT);

		final DataFlowPort ur5RtConn_connection_Port = createOrGetPort(ur5RtConn_Block.getType(), "connection", "Ethernet", PortDirection.INOUT);

		final DataFlowPort dmxctrl_dmxIntf_Port = createOrGetPort(dmxctrl_Block.getType(), "dmxIntf", "DMXIntf", PortDirection.IN);

		// Connections
		createConnector(ur5_draw_BlockType, cmdprocessor_Block, cmdprocessor_cmdConn_Port, cmdInterface_Block, cmdInterface_connection_Port);
		createConnector(ur5_draw_BlockType, cmdprocessor_Block, cmdprocessor_movementPart_Port, pathPlaner_Block, pathPlaner_movementPart_Port);

		createConnector(ur5_draw_BlockType, pathPlaner_Block, pathPlaner_nextPoses_Port, posectrl_Block, posectrl_cmdPose_Port);

		createConnector(ur5_draw_BlockType, posectrl_Block, posectrl_outPose_Port, rtde_Block, rtde_sendPose_Port);
		createConnector(ur5_draw_BlockType, posectrl_Block, posectrl_poseArray_Port, shadowGenerator_Block, shadowGenerator_inPoses_Port);

		createConnector(ur5_draw_BlockType, rtde_Block, rtde_curPose_Port, posectrl_Block, posectrl_curPose_Port);
		createConnector(ur5_draw_BlockType, rtde_Block, rtde_dashboardCmd_Port, dashboard_Block, dashboard_dashboardCmd_Port);
		createConnector(ur5_draw_BlockType, rtde_Block, rtde_ur5rtde_Port, ur5RtConn_Block, ur5RtConn_connection_Port);

		createConnector(ur5_draw_BlockType, dashboard_Block, dashboard_dashboardRtrn_Port, rtde_Block, rtde_dashboardRtrn_Port);
		createConnector(ur5_draw_BlockType, dashboard_Block, dashboard_ur5Ctrl_Port, ur5CtrlConn_Block, ur5CtrlConn_connection_Port);

		createConnector(ur5_draw_BlockType, shadowGenerator_Block, shadowGenerator_dmxIntf_Port, dmxctrl_Block, dmxctrl_dmxIntf_Port);

	}

}
