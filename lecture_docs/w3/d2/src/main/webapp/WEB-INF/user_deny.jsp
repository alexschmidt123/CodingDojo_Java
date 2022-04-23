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
				<c:if test="${user_id!=null}">
					<a class="col_white1" href="/logout">Logout</a>
				</c:if>
				<c:if test="${user_id==null}">
					<a class="col_white1" href="/login">Login</a>
				</c:if>
				<a class="col_white1" href="/register">Register</a>
			</div>
		</div>
	</div>

	<div class="container p2 grid gap2">
		<div class="card">
			<div class="card_head bg_red">
				<h1 class="col_white1">Access Denied</h1>
			</div>
			<div class="card_body">
				<p>You do not have access to visit the requested resource.</p>
				<p class="col_green">This one is for Mansoor.</p>
				<a class="col_red" href="/login">Login</a>
				<a class="col_red" href="/register">Register</a>
			</div>
		</div>
	</div>
</body>
</html>