<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />

<meta charset="ISO-8859-1">
<title>User Page</title>
</head>
<body>

<!-- Header -->
<section class="header">
<%@ include file="partials/header.jsp" %>
</section>

<!-- MainBody -->
<main class="container">
<h1>${user.name}'s Page</h1>

<section id="user-options">
	<a href="/settings">Settings</a>
</section>


<section id="affirmations">
	<h2>Favorite Affirmations</h2>
	<c:forEach var="affirmation" items="${affirmations}" end="2">
		
		<form action="/delete/affirmation" method="post">
		<button type="submit"></button>
		</form>
		${affirmation.affirmation}
		
		
		<br>
	</c:forEach>
	
	<!-- Form to pass list into "display more" page -->
	<form action="/list" method="post">
	<input type="hidden" value="${affirmations}"/>
	<button type="submit">See More</button>
	</form>
</section>



</main>

</body>
</html>