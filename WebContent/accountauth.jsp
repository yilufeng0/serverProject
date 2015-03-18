<%@page import="com.cp.account.SelectAccount"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.cp.JDBC.*" %>
<%@page import="java.util.ArrayList,java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    
	String userName = request.getParameter("account");
	String passwd = Integer.toHexString(request.getParameter("passwd").hashCode());	
	if(userName==null||passwd==null){
		out.write("0");
		return;
	}
	else{
		boolean result = true;
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
		System.out.println(result);
		if(result==true){
			out.write("1");
		}
		else
			out.write("0");
	}
	
	
	

%>