package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Categoria;

public interface CategoriaRepository extends JpaRepository <Categoria, Integer> {
	//public List <Categoria> findByNomeCategoria(String nomeCategoria);
	
	 List<Categoria> findByNomeCategoriaContaining(String nomeCategoria);
}
