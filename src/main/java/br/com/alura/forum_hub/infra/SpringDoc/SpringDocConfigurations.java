package br.com.alura.forum_hub.infra.SpringDoc;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .info(new Info()
                        .title("Challenge Forum Hub")
                        .description("API Rest do Challenge 3 do programa ONE(Oracle Next Generation) contendo as funcionalidades CRUD de tópicos. ")
                        .contact(new Contact()
                                .name("Tayna Silva")
                                .email("taykazuhiro@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://forumhub/api/licenca")));

    }
}
