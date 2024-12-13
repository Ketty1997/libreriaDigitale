<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>Home</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarScroll">
      <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
    	  <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Libri
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/libro/preInserisciLibro">Inserisci</a></li>
            <li><a class="dropdown-item" href="/libro">Vedi tutti</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Autori
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/autore/preInserisciAutore">Inserisci</a></li>
            <li><a class="dropdown-item" href="/autore">Vedi tutti</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Categorie
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/categoria/preInserisciCat">Inserisci</a></li>
            <li><a class="dropdown-item" href="/categoria">Vedi tutte</a></li>
          </ul>
        </li>
      </ul>
       <form class="d-flex forMedia" role="search" method="POST" action ="/libro/ricercaPerCategoria">
        <input name="nomeCategoria" class="form-control me-2" type="search" placeholder="Cerca categoria" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Cerca</button>
      </form>
       <form class="d-flex forMedia" role="search" method="POST" action ="/libro/ricercaPerAutore">
        <input name="input" class="form-control me-2" type="search" placeholder="Cerca autore" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Cerca</button>
      </form>
      <form action="/utente/logout" method="get">
    		<button type="submit" class="btn btn-success">Logout</button>
	</form>
    </div>
  </div>
</nav>
<div class="box-home">
	<div class="box-testi">
		<h2>Benvenuto nel tuo gestionale di libri!</h2>
	    <p>${message}</p>
	    <p>Organizza, cataloga e gestisci la tua libreria in modo semplice e intuitivo. Qui puoi tenere traccia dei tuoi libri, monitorare prestiti, e scoprire nuove letture.
		Inizia subito e rendi la tua passione per i libri ancora più accessibile e organizzata! 📚</p>
		<div class="box-buttons">
			
			 <form action="/utente/profilo" method="get">
        	<button type="submit" class="btn btn-success">Il mio profilo</button>
    		</form>
		</div>
	</div>
	<div class="box-img">
		<img src="/img/libreria.jpg">
	</div>
	
</div>
	<!--
	<h2>Autori</h2>
	<a href="/autore/preInserisciAutore" target="_blank"> Inserisci autore</a>
	<br>
	<a href="/autore" target="_blank">Tutti gli autori</a>
	
	<h2>Categorie</h2>
	<a href="/categoria/preInserisciCat" target="_blank"> Inserisci categoria</a>
	<br>
	<a href="/categoria" target="_blank">Tutte le categorie</a>
	<br><br>
	<form method="POST" action ="/libro/ricercaPerCategoria">
		<label for="nomeCategoria">Inserisci Categoria</label>
		<input name="nomeCategoria" type="text"/>
		<input type="submit" value="cerca"/>
	 </form>
	
	<h2>Libri</h2>
	<a href="/libro/preInserisciLibro" target="_blank">Inserisci libro</a>
	<br>
	<a href="/libro">Tutti i libri</a>
	<br><br>
	<form method="POST" action="/libro/ricercaPerAutore">
		<label for="input">Inserisi autore</label>
		<input name="input" type="text"/>
		<input type="submit" value="cerca">
	</form>
	<form action="/utente/logout" method="get">
    	<button type="submit">Logout</button>
	</form>
	 <form action="/utente/profilo" method="get">
        <button type="submit">Modifica Profilo</button>
    </form>
      -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>