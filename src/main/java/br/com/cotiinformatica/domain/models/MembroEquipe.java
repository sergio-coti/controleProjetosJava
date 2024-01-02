package br.com.cotiinformatica.domain.models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "membroequipe")
public class MembroEquipe {

	@Id
	private UUID id;
	private String nome;
	private String papel;
}
