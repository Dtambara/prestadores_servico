package com.desafio.saude.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.saude.dto.PrestadorSaudeDTO;
import com.desafio.saude.service.PrestadorSaudeService;

@RestController
public class PrestadoresSaudeController {

	private final  Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PrestadorSaudeService prestadorSaudeService;

	@GetMapping("/prestador")
	public List<PrestadorSaudeDTO> greeting(@RequestParam(value = "latitude", defaultValue = "0") double latitude,
			@RequestParam(value = "longitude", defaultValue = "0") double longitude,
			@RequestParam(value = "especialidade", defaultValue = "0") String especialidade) {

		logger.info(String.format("Inicializando busca para parametros latitude %f, longitude %f e especialide %s",
				latitude, longitude, especialidade));
		List<PrestadorSaudeDTO> lista = prestadorSaudeService.getPrestadores(latitude, longitude, especialidade);
		return lista;
	}

}
