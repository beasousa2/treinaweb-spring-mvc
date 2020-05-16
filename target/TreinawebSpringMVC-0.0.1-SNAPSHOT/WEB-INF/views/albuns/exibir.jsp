<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exibir Album</title>
</head>
<body>
	<h2>Treinaweb: Exibir Album</h2>
	<p><label>Nome do Album: </label>${album.getAlbumName()}</p>
	<p><label>Ano de Lançamento: </label>${album.getReleaseYear()}</p>
</body>
</html>