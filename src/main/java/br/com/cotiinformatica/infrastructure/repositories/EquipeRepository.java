package br.com.cotiinformatica.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.cotiinformatica.domain.models.Equipe;

@Repository
public interface EquipeRepository extends MongoRepository<Equipe, UUID> {

}
