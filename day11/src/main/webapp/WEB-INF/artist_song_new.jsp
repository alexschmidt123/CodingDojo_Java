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
		<div class="container grid col2 align_center justify_center">
			<a href="/"><img id="dojo" src="/img/codingdojo.svg"/></a>

			<div class="flex col2 gap2">
				<a class="col_white1" href="/artist">Artists</a>
				<a class="col_white1" href="/song">Songs</a>

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
			<div class="card_head">
				<h1 class="col_white1">All Artists and Songs</h1>
			</div>
			
			<div class="card_body grid">
				<c:forEach items="${artists_songs}" var="i" >
					<div class="card">
						<div class="card_head">
							<h1 class="col_white1">${i.song.song_title}</h1>
						</div>
						<div class="card_body">
							<p>${i.artist.name}</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	
		<form:form class="card" action="/artist_song" method="POST" modelAttribute="artist_song" >
			<div class="card_head">
				<h1 class="col_white1">Add Artist And Song</h1>
			</div>
			<div class="card_body">
				<form:select path="artist">
					<c:forEach items="${artists}" var="artist">
						<form:option value="${artist.id}">${artist.name}</form:option>
					</c:forEach>
				</form:select>

				<form:select path="song">
					<c:forEach items="${songs}" var="song" >
						<form:option value="${song.id}">${song.song_title}</form:option>
					</c:forEach>
				</form:select>

				<input class="btn_submit" type="submit" value="Add Artist And Song" />
			</div>
		</form:form>
	</div>
</body>
</html>