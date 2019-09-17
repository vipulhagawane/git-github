
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
  <script src="<c:url value="/resources/lib/jquery/jquery.min.js" />"></script>
  <jsp:include page="header.jsp"></jsp:include>
</head>

<body class="hold-transition skin-blue fixed sidebar-mini">

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
          <li><a href="<c:url value="/events"/>"><i class="fa fa-calendar"></i> <span>Events</span></a></li>
          <li class="active"><a href="<c:url value="/videos"/>"><i class="fa fa-play"></i> <span>Videos</span></a></li>
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
                  <th style="width:100px">Video Name</th>
                  <th>Video Url</th>
                  <th style="width:100px">Video Category</th> 
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
 
  <!-- Bootstrap 3.3.7 -->
  <script src="<c:url value="/resources/lib/bootstrap/js/bootstrap.min.js"/>"></script>
  <!-- Data table -->
  <script src="<c:url value="/resources/lib/data-tables/js/datatables.min.js"/>"></script>
  <!-- CK Editor -->
  <script src="<c:url value="/resources/lib/ckeditor/ckeditor.js"/>"></script>
  <script src="<c:url value="/resources/lib/ckeditor/config.js"/>"></script>
  
  <!-- sweetalert  -->
  <script src="<c:url value="/resources/lib/sweetalert/sweetalert.min.js"/>"></script>
  
  <!-- AdminLTE App -->
  <script src="<c:url value="/resources/js/adminlte.js"/>"></script>
  <!-- AdminLTE App -->
 
  <script src="<c:url value="/resources/js/videoes.js"/>"></script>
  
  
</body>

</html>