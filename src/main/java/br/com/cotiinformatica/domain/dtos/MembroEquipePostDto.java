package br.com.cotiinformatica.domain.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MembroEquipePostDto {

	@NotBlank(message = "Por favor, informe o nome do membro da equipe.")
	private String nome;
	
	@NotBlank(message = "Por favor, informe o papel do membro da equipe.")
	private String papel;
	
	@NotNull(message = "Por favor, informe o id da equipe.")
	private UUID equipeId;
}
