package br.com.cotiinformatica.domain.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.domain.dtos.TarefaGetDto;
import br.com.cotiinformatica.domain.dtos.TarefaPostDto;

public interface TarefaService {

	UUID criar(TarefaPostDto dto);
	
	List<TarefaGetDto> consultar(UUID sprintId);
}
