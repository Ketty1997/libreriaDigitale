<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista libri</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
<!-- messaggio di errore -->
<c:if test="${not empty errore}"> <!-- cif e' un tag usato per eseguire una porzione di codice html solo se un condizione
 e' sempre vera, il test contiene l'espressione condizionale da valutare. errore e' l'attributo che abbiamo inserito nel modello
che con not empty verifichiamo che non sia vuoto -->
	<div class="alert alert-danger" role="alert">
		${errore}
	</div>
</c:if>
	<table class="table table-success table-striped table-hover mt-5">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Autore</th>
				<th>Prezzo</th>
				<th>Numero pagine</th>
				<th></th>
				<th></th>
			</tr>
		</thead> 
		<tbody>
			<c:forEach var="libro" items="${listaL}">
				<tr>
				<td>${libro.getNomeLibro()}</td>
				<td>${libro.getIdAutore()}</td>
				<td>${libro.getPrezzo()}</td>
				<td>${libro.getNumeroPag()}</td>
				<td><a class="link-danger link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover" href="libro/elimina/${libro.getId()}">Elimina</a></td>
				<td><a class="link-primary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"href="libro/preAggiornaLibro/${libro.getId()}">Aggiorna</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/" class="btn btn-success">Torna alla Home</a>
</div>
</body>
</html>