package dev.rampmaster.ecommerce.products.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI productsOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Products API")
                        .description("Documentacion del microservicio de catalogo de productos")
                        .version("v1"))
                .addServersItem(new Server()
                        .url("/products")
                        .description("Context path del microservicio products"));
    }
}

