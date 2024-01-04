package br.com.cotiinformatica.domain.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EquipePostDto {

	@NotBlank(message = "Por favor, informe o nome da equipe.")
	private String nome;
	
	@NotNull(message = "Por favor, informe o id do projeto.")
	private UUID projetoId;
}
