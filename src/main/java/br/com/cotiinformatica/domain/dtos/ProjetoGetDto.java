package br.com.cotiinformatica.domain.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class ProjetoGetDto {

	private UUID id;
	private String nome;
	private String escopo;
	private String dataEntrega;
}
