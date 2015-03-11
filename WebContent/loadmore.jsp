<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="highlight">
		<!-- <p class="text-center"><img alt="" src="img/ajax-loader.gif">点击加载更多</p>-->
		<ul class="text-center">
			<li id="startload" style="display:''" onclick="loadlist('<%=request.getParameter("loadType")%>','<%=request.getParameter("type")%>')">点击加载更多</li>
			<li id="loading" style="display:none"><img alt="loading" src="img/ajax-loader.gif">加载中</li>
			<li id="allloaded" style="display:none">全部加载完成，没有更多</li>
		</ul>
	</div>
	
	<script type="text/javascript" src="js/forWebAction.js"></script>
</body>
</html>