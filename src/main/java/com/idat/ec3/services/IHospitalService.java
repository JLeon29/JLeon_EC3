package com.idat.ec3.services;

import java.util.List;

import com.idat.ec3.dto.HospitalRequestDTO;
import com.idat.ec3.dto.HospitalResponseDTO;

public interface IHospitalService {
	
	public void guardarHospital(HospitalRequestDTO p);
	public void eliminarHospital(Integer id);
	public void editarHospital(HospitalRequestDTO p);
	public List<HospitalResponseDTO> listarHospital();
	public HospitalResponseDTO clienteById(Integer id);

}
