package br.com.cotiinformatica;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import br.com.cotiinformatica.domain.dtos.ProjetoPostDto;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProjetoTest {

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

	@Test
	@Order(1)
	public void projetoPostTest() throws Exception {

		Faker faker = new Faker();

		ProjetoPostDto dto = new ProjetoPostDto();
		dto.setNome(faker.company().name());
		dto.setEscopo(faker.company().profession());
		dto.setDataEntrega(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

		mockMvc.perform(
				post("/api/projeto").contentType("application/json").content(objectMapper.writeValueAsString(dto)))
				.andExpect(status().isOk());
	}

	@Test
	@Order(2)
	public void projetoGetTest() throws Exception {
		objectMapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
		mockMvc.perform(get("/api/projeto")).andExpect(status().isOk());
	}
}
