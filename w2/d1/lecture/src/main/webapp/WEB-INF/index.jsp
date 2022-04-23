<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<h1>I'm a Template</h1>
	
	<h1>Number Of User Submitted Stories: ${stories.size()}</h1>
	
	<c:forEach items="${stories}" var="story" >
		<h1>${story}</h1>
	</c:forEach>
	
	<form action="/madlibs" method="POST">
		<p class="err">${verb_err}</p>
		<input placeholder="Verb" type="text" name="verb" />
		<p class="err">${adj_err}</p>
		<input placeholder="Adjective" type="text" name="adjective" />
		<p class="err">${adverb_err}</p>
		<input placeholder="Adverb" type="text" name="adverb" />

		<input type="submit" value="Create Mad Lib" />
	</form>
</body>
</html>