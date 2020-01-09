package com.centrodistribuccion.pra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centrodistribuccion.pra.model.SecUsuarios;

public interface SecUsuarioRepository extends JpaRepository<SecUsuarios, Long>{
	
		//select * from usuario where username = ?
		SecUsuarios findOneByUsername(String username);

}
