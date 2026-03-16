package dev.rampmaster.ecommerce.reviews.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI reviewsOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Reviews API")
                        .description("Documentacion del microservicio de valoraciones y comentarios")
                        .version("v1"))
                .addServersItem(new Server()
                        .url("/reviews")
                        .description("Context path del microservicio reviews"));
    }
}

