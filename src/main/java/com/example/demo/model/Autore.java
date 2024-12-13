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
public class Autore  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)//genera automaticamente chiave primaria
	private int id;
	private String nome;
	private String cognome;
	private String nazionalita;
	private int eta;
	@OneToMany(mappedBy="autore", cascade= CascadeType.REMOVE)
	private List<Libro> libri;
	
	public List<Libro> getLibri() {
		return libri;
	}

	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}

	public Autore(){}
	
	public Autore(int id){
		this.id=id;
	}
	
	public Autore(String nome, String cognome, String nazionalita, int eta) {
		this.nome=nome;
		this.cognome=cognome;
		this.nazionalita=nazionalita;
		this.eta=eta;
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
	@Override
	public String toString() {
		return "Autore [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", nazionalita=" + nazionalita
				+ ", eta=" + eta + "]";
	}
	
	
}
