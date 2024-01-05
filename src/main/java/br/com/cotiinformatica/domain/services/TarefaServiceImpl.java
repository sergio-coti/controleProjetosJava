package br.com.cotiinformatica.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.dtos.TarefaGetDto;
import br.com.cotiinformatica.domain.dtos.TarefaPostDto;
import br.com.cotiinformatica.domain.interfaces.TarefaService;
import br.com.cotiinformatica.domain.models.Tarefa;
import br.com.cotiinformatica.infrastructure.repositories.TarefaRepository;

@Service
public class TarefaServiceImpl implements TarefaService {

	@Autowired
	TarefaRepository tarefaRepository;

	@Override
	public UUID criar(TarefaPostDto dto) {
		
		Tarefa tarefa = new Tarefa();
		tarefa.setId(UUID.randomUUID());
		tarefa.setDescricao(dto.getDescricao());
		tarefa.setResponsavel(dto.getResponsavel());
		tarefa.setStatus(dto.getStatus());
		tarefa.setSprintId(dto.getSprintId());
		
		tarefaRepository.save(tarefa);
		
		return tarefa.getId();
	}

	@Override
	public List<TarefaGetDto> consultar(UUID sprintId) {

		List<TarefaGetDto> result = new ArrayList<TarefaGetDto>();
		
		for(Tarefa tarefa : tarefaRepository.findBySprint(sprintId)) {
			
			TarefaGetDto dto = new TarefaGetDto();
			dto.setId(tarefa.getId());
			dto.setDescricao(tarefa.getDescricao());
			dto.setResponsavel(tarefa.getResponsavel());
			dto.setStatus(tarefa.getStatus());
			dto.setSprintId(tarefa.getSprintId());
			
			result.add(dto);
		}
		
		return result;
	}
}
