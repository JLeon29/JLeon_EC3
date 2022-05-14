package com.idat.ec3.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec3.dto.ClienteResponseDTO;
import com.idat.ec3.dto.UsuarioClienteRequestDTO;
import com.idat.ec3.dto.UsuarioClienteResponseDTO;
import com.idat.ec3.models.Cliente;
import com.idat.ec3.models.UsuarioCliente;
import com.idat.ec3.repositories.UsuarioClienteRepository;
import com.idat.ec3.services.IUsuarioCliente;

@Service
public class UsuarioClienteServiceImpl implements IUsuarioCliente {
	
	
	@Autowired
	private UsuarioClienteRepository repository;

	@Override
	public void guardarUsuario(UsuarioClienteRequestDTO p) {
		
		UsuarioCliente usuarioCliente = new UsuarioCliente();
		usuarioCliente.setIdUsuario(p.getIdUsuarioRequestDTO());
		usuarioCliente.setUsuario(p.getUsuario());
		usuarioCliente.setPassword(p.getPassword());
		usuarioCliente.setRol(p.getRol());
		repository.save(usuarioCliente);
		
	}
		
	

	@Override
	public void eliminarUsuario(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public void editarUsuario(UsuarioClienteRequestDTO p) {

		UsuarioCliente usuarioCliente = new UsuarioCliente();
		usuarioCliente.setIdUsuario(p.getIdUsuarioRequestDTO());
		usuarioCliente.setUsuario(p.getUsuario());
		usuarioCliente.setPassword(p.getPassword());
		usuarioCliente.setRol(p.getRol());

		repository.saveAndFlush(usuarioCliente);
		
	}

	@Override
	public List<UsuarioClienteResponseDTO> listarUsuario() {

		List<UsuarioCliente> usuarioCliente = repository.findAll();
		List<UsuarioClienteResponseDTO> dto = new ArrayList<UsuarioClienteResponseDTO>();
		UsuarioClienteResponseDTO usuarioDTO = null;
		
		for (UsuarioCliente c : usuarioCliente) {
			usuarioDTO = new UsuarioClienteResponseDTO();
			usuarioDTO.setIdUsuarioResponseDTO(c.getIdUsuario());
			usuarioDTO.setUsuario(c.getUsuario());
			usuarioDTO.setPassword(c.getPassword());
			usuarioDTO.setRol(c.getRol());
			dto.add(usuarioDTO);
		}
		
		return dto;
	}

	@Override
	public UsuarioClienteResponseDTO clienteById(Integer id) {
		
		UsuarioCliente usuarioCliente = repository.findById(id).orElse(null);
		UsuarioClienteResponseDTO usuarioClienteResponseDTO =new UsuarioClienteResponseDTO();
		
		usuarioClienteResponseDTO.setIdUsuarioResponseDTO(usuarioCliente.getIdUsuario());
		usuarioClienteResponseDTO.setUsuario(usuarioCliente.getUsuario());
		usuarioClienteResponseDTO.setPassword(usuarioCliente.getPassword());
		usuarioClienteResponseDTO.setRol(usuarioCliente.getRol());
		
		
		return usuarioClienteResponseDTO;
	}
	
	

}
