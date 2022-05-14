package com.idat.ec3.services;

import java.util.List;

import com.idat.ec3.dto.ClienteRequestDTO;
import com.idat.ec3.dto.ClienteResponseDTO;

public interface IClienteService {
	
	public void guardarCliente(ClienteRequestDTO p);
	public void eliminarCliente(Integer id);
	public void editarCliente(ClienteRequestDTO p);
	public List<ClienteResponseDTO> listarCliente();
	public ClienteResponseDTO clienteById(Integer id);
	
	

}
