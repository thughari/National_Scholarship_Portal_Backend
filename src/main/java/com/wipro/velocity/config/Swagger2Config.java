package com.wipro.velocity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.util.Predicates;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SuppressWarnings("unused")
@Configuration
//@EnableSwagger2
public class Swagger2Config {

    //creating bean
    @Bean
    Docket api()
    {
        //creating constructor of Docket class that accepts parameter DocumentationType
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build();

        /*
     * Swagger2 JSON API Docs should be available in JSON format in following url.
     * Open in Browser/POSTMAN
     *
     * http://localhost:9095/ims/v2/api-docs
     *
     * Swagger2 UI Docs i.e Grapical document of REST API is in following URL
     *
     *  Open in Browser
     *
     * http://localhost:8989/swagger-ui.html
     */
    }

}
