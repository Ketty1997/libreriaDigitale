package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.AuthInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthInterceptor())
		.addPathPatterns("/**")//protegge tutte le rotte  Per ogni richiesta, l'interceptor verrà attivato.
		.excludePathPatterns("/utente/login" ,"/utente/register","/utente/logout","/resources/**","/css/**", "/img/**");//esclude la pagine pubbliche
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/css/**")
	            .addResourceLocations("classpath:/static/css/");
	}
}
