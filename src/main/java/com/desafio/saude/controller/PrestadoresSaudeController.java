package com.desafio.saude.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.desafio.saude.dto.PrestadorSaudeDTO;
import com.desafio.saude.service.PrestadorSaudeService;

@RestController
public class PrestadoresSaudeController extends MainController {

	private final  Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PrestadorSaudeService prestadorSaudeService;

	@GetMapping("/prestador")
	public List<PrestadorSaudeDTO> getPrestadores(@RequestParam(value = "latitude") double latitude,
			@RequestParam(value = "longitude") double longitude,
			@RequestParam(value = "especialidade") String especialidade) {

		try {
			logger.info(String.format("Inicializando busca para parametros latitude %f, longitude %f e especialide %s",
					latitude, longitude, especialidade));
			List<PrestadorSaudeDTO> lista = prestadorSaudeService.getPrestadores(latitude, longitude, especialidade);
			return lista;
		} catch (Exception e) {
			logger.error("Houve um erro durante a requisição");
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
		
	}

	
}
