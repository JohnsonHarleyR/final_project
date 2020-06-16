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
    <select name= "feelings" class="form-control" id="FormControlSelect1">
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
  <input class="form-check-input" type="radio" name="workoutFocus" id="radios1" value="9" >
  <label class="form-check-label" for="radios1">
   Legs
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="workoutFocus" id="radios2" value="14">
  <label class="form-check-label" for="radios2">
   Calves
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="workoutFocus" id="radios3" value="11" >
  <label class="form-check-label" for="radios3">
   Chest
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="workoutFocus" id="radios4" value="12" >
  <label class="form-check-label" for="radios4">
   Back
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="workoutFocus" id="radios5" value="13" >
  <label class="form-check-label" for="radios5">
   Shoulders
  </label>
  </div>
  <div class="form-check">
  <input class="form-check-input" type="radio" name="workoutFocus" id="radios6" value="null" >
  <label class="form-check-label" for="radios6">
   Not Working Out Today
  </label>
</div>
</div>

<div class="form-group" id = "interestsQuestion">
  <label for="interestsQuestion">What topics are you interested in today?</label>
<div class="form-check">
<input class="form-check-input" name= "interests[]" type="hidden" value="none" >
  <input class="form-check-input" name="interests[]" type="checkbox" value="0" id="check5" >
  <label class="form-check-label" for="check5">
    Top Headlines
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" name="interests[]" type="checkbox" value="1" id="check6" >
  <label class="form-check-label" for="check6">
   Spirituality
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" name="interests[]" type="checkbox" value="2" id="check7" >
  <label class="form-check-label" for="check7">
   Overcoming Struggle
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" name="interests[]" type="checkbox" value="3" id="check8" >
  <label class="form-check-label" for="check8">
  Something Funny
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" name="interests[]" type="checkbox" value="4" id="check9" >
  <label class="form-check-label" for="check8">
  Mental Health
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" name="interests[]" type="checkbox" value="5" id="check10" >
  <label class="form-check-label" for="check8">
 Meditation 
  </label>
</div>
</div>

<button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>