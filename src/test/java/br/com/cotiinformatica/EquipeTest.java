package br.com.cotiinformatica;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import br.com.cotiinformatica.domain.dtos.EquipePostDto;
import br.com.cotiinformatica.domain.models.Projeto;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EquipeTest {

	/*
	 * Componente capaz de realizar as chamadas / requisições para os endpoints da
	 * API que serão testados
	 */
	@Autowired
	MockMvc mockMvc;

	/*
	 * Componente capaz de ler e deserializar os dados em JSON obtidos da API (ler
	 * as respostas obtidas da API)
	 */
	@Autowired
	ObjectMapper objectMapper;

	// atributo para armazenar o ID do projeto
	private static UUID projetoId;

	@Test
	@Order(1)
	public void equipePostTest() throws Exception {

		// consultando os projetos
		objectMapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
		MvcResult result = mockMvc.perform(get("/api/projeto")).andReturn();
		String json = result.getResponse().getContentAsString();
		List<Projeto> projetos = objectMapper.readValue(json, new TypeReference<List<Projeto>>() {
		});

		Faker faker = new Faker();

		EquipePostDto dto = new EquipePostDto();
		dto.setNome(faker.funnyName().name());
		dto.setProjetoId(projetos.get(0).getId());

		mockMvc.perform(
				post("/api/equipe").contentType("application/json").content(objectMapper.writeValueAsString(dto)))
				.andExpect(status().isOk());

		projetoId = dto.getProjetoId();
	}

	@Test
	@Order(2)
	public void equipeGetTest() throws Exception {

		mockMvc.perform(get("/api/equipe/" + projetoId)).andExpect(status().isOk());
	}
}
