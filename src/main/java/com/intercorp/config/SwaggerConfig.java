package com.intercorp.config;

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

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Clientes API",
                "Registro de clientes,Promedio de edad de clientes,Deviación estandar de edad de clientes,Listar todos los clientes",
                "v1",
                "https://www.familiadrywall.com/",
                new Contact("Axel Cristhofer Gonzales Llerena", "https://www.familiadrywall.com", "ac.gonzalesllena@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.intercor.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}