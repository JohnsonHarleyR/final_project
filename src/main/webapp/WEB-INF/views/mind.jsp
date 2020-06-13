<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- Header -->
<section class="header">
<%@ include file="partials/header.jsp" %>
</section>

<section>
${result.name}<br>
${result.description}<br>
${result.sourceUrl}<br>
</section>

<!-- Testing Area - temporary -->
<section>
<br>
<br>
<b>Testing Area</b>
<br>
${time}
<br>
${ftime}
</section>



</body>
</html>