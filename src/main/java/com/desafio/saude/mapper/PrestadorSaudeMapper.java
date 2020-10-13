package com.desafio.saude.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.desafio.saude.domain.PrestadorSaude;
import com.desafio.saude.dto.PrestadorSaudeDTO;

@Service
public class PrestadorSaudeMapper implements IMapper<PrestadorSaudeDTO, PrestadorSaude>{


	@Override
	public PrestadorSaudeDTO toDTO(PrestadorSaude prestadorSaude) {
		ModelMapper modelMapper = new ModelMapper();
		PrestadorSaudeDTO prestadorSaudeDTO = modelMapper.map(prestadorSaude, PrestadorSaudeDTO.class);
		return prestadorSaudeDTO;
	}

}
