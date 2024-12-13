package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Autore;
import com.example.demo.model.Libro;

public interface LibroRepository extends JpaRepository <Libro, Integer> {
	public Libro findByNomeLibro(String nomeLibro);
	public List<Libro> findByAutore(Autore autore);
	
	
}
