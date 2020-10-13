package com.desafio.saude.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.saude.domain.PrestadorSaude;

public interface PrestadorSaudeRepository extends JpaRepository<PrestadorSaude, Long> {

	PrestadorSaude findByNome(String nome);
	Collection<PrestadorSaude> findAllDistinctByEspecialidades_nome(String nomeEspecialidade);
}
