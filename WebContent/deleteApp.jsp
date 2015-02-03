<%@page import="com.cp.app.DeleteApps"%>
<%@page import="com.cp.app.SelectApps"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int id = Integer.valueOf(request.getParameter("id"));
    boolean result=new DeleteApps().deleteApp(id);
    if(result){
    	out.write("1");
    }else{
    	out.write("0");
    }
	
%>