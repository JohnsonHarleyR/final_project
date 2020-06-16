<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mind Page</title>
</head>
<body>

<!-- Header -->
<section class="header">
<%@ include file="partials/header.jsp" %>
</section>

<section>

<h1><c:out value="${article.title }"></c:out></h1>
<c:out value="${article.description }"></c:out>
<br>
<a href="${article.url}">Read Article</a>

<form action="/save/article" method="post">
			<input type="hidden" name="title" 
			value="${article.title}"/>
			<input type="hidden" name="description" 
			value="${article.description}"/>
			<input type="hidden" name="url" 
			value="${article.url}"/>
			<button type="submit">Save</button>
		</form>
</section>




</body>
</html>