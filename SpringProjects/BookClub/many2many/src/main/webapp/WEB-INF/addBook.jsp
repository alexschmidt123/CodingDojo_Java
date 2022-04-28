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
<body class="bg_white2">
	<div class="container p2 grid gap2">
		<div class="card">
			<div class="card_head flex gap2 align_center">
				<div>
					<h1 class="col_white1">Add a book to your shelf! </h1>
				</div>
				<div>
					<a href="/books">Back to the shelves</a>
				</div>
			</div>

	<div class="container p2 grid gap2">
	
		<form:form class="card" action="/books/new" method="POST" modelAttribute="book" >
			<div class="card_body">
				<form:errors class="col_red" path="title" />
				<form:input placeholder="Title" path="title" />
				<form:errors class="col_red" path="author" />
				<form:input placeholder="Auther" path="author" />
				<form:errors class="col_red" path="thoughts" />
				<form:input placeholder="My thoughts" path="thoughts" />
				<input class="btn_submit" type="submit" value="Submit" />
			</div>
		</form:form>
	</div>
	</div>
	</div>
</body>
</html>