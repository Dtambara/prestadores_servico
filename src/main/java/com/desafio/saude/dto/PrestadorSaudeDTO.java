package com.desafio.saude.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PrestadorSaudeDTO {

	private String nome;
	private String endereco;
	private double latitude;
	private double longitude;
	private double distanciaEmKm;
}
