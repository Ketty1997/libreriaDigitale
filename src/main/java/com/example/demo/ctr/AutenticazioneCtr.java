package com.example.demo.ctr;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.AutoreDto;
import com.example.demo.dto.UtenteDto;
import com.example.demo.dto.builder.AutoreDtoBuilder;
import com.example.demo.dto.builder.UtenteDtoBuilder;
import com.example.demo.model.Autore;
import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.service.AutenticazioneService;

import jakarta.servlet.http.HttpSession;


@RequestMapping("utente")
@Controller
public class AutenticazioneCtr {
	
	@Autowired
	private AutenticazioneService authService;
	@Autowired
	private UtenteRepository utenteRepo;
	//mostra il form di login
	@GetMapping("/login")
	public String mostaLogin(Model model) {
		UtenteDto uDto = new UtenteDto();
		model.addAttribute("loginForm", uDto);
		return "/view/utente/login.jsp"; 
	}
	
	//gestisce la richesta di login
	@PostMapping("/login")
	//Prende i parametri email e password inviati dal form di login e li passa al metodo.
	public String handleLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		//Questo chiama il metodo login del AutenticazioneService per verificare 
		//l’autenticazione dell’utente.
		//Il metodo login restituisce true se le credenziali sono corrette e false altrimenti.
		boolean isAuthenticated = authService.login(email, password);
		UtenteDto uDto = new UtenteDto();
		//Se isAuthenticated è true, il controller aggiunge un messaggio di successo 
		//("login avvenuto con successo") al modello, e reindirizza alla pagina home.jsp
		if(isAuthenticated) {
			session.setAttribute("isAuthenticated", true); //salva lo stato di autenticazione nella sessione
			session.setAttribute("userEmail", email);//salva l'email  dell'utente per eventuali utilizzi futuri
			return "/view/home.jsp";
			
		//Se isAuthenticated è false, aggiunge un messaggio di errore ("password o email sbagliata")
		//e reindirizza di nuovo alla pagina login.jsp per tentare nuovamente il login.
		}else {
			model.addAttribute("loginForm",uDto);
			model.addAttribute("error", "password o email sbagliata");
			return "/view/utente/login.jsp";
		}
	}
	
	//gestisce la registrazione

	@PostMapping("/register")
	
	//Prende i parametri nomeUtente, cognomeUtente, email, e password inviati dal form di registrazione.
	public String handleRegister(Model model, @ModelAttribute("loginForm") UtenteDto uDto, HttpSession session) {
		//password criptata, chiamo il metodo hashpw (dipendenza Bcript)
		String hashedPassword = BCrypt.hashpw(uDto.getPassword(), BCrypt.gensalt());
		//setto la password hashata
		uDto.setPassword(hashedPassword);
		//Questo chiama isEmailTaken di authService per verificare se l’email esiste già nel database.
		  if (authService.isEmailTaken(uDto.getEmail())) {
	            model.addAttribute("error", "Email gia usata");
	            return "/view/utente/login.jsp"; // Ritorna alla pagina di registrazione
	        }
		//Crea e salva un nuovo utente
	        Utente newUser = UtenteDtoBuilder.UtenteFromDtoToEntity(uDto);
	        
	        
	        // Chiama register di authService per salvare il nuovo utente nel database.
	        authService.register(newUser);
	        
	       session.setAttribute("isAuthenticated", true);
	       session.setAttribute("userEmail", uDto.getEmail());
	        //Se la registrazione è completata, viene aggiunto un messaggio ("Registratione avvenuta con successo") 
	        //al modello e si reindirizza l’utente a home.jsp.
	        model.addAttribute("message", "Registratione avvenuta con successo");
	        return "/view/home.jsp"; // Ritorna alla pagina di login per accedere
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate(); // Invalida la sessione corrente. Questo cancella tutte le informazioni salvate nella sessione, come lo stato di autenticazione e l'email dell'utente. In pratica, effettua il logout dell'utente.
	    return "redirect:/utente/login"; // Reindirizza alla pagina di login
	}
	
	//metodo che mi permette di ottenere i dati di un utente e visualizzarli nel form
	@GetMapping("/profilo")
	public String mostraProfiloUtente(Model model, HttpSession session) {
		String userEmail = (String)session.getAttribute("userEmail");//ottengo l'email dell'utente loggato
		Optional<Utente> userOpt = authService.findUserByEmail(userEmail); //trovo utente tramite mail, metodo implementato in service
		//controlla se l'utente esiste controllando che optional contenga un valore
		if(userOpt.isPresent()) {
			Utente user = userOpt.get(); //estrae l'utente dall'optional
			UtenteDto uDto = UtenteDtoBuilder.UtenteFromEntityToDto(user);//converto l'entita in dto per il form
			//aggiunge l'utente come attributo al modello per il form
			model.addAttribute("userForm", uDto);
			//ritorna il profilo dove l'utente puo aggiornare i dati
			return "/view/utente/profilo.jsp";
		} else {
			return "/view/utente/login.jsp"; // se l'utente non esiste reindirizza alla pagina di login
		}
	}
	
	
	//gestisco il salvataggio delle modifiche quando l'utente aggiorna i propri dati e invia il form
	@PostMapping("/aggiornaProfilo")
	public String aggiornaProfiloUtente(@ModelAttribute("userForm") UtenteDto uDto, HttpSession session, Model model) {
		String userEmail = (String) session.getAttribute("userEmail");//ottengo email dell'utente tramite la sessione
		//verifica che l'email nel form sia la stessa dell'utente loggato
		if(!userEmail.equals(uDto.getEmail())) {
			model.addAttribute("erroreAggiorna", "Non puoi aggiornare l'email");
			return "/view/utente/profilo.jsp"; //ritorna alla pagina del profilo con messagio di errore
		}
		 // Ottieni l'ID dell'utente dalla form
	    Integer userId = uDto.getId();
	    // Verifica se l'ID è valido (l'utente deve esistere)
	    if (userId == null || userId <= 0) {
	        model.addAttribute("error", "ID utente non valido");
	        return "/view/utente/profilo.jsp"; // Ritorna alla pagina del profilo con il messaggio di errore
	    }
	    //recupera l'utente dal db
	    Optional <Utente> userOpt = authService.findUserByEmail(userEmail);
	    if(userOpt.isEmpty()) {
	    	model.addAttribute("error","Utente non trovato");
	    	return "/view/utente/profilo.jsp";
	    }
	    
	    Utente u = userOpt.get();
	    //controlla se la password e' stata modificata
	    if(!u.getPassword().equals(uDto.getPassword())) {
	    	//la password e' stata modificata quindi criptala
	    	String hashedPas = BCrypt.hashpw(uDto.getPassword(), BCrypt.gensalt());
	    	uDto.setPassword(hashedPas);
	    }
	    //Aggiorna i dati dell'utente
		Utente utenteDto = UtenteDtoBuilder.UtenteFromDtoToEntity(uDto);
		authService.updateUser(utenteDto);//aggiorna l'utente nel db
		return"/view/operazioneSuccess.jsp";
	}

	
	/*
	@GetMapping("profilo/{id}")
	public String mostraFormAggiornamento(Model model, @PathVariable int id) {
		model.addAttribute("userForm", UtenteDtoBuilder.UtenteFromEntityToDto(utenteRepo.findById(id).orElse(new Utente())));
	    return "/view/utente/profilo.jsp";  // Pagina JSP con il form per l'aggiornamento
	}
	@PostMapping("aggiornaProfilo")
	public String aggiorna (Model model, @ModelAttribute("userForm") UtenteDto u) {
		Utente utente = UtenteDtoBuilder.UtenteFromDtoToEntity(u);
		utenteRepo.save(utente);
		return "/view/success.jsp";
		
	}
	*/

}
