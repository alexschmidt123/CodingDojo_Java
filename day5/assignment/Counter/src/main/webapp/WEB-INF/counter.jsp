<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Counter</title>
</head>
<body>
	<% Integer currentCount = (Integer) session.getAttribute("count"); %>
	<h1> You have visited http://localhost:8080/ <%= currentCount %> times </h1>
	<a href="/">Visit again</a>
	<a href="/reset">Reset counter</a>
</body>
</html>