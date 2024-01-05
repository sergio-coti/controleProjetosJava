package br.com.cotiinformatica.domain.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class MembroEquipeGetDto {

	private UUID id;
	private String nome;
	private String papel;
	private UUID equipeId;
}
