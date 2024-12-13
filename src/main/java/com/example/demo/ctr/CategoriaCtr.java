package com.example.demo.ctr;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.AutoreDto;
import com.example.demo.dto.CategoriaDto;
import com.example.demo.dto.builder.AutoreDtoBuilder;
import com.example.demo.dto.builder.CategoriaDtoBuilder;
import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;

import org.springframework.ui.Model;

@Controller
@RequestMapping("categoria")
public class CategoriaCtr {
	
	@Autowired
	private CategoriaRepository catRep;
	
	@GetMapping({"","/"})
	public String listaCat(Model model) {
		List <CategoriaDto> categorie = CategoriaDtoBuilder.catFromEntityToDto(catRep.findAll());
		model.addAttribute("listaCat", categorie);
		System.out.println(categorie);
		return "/view/categoria/listaCategoria.jsp";
	}
	
	@GetMapping("preInserisciCat")
	public String inserisci(Model model) {
		CategoriaDto cDto = new CategoriaDto();
		model.addAttribute("categoriaForm", cDto);
		return "/view/categoria/inserisciCategoria.jsp";
	}
	@PostMapping("inserisciCat")
	public String inserisciCat(Model model, @ModelAttribute("categoriaForm") CategoriaDto cDto) {
		 // Lista per raccogliere eventuali errori
	    List<String> errori = new ArrayList<>();

	    // Controlli sui campi
	    if (cDto.getNomeCategoria() == null || cDto.getNomeCategoria().trim().isEmpty()) {
	        errori.add("Il campo non può essere vuoto");
	    }
	    
	    // Se ci sono errori, aggiungili al modello e ricarica la pagina
	    if (!errori.isEmpty()) {
	        model.addAttribute("errori", errori);
	        List<CategoriaDto> categorie = CategoriaDtoBuilder.catFromEntityToDto(catRep.findAll());
	        model.addAttribute("categorie", categorie);
	        return "/view/categoria/inserisciCategoria.jsp";
	    }
		Categoria cat = CategoriaDtoBuilder.catFromDtoToEntity(cDto);
		catRep.save(cat);
		return "/view/operazioneSuccess.jsp";
	}
	@GetMapping("preAggiornaCat/{id}")
	public String aggiorna(Model model, @PathVariable int id) {
		model.addAttribute("catAgg" , CategoriaDtoBuilder.catFromEntityToDto(catRep.findById(id).orElse(new Categoria())));
		return "/view/categoria/aggiornaCat.jsp";
	}
	
	@PostMapping("aggiornaCat")
	public String aggiornaCat(Model model, @ModelAttribute("catAgg") CategoriaDto cDto) {
		Categoria c = CategoriaDtoBuilder.catFromDtoToEntity(cDto);
		catRep.save(c);
		return "/view/operazioneSuccess.jsp";
	}
	
	@GetMapping("/elimina/{id}")
	public String elimina(Model model, @PathVariable int id) {
		catRep.deleteById(id);
		return "/view/operazioneSuccess.jsp";
	}
}
