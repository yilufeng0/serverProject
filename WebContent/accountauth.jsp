<%@page import="com.cp.account.SelectAccount"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.cp.JDBC.*" %>
<%@page import="java.util.ArrayList,java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String passwd = Integer.toHexString(request.getParameter("passwd").hashCode());	
	String userName = request.getParameter("account");
	String refUrl = request.getHeader("Referer");
	System.out.println("refurl:"+refUrl);
	response.addHeader( "Cache-Control", "no-cache" );
	response.addHeader( "Cache-Control", "no-store" );
	boolean result = true;
	if(userName==null){
		 userName = (String)session.getAttribute("username");	
		 System.out.println(userName);
	}
    String userNamee = (String)session.getAttribute("username");	
	if(userName==""||passwd=="0"){
		session.setAttribute("username","");
		session.setAttribute("login", "false");
		System.out.println("test1");
		result=false;
//		out.write("0");
		return;
	}
	else{
		session.setAttribute("username",userName);
		System.out.println("userName:"+userName);
		System.out.println("passwd:"+passwd);
		System.out.println("test2");		
		String sql = "select count(*) as result from account where userName=? and passwd=?";
		List<Object> list = new ArrayList<>();
		list.add(userName);
		list.add(passwd);
		try {
			ResultSet rs = SelectOperation.selectOne(sql, list);
			rs.next();
			int tmp = rs.getInt("result");
			if(tmp==0){
				result = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			result = false;
		}
		System.out.println("result:"+result);
		
		
		if(result==true){
				
			session.setAttribute("login", "true");
			//out.write("1");
			response.sendRedirect("index.jsp");
			//out.write("1");
		}
		else{			
		    session.setAttribute("login", "false");	
		    //out.write("0");
		    response.sendRedirect("login.jsp");
		}
			
	}
	
	
	

%>