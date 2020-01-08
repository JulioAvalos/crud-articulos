package com.centrodistribuccion.pra.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SecUsuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String codusr;
	private String nombre;
	private String administrador;
	private String codigoSeguridad;
	private String clave;
	private String validarIp;
	private String estadoUsuario;
	private String estadoClave;
	private LocalDateTime fechaUltimaModificacion;
	private String codcia;
	private LocalDateTime fechaVencimientoClave;
	private String claveGenerada;
	
}
