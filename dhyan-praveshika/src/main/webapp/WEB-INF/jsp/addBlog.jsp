
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
      <section class="sidebar">
        <div class="user-panel">
          <div class="info">
            <p>Dhyan Praveshika Team</p>
            <a href="javascript:void(0)"><i class="fa fa-circle text-success"></i> Admin</a>
          </div>
        </div>

        <ul class="sidebar-menu" data-widget="tree">
          <li class="header">Menu</li>
          <li class="active"><a href="<c:url value="/getArticles"/>"><i class="fa fa-list-alt"></i> <span>Articles</span></a></li>
          <li><a  href="<c:url value="/events.html"/>"><i class="fa fa-calendar"></i> <span>Events</span></a></li>
          <li><a  href="<c:url value="/videos"/>"><i class="fa fa-play"></i> <span>Videos</span></a></li>
          <li><a  href="<c:url value="/userManagement"/>"><i class="fa fa-user"></i> <span>User Management</span></a></li>
          <li><a  href="<c:url value="/donationList"/>"><i class="fa fa-user"></i> <span>Donations</span></a></li>
        </ul>
      </section>
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          Add new article
        </h1>
        
      </section>
      
      <!-- Main content -->
      <section class="content container-fluid">
      <form action = "/addArticle" method = "post">
        <div class="box">
        
        <div class="form-group">
              <label>Article Title</label>
              <input type="text"  name="articleTital" class="form-control">
            </div>

            <div class="form-group">
              <label>Creator Name</label>
              <input type="text" name="authorName" class="form-control">
            </div>
            
            <div class="form-group">
              <label>Category</label>
              <input type="text" name="category" class="form-control">
            </div>

            <div class="form-group">
              <label>Article</label>
              <textarea id="editor12" name="articleDescription" rows="10" cols="80">
               
              </textarea>
            </div>
        </div>
        <div class="text-right clearfix">
          <input type = "submit" class="btn btn-primary" value = "Save"/>
          <input type="button" class="btn btn-default" value = "Cancel"/>
        </div>
        </form>
      </section>
      <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
	
	<jsp:include page="footer.jsp"></jsp:include>
    <!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
  <!-- ./wrapper -->


  <!-- REQUIRED JS SCRIPTS -->
  <!-- jQuery 3 -->
  <script src="lib/jquery/jquery.min.js"></script>
  <!-- Bootstrap 3.3.7 -->
  <script src="lib/bootstrap/js/bootstrap.min.js"></script>
  <!-- Data table -->
  <script src="lib/data-tables/js/datatables.min.js"></script>
  <!-- CK Editor -->
  <script src="lib/ckeditor/ckeditor.js"></script>
  <script src="lib/ckeditor/config.js"></script>
 
  <!-- AdminLTE App -->
  <script src="js/adminlte.js"></script>
  <!-- AdminLTE App -->
  <script src="js/custom.js"></script>
  <script>
    $(function () {
      CKEDITOR.replace('editor12');
    });
  </script>
</body>

</html>