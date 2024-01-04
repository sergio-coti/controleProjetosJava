package br.com.cotiinformatica.domain.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.domain.dtos.EquipeGetDto;
import br.com.cotiinformatica.domain.dtos.EquipePostDto;

public interface EquipeService {

	UUID criar(EquipePostDto dto);
	
	List<EquipeGetDto> consultar(UUID projetoId);
}
