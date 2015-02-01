<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.cp.newspub.SelectNews"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.cp.JDBC.SelectOperation"%>
<%@page import="java.sql.ResultSet"%>

<%
   String pageNum = request.getParameter("pageNum");
	if(pageNum==null){
		pageNum="0";
	}
	ResultSet rs = SelectNews.selectNews(pageNum);
  try{
 	while(rs.next()){
 	 out.print("<tr class=\"text-center\"><td>");
 	 out.print(rs.getRow());
 	 out.print("</td><td>");
 	 out.print(rs.getString("title"));
 	 out.print("</td><td>");
 	 out.print(rs.getString("time"));
 	 out.print("</td><td>"); 
 	 out.print(rs.getString("author"));
 	 out.print("</td><td>");
 	 out.print("<button class=\"btn btn-primary btn-xs\" onclick=\"editItem(");
 	 out.print(rs.getInt("ID"));
     out.print(")\"><i class=\"fa fa-pencil\"></i></button>");
 	 out.print("<button class=\"btn btn-danger btn-xs\" onclick=\"deleteItem(");
     out.print(rs.getInt("ID"));
     out.print(")\"><i class=\"fa fa-trash-o\"></i></button>"); 
 	 out.print("</td><tr>");
     }	
 }catch(SQLException e){
	 e.printStackTrace();
 }

%>