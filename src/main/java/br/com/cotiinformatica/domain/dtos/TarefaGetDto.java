package br.com.cotiinformatica.domain.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class TarefaGetDto {

	private UUID id;
	private String descricao;
	private String status;
	private String responsavel;
	private UUID sprintId;
}
