<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruit Page</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<h1>Two plus two is: </h1>
	<h2><c:out value="${2+2}"/></h2>
	<h1>Fruit of the Day</h1>
	<h2><c:out value="${fruit}"/></h2>
</body>
</html>