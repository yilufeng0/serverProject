<%@page import="org.json.JSONObject"%>
<%@page import="com.cp.serverInfo.ServerInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	ServerInfo serverInfo = new ServerInfo();
	JSONObject serverJson = new JSONObject();
	serverJson.put("memRatio",serverInfo.getMemUsageRatio());
	serverJson.put("diskAll",serverInfo.getDiskAll());
	serverJson.put("diskRation",serverInfo.getDiskRatio());
	serverJson.put("cpuRatio",serverInfo.getCpuRatio());
	serverJson.put("rxPackets",serverInfo.getRxPackets());
	serverJson.put("txPackets",serverInfo.getTxPackets());
	ServletOutputStream servletOutputStream = response.getOutputStream();
	servletOutputStream.write(serverJson.toString().getBytes());
%>