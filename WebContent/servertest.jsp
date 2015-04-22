<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.cp.serverInfo.ServerInfo2"%>
<%@page import="com.cp.push.GetPushParameter"%>

<%
	new ServerInfo2().getPort();
    System.out.println(new GetPushParameter().getAPP_KEY("android"));
    System.out.println(new GetPushParameter().getDevice_Token("android"));
    System.out.println(new GetPushParameter().getAPP_MASTER_SECRET("android"));
    System.out.println(new GetPushParameter().getAPP_KEY("ios"));
    System.out.println(new GetPushParameter().getDevice_Token("ios"));
    System.out.println(new GetPushParameter().getAPP_MASTER_SECRET("ios"));
%>