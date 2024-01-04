package br.com.cotiinformatica.domain.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class EquipeGetDto {

	private UUID id;
	private String nome;
	private UUID projetoId;
}
