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
		<form:form class="card" action="/projects/${project.id}/tasks" method="POST" modelAttribute="task" >
			<div class="card_head">
				<h1 class="col_white1">Project: ${project.title}</h1>
				<h2>Project Lead: ${project.owner.email}</h2>
			</div>
			
			<div class="card_body">
				<form:errors class="col_red" path="description" />
				<form:input placeholder="Description" path="description" />
				<input class="btn_submit" type="submit" value="Add A Task" />
			</div>
		</form:form>
		
		<h1>Tasks:</h1>

		<c:forEach items="${project.tasks}" var="task">
			<div class="card">
				<div class="card_head">
					<h1 class="col_white1">Added By ${task.user.email} at ${task.createdAt}:</h1>
				</div>
				<div class="card_body">
					<p>${task.description}</p>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>