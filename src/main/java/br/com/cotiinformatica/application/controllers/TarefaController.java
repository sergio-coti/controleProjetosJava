package br.com.cotiinformatica.application.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.domain.dtos.TarefaGetDto;
import br.com.cotiinformatica.domain.dtos.TarefaPostDto;
import br.com.cotiinformatica.domain.interfaces.TarefaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/tarefa")
public class TarefaController {

	@Autowired
	TarefaService tarefaService;
	
	@PostMapping
	public UUID post(@RequestBody @Valid TarefaPostDto dto) {
		return tarefaService.criar(dto);
	}

	@GetMapping("{sprintId}")
	public List<TarefaGetDto> get(@PathVariable("sprintId") UUID sprintId) {
		return tarefaService.consultar(sprintId);
	}
}
