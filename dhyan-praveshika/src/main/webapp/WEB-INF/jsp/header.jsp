<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%        
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    //response.setDateHeader("Expires", "0");
%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  
  <meta http-equiv="Cache-control" content="no-cache, no-store, must-revalidate"/>
<meta http-equiv="This-Header-Is-Set" content="no-cache, no-store, must-revalidate"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/> 
  <title>Dhyan Praveshika | Articles</title>
  <link rel='shortcut icon' type='image/x-icon'  href="<c:url value="/resources/img/favicon.ico"/>">
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="<c:url value="/resources/lib/bootstrap/css/bootstrap.min.css"/>">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<c:url value="/resources/lib/font-awesome/css/font-awesome.min.css"/>">
  <!-- Theme style -->
  <link rel="stylesheet" href="<c:url value="/resources/css/AdminLTE.css"/>">
  <!-- Custom style -->
  <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
  <!-- Data table CSS -->
  <link rel="stylesheet" href="<c:url value="/resources/lib/data-tables/css/datatables.min.css"/>">
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <!-- <link rel="stylesheet"
    href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic"> -->
</head>


<body class="hold-transition skin-blue fixed sidebar-mini">
  <div class="wrapper">
    <!-- Main Header -->
    <header class="main-header">
      <!-- Logo -->
      <a href="/dhyanpraveshika-web/getArticles" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><img src="<c:url value="/resources/img/dhyanPraveshikaIcon.png"/>"></span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><img src="<c:url value="/resources/img/dhyanPraveshikaIcon.png"/>"> Dhyan Praveshika</span>
      </a>

      <!-- Header Navbar -->
      <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
          <span class="sr-only">Toggle navigation</span>
        </a>
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
          <ul class="nav navbar-nav">
            <li>
              <a href="/dhyanpraveshika-web/signOut">
                <i class="fa fa-sign-out" aria-hidden="true"></i>
                Sign out
              </a>
            </li>
          </ul>        </div>
      </nav>
    </header>
</body>
</html>