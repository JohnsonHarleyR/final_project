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

<form>

 <div class="form-group">
    <label for="\FormControlSelect1">How are you feeling today?</label>
    <select class="form-control" id="FormControlSelect1">
      <option>Happy</option>
      <option>Sad</option>
      <option>Un-Motivated</option>
      <option>Anxious</option>
      <option>Tired</option>
    </select>
</div>

<%--Question ties into the body page for display of workouts --%>
<div class="form-group" id="excerciseFocusOptions">
<label for="excerciseFocusOptions" >What part of your body would you like to work on today?</label>
<div class="form-check">
  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="9" >
  <label class="form-check-label" for="exampleRadios1">
   Legs
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="14">
  <label class="form-check-label" for="exampleRadios2">
   Calves
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios3" value="11" >
  <label class="form-check-label" for="exampleRadios3">
   Chest
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios3" value="12" >
  <label class="form-check-label" for="exampleRadios3">
   Back
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios3" value="13" >
  <label class="form-check-label" for="exampleRadios3">
   Shoulders
  </label>
  </div>
  <div class="form-check">
  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios3" value="null" >
  <label class="form-check-label" for="exampleRadios3">
   Not Working Out Today
  </label>
</div>
</div>

<%-- Want to add question specifically pertaining to what news they want to see, if any at all --%>
<%-- 
<div class="form-group">


</div>
--%>

<button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>