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
	<title>Edit</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<h1>Edit Expense</h1>
	<a href="/expenses">Go back</a>
<form:form action="/expenses/edit/${expense.id}" method="post" modelAttribute="expense">
<input type="hidden" name="_method" value="put"/> 
    		<p>
		        <form:label path="name">Name: </form:label>
		        <form:input path="name"/>
		        <form:errors path="name"/>
	    	</p> 
	    	<p>
		        <form:label path="vendor">Vendor: </form:label>
		        <form:input path="vendor"/>
		        <form:errors path="vendor"/> 
		    </p>  
		    <p>
		        <form:label path="price">Amount: </form:label>
		        <form:input type="number" step="0.01"  path="price"/>
		        <form:errors path="price"/>
		    </p>
		    <p>
		        <form:label path="description">Description: </form:label>
		        <form:textarea path="description"/>
		        <form:errors path="description"/>
		    </p> 
    <input type="submit" value="Submit"/>
</form:form>    

</body>
</html>