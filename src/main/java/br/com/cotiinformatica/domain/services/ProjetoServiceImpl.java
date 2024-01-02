package br.com.cotiinformatica.domain.services;

import java.text.SimpleDateFormat;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
