package br.com.cotiinformatica.domain.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.dtos.ProjetoGetDto;
import br.com.cotiinformatica.domain.dtos.ProjetoPostDto;
import br.com.cotiinformatica.domain.interfaces.ProjetoService;
import br.com.cotiinformatica.domain.models.Projeto;
import br.com.cotiinformatica.infrastructure.repositories.ProjetoRepository;

@Service
public class ProjetoServiceImpl implements ProjetoService {

	@Autowired
	ProjetoRepository projetoRepository;
	
	@Override
	public UUID criar(ProjetoPostDto dto) {

		try {
			
			Projeto projeto = new Projeto();
			
			projeto.setId(UUID.randomUUID());
			projeto.setNome(dto.getNome());
			projeto.setEscopo(dto.getEscopo());
			projeto.setDataEntrega(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getDataEntrega()));
			
			projetoRepository.save(projeto);
			
			return projeto.getId();			
		}
		catch(Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	@Override
	public List<ProjetoGetDto> consultar() {

		try {
		
			List<ProjetoGetDto> result = new ArrayList<ProjetoGetDto>();
			
			for(Projeto projeto : projetoRepository.findAll()) {
				
				ProjetoGetDto dto = new ProjetoGetDto();
				dto.setId(projeto.getId());
				dto.setNome(projeto.getNome());
				dto.setEscopo(projeto.getEscopo());
				dto.setDataEntrega(new SimpleDateFormat("dd/MM/yyyy").format(projeto.getDataEntrega()));
				
				result.add(dto);
			}
			
			return result;
		}
		catch(Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
}
