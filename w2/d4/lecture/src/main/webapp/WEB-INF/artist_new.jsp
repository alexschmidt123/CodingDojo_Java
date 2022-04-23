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
		<div class="card">
			<div class="card_head">
				<h1 class="col_white1">All Artists</h1>
			</div>
			
			<div class="card_body grid">
				<c:forEach items="${artists}" var="i" >
					<div class="card">
						<div class="card_head">
							<h1 class="col_white1">${i.name}</h1>
						</div>
						<div class="card_body">
							<p>Nationality: ${i.nationality}</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	
		<form:form class="card" action="/artist" method="POST" modelAttribute="artist" >
			<div class="card_head">
				<h1 class="col_white1">Add Artist</h1>
			</div>
			
			<div class="card_body">
				<form:errors class="col_red" path="name" />
				<form:input placeholder="Artist Name" path="name" />
				
				<form:errors class="col_red" path="nationality" />
				<form:input placeholder="Artist Nationality" path="nationality" />
				
				<input class="btn_submit" type="submit" value="Add Artist" />
			</div>
		</form:form>
	</div>
</body>
</html>