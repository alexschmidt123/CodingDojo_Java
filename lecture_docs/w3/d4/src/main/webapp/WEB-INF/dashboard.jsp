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
		<h1>All Projects</h1>
		<a href="/projects/new">New Project</a>

		<table>
			<thead>
				<tr>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${users_projects}" var="user_project">
					<%-- <c:if test="${user_project.user.id!=user.id}"> --%>
						<tr>
							<td><a href="/projects/${user_project.project.id}">${user_project.project.id}-${user_project.project.title}</a></td>
							<td>${user_project.project.owner.email}</td>
							<td>${user_project.project.due_date}</td>
							<td><a href="/projects/${user_project.project.id}/join">Join Team</a></td>
						</tr>
					<%-- </c:if> --%>
				</c:forEach>
			</tbody>
		</table>

		<h1>Your Projects</h1>
		
		<table>
			<thead>
				<tr>
					<th>Project</th>
					<th>Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${your_projects}" var="user_project">
					<tr>
						<td><a href="/projects/${user_project.project.id}">${user_project.project.id}-${user_project.project.title}</a></td>
						<td>${user_project.project.owner.email}</td>
						<td>${user_project.project.due_date}</td>
						<c:if test="${user_project.project.owner.id==user.id}">
							<td>
								<a href="">Edit</a>
							</td>
						</c:if>

						<c:if test="${user_project.project.owner.id!=user.id}">
							<td>
								<a href="/projects/${user_project.id}/leave">Leave Team</a>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>