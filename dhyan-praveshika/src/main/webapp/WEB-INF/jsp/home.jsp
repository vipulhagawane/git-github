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
          <li class="active"><a href="/getArticles"><i class="fa fa-list-alt"></i> <span>Articles</span></a></li>
          <li><a href="events.html"><i class="fa fa-calendar"></i> <span>Events</span></a></li>
          <li><a href="/videos"><i class="fa fa-play"></i> <span>Videos</span></a></li>
          <li><a href="/userManagement"><i class="fa fa-user"></i> <span>User Management</span></a></li>
          <li><a href="/donationList"><i class="fa fa-user"></i> <span>Donations</span></a></li>
        </ul>
      </section>
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
    <form action = "/addBlog">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          List Of Articles
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
            <table id="article" class="table table-bordered table-striped table-hover">
              <thead>
                <tr>
                  <th>Name Of Article</th>
                  <th>Date</th>
                  <th>Created By</th>
                  <th>Category</th>
                  <th style="width:80px">Actions</th>
                </tr>
            <!--   </thead>
              <tbody>
                <tr>
                  <td>Sanatana Dharma, it’s Origins and Philosophy</td>
                  <td>18th July 2019</td>
                  <td>Dhyan Praveshika Team</td>
                  <td>HomeArticles</td>
                  <td>
                    <a class="btn btn-info tblBtn"><i class="fa fa-pencil"></i></a>
                    <a class="btn btn-warning tblBtn"><i class="fa fa-eye"></i></a>
                    <a class="btn btn-danger tblBtn"><i class="fa fa-trash"></i></a>
                  </td>
                </tr>
                <tr>
                  <td>How Karma Works and its Foundations </td>
                  <td>25th June 2019</td>
                  <td>Dhyan Praveshika Team</td>
                  <td>HomeArticles</td>
                  <td>
                    <a class="btn btn-info tblBtn"><i class="fa fa-pencil"></i></a>
                    <a class="btn btn-warning tblBtn"><i class="fa fa-eye"></i></a>
                    <a class="btn btn-danger tblBtn"><i class="fa fa-trash"></i></a>
                  </td>
                </tr>
                <tr>
                  <td>THE PURPOSE OF THE SOUL ACCORDING TO HINDUISM </td>
                  <td>17th June 2019</td>
                  <td>Dhyan Praveshika Team</td>
                  <td>HomeArticles</td>
                  <td>
                    <a class="btn btn-info tblBtn"><i class="fa fa-pencil"></i></a>
                    <a class="btn btn-warning tblBtn"><i class="fa fa-eye"></i></a>
                    <a class="btn btn-danger tblBtn"><i class="fa fa-trash"></i></a>
                  </td>
                </tr>
              </tbody> -->
            </table>
          </div>
        </div>
        <div class="text-right clearfix">
          <input type = "submit" class="btn btn-primary" value = "Add New Article"/>
        </div>
      </section>
      <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
   <!--  <footer class="main-footer">
      To the right
      <div class="pull-right hidden-xs">
        Developed by <a href="http://www.dahlia-tech.com/" target="_blank">Dahlia Technologies</a>
      </div>
      Default to the left
      <strong>Copyright &copy; 2019 <a href="#">Dhyan Praveshika</a>.</strong> All rights reserved.
    </footer> -->
	
	<jsp:include page="footer.jsp"></jsp:include>
    <!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
  </div>
  <!-- ./wrapper -->

  <!--Modal edit View Article-->
  <div class="modal fade" id="editViewArticleModal" role="dialog">
    <div class="modal-dialog modal-lg">

      <!-- Modal content-->
      <div class="modal-content">
      
      <!-- add new Articale --> 
        <form action="/addArticles" method="post" >
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Add New Article</h4>
          </div>
          <div class="modal-body">

            <div class="form-group">
              <label>Article Title</label>
              <input type="text"  name="articalTitel" class="form-control">
            </div>

            <div class="form-group">
              <label>Creator Name</label>
              <input type="text" name="articalName" class="form-control">
            </div>

            <div class="form-group">
              <label>Article</label>
              <textarea id="editor12" name="articalMeaasge" rows="10" cols="80">
                Please start writing article here
              </textarea>
            </div>
          </div>

          <div class="modal-footer">
            <button type="button" class="btn btn-primary" data-dismiss="modal">Save</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
          </div>
        </form>
      </div>
    </div>
  </div>
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
