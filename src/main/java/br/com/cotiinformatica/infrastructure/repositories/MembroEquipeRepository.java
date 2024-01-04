package br.com.cotiinformatica.infrastructure.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cotiinformatica.domain.models.MembroEquipe;

@Repository
public interface MembroEquipeRepository extends MongoRepository<MembroEquipe, UUID> {

	@Query("{ 'equipeId' : ?0 }")
	List<MembroEquipe> findByEquipe(UUID equipeId);
}
