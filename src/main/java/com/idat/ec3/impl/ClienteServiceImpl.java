package com.idat.ec3.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec3.dto.ClienteRequestDTO;
import com.idat.ec3.dto.ClienteResponseDTO;
import com.idat.ec3.models.Cliente;
import com.idat.ec3.repositories.ClienteRepository;
import com.idat.ec3.services.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public void guardarCliente(ClienteRequestDTO p) {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(p.getIdClienteRequest());
		cliente.setNombre(p.getNombre());
		cliente.setCelular(p.getCelular());
		repository.save(cliente);
		
	}

	@Override
	public void eliminarCliente(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public void editarCliente(ClienteRequestDTO p) {
		
		Cliente cliente = new Cliente();
		cliente.setIdCliente(p.getIdClienteRequest());
		cliente.setNombre(p.getNombre());
		cliente.setCelular(p.getCelular());

		repository.saveAndFlush(cliente);
		
	}

	@Override
	public List<ClienteResponseDTO> listarCliente() {
		List<Cliente> cliente = repository.findAll();
		List<ClienteResponseDTO> dto = new ArrayList<ClienteResponseDTO>();
		ClienteResponseDTO clienteDTO = null;
		
		for (Cliente c : cliente) {
			clienteDTO = new ClienteResponseDTO();
			clienteDTO.setIdClienteResponse(c.getIdCliente());
			clienteDTO.setCelular(c.getCelular());
			clienteDTO.setNombre(c.getNombre());
			dto.add(clienteDTO);
		}
		
		return dto;
	
	}

	@Override
	public ClienteResponseDTO clienteById(Integer id) {
		
		Cliente cliente = repository.findById(id).orElse(null);
		ClienteResponseDTO clienteResponseDTO =new ClienteResponseDTO();
		
		clienteResponseDTO.setIdClienteResponse(cliente.getIdCliente());
		clienteResponseDTO.setNombre(cliente.getNombre());
		clienteResponseDTO.setCelular(cliente.getCelular());
		
		
		return clienteResponseDTO;
	}

}
