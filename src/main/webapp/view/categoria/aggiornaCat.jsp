<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aggiorna Categoria</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="/css/inserisci.css" />
</head>
<body>
<div class="insert-page">
  <div class="form">
	<f:form modelAttribute="catAgg" method="post" action="/categoria/aggiornaCat">
		<f:input path="id" type="hidden"/>
		<f:label path="nomeCategoria" class="titoli">Categoria</f:label>
		<br>
		<f:input path="nomeCategoria"/>
		<br><br>
		<input type="submit" value="Aggiorna categoria" class="bottoneAggiorna">
	</f:form>
</div>
</div>
</body>
</html>