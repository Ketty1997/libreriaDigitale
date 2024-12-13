package com.example.demo.ctr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeCtr {
	@GetMapping()
	public String home() {
		return "/view/home.jsp";
	}
	
	/*
    @GetMapping("/")
    public String redirectToLogin(HttpSession session) {
        Boolean isAuthenticated = (Boolean) session.getAttribute("isAuthenticated");

        if (isAuthenticated == null || !isAuthenticated) {
            // Reindirizza alla pagina di login se non autenticato
            return "redirect:/utente/login";
        }
        // Se autenticato, reindirizza alla home page
        return "redirect:/utente/home";
    }
*/
}
