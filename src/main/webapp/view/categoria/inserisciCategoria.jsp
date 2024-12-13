<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserisci Categoria</title>
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
 	<f:form modelAttribute="categoriaForm" method="post" action="inserisciCat">
 		<f:label path="nomeCategoria" class="titoli">Categoria</f:label>
 		<br>
 		<f:input path="nomeCategoria"/>
 		<br><br>
 		<input type="submit" value="Inserisci categoria" class="bottone">
 	
 	</f:form>
 </div>
 </div>
</body>
</html>