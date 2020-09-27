<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>	
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>

<link rel="stylesheet"  href="/css/style.css">

</head>
<body>

	<nav class="navbar navbar-inverse">
		<form id="menu" method="get">
 		 <div class="container-fluid">
    		<div class="navbar-header">
    			<a class="navbar-brand" href="login.jsp">LOGIN</a>
    		</div>
		    <ul class="nav navbar-nav">
		      <li class="active"><a href="#"></a></li>
		    </ul>
  		</div>
  </form>
</nav>

<br>
<br>
<br>
	
	<div class="container">
	<div class="row">
		<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
		</div>
		<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
				<form action="/userlogin" method="post">
				
					<div class="form-group">
					  	<input type = "radio" name = "logger" value = "admin">Admin &nbsp; &nbsp;
						<input type = "radio" name = "logger" value = "user">User
				  	</div>
					<div class="form-group">
					    <label for="username">Username:</label>
					    <input type="text" name ="uname" class="form-control" id="uname">
				  	</div>
				  	<div class="form-group">
					    <label for="password">Password:</label>
					    <input type="text" name ="password" class="form-control" id="password">
				  	</div>
				  	
				  	<input type="submit" class="btn btn-default" value="Login"></input>
				</form>
		</div>
		<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
		</div>
	</div>
</div>
	
</body>
</html>