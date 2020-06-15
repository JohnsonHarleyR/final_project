<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />
</head>
<body>

<section class="header">
<%@ include file="partials/header.jsp" %>
</section>
<h1>Enter and exercise: </h1>
	<form action = "/body" name = "exerciseForm" method = "post">
	
	          <textarea name = "userInput" rows = "3" cols = "80">Your text here</textarea>
					<input type="submit" value="Submit">
	
	</form>

<c:forEach var= "excercise" items="${excercises}">
<h2>Total Calories burned: ${excercise.nf_calories }</h2>
<h2>Time in minutes: ${excercise.duration_min}</h2>
<h2>Exercise name : ${excercise.name}</h2>
	<input type="submit" value="Add to completed">
</c:forEach>

<c:forEach var= "result" items="${resultList}">
<h3>${result.name}</h3>
<p>${result.description}</p>

</c:forEach>


</body>
</html>