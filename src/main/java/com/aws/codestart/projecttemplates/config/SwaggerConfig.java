package com.aws.codestart.projecttemplates.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
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

}