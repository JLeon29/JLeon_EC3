package com.idat.ec3.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "hospital")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hospital implements Serializable {
	

	private static final long serialVersionUID = 4316192291275949841L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHospital;
	private String nombre;
	private String descipcion;
	private String distrito;
	
	@ManyToMany(mappedBy = "hospitalList")
	private List<Cliente> clienteList;
	

}
