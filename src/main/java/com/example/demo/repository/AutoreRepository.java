package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Autore;

public interface AutoreRepository extends JpaRepository <Autore, Integer>{
	public List <Autore> findByNome(String nome);
	public List <Autore> findByCognome(String cognome);
	//List<Autore> findByCognomeContaining(String cognome);
	public List <Autore> findByNomeAndCognome(String nome, String cognome);
	
	 // Nuovo metodo per cercare autori per nome o cognome parziale, case-insensitive
    List<Autore> findByNomeContainingIgnoreCaseOrCognomeContainingIgnoreCase(@Param("nome") String nome, @Param("cognome") String cognome);
}
