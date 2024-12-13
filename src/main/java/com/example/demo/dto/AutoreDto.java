package com.example.demo.dto;

public class AutoreDto {
	private int id;
	private String nome;
	private String cognome;
	private String nazionalita;
	private int eta;
	
	public AutoreDto() {}
	
	public AutoreDto(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNazionalita() {
		return nazionalita;
	}
	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	
	
}
