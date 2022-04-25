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
	<title>Dashboard</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="/js/main.js"></script>
</head>
<body>
<h1>All Books</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
         <c:forEach var="book" items="${books}">
							<tr>
								<th>
									<a href="/books/${book.id}"><c:out value="${book.id}"></c:out></a>
								</th>
								<th>
									<c:out value="${book.title}"></c:out>
								</th>
								<th>
									<c:out value="${book.language}"></c:out>
								</th>
								<th>
									<c:out value="${book.pages}"></c:out>
								</th>
							</tr>
		</c:forEach>
    </tbody>
</table>
</body>
</html>