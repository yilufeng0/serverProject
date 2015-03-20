<%@page import="com.cp.basefunc.MapToJSON"%>
<%@page import="com.cp.app.SelectApps"%>
<%@page import="com.cp.feedback.AddFeedback"%>
<%@page import="com.cp.JDBC.InsertOperation"%>
<%@page import="com.cp.feedback.SelectFeedback"%>
<%@page import="com.cp.basefunc.ResultsetToJSON"%>
<%@page import="com.cp.exhibition.SelectCpImgVideo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.cp.newspub.SelectNews"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.cp.JDBC.SelectOperation"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.*"%>

<%
String requestType = request.getParameter("requestType");
if(requestType==null){
	out.write("0");
	return;
}
response.setContentType("application/json;charset=utf-8");
switch (requestType)	
{
  case "exhibition"  : ResultSet rsExhibition = SelectCpImgVideo.selectExhibition();
                       out.write(ResultsetToJSON.resultsetToJSON(rsExhibition));          
 					   break;  
 					   
  case "newsitem"    : String id = request.getParameter("id");
                       if(id==null){
                    	id="0";
                       }
                       ResultSet rsNewsItem = SelectNews.selectNewsItem(id);                      
  	  				   out.write(ResultsetToJSON.resultsetToJSON(rsNewsItem));
	                   break;
	                   
  case "feedback"	 : String feedback = request.getParameter("content_str");
                       System.out.println(feedback);
                       //String uuid = request.getParameter("uuid");
                       //String telephone = request.getParameter("phone_str");
                       //AddFeedback.addFeedback(feedback,uuId,telephone);
                       out.write("1");
                       break;
                       
  case "version"     : String appType = request.getParameter("appType");
	                   String version = request.getParameter("version");
	                   ResultSet rsVersion = null;
                       int bigVersion = Integer.valueOf(version.substring(0, version.indexOf(".")));
                       int mediumVersion = Integer.valueOf(version.substring(version.indexOf(".")+1,version.lastIndexOf(".")));
           			   int smallVersion = Integer.valueOf(version.substring(version.lastIndexOf(".")+1,version.length()));
           			  
           		       HashMap<String,String> map = new HashMap<String,String>();  
           			   switch(appType){
           			   case "android"  :  {rsVersion = SelectApps.selectAppsVer("android"); break;}                
           			   case "ios"      :  {rsVersion = SelectApps.selectAppsVer("ios"); break;}
           			   case "winphone" :  {rsVersion = SelectApps.selectAppsVer("winphone"); break;} 			   
           			   }
           			   
           			   if(rsVersion.next()){
             			   if(Integer.valueOf(rsVersion.getString("bigversion"))>bigVersion){
             				   String url = rsVersion.getString("Url");
             				   map.put("result", "1");
             				   map.put("isMust","2");
             				   map.put("appUrl",url);
             			   }
             			   else if((Integer.valueOf(rsVersion.getString("mediumVersion"))>mediumVersion)&&(bigVersion==Integer.valueOf(rsVersion.getString("bigversion")))){
             				   String url = rsVersion.getString("Url");
           				       map.put("result", "1");
           				       map.put("isMust","1");
           				       map.put("appUrl",url);
             				   
             			   }
             			   else if((Integer.valueOf(rsVersion.getString("smallVersion"))>smallVersion)&&(mediumVersion==Integer.valueOf(rsVersion.getString("mediumVersion")))){
             				   String url = rsVersion.getString("Url");
             				   map.put("result", "1");
        				       map.put("isMust","0");
        				       map.put("appUrl",url);
             			   }
             			   else{
             				   map.put("result", "0");
     				           map.put("isMust","0");
     				           map.put("appUrl",null);
             			   }
             			   out.write(MapToJSON.hashMapToJson(map));   
           			   }
           			   else{
           				   out.write("{'result':'-1'}");
           			   }
           			   
                       break;
}  

%>