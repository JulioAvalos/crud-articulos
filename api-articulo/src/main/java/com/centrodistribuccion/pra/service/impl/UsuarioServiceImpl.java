package com.centrodistribuccion.pra.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.centrodistribuccion.pra.model.SecUsuarios;
import com.centrodistribuccion.pra.repository.SecUsuarioRepository;

@Service
public class UsuarioServiceImpl implements UserDetailsService {
	
	private SecUsuarioRepository repo;
	
	public UsuarioServiceImpl(SecUsuarioRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SecUsuarios secUsuario = repo.findOneByUsername(username);
		
		if(secUsuario == null) {
			throw new UsernameNotFoundException(String.format("SecUsuario no existe", username));
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		
		secUsuario.getRoles().forEach(rol -> {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		});
		
		UserDetails ud = new User(secUsuario.getUsername(), secUsuario.getPassword(), roles);
		return ud;
	}

}
