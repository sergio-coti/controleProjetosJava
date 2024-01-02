package br.com.cotiinformatica.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI().components(new Components())
				.info(new Info()
						.title("API para controle de projetos")
						.description("Curso de férias 2024 Java - COTI Informática")
						.version("v1")
						);
	}
}
