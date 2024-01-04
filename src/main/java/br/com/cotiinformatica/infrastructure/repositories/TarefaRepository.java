package br.com.cotiinformatica.infrastructure.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cotiinformatica.domain.models.Tarefa;

@Repository
public interface TarefaRepository extends MongoRepository<Tarefa, UUID> {

	@Query("{ 'sprintId' : ?0 }")
	List<Tarefa> findBySprint(UUID sprintId);
}
