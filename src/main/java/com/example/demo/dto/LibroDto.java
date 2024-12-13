package com.example.demo.dto;

public class LibroDto {
	private int id;
	private String nomeLibro;
	private int idAutore;
	private int prezzo;
	private int numeroPag;
	private int idCategoria;
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
	public int getIdAutore() {
		return idAutore;
	}
	public void setIdAutore(int idAutore) {
		this.idAutore = idAutore;
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
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	
}
