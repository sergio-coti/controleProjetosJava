package br.com.cotiinformatica;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import br.com.cotiinformatica.domain.dtos.SprintPostDto;
import br.com.cotiinformatica.domain.models.Projeto;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SprintTest {

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
	public void sprintPostTest() throws Exception {

		// consultando os projetos
		objectMapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
		MvcResult result = mockMvc.perform(get("/api/projeto")).andReturn();
		String json = result.getResponse().getContentAsString();
		List<Projeto> projetos = objectMapper.readValue(json, new TypeReference<List<Projeto>>() {
		});

		Faker faker = new Faker();

		SprintPostDto dto = new SprintPostDto();
		dto.setNome("Sprint " + faker.number().randomDigit());
		dto.setDataInicio(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		dto.setDataFim(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		dto.setProjetoId(projetos.get(0).getId());

		mockMvc.perform(
				post("/api/sprint").contentType("application/json").content(objectMapper.writeValueAsString(dto)))
				.andExpect(status().isOk());

		projetoId = dto.getProjetoId();
	}

	@Test
	@Order(2)
	public void sprintGetTest() throws Exception {

		mockMvc.perform(get("/api/sprint/" + projetoId)).andExpect(status().isOk());
	}
}
