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
	<div class="container p2 grid gap2">
		<div class="card">
			<div class="card_head flex">
				<div>
					<h1 class="col_white1">Welcome, ${session.name} </h1>
					<p>Books from everyone's shelves</p>
				</div>
				<a href="/logout">logout</a>
				<a href="/books/new">Add one book to my shelf</a>
			</div>
			
			<div class="card_body grid">

							<table>
								<thead>
							        <tr>
							            <th>ID</th>
							            <th>Title</th>
							            <th>Author Name</th>
							            <th>Posted By</th>
							        </tr>
							    </thead>
							    <tbody>
							        <c:forEach var="book" items="${books}">
									<tr>
										<th>
											<c:out value="${book.id}"></c:out>
										</th>
										<th>
											<a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a>
										</th>
										<th>
											<c:out value="${book.author}"></c:out>
										</th>
										<th> 
											<c:out value="${book.user}"></c:out>
										</th>
									</tr>
									</c:forEach>
							    </tbody>
							</table>
						</div>
	</div>
	</div>
</body>
</html>