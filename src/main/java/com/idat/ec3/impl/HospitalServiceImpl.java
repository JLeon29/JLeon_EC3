package com.idat.ec3.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec3.dto.ClienteResponseDTO;
import com.idat.ec3.dto.HospitalRequestDTO;
import com.idat.ec3.dto.HospitalResponseDTO;
import com.idat.ec3.models.Cliente;
import com.idat.ec3.models.Hospital;
import com.idat.ec3.repositories.HospitalRepository;
import com.idat.ec3.services.IHospitalService;

@Service
public class HospitalServiceImpl implements IHospitalService {
	
	@Autowired
	private HospitalRepository repository;

	@Override
	public void guardarHospital(HospitalRequestDTO p) {
		
		Hospital hospital = new Hospital();
		hospital.setIdHospital(p.getIdHospitalRequestDTO());
		hospital.setNombre(p.getNombre());
		hospital.setDistrito(p.getDistrito());
		hospital.setDescipcion(p.getDescipcion());
		repository.save(hospital);
		
	}

	@Override
	public void eliminarHospital(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public void editarHospital(HospitalRequestDTO p) {
		
		Hospital hospital = new Hospital();
		hospital.setIdHospital(p.getIdHospitalRequestDTO());
		hospital.setNombre(p.getNombre());
		hospital.setDistrito(p.getDistrito());
		hospital.setDescipcion(p.getDescipcion());

		repository.saveAndFlush(hospital);
		
	}

	@Override
	public List<HospitalResponseDTO> listarHospital() {

		List<Hospital> hospital = repository.findAll();
		List<HospitalResponseDTO> dto = new ArrayList<HospitalResponseDTO>();
		HospitalResponseDTO hospitalDTO = null;
		
		for (Hospital c : hospital) {
			hospitalDTO = new HospitalResponseDTO();
			hospitalDTO.setIdHospitalResponseDTO(c.getIdHospital());
			hospitalDTO.setNombre(c.getNombre());
			hospitalDTO.setDistrito(c.getDistrito());
			hospitalDTO.setDescipcion(c.getDescipcion());
			dto.add(hospitalDTO);
		}
		
		return dto;
	}

	@Override
	public HospitalResponseDTO clienteById(Integer id) {
		
		Hospital hospital = repository.findById(id).orElse(null);
		HospitalResponseDTO hospitalResponseDTO =new HospitalResponseDTO();
		
		hospitalResponseDTO.setIdHospitalResponseDTO(hospital.getIdHospital());
		hospitalResponseDTO.setNombre(hospital.getNombre());
		hospitalResponseDTO.setDistrito(hospital.getDistrito());
		hospitalResponseDTO.setDescipcion(hospital.getDescipcion());
		
		
		return hospitalResponseDTO;
	}

}
