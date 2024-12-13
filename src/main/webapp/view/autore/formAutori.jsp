<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista autori</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<table  class="table table-success table-striped table-hover mt-5">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Eta</th>
				<th>Nazionalita</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="autore" items="${listaAutori}">
					<tr>
						<td>${autore.getNome()}</td>
						<td>${autore.getCognome()}</td>
						<td>${autore.getEta()}</td>
						<td>${autore.getNazionalita()}</td>
						<td><a class="link-danger link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover" href="autore/elimina/${autore.getId()}">Elimina</a></td>
						<td><a class="link-primary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"href="autore/preAggiornaAutore/${autore.getId()}">Aggiorna</a></td>
					</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/" class="btn btn-success">Torna alla Home</a>
</div>
</body>
</html>