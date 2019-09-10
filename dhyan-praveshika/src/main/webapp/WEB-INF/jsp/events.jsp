<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="session.jsp"></jsp:include>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>

<head>

  <!-- jQuery 3 -->
  <script src="<c:url value="/resources/lib/jquery/jquery.min.js"/>"></script>
<jsp:include page="header.jsp"></jsp:include>
 <!--  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Dhyan Praveshika | Events</title>
  <link rel='shortcut icon' type='image/x-icon' href='img/favicon.ico' />
  Tell the browser to be responsive to screen width
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css">
  Font Awesome
  <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.min.css">
  Theme style
  <link rel="stylesheet" href="css/AdminLTE.css">
  Custom style
  <link rel="stylesheet" href="css/style.css">
  Data table CSS
  <link rel="stylesheet" href="lib/data-tables/css/datatables.min.css">
  HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries
  WARNING: Respond.js doesn't work if you view the page via file://
  [if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]

  Google Font
  <link rel="stylesheet"
    href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">-->
    
</head> 
<body class="hold-transition skin-blue fixed sidebar-mini">
  <!-- <div class="wrapper">
    Main Header
    <header class="main-header">
      Logo
      <a href="index2.html" class="logo">
        mini logo for sidebar mini 50x50 pixels
        <span class="logo-mini"><img src="img/dhyanPraveshikaIcon.png"></span>
        logo for regular state and mobile devices
        <span class="logo-lg"><img src="img/dhyanPraveshikaIcon.png"> Dhyan Praveshika</span>
      </a>

      Header Navbar
      <nav class="navbar navbar-static-top" role="navigation">
        Sidebar toggle button
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
          <span class="sr-only">Toggle navigation</span>
        </a>
        Navbar Right Menu
        <div class="navbar-custom-menu">
          <ul class="nav navbar-nav">
            <li>
              <a href="/login">
                <i class="fa fa-sign-out" aria-hidden="true"></i>
                Sign out
              </a>
            </li>
          </ul>
        </div>
      </nav>
    </header> -->
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
      <section class="sidebar">
        <div class="user-panel">
          <div class="info">
            <p>Dhyan Praveshika Team</p>
            <a href="javascript:void(0)"><i class="fa fa-circle text-success"></i> Admin</a>
          </div>
        </div>

        <form action="#" method="get" class="sidebar-form">
          <div class="input-group">
            <input type="text" name="q" class="form-control" placeholder="Search...">
            <span class="input-group-btn">
              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
              </button>
            </span>
          </div>
        </form>

        <ul class="sidebar-menu" data-widget="tree">
          <li class="header">HEADER</li>
          <li><a href="<c:url value="/getArticles"/>"><i class="fa fa-list-alt"></i> <span>Articles</span></a></li>
          <li class="active"><a href="<c:url value="/events"/>"><i class="fa fa-calendar"></i> <span>Events</span></a></li>
          <li><a href="<c:url value="/videos"/>"><i class="fa fa-play"></i> <span>Videos</span></a></li>
          <li><a href="<c:url value="/userManagement"/>"><i class="fa fa-user"></i> <span>User Management</span></a>
          </li>
          <li><a href="<c:url value="/donationList"/>"><i class="fa fa-user"></i> <span>Donations</span></a></li>
        </ul>
      </section>
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          Events
          <small>Optional description</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
          <li class="active">Here</li>
        </ol>
      </section>
      <!-- Main content -->
      <section class="content container-fluid">
        <div class="box">
          <!-- /.box-header -->
          <div class="box-body">
            <table id="events" class="table table-bordered table-striped table-hover">
              <thead>
                <tr>
                  <th>Title</th>
                  <th>Description</th>
                  <th>Date</th>
                  <th>Time</th>
                  <th>Location</th>
                  <th style="width:80px">Actions</th>
                </tr>
              </thead>
              
            </table>
          </div>
        </div>
        <div class="text-right clearfix">
          <input type="submit" class="btn btn-primary" data-toggle="modal" data-target="#editAddEventModal" value="Add New Event"/> 
        </div>
      </section>
      <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <footer class="main-footer">
      <!-- To the right -->
      <div class="pull-right hidden-xs">
        Developed by <a href="http://www.dahlia-tech.com/" target="_blank">Dahlia Technologies</a>
      </div>
      <!-- Default to the left -->
      <strong>Copyright &copy; 2019 <a href="#">Dhyan Praveshika</a>.</strong> All rights reserved.
    </footer>

    <!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
  <!-- ./wrapper -->

  <jsp:include page="addEvent.jsp"></jsp:include>
  <!-- REQUIRED JS SCRIPTS -->
  <!-- Bootstrap 3.3.7 -->
  <script src="<c:url value="/resources/lib/bootstrap/js/bootstrap.min.js"/>"></script>
  <!-- Data table -->
  <script src="<c:url value="/resources/lib/data-tables/js/datatables.min.js"/>"></script>
  
     <!-- sweetalert  -->
  <script src="<c:url value="/resources/lib/sweetalert/sweetalert.min.js"/>"></script>
  <!-- AdminLTE App -->
  <script src="<c:url value="/resources/js/adminlte.js"/>"></script>
  <!-- AdminLTE App -->
  <script src="<c:url value="/resources/js/custom.js"/>"></script>
  <script src="<c:url value="/resources/js/event.js"/>"></script>
  
</body>

</html>