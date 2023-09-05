package com.example.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.proyecto.dao.IUsersDAO;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private IUsersDAO iUsersDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
			
		return iUsersDAO.findByEmail(username)
                .map(UsuariosUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("No user found"));
	}

	

}
