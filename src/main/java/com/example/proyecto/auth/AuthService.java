package com.example.proyecto.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.proyecto.dao.IRolesDAO;
import com.example.proyecto.dao.UserRepository;
import com.example.proyecto.dto.Roles;
import com.example.proyecto.dto.Users;
import com.example.proyecto.jwt.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private IRolesDAO iRolesDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public AuthResponse login(LoginRequest request) {
		try {
	        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
	        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow(() 
	        		-> new UsernameNotFoundException("No user found with email: " + request.getEmail()));
	        String token = jwtService.generarToken(user);
	        return AuthResponse.builder()
	                .token(token)
	                .build();
	    } catch (AuthenticationException e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	@SuppressWarnings("null")
	public AuthResponse register(RegisterRequest request) {
		Roles role = iRolesDAO.findByNombre(request.getRole());
		
		if(role == null) {
			role = new Roles();
			role.setNombre("USER");
		}
		
		Users user = Users.builder()
				 .nombre(request.getUsername())
		         .password(passwordEncoder.encode(request.getPassword()))
	            .username(request.getEmail())
	            .fechaCreacion(request.getFechaCreacion())
	            .build();
		
		user.setRoles(role);
		
		userRepository.save(user);
		
		return AuthResponse.builder()
				.token(jwtService.generarToken(user))
				.build();
	}

}
