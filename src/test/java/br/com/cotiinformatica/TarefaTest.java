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

import br.com.cotiinformatica.domain.dtos.TarefaPostDto;
import br.com.cotiinformatica.domain.models.Projeto;
import br.com.cotiinformatica.domain.models.Sprint;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TarefaTest {

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

	// atributo para armazenar o ID da sprint
	private static UUID sprintId;

	@Test
	@Order(1)
	public void tarefaPostTest() throws Exception {

		// consultando os projetos
		objectMapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
		MvcResult result = mockMvc.perform(get("/api/projeto")).andReturn();
		String json = result.getResponse().getContentAsString();
		List<Projeto> projetos = objectMapper.readValue(json, new TypeReference<List<Projeto>>() {
		});

		// consultando as equipes
		result = mockMvc.perform(get("/api/sprint/" + projetos.get(0).getId())).andReturn();
		json = result.getResponse().getContentAsString();
		List<Sprint> sprints = objectMapper.readValue(json, new TypeReference<List<Sprint>>() {
		});

		Faker faker = new Faker();

		TarefaPostDto dto = new TarefaPostDto();
		dto.setDescricao(faker.company().profession());
		dto.setResponsavel(faker.name().fullName());
		dto.setStatus("Entregue");
		dto.setSprintId(sprints.get(0).getId());

		mockMvc.perform(
				post("/api/tarefa").contentType("application/json").content(objectMapper.writeValueAsString(dto)))
				.andExpect(status().isOk());

		sprintId = dto.getSprintId();
	}

	@Test
	@Order(2)
	public void tarefaGetTest() throws Exception {

		mockMvc.perform(get("/api/tarefa/" + sprintId)).andExpect(status().isOk());
	}
}
