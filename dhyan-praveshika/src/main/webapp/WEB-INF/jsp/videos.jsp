<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>

<head>
  <jsp:include page="header.jsp"></jsp:include>
</head>

<body class="hold-transition skin-blue fixed sidebar-mini">
 <!--  <div class="wrapper">
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
              <a href="login.html">
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
          <li><a href="/getArticles"><i class="fa fa-list-alt"></i> <span>Articles</span></a></li>
          <li><a href="/events"><i class="fa fa-calendar"></i> <span>Events</span></a></li>
          <li class="active"><a href="/videos"><i class="fa fa-play"></i> <span>Videos</span></a></li>
          <li><a href="/userManagement"><i class="fa fa-user"></i> <span>User Management</span></a>
          </li>
          <li><a href="/donationList"><i class="fa fa-user"></i> <span>Donations</span></a></li>
        </ul>
      </section>
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          Videos
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
            <table id="videoes" class="table table-bordered table-striped table-hover">
              <thead>
                <tr>
                  <th>Video Name</th>
                  <th>Video Url</th>
                  <th>Video category</th> 
                  <th style="width:80px">Actions</th>
                </tr>
              </thead>
              
              
            </table>
          </div>
        </div>
        <div class="text-right clearfix">
          <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editAddVideoModal"> Add New
            Video </button>
        </div>
      </section>
      <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <jsp:include page="footer.jsp"></jsp:include>

    <!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
  <!-- ./wrapper -->
<jsp:include page="addVideosLink.jsp"></jsp:include>
  
  <!-- REQUIRED JS SCRIPTS -->
  <!-- jQuery 3 -->
  <script src="lib/jquery/jquery.min.js"></script>
  <!-- Bootstrap 3.3.7 -->
  <script src="lib/bootstrap/js/bootstrap.min.js"></script>
  <!-- Data table -->
  <script src="lib/data-tables/js/datatables.min.js"></script>
  
  <!-- sweetalert  -->
  <script src="lib/sweetalert/sweetalert.min.js"></script>
  
  <!-- AdminLTE App -->
  <script src="js/adminlte.js"></script>
  <!-- AdminLTE App -->
  <script src="js/custom.js"></script>
  
  
</body>

</html>