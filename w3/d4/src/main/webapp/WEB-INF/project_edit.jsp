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
	<div class="grid bg_blue">
		<div class="container grid col3 align_center justify_center">
			<a href="/"><img id="dojo" src="/img/codingdojo.svg"/></a>

			<h1 class="col_white1">Exam</h1>

			<div class="flex col2 gap2">
				<c:if test="${user!=null}">
					<a class="col_white1" href="/logout">Logout</a>
				</c:if>
				<c:if test="${user==null}">
					<a class="col_white1" href="/login">Login</a>
				</c:if>
				<a class="col_white1" href="/register">Register</a>
			</div>
		</div>
	</div>

	<div class="container p2 grid gap2">
		<form:form class="card" action="/projects/update/${project.id}" method="POST" modelAttribute="project" >
			<div class="card_head">
				<h1 class="col_white1">Edit A Project</h1>
			</div>
			
			<div class="card_body">
				<form:errors class="col_red" path="title" />
				<form:input placeholder="Title" path="title" />
				
				<form:errors class="col_red" path="description" />
				<form:input type="text" placeholder="Description" path="description" />

				<form:errors class="col_red" path="due_date" />
				<form:input type="date" path="due_date" />

				<form:input type="hidden" path="owner" value="${project.owner.id}" />
				
				<input class="btn_submit" type="submit" value="Submit" />
			</div>
		</form:form>
	</div>
</body>
</html>