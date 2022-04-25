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
	<title>Create</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>   
<h1>Edit Book</h1>
<form:form action="/books/edit/${book.id}" method="post" modelAttribute="book">
<input type="hidden" name="_method" value="put"> 
    <p>
        <form:label path="title">Title</form:label>
        <form:errors path="title" style="color: red"/>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <p>
        <form:label path="language">Language</form:label>
        <form:errors path="language"/>
        <form:input path="language"/>
    </p>
    <p>
        <form:label path="pages">Pages</form:label>
        <form:errors path="pages"/>     
        <form:input type="number" path="pages"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    
<a href="/books">Go back to home</a>

</body>
</html>