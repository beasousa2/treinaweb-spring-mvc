<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html >
<html>
<head>
<spring:url value="/resources/js/jquery.min.js" var="jqueryJs"></spring:url>
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs"></spring:url>
<spring:url value="/resources/js/popper.min.js" var="popperJs"></spring:url>
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"></spring:url>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title>
<script type="text/javascript" src="${ jqueryJs}"></script>
<script type="text/javascript" src="${bootstrapJs}"></script>
<script type="text/javascript" src="${popperJs}"></script>
<link href="${bootstrapCss}" rel="stylesheet">
</head>
<body>
	<div style="width: 100%" >
		<tiles:insertAttribute name="header" ignore="false"></tiles:insertAttribute>
	</div>
	<div style="width: 100%" class="container mt-5" >
		<tiles:insertAttribute name="body" ignore="false"></tiles:insertAttribute>
	</div>
	<div style="width: 100%" class="mt-5">
		<tiles:insertAttribute name="footer" ignore="false"></tiles:insertAttribute>
	</div>
</body>
</html>