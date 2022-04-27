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
			<div class="card_head flex">
				<div>
					<h1 class="col_white1">${book.title}</h1>
				</div>
				<div>
					<a href="/books">Back to the shelves</a>
				</div>
			</div>

	<div class="container p2 grid gap2">
			<div class="card_header">
				<p>${session.name} read ${book.title} by ${book.author}</p>
				<p>Here are ${session.name}'s thoughts:</p>
			</div>
			<div class="card_body">
				<p>${book.thoughts}</p>
				<a class="btn_submit" href="/book/edit/${book.id}">edit</a>
			</div>
	</div>
	</div>
	</div>
</body>
</html>