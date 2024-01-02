package br.com.cotiinformatica.domain.models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "projeto")
public class Projeto {

	@Id
	private UUID id;
	private String nome;
	private String escopo;
	private Date dataEntrega;
	private List<Equipe> equipes;
	private List<Sprint> sprints;
}
