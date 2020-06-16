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

<section id="record-events">
	<h2>Happy Reminders</h2>
	One way to stay positive is to record what makes you feel happy. This could be an event, 
	a compliment from a stranger, or an uplifting saying.<br> 
	Whatever it may be, record it here for when you need a 
	pick-me-up!
	
	<form action="record" method="post">
	<textarea name="text" rows="5" cols="50" maxlength="500" 
	placeholder="What made you smile?" required></textarea>
	
	<br>
	<input type="hidden" name="list" value="no"/>
	<button type="submit">Add</button>
	</form>
	
	<h3>Past Records</h3>
	<c:forEach var="record" items="${records}" end="2">
		
		
		${record.text}
		<br>
		<i>${record.datetime}</i> <a href="/delete/record?id=${record.id}&url=/user">
		Delete</a>
		
		<br>
	</c:forEach>
	
	<!-- Form to pass list into "display more" page -->
	<form action="/list/records" method="post">
	<button type="submit">See More</button>
	</form>

</section>


<section id="affirmations">
	<h2>Favorite Affirmations</h2>
	<c:forEach var="affirmation" items="${affirmations}" end="2">
		
		
		${affirmation.affirmation}
		<br>
		<i>${affirmation.datetime}</i> <a href="/delete/affirmation?id=${affirmation.id}&url=/user">
		Delete</a>
		
		<br>
	</c:forEach>
	
	
	<!-- Form to pass list into "display more" page -->
	<form action="/list/affirmations" method="post">
	<button type="submit">See More</button>
	</form>
</section>



</main>

</body>
</html>