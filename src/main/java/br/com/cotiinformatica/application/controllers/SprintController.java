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

import br.com.cotiinformatica.domain.dtos.SprintGetDto;
import br.com.cotiinformatica.domain.dtos.SprintPostDto;
import br.com.cotiinformatica.domain.interfaces.SprintService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/sprint")
public class SprintController {

	@Autowired
	SprintService sprintService;
	
	@PostMapping
	public UUID post(@RequestBody @Valid SprintPostDto dto) {
		return sprintService.criar(dto);
	}

	@GetMapping("{projetoId}")
	public List<SprintGetDto> get(@PathVariable("projetoId") UUID projetoId) {
		return sprintService.consultar(projetoId);
	}
}
