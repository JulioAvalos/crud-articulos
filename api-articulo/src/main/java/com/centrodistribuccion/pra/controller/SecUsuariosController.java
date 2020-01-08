package com.centrodistribuccion.pra.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.centrodistribuccion.pra.model.SecUsuarios;
import com.centrodistribuccion.pra.service.SecUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class SecUsuariosController {

	private final SecUsuarioService service;

	public SecUsuariosController(SecUsuarioService service) {
		this.service = service;
	}
	
	@GetMapping
    public ResponseEntity<List<SecUsuarios>> lista() {
        List<SecUsuarios> lista = service.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SecUsuarios> listarPorId(@PathVariable Long id) {
        SecUsuarios obj = service.leerPorId(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SecUsuarios> registrar(@RequestBody SecUsuarios secUsuario){
        SecUsuarios obj = service.registrar(secUsuario);
        URI location = ServletUriComponentsBuilder
        		.fromCurrentRequest()
        		.path("/{id}")
        		.buildAndExpand(obj.getId())
        		.toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<SecUsuarios> modificar(@RequestBody SecUsuarios secUsuario){
        SecUsuarios obj = service.modificar(secUsuario);
        return new ResponseEntity<>(obj, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id){
        SecUsuarios obj = service.leerPorId(id);
        if(obj.getId() != null){
            service.eliminar(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
}
