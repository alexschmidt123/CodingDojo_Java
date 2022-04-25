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
			</div>
		</div>
	</div>

	<div class="container p2 grid gap2">
	
		<form:form class="card" action="/ninjas/edit/${ninja.id}" method="POST" modelAttribute="ninja" >
			<div class="card_head">
				<h1 class="col_white1">Edit a Ninja</h1>
			</div>
			
			<div class="card_body">
				<form:select path="dojo" >
					<c:forEach items="${dojos}" var="dojo" >						
						<c:choose>
							<c:when test="${dojo.id==ninja.dojo.id}">
								<form:option value="${dojo.id}" selected="true" >${dojo.location}</form:option>
							</c:when>					
							<c:otherwise>
								<form:option value="${dojo.id}">${dojo.location}</form:option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:select>
				<form:errors class="col_red" path="firstName" />
				<form:input placeholder="firstName" path="firstName" />
				<form:errors class="col_red" path="lastName" />
				<form:input placeholder="lastName" path="lastName" />
				<form:errors class="col_red" path="age" />
				<form:input placeholder="age" path="age"/>
				<input class="btn_submit" type="submit" value="Edit" />
			</div>
		</form:form>
	</div> 
</body>
</html>