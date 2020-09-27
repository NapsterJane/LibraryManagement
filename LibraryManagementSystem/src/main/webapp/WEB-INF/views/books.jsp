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

<title>books</title>
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
			<form action="/savebook" method="post" enctype="multipart/form-data">
				<div class="form-group">
				    <label for="bookname">Book Name:</label>
				    <input type="text" name ="bookname" class="form-control" id="bookname" required="required">
			  	</div>
			  	<div class="form-group">
				    <label for="author">Author Name:</label>
				    <input type="text" name ="author" class="form-control" id="author" required="required">
			  	</div>
			  	<div class="form-group">
				  	<label for="publisher">Publisher Name:</label>
				  	<input type="text" name="publisher" class="form-control" id="publisher" required="required">
			  	</div>
			  	<div class="form-group">
				  	<label for="category">Category:</label>
				  	<input type="text" name="category" class="form-control" id="category" required="required">
			  	</div>
			  	<div class="form-group">
					<label for="attachment"><i class="zmdi zmdi-file"></i> Book Cover Image</label>
					<input type="file" name="file" accept="*" id="file" multiple="multiple" />
			  	</div> 
			  	<input type="submit" class="btn btn-default" value="Save Book"></input>
			</form>
		</div>
	</div>
	<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
	<c:set var="errors" scope="session" value="${error}"/>
		<c:if test="${errors != null}">
			<div class ="row">
				<div class = "container">
					<p class ="error">${errors}</p>
				</div>
			</div>
		</c:if>
		
		<c:set var="msg" scope="session" value="${success}"/>
		<c:if test="${msg != null}">
			<div class ="row">
				<div class = "container">
					<p style="color: green">${msg}</p>
				</div>
			</div>
		</c:if>
		<table class="table table-bordered" >
			<thead>
				<tr>
					<th>Book Name</th>
					<th>Author Name</th>
					<th>Publisher</th>
					<th>Cover Image</th>
					<th colspan="2">&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
				<form action="saveorupdate" method="post" id="prodform${book.book_id}">
					<tr>
						<td>${book.bookname}</td>
						<input type= "hidden" name= "bookid" value="${book.book_id}">
						<td><input type= "text" id = "author${book.book_id}" name ="author" value="${book.author.authorname}" readonly="readonly"></td>
						<input type="hidden" name="authorid" value="${book.author.author_id}">
						<td><input type= "text" id = "publisher${book.book_id}" name ="publisher" value="${book.publisher.publishername}" readonly="readonly"></td>
						<input type="hidden" name="publisherid" value="${book.publisher.publisher_id}">
						<td>${book.coverimage}</td>
						
						<td align="left"><input type="button" value="edit" id="edit${book.book_id}" onclick="editFunc('${book.book_id}')">
						<input type="button" value="Save" id="save${book.book_id}" onclick="saveFunc('${book.book_id}')" style="visibility: hidden"></td>
						<td align="left"><input type="button" value="cancel" id="cancel${book.book_id}" onclick="cancelFunc('${book.book_id}')" style="visibility: hidden">
						<input type="button" value="delete" id="delete${book.book_id}" onclick="deleteFunc('${book.book_id}')"></td>
					</tr>
					</form>
				</c:forEach>	
				</tbody>
		</table>
	</div>
	</div>
	
</body>
</html>