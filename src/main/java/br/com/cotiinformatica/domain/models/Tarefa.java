package br.com.cotiinformatica.domain.models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "tarefa")
public class Tarefa {

	@Id
	private UUID id;
	private String descricao;
	private String status;
	private String responsavel;
	private UUID sprintId;
}
