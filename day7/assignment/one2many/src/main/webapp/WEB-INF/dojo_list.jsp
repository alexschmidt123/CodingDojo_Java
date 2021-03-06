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
				<h1 class="col_white1">All Dojos' Location</h1>
			</div>
			
			<div class="card_body grid">
				<c:forEach items="${dojos}" var="dojo" >
					<div class="card">
						<div class="card_head flex col2 gap2">
							<p class="col_white1">${dojo.location}</p>
							<p><a href="dojos/ninjas/${dojo.id}">Ninjas</a></p>
							<p><a href="dojos/delete/${dojo.id}">Delete</a></p>
						</div>
					</div>
				</c:forEach>			
				
			</div>	
<a class="card_head btn_submit" href="/dojos/new">Create a new Dojo!</a>
		</div>

	</div>
</body>
</html>