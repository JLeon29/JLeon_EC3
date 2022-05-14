package com.idat.ec3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.ec3.dto.ClienteRequestDTO;
import com.idat.ec3.dto.ClienteResponseDTO;
import com.idat.ec3.dto.UsuarioClienteRequestDTO;
import com.idat.ec3.dto.UsuarioClienteResponseDTO;
import com.idat.ec3.services.IUsuarioCliente;

@RestController
@RequestMapping("/usuario")
public class UsuarioClienteController {
	
	
	@Autowired
	private IUsuarioCliente servicio;
	
	@GetMapping("/listar")
	public ResponseEntity<List<UsuarioClienteResponseDTO>> listar(){
		
		return new ResponseEntity<List<UsuarioClienteResponseDTO>>(servicio.listarUsuario(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> guardar(@RequestBody UsuarioClienteRequestDTO usuarioClienteRequestDTO){
		
		servicio.guardarUsuario(usuarioClienteRequestDTO);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<UsuarioClienteResponseDTO> cursoPorId(@PathVariable Integer id){
		
		UsuarioClienteResponseDTO usuarioClienteResponseDTO = servicio.clienteById(id);
		if(usuarioClienteResponseDTO != null) {
			return new ResponseEntity<UsuarioClienteResponseDTO>(usuarioClienteResponseDTO, HttpStatus.OK);
			
		}
		
		return new ResponseEntity<UsuarioClienteResponseDTO>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		UsuarioClienteResponseDTO usuarioClienteResponseDTO = servicio.clienteById(id);
		if(usuarioClienteResponseDTO != null) {
			servicio.eliminarUsuario(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping
	public ResponseEntity<Void> editar (@RequestBody UsuarioClienteRequestDTO usuarioClienteRequestDTO){
		
		UsuarioClienteResponseDTO usuarioClienteResponseDTO = servicio.clienteById(usuarioClienteRequestDTO.getIdUsuarioRequestDTO());
		if(usuarioClienteResponseDTO != null) {
			servicio.editarUsuario(usuarioClienteRequestDTO);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}


}
