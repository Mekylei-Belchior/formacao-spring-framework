package br.com.mekylei.forum.config.swagger;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.mekylei.forum.modelo.Usuario;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ParameterType;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {
	
	/**
	 * Configura quais endpoints e pacotes da API o Swagger deve gerar a
	 * documentação
	 * 
	 * @return o parâmetro criado
	 */
	@Bean
	public Docket forumAPI() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.mekylei.forum"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.ignoredParameterTypes(Usuario.class);
				
		/*
		 * Adiciona o header para inserir o token de autorização dos endpoints
		 * bloqueados
		 */
				docket.globalRequestParameters(Arrays.asList(
		                new RequestParameterBuilder()
		                		.name("Authorization")
		                        .description("Authorization details for security JWT token")
		                        .in(ParameterType.HEADER)
		                        .required(false)
		                        .build()));
		    return docket;

	}
}
