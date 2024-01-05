package br.com.cotiinformatica.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.dtos.MembroEquipeGetDto;
import br.com.cotiinformatica.domain.dtos.MembroEquipePostDto;
import br.com.cotiinformatica.domain.interfaces.MembroEquipeService;
import br.com.cotiinformatica.domain.models.MembroEquipe;
import br.com.cotiinformatica.infrastructure.repositories.MembroEquipeRepository;

@Service
public class MembroEquipeServiceImpl implements MembroEquipeService {

	@Autowired
	MembroEquipeRepository membroEquipeRepository;
	
	@Override
	public UUID criar(MembroEquipePostDto dto) {
		
		MembroEquipe membroEquipe = new MembroEquipe();
		membroEquipe.setId(UUID.randomUUID());
		membroEquipe.setNome(dto.getNome());
		membroEquipe.setPapel(dto.getPapel());
		membroEquipe.setEquipeId(dto.getEquipeId());
		
		membroEquipeRepository.save(membroEquipe);
		
		return membroEquipe.getId();
	}

	@Override
	public List<MembroEquipeGetDto> consultar(UUID equipeId) {

		List<MembroEquipeGetDto> result = new ArrayList<MembroEquipeGetDto>();
		
		for(MembroEquipe membroEquipe : membroEquipeRepository.findByEquipe(equipeId)) {
			
			MembroEquipeGetDto dto = new MembroEquipeGetDto();
			dto.setId(membroEquipe.getId());
			dto.setNome(membroEquipe.getNome());
			dto.setPapel(membroEquipe.getPapel());
			dto.setEquipeId(membroEquipe.getEquipeId());
			
			result.add(dto);
		}
		
		return result;
	}

}
