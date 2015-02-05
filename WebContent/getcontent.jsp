<%@page import="com.cp.newspub.SelectNews"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int id = Integer.valueOf(request.getParameter("id"));
	ResultSet rs = SelectNews.selectNews(id);	
	rs.next();
    String oriContent = rs.getString("content"); 
    System.out.println(oriContent);
	out.write(oriContent);
%>
