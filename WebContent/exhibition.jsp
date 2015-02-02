<%@page import="com.cp.download.DownLoadFileStream"%>
<%@page import="com.cp.exhibition.SelectCpImage"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.jspsmart.upload.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int id = Integer.valueOf(request.getParameter("id"));  //通过"exhibition.jsp?id="+id;获取参数id
	ResultSet rs = SelectCpImage.selectCpImage(id);
	rs.next();
	String filePath = rs.getString("oripath");
	new DownLoadFileStream().downLoad(response, filePath);
%>