package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {
	
	//In Java, Optional è una classe che fa parte del pacchetto java.util ed è 
	//utilizzata per rappresentare un valore che potrebbe essere presente o assente. 
	Optional <Utente> findByEmailAndPassword(String email, String password);
	//metodo che mi permette di trovare un utente tramite email e password
	
	Optional<Utente> findByEmail(String email); // Trova un utente per email
	
	
}
