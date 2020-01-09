package com.centrodistribuccion.pra.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SecUsuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@Column(name = "codusr", nullable = false)
	private String username;
	private String nombre;
	private String administrador;
	private String codigoSeguridad;
	@Column(name = "clave", nullable = false)
	private String password;
	private String validarIp;
	private String estadoUsuario;
	private String estadoClave;
	private LocalDateTime fechaUltimaModificacion;
	private String codcia;
	private LocalDateTime fechaVencimientoClave;
	private String claveGenerada;
	@Column(name = "estado", nullable = false)
	private boolean enabled;
	
	@ManyToMany(fetch = FetchType.EAGER)
		@JoinTable(name = "usuario_rol", joinColumns = 
		@JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"), 
		inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol")
	)
	private List<Rol> roles;
	
}
