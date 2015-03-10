<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.cp.newspub.SelectNews"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.cp.JDBC.SelectOperation"%>
<%@page import="java.sql.ResultSet"%>

<%
	String loadType = request.getParameter("loadType");
	switch (loadType)	
   {
	case "accountload"      : response.sendRedirect("accountload.jsp");
	case "appload"          : response.sendRedirect("appload.jsp");
	case "aboutcpimageload" : response.sendRedirect("aboutcpimageload.jsp");
	case "feedbackload"     : response.sendRedirect("feedbackload.jsp");
	case "newsload"         : response.sendRedirect("newsload.jsp");
	case "pushload"         : response.sendRedirect("pushload.jsp");
	
   }

%>