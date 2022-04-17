<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Fruit Page</title>
			<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		</head>

		<body>
			<div class="container p-3">
				<h1>Fruit Store</h1>

				<table class="table border border-danger">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Price</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="fruit" items="${fruits}">
							<tr>
								<td>
									<c:out value="${fruit.name}"></c:out>
								</td>
								<td>
									<c:out value="${fruit.price}"></c:out>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</body>

		</html>