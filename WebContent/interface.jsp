<%@page import="com.cp.basefunc.ResultsetToJSON"%>
<%@page import="com.cp.exhibition.SelectCpImgVideo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.cp.newspub.SelectNews"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.cp.JDBC.SelectOperation"%>
<%@page import="java.sql.ResultSet"%>

<%
String requestType = request.getParameter("requestType");
if(requestType==null){
	out.write("0");
	return;
}
//response.setContentType("application/json;charset=utf-8");
switch (requestType)	
{
  case "exhibition"  : ResultSet rsExhibition = SelectCpImgVideo.selectExhibition();
                       out.write(ResultsetToJSON.resultsetToJSON(rsExhibition));          
 					   break;                 
  case "newsitem"    : ResultSet rsNewsItem = SelectNews.selectNewsItem();
	  				   out.write(ResultsetToJSON.resultsetToJSON(rsNewsItem));
	                   break;
  case "feedback"	 : 
	  
  case "version"     : 
	  
  
                     
}  

%>