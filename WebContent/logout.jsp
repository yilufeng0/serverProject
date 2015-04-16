<%@page import="com.cp.account.SelectAccount"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.cp.JDBC.*" %>
<%@page import="java.util.ArrayList,java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  session.setAttribute("login", "false");
  session.setAttribute("username", "");
  response.sendRedirect("login.jsp");
%>