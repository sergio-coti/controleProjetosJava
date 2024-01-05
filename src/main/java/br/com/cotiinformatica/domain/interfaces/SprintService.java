package br.com.cotiinformatica.domain.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.domain.dtos.SprintGetDto;
import br.com.cotiinformatica.domain.dtos.SprintPostDto;

public interface SprintService {

	UUID criar(SprintPostDto dto);
	
	List<SprintGetDto> consultar(UUID projetoId);
}
