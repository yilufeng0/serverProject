<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.cp.newspub.SelectNews"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.cp.JDBC.SelectOperation"%>
<%@page import="java.sql.ResultSet"%>

<%
	String loadType = request.getParameter("loadType");
    if(loadType==null){
    	out.write("0");
    	return;
    }
	switch (loadType)	
   {
	case "accountload"      : request.getRequestDispatcher("accountload.jsp").forward(request, response); return;
	case "appload"          : request.getRequestDispatcher("appload.jsp").forward(request, response);  return;
	case "aboutcpimageload" : request.getRequestDispatcher("aboutcpimageload.jsp").forward(request, response);  return;
	case "feedbackload"     : request.getRequestDispatcher("feedbackload.jsp").forward(request, response);  return;
	case "newsload"         : request.getRequestDispatcher("newsload.jsp").forward(request, response);  return;
	case "pushload"         : request.getRequestDispatcher("pushload.jsp").forward(request, response);  return;
	case "videoload"        : request.getRequestDispatcher("videoload.jsp").forward(request, response);  return;
   }

%>