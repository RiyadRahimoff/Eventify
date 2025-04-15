package az.it.hamburg.eventify.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition

public class DocumentationConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("Event sale system")
                .version("0.0.1")
                .contact(new Contact()
                        .email("riyad_rahimov.dev@mail.ru"))
                        .description("**Eventify** – A Spring Boot event ticketing API with user registration," +
                                " event management, ticket purchasing, Swagger docs, and Liquibase migrations."));

    }

}
