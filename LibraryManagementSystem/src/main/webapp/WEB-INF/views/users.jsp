<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>	
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>

<link rel="stylesheet"  href="/css/style.css">
<script src="/js/lms.js"></script>

<title>Users</title>
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
	
	<div class="row">
	<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
		<div class = "leftpadd">
			<form action="/saveuser" method="post">
				<div class="form-group">
				    <label for="fullname">Full Name:</label>
				    <input type="text" name ="fullname" class="form-control" id="fullname" required="required">
			  	</div>
			  	<div class="form-group">
				    <label for="username">User Name*:</label>
				    <input type="text" name ="username" class="form-control" id="username" required="required">
			  	</div>
			  	<div class="form-group">
				  	<label for="password">password*:</label>
				  	<input type="password" name="password" class="form-control" id="password" required="required">
			  	</div>
			  	<div class="form-group">
			  		<label for="bookallowed">Books Allowed:</label>
			  		<c:forEach var="book" items="${books}">
					<label for="bookallowed">${book.bookname}</label>
					<input type="checkbox" id="book" name="bookallowed" value="${book.bookname}">	
					
					<%-- <select name="bookallowed">
					  		<c:forEach var="book" items="${books}">
							  	<option value="${book.book_id}">${book.bookname}</option>
						  	</c:forEach>
					  	</select> --%>
					
					</c:forEach> 		  		
			  	</div> 
			  	<input type="submit" class="btn btn-default" value="Save User"></input>
			</form>
		</div>
	</div></div>
</body>
</html>