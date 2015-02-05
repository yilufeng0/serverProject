<%@page import="com.cp.account.DeleteAccount"%>
<%@page import="com.cp.exhibition.DeleteCpImage"%>
<%@page import="com.cp.newspub.DeleteNews"%>
<%@page import="com.cp.push.DeletePush"%>
<%@page import="com.mysql.jdbc.util.ResultSetUtil"%>
<%@page import="com.cp.app.DeleteApps"%>
<%@page import="com.cp.app.SelectApps"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int id = Integer.valueOf(request.getParameter("id"));
    String type = request.getParameter("type");
    boolean result = false;
    switch (type){
    case "news" :
    	  result = DeleteNews.deleteNews(id);
    	  break;
    case "push" :
    	  result = DeletePush.deletePush(id); 	
    	  break;
    case "android" :
    case "ios" :
    case "winphone" :
    	  result = DeleteApps.deleteApp(id);
    	  break;
    case "cpimg" :
    	  result = DeleteCpImage.deleteCpImage(id);
    	  break;
    case "server" :
    case "remote" :
    	  result = DeleteAccount.deleteAccount(id);  
    default:
    	result = false;
    
    }

    if(result){
    	out.write("1"); 
    	//System.out.println("1");
    }else{
    	out.write("0");
    }
	

%>