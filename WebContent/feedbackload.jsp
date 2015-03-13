<%@page import="com.cp.feedback.SelectFeedback"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%
   String pageNum = request.getParameter("pageNum");
   if(pageNum==null){
	   out.write("0");
	   return;
	}
   
   ResultSet rs = SelectFeedback.selectFeedback(pageNum);
   try{
	 	while(rs.next()){
	 	 out.print("<tr class=\"text-center\"><td>");
	 	 out.print(rs.getRow());
	 	 out.print("</td><td>");
	 	 out.print(rs.getString("showTime"));
	 	 out.print("</td><td  class=\"text-center\">"); 
	 	 out.print(rs.getString("feedback")!=null?rs.getString("feedback"):"");
	 	 out.print("</td><td  class=\"text-center\">"); 
	 	 out.print(rs.getString("operation")!=null?rs.getString("operation"):"");
	 	 out.print("</td><tr>");
	     }	
	 }catch(SQLException e){
		 e.printStackTrace();
		 out.print("0");
	 }

%>
 