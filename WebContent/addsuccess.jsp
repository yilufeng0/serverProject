<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

  <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">    



</head>
<body>

<% 
	String pathAll = request.getHeader("referer"); 
	int quesMark = pathAll.indexOf("?");
	String pageRef = pathAll.substring(pathAll.lastIndexOf("/")+1,quesMark==-1?pathAll.length():quesMark);
	
	String listPageURL=null;
	switch(pageRef){
	case "addnews.jsp" :
		listPageURL = "newspub.jsp";
		break;
	case "addpromotion.jsp":
		listPageURL= "promotion.jsp";
		break;
	case "addnewcp.jsp":
		listPageURL= "aboutcp.jsp";
		break;
	case "addnewvideo.jsp":
		listPageURL= "advideo.jsp";
		break;
	case "addnewapp.jsp":
		listPageURL= "applist.jsp?apptype="+request.getAttribute("apptype");
		break;
	case "createaccount.jsp":
		if(request.getParameter("acctype")!=null)
		{
			listPageURL= "accountprofile.jsp?type="+request.getParameter("acctype");
		}else{
			listPageURL= "accountprofile.jsp?type=server";
		}
		break;	
	}
%>

<a class="btn btn-primary" onclick="javascript:history.go(-1);">继续添加 </a>
<a class="btn btn-primary" href="<%=listPageURL%>">返回列表页</a>  

  <script src="assets/js/jquery.js"></script>
  <script src="assets/js/jquery-1.8.3.min.js"></script>
  <script src="assets/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
  <script src="assets/js/jquery.scrollTo.min.js"></script>
  <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
  <script src="assets/js/jquery.sparkline.js"></script>



  


</body>
</html>