<%@page import="com.cp.account.AccountAuth"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.cp.JDBC.SelectOperation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
	String userName=null,passwd;
	passwd=request.getParameter("passwd");
	if(request.getParameter("account")!=null){
		userName= request.getParameter("account");
	}else if(session.getAttribute("account")!=null){
		userName=(String)session.getAttribute("account");
	}
	
	
	int resp=1;
	if(userName != null){  //若用户名不为空，则进行登录授权管理
		//boolean result= new AccountAuth().AccountLogin(userName, passwd);
		boolean result=true;
		if(!result){
			resp=0;
		}else{
			session.setAttribute("account", userName);
		}
	}else{
		resp=0;
	}	
	out.write(String.valueOf(resp));
*/
	out.write("1");
%>