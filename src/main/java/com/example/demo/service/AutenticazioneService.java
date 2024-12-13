package com.example.demo.service;

import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

// indica a Spring che questa classe è un componente di servizio, 
//quindi sarà gestito dal contesto di Spring come parte della logica applicativa.
@Service
public class AutenticazioneService {

    @Autowired
    private UtenteRepository utenteRepository;

    public boolean login(String email, String password) {
    	//Questo metodo è pubblico e accetta due parametri, email e password, che rappresentano le credenziali dell'utente che vuole autenticarsi. Restituisce un valore booleano:
    	//true se le credenziali sono corrette e l'utente esiste. false altrimenti.
    	
    	//Questo metodo sta cercando di confrontare direttamente la password in chiaro inviata dal form con quella memorizzata (crittografata) nel database. 
    	//Poiché la password nel database è crittografata con BCrypt, questo confronto non avrà mai successo
    	//ed e' per questo che faro una ricerca solo per email
        //Optional<Utente> user = utenteRepository.findByEmailAndPassword(email, password);
        Optional<Utente> user = utenteRepository.findByEmail(email);

        //return user.isPresent();
        if (user.isPresent()) {
            Utente u = user.get();
            return BCrypt.checkpw(password, u.getPassword());
        }
        return false;
    }
    
    public boolean isEmailTaken(String email) {
        return utenteRepository.findByEmail(email).isPresent();//user.isPresent(): verifica se l'utente è stato trovato nel database. isPresent() restituisce true se user contiene un valore (cioè se l'utente esiste), oppure false se è vuoto.
    }

    public void register(Utente newUser) {
        utenteRepository.save(newUser);
    }
    
    public Optional<Utente> findUserByEmail(String email) {
    	return utenteRepository.findByEmail(email);// Metodo del repository che esegue la ricerca nel database
    }
    //metodo per aggiornare l'utente
    public void updateUser(Utente u) {
    	utenteRepository.save(u);
    }
    
    
}

/*L'uso del Service in un'applicazione Spring è un modo per organizzare la logica di business, 
creando una struttura chiara e mantenendo separata la logica principale dalle altre componenti 
come controller e repository.
I metodi nei Service possono essere utilizzati in diversi controller o altre parti dell'applicazione, 
migliorando la modularità e la riusabilità:
Ad esempio, un metodo come authService.isEmailTaken() può essere usato sia per la registrazione sia 
per altre funzionalità dove è importante sapere se l’email è unica.
Se la logica fosse direttamente nei controller, sarebbe più difficile riutilizzarla e 
mantenere il codice


Invece di usare un AuthService, potresti scrivere la logica di autenticazione direttamente 
in AuthController, 
chiamando UtenteRepository per effettuare l'accesso e registrare l'utente. E inserendo tutti questi 
metodi sopraelencati direttamente nel controller
*/
 