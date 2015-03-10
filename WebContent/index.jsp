<%@page import="com.cp.basefunc.GetTime"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mysql.fabric.xmlrpc.base.Data"%>
<%@page import="com.cp.serverInfo.ServerInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="wirelessLab">
    <meta name="keyword" content="安全, Bootstrap, 管理, Responsive, Fluid, Retina">

    <title>安全追溯系统平台</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">
	<script type="text/javascript" src="js/getserverstate.js"></script>
    <script src="assets/js/chart-master/Chart.js"></script>
    <script type="text/javascript" src="js/contentHeight.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body onload="setContentHeight('mainheight',0.63);timer()">
	<%!ServerInfo serverInfo = new ServerInfo(); %>

  <section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
      <header class="header black-bg">
            <div class="sidebar-toggle-box">
              <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation">
                
              </div>
            </div>
            <!--logo start-->
            <a href="index.jsp" class="logo"><b>安全追溯平台</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
                <ul class="nav top-menu">
                    <!-- settings start -->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.jsp#">
                            <i class="fa fa-tasks"></i>
                            <span class="badge bg-theme"></span>
                        </a>
                        <ul class="dropdown-menu extended tasks-bar">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 4 pending tasks</p>
                            </li>
                            <li>
                                <a href="index.jsp#">
                                    <div class="task-info">
                                        <div class="desc">DashGum Admin Panel</div>
                                        <div class="percent">40%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                           
                        </ul>
                    </li>
                    <!-- settings end -->
                    <!-- inbox dropdown start-->
                    <li id="header_inbox_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.jsp#">
                            <i class="fa fa-envelope-o"></i>
                            <span class="badge bg-theme"></span>
                        </a>
                        <ul class="dropdown-menu extended inbox">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 5 new messages</p>
                            </li>
                            <li>
                                <a href="index.jsp#">
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-zac.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Zac Snider</span>
                                    <span class="time">Just now</span>
                                    </span>
                                    <span class="message">
                                        Hi mate, how is everything?
                                    </span>
                                </a>
                            </li>
                            
                        </ul>
                    </li>
                    <!-- inbox dropdown end -->
                </ul>
                <!--  notification end -->
            </div>
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="login.jsp">退出</a></li>
            	</ul>
              <ul class="nav pull-right top-menu">
                    <li><a class="logout" href="lock_screen.jsp">锁屏</a></li>
              </ul>
            </div>
        </header>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="index.jsp"><img src="assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
              	  <h5 class="centered">CP Admin</h5>
              	  	
                  <li class="mt">
                      <a class="active" href="index.jsp">
                          <i class="fa fa-dashboard"></i>
                          <span>主界面</span>
                      </a>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-phone"></i>
                          <span>智能终端管理</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="newspub.jsp">新闻发布</a></li>
                          <li><a  href="promotion.jsp">优惠促销</a></li>
                          <li><a  href="feedback.jsp">用户反馈</a></li>
                      </ul>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-desktop"></i>
                          <span>查询终端管理</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="aboutcp.jsp">关于正大</a></li>
                          <li><a  href="safetrace.jsp">安全追溯</a></li>
                          <li><a  href="advideo.jsp">宣传视频</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                    <a href="javascript:;" >
                          <i class="fa fa-cogs"></i>
                          <span>应用版本管理</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="applist.jsp?apptype=android">安卓终端</a></li>
                          <li><a  href="applist.jsp?apptype=ios">IOS终端</a></li>
                          <li><a  href="applist.jsp?apptype=winphone">微软终端</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-user"></i>
                          <span>系统帐户管理</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="createaccount.jsp">添加账户</a></li>
                          <li><a  href="accountprofile.jsp?type=server">后台账户管理</a></li>
                          <li><a  href="accountprofile.jsp?type=remote">远程账户管理</a></li>
                      </ul>
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">

              <div class="row">
                  <div class="row"></div>
                  <div class="col-lg-12 main-chart">
                    
                    <div class="row mtbox">
                    <div class="col-md-1 col-sm-1"></div>
                      <div class="col-md-2 col-sm-2 col-md-offset-1 box0">
                        <div class="box1">
                            <span class="li_heart"></span>
                                <h3>IP</h3>
                        </div>
                 			 <p><%=serverInfo.getIpAddr()%></p>
                      </div>
                      <div class="col-md-2 col-sm-2 box0">
                        <div class="box1">
	                  		<span class="li_cloud"></span>
	                 		 <h3>系统名称</h3>
                       	</div>
                 		 	<p><%=serverInfo.getOsDesc() %></p>
                      </div>
                      <div class="col-md-2 col-sm-2 box0">
                        <div class="box1">
			                  <span class="li_stack"></span>
			                  <h3>系统类型</h3>
                        </div>
                  			<p><%=serverInfo.getOsType()%></p>
                      </div>
                      <div class="col-md-2 col-sm-2 box0">
                        <div class="box1">
		                  <span class="li_news"></span>
		                  <h3>系统版本</h3>
                        </div>
                 			 <p><%=serverInfo.getOsVersion()%></p>
                      </div>
                   
                    
                    </div>
            



              <div class="row">
                  
                  <div class="col-lg-10 main-chart"> 	
                    <!-- here add content -->
                    
                      <div class="row mt" id="mainheight">
                      <!-- SERVER STATUS PANELS -->
                      <div class="col-md-2"></div>
                        <div class="col-md-5 col-sm-5 mb">
                          <div class="white-panel pn donut-chart">
                            <div class="white-header">
                                <h5 style="color:black;">内存状态</h5>
                            </div>
                            <div class="row">
                              <div class="col-sm-4 col-xs-4 goleft">

                                <p><i class="fa fa-database"></i><span id="memstatetitle"><%=serverInfo.getMemUsageRatio()%></span>%</p>
                              </div>
                            </div>
                              <canvas id="serverstatus01" height="120" width="140"></canvas>
                              <script>
                                var doughnutData = [
                                    {

                                      value: <%=serverInfo.getMemUsageRatio()%>,
                                      color:"#68dff0"
                                    },
                                    {
                                      value : <%=100-serverInfo.getMemUsageRatio()%>,

                                      color : "#fdfdfd"
                                    }
                                  ];
                                  var myDoughnut = new Chart(document.getElementById("serverstatus01").getContext("2d")).Doughnut(doughnutData);
                              </script>
                            </div>
                        </div>


                      
                    

                  <div class="col-md-5 mb">
                          <div class="darkblue-panel pn">
                            <div class="darkblue-header">
                    			<h5>硬盘状态</h5>
                            </div>
                <canvas id="serverstatus02" height="120" width="140"></canvas>
	                <script>
	                  var doughnutData = [
	                      {
	                        value: <%=serverInfo.getDiskRatio()%>,
	                        color:"#68dff0"
	                      },
	                      {
	                        value : <%=100-serverInfo.getDiskRatio()%>,
	                        color : "#444c57"
	                      }
	                    ];
	                    var myDoughnut = new Chart(document.getElementById("serverstatus02").getContext("2d")).Doughnut(doughnutData);
	                </script>
                		<p><%=GetTime.getPageDate() %></p>
	                <footer>
	                  <div class="pull-left">
	                    <h5><i class="fa fa-hdd-o"></i><span id="diskall"><%=serverInfo.getDiskAll()%></span>GB</h5>
	                  </div>
	                  <div class="pull-right">
	                    <h5><span id="diskratio"><%=serverInfo.getDiskRatio() %></span>% Used</h5>
	                  </div>
	                </footer>
                </div>
            </div>

                    <!-- here finish add content -->
                  </div><!-- /col-lg-10 END SECTION MIDDLE --> 
                  <div class="col-lg-1"></div>                 
              </div>
          </section>
      </section>

      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer">
          <div class="text-center">
               <a href="http://www.cpegg.com" target="_blank">正大集团</a> 
              <a href="#container" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
      <!--footer end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
  <script src="assets/js/jquery.js"></script>
  <script src="assets/js/jquery-1.8.3.min.js"></script>
  <script src="assets/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
  <script src="assets/js/jquery.scrollTo.min.js"></script>
  <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
  <script src="assets/js/jquery.sparkline.js"></script>


  <!--common script for all pages-->
  <script src="assets/js/common-scripts.js"></script>
  
  <script type="text/javascript" src="assets/js/gritter/js/jquery.gritter.js"></script>
  <script type="text/javascript" src="assets/js/gritter-conf.js"></script>

  <!--script for this page-->
  <script src="assets/js/sparkline-chart.js"></script>    
  <script src="assets/js/zabuto_calendar.js"></script>	
	

	
	<script type="application/javascript">
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            });
        });
        
        
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
  </script>
  

  </body>
</html>
    