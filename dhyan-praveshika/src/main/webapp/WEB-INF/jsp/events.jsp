<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>

<head>
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
          <li><a href="/getArticles"><i class="fa fa-list-alt"></i> <span>Articles</span></a></li>
          <li class="active"><a href="/events.html"><i class="fa fa-calendar"></i> <span>Events</span></a></li>
          <li><a href="/videos"><i class="fa fa-play"></i> <span>Videos</span></a></li>
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
            <table id="example" class="table table-bordered table-striped table-hover">
              <thead>
                <tr>
                  <th>Event&nbsp;Name</th>
                  <th>Description</th>
                  <th>Date And Time</th>
                  <th>Location</th>
                  <th style="width:60px">Actions</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>Event 1</td>
                  <td>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been
                    the industry's standard dummy text ever since the 1500s</td>
                  <td>16-08-2019 at 04:00pm</td>
                  <td>Viman nagar pune</td>
                  <td>
                    <a class="btn btn-info tblBtn" data-toggle="modal" data-target="#editAddEventModal"><i
                        class="fa fa-pencil"></i></a>
                    <a class="btn btn-danger tblBtn"><i class="fa fa-trash"></i></a>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <div class="text-right clearfix">
          <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editAddEventModal"> Add New
            Event</button>
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
  </div>
  <!-- ./wrapper -->

  <!--Modal edit View Article-->
  <div class="modal fade" id="editAddEventModal" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class="modal-content">
        <form action="/action_page.php">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Add/Edit Event</h4>
          </div>
          <div class="modal-body">

            <div class="form-group">
              <label>Event Title</label>
              <input type="text" rows="4" class="form-control">
            </div>

            <div class="form-group">
              <label>Event Image</label>
              <div class="input-group">
                <input id="hiddenFileOpner" class="hidden" type="file" class="form-control"
                  placeholder="Select Iamage...">
                <input id="imageNameShowBox" type="text" class="form-control" placeholder="Select Iamage..." readonly>
                <span class="input-group-btn" id="eventSelectImage">
                  <button class="btn btn-default" type="button">Browse</button>
                </span>
              </div><!-- /input-group -->
            </div>

            <div class="form-group">
              <label>Description</label>
              <textarea type="text" rows="3" class="form-control"></textarea>
            </div>

            <div class="row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label>Event Date</label>
                  <input type="date" class="form-control">
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label>Event Time</label>
                  <input type="time" class="form-control">
                </div>
              </div>
            </div>

            <div class="form-group">
              <label>Location</label>
              <input type="text" class="form-control">
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
  <!-- AdminLTE App -->
  <script src="js/adminlte.js"></script>
  <!-- AdminLTE App -->
  <script src="js/custom.js"></script>
  <script>
    $('#eventSelectImage').on('click', function () {
      $('#hiddenFileOpner').trigger('click');
      $('#hiddenFileOpner[type="file"]').change(function (e) {
        var fileName = e.target.files[0].name;
        $('#imageNameShowBox').val(fileName);
      });

    });
  </script>
</body>

</html>