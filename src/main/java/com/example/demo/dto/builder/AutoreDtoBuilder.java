package com.example.demo.dto.builder;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.AutoreDto;
import com.example.demo.model.Autore;

public class AutoreDtoBuilder {
	public static Autore AutorefromDtoToEntity(AutoreDto aDto) {
		Autore a = new Autore();
		a.setId(aDto.getId());
		a.setNome(aDto.getNome());
		a.setCognome(aDto.getCognome());
		a.setEta(aDto.getEta());
		a.setNazionalita(aDto.getNazionalita());
		return a;
	}
	
	public static List<AutoreDto> AutorefromEntityToDto(List<Autore> autori){
		List<AutoreDto> autoriDto = new ArrayList<>();
		for (Autore a : autori) {
			autoriDto.add(AutorefromEntityToDto(a));
		}
		return autoriDto;
	}
	
	public static AutoreDto AutorefromEntityToDto(Autore a) {
		AutoreDto aDto = new AutoreDto();
		aDto.setId(a.getId());
		aDto.setNome(a.getNome());
		aDto.setCognome(a.getCognome());
		aDto.setEta(a.getEta());
		aDto.setNazionalita(a.getNazionalita());
		return aDto;
	}
}
