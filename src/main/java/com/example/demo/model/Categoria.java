package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categoria implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)//genera automaticamente chiave primaria
	private int id;
	
	@OneToMany(mappedBy="categoria", cascade= CascadeType.REMOVE)
	private List <Libro> libri;
	
	private String nomeCategoria;
	
	public Categoria () {}
	
	public List<Libro> getLibri() {
		return libri;
	}

	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}

	public Categoria(String nomeCategoria) {
		this.nomeCategoria= nomeCategoria;
	}
	public Categoria(int id) {
		this.id= id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
}
