<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>安全追溯管理系统</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">
	<script type="text/javascript" src="js/forLogin.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	  <div id="login-page">
	  	<div class="container">
	  	
		      <form class="form-login" method="POST" action="accountauth.jsp">
		        <h2 class="form-login-heading">用户验证</h2>
		        <div class="">
		        <div class="col-sm-4"></div>
		        	<img src="img/loginpic.png" class="img-circle" style="width:96px;height:96px;">
		        </div>
		        <div class="login-wrap">
		            <input  id="account" type="text" class="form-control  text-center" name="account" placeholder="用户名" autofocus>
		            <br>
		            <input id="passwd" type="password" class="form-control text-center" name="passwd" placeholder="密码">
		            <br>
		            <!--  <button  onclick="mainPaeSubmit()" class="btn btn-theme btn-block" ><i class="fa fa-lock"></i>登&nbsp;&nbsp;录</button>  -->
		            <button  type="submit" class="btn btn-theme btn-block" ><i class="fa fa-lock"></i>登&nbsp;&nbsp;录</button>
		            <hr>	            
		            
		        </div>	
		         
		     </form>	
	  	</div>
	  </div>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
    <script>
        $.backstretch("assets/img/login-bg.jpg", {speed: 500});
    </script>


  </body>
</html>
