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

import br.com.cotiinformatica.domain.dtos.EquipeGetDto;
import br.com.cotiinformatica.domain.dtos.EquipePostDto;
import br.com.cotiinformatica.domain.interfaces.EquipeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/equipe")
public class EquipeController {

	@Autowired
	EquipeService equipeService;
	
	@PostMapping
	public UUID post(@RequestBody @Valid EquipePostDto dto) {
		return equipeService.criar(dto);
	}

	@GetMapping("{projetoId}")
	public List<EquipeGetDto> get(@PathVariable("projetoId") UUID projetoId) {
		return equipeService.consultar(projetoId);
	}
}
