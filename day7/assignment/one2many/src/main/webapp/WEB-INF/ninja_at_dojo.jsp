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
	

	<!-- display the dojo name
	
	in order to show the ninjas access the list of ninjas from your dojo model
	loop through that list to get each ninja object -->

<div class="container p2 grid gap2">
		<div class="card">
			<div class="card_head">
				<h1 class="col_white1">All Ninjas in <c:out value="${dojo.location}"></c:out></h1>
			</div>
			
			<div class="card_body grid">

							<table>
								<thead>
							        <tr>
							            <th>Name</th>
							            <th>Age</th>
							            <th>Actions</th>
							        </tr>
							    </thead>
							    <tbody>
							        <c:forEach var="ninja" items="${dojo.ninjas}">
									<tr>
										<th>
		
											<a href="/ninjas/${ninja.id}"><c:out value="${ninja.firstName}"></c:out> <c:out value="${ninja.lastName}"></c:out></a>
										</th>
										<th>
											<c:out value="${ninja.age}"></c:out>
										</th>
										<th>
											<a href="/ninjas/edit/${ninja.id}">Edit</a>
											<a href="/ninjas/delete/${ninja.id}">Delete</a>
										</th>
									</tr>
									</c:forEach>
							    </tbody>
							</table>

						</div>
	<a class="card_head btn_submit" href="/dojos">Back</a>
	</div>
</body>
</html>