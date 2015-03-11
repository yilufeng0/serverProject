<%@page import="com.cp.push.SelectPush"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String pageNum = request.getParameter("pageNum");
   if(pageNum==null){
		out.write("0");
		return;
	}
   
   ResultSet rs = SelectPush.selectPush(pageNum);
   try{
	 	while(rs.next()){
	 	 out.print("<tr class=\"text-center\"><td>");
	 	 out.print(rs.getRow());
	 	 out.print("</td><td>");
	 	 out.print(rs.getString("tips"));
	 	 out.print("</td><td>");
	 	 out.print(rs.getString("title"));
	 	 out.print("</td><td>"); 
	 	 out.print(rs.getString("abstract"));
	 	 out.print("</td><td>");
	 	 out.print("<button class=\"btn btn-danger btn-xs\" onclick=\"deleteItem(");
	     out.print(rs.getInt("ID"));
	     out.print(")\"><i class=\"fa fa-trash-o\"></i></button>"); 
	 	 out.print("</td><tr>");
	     }	
	 }catch(SQLException e){
		 e.printStackTrace();
		 out.print("0");
	 }







%>