<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<link rel="stylesheet" type="text/css" href="main.css"/>
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
	#search h4{
		font-size:20px;
		padding:10px;
		margin:0px;
	}
<!-- 	</style>
<script type="text/javascript">
 </script>
 <jsp:include page="header.jsp"></jsp:include>
 </head>
 <body>
 
  <%-- <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">bigCAPITA</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Audit</a></li>
      <li><a href="#">Accounting</a></li>
	  <li><a href="#">Business Risk</a></li>
	  <li><a href="#">Investments</a></li>
    </ul>
	<ul class="nav navbar-nav navbar-right">
      <li id="change"><a href="#" data-toggle="modal" data-target="#Signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#" data-toggle="modal" data-target="#login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>

	<div id="login" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				Login
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
				  <form method="doPOST" action="doLogin">
					<input type="text" class="form-control" id="userName" name="userName" value="CY01"/>
					<br/>
					<input type="password" class="form-control" id="password" name="password" value="aks@1994"/>
					<br/>
					<button type="submit" class="btn btn-success">Login</button>
					<h3>${errorString}</h3>
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
						<br/>
						<span id="errorname"/>
						<input type="text" class="form-control" id="userName" name="userName" />
						<br/>
						<input type="text" class="form-control" id="company_name" name="companyName" />
						<br/>
						<input type="password" class="form-control" id="password" name="password" />
						<br/>
						<input type="text" class="form-control" id="phone" name="phone" value="PHONE"/>
					<br/>
					<button type="submit" class="btn btn-success" onClick="check()">Signup</button>
				</div>
				<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</nav> --%>
	<div class="bs-example">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>   
        <!-- Wrapper for carousel items -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="Images/1.jpg" alt="First Slide">
				</div>
				<div class="item">
					<img src="Images/2.jpg" alt="Second Slide">
				</div>
				<div class="item">
					<img src="Images/3.jpg" alt="Third Slide">
				</div>
			</div>
        <!-- Carousel controls -->
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</a>
			<a class="carousel-control right" href="#myCarousel" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>
	</div>
	<div id="search">
		<h4 align="center">SUBSCRIBE NEWSLETTER</h4>
		<div class="row">
			<div class="col-sm-4">
				<form>
					<div class="Newsletter" >
						<input type="text" class="form-control" id="name" value="NAME">
					</div>
				</form>
			</div>
			<div class="col-sm-4">
				<form>
					<div class="Newsletter" >
						<input type="email" class="form-control" id="email" value="EMAIL">
					</div>
				</form>
			</div>
			<div class="col-sm-4">
				<button class="button"><span>SUBSCRIBE </span></button>
			</div>
		</div>
	</div>
	<div id="mission">
		<div class="row">
			<div class="col-sm-4">
				<img id="missionj" src="Images/mission.png"/>
				<h3>MISSION</h3>
				<p>Shape the future of the Financial Services by creating value and opportunity profoundly for all our stakeholders.</p>
			</div>
			<div class="col-sm-4">
				
				<img id="visionj" src="Images/vision.jpg"/>
				<h3>VISION</h3>
				<p>To emphasize,reflect on and illustrate the importance of correct decisions which leads to profit and subsequent peace of mind.</p>
			</div>
		</div>
	</div>
	<div id="who_are_we">
			<div class="row">
				<div class="col-sm-6">
					<div class="panel">
						<div class="panel-body">
							<p id="GST" align="center">What is GST</p>
							<iframe class="embed-responsive-item" width="370" height="255" src="https://www.youtube.com/embed/yzk5Hsw_SWs" frameborder="0" allowfullscreen></iframe>
						</div>
					</div>
				</div>
				<div class="col-sm-3">
					<p id="header">Who are we</p>
					<p id="sub-head">ABOUT US IN SHORT</p>
					<p id="title">INTRODUCTION</p>
					<p id="ïntro-body">Established in 1994 and headquartered in Pune,As bigCapita and Associates is an Accouting,tax,outsourcing and business consultancy
					firm with branch offices in delhi and Bengaluru adn strategic tie ups with leading international accounting,law adn concultancy firms.In pursuit of 
					extrending global footprints,we have opened our new branch in Chicago that enhances our ability to guide international companies considering global expansion
					</p>
					
				</div>
				<div class="col-sm-3">
				<div id="second-body">
					<p id="title">How are we different</p>
					<p id="intro-body">We are a team of over 200 in-house qualified professionals with sound legal knowledge and strong business understanding.Our resources
					pool consists of Chartered Accountants,MBA's,Company Secretaries,Lawyers and Financial Management.
					Experts having in-dept experience in providing multi-disciplinary services in a wide range of area including:Tax and Regulatory,Audit and Assurance,Business Risk Advisory,
					Investment Management and outsourcing.
					</p>
				</div>
				</div>
			</div>
	</div>
	<div id="servises">
		<h1 align="center">SERVICES PROVIDED</h1>
						<div class="row">
			<div id="accounting_div" class="col-sm-4">
				<h3 align="center">ACCOUNTING</h3>
				<p> We are a team of over 200 in-house qualified professionals with sound legal knowledge and strong business understanding.Our resources
					pool consists of Chartered Accountants,MBA's,Company Secretaries,Lawyers and Financial Management.
					Experts having in-dept experience in providing multi-disciplinary services in a wide range of area including:Tax and Regulatory,Audit and Assurance,Business Risk Advisory,
					Investment Management and outsourcing.
				</p>
			</div>
			<div id="audit_img_div" class="col-sm-4" >
				<img class="audit" src="Images/audit.jpg">
				<div class="arrow-left"></div>
			</div>
			<div id="audit_div" class="col-sm-4">
					<h3 align="center">AUDIT</h3>
					<p> We are a team of over 200 in-house qualified professionals with sound legal knowledge and strong business understanding.Our resources
						pool consists of Chartered Accountants,MBA's,Company Secretaries,Lawyers and Financial Management.
						Experts having in-dept experience in providing multi-disciplinary services in a wide range of area including:Tax and Regulatory,Audit and Assurance,Business Risk Advisory,
						Investment Management and outsourcing.
					</p>
			</div>
		</div>
		<div id="accounting_img">
		</div>
			<div id="join_accountion" class="arrow-down"></div>
		
	</div>
	
	</div>
</body>
</html> 