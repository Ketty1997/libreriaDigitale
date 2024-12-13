package com.example.demo.dto.builder;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.UtenteDto;
import com.example.demo.model.Utente;

public class UtenteDtoBuilder {
	public static Utente UtenteFromDtoToEntity(UtenteDto uDto) {
		Utente u = new Utente();
		u.setId(uDto.getId());
		u.setNomeUtente(uDto.getNomeUtente());
		u.setCognomeUtente(uDto.getCognomeUtente());
		u.setEmail(uDto.getEmail());
		u.setPassword(uDto.getPassword());
		return u;
	}
	
	public static List<UtenteDto> UtenteFromEntityToDto(List<Utente> utenti){
		List <UtenteDto> utentiDto = new ArrayList<>();
		for(Utente u: utenti) {
			utentiDto.add(UtenteFromEntityToDto(u));
		}
		return utentiDto;
	}
	
	public static UtenteDto UtenteFromEntityToDto(Utente u) {
		UtenteDto uDto = new UtenteDto();
		uDto.setId(u.getId());
		uDto.setNomeUtente(u.getNomeUtente());
		uDto.setCognomeUtente(u.getCognomeUtente());
		uDto.setEmail(u.getEmail());
		uDto.setPassword(u.getPassword());
		return uDto;
	}
	
	
}
