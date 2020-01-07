package com.centrodistribuccion.pra.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centrodistribuccion.pra.model.Articulo;
import com.centrodistribuccion.pra.repository.ArticuloRepository;
import com.centrodistribuccion.pra.service.ArticuloService;

@Transactional
@Service
public class ArticuloServiceImpl implements ArticuloService {

	private final ArticuloRepository repo;

	public ArticuloServiceImpl(ArticuloRepository repo) {
		this.repo = repo;
	}

	@Override
	public Articulo registrar(Articulo obj) {
		return repo.save(obj);
	}

	@Override
	public Articulo modificar(Articulo obj) {
		return repo.save(obj);
	}

	@Override
	public List<Articulo> listar() {
		return repo.findAll();
	}

	@Override
	public Articulo leerPorId(Long id) {
		Optional<Articulo> op = repo.findById(id);
		return op.orElseGet(Articulo::new);
	}

	@Override
	public boolean eliminar(Long id) {
		repo.deleteById(id);
		return true;
	}

}
