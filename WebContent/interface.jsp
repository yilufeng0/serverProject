<%@page import="java.net.URLDecoder"%>
<%@page import="com.cp.basefunc.GetTime"%>
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
	out.write("{\"result\":\"0\"}");
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
	                   
  case "feedback"	 : String tmp_feedback = request.getParameter("content_str");  //获取反馈内容
  					   String feedback = URLDecoder.decode(tmp_feedback,"utf-8");  //urldecoder解码
                       System.out.print("feedback:");
  					   System.out.println(feedback);
  					   
                       String uuId = request.getParameter("uuId");  //获取uuid，即device_token
                       System.out.print("uuid:");
                       System.out.println(uuId);
                       
                       String telephone = request.getParameter("phone_str"); //获取手机号
                       System.out.print("phone_str:");
                       System.out.println(telephone);
                       if(telephone==null){telephone="";}
                       
                       String showTime = GetTime.getPageDate();             //获取反馈发送时间
                       AddFeedback.addFeedback(feedback,uuId,telephone,showTime);
                       out.write("{\"result\":\"1\"}"); 
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
           				out.write("{\"result\":\"-1\"}");
           			   }
           			   
                       break;
}  

%>