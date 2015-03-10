<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.cp.account.AccountAuth"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.cp.JDBC.SelectOperation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   
	String userName=null,passwd;
	passwd=request.getParameter("passwd");
	if(request.getParameter("account")!=null){
		userName= request.getParameter("account");
	}else if(session.getAttribute("account")!=null){
		userName=(String)session.getAttribute("account");
	}
	
	String sql = "select count(*) as counter from account where passwd = ? and userName = ? and type = 'server'";
	List<Object> list = new ArrayList<>();
	list.add(passwd);
	list.add(userName);
	ResultSet rs = SelectOperation.selectOne(sql, list);
	rs.next();
	int counter = rs.getInt("counter");
	boolean result = true;
	if(counter!=0){
		result = true;
	}
	else{
		result = false;
	}

	if(result){
		out.write("1");
	}
	else{
		out.write("0");
	}

%>