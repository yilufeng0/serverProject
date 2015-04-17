<%@page import="org.json.JSONObject"%>
<%@page import="com.cp.serverInfo.ServerInfo2"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%
	ServerInfo2 serverInfo = new ServerInfo2();
	JSONObject serverJson = new JSONObject();
	serverJson.put("memRatio",serverInfo.getMemUsageRatio());
	serverJson.put("diskAll",serverInfo.getDiskAll());
	serverJson.put("diskRation",serverInfo.getDiskRatio());
//	serverJson.put("cpuRatio",serverInfo.getCpuRatio());
//	serverJson.put("rxPackets",serverInfo.getRxPackets());
//	serverJson.put("txPackets",serverInfo.getTxPackets());
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	out.write(serverJson.toString());	
%>