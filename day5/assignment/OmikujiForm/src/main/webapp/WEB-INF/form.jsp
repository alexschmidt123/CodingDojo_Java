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
	<title>Form</title>
  <!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
</head>

  <body>
    <div class="contanier">
      <div class="card">
        <div class="card_head">
          <h3>Send an Omikuji!</h3>
        </div>
        <div class="card_body">
          <form action='/process' method='POST'>
            <div class="form-group">
              <label for="name">Pick any number from 5 to 25</label>
              <input type="number" name='number' class="form-control" id="name" placeholder="A number from 5 to 25">
            </div>
            <div class="form-group">
              <label for="nameOfCity">Enter the name of any city</label>
              <input type="text" name="nameOfCity" class="form-control" id="nameOfCity" placeholder="Any City">
            </div>
            <div class="form-group">
              <label for="nameOfPerson">Enter the name of any real person</label>
              <input type="text" name="nameOfPerson" class="form-control" id="nameOfPerson" placeholder="Any real person">
            </div>
            <div class="form-group">
              <label for="hobby">Enter professional endeavor or hobby</label>
              <input type="text" name="hobby" class="form-control" id="hobby" placeholder="Any endeavor or hobby">
            </div>
            <div class="form-group">
              <label for="livingThing">Enter any type of living thing</label>
              <input type="text" name="livingThing" class="form-control" id="livingThing" placeholder="Any type of living things">
            </div>
            <div class="form-group">
              <label for="sentence">Say something nice to someone</label>
              <textarea name="sentence" class="form-control" id="sentence" placeholder="Anything nice"></textarea>
            </div>
            <button type="submit" class="btn-submit" value="send">Submit</button>
          </form>
        </div>
      </div>
    </div>
  </body>

  </html>