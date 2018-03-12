<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- Create local vars to point to the resources mappings we created in dispatcher-servlet.xml -->
<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Spring MVC Application">
    <meta name="author" content="Kunal Patil">

    <title>My MVC Page - ${title}</title>

    <!-- Bootstrap core CSS -->
    <!-- We are using var created at top of page to find the css file relative to context -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    <link href="${css}/bootstrap-unbuntu-theme.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/main.css" rel="stylesheet">

  </head>

  <body>

	
