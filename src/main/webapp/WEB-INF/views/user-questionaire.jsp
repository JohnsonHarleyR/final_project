
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

<%-- Mental Health Question --%>

  <div class="form-group" id = "mentalHealthQuestion">
  <label for="mentalHealthQuestion">Do you have any mental illnesses?</label>
<div class="form-check">
  <input class="form-check-input" name= "mentalHealth" type="checkbox" value="depression" id="check1" >
  <label class="form-check-label" for="check1">
    Depression
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" name= "mentalHealth" type="checkbox" value="anxiety" id="check2" >
  <label class="form-check-label" for="check2">
    Anxiety
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" name= "mentalHealth" type="checkbox" value="ocd" id="check3" >
  <label class="form-check-label" for="check3">
    OCD
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" name= "mentalHealth" type="checkbox" value="null" id="check4" >
  <label class="form-check-label" for="check4">
    None
  </label>
</div>
</div>

<%-- Music Preference Question --%>

<div class="form-group" id = "musicQuestion">
  <label for="musicQuestion">What kind of music do you like?</label>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="check5" >
  <label class="form-check-label" for="check5">
    Rap/Hip-Hop
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="check6" >
  <label class="form-check-label" for="check6">
    Classical
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="check7" >
  <label class="form-check-label" for="check7">
    Jazz
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="check8" >
  <label class="form-check-label" for="check8">
    Rock 
  </label>
</div>
</div>

<%-- Body Goals (Gaining/Maintaining/Losing) --%>

  <div class="form-group">
    <label for="exampleFormControlSelect1">How would you like to change your body?</label>
    <select name="weightGoalText"class="form-control" id="FormControlSelect1">
      <option>I Want To Lose Weight</option>
      <option>I Want To Gain Weight</option>
      <option>I Want To Maintain My Current Weight</option>
    </select>
  </div>
  <%-- User Current Body Weight --%>
<div class="form-group">
    <label for="FormControlInput2" >How much do you weigh currently?</label>
    <input type="text" name="userWeight" class="form-control" id="FormControlInput2">
  </div>
  
  <%-- THIS QUESTION WILL ONLY DISPLAY IF THEY WANT TO GAIN OR LOSE WEIGHT--%>
  <c:if test="${weightGoalText != 'I Want To Maintain My Current Weight'}" >
  <div class="form-group">
    <label for="FormControlInput3" >What is your goal weight?</label>
    <input type="text" name="userGoalWeight" class="form-control" id="FormControlInput3">
  </div>
  </c:if>
 
 
 <button type="submit" class="btn btn-primary">Submit</button>


</form>









</body>
</html>