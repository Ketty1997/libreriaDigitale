package com.example.demo.ctr;

import java.nio.file.spi.FileSystemProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.AutoreDto;
import com.example.demo.dto.CategoriaDto;
import com.example.demo.dto.LibroDto;
import com.example.demo.dto.builder.AutoreDtoBuilder;
import com.example.demo.dto.builder.CategoriaDtoBuilder;
import com.example.demo.dto.builder.LibroDtoBuilder;
import com.example.demo.model.Autore;
import com.example.demo.model.Categoria;
import com.example.demo.model.Libro;
import com.example.demo.repository.AutoreRepository;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.LibroRepository;

import org.springframework.ui.Model;

@Controller
@RequestMapping("libro")
public class LibroCtr {
	
	@Autowired
	private LibroRepository libroRep;
	@Autowired
	private AutoreRepository autoreRep;
	@Autowired
	private CategoriaRepository catRep;
	
	
	@GetMapping({"","/"})
	public String listaLibri(Model model) {
		List <LibroDto> lDto = LibroDtoBuilder.LibroFromEntityToDto(libroRep.findAll());
		model.addAttribute("listaL", lDto);
		return "/view/libro/listaLibri.jsp";
	}
	
	@GetMapping("preInserisciLibro")
	public String inserisci(Model model) {
		LibroDto lDto = new LibroDto();
		List <AutoreDto> autori =AutoreDtoBuilder.AutorefromEntityToDto(autoreRep.findAll());
		List <CategoriaDto> categorie = CategoriaDtoBuilder.catFromEntityToDto(catRep.findAll());
		model.addAttribute("autori",autori);
		model.addAttribute("categorie", categorie);
		model.addAttribute("libroForm", lDto);
		return "/view/libro/inserisciLibro.jsp";
	}
	
	@PostMapping("inserisciLibro")
	public String inserisciLibro(Model model, @ModelAttribute("libroForm") LibroDto l) {
		 // Lista per raccogliere eventuali errori
	    List<String> errori = new ArrayList<>();

	    // Controlli sui campi
	    if (l.getNomeLibro() == null || l.getNomeLibro().trim().isEmpty()) {
	        errori.add("Il titolo non può essere vuoto");
	    }
	    if (Objects.isNull(l.getIdAutore())|| l.getIdAutore() == -1) {
	        errori.add("Devi selezionare un autore");
	    }
	    if (Objects.isNull(l.getIdCategoria()) || l.getIdCategoria() == -1) {
	        errori.add("Devi selezionare una categoria");
	    }
	    if (Objects.isNull(l.getPrezzo()) || l.getPrezzo() <= 0) {
	        errori.add("Il prezzo deve essere maggiore di zero");
	    }
	    if (Objects.isNull(l.getNumeroPag()) || l.getNumeroPag() <= 0) {
	        errori.add("Il numero di pagine deve essere maggiore di zero");
	    }
	   

	    // Se ci sono errori, aggiungili al modello e ricarica la pagina
	    if (!errori.isEmpty()) {
	        model.addAttribute("errori", errori);
	        List<AutoreDto> autori = AutoreDtoBuilder.AutorefromEntityToDto(autoreRep.findAll());
	        List<CategoriaDto> categorie = CategoriaDtoBuilder.catFromEntityToDto(catRep.findAll());
	        model.addAttribute("autori", autori);
	        model.addAttribute("categorie", categorie);
	        return "/view/libro/inserisciLibro.jsp";
	    }

		Libro libro = LibroDtoBuilder.LibroFromDtoToEntity(l);
		libroRep.save(libro);
		return "/view/operazioneSuccess.jsp";
	}
	
	@GetMapping("preAggiornaLibro/{id}")
	public String aggiorna(Model model, @PathVariable int id) {
		List <AutoreDto> autori =AutoreDtoBuilder.AutorefromEntityToDto(autoreRep.findAll());
		List <CategoriaDto> categorie = CategoriaDtoBuilder.catFromEntityToDto(catRep.findAll());
		model.addAttribute("autori",autori);
		model.addAttribute("categorie", categorie);
		model.addAttribute("libroAgg", LibroDtoBuilder.LibroFromEntityToDto(libroRep.findById(id).orElse(new Libro())));
		return "/view/libro/aggiornaLibro.jsp";
	}
	
	@PostMapping("aggiornaLibro")
	public String aggiornaLibro(Model model, @ModelAttribute("libroAgg") LibroDto l) {
		Libro libro = LibroDtoBuilder.LibroFromDtoToEntity(l);
		libroRep.save(libro);
		return "/view/operazioneSuccess.jsp";
	}
	
	@GetMapping("/elimina/{id}")
	public String eliminaLibro(@PathVariable int id) {
		libroRep.deleteById(id);
		return "/view/operazioneSuccess.jsp";
	}
	
	@PostMapping("/ricercaPerAutore") 
	public String ricercaPerAutore(Model model, @RequestParam("input") String input) {
		//controllo che l'input e' vuoto, metto input nel request param cosi evito di scrivere nome e cognome
		//se l'input e' nullo O vuoto allora aggiungo al modello un messaggio di errore. Trim() e' un metodo di java che rimuove gli spazi bianchi iniziali e finali di una stringa
		//È utile per pulire l'input degli utenti, perché spesso gli utenti possono accidentalmente inserire spazi prima o dopo il testo.
		if(input ==null || input.trim().isEmpty()) {
			model.addAttribute("errore", "Il campo di ricerca non può essere vuoto");
			return "/view/libro/listaLibri.jsp";
		}
		//faccio una ricerca autori per cognome che mi restituisce tutti gli autori con quel cognome
		//il metodo findBycognome ce l'ho nel repository di autore 
		//List<Autore> autori = autoreRep.findByCognome(cognome);
		List<Autore> autori = autoreRep.findByNomeContainingIgnoreCaseOrCognomeContainingIgnoreCase(input, input);
		//se non ci sono autori aggiungo un messaggio di errore al modello
		if(autori.isEmpty()) {
			model.addAttribute("errore", "Autore non disponibile");
			return "/view/libro/listaLibri.jsp";
		}
		
		//creo una lista di libri
		List<Libro> libri = new ArrayList<Libro>();
		//tutti i libri che sono all'interno dell'autore li inserisco nella lista libri
		for(Autore a: autori) {
			libri.addAll(a.getLibri());//prendo la lista di libri nel model autore
		}
		//aggiungo al model e passo la lista trasformata da entity a DTO
		model.addAttribute("listaL", LibroDtoBuilder.LibroFromEntityToDto(libri));
		//mi ritorno la lista di libri che gia ho, ma con questo controller mi viene filtrata appunto per autore
		return "/view/libro/listaLibri.jsp";
	}
	
	@PostMapping("/ricercaPerCategoria")
	public String ricercaPerCategoria(Model model, @RequestParam("nomeCategoria") String nomeCategoria) {
		//se l'input e' nullo o vuoto inserisco un messaggio di errore nel modello
		if(nomeCategoria==null || nomeCategoria.trim().isEmpty()) {
			model.addAttribute("errore", "Il campo di ricerca non può essere vuoto");
			return"/view/libro/listaLibri.jsp";
		}
		List<Categoria> categorie = catRep.findByNomeCategoriaContaining(nomeCategoria);
		//se la categoria inserita non esiste
		if(categorie.isEmpty()) {
			model.addAttribute("errore", "Categoria non disponibile");
			return"/view/libro/listaLibri.jsp";
		}
		List <Libro> libri = new ArrayList<Libro>();
		for(Categoria c: categorie) {
			libri.addAll(c.getLibri());
		
	}
		model.addAttribute("listaL" , LibroDtoBuilder.LibroFromEntityToDto(libri));
		return "/view/libro/listaLibri.jsp";
	
}
}
