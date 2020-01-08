package com.centrodistribuccion.pra.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centrodistribuccion.pra.model.SecUsuarios;
import com.centrodistribuccion.pra.repository.SecUsuarioRepository;
import com.centrodistribuccion.pra.service.SecUsuarioService;

@Transactional
@Service
public class SecUsuarioServiceImpl implements SecUsuarioService{
	
	private final SecUsuarioRepository repo;
	private final PasswordEncoder passwordEncoder;
	
	public SecUsuarioServiceImpl(SecUsuarioRepository repo, PasswordEncoder passwordEncoder) {
		this.repo = repo;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public SecUsuarios registrar(SecUsuarios obj) {
		obj.setClave(passwordEncoder.encode(obj.getClave()));
		return repo.save(obj);
	}

	@Override
	public SecUsuarios modificar(SecUsuarios obj) {
		return repo.save(obj);
	}

	@Override
	public List<SecUsuarios> listar() {
		return repo.findAll();
	}

	@Override
	public SecUsuarios leerPorId(Long id) {
		Optional<SecUsuarios> op = repo.findById(id);
		return op.orElseGet(SecUsuarios::new);
	}

	@Override
	public boolean eliminar(Long id) {
		repo.deleteById(id);
		return true;
	}

}
