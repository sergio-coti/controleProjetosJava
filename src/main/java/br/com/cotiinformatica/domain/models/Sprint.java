package br.com.cotiinformatica.domain.models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "sprint")
public class Sprint {

	@Id
	private UUID id;
	private String nome;
	private Date dataInicio;
	private Date dataFim;
	private List<Tarefa> tarefas;
}
