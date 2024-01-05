package br.com.cotiinformatica.domain.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.dtos.SprintGetDto;
import br.com.cotiinformatica.domain.dtos.SprintPostDto;
import br.com.cotiinformatica.domain.interfaces.SprintService;
import br.com.cotiinformatica.domain.models.Sprint;
import br.com.cotiinformatica.infrastructure.repositories.SprintRepository;

@Service
public class SprintServiceImpl implements SprintService {

	@Autowired
	SprintRepository sprintRepository;
	
	@Override
	public UUID criar(SprintPostDto dto) {

		try {
			
			Sprint sprint = new Sprint();
			
			sprint.setId(UUID.randomUUID());
			sprint.setNome(dto.getNome());
			sprint.setDataInicio(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getDataInicio()));
			sprint.setDataFim(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getDataFim()));
			sprint.setProjetoId(dto.getProjetoId());
			
			sprintRepository.save(sprint);
			
			return sprint.getId();			
		}
		catch(Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	@Override
	public List<SprintGetDto> consultar(UUID projetoId) {

		try {
			
			List<SprintGetDto> result = new ArrayList<SprintGetDto>();
			
			for(Sprint sprint : sprintRepository.findByProjeto(projetoId)) {
				
				SprintGetDto dto = new SprintGetDto();
				dto.setId(sprint.getId());
				dto.setNome(sprint.getNome());
				dto.setDataInicio(new SimpleDateFormat("dd/MM/yyyy").format(sprint.getDataInicio()));
				dto.setDataFim(new SimpleDateFormat("dd/MM/yyyy").format(sprint.getDataFim()));
				dto.setProjetoId(sprint.getProjetoId());
				
				result.add(dto);
			}
			
			return result;
		}
		catch(Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

}
