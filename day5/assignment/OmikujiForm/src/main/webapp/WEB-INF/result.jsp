<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Result</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<h3>Here is Your Omikuji!</h3>
    <div class="">
    	<p>In ${number} years, you will live in ${nameOfCity} with ${nameOfPerson} as your roommate, selling ${hobby} for a living. The next time you see ${livingThing }, you will have good luck! Also, ${sentence }</p>
    </div>
    <a href="/">Go Back</a>
</body>
</html>