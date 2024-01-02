package br.com.cotiinformatica.domain.interfaces;

import java.util.UUID;

import br.com.cotiinformatica.domain.dtos.ProjetoPostDto;

public interface ProjetoService {

	UUID criar(ProjetoPostDto dto);
}
