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
	case "accountload"      : request.getRequestDispatcher("accountload.jsp").forward(request, response);
	case "appload"          : request.getRequestDispatcher("appload.jsp").forward(request, response);
	case "aboutcpimageload" : request.getRequestDispatcher("aboutcpimageload.jsp").forward(request, response);
	case "feedbackload"     : request.getRequestDispatcher("feedbackload.jsp").forward(request, response);
	case "newsload"         : request.getRequestDispatcher("newsload.jsp").forward(request, response);
	case "pushload"         : request.getRequestDispatcher("pushload.jsp").forward(request, response);
	
   }

%>