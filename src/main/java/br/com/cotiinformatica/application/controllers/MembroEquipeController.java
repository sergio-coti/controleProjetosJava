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

import br.com.cotiinformatica.domain.dtos.MembroEquipeGetDto;
import br.com.cotiinformatica.domain.dtos.MembroEquipePostDto;
import br.com.cotiinformatica.domain.interfaces.MembroEquipeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/membroequipe")
public class MembroEquipeController {

	@Autowired
	MembroEquipeService membroEquipeService;

	@PostMapping
	public UUID post(@RequestBody @Valid MembroEquipePostDto dto) {
		return membroEquipeService.criar(dto);
	}

	@GetMapping("{equipeId}")
	public List<MembroEquipeGetDto> get(@PathVariable("equipeId") UUID equipeId) {
		return membroEquipeService.consultar(equipeId);
	}
}
