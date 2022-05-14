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
import com.idat.ec3.services.IClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService servicio;
	
	@GetMapping("/listar")
	public ResponseEntity<List<ClienteResponseDTO>> listar(){
		
		return new ResponseEntity<List<ClienteResponseDTO>>(servicio.listarCliente(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> guardar(@RequestBody ClienteRequestDTO clienteRequestDto){
		
		servicio.guardarCliente(clienteRequestDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<ClienteResponseDTO> cursoPorId(@PathVariable Integer id){
		
		ClienteResponseDTO clienteResponseDTO = servicio.clienteById(id);
		if(clienteResponseDTO != null) {
			return new ResponseEntity<ClienteResponseDTO>(clienteResponseDTO, HttpStatus.OK);
			
		}
		
		return new ResponseEntity<ClienteResponseDTO>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		ClienteResponseDTO clienteResponseDTO = servicio.clienteById(id);
		if(clienteResponseDTO != null) {
			servicio.eliminarCliente(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping
	public ResponseEntity<Void> editar (@RequestBody ClienteRequestDTO clienteRequestDTO){
		
		ClienteResponseDTO clienteResponseDTO = servicio.clienteById(clienteRequestDTO.getIdClienteRequest());
		if(clienteResponseDTO != null) {
			servicio.editarCliente(clienteRequestDTO);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
