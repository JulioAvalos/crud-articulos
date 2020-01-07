package com.centrodistribuccion.pra.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Articulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idArticulo;
	
	private String descripcion;
	private BigDecimal ultimoCosto;
	private LocalDateTime fechaHoraCreacion;
	private LocalDateTime fechaHoraMod;
	
}
