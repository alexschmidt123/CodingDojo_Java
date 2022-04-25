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
		<div class="container grid p2 col2">
			<div></div>
			<div class="flex col2 gap2">
				<a class="col_white1" href="/dojos">Dojos</a>
				<a class="col_white1" href="/ninjas">Ninjas</a>
<%-- 
				<c:if test="${user_id!=null}">
					<a class="col_white1" href="/logout">Logout</a>
				</c:if>
				<c:if test="${user_id==null}">
					<a class="col_white1" href="/login">Login</a>
				</c:if>

				<a class="col_white1" href="/register">Register</a> --%>
			</div>
		</div>
	</div>

	<div class="container p2 grid gap2">
		<div class="card">
			<div class="card_head">
				<h1 class="col_white1">All Ninjas </h1>
			<%-- 	<form:select path="dojo" >
					<c:forEach items="${dojos}" var="dojo" >
						<form:option value="${dojo.id}">${dojo.location}</form:option>				
					</c:forEach>
				</form:select> --%>
			</div>
			
			<div class="card_body grid">

							<table>
								<thead>
							        <tr>
							            <th>Name</th>
							            <th>Age</th>
							            <th>Dojo Location</th>
							            <th>Actions</th>
							        </tr>
							    </thead>
							    <tbody>
							        <c:forEach var="ninja" items="${ninjas}">
									<tr>
										<th>
											<a href="/ninjas/${ninja.id}"><c:out value="${ninja.firstName}"></c:out> <c:out value="${ninja.lastName}"></c:out></a>
										</th>
										<th>
											<c:out value="${ninja.age}"></c:out>
										</th>
										<th>
											<c:out value="${ninja.dojo.location}"></c:out>
										</th>
										<th>
											<a href="/ninjas/edit/${ninja.id}">Edit</a>
											<a href="/ninjas/delete/${ninja.id}">Delete</a>
											<%-- <form action="/ninjas/delete/${ninja.id}" method="post">
															<input type="hidden" name="_method" value="delete">
															<input type="submit" value="Delete">
											</form> --%>
										</th>
									</tr>
									</c:forEach>
							    </tbody>
							</table>

						</div>
	<a class="card_head btn_submit" href="/ninjas/new">Create a new Ninja!</a>
	</div>
</body>
</html>