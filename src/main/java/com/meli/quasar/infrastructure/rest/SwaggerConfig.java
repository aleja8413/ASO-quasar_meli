package com.meli.quasar.infrastructure.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.meli.quasar.infrastructure.rest.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "MELI - Challenge Fuego de Quasar",
                "Herramienta que retorna la fuente y contenido del mensaje de auxilio",
                "1.0",
                "Uso Privado",
                new Contact("Alejandra Sepúlveda", "","aleja0513@gmail.com"),
                "Non-Commercial use",
                "",
                Collections.emptyList()
        );
    }
}
