package com.desafio.saude.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "PRESTADOR_SAUDE")
@Getter
@Setter
@NoArgsConstructor
public class PrestadorSaude {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String endereco;
	private double latitude;
	private double longitude;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PRESTADOR_ESPECIALIDADE", 
      joinColumns = @JoinColumn(name = "ID_PRESTADOR", referencedColumnName = "ID"), 
      inverseJoinColumns = @JoinColumn(name = "ID_ESPECIALIDADE", 
      referencedColumnName = "ID"))
    private Collection<Especialidade> especialidades;
}
