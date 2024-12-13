package com.example.demo.dto;

public class UtenteDto {
	private int id;
	private String nomeUtente;
	private String cognomeUtente;
	private String email;
	private String password;
	
	public UtenteDto() {}
	
	public UtenteDto(int id) {
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getCognomeUtente() {
		return cognomeUtente;
	}

	public void setCognomeUtente(String cognomeUtente) {
		this.cognomeUtente = cognomeUtente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
