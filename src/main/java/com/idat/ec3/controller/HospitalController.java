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
import com.idat.ec3.dto.HospitalRequestDTO;
import com.idat.ec3.dto.HospitalResponseDTO;
import com.idat.ec3.services.IHospitalService;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
	
	@Autowired
	private IHospitalService servicio;
	
	@GetMapping("/listar")
	public ResponseEntity<List<HospitalResponseDTO>> listar(){
		
		return new ResponseEntity<List<HospitalResponseDTO>>(servicio.listarHospital(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> guardar(@RequestBody HospitalRequestDTO hospitalRequestDTO){
		
		servicio.guardarHospital(hospitalRequestDTO);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<HospitalResponseDTO> hospitalPorId(@PathVariable Integer id){
		
		HospitalResponseDTO hospitalResponseDTO = servicio.clienteById(id);
		if(hospitalResponseDTO != null) {
			return new ResponseEntity<HospitalResponseDTO>(hospitalResponseDTO, HttpStatus.OK);
			
		}
		
		return new ResponseEntity<HospitalResponseDTO>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		HospitalResponseDTO hospitalResponseDTO = servicio.clienteById(id);
		if(hospitalResponseDTO != null) {
			servicio.eliminarHospital(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping
	public ResponseEntity<Void> editar (@RequestBody HospitalRequestDTO hospitalRequestDTO){
		
		HospitalResponseDTO hospitalResponseDTO = servicio.clienteById(hospitalRequestDTO.getIdHospitalRequestDTO());
		if(hospitalResponseDTO != null) {
			servicio.editarHospital(hospitalRequestDTO);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
