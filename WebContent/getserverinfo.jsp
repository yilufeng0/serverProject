<%@page import="org.json.JSONObject"%>
<%@page import="com.cp.serverInfo.ServerInfo"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%
	ServerInfo serverInfo = new ServerInfo();
	JSONObject serverJson = new JSONObject();
	serverJson.put("memRatio",String.valueOf(serverInfo.getMemUsageRatio()));
	serverJson.put("diskAll",serverInfo.getDiskAll());
	serverJson.put("diskRation",String.valueOf(serverInfo.getDiskRatio()));
	serverJson.put("cpuRatio",serverInfo.getCpuRatio());
	serverJson.put("rxPackets",serverInfo.getRxPackets());
	serverJson.put("txPackets",serverInfo.getTxPackets());
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	out.write(serverJson.toString());	
%>