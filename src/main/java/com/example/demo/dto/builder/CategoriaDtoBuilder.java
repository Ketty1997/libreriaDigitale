package com.example.demo.dto.builder;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.CategoriaDto;
import com.example.demo.model.Categoria;

public class CategoriaDtoBuilder {
	public static Categoria catFromDtoToEntity(CategoriaDto cDto) {
		Categoria c = new Categoria();
		c.setId(cDto.getId());
		c.setNomeCategoria(cDto.getNomeCategoria());
		return c;
	}
	public static List <CategoriaDto> catFromEntityToDto (List <Categoria> categorie){
		List <CategoriaDto> cDto = new ArrayList<>();
		for(Categoria c: categorie) {
			cDto.add(catFromEntityToDto(c));
		}
		return cDto;
	}
	public static CategoriaDto catFromEntityToDto(Categoria c) {
		CategoriaDto cDto = new CategoriaDto();
		cDto.setId(c.getId());
		cDto.setNomeCategoria(c.getNomeCategoria());
		return cDto;
	}
}
