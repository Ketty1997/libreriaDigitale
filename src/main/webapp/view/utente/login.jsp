<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="/css/login.css"/>
</head>
<body>
	
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
 
 <div class="container" id="container">
 
 	<div class="form-container sign-up-container">
  <!-- Sign Up Form -->
    <f:form action="/utente/register" method="post" modelAttribute="loginForm">
    <h1>Registrati</h1>
    <br>
        <f:input placeholder="Nome" id="nomeUtente" path="nomeUtente" type="text" required="true"/>
        <f:input placeholder="Cognome" id="cognomeUtente" path="cognomeUtente" type="text" required="true"/>
        <f:input placeholder="Email" id="email" path="email" type="email" required="true"/>
        <f:input placeholder="Password" id="password" path="password" type="password"  required="true"/>
        <br>
        <button type="submit">Registrati</button>
    </f:form>
    </div>
    <div class="form-container sign-in-container">
    <form action="/utente/login" method="post">
    <h1>Accedi</h1>
       <br>
        <input placeholder="Email" type="email" id="email" name="email" value="${loginForm.email}" required>
        <input placeholder="Password" type="password" id="password" name="password" value="${loginForm.password}"  required>
        <br>
        <button type="submit">Login</button>
    </form>
    </div>
    <div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1>Bentornato!</h1>
				<p>Per continuare il tuo viaggio nel nostro gestionale di libri, accedi con le tue credenziali e riprendi il controllo delle tue informazioni.</p>
				
				<button class="ghost" id="signIn">Login</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1>Ciao!</h1>
				<p>Registrati per unirti a noi in questo meraviglioso viaggio nel mondo della lettura. Crea il tuo account e inizia a gestire i tuoi libri preferiti.</p>
				<button class="ghost" id="signUp">Registrati</button>
			</div>
		</div>
	</div>
    </div>
   
    
    
    
    
   


	
	
	




<script>
const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});
</script>
</body>
</html>