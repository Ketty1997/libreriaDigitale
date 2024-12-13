package com.example.demo.dto.builder;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.LibroDto;
import com.example.demo.model.Autore;
import com.example.demo.model.Categoria;
import com.example.demo.model.Libro;

public class LibroDtoBuilder {
	public static Libro LibroFromDtoToEntity(LibroDto lDto) {
		Libro l = new Libro();
		l.setId(lDto.getId());
		l.setNomeLibro(lDto.getNomeLibro());
		l.setNumeroPag(lDto.getNumeroPag());
		l.setPrezzo(lDto.getPrezzo());
		l.setCategoria(new Categoria(lDto.getIdCategoria()));
		l.setAutore(new Autore(lDto.getIdAutore()));
		return l;
	}
	public static List <LibroDto> LibroFromEntityToDto (List<Libro> libri){
		List <LibroDto> libriDto = new ArrayList<>();
		for(Libro l: libri) {
			libriDto.add(LibroFromEntityToDto(l));
		}
		return libriDto;
	}
	public static LibroDto LibroFromEntityToDto(Libro l) {
		LibroDto lDto = new LibroDto();
		lDto.setId(l.getId());
		lDto.setNomeLibro(l.getNomeLibro());
		lDto.setNumeroPag(l.getNumeroPag());
		lDto.setPrezzo(l.getPrezzo());
		lDto.setIdCategoria(l.getCategoria().getId());
		lDto.setIdAutore(l.getAutore().getId());
		return lDto;
	}
}
