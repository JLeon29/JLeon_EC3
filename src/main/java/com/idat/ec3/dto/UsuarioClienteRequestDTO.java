package com.idat.ec3.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioClienteRequestDTO {
	
	private Integer idUsuarioRequestDTO;
	private String usuario;
	private String password;
	private String rol;

}
