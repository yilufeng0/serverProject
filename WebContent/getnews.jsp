<%@page import="com.cp.download.DownLoadFileStream"%>
<%@page import="com.cp.basefunc.ResultsetToJSON"%>
<%@page import="com.cp.exhibition.SelectCpImgVideo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.cp.newspub.SelectNews"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.cp.JDBC.SelectOperation"%>
<%@page import="java.sql.ResultSet"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
 String uuid = request.getParameter("uuid");
//   String uuid = "56b10c84-990d-4998-b03c-b73ee02e7d87";
 if(uuid==null){
	out.write("0");
	return;
}

 ResultSet rs = SelectNews.selectNewsInfo(uuid);
 String content=null;
 String title=null;
 String showTime=null;
 try{
	 while(rs.next()){
		 content= rs.getString("content");
		 title = rs.getString("title");
//		 abstractt = rs.getString("abstract");
		 showTime = rs.getString("showTime");	 
	 } 
 }catch(SQLException e){
//	 e.printStackTrace(); 
 }
%>

<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title><%=title %></title>
	<link rel="stylesheet" href="mobile/jquery.mobile-1.4.5.min.css">
	<link rel="stylesheet" href="mobile/css/jqm-css.css">
	<script src="js/jquery-1.7.2.min.js"></script>
	<script src="mobile/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
<div data-role="page">
	<div data-role="header" class="jqm-header">
		<h2><%=title %></h2>				
	</div>
	<h6><span style="text-align:left">正大禽蛋 &nbsp&nbsp<%=showTime %></span></h6>
	<hr sytle="">
	<div data-role="content">
		
		<p><%=content %></p>
	</div>
	
</div>
<hr>
<div>
	
</div>

</body>
</html>