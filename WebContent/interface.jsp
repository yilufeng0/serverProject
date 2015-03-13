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
  case "image"      : ResultSet rsImage = SelectCpImgVideo.selectCpImgVideo("image");
                      out.write(ResultsetToJSON.resultsetToJSON(rsImage));
                      break;
                    
  case "video"      : ResultSet rsVideo = SelectCpImgVideo.selectCpImgVideo("video");
                      out.write(ResultsetToJSON.resultsetToJSON(rsVideo));
                      break;
                      
  case "newsimg"    : ResultSet rsNewsImg = SelectNews.selectNewsImg();
  					  out.write(ResultsetToJSON.resultsetToJSON(rsNewsImg));
  					  break;
  					  
  case "newstext"   : ResultSet rsNewsText = SelectNews.selectNewsText();
	  				  out.write(ResultsetToJSON.resultsetToJSON(rsNewsText));
	                  break;
                     
}  

%>