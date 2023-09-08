package com.example.proyecto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.proyecto.jwt.JwtAuthenticationFilter;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private AuthenticationProvider authProvider;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(authRequest ->
						authRequest
						.requestMatchers("/auth/**").permitAll()
						.requestMatchers("/api/**").hasAnyAuthority("USER","MODER", "ADMIN")
						.requestMatchers("/api/moder/**").hasAnyAuthority("MODER", "ADMIN")
						.requestMatchers("/api/admin/**").hasAuthority("ADMIN")
						.anyRequest().authenticated()
						)
				.sessionManagement(sessionManager ->
									sessionManager
										.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authProvider)
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
}
