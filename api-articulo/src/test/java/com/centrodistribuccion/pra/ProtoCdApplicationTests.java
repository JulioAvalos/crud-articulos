package com.centrodistribuccion.pra;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.centrodistribuccion.pra.model.SecUsuarios;
import com.centrodistribuccion.pra.repository.SecUsuarioRepository;

@SpringBootTest
class ProtoCdApplicationTests {

	@Autowired
	BCryptPasswordEncoder bcrypt;

	@Autowired
	SecUsuarioRepository repo;

	@Test
	public void crearUsuario() {
		SecUsuarios us = SecUsuarios.builder()
				.idUsuario(2L)
				.username("javalos")
				.password(bcrypt.encode("javalos"))
				.enabled(true).build();

		SecUsuarios retorno = repo.save(us);

		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	}

}
