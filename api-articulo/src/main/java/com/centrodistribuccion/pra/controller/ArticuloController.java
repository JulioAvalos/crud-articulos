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

import com.centrodistribuccion.pra.model.Articulo;
import com.centrodistribuccion.pra.service.ArticuloService;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {
	
	private final ArticuloService service;

	public ArticuloController(ArticuloService service) {
		this.service = service;
	}
	
	@GetMapping
    public ResponseEntity<List<Articulo>> lista() {
        List<Articulo> lista = service.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Articulo> listarPorId(@PathVariable Long id) {
        Articulo obj = service.leerPorId(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Articulo> registrar(@RequestBody Articulo articulo){
        Articulo obj = service.registrar(articulo);
        URI location = ServletUriComponentsBuilder
        		.fromCurrentRequest()
        		.path("/{id}")
        		.buildAndExpand(obj.getIdArticulo())
        		.toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Articulo> modificar(@RequestBody Articulo articulo){
        Articulo obj = service.modificar(articulo);
        return new ResponseEntity<>(obj, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id){
        Articulo obj = service.leerPorId(id);
        if(obj.getIdArticulo() != null){
            service.eliminar(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	
}
