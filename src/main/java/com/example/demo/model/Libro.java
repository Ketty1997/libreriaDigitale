package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Libro implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)//genera automaticamente chiave primaria
	private int id;
	private String nomeLibro;
	@ManyToOne
	@JoinColumn(name="idAutore")
	private Autore autore;
	private int prezzo;
	private int numeroPag;
	@ManyToOne
	@JoinColumn(name="idCategoria")
	private Categoria categoria;
	
	public Libro() {}
	public Libro(String nomeLibro, Autore autore, int prezzo, int numeroPag,Categoria categoria) {
		this.nomeLibro=nomeLibro;
		this.autore= autore;
		this.prezzo= prezzo;
		this.numeroPag= numeroPag;
		this.categoria = categoria;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeLibro() {
		return nomeLibro;
	}
	public void setNomeLibro(String nomeLibro) {
		this.nomeLibro = nomeLibro;
	}
	public Autore getAutore() {
		return autore;
	}
	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	public int getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	public int getNumeroPag() {
		return numeroPag;
	}
	public void setNumeroPag(int numeroPag) {
		this.numeroPag = numeroPag;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Libro [id=" + id + ", nomeLibro=" + nomeLibro + ", autore=" + autore + ", prezzo=" + prezzo
				+ ", numeroPag=" + numeroPag + "]";
	}
	
}
