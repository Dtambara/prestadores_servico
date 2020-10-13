package com.desafio.saude.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.saude.dto.PrestadorSaudeDTO;
import com.desafio.saude.integration.DistanceMatrixApiClient;
import com.desafio.saude.mapper.PrestadorSaudeMapper;
import com.desafio.saude.repository.PrestadorSaudeRepository;

@Service
public class PrestadorSaudeService {

	@Autowired
	private PrestadorSaudeRepository prestadorSaudeRepository;
	
	@Autowired
	private DistanceMatrixApiClient distanceApi;
	
	@Autowired
	private PrestadorSaudeMapper mapper;
	
	public List<PrestadorSaudeDTO> getPrestadores(double latitude, double longitude, String especialidade) {
		
		List<PrestadorSaudeDTO> lista = new ArrayList<PrestadorSaudeDTO>(); 
		prestadorSaudeRepository.findAllByEspecialidades_nome(especialidade).forEach(prestador -> {
			PrestadorSaudeDTO dto = mapper.toDTO(prestador);
			dto.setDistanciaEmKm(distanceApi.getDistance(latitude, longitude, prestador.getLatitude(), prestador.getLongitude()));
			lista.add(dto);
		});
		//prestadorSaudeRepository.findAll().forEach(lista::add);		
		
		
		
		return lista;
	}
}
