package br.com.cotiinformatica.domain.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.domain.dtos.MembroEquipeGetDto;
import br.com.cotiinformatica.domain.dtos.MembroEquipePostDto;

public interface MembroEquipeService {

	UUID criar(MembroEquipePostDto dto);
	
	List<MembroEquipeGetDto> consultar(UUID equipeId);
}
