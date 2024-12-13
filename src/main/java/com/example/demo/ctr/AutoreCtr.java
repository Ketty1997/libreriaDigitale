package com.example.demo.ctr;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.AutoreDto;
import com.example.demo.dto.CategoriaDto;
import com.example.demo.dto.builder.AutoreDtoBuilder;
import com.example.demo.dto.builder.CategoriaDtoBuilder;
import com.example.demo.model.Autore;
import com.example.demo.repository.AutoreRepository;



@Controller
@RequestMapping("autore")
public class AutoreCtr {
	
	@GetMapping({"","/"}) //mapping disponibile all'url /autore o /autore/
	public String listaAutori(Model model) {
		List<AutoreDto> autori = AutoreDtoBuilder.AutorefromEntityToDto(autoreRep.findAll());
		model.addAttribute("listaAutori", autori);
		return "/view/autore/formAutori.jsp";
	}
	@GetMapping("preInserisciAutore")
	public String inserisci(Model model) {
		AutoreDto aDto = new AutoreDto();
		model.addAttribute("autoreForm", aDto);
		return "/view/autore/inserisciAutore.jsp"; //cartella + file jsp
	}
	
	@Autowired
	private AutoreRepository autoreRep;
	
	@PostMapping("inserimentoAutore")
	public String inserisciAutore(Model model, @ModelAttribute("autoreForm") AutoreDto i) {
		 // Lista per raccogliere eventuali errori
	    List<String> errori = new ArrayList<>();

	    // Controlli sui campi
	    if (i.getNome() == null || i.getNome().trim().isEmpty()) {
	        errori.add("Il nome non può essere vuoto");
	    }
	    if (i.getCognome() == null || i.getCognome().trim().isEmpty()) {
	        errori.add("Il cognome non può essere vuoto");
	    }
	    if (i.getNazionalita() == null || i.getNazionalita().trim().isEmpty()) {
	        errori.add("La nazionalità non può essere vuota");
	    }

	    if (Objects.isNull(i.getEta()) || i.getEta() <= 0) {
	        errori.add("Età deve essere maggiore di zero");
	    }
	   

	    // Se ci sono errori, aggiungili al modello e ricarica la pagina
	    if (!errori.isEmpty()) {
	        model.addAttribute("errori", errori);
	        List<AutoreDto> autori = AutoreDtoBuilder.AutorefromEntityToDto(autoreRep.findAll());
	        model.addAttribute("autori", autori);
	        return "/view/autore/inserisciAutore.jsp";
	    }
		Autore a = AutoreDtoBuilder.AutorefromDtoToEntity(i);
		autoreRep.save(a);
		return "/view/operazioneSuccess.jsp";
		
	}
	@GetMapping("preAggiornaAutore/{id}")
	public String mostraFormAggiornamento(Model model, @PathVariable int id) {
		model.addAttribute("autoreAggiorna", AutoreDtoBuilder.AutorefromEntityToDto(autoreRep.findById(id).orElse(new Autore())));
	    return "/view/autore/aggiornaAutore.jsp";  // Pagina JSP con il form per l'aggiornamento
	}
	@PostMapping("aggiornaAutore")
	public String aggiorna (Model model, @ModelAttribute("autoreAggiorna") AutoreDto i) {
		Autore a = AutoreDtoBuilder.AutorefromDtoToEntity(i);
		autoreRep.save(a);
		return "/view/operazioneSuccess.jsp";
		
	}
	
	@GetMapping("/elimina/{id}")
	public String elimina(@PathVariable int id) {
		autoreRep.deleteById(id);
		return "/view/operazioneSuccess.jsp";
	}
	
}
