package com.idat.ec3.services;

import java.util.List;

import com.idat.ec3.dto.UsuarioClienteRequestDTO;
import com.idat.ec3.dto.UsuarioClienteResponseDTO;

public interface IUsuarioCliente {
	
	public void guardarUsuario(UsuarioClienteRequestDTO p);
	public void eliminarUsuario(Integer id);
	public void editarUsuario(UsuarioClienteRequestDTO p);
	public List<UsuarioClienteResponseDTO> listarUsuario();
	public UsuarioClienteResponseDTO clienteById(Integer id);

}
