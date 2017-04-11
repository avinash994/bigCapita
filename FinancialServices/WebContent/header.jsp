<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="css/main.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="modal.js"></script>
	<style type="text/css">
	.carousel{
		background: #2f4357;
		margin-top: 20px;
	}
	.carousel .item img{
		margin: 0 auto; 
	}
<!-- 	</style>
<script type="text/javascript">
 </script>
  </head>
<title>bigCAPITA</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.jsp">bigCAPITA</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="index.jsp">Home</a></li>
			<li><a href="${pageContext.request.contextPath}/GotoAuditServlet">Audit</a></li>
			<li><a href="${pageContext.request.contextPath}/GotoAccounting">Accounting</a></li>
			<li><a href="${pageContext.request.contextPath}/GotoBusinessServlet">Business Risk</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li id="change"><a href="#" data-toggle="modal"
				data-target="#Signup"><span class="glyphicon glyphicon-user"></span>
					Sign Up</a></li>
			<li><a href="#" data-toggle="modal" data-target="#login"><span
					class="glyphicon glyphicon-log-in"></span> Login</a></li>
		</ul>

		<div id="login" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						Login
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<form method="POST" action="doLogin">
							<input type="text" class="form-control" id="userName"
								name="userName" placeholder="Username" required/> <br /> <input type="password"
								class="form-control" id="password" name="password"
								placeholder="Password" required/> <br />
							<button type="submit" class="btn btn-success">Login</button>

						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<div id="Signup" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						Signup
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<form method="POST" action="DoSignupServlet">
							<br /> <span id="errorname" /> <input type="text"
								class="form-control" id="userName" name="userName" placeholder="UserName" required/> <br /> <input
								type="text" class="form-control" id="company_name"
								name="companyName" placeholder="Company Name" required/> <br /> <input type="password"
								class="form-control" id="password" name="password" placeholder="Password" required/> <br /> <input
								type="text" class="form-control" id="phone" name="phone"
								value="PHONE" placeholder="Contact" required/> <br />
							<button type="submit" class="btn btn-success" onClick="check()">Signup</button>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</nav>
</body>
</html>