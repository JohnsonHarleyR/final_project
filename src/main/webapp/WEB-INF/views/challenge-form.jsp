<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="/submit-challenge">
  <label for="category">Category</label><br>
  <input type="text" id="category" name="category"><br>
  <label for="date">Date:</label><br>
  <input type="date" id="date" name="date">
   <label for="description">Date:</label><br>
  <input type="text" id="description" name="description">
   <label for="experationDate">Experation Date:</label><br>
  <input type="text" id="experationDate" name="experationDate">
   <label for="name">Name:</label><br>
  <input type="text" id="name" name="name">
   <label for="points_req">Points Req:</label><br>
  <input type="text" id="points_req" name="points_req">
   <label for="prize_url">Prize file</label><br>
  <input type="text" id="prize_url" name="prize_url">
  <input type="submit" value="Submit">
  
</form>

</body>
</html>