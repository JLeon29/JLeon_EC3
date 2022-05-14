package com.idat.ec3.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "cliente")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {
	

	private static final long serialVersionUID = 4409758283120721897L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	private String nombre;
	private Integer celular;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente")
	private UsuarioCliente usuarioCliente;
	
	@JoinTable(name="hospitalCliente", joinColumns = {
			@JoinColumn(name="idCliente", referencedColumnName = "idCliente")
	}, inverseJoinColumns = {
			@JoinColumn(name="idHospital", referencedColumnName = "idHospital")
	}
	
			)
	@ManyToMany
	private List<Hospital> hospitalList;

	
	
	

}
