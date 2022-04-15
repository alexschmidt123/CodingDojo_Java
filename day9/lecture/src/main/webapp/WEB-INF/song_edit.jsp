<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/main.js"></script>
</head>
<body>
	<div class="container p2 grid gap2">	
		<form:form class="card" action="/song/${song.id}/update" method="POST" modelAttribute="song" >
			<div class="card_head">
				<h1 class="col_white1">Edit Song</h1>
			</div>
			
			<div class="card_body">
				<form:errors class="col_red" path="song_title" />
				<form:input placeholder="Song Title" path="song_title" />

				<form:errors class="col_red" path="genre" />
				<form:input placeholder="Genre" path="genre" />	

				<input class="btn_submit" type="submit" value="Edit Song" />

				<a href="/song">Back</a>
			</div>
		</form:form>
	</div>
</body>
</html>