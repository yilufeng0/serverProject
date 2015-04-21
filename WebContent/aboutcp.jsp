<%@page import="com.cp.exhibition.SelectCpImgVideo"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
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
	<script src="js/forWebAction.js"></script>
    <script src="assets/js/chart-master/Chart.js"></script>
    <script type="text/javascript" src="js/contentHeight.js"></script>
    <script type="text/javascript" src="js/editcp.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body onload="setContentHeight('main-content',0.95)"> 
 <%
  	ResultSet rs = SelectCpImgVideo.selectCpImgVideo("image","0");
  %>
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
            
            <div class="top-menu">
              <ul class="nav pull-right top-menu">
                    <li><a class="logout" href="logout.jsp">退出</a></li>
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
                      <a href="index.jsp">
                          <i class="fa fa-dashboard"></i>
                          <span>主界面</span>
                      </a>
                  </li>

                  <li class="sub-menu">
                      <a  href="javascript:;" >
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
                      <a class="active" href="javascript:;" >
                          <i class="fa fa-desktop"></i>
                          <span>查询终端管理</span>
                      </a>
                      <ul class="sub">
                          <li class="active"><a  href="aboutcp.jsp">关于正大</a></li>
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
                  <div class="col-lg-1"></div>
                  <div class="col-lg-10 main-chart">  
                    <!-- here add content -->
                	
                	    <div id="myModal" class="modal fade bs-example-modal-lg" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1">
                        <div class="modal-dialog">
                          <!--<div class="modal-content">                            
                            <div class="modal-body">
                              <img id="modalImg" src="">
                            </div> -->
                           <img id="modalImg" src="">
                          </div>
                        </div>
                      </div> 
                      <div id="myModaldes" class="modal fade bs-example-modal-lg" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1">
                        <div class="modal-dialog">
                          <div class="modal-content">                            
                            <div class="modal-header">
                              <div class="modal-title text-center"><h4 id="edittitle">描述信息</h4></div>
                            </div>
                            <div class="modal-body">                                                         
                             	<input class="form-control" id="modaldes">
                            </div>
                            <div class="modal-footer">
                              <button class="btn btn-default" data-dismiss="modal" type="button">放弃</button>
                              <label style="display:none" id="submitid">2222</label>
                              <button class="btn btn-primary" onclick="suretodesc()">提交</button>
                            </div>
                          </div>
                        </div>
                      </div> 
                    <div class="showback">
                    	<a href="addnewcp.jsp"><button class="btn btn-success btn-lg">上传图片</button></a>
                    </div>
                    <div class="showback text-center" style="">                      
                        <table class="table table-striped table-hover">
                      <thead>
                        <tr>
                          <th class="col-sm-1 text-center">#</th>
                          <th class="col-sm-2 text-center">图片</th>
                          <th class="col-sm-1 text-center">描述</th>
                          <th class="col-sm-2 text-center">上传时间</th>
                          <th class="col-sm-1 text-center">操作</th>
                        </tr>
                      </thead>
                      <tbody>
                      <!-- 表格开始   -->
                          <!-- 此处内容有JSP动态生成 -->
                          <!-- example start -->
                       <%
                       if(rs!=null){
                        try{
                     	  while(rs.next()){                   		 
                       %>
                        <tr class="text-center" id="<%=rs.getInt("ID") %>">
                          <td><%=rs.getRow() %></td>
                          <td><img alt="error" src=<%=rs.getString("thumbpath")%> onclick="dispImg(<%=rs.getInt("ID")%>)"></td>
                          <td id="des<%=rs.getInt("ID") %>"><%=rs.getString("description")!=null?rs.getString("description"):"" %></td>
                          <td><%=rs.getString("showTime")!=null?rs.getString("showTime"):"" %></td>
                          <td>
                            <button class="btn btn-primary btn-xs" onclick="editItem(<%=rs.getInt("ID")%>)"><i class="fa fa-pencil"></i></button>
                            <button class="btn btn-danger btn-xs" onclick="deleteItem(<%=rs.getInt("ID")%>,'cpimg')"><i class="fa fa-trash-o"></i></button>
                          </td>
                          </tr>
                        <%
                          }
                         }catch(SQLException e){
                    	 e.printStackTrace();
                        }
                       }
                       %> 
                          <!-- example end -->
                          
                        <!-- 表格结束 -->
                        <tr id="endpos" style="display:none"><td></td></tr>
                      </tbody>
                    </table>

                    </div>           	
                	
					<jsp:include page="loadmore.jsp">
						<jsp:param value="aboutcpimageload" name="loadType"/>
					</jsp:include>
                    <!-- here finish add content -->
                  </div><!-- /col-lg-10 END SECTION MIDDLE --> 
                  <div class="col-lg-1"></div>                 
              </div>
          </section>
      </section>

      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer navbar-fixed-bottom">
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
