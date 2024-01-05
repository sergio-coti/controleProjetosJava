package br.com.cotiinformatica.domain.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TarefaPostDto {

	@NotBlank(message = "Informe a descrição da tarefa.")
	private String descricao;
	
	@NotBlank(message = "Informe o status da tarefa.")
	private String status;
	
	@NotBlank(message = "Informe o responsável da tarefa.")
	private String responsavel;
	
	@NotNull(message = "Informe a sprint da tarefa.")
	private UUID sprintId;
}
