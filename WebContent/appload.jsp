<%@page import="com.cp.app.SelectApps"%>
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
	String appType = request.getParameter("appType");
	appType = (appType == null)?"android":appType;
	
	ResultSet rs = SelectApps.selectApps(appType, pageNum);
	try{
		 	while(rs.next()){
		 	 out.print("<tr class=\"text-center\"><td>");
		 	 out.print(rs.getRow());
		 	 out.print("</td><td>");
		 	 out.print("<button type=\"button\" class=\"btn btn-link\" data-placement=\'right\' title=");
		 	 out.print(rs.getString("title")); 
		 	 out.print(" onclick=\"disp('right')\">");
		 	 out.print(rs.getString("title"));
             out.print("</button></td><td>");
             out.print(rs.getString("bigVersion")+"."+rs.getString("mediumVersion")+"."+rs.getString("smallVersion"));
             out.print("</td><td>"); 
		 	 out.print(rs.getString("time"));
		 	 out.print("</td><td>"); 
		 	 out.print("<button class=\"btn btn-danger btn-xs\" onclick=\"deleteItem(");
		     out.print(rs.getInt("ID"));
		     out.print(")\"><i class=\"fa fa-trash-o\"></i></button>"); 
		 	 out.print("</td><tr>");
		     }	
		 }catch(SQLException e){
			 e.printStackTrace();
   }


%>