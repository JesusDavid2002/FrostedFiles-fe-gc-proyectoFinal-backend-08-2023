package com.example.proyecto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.proyecto.service.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig {
	
	@Bean
	SecurityFilterChain web(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests((authorize) -> authorize
					.requestMatchers("/publico/**").permitAll()
					.requestMatchers("/moderador/**").hasRole("MODER")
					.requestMatchers("/admin/**").hasRole("ADMIN")
					
					.anyRequest().authenticated()
			);
//		http.formLogin(withDefaults());
//		http.httpBasic(withDefaults());
		return http.build();
	}
	
	//Autenticacion con UserDetailsService
	@Bean
	UserDetailsServiceImpl userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
