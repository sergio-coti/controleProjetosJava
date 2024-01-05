package br.com.cotiinformatica.domain.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SprintPostDto {

	@NotBlank(message = "Por favor, informe o nome da sprint.")
	private String nome;
	
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", 
			message = "Informe a data de início no formato YYYY-MM-DD.")
	@NotBlank(message = "Por favor, informe a data de início da sprint.")
	private String dataInicio;
	
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", 
			message = "Informe a data de fim no formato YYYY-MM-DD.")
	@NotBlank(message = "Por favor, informe a data de fim da sprint.")
	private String dataFim;
	
	@NotNull(message = "Por favor, informe o id do projeto.")
	private UUID projetoId;
}
