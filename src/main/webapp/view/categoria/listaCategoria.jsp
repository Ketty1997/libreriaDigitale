<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Categorie</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<table class="table table-success table-striped table-hover mt-5">
		<thead>
			<tr>
				<th>Categorie</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cat" items="${listaCat}">
				<tr>
					<td>${cat.getNomeCategoria()}</td>
					<td><a class="link-danger link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover" href="categoria/elimina/${cat.getId()}">Elimina</a></td>
					<td><a class="link-primary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover" href="categoria/preAggiornaCat/${cat.getId()}">Aggiorna</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/" class="btn btn-success">Torna alla Home</a>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>