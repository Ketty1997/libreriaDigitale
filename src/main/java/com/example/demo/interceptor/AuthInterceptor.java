package com.example.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthInterceptor implements HandlerInterceptor {
	//questo metodo viene eseguito prima che il controller gestisca la richiesta.QUI e' dove verifichiamo se l'utente e' autenticato
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();//otteniamo la sessione http dall'utente
		//controlla se l'utente e' autenticato 
		//Se isAuthenticated è null o false, significa che l'utente non è autenticato. In tal caso, lo reindirizziamo alla pagina di login con response.sendRedirect(request.getContextPath() + "/utente/login"); e restituiamo false, il che impedirà al controller di gestire la richiesta successiva.
		//Se l'utente è autenticato, restituiamo true, il che permette alla richiesta di continuare.
		Boolean isAuthenticated =(Boolean) session.getAttribute("isAuthenticated");//Recuperiamo lo stato di autenticazione dalla sessione. Se l'utente è loggato, questa variabile sarà true.
		if(isAuthenticated ==null || !isAuthenticated) {
			String requestPath = request.getRequestURI(); // Percorso richiesto
			//response.sendRedirect(request.getContextPath()+"/utente/login"+"/utente/register");//reindirizza al loginCTR e non jsp
			//return false;
	        // Evita un ciclo di reindirizzamenti: consenti sempre l'accesso a login e registrazione
			if (!requestPath.endsWith("/utente/login") && !requestPath.endsWith("/utente/register")) {
		            response.sendRedirect(request.getContextPath() + "/utente/login"); // Reindirizza al login
		            return false;
		        }
		}
		return true;
	
	}
	
	
}
