package com.desafio.saude.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.saude.dto.PrestadorSaudeDTO;
import com.desafio.saude.integration.DistanceMatrixApiClient;
import com.desafio.saude.mapper.PrestadorSaudeMapper;
import com.desafio.saude.repository.PrestadorSaudeRepository;

@Service
public class PrestadorSaudeService {

	private final  Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PrestadorSaudeRepository prestadorSaudeRepository;
	
	@Autowired
	private DistanceMatrixApiClient distanceApi;
	
	@Autowired
	private PrestadorSaudeMapper mapper;
	
	public List<PrestadorSaudeDTO> getPrestadores(double latitude, double longitude, String especialidade) {
		logger.info("iniciando a busca por prestadores de saude");
		List<PrestadorSaudeDTO> prestadores = findPrestadores(latitude, longitude, especialidade);
		logger.info(String.format("foram retornados %d prestadores", prestadores.size()));
		logger.info("Retornando lista de prestadores");
		ordenaPrestadoresPorDistancia(prestadores);
		
		return prestadores;
	}

	private void ordenaPrestadoresPorDistancia(List<PrestadorSaudeDTO> prestadores) {
		prestadores.sort(Comparator.comparing(PrestadorSaudeDTO::getDistanciaEmKm));
	}
	
	private List<PrestadorSaudeDTO> findPrestadores(double latitude, double longitude, String especialidade) {
		List<PrestadorSaudeDTO> prestadores = new ArrayList<PrestadorSaudeDTO>(); 
		
		prestadorSaudeRepository.findAllDistinctByEspecialidades_nome(especialidade.toUpperCase()).forEach(prestador -> {
			PrestadorSaudeDTO dto = mapper.toDTO(prestador);
			dto.setDistanciaEmKm(distanceApi.getDistance(latitude, longitude, prestador.getLatitude(), prestador.getLongitude()));
			prestadores.add(dto);
		});
	
		return prestadores;
	}
}
