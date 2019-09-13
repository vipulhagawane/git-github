<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("This-Header-Is-Set", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Cache-control" content="no-cache, no-store, must-revalidate"/>
<meta http-equiv="This-Header-Is-Set" content="no-cache, no-store, must-revalidate"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel='shortcut icon' type='image/x-icon' href="<c:url value="/resources/img/favicon.ico" />">
<title>Admin | Dhyan Praveshika</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<!-- <link rel="stylesheet" href="/lib/bootstrap/css/bootstrap.min.css"> -->
<link rel="stylesheet" href="<c:url value="/resources/lib/bootstrap/css/bootstrap.min.css"/>">
<!-- Font Awesome -->
<link rel="stylesheet" href="<c:url value="/resources/lib/font-awesome/css/font-awesome.min.css"/>">
<!-- <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.min.css"> -->
<!-- Theme style -->
<link rel="stylesheet" href="<c:url value="/resources/css/AdminLTE.css"/>">
<!-- <link rel="stylesheet" href="css/AdminLTE.css"> -->

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>

<body class="hold-transition login-page">
	<div class="dispTbl">
		<div class="dispTblCell">
			<div class="login-box">
				<div class="login-logo">
					<a href="../../index2.html"> <img src="<c:url value="/resources/img/logo.png"/>">
					</a>
				</div>
				<!-- /.login-logo -->

				<div class="login-box-body text-center">
					<!-- <p class="login-box-msg">Login</p> -->
					<h3>Login</h3>
					<br>
					
					<form action="/dhyanpraveshika-web/home" method="post">
						
						<div class="form-group has-feedback">
							
							<input type="email" name="email" class="form-control" placeholder="Email">

							<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
						</div>
						<div class="form-group has-feedback">
							
							<input type="password"  name="password" class="form-control" placeholder="Password"> 
							
							<span class="glyphicon glyphicon-lock form-control-feedback"></span>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<input type="submit" class="btn btn-primary btn-block btn-flat" value="sign in" />
							</div>
							<font color="red">${errorMessag}</font>
						</div>
					</form>
					<br> <strong>Copyright &copy; 2019 <a href="#">Dhyan
							Praveshika</a>.
					</strong> <br> All rights reserved.
				</div>

				<!-- /.login-box-body -->
			</div>
			<!-- /.login-box -->
		</div>
	</div>
	<!-- jQuery 3 -->
	<!-- <script src="../../bower_components/jquery/dist/jquery.min.js"></script> -->
	<%-- <script src="<c:url value="/resources/jquery/dist/jquery.min.js" />"></script>
	<!-- Bootstrap 3.3.7 -->
	<!-- <script src="../../bower_components/bootstrap/dist/js/bootstrap.min.js"></script> -->
	<script src="<c:url value="/resources/bootstrap/dist/js/bootstrap.min.js"/>"></script>
	<!-- iCheck -->
	<script src="../../plugins/iCheck/icheck.min.js"></script>
	<script src="<c:url value="/resources/bootstrap/dist/js/bootstrap.min.js"/>"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' /* optional */
			});
		});
	</script> --%>
</body>

</html>