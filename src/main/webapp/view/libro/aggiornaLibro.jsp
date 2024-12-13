<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aggiorna Libro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="/css/inserisci.css" />
</head>
<body>
<div class="insert-page">
  <div class="form">
	<f:form modelAttribute="libroAgg" method="post" action="/libro/aggiornaLibro">
		<f:input path="id" type="hidden"/>
		
		<f:label path="nomeLibro" class="titoli">Titolo</f:label>
		<f:input path="nomeLibro"/>
		<!--  
		<f:label path="idAutore">Autore</f:label>
		<f:input path="idAutore"/>-->
		<f:label path="idAutore"></f:label>
		<f:select  class="form-select" aria-label="Default select example" path="idAutore">
			  <f:options items="${autori}" itemValue="id" itemLabel="cognome"/>
		</f:select>
		<br>
		<f:label path="prezzo" class="titoli">Prezzo</f:label>
		<f:input path="prezzo"/>
		<br><br>
		<f:label path="numeroPag" class="titoli">Numero pagine</f:label>
		<f:input path="numeroPag"/>
		<!--  
		<f:label path="idCategoria">Categoria</f:label>
		<f:input path="idCategoria"/>
		-->
		<br><br>
		<f:select class="form-select" path="idCategoria">
			<f:options items="${categorie}" itemValue="id" itemLabel="nomeCategoria"/>
		</f:select>
		<br><br>
		<input type="submit" value="Aggiorna libro" class="bottoneAggiorna"/>
	</f:form>
</div>
</div>
</body>
</html>