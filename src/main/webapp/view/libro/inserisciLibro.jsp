<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserisci Libro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="/css/inserisci.css" />
</head>

<body>
<c:if test="${not empty errori}">
    <div class="alert-danger alert">
        <ul>
            <c:forEach var="errore" items="${errori}">
                <li>${errore}</li>
            </c:forEach>
        </ul>
    </div>
</c:if>
<div class="insert-page">
  <div class="form">
	<f:form modelAttribute="libroForm" method="post" action="inserisciLibro">
		<f:label path="nomeLibro"  class="titoli">Titolo</f:label>
		<f:input path="nomeLibro"/>
		<!--  
		<f:label path="idAutore">Autore</f:label>
		<f:input path="idAutore"/>
		-->
		<!-- Menu a tendina (select) per la selezione di un autore
		Opzioni del menu items="${autori}": stai passando una lista di autori dal controller. 
    	Ogni autore è un oggetto con almeno due proprietà: "id" e "cognome".
    	itemValue="id": imposta l'ID dell'autore come valore dell'opzione nel menu a tendina.
    	itemLabel="cognome": mostra il cognome dell'autore come testo visibile all'utente nel menu a tendina
    	Il tag f:options cicla attraverso ogni elemento della lista autori e crea un'opzione nel menu a tendina. 
    	Quindi, anche se non vedi un ciclo esplicito nel JSP, il ciclo avviene grazie al tag items="${autori}"-->
		<f:label path="idAutore"></f:label>
		<f:select  class="form-select" aria-label="Default select example" path="idAutore">
			  <option value="-1" selected>Scegli autore</option>
			  <f:options items="${autori}" itemValue="id" itemLabel="cognome"/>
		</f:select>
		<br>
		<f:label path="prezzo" class="titoli">Prezzo</f:label>
		<f:input path="prezzo"/>
		<br> <br>
		<f:label path="numeroPag" class="titoli">Numero pagine</f:label>
		<f:input path="numeroPag"/>
		
		<br><br>
		<!-- faccio la stessa cosa per categoria -->
		<f:select class="form-select" path="idCategoria">
		<option value="-1" selected>Scegli categoria</option> 
			<f:options items="${categorie}" itemValue="id" itemLabel="nomeCategoria"/>
		</f:select>
		
		<br><br>
		
		<input class="bottone" type="submit" value="Inserisci libro"/>
	</f:form>
</div>
</div>
	<!--  
	<c:forEach var="autore" items="${autori}">
		<p>${autore.getId()}</p>
		<p>${autore.getNome()}</p>
		<p>${autore.getCognome()}</p>
	</c:forEach>
	<c:forEach var="cat" items="${categorie}">
		<p>${cat.getNomeCategoria()}</p>
	</c:forEach>
	-->
	<script><script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script></script>
</body>
</html>