package br.com.cotiinformatica.domain.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.domain.dtos.ProjetoGetDto;
import br.com.cotiinformatica.domain.dtos.ProjetoPostDto;

public interface ProjetoService {

	UUID criar(ProjetoPostDto dto);

	List<ProjetoGetDto> consultar();
}
