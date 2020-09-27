<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>	
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>

<link rel="stylesheet"  href="/css/style.css">
<script src="/js/lms.js"></script>

<title>Admin Home</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<form id="menu" method="get">
 		 <div class="container-fluid">
    		<div class="navbar-header">
    			<a class="navbar-brand" href=""></a>
    		</div>
		    <ul class="nav navbar-nav">
		      <li class="active"><a href="#">Home</a></li>
		      <li><a onclick="fncMenu('users')">USERS</a></li>
		      <li><a onclick="fncMenu('books')">BOOKS</a></li>
		    </ul>
  		</div>
  </form>
</nav>

<br>
<br>
	
	
	
	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
			</div>
			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
			</div>
		</div>
	</div>
</body>
</html>