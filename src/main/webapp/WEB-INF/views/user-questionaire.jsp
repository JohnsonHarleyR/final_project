
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
    <label for="textArea1">Tell Us About Yourself</label>
    <textarea class="form-control" id="textArea1" rows="3"></textarea>
  </div>
  <div class="form-group" id = "mentalHealthQuestion">
  <label for="mentalHealthQuestion">Do you have any mental illnesses?</label>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1" >
  <label class="form-check-label" for="defaultCheck1">
    Depression
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="defaultCheck2" >
  <label class="form-check-label" for="defaultCheck2">
    Anxiety
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="defaultCheck2" >
  <label class="form-check-label" for="defaultCheck2">
    OCD
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="defaultCheck2" >
  <label class="form-check-label" for="defaultCheck2">
    None
  </label>
</div>
</div>

<div class="form-group" id = "musicQuestion">
  <label for="musicQuestion">What kind of music do you like?</label>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1" >
  <label class="form-check-label" for="defaultCheck1">
    Rap/Hip-Hop
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="defaultCheck2" >
  <label class="form-check-label" for="defaultCheck2">
    Classical
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="defaultCheck2" >
  <label class="form-check-label" for="defaultCheck2">
    Jazz
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="defaultCheck2" >
  <label class="form-check-label" for="defaultCheck2">
    Rock 
  </label>
</div>
</div>





</form>









</body>
</html>