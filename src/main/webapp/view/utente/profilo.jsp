<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profilo</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="/css/inserisci.css" />
</head>
<body class="onlyColor">
<div class="insert-page">
  <div class="form">
	<form action="/utente/aggiornaProfilo" method="POST">
	<input type="hidden" id="id" name="id" value="${userForm.id}" required />
		<label for="nomeUtente" class="titoli">Nome</label>
		<input type="text" id="nomeUtente" name="nomeUtente" value="${userForm.nomeUtente}"required/>
		<br><br>
		<label for="cognomeUtente" class="titoli">Cognome</label>
		<input type="text" id="cognomeUtente" name="cognomeUtente" value="${userForm.cognomeUtente}"required/>
		<br><br>
		<label for="email" class="titoli">Email</label>
		<input type="email" id="email" name="email" value="${userForm.email}"required/>
		<br><br>
		<label for="password" class="titoli">Password</label>
		<input type="password" id="password" name="password"required/>
		<br><br>
		<button type="submit" class="bottoneAggiorna">Aggiorna Profilo</button>
		<br><br>
		<a href="/" class="bottone">Torna alla Home</a>
	</form>
</div>
</div>
</body>
</html>