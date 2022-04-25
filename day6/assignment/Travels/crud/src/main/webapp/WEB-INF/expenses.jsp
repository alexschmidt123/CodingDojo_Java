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
	<title>Expenses</title>
	<!-- <link rel="stylesheet" type="text/css" href="css/style.css"> -->
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<div class="container">
		<h1>Save Travels</h1>
		<a href="/create">Create</a>
		<table>
			 <thead>
        <tr>
            <th>Name</th>
            <th>Vendor</th>
            <th>Amount</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
         <c:forEach var="expense" items="${expenses}">
							<tr>
								<th>
									<a href="/expenses/${expense.id}"><c:out value="${expense.name}"></c:out></a>
								</th>
								<th>
									<c:out value="${expense.vendor}"></c:out>
								</th>
								<th>
									<c:out value="${expense.price}"></c:out>
								</th>
								<th>
									<a href="expenses/edit/${expense.id}">edit</a>
									<form action="/expenses/delete/${expense.id}" method="post">
	    								<input type="hidden" name="_method" value="delete">
	    								<input type="submit" value="Delete">
									</form>
								</th>
							</tr>
		</c:forEach>
    </tbody>
		</table>
	</div>
</body>
</html>