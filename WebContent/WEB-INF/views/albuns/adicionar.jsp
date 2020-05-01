<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Album</title>
</head>
<body>
	<j:url var="actionAdd" value="/albuns/adicionar" ></j:url>
	<h2>Treinaweb Adição de Albuns</h2>
	
	<f:form action="${actionAdd}" method="POST" modelAttribute="album">
		<label>Nome</label>
		<f:input path="albumName"/><br>
		<f:errors path="albumName"></f:errors>
		<label>Ano de Lançamento</label>
		<f:input path="releaseYear"/><br><br>
		<f:errors path="releaseYear"></f:errors>
		<input type="submit" value="Salvar">
	</f:form>

</body>
</html>